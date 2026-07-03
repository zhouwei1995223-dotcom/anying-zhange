export type EnhanceOutcome =
  | 'success'
  | 'fail_keep'
  | 'fail_reset'
  | 'fail_destroy'
  | 'fail_protected';

export type EnhanceBlockedReason =
  | 'missing_context'
  | 'equipment_not_found'
  | 'not_enough_gold'
  | 'not_enough_tian_jing_stone'
  | 'not_enough_protect_stone';

export type EnhanceResultType = EnhanceOutcome | EnhanceBlockedReason;

export type EnhanceRandomSource = () => number;

export type EnhanceCost = {
  gold: number;
  tianJingStone: number;
  protectStone: number;
};

export type EnhanceResourceState = {
  gold: number;
  tianJingStone: number;
  protectStone: number;
};

export type EnhanceEquipmentRecord = {
  id?: string | number;
  uid?: string;
  enhanceLevel?: number;
  [key: string]: unknown;
};

export type EnhanceSystemContext = {
  resources: EnhanceResourceState;

  // UI/game code decides where equipment lives: bag, equipped slots, depot, etc.
  // The enhance system only needs a lookup by runtime id/uid.
  getEquipment(equipmentId: string): EnhanceEquipmentRecord | null | undefined;

  // Called only when failure destroys the equipment.
  removeEquipment(equipmentId: string, equipment: EnhanceEquipmentRecord): void;

  // Optional hook for UI refresh, save-dirty flags, stat recalculation, etc.
  onEquipmentUpdated?: (equipmentId: string, equipment: EnhanceEquipmentRecord) => void;
};

export type EnhanceResult = {
  result: EnhanceResultType;
  success: boolean;
  executed: boolean;
  reason?: EnhanceBlockedReason;
  equipmentId: string;
  beforeLevel: number | null;
  afterLevel: number | null;
  destroyed: boolean;
  usedProtectStone: boolean;
  cost: EnhanceCost;
  rate: number;
  successRoll?: number;
  failRoll?: number;
  messageKey: string;
};

type EnhanceFailRule = {
  minLevel: number;
  maxLevelExclusive?: number;
  outcomes: Array<{ result: EnhanceOutcome; weight: number }>;
};

export type EnhanceSimulationOptions = {
  attempts?: number;
  startLevel?: number;
  useProtectStone?: boolean;
  recreateAfterDestroy?: boolean;
  random?: EnhanceRandomSource;
};

export type EnhanceSimulationResult = {
  attempts: number;
  completedAttempts: number;
  startLevel: number;
  finalLevel: number | null;
  destroyed: boolean;
  usedProtectStone: boolean;
  counts: Record<EnhanceOutcome, number>;
  levelDistribution: Record<number, number>;
  totalCost: EnhanceCost;
};

// All numeric tuning lives here. UI code should read costs/rates through the
// exported functions instead of duplicating these values.
export const ENHANCE_CONFIG = {
  ratesBeforeThirty: [
    1,
    1,
    0.95,
    0.9,
    0.85,
    0.8,
    0.7,
    0.6,
    0.5,
    0.4,
    0.35,
    0.3,
    0.25,
    0.22,
    0.2,
    0.18,
    0.16,
    0.14,
    0.12,
    0.1,
    0.09,
    0.08,
    0.07,
    0.06,
    0.05,
    0.045,
    0.04,
    0.035,
    0.03,
    0.03,
  ],

  rateAfterThirty: {
    baseRate: 0.03,
    decay: 0.92,
    minimumRate: 0.01,
  },

  gold: {
    preTenBase: 1000,
    preTenMultiplier: 2,
    postTenBase: 512000,
    postTenMultiplier: 1.35,
    postTenExponentOffset: 9,
  },

  tianJingStone: {
    tiers: [
      { minLevel: 0, maxLevelExclusive: 5, cost: 1 },
      { minLevel: 5, maxLevelExclusive: 10, cost: 2 },
      { minLevel: 10, maxLevelExclusive: 15, cost: 4 },
      { minLevel: 15, maxLevelExclusive: 20, cost: 8 },
      { minLevel: 20, maxLevelExclusive: 25, cost: 15 },
      { minLevel: 25, maxLevelExclusive: 30, cost: 25 },
    ],
    afterThirtyBaseCost: 40,
    afterThirtyStepSize: 10,
    afterThirtyStepCost: 20,
  },

  protectStoneCost: 1,

  failRules: [
    {
      minLevel: 0,
      maxLevelExclusive: 10,
      outcomes: [{ result: 'fail_keep', weight: 1 }],
    },
    {
      minLevel: 10,
      maxLevelExclusive: 20,
      outcomes: [
        { result: 'fail_keep', weight: 0.7 },
        { result: 'fail_reset', weight: 0.3 },
      ],
    },
    {
      minLevel: 20,
      maxLevelExclusive: 30,
      outcomes: [
        { result: 'fail_keep', weight: 0.5 },
        { result: 'fail_reset', weight: 0.4 },
        { result: 'fail_destroy', weight: 0.1 },
      ],
    },
    {
      minLevel: 30,
      outcomes: [
        { result: 'fail_keep', weight: 0.35 },
        { result: 'fail_reset', weight: 0.45 },
        { result: 'fail_destroy', weight: 0.2 },
      ],
    },
  ] satisfies EnhanceFailRule[],
} as const;

