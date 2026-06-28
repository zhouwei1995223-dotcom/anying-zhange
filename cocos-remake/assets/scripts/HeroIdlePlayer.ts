import { _decorator, Camera, Color, Component, Graphics, JsonAsset, Label, macro, Node, ResolutionPolicy, resources, Sprite, SpriteFrame, UITransform, Vec3, view } from 'cc';

const { ccclass, property } = _decorator;
const DESIGN_WIDTH = 720;
const DESIGN_HEIGHT = 1280;
const CAMERA_ORTHO_HEIGHT = 350;
const DEFAULT_MAP_ID = 3;
const HERO_RESOURCE = 'heroes/hero_00';
const HERO_RACE = 0;
const HERO_MOVE_SPEED = 100;
const MONSTER_ATTACK_INTERVAL = 0.8;
const MONSTER_ATTACK_FRAME_INTERVAL = 0.09;
const MONSTER_MOVE_SPEED = 50;
const MONSTER_WANDER_STEP = 60;
const MONSTER_ATTACK_RANGE = 46;
const MONSTER_CHASE_RANGE = 150;
const ACTOR_COLLISION_RADIUS = 12;
const ACTOR_SEPARATION = 24;
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
@ccclass('MapMonsterConfig')
class MapMonsterConfig {
  @property({ displayName: '怪物编号' })
  monsterId = 0;

  @property({ displayName: '最大血量' })
  maxHp = 50;

  @property({ displayName: '攻击' })
  attack = 8;

  @property({ displayName: '防御' })
  defense = 0;

  @property({ displayName: '经验最小' })
  expMin = 20;

  @property({ displayName: '经验最大' })
  expMax = 30;
}

