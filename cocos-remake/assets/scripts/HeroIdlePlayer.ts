import { _decorator, Camera, Color, Component, Graphics, JsonAsset, Label, macro, Node, ResolutionPolicy, resources, Sprite, SpriteFrame, sys, UITransform, Vec3, view } from 'cc';
import { EnhanceResult, EnhanceSystem } from './EnhanceSystem';
import { GAME_EQUIPMENT_SLOT_LABELS, GAME_HERO_ROLE_LABELS, GAME_PROFESSION_NAMES, GAME_QUALITY_NAMES, GAME_TEXT, formatGameText } from './GameText';

const { ccclass, property } = _decorator;
const DESIGN_WIDTH = 720;
const DESIGN_HEIGHT = 1280;
const CAMERA_ORTHO_HEIGHT = 350;
const DEFAULT_MAP_ID = 3;
const DEFAULT_HERO_ROLE_ID = '00';
const DEFAULT_HERO_APPEARANCE_ID = 0;
const DEFAULT_HERO_RACE = 0;
const LOCAL_SAVE_KEY_PREFIX = 'anying-cocos-remake-save-v1';
const AUTO_SAVE_INTERVAL_SECONDS = 2;
const HERO_OLD_FRAME_SIZE = 150;
const HERO_FOLDERED_FRAME_SIZE = 320;
const HERO_MOVE_SPEED = 100;
const HERO_BASE_ATTACK_TIME = 1000;
const HERO_MELEE_ATTACK_RANGE = 36;
const HERO_RANGER_ATTACK_RANGE = 180;
const HERO_IDLE_FRAME_INTERVAL = 0.18;
const HERO_WALK_FRAME_INTERVAL = 0.14;
const HERO_ATTACK_FRAME_INTERVAL = 0.1;
const HERO_MIN_WALK_FRAME_INTERVAL = 0.06;
const HERO_MAX_WALK_FRAME_INTERVAL = 0.24;
const HERO_MIN_ATTACK_FRAME_INTERVAL = 0.035;
const HERO_MAX_ATTACK_FRAME_INTERVAL = 0.18;
const MONSTER_ATTACK_INTERVAL = 0.8;
const MONSTER_ATTACK_FRAME_INTERVAL = 0.1;
const MONSTER_FRAME_INTERVAL = 0.14;
const MONSTER_MOVE_SPEED = 50;
const MONSTER_WANDER_STEP = 60;
const MONSTER_ATTACK_RANGE = 58;
const MONSTER_ATTACK_HIT_RANGE = 72;
const MONSTER_CHASE_RANGE = 150;
const ACTOR_COLLISION_RADIUS = 12;
const ACTOR_SEPARATION = 24;
const MONSTER_EDGE_CLEARANCE = 28;
const UNSTUCK_STEP = 8;
const STUCK_SECONDS = 0.55;
const BYPASS_DISTANCE = 90;
const RETREAT_DISTANCE = 70;
const COORD_STUCK_SECONDS = 0.5;
const COORD_GRID = 4;
const TARGET_REACH_CHECK_RANGE = 900;
const TARGET_STALL_SECONDS = 2.2;
const TARGET_BLOCK_SECONDS = 5;
const TARGET_PROGRESS_EPS = 18;
const TARGET_AREA_EPS = 80;
const PATH_SEARCH_LIMIT = 6000;
const PATH_TARGET_REPATH_DISTANCE = 48;
const PATH_POINT_REACH = 10;
const LEVEL_UP_FRAME_COUNT = 10;
const BLOOD_STAIN_LIFETIME = 2;
const BLOOD_STAIN_FOOT_OFFSET_Y = -20;
const DAMAGE_TEXT_LIFETIME = 0.75;
const DAMAGE_TEXT_RISE = 46;
const DAMAGE_TEXT_OFFSET_Y = 74;
const DAMAGE_TEXT_GAP = -2;
const TEMP_CRIT_RATE = 0.15;
const TEMP_CRIT_MULTIPLIER = 2;
const HERO_HP_BAR_WIDTH = 82;
const HERO_HP_BAR_HEIGHT = 8;
const MONSTER_HP_BAR_WIDTH = 46;
const MONSTER_HP_BAR_HEIGHT = 5;
const HERO_ORIGIN_STRENGTH = [2, 2, 6];
const HERO_ORIGIN_DEXTERITY = [6, 2, 2];
const HERO_ORIGIN_WISDOM = [2, 6, 2];
const HERO_ORIGIN_LIFE = [450, 400, 500];
const HERO_ORIGIN_MANA = [150, 200, 120];
const HERO_STRENGTH_GAIN = [2, 1, 3];
const HERO_DEXTERITY_GAIN = [3, 2, 2];
const HERO_WISDOM_GAIN = [1, 3, 1];
const EXP_FACTORS = [1, 1, 1, 1, 1, 1.5, 2, 2.5, 3, 3.5, 5, 10, 13, 16, 20];
const INVENTORY_BAG_SIZE = 192;
const INVENTORY_OLD_WIDTH = 320;
const INVENTORY_OLD_HEIGHT = 588;
const INVENTORY_UI_SCALE = 1.15;
const LEGACY_POPUP_OLD_WIDTH = 288;
const LEGACY_POPUP_OLD_HEIGHT = 516;
const STATS_OLD_WIDTH = 204;
const STATS_OLD_HEIGHT = 342;
const STATS_UI_SCALE = INVENTORY_UI_SCALE;
const STATS_POINT_BUTTON_SIZE = 8;
const INVENTORY_SLOT_SIZE = 28;
const INVENTORY_ICON_SIZE = 24;
const INVENTORY_BAG_SLOT_SIZE = 36;
const INVENTORY_BAG_ICON_SIZE = 30;
const INVENTORY_COLUMNS = 8;
const INVENTORY_ROWS = 8;
const INVENTORY_PAGE_SIZE = INVENTORY_COLUMNS * INVENTORY_ROWS;
const INVENTORY_START_X = Math.round((INVENTORY_OLD_WIDTH - ((INVENTORY_COLUMNS - 1) * INVENTORY_BAG_SLOT_SIZE + INVENTORY_BAG_ICON_SIZE)) / 2);
const INVENTORY_START_Y = 214;
const INVENTORY_SECTION_DIVIDER_OLD_HEIGHT = 30;
const EQUIPMENT_STAGE_OLD_X = 8;
const EQUIPMENT_STAGE_OLD_Y = 38;
const EQUIPMENT_STAGE_OLD_WIDTH = INVENTORY_OLD_WIDTH - EQUIPMENT_STAGE_OLD_X * 2;
const EQUIPMENT_STAGE_OLD_HEIGHT = 146;
const EQUIPMENT_PREVIEW_OLD_X = EQUIPMENT_STAGE_OLD_X + EQUIPMENT_STAGE_OLD_WIDTH / 2;
const EQUIPMENT_PREVIEW_OLD_Y = EQUIPMENT_STAGE_OLD_Y + EQUIPMENT_STAGE_OLD_HEIGHT / 2;
const EQUIPMENT_PREVIEW_SCALE = 1.6;
const EQUIPMENT_DETAIL_OLD_WIDTH = 184;
const EQUIPMENT_DETAIL_OLD_HEIGHT = 190;
const EQUIPMENT_DETAIL_BASE_Y = 4;
const EQUIPMENT_DETAIL_ROW_START_Y = 106;
const EQUIPMENT_DETAIL_ROW_GAP = 14;
const EQUIPMENT_DETAIL_BASE_ROW_COUNT = 5;
const EQUIPMENT_DETAIL_TEXT_BOTTOM_PADDING = 20;
const EQUIPMENT_DETAIL_BUTTON_BOTTOM_GAP = 25;
const ENHANCE_OLD_WIDTH = LEGACY_POPUP_OLD_WIDTH;
const ENHANCE_OLD_HEIGHT = LEGACY_POPUP_OLD_HEIGHT;
const ENHANCE_UI_SCALE = INVENTORY_UI_SCALE;
const ENHANCE_BAG_COLUMNS = 10;
const ENHANCE_BAG_ROWS = 10;
const ENHANCE_PAGE_SIZE = ENHANCE_BAG_COLUMNS * ENHANCE_BAG_ROWS;
const ENHANCE_TIAN_JING_ITEM_ID = 900001;
const ENHANCE_PROTECT_ITEM_ID = 900002;
const ENHANCE_ITEM_SLOT_OLD_X = 132;
const ENHANCE_ITEM_SLOT_OLD_Y = 54;
const ENHANCE_STONE_SLOT_OLD_X = 88;
const ENHANCE_PROTECT_SLOT_OLD_X = 176;
const ENHANCE_INFO_OLD_X = 212;
const ENHANCE_INFO_OLD_Y = 54;
const ENHANCE_INFO_LABEL_OLD_X = 24;
const ENHANCE_INFO_VALUE_OLD_X = 86;
const ENHANCE_INFO_RIGHT_OLD_X = 174;
const ENHANCE_EXECUTE_BUTTON_OLD_X = 224;
const ENHANCE_EXECUTE_BUTTON_OLD_Y = 148;
const ENHANCE_BAG_START_X = 6;
const ENHANCE_BAG_START_Y = 211;
const ENHANCE_SECTION_DIVIDER_OLD_Y = ENHANCE_BAG_START_Y - 16;
const ENHANCE_TIAN_JING_DEFAULT = 200;
const ENHANCE_PROTECT_STONE_DEFAULT = 20;
const REVIVE_OLD_WIDTH = 180;
const REVIVE_OLD_HEIGHT = 112;
const REVIVE_UI_SCALE = INVENTORY_UI_SCALE;
const REVIVE_PROMPT_HIDE_SECONDS = 3;
const OLD_UI_POPUP_TITLE_MARGIN = 10;
const OLD_UI_CLOSE_BUTTON_SIZE = 16;
const OLD_UI_BUTTON_OLD_WIDTH = 48;
const OLD_UI_BUTTON_OLD_HEIGHT = 20;
const OLD_UI_BUTTON_WIDTH = Math.round(OLD_UI_BUTTON_OLD_WIDTH * INVENTORY_UI_SCALE);
const OLD_UI_BUTTON_HEIGHT = Math.round(OLD_UI_BUTTON_OLD_HEIGHT * INVENTORY_UI_SCALE);
const OLD_UI_BUTTON_FONT_SIZE = 11;
const OLD_UI_TITLE_TEXT_COLOR = new Color(31, 184, 255, 255);
const OLD_UI_BUTTON_TEXT_COLOR = new Color(235, 220, 150, 255);
const OLD_UI_BODY_TEXT_COLOR = Color.WHITE;
const MAIN_MENU_BUTTON_COUNT = 7;
const MAIN_MENU_BUTTON_GAP = 4;
const MAIN_MENU_BUTTON_HORIZONTAL_PADDING = 0;
const MAIN_MENU_BUTTON_BOTTOM_MARGIN = 9;
const MAIN_MENU_BUTTON_MIN_SIZE = 40;
const MAIN_MENU_BUTTON_FONT_SIZE = 10;
const SKILL_OLD_WIDTH = 220;
const SKILL_OLD_HEIGHT = 426;
const SKILL_UI_SCALE = INVENTORY_UI_SCALE;
const SKILL_SLOT_SIZE = 24;
const SKILL_ROW_HEIGHT = 28;
const SKILL_LIST_START_Y = 42;
const SKILL_ROW_COUNT = 12;
const SKILL_LIST_MARGIN_X = 12;
const SKILL_ROW_OLD_WIDTH = SKILL_OLD_WIDTH - SKILL_LIST_MARGIN_X * 2;
const SKILL_ICON_OLD_X = 6;
const SKILL_TEXT_OLD_X = 36;
const SKILL_TEXT_OLD_WIDTH = SKILL_ROW_OLD_WIDTH - SKILL_TEXT_OLD_X - 6;
const SKILL_DETAIL_OLD_Y = SKILL_LIST_START_Y + SKILL_ROW_COUNT * SKILL_ROW_HEIGHT + 12;
const SKILL_DEFAULT_EXP_GAIN = 1;
const SKILL_EFFECT_FRAME_INTERVAL = 0.08;
const SKILL_PROJECTILE_SPEED = 430;
const SKILL_PROJECTILE_MIN_DURATION = 0.18;
const SKILL_PROJECTILE_MAX_DURATION = 0.55;
const SKILL_RANGE_UNIT = 30;
const RANGER_ARROW_FLYER_TYPE = 4;
const RANGER_ARROW_PROJECTILE_PATH = 'skill_effects/ranger_arrow/ranger_arrow_';
const RANGER_ARROW_PROJECTILE_FRAME_COUNT = 1;
const RANGER_ARROW_START_BODY_Y = 16;
const RANGER_ARROW_START_FORWARD_OFFSET = 14;
const DROP_CHEST_RESOURCE = 'ui/drop/chest';
const DROP_CHEST_QUALITY_RESOURCES = [
  'ui/drop/chest_quality_1',
  'ui/drop/chest_quality_1',
  'ui/drop/chest_quality_2',
  'ui/drop/chest_quality_3',
  'ui/drop/chest_quality_4',
  'ui/drop/chest_quality_5',
] as const;
const DROP_CHEST_WIDTH = 32;
const DROP_CHEST_HEIGHT = 34;
const DROP_PICKUP_RADIUS = 28;
const DROP_NAME_OFFSET_Y = 32;
const DROP_LIFETIME_SECONDS = 60;
const COMPANION_OLD_WIDTH = 288;
const COMPANION_OLD_HEIGHT = 392;
const COMPANION_UI_SCALE = INVENTORY_UI_SCALE;
const COMPANION_ACTIVE_SIZE = 6;
const COMPANION_BAG_COLUMNS = 10;
const COMPANION_BAG_ROWS = 5;
const COMPANION_BAG_SIZE = COMPANION_BAG_COLUMNS * COMPANION_BAG_ROWS;
const COMPANION_GRID_START_X = 6;
const COMPANION_GRID_START_Y = 202;
const COMPANION_STAGE_OLD_X = 30;
const COMPANION_STAGE_OLD_Y = 38;
const COMPANION_STAGE_OLD_WIDTH = 228;
const COMPANION_STAGE_OLD_HEIGHT = 146;
const COMPANION_SECTION_DIVIDER_OLD_HEIGHT = 30;
const COMPANION_PREVIEW_SCALE = 1.25;
const COMPANION_DETAIL_OLD_WIDTH = 184;
const COMPANION_DETAIL_OLD_HEIGHT = 160;
const COMPANION_DETAIL_BUTTON_BOTTOM_GAP = 24;
const COMPANION_MOVE_SPEED = 116;
const COMPANION_ATTACK_RANGE = MONSTER_ATTACK_RANGE;
const COMPANION_ATTACK_INTERVAL = 1;
const COMPANION_IDLE_FRAME_INTERVAL = MONSTER_FRAME_INTERVAL;
const COMPANION_WALK_FRAME_INTERVAL = 0.22;
const COMPANION_FOLLOW_NEAR_DISTANCE = 18;
const COMPANION_FOLLOW_MAX_DISTANCE = 300;
const COMPANION_FOLLOW_SNAP_DISTANCE = 600;
const COMPANION_ASSIST_TARGET_RANGE = 240;
const COMPANION_IDLE_STEP_INTERVAL = 3;
const COMPANION_IDLE_STEP_DISTANCE = 28;
const COMPANION_IDLE_MAX_HERO_DISTANCE = 300;
const COMPANION_ACTIVE_SLOT_LAYOUT = [
  { x: 18, y: 50 }, { x: 18, y: 80 }, { x: 18, y: 110 },
  { x: 242, y: 50 }, { x: 242, y: 80 }, { x: 242, y: 110 },
] as const;
const COMPANION_FORMATION_OFFSETS = [
  [-46, -42], [46, -42], [-64, -8], [64, -8], [-38, 30], [38, 30],
] as const;
const DEFAULT_COMPANION_TYPES = ['monster_00', 'monster_01', 'monster_02', 'monster_03', 'monster_04', 'monster_05'] as const;
const EQUIPMENT_STAT_ROLL_MIN = 0.9;
const EQUIPMENT_STAT_ROLL_MAX = 1.1;
const EQUIPMENT_NAME_QUALITY_COLORS = [
  Color.WHITE,
  new Color(90, 220, 110, 255),
  new Color(92, 178, 255, 255),
  new Color(196, 120, 255, 255),
  new Color(255, 120, 210, 255),
  new Color(255, 182, 70, 255),
  new Color(255, 226, 90, 255),
];
const INVENTORY_GOLD_DEFAULT = 12000;
const INVENTORY_TREASURE_DEFAULT = 88;
const MONSTER_DROP_RATE_BASE = 10000;
const MONSTER_DROP_QUALITY_RATES = [
  { quality: 0, rate: 667 },
  { quality: 1, rate: 222 },
  { quality: 2, rate: 74 },
  { quality: 3, rate: 25 },
  { quality: 4, rate: 8 },
  { quality: 5, rate: 3 },
] as const;
const EQUIPMENT_DROP_LEVEL_TIERS = [0, 12, 24, 36, 48, 60, 72, 84, 96, 108, 120];
const JEWELRY_DROP_LEVEL_TIERS = [18, 30, 42, 54, 66, 78, 90, 102, 114];
const DROP_CLASS_EQUIPMENT_SLOTS = ['weapon', 'armor', 'helmet', 'boots', 'shield'] as const;
const DROP_DECORATION_SLOTS = ['earbob', 'necklace', 'ring'] as const;
const DROP_EQUIPMENT_SLOTS = [...DROP_CLASS_EQUIPMENT_SLOTS, ...DROP_DECORATION_SLOTS] as const;
const HERO_TURNS = 0;
const PROFESSION_NAMES = GAME_PROFESSION_NAMES;
const HERO_ROLE_IDS = ['00', '01', '10', '11', '20', '21'] as const;
type HeroRoleId = (typeof HERO_ROLE_IDS)[number];
const HERO_ROLE_META: Record<HeroRoleId, { race: number; sex: number; label: string; appearanceCount: number }> = {
  '00': { race: 0, sex: 0, label: GAME_HERO_ROLE_LABELS['00'], appearanceCount: 9 },
  '01': { race: 0, sex: 1, label: GAME_HERO_ROLE_LABELS['01'], appearanceCount: 9 },
  '10': { race: 1, sex: 0, label: GAME_HERO_ROLE_LABELS['10'], appearanceCount: 8 },
  '11': { race: 1, sex: 1, label: GAME_HERO_ROLE_LABELS['11'], appearanceCount: 9 },
  '20': { race: 2, sex: 0, label: GAME_HERO_ROLE_LABELS['20'], appearanceCount: 8 },
  '21': { race: 2, sex: 1, label: GAME_HERO_ROLE_LABELS['21'], appearanceCount: 9 },
};
const QUALITY_COLORS = [
  new Color(210, 210, 210, 255),
  new Color(90, 220, 110, 255),
  new Color(92, 178, 255, 255),
  new Color(196, 120, 255, 255),
  new Color(255, 182, 70, 255),
  new Color(255, 80, 80, 255),
  new Color(255, 226, 90, 255),
];
const QUALITY_NAMES = GAME_QUALITY_NAMES;
const EQUIPMENT_SLOT_LABELS: Record<EquipmentSlotKey, string> = GAME_EQUIPMENT_SLOT_LABELS;
const EQUIPMENT_SLOT_LAYOUT: Record<EquipmentSlotKey, { x: number; y: number }> = {
  leftEarbob: { x: 14, y: 36 },
  leftRing: { x: 14, y: 66 },
  armor: { x: 14, y: 96 },
  boots: { x: 14, y: 126 },
  necklace: { x: 44, y: 36 },
  weapon: { x: 44, y: 66 },
  shield: { x: 44, y: 96 },
  title: { x: 252, y: 36 },
  fashion: { x: 252, y: 66 },
  aura: { x: 252, y: 96 },
  rightEarbob: { x: 282, y: 36 },
  rightRing: { x: 282, y: 66 },
  helmet: { x: 282, y: 96 },
};

type EquipmentSlotKey =
  'weapon' | 'armor' | 'helmet' | 'boots' | 'shield'
  | 'leftEarbob' | 'rightEarbob' | 'necklace' | 'leftRing' | 'rightRing'
  | 'fashion' | 'title' | 'aura';

type EquipmentBaseSlot = 'weapon' | 'armor' | 'helmet' | 'boots' | 'shield' | 'earbob' | 'necklace' | 'ring' | 'fashion' | 'title' | 'aura' | 'material';

type EnhanceMaterialId = 'tianJingStone' | 'protectStone';

type EquipmentCatalogItem = {
  id: number;
  name: string;
  goodsType: number;
  kind: string;
  slot: EquipmentBaseSlot;
  slotName: string;
  icon: number;
  iconPath: string;
  quality: number;
  qualityName: string;
  requiredRace: number;
  profession: string;
  requiredLevel: number;
  requiredTurn: number;
  moneyCost: number;
  treasureCost: number;
  appearanceId?: number;
  materialId?: EnhanceMaterialId;
  maxStack?: number;
  description: string;
  stats: Record<string, number | string>;
};

type EquipmentInstance = {
  uid: string;
  item: EquipmentCatalogItem;
  locked?: boolean;
  statRollPercent?: number;
  enhanceLevel?: number;
  quantity?: number;
};

type InventorySlotView = {
  node: Node;
  bg: Graphics;
  iconSize?: number;
  uiScale?: number;
};

type EquipmentSlotView = InventorySlotView & {
  slot: EquipmentSlotKey;
};

type OldUiButtonState = 'normal' | 'hover' | 'pressed';

type OldUiButtonView = {
  node: Node;
  width: number;
  height: number;
  state: OldUiButtonState;
};

type MainMenuButtonView = {
  node: Node;
  size: number;
  state: OldUiButtonState;
};

type OldUiPopupFrameView = {
  node: Node;
  width: number;
  height: number;
  oldWidth: number;
  oldHeight: number;
};

type EquipmentSelection =
  | { source: 'bag'; instance: EquipmentInstance; bagIndex: number }
  | { source: 'equipped'; instance: EquipmentInstance; equippedSlot: EquipmentSlotKey };

type SavedEquipmentInstance = {
  itemId: number;
  uid: string;
  locked?: boolean;
  statRollPercent?: number;
  enhanceLevel?: number;
  quantity?: number;
  materialId?: EnhanceMaterialId;
};

type SavedSkillInstance = {
  id: number;
  experience: number;
};

type GameSaveData = {
  version: 1;
  savedAt: number;
  hero: {
    roleId: string;
    appearanceId: number;
    level: number;
    exp: number;
    strength: number;
    dexterity: number;
    wisdom: number;
    unassignedPoints: number;
    hp: number;
    mana: number;
  };
  inventory: {
    slots: Array<SavedEquipmentInstance | null>;
    equipped: Partial<Record<EquipmentSlotKey, SavedEquipmentInstance | null>>;
    page: number;
    money: number;
    treasure: number;
    tianJingStone?: number;
    protectStone?: number;
  };
  skills: {
    selectedSkillId: number;
    learned: SavedSkillInstance[];
  };
};

type InventoryCatalog = {
  bagSize?: number;
  qualityNames?: string[];
  items?: EquipmentCatalogItem[];
};

type MonsterDropQualityRule = {
  quality: number;
  count: number;
  rate: number;
};

type MonsterExtraDropRule = {
  goodsId: number;
  rate: number;
  name?: string;
};

type MonsterDropReward = {
  id: number;
  name: string;
  level: number;
  exp?: { min: number; max: number };
  money?: { min: number; max: number };
  medicine?: { count: number; rate: number };
  bigDrop?: { rate: number; times: number };
  equipmentDrops?: MonsterDropQualityRule[];
  weaponDrops?: MonsterDropQualityRule[];
  extraGoods?: MonsterExtraDropRule[];
};

type MonsterRewardDefault = {
  rewardId: number;
  monsterImageId?: number;
  mapId?: number;
};

type MonsterDropRewardsCatalog = {
  rateBase?: number;
  rewards?: MonsterDropReward[];
  defaultsByMonsterImageId?: MonsterRewardDefault[];
  defaultsByMapId?: MonsterRewardDefault[];
};

type SkillType = 'damage' | 'state' | 'scene';

type SkillCatalogItem = {
  id: number;
  name: string;
  type: SkillType;
  race: number;
  group: number;
  level: number;
  icon: number;
  iconPath: string;
  flyerType: number;
  projectilePath: string;
  projectileFrameCount: number;
  animation: number;
  effectPath: string;
  effectFrameCount: number;
  timeLast: number;
  releaseRange: number;
  maxExperience: number;
  requiredLevel: number;
  nextLevelSkillId: number;
  manaCost: number;
  minDamage: number;
  maxDamage: number;
  selfCoolTime: number;
  globalCoolTime: number;
  damageType: number;
  strengthFactor: number;
  wisdomFactor: number;
  dexterityFactor: number;
  selfPhysicalDamageFactor: number;
  selfMagicDamageFactor: number;
  description: string;
};

type SkillCatalog = {
  skills?: SkillCatalogItem[];
};

type SkillInstance = {
  skill: SkillCatalogItem;
  experience: number;
  cooldown: number;
};

type SkillRowView = {
  node: Node;
  bg: Graphics;
  iconRoot: Node;
  name: Label;
  meta: Label;
};

type SkillEffectInstance = {
  node: Node;
  sprite: Sprite;
  transform: UITransform;
  frames: SpriteFrame[];
  time: number;
  frame: number;
  frameInterval: number;
  elapsed: number;
  duration: number;
  start?: Vec3;
  end?: Vec3;
  onFinish?: () => void;
};

type WorldDropItem = {
  node: Node;
  item: EquipmentCatalogItem;
  createdAt: number;
};

type WorldDropPickupTarget = {
  drop: WorldDropItem;
  position: Vec3;
  distance: number;
};

type CompanionInstance = {
  uid: string;
  id: number;
  name: string;
  type: string;
  level: number;
  maxHp: number;
  attack: number;
  defense: number;
  quality: number;
  description: string;
};

type CompanionSelection =
  | { source: 'bag'; instance: CompanionInstance; bagIndex: number }
  | { source: 'active'; instance: CompanionInstance; activeIndex: number };

type CompanionActor = {
  node: Node;
  visualNode: Node;
  instance: CompanionInstance;
  type: string;
  sprite: Sprite;
  transform: UITransform;
  state: MonsterState;
  dir: number;
  clip: string;
  frame: number;
  time: number;
  activeIndex: number;
  target: MonsterActor | null;
  attackCooldown: number;
  attackActive: boolean;
  idleStepTimer: number;
  idleTarget: Vec3 | null;
};

type CompanionSlotView = InventorySlotView & {
  index: number;
};

@ccclass('MapMonsterConfig')
class MapMonsterConfig {
  @property({ displayName: 'Monster ID' })
  monsterId = 0;

  @property({ displayName: 'Reward ID', tooltip: 'Matches rewards/monster_drop_rewards.json plunderID. Empty means auto match by legacy image or map.' })
  rewardId = 0;

  @property({ displayName: 'Monster Level', tooltip: 'Equipment drops use the nearest level tier. -1 uses the reward level.' })
  monsterLevel = -1;

  @property({ displayName: 'Max HP' })
  maxHp = 50;

  @property({ displayName: 'Attack' })
  attack = 8;

  @property({ displayName: 'Defense' })
  defense = 0;

  @property({ displayName: 'Exp Min' })
  expMin = 20;

  @property({ displayName: 'Exp Max' })
  expMax = 30;
}

function defaultMonsterConfig(id: number) {
  const config = new MapMonsterConfig();
  config.monsterId = id;
  return config;
}

@ccclass('EditableEquipmentConfig')
class EditableEquipmentConfig {
  @property({ displayName: 'Equipment ID' })
  id = 0;

  @property({ displayName: 'Equipment Name' })
  name = '';

  @property({ displayName: 'Equipment Slot', tooltip: 'weapon/armor/helmet/boots/shield/earbob/necklace/ring/fashion/title/aura' })
  slot = 'weapon';

  @property({ displayName: 'Icon Path', tooltip: 'Example: equipment/icons/weapon_r0_1. Empty uses a color placeholder.' })
  iconPath = '';

  @property({ displayName: 'Quality 0-6' })
  quality = 0;

  @property({ displayName: 'Profession', tooltip: '-1 common, 0 ranger, 1 mage, 2 warrior.' })
  requiredRace = -1;

  @property({ displayName: 'Required Level' })
  requiredLevel = 0;

  @property({ displayName: 'Required Turn' })
  requiredTurn = 0;

  @property({ displayName: 'Appearance ID', tooltip: '-1 auto. Armor maps by level; fashion can use a specific appearance ID.' })
  appearanceId = -1;

  @property({ displayName: 'Gold Cost' })
  moneyCost = 0;

  @property({ displayName: 'Treasure Cost' })
  treasureCost = 0;

  @property({ displayName: 'Description' })
  description = '';

  @property({ displayName: 'Min Physical Attack' })
  minPhysicalDamage = 0;

  @property({ displayName: 'Max Physical Attack' })
  maxPhysicalDamage = 0;

  @property({ displayName: 'Min Magic Attack' })
  minMagicDamage = 0;

  @property({ displayName: 'Max Magic Attack' })
  maxMagicDamage = 0;

  @property({ displayName: 'Physical Defense' })
  physicalDefense = 0;

  @property({ displayName: 'Magic Defense' })
  magicDefense = 0;

  @property({ displayName: 'Max HP Bonus' })
  lifeRaised = 0;

  @property({ displayName: 'Max Mana Bonus' })
  manaRaised = 0;

  @property({ displayName: 'Hit Bonus' })
  hittingAbility = 0;

  @property({ displayName: 'Dodge Bonus' })
  evadingAbility = 0;

  @property({ displayName: 'Attack Time Modifier' })
  attackTime = 0;

  @property({ displayName: 'Attack Range Modifier' })
  attackRange = 0;
}

function defaultEquippedSlots(): Record<EquipmentSlotKey, EquipmentInstance | null> {
  return {
    weapon: null,
    armor: null,
    helmet: null,
    boots: null,
    shield: null,
    leftEarbob: null,
    rightEarbob: null,
    necklace: null,
    leftRing: null,
    rightRing: null,
    fashion: null,
    title: null,
    aura: null,
  };
}

const MONSTER_FRAME_COUNTS: Record<string, { idle: number; walk: number; attack: number }> = {
  monster_00: { idle: 10, walk: 10, attack: 10 },
  monster_01: { idle: 10, walk: 10, attack: 10 },
  monster_02: { idle: 10, walk: 10, attack: 10 },
  monster_03: { idle: 10, walk: 10, attack: 10 },
  monster_04: { idle: 10, walk: 10, attack: 10 },
  monster_05: { idle: 10, walk: 10, attack: 10 },
  monster_06: { idle: 10, walk: 10, attack: 10 },
  monster_07: { idle: 10, walk: 10, attack: 10 },
  monster_08: { idle: 10, walk: 10, attack: 10 },
  monster_09: { idle: 10, walk: 10, attack: 10 },
  monster_10: { idle: 10, walk: 10, attack: 10 },
  monster_11: { idle: 10, walk: 10, attack: 10 },
  monster_12: { idle: 10, walk: 10, attack: 10 },
  monster_13: { idle: 10, walk: 10, attack: 10 },
  monster_14: { idle: 10, walk: 10, attack: 10 },
  monster_15: { idle: 10, walk: 10, attack: 10 },
  monster_16: { idle: 10, walk: 10, attack: 10 },
  monster_17: { idle: 10, walk: 10, attack: 10 },
  monster_18: { idle: 10, walk: 10, attack: 10 },
  monster_19: { idle: 10, walk: 10, attack: 10 },
  monster_20: { idle: 10, walk: 10, attack: 10 },
  monster_21: { idle: 10, walk: 10, attack: 10 },
  monster_22: { idle: 10, walk: 10, attack: 10 },
  monster_23: { idle: 10, walk: 10, attack: 10 },
  monster_24: { idle: 10, walk: 10, attack: 10 },
  monster_25: { idle: 10, walk: 10, attack: 10 },
  monster_26: { idle: 10, walk: 10, attack: 10 },
  monster_27: { idle: 10, walk: 10, attack: 10 },
  monster_28: { idle: 10, walk: 10, attack: 10 },
  monster_29: { idle: 10, walk: 10, attack: 10 },
  monster_30: { idle: 10, walk: 10, attack: 10 },
  monster_31: { idle: 4, walk: 6, attack: 8 },
  monster_32: { idle: 4, walk: 6, attack: 8 },
  monster_33: { idle: 10, walk: 10, attack: 10 },
  monster_34: { idle: 4, walk: 6, attack: 8 },
  monster_35: { idle: 4, walk: 6, attack: 8 },
  monster_36: { idle: 4, walk: 6, attack: 8 },
  monster_37: { idle: 4, walk: 6, attack: 8 },
  monster_38: { idle: 4, walk: 6, attack: 8 },
  monster_39: { idle: 4, walk: 6, attack: 8 },
  monster_40: { idle: 4, walk: 6, attack: 8 },
  monster_41: { idle: 4, walk: 6, attack: 8 },
  monster_42: { idle: 4, walk: 6, attack: 8 },
  monster_43: { idle: 10, walk: 10, attack: 10 },
  monster_44: { idle: 10, walk: 10, attack: 10 },
  monster_45: { idle: 10, walk: 10, attack: 10 },
  monster_46: { idle: 10, walk: 10, attack: 10 },
  monster_47: { idle: 10, walk: 10, attack: 10 },
  monster_48: { idle: 10, walk: 10, attack: 10 },
  monster_49: { idle: 10, walk: 10, attack: 10 },
  monster_50: { idle: 10, walk: 10, attack: 10 },
  monster_51: { idle: 4, walk: 6, attack: 8 },
  monster_52: { idle: 4, walk: 6, attack: 8 },
  monster_53: { idle: 4, walk: 6, attack: 8 },
  monster_54: { idle: 4, walk: 6, attack: 8 },
  monster_55: { idle: 4, walk: 6, attack: 8 },
  monster_56: { idle: 10, walk: 10, attack: 10 },
  monster_57: { idle: 5, walk: 4, attack: 4 },
};
const STAND_OFFSETS = [
  [0, 0],
  [-ACTOR_COLLISION_RADIUS, 0],
  [ACTOR_COLLISION_RADIUS, 0],
  [0, -ACTOR_COLLISION_RADIUS],
  [0, ACTOR_COLLISION_RADIUS],
];
const MONSTER_CLEARANCE_OFFSETS = [
  [0, 0],
  [-MONSTER_EDGE_CLEARANCE, 0],
  [MONSTER_EDGE_CLEARANCE, 0],
  [0, -MONSTER_EDGE_CLEARANCE],
  [0, MONSTER_EDGE_CLEARANCE],
];

type MonsterState = 'idle' | 'walk' | 'chase' | 'attack';

type MonsterActor = {
  node: Node;
  visualNode: Node;
  type: string;
  config: MapMonsterConfig;
  sprite: Sprite;
  transform: UITransform;
  state: MonsterState;
  dir: number;
  clip: string;
  frame: number;
  time: number;
  wait: number;
  target: Vec3;
  blockedUntil: number;
  maxHp: number;
  currentHp: number;
  level: number;
  attack: number;
  defense: number;
  expMin: number;
  expMax: number;
  rewardId: number;
  hpRoot: Node;
  hpLabel: Label;
  hpBar: Graphics;
  attackCooldown: number;
  attackActive: boolean;
};

type BlockMap = {
  width: number;
  height: number;
  mapImageWidth: number;
  mapImageHeight: number;
  mapNodeScale: number;
  data: string;
};

type MapPatchObjectData = {
  assetId: number;
  resource?: string;
  x: number;
  y: number;
  scale: number;
  width: number;
  height: number;
  collision?: { x: number; y: number; w: number; h: number };
  occlusion?: boolean;
};

type MapPatchObject = {
  node: Node;
  data: MapPatchObjectData;
};

type BlockCell = {
  x: number;
  y: number;
};

type MoveMemory = {
  node: Node;
  lastX: number;
  lastY: number;
  lastMoveX: number;
  lastMoveY: number;
  coordX: number;
  coordY: number;
  sameCoordTime: number;
  targetX: number;
  targetY: number;
  stuck: number;
  bypass: Vec3 | null;
  bypassTime: number;
  path: Vec3[];
  pathIndex: number;
  pathTargetX: number;
  pathTargetY: number;
};

type FloatingText = {
  node: Node;
  time: number;
  startY: number;
};

type HeroDerivedStats = {
  minPhysicalDamage: number;
  maxPhysicalDamage: number;
  minMagicDamage: number;
  maxMagicDamage: number;
  physicalDefense: number;
  magicDefense: number;
  attackTime: number;
  attackRange: number;
  hittingAbility: number;
  evadingAbility: number;
  maxHp: number;
  maxMana: number;
};

@ccclass('HeroIdlePlayer')
export class HeroIdlePlayer extends Component {
  @property({ displayName: 'Map ID', tooltip: 'Maps to assets/resources/maps/map_ID_preview / block / occlusion.' })
  public mapId = DEFAULT_MAP_ID;

  @property({ type: [MapMonsterConfig], displayName: 'Map Monster Configs' })
  public mapMonsters: MapMonsterConfig[] = [defaultMonsterConfig(0), defaultMonsterConfig(1)];

  @property({ type: [EditableEquipmentConfig], displayName: 'Equipment Configs', tooltip: 'Add or override equipment. Existing IDs override legacy equipment.' })
  public equipmentConfigs: EditableEquipmentConfig[] = [];

  @property({ displayName: 'Starter Equipment IDs', tooltip: 'Comma separated. Empty means a new character starts with an empty bag.' })
  public starterEquipmentIds = '';

  @property({ displayName: 'Hero Role ID', tooltip: '00 male ranger, 01 female ranger, 10 male mage, 11 female mage, 20 male warrior, 21 female warrior' })
  public heroRoleId = DEFAULT_HERO_ROLE_ID;

  @property({ displayName: 'Hero Appearance ID', tooltip: '0 base, 1 level-36 armor look, 2 level-72 armor look, 3 level-108 armor look' })
  public heroAppearanceId = DEFAULT_HERO_APPEARANCE_ID;

  @property({ displayName: 'Save Slot ID', tooltip: 'Different slot IDs create separate local saves.' })
  public saveSlotId = 'default';

  @property({ displayName: 'Reset Save On Start', tooltip: 'Editor test switch. Leave disabled for normal play.' })
  public resetSaveOnStart = false;

  private clips: Record<string, SpriteFrame[]> = {};
  private monsterClips: Record<string, SpriteFrame[]> = {};
  private currentClip = 'idle';
  private sprite: Sprite | null = null;
  private transform: UITransform | null = null;
  private cameraNode: Node | null = null;
  private blockMap: BlockMap | null = null;
  private occlusionNode: Node | null = null;
  private mapPatchObjects: MapPatchObject[] = [];
  private monsterFrames: Record<string, SpriteFrame> = {};
  private levelUpFrames: SpriteFrame[] = [];
  private bloodStainFrame: SpriteFrame | null = null;
  private damageTextFrames: Record<string, SpriteFrame> = {};
  private floatingTexts: FloatingText[] = [];
  private skillEffects: SkillEffectInstance[] = [];
  private levelUpNode: Node | null = null;
  private levelUpSprite: Sprite | null = null;
  private levelUpTransform: UITransform | null = null;
  private levelUpTime = -1;
  private expLabel: Label | null = null;
  private heroHpLabel: Label | null = null;
  private heroHpBar: Graphics | null = null;
  private autoBattleButton: Node | null = null;
  private autoBattleEnabled = false;
  private statsButton: Node | null = null;
  private statsPanel: Node | null = null;
  private statsPopupFrame: OldUiPopupFrameView | null = null;
  private statsLabels: Record<string, Label> = {};
  private skillButton: Node | null = null;
  private skillPanel: Node | null = null;
  private skillPopupFrame: OldUiPopupFrameView | null = null;
  private skillRows: SkillRowView[] = [];
  private skillLabels: Record<string, Label> = {};
  private skillCatalog: SkillCatalogItem[] = [];
  private skillById: Record<number, SkillCatalogItem> = {};
  private learnedSkills: SkillInstance[] = [];
  private selectedSkillId = 0;
  private skillIconFrames: Record<string, SpriteFrame> = {};
  private skillFrames: Record<string, SpriteFrame[]> = {};
  private requestedSkillFrames: Record<string, boolean> = {};
  private dropChestFrame: SpriteFrame | null = null;
  private dropChestQualityFrames: Partial<Record<number, SpriteFrame>> = {};
  private worldDrops: WorldDropItem[] = [];
  private loadedMapId = -1;
  private loadedHeroResource = '';
  private heroClipLoadToken = 0;
  private loadedMonsterSignature = '';
  private monsters: MonsterActor[] = [];
  private moveMemories: MoveMemory[] = [];
  private target: MonsterActor | null = null;
  private attackTarget: MonsterActor | null = null;
  private attackSkill: SkillInstance | null = null;
  private currentDir = 4;
  private index = 0;
  private time = 0;
  private spawnTime = 0;
  private attackTime = -1;
  private runtimeTime = 0;
  private initialHeroPosition = new Vec3();
  private heroDead = false;
  private revivePromptCooldown = 0;
  private saveDirty = false;
  private saveTimer = 0;
  private pendingSavedInventory: GameSaveData['inventory'] | null = null;
  private pendingSavedSkills: GameSaveData['skills'] | null = null;
  private pendingSavedHp: number | null = null;
  private pendingSavedMana: number | null = null;
  private stalledTarget: MonsterActor | null = null;
  private stalledBestDist = Infinity;
  private stalledTime = 0;
  private stalledAnchorX = 0;
  private stalledAnchorY = 0;
  private stalledAreaTime = 0;
  private heroLevel = 1;
  private heroExp = 0;
  private heroStrength = heroBaseStrength(1, DEFAULT_HERO_RACE);
  private heroDexterity = heroBaseDexterity(1, DEFAULT_HERO_RACE);
  private heroWisdom = heroBaseWisdom(1, DEFAULT_HERO_RACE);
  private heroUnassignedPoints = 0;
  private pendingStrengthPoints = 0;
  private pendingDexterityPoints = 0;
  private pendingWisdomPoints = 0;
  private heroMaxHp = 0;
  private heroCurrentHp = 0;
  private heroMaxMana = 0;
  private heroCurrentMana = 0;
  private equipmentCatalog: EquipmentCatalogItem[] = [];
  private equipmentById: Record<number, EquipmentCatalogItem> = {};
  private dropRewardsById: Record<number, MonsterDropReward> = {};
  private defaultDropRewardByMonsterImageId: Record<number, number> = {};
  private defaultDropRewardByMapId: Record<number, number> = {};
  private inventorySlots: Array<EquipmentInstance | null> = Array.from({ length: INVENTORY_BAG_SIZE }, () => null);
  private equippedSlots: Record<EquipmentSlotKey, EquipmentInstance | null> = defaultEquippedSlots();
  private inventoryInitialized = false;
  private inventoryButton: Node | null = null;
  private inventoryPanel: Node | null = null;
  private inventoryBagViews: InventorySlotView[] = [];
  private equipmentViews: Record<string, EquipmentSlotView> = {};
  private inventoryLabels: Record<string, Label> = {};
  private selectedInventoryItem: EquipmentInstance | null = null;
  private selectedEquipment: EquipmentSelection | null = null;
  private inventoryPage = 0;
  private oldUiButtons: OldUiButtonView[] = [];
  private mainMenuButtons: MainMenuButtonView[] = [];
  private mainMenuButtonFrames: Partial<Record<OldUiButtonState, SpriteFrame>> = {};
  private iconFrames: Record<string, SpriteFrame> = {};
  private requestedIconFrames: Record<string, boolean> = {};
  private equipmentBackFrame: SpriteFrame | null = null;
  private equipmentBackSprite: Sprite | null = null;
  private equipmentBackTransform: UITransform | null = null;
  private equipmentPreviewNode: Node | null = null;
  private equipmentPreviewSprite: Sprite | null = null;
  private equipmentPreviewTransform: UITransform | null = null;
  private equipmentPreviewAura: Graphics | null = null;
  private equipmentPreviewTitleLabel: Label | null = null;
  private equipmentPreviewFashionLabel: Label | null = null;
  private equipmentPreviewFrame = 0;
  private equipmentPreviewTime = 0;
  private oldUiButtonFrames: Record<string, SpriteFrame> = {};
  private oldUiPopupFrames: Record<string, SpriteFrame> = {};
  private statPointFrames: Record<string, SpriteFrame> = {};
  private inventoryPopupFrame: OldUiPopupFrameView | null = null;
  private equipmentDetailPanel: Node | null = null;
  private equipmentDetailPopupFrame: OldUiPopupFrameView | null = null;
  private equipmentDetailTitleLabel: Label | null = null;
  private equipmentDetailIconRoot: Node | null = null;
  private equipmentDetailLabels: Record<string, Label> = {};
  private equipmentDetailSellButton: Node | null = null;
  private equipmentDetailLockButton: Node | null = null;
  private equipmentDetailEquipButton: Node | null = null;
  private equipmentDetailUnequipButton: Node | null = null;
  private coinFrame: SpriteFrame | null = null;
  private depotMoney = INVENTORY_GOLD_DEFAULT;
  private depotTreasure = INVENTORY_TREASURE_DEFAULT;
  private enhanceSystem = new EnhanceSystem();
  private enhanceTianJingStone = ENHANCE_TIAN_JING_DEFAULT;
  private enhanceProtectStone = ENHANCE_PROTECT_STONE_DEFAULT;
  private enhanceButton: Node | null = null;
  private enhancePanel: Node | null = null;
  private enhancePopupFrame: OldUiPopupFrameView | null = null;
  private enhanceExecuteButton: Node | null = null;
  private enhanceItemSlotView: InventorySlotView | null = null;
  private enhanceStoneSlotView: InventorySlotView | null = null;
  private enhanceProtectSlotView: InventorySlotView | null = null;
  private enhanceBagViews: InventorySlotView[] = [];
  private enhanceLabels: Record<string, Label> = {};
  private enhanceProtectBox: Graphics | null = null;
  private selectedEnhanceItem: EquipmentInstance | null = null;
  private selectedEnhanceStone: EquipmentInstance | null = null;
  private selectedEnhanceProtectStone: EquipmentInstance | null = null;
  private enhancePage = 0;
  private enhanceUseProtectStone = false;
  private companionInitialized = false;
  private companionButton: Node | null = null;
  private settingsButton: Node | null = null;
  private companionPanel: Node | null = null;
  private companionPopupFrame: OldUiPopupFrameView | null = null;
  private companionBagSlots: Array<CompanionInstance | null> = Array.from({ length: COMPANION_BAG_SIZE }, () => null);
  private activeCompanionSlots: Array<CompanionInstance | null> = Array.from({ length: COMPANION_ACTIVE_SIZE }, () => null);
  private companionBagViews: CompanionSlotView[] = [];
  private companionActiveViews: CompanionSlotView[] = [];
  private companionLabels: Record<string, Label> = {};
  private selectedCompanion: CompanionSelection | null = null;
  private companionDetailPanel: Node | null = null;
  private companionDetailPopupFrame: OldUiPopupFrameView | null = null;
  private companionDetailIconRoot: Node | null = null;
  private companionDetailLabels: Record<string, Label> = {};
  private companionDetailActionButton: Node | null = null;
  private companionPreviewNode: Node | null = null;
  private companionPreviewSprite: Sprite | null = null;
  private companionPreviewTransform: UITransform | null = null;
  private companionPreviewFrame = 0;
  private companionPreviewTime = 0;
  private companionActors: CompanionActor[] = [];
  private revivePanel: Node | null = null;
  private revivePopupFrame: OldUiPopupFrameView | null = null;

  start() {
    this.forcePortrait();
    this.sprite = this.getComponent(Sprite);
    this.transform = this.getComponent(UITransform);
    this.cameraNode = this.node.parent?.getChildByName('Camera') ?? null;
    this.initialHeroPosition.set(this.node.position.x, this.node.position.y, this.node.position.z);
    this.prepareInventoryRuntimeState();
    this.recalculateHeroStats(true);
    this.syncCamera();
    this.createLevelUpEffect();
    this.createExpLabel();
    this.createHeroHpUi();
    this.createStatsUi();
    this.createInventoryUi();
    this.createSkillUi();
    this.initializeCompanions();
    this.createCompanionUi();
    this.createEnhanceUi();
    this.createSettingsButton();
    this.createReviveUi();
    this.loadInventoryAssets();
    this.loadEquipmentCatalog();
    this.loadMonsterDropRewards();
    this.loadSkillFrameSet(RANGER_ARROW_PROJECTILE_PATH, RANGER_ARROW_PROJECTILE_FRAME_COUNT);
    this.loadSkillCatalog();
    this.keepTrimmedFrame();
    this.loadLevelUpFrames();
    this.loadBloodStainFrame();
    this.loadDamageTextFrames();
    this.loadHeroClips();
    this.syncMonsterConfigs();
    this.reloadMapAssets();
  }

  protected onDestroy() {
    if (this.saveDirty) this.saveGameProgress();
  }

  private normalizeHeroRoleId(value: unknown): HeroRoleId {
    const id = `${value ?? ''}`.trim();
    return (HERO_ROLE_IDS as readonly string[]).indexOf(id) >= 0 ? id as HeroRoleId : DEFAULT_HERO_ROLE_ID;
  }

  private normalizedHeroRoleId(): HeroRoleId {
    return this.normalizeHeroRoleId(this.heroRoleId);
  }

  private heroAppearanceCount(roleId = this.normalizedHeroRoleId()) {
    return Math.max(1, HERO_ROLE_META[roleId]?.appearanceCount ?? 1);
  }

  private normalizedHeroAppearanceId(roleId = this.normalizedHeroRoleId()) {
    const max = this.heroAppearanceCount(roleId) - 1;
    const appearanceId = Math.floor(Number(this.heroAppearanceId));
    return Number.isFinite(appearanceId) ? this.clamp(appearanceId, 0, max) : DEFAULT_HERO_APPEARANCE_ID;
  }

  private currentHeroRace() {
    return HERO_ROLE_META[this.normalizedHeroRoleId()]?.race ?? DEFAULT_HERO_RACE;
  }

  private heroResourcePath() {
    const roleId = this.normalizedHeroRoleId();
    return `heroes/hero_${roleId}/appearance_${this.normalizedHeroAppearanceId(roleId)}`;
  }

  private heroFrameCanvasSize() {
    return this.normalizedHeroRoleId() === '00' && this.normalizedHeroAppearanceId('00') === 8
      ? HERO_FOLDERED_FRAME_SIZE
      : HERO_OLD_FRAME_SIZE;
  }

  private loadHeroClips() {
    const heroResource = this.heroResourcePath();
    this.loadedHeroResource = heroResource;
    const token = ++this.heroClipLoadToken;
    this.currentDir = this.normalizedDirection(this.currentDir);
    this.currentClip = this.heroDead ? 'death' : `idle${this.currentDir}`;
    this.index = 0;
    this.time = 0;
    this.loadClip('idle', `${heroResource}/idle/d4/idle_`, 4, token);
    this.loadClip('idleFront', `${heroResource}/idle/d4/idle_`, 4, token);
    for (let dir = 0; dir < 8; dir++) {
      this.loadClip(`idle${dir}`, `${heroResource}/idle/d${dir}/idle_`, 4, token);
      this.loadClip(`walk${dir}`, `${heroResource}/walk/d${dir}/walk_`, 6, token);
      this.loadClip(`attack${dir}`, `${heroResource}/attack/d${dir}/attack_`, 8, token);
    }
    this.loadClip('death', `${heroResource}/death/death_`, 1, token);
  }

  private syncHeroLookFromProperties() {
    const roleId = this.normalizedHeroRoleId();
    const appearanceId = this.normalizedHeroAppearanceId(roleId);
    if (this.heroRoleId !== roleId || this.heroAppearanceId !== appearanceId) {
      this.heroRoleId = roleId;
      this.heroAppearanceId = appearanceId;
      this.resetHeroBaseStatsForCurrentRole();
    }
    const resource = this.heroResourcePath();
    if (this.loadedHeroResource && this.loadedHeroResource !== resource) this.loadHeroClips();
  }

  private resetHeroBaseStatsForCurrentRole() {
    const race = this.currentHeroRace();
    this.pendingStrengthPoints = 0;
    this.pendingDexterityPoints = 0;
    this.pendingWisdomPoints = 0;
    this.heroUnassignedPoints = 0;
    this.heroStrength = heroBaseStrength(this.heroLevel, race);
    this.heroDexterity = heroBaseDexterity(this.heroLevel, race);
    this.heroWisdom = heroBaseWisdom(this.heroLevel, race);
    this.recalculateHeroStats(true);
  }

  private syncEquippedHeroAppearance() {
    this.applyHeroAppearance(this.equippedHeroAppearanceId());
  }

  private applyHeroAppearance(appearanceId: number) {
    const roleId = this.normalizedHeroRoleId();
    const nextAppearance = this.clamp(Math.floor(Number(appearanceId)), 0, this.heroAppearanceCount(roleId) - 1);
    const currentAppearance = this.normalizedHeroAppearanceId(roleId);
    this.heroAppearanceId = Number.isFinite(nextAppearance) ? nextAppearance : DEFAULT_HERO_APPEARANCE_ID;
    const resource = this.heroResourcePath();
    if (currentAppearance !== this.heroAppearanceId || this.loadedHeroResource !== resource) this.loadHeroClips();
  }

  private equippedHeroAppearanceId() {
    const fashion = this.equippedSlots.fashion;
    const fashionAppearance = fashion ? this.equipmentAppearanceId(fashion.item, false) : -1;
    if (fashionAppearance >= 0) return fashionAppearance;

    const armor = this.equippedSlots.armor;
    const armorAppearance = armor ? this.equipmentAppearanceId(armor.item, true) : -1;
    return armorAppearance >= 0 ? armorAppearance : DEFAULT_HERO_APPEARANCE_ID;
  }

  private equipmentAppearanceId(item: EquipmentCatalogItem, allowArmorLevelMapping: boolean) {
    const configured = this.resolveConfiguredAppearanceId(item.appearanceId, item.stats.appearanceId);
    if (configured >= 0) return this.clamp(configured, 0, this.heroAppearanceCount() - 1);
    if (allowArmorLevelMapping && item.slot === 'armor') return this.armorLevelAppearanceId(item.requiredLevel);
    return -1;
  }

  private armorLevelAppearanceId(requiredLevel: number) {
    const level = Math.floor(this.toNumber(requiredLevel, 0));
    const autoAppearance = level >= 108 ? 3 : level >= 72 ? 2 : level >= 36 ? 1 : 0;
    return this.clamp(autoAppearance, 0, this.heroAppearanceCount() - 1);
  }

  protected onValidate() {
    this.mapId = this.currentMapId();
    this.syncHeroLookFromProperties();
    this.syncMonsterConfigs();
    if (this.loadedMapId !== this.mapId) this.reloadMapAssets();
  }

  update(dt: number) {
    this.runtimeTime += dt;
    this.syncCamera();
    this.syncMonsterConfigs();
    this.syncHeroLookFromProperties();
    if (this.loadedMapId !== this.currentMapId()) this.reloadMapAssets();
    this.playFrames(dt);
    this.playEquipmentPreview(dt);
    this.playCompanionPreview(dt);
    this.playLevelUpEffect(dt);
    this.updateSkillCooldowns(dt);
    this.updateSkillEffects(dt);
    this.updateFloatingTexts(dt);
    this.updateWorldDrops();
    this.followCamera();
    this.layoutStatsUi();
    this.layoutInventoryUi();
    this.layoutSkillUi();
    this.layoutCompanionUi();
    this.layoutEnhanceUi();
    this.layoutReviveUi();
    if (this.revivePromptCooldown > 0) this.revivePromptCooldown = Math.max(0, this.revivePromptCooldown - dt);

    if (this.heroDead) {
      this.autoBattleEnabled = false;
      this.refreshAutoBattleButton();
      this.cancelAllMonsterAttacks();
      this.setHeroDeathClip();
      this.showRevivePrompt();
      this.sortActorsByY();
      this.bringOcclusionToFront();
      this.bringWorldDropsToFront();
      this.bringSkillEffectsToFront();
      this.bringFloatingTextsToFront();
      this.bringStatsUiToFront();
      this.bringInventoryUiToFront();
      this.bringSkillUiToFront();
      this.bringCompanionUiToFront();
      this.bringEnhanceUiToFront();
      this.bringReviveUiToFront();
      this.updateAutoSave(dt);
      return;
    }

    this.updateMonsters(dt);
    this.updateCompanions(dt);
    this.spawnTime += dt;
    if (this.spawnTime > 0.8) {
      this.spawnTime = 0;
      if (this.monsters.length < 12) this.spawnMonster();
    }
    this.sortActorsByY();
    this.bringOcclusionToFront();
    this.bringWorldDropsToFront();
    this.bringSkillEffectsToFront();
    this.bringFloatingTextsToFront();
    this.bringStatsUiToFront();
    this.bringInventoryUiToFront();
    this.bringSkillUiToFront();
    this.bringCompanionUiToFront();
    this.bringEnhanceUiToFront();
    this.bringReviveUiToFront();
    this.updateAutoSave(dt);

    if (!this.autoBattleEnabled) {
      this.stopHeroAutoBattle();
      return;
    }

    if (this.attackTime >= 0) {
      this.attackTime += dt;
      if (this.attackTime >= this.heroAttackAnimationDuration()) this.finishAttack();
      return;
    }

    this.monsters = this.monsters.filter((monster) => monster.node.isValid);
    const pickup = this.nearestWorldDropPickupTarget();
    if (pickup) {
      this.resetTargetProgress();
      const move = this.moveToward(this.node, pickup.position, this.heroMoveSpeed(), dt);
      if (move) {
        this.currentDir = this.directionFrom(move.lastMoveX, move.lastMoveY);
        this.setClip(`walk${this.currentDir}`);
        return;
      }
    }

    this.target = this.nearestMonster();
    if (!this.target) {
      this.resetTargetProgress();
      this.setHeroIdleClip();
      return;
    }

    const dx = this.target.node.position.x - this.node.position.x;
    const dy = this.target.node.position.y - this.node.position.y;
    const dist = Math.sqrt(dx * dx + dy * dy);
    if (dist <= this.heroAttackRange()) {
      this.currentDir = this.directionFrom(dx, dy);
      this.resetTargetProgress();
      this.startAttack(this.target);
      return;
    }
    if (!this.trackTargetProgress(this.target, dist, dt)) {
      this.target = null;
      this.setHeroIdleClip();
      return;
    }

    const move = this.moveToward(this.node, this.target.node.position, this.heroMoveSpeed(), dt);
    if (move) {
      this.currentDir = this.directionFrom(move.lastMoveX, move.lastMoveY);
      this.setClip(`walk${this.currentDir}`);
    } else {
      this.setHeroIdleClip();
    }
  }

  private loadClip(name: string, prefix: string, count: number, token = this.heroClipLoadToken) {
    const paths = Array.from({ length: count }, (_, i) => `${prefix}${i < 10 ? '0' : ''}${i}/spriteFrame`);
    resources.load(paths, SpriteFrame, (err, frames) => {
      if (token !== this.heroClipLoadToken) return;
      if (!err && frames?.length) {
        this.clips[name] = frames;
        if (name === this.currentClip) this.setFrame(0);
        if (name === 'death' && this.heroDead) this.setHeroDeathClip();
        if (name === 'idleFront' || name === 'idle' || name === 'idle4') this.setEquipmentPreviewFrame(this.equipmentPreviewFrame);
      }
    });
  }

  private loadMonsterClips() {
    for (const type of this.monsterTypes()) {
      const counts = MONSTER_FRAME_COUNTS[type] ?? { idle: 10, walk: 10, attack: 10 };
      for (let dir = 0; dir < 8; dir++) {
        this.loadMonsterClip(this.monsterClip(type, 'idle', dir), `monsters/${type}/idle/d${dir}/idle_`, counts.idle);
        this.loadMonsterClip(this.monsterClip(type, 'walk', dir), `monsters/${type}/walk/d${dir}/walk_`, counts.walk);
        this.loadMonsterClip(this.monsterClip(type, 'attack', dir), `monsters/${type}/attack/d${dir}/attack_`, counts.attack);
      }
      resources.load(`monsters/${type}/idle/d0/idle_00/spriteFrame`, SpriteFrame, (err, frame) => {
        if (!err && frame) {
          this.monsterFrames[type] = frame;
          this.renderCompanionUi();
          this.syncCompanionActors();
        }
      });
    }
  }

  private loadMonsterClip(name: string, prefix: string, count: number) {
    const paths = Array.from({ length: count }, (_, i) => `${prefix}${i < 10 ? '0' : ''}${i}/spriteFrame`);
    resources.load(paths, SpriteFrame, (err, frames) => {
      if (!err && frames?.length) {
        this.monsterClips[name] = frames;
        this.renderCompanionUi();
        this.syncCompanionActors();
      }
    });
  }

  private loadLevelUpFrames() {
    const paths = Array.from({ length: LEVEL_UP_FRAME_COUNT }, (_, i) => `effects/level_up/level_up_${i < 10 ? '0' : ''}${i}/spriteFrame`);
    resources.load(paths, SpriteFrame, (err, frames) => {
      if (!err && frames?.length) this.levelUpFrames = frames;
    });
  }

  private loadBloodStainFrame() {
    resources.load('effects/blood_stain/blood_stain/spriteFrame', SpriteFrame, (err, frame) => {
      if (!err && frame) this.bloodStainFrame = frame;
    });
  }

  private loadDamageTextFrames() {
    const digitKeys = Array.from({ length: 10 }, (_, i) => `${i}`);
    const keys = [
      ...digitKeys.map((key) => `damage_${key}`), 'damage_minus',
      ...digitKeys.map((key) => `heal_${key}`), 'heal_plus',
      ...digitKeys.map((key) => `special_${key}`), 'special_minus',
      'text_hit_empty', 'text_lost', 'text_block', 'text_crit',
      ...digitKeys.map((key) => `mp_${key}`), 'mp_plus',
    ];
    resources.load(keys.map((key) => `effects/damage_text/${key}/spriteFrame`), SpriteFrame, (err, frames) => {
      if (err || !frames?.length) return;
      keys.forEach((key, index) => {
        const frame = frames[index];
        if (frame) this.damageTextFrames[key] = frame;
      });
    });
  }

  private syncMonsterConfigs() {
    const signature = this.monsterConfigs()
      .map((config) => `${this.monsterType(config)}:${config.monsterLevel}:${config.maxHp}:${config.attack}:${config.defense}:${config.expMin}:${config.expMax}:${config.rewardId}`)
      .join('|');
    if (signature === this.loadedMonsterSignature) return;
    this.loadedMonsterSignature = signature;
    this.loadMonsterClips();
    for (const monster of this.monsters) {
      if (monster.node.isValid) monster.node.destroy();
    }
    this.monsters = [];
    this.target = null;
    this.attackTarget = null;
  }

  private reloadMapAssets() {
    const id = this.currentMapId();
    this.loadedMapId = id;
    this.blockMap = null;
    this.target = null;
    this.attackTarget = null;
    this.resetTargetProgress();
    for (const monster of this.monsters) {
      if (monster.node.isValid) monster.node.destroy();
    }
    this.monsters = [];
    this.clearWorldDrops();
    this.moveMemories = this.moveMemories.filter((item) => item.node === this.node);
    if (this.occlusionNode?.isValid) this.occlusionNode.destroy();
    this.occlusionNode = null;
    for (const item of this.mapPatchObjects) {
      if (item.node.isValid) item.node.destroy();
    }
    this.mapPatchObjects = [];
    this.loadMapPreview(id);
    this.loadBlockMap(id);
    this.loadOcclusionLayer(id);
  }

  private loadMapPreview(mapId: number) {
    if (!this.node.parent) return;
    const node = this.mapPreviewNode();
    if (!node) return;
    resources.load(`maps/map_${mapId}_preview/spriteFrame`, SpriteFrame, (err, frame) => {
      if (err || !frame || !node.isValid) return;
      node.name = `Map${mapId}Preview`;
      node.setScale(1.5, 1.5, 1);
      node.getComponent(UITransform)?.setContentSize(3000, 3000);
      const sprite = node.getComponent(Sprite) ?? node.addComponent(Sprite);
      sprite.sizeMode = Sprite.SizeMode.RAW;
      sprite.spriteFrame = frame;
    });
  }

  private loadBlockMap(mapId: number) {
    resources.load(`maps/map_${mapId}_block`, JsonAsset, (err, asset) => {
      if (!err && asset?.json) this.blockMap = asset.json as BlockMap;
      this.loadMapPatch(mapId);
    });
  }

  private loadOcclusionLayer(mapId: number) {
    resources.load(`maps/map_${mapId}_occlusion/spriteFrame`, SpriteFrame, (err, frame) => {
      if (err || !frame || !this.node.parent || this.occlusionNode) return;
      const node = new Node(`Map${mapId}Occlusion`);
      node.parent = this.node.parent;
      node.setPosition(0, 0, 0);
      node.setScale(1.5, 1.5, 1);
      node.addComponent(UITransform).setContentSize(3000, 3000);
      const sprite = node.addComponent(Sprite);
      sprite.sizeMode = Sprite.SizeMode.RAW;
      sprite.spriteFrame = frame;
      this.occlusionNode = node;
      this.bringOcclusionToFront();
    });
  }

  private loadMapPatch(mapId: number) {
    resources.load(`maps/patches/map_${mapId}_patch`, JsonAsset, (err, asset) => {
      const objects = asset?.json?.objects as MapPatchObjectData[] | undefined;
      if (err || !objects?.length || !this.node.parent) return;
      for (const item of objects) this.createMapPatchObject(item);
    });
  }

  private createMapPatchObject(data: MapPatchObjectData) {
    const resource = data.resource || `map_objects/tile_${data.assetId}`;
    resources.load(`${resource}/spriteFrame`, SpriteFrame, (err, frame) => {
      if (err || !frame || !this.node.parent) return;
      const node = new Node(`MapObject_${data.assetId}`);
      node.parent = this.node.parent;
      const transform = node.addComponent(UITransform);
      transform.setContentSize(data.width, data.height);
      transform.setAnchorPoint(0.5, 0);
      node.setScale(this.mapNodeScale() * (data.scale || 1), this.mapNodeScale() * (data.scale || 1), 1);
      node.setPosition(this.mapImageToWorld(data.x + (data.width * data.scale) / 2, data.y + data.height * data.scale));
      const sprite = node.addComponent(Sprite);
      sprite.sizeMode = Sprite.SizeMode.RAW;
      sprite.spriteFrame = frame;
      this.mapPatchObjects.push({ node, data });
    });
  }

  private spawnMonster() {
    if (!this.blockMap) return;
    const type = this.randomMonsterType();
    const frame = this.monsterClips[this.monsterClip(type, 'idle', 0)]?.[0] ?? this.monsterFrames[type];
    if (!frame || !this.node.parent) return;
    const monster = new Node('AutoMonster');
    monster.parent = this.node.parent;
    const pos = this.randomPassablePoint();
    monster.setPosition(pos.x, pos.y, 0);
    const visualNode = this.usesOffsetAlignedMonster(type) ? new Node('MonsterVisual') : monster;
    if (visualNode !== monster) monster.addChild(visualNode);
    const transform = visualNode.addComponent(UITransform);
    const sprite = visualNode.addComponent(Sprite);
    sprite.sizeMode = Sprite.SizeMode.TRIMMED;
    this.applyMonsterFrame(type, sprite, transform, frame, visualNode);
    const hpUi = this.createMonsterHpUi(monster);
    const config = this.monsterConfigByType(type);
    const maxHp = Math.max(1, Math.round(config.maxHp));
    const rewardId = this.resolveMonsterRewardId(config);
    const actor: MonsterActor = {
      node: monster,
      visualNode,
      type,
      config,
      sprite,
      transform,
      state: 'idle',
      dir: 0,
      clip: this.monsterClip(type, 'idle', 0),
      frame: 0,
      time: 0,
      wait: Math.random() * 1.4,
      target: this.randomWanderPoint(pos),
      blockedUntil: 0,
      maxHp,
      currentHp: maxHp,
      level: this.resolveMonsterLevel(config, rewardId),
      attack: Math.max(0, Math.round(config.attack)),
      defense: Math.max(0, Math.round(config.defense)),
      expMin: Math.max(0, Math.round(config.expMin)),
      expMax: Math.max(0, Math.round(config.expMax)),
      rewardId,
      hpRoot: hpUi.root,
      hpLabel: hpUi.label,
      hpBar: hpUi.bar,
      attackCooldown: 0,
      attackActive: false,
    };
    this.layoutMonsterHp(actor);
    this.updateMonsterHpUi(actor);
    this.monsters.push(actor);
  }

  private randomMapPoint() {
    const hero = this.node.position;
    const angle = Math.random() * Math.PI * 2;
    const radius = 260 + Math.random() * 520;
    const bounds = this.mapWorldBounds(30);
    return new Vec3(
      this.clamp(hero.x + Math.cos(angle) * radius, bounds.minX, bounds.maxX),
      this.clamp(hero.y + Math.sin(angle) * radius, bounds.minY, bounds.maxY),
      0,
    );
  }

  private randomPassablePoint() {
    for (let i = 0; i < 40; i++) {
      const pos = this.randomMapPoint();
      if (this.canMonsterStandAt(pos.x, pos.y) && this.isActorSpotFree(null, pos.x, pos.y)) return pos;
    }
    return this.findFreePointAround(this.node.position, 80, 560) ?? this.node.position.clone();
  }

  private findFreePointAround(center: Readonly<Vec3>, minRadius: number, maxRadius: number) {
    const bounds = this.mapWorldBounds(30);
    for (let radius = minRadius; radius <= maxRadius; radius += 40) {
      for (let i = 0; i < 16; i++) {
        const angle = (Math.PI * 2 * i) / 16;
        const pos = new Vec3(
          this.clamp(center.x + Math.cos(angle) * radius, bounds.minX, bounds.maxX),
          this.clamp(center.y + Math.sin(angle) * radius, bounds.minY, bounds.maxY),
          0,
        );
        if (this.canMonsterStandAt(pos.x, pos.y) && this.isActorSpotFree(null, pos.x, pos.y)) return pos;
      }
    }
    return null;
  }

  private nearestMonster() {
    let best: MonsterActor | null = null;
    let bestDist = Infinity;
    for (const monster of this.monsters) {
      if (monster.currentHp <= 0) continue;
      if (monster.blockedUntil > this.runtimeTime) continue;
      const dist = Vec3.distance(this.node.position, monster.node.position);
      if (!this.canReachTarget(this.node.position, monster.node.position, dist)) continue;
      if (dist < bestDist) {
        bestDist = dist;
        best = monster;
      }
    }
    return best;
  }

  private trackTargetProgress(monster: MonsterActor, dist: number, dt: number) {
    if (this.stalledTarget !== monster) {
      this.stalledTarget = monster;
      this.stalledBestDist = dist;
      this.stalledTime = 0;
      this.stalledAnchorX = this.node.position.x;
      this.stalledAnchorY = this.node.position.y;
      this.stalledAreaTime = 0;
      return true;
    }
    const areaDx = this.node.position.x - this.stalledAnchorX;
    const areaDy = this.node.position.y - this.stalledAnchorY;
    if (Math.sqrt(areaDx * areaDx + areaDy * areaDy) < TARGET_AREA_EPS) {
      this.stalledAreaTime += dt;
    } else {
      this.stalledAnchorX = this.node.position.x;
      this.stalledAnchorY = this.node.position.y;
      this.stalledAreaTime = 0;
    }
    if (dist < this.stalledBestDist - TARGET_PROGRESS_EPS) {
      this.stalledBestDist = dist;
      this.stalledTime = 0;
    } else {
      this.stalledTime += dt;
    }
    if (this.stalledTime < TARGET_STALL_SECONDS && this.stalledAreaTime < TARGET_STALL_SECONDS) return true;
    monster.blockedUntil = this.runtimeTime + TARGET_BLOCK_SECONDS;
    this.resetTargetProgress();
    return false;
  }

  private resetTargetProgress() {
    this.stalledTarget = null;
    this.stalledBestDist = Infinity;
    this.stalledTime = 0;
    this.stalledAreaTime = 0;
  }

  private startAttack(monster: MonsterActor) {
    if (this.heroDead) return;
    if (monster.currentHp <= 0) return;
    this.attackTarget = monster;
    this.attackSkill = this.pickReadySkill(monster);
    this.attackTime = 0;
    this.currentDir = this.normalizedDirection(this.currentDir);
    this.setClip(`attack${this.currentDir}`);
  }

  private finishAttack() {
    if (this.heroDead) {
      this.stopHeroAutoBattle();
      return;
    }
    this.attackTime = -1;
    const monster = this.attackTarget;
    if (monster?.node.isValid) {
      const skill = this.attackSkill;
      if (skill) this.resolveSkillAttack(monster, skill);
      else this.resolveNormalAttack(monster);
    }
    this.attackTarget = null;
    this.attackSkill = null;
    this.target = this.nearestMonster();
    this.setHeroIdleClip();
  }

  private resolveNormalAttack(monster: MonsterActor) {
    const hit = this.rollHeroHit();
    const position = new Vec3(monster.node.position.x, monster.node.position.y, 0);
    const finish = () => {
      if (!monster.node.isValid || monster.currentHp <= 0) return;
      const actualDamage = this.applyHeroDamageToMonster(monster, hit.damage);
      this.spawnDamageNumber(actualDamage, position, hit.crit);
    };
    if (this.currentHeroRace() === DEFAULT_HERO_RACE) {
      this.spawnRangerBasicProjectile(monster, finish);
      return;
    }
    finish();
  }

  private spawnRangerBasicProjectile(monster: MonsterActor, onFinish: () => void) {
    const frames = this.skillFrames[RANGER_ARROW_PROJECTILE_PATH] ?? [];
    if (!frames.length || !monster.node.isValid) {
      onFinish();
      return;
    }
    const impact = new Vec3(monster.node.position.x, monster.node.position.y + 22, 0);
    const dirX = impact.x - this.node.position.x;
    const dirY = impact.y - this.node.position.y;
    const length = Math.hypot(dirX, dirY) || 1;
    const start = new Vec3(
      this.node.position.x + (dirX / length) * RANGER_ARROW_START_FORWARD_OFFSET,
      this.node.position.y + RANGER_ARROW_START_BODY_Y + (dirY / length) * RANGER_ARROW_START_FORWARD_OFFSET,
      0,
    );
    this.spawnSkillProjectile(frames, start, impact, onFinish);
  }

  private resolveSkillAttack(monster: MonsterActor, instance: SkillInstance) {
    const skill = instance.skill;
    this.heroCurrentMana = Math.max(0, this.heroCurrentMana - Math.max(0, skill.manaCost));
    this.updateHeroHpUi();
    const hit = this.rollHeroHit();
    const damage = this.rollSkillDamage(skill, hit.damage);
    const projectileFrames = skill.projectilePath ? this.skillFrames[skill.projectilePath] ?? [] : [];
    const effectFrames = skill.effectPath ? this.skillFrames[skill.effectPath] ?? [] : [];
    const impact = new Vec3(monster.node.position.x, monster.node.position.y + 22, 0);
    const finish = () => {
      if (!monster.node.isValid || monster.currentHp <= 0) return;
      const position = new Vec3(monster.node.position.x, monster.node.position.y, 0);
      const actualDamage = this.applyHeroDamageToMonster(monster, damage);
      if (effectFrames.length) this.spawnSkillEffect(effectFrames, impact, this.skillEffectDuration(skill, effectFrames.length));
      this.spawnDamageNumber(actualDamage, position, hit.crit);
    };
    if (projectileFrames.length) {
      const dirX = impact.x - this.node.position.x;
      const dirY = impact.y - this.node.position.y;
      const length = Math.hypot(dirX, dirY) || 1;
      const start = new Vec3(
        this.node.position.x + (dirX / length) * RANGER_ARROW_START_FORWARD_OFFSET,
        this.node.position.y + RANGER_ARROW_START_BODY_Y + (dirY / length) * RANGER_ARROW_START_FORWARD_OFFSET,
        0,
      );
      this.spawnSkillProjectile(projectileFrames, start, impact, finish);
    } else {
      finish();
    }
    instance.cooldown = this.skillCooldownSeconds(skill);
    this.gainSkillExperience(instance);
    this.renderSkillUi();
  }

  private applyHeroDamageToMonster(monster: MonsterActor, damage: number) {
    const actualDamage = this.damageMonster(monster, damage);
    if (monster.currentHp <= 0) {
      this.spawnBloodStain(monster.node.position);
      this.applyMonsterReward(monster);
      monster.node.destroy();
      this.monsters = this.monsters.filter((item) => item.node.isValid && item !== monster);
    }
    return actualDamage;
  }

  private spawnBloodStain(position: Readonly<Vec3>) {
    if (!this.bloodStainFrame || !this.node.parent) return;
    const node = new Node('BloodStain');
    node.parent = this.node.parent;
    node.setPosition(position.x, position.y + BLOOD_STAIN_FOOT_OFFSET_Y, 0);
    const transform = node.addComponent(UITransform);
    const sprite = node.addComponent(Sprite);
    this.applyFrame(sprite, transform, this.bloodStainFrame);
    const mapNode = this.mapPreviewNode();
    node.setSiblingIndex(mapNode ? mapNode.getSiblingIndex() + 1 : 1);
    this.scheduleOnce(() => {
      if (node.isValid) node.destroy();
    }, BLOOD_STAIN_LIFETIME);
  }

  private playFrames(dt: number) {
    const frames = this.clips[this.currentClip] ?? [];
    if (!this.sprite || frames.length < 1) return;
    if (frames.length === 1) {
      if (this.index !== 0) {
        this.index = 0;
        this.setFrame(0);
      }
      return;
    }
    this.time += dt;
    if (this.time < this.frameInterval()) return;
    this.time = 0;
    this.index = this.currentClip.startsWith('attack') || this.currentClip === 'death'
      ? Math.min(this.index + 1, frames.length - 1)
      : (this.index + 1) % frames.length;
    this.setFrame(this.index);
  }

  private playEquipmentPreview(dt: number) {
    if (!this.inventoryPanel?.active) return;
    const frames = this.equipmentPreviewFrames();
    if (!this.equipmentPreviewSprite || !this.equipmentPreviewTransform || frames.length < 2) return;
    this.equipmentPreviewTime += dt;
    if (this.equipmentPreviewTime < 0.18) return;
    this.equipmentPreviewTime = 0;
    this.equipmentPreviewFrame = (this.equipmentPreviewFrame + 1) % frames.length;
    this.setEquipmentPreviewFrame(this.equipmentPreviewFrame);
  }

  private setEquipmentPreviewFrame(index: number) {
    const frames = this.equipmentPreviewFrames();
    if (!this.equipmentPreviewSprite || !this.equipmentPreviewTransform || !frames.length) return;
    this.equipmentPreviewFrame = ((index % frames.length) + frames.length) % frames.length;
    this.applyFrame(this.equipmentPreviewSprite, this.equipmentPreviewTransform, frames[this.equipmentPreviewFrame]);
  }

  private equipmentPreviewFrames() {
    return this.clips.idleFront ?? this.clips.idle4 ?? this.clips.idle ?? [];
  }

  private setHeroIdleClip() {
    if (this.heroDead) {
      this.setHeroDeathClip();
      return;
    }
    this.currentDir = this.normalizedDirection(this.currentDir);
    const directedIdle = `idle${this.currentDir}`;
    if (this.clips[directedIdle]?.length) {
      this.setClip(directedIdle);
      return;
    }
    this.setClip('idle');
  }

  private setHeroDeathClip() {
    if (this.clips.death?.length) {
      this.setClip('death');
      return;
    }
    this.currentClip = 'death';
    this.index = 0;
    this.time = 0;
  }

  private setClip(name: string) {
    if (this.currentClip === name || !this.clips[name]?.length) return;
    this.currentClip = name;
    this.index = 0;
    this.time = 0;
    this.setFrame(0);
  }

  private updateMonsters(dt: number) {
    for (const monster of this.monsters) {
      if (!monster.node.isValid) continue;
      const dx = this.node.position.x - monster.node.position.x;
      const dy = this.node.position.y - monster.node.position.y;
      const heroDist = Math.sqrt(dx * dx + dy * dy);
      const canAttackHero = heroDist <= MONSTER_ATTACK_RANGE;
      const canChaseHero = heroDist <= MONSTER_CHASE_RANGE && this.canReachTarget(monster.node.position, this.node.position, heroDist, true);

      if (monster.attackActive || canAttackHero) {
        monster.dir = this.directionFrom(dx, dy);
        this.updateMonsterAttack(monster, dt);
      } else if (canChaseHero) {
        this.cancelMonsterAttack(monster);
        if (this.moveMonster(monster, this.node.position, dt)) this.setMonsterState(monster, 'chase');
        else this.setMonsterState(monster, 'idle');
      } else if (monster.wait > 0) {
        this.cancelMonsterAttack(monster);
        monster.wait -= dt;
        this.setMonsterState(monster, 'idle');
      } else {
        this.cancelMonsterAttack(monster);
        if (this.moveMonster(monster, monster.target, dt)) {
          this.setMonsterState(monster, 'walk');
        } else {
          monster.wait = 0.8 + Math.random() * 1.6;
          monster.target = this.randomWanderPoint(monster.node.position);
        }
      }

      this.playMonsterFrames(monster, dt);
    }
  }

  private moveMonster(monster: MonsterActor, target: Readonly<Vec3>, dt: number) {
    const dx = target.x - monster.node.position.x;
    const dy = target.y - monster.node.position.y;
    const dist = Math.sqrt(dx * dx + dy * dy);
    if (dist < 4) return false;
    const move = this.moveToward(monster.node, target, MONSTER_MOVE_SPEED, dt, true);
    if (!move) return false;
    monster.dir = this.directionFrom(move.lastMoveX, move.lastMoveY);
    return dist > 8;
  }

  private randomWanderPoint(from: Readonly<Vec3>) {
    const bounds = this.mapWorldBounds(30);
    for (let i = 0; i < 16; i++) {
      const angle = Math.random() * Math.PI * 2;
      const pos = new Vec3(
        this.clamp(from.x + Math.cos(angle) * MONSTER_WANDER_STEP, bounds.minX, bounds.maxX),
        this.clamp(from.y + Math.sin(angle) * MONSTER_WANDER_STEP, bounds.minY, bounds.maxY),
        0,
      );
      if (this.canMonsterStandAt(pos.x, pos.y) && this.isActorSpotFree(null, pos.x, pos.y)) return pos;
    }
    return new Vec3(from.x, from.y, 0);
  }

  private setMonsterState(monster: MonsterActor, state: MonsterState) {
    const action = state === 'chase' ? 'walk' : state;
    const clip = this.monsterClip(monster.type, action, monster.dir);
    if (monster.clip === clip || !this.monsterClips[clip]?.length) return;
    monster.state = state;
    monster.clip = clip;
    monster.frame = 0;
    monster.time = 0;
    this.setMonsterFrame(monster, 0);
  }

  private playMonsterFrames(monster: MonsterActor, dt: number) {
    const frames = this.monsterClips[monster.clip] ?? [];
    if (frames.length < 2) return;
    monster.time += dt;
    const isAttack = monster.clip.startsWith(`${monster.type}:attack`);
    const interval = isAttack ? MONSTER_ATTACK_FRAME_INTERVAL : MONSTER_FRAME_INTERVAL;
    if (monster.time < interval) return;
    monster.time = 0;
    if (isAttack && monster.frame >= frames.length - 1) {
      if (this.canMonsterHitHero(monster)) this.damageHeroFromMonster(monster);
      monster.attackActive = false;
      monster.attackCooldown = MONSTER_ATTACK_INTERVAL;
      this.setMonsterState(monster, 'idle');
      return;
    }
    monster.frame = (monster.frame + 1) % frames.length;
    this.setMonsterFrame(monster, monster.frame);
  }

  private setMonsterFrame(monster: MonsterActor, index: number) {
    const frame = this.monsterClips[monster.clip]?.[index];
    if (frame) {
      this.applyMonsterFrame(monster.type, monster.sprite, monster.transform, frame, monster.visualNode);
      this.layoutMonsterHp(monster);
    }
  }

  private currentMapId() {
    const id = Number.isFinite(this.mapId) ? this.mapId : DEFAULT_MAP_ID;
    return Math.max(0, Math.floor(id));
  }

  private mapPreviewNode() {
    if (!this.node.parent) return null;
    return this.node.parent.children.find((node) => /^Map\d+Preview$/.test(node.name))
      ?? this.node.parent.getChildByName(`Map${this.currentMapId()}Preview`);
  }

  private monsterConfigs() {
    return (this.mapMonsters?.length ? this.mapMonsters : [defaultMonsterConfig(0)])
      .filter((config) => config && config.monsterId >= 0);
  }

  private monsterType(config: MapMonsterConfig) {
    const id = Math.floor(config.monsterId);
    return `monster_${id < 10 ? `0${id}` : id}`;
  }

  private monsterConfigByType(type: string) {
    return this.monsterConfigs().find((config) => this.monsterType(config) === type) ?? defaultMonsterConfig(0);
  }

  private monsterTypes() {
    return Array.from(new Set([
      ...this.mapMonsterTypes(),
      ...this.companionTypes(),
    ]));
  }

  private mapMonsterTypes() {
    return this.monsterConfigs().map((config) => this.monsterType(config));
  }

  private companionTypes() {
    const types = new Set<string>(DEFAULT_COMPANION_TYPES);
    for (const companion of [...this.companionBagSlots, ...this.activeCompanionSlots]) {
      if (companion?.type) types.add(companion.type);
    }
    return Array.from(types);
  }

  private randomMonsterType() {
    const types = this.mapMonsterTypes();
    const ready = types.filter((type) => this.monsterClips[this.monsterClip(type, 'idle', 0)]?.length || this.monsterFrames[type]);
    return ready[Math.floor(Math.random() * ready.length)] ?? types[0];
  }

  private monsterClip(type: string, action: string, dir: number) {
    return `${type}:${action}${dir}`;
  }

  private setFrame(index: number) {
    if (!this.sprite) return;
    const frame = this.clips[this.currentClip]?.[index];
    if (!frame) return;
    this.sprite.spriteFrame = frame;
    this.keepTrimmedFrame();
  }

  private frameInterval() {
    if (this.currentClip.startsWith('attack')) return this.heroAttackFrameInterval();
    if (this.currentClip.startsWith('walk')) return this.heroWalkFrameInterval();
    return HERO_IDLE_FRAME_INTERVAL;
  }

  private heroAttackFrameInterval() {
    const frames = this.clips[this.currentClip]?.length || 8;
    return this.heroAttackAnimationDuration(frames) / frames;
  }

  private heroAttackAnimationDuration(frameCount = this.clips[this.currentClip]?.length || 8) {
    const frames = Math.max(1, frameCount);
    const baseDuration = frames * HERO_ATTACK_FRAME_INTERVAL;
    const attackTime = this.heroDerivedStats().attackTime;
    const duration = baseDuration * attackTime / HERO_BASE_ATTACK_TIME;
    return this.clamp(duration, frames * HERO_MIN_ATTACK_FRAME_INTERVAL, frames * HERO_MAX_ATTACK_FRAME_INTERVAL);
  }

  private heroWalkFrameInterval() {
    const speed = Math.max(1, this.heroMoveSpeed());
    return this.clamp(HERO_WALK_FRAME_INTERVAL * HERO_MOVE_SPEED / speed, HERO_MIN_WALK_FRAME_INTERVAL, HERO_MAX_WALK_FRAME_INTERVAL);
  }

  private heroMoveSpeed() {
    return HERO_MOVE_SPEED;
  }

  private heroAttackRange() {
    const skill = this.selectedSkill();
    if (skill && skill.cooldown <= 0 && this.heroCurrentMana >= skill.skill.manaCost) {
      return Math.max(this.heroDerivedStats().attackRange, this.skillAttackRange(skill.skill));
    }
    return this.heroDerivedStats().attackRange;
  }

  private heroMaxVisibleAttackRange() {
    const designHalfWidth = CAMERA_ORTHO_HEIGHT * (DESIGN_WIDTH / DESIGN_HEIGHT);
    const actualHalfWidth = this.screenUiBounds().halfScreenWidth;
    const halfWidth = actualHalfWidth > 0 ? Math.min(designHalfWidth, actualHalfWidth) : designHalfWidth;
    return Math.max(HERO_MELEE_ATTACK_RANGE, Math.floor(halfWidth - 24));
  }

  private createExpLabel() {
    const node = new Node('HeroExpLabel');
    this.node.addChild(node);
    node.setPosition(0, 92, 0);
    this.expLabel = node.addComponent(Label);
    this.expLabel.fontSize = 16;
    this.expLabel.lineHeight = 18;
    this.expLabel.color = Color.WHITE;
    this.updateExpLabel();
  }

  private createHeroHpUi() {
    const barNode = new Node('HeroHpBar');
    this.node.addChild(barNode);
    barNode.setPosition(0, 114, 0);
    barNode.addComponent(UITransform).setContentSize(HERO_HP_BAR_WIDTH, HERO_HP_BAR_HEIGHT);
    this.heroHpBar = barNode.addComponent(Graphics);

    const labelNode = new Node('HeroHpLabel');
    this.node.addChild(labelNode);
    labelNode.setPosition(0, 128, 0);
    this.heroHpLabel = labelNode.addComponent(Label);
    this.heroHpLabel.fontSize = 14;
    this.heroHpLabel.lineHeight = 16;
    this.heroHpLabel.color = Color.WHITE;
    this.updateHeroHpUi();
  }

  private createStatsUi() {
    if (!this.node.parent) return;
    this.autoBattleButton = this.createMainMenuButton(this.node.parent, 'AutoBattleButton', GAME_TEXT.ui.autoBattleShort, () => this.toggleAutoBattle());
    this.statsButton = this.createMainMenuButton(this.node.parent, 'HeroStatsButton', GAME_TEXT.ui.stats, () => {
      if (this.statsPanel) this.statsPanel.active = !this.statsPanel.active;
    });

    this.statsPanel = new Node('HeroStatsPanel');
    this.statsPanel.parent = this.node.parent;
    this.statsPanel.active = false;
    this.statsPanel.addComponent(UITransform).setContentSize(STATS_OLD_WIDTH * STATS_UI_SCALE, STATS_OLD_HEIGHT * STATS_UI_SCALE);
    const bg = this.statsPanel.addComponent(Graphics);
    this.drawOldPopupBackground(bg, STATS_OLD_WIDTH, STATS_OLD_HEIGHT, STATS_UI_SCALE);
    this.statsPopupFrame = {
      node: this.statsPanel,
      width: STATS_OLD_WIDTH * STATS_UI_SCALE,
      height: STATS_OLD_HEIGHT * STATS_UI_SCALE,
      oldWidth: STATS_OLD_WIDTH,
      oldHeight: STATS_OLD_HEIGHT,
    };
    this.applyOldPopupFrame(this.statsPopupFrame);

    this.addOldPopupTitle(this.statsPanel, GAME_TEXT.panel.stats, STATS_OLD_WIDTH, STATS_OLD_HEIGHT, STATS_UI_SCALE);
    this.addOldPopupCloseButton(this.statsPanel, STATS_OLD_WIDTH, STATS_OLD_HEIGHT, STATS_UI_SCALE, () => {
      if (this.statsPanel) this.statsPanel.active = false;
    });
    this.addOldPanelLabel(this.statsPanel, GAME_TEXT.stats.base, STATS_OLD_WIDTH, STATS_OLD_HEIGHT, STATS_UI_SCALE, 18, 42, 90, 'left');
    this.addOldPanelLabel(this.statsPanel, GAME_TEXT.stats.remainingPoints, STATS_OLD_WIDTH, STATS_OLD_HEIGHT, STATS_UI_SCALE, 146, 42, 58, 'left');
    this.statsLabels.points = this.addOldStatValueBox(this.statsPanel, 'points', 152, 61, 34, 16);

    this.addStatRow(GAME_TEXT.stats.strength, 'strength', 18, 61);
    this.addStatRow(GAME_TEXT.stats.dexterity, 'dexterity', 18, 82);
    this.addStatRow(GAME_TEXT.stats.wisdom, 'wisdom', 18, 103);
    this.createStatsActionButton('StatsSubmitAddPoint', GAME_TEXT.ui.confirm, 130, 100, 32, () => this.submitStatPoints());
    this.createStatsActionButton('StatsCancelAddPoint', GAME_TEXT.ui.cancel, 164, 100, 32, () => this.cancelStatPoints());
    this.addOldPanelSeparator(this.statsPanel, STATS_OLD_WIDTH, STATS_OLD_HEIGHT, STATS_UI_SCALE, 3, 129, STATS_OLD_WIDTH - 3);

    const rows: [string, keyof HeroDerivedStats | 'pk' | 'turns' | 'merit', number][] = [
      [GAME_TEXT.stats.physicalAttack, 'minPhysicalDamage', 146],
      [GAME_TEXT.stats.magicAttack, 'minMagicDamage', 162],
      [GAME_TEXT.stats.physicalDefense, 'physicalDefense', 178],
      [GAME_TEXT.stats.magicDefense, 'magicDefense', 194],
      [GAME_TEXT.stats.attackTime, 'attackTime', 210],
      [GAME_TEXT.stats.hit, 'hittingAbility', 226],
      [GAME_TEXT.stats.dodge, 'evadingAbility', 242],
      [GAME_TEXT.stats.pk, 'pk', 258],
      [GAME_TEXT.stats.turns, 'turns', 274],
      [GAME_TEXT.stats.merit, 'merit', 290],
    ];
    for (const [name, key, y] of rows) {
      this.addOldPanelLabel(this.statsPanel, name, STATS_OLD_WIDTH, STATS_OLD_HEIGHT, STATS_UI_SCALE, 18, y, 94, 'left');
      this.statsLabels[key] = this.addOldPanelLabel(this.statsPanel, '', STATS_OLD_WIDTH, STATS_OLD_HEIGHT, STATS_UI_SCALE, 118, y, 68, 'left');
    }
    this.updateStatsPanel();
  }

  private createReviveUi() {
    if (!this.node.parent) return;
    const width = REVIVE_OLD_WIDTH * REVIVE_UI_SCALE;
    const height = REVIVE_OLD_HEIGHT * REVIVE_UI_SCALE;
    this.revivePanel = new Node('RevivePanel');
    this.revivePanel.parent = this.node.parent;
    this.revivePanel.active = false;
    this.revivePanel.addComponent(UITransform).setContentSize(width, height);
    const bg = this.revivePanel.addComponent(Graphics);
    this.drawOldPopupBackground(bg, REVIVE_OLD_WIDTH, REVIVE_OLD_HEIGHT, REVIVE_UI_SCALE);
    this.revivePopupFrame = {
      node: this.revivePanel,
      width,
      height,
      oldWidth: REVIVE_OLD_WIDTH,
      oldHeight: REVIVE_OLD_HEIGHT,
    };
    this.applyOldPopupFrame(this.revivePopupFrame);
    this.addOldPopupTitle(this.revivePanel, GAME_TEXT.panel.revive, REVIVE_OLD_WIDTH, REVIVE_OLD_HEIGHT, REVIVE_UI_SCALE);
    this.addOldPanelLabel(this.revivePanel, GAME_TEXT.revive.message, REVIVE_OLD_WIDTH, REVIVE_OLD_HEIGHT, REVIVE_UI_SCALE, REVIVE_OLD_WIDTH / 2, 48, 136, 'center');

    const reviveButton = this.createOldUiButton(this.revivePanel, 'ReviveConfirmButton', GAME_TEXT.ui.revive, () => this.reviveHero());
    reviveButton.setPosition(...this.oldPanelCenter(REVIVE_OLD_WIDTH, REVIVE_OLD_HEIGHT, REVIVE_UI_SCALE, 36, 76, OLD_UI_BUTTON_OLD_WIDTH, OLD_UI_BUTTON_OLD_HEIGHT), 0);
    const cancelButton = this.createOldUiButton(this.revivePanel, 'ReviveCancelButton', GAME_TEXT.ui.cancel, () => {
      this.revivePromptCooldown = REVIVE_PROMPT_HIDE_SECONDS;
      if (this.revivePanel) this.revivePanel.active = false;
    });
    cancelButton.setPosition(...this.oldPanelCenter(REVIVE_OLD_WIDTH, REVIVE_OLD_HEIGHT, REVIVE_UI_SCALE, 96, 76, OLD_UI_BUTTON_OLD_WIDTH, OLD_UI_BUTTON_OLD_HEIGHT), 0);
  }

  private createSkillUi() {
    if (!this.node.parent) return;
    this.skillButton = this.createMainMenuButton(this.node.parent, 'SkillButton', GAME_TEXT.ui.skill, () => {
      if (this.skillPanel) this.skillPanel.active = !this.skillPanel.active;
    });

    this.skillPanel = new Node('SkillPanel');
    this.skillPanel.parent = this.node.parent;
    this.skillPanel.active = false;
    this.skillPanel.addComponent(UITransform).setContentSize(SKILL_OLD_WIDTH * SKILL_UI_SCALE, SKILL_OLD_HEIGHT * SKILL_UI_SCALE);
    const bg = this.skillPanel.addComponent(Graphics);
    this.drawOldPopupBackground(bg, SKILL_OLD_WIDTH, SKILL_OLD_HEIGHT, SKILL_UI_SCALE);
    this.skillPopupFrame = {
      node: this.skillPanel,
      width: SKILL_OLD_WIDTH * SKILL_UI_SCALE,
      height: SKILL_OLD_HEIGHT * SKILL_UI_SCALE,
      oldWidth: SKILL_OLD_WIDTH,
      oldHeight: SKILL_OLD_HEIGHT,
    };
    this.applyOldPopupFrame(this.skillPopupFrame);
    this.addOldPopupTitle(this.skillPanel, GAME_TEXT.panel.skill, SKILL_OLD_WIDTH, SKILL_OLD_HEIGHT, SKILL_UI_SCALE);
    this.addOldPopupCloseButton(this.skillPanel, SKILL_OLD_WIDTH, SKILL_OLD_HEIGHT, SKILL_UI_SCALE, () => {
      if (this.skillPanel) this.skillPanel.active = false;
    });

    this.skillLabels.detail = this.addOldPanelLabel(this.skillPanel, '', SKILL_OLD_WIDTH, SKILL_OLD_HEIGHT, SKILL_UI_SCALE, 12, SKILL_DETAIL_OLD_Y, 196, 'left');
    this.skillRows = [];
    for (let i = 0; i < SKILL_ROW_COUNT; i++) this.skillRows.push(this.createSkillRow(i));
    this.renderSkillUi();
  }

  private createSkillRow(index: number): SkillRowView {
    const node = new Node(`SkillRow_${index}`);
    node.parent = this.skillPanel;
    node.setPosition(...this.oldPanelCenter(SKILL_OLD_WIDTH, SKILL_OLD_HEIGHT, SKILL_UI_SCALE, SKILL_LIST_MARGIN_X, SKILL_LIST_START_Y + index * SKILL_ROW_HEIGHT, SKILL_ROW_OLD_WIDTH, SKILL_ROW_HEIGHT - 2), 0);
    node.addComponent(UITransform).setContentSize(SKILL_ROW_OLD_WIDTH * SKILL_UI_SCALE, (SKILL_ROW_HEIGHT - 2) * SKILL_UI_SCALE);
    const bg = node.addComponent(Graphics);
    this.drawSkillRow(bg, false);

    const iconRoot = new Node(`SkillIcon_${index}`);
    iconRoot.parent = node;
    iconRoot.setPosition((-SKILL_ROW_OLD_WIDTH / 2 + SKILL_ICON_OLD_X + SKILL_SLOT_SIZE / 2) * SKILL_UI_SCALE, 0, 0);
    iconRoot.addComponent(UITransform).setContentSize(SKILL_SLOT_SIZE * SKILL_UI_SCALE, SKILL_SLOT_SIZE * SKILL_UI_SCALE);
    const iconBg = iconRoot.addComponent(Graphics);
    this.drawInventorySlot(iconBg, -1, false);

    const textX = (-SKILL_ROW_OLD_WIDTH / 2 + SKILL_TEXT_OLD_X) * SKILL_UI_SCALE;
    const name = this.addUiLabel(node, '', textX, 6, OLD_UI_BUTTON_FONT_SIZE, OLD_UI_BODY_TEXT_COLOR, 'left');
    this.alignLeftLabelBox(name, SKILL_TEXT_OLD_WIDTH * SKILL_UI_SCALE, 13 * SKILL_UI_SCALE);
    const meta = this.addUiLabel(node, '', textX, -8, OLD_UI_BUTTON_FONT_SIZE, OLD_UI_BUTTON_TEXT_COLOR, 'left');
    this.alignLeftLabelBox(meta, SKILL_TEXT_OLD_WIDTH * SKILL_UI_SCALE, 13 * SKILL_UI_SCALE);

    node.on(Node.EventType.TOUCH_END, () => {
      const instance = this.learnedSkills[index];
      if (!instance) return;
      this.selectedSkillId = instance.skill.id;
      this.renderSkillUi();
    });
    return { node, bg, iconRoot, name, meta };
  }

  private drawSkillRow(g: Graphics, selected: boolean) {
    const width = SKILL_ROW_OLD_WIDTH * SKILL_UI_SCALE;
    const height = (SKILL_ROW_HEIGHT - 2) * SKILL_UI_SCALE;
    g.clear();
    g.fillColor = selected ? new Color(28, 44, 50, 210) : new Color(8, 10, 12, 120);
    g.rect(-width / 2, -height / 2, width, height);
    g.fill();
    g.strokeColor = selected ? OLD_UI_TITLE_TEXT_COLOR : new Color(120, 112, 92, 180);
    g.lineWidth = 1;
    g.rect(-width / 2, -height / 2, width, height);
    g.stroke();
  }

  private loadSkillCatalog() {
    resources.load('skills/skill_catalog', JsonAsset, (err, asset) => {
      if (err || !asset) return;
      const catalog = asset.json as SkillCatalog;
      const skills = (catalog.skills ?? []).map((skill) => this.normalizeSkill(skill));
      const byId: Record<number, SkillCatalogItem> = {};
      for (const skill of skills) byId[skill.id] = skill;
      this.skillCatalog = skills;
      this.skillById = byId;
      this.loadSkillAssetsForCatalog();
      if (this.pendingSavedSkills) this.applyPersistedSkillState(this.pendingSavedSkills);
      else this.initializeLearnedSkills();
      this.renderSkillUi();
    });
  }

  private normalizeSkill(skill: SkillCatalogItem): SkillCatalogItem {
    const normalized: SkillCatalogItem = {
      ...skill,
      id: this.toNumber(skill.id, 0),
      race: this.toNumber(skill.race, 0),
      group: this.toNumber(skill.group, 0),
      level: this.toNumber(skill.level, 1),
      icon: this.toNumber(skill.icon, 0),
      flyerType: this.toNumber(skill.flyerType, 0),
      projectileFrameCount: this.toNumber(skill.projectileFrameCount, 0),
      animation: this.toNumber(skill.animation, 0),
      effectFrameCount: this.toNumber(skill.effectFrameCount, 0),
      timeLast: this.toNumber(skill.timeLast, 0),
      releaseRange: this.toNumber(skill.releaseRange, 1),
      maxExperience: this.toNumber(skill.maxExperience, 0),
      requiredLevel: this.toNumber(skill.requiredLevel, 0),
      nextLevelSkillId: this.toNumber(skill.nextLevelSkillId, 0),
      manaCost: this.toNumber(skill.manaCost, 0),
      minDamage: this.toNumber(skill.minDamage, 0),
      maxDamage: this.toNumber(skill.maxDamage, 0),
      selfCoolTime: this.toNumber(skill.selfCoolTime, 0),
      globalCoolTime: this.toNumber(skill.globalCoolTime, 0),
      damageType: this.toNumber(skill.damageType, 0),
      strengthFactor: this.toNumber(skill.strengthFactor, 0),
      wisdomFactor: this.toNumber(skill.wisdomFactor, 0),
      dexterityFactor: this.toNumber(skill.dexterityFactor, 0),
      selfPhysicalDamageFactor: this.toNumber(skill.selfPhysicalDamageFactor, 0),
      selfMagicDamageFactor: this.toNumber(skill.selfMagicDamageFactor, 0),
      name: `${skill.name ?? ''}`,
      type: (skill.type === 'state' || skill.type === 'scene') ? skill.type : 'damage',
      iconPath: `${skill.iconPath ?? ''}`,
      projectilePath: `${skill.projectilePath ?? ''}`,
      effectPath: `${skill.effectPath ?? ''}`,
      description: `${skill.description ?? ''}`,
    };
    if (
      normalized.type === 'damage' &&
      normalized.race === DEFAULT_HERO_RACE &&
      normalized.flyerType === RANGER_ARROW_FLYER_TYPE
    ) {
      return {
        ...normalized,
        projectilePath: RANGER_ARROW_PROJECTILE_PATH,
        projectileFrameCount: RANGER_ARROW_PROJECTILE_FRAME_COUNT,
      };
    }
    return normalized;
  }

  private loadSkillAssetsForCatalog() {
    const iconPaths = new Set<string>();
    this.loadSkillFrameSet(RANGER_ARROW_PROJECTILE_PATH, RANGER_ARROW_PROJECTILE_FRAME_COUNT);
    for (const skill of this.skillCatalog) {
      if (skill.iconPath) iconPaths.add(skill.iconPath);
      this.loadSkillFrameSet(skill.projectilePath, skill.projectileFrameCount);
      this.loadSkillFrameSet(skill.effectPath, skill.effectFrameCount);
    }
    for (const path of iconPaths) {
      resources.load(`${path}/spriteFrame`, SpriteFrame, (err, frame) => {
        if (err || !frame) return;
        this.skillIconFrames[path] = frame;
        this.renderSkillUi();
      });
    }
  }

  private loadSkillFrameSet(prefix: string, count: number) {
    if (!prefix || count <= 0 || this.requestedSkillFrames[prefix]) return;
    this.requestedSkillFrames[prefix] = true;
    const paths = Array.from({ length: count }, (_, i) => `${prefix}${i < 10 ? '0' : ''}${i}/spriteFrame`);
    resources.load(paths, SpriteFrame, (err, frames) => {
      if (!err && frames?.length) this.skillFrames[prefix] = frames;
    });
  }

  private initializeLearnedSkills() {
    const race = this.currentHeroRace();
    const preferredIds = this.skillCatalog
      .filter((skill) => this.isHeroLearnableSkill(skill, race))
      .sort((a, b) => a.requiredLevel - b.requiredLevel || a.id - b.id);
    this.learnedSkills = preferredIds.map((skill) => ({ skill, experience: 0, cooldown: 0 }));
    if (this.learnedSkills.length && !this.learnedSkills.some((instance) => instance.skill.id === this.selectedSkillId)) {
      this.selectedSkillId = this.learnedSkills[0].skill.id;
    }
  }

  private isHeroLearnableSkill(skill: SkillCatalogItem, race = this.currentHeroRace()) {
    return skill.race === race && skill.level === 1 && (skill.type === 'damage' || skill.type === 'state' || skill.type === 'scene');
  }

  private renderSkillUi() {
    for (let i = 0; i < this.skillRows.length; i++) {
      const row = this.skillRows[i];
      const instance = this.learnedSkills[i] ?? null;
      row.node.active = !!instance;
      if (!instance) continue;
      const selected = instance.skill.id === this.selectedSkillId;
      this.drawSkillRow(row.bg, selected);
      row.iconRoot.removeAllChildren();
      const iconBg = row.iconRoot.getComponent(Graphics) ?? row.iconRoot.addComponent(Graphics);
      this.drawInventorySlot(iconBg, -1, false);
      const icon = this.skillIconFrames[instance.skill.iconPath];
      if (icon) {
        const iconNode = new Node(`SkillIconFrame_${instance.skill.id}`);
        iconNode.parent = row.iconRoot;
        iconNode.addComponent(UITransform).setContentSize(SKILL_SLOT_SIZE * SKILL_UI_SCALE, SKILL_SLOT_SIZE * SKILL_UI_SCALE);
        const sprite = iconNode.addComponent(Sprite);
        sprite.sizeMode = Sprite.SizeMode.CUSTOM;
        sprite.spriteFrame = icon;
      }
      row.name.string = `${instance.skill.name} Lv.${instance.skill.level}`;
      row.name.color = selected ? OLD_UI_TITLE_TEXT_COLOR : OLD_UI_BODY_TEXT_COLOR;
      const expMax = Math.max(0, instance.skill.maxExperience);
      const cd = instance.cooldown > 0 ? ` CD ${Math.ceil(instance.cooldown)}` : '';
      row.meta.string = expMax > 0 ? `${instance.experience}/${expMax}${cd}` : `${GAME_TEXT.skill.fullLevel}${cd}`;
    }
    const selected = this.selectedSkill();
    if (this.skillLabels.detail) {
      this.skillLabels.detail.string = selected
        ? `${selected.skill.name}  ${GAME_TEXT.skill.range}${selected.skill.releaseRange}  ${GAME_TEXT.skill.manaCost}${selected.skill.manaCost}`
        : GAME_TEXT.skill.noLearnedSkill;
    }
  }

  private initializeCompanions() {
    if (this.companionInitialized) return;
    this.companionBagSlots = Array.from({ length: COMPANION_BAG_SIZE }, () => null);
    this.activeCompanionSlots = Array.from({ length: COMPANION_ACTIVE_SIZE }, () => null);
    const names = GAME_TEXT.companion.defaultNames;
    DEFAULT_COMPANION_TYPES.forEach((type, index) => {
      this.companionBagSlots[index] = this.createCompanionInstance(
        index + 1,
        names[index] ?? formatGameText(GAME_TEXT.companion.fallbackName, { index: index + 1 }),
        type,
        index,
      );
    });
    this.companionInitialized = true;
  }

  private createCompanionInstance(id: number, name: string, type: string, index = 0): CompanionInstance {
    return {
      uid: `companion:${id}:${Date.now()}:${Math.random().toString(36).slice(2)}`,
      id,
      name,
      type,
      level: Math.max(1, this.heroLevel),
      maxHp: 120 + index * 20,
      attack: 12 + index * 3,
      defense: 2 + index,
      quality: Math.min(5, Math.floor(index / 1.2)),
      description: GAME_TEXT.companion.temporaryDescription,
    };
  }

  private createCompanionUi() {
    if (!this.node.parent) return;
    const parent = this.node.parent;
    const panelWidth = COMPANION_OLD_WIDTH * COMPANION_UI_SCALE;
    const panelHeight = COMPANION_OLD_HEIGHT * COMPANION_UI_SCALE;

    this.companionButton = this.createMainMenuButton(parent, 'CompanionButton', GAME_TEXT.ui.companion, () => {
      if (!this.companionPanel) return;
      this.companionPanel.active = !this.companionPanel.active;
      this.renderCompanionUi();
    });

    this.companionPanel = new Node('CompanionPanel');
    this.companionPanel.parent = parent;
    this.companionPanel.active = false;
    this.companionPanel.addComponent(UITransform).setContentSize(panelWidth, panelHeight);
    const bg = this.companionPanel.addComponent(Graphics);
    this.drawOldPopupBackground(bg, COMPANION_OLD_WIDTH, COMPANION_OLD_HEIGHT, COMPANION_UI_SCALE);
    this.companionPopupFrame = {
      node: this.companionPanel,
      width: panelWidth,
      height: panelHeight,
      oldWidth: COMPANION_OLD_WIDTH,
      oldHeight: COMPANION_OLD_HEIGHT,
    };
    this.applyOldPopupFrame(this.companionPopupFrame);

    this.addOldPopupTitle(this.companionPanel, GAME_TEXT.panel.companion, COMPANION_OLD_WIDTH, COMPANION_OLD_HEIGHT, COMPANION_UI_SCALE);
    this.addOldPopupCloseButton(this.companionPanel, COMPANION_OLD_WIDTH, COMPANION_OLD_HEIGHT, COMPANION_UI_SCALE, () => {
      if (this.companionPanel) this.companionPanel.active = false;
      this.clearCompanionSelection();
    });

    const stage = new Node('CompanionPreviewStage');
    stage.parent = this.companionPanel;
    stage.setPosition(...this.oldPanelCenter(
      COMPANION_OLD_WIDTH,
      COMPANION_OLD_HEIGHT,
      COMPANION_UI_SCALE,
      COMPANION_STAGE_OLD_X,
      COMPANION_STAGE_OLD_Y,
      COMPANION_STAGE_OLD_WIDTH,
      COMPANION_STAGE_OLD_HEIGHT,
    ), 0);
    stage.addComponent(UITransform).setContentSize(COMPANION_STAGE_OLD_WIDTH * COMPANION_UI_SCALE, COMPANION_STAGE_OLD_HEIGHT * COMPANION_UI_SCALE);
    stage.addComponent(Graphics).clear();

    this.companionPreviewNode = new Node('CompanionLivePreview');
    this.companionPreviewNode.parent = this.companionPanel;
    this.companionPreviewNode.setPosition(...this.oldPanelCenter(
      COMPANION_OLD_WIDTH,
      COMPANION_OLD_HEIGHT,
      COMPANION_UI_SCALE,
      104,
      56,
      80,
      96,
    ), 0);
    this.companionPreviewNode.setScale(COMPANION_PREVIEW_SCALE, COMPANION_PREVIEW_SCALE, 1);
    this.companionPreviewTransform = this.companionPreviewNode.addComponent(UITransform);
    this.companionPreviewSprite = this.companionPreviewNode.addComponent(Sprite);
    this.companionPreviewSprite.sizeMode = Sprite.SizeMode.TRIMMED;

    this.companionLabels.previewName = this.addOldPanelLabel(
      this.companionPanel,
      '',
      COMPANION_OLD_WIDTH,
      COMPANION_OLD_HEIGHT,
      COMPANION_UI_SCALE,
      COMPANION_OLD_WIDTH / 2 - 45,
      COMPANION_GRID_START_Y - COMPANION_SECTION_DIVIDER_OLD_HEIGHT / 2,
      90,
      'center',
      OLD_UI_TITLE_TEXT_COLOR,
    );
    this.companionLabels.detail = this.addOldPanelLabel(
      this.companionPanel,
      '',
      COMPANION_OLD_WIDTH,
      COMPANION_OLD_HEIGHT,
      COMPANION_UI_SCALE,
      84,
      COMPANION_GRID_START_Y - COMPANION_SECTION_DIVIDER_OLD_HEIGHT / 2,
      120,
      'center',
      OLD_UI_BODY_TEXT_COLOR,
    );

    this.companionActiveViews = [];
    for (let i = 0; i < COMPANION_ACTIVE_SIZE; i++) {
      const layout = COMPANION_ACTIVE_SLOT_LAYOUT[i];
      const slot = this.createPanelSlotNode(this.companionPanel, `CompanionActive_${i}`, COMPANION_OLD_WIDTH, COMPANION_OLD_HEIGHT, COMPANION_UI_SCALE, layout.x, layout.y, i);
      slot.node.on(Node.EventType.TOUCH_END, () => this.openActiveCompanionDetail(i));
      this.companionActiveViews[i] = slot;
    }

    this.companionBagViews = [];
    for (let row = 0; row < COMPANION_BAG_ROWS; row++) {
      for (let col = 0; col < COMPANION_BAG_COLUMNS; col++) {
        const index = row * COMPANION_BAG_COLUMNS + col;
        const slot = this.createPanelSlotNode(
          this.companionPanel,
          `CompanionBag_${index}`,
          COMPANION_OLD_WIDTH,
          COMPANION_OLD_HEIGHT,
          COMPANION_UI_SCALE,
          COMPANION_GRID_START_X + col * INVENTORY_SLOT_SIZE,
          COMPANION_GRID_START_Y + row * INVENTORY_SLOT_SIZE,
          index,
        );
        slot.node.on(Node.EventType.TOUCH_END, () => this.openBagCompanionDetail(index));
        this.companionBagViews[index] = slot;
      }
    }

    this.createCompanionDetailUi();
    this.renderCompanionUi();
  }

  private createPanelSlotNode(parent: Node, name: string, oldPanelWidth: number, oldPanelHeight: number, scale: number, oldX: number, oldY: number, index: number): CompanionSlotView {
    const node = new Node(name);
    node.parent = parent;
    node.setPosition(...this.oldPanelCenter(oldPanelWidth, oldPanelHeight, scale, oldX, oldY, INVENTORY_ICON_SIZE, INVENTORY_ICON_SIZE), 0);
    node.addComponent(UITransform).setContentSize(INVENTORY_ICON_SIZE * scale, INVENTORY_ICON_SIZE * scale);
    const bg = node.addComponent(Graphics);
    return { node, bg, index, iconSize: INVENTORY_ICON_SIZE, uiScale: scale };
  }

  private createCompanionDetailUi() {
    if (!this.companionPanel) return;
    const width = COMPANION_DETAIL_OLD_WIDTH * COMPANION_UI_SCALE;
    const height = COMPANION_DETAIL_OLD_HEIGHT * COMPANION_UI_SCALE;
    this.companionDetailPanel = new Node('CompanionDetailPanel');
    this.companionDetailPanel.parent = this.companionPanel;
    this.companionDetailPanel.active = false;
    this.companionDetailPanel.setPosition(0, 0, 1);
    this.companionDetailPanel.addComponent(UITransform).setContentSize(width, height);
    const bg = this.companionDetailPanel.addComponent(Graphics);
    this.drawOldPopupBackground(bg, COMPANION_DETAIL_OLD_WIDTH, COMPANION_DETAIL_OLD_HEIGHT, COMPANION_UI_SCALE);
    this.companionDetailPopupFrame = {
      node: this.companionDetailPanel,
      width,
      height,
      oldWidth: COMPANION_DETAIL_OLD_WIDTH,
      oldHeight: COMPANION_DETAIL_OLD_HEIGHT,
    };
    this.applyOldPopupFrame(this.companionDetailPopupFrame);
    this.addOldPopupTitle(this.companionDetailPanel, GAME_TEXT.panel.companionDetail, COMPANION_DETAIL_OLD_WIDTH, COMPANION_DETAIL_OLD_HEIGHT, COMPANION_UI_SCALE);
    this.addOldPopupCloseButton(this.companionDetailPanel, COMPANION_DETAIL_OLD_WIDTH, COMPANION_DETAIL_OLD_HEIGHT, COMPANION_UI_SCALE, () => this.clearCompanionSelection());

    const iconSlot = new Node('CompanionDetailIconSlot');
    iconSlot.parent = this.companionDetailPanel;
    iconSlot.setPosition(...this.oldPanelCenter(COMPANION_DETAIL_OLD_WIDTH, COMPANION_DETAIL_OLD_HEIGHT, COMPANION_UI_SCALE, 15, 40, INVENTORY_ICON_SIZE, INVENTORY_ICON_SIZE), 0);
    iconSlot.addComponent(UITransform).setContentSize(INVENTORY_ICON_SIZE * COMPANION_UI_SCALE, INVENTORY_ICON_SIZE * COMPANION_UI_SCALE);
    const iconBg = iconSlot.addComponent(Graphics);
    this.drawInventorySlot(iconBg, -1, false);
    this.companionDetailIconRoot = iconSlot;

    this.companionDetailLabels.name = this.addOldPanelLabel(this.companionDetailPanel, '', COMPANION_DETAIL_OLD_WIDTH, COMPANION_DETAIL_OLD_HEIGHT, COMPANION_UI_SCALE, 48, 45, 126, 'left', OLD_UI_TITLE_TEXT_COLOR);
    this.companionDetailLabels.meta = this.addOldPanelLabel(this.companionDetailPanel, '', COMPANION_DETAIL_OLD_WIDTH, COMPANION_DETAIL_OLD_HEIGHT, COMPANION_UI_SCALE, 48, 63, 126, 'left');
    this.companionDetailLabels.stat0 = this.addOldPanelLabel(this.companionDetailPanel, '', COMPANION_DETAIL_OLD_WIDTH, COMPANION_DETAIL_OLD_HEIGHT, COMPANION_UI_SCALE, 15, 92, 155, 'left');
    this.companionDetailLabels.stat1 = this.addOldPanelLabel(this.companionDetailPanel, '', COMPANION_DETAIL_OLD_WIDTH, COMPANION_DETAIL_OLD_HEIGHT, COMPANION_UI_SCALE, 15, 108, 155, 'left');
    this.companionDetailLabels.stat2 = this.addOldPanelLabel(this.companionDetailPanel, '', COMPANION_DETAIL_OLD_WIDTH, COMPANION_DETAIL_OLD_HEIGHT, COMPANION_UI_SCALE, 15, 124, 155, 'left');

    this.companionDetailActionButton = this.createOldUiButton(this.companionDetailPanel, 'CompanionDetailAction', GAME_TEXT.ui.deploy, () => this.toggleSelectedCompanionBattle());
    this.companionDetailActionButton.setPosition(...this.oldPanelCenter(COMPANION_DETAIL_OLD_WIDTH, COMPANION_DETAIL_OLD_HEIGHT, COMPANION_UI_SCALE, 68, COMPANION_DETAIL_OLD_HEIGHT - COMPANION_DETAIL_BUTTON_BOTTOM_GAP, OLD_UI_BUTTON_OLD_WIDTH, OLD_UI_BUTTON_OLD_HEIGHT), 0);
  }

  private renderCompanionUi() {
    if (!this.companionPanel) return;
    this.syncSelectedCompanion();
    for (let i = 0; i < this.companionActiveViews.length; i++) {
      this.renderCompanionSlot(this.companionActiveViews[i], this.activeCompanionSlots[i], true);
    }
    for (let i = 0; i < this.companionBagViews.length; i++) {
      this.renderCompanionSlot(this.companionBagViews[i], this.companionBagSlots[i], false);
    }
    const preview = this.selectedCompanion?.instance ?? this.activeCompanionSlots.find((item): item is CompanionInstance => !!item) ?? null;
    this.renderCompanionPreview(preview);
    if (this.companionLabels.previewName) this.companionLabels.previewName.string = preview ? `${preview.name} Lv.${preview.level}` : GAME_TEXT.companion.previewFallback;
    if (this.companionLabels.detail && !this.selectedCompanion) this.companionLabels.detail.string = GAME_TEXT.companion.selectToView;
    this.renderCompanionDetailUi();
  }

  private renderCompanionSlot(view: CompanionSlotView | undefined, instance: CompanionInstance | null, active: boolean) {
    if (!view) return;
    view.node.removeAllChildren();
    this.drawInventorySlot(view.bg, instance?.quality ?? -1, active);
    if (!instance) return;
    this.addCompanionIcon(view.node, instance);
  }

  private addCompanionIcon(parent: Node, instance: CompanionInstance) {
    const frame = this.companionIconFrame(instance);
    const size = INVENTORY_ICON_SIZE * COMPANION_UI_SCALE;
    if (!frame) {
      const fallback = new Node(`CompanionFallback_${instance.id}`);
      parent.addChild(fallback);
      fallback.addComponent(UITransform).setContentSize(size - 2, size - 2);
      const g = fallback.addComponent(Graphics);
      g.fillColor = this.qualityColor(instance.quality, 180);
      g.rect(-(size - 2) / 2, -(size - 2) / 2, size - 2, size - 2);
      g.fill();
      this.addUiLabel(fallback, `${instance.id}`, 0, -4, 8, Color.WHITE);
      return;
    }
    const icon = new Node(`CompanionIcon_${instance.id}`);
    parent.addChild(icon);
    icon.addComponent(UITransform).setContentSize(size, size);
    const sprite = icon.addComponent(Sprite);
    sprite.sizeMode = Sprite.SizeMode.CUSTOM;
    sprite.spriteFrame = frame;
  }

  private companionIconFrame(instance: CompanionInstance) {
    return this.monsterClips[this.monsterClip(instance.type, 'idle', 0)]?.[0] ?? this.monsterFrames[instance.type] ?? null;
  }

  private renderCompanionPreview(instance: CompanionInstance | null) {
    if (!this.companionPreviewNode || !this.companionPreviewSprite || !this.companionPreviewTransform) return;
    const frame = instance ? this.companionPreviewFrames(instance)[this.companionPreviewFrame % Math.max(1, this.companionPreviewFrames(instance).length)] : null;
    this.companionPreviewNode.active = !!frame;
    if (!frame || !instance) return;
    this.applyMonsterFrame(instance.type, this.companionPreviewSprite, this.companionPreviewTransform, frame, this.companionPreviewNode);
  }

  private companionPreviewFrames(instance: CompanionInstance) {
    return this.monsterClips[this.monsterClip(instance.type, 'idle', 4)]
      ?? this.monsterClips[this.monsterClip(instance.type, 'idle', 0)]
      ?? [];
  }

  private playCompanionPreview(dt: number) {
    const preview = this.selectedCompanion?.instance ?? this.activeCompanionSlots.find((item): item is CompanionInstance => !!item) ?? null;
    if (!preview) return;
    const frames = this.companionPreviewFrames(preview);
    if (frames.length < 2) return;
    this.companionPreviewTime += dt;
    if (this.companionPreviewTime < MONSTER_FRAME_INTERVAL) return;
    this.companionPreviewTime = 0;
    this.companionPreviewFrame = (this.companionPreviewFrame + 1) % frames.length;
    this.renderCompanionPreview(preview);
  }

  private openBagCompanionDetail(index: number) {
    const instance = this.companionBagSlots[index];
    if (!instance) {
      this.clearCompanionSelection();
      this.renderCompanionUi();
      return;
    }
    this.selectedCompanion = { source: 'bag', instance, bagIndex: index };
    this.showCompanionDetail();
    this.renderCompanionUi();
  }

  private openActiveCompanionDetail(index: number) {
    const instance = this.activeCompanionSlots[index];
    if (!instance) {
      this.clearCompanionSelection();
      this.renderCompanionUi();
      return;
    }
    this.selectedCompanion = { source: 'active', instance, activeIndex: index };
    this.showCompanionDetail();
    this.renderCompanionUi();
  }

  private showCompanionDetail() {
    if (this.companionDetailPanel) this.companionDetailPanel.active = true;
  }

  private clearCompanionSelection() {
    this.selectedCompanion = null;
    if (this.companionDetailPanel) this.companionDetailPanel.active = false;
    this.renderCompanionUi();
  }

  private syncSelectedCompanion() {
    if (!this.selectedCompanion) return;
    const instance = this.selectedCompanion.instance;
    const bagIndex = this.companionBagSlots.indexOf(instance);
    const activeIndex = this.activeCompanionSlots.indexOf(instance);
    if (this.selectedCompanion.source === 'bag' && bagIndex >= 0) {
      this.selectedCompanion = { source: 'bag', instance, bagIndex };
      return;
    }
    if (this.selectedCompanion.source === 'active' && activeIndex >= 0) {
      this.selectedCompanion = { source: 'active', instance, activeIndex };
      return;
    }
    if (activeIndex >= 0) {
      this.selectedCompanion = { source: 'active', instance, activeIndex };
      return;
    }
    if (bagIndex >= 0) {
      this.selectedCompanion = { source: 'bag', instance, bagIndex };
      return;
    }
    this.selectedCompanion = null;
  }

  private renderCompanionDetailUi() {
    if (!this.companionDetailPanel || !this.companionDetailPanel.active) return;
    this.syncSelectedCompanion();
    if (!this.selectedCompanion) return;
    const instance = this.selectedCompanion.instance;
    if (this.companionDetailIconRoot) {
      this.companionDetailIconRoot.removeAllChildren();
      const bg = this.companionDetailIconRoot.getComponent(Graphics);
      if (bg) this.drawInventorySlot(bg, instance.quality, this.selectedCompanion.source === 'active');
      this.addCompanionIcon(this.companionDetailIconRoot, instance);
    }
    this.setCompanionDetailLabel('name', instance.name, OLD_UI_TITLE_TEXT_COLOR);
    this.setCompanionDetailLabel('meta', `${this.selectedCompanion.source === 'active' ? GAME_TEXT.companion.active : GAME_TEXT.companion.bag}  Lv.${instance.level}`);
    this.setCompanionDetailLabel('stat0', `${GAME_TEXT.companion.hp}  ${instance.maxHp}    ${GAME_TEXT.companion.defense}  ${instance.defense}`);
    this.setCompanionDetailLabel('stat1', `${GAME_TEXT.companion.attack}  ${instance.attack}    ${GAME_TEXT.companion.range}  ${COMPANION_ATTACK_RANGE}`);
    this.setCompanionDetailLabel('stat2', instance.description);
    this.setOldUiButtonText(this.companionDetailActionButton, this.selectedCompanion.source === 'active' ? GAME_TEXT.ui.recall : GAME_TEXT.ui.deploy);
    if (this.companionLabels.detail) {
      this.companionLabels.detail.string = this.selectedCompanion.source === 'active' ? GAME_TEXT.companion.deployed : GAME_TEXT.companion.clickToDeploy;
    }
  }

  private setCompanionDetailLabel(key: string, text: string, color?: Color) {
    const label = this.companionDetailLabels[key];
    if (!label) return;
    label.string = text;
    label.color = color ?? OLD_UI_BODY_TEXT_COLOR;
  }

  private toggleSelectedCompanionBattle() {
    this.syncSelectedCompanion();
    if (!this.selectedCompanion) return;
    if (this.selectedCompanion.source === 'active') this.recallSelectedCompanion();
    else this.deploySelectedCompanion();
  }

  private deploySelectedCompanion() {
    if (!this.selectedCompanion || this.selectedCompanion.source !== 'bag') return;
    const activeIndex = this.activeCompanionSlots.findIndex((item) => item === null);
    if (activeIndex < 0) {
      if (this.companionLabels.detail) this.companionLabels.detail.string = GAME_TEXT.companion.activeFull;
      return;
    }
    const { instance, bagIndex } = this.selectedCompanion;
    this.companionBagSlots[bagIndex] = null;
    this.activeCompanionSlots[activeIndex] = instance;
    this.selectedCompanion = { source: 'active', instance, activeIndex };
    this.syncCompanionActors();
    this.showCompanionDetail();
    this.renderCompanionUi();
  }

  private recallSelectedCompanion() {
    if (!this.selectedCompanion || this.selectedCompanion.source !== 'active') return;
    const bagIndex = this.companionBagSlots.findIndex((item) => item === null);
    if (bagIndex < 0) {
      if (this.companionLabels.detail) this.companionLabels.detail.string = GAME_TEXT.companion.bagFull;
      return;
    }
    const { instance, activeIndex } = this.selectedCompanion;
    this.activeCompanionSlots[activeIndex] = null;
    this.companionBagSlots[bagIndex] = instance;
    this.destroyCompanionActor(instance);
    this.selectedCompanion = { source: 'bag', instance, bagIndex };
    this.showCompanionDetail();
    this.renderCompanionUi();
  }

  private syncCompanionActors() {
    if (!this.node.parent) return;
    const activeUids = new Set(this.activeCompanionSlots.filter((item): item is CompanionInstance => !!item).map((item) => item.uid));
    for (const actor of [...this.companionActors]) {
      if (!activeUids.has(actor.instance.uid) || !actor.node.isValid) {
        actor.node.destroy();
        this.companionActors = this.companionActors.filter((item) => item !== actor);
      }
    }
    for (let i = 0; i < this.activeCompanionSlots.length; i++) {
      const instance = this.activeCompanionSlots[i];
      if (!instance) continue;
      const actor = this.companionActors.find((item) => item.instance === instance);
      if (actor) {
        actor.activeIndex = i;
        continue;
      }
      const created = this.createCompanionActor(instance, i);
      if (created) this.companionActors.push(created);
    }
  }

  private createCompanionActor(instance: CompanionInstance, activeIndex: number) {
    if (!this.node.parent) return null;
    const frame = this.companionIconFrame(instance);
    if (!frame) return null;
    const node = new Node('CompanionActor');
    node.parent = this.node.parent;
    const start = this.findCompanionFollowPoint(activeIndex);
    node.setPosition(start.x, start.y, 0);
    const visualNode = this.usesOffsetAlignedMonster(instance.type) ? new Node('CompanionVisual') : node;
    if (visualNode !== node) node.addChild(visualNode);
    const transform = visualNode.addComponent(UITransform);
    const sprite = visualNode.addComponent(Sprite);
    sprite.sizeMode = Sprite.SizeMode.TRIMMED;
    this.applyMonsterFrame(instance.type, sprite, transform, frame, visualNode);
    return {
      node,
      visualNode,
      instance,
      type: instance.type,
      sprite,
      transform,
      state: 'idle' as MonsterState,
      dir: 4,
      clip: this.monsterClip(instance.type, 'idle', 4),
      frame: 0,
      time: 0,
      activeIndex,
      target: null,
      attackCooldown: Math.random() * 0.3,
      attackActive: false,
      idleStepTimer: Math.random() * COMPANION_IDLE_STEP_INTERVAL,
      idleTarget: null,
    };
  }

  private destroyCompanionActor(instance: CompanionInstance) {
    const actor = this.companionActors.find((item) => item.instance === instance);
    if (!actor) return;
    actor.node.destroy();
    this.companionActors = this.companionActors.filter((item) => item !== actor);
  }

  private updateCompanions(dt: number) {
    this.syncCompanionActors();
    this.companionActors = this.companionActors.filter((actor) => actor.node.isValid);
    for (const actor of this.companionActors) {
      this.updateCompanionActor(actor, dt);
      this.playCompanionFrames(actor, dt);
    }
  }

  private updateCompanionActor(actor: CompanionActor, dt: number) {
    const heroDist = Vec3.distance(actor.node.position, this.node.position);
    if (heroDist > COMPANION_FOLLOW_SNAP_DISTANCE) {
      const point = this.findCompanionFollowPoint(actor.activeIndex);
      actor.node.setPosition(point.x, point.y, 0);
      this.setCompanionState(actor, 'idle');
      actor.target = null;
      actor.attackActive = false;
      actor.idleTarget = null;
      actor.idleStepTimer = COMPANION_IDLE_STEP_INTERVAL;
      return;
    }

    const target = this.preferredCompanionTarget(actor);
    if (target && target.node.isValid && target.currentHp > 0) {
      const targetDist = Vec3.distance(actor.node.position, target.node.position);
      const heroToTarget = Vec3.distance(this.node.position, target.node.position);
      const canAssist = heroToTarget <= COMPANION_ASSIST_TARGET_RANGE || target === this.attackTarget || target === this.target;
      if (canAssist && targetDist <= COMPANION_ATTACK_RANGE && this.canReachTarget(actor.node.position, target.node.position, targetDist, true)) {
        const dx = target.node.position.x - actor.node.position.x;
        const dy = target.node.position.y - actor.node.position.y;
        actor.dir = this.directionFrom(dx, dy);
        this.updateCompanionAttack(actor, target, dt);
        return;
      }
      if (canAssist && heroDist < COMPANION_FOLLOW_MAX_DISTANCE && targetDist > COMPANION_ATTACK_RANGE) {
        actor.attackActive = false;
        actor.idleTarget = null;
        actor.idleStepTimer = COMPANION_IDLE_STEP_INTERVAL;
        if (this.moveCompanion(actor, target.node.position, dt)) {
          this.setCompanionState(actor, 'chase');
          return;
        }
      }
    }

    actor.attackActive = false;
    actor.target = null;
    this.updateCompanionIdle(actor, heroDist, dt);
  }

  private updateCompanionIdle(actor: CompanionActor, heroDist: number, dt: number) {
    if (heroDist > COMPANION_FOLLOW_MAX_DISTANCE) {
      const follow = this.findCompanionFollowPoint(actor.activeIndex);
      actor.idleTarget = null;
      actor.idleStepTimer = COMPANION_IDLE_STEP_INTERVAL;
      if (Vec3.distance(actor.node.position, follow) > COMPANION_FOLLOW_NEAR_DISTANCE && this.moveCompanion(actor, follow, dt)) {
        this.setCompanionState(actor, 'walk');
      } else {
        this.setCompanionState(actor, 'idle');
      }
      return;
    }

    if (actor.idleTarget) {
      if (Vec3.distance(actor.node.position, actor.idleTarget) > 4 && this.moveCompanion(actor, actor.idleTarget, dt)) {
        this.setCompanionState(actor, 'walk');
        return;
      }
      actor.idleTarget = null;
      actor.idleStepTimer = COMPANION_IDLE_STEP_INTERVAL;
    }

    actor.idleStepTimer -= dt;
    this.setCompanionState(actor, 'idle');
    if (actor.idleStepTimer > 0) return;

    actor.idleStepTimer = COMPANION_IDLE_STEP_INTERVAL;
    actor.idleTarget = this.findCompanionIdleStep(actor);
  }

  private findCompanionIdleStep(actor: CompanionActor) {
    const bounds = this.mapWorldBounds(30);
    let best: Vec3 | null = null;
    let bestScore = -Infinity;
    const baseAngle = Math.random() * Math.PI * 2;
    for (let i = 0; i < 8; i++) {
      const angle = baseAngle + (Math.PI * 2 * i) / 8;
      const x = this.clamp(actor.node.position.x + Math.cos(angle) * COMPANION_IDLE_STEP_DISTANCE, bounds.minX, bounds.maxX);
      const y = this.clamp(actor.node.position.y + Math.sin(angle) * COMPANION_IDLE_STEP_DISTANCE, bounds.minY, bounds.maxY);
      if (!this.canMonsterStandAt(x, y) || !this.isActorSpotFree(actor.node, x, y)) continue;
      const candidate = new Vec3(x, y, 0);
      if (Vec3.distance(candidate, this.node.position) > COMPANION_IDLE_MAX_HERO_DISTANCE) continue;
      const score = this.companionIdleStepScore(actor, candidate);
      if (score > bestScore) {
        bestScore = score;
        best = candidate;
      }
    }
    return best;
  }

  private companionIdleStepScore(actor: CompanionActor, point: Readonly<Vec3>) {
    let nearestActorDistance = Vec3.distance(point, this.node.position);
    for (const companion of this.companionActors) {
      if (!companion.node.isValid || companion === actor) continue;
      nearestActorDistance = Math.min(nearestActorDistance, Vec3.distance(point, companion.node.position));
    }
    const home = this.findCompanionFormationPoint(actor.activeIndex);
    const homeDistance = Vec3.distance(point, home);
    return nearestActorDistance - homeDistance * 0.15 + Math.random() * 0.25;
  }

  private findCompanionFormationPoint(activeIndex: number) {
    const offset = COMPANION_FORMATION_OFFSETS[activeIndex % COMPANION_FORMATION_OFFSETS.length] ?? [0, -48];
    return new Vec3(this.node.position.x + offset[0], this.node.position.y + offset[1], 0);
  }

  private preferredCompanionTarget(actor: CompanionActor) {
    let best: MonsterActor | null = null;
    let bestDist = Infinity;
    const heroTargets = [this.attackTarget, this.target].filter((monster): monster is MonsterActor => !!monster && monster.node.isValid && monster.currentHp > 0);
    for (const monster of this.monsters) {
      if (!monster.node.isValid || monster.currentHp <= 0) continue;
      if (heroTargets.indexOf(monster) >= 0) continue;
      const heroDist = Vec3.distance(this.node.position, monster.node.position);
      const actorDist = Vec3.distance(actor.node.position, monster.node.position);
      if (heroDist > COMPANION_ASSIST_TARGET_RANGE && actorDist > COMPANION_ATTACK_RANGE) continue;
      if (actorDist < bestDist) {
        bestDist = actorDist;
        best = monster;
      }
    }
    return best ?? heroTargets[0] ?? null;
  }

  private moveCompanion(actor: CompanionActor, target: Readonly<Vec3>, dt: number) {
    const move = this.moveToward(actor.node, target, COMPANION_MOVE_SPEED, dt, true);
    if (!move) return false;
    actor.dir = this.directionFrom(move.lastMoveX, move.lastMoveY);
    return true;
  }

  private findCompanionFollowPoint(activeIndex: number) {
    const target = this.findCompanionFormationPoint(activeIndex);
    if (this.canMonsterStandAt(target.x, target.y) && this.isActorSpotFree(null, target.x, target.y)) return target;
    return this.findFreePointAround(this.node.position, 30, 120) ?? this.node.position.clone();
  }

  private updateCompanionAttack(actor: CompanionActor, target: MonsterActor, dt: number) {
    actor.idleTarget = null;
    actor.idleStepTimer = COMPANION_IDLE_STEP_INTERVAL;
    actor.target = target;
    if (!actor.attackActive) {
      actor.attackCooldown -= dt;
      if (actor.attackCooldown > 0) {
        this.setCompanionState(actor, 'idle');
        return;
      }
      const attackClip = this.monsterClip(actor.type, 'attack', actor.dir);
      const attackFrames = this.monsterClips[attackClip] ?? [];
      if (attackFrames.length < 2) {
        this.damageMonsterFromCompanion(actor, target);
        actor.attackCooldown = COMPANION_ATTACK_INTERVAL;
        return;
      }
      actor.attackActive = true;
      this.setCompanionState(actor, 'attack');
      actor.frame = 0;
      actor.time = 0;
      this.setCompanionFrame(actor, 0);
    }
  }

  private damageMonsterFromCompanion(actor: CompanionActor, target: MonsterActor | null) {
    if (!target?.node.isValid || target.currentHp <= 0) return;
    const position = new Vec3(target.node.position.x, target.node.position.y, 0);
    const actual = this.applyHeroDamageToMonster(target, actor.instance.attack);
    if (actual > 0) this.spawnDamageNumber(actual, position);
  }

  private setCompanionState(actor: CompanionActor, state: MonsterState) {
    const action = state === 'chase' ? 'walk' : state;
    const clip = this.monsterClip(actor.type, action, actor.dir);
    if (actor.clip === clip || !this.monsterClips[clip]?.length) {
      actor.state = state;
      return;
    }
    actor.state = state;
    actor.clip = clip;
    actor.frame = 0;
    actor.time = 0;
    this.setCompanionFrame(actor, 0);
  }

  private playCompanionFrames(actor: CompanionActor, dt: number) {
    const frames = this.monsterClips[actor.clip] ?? [];
    if (frames.length < 2) return;
    actor.time += dt;
    const isAttack = actor.clip.startsWith(`${actor.type}:attack`);
    const isMove = actor.state === 'walk' || actor.state === 'chase';
    const interval = isAttack
      ? MONSTER_ATTACK_FRAME_INTERVAL
      : isMove
        ? COMPANION_WALK_FRAME_INTERVAL
        : COMPANION_IDLE_FRAME_INTERVAL;
    if (actor.time < interval) return;
    actor.time = 0;
    if (isAttack && actor.frame >= frames.length - 1) {
      this.damageMonsterFromCompanion(actor, actor.target);
      actor.attackActive = false;
      actor.attackCooldown = COMPANION_ATTACK_INTERVAL;
      this.setCompanionState(actor, 'idle');
      return;
    }
    actor.frame = (actor.frame + 1) % frames.length;
    this.setCompanionFrame(actor, actor.frame);
  }

  private setCompanionFrame(actor: CompanionActor, index: number) {
    const frame = this.monsterClips[actor.clip]?.[index];
    if (frame) this.applyMonsterFrame(actor.type, actor.sprite, actor.transform, frame, actor.visualNode);
  }

  private toggleAutoBattle() {
    if (this.heroDead) {
      this.autoBattleEnabled = false;
      this.refreshAutoBattleButton();
      this.showRevivePrompt();
      return;
    }
    this.autoBattleEnabled = !this.autoBattleEnabled;
    this.refreshAutoBattleButton();
    if (!this.autoBattleEnabled) this.stopHeroAutoBattle();
  }

  private refreshAutoBattleButton() {
    this.setOldUiButtonText(this.autoBattleButton, this.autoBattleEnabled ? GAME_TEXT.ui.stopBattleShort : GAME_TEXT.ui.autoBattleShort);
  }

  private stopHeroAutoBattle() {
    this.target = null;
    this.attackTarget = null;
    this.attackSkill = null;
    this.attackTime = -1;
    this.resetTargetProgress();
    if (this.heroDead) this.setHeroDeathClip();
    else this.setHeroIdleClip();
  }

  private selectedSkill() {
    return this.learnedSkills.find((instance) => instance.skill.id === this.selectedSkillId) ?? this.learnedSkills[0] ?? null;
  }

  private pickReadySkill(monster: MonsterActor) {
    const selected = this.selectedSkill();
    const candidates = selected?.skill.type === 'damage'
      ? [selected, ...this.learnedSkills.filter((instance) => instance !== selected && instance.skill.type === 'damage')]
      : this.learnedSkills.filter((instance) => instance.skill.type === 'damage');
    const dx = monster.node.position.x - this.node.position.x;
    const dy = monster.node.position.y - this.node.position.y;
    const dist = Math.sqrt(dx * dx + dy * dy);
    return candidates.find((instance) => {
      if (instance.cooldown > 0) return false;
      if (this.heroCurrentMana < instance.skill.manaCost) return false;
      return dist <= this.skillAttackRange(instance.skill);
    }) ?? null;
  }

  private skillAttackRange(skill: SkillCatalogItem) {
    const oldRange = Math.max(1, this.toNumber(skill.releaseRange, 1));
    return this.clamp(oldRange * SKILL_RANGE_UNIT, HERO_MELEE_ATTACK_RANGE, this.heroMaxVisibleAttackRange());
  }

  private skillCooldownSeconds(skill: SkillCatalogItem) {
    const extra = Math.max(0, skill.selfCoolTime + skill.globalCoolTime);
    if (extra <= 0) return this.heroAttackAnimationDuration();
    return Math.max(this.heroAttackAnimationDuration(), extra / 1000);
  }

  private rollSkillDamage(skill: SkillCatalogItem, normalDamage: number) {
    const min = Math.min(skill.minDamage, skill.maxDamage);
    const max = Math.max(skill.minDamage, skill.maxDamage);
    const base = this.rollRange(min, max);
    const stats = this.heroDerivedStats();
    const physical = this.rollRange(stats.minPhysicalDamage, stats.maxPhysicalDamage);
    const magic = this.rollRange(stats.minMagicDamage, stats.maxMagicDamage);
    const scaled =
      base +
      Math.floor((this.heroStrength * skill.strengthFactor) / 100) +
      Math.floor((this.heroWisdom * skill.wisdomFactor) / 100) +
      Math.floor((this.heroDexterity * skill.dexterityFactor) / 100) +
      Math.floor((physical * skill.selfPhysicalDamageFactor) / 100) +
      Math.floor((magic * skill.selfMagicDamageFactor) / 100);
    return Math.max(1, scaled || normalDamage);
  }

  private gainSkillExperience(instance: SkillInstance) {
    const maxExperience = Math.max(0, instance.skill.maxExperience);
    if (maxExperience <= 0 || instance.skill.nextLevelSkillId <= 0) return;
    instance.experience += SKILL_DEFAULT_EXP_GAIN;
    this.queueSaveGameProgress();
    if (instance.experience < maxExperience) return;
    const next = this.skillById[instance.skill.nextLevelSkillId];
    if (!next || next.requiredLevel > this.heroLevel) {
      instance.experience = maxExperience;
      return;
    }
    instance.skill = next;
    instance.experience = 0;
    instance.cooldown = 0;
    this.selectedSkillId = next.id;
    this.loadSkillFrameSet(next.projectilePath, next.projectileFrameCount);
    this.loadSkillFrameSet(next.effectPath, next.effectFrameCount);
  }

  private updateSkillCooldowns(dt: number) {
    let changed = false;
    for (const instance of this.learnedSkills) {
      if (instance.cooldown <= 0) continue;
      instance.cooldown = Math.max(0, instance.cooldown - dt);
      changed = true;
    }
    if (changed && this.skillPanel?.active) this.renderSkillUi();
  }

  private spawnSkillProjectile(frames: SpriteFrame[], start: Readonly<Vec3>, end: Readonly<Vec3>, onFinish: () => void) {
    if (!frames.length || !this.node.parent) {
      onFinish();
      return;
    }
    const node = new Node('SkillProjectile');
    node.parent = this.node.parent;
    node.setPosition(start.x, start.y, 0);
    const transform = node.addComponent(UITransform);
    const sprite = node.addComponent(Sprite);
    this.applyFrame(sprite, transform, frames[0]);
    node.angle = (Math.atan2(end.y - start.y, end.x - start.x) * 180) / Math.PI;
    const dist = Vec3.distance(start, end);
    const duration = this.clamp(dist / SKILL_PROJECTILE_SPEED, SKILL_PROJECTILE_MIN_DURATION, SKILL_PROJECTILE_MAX_DURATION);
    this.skillEffects.push({
      node,
      sprite,
      transform,
      frames,
      time: 0,
      frame: 0,
      frameInterval: SKILL_EFFECT_FRAME_INTERVAL,
      elapsed: 0,
      duration,
      start: new Vec3(start.x, start.y, 0),
      end: new Vec3(end.x, end.y, 0),
      onFinish,
    });
  }

  private spawnSkillEffect(frames: SpriteFrame[], position: Readonly<Vec3>, duration: number) {
    if (!frames.length || !this.node.parent) return;
    const node = new Node('SkillImpactEffect');
    node.parent = this.node.parent;
    node.setPosition(position.x, position.y, 0);
    const transform = node.addComponent(UITransform);
    const sprite = node.addComponent(Sprite);
    this.applyFrame(sprite, transform, frames[0]);
    this.skillEffects.push({
      node,
      sprite,
      transform,
      frames,
      time: 0,
      frame: 0,
      frameInterval: SKILL_EFFECT_FRAME_INTERVAL,
      elapsed: 0,
      duration,
    });
  }

  private skillEffectDuration(skill: SkillCatalogItem, frameCount: number) {
    const configured = Math.max(0, skill.timeLast) / 1000;
    return configured > 0 ? configured : Math.max(0.18, frameCount * SKILL_EFFECT_FRAME_INTERVAL);
  }

  private updateSkillEffects(dt: number) {
    for (let i = this.skillEffects.length - 1; i >= 0; i--) {
      const effect = this.skillEffects[i];
      if (!effect.node.isValid) {
        this.skillEffects.splice(i, 1);
        continue;
      }
      effect.elapsed += dt;
      effect.time += dt;
      if (effect.start && effect.end) {
        const ratio = this.clamp(effect.elapsed / Math.max(0.001, effect.duration), 0, 1);
        effect.node.setPosition(
          effect.start.x + (effect.end.x - effect.start.x) * ratio,
          effect.start.y + (effect.end.y - effect.start.y) * ratio,
          0,
        );
      }
      if (effect.time >= effect.frameInterval && effect.frames.length > 1) {
        effect.time = 0;
        effect.frame = (effect.frame + 1) % effect.frames.length;
        this.applyFrame(effect.sprite, effect.transform, effect.frames[effect.frame]);
      }
      if (effect.elapsed < effect.duration) continue;
      const onFinish = effect.onFinish;
      effect.node.destroy();
      this.skillEffects.splice(i, 1);
      onFinish?.();
    }
  }

  private addStatRow(name: string, key: 'strength' | 'dexterity' | 'wisdom', oldX: number, oldBoxY: number) {
    if (!this.statsPanel) return;
    const rowCenterY = oldBoxY + 8;
    this.addOldPanelLabel(this.statsPanel, name, STATS_OLD_WIDTH, STATS_OLD_HEIGHT, STATS_UI_SCALE, oldX, rowCenterY, 40, 'left');
    this.statsLabels[key] = this.addOldStatValueBox(this.statsPanel, key, 58, oldBoxY, 40, 16);
    const buttonY = oldBoxY - 1;
    this.createStatsPointButton(`StatsAdd_${key}`, 'add', 100, buttonY, () => this.addHeroPoint(key));
    this.createStatsPointButton(`StatsReduce_${key}`, 'reduce', 100, buttonY + 8, () => this.reduceHeroPoint(key));
  }

  private addOldStatValueBox(parent: Node, key: string, oldX: number, oldY: number, oldWidth: number, oldHeight: number) {
    const node = new Node(`StatsValueBox_${key}`);
    parent.addChild(node);
    node.setPosition(...this.oldPanelCenter(STATS_OLD_WIDTH, STATS_OLD_HEIGHT, STATS_UI_SCALE, oldX, oldY, oldWidth, oldHeight), 0);
    node.addComponent(UITransform).setContentSize(oldWidth * STATS_UI_SCALE, oldHeight * STATS_UI_SCALE);
    const g = node.addComponent(Graphics);
    this.drawOldStatValueBox(g, oldWidth * STATS_UI_SCALE, oldHeight * STATS_UI_SCALE);
    return this.addOldPanelLabel(parent, '', STATS_OLD_WIDTH, STATS_OLD_HEIGHT, STATS_UI_SCALE, oldX + oldWidth - 2, oldY + oldHeight / 2, oldWidth - 4, 'right');
  }

  private drawOldStatValueBox(g: Graphics, width: number, height: number) {
    g.clear();
    g.fillColor = this.oldRgbColor(-4737099);
    g.rect(-width / 2, -height / 2, width, height);
    g.fill();
    g.fillColor = this.oldRgbColor(-16646141);
    g.rect(-width / 2 + STATS_UI_SCALE, -height / 2 + STATS_UI_SCALE, width - 2 * STATS_UI_SCALE, height - 2 * STATS_UI_SCALE);
    g.fill();
  }

  private addOldPanelSeparator(parent: Node, oldPanelWidth: number, oldPanelHeight: number, scale: number, oldX1: number, oldY: number, oldX2: number) {
    const node = new Node('OldPanelSeparator');
    parent.addChild(node);
    const g = node.addComponent(Graphics);
    const colors = [-8287098, -10068658, -9476521, -15197932];
    for (let i = 0; i < colors.length; i++) this.drawOldHLine(g, oldPanelWidth, oldPanelHeight, oldX1, oldY + i, oldX2, scale, colors[i]);
  }

  private createStatsActionButton(name: string, text: string, oldX: number, oldY: number, oldWidth: number, onClick: () => void) {
    if (!this.statsPanel) return;
    const node = this.createOldUiButton(this.statsPanel, name, text, onClick, oldWidth, 19);
    node.setPosition(...this.oldPanelCenter(STATS_OLD_WIDTH, STATS_OLD_HEIGHT, STATS_UI_SCALE, oldX, oldY, oldWidth, 19), 0);
  }

  private createStatsPointButton(name: string, kind: 'add' | 'reduce', oldX: number, oldY: number, onClick: () => void) {
    if (!this.statsPanel) return;
    const node = new Node(name);
    node.parent = this.statsPanel;
    node.setPosition(...this.oldPanelCenter(STATS_OLD_WIDTH, STATS_OLD_HEIGHT, STATS_UI_SCALE, oldX, oldY, STATS_POINT_BUTTON_SIZE, STATS_POINT_BUTTON_SIZE), 0);
    node.addComponent(UITransform).setContentSize(STATS_POINT_BUTTON_SIZE * STATS_UI_SCALE, STATS_POINT_BUTTON_SIZE * STATS_UI_SCALE);
    const sprite = node.addComponent(Sprite);
    sprite.sizeMode = Sprite.SizeMode.CUSTOM;
    sprite.spriteFrame = this.statPointFrames[kind] ?? null;
    node.on(Node.EventType.TOUCH_END, onClick);
  }

  private addUiLabel(parent: Node, text: string, x: number, y: number, size: number, color: Color, align: 'left' | 'center' | 'right' = 'center') {
    const node = new Node(`Label_${text || 'value'}`);
    parent.addChild(node);
    node.setPosition(x, y, 0);
    node.addComponent(UITransform);
    const label = node.addComponent(Label);
    label.string = text;
    label.fontSize = size;
    label.lineHeight = size + 2;
    label.color = color;
    label.horizontalAlign = align === 'left' ? Label.HorizontalAlign.LEFT : align === 'right' ? Label.HorizontalAlign.RIGHT : Label.HorizontalAlign.CENTER;
    return label;
  }

  private makeLabelAutoFit(label: Label, width: number, height: number, minFontSize = 7) {
    label.enableWrapText = false;
    const overflow = (Label as unknown as { Overflow?: Record<string, number> }).Overflow;
    if (overflow?.CLAMP !== undefined) (label as unknown as { overflow: number }).overflow = overflow.CLAMP;
    const transform = label.node.getComponent(UITransform);
    transform?.setContentSize(width, height);
  }

  private alignLeftLabelBox(label: Label, width: number, height: number) {
    label.enableWrapText = false;
    label.verticalAlign = Label.VerticalAlign.CENTER;
    const transform = label.node.getComponent(UITransform);
    transform?.setAnchorPoint(0, 0.5);
    this.makeLabelAutoFit(label, width, height);
  }

  private addOldPopupTitle(parent: Node, text: string, oldPanelWidth: number, oldPanelHeight: number, scale: number) {
    return this.addOldPanelLabel(parent, text, oldPanelWidth, oldPanelHeight, scale, OLD_UI_POPUP_TITLE_MARGIN, 15, 80, 'left', OLD_UI_TITLE_TEXT_COLOR);
  }

  private addOldPopupCloseButton(parent: Node, oldPanelWidth: number, oldPanelHeight: number, scale: number, onClick: () => void) {
    const node = this.createOldUiButton(parent, 'PopupCloseButton', GAME_TEXT.ui.close, onClick, OLD_UI_CLOSE_BUTTON_SIZE, OLD_UI_CLOSE_BUTTON_SIZE);
    this.positionOldPopupCloseButton(node, oldPanelWidth, oldPanelHeight, scale);
    return node;
  }

  private positionOldPopupCloseButton(node: Node | null | undefined, oldPanelWidth: number, oldPanelHeight: number, scale: number) {
    if (!node) return;
    node.setPosition(...this.oldPanelCenter(
      oldPanelWidth,
      oldPanelHeight,
      scale,
      oldPanelWidth - OLD_UI_POPUP_TITLE_MARGIN - OLD_UI_CLOSE_BUTTON_SIZE,
      7,
      OLD_UI_CLOSE_BUTTON_SIZE,
      OLD_UI_CLOSE_BUTTON_SIZE,
    ), 0);
  }

  private addOldPanelLabel(parent: Node, text: string, oldPanelWidth: number, oldPanelHeight: number, scale: number, oldX: number, oldY: number, oldWidth: number, align: 'left' | 'center' | 'right' = 'left', color: Color = OLD_UI_BODY_TEXT_COLOR) {
    const x = (oldX - oldPanelWidth / 2) * scale;
    const y = (oldPanelHeight / 2 - oldY) * scale;
    const label = this.addUiLabel(parent, text, x, y, OLD_UI_BUTTON_FONT_SIZE, color, align);
    label.lineHeight = OLD_UI_BUTTON_HEIGHT;
    label.verticalAlign = Label.VerticalAlign.CENTER;
    const transform = label.node.getComponent(UITransform);
    transform?.setContentSize(oldWidth * scale, OLD_UI_BUTTON_HEIGHT);
    transform?.setAnchorPoint(align === 'left' ? 0 : align === 'right' ? 1 : 0.5, 0.5);
    this.makeLabelAutoFit(label, oldWidth * scale, OLD_UI_BUTTON_HEIGHT);
    return label;
  }

  private drawPanelBox(g: Graphics, width: number, height: number, fill: Color) {
    g.clear();
    g.fillColor = fill;
    g.rect(-width / 2, -height / 2, width, height);
    g.fill();
    g.strokeColor = new Color(170, 170, 150, 255);
    g.lineWidth = 1;
    g.rect(-width / 2, -height / 2, width, height);
    g.stroke();
  }

  private createInventoryUi() {
    if (!this.node.parent) return;
    const parent = this.node.parent;
    const panelWidth = INVENTORY_OLD_WIDTH * INVENTORY_UI_SCALE;
    const panelHeight = INVENTORY_OLD_HEIGHT * INVENTORY_UI_SCALE;

    this.inventoryButton = this.createMainMenuButton(parent, 'InventoryButton', GAME_TEXT.ui.inventory, () => {
      if (!this.inventoryPanel) return;
      this.inventoryPanel.active = !this.inventoryPanel.active;
      this.renderInventoryUi();
    });

    this.inventoryPanel = new Node('InventoryPanel');
    this.inventoryPanel.parent = parent;
    this.inventoryPanel.active = false;
    this.inventoryPanel.addComponent(UITransform).setContentSize(panelWidth, panelHeight);
    const bg = this.inventoryPanel.addComponent(Graphics);
    this.drawOldPopupBackground(bg, INVENTORY_OLD_WIDTH, INVENTORY_OLD_HEIGHT, INVENTORY_UI_SCALE);
    this.inventoryPopupFrame = {
      node: this.inventoryPanel,
      width: panelWidth,
      height: panelHeight,
      oldWidth: INVENTORY_OLD_WIDTH,
      oldHeight: INVENTORY_OLD_HEIGHT,
    };
    this.applyOldPopupFrame(this.inventoryPopupFrame);

    this.addOldPopupTitle(this.inventoryPanel, GAME_TEXT.panel.inventory, INVENTORY_OLD_WIDTH, INVENTORY_OLD_HEIGHT, INVENTORY_UI_SCALE);
    this.addOldPopupCloseButton(this.inventoryPanel, INVENTORY_OLD_WIDTH, INVENTORY_OLD_HEIGHT, INVENTORY_UI_SCALE, () => {
      if (this.inventoryPanel) this.inventoryPanel.active = false;
      this.clearEquipmentSelection();
    });
    this.inventoryLabels.profession = this.addUiLabel(
      this.inventoryPanel,
      '',
      this.oldInventoryX(INVENTORY_OLD_WIDTH / 2),
      this.oldInventoryY(INVENTORY_START_Y - INVENTORY_SECTION_DIVIDER_OLD_HEIGHT / 2),
      OLD_UI_BUTTON_FONT_SIZE,
      OLD_UI_TITLE_TEXT_COLOR,
    );
    this.inventoryLabels.detail = this.addUiLabel(this.inventoryPanel, '', this.oldInventoryX(120), this.oldInventoryY(184), OLD_UI_BUTTON_FONT_SIZE, OLD_UI_BODY_TEXT_COLOR);

    const equipmentBack = new Node('EquipmentPreviewStage');
    equipmentBack.parent = this.inventoryPanel;
    equipmentBack.setPosition(...this.oldInventoryCenter(EQUIPMENT_STAGE_OLD_X, EQUIPMENT_STAGE_OLD_Y, EQUIPMENT_STAGE_OLD_WIDTH, EQUIPMENT_STAGE_OLD_HEIGHT), 0);
    this.equipmentBackTransform = equipmentBack.addComponent(UITransform);
    this.equipmentBackTransform.setContentSize(EQUIPMENT_STAGE_OLD_WIDTH * INVENTORY_UI_SCALE, EQUIPMENT_STAGE_OLD_HEIGHT * INVENTORY_UI_SCALE);
    const equipmentStageGraphics = equipmentBack.addComponent(Graphics);
    this.drawEquipmentPreviewStage(equipmentStageGraphics);

    this.createEquipmentPreviewNode();

    this.inventoryBagViews = [];
    this.equipmentViews = {};
    for (const slotKey of Object.keys(EQUIPMENT_SLOT_LAYOUT) as EquipmentSlotKey[]) {
      const layout = EQUIPMENT_SLOT_LAYOUT[slotKey];
      const slotNode = this.createSlotNode(`Equip_${slotKey}`, layout.x, layout.y, slotKey);
      slotNode.node.on(Node.EventType.TOUCH_END, () => this.openEquippedEquipmentDetail(slotKey));
      this.equipmentViews[slotKey] = slotNode;
    }

    for (let row = 0; row < INVENTORY_ROWS; row++) {
      for (let col = 0; col < INVENTORY_COLUMNS; col++) {
        const index = row * INVENTORY_COLUMNS + col;
        const slotNode = this.createSlotNode(
          `Bag_${index}`,
          INVENTORY_START_X + col * INVENTORY_BAG_SLOT_SIZE,
          INVENTORY_START_Y + row * INVENTORY_BAG_SLOT_SIZE,
          undefined,
          INVENTORY_BAG_ICON_SIZE,
        );
        slotNode.node.on(Node.EventType.TOUCH_END, () => this.openBagEquipmentDetail(index));
        this.inventoryBagViews[index] = slotNode;
      }
    }
    const actionButtonY = INVENTORY_OLD_HEIGHT - 23;
    this.createInventoryActionButton('InventoryPrevPage', GAME_TEXT.ui.previousPage, 16, actionButtonY, () => this.changeInventoryPage(-1));
    this.createInventoryActionButton('InventorySort', GAME_TEXT.ui.sort, 104, actionButtonY, () => this.sortInventory());
    this.createInventoryActionButton('InventorySell', GAME_TEXT.ui.sell, 168, actionButtonY, () => this.sellSelectedInventoryItem());
    this.createInventoryActionButton('InventoryNextPage', GAME_TEXT.ui.nextPage, 256, actionButtonY, () => this.changeInventoryPage(1));

    this.createEquipmentDetailUi();
    this.renderInventoryUi();
  }

  private createInventoryActionButton(name: string, text: string, oldX: number, oldY: number, onClick: () => void) {
    if (!this.inventoryPanel) return;
    const node = this.createOldUiButton(this.inventoryPanel, name, text, onClick);
    node.setPosition(...this.oldInventoryCenter(oldX, oldY, OLD_UI_BUTTON_OLD_WIDTH, OLD_UI_BUTTON_OLD_HEIGHT), 0);
  }

  private createEnhanceUi() {
    if (!this.node.parent) return;
    const parent = this.node.parent;
    const panelWidth = ENHANCE_OLD_WIDTH * ENHANCE_UI_SCALE;
    const panelHeight = ENHANCE_OLD_HEIGHT * ENHANCE_UI_SCALE;

    this.enhanceButton = this.createMainMenuButton(parent, 'EnhanceButton', GAME_TEXT.ui.enhance, () => {
      if (!this.enhancePanel) return;
      this.enhancePanel.active = !this.enhancePanel.active;
      this.renderEnhanceUi();
    });

    this.enhancePanel = new Node('EnhancePanel');
    this.enhancePanel.parent = parent;
    this.enhancePanel.active = false;
    this.enhancePanel.addComponent(UITransform).setContentSize(panelWidth, panelHeight);
    const bg = this.enhancePanel.addComponent(Graphics);
    this.drawOldPopupBackground(bg, ENHANCE_OLD_WIDTH, ENHANCE_OLD_HEIGHT, ENHANCE_UI_SCALE);
    this.enhancePopupFrame = {
      node: this.enhancePanel,
      width: panelWidth,
      height: panelHeight,
      oldWidth: ENHANCE_OLD_WIDTH,
      oldHeight: ENHANCE_OLD_HEIGHT,
    };
    this.applyOldPopupFrame(this.enhancePopupFrame);

    this.addOldPopupTitle(this.enhancePanel, GAME_TEXT.panel.enhance, ENHANCE_OLD_WIDTH, ENHANCE_OLD_HEIGHT, ENHANCE_UI_SCALE);
    this.addOldPopupCloseButton(this.enhancePanel, ENHANCE_OLD_WIDTH, ENHANCE_OLD_HEIGHT, ENHANCE_UI_SCALE, () => {
      if (this.enhancePanel) this.enhancePanel.active = false;
      this.clearEnhanceSelection();
    });
    this.addOldPanelSeparator(this.enhancePanel, ENHANCE_OLD_WIDTH, ENHANCE_OLD_HEIGHT, ENHANCE_UI_SCALE, 3, ENHANCE_SECTION_DIVIDER_OLD_Y, ENHANCE_OLD_WIDTH - 3);

    this.enhanceStoneSlotView = this.createPanelSlotNode(
      this.enhancePanel,
      'EnhanceStoneSlot',
      ENHANCE_OLD_WIDTH,
      ENHANCE_OLD_HEIGHT,
      ENHANCE_UI_SCALE,
      ENHANCE_STONE_SLOT_OLD_X,
      ENHANCE_ITEM_SLOT_OLD_Y,
      -1,
    );
    this.enhanceStoneSlotView.node.on(Node.EventType.TOUCH_END, () => {
      this.selectedEnhanceStone = null;
      this.renderEnhanceUi();
    });

    this.enhanceItemSlotView = this.createPanelSlotNode(
      this.enhancePanel,
      'EnhanceItemSlot',
      ENHANCE_OLD_WIDTH,
      ENHANCE_OLD_HEIGHT,
      ENHANCE_UI_SCALE,
      ENHANCE_ITEM_SLOT_OLD_X,
      ENHANCE_ITEM_SLOT_OLD_Y,
      -1,
    );
    this.enhanceItemSlotView.node.on(Node.EventType.TOUCH_END, () => this.clearEnhanceSelection());

    this.enhanceProtectSlotView = this.createPanelSlotNode(
      this.enhancePanel,
      'EnhanceProtectStoneSlot',
      ENHANCE_OLD_WIDTH,
      ENHANCE_OLD_HEIGHT,
      ENHANCE_UI_SCALE,
      ENHANCE_PROTECT_SLOT_OLD_X,
      ENHANCE_ITEM_SLOT_OLD_Y,
      -1,
    );
    this.enhanceProtectSlotView.node.on(Node.EventType.TOUCH_END, () => {
      this.selectedEnhanceProtectStone = null;
      this.enhanceUseProtectStone = false;
      this.renderEnhanceUi();
    });

    this.enhanceLabels.name = this.addOldPanelLabel(this.enhancePanel, GAME_TEXT.enhance.emptySlot, ENHANCE_OLD_WIDTH, ENHANCE_OLD_HEIGHT, ENHANCE_UI_SCALE, ENHANCE_INFO_OLD_X, ENHANCE_INFO_OLD_Y, 68, 'left', OLD_UI_TITLE_TEXT_COLOR);
    this.enhanceLabels.level = this.addOldPanelLabel(this.enhancePanel, '', ENHANCE_OLD_WIDTH, ENHANCE_OLD_HEIGHT, ENHANCE_UI_SCALE, ENHANCE_INFO_OLD_X, ENHANCE_INFO_OLD_Y + 18, 68, 'left');
    this.enhanceLabels.rateTitle = this.addOldPanelLabel(this.enhancePanel, GAME_TEXT.enhance.rateLabel, ENHANCE_OLD_WIDTH, ENHANCE_OLD_HEIGHT, ENHANCE_UI_SCALE, ENHANCE_INFO_LABEL_OLD_X, 98, 58, 'left');
    this.enhanceLabels.rate = this.addOldPanelLabel(this.enhancePanel, '', ENHANCE_OLD_WIDTH, ENHANCE_OLD_HEIGHT, ENHANCE_UI_SCALE, ENHANCE_INFO_VALUE_OLD_X, 98, 60, 'left');
    this.enhanceLabels.goldTitle = this.addOldPanelLabel(this.enhancePanel, GAME_TEXT.enhance.goldLabel, ENHANCE_OLD_WIDTH, ENHANCE_OLD_HEIGHT, ENHANCE_UI_SCALE, ENHANCE_INFO_LABEL_OLD_X, 120, 58, 'left');
    this.enhanceLabels.gold = this.addOldPanelLabel(this.enhancePanel, '', ENHANCE_OLD_WIDTH, ENHANCE_OLD_HEIGHT, ENHANCE_UI_SCALE, ENHANCE_INFO_VALUE_OLD_X, 120, 76, 'left');
    this.enhanceLabels.stoneTitle = this.addOldPanelLabel(this.enhancePanel, GAME_TEXT.enhance.stoneLabel, ENHANCE_OLD_WIDTH, ENHANCE_OLD_HEIGHT, ENHANCE_UI_SCALE, ENHANCE_INFO_LABEL_OLD_X, 142, 58, 'left');
    this.enhanceLabels.stone = this.addOldPanelLabel(this.enhancePanel, '', ENHANCE_OLD_WIDTH, ENHANCE_OLD_HEIGHT, ENHANCE_UI_SCALE, ENHANCE_INFO_VALUE_OLD_X, 142, 76, 'left');
    this.enhanceLabels.protectTitle = this.addOldPanelLabel(this.enhancePanel, GAME_TEXT.enhance.protectLabel, ENHANCE_OLD_WIDTH, ENHANCE_OLD_HEIGHT, ENHANCE_UI_SCALE, 42, 164, 64, 'left');
    this.enhanceLabels.protect = this.addOldPanelLabel(this.enhancePanel, '', ENHANCE_OLD_WIDTH, ENHANCE_OLD_HEIGHT, ENHANCE_UI_SCALE, ENHANCE_INFO_VALUE_OLD_X + 18, 164, 72, 'left');
    this.enhanceLabels.result = this.addOldPanelLabel(this.enhancePanel, GAME_TEXT.enhance.selectEquipment, ENHANCE_OLD_WIDTH, ENHANCE_OLD_HEIGHT, ENHANCE_UI_SCALE, ENHANCE_INFO_RIGHT_OLD_X, 112, 88, 'left', OLD_UI_BUTTON_TEXT_COLOR);

    const protectNode = new Node('EnhanceProtectToggle');
    protectNode.parent = this.enhancePanel;
    protectNode.setPosition(...this.oldPanelCenter(ENHANCE_OLD_WIDTH, ENHANCE_OLD_HEIGHT, ENHANCE_UI_SCALE, 24, 164, 12, 12), 0);
    protectNode.addComponent(UITransform).setContentSize(12 * ENHANCE_UI_SCALE, 12 * ENHANCE_UI_SCALE);
    this.enhanceProtectBox = protectNode.addComponent(Graphics);
    protectNode.on(Node.EventType.TOUCH_END, () => this.toggleEnhanceProtectStone());

    this.enhanceExecuteButton = this.createOldUiButton(this.enhancePanel, 'EnhanceExecute', GAME_TEXT.ui.enhance, () => this.enhanceSelectedEquipment());
    this.enhanceExecuteButton.setPosition(
      ...this.oldPanelCenter(
        ENHANCE_OLD_WIDTH,
        ENHANCE_OLD_HEIGHT,
        ENHANCE_UI_SCALE,
        ENHANCE_EXECUTE_BUTTON_OLD_X,
        ENHANCE_EXECUTE_BUTTON_OLD_Y,
        OLD_UI_BUTTON_OLD_WIDTH,
        OLD_UI_BUTTON_OLD_HEIGHT,
      ),
      0,
    );

    this.enhanceBagViews = [];
    for (let row = 0; row < ENHANCE_BAG_ROWS; row++) {
      for (let col = 0; col < ENHANCE_BAG_COLUMNS; col++) {
        const index = row * ENHANCE_BAG_COLUMNS + col;
        const slot = this.createPanelSlotNode(
          this.enhancePanel,
          `EnhanceBag_${index}`,
          ENHANCE_OLD_WIDTH,
          ENHANCE_OLD_HEIGHT,
          ENHANCE_UI_SCALE,
          ENHANCE_BAG_START_X + col * INVENTORY_SLOT_SIZE,
          ENHANCE_BAG_START_Y + row * INVENTORY_SLOT_SIZE,
          index,
        );
        slot.node.on(Node.EventType.TOUCH_END, () => this.selectEnhanceBagItem(index));
        this.enhanceBagViews[index] = slot;
      }
    }

    const actionButtonY = ENHANCE_OLD_HEIGHT - 23;
    this.createEnhanceActionButton('EnhancePrevPage', GAME_TEXT.ui.previousPage, 10, actionButtonY, () => this.changeEnhancePage(-1));
    this.createEnhanceActionButton('EnhanceNextPage', GAME_TEXT.ui.nextPage, 230, actionButtonY, () => this.changeEnhancePage(1));
    this.renderEnhanceUi();
  }

  private createEnhanceActionButton(name: string, text: string, oldX: number, oldY: number, onClick: () => void) {
    if (!this.enhancePanel) return;
    const node = this.createOldUiButton(this.enhancePanel, name, text, onClick);
    node.setPosition(...this.oldPanelCenter(ENHANCE_OLD_WIDTH, ENHANCE_OLD_HEIGHT, ENHANCE_UI_SCALE, oldX, oldY, OLD_UI_BUTTON_OLD_WIDTH, OLD_UI_BUTTON_OLD_HEIGHT), 0);
  }

  private createSettingsButton() {
    if (!this.node.parent) return;
    this.settingsButton = this.createMainMenuButton(this.node.parent, 'SettingsButton', GAME_TEXT.ui.settings, () => {
      // Reserved for the later settings panel. Keeping it inert avoids changing current gameplay.
    });
  }

  private drawEquipmentPreviewStage(g: Graphics) {
    g.clear();
  }

  private createEquipmentPreviewNode() {
    if (!this.inventoryPanel) return;
    const auraNode = new Node('EquipmentPreviewAura');
    auraNode.parent = this.inventoryPanel;
    auraNode.setPosition(this.oldInventoryX(EQUIPMENT_PREVIEW_OLD_X), this.oldInventoryY(EQUIPMENT_PREVIEW_OLD_Y + 30), 0);
    this.equipmentPreviewAura = auraNode.addComponent(Graphics);

    this.equipmentPreviewNode = new Node('EquipmentLivePreview');
    this.equipmentPreviewNode.parent = this.inventoryPanel;
    this.equipmentPreviewNode.setPosition(this.oldInventoryX(EQUIPMENT_PREVIEW_OLD_X), this.oldInventoryY(EQUIPMENT_PREVIEW_OLD_Y), 0);
    this.equipmentPreviewNode.setScale(EQUIPMENT_PREVIEW_SCALE, EQUIPMENT_PREVIEW_SCALE, 1);
    this.equipmentPreviewTransform = this.equipmentPreviewNode.addComponent(UITransform);
    this.equipmentPreviewSprite = this.equipmentPreviewNode.addComponent(Sprite);
    this.equipmentPreviewSprite.sizeMode = Sprite.SizeMode.TRIMMED;

    this.equipmentPreviewTitleLabel = this.addUiLabel(this.inventoryPanel, '', this.oldInventoryX(EQUIPMENT_PREVIEW_OLD_X), this.oldInventoryY(44), OLD_UI_BUTTON_FONT_SIZE, OLD_UI_TITLE_TEXT_COLOR);
    this.makeLabelAutoFit(this.equipmentPreviewTitleLabel, 86 * INVENTORY_UI_SCALE, OLD_UI_BUTTON_HEIGHT);
    this.equipmentPreviewFashionLabel = this.addUiLabel(this.inventoryPanel, '', this.oldInventoryX(EQUIPMENT_PREVIEW_OLD_X), this.oldInventoryY(174), OLD_UI_BUTTON_FONT_SIZE, OLD_UI_BODY_TEXT_COLOR);
    this.makeLabelAutoFit(this.equipmentPreviewFashionLabel, 86 * INVENTORY_UI_SCALE, OLD_UI_BUTTON_HEIGHT);

    this.setEquipmentPreviewFrame(0);
    this.updateEquipmentPreviewDecorations();
  }

  private updateEquipmentPreviewDecorations() {
    const title = this.equippedSlots.title;
    if (this.equipmentPreviewTitleLabel) {
      this.equipmentPreviewTitleLabel.string = title ? title.item.name : '';
      this.equipmentPreviewTitleLabel.color = title ? this.equipmentNameColor(title.item.quality) : OLD_UI_TITLE_TEXT_COLOR;
    }

    const fashion = this.equippedSlots.fashion;
    if (this.equipmentPreviewFashionLabel) {
      this.equipmentPreviewFashionLabel.string = fashion ? fashion.item.name : '';
      this.equipmentPreviewFashionLabel.color = fashion ? this.equipmentNameColor(fashion.item.quality) : OLD_UI_BODY_TEXT_COLOR;
    }

    if (!this.equipmentPreviewAura) return;
    this.equipmentPreviewAura.clear();
    const aura = this.equippedSlots.aura;
    if (!aura) return;
    const color = this.equipmentNameColor(aura.item.quality);
    this.equipmentPreviewAura.strokeColor = new Color(color.r, color.g, color.b, 180);
    this.equipmentPreviewAura.lineWidth = 2;
    this.equipmentPreviewAura.circle(0, 0, 33 * INVENTORY_UI_SCALE);
    this.equipmentPreviewAura.stroke();
    this.equipmentPreviewAura.strokeColor = new Color(color.r, color.g, color.b, 90);
    this.equipmentPreviewAura.circle(0, 0, 23 * INVENTORY_UI_SCALE);
    this.equipmentPreviewAura.stroke();
  }

  private createEquipmentDetailUi() {
    if (!this.inventoryPanel) return;
    const width = EQUIPMENT_DETAIL_OLD_WIDTH * INVENTORY_UI_SCALE;
    const height = EQUIPMENT_DETAIL_OLD_HEIGHT * INVENTORY_UI_SCALE;
    this.equipmentDetailPanel = new Node('EquipmentDetailPanel');
    this.equipmentDetailPanel.parent = this.inventoryPanel;
    this.equipmentDetailPanel.active = false;
    this.equipmentDetailPanel.setPosition(0, EQUIPMENT_DETAIL_BASE_Y, 1);
    this.equipmentDetailPanel.addComponent(UITransform).setContentSize(width, height);
    const bg = this.equipmentDetailPanel.addComponent(Graphics);
    this.drawOldPopupBackground(bg, EQUIPMENT_DETAIL_OLD_WIDTH, EQUIPMENT_DETAIL_OLD_HEIGHT, INVENTORY_UI_SCALE);
    this.equipmentDetailPopupFrame = {
      node: this.equipmentDetailPanel,
      width,
      height,
      oldWidth: EQUIPMENT_DETAIL_OLD_WIDTH,
      oldHeight: EQUIPMENT_DETAIL_OLD_HEIGHT,
    };
    this.applyOldPopupFrame(this.equipmentDetailPopupFrame);

    this.equipmentDetailTitleLabel = this.addOldPopupTitle(this.equipmentDetailPanel, GAME_TEXT.panel.equipmentDetail, EQUIPMENT_DETAIL_OLD_WIDTH, EQUIPMENT_DETAIL_OLD_HEIGHT, INVENTORY_UI_SCALE);
    this.addOldPopupCloseButton(this.equipmentDetailPanel, EQUIPMENT_DETAIL_OLD_WIDTH, EQUIPMENT_DETAIL_OLD_HEIGHT, INVENTORY_UI_SCALE, () => this.clearEquipmentSelection());
    const iconSlot = new Node('EquipmentDetailIconSlot');
    iconSlot.parent = this.equipmentDetailPanel;
    iconSlot.setPosition(...this.oldPanelCenter(EQUIPMENT_DETAIL_OLD_WIDTH, EQUIPMENT_DETAIL_OLD_HEIGHT, INVENTORY_UI_SCALE, 15, 40, INVENTORY_ICON_SIZE, INVENTORY_ICON_SIZE), 0);
    iconSlot.addComponent(UITransform).setContentSize(INVENTORY_ICON_SIZE * INVENTORY_UI_SCALE, INVENTORY_ICON_SIZE * INVENTORY_UI_SCALE);
    const iconBg = iconSlot.addComponent(Graphics);
    this.drawInventorySlot(iconBg, -1, false);
    this.equipmentDetailIconRoot = iconSlot;

    this.equipmentDetailLabels.name = this.addOldPanelLabel(this.equipmentDetailPanel, '', EQUIPMENT_DETAIL_OLD_WIDTH, EQUIPMENT_DETAIL_OLD_HEIGHT, INVENTORY_UI_SCALE, 48, 45, 126, 'left');
    this.equipmentDetailLabels.meta = this.addOldPanelLabel(this.equipmentDetailPanel, '', EQUIPMENT_DETAIL_OLD_WIDTH, EQUIPMENT_DETAIL_OLD_HEIGHT, INVENTORY_UI_SCALE, 48, 63, 126, 'left');
    this.equipmentDetailLabels.status = this.addOldPanelLabel(this.equipmentDetailPanel, '', EQUIPMENT_DETAIL_OLD_WIDTH, EQUIPMENT_DETAIL_OLD_HEIGHT, INVENTORY_UI_SCALE, 48, 81, 126, 'left');
    for (let i = 0; i < EQUIPMENT_DETAIL_BASE_ROW_COUNT; i++) this.ensureEquipmentDetailStatLabel(i);

    this.equipmentDetailSellButton = this.createEquipmentDetailButton('EquipmentDetailSell', GAME_TEXT.ui.sell, 8, () => this.sellSelectedInventoryItem());
    this.equipmentDetailLockButton = this.createEquipmentDetailButton('EquipmentDetailLock', GAME_TEXT.ui.lock, 68, () => this.toggleSelectedEquipmentLock());
    this.equipmentDetailEquipButton = this.createEquipmentDetailButton('EquipmentDetailEquip', GAME_TEXT.ui.equip, 128, () => this.equipSelectedEquipment());
    this.equipmentDetailUnequipButton = this.createEquipmentDetailButton('EquipmentDetailUnequip', GAME_TEXT.ui.unequip, 128, () => this.unequipSelectedEquipment());
  }

  private createEquipmentDetailButton(name: string, text: string, oldX: number, onClick: () => void) {
    if (!this.equipmentDetailPanel) return null;
    const node = this.createOldUiButton(this.equipmentDetailPanel, name, text, onClick);
    this.positionEquipmentDetailButton(node, oldX);
    return node;
  }

  private ensureEquipmentDetailStatLabel(index: number) {
    const key = `stat${index}`;
    if (this.equipmentDetailLabels[key] || !this.equipmentDetailPanel) return this.equipmentDetailLabels[key];
    this.equipmentDetailLabels[key] = this.addOldPanelLabel(
      this.equipmentDetailPanel,
      '',
      EQUIPMENT_DETAIL_OLD_WIDTH,
      this.currentEquipmentDetailOldHeight(),
      INVENTORY_UI_SCALE,
      15,
      EQUIPMENT_DETAIL_ROW_START_Y + index * EQUIPMENT_DETAIL_ROW_GAP,
      154,
      'left',
    );
    return this.equipmentDetailLabels[key];
  }

  private currentEquipmentDetailOldHeight() {
    return this.equipmentDetailPopupFrame?.oldHeight ?? EQUIPMENT_DETAIL_OLD_HEIGHT;
  }

  private resizeEquipmentDetailPanel(oldHeight: number) {
    if (!this.equipmentDetailPanel || !this.equipmentDetailPopupFrame) return;
    const clampedHeight = Math.max(EQUIPMENT_DETAIL_OLD_HEIGHT, Math.round(oldHeight));
    const height = clampedHeight * INVENTORY_UI_SCALE;
    const width = EQUIPMENT_DETAIL_OLD_WIDTH * INVENTORY_UI_SCALE;
    this.equipmentDetailPanel.getComponent(UITransform)?.setContentSize(width, height);
    this.equipmentDetailPanel.setPosition(0, EQUIPMENT_DETAIL_BASE_Y - ((clampedHeight - EQUIPMENT_DETAIL_OLD_HEIGHT) * INVENTORY_UI_SCALE) / 2, 1);
    const bg = this.equipmentDetailPanel.getComponent(Graphics);
    if (bg) this.drawOldPopupBackground(bg, EQUIPMENT_DETAIL_OLD_WIDTH, clampedHeight, INVENTORY_UI_SCALE);
    this.equipmentDetailPopupFrame.width = width;
    this.equipmentDetailPopupFrame.height = height;
    this.equipmentDetailPopupFrame.oldWidth = EQUIPMENT_DETAIL_OLD_WIDTH;
    this.equipmentDetailPopupFrame.oldHeight = clampedHeight;
    this.applyOldPopupFrame(this.equipmentDetailPopupFrame);
    this.positionEquipmentDetailStaticNodes();
  }

  private positionEquipmentDetailStaticNodes() {
    const oldHeight = this.currentEquipmentDetailOldHeight();
    if (this.equipmentDetailTitleLabel) {
      this.positionOldPanelLabel(this.equipmentDetailTitleLabel, EQUIPMENT_DETAIL_OLD_WIDTH, oldHeight, INVENTORY_UI_SCALE, OLD_UI_POPUP_TITLE_MARGIN, 15, 80);
    }
    this.positionOldPopupCloseButton(this.equipmentDetailPanel?.getChildByName('PopupCloseButton'), EQUIPMENT_DETAIL_OLD_WIDTH, oldHeight, INVENTORY_UI_SCALE);
    if (this.equipmentDetailIconRoot) {
      this.equipmentDetailIconRoot.setPosition(...this.oldPanelCenter(EQUIPMENT_DETAIL_OLD_WIDTH, oldHeight, INVENTORY_UI_SCALE, 15, 40, INVENTORY_ICON_SIZE, INVENTORY_ICON_SIZE), 0);
    }
    this.positionOldPanelLabel(this.equipmentDetailLabels.name, EQUIPMENT_DETAIL_OLD_WIDTH, oldHeight, INVENTORY_UI_SCALE, 48, 45, 126);
    this.positionOldPanelLabel(this.equipmentDetailLabels.meta, EQUIPMENT_DETAIL_OLD_WIDTH, oldHeight, INVENTORY_UI_SCALE, 48, 63, 126);
    this.positionOldPanelLabel(this.equipmentDetailLabels.status, EQUIPMENT_DETAIL_OLD_WIDTH, oldHeight, INVENTORY_UI_SCALE, 48, 81, 126);
    for (let i = 0; this.equipmentDetailLabels[`stat${i}`]; i++) {
      this.positionOldPanelLabel(this.equipmentDetailLabels[`stat${i}`], EQUIPMENT_DETAIL_OLD_WIDTH, oldHeight, INVENTORY_UI_SCALE, 15, EQUIPMENT_DETAIL_ROW_START_Y + i * EQUIPMENT_DETAIL_ROW_GAP, 154);
    }
  }

  private positionOldPanelLabel(label: Label | undefined | null, oldPanelWidth: number, oldPanelHeight: number, scale: number, oldX: number, oldY: number, oldWidth: number) {
    if (!label) return;
    label.node.setPosition((oldX - oldPanelWidth / 2) * scale, (oldPanelHeight / 2 - oldY) * scale, 0);
    this.makeLabelAutoFit(label, oldWidth * scale, OLD_UI_BUTTON_HEIGHT);
  }

  private positionEquipmentDetailButton(node: Node | null, oldX: number) {
    if (!node) return;
    const oldHeight = this.currentEquipmentDetailOldHeight();
    node.setPosition(...this.oldPanelCenter(EQUIPMENT_DETAIL_OLD_WIDTH, oldHeight, INVENTORY_UI_SCALE, oldX, oldHeight - EQUIPMENT_DETAIL_BUTTON_BOTTOM_GAP, OLD_UI_BUTTON_OLD_WIDTH, OLD_UI_BUTTON_OLD_HEIGHT), 0);
  }

  private setOldUiButtonText(node: Node | null, text: string) {
    if (!node) return;
    for (const child of node.children) {
      const label = child.getComponent(Label);
      if (label) {
        label.string = text;
        const transform = child.getComponent(UITransform);
        if (transform) this.makeLabelAutoFit(label, transform.contentSize.width, transform.contentSize.height);
        return;
      }
    }
  }

  private createMainMenuButton(parent: Node, name: string, text: string, onClick: () => void) {
    const node = new Node(name);
    node.parent = parent;
    node.addComponent(UITransform).setContentSize(MAIN_MENU_BUTTON_MIN_SIZE, MAIN_MENU_BUTTON_MIN_SIZE);
    node.addComponent(Graphics);

    const skin = new Node('MainMenuButtonSkin');
    skin.parent = node;
    skin.setSiblingIndex(0);
    skin.addComponent(UITransform).setContentSize(MAIN_MENU_BUTTON_MIN_SIZE, MAIN_MENU_BUTTON_MIN_SIZE);
    const sprite = skin.addComponent(Sprite);
    sprite.sizeMode = Sprite.SizeMode.CUSTOM;

    const labelNode = new Node(`Label_${text || 'button'}`);
    labelNode.parent = node;
    labelNode.setPosition(0, 0, 0);
    labelNode.addComponent(UITransform).setContentSize(MAIN_MENU_BUTTON_MIN_SIZE, MAIN_MENU_BUTTON_MIN_SIZE);
    const label = labelNode.addComponent(Label);
    label.string = text;
    label.fontSize = MAIN_MENU_BUTTON_FONT_SIZE;
    label.lineHeight = MAIN_MENU_BUTTON_MIN_SIZE;
    label.color = OLD_UI_BUTTON_TEXT_COLOR;
    label.horizontalAlign = Label.HorizontalAlign.CENTER;
    label.verticalAlign = Label.VerticalAlign.CENTER;

    const view: MainMenuButtonView = { node, size: MAIN_MENU_BUTTON_MIN_SIZE, state: 'normal' };
    this.mainMenuButtons.push(view);
    this.applyMainMenuButtonSkin(view);

    node.on(Node.EventType.TOUCH_START, () => this.setMainMenuButtonState(node, 'pressed'));
    node.on(Node.EventType.TOUCH_CANCEL, () => this.setMainMenuButtonState(node, 'normal'));
    node.on(Node.EventType.TOUCH_END, () => {
      this.setMainMenuButtonState(node, 'normal');
      onClick();
    });
    return node;
  }

  private setMainMenuButtonState(node: Node, state: OldUiButtonState) {
    const view = this.mainMenuButtons.find((button) => button.node === node);
    if (!view || view.state === state) return;
    view.state = state;
    this.applyMainMenuButtonSkin(view);
  }

  private resizeMainMenuButton(node: Node | null, size: number) {
    if (!node) return;
    const view = this.mainMenuButtons.find((button) => button.node === node);
    if (!view) return;
    view.size = size;
    node.getComponent(UITransform)?.setContentSize(size, size);
    const skin = node.getChildByName('MainMenuButtonSkin');
    skin?.getComponent(UITransform)?.setContentSize(size, size);
    for (const child of node.children) {
      const label = child.getComponent(Label);
      if (!label) continue;
      child.getComponent(UITransform)?.setContentSize(size, size);
      label.lineHeight = size;
      this.makeLabelAutoFit(label, size - 4, size);
    }
    this.applyMainMenuButtonSkin(view);
  }

  private refreshMainMenuButtonSkins() {
    for (const button of this.mainMenuButtons) this.applyMainMenuButtonSkin(button);
  }

  private applyMainMenuButtonSkin(button: MainMenuButtonView) {
    const skin = button.node.getChildByName('MainMenuButtonSkin');
    const sprite = skin?.getComponent(Sprite);
    const frame = this.mainMenuButtonFrames[button.state] ?? this.mainMenuButtonFrames.normal ?? null;
    if (sprite) sprite.spriteFrame = frame;
    const bg = button.node.getComponent(Graphics);
    if (!bg) return;
    bg.clear();
    if (!frame) this.drawPanelBox(bg, button.size, button.size, button.state === 'pressed' ? new Color(20, 20, 18, 245) : new Color(76, 62, 50, 245));
  }

  private createOldUiButton(parent: Node, name: string, text: string, onClick: () => void, oldWidth = OLD_UI_BUTTON_OLD_WIDTH, oldHeight = OLD_UI_BUTTON_OLD_HEIGHT) {
    const width = Math.round(oldWidth * INVENTORY_UI_SCALE);
    const height = Math.round(oldHeight * INVENTORY_UI_SCALE);
    const node = new Node(name);
    node.parent = parent;
    node.addComponent(UITransform).setContentSize(width, height);
    const bg = node.addComponent(Graphics);
    this.drawPanelBox(bg, width, height, new Color(22, 24, 26, 235));
    const view: OldUiButtonView = {
      node,
      width,
      height,
      state: 'normal',
    };
    this.oldUiButtons.push(view);
    this.applyOldUiButtonSkin(view);
    this.addOldUiButtonLabel(node, text, width, height);
    node.on(Node.EventType.TOUCH_START, () => this.setOldUiButtonState(node, 'pressed'));
    node.on(Node.EventType.TOUCH_CANCEL, () => this.setOldUiButtonState(node, 'normal'));
    node.on(Node.EventType.TOUCH_END, () => {
      this.setOldUiButtonState(node, 'normal');
      onClick();
    });
    return node;
  }

  private addOldUiButtonLabel(parent: Node, text: string, width = OLD_UI_BUTTON_WIDTH, height = OLD_UI_BUTTON_HEIGHT) {
    const node = new Node(`Label_${text || 'button'}`);
    parent.addChild(node);
    node.setPosition(0, 0, 0);
    node.addComponent(UITransform).setContentSize(width, height);
    const label = node.addComponent(Label);
    label.string = text;
    label.fontSize = OLD_UI_BUTTON_FONT_SIZE;
    label.lineHeight = height;
    label.color = OLD_UI_BUTTON_TEXT_COLOR;
    label.horizontalAlign = Label.HorizontalAlign.CENTER;
    return label;
  }

  private setOldUiButtonState(node: Node, state: OldUiButtonState) {
    const view = this.oldUiButtons.find((button) => button.node === node);
    if (!view || view.state === state) return;
    view.state = state;
    this.applyOldUiButtonSkin(view);
  }

  private applyOldUiButtonSkin(button: OldUiButtonView) {
    let left = this.oldUiButtonFrames[`button_${button.state}_left`];
    let mid = this.oldUiButtonFrames[`button_${button.state}_mid`];
    let right = this.oldUiButtonFrames[`button_${button.state}_right`];
    if ((!left || !mid || !right) && button.state !== 'normal') {
      left = this.oldUiButtonFrames.button_normal_left;
      mid = this.oldUiButtonFrames.button_normal_mid;
      right = this.oldUiButtonFrames.button_normal_right;
    }
    if (!left || !mid || !right) return;

    const oldSkin = button.node.getChildByName('OldUiButtonSkin');
    if (oldSkin) {
      oldSkin.removeFromParent();
      oldSkin.destroy();
    }

    button.node.getComponent(Graphics)?.clear();
    const skin = new Node('OldUiButtonSkin');
    skin.parent = button.node;
    skin.setSiblingIndex(0);
    const nativeHeight = 24;
    const nativeLeftWidth = 11;
    const nativeMidWidth = 16;
    const nativeRightWidth = 11;
    const scale = button.height / nativeHeight;
    const leftWidth = Math.round(nativeLeftWidth * scale);
    const rightWidth = Math.round(nativeRightWidth * scale);
    const midWidth = Math.max(1, Math.round(nativeMidWidth * scale));
    const leftX = -button.width / 2;
    const rightX = button.width / 2 - rightWidth;
    const overlap = 1;

    this.addOldUiButtonPiece(skin, left, leftX + leftWidth / 2, leftWidth + overlap, button.height);
    let midX = leftX + leftWidth - overlap;
    const midEndX = rightX + overlap;
    while (midX < midEndX - 0.1) {
      const segmentWidth = Math.min(midWidth, midEndX - midX);
      this.addOldUiButtonPiece(skin, mid, midX + segmentWidth / 2, segmentWidth + overlap, button.height);
      midX += segmentWidth;
    }
    this.addOldUiButtonPiece(skin, right, button.width / 2 - rightWidth / 2, rightWidth, button.height);
  }

  private addOldUiButtonPiece(parent: Node, frame: SpriteFrame, x: number, width: number, height: number) {
    const node = new Node('OldUiButtonPiece');
    node.parent = parent;
    node.setPosition(x, 0, 0);
    const transform = node.addComponent(UITransform);
    const sprite = node.addComponent(Sprite);
    sprite.sizeMode = Sprite.SizeMode.CUSTOM;
    sprite.spriteFrame = frame;
    transform.setContentSize(width, height);
  }

  private drawOldPopupBackground(g: Graphics, oldWidth: number, oldHeight: number, scale: number) {
    g.clear();
    this.fillOldRect(g, oldWidth, oldHeight, 4, 30, oldWidth - 8, oldHeight - 59, scale, this.oldArgbColor(-1627389952));
  }

  private applyOldPopupFrame(frameView: OldUiPopupFrameView) {
    const oldFrame = frameView.node.getChildByName('OldUiPopupFrame');
    if (oldFrame) {
      oldFrame.removeFromParent();
      oldFrame.destroy();
    }

    const required = [
      'popup_top_left', 'popup_top_mid', 'popup_top_right',
      'popup_bottom_left', 'popup_bottom_mid', 'popup_bottom_right',
      'popup_inner_top_left', 'popup_inner_top_right',
      'popup_inner_left_top', 'popup_inner_left_bottom',
      'popup_inner_bottom_left', 'popup_inner_bottom_right',
      'popup_inner_right_top', 'popup_inner_right_bottom',
    ];
    if (required.some((key) => !this.oldUiPopupFrames[key])) return;

    const root = new Node('OldUiPopupFrame');
    root.parent = frameView.node;
    root.setSiblingIndex(0);
    const scale = frameView.width / frameView.oldWidth;

    this.addOldPopupStrip(root, 'popup_top', 0, 0, frameView.oldWidth, 26, frameView);
    this.addOldPopupStrip(root, 'popup_bottom', 0, frameView.oldHeight - 26, frameView.oldWidth, 30, frameView);

    const lineLayer = new Node('OldUiPopupFrameLines');
    lineLayer.parent = root;
    const g = lineLayer.addComponent(Graphics);
    this.addOldPopupInnerFrame(root, g, 0, 26, frameView.oldWidth, frameView.oldHeight - 52, frameView, scale);
    if (frameView === this.inventoryPopupFrame || frameView === this.companionPopupFrame) {
      const dividerY = frameView === this.companionPopupFrame
        ? COMPANION_GRID_START_Y - COMPANION_SECTION_DIVIDER_OLD_HEIGHT
        : INVENTORY_START_Y - INVENTORY_SECTION_DIVIDER_OLD_HEIGHT;
      this.addOldPopupStrip(
        root,
        'popup_bottom',
        0,
        dividerY,
        frameView.oldWidth,
        frameView === this.companionPopupFrame ? COMPANION_SECTION_DIVIDER_OLD_HEIGHT : INVENTORY_SECTION_DIVIDER_OLD_HEIGHT,
        frameView,
      );
    }
  }

  private addOldPopupStrip(parent: Node, prefix: 'popup_top' | 'popup_bottom', oldX: number, oldY: number, oldWidth: number, oldHeight: number, frameView: OldUiPopupFrameView) {
    const left = this.oldUiPopupFrames[`${prefix}_left`];
    const mid = this.oldUiPopupFrames[`${prefix}_mid`];
    const right = this.oldUiPopupFrames[`${prefix}_right`];
    if (!left || !mid || !right) return;
    const leftWidth = 17;
    const midWidth = 15;
    const rightWidth = 13;
    const rightX = oldX + oldWidth - rightWidth;

    this.addOldPopupPiece(parent, left, oldX, oldY, leftWidth, oldHeight, frameView);
    let x = oldX + leftWidth;
    while (x < rightX - 0.1) {
      const segmentWidth = Math.min(midWidth, rightX - x);
      this.addOldPopupPiece(parent, mid, x, oldY, segmentWidth, oldHeight, frameView);
      x += segmentWidth;
    }
    this.addOldPopupPiece(parent, right, rightX, oldY, rightWidth, oldHeight, frameView);
  }

  private addOldPopupInnerFrame(parent: Node, g: Graphics, oldX: number, oldY: number, oldWidth: number, oldHeight: number, frameView: OldUiPopupFrameView, scale: number) {
    let x1 = oldX;
    const topRightX = oldX + oldWidth - 16;
    let y = oldY;
    this.addOldPopupPiece(parent, this.oldUiPopupFrames.popup_inner_top_left, x1, y, 14, 4, frameView);
    x1 += 14;
    this.drawOldHLine(g, frameView.oldWidth, frameView.oldHeight, x1, y, topRightX, scale, -15001836);
    this.drawOldHLine(g, frameView.oldWidth, frameView.oldHeight, x1, y + 1, topRightX, scale, -2435373);
    this.drawOldHLine(g, frameView.oldWidth, frameView.oldHeight, x1, y + 2, topRightX, scale, -14671830);
    this.drawOldHLine(g, frameView.oldWidth, frameView.oldHeight, x1, y + 3, topRightX, scale, -8553081);
    this.addOldPopupPiece(parent, this.oldUiPopupFrames.popup_inner_top_right, topRightX, oldY, 16, 4, frameView);

    x1 = oldX;
    y = oldY + 4;
    const sideBottomY = oldY + oldHeight - 14;
    this.addOldPopupPiece(parent, this.oldUiPopupFrames.popup_inner_left_top, x1, y, 4, 10, frameView);
    let sideStartY = y + 10;
    this.drawOldVLine(g, frameView.oldWidth, frameView.oldHeight, x1, sideStartY, sideBottomY, scale, -14409444);
    this.drawOldVLine(g, frameView.oldWidth, frameView.oldHeight, x1 + 1, sideStartY, sideBottomY, scale, -10330278);
    this.drawOldVLine(g, frameView.oldWidth, frameView.oldHeight, x1 + 2, sideStartY, sideBottomY, scale, -7960703);
    this.drawOldVLine(g, frameView.oldWidth, frameView.oldHeight, x1 + 3, sideStartY, sideBottomY, scale, -14605796);
    this.addOldPopupPiece(parent, this.oldUiPopupFrames.popup_inner_left_bottom, oldX, sideBottomY, 4, 14, frameView);

    x1 = oldX + 4;
    y = oldY + oldHeight - 3;
    this.addOldPopupPiece(parent, this.oldUiPopupFrames.popup_inner_bottom_left, x1, y, 9, 3, frameView);
    this.addOldPopupPiece(parent, this.oldUiPopupFrames.popup_inner_bottom_right, topRightX, y, 16, 3, frameView);
    x1 += 9;
    this.drawOldHLine(g, frameView.oldWidth, frameView.oldHeight, x1, y, topRightX, scale, -6974562);
    this.drawOldHLine(g, frameView.oldWidth, frameView.oldHeight, x1, y + 1, topRightX, scale, -10068912);
    this.drawOldHLine(g, frameView.oldWidth, frameView.oldHeight, x1, y + 2, topRightX, scale, -10068912);

    const rightX = oldX + oldWidth - 4;
    y = oldY + 4;
    this.addOldPopupPiece(parent, this.oldUiPopupFrames.popup_inner_right_top, rightX, y, 4, 12, frameView);
    this.addOldPopupPiece(parent, this.oldUiPopupFrames.popup_inner_right_bottom, rightX, sideBottomY, 4, 10, frameView);
    sideStartY = y + 12;
    this.drawOldVLine(g, frameView.oldWidth, frameView.oldHeight, rightX, sideStartY, sideBottomY, scale, -14343912);
    this.drawOldVLine(g, frameView.oldWidth, frameView.oldHeight, rightX + 1, sideStartY, sideBottomY, scale, -7698819);
    this.drawOldVLine(g, frameView.oldWidth, frameView.oldHeight, rightX + 2, sideStartY, sideBottomY, scale, -10396073);
    this.drawOldVLine(g, frameView.oldWidth, frameView.oldHeight, rightX + 3, sideStartY, sideBottomY, scale, -14605795);
  }

  private addOldPopupPiece(parent: Node, frame: SpriteFrame | undefined, oldX: number, oldY: number, oldWidth: number, oldHeight: number, frameView: OldUiPopupFrameView) {
    if (!frame) return;
    const scale = frameView.width / frameView.oldWidth;
    const node = new Node('OldUiPopupPiece');
    node.parent = parent;
    node.setPosition(
      (oldX + oldWidth / 2 - frameView.oldWidth / 2) * scale,
      (frameView.oldHeight / 2 - oldY - oldHeight / 2) * scale,
      0,
    );
    const transform = node.addComponent(UITransform);
    const sprite = node.addComponent(Sprite);
    sprite.sizeMode = Sprite.SizeMode.CUSTOM;
    sprite.spriteFrame = frame;
    transform.setContentSize(oldWidth * scale, oldHeight * scale);
  }

  private drawOldHLine(g: Graphics, oldPanelWidth: number, oldPanelHeight: number, oldX1: number, oldY: number, oldX2: number, scale: number, color: number) {
    this.fillOldRect(g, oldPanelWidth, oldPanelHeight, oldX1, oldY, Math.max(0, oldX2 - oldX1), 1, scale, this.oldRgbColor(color));
  }

  private drawOldVLine(g: Graphics, oldPanelWidth: number, oldPanelHeight: number, oldX: number, oldY1: number, oldY2: number, scale: number, color: number) {
    this.fillOldRect(g, oldPanelWidth, oldPanelHeight, oldX, oldY1, 1, Math.max(0, oldY2 - oldY1), scale, this.oldRgbColor(color));
  }

  private fillOldRect(g: Graphics, oldPanelWidth: number, oldPanelHeight: number, oldX: number, oldY: number, oldWidth: number, oldHeight: number, scale: number, color: Color) {
    g.fillColor = color;
    g.rect(
      (oldX - oldPanelWidth / 2) * scale,
      (oldPanelHeight / 2 - oldY - oldHeight) * scale,
      oldWidth * scale,
      oldHeight * scale,
    );
    g.fill();
  }

  private oldRgbColor(color: number) {
    const value = color >>> 0;
    return new Color((value >> 16) & 255, (value >> 8) & 255, value & 255, 255);
  }

  private oldArgbColor(color: number) {
    const value = color >>> 0;
    return new Color((value >> 16) & 255, (value >> 8) & 255, value & 255, (value >> 24) & 255);
  }

  private refreshOldUiButtonSkins() {
    for (const button of this.oldUiButtons) this.applyOldUiButtonSkin(button);
  }

  private refreshOldPopupFrames() {
    if (this.inventoryPopupFrame) this.applyOldPopupFrame(this.inventoryPopupFrame);
    if (this.statsPopupFrame) this.applyOldPopupFrame(this.statsPopupFrame);
    if (this.skillPopupFrame) this.applyOldPopupFrame(this.skillPopupFrame);
    if (this.companionPopupFrame) this.applyOldPopupFrame(this.companionPopupFrame);
    if (this.enhancePopupFrame) this.applyOldPopupFrame(this.enhancePopupFrame);
    if (this.equipmentDetailPopupFrame) this.applyOldPopupFrame(this.equipmentDetailPopupFrame);
    if (this.companionDetailPopupFrame) this.applyOldPopupFrame(this.companionDetailPopupFrame);
    if (this.revivePopupFrame) this.applyOldPopupFrame(this.revivePopupFrame);
  }

  private refreshStatsPointButtons() {
    if (!this.statsPanel) return;
    for (const child of this.statsPanel.children) {
      const kind = child.name.startsWith('StatsAdd_') ? 'add' : child.name.startsWith('StatsReduce_') ? 'reduce' : '';
      if (!kind) continue;
      const sprite = child.getComponent(Sprite);
      if (sprite) sprite.spriteFrame = this.statPointFrames[kind] ?? null;
    }
  }

  private createSlotNode(name: string, oldX: number, oldY: number, slot?: EquipmentSlotKey, iconSize = INVENTORY_ICON_SIZE): EquipmentSlotView {
    const node = new Node(name);
    if (this.inventoryPanel) node.parent = this.inventoryPanel;
    node.setPosition(...this.oldInventoryCenter(oldX, oldY, iconSize, iconSize), 0);
    node.addComponent(UITransform).setContentSize(iconSize * INVENTORY_UI_SCALE, iconSize * INVENTORY_UI_SCALE);
    const bg = node.addComponent(Graphics);
    return { node, bg, slot: slot ?? 'weapon', iconSize, uiScale: INVENTORY_UI_SCALE };
  }

  private loadInventoryAssets() {
    resources.load('ui/inventory/equipment_back/spriteFrame', SpriteFrame, (err, frame) => {
      if (!err && frame) {
        this.equipmentBackFrame = frame;
        if (this.equipmentBackSprite) this.equipmentBackSprite.spriteFrame = frame;
      }
    });
    resources.load('ui/inventory/coin/spriteFrame', SpriteFrame, (err, frame) => {
      if (!err && frame) this.coinFrame = frame;
    });
    resources.load(`${DROP_CHEST_RESOURCE}/spriteFrame`, SpriteFrame, (err, frame) => {
      if (!err && frame) this.dropChestFrame = frame;
    });
    DROP_CHEST_QUALITY_RESOURCES.forEach((resource, quality) => {
      resources.load(`${resource}/spriteFrame`, SpriteFrame, (err, frame) => {
        if (!err && frame) this.dropChestQualityFrames[quality] = frame;
      });
    });
    resources.load('ui/main_button/normal/spriteFrame', SpriteFrame, (err, frame) => {
      if (err || !frame) return;
      this.mainMenuButtonFrames.normal = frame;
      this.refreshMainMenuButtonSkins();
    });
    resources.load('ui/main_button/pressed/spriteFrame', SpriteFrame, (err, frame) => {
      if (err || !frame) return;
      this.mainMenuButtonFrames.pressed = frame;
      this.refreshMainMenuButtonSkins();
    });
    for (const state of ['normal', 'hover', 'pressed'] as OldUiButtonState[]) {
      for (const part of ['left', 'mid', 'right']) {
        const key = `button_${state}_${part}`;
        resources.load(`ui/old/${key}/spriteFrame`, SpriteFrame, (err, frame) => {
          if (err || !frame) return;
          this.oldUiButtonFrames[key] = frame;
          this.refreshOldUiButtonSkins();
        });
      }
    }
    const popupKeys = [
      'popup_top_left', 'popup_top_mid', 'popup_top_right',
      'popup_bottom_left', 'popup_bottom_mid', 'popup_bottom_right',
      'popup_inner_top_left', 'popup_inner_top_right',
      'popup_inner_left_top', 'popup_inner_left_bottom',
      'popup_inner_bottom_left', 'popup_inner_bottom_right',
      'popup_inner_right_top', 'popup_inner_right_bottom',
    ];
    for (const key of popupKeys) {
      resources.load(`ui/old/${key}/spriteFrame`, SpriteFrame, (err, frame) => {
        if (err || !frame) return;
        this.oldUiPopupFrames[key] = frame;
        this.refreshOldPopupFrames();
      });
    }
    for (const [kind, key] of [['add', 'stat_point_add'], ['reduce', 'stat_point_reduce']] as const) {
      resources.load(`ui/old/${key}/spriteFrame`, SpriteFrame, (err, frame) => {
        if (err || !frame) return;
        this.statPointFrames[kind] = frame;
        this.refreshStatsPointButtons();
      });
    }
  }

  private loadEquipmentCatalog() {
    resources.load('equipment/equipment_catalog', JsonAsset, (err, asset) => {
      if (err || !asset) return;
      const catalog = asset.json as InventoryCatalog;
      const items = (catalog.items ?? []).map((item) => this.normalizeCatalogItem(item));
      this.setEquipmentCatalog(items);
    });
  }

  private loadMonsterDropRewards() {
    resources.load('rewards/monster_drop_rewards', JsonAsset, (err, asset) => {
      if (err || !asset) return;
      const catalog = asset.json as MonsterDropRewardsCatalog;
      const byId: Record<number, MonsterDropReward> = {};
      for (const reward of catalog.rewards ?? []) {
        const id = this.toNumber(reward.id, 0);
        if (id <= 0) continue;
        byId[id] = reward;
      }
      this.dropRewardsById = byId;
      this.defaultDropRewardByMonsterImageId = this.defaultRewardMap(catalog.defaultsByMonsterImageId ?? [], 'monsterImageId');
      this.defaultDropRewardByMapId = this.defaultRewardMap(catalog.defaultsByMapId ?? [], 'mapId');
      for (const monster of this.monsters) {
        if (!monster.node.isValid) continue;
        monster.rewardId = this.resolveMonsterRewardId(monster.config);
        monster.level = this.resolveMonsterLevel(monster.config, monster.rewardId);
      }
    });
  }

  private defaultRewardMap(rows: MonsterRewardDefault[], key: 'monsterImageId' | 'mapId') {
    const result: Record<number, number> = {};
    for (const row of rows) {
      const id = this.toNumber(row[key], -1);
      const rewardId = this.toNumber(row.rewardId, 0);
      if (id >= 0 && rewardId > 0) result[id] = rewardId;
    }
    return result;
  }

  private setEquipmentCatalog(items: EquipmentCatalogItem[]) {
    const byId: Record<number, EquipmentCatalogItem> = {};
    for (const item of items) {
      if (this.isBaseEquipmentCatalogItem(item)) byId[item.id] = item;
    }
    for (const editable of this.equipmentConfigs) {
      const item = this.editableEquipmentItem(editable, byId[editable.id]);
      if (item.id > 0) byId[item.id] = item;
    }
    byId[ENHANCE_TIAN_JING_ITEM_ID] = this.enhanceMaterialCatalogItem('tianJingStone');
    byId[ENHANCE_PROTECT_ITEM_ID] = this.enhanceMaterialCatalogItem('protectStone');
    this.equipmentById = byId;
    this.equipmentCatalog = Object.keys(byId).map((id) => byId[Number(id)]).sort((a, b) => a.id - b.id);
    if (this.pendingSavedInventory) {
      if (!this.applyPersistedInventoryState(this.pendingSavedInventory)) this.initializeNewCharacterInventory();
      this.pendingSavedInventory = null;
    } else if (!this.inventoryInitialized) {
      this.initializeNewCharacterInventory();
    }
    this.renderInventoryUi();
  }

  private isBaseEquipmentCatalogItem(item: EquipmentCatalogItem) {
    const id = Math.floor(this.toNumber(item.id, 0));
    if (id <= 0 || id % 100 !== 0) return false;
    return !/\+\d+$/.test(item.name);
  }

  private normalizeCatalogItem(item: EquipmentCatalogItem): EquipmentCatalogItem {
    const slot = this.normalizeBaseSlot(String(item.slot ?? 'weapon'));
    const quality = this.toNumber(item.quality, 0);
    const requiredRace = this.toNumber(item.requiredRace, -1);
    const stats = item.stats ?? {};
    return {
      id: this.toNumber(item.id, 0),
      name: String(item.name ?? ''),
      goodsType: this.toNumber(item.goodsType, this.goodsTypeForSlot(slot)),
      kind: String(item.kind ?? this.kindForSlot(slot)),
      slot,
      slotName: item.slotName || this.slotDisplayName(slot),
      icon: this.toNumber(item.icon, 0),
      iconPath: String(item.iconPath ?? ''),
      quality,
      qualityName: item.qualityName || QUALITY_NAMES[quality] || formatGameText(GAME_TEXT.inventory.fallbackQuality, { quality }),
      requiredRace,
      profession: item.profession || (requiredRace >= 0 ? PROFESSION_NAMES[requiredRace] : GAME_TEXT.inventory.commonProfession),
      requiredLevel: this.toNumber(item.requiredLevel, 0),
      requiredTurn: this.toNumber(item.requiredTurn, 0),
      moneyCost: this.toNumber(item.moneyCost, 0),
      treasureCost: this.toNumber(item.treasureCost, 0),
      appearanceId: this.resolveConfiguredAppearanceId(item.appearanceId, stats.appearanceId),
      description: String(item.description ?? ''),
      stats,
    };
  }

  private editableEquipmentItem(config: EditableEquipmentConfig, fallback?: EquipmentCatalogItem): EquipmentCatalogItem {
    const slot = this.normalizeBaseSlot(config.slot || fallback?.slot || 'weapon');
    const quality = this.toNumber(config.quality, fallback?.quality ?? 0);
    const requiredRace = this.toNumber(config.requiredRace, fallback?.requiredRace ?? -1);
    const stats = { ...(fallback?.stats ?? {}) };
    const statKeys: Array<keyof EditableEquipmentConfig> = [
      'minPhysicalDamage', 'maxPhysicalDamage', 'minMagicDamage', 'maxMagicDamage',
      'physicalDefense', 'magicDefense', 'lifeRaised', 'manaRaised',
      'hittingAbility', 'evadingAbility', 'attackTime', 'attackRange',
    ];
    for (const key of statKeys) {
      const value = Number(config[key]);
      if (Number.isFinite(value) && value !== 0) stats[key] = value;
    }
    return {
      id: this.toNumber(config.id, fallback?.id ?? 0),
      name: config.name || fallback?.name || formatGameText(GAME_TEXT.inventory.fallbackEquipment, { id: config.id }),
      goodsType: fallback?.goodsType ?? this.goodsTypeForSlot(slot),
      kind: fallback?.kind ?? this.kindForSlot(slot),
      slot,
      slotName: this.slotDisplayName(slot),
      icon: fallback?.icon ?? 0,
      iconPath: config.iconPath || fallback?.iconPath || '',
      quality,
      qualityName: QUALITY_NAMES[quality] || formatGameText(GAME_TEXT.inventory.fallbackQuality, { quality }),
      requiredRace,
      profession: requiredRace >= 0 ? PROFESSION_NAMES[requiredRace] : GAME_TEXT.inventory.commonProfession,
      requiredLevel: this.toNumber(config.requiredLevel, fallback?.requiredLevel ?? 0),
      requiredTurn: this.toNumber(config.requiredTurn, fallback?.requiredTurn ?? 0),
      moneyCost: this.toNumber(config.moneyCost, fallback?.moneyCost ?? 0),
      treasureCost: this.toNumber(config.treasureCost, fallback?.treasureCost ?? 0),
      appearanceId: this.resolveConfiguredAppearanceId(config.appearanceId, fallback?.appearanceId),
      description: config.description || fallback?.description || '',
      stats,
    };
  }

  private enhanceMaterialCatalogItem(materialId: EnhanceMaterialId): EquipmentCatalogItem {
    const isProtect = materialId === 'protectStone';
    return {
      id: isProtect ? ENHANCE_PROTECT_ITEM_ID : ENHANCE_TIAN_JING_ITEM_ID,
      name: isProtect ? GAME_TEXT.enhance.protectStoneName : GAME_TEXT.enhance.tianJingStoneName,
      goodsType: 9,
      kind: 'material',
      slot: 'material',
      slotName: GAME_TEXT.inventory.material,
      icon: isProtect ? 2 : 1,
      iconPath: '',
      quality: isProtect ? 3 : 1,
      qualityName: QUALITY_NAMES[isProtect ? 3 : 1] || '',
      requiredRace: -1,
      profession: GAME_TEXT.inventory.commonProfession,
      requiredLevel: 0,
      requiredTurn: 0,
      moneyCost: 1,
      treasureCost: 0,
      materialId,
      maxStack: 9999,
      description: '',
      stats: {},
    };
  }

  private resolveConfiguredAppearanceId(...values: unknown[]) {
    for (const value of values) {
      const id = Math.floor(this.toNumber(value, -1));
      if (id >= 0) return id;
    }
    return -1;
  }

  private prepareInventoryRuntimeState() {
    if (this.resetSaveOnStart) this.clearLocalSave();
    if (this.loadPersistedInventoryState()) return;
    this.initializeNewCharacterInventoryState();
  }

  private loadPersistedInventoryState() {
    this.initializeNewCharacterInventoryState();
    const raw = this.readLocalSave();
    if (!raw) return false;
    let save: GameSaveData | null = null;
    try {
      save = JSON.parse(raw) as GameSaveData;
    } catch {
      return false;
    }
    if (!save || save.version !== 1 || !save.hero || !save.inventory) return false;

    const roleId = this.normalizeHeroRoleId(save.hero.roleId);
    this.heroRoleId = roleId;
    this.heroAppearanceId = this.normalizedSavedAppearance(roleId, save.hero.appearanceId);
    this.heroLevel = this.clamp(Math.floor(this.toNumber(save.hero.level, 1)), 1, 60);
    this.heroExp = Math.max(0, Math.floor(this.toNumber(save.hero.exp, 0)));
    const race = this.currentHeroRace();
    this.heroStrength = Math.max(0, Math.floor(this.toNumber(save.hero.strength, heroBaseStrength(this.heroLevel, race))));
    this.heroDexterity = Math.max(0, Math.floor(this.toNumber(save.hero.dexterity, heroBaseDexterity(this.heroLevel, race))));
    this.heroWisdom = Math.max(0, Math.floor(this.toNumber(save.hero.wisdom, heroBaseWisdom(this.heroLevel, race))));
    this.heroUnassignedPoints = Math.max(0, Math.floor(this.toNumber(save.hero.unassignedPoints, 0)));
    this.pendingStrengthPoints = 0;
    this.pendingDexterityPoints = 0;
    this.pendingWisdomPoints = 0;
    this.pendingSavedHp = Math.max(0, this.toNumber(save.hero.hp, 0));
    this.pendingSavedMana = Math.max(0, this.toNumber(save.hero.mana, 0));
    this.pendingSavedInventory = save.inventory;
    this.pendingSavedSkills = save.skills ?? null;
    return true;
  }

  private initializeNewCharacterInventoryState() {
    this.inventorySlots = Array.from({ length: INVENTORY_BAG_SIZE }, () => null);
    this.equippedSlots = defaultEquippedSlots();
    this.inventoryInitialized = false;
    this.inventoryPage = 0;
    this.selectedInventoryItem = null;
    this.selectedEquipment = null;
    this.selectedEnhanceItem = null;
    this.selectedEnhanceStone = null;
    this.selectedEnhanceProtectStone = null;
    this.enhanceUseProtectStone = false;
    this.depotMoney = INVENTORY_GOLD_DEFAULT;
    this.depotTreasure = INVENTORY_TREASURE_DEFAULT;
    this.enhanceTianJingStone = ENHANCE_TIAN_JING_DEFAULT;
    this.enhanceProtectStone = ENHANCE_PROTECT_STONE_DEFAULT;
    this.pendingSavedInventory = null;
    this.pendingSavedSkills = null;
    this.pendingSavedHp = null;
    this.pendingSavedMana = null;
  }

  private normalizedSavedAppearance(roleId: HeroRoleId, value: unknown) {
    const max = this.heroAppearanceCount(roleId) - 1;
    const id = Math.floor(this.toNumber(value, DEFAULT_HERO_APPEARANCE_ID));
    return this.clamp(Number.isFinite(id) ? id : DEFAULT_HERO_APPEARANCE_ID, 0, max);
  }

  private applyPersistedInventoryState(saved: GameSaveData['inventory']) {
    const slots = Array.from({ length: INVENTORY_BAG_SIZE }, (_, index) => this.savedEquipmentInstance(saved.slots?.[index] ?? null));
    const equipped = defaultEquippedSlots();
    for (const key of Object.keys(equipped) as EquipmentSlotKey[]) {
      equipped[key] = this.savedEquipmentInstance(saved.equipped?.[key] ?? null);
    }
    this.inventorySlots = slots;
    this.equippedSlots = equipped;
    this.inventoryInitialized = true;
    this.inventoryPage = this.clamp(Math.floor(this.toNumber(saved.page, 0)), 0, this.inventoryPageCount() - 1);
    this.selectedInventoryItem = null;
    this.selectedEquipment = null;
    this.selectedEnhanceItem = null;
    this.selectedEnhanceStone = null;
    this.selectedEnhanceProtectStone = null;
    this.enhanceUseProtectStone = false;
    this.depotMoney = Math.max(0, Math.floor(this.toNumber(saved.money, INVENTORY_GOLD_DEFAULT)));
    this.depotTreasure = Math.max(0, Math.floor(this.toNumber(saved.treasure, INVENTORY_TREASURE_DEFAULT)));
    this.enhanceTianJingStone = Math.max(0, Math.floor(this.toNumber(saved.tianJingStone, ENHANCE_TIAN_JING_DEFAULT)));
    this.enhanceProtectStone = Math.max(0, Math.floor(this.toNumber(saved.protectStone, ENHANCE_PROTECT_STONE_DEFAULT)));
    if (this.totalMaterialQuantity('tianJingStone') <= 0 && this.enhanceTianJingStone > 0) this.addMaterialStack('tianJingStone', this.enhanceTianJingStone);
    if (this.totalMaterialQuantity('protectStone') <= 0 && this.enhanceProtectStone > 0) this.addMaterialStack('protectStone', this.enhanceProtectStone);
    this.recalculateHeroStats(false);
    this.applyPendingSavedVitals();
    this.syncEquippedHeroAppearance();
    return true;
  }

  private savedEquipmentInstance(saved: SavedEquipmentInstance | null | undefined): EquipmentInstance | null {
    if (!saved) return null;
    const item = this.equipmentById[Math.floor(this.toNumber(saved.itemId, 0))];
    if (!item) return null;
    return {
      uid: String(saved.uid || `${item.id}:save:${Date.now()}:${Math.floor(Math.random() * 100000)}`),
      item,
      locked: !!saved.locked,
      statRollPercent: this.clamp(Math.round(this.toNumber(saved.statRollPercent, 50)), 0, 100),
      enhanceLevel: Math.max(0, Math.floor(this.toNumber(saved.enhanceLevel, 0))),
      quantity: this.isMaterialItem(item) ? Math.max(1, Math.floor(this.toNumber(saved.quantity, 1))) : undefined,
    };
  }

  private applyPendingSavedVitals() {
    if (this.pendingSavedHp !== null) {
      this.heroCurrentHp = this.clampHp(this.pendingSavedHp, this.heroMaxHp);
      this.pendingSavedHp = null;
    }
    if (this.pendingSavedMana !== null) {
      this.heroCurrentMana = this.clampHp(this.pendingSavedMana, this.heroMaxMana);
      this.pendingSavedMana = null;
    }
    this.heroDead = this.heroMaxHp > 0 && this.heroCurrentHp <= 0;
    this.updateHeroHpUi();
    if (this.heroDead) {
      this.autoBattleEnabled = false;
      this.refreshAutoBattleButton();
      this.setHeroDeathClip();
      this.showRevivePrompt();
    }
  }

  private applyPersistedSkillState(saved: GameSaveData['skills']) {
    const restored: SkillInstance[] = [];
    const race = this.currentHeroRace();
    for (const row of saved.learned ?? []) {
      const skill = this.skillById[Math.floor(this.toNumber(row.id, 0))];
      if (!skill) continue;
      if (!this.isHeroLearnableSkill(skill, race) && skill.race !== race) continue;
      restored.push({
        skill,
        experience: Math.max(0, Math.floor(this.toNumber(row.experience, 0))),
        cooldown: 0,
      });
    }
    if (restored.length) {
      this.learnedSkills = restored;
      const savedSelected = this.skillById[Math.floor(this.toNumber(saved.selectedSkillId, 0))];
      this.selectedSkillId = savedSelected && restored.some((instance) => instance.skill.id === savedSelected.id)
        ? Math.floor(this.toNumber(saved.selectedSkillId, 0))
        : restored[0].skill.id;
    } else {
      this.initializeLearnedSkills();
    }
    this.pendingSavedSkills = null;
  }

  private queueSaveGameProgress() {
    this.saveDirty = true;
  }

  private updateAutoSave(dt: number) {
    if (!this.saveDirty) return;
    this.saveTimer += dt;
    if (this.saveTimer < AUTO_SAVE_INTERVAL_SECONDS) return;
    this.saveGameProgress();
  }

  private saveGameProgress() {
    if (!this.inventoryInitialized) return;
    const save: GameSaveData = {
      version: 1,
      savedAt: Date.now(),
      hero: {
        roleId: this.normalizedHeroRoleId(),
        appearanceId: this.normalizedHeroAppearanceId(),
        level: this.heroLevel,
        exp: this.heroExp,
        strength: this.heroStrength,
        dexterity: this.heroDexterity,
        wisdom: this.heroWisdom,
        unassignedPoints: this.heroUnassignedPoints,
        hp: this.heroCurrentHp,
        mana: this.heroCurrentMana,
      },
      inventory: {
        slots: this.inventorySlots.map((instance) => this.savedEquipmentPayload(instance)),
        equipped: this.savedEquippedPayload(),
        page: this.inventoryPage,
        money: this.depotMoney,
        treasure: this.depotTreasure,
        tianJingStone: this.totalMaterialQuantity('tianJingStone'),
        protectStone: this.totalMaterialQuantity('protectStone'),
      },
      skills: {
        selectedSkillId: this.selectedSkillId,
        learned: this.learnedSkills.map((instance) => ({
          id: instance.skill.id,
          experience: instance.experience,
        })),
      },
    };
    try {
      sys.localStorage.setItem(this.localSaveKey(), JSON.stringify(save));
      this.saveDirty = false;
      this.saveTimer = 0;
    } catch {
      this.saveDirty = true;
      this.saveTimer = 0;
    }
  }

  private savedEquippedPayload() {
    const equipped: Partial<Record<EquipmentSlotKey, SavedEquipmentInstance | null>> = {};
    for (const key of Object.keys(this.equippedSlots) as EquipmentSlotKey[]) {
      equipped[key] = this.savedEquipmentPayload(this.equippedSlots[key]);
    }
    return equipped;
  }

  private savedEquipmentPayload(instance: EquipmentInstance | null): SavedEquipmentInstance | null {
    if (!instance) return null;
    return {
      itemId: instance.item.id,
      uid: instance.uid,
      locked: !!instance.locked,
      statRollPercent: this.equipmentRollPercent(instance),
      enhanceLevel: this.equipmentEnhanceLevel(instance),
      quantity: this.isMaterialInstance(instance) ? this.materialQuantity(instance) : undefined,
      materialId: this.isMaterialInstance(instance) ? instance.item.materialId : undefined,
    };
  }

  private readLocalSave() {
    try {
      return sys.localStorage.getItem(this.localSaveKey());
    } catch {
      return null;
    }
  }

  private clearLocalSave() {
    try {
      sys.localStorage.removeItem(this.localSaveKey());
    } catch {
      // Local storage may be unavailable on some runtimes.
    }
  }

  private localSaveKey() {
    const slot = String(this.saveSlotId || 'default').replace(/[^a-zA-Z0-9_.-]/g, '_');
    return `${LOCAL_SAVE_KEY_PREFIX}:${slot}:${this.normalizedHeroRoleId()}`;
  }

  private initializeNewCharacterInventory() {
    this.inventorySlots = Array.from({ length: INVENTORY_BAG_SIZE }, () => null);
    this.equippedSlots = defaultEquippedSlots();
    this.selectedInventoryItem = null;
    this.selectedEquipment = null;
    this.selectedEnhanceItem = null;
    this.selectedEnhanceStone = null;
    this.selectedEnhanceProtectStone = null;
    this.enhanceUseProtectStone = false;
    this.inventoryPage = 0;
    this.enhancePage = 0;
    const ids = this.starterEquipmentIds
      .split(',')
      .map((value) => Number(value.trim()))
      .filter((value) => Number.isFinite(value) && value > 0);
    const picked = new Set<number>();
    let cursor = 0;

    const pushItem = (item: EquipmentCatalogItem | undefined) => {
      if (!item || picked.has(item.id) || cursor >= this.inventorySlots.length) return;
      this.inventorySlots[cursor] = this.createEquipmentInstance(item, `starter:${cursor}`);
      cursor++;
      picked.add(item.id);
    };

    for (const id of ids) pushItem(this.equipmentById[id]);
    this.addMaterialStack('tianJingStone', ENHANCE_TIAN_JING_DEFAULT);
    this.addMaterialStack('protectStone', ENHANCE_PROTECT_STONE_DEFAULT);

    this.inventoryInitialized = true;
  }

  private equipInventoryPageSlot(localIndex: number) {
    this.openBagEquipmentDetail(localIndex);
  }

  private openBagEquipmentDetail(localIndex: number) {
    const bagIndex = this.inventoryPage * INVENTORY_PAGE_SIZE + localIndex;
    const instance = this.inventorySlots[bagIndex];
    if (!instance) {
      this.clearEquipmentSelection();
      this.renderInventoryUi();
      return;
    }
    this.selectedInventoryItem = instance;
    this.selectedEquipment = { source: 'bag', instance, bagIndex };
    this.showEquipmentDetail();
    this.renderInventoryUi();
  }

  private openEquippedEquipmentDetail(slot: EquipmentSlotKey) {
    const instance = this.equippedSlots[slot];
    if (!instance) {
      this.clearEquipmentSelection();
      this.renderInventoryUi();
      return;
    }
    this.selectedInventoryItem = instance;
    this.selectedEquipment = { source: 'equipped', instance, equippedSlot: slot };
    this.showEquipmentDetail();
    this.renderInventoryUi();
  }

  private showEquipmentDetail() {
    if (!this.equipmentDetailPanel) return;
    this.equipmentDetailPanel.active = true;
    this.equipmentDetailPanel.setSiblingIndex(this.equipmentDetailPanel.parent?.children.length ?? 0);
  }

  private hideEquipmentDetail() {
    if (this.equipmentDetailPanel) this.equipmentDetailPanel.active = false;
  }

  private clearEquipmentSelection() {
    this.selectedInventoryItem = null;
    this.selectedEquipment = null;
    this.hideEquipmentDetail();
  }

  private equipInventoryItem(index: number) {
    const instance = this.inventorySlots[index];
    if (!instance) {
      this.clearEquipmentSelection();
      this.renderInventoryUi();
      return false;
    }
    this.selectedInventoryItem = instance;
    const error = this.equipmentError(instance.item);
    if (error) {
      this.setInventoryDetail(`${instance.item.name} ${error}`);
      this.renderInventoryUi();
      return false;
    }
    const slot = this.resolveEquipSlot(instance.item);
    if (!slot) {
      this.setInventoryDetail(formatGameText(GAME_TEXT.inventory.cannotEquip, { name: instance.item.name }));
      this.renderInventoryUi();
      return false;
    }
    const old = this.equippedSlots[slot];
    this.equippedSlots[slot] = instance;
    this.inventorySlots[index] = old;
    this.selectedInventoryItem = instance;
    this.setInventoryDetail(formatGameText(GAME_TEXT.inventory.equipped, { name: instance.item.name }));
    this.recalculateHeroStats(false);
    this.syncEquippedHeroAppearance();
    this.renderInventoryUi();
    this.queueSaveGameProgress();
    return true;
  }

  private unequipInventorySlot(slot: EquipmentSlotKey) {
    const instance = this.equippedSlots[slot];
    if (!instance) return false;
    const index = this.inventorySlots.findIndex((item) => item === null);
    if (index < 0) {
      this.setInventoryDetail(GAME_TEXT.inventory.full);
      return false;
    }
    this.inventorySlots[index] = instance;
    this.equippedSlots[slot] = null;
    this.selectedInventoryItem = instance;
    this.setInventoryDetail(formatGameText(GAME_TEXT.inventory.unequipped, { name: instance.item.name }));
    this.recalculateHeroStats(false);
    this.syncEquippedHeroAppearance();
    this.renderInventoryUi();
    this.queueSaveGameProgress();
    return true;
  }

  private equipSelectedEquipment() {
    if (!this.selectedEquipment || this.selectedEquipment.source !== 'bag') {
      this.setInventoryDetail(GAME_TEXT.inventory.selectBagEquipment);
      return;
    }
    const index = this.inventorySlots.indexOf(this.selectedEquipment.instance);
    if (index < 0) {
      this.clearEquipmentSelection();
      this.renderInventoryUi();
      return;
    }
    if (this.equipInventoryItem(index)) this.clearEquipmentSelection();
    this.renderInventoryUi();
    this.queueSaveGameProgress();
  }

  private unequipSelectedEquipment() {
    if (!this.selectedEquipment || this.selectedEquipment.source !== 'equipped') {
      this.setInventoryDetail(GAME_TEXT.inventory.selectEquippedEquipment);
      return;
    }
    if (this.unequipInventorySlot(this.selectedEquipment.equippedSlot)) this.clearEquipmentSelection();
    this.renderInventoryUi();
    this.queueSaveGameProgress();
  }

  private toggleSelectedEquipmentLock() {
    if (!this.selectedEquipment) {
      this.setInventoryDetail(GAME_TEXT.inventory.selectEquipment);
      return;
    }
    this.selectedEquipment.instance.locked = !this.selectedEquipment.instance.locked;
    this.setInventoryDetail(formatGameText(GAME_TEXT.inventory.lockedState, {
      name: this.selectedEquipment.instance.item.name,
      state: this.selectedEquipment.instance.locked ? GAME_TEXT.inventory.locked : GAME_TEXT.inventory.unlocked,
    }));
    this.renderInventoryUi();
    this.queueSaveGameProgress();
  }

  private renderInventoryUi() {
    this.syncSelectedEquipment();
    this.clampInventoryPage();
    this.renderEquipmentSlots();
    this.renderBagSlots();
    this.updateEquipmentPreviewDecorations();
    const race = this.currentHeroRace();
    const profession = PROFESSION_NAMES[race] ?? formatGameText(GAME_TEXT.inventory.fallbackProfession, { race });
    if (this.inventoryLabels.profession) this.inventoryLabels.profession.string = `${profession} Lv.${this.heroLevel}`;
    if (this.selectedInventoryItem) this.setInventoryDetail(this.itemShortLine(this.selectedInventoryItem.item));
    this.renderEquipmentDetailUi();
  }

  private renderEquipmentSlots() {
    for (const key of Object.keys(this.equipmentViews) as EquipmentSlotKey[]) {
      this.renderSlot(this.equipmentViews[key], this.equippedSlots[key], true);
    }
  }

  private renderBagSlots() {
    const offset = this.inventoryPage * INVENTORY_PAGE_SIZE;
    for (let i = 0; i < this.inventoryBagViews.length; i++) {
      this.renderSlot(this.inventoryBagViews[i], this.inventorySlots[offset + i] ?? null, false);
    }
  }

  private renderEnhanceUi() {
    if (!this.enhancePanel) return;
    this.syncSelectedEnhanceItem();
    this.syncSelectedEnhanceMaterials();
    this.clampEnhancePage();
    const selected = this.selectedEnhanceItem;
    const level = selected ? this.equipmentEnhanceLevel(selected) : 0;
    const stoneOwned = this.materialQuantity(this.selectedEnhanceStone);
    const protectOwned = this.materialQuantity(this.selectedEnhanceProtectStone);
    if (!selected || level < 10 || protectOwned <= 0) this.enhanceUseProtectStone = false;

    this.renderEnhanceSlot(this.enhanceStoneSlotView, this.selectedEnhanceStone, !!this.selectedEnhanceStone);
    this.renderEnhanceSlot(this.enhanceItemSlotView, selected, true);
    this.renderEnhanceSlot(this.enhanceProtectSlotView, this.selectedEnhanceProtectStone, !!this.selectedEnhanceProtectStone);
    if (this.enhanceLabels.name) {
      this.enhanceLabels.name.string = selected ? selected.item.name : GAME_TEXT.enhance.emptySlot;
      this.enhanceLabels.name.color = selected ? this.equipmentNameColor(selected.item.quality) : OLD_UI_TITLE_TEXT_COLOR;
    }
    if (this.enhanceLabels.level) this.enhanceLabels.level.string = selected ? formatGameText(GAME_TEXT.enhance.currentLevel, { level }) : '';

    const rate = selected ? Math.round(this.enhanceSystem.getEnhanceRate(level) * 1000) / 10 : 0;
    const goldCost = selected ? this.enhanceSystem.getGoldCost(level) : 0;
    const stoneCost = selected ? this.enhanceSystem.getTianJingStoneCost(level) : 0;
    const protectCost = selected && level >= 10 ? 1 : 0;
    this.setEnhanceLabel('rate', selected ? formatGameText(GAME_TEXT.enhance.rateValue, { rate }) : '');
    this.setEnhanceLabel('gold', selected ? formatGameText(GAME_TEXT.enhance.valuePair, { cost: goldCost, owned: this.depotMoney }) : '', this.depotMoney >= goldCost ? OLD_UI_BODY_TEXT_COLOR : new Color(255, 120, 120, 255));
    this.setEnhanceLabel('stone', selected ? formatGameText(GAME_TEXT.enhance.valuePair, { cost: stoneCost, owned: stoneOwned }) : '', stoneOwned >= stoneCost ? OLD_UI_BODY_TEXT_COLOR : new Color(255, 120, 120, 255));
    this.setEnhanceLabel('protect', selected ? `${formatGameText(GAME_TEXT.enhance.valuePair, { cost: protectCost, owned: protectOwned })}${level < 10 ? ` ${GAME_TEXT.enhance.protectAfterTen}` : ''}` : '', protectOwned >= protectCost ? OLD_UI_BODY_TEXT_COLOR : new Color(255, 120, 120, 255));
    this.renderEnhanceProtectToggle(!!selected && level >= 10 && protectOwned > 0);

    const offset = this.enhancePage * ENHANCE_PAGE_SIZE;
    for (let i = 0; i < this.enhanceBagViews.length; i++) {
      const instance = this.inventorySlots[offset + i] ?? null;
      this.renderEnhanceSlot(this.enhanceBagViews[i], instance, instance === selected || instance === this.selectedEnhanceStone || instance === this.selectedEnhanceProtectStone);
    }
  }

  private renderEnhanceSlot(view: InventorySlotView | null | undefined, instance: EquipmentInstance | null, selected: boolean) {
    if (!view) return;
    const iconSize = view.iconSize ?? INVENTORY_ICON_SIZE;
    const uiScale = view.uiScale ?? ENHANCE_UI_SCALE;
    view.node.removeAllChildren();
    this.drawInventorySlot(view.bg, instance?.item.quality ?? -1, selected, iconSize, uiScale);
    if (!instance) return;
    this.addItemIcon(view.node, instance.item, iconSize, uiScale);
    if (instance.locked) this.addSlotLockMarker(view.node, iconSize, uiScale);
    this.addEnhanceLevelMarker(view.node, instance, iconSize, uiScale);
    this.addQuantityMarker(view.node, instance, iconSize, uiScale);
  }

  private setEnhanceLabel(key: string, text: string, color = OLD_UI_BODY_TEXT_COLOR) {
    const label = this.enhanceLabels[key];
    if (!label) return;
    label.string = text;
    label.color = color;
  }

  private renderEnhanceProtectToggle(enabled: boolean) {
    if (!this.enhanceProtectBox) return;
    const size = 12 * ENHANCE_UI_SCALE;
    this.enhanceProtectBox.clear();
    this.enhanceProtectBox.fillColor = enabled ? new Color(8, 10, 12, 220) : new Color(35, 35, 35, 160);
    this.enhanceProtectBox.rect(-size / 2, -size / 2, size, size);
    this.enhanceProtectBox.fill();
    this.enhanceProtectBox.strokeColor = enabled ? OLD_UI_BUTTON_TEXT_COLOR : new Color(110, 110, 110, 180);
    this.enhanceProtectBox.lineWidth = 1;
    this.enhanceProtectBox.rect(-size / 2, -size / 2, size, size);
    this.enhanceProtectBox.stroke();
    if (!enabled || !this.enhanceUseProtectStone) return;
    this.enhanceProtectBox.strokeColor = OLD_UI_TITLE_TEXT_COLOR;
    this.enhanceProtectBox.lineWidth = 2;
    this.enhanceProtectBox.moveTo(-size / 4, 0);
    this.enhanceProtectBox.lineTo(-size / 12, -size / 4);
    this.enhanceProtectBox.lineTo(size / 3, size / 4);
    this.enhanceProtectBox.stroke();
  }

  private selectEnhanceBagItem(localIndex: number) {
    const bagIndex = this.enhancePage * ENHANCE_PAGE_SIZE + localIndex;
    const instance = this.inventorySlots[bagIndex];
    if (!instance) {
      this.clearEnhanceSelection();
      this.renderEnhanceUi();
      return;
    }
    if (this.isEnhanceMaterial(instance, 'tianJingStone')) {
      this.selectedEnhanceStone = instance;
      this.setEnhanceResult(this.itemShortLine(instance.item));
      this.renderEnhanceUi();
      return;
    }
    if (this.isEnhanceMaterial(instance, 'protectStone')) {
      this.selectedEnhanceProtectStone = instance;
      if (this.selectedEnhanceItem && this.equipmentEnhanceLevel(this.selectedEnhanceItem) >= 10) this.enhanceUseProtectStone = true;
      this.setEnhanceResult(this.itemShortLine(instance.item));
      this.renderEnhanceUi();
      return;
    }
    this.selectedEnhanceItem = instance;
    if (this.equipmentEnhanceLevel(instance) < 10) this.enhanceUseProtectStone = false;
    else if (this.materialQuantity(this.selectedEnhanceProtectStone) > 0) this.enhanceUseProtectStone = true;
    this.setEnhanceResult(this.itemShortLine(instance.item));
    this.renderEnhanceUi();
  }

  private clearEnhanceSelection() {
    this.selectedEnhanceItem = null;
    this.enhanceUseProtectStone = false;
    this.setEnhanceResult(GAME_TEXT.enhance.selectEquipment);
    this.renderEnhanceUi();
  }

  private syncSelectedEnhanceItem() {
    if (!this.selectedEnhanceItem) return;
    if (this.isMaterialInstance(this.selectedEnhanceItem)) {
      this.selectedEnhanceItem = null;
      this.enhanceUseProtectStone = false;
      return;
    }
    if (this.inventorySlots.indexOf(this.selectedEnhanceItem) >= 0 || this.findEquippedSlot(this.selectedEnhanceItem)) return;
    this.selectedEnhanceItem = null;
    this.enhanceUseProtectStone = false;
  }

  private syncSelectedEnhanceMaterials() {
    if (this.selectedEnhanceStone && (!this.isEnhanceMaterial(this.selectedEnhanceStone, 'tianJingStone') || this.inventorySlots.indexOf(this.selectedEnhanceStone) < 0 || this.materialQuantity(this.selectedEnhanceStone) <= 0)) {
      this.selectedEnhanceStone = null;
    }
    if (this.selectedEnhanceProtectStone && (!this.isEnhanceMaterial(this.selectedEnhanceProtectStone, 'protectStone') || this.inventorySlots.indexOf(this.selectedEnhanceProtectStone) < 0 || this.materialQuantity(this.selectedEnhanceProtectStone) <= 0)) {
      this.selectedEnhanceProtectStone = null;
      this.enhanceUseProtectStone = false;
    }
  }

  private changeEnhancePage(delta: number) {
    const next = this.clamp(Math.floor(this.enhancePage + delta), 0, this.enhancePageCount() - 1);
    if (next === this.enhancePage) return;
    this.enhancePage = next;
    this.clearEnhanceSelection();
    this.renderEnhanceUi();
  }

  private clampEnhancePage() {
    this.enhancePage = this.clamp(Math.floor(this.enhancePage), 0, this.enhancePageCount() - 1);
  }

  private toggleEnhanceProtectStone() {
    if (!this.selectedEnhanceItem) {
      this.setEnhanceResult(GAME_TEXT.enhance.selectEquipment);
      return;
    }
    if (this.equipmentEnhanceLevel(this.selectedEnhanceItem) < 10) {
      this.enhanceUseProtectStone = false;
      this.setEnhanceResult(GAME_TEXT.enhance.protectAfterTen);
      this.renderEnhanceUi();
      return;
    }
    if (this.materialQuantity(this.selectedEnhanceProtectStone) <= 0) {
      this.enhanceUseProtectStone = false;
      this.setEnhanceResult(GAME_TEXT.enhance.notEnoughProtect);
      this.renderEnhanceUi();
      return;
    }
    this.enhanceUseProtectStone = !this.enhanceUseProtectStone;
    this.renderEnhanceUi();
  }

  private enhanceSelectedEquipment() {
    if (!this.selectedEnhanceItem) {
      this.setEnhanceResult(GAME_TEXT.enhance.selectEquipment);
      return;
    }
    this.syncSelectedEnhanceMaterials();
    const equipmentId = this.selectedEnhanceItem.uid;
    const level = this.equipmentEnhanceLevel(this.selectedEnhanceItem);
    const useProtect = this.enhanceUseProtectStone && level >= 10 && this.materialQuantity(this.selectedEnhanceProtectStone) > 0;
    const resources = {
      gold: this.depotMoney,
      tianJingStone: this.materialQuantity(this.selectedEnhanceStone),
      protectStone: useProtect ? this.materialQuantity(this.selectedEnhanceProtectStone) : 0,
    };
    this.enhanceSystem.setContext({
      resources,
      getEquipment: (id) => this.findEquipmentByUid(id),
      removeEquipment: (id) => this.removeEquipmentByUid(id),
      onEquipmentUpdated: () => {
        this.recalculateHeroStats(false);
        this.syncEquippedHeroAppearance();
      },
    });
    const result = this.enhanceSystem.enhanceEquipment(equipmentId, useProtect);
    this.enhanceSystem.setContext(null);
    this.depotMoney = resources.gold;
    this.setMaterialQuantity(this.selectedEnhanceStone, resources.tianJingStone);
    if (useProtect) this.setMaterialQuantity(this.selectedEnhanceProtectStone, resources.protectStone);
    this.enhanceTianJingStone = this.totalMaterialQuantity('tianJingStone');
    this.enhanceProtectStone = this.totalMaterialQuantity('protectStone');
    if (result.destroyed) this.selectedEnhanceItem = null;
    this.setEnhanceResult(this.enhanceResultMessage(result));
    this.renderInventoryUi();
    this.renderEnhanceUi();
    if (result.executed) this.queueSaveGameProgress();
  }

  private findEquipmentByUid(uid: string) {
    for (const instance of this.inventorySlots) {
      if (instance?.uid === uid) return instance;
    }
    for (const key of Object.keys(this.equippedSlots) as EquipmentSlotKey[]) {
      const instance = this.equippedSlots[key];
      if (instance?.uid === uid) return instance;
    }
    return null;
  }

  private removeEquipmentByUid(uid: string) {
    let removedEquipped = false;
    for (let i = 0; i < this.inventorySlots.length; i++) {
      if (this.inventorySlots[i]?.uid === uid) this.inventorySlots[i] = null;
    }
    for (const key of Object.keys(this.equippedSlots) as EquipmentSlotKey[]) {
      if (this.equippedSlots[key]?.uid !== uid) continue;
      this.equippedSlots[key] = null;
      removedEquipped = true;
    }
    if (this.selectedEnhanceItem?.uid === uid) this.selectedEnhanceItem = null;
    if (this.selectedInventoryItem?.uid === uid) this.clearEquipmentSelection();
    if (removedEquipped) {
      this.recalculateHeroStats(false);
      this.syncEquippedHeroAppearance();
    }
  }

  private equipmentEnhanceLevel(instance: EquipmentInstance | null | undefined) {
    const level = Math.floor(this.toNumber(instance?.enhanceLevel, 0));
    return Number.isFinite(level) ? Math.max(0, level) : 0;
  }

  private setEnhanceResult(text: string) {
    this.setEnhanceLabel('result', text.length > 18 ? `${text.slice(0, 17)}...` : text, OLD_UI_BUTTON_TEXT_COLOR);
  }

  private enhanceResultMessage(result: EnhanceResult) {
    switch (result.result) {
      case 'success': return `${GAME_TEXT.enhance.success} +${result.afterLevel ?? 0}`;
      case 'fail_keep': return GAME_TEXT.enhance.failKeep;
      case 'fail_reset': return GAME_TEXT.enhance.failReset;
      case 'fail_destroy': return GAME_TEXT.enhance.failDestroy;
      case 'fail_protected': return GAME_TEXT.enhance.failProtected;
      case 'equipment_not_found': return GAME_TEXT.enhance.equipmentNotFound;
      case 'not_enough_gold': return GAME_TEXT.enhance.notEnoughGold;
      case 'not_enough_tian_jing_stone': return GAME_TEXT.enhance.notEnoughStone;
      case 'not_enough_protect_stone': return GAME_TEXT.enhance.notEnoughProtect;
      default: return GAME_TEXT.enhance.selectEquipment;
    }
  }

  private changeInventoryPage(delta: number) {
    const next = this.clamp(Math.floor(this.inventoryPage + delta), 0, this.inventoryPageCount() - 1);
    if (next === this.inventoryPage) return;
    this.inventoryPage = next;
    this.clearEquipmentSelection();
    this.setInventoryDetail(formatGameText(GAME_TEXT.inventory.page, { page: this.inventoryPage + 1, total: this.inventoryPageCount() }));
    this.renderInventoryUi();
  }

  private sortInventory() {
    const items = this.inventorySlots.filter((item): item is EquipmentInstance => item !== null);
    items.sort((a, b) => (
      this.slotSortIndex(a.item.slot) - this.slotSortIndex(b.item.slot)
      || a.item.quality - b.item.quality
      || a.item.requiredLevel - b.item.requiredLevel
      || a.item.id - b.item.id
    ));
    this.inventorySlots = [
      ...items,
      ...Array.from({ length: Math.max(0, INVENTORY_BAG_SIZE - items.length) }, () => null),
    ];
    this.clearEquipmentSelection();
    this.setInventoryDetail(GAME_TEXT.inventory.sorted);
    this.renderInventoryUi();
    this.queueSaveGameProgress();
  }

  private sellSelectedInventoryItem() {
    if (!this.selectedInventoryItem) {
      this.setInventoryDetail(GAME_TEXT.inventory.selectItem);
      return;
    }
    const bagIndex = this.inventorySlots.indexOf(this.selectedInventoryItem);
    if (bagIndex < 0) {
      if (this.findEquippedSlot(this.selectedInventoryItem)) {
        this.setInventoryDetail(GAME_TEXT.inventory.equippedCannotSell);
        return;
      }
      this.setInventoryDetail(GAME_TEXT.inventory.selectBagItem);
      return;
    }
    if (this.selectedInventoryItem.locked) {
      this.setInventoryDetail(GAME_TEXT.inventory.lockedCannotSell);
      return;
    }

    const item = this.selectedInventoryItem.item;
    const stackCount = this.isMaterialInstance(this.selectedInventoryItem) ? this.materialQuantity(this.selectedInventoryItem) : 1;
    const price = Math.max(1, Math.floor((item.moneyCost || item.treasureCost || item.requiredLevel || 1) / 2)) * stackCount;
    this.inventorySlots[bagIndex] = null;
    this.depotMoney += price;
    this.clearEquipmentSelection();
    this.setInventoryDetail(formatGameText(GAME_TEXT.inventory.sold, { name: item.name, price }));
    this.renderInventoryUi();
    this.queueSaveGameProgress();
  }

  private findEquippedSlot(instance: EquipmentInstance) {
    for (const key of Object.keys(this.equippedSlots) as EquipmentSlotKey[]) {
      if (this.equippedSlots[key] === instance) return key;
    }
    return null;
  }

  private syncSelectedEquipment() {
    if (!this.selectedEquipment) return;
    const instance = this.selectedEquipment.instance;
    const bagIndex = this.inventorySlots.indexOf(instance);
    const equippedSlot = this.findEquippedSlot(instance);
    if (this.selectedEquipment.source === 'bag' && bagIndex >= 0) {
      this.selectedEquipment = { source: 'bag', instance, bagIndex };
      this.selectedInventoryItem = instance;
      return;
    }
    if (this.selectedEquipment.source === 'equipped' && equippedSlot) {
      this.selectedEquipment = { source: 'equipped', instance, equippedSlot };
      this.selectedInventoryItem = instance;
      return;
    }
    if (bagIndex >= 0) {
      this.selectedEquipment = { source: 'bag', instance, bagIndex };
      this.selectedInventoryItem = instance;
      return;
    }
    if (equippedSlot) {
      this.selectedEquipment = { source: 'equipped', instance, equippedSlot };
      this.selectedInventoryItem = instance;
      return;
    }
    this.clearEquipmentSelection();
  }

  private renderEquipmentDetailUi() {
    if (!this.equipmentDetailPanel || !this.equipmentDetailPanel.active) return;
    this.syncSelectedEquipment();
    if (!this.selectedEquipment) return;
    const instance = this.selectedEquipment.instance;
    const item = instance.item;
    const error = this.selectedEquipment.source === 'bag' ? this.equipmentError(item) : '';
    if (this.equipmentDetailIconRoot) {
      this.equipmentDetailIconRoot.removeAllChildren();
      const bg = this.equipmentDetailIconRoot.getComponent(Graphics);
      if (bg) this.drawInventorySlot(bg, item.quality, this.selectedEquipment.source === 'equipped');
      this.addItemIcon(this.equipmentDetailIconRoot, item);
      if (instance.locked) this.addSlotLockMarker(this.equipmentDetailIconRoot);
    }
    this.setEquipmentDetailLabel('name', item.name, this.equipmentNameColor(item.quality));
    const enhanceLevel = this.equipmentEnhanceLevel(instance);
    this.setEquipmentDetailLabel('meta', `${this.equipmentSlotName(item.slot)}  ${item.qualityName || formatGameText(GAME_TEXT.inventory.fallbackQuality, { quality: item.quality })} ${this.equipmentRollPercent(instance)}%${enhanceLevel > 0 ? ` +${enhanceLevel}` : ''}`);
    this.setEquipmentDetailLabel(
      'status',
      `${this.selectedEquipment.source === 'equipped' ? GAME_TEXT.inventory.equippedStatus : GAME_TEXT.inventory.bagStatus}  Lv.${item.requiredLevel}${instance.locked ? `  ${GAME_TEXT.inventory.locked}` : ''}${error ? `  ${error}` : ''}`,
    );
    const rows = this.wrappedEquipmentDetailRows(instance);
    const rowCount = Math.max(EQUIPMENT_DETAIL_BASE_ROW_COUNT, rows.length);
    this.resizeEquipmentDetailPanel(this.equipmentDetailHeightForRows(rowCount));
    for (let i = 0; i < rowCount; i++) {
      this.ensureEquipmentDetailStatLabel(i);
      this.setEquipmentDetailLabel(`stat${i}`, rows[i] ?? '');
    }
    for (let i = rowCount; this.equipmentDetailLabels[`stat${i}`]; i++) this.setEquipmentDetailLabel(`stat${i}`, '');

    const fromBag = this.selectedEquipment.source === 'bag';
    if (this.equipmentDetailSellButton) this.equipmentDetailSellButton.active = fromBag;
    if (this.equipmentDetailEquipButton) this.equipmentDetailEquipButton.active = fromBag;
    if (this.equipmentDetailUnequipButton) this.equipmentDetailUnequipButton.active = !fromBag;
    if (this.equipmentDetailLockButton) this.equipmentDetailLockButton.active = true;
    this.positionEquipmentDetailButton(this.equipmentDetailLockButton, fromBag ? 68 : 38);
    this.positionEquipmentDetailButton(this.equipmentDetailUnequipButton, 98);
    this.positionEquipmentDetailButton(this.equipmentDetailEquipButton, 128);
    this.positionEquipmentDetailButton(this.equipmentDetailSellButton, 8);
    this.setOldUiButtonText(this.equipmentDetailLockButton, instance.locked ? GAME_TEXT.ui.unlock : GAME_TEXT.ui.lock);
  }

  private setEquipmentDetailLabel(key: string, text: string, color?: Color) {
    const label = this.equipmentDetailLabels[key];
    if (!label) return;
    label.string = text;
    label.color = color ?? OLD_UI_BODY_TEXT_COLOR;
  }

  private equipmentDetailHeightForRows(rowCount: number) {
    const lastRowY = EQUIPMENT_DETAIL_ROW_START_Y + Math.max(0, rowCount - 1) * EQUIPMENT_DETAIL_ROW_GAP;
    const neededHeight = lastRowY + OLD_UI_BUTTON_HEIGHT + EQUIPMENT_DETAIL_TEXT_BOTTOM_PADDING + OLD_UI_BUTTON_OLD_HEIGHT + EQUIPMENT_DETAIL_BUTTON_BOTTOM_GAP;
    return Math.max(EQUIPMENT_DETAIL_OLD_HEIGHT, neededHeight);
  }

  private equipmentDetailRows(instance: EquipmentInstance) {
    const item = instance.item;
    if (this.isMaterialInstance(instance)) {
      return [
        `${GAME_TEXT.inventory.quantity}  ${this.materialQuantity(instance)}`,
        `${GAME_TEXT.inventory.price}  ${Math.max(1, Math.floor(item.moneyCost || 1))}`,
      ];
    }
    const rows: string[] = [];
    const physicalMin = this.instanceStat(instance, 'minPhysicalDamage') + this.instanceStat(instance, 'extraMinPhysicalDamage');
    const physicalMax = this.instanceStat(instance, 'maxPhysicalDamage') + this.instanceStat(instance, 'extraMaxPhysicalDamage');
    const magicMin = this.instanceStat(instance, 'minMagicDamage') + this.instanceStat(instance, 'extraMinMagicDamage');
    const magicMax = this.instanceStat(instance, 'maxMagicDamage') + this.instanceStat(instance, 'extraMaxMagicDamage');
    const physicalDefense = this.instanceStat(instance, 'physicalDefense') + this.instanceStat(instance, 'extraPhysicalDefense');
    const magicDefense = this.instanceStat(instance, 'magicDefense') + this.instanceStat(instance, 'extraMagicDefense');
    if (physicalMin || physicalMax) rows.push(`${GAME_TEXT.inventory.physicalAttack}  ${physicalMin}-${Math.max(physicalMin, physicalMax)}`);
    if (magicMin || magicMax) rows.push(`${GAME_TEXT.inventory.magicAttack}  ${magicMin}-${Math.max(magicMin, magicMax)}`);
    if (physicalDefense) rows.push(`${GAME_TEXT.inventory.physicalDefense}  ${physicalDefense}`);
    if (magicDefense) rows.push(`${GAME_TEXT.inventory.magicDefense}  ${magicDefense}`);
    const life = this.instanceStat(instance, 'lifeRaised');
    const mana = this.instanceStat(instance, 'manaRaised');
    if (life) rows.push(`${GAME_TEXT.inventory.maxHp}  +${life}`);
    if (mana) rows.push(`${GAME_TEXT.inventory.maxMana}  +${mana}`);
    const hit = this.instanceStat(instance, 'hittingAbility');
    const evade = this.instanceStat(instance, 'evadingAbility');
    if (hit) rows.push(`${GAME_TEXT.inventory.hit}  +${hit}`);
    if (evade) rows.push(`${GAME_TEXT.inventory.dodge}  +${evade}`);
    const attackTime = this.instanceStat(instance, 'attackTime');
    if (attackTime) rows.push(`${GAME_TEXT.inventory.attackTime}  ${attackTime}`);
    const attackRange = this.instanceStat(instance, 'attackRange');
    if (attackRange) rows.push(`${GAME_TEXT.inventory.attackRange}  ${attackRange}`);
    if (!rows.length && item.description) rows.push(item.description);
    rows.push(`${GAME_TEXT.inventory.price}  ${Math.max(1, Math.floor((item.moneyCost || item.treasureCost || item.requiredLevel || 1) / 2))}`);
    return rows;
  }

  private wrappedEquipmentDetailRows(instance: EquipmentInstance) {
    const rows: string[] = [];
    for (const row of this.equipmentDetailRows(instance)) {
      rows.push(...this.wrapEquipmentDetailText(row));
    }
    return rows;
  }

  private wrapEquipmentDetailText(text: string) {
    const trimmed = text.trim();
    if (!trimmed) return [''];
    const maxUnits = 15;
    const lines: string[] = [];
    let line = '';
    let units = 0;
    for (const char of trimmed) {
      const charUnits = char.charCodeAt(0) > 255 ? 1 : 0.55;
      if (line && units + charUnits > maxUnits) {
        lines.push(line.replace(/\s+$/g, ''));
        line = '';
        units = 0;
      }
      line += char;
      units += charUnits;
    }
    if (line) lines.push(line.replace(/\s+$/g, ''));
    return lines;
  }

  private equipmentSlotName(slot: EquipmentBaseSlot) {
    switch (slot) {
      case 'weapon': return EQUIPMENT_SLOT_LABELS.weapon;
      case 'armor': return EQUIPMENT_SLOT_LABELS.armor;
      case 'helmet': return EQUIPMENT_SLOT_LABELS.helmet;
      case 'boots': return EQUIPMENT_SLOT_LABELS.boots;
      case 'shield': return EQUIPMENT_SLOT_LABELS.shield;
      case 'earbob': return GAME_TEXT.inventory.earring;
      case 'necklace': return EQUIPMENT_SLOT_LABELS.necklace;
      case 'ring': return GAME_TEXT.inventory.ring;
      case 'fashion': return EQUIPMENT_SLOT_LABELS.fashion;
      case 'title': return EQUIPMENT_SLOT_LABELS.title;
      case 'aura': return EQUIPMENT_SLOT_LABELS.aura;
      case 'material': return GAME_TEXT.inventory.material;
      default: return GAME_TEXT.inventory.equipment;
    }
  }

  private slotSortIndex(slot: EquipmentBaseSlot) {
    const order: EquipmentBaseSlot[] = ['weapon', 'armor', 'helmet', 'boots', 'shield', 'earbob', 'necklace', 'ring', 'fashion', 'title', 'aura', 'material'];
    const index = order.indexOf(slot);
    return index >= 0 ? index : order.length;
  }

  private inventoryPageCount() {
    return Math.max(1, Math.ceil(this.inventorySlots.length / INVENTORY_PAGE_SIZE));
  }

  private enhancePageCount() {
    return Math.max(1, Math.ceil(this.inventorySlots.length / ENHANCE_PAGE_SIZE));
  }

  private clampInventoryPage() {
    this.inventoryPage = this.clamp(Math.floor(this.inventoryPage), 0, this.inventoryPageCount() - 1);
  }

  private renderSlot(view: InventorySlotView | undefined, instance: EquipmentInstance | null, equipped: boolean) {
    if (!view) return;
    const iconSize = view.iconSize ?? INVENTORY_ICON_SIZE;
    const uiScale = view.uiScale ?? INVENTORY_UI_SCALE;
    view.node.removeAllChildren();
    this.drawInventorySlot(view.bg, instance?.item.quality ?? -1, equipped, iconSize, uiScale);
    if (!instance) return;
    this.addItemIcon(view.node, instance.item, iconSize, uiScale);
    if (instance.locked) this.addSlotLockMarker(view.node, iconSize, uiScale);
    this.addEnhanceLevelMarker(view.node, instance, iconSize, uiScale);
    this.addQuantityMarker(view.node, instance, iconSize, uiScale);
  }

  private addSlotLockMarker(parent: Node, iconSize = INVENTORY_ICON_SIZE, uiScale = INVENTORY_UI_SCALE) {
    const size = iconSize * uiScale;
    const marker = this.addUiLabel(parent, GAME_TEXT.inventory.lockMarker, size / 2 - 6, size / 2 - 7, 8, OLD_UI_BUTTON_TEXT_COLOR);
    marker.lineHeight = 9;
  }

  private addEnhanceLevelMarker(parent: Node, instance: EquipmentInstance, iconSize = INVENTORY_ICON_SIZE, uiScale = INVENTORY_UI_SCALE) {
    const level = this.equipmentEnhanceLevel(instance);
    if (level <= 0) return;
    const size = iconSize * uiScale;
    const marker = this.addUiLabel(parent, `+${level}`, size / 2 - 8, -size / 2 + 7, 8, OLD_UI_BUTTON_TEXT_COLOR, 'right');
    marker.lineHeight = 9;
  }

  private addQuantityMarker(parent: Node, instance: EquipmentInstance, iconSize = INVENTORY_ICON_SIZE, uiScale = INVENTORY_UI_SCALE) {
    const quantity = this.materialQuantity(instance);
    if (quantity <= 1) return;
    const size = iconSize * uiScale;
    const marker = this.addUiLabel(parent, String(quantity), size / 2 - 4, -size / 2 + 7, 8, OLD_UI_BODY_TEXT_COLOR, 'right');
    marker.lineHeight = 9;
  }

  private addItemIcon(parent: Node, item: EquipmentCatalogItem, iconSize = INVENTORY_ICON_SIZE, uiScale = INVENTORY_UI_SCALE) {
    const size = iconSize * uiScale;
    const path = item.iconPath;
    const frame = path ? this.iconFrames[path] : null;
    if (frame) {
      const icon = new Node(`Icon_${item.id}`);
      parent.addChild(icon);
      icon.addComponent(UITransform).setContentSize(size, size);
      const sprite = icon.addComponent(Sprite);
      sprite.sizeMode = Sprite.SizeMode.CUSTOM;
      sprite.spriteFrame = frame;
    } else {
      const placeholder = new Node(`IconFallback_${item.id}`);
      parent.addChild(placeholder);
      placeholder.addComponent(UITransform).setContentSize(size - 2, size - 2);
      const g = placeholder.addComponent(Graphics);
      g.fillColor = this.qualityColor(item.quality, 180);
      g.rect(-(size - 2) / 2, -(size - 2) / 2, size - 2, size - 2);
      g.fill();
      this.addUiLabel(placeholder, `${item.icon || item.quality}`, 0, -4, 8, Color.WHITE);
    }
    if (path && !frame && !this.requestedIconFrames[path]) {
      this.requestedIconFrames[path] = true;
      resources.load(`${path}/spriteFrame`, SpriteFrame, (err, loaded) => {
        if (!err && loaded) {
          this.iconFrames[path] = loaded;
          this.renderInventoryUi();
          this.renderEnhanceUi();
          this.renderEquipmentDetailUi();
        }
      });
    }
  }

  private drawInventorySlot(g: Graphics, quality: number, equipped: boolean, iconSize = INVENTORY_ICON_SIZE, uiScale = INVENTORY_UI_SCALE) {
    const size = iconSize * uiScale;
    g.clear();
    g.fillColor = equipped ? new Color(18, 18, 20, 220) : new Color(8, 10, 12, 210);
    g.rect(-size / 2, -size / 2, size, size);
    g.fill();
    g.strokeColor = quality >= 0 ? this.qualityColor(quality, 255) : new Color(116, 108, 92, 255);
    g.lineWidth = quality >= 0 ? 2 : 1;
    g.rect(-size / 2, -size / 2, size, size);
    g.stroke();
  }

  private oldInventoryCenter(x: number, y: number, width: number, height: number): [number, number] {
    return [
      (x + width / 2 - INVENTORY_OLD_WIDTH / 2) * INVENTORY_UI_SCALE,
      (INVENTORY_OLD_HEIGHT / 2 - y - height / 2) * INVENTORY_UI_SCALE,
    ];
  }

  private oldPanelCenter(oldPanelWidth: number, oldPanelHeight: number, scale: number, x: number, y: number, width: number, height: number): [number, number] {
    return [
      (x + width / 2 - oldPanelWidth / 2) * scale,
      (oldPanelHeight / 2 - y - height / 2) * scale,
    ];
  }

  private oldInventoryX(x: number) {
    return (x - INVENTORY_OLD_WIDTH / 2) * INVENTORY_UI_SCALE;
  }

  private oldInventoryY(y: number) {
    return (INVENTORY_OLD_HEIGHT / 2 - y) * INVENTORY_UI_SCALE;
  }

  private screenUiBounds() {
    const camera = this.cameraNode?.position ?? this.node.position;
    const visibleSize = view.getVisibleSize();
    const aspect = visibleSize.height > 0 ? visibleSize.width / visibleSize.height : DESIGN_WIDTH / DESIGN_HEIGHT;
    return {
      camera,
      halfScreenWidth: CAMERA_ORTHO_HEIGHT * aspect,
    };
  }

  private mainMenuButtonNodes() {
    return [
      this.autoBattleButton,
      this.statsButton,
      this.inventoryButton,
      this.skillButton,
      this.companionButton,
      this.enhanceButton,
      this.settingsButton,
    ];
  }

  private layoutMainMenuButtons() {
    const { camera, halfScreenWidth } = this.screenUiBounds();
    const gap = MAIN_MENU_BUTTON_GAP;
    const usableWidth = Math.max(1, halfScreenWidth * 2 - MAIN_MENU_BUTTON_HORIZONTAL_PADDING * 2);
    const buttonSize = Math.max(MAIN_MENU_BUTTON_MIN_SIZE, Math.floor((usableWidth - gap * (MAIN_MENU_BUTTON_COUNT - 1)) / MAIN_MENU_BUTTON_COUNT));
    const totalWidth = buttonSize * MAIN_MENU_BUTTON_COUNT + gap * (MAIN_MENU_BUTTON_COUNT - 1);
    const left = camera.x - totalWidth / 2 + buttonSize / 2;
    const bottomY = camera.y - CAMERA_ORTHO_HEIGHT + MAIN_MENU_BUTTON_BOTTOM_MARGIN + buttonSize / 2;
    this.mainMenuButtonNodes().forEach((button, index) => {
      this.resizeMainMenuButton(button, buttonSize);
      button?.setPosition(left + index * (buttonSize + gap), bottomY, 0);
    });
  }

  private layoutInventoryUi() {
    const { camera } = this.screenUiBounds();
    this.layoutMainMenuButtons();
    this.inventoryPanel?.setPosition(camera.x, camera.y, 0);
  }

  private layoutSkillUi() {
    const { camera } = this.screenUiBounds();
    this.skillPanel?.setPosition(camera.x, camera.y, 0);
  }

  private layoutCompanionUi() {
    const { camera } = this.screenUiBounds();
    this.companionPanel?.setPosition(camera.x, camera.y, 0);
  }

  private layoutEnhanceUi() {
    const { camera } = this.screenUiBounds();
    this.enhancePanel?.setPosition(camera.x, camera.y, 0);
  }

  private layoutReviveUi() {
    const { camera } = this.screenUiBounds();
    this.revivePanel?.setPosition(camera.x, camera.y, 0);
  }

  private bringMainMenuButtonsToFront() {
    if (!this.node.parent) return;
    for (const button of this.mainMenuButtonNodes()) button?.setSiblingIndex(this.node.parent.children.length - 1);
  }

  private bringInventoryUiToFront() {
    if (!this.node.parent) return;
    this.bringMainMenuButtonsToFront();
    this.inventoryPanel?.setSiblingIndex(this.node.parent.children.length - 1);
  }

  private bringSkillUiToFront() {
    if (!this.node.parent) return;
    this.bringMainMenuButtonsToFront();
    this.skillPanel?.setSiblingIndex(this.node.parent.children.length - 1);
  }

  private bringCompanionUiToFront() {
    if (!this.node.parent) return;
    this.bringMainMenuButtonsToFront();
    this.companionPanel?.setSiblingIndex(this.node.parent.children.length - 1);
  }

  private bringEnhanceUiToFront() {
    if (!this.node.parent) return;
    this.bringMainMenuButtonsToFront();
    this.enhancePanel?.setSiblingIndex(this.node.parent.children.length - 1);
  }

  private bringReviveUiToFront() {
    if (!this.node.parent) return;
    this.revivePanel?.setSiblingIndex(this.node.parent.children.length - 1);
  }

  private setInventoryDetail(text: string) {
    const label = this.inventoryLabels.detail;
    if (label) label.string = text.length > 22 ? `${text.slice(0, 21)}...` : text;
  }

  private itemShortLine(item: EquipmentCatalogItem) {
    return `${item.name} [${item.qualityName}]`;
  }

  private equipmentError(item: EquipmentCatalogItem) {
    if (item.requiredRace >= 0 && item.requiredRace !== this.currentHeroRace()) return GAME_TEXT.inventory.raceMismatch;
    if (item.requiredLevel > this.heroLevel) return GAME_TEXT.inventory.levelTooLow;
    if (item.requiredTurn > HERO_TURNS) return GAME_TEXT.inventory.turnTooLow;
    return '';
  }

  private resolveEquipSlot(item: EquipmentCatalogItem): EquipmentSlotKey | null {
    switch (item.slot) {
      case 'weapon': return 'weapon';
      case 'armor': return 'armor';
      case 'helmet': return 'helmet';
      case 'boots': return 'boots';
      case 'shield': return 'shield';
      case 'necklace': return 'necklace';
      case 'fashion': return 'fashion';
      case 'title': return 'title';
      case 'aura': return 'aura';
      case 'earbob':
        if (!this.equippedSlots.leftEarbob) return 'leftEarbob';
        if (!this.equippedSlots.rightEarbob) return 'rightEarbob';
        return 'leftEarbob';
      case 'ring':
        if (!this.equippedSlots.leftRing) return 'leftRing';
        if (!this.equippedSlots.rightRing) return 'rightRing';
        return 'leftRing';
      default:
        return null;
    }
  }

  private normalizeBaseSlot(value: string): EquipmentBaseSlot {
    const slot = value as EquipmentBaseSlot;
    if (this.isEquipmentBaseSlot(slot)) return slot;
    return 'weapon';
  }

  private isEquipmentBaseSlot(slot: string): slot is EquipmentBaseSlot {
    switch (slot) {
      case 'weapon':
      case 'armor':
      case 'helmet':
      case 'boots':
      case 'shield':
      case 'earbob':
      case 'necklace':
      case 'ring':
      case 'fashion':
      case 'title':
      case 'aura':
      case 'material':
        return true;
      default:
        return false;
    }
  }

  private slotDisplayName(slot: EquipmentBaseSlot) {
    if (slot === 'material') return GAME_TEXT.inventory.material;
    if (slot === 'earbob') return GAME_TEXT.inventory.earring;
    if (slot === 'ring') return GAME_TEXT.inventory.ring;
    return EQUIPMENT_SLOT_LABELS[slot as EquipmentSlotKey] ?? GAME_TEXT.inventory.equipment;
  }

  private goodsTypeForSlot(slot: EquipmentBaseSlot) {
    if (slot === 'weapon') return 1;
    if (slot === 'armor' || slot === 'helmet' || slot === 'boots' || slot === 'shield') return 2;
    if (slot === 'earbob' || slot === 'necklace' || slot === 'ring' || slot === 'title' || slot === 'aura') return 3;
    if (slot === 'fashion') return 6;
    return 2;
  }

  private kindForSlot(slot: EquipmentBaseSlot) {
    if (slot === 'material') return 'material';
    if (slot === 'weapon') return 'weapon';
    if (slot === 'fashion') return 'fashion';
    if (slot === 'earbob' || slot === 'necklace' || slot === 'ring' || slot === 'title' || slot === 'aura') return 'decoration';
    return 'equipment';
  }

  private qualityColor(quality: number, alpha = 255) {
    const base = QUALITY_COLORS[Math.max(0, Math.min(QUALITY_COLORS.length - 1, quality))] ?? Color.WHITE;
    return new Color(base.r, base.g, base.b, alpha);
  }

  private equipmentNameColor(quality: number) {
    const base = EQUIPMENT_NAME_QUALITY_COLORS[Math.max(0, Math.min(EQUIPMENT_NAME_QUALITY_COLORS.length - 1, quality))] ?? Color.WHITE;
    return new Color(base.r, base.g, base.b, base.a);
  }

  private toNumber(value: unknown, fallback: number) {
    const n = Number(value);
    return Number.isFinite(n) ? n : fallback;
  }

  private addHeroPoint(key: 'strength' | 'dexterity' | 'wisdom') {
    if (this.heroUnassignedPoints <= 0) return;
    this.heroUnassignedPoints--;
    if (key === 'strength') {
      this.pendingStrengthPoints++;
      this.heroStrength++;
    }
    if (key === 'dexterity') {
      this.pendingDexterityPoints++;
      this.heroDexterity++;
    }
    if (key === 'wisdom') {
      this.pendingWisdomPoints++;
      this.heroWisdom++;
    }
    this.recalculateHeroStats(false);
  }

  private reduceHeroPoint(key: 'strength' | 'dexterity' | 'wisdom') {
    if (key === 'strength' && this.pendingStrengthPoints > 0) {
      this.pendingStrengthPoints--;
      this.heroStrength--;
    } else if (key === 'dexterity' && this.pendingDexterityPoints > 0) {
      this.pendingDexterityPoints--;
      this.heroDexterity--;
    } else if (key === 'wisdom' && this.pendingWisdomPoints > 0) {
      this.pendingWisdomPoints--;
      this.heroWisdom--;
    } else {
      return;
    }
    this.heroUnassignedPoints++;
    this.recalculateHeroStats(false);
  }

  private submitStatPoints() {
    const changed = this.pendingStrengthPoints + this.pendingDexterityPoints + this.pendingWisdomPoints > 0;
    this.pendingStrengthPoints = 0;
    this.pendingDexterityPoints = 0;
    this.pendingWisdomPoints = 0;
    this.updateStatsPanel();
    if (changed) this.queueSaveGameProgress();
  }

  private cancelStatPoints() {
    const total = this.pendingStrengthPoints + this.pendingDexterityPoints + this.pendingWisdomPoints;
    if (total <= 0) return;
    this.heroStrength -= this.pendingStrengthPoints;
    this.heroDexterity -= this.pendingDexterityPoints;
    this.heroWisdom -= this.pendingWisdomPoints;
    this.heroUnassignedPoints += total;
    this.pendingStrengthPoints = 0;
    this.pendingDexterityPoints = 0;
    this.pendingWisdomPoints = 0;
    this.recalculateHeroStats(false);
  }

  private layoutStatsUi() {
    const camera = this.cameraNode?.position ?? this.node.position;
    this.layoutMainMenuButtons();
    this.statsPanel?.setPosition(camera.x, camera.y, 0);
  }

  private bringStatsUiToFront() {
    if (!this.node.parent) return;
    this.bringMainMenuButtonsToFront();
    this.statsPanel?.setSiblingIndex(this.node.parent.children.length - 1);
  }

  private createMonsterHpUi(parent: Node) {
    const root = new Node('MonsterHpUi');
    parent.addChild(root);

    const barNode = new Node('MonsterHpBar');
    root.addChild(barNode);
    barNode.addComponent(UITransform).setContentSize(MONSTER_HP_BAR_WIDTH, MONSTER_HP_BAR_HEIGHT);
    const bar = barNode.addComponent(Graphics);

    const labelNode = new Node('MonsterHpLabel');
    root.addChild(labelNode);
    labelNode.setPosition(0, 10, 0);
    const label = labelNode.addComponent(Label);
    label.fontSize = 11;
    label.lineHeight = 12;
    label.color = Color.WHITE;
    return { root, label, bar };
  }

  private layoutMonsterHp(monster: MonsterActor) {
    monster.hpRoot.setPosition(0, Math.max(36, monster.transform.contentSize.height * 0.5 + 14), 0);
  }

  private damageMonster(monster: MonsterActor, damage: number) {
    const actualDamage = Math.max(1, Math.round(damage - monster.defense));
    monster.currentHp = this.clampHp(monster.currentHp - actualDamage, monster.maxHp);
    this.updateMonsterHpUi(monster);
    return actualDamage;
  }

  private updateMonsterAttack(monster: MonsterActor, dt: number) {
    if (!monster.attackActive) {
      monster.attackCooldown -= dt;
      if (monster.attackCooldown > 0) {
        this.setMonsterState(monster, 'idle');
        return;
      }
      const attackClip = this.monsterClip(monster.type, 'attack', monster.dir);
      const attackFrames = this.monsterClips[attackClip] ?? [];
      if (attackFrames.length < 2) {
        this.damageHeroFromMonster(monster);
        monster.attackCooldown = MONSTER_ATTACK_INTERVAL;
        return;
      }
      monster.attackActive = true;
      this.setMonsterState(monster, 'attack');
      monster.frame = 0;
      monster.time = 0;
      this.setMonsterFrame(monster, 0);
    }
  }

  private cancelMonsterAttack(monster: MonsterActor) {
    monster.attackActive = false;
  }

  private cancelAllMonsterAttacks() {
    for (const monster of this.monsters) {
      if (!monster.node.isValid) continue;
      this.cancelMonsterAttack(monster);
      this.setMonsterState(monster, 'idle');
    }
  }

  private damageHeroFromMonster(monster: MonsterActor) {
    if (this.heroDead || this.heroCurrentHp <= 0) return;
    const damage = Math.max(1, Math.round(monster.attack));
    this.heroCurrentHp = this.clampHp(this.heroCurrentHp - damage, this.heroMaxHp);
    this.updateHeroHpUi();
    this.spawnDamageNumber(damage, this.node.position);
    if (this.heroCurrentHp <= 0) this.handleHeroDeath();
  }

  private canMonsterHitHero(monster: MonsterActor) {
    if (this.heroDead || this.heroCurrentHp <= 0 || !monster.node.isValid) return false;
    return Vec3.distance(monster.node.position, this.node.position) <= MONSTER_ATTACK_HIT_RANGE;
  }

  private handleHeroDeath() {
    if (this.heroDead) return;
    this.heroDead = true;
    this.heroCurrentHp = 0;
    this.autoBattleEnabled = false;
    this.refreshAutoBattleButton();
    this.stopHeroAutoBattle();
    this.cancelAllMonsterAttacks();
    this.updateHeroHpUi();
    this.setHeroDeathClip();
    this.showRevivePrompt();
    this.queueSaveGameProgress();
  }

  private showRevivePrompt() {
    if (!this.heroDead || !this.revivePanel || this.revivePromptCooldown > 0) return;
    this.revivePanel.active = true;
  }

  private reviveHero() {
    if (!this.heroDead) return;
    this.heroDead = false;
    this.revivePromptCooldown = 0;
    if (this.revivePanel) this.revivePanel.active = false;
    this.node.setPosition(this.initialHeroPosition.x, this.initialHeroPosition.y, this.initialHeroPosition.z);
    this.heroCurrentHp = this.heroMaxHp;
    this.heroCurrentMana = this.heroMaxMana;
    this.updateHeroHpUi();
    this.autoBattleEnabled = false;
    this.refreshAutoBattleButton();
    this.currentDir = 4;
    this.setHeroIdleClip();
    this.syncCamera();
    this.followCamera();
    this.queueSaveGameProgress();
  }

  private updateHeroHpUi() {
    if (this.heroHpLabel) this.heroHpLabel.string = `${this.heroCurrentHp} / ${this.heroMaxHp}`;
    if (this.heroHpBar) this.drawHpBar(this.heroHpBar, this.heroCurrentHp, this.heroMaxHp, HERO_HP_BAR_WIDTH, HERO_HP_BAR_HEIGHT);
  }

  private recalculateHeroStats(fillHpMana: boolean) {
    const stats = this.heroDerivedStats();
    const hpRatio = this.heroMaxHp > 0 ? this.heroCurrentHp / this.heroMaxHp : 1;
    const manaRatio = this.heroMaxMana > 0 ? this.heroCurrentMana / this.heroMaxMana : 1;
    this.heroMaxHp = stats.maxHp;
    this.heroMaxMana = stats.maxMana;
    this.heroCurrentHp = this.heroDead ? 0 : fillHpMana ? this.heroMaxHp : this.clampHp(this.heroMaxHp * hpRatio, this.heroMaxHp);
    this.heroCurrentMana = fillHpMana ? this.heroMaxMana : this.clampHp(this.heroMaxMana * manaRatio, this.heroMaxMana);
    this.updateHeroHpUi();
    this.updateStatsPanel();
  }

  private heroDerivedStats(): HeroDerivedStats {
    const stats = calculateHeroDerivedStats(this.heroLevel, this.heroStrength, this.heroDexterity, this.heroWisdom, this.currentHeroRace());
    return this.applyEquipmentStats(stats);
  }

  private applyEquipmentStats(stats: HeroDerivedStats): HeroDerivedStats {
    const result = { ...stats };
    for (const instance of this.equippedItems()) {
      result.minPhysicalDamage += this.instanceStat(instance, 'minPhysicalDamage') + this.instanceStat(instance, 'extraMinPhysicalDamage');
      result.maxPhysicalDamage += this.instanceStat(instance, 'maxPhysicalDamage') + this.instanceStat(instance, 'extraMaxPhysicalDamage');
      result.minMagicDamage += this.instanceStat(instance, 'minMagicDamage') + this.instanceStat(instance, 'extraMinMagicDamage');
      result.maxMagicDamage += this.instanceStat(instance, 'maxMagicDamage') + this.instanceStat(instance, 'extraMaxMagicDamage');
      result.physicalDefense += this.instanceStat(instance, 'physicalDefense') + this.instanceStat(instance, 'extraPhysicalDefense');
      result.magicDefense += this.instanceStat(instance, 'magicDefense') + this.instanceStat(instance, 'extraMagicDefense');
      result.physicalDefense += Math.floor((this.instanceStat(instance, 'pdLevelFactor') * this.heroLevel) / 10);
      result.physicalDefense += Math.floor((this.instanceStat(instance, 'pdStrengthFactor') * this.heroStrength) / 100);
      result.physicalDefense += Math.floor((this.instanceStat(instance, 'pdDexterityFactor') * this.heroDexterity) / 100);
      result.physicalDefense += Math.floor((this.instanceStat(instance, 'pdWisdomFactor') * this.heroWisdom) / 100);
      result.magicDefense += Math.floor((this.instanceStat(instance, 'mdLevelFactor') * this.heroLevel) / 10);
      result.magicDefense += Math.floor((this.instanceStat(instance, 'mdStrengthFactor') * this.heroStrength) / 100);
      result.magicDefense += Math.floor((this.instanceStat(instance, 'mdDexterityFactor') * this.heroDexterity) / 100);
      result.magicDefense += Math.floor((this.instanceStat(instance, 'mdWisdomFactor') * this.heroWisdom) / 100);
      result.maxHp += this.instanceStat(instance, 'lifeRaised');
      result.maxMana += this.instanceStat(instance, 'manaRaised');
      result.hittingAbility += this.instanceStat(instance, 'hittingAbility');
      result.evadingAbility += this.instanceStat(instance, 'evadingAbility');
      result.attackTime += this.instanceStat(instance, 'attackTime');
      result.attackRange += this.instanceStat(instance, 'attackRange');
    }
    result.minPhysicalDamage = Math.max(0, Math.round(result.minPhysicalDamage));
    result.maxPhysicalDamage = Math.max(result.minPhysicalDamage, Math.round(result.maxPhysicalDamage));
    result.minMagicDamage = Math.max(0, Math.round(result.minMagicDamage));
    result.maxMagicDamage = Math.max(result.minMagicDamage, Math.round(result.maxMagicDamage));
    result.physicalDefense = Math.max(0, Math.round(result.physicalDefense));
    result.magicDefense = Math.max(0, Math.round(result.magicDefense));
    result.maxHp = Math.max(1, Math.round(result.maxHp));
    result.maxMana = Math.max(0, Math.round(result.maxMana));
    result.attackTime = Math.max(150, Math.round(result.attackTime));
    result.attackRange = this.clamp(Math.round(result.attackRange), HERO_MELEE_ATTACK_RANGE, this.heroMaxVisibleAttackRange());
    return result;
  }

  private equippedItems() {
    const items: EquipmentInstance[] = [];
    for (const key of Object.keys(this.equippedSlots) as EquipmentSlotKey[]) {
      const item = this.equippedSlots[key];
      if (item) items.push(item);
    }
    return items;
  }

  private createEquipmentInstance(item: EquipmentCatalogItem, uidSeed = 'item'): EquipmentInstance {
    return {
      uid: `${item.id}:${uidSeed}:${Date.now()}:${Math.floor(Math.random() * 100000)}`,
      item,
      statRollPercent: Math.floor(Math.random() * 101),
      enhanceLevel: 0,
      quantity: this.isMaterialItem(item) ? 1 : undefined,
    };
  }

  private createMaterialInstance(materialId: EnhanceMaterialId, quantity: number, uidSeed = 'material'): EquipmentInstance {
    const item = this.equipmentById[this.materialItemId(materialId)] ?? this.enhanceMaterialCatalogItem(materialId);
    return {
      uid: `${item.id}:${uidSeed}:${Date.now()}:${Math.floor(Math.random() * 100000)}`,
      item,
      quantity: Math.max(1, Math.floor(quantity)),
      statRollPercent: 50,
      enhanceLevel: 0,
    };
  }

  private materialItemId(materialId: EnhanceMaterialId) {
    return materialId === 'protectStone' ? ENHANCE_PROTECT_ITEM_ID : ENHANCE_TIAN_JING_ITEM_ID;
  }

  private isMaterialItem(item: EquipmentCatalogItem | null | undefined): item is EquipmentCatalogItem & { materialId: EnhanceMaterialId } {
    return item?.slot === 'material' && (item.materialId === 'tianJingStone' || item.materialId === 'protectStone');
  }

  private isMaterialInstance(instance: EquipmentInstance | null | undefined): instance is EquipmentInstance {
    return !!instance && this.isMaterialItem(instance.item);
  }

  private isEnhanceMaterial(instance: EquipmentInstance | null | undefined, materialId: EnhanceMaterialId) {
    return this.isMaterialInstance(instance) && instance.item.materialId === materialId;
  }

  private materialQuantity(instance: EquipmentInstance | null | undefined) {
    if (!this.isMaterialInstance(instance)) return 0;
    return Math.max(0, Math.floor(this.toNumber(instance.quantity, 1)));
  }

  private totalMaterialQuantity(materialId: EnhanceMaterialId) {
    return this.inventorySlots.reduce((sum, instance) => (
      this.isEnhanceMaterial(instance, materialId) ? sum + this.materialQuantity(instance) : sum
    ), 0);
  }

  private addMaterialStack(materialId: EnhanceMaterialId, quantity: number) {
    let remaining = Math.max(0, Math.floor(quantity));
    if (remaining <= 0) return true;
    const maxStack = Math.max(1, Math.floor(this.toNumber(this.equipmentById[this.materialItemId(materialId)]?.maxStack, 9999)));
    for (const instance of this.inventorySlots) {
      if (!this.isEnhanceMaterial(instance, materialId)) continue;
      const current = this.materialQuantity(instance);
      const room = Math.max(0, maxStack - current);
      if (room <= 0) continue;
      const add = Math.min(room, remaining);
      instance.quantity = current + add;
      remaining -= add;
      if (remaining <= 0) return true;
    }
    while (remaining > 0) {
      const index = this.inventorySlots.findIndex((slot) => slot === null);
      if (index < 0) return false;
      const add = Math.min(maxStack, remaining);
      this.inventorySlots[index] = this.createMaterialInstance(materialId, add, 'material');
      remaining -= add;
    }
    return true;
  }

  private removeInventoryInstance(instance: EquipmentInstance | null | undefined) {
    if (!instance) return;
    const index = this.inventorySlots.indexOf(instance);
    if (index >= 0) this.inventorySlots[index] = null;
    if (this.selectedEnhanceItem === instance) this.selectedEnhanceItem = null;
    if (this.selectedEnhanceStone === instance) this.selectedEnhanceStone = null;
    if (this.selectedEnhanceProtectStone === instance) this.selectedEnhanceProtectStone = null;
    if (this.selectedInventoryItem === instance) this.clearEquipmentSelection();
  }

  private consumeMaterial(instance: EquipmentInstance | null | undefined, quantity: number) {
    if (!this.isMaterialInstance(instance)) return false;
    const current = this.materialQuantity(instance);
    const cost = Math.max(0, Math.floor(quantity));
    if (current < cost) return false;
    instance.quantity = current - cost;
    if (this.materialQuantity(instance) <= 0) this.removeInventoryInstance(instance);
    return true;
  }

  private setMaterialQuantity(instance: EquipmentInstance | null | undefined, quantity: number) {
    if (!this.isMaterialInstance(instance)) return;
    instance.quantity = Math.max(0, Math.floor(quantity));
    if (this.materialQuantity(instance) <= 0) this.removeInventoryInstance(instance);
  }

  private equipmentRollPercent(instance: EquipmentInstance) {
    const value = Number(instance.statRollPercent);
    if (!Number.isFinite(value)) {
      instance.statRollPercent = Math.floor(Math.random() * 101);
    } else {
      instance.statRollPercent = this.clamp(Math.round(value), 0, 100);
    }
    return instance.statRollPercent;
  }

  private equipmentRollMultiplier(instance: EquipmentInstance) {
    const ratio = this.equipmentRollPercent(instance) / 100;
    return EQUIPMENT_STAT_ROLL_MIN + (EQUIPMENT_STAT_ROLL_MAX - EQUIPMENT_STAT_ROLL_MIN) * ratio;
  }

  private instanceStat(instance: EquipmentInstance, key: string) {
    const value = this.itemStat(instance.item, key);
    if (value === 0) return 0;
    const rolled = value * this.equipmentRollMultiplier(instance);
    return Number.isInteger(value) ? Math.round(rolled) : rolled;
  }

  private itemStat(item: EquipmentCatalogItem, key: string) {
    const value = item.stats?.[key];
    const n = Number(value);
    return Number.isFinite(n) ? n : 0;
  }

  private updateStatsPanel() {
    const stats = this.heroDerivedStats();
    this.setStatsLabel('points', `${this.heroUnassignedPoints}`);
    this.setStatsLabel('strength', `${this.heroStrength}`);
    this.setStatsLabel('dexterity', `${this.heroDexterity}`);
    this.setStatsLabel('wisdom', `${this.heroWisdom}`);
    this.setStatsLabel('minPhysicalDamage', `${stats.minPhysicalDamage}-${stats.maxPhysicalDamage}`);
    this.setStatsLabel('minMagicDamage', `${stats.minMagicDamage}-${stats.maxMagicDamage}`);
    this.setStatsLabel('physicalDefense', `${stats.physicalDefense}`);
    this.setStatsLabel('magicDefense', `${stats.magicDefense}`);
    this.setStatsLabel('attackTime', `${stats.attackTime}`);
    this.setStatsLabel('hittingAbility', `${stats.hittingAbility}`);
    this.setStatsLabel('evadingAbility', `${stats.evadingAbility}`);
    this.setStatsLabel('pk', '0');
    this.setStatsLabel('turns', '0');
    this.setStatsLabel('merit', '0');
  }

  private setStatsLabel(key: string, value: string) {
    const label = this.statsLabels[key];
    if (label) label.string = value;
  }

  private updateMonsterHpUi(monster: MonsterActor) {
    monster.hpLabel.string = `${monster.currentHp} / ${monster.maxHp}`;
    this.drawHpBar(monster.hpBar, monster.currentHp, monster.maxHp, MONSTER_HP_BAR_WIDTH, MONSTER_HP_BAR_HEIGHT);
  }

  private drawHpBar(bar: Graphics, current: number, max: number, width: number, height: number) {
    const ratio = max <= 0 ? 0 : current / max;
    bar.clear();
    bar.fillColor = new Color(45, 0, 0, 220);
    bar.rect(-width / 2, -height / 2, width, height);
    bar.fill();
    bar.fillColor = new Color(210, 36, 32, 235);
    bar.rect(-width / 2, -height / 2, width * ratio, height);
    bar.fill();
    bar.strokeColor = new Color(0, 0, 0, 230);
    bar.lineWidth = 1;
    bar.rect(-width / 2, -height / 2, width, height);
    bar.stroke();
  }

  private clampHp(value: number, max: number) {
    return Math.max(0, Math.min(max, Math.round(value)));
  }

  private rollHeroHit() {
    const crit = Math.random() < TEMP_CRIT_RATE;
    const stats = this.heroDerivedStats();
    const base = stats.minPhysicalDamage + Math.random() * (stats.maxPhysicalDamage - stats.minPhysicalDamage + 1);
    return {
      damage: Math.floor(base) * (crit ? TEMP_CRIT_MULTIPLIER : 1),
      crit,
    };
  }

  private spawnDamageNumber(value: number, position: Readonly<Vec3>, crit = false) {
    if (crit) this.spawnFloatingText(['text_crit'], position, DAMAGE_TEXT_OFFSET_Y + 22);
    const keys = ['damage_minus'].concat(`${Math.max(0, Math.round(value))}`.split('').map((digit) => `damage_${digit}`));
    this.spawnFloatingText(keys, position, DAMAGE_TEXT_OFFSET_Y);
  }

  private spawnHealNumber(value: number, position: Readonly<Vec3>) {
    const keys = ['heal_plus'].concat(`${Math.max(0, Math.round(value))}`.split('').map((digit) => `heal_${digit}`));
    this.spawnFloatingText(keys, position, DAMAGE_TEXT_OFFSET_Y);
  }

  private spawnFloatingText(keys: string[], position: Readonly<Vec3>, yOffset: number) {
    if (!this.node.parent) return;
    const frames = keys.map((key) => this.damageTextFrames[key]).filter((frame): frame is SpriteFrame => !!frame);
    if (!frames.length) return;
    const root = new Node('FloatingDamageText');
    root.parent = this.node.parent;
    root.setPosition(position.x, position.y + yOffset, 0);
    let totalWidth = Math.max(0, DAMAGE_TEXT_GAP * (frames.length - 1));
    const widths = frames.map((frame) => {
      const width = frame.getRect().width;
      totalWidth += width;
      return width;
    });
    let x = -totalWidth / 2;
    frames.forEach((frame, index) => {
      const child = new Node('DamageGlyph');
      root.addChild(child);
      const transform = child.addComponent(UITransform);
      const sprite = child.addComponent(Sprite);
      this.applyFrame(sprite, transform, frame);
      child.setPosition(x + widths[index] / 2, 0, 0);
      x += widths[index] + DAMAGE_TEXT_GAP;
    });
    this.floatingTexts.push({ node: root, time: 0, startY: root.position.y });
  }

  private updateFloatingTexts(dt: number) {
    for (const item of this.floatingTexts) {
      if (!item.node.isValid) continue;
      item.time += dt;
      const ratio = Math.min(1, item.time / DAMAGE_TEXT_LIFETIME);
      item.node.setPosition(item.node.position.x, item.startY + DAMAGE_TEXT_RISE * ratio, 0);
      if (ratio >= 1) item.node.destroy();
    }
    this.floatingTexts = this.floatingTexts.filter((item) => item.node.isValid);
  }

  private bringFloatingTextsToFront() {
    if (!this.node.parent) return;
    for (const item of this.floatingTexts) {
      if (item.node.isValid) item.node.setSiblingIndex(this.node.parent.children.length - 1);
    }
  }

  private createLevelUpEffect() {
    this.levelUpNode = new Node('LevelUpEffect');
    this.node.addChild(this.levelUpNode);
    this.levelUpNode.setPosition(0, 20, 0);
    this.levelUpNode.active = false;
    this.levelUpTransform = this.levelUpNode.addComponent(UITransform);
    this.levelUpSprite = this.levelUpNode.addComponent(Sprite);
  }

  private addHeroExp(value: number) {
    if (value <= 0) return;
    this.heroExp += value;
    let leveled = false;
    while (this.heroLevel < 60 && this.heroExp >= this.heroMaxExp()) {
      this.heroExp -= this.heroMaxExp();
      this.heroLevel++;
      const race = this.currentHeroRace();
      this.heroStrength += HERO_STRENGTH_GAIN[race];
      this.heroDexterity += HERO_DEXTERITY_GAIN[race];
      this.heroWisdom += HERO_WISDOM_GAIN[race];
      leveled = true;
    }
    if (leveled) this.recalculateHeroStats(true);
    this.updateExpLabel();
    if (leveled) this.startLevelUpEffect();
    this.queueSaveGameProgress();
  }

  private rollMonsterExp(monster: MonsterActor) {
    const min = Math.min(monster.expMin, monster.expMax);
    const max = Math.max(monster.expMin, monster.expMax);
    return Math.floor(min + Math.random() * (max - min + 1));
  }

  private resolveMonsterRewardId(config: MapMonsterConfig) {
    const configured = Math.floor(this.toNumber(config.rewardId, 0));
    if (configured > 0) return configured;
    const imageId = Math.floor(this.toNumber(config.monsterId, -1));
    const byImage = this.defaultDropRewardByMonsterImageId[imageId];
    if (byImage > 0) return byImage;
    const byMap = this.defaultDropRewardByMapId[this.currentMapId()];
    return byMap > 0 ? byMap : 0;
  }

  private resolveMonsterLevel(config: MapMonsterConfig, rewardId: number) {
    const configured = Math.floor(this.toNumber(config.monsterLevel, -1));
    if (configured >= 0) return configured;
    const reward = this.dropRewardsById[rewardId];
    return Math.max(0, Math.floor(this.toNumber(reward?.level, 0)));
  }

  private applyMonsterReward(monster: MonsterActor) {
    const reward = this.dropRewardsById[monster.rewardId];
    if (!reward) {
      this.addHeroExp(this.rollMonsterExp(monster));
      this.rollMonsterEquipmentDrop(monster);
      return;
    }

    const exp = this.rollRange(reward.exp?.min ?? monster.expMin, reward.exp?.max ?? monster.expMax);
    const money = this.rollRange(reward.money?.min ?? 0, reward.money?.max ?? 0);
    this.addHeroExp(exp);
    this.addDepotMoney(money);
    this.rollMonsterRewardDrops(monster);
  }

  private rollMonsterRewardDrops(monster: MonsterActor) {
    this.rollMonsterEquipmentDrop(monster);
    // Old extraGoods contains many fixed equipment IDs. Equipment drops now use the unified 9.99% quality table.
  }

  private rollMonsterEquipmentDrop(monster: MonsterActor) {
    const quality = this.rollDropQuality();
    if (quality < 0) return false;
    const item = this.pickDropEquipment(monster.level, quality);
    return item ? this.spawnWorldDrop(item, monster.node.position) : false;
  }

  private rollDropQuality() {
    let roll = Math.floor(Math.random() * MONSTER_DROP_RATE_BASE);
    for (const rule of MONSTER_DROP_QUALITY_RATES) {
      if (roll < rule.rate) return rule.quality;
      roll -= rule.rate;
    }
    return -1;
  }

  private pickDropEquipment(monsterLevel: number, quality: number) {
    const slot = this.randomDropSlot();
    const race = this.randomDropRace(slot);
    const preferred = this.pickDropEquipmentForSlot(monsterLevel, quality, slot, race);
    if (preferred) return preferred;
    const pool = this.equipmentCatalog.filter((item) => this.isDropEquipmentCandidate(item, quality));
    return this.pickNearestDropItem(pool, monsterLevel);
  }

  private randomDropSlot(): EquipmentBaseSlot {
    return DROP_EQUIPMENT_SLOTS[Math.floor(Math.random() * DROP_EQUIPMENT_SLOTS.length)] as EquipmentBaseSlot;
  }

  private randomDropRace(slot: EquipmentBaseSlot) {
    return (DROP_CLASS_EQUIPMENT_SLOTS as readonly string[]).indexOf(slot) >= 0
      ? Math.floor(Math.random() * PROFESSION_NAMES.length)
      : -1;
  }

  private pickDropEquipmentForSlot(monsterLevel: number, quality: number, slot: EquipmentBaseSlot, race: number) {
    const pool = this.equipmentCatalog.filter((item) => this.isDropEquipmentCandidate(item, quality, slot, race));
    return this.pickNearestDropItem(pool, monsterLevel, slot);
  }

  private pickNearestDropItem(pool: EquipmentCatalogItem[], monsterLevel: number, forcedSlot?: EquipmentBaseSlot) {
    if (!pool.length) return null;
    let bestLevel = -1;
    let bestDistance = Infinity;
    const preferredLevel = this.nearestDropLevel(monsterLevel, forcedSlot ?? pool[0].slot);
    const bestItems: EquipmentCatalogItem[] = [];
    for (const item of pool) {
      const targetLevel = forcedSlot ? preferredLevel : this.nearestDropLevel(monsterLevel, item.slot);
      const distance = Math.abs(item.requiredLevel - targetLevel);
      if (distance < bestDistance || (distance === bestDistance && item.requiredLevel < bestLevel)) {
        bestDistance = distance;
        bestLevel = item.requiredLevel;
        bestItems.length = 0;
        bestItems.push(item);
      } else if (distance === bestDistance && item.requiredLevel === bestLevel) {
        bestItems.push(item);
      }
    }
    return bestItems[Math.floor(Math.random() * bestItems.length)] ?? null;
  }

  private isDropEquipmentCandidate(item: EquipmentCatalogItem, quality: number, slot?: EquipmentBaseSlot, race = -1) {
    if (item.id % 100 !== 0) return false;
    if (item.name.indexOf(GAME_TEXT.inventory.superKeyword) >= 0) return false;
    if (item.quality !== quality || item.quality >= 6) return false;
    if (slot && item.slot !== slot) return false;
    if ((DROP_EQUIPMENT_SLOTS as readonly string[]).indexOf(item.slot) < 0) return false;
    if ((DROP_CLASS_EQUIPMENT_SLOTS as readonly string[]).indexOf(item.slot) >= 0) {
      if (race >= 0 && item.requiredRace !== race) return false;
      return item.requiredLevel >= 0 && item.requiredLevel <= 120;
    }
    return item.requiredLevel >= 18 && item.requiredLevel <= 114;
  }

  private nearestDropLevel(monsterLevel: number, slot: EquipmentBaseSlot) {
    const level = Math.max(0, Math.floor(this.toNumber(monsterLevel, 0)));
    const tiers = (DROP_DECORATION_SLOTS as readonly string[]).indexOf(slot) >= 0
      ? JEWELRY_DROP_LEVEL_TIERS
      : EQUIPMENT_DROP_LEVEL_TIERS;
    let best = tiers[0];
    let bestDistance = Math.abs(level - best);
    for (const tier of tiers) {
      const distance = Math.abs(level - tier);
      if (distance < bestDistance || (distance === bestDistance && tier < best)) {
        best = tier;
        bestDistance = distance;
      }
    }
    return best;
  }

  private spawnWorldDrop(item: EquipmentCatalogItem, position: Readonly<Vec3>) {
    if (!this.node.parent) return false;
    const node = new Node('WorldDrop');
    node.parent = this.node.parent;
    node.setPosition(position.x, position.y, 0);
    node.addComponent(UITransform).setContentSize(DROP_CHEST_WIDTH, DROP_CHEST_HEIGHT);
    const chestFrame = this.dropChestFrameForQuality(item.quality);
    if (chestFrame) {
      const sprite = node.addComponent(Sprite);
      sprite.sizeMode = Sprite.SizeMode.CUSTOM;
      sprite.spriteFrame = chestFrame;
    } else {
      this.drawWorldDropChest(node.addComponent(Graphics));
    }
    const name = this.addUiLabel(node, item.name, 0, DROP_NAME_OFFSET_Y, OLD_UI_BUTTON_FONT_SIZE, this.equipmentNameColor(item.quality));
    name.lineHeight = OLD_UI_BUTTON_HEIGHT;
    name.verticalAlign = Label.VerticalAlign.CENTER;
    this.makeLabelAutoFit(name, 160, OLD_UI_BUTTON_HEIGHT);
    this.worldDrops.push({ node, item, createdAt: this.runtimeTime });
    return true;
  }

  private dropChestFrameForQuality(quality: number) {
    const index = this.clamp(Math.floor(this.toNumber(quality, 0)), 0, DROP_CHEST_QUALITY_RESOURCES.length - 1);
    return this.dropChestQualityFrames[index] ?? this.dropChestFrame;
  }

  private drawWorldDropChest(g: Graphics) {
    const w = DROP_CHEST_WIDTH;
    const h = DROP_CHEST_HEIGHT;
    g.clear();
    g.lineWidth = 1;
    g.fillColor = new Color(72, 42, 18, 255);
    g.fillRect(-w / 2 + 3, -h / 2 + 7, w - 6, h - 11);
    g.fillColor = new Color(112, 70, 28, 255);
    g.fillRect(-w / 2 + 4, -h / 2 + 1, w - 8, 9);
    g.strokeColor = new Color(184, 132, 62, 255);
    g.rect(-w / 2 + 3, -h / 2 + 1, w - 6, h - 5);
    g.stroke();
    g.fillColor = new Color(205, 156, 62, 255);
    g.fillRect(-2, -h / 2 + 5, 4, 6);
  }

  private updateWorldDrops() {
    for (let i = this.worldDrops.length - 1; i >= 0; i--) {
      const drop = this.worldDrops[i];
      if (!drop.node.isValid) {
        this.worldDrops.splice(i, 1);
        continue;
      }
      if (this.runtimeTime - drop.createdAt >= DROP_LIFETIME_SECONDS) {
        drop.node.destroy();
        this.worldDrops.splice(i, 1);
        continue;
      }
      if (Vec3.distance(this.node.position, drop.node.position) > DROP_PICKUP_RADIUS) continue;
      if (!this.addInventoryItem(drop.item)) {
        this.setInventoryDetail(GAME_TEXT.inventory.full);
        continue;
      }
      drop.node.destroy();
      this.worldDrops.splice(i, 1);
      this.renderInventoryUi();
    }
  }

  private nearestWorldDropPickupTarget(): WorldDropPickupTarget | null {
    if (!this.hasInventorySpace()) return null;
    let best: WorldDropPickupTarget | null = null;
    for (const drop of this.worldDrops) {
      if (!drop.node.isValid) continue;
      const pickupPosition = this.worldDropPickupPosition(drop);
      if (!pickupPosition) continue;
      const distance = Vec3.distance(this.node.position, pickupPosition);
      if (!best || distance < best.distance) best = { drop, position: pickupPosition, distance };
    }
    return best;
  }

  private worldDropPickupPosition(drop: WorldDropItem) {
    const center = drop.node.position;
    const candidates = [
      new Vec3(center.x, center.y, 0),
      new Vec3(center.x - 18, center.y, 0),
      new Vec3(center.x + 18, center.y, 0),
      new Vec3(center.x, center.y - 18, 0),
      new Vec3(center.x, center.y + 18, 0),
      new Vec3(center.x - 13, center.y - 13, 0),
      new Vec3(center.x + 13, center.y - 13, 0),
      new Vec3(center.x - 13, center.y + 13, 0),
      new Vec3(center.x + 13, center.y + 13, 0),
    ];
    let best: Vec3 | null = null;
    let bestDist = Infinity;
    for (const candidate of candidates) {
      if (Vec3.distance(candidate, center) > DROP_PICKUP_RADIUS) continue;
      if (!this.canStandAt(candidate.x, candidate.y)) continue;
      if (!this.isActorSpotFree(this.node, candidate.x, candidate.y)) continue;
      const dist = Vec3.distance(this.node.position, candidate);
      if (dist < bestDist) {
        bestDist = dist;
        best = candidate;
      }
    }
    return best;
  }

  private hasInventorySpace() {
    return this.inventorySlots.some((slot) => slot === null);
  }

  private clearWorldDrops() {
    for (const drop of this.worldDrops) {
      if (drop.node.isValid) drop.node.destroy();
    }
    this.worldDrops = [];
  }

  private addInventoryItem(item: EquipmentCatalogItem) {
    const index = this.inventorySlots.findIndex((slot) => slot === null);
    if (index < 0) return false;
    this.inventorySlots[index] = this.createEquipmentInstance(item, 'drop');
    this.inventoryPage = Math.floor(index / INVENTORY_PAGE_SIZE);
    this.selectedInventoryItem = this.inventorySlots[index];
    this.setInventoryDetail(formatGameText(GAME_TEXT.inventory.pickedUp, { name: item.name }));
    this.queueSaveGameProgress();
    return true;
  }

  private addDepotMoney(amount: number) {
    const value = Math.max(0, Math.floor(amount));
    if (value <= 0) return;
    this.depotMoney += value;
    this.queueSaveGameProgress();
  }

  private rollDropRate(rate: number) {
    return Math.random() * MONSTER_DROP_RATE_BASE < Math.max(0, this.toNumber(rate, 0));
  }

  private rollRange(minValue: number, maxValue: number) {
    const min = Math.floor(Math.min(this.toNumber(minValue, 0), this.toNumber(maxValue, 0)));
    const max = Math.floor(Math.max(this.toNumber(minValue, 0), this.toNumber(maxValue, 0)));
    return Math.floor(min + Math.random() * (max - min + 1));
  }

  private heroMaxExp() {
    return heroMaxExp(this.heroLevel);
  }

  private updateExpLabel() {
    if (this.expLabel) this.expLabel.string = `Lv.${this.heroLevel} ${this.heroExp}/${this.heroMaxExp()}`;
  }

  private startLevelUpEffect() {
    if (!this.levelUpNode || !this.levelUpFrames.length) return;
    this.levelUpTime = 0;
    this.levelUpNode.active = true;
    this.setLevelUpFrame(0);
  }

  private playLevelUpEffect(dt: number) {
    if (this.levelUpTime < 0 || !this.levelUpNode) return;
    this.levelUpTime += dt;
    const frame = Math.floor(this.levelUpTime / 0.14);
    if (frame >= this.levelUpFrames.length) {
      this.levelUpTime = -1;
      this.levelUpNode.active = false;
      return;
    }
    this.setLevelUpFrame(frame);
  }

  private setLevelUpFrame(index: number) {
    const frame = this.levelUpFrames[index];
    if (frame && this.levelUpSprite && this.levelUpTransform) this.applyFrame(this.levelUpSprite, this.levelUpTransform, frame);
  }

  private directionFrom(dx: number, dy: number) {
    const dir = Math.round(Math.atan2(dx, dy) / (Math.PI / 4));
    return this.normalizedDirection(dir);
  }

  private normalizedDirection(dir: number) {
    const value = Math.round(Number(dir));
    return Number.isFinite(value) ? ((value % 8) + 8) % 8 : 4;
  }

  private followCamera() {
    this.cameraNode?.setPosition(this.snapPixel(this.node.position.x), this.snapPixel(this.node.position.y), 1000);
  }

  private keepTrimmedFrame() {
    if (this.sprite && this.transform && this.sprite.spriteFrame) {
      this.sprite.sizeMode = Sprite.SizeMode.CUSTOM;
      const size = this.heroFrameCanvasSize();
      this.transform.setContentSize(size, size);
    }
    this.node.setScale(1, 1, 1);
  }

  private applyFrame(sprite: Sprite, transform: UITransform, frame: SpriteFrame) {
    sprite.sizeMode = Sprite.SizeMode.TRIMMED;
    sprite.spriteFrame = frame;
    const rect = frame.getRect();
    if (rect) transform.setContentSize(rect.width, rect.height);
  }

  private applyMonsterFrame(type: string, sprite: Sprite, transform: UITransform, frame: SpriteFrame, visualNode: Node) {
    this.applyFrame(sprite, transform, frame);
    if (!this.usesOffsetAlignedMonster(type)) return;
    const offset = this.spriteFrameOffset(frame);
    visualNode.setPosition(offset.x, offset.y, 0);
  }

  private usesOffsetAlignedMonster(type: string) {
    return type.startsWith('monster_');
  }

  private spriteFrameOffset(frame: SpriteFrame) {
    const data = frame as unknown as { offset?: { x?: number; y?: number }; getOffset?: () => { x?: number; y?: number } };
    let offset = data.offset;
    try {
      offset = data.getOffset?.() ?? offset;
    } catch {
      // Some Cocos builds expose offset as a property only.
    }
    return { x: Number(offset?.x) || 0, y: Number(offset?.y) || 0 };
  }

  private trySetPosition(node: Node, x: number, y: number, avoidCollisionEdges = false) {
    const nextX = this.snapPixel(x);
    const nextY = this.snapPixel(y);
    const nextScore = this.standScore(nextX, nextY);
    if (nextScore < 5 && nextScore <= this.standScore(node.position.x, node.position.y)) return false;
    if (!this.allowsCollisionEdgeMove(node, nextX, nextY, avoidCollisionEdges)) return false;
    if (!this.isActorSpotFree(node, nextX, nextY)) return false;
    node.setPosition(nextX, nextY, 0);
    return true;
  }

  private snapPixel(value: number) {
    return Math.round(value);
  }

  private moveToward(node: Node, target: Readonly<Vec3>, speed: number, dt: number, avoidCollisionEdges = false) {
    const memory = this.moveMemory(node, target);
    this.trackSameCoord(node, target, memory, dt, avoidCollisionEdges);
    if (memory.bypass) {
      memory.bypassTime = Math.max(0, memory.bypassTime - dt);
    }
    if (memory.bypass && (memory.bypassTime <= 0 || Vec3.distance(node.position, memory.bypass) < 12)) {
      memory.bypass = null;
      memory.bypassTime = 0;
    }
    const realTarget = memory.bypass ?? target;
    const dx = realTarget.x - node.position.x;
    const dy = realTarget.y - node.position.y;
    const dist = Math.sqrt(dx * dx + dy * dy);
    if (dist < 1) return null;
    const step = Math.min(speed * dt, dist);
    const nx = dx / dist;
    const ny = dy / dist;

    this.ensurePath(node.position, realTarget, memory, avoidCollisionEdges);
    const pathPoint = this.nextPathPoint(node, memory);
    if (pathPoint) {
      if (this.tryMoveToPoint(node, pathPoint, step, avoidCollisionEdges)) return this.afterMove(node, target, memory, dt, avoidCollisionEdges);
      this.clearPath(memory);
    }

    if (this.trySetPosition(node, node.position.x + nx * step, node.position.y + ny * step, avoidCollisionEdges)) return this.afterMove(node, target, memory, dt, avoidCollisionEdges);
    for (const [ax, ay] of [[nx, 0], [0, ny], [-ny, nx], [ny, -nx]]) {
      const len = Math.sqrt(ax * ax + ay * ay);
      if (len < 0.01) continue;
      if (this.trySetPosition(node, node.position.x + (ax / len) * step, node.position.y + (ay / len) * step, avoidCollisionEdges)) return this.afterMove(node, target, memory, dt, avoidCollisionEdges);
    }
    if (this.tryUnstuckMove(node, realTarget, Math.max(step * 4, UNSTUCK_STEP), avoidCollisionEdges)) return this.afterMove(node, target, memory, dt, avoidCollisionEdges);
    this.setBypass(node, target, memory, avoidCollisionEdges);
    return null;
  }

  private afterMove(node: Node, target: Readonly<Vec3>, memory: MoveMemory, dt: number, avoidCollisionEdges = false) {
    const mx = node.position.x - memory.lastX;
    const my = node.position.y - memory.lastY;
    const moved = Math.sqrt(mx * mx + my * my);
    if (moved > 0.01) {
      memory.lastMoveX = mx;
      memory.lastMoveY = my;
    }
    memory.lastX = node.position.x;
    memory.lastY = node.position.y;
    if (moved < 0.4) {
      memory.stuck += dt;
    } else {
      memory.stuck = 0;
    }
    if (memory.stuck > STUCK_SECONDS) {
      this.setBypass(node, target, memory, avoidCollisionEdges);
    }
    return memory;
  }

  private moveMemory(node: Node, target: Readonly<Vec3>) {
    let memory: MoveMemory | null = null;
    for (const item of this.moveMemories) {
      if (item.node === node) {
        memory = item;
        break;
      }
    }
    if (!memory) {
      memory = {
        node,
        lastX: node.position.x,
        lastY: node.position.y,
        lastMoveX: 0,
        lastMoveY: -1,
        coordX: this.coordBucket(node.position.x),
        coordY: this.coordBucket(node.position.y),
        sameCoordTime: 0,
        targetX: target.x,
        targetY: target.y,
        stuck: 0,
        bypass: null,
        bypassTime: 0,
        path: [],
        pathIndex: 0,
        pathTargetX: target.x,
        pathTargetY: target.y,
      };
      this.moveMemories.push(memory);
    } else if (Math.abs(memory.targetX - target.x) > 120 || Math.abs(memory.targetY - target.y) > 120) {
      memory.lastX = node.position.x;
      memory.lastY = node.position.y;
      memory.lastMoveX = 0;
      memory.lastMoveY = -1;
      memory.targetX = target.x;
      memory.targetY = target.y;
      memory.stuck = 0;
      memory.coordX = this.coordBucket(node.position.x);
      memory.coordY = this.coordBucket(node.position.y);
      memory.sameCoordTime = 0;
      memory.bypass = null;
      memory.bypassTime = 0;
      this.clearPath(memory);
    }
    return memory;
  }

  private trackSameCoord(node: Node, target: Readonly<Vec3>, memory: MoveMemory, dt: number, avoidCollisionEdges = false) {
    const x = this.coordBucket(node.position.x);
    const y = this.coordBucket(node.position.y);
    if (x === memory.coordX && y === memory.coordY) {
      memory.sameCoordTime += dt;
    } else {
      memory.coordX = x;
      memory.coordY = y;
      memory.sameCoordTime = 0;
    }
    if (!memory.bypass && memory.sameCoordTime > COORD_STUCK_SECONDS) {
      this.setBypass(node, target, memory, avoidCollisionEdges);
    }
  }

  private coordBucket(value: number) {
    return Math.round(value / COORD_GRID);
  }

  private setBypass(node: Node, target: Readonly<Vec3>, memory: MoveMemory, avoidCollisionEdges = false) {
    this.clearPath(memory);
    memory.bypass = this.findRetreatPoint(node, node.position, target, avoidCollisionEdges)
      ?? this.findBypassPoint(node, node.position, target, avoidCollisionEdges);
    memory.bypassTime = memory.bypass ? 1.2 : 0;
    memory.sameCoordTime = 0;
    memory.stuck = 0;
  }

  private findRetreatPoint(node: Node, from: Readonly<Vec3>, target: Readonly<Vec3>, avoidCollisionEdges = false) {
    const away = Math.atan2(from.y - target.y, from.x - target.x);
    for (const distance of [RETREAT_DISTANCE, RETREAT_DISTANCE + 40]) {
      for (const offset of [0, Math.PI / 5, -Math.PI / 5, Math.PI / 3, -Math.PI / 3]) {
        const angle = away + offset;
        const point = new Vec3(from.x + Math.cos(angle) * distance, from.y + Math.sin(angle) * distance, 0);
        if (this.canActorStandAt(point.x, point.y, avoidCollisionEdges) && this.isActorSpotFree(node, point.x, point.y)) return point;
      }
    }
    return null;
  }

  private findBypassPoint(node: Node, from: Readonly<Vec3>, target: Readonly<Vec3>, avoidCollisionEdges = false) {
    let best: Vec3 | null = null;
    let bestScore = -Infinity;
    for (const distance of [BYPASS_DISTANCE - 30, BYPASS_DISTANCE, BYPASS_DISTANCE + 45, BYPASS_DISTANCE + 90]) {
      for (let i = 0; i < 16; i++) {
        const angle = (Math.PI * 2 * i) / 16;
        const point = new Vec3(from.x + Math.cos(angle) * distance, from.y + Math.sin(angle) * distance, 0);
        if (!this.canActorStandAt(point.x, point.y, avoidCollisionEdges) || !this.isActorSpotFree(node, point.x, point.y)) continue;
        const routeBonus = this.findNextPathPoint(point, target, avoidCollisionEdges) ? 500 : 0;
        const score = routeBonus - Vec3.distance(point, target);
        if (score > bestScore) {
          bestScore = score;
          best = point;
        }
      }
    }
    return best;
  }

  private tryUnstuckMove(node: Node, target: Readonly<Vec3>, step: number, avoidCollisionEdges = false) {
    let best: Vec3 | null = null;
    let bestScore = -Infinity;
    const currentDist = Vec3.distance(node.position, target);
    const currentStand = this.standScore(node.position.x, node.position.y);
    for (let i = 0; i < 16; i++) {
      const angle = (Math.PI * 2 * i) / 16;
      const x = node.position.x + Math.cos(angle) * step;
      const y = node.position.y + Math.sin(angle) * step;
      const stand = this.standScore(x, y);
      if (stand < 5 && stand <= currentStand) continue;
      if (!this.allowsCollisionEdgeMove(node, x, y, avoidCollisionEdges)) continue;
      if (!this.isActorSpotFree(node, x, y)) continue;
      const distGain = currentDist - Vec3.distance(new Vec3(x, y, 0), target);
      const score = stand * 1000 + distGain;
      if (score > bestScore) {
        bestScore = score;
        best = new Vec3(x, y, 0);
      }
    }
    if (!best) return false;
    node.setPosition(best);
    return true;
  }

  private ensurePath(from: Readonly<Vec3>, target: Readonly<Vec3>, memory: MoveMemory, avoidCollisionEdges = false) {
    const targetMoved = Math.abs(memory.pathTargetX - target.x) > PATH_TARGET_REPATH_DISTANCE
      || Math.abs(memory.pathTargetY - target.y) > PATH_TARGET_REPATH_DISTANCE;
    if (targetMoved) this.clearPath(memory);
    if (memory.path.length || !this.blockMap) return;
    memory.path = this.findPath(from, target, avoidCollisionEdges);
    memory.pathIndex = 0;
    memory.pathTargetX = target.x;
    memory.pathTargetY = target.y;
  }

  private nextPathPoint(node: Node, memory: MoveMemory) {
    while (memory.pathIndex < memory.path.length && Vec3.distance(node.position, memory.path[memory.pathIndex]) < PATH_POINT_REACH) {
      memory.pathIndex++;
    }
    if (memory.pathIndex >= memory.path.length) {
      this.clearPath(memory);
      return null;
    }
    return memory.path[memory.pathIndex];
  }

  private clearPath(memory: MoveMemory) {
    memory.path = [];
    memory.pathIndex = 0;
  }

  private tryMoveToPoint(node: Node, point: Readonly<Vec3>, step: number, avoidCollisionEdges = false) {
    const dx = point.x - node.position.x;
    const dy = point.y - node.position.y;
    const dist = Math.sqrt(dx * dx + dy * dy);
    if (dist < 0.1) return false;
    return this.trySetPosition(node, node.position.x + (dx / dist) * step, node.position.y + (dy / dist) * step, avoidCollisionEdges);
  }

  private findNextPathPoint(from: Readonly<Vec3>, to: Readonly<Vec3>, avoidCollisionEdges = false) {
    return this.findPath(from, to, avoidCollisionEdges)[0] ?? null;
  }

  private findPath(from: Readonly<Vec3>, to: Readonly<Vec3>, avoidCollisionEdges = false) {
    const start = this.worldToBlock(from.x, from.y);
    const goal = this.nearestStandableCell(this.worldToBlock(to.x, to.y), avoidCollisionEdges);
    if (!start || !goal) return [];
    const width = this.blockMap!.width;
    const total = width * this.blockMap!.height;
    const startId = start.y * width + start.x;
    const goalId = goal.y * width + goal.x;
    if (startId === goalId) return [];
    const open = [startId];
    const came = new Int32Array(total).fill(-1);
    const g = new Float32Array(total).fill(Infinity);
    g[startId] = 0;

    // ponytail: cache this tiny A* path per actor; no navmesh until the map pipeline needs it.
    for (let seen = 0; open.length && seen < PATH_SEARCH_LIMIT; seen++) {
      let best = 0;
      let bestScore = Infinity;
      for (let i = 0; i < open.length; i++) {
        const id = open[i];
        const x = id % width;
        const y = Math.floor(id / width);
        const score = g[id] + Math.abs(goal.x - x) + Math.abs(goal.y - y);
        if (score < bestScore) {
          bestScore = score;
          best = i;
        }
      }
      const current = open.splice(best, 1)[0];
      if (current === goalId) break;
      const cx = current % width;
      const cy = Math.floor(current / width);
      for (let oy = -1; oy <= 1; oy++) {
        for (let ox = -1; ox <= 1; ox++) {
          if (!ox && !oy) continue;
          const nx = cx + ox;
          const ny = cy + oy;
          if (!this.isPathCellPassable(nx, ny, avoidCollisionEdges)) continue;
          if (ox && oy && (!this.isPathCellPassable(cx + ox, cy, avoidCollisionEdges) || !this.isPathCellPassable(cx, cy + oy, avoidCollisionEdges))) continue;
          const next = ny * width + nx;
          const cost = g[current] + (ox && oy ? 1.4 : 1);
          if (cost >= g[next]) continue;
          g[next] = cost;
          came[next] = current;
          if (open.indexOf(next) < 0) open.push(next);
        }
      }
    }

    if (came[goalId] < 0) return [];
    const path: Vec3[] = [];
    let id = goalId;
    while (id !== startId && id >= 0) {
      path.push(this.blockToWorld({ x: id % width, y: Math.floor(id / width) }));
      id = came[id];
    }
    path.reverse();
    return path;
  }

  private canReachTarget(from: Readonly<Vec3>, to: Readonly<Vec3>, dist: number, avoidCollisionEdges = false) {
    if (!this.blockMap || dist > TARGET_REACH_CHECK_RANGE) return true;
    const start = this.worldToBlock(from.x, from.y);
    const goal = this.nearestStandableCell(this.worldToBlock(to.x, to.y), avoidCollisionEdges);
    if (!start || !goal) return false;
    if (start.x === goal.x && start.y === goal.y) return true;
    return !!this.findNextPathPoint(from, to, avoidCollisionEdges);
  }

  private isPassable(x: number, y: number) {
    const cell = this.worldToBlock(x, y);
    if (this.isPatchBlockedAt(x, y)) return false;
    return !this.blockMap || (!!cell && this.isBlockPassable(cell.x, cell.y));
  }

  private canStandAt(x: number, y: number) {
    return this.standScore(x, y) === 5;
  }

  private canMonsterStandAt(x: number, y: number) {
    return this.canStandAt(x, y) && this.collisionClearanceScore(x, y) === MONSTER_CLEARANCE_OFFSETS.length;
  }

  private canActorStandAt(x: number, y: number, avoidCollisionEdges = false) {
    return avoidCollisionEdges ? this.canMonsterStandAt(x, y) : this.canStandAt(x, y);
  }

  private allowsCollisionEdgeMove(node: Node, x: number, y: number, avoidCollisionEdges = false) {
    if (!avoidCollisionEdges) return true;
    const nextScore = this.collisionClearanceScore(x, y);
    if (nextScore === MONSTER_CLEARANCE_OFFSETS.length) return true;
    return nextScore > this.collisionClearanceScore(node.position.x, node.position.y);
  }

  private collisionClearanceScore(x: number, y: number) {
    return MONSTER_CLEARANCE_OFFSETS.reduce((score, offset) => score + (this.isPassable(x + offset[0], y + offset[1]) ? 1 : 0), 0);
  }

  private isActorSpotFree(actor: Node | null, x: number, y: number) {
    const next = new Vec3(x, y, 0);
    if (!this.isSpotClearFrom(actor, this.node, next)) return false;
    for (const monster of this.monsters) {
      if (!monster.node.isValid || monster.node === actor) continue;
      if (!this.isSpotClearFrom(actor, monster.node, next)) return false;
    }
    for (const companion of this.companionActors) {
      if (!companion.node.isValid || companion.node === actor) continue;
      if (!this.isSpotClearFrom(actor, companion.node, next)) return false;
    }
    return true;
  }

  private isSpotClearFrom(actor: Node | null, other: Node, next: Readonly<Vec3>) {
    if (!other.isValid || other === actor) return true;
    const nextDist = Vec3.distance(next, other.position);
    if (nextDist >= ACTOR_SEPARATION) return true;
    if (!actor) return false;
    const currentDist = Vec3.distance(actor.position, other.position);
    return nextDist > currentDist + 0.5;
  }

  private standScore(x: number, y: number) {
    return STAND_OFFSETS.reduce((score, offset) => score + (this.isPassable(x + offset[0], y + offset[1]) ? 1 : 0), 0);
  }

  private nearestStandableCell(cell: BlockCell | null, avoidCollisionEdges = false) {
    if (!cell) return null;
    if (this.isPathCellPassable(cell.x, cell.y, avoidCollisionEdges)) return cell;
    for (let r = 1; r <= 4; r++) {
      for (let y = cell.y - r; y <= cell.y + r; y++) {
        for (let x = cell.x - r; x <= cell.x + r; x++) {
          if ((Math.abs(x - cell.x) === r || Math.abs(y - cell.y) === r) && this.isPathCellPassable(x, y, avoidCollisionEdges)) return { x, y };
        }
      }
    }
    return null;
  }

  private isPathCellPassable(bx: number, by: number, avoidCollisionEdges = false) {
    if (!this.isBlockPassable(bx, by)) return false;
    const pos = this.blockToWorld({ x: bx, y: by });
    return this.canActorStandAt(pos.x, pos.y, avoidCollisionEdges);
  }

  private worldToBlock(x: number, y: number): BlockCell | null {
    if (!this.blockMap) return null;
    const mapWorldW = this.blockMap.mapImageWidth * this.blockMap.mapNodeScale;
    const mapWorldH = this.blockMap.mapImageHeight * this.blockMap.mapNodeScale;
    const px = (x + mapWorldW / 2) / mapWorldW;
    const py = (mapWorldH / 2 - y) / mapWorldH;
    const bx = Math.floor(px * this.blockMap.width);
    const by = Math.floor(py * this.blockMap.height);
    if (bx < 0 || by < 0 || bx >= this.blockMap.width || by >= this.blockMap.height) return null;
    return { x: bx, y: by };
  }

  private blockToWorld(cell: BlockCell) {
    const mapWorldW = this.blockMap!.mapImageWidth * this.blockMap!.mapNodeScale;
    const mapWorldH = this.blockMap!.mapImageHeight * this.blockMap!.mapNodeScale;
    return new Vec3(
      ((cell.x + 0.5) / this.blockMap!.width) * mapWorldW - mapWorldW / 2,
      mapWorldH / 2 - ((cell.y + 0.5) / this.blockMap!.height) * mapWorldH,
      0,
    );
  }

  private isBlockPassable(bx: number, by: number) {
    if (!this.blockMap || bx < 0 || by < 0 || bx >= this.blockMap.width || by >= this.blockMap.height) return false;
    return this.blockMap.data[(by * this.blockMap.width) + bx] === '1';
  }

  private bringOcclusionToFront() {
    if (this.occlusionNode?.isValid && this.node.parent) {
      this.occlusionNode.setSiblingIndex(this.node.parent.children.length - 1);
    }
  }

  private bringSkillEffectsToFront() {
    if (!this.node.parent) return;
    for (const effect of this.skillEffects) {
      if (effect.node.isValid) effect.node.setSiblingIndex(this.node.parent.children.length - 1);
    }
  }

  private bringWorldDropsToFront() {
    if (!this.node.parent) return;
    for (const drop of this.worldDrops) {
      if (drop.node.isValid) drop.node.setSiblingIndex(this.node.parent.children.length - 1);
    }
  }

  private sortActorsByY() {
    if (!this.node.parent) return;
    const actors = [this.node]
      .concat(this.monsters.filter((monster) => monster.node.isValid).map((monster) => monster.node))
      .concat(this.companionActors.filter((companion) => companion.node.isValid).map((companion) => companion.node))
      .concat(this.mapPatchObjects.filter((item) => item.node.isValid && item.data.occlusion !== false).map((item) => item.node));
    actors.sort((a, b) => b.position.y - a.position.y);
    for (const actor of actors) actor.setSiblingIndex(this.node.parent.children.length - 1);
  }

  private isPatchBlockedAt(worldX: number, worldY: number) {
    const point = this.worldToMapImage(worldX, worldY);
    for (const item of this.mapPatchObjects) {
      if (this.isObjectCollisionHit(point.x, point.y, item.data)) return true;
    }
    return false;
  }

  private isObjectCollisionHit(mapX: number, mapY: number, item: MapPatchObjectData) {
    const col = item.collision;
    if (!col || col.w <= 0 || col.h <= 0) return false;
    const scale = item.scale || 1;
    const x = item.x + col.x * scale;
    const y = item.y + col.y * scale;
    const w = col.w * scale;
    const h = col.h * scale;
    return mapX >= x && mapY >= y && mapX <= x + w && mapY <= y + h;
  }

  private mapImageToWorld(x: number, y: number) {
    const width = this.mapImageWidth();
    const height = this.mapImageHeight();
    const scale = this.mapNodeScale();
    return new Vec3((x - width / 2) * scale, (height / 2 - y) * scale, 0);
  }

  private worldToMapImage(x: number, y: number) {
    const width = this.mapImageWidth();
    const height = this.mapImageHeight();
    const scale = this.mapNodeScale();
    return { x: x / scale + width / 2, y: height / 2 - y / scale };
  }

  private mapImageWidth() {
    return this.blockMap?.mapImageWidth ?? 3000;
  }

  private mapImageHeight() {
    return this.blockMap?.mapImageHeight ?? 3000;
  }

  private mapNodeScale() {
    return this.blockMap?.mapNodeScale ?? 1.5;
  }

  private mapWorldBounds(padding = 0) {
    const halfW = (this.mapImageWidth() * this.mapNodeScale()) / 2;
    const halfH = (this.mapImageHeight() * this.mapNodeScale()) / 2;
    return {
      minX: -halfW + padding,
      maxX: halfW - padding,
      minY: -halfH + padding,
      maxY: halfH - padding,
    };
  }

  private clamp(value: number, min: number, max: number) {
    return Math.max(min, Math.min(max, value));
  }

  private forcePortrait() {
    view.setOrientation(macro.ORIENTATION_PORTRAIT);
    view.setDesignResolutionSize(DESIGN_WIDTH, DESIGN_HEIGHT, ResolutionPolicy.SHOW_ALL);
  }

  private syncCamera() {
    const camera = this.cameraNode?.getComponent(Camera);
    if (camera && camera.orthoHeight !== CAMERA_ORTHO_HEIGHT) camera.orthoHeight = CAMERA_ORTHO_HEIGHT;
  }
}

function heroMaxExp(level: number) {
  if (level <= 0) return 10;
  if (level >= 255) return 0;
  const base = (level + 1) * (level + 1);
  const rough = Math.round((base * base) / 100 + base * 10);
  const factorIndex = level < 95 ? Math.floor(level / 10) : Math.min(EXP_FACTORS.length - 1, Math.floor((level - 95) / 5) + 10);
  return Math.floor(rough * EXP_FACTORS[factorIndex]);
}

function heroBaseStrength(level: number, race = DEFAULT_HERO_RACE) {
  return HERO_ORIGIN_STRENGTH[race] + HERO_STRENGTH_GAIN[race] * level;
}

function heroBaseDexterity(level: number, race = DEFAULT_HERO_RACE) {
  return HERO_ORIGIN_DEXTERITY[race] + HERO_DEXTERITY_GAIN[race] * level;
}

function heroBaseWisdom(level: number, race = DEFAULT_HERO_RACE) {
  return HERO_ORIGIN_WISDOM[race] + HERO_WISDOM_GAIN[race] * level;
}

function heroBaseAttackRange(race: number) {
  return race === 0 ? HERO_RANGER_ATTACK_RANGE : HERO_MELEE_ATTACK_RANGE;
}

function calculateHeroDerivedStats(level: number, strength: number, dexterity: number, wisdom: number, race: number): HeroDerivedStats {
  const levelBonus = Math.floor(level / 12);
  const minPhysicalDamage = strength + Math.floor((dexterity * 3) / 2) + (Math.floor((dexterity * dexterity) / 1600) + levelBonus) * 3;
  const maxPhysicalDamage = strength * 3 + dexterity + (Math.floor((strength * strength) / 400) + levelBonus) * 3;
  const minMagicDamage = Math.floor((wisdom * 3) / 2) + (Math.floor((dexterity * dexterity) / 2500) + levelBonus) * 3;
  const maxMagicDamage = wisdom * 2 + (Math.floor((wisdom * wisdom) / 400) + levelBonus) * 3;
  const physicalDefense = Math.floor(strength / 2) + Math.floor((dexterity * 4) / 10)
    + (Math.floor((strength * strength) / 900) + Math.floor(dexterity / 25)) * 2;
  const magicDefense = Math.floor((wisdom * 6) / 10) + Math.floor((dexterity * 3) / 10)
    + (Math.floor((wisdom * wisdom) / 900) + Math.floor(dexterity / 25)) * 2;
  const accuracy = Math.floor((dexterity * 2) / 10) + Math.floor((dexterity * dexterity) / 2500) + Math.floor(level / 8) + 5;
  return {
    minPhysicalDamage,
    maxPhysicalDamage,
    minMagicDamage,
    maxMagicDamage,
    physicalDefense,
    magicDefense,
    // ponytail: no equipment/depot system yet; add item bonuses here when equipment exists.
    attackTime: 1000,
    attackRange: heroBaseAttackRange(race),
    hittingAbility: accuracy,
    evadingAbility: accuracy,
    maxHp: strength * 8 + level * 12 + HERO_ORIGIN_LIFE[race],
    maxMana: wisdom * 5 + level * 8 + HERO_ORIGIN_MANA[race],
  };
}