function normalizeLevel(currentLevel: number) {
  const value = Math.floor(Number(currentLevel));
  return Number.isFinite(value) ? Math.max(0, value) : 0;
}

function emptyCost(): EnhanceCost {
  return { gold: 0, tianJingStone: 0, protectStone: 0 };
}

function emptyOutcomeCounts(): Record<EnhanceOutcome, number> {
  return {
    success: 0,
    fail_keep: 0,
    fail_reset: 0,
    fail_destroy: 0,
    fail_protected: 0,
  };
}

export class EnhanceSystem {
  private context: EnhanceSystemContext | null = null;
  private random: EnhanceRandomSource;

  constructor(context?: EnhanceSystemContext, random: EnhanceRandomSource = Math.random) {
    this.context = context ?? null;
    this.random = random;
  }

  setContext(context: EnhanceSystemContext | null) {
    this.context = context;
  }

  setRandomSource(random: EnhanceRandomSource) {
    this.random = random;
  }

  getEnhanceRate(currentLevel: number) {
    const level = normalizeLevel(currentLevel);
    if (level < ENHANCE_CONFIG.ratesBeforeThirty.length) {
      return ENHANCE_CONFIG.ratesBeforeThirty[level];
    }

    const { baseRate, decay, minimumRate } = ENHANCE_CONFIG.rateAfterThirty;
    return Math.max(baseRate * Math.pow(decay, level - 30), minimumRate);
  }

  getGoldCost(currentLevel: number) {
    const level = normalizeLevel(currentLevel);
    const { preTenBase, preTenMultiplier, postTenBase, postTenMultiplier, postTenExponentOffset } = ENHANCE_CONFIG.gold;
    if (level < 10) {
      return Math.floor(preTenBase * Math.pow(preTenMultiplier, level));
    }
    return Math.floor(postTenBase * Math.pow(postTenMultiplier, level - postTenExponentOffset));
  }

  getTianJingStoneCost(currentLevel: number) {
    const level = normalizeLevel(currentLevel);
    for (const tier of ENHANCE_CONFIG.tianJingStone.tiers) {
      if (level >= tier.minLevel && level < tier.maxLevelExclusive) return tier.cost;
    }

    const { afterThirtyBaseCost, afterThirtyStepSize, afterThirtyStepCost } = ENHANCE_CONFIG.tianJingStone;
    const extraSteps = Math.max(0, Math.floor((level - 30) / afterThirtyStepSize));
    return afterThirtyBaseCost + extraSteps * afterThirtyStepCost;
  }

  getEnhanceCost(currentLevel: number, useProtectStone: boolean): EnhanceCost {
    return {
      gold: this.getGoldCost(currentLevel),
      tianJingStone: this.getTianJingStoneCost(currentLevel),
      protectStone: useProtectStone ? ENHANCE_CONFIG.protectStoneCost : 0,
    };
  }

  // This function should be called only after an enhance roll has already failed.
  getFailResult(currentLevel: number, useProtectStone: boolean) {
    if (useProtectStone) return 'fail_protected';

    const level = normalizeLevel(currentLevel);
    const rule = ENHANCE_CONFIG.failRules.find((item) => {
      const belowMax = item.maxLevelExclusive === undefined || level < item.maxLevelExclusive;
      return level >= item.minLevel && belowMax;
    });
    if (!rule) return 'fail_keep';

    const totalWeight = rule.outcomes.reduce((sum, item) => sum + Math.max(0, item.weight), 0);
    if (totalWeight <= 0) return 'fail_keep';

    const roll = this.random() * totalWeight;
    let cursor = 0;
    for (const item of rule.outcomes) {
      cursor += Math.max(0, item.weight);
      if (roll < cursor) return item.result;
    }
    return rule.outcomes[rule.outcomes.length - 1]?.result ?? 'fail_keep';
  }