function defaultMonsterConfig(id: number) {
  const config = new MapMonsterConfig();
  config.monsterId = id;
  return config;
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

type MonsterState = 'idle' | 'walk' | 'chase' | 'attack';

type MonsterActor = {
  node: Node;
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
  attack: number;
  defense: number;
  expMin: number;
  expMax: number;
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
  hittingAbility: number;
  evadingAbility: number;
  maxHp: number;
  maxMana: number;
};

@ccclass('HeroIdlePlayer')
export class HeroIdlePlayer extends Component {
  @property({ displayName: '地图编号', tooltip: '对应 assets/resources/maps/map_ID_preview / block / occlusion' })
  public mapId = DEFAULT_MAP_ID;

  @property({ type: [MapMonsterConfig], displayName: '地图怪物配置' })
  public mapMonsters: MapMonsterConfig[] = [defaultMonsterConfig(0), defaultMonsterConfig(1)];

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
  private levelUpNode: Node | null = null;
  private levelUpSprite: Sprite | null = null;
  private levelUpTransform: UITransform | null = null;
  private levelUpTime = -1;
  private expLabel: Label | null = null;
  private heroHpLabel: Label | null = null;
  private heroHpBar: Graphics | null = null;
  private statsButton: Node | null = null;
  private statsPanel: Node | null = null;
  private statsLabels: Record<string, Label> = {};
  private loadedMapId = -1;
  private loadedMonsterSignature = '';
  private monsters: MonsterActor[] = [];
  private moveMemories: MoveMemory[] = [];
  private target: MonsterActor | null = null;
  private attackTarget: MonsterActor | null = null;
  private currentDir = 4;
  private index = 0;
  private time = 0;
  private spawnTime = 0;
  private attackTime = -1;
  private runtimeTime = 0;
  private stalledTarget: MonsterActor | null = null;
  private stalledBestDist = Infinity;
  private stalledTime = 0;
  private stalledAnchorX = 0;
  private stalledAnchorY = 0;
  private stalledAreaTime = 0;
  private heroLevel = 1;
  private heroExp = 0;
  private heroStrength = heroBaseStrength(1);
  private heroDexterity = heroBaseDexterity(1);
  private heroWisdom = heroBaseWisdom(1);
  private heroUnassignedPoints = 0;
  private heroMaxHp = 0;
  private heroCurrentHp = 0;
  private heroMaxMana = 0;
  private heroCurrentMana = 0;

  start() {
    this.forcePortrait();
    this.sprite = this.getComponent(Sprite);
    this.transform = this.getComponent(UITransform);
    this.cameraNode = this.node.parent?.getChildByName('Camera') ?? null;
    this.recalculateHeroStats(true);
    this.syncCamera();
    this.createLevelUpEffect();
    this.createExpLabel();
    this.createHeroHpUi();
    this.createStatsUi();
    this.keepTrimmedFrame();
    this.loadLevelUpFrames();
    this.loadBloodStainFrame();
    this.loadDamageTextFrames();
    this.loadClip('idle', `${HERO_RESOURCE}/idle/idle_`, 4);
    for (let dir = 0; dir < 8; dir++) {
      this.loadClip(`walk${dir}`, `${HERO_RESOURCE}/walk/d${dir}/walk_`, 6);
      this.loadClip(`attack${dir}`, `${HERO_RESOURCE}/attack/d${dir}/attack_`, 8);
    }
    this.syncMonsterConfigs();
    this.reloadMapAssets();
  }

  protected onValidate() {
    this.mapId = this.currentMapId();
    this.syncMonsterConfigs();
    if (this.loadedMapId !== this.mapId) this.reloadMapAssets();
  }

  update(dt: number) {
    this.runtimeTime += dt;
    this.syncCamera();
    this.syncMonsterConfigs();
    if (this.loadedMapId !== this.currentMapId()) this.reloadMapAssets();
    this.playFrames(dt);
    this.playLevelUpEffect(dt);
    this.updateFloatingTexts(dt);
    this.followCamera();
    this.layoutStatsUi();
    this.updateMonsters(dt);
    this.spawnTime += dt;
    if (this.spawnTime > 0.8) {
      this.spawnTime = 0;
      if (this.monsters.length < 12) this.spawnMonster();
    }
    this.sortActorsByY();
    this.bringOcclusionToFront();
    this.bringFloatingTextsToFront();
    this.bringStatsUiToFront();

    if (this.attackTime >= 0) {
      this.attackTime += dt;
      if (this.attackTime > 0.68) this.finishAttack();
      return;
    }

    this.monsters = this.monsters.filter((monster) => monster.node.isValid);
    this.target = this.nearestMonster();
    if (!this.target) {
      this.resetTargetProgress();
      this.setClip('idle');
      return;
    }

    const dx = this.target.node.position.x - this.node.position.x;
    const dy = this.target.node.position.y - this.node.position.y;
    const dist = Math.sqrt(dx * dx + dy * dy);
    if (dist < 36) {
      this.currentDir = this.directionFrom(dx, dy);
      this.resetTargetProgress();
      this.startAttack(this.target);
      return;
    }
    if (!this.trackTargetProgress(this.target, dist, dt)) {
      this.target = null;
      this.setClip('idle');
      return;
    }

    const move = this.moveToward(this.node, this.target.node.position, HERO_MOVE_SPEED, dt);
    if (move) {
      this.currentDir = this.directionFrom(move.lastMoveX, move.lastMoveY);
      this.setClip(`walk${this.currentDir}`);
    } else {
      this.setClip('idle');
    }
  }

  private loadClip(name: string, prefix: string, count: number) {
    const paths = Array.from({ length: count }, (_, i) => `${prefix}${i < 10 ? '0' : ''}${i}/spriteFrame`);
    resources.load(paths, SpriteFrame, (err, frames) => {
      if (!err && frames?.length) {
        this.clips[name] = frames;
        if (name === this.currentClip) this.setFrame(0);
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
        if (!err && frame) this.monsterFrames[type] = frame;
      });
    }
  }

  private loadMonsterClip(name: string, prefix: string, count: number) {
    const paths = Array.from({ length: count }, (_, i) => `${prefix}${i < 10 ? '0' : ''}${i}/spriteFrame`);
    resources.load(paths, SpriteFrame, (err, frames) => {
      if (!err && frames?.length) this.monsterClips[name] = frames;
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
      .map((config) => `${this.monsterType(config)}:${config.maxHp}:${config.attack}:${config.defense}:${config.expMin}:${config.expMax}`)
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
    const transform = monster.addComponent(UITransform);
    const sprite = monster.addComponent(Sprite);
    sprite.sizeMode = Sprite.SizeMode.TRIMMED;
    this.applyFrame(sprite, transform, frame);
    const hpUi = this.createMonsterHpUi(monster);
    const config = this.monsterConfigByType(type);
    const maxHp = Math.max(1, Math.round(config.maxHp));
    const actor: MonsterActor = {
      node: monster,
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
      attack: Math.max(0, Math.round(config.attack)),
      defense: Math.max(0, Math.round(config.defense)),
      expMin: Math.max(0, Math.round(config.expMin)),
      expMax: Math.max(0, Math.round(config.expMax)),
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
    return new Vec3(
      this.clamp(hero.x + Math.cos(angle) * radius, -1900, 1900),
      this.clamp(hero.y + Math.sin(angle) * radius, -1900, 1900),
      0,
    );
  }

  private randomPassablePoint() {
    for (let i = 0; i < 20; i++) {
      const pos = this.randomMapPoint();
      if (this.canStandAt(pos.x, pos.y) && this.isActorSpotFree(null, pos.x, pos.y)) return pos;
    }
    return this.node.position.clone();
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
    if (monster.currentHp <= 0) return;
    this.attackTarget = monster;
    this.attackTime = 0;
    this.setClip(`attack${this.currentDir}`);
  }

  private finishAttack() {
    this.attackTime = -1;
    const monster = this.attackTarget;
    if (monster?.node.isValid) {
      const hit = this.rollHeroHit();
      const actualDamage = this.damageMonster(monster, hit.damage);
      this.spawnDamageNumber(actualDamage, monster.node.position, hit.crit);
      if (monster.currentHp <= 0) {
        this.spawnBloodStain(monster.node.position);
        this.addHeroExp(this.rollMonsterExp(monster));
        monster.node.destroy();
        this.monsters = this.monsters.filter((item) => item.node.isValid && item !== monster);
      }
    }
    this.attackTarget = null;
    this.target = this.nearestMonster();
    this.setClip('idle');
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
    if (!this.sprite || frames.length < 2) return;
    this.time += dt;
    if (this.time < this.frameInterval()) return;
    this.time = 0;
    this.index = (this.index + 1) % frames.length;
    this.setFrame(this.index);
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
      const canReachHero = heroDist <= MONSTER_CHASE_RANGE && this.canReachTarget(monster.node.position, this.node.position, heroDist);

      if (heroDist <= MONSTER_ATTACK_RANGE && canReachHero) {
        monster.dir = this.directionFrom(dx, dy);
        this.updateMonsterAttack(monster, dt);
      } else if (canReachHero) {
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
    const move = this.moveToward(monster.node, target, MONSTER_MOVE_SPEED, dt);
    if (!move) return false;
    monster.dir = this.directionFrom(move.lastMoveX, move.lastMoveY);
    return dist > 8;
  }

  private randomWanderPoint(from: Readonly<Vec3>) {
    for (let i = 0; i < 8; i++) {
      const angle = Math.random() * Math.PI * 2;
      const pos = new Vec3(
        this.clamp(from.x + Math.cos(angle) * MONSTER_WANDER_STEP, -1900, 1900),
        this.clamp(from.y + Math.sin(angle) * MONSTER_WANDER_STEP, -1900, 1900),
        0,
      );
      if (this.canStandAt(pos.x, pos.y) && this.isActorSpotFree(null, pos.x, pos.y)) return pos;
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
    const isAttack = monster.clip.startsWith('attack');
    const interval = isAttack ? MONSTER_ATTACK_FRAME_INTERVAL : 0.12;
    if (monster.time < interval) return;
    monster.time = 0;
    if (isAttack && monster.frame >= frames.length - 1) {
      this.damageHeroFromMonster(monster);
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
      this.applyFrame(monster.sprite, monster.transform, frame);
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
    return `monster_${String(Math.floor(config.monsterId)).padStart(2, '0')}`;
  }

  private monsterConfigByType(type: string) {
    return this.monsterConfigs().find((config) => this.monsterType(config) === type) ?? defaultMonsterConfig(0);
  }

  private monsterTypes() {
    return this.monsterConfigs().map((config) => this.monsterType(config));
  }

  private randomMonsterType() {
    const types = this.monsterTypes();
    const ready = types.filter((type) => this.monsterClips[this.monsterClip(type, 'idle', 0)]?.length || this.monsterFrames[type]);
    return ready[Math.floor(Math.random() * ready.length)] ?? types[0];
  }

  private monsterClip(type: string, action: string, dir: number) {
    return `${type}:${action}${dir}`;
  }

  private setFrame(index: number) {
    if (!this.sprite) return;
    this.sprite.spriteFrame = this.clips[this.currentClip]?.[index] ?? null;
    this.keepTrimmedFrame();
  }

  private frameInterval() {
    if (this.currentClip.startsWith('attack')) return 0.08;
    if (this.currentClip.startsWith('walk')) return 0.1;
    return 0.12;
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
    this.statsButton = new Node('HeroStatsButton');
    this.statsButton.parent = this.node.parent;
    this.statsButton.addComponent(UITransform).setContentSize(54, 26);
    const buttonBg = this.statsButton.addComponent(Graphics);
    this.drawPanelBox(buttonBg, 54, 26, new Color(22, 28, 30, 230));
    this.addUiLabel(this.statsButton, '属性', 0, -1, 15, new Color(88, 220, 255, 255));
    this.statsButton.on(Node.EventType.TOUCH_END, () => {
      if (this.statsPanel) this.statsPanel.active = !this.statsPanel.active;
    });

    this.statsPanel = new Node('HeroStatsPanel');
    this.statsPanel.parent = this.node.parent;
    this.statsPanel.active = false;
    this.statsPanel.addComponent(UITransform).setContentSize(210, 300);
    const bg = this.statsPanel.addComponent(Graphics);
    this.drawPanelBox(bg, 210, 300, new Color(18, 24, 20, 235));

    this.addUiLabel(this.statsPanel, '属性', -86, 130, 16, new Color(88, 220, 255, 255), 'left');
    this.addUiLabel(this.statsPanel, '基础属性', -78, 98, 15, new Color(255, 235, 0, 255), 'left');
    this.addUiLabel(this.statsPanel, '剩余点数', 45, 98, 15, new Color(255, 235, 0, 255), 'left');
    this.statsLabels.points = this.addUiLabel(this.statsPanel, '', 72, 74, 14, Color.WHITE);

    this.addStatRow('强壮', 'strength', -54, 68);
    this.addStatRow('敏捷', 'dexterity', -54, 44);
    this.addStatRow('智力', 'wisdom', -54, 20);

    const rows: [string, keyof HeroDerivedStats | 'pk' | 'turns' | 'merit', number][] = [
      ['物理攻击力', 'minPhysicalDamage', -20],
      ['魔法攻击力', 'minMagicDamage', -42],
      ['物理防御', 'physicalDefense', -64],
      ['魔法防御', 'magicDefense', -86],
      ['攻击时间', 'attackTime', -108],
      ['命中力', 'hittingAbility', -130],
      ['躲避力', 'evadingAbility', -152],
      ['PK值', 'pk', -174],
      ['转生次数', 'turns', -196],
      ['功勋值', 'merit', -218],
    ];
    for (const [name, key, y] of rows) {
      this.addUiLabel(this.statsPanel, name, -74, y, 13, Color.WHITE, 'left');
      this.statsLabels[key] = this.addUiLabel(this.statsPanel, '', 74, y, 13, Color.WHITE, 'right');
    }
    this.updateStatsPanel();
  }

  private addStatRow(name: string, key: 'strength' | 'dexterity' | 'wisdom', labelX: number, y: number) {
    if (!this.statsPanel) return;
    this.addUiLabel(this.statsPanel, name, labelX - 28, y, 13, Color.WHITE, 'left');
    this.statsLabels[key] = this.addUiLabel(this.statsPanel, '', labelX + 28, y, 13, Color.WHITE, 'right');
    const plus = this.addUiLabel(this.statsPanel, '+', labelX + 48, y, 15, new Color(190, 210, 220, 255));
    plus.node.getComponent(UITransform)?.setContentSize(20, 20);
    plus.node.on(Node.EventType.TOUCH_END, () => this.addHeroPoint(key));
  }

  private addUiLabel(parent: Node, text: string, x: number, y: number, size: number, color: Color, align: 'left' | 'center' | 'right' = 'center') {
    const node = new Node(`Label_${text || 'value'}`);
    parent.addChild(node);
    node.setPosition(x, y, 0);
    const label = node.addComponent(Label);
    label.string = text;
    label.fontSize = size;
    label.lineHeight = size + 2;
    label.color = color;
    label.horizontalAlign = align === 'left' ? Label.HorizontalAlign.LEFT : align === 'right' ? Label.HorizontalAlign.RIGHT : Label.HorizontalAlign.CENTER;
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

  private addHeroPoint(key: 'strength' | 'dexterity' | 'wisdom') {
    if (this.heroUnassignedPoints <= 0) return;
    this.heroUnassignedPoints--;
    if (key === 'strength') this.heroStrength++;
    if (key === 'dexterity') this.heroDexterity++;
    if (key === 'wisdom') this.heroWisdom++;
    this.recalculateHeroStats(false);
  }

  private layoutStatsUi() {
    const camera = this.cameraNode?.position ?? this.node.position;
    this.statsButton?.setPosition(camera.x - 162, camera.y + 314, 0);
    this.statsPanel?.setPosition(camera.x - 82, camera.y + 160, 0);
  }

  private bringStatsUiToFront() {
    if (!this.node.parent) return;
    this.statsButton?.setSiblingIndex(this.node.parent.children.length - 1);
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

  private damageHeroFromMonster(monster: MonsterActor) {
    if (this.heroCurrentHp <= 0) return;
    const damage = Math.max(1, Math.round(monster.attack));
    this.heroCurrentHp = this.clampHp(this.heroCurrentHp - damage, this.heroMaxHp);
    this.updateHeroHpUi();
    this.spawnDamageNumber(damage, this.node.position);
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
    this.heroCurrentHp = fillHpMana ? this.heroMaxHp : this.clampHp(this.heroMaxHp * hpRatio, this.heroMaxHp);
    this.heroCurrentMana = fillHpMana ? this.heroMaxMana : this.clampHp(this.heroMaxMana * manaRatio, this.heroMaxMana);
    this.updateHeroHpUi();
    this.updateStatsPanel();
  }

  private heroDerivedStats(): HeroDerivedStats {
    return calculateHeroDerivedStats(this.heroLevel, this.heroStrength, this.heroDexterity, this.heroWisdom, HERO_RACE);
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
    this.heroExp += value;
    let leveled = false;
    while (this.heroLevel < 60 && this.heroExp >= this.heroMaxExp()) {
      this.heroExp -= this.heroMaxExp();
      this.heroLevel++;
      this.heroStrength += HERO_STRENGTH_GAIN[HERO_RACE];
      this.heroDexterity += HERO_DEXTERITY_GAIN[HERO_RACE];
      this.heroWisdom += HERO_WISDOM_GAIN[HERO_RACE];
      leveled = true;
    }
    if (leveled) this.recalculateHeroStats(true);
    this.updateExpLabel();
    if (leveled) this.startLevelUpEffect();
  }

  private rollMonsterExp(monster: MonsterActor) {
    const min = Math.min(monster.expMin, monster.expMax);
    const max = Math.max(monster.expMin, monster.expMax);
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
    return (dir + 8) % 8;
  }

  private followCamera() {
    this.cameraNode?.setPosition(this.node.position.x, this.node.position.y, 1000);
  }

  private keepTrimmedFrame() {
    if (this.sprite) this.sprite.sizeMode = Sprite.SizeMode.TRIMMED;
    if (this.sprite && this.transform && this.sprite.spriteFrame) {
      this.applyFrame(this.sprite, this.transform, this.sprite.spriteFrame);
    }
    this.node.setScale(1, 1, 1);
  }

  private applyFrame(sprite: Sprite, transform: UITransform, frame: SpriteFrame) {
    sprite.sizeMode = Sprite.SizeMode.TRIMMED;
    sprite.spriteFrame = frame;
    const rect = frame.getRect();
    if (rect) transform.setContentSize(rect.width, rect.height);
  }

  private trySetPosition(node: Node, x: number, y: number) {
    const nextScore = this.standScore(x, y);
    if (nextScore < 5 && nextScore <= this.standScore(node.position.x, node.position.y)) return false;
    if (!this.isActorSpotFree(node, x, y)) return false;
    node.setPosition(x, y, 0);
    return true;
  }

  private moveToward(node: Node, target: Readonly<Vec3>, speed: number, dt: number) {
    const memory = this.moveMemory(node, target);
    this.trackSameCoord(node, target, memory, dt);
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

    this.ensurePath(node.position, realTarget, memory);
    const pathPoint = this.nextPathPoint(node, memory);
    if (pathPoint) {
      if (this.tryMoveToPoint(node, pathPoint, step)) return this.afterMove(node, target, memory, dt);
      this.clearPath(memory);
    }

    if (this.trySetPosition(node, node.position.x + nx * step, node.position.y + ny * step)) return this.afterMove(node, target, memory, dt);
    for (const [ax, ay] of [[nx, 0], [0, ny], [-ny, nx], [ny, -nx]]) {
      const len = Math.sqrt(ax * ax + ay * ay);
      if (len < 0.01) continue;
      if (this.trySetPosition(node, node.position.x + (ax / len) * step, node.position.y + (ay / len) * step)) return this.afterMove(node, target, memory, dt);
    }
    if (this.tryUnstuckMove(node, realTarget, Math.max(step * 4, UNSTUCK_STEP))) return this.afterMove(node, target, memory, dt);
    this.setBypass(node, target, memory);
    return null;
  }

  private afterMove(node: Node, target: Readonly<Vec3>, memory: MoveMemory, dt: number) {
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
      this.setBypass(node, target, memory);
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

  private trackSameCoord(node: Node, target: Readonly<Vec3>, memory: MoveMemory, dt: number) {
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
      this.setBypass(node, target, memory);
    }
  }

  private coordBucket(value: number) {
    return Math.round(value / COORD_GRID);
  }

  private setBypass(node: Node, target: Readonly<Vec3>, memory: MoveMemory) {
    this.clearPath(memory);
    memory.bypass = this.findRetreatPoint(node, node.position, target) ?? this.findBypassPoint(node, node.position, target);
    memory.bypassTime = memory.bypass ? 1.2 : 0;
    memory.sameCoordTime = 0;
    memory.stuck = 0;
  }

  private findRetreatPoint(node: Node, from: Readonly<Vec3>, target: Readonly<Vec3>) {
    const away = Math.atan2(from.y - target.y, from.x - target.x);
    for (const distance of [RETREAT_DISTANCE, RETREAT_DISTANCE + 40]) {
      for (const offset of [0, Math.PI / 5, -Math.PI / 5, Math.PI / 3, -Math.PI / 3]) {
        const angle = away + offset;
        const point = new Vec3(from.x + Math.cos(angle) * distance, from.y + Math.sin(angle) * distance, 0);
        if (this.canStandAt(point.x, point.y) && this.isActorSpotFree(node, point.x, point.y)) return point;
      }
    }
    return null;
  }

  private findBypassPoint(node: Node, from: Readonly<Vec3>, target: Readonly<Vec3>) {
    let best: Vec3 | null = null;
    let bestScore = -Infinity;
    for (const distance of [BYPASS_DISTANCE - 30, BYPASS_DISTANCE, BYPASS_DISTANCE + 45, BYPASS_DISTANCE + 90]) {
      for (let i = 0; i < 16; i++) {
        const angle = (Math.PI * 2 * i) / 16;
        const point = new Vec3(from.x + Math.cos(angle) * distance, from.y + Math.sin(angle) * distance, 0);
        if (!this.canStandAt(point.x, point.y) || !this.isActorSpotFree(node, point.x, point.y)) continue;
        const routeBonus = this.findNextPathPoint(point, target) ? 500 : 0;
        const score = routeBonus - Vec3.distance(point, target);
        if (score > bestScore) {
          bestScore = score;
          best = point;
        }
      }
    }
    return best;
  }

  private tryUnstuckMove(node: Node, target: Readonly<Vec3>, step: number) {
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

  private ensurePath(from: Readonly<Vec3>, target: Readonly<Vec3>, memory: MoveMemory) {
    const targetMoved = Math.abs(memory.pathTargetX - target.x) > PATH_TARGET_REPATH_DISTANCE
      || Math.abs(memory.pathTargetY - target.y) > PATH_TARGET_REPATH_DISTANCE;
    if (targetMoved) this.clearPath(memory);
    if (memory.path.length || !this.blockMap) return;
    memory.path = this.findPath(from, target);
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

  private tryMoveToPoint(node: Node, point: Readonly<Vec3>, step: number) {
    const dx = point.x - node.position.x;
    const dy = point.y - node.position.y;
    const dist = Math.sqrt(dx * dx + dy * dy);
    if (dist < 0.1) return false;
    return this.trySetPosition(node, node.position.x + (dx / dist) * step, node.position.y + (dy / dist) * step);
  }

  private findNextPathPoint(from: Readonly<Vec3>, to: Readonly<Vec3>) {
    return this.findPath(from, to)[0] ?? null;
  }

  private findPath(from: Readonly<Vec3>, to: Readonly<Vec3>) {
    const start = this.worldToBlock(from.x, from.y);
    const goal = this.nearestStandableCell(this.worldToBlock(to.x, to.y));
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
          if (!this.isPathCellPassable(nx, ny)) continue;
          if (ox && oy && (!this.isPathCellPassable(cx + ox, cy) || !this.isPathCellPassable(cx, cy + oy))) continue;
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

  private canReachTarget(from: Readonly<Vec3>, to: Readonly<Vec3>, dist: number) {
    if (!this.blockMap || dist > TARGET_REACH_CHECK_RANGE) return true;
    const start = this.worldToBlock(from.x, from.y);
    const goal = this.nearestStandableCell(this.worldToBlock(to.x, to.y));
    if (!start || !goal) return false;
    if (start.x === goal.x && start.y === goal.y) return true;
    return !!this.findNextPathPoint(from, to);
  }

  private isPassable(x: number, y: number) {
    const cell = this.worldToBlock(x, y);
    if (this.isPatchBlockedAt(x, y)) return false;
    return !this.blockMap || (!!cell && this.isBlockPassable(cell.x, cell.y));
  }

  private canStandAt(x: number, y: number) {
    return this.standScore(x, y) === 5;
  }

  private isActorSpotFree(actor: Node | null, x: number, y: number) {
    if (actor !== this.node && Vec3.distance(new Vec3(x, y, 0), this.node.position) < ACTOR_SEPARATION) return false;
    for (const monster of this.monsters) {
      if (!monster.node.isValid || monster.node === actor) continue;
      if (Vec3.distance(new Vec3(x, y, 0), monster.node.position) < ACTOR_SEPARATION) return false;
    }
    return true;
  }

  private standScore(x: number, y: number) {
    return STAND_OFFSETS.reduce((score, offset) => score + (this.isPassable(x + offset[0], y + offset[1]) ? 1 : 0), 0);
  }

  private nearestStandableCell(cell: BlockCell | null) {
    if (!cell) return null;
    if (this.isPathCellPassable(cell.x, cell.y)) return cell;
    for (let r = 1; r <= 4; r++) {
      for (let y = cell.y - r; y <= cell.y + r; y++) {
        for (let x = cell.x - r; x <= cell.x + r; x++) {
          if ((Math.abs(x - cell.x) === r || Math.abs(y - cell.y) === r) && this.isPathCellPassable(x, y)) return { x, y };
        }
      }
    }
    return null;
  }

  private isPathCellPassable(bx: number, by: number) {
    if (!this.isBlockPassable(bx, by)) return false;
    const pos = this.blockToWorld({ x: bx, y: by });
    return this.canStandAt(pos.x, pos.y);
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

  private sortActorsByY() {
    if (!this.node.parent) return;
    const actors = [this.node]
      .concat(this.monsters.filter((monster) => monster.node.isValid).map((monster) => monster.node))
      .concat(this.mapPatchObjects.filter((item) => item.node.isValid && item.data.occlusion !== false).map((item) => item.node));
    actors.sort((a, b) => b.position.y - a.position.y);
    for (const actor of actors) actor.setSiblingIndex(this.node.parent.children.length - 1);
  }

  private isPatchBlockedAt(worldX: number, worldY: number) {
    const point = this.worldToMapImage(worldX, worldY);
    for (const item of this.mapPatchObjects) {
      const col = item.data.collision;
      if (!col || col.w <= 0 || col.h <= 0) continue;
      const x = item.data.x + col.x;
      const y = item.data.y + col.y;
      if (point.x >= x && point.y >= y && point.x <= x + col.w && point.y <= y + col.h) return true;
    }
    return false;
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

function heroBaseStrength(level: number) {
  return HERO_ORIGIN_STRENGTH[HERO_RACE] + HERO_STRENGTH_GAIN[HERO_RACE] * level;
}

function heroBaseDexterity(level: number) {
  return HERO_ORIGIN_DEXTERITY[HERO_RACE] + HERO_DEXTERITY_GAIN[HERO_RACE] * level;
}

function heroBaseWisdom(level: number) {
  return HERO_ORIGIN_WISDOM[HERO_RACE] + HERO_WISDOM_GAIN[HERO_RACE] * level;
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
    hittingAbility: accuracy,
    evadingAbility: accuracy,
    maxHp: strength * 8 + level * 12 + HERO_ORIGIN_LIFE[race],
    maxMana: wisdom * 5 + level * 8 + HERO_ORIGIN_MANA[race],
  };
}