  enhanceEquipment(equipmentId: string, useProtectStone: boolean): EnhanceResult {
    if (!this.context) {
      return this.blockedResult('missing_context', equipmentId, useProtectStone, null, emptyCost());
    }

    const equipment = this.context.getEquipment(equipmentId);
    if (!equipment) {
      return this.blockedResult('equipment_not_found', equipmentId, useProtectStone, null, emptyCost());
    }

    const beforeLevel = this.getEquipmentLevel(equipment);
    const cost = this.getEnhanceCost(beforeLevel, useProtectStone);
    const resources = this.context.resources;

    if (resources.gold < cost.gold) {
      return this.blockedResult('not_enough_gold', equipmentId, useProtectStone, beforeLevel, cost);
    }
    if (resources.tianJingStone < cost.tianJingStone) {
      return this.blockedResult('not_enough_tian_jing_stone', equipmentId, useProtectStone, beforeLevel, cost);
    }
    if (useProtectStone && resources.protectStone < cost.protectStone) {
      return this.blockedResult('not_enough_protect_stone', equipmentId, useProtectStone, beforeLevel, cost);
    }

    // Costs are consumed once the enhance attempt starts, no matter how it ends.
    resources.gold -= cost.gold;
    resources.tianJingStone -= cost.tianJingStone;
    resources.protectStone -= cost.protectStone;

    const rate = this.getEnhanceRate(beforeLevel);
    const successRoll = this.random();
    if (successRoll < rate) {
      const afterLevel = beforeLevel + 1;
      this.setEquipmentLevel(equipment, afterLevel);
      this.context.onEquipmentUpdated?.(equipmentId, equipment);
      return this.executedResult('success', equipmentId, beforeLevel, afterLevel, false, useProtectStone, cost, rate, successRoll);
    }

    const failRoll = this.random();
    const failResult = this.getFailResultWithRoll(beforeLevel, useProtectStone, failRoll);
    if (failResult === 'fail_reset') {
      this.setEquipmentLevel(equipment, 0);
      this.context.onEquipmentUpdated?.(equipmentId, equipment);
      return this.executedResult(failResult, equipmentId, beforeLevel, 0, false, useProtectStone, cost, rate, successRoll, failRoll);
    }

    if (failResult === 'fail_destroy') {
      this.context.removeEquipment(equipmentId, equipment);
      return this.executedResult(failResult, equipmentId, beforeLevel, null, true, useProtectStone, cost, rate, successRoll, failRoll);
    }

    this.context.onEquipmentUpdated?.(equipmentId, equipment);
    return this.executedResult(failResult, equipmentId, beforeLevel, beforeLevel, false, useProtectStone, cost, rate, successRoll, failRoll);
  }

  simulate(options: EnhanceSimulationOptions = {}): EnhanceSimulationResult {
    return simulateEnhanceResults({ ...options, random: options.random ?? this.random });
  }

  private getFailResultWithRoll(currentLevel: number, useProtectStone: boolean, failRoll: number): EnhanceOutcome {
    if (useProtectStone) return 'fail_protected';

    const previousRandom = this.random;
    this.random = () => failRoll;
    try {
      return this.getFailResult(currentLevel, false);
    } finally {
      this.random = previousRandom;
    }
  }

  private getEquipmentLevel(equipment: EnhanceEquipmentRecord) {
    return normalizeLevel(Number(equipment.enhanceLevel ?? 0));
  }

  private setEquipmentLevel(equipment: EnhanceEquipmentRecord, level: number) {
    equipment.enhanceLevel = normalizeLevel(level);
  }

  private blockedResult(
    reason: EnhanceBlockedReason,
    equipmentId: string,
    useProtectStone: boolean,
    beforeLevel: number | null,
    cost: EnhanceCost,
  ): EnhanceResult {
    return {
      result: reason,
      success: false,
      executed: false,
      reason,
      equipmentId,
      beforeLevel,
      afterLevel: beforeLevel,
      destroyed: false,
      usedProtectStone: useProtectStone,
      cost,
      rate: beforeLevel === null ? 0 : this.getEnhanceRate(beforeLevel),
      messageKey: reason,
    };
  }

  private executedResult(
    result: EnhanceOutcome,
    equipmentId: string,
    beforeLevel: number,
    afterLevel: number | null,
    destroyed: boolean,
    useProtectStone: boolean,
    cost: EnhanceCost,
    rate: number,
    successRoll: number,
    failRoll?: number,
  ): EnhanceResult {
    return {
      result,
      success: result === 'success',
      executed: true,
      equipmentId,
      beforeLevel,
      afterLevel,
      destroyed,
      usedProtectStone: useProtectStone,
      cost,
      rate,
      successRoll,
      failRoll,
      messageKey: result,
    };
  }
}

export const defaultEnhanceSystem = new EnhanceSystem();

export function configureEnhanceSystem(context: EnhanceSystemContext | null) {
  defaultEnhanceSystem.setContext(context);
}

export function getEnhanceRate(currentLevel: number): number {
  return defaultEnhanceSystem.getEnhanceRate(currentLevel);
}

export function getGoldCost(currentLevel: number): number {
  return defaultEnhanceSystem.getGoldCost(currentLevel);
}

export function getTianJingStoneCost(currentLevel: number): number {
  return defaultEnhanceSystem.getTianJingStoneCost(currentLevel);
}

export function getFailResult(currentLevel: number, useProtectStone: boolean): string {
  return defaultEnhanceSystem.getFailResult(currentLevel, useProtectStone);
}

export function enhanceEquipment(equipmentId: string, useProtectStone: boolean): EnhanceResult {
  return defaultEnhanceSystem.enhanceEquipment(equipmentId, useProtectStone);
}

export function simulateEnhanceResults(options: EnhanceSimulationOptions = {}): EnhanceSimulationResult {
  const attempts = Math.max(0, Math.floor(options.attempts ?? 1000));
  const startLevel = normalizeLevel(options.startLevel ?? 0);
  const useProtectStone = !!options.useProtectStone;
  const recreateAfterDestroy = options.recreateAfterDestroy ?? true;
  const random = options.random ?? Math.random;
  const counts = emptyOutcomeCounts();
  const levelDistribution: Record<number, number> = {};
  const totalCost = emptyCost();
  const simSystem = new EnhanceSystem(undefined, random);

  let currentLevel: number | null = startLevel;
  let destroyed = false;
  let completedAttempts = 0;

  for (let i = 0; i < attempts; i++) {
    if (currentLevel === null) {
      if (!recreateAfterDestroy) break;
      currentLevel = 0;
      destroyed = false;
    }

    const cost = simSystem.getEnhanceCost(currentLevel, useProtectStone);
    totalCost.gold += cost.gold;
    totalCost.tianJingStone += cost.tianJingStone;
    totalCost.protectStone += cost.protectStone;

    const rate = simSystem.getEnhanceRate(currentLevel);
    const success = random() < rate;
    if (success) {
      counts.success++;
      currentLevel++;
    } else {
      const outcome = simSystem.getFailResult(currentLevel, useProtectStone) as EnhanceOutcome;
      counts[outcome]++;
      if (outcome === 'fail_reset') currentLevel = 0;
      else if (outcome === 'fail_destroy') {
        currentLevel = null;
        destroyed = true;
      }
    }

    if (currentLevel !== null) {
      levelDistribution[currentLevel] = (levelDistribution[currentLevel] ?? 0) + 1;
    }
    completedAttempts++;
  }

  return {
    attempts,
    completedAttempts,
    startLevel,
    finalLevel: currentLevel,
    destroyed,
    usedProtectStone: useProtectStone,
    counts,
    levelDistribution,
    totalCost,
  };
}

export function logEnhanceSimulation(result: EnhanceSimulationResult) {
  console.log(`[EnhanceSim] attempts=${result.completedAttempts}/${result.attempts}, start=+${result.startLevel}, final=${result.finalLevel === null ? 'destroyed' : `+${result.finalLevel}`}`);
  console.log(`[EnhanceSim] counts=${JSON.stringify(result.counts)}`);
  console.log(`[EnhanceSim] totalCost=${JSON.stringify(result.totalCost)}`);
  console.log(`[EnhanceSim] levelDistribution=${JSON.stringify(result.levelDistribution)}`);
}

export function runEnhanceSimulationTest(attempts = 1000, options: Omit<EnhanceSimulationOptions, 'attempts'> = {}) {
  const result = simulateEnhanceResults({ ...options, attempts });
  logEnhanceSimulation(result);
  return result;
}
