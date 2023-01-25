package com.zenyte.desktop;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import net.runelite.api.Hitsplat;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.Hitsplat.HitsplatType;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.events.InteractingChanged;
import net.runelite.api.events.OverheadTextChanged;
import net.runelite.api.events.PlayerDeath;
import net.runelite.api.events.SpotAnimationChanged;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSActor;
import net.runelite.rs.api.RSHealthBar;
import net.runelite.rs.api.RSHealthBarDefinition;
import net.runelite.rs.api.RSHealthBarUpdate;
import net.runelite.rs.api.RSIterableNodeDeque;
import net.runelite.rs.api.RSNPC;
import net.runelite.rs.api.RSNode;
import net.runelite.rs.api.RSPlayer;

@ObfuscatedName("cw")
public abstract class Actor extends Entity implements RSActor {
	@ObfuscatedName("an")
	boolean isWalking;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = -1730088457
	)
	int x;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = 58548893
	)
	int y;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = 2047396387
	)
	int rotation;
	@ObfuscatedName("at")
	@ObfuscatedGetter(
		intValue = 747650361
	)
	int field976;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = 1154559573
	)
	int playerCycle;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = 399800473
	)
	int idleSequence;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = -684262003
	)
	int turnLeftSequence;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = -1952661919
	)
	int turnRightSequence;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = 2064847885
	)
	int walkSequence;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = 1807346449
	)
	int walkBackSequence;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = -598231963
	)
	int walkLeftSequence;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = -1622741341
	)
	int walkRightSequence;
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = 1458798213
	)
	int runSequence;
	@ObfuscatedName("ax")
	String overheadText;
	@ObfuscatedName("az")
	boolean isAutoChatting;
	@ObfuscatedName("aj")
	boolean field988;
	@ObfuscatedName("ay")
	@ObfuscatedGetter(
		intValue = -1807093205
	)
	int overheadTextCyclesRemaining;
	@ObfuscatedName("ad")
	@ObfuscatedGetter(
		intValue = -1168789031
	)
	int overheadTextColor;
	@ObfuscatedName("ac")
	@ObfuscatedGetter(
		intValue = -54296883
	)
	int overheadTextEffect;
	@ObfuscatedName("ag")
	byte hitSplatCount;
	@ObfuscatedName("aw")
	int[] hitSplatTypes;
	@ObfuscatedName("bf")
	int[] hitSplatValues;
	@ObfuscatedName("bc")
	int[] hitSplatCycles;
	@ObfuscatedName("bo")
	int[] hitSplatTypes2;
	@ObfuscatedName("bd")
	int[] hitSplatValues2;
	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		signature = "Ljm;"
	)
	IterableNodeDeque healthBars;
	@ObfuscatedName("bu")
	@ObfuscatedGetter(
		intValue = 1906218843
	)
	int targetIndex;
	@ObfuscatedName("be")
	boolean false0;
	@ObfuscatedName("bg")
	@ObfuscatedGetter(
		intValue = -1444761415
	)
	int field1015;
	@ObfuscatedName("bt")
	@ObfuscatedGetter(
		intValue = 1296285639
	)
	int movementSequence;
	@ObfuscatedName("bh")
	@ObfuscatedGetter(
		intValue = -1097128947
	)
	int movementFrame;
	@ObfuscatedName("br")
	@ObfuscatedGetter(
		intValue = 1112091343
	)
	int movementFrameCycle;
	@ObfuscatedName("bq")
	@ObfuscatedGetter(
		intValue = -20846645
	)
	int sequence;
	@ObfuscatedName("ba")
	@ObfuscatedGetter(
		intValue = 1620009483
	)
	int sequenceFrame;
	@ObfuscatedName("bv")
	@ObfuscatedGetter(
		intValue = 1370333627
	)
	int sequenceFrameCycle;
	@ObfuscatedName("bx")
	@ObfuscatedGetter(
		intValue = -1532646011
	)
	int sequenceDelay;
	@ObfuscatedName("bz")
	@ObfuscatedGetter(
		intValue = 743745547
	)
	int field1011;
	@ObfuscatedName("bs")
	@ObfuscatedGetter(
		intValue = -1600718851
	)
	int spotAnimation;
	@ObfuscatedName("bp")
	@ObfuscatedGetter(
		intValue = -595193051
	)
	int spotAnimationFrame;
	@ObfuscatedName("bm")
	@ObfuscatedGetter(
		intValue = -1426517203
	)
	int spotAnimationFrameCycle;
	@ObfuscatedName("bb")
	@ObfuscatedGetter(
		intValue = 1048299633
	)
	int field1013;
	@ObfuscatedName("bn")
	@ObfuscatedGetter(
		intValue = 1503080001
	)
	int field1033;
	@ObfuscatedName("by")
	@ObfuscatedGetter(
		intValue = 1317270699
	)
	int field990;
	@ObfuscatedName("bj")
	@ObfuscatedGetter(
		intValue = 1667801647
	)
	int field972;
	@ObfuscatedName("bi")
	@ObfuscatedGetter(
		intValue = 441172781
	)
	int field1017;
	@ObfuscatedName("bl")
	@ObfuscatedGetter(
		intValue = -1550774947
	)
	int field1018;
	@ObfuscatedName("bw")
	@ObfuscatedGetter(
		intValue = -625975993
	)
	int field1019;
	@ObfuscatedName("cw")
	@ObfuscatedGetter(
		intValue = 1067146179
	)
	int field1020;
	@ObfuscatedName("cc")
	@ObfuscatedGetter(
		intValue = 1247809135
	)
	int field1021;
	@ObfuscatedName("ch")
	@ObfuscatedGetter(
		intValue = 1215799343
	)
	int npcCycle;
	@ObfuscatedName("cr")
	@ObfuscatedGetter(
		intValue = 1881116621
	)
	int defaultHeight;
	@ObfuscatedName("cq")
	@ObfuscatedGetter(
		intValue = 616594567
	)
	int orientation;
	@ObfuscatedName("co")
	@ObfuscatedGetter(
		intValue = 230967505
	)
	int field1025;
	@ObfuscatedName("cm")
	@ObfuscatedGetter(
		intValue = 2061571405
	)
	int field1026;
	@ObfuscatedName("cu")
	@ObfuscatedGetter(
		intValue = -525774551
	)
	int pathLength;
	@ObfuscatedName("cs")
	int[] pathX;
	@ObfuscatedName("cg")
	int[] pathY;
	@ObfuscatedName("cd")
	byte[] pathTraversed;
	@ObfuscatedName("cx")
	@ObfuscatedGetter(
		intValue = -1741747755
	)
	int field1031;
	@ObfuscatedName("cn")
	@ObfuscatedGetter(
		intValue = -932937077
	)
	int field1032;

	Actor() {
		this.isWalking = false;
		this.field976 = 1;
		this.idleSequence = -1;
		this.turnLeftSequence = -1;
		this.turnRightSequence = -1;
		this.walkSequence = -1;
		this.walkBackSequence = -1;
		this.walkLeftSequence = -1;
		this.walkRightSequence = -1;
		this.runSequence = -1;
		this.overheadText = null;
		this.overheadTextChanged(-1);
		this.field988 = false;
		this.overheadTextCyclesRemaining = 100;
		this.overheadTextColor = 0;
		this.overheadTextEffect = 0;
		this.hitSplatCount = 0;
		this.hitSplatTypes = new int[4];
		this.hitSplatValues = new int[4];
		this.hitSplatCycles = new int[4];
		this.hitSplatTypes2 = new int[4];
		this.hitSplatValues2 = new int[4];
		this.healthBars = new IterableNodeDeque();
		this.targetIndex = -1;
		this.interactingChanged(-1);
		this.false0 = false;
		this.field1015 = -1;
		this.movementSequence = -1;
		this.movementFrame = 0;
		this.movementFrameCycle = 0;
		this.sequence = -1;
		this.animationChanged(-1);
		this.sequenceFrame = 0;
		this.sequenceFrameCycle = 0;
		this.sequenceDelay = 0;
		this.field1011 = 0;
		this.spotAnimation = -1;
		this.spotAnimationChanged(-1);
		this.spotAnimationFrame = 0;
		this.spotAnimationFrameCycle = 0;
		this.npcCycle = 0;
		this.defaultHeight = 200;
		this.field1025 = 0;
		this.field1026 = 32;
		this.pathLength = 0;
		this.pathX = new int[10];
		this.pathY = new int[10];
		this.pathTraversed = new byte[10];
		this.field1031 = 0;
		this.field1032 = 0;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "116176402"
	)
	boolean vmethod2118() {
		return false;
	}

	@ObfuscatedName("bu")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1960813077"
	)
	final void method1828() {
		this.pathLength = 0;
		this.field1032 = 0;
	}

	@ObfuscatedName("be")
	@ObfuscatedSignature(
		signature = "(IIIIIII)V",
		garbageValue = "-1774762927"
	)
	final void method1845(int var1, int var2, int var3, int var4, int var5, int var6) {
		boolean var7 = true;
		boolean var8 = true;

		int var9;
		for (var9 = 0; var9 < 4; ++var9) {
			if (this.hitSplatCycles[var9] > var5) {
				var7 = false;
			} else {
				var8 = false;
			}
		}

		var9 = -1;
		int var10 = -1;
		int var11 = 0;
		if (var1 >= 0) {
			HitSplatDefinition var12 = GrandExchangeOfferUnitPriceComparator.method213(var1);
			var10 = var12.field3327;
			var11 = var12.field3329;
		}

		int var14;
		if (var8) {
			if (var10 == -1) {
				this.applyActorHitsplat(var1, var2, var3, var4, var5, var6);
				return;
			}

			var9 = 0;
			var14 = 0;
			if (var10 == 0) {
				var14 = this.hitSplatCycles[0];
			} else if (var10 == 1) {
				var14 = this.hitSplatValues[0];
			}

			for (int var13 = 1; var13 < 4; ++var13) {
				if (var10 == 0) {
					if (this.hitSplatCycles[var13] < var14) {
						var9 = var13;
						var14 = this.hitSplatCycles[var13];
					}
				} else if (var10 == 1 && this.hitSplatValues[var13] < var14) {
					var9 = var13;
					var14 = this.hitSplatValues[var13];
				}
			}

			if (var10 == 1 && var14 >= var2) {
				this.applyActorHitsplat(var1, var2, var3, var4, var5, var6);
				return;
			}
		} else {
			if (var7) {
				this.hitSplatCount = 0;
			}

			for (var14 = 0; var14 < 4; ++var14) {
				byte var15 = this.hitSplatCount;
				this.hitSplatCount = (byte)((this.hitSplatCount + 1) % 4);
				if (this.hitSplatCycles[var15] <= var5) {
					var9 = var15;
					break;
				}
			}
		}

		if (var9 < 0) {
			this.applyActorHitsplat(var1, var2, var3, var4, var5, var6);
		} else {
			this.hitSplatTypes[var9] = var1;
			this.hitSplatValues[var9] = var2;
			this.hitSplatTypes2[var9] = var3;
			this.hitSplatValues2[var9] = var4;
			this.hitSplatCycles[var9] = var5 + var11 + var6;
			this.applyActorHitsplat(var1, var2, var3, var4, var5, var6);
		}
	}

	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		signature = "(IIIIIIB)V",
		garbageValue = "-58"
	)
	final void method1831(int var1, int var2, int var3, int var4, int var5, int var6) {
		this.setCombatInfo(var1, var2, var3, var4, var5, var6);
		HealthBarDefinition var8 = (HealthBarDefinition)HealthBarDefinition.HealthBarDefinition_cached.method3418((long)var1);
		HealthBarDefinition var7;
		if (var8 != null) {
			var7 = var8;
		} else {
			byte[] var9 = HealthBarDefinition.HealthBarDefinition_archive.method4224(33, var1, (byte)-90);
			var8 = new HealthBarDefinition();
			if (var9 != null) {
				var8.method4521(new Buffer(var9));
			}

			HealthBarDefinition.HealthBarDefinition_cached.method3424(var8, (long)var1);
			var7 = var8;
		}

		var8 = var7;
		HealthBar var14 = null;
		HealthBar var10 = null;
		int var11 = var7.int2;
		int var12 = 0;

		HealthBar var13;
		for (var13 = (HealthBar)this.healthBars.method4860(); var13 != null; var13 = (HealthBar)this.healthBars.method4915()) {
			++var12;
			if (var13.definition.field3276 == var8.field3276) {
				var13.method2111(var2 + var4, var5, var6, var3);
				return;
			}

			if (var13.definition.int1 <= var8.int1) {
				var14 = var13;
			}

			if (var13.definition.int2 > var11) {
				var10 = var13;
				var11 = var13.definition.int2;
			}
		}

		if (var10 != null || var12 < 4) {
			var13 = new HealthBar(var8);
			if (var14 == null) {
				this.healthBars.method4880(var13);
			} else {
				IterableNodeDeque.method4893(var13, var14);
			}

			var13.method2111(var2 + var4, var5, var6, var3);
			if (var12 >= 4) {
				var10.method3657();
			}

		}
	}

	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "671360815"
	)
	final void method1832(int var1) {
		HealthBarDefinition var3 = (HealthBarDefinition)HealthBarDefinition.HealthBarDefinition_cached.method3418((long)var1);
		HealthBarDefinition var2;
		if (var3 != null) {
			var2 = var3;
		} else {
			byte[] var4 = HealthBarDefinition.HealthBarDefinition_archive.method4224(33, var1, (byte)-57);
			var3 = new HealthBarDefinition();
			if (var4 != null) {
				var3.method4521(new Buffer(var4));
			}

			HealthBarDefinition.HealthBarDefinition_cached.method3424(var3, (long)var1);
			var2 = var3;
		}

		var3 = var2;

		for (HealthBar var5 = (HealthBar)this.healthBars.method4860(); var5 != null; var5 = (HealthBar)this.healthBars.method4915()) {
			if (var3 == var5.definition) {
				var5.method3657();
				return;
			}
		}

	}

	public void setCombatInfo(int var1, int var2, int var3, int var4, int var5, int var6) {
		if (var5 == 0) {
			if (this instanceof net.runelite.api.Player) {
				PlayerDeath var7 = new PlayerDeath((net.runelite.api.Player)this);
				WorldMapSection1.client.getCallbacks().post(PlayerDeath.class, var7);
			} else if (this instanceof RSNPC) {
				((RSNPC)this).setDead(true);
			}
		}

	}

	public RSIterableNodeDeque getHealthBars() {
		return this.healthBars;
	}

	public int getRSInteracting() {
		return this.targetIndex;
	}

	public String getOverheadText() {
		return this.overheadText;
	}

	public int getX() {
		return this.x;
	}

	public net.runelite.api.Actor getInteracting() {
		int var1 = this.getRSInteracting();
		if (var1 != -1 && var1 != 65535) {
			if (var1 < 32768) {
				RSNPC[] var3 = WorldMapSection1.client.getCachedNPCs();
				return var3[var1];
			} else {
				var1 -= 32768;
				RSPlayer[] var2 = WorldMapSection1.client.getCachedPlayers();
				return var2[var1];
			}
		} else {
			return null;
		}
	}

	public int[] getPathX() {
		return this.pathX;
	}

	public WorldPoint getWorldLocation() {
		return WorldPoint.fromLocal(WorldMapSection1.client, this.getPathX()[0] * 128 + 64, this.getPathY()[0] * 128 + 64, WorldMapSection1.client.getPlane());
	}

	public LocalPoint getLocalLocation() {
		return new LocalPoint(this.getX(), this.getY());
	}

	public int getY() {
		return this.y;
	}

	public int getAnimation() {
		return this.sequence;
	}

	public int getActionFrame() {
		return this.sequenceFrame;
	}

	public void applyActorHitsplat(int var1, int var2, int var3, int var4, int var5, int var6) {
		Hitsplat var7 = new Hitsplat(HitsplatType.fromInteger(var1), var2, var5 + var6);
		HitsplatApplied var8 = new HitsplatApplied();
		var8.setActor(this);
		var8.setHitsplat(var7);
		WorldMapSection1.client.getCallbacks().post(HitsplatApplied.class, var8);
	}

	public int[] getPathY() {
		return this.pathY;
	}

	public int getPoseFrame() {
		return this.movementFrame;
	}

	public int getSpotAnimationFrame() {
		return this.spotAnimationFrame;
	}

	public int getActionFrameCycle() {
		return this.sequenceFrameCycle;
	}

	public void setActionFrame(int var1) {
		this.sequenceFrame = var1;
	}

	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1"
	)
	public void animationChanged(int var1) {
		AnimationChanged var2 = new AnimationChanged();
		var2.setActor(this);
		WorldMapSection1.client.getCallbacks().post(AnimationChanged.class, var2);
	}

	public void setPoseFrame(int var1) {
		this.movementFrame = var1;
	}

	public int getPoseFrameCycle() {
		return this.movementFrameCycle;
	}

	public void setSpotAnimationFrame(int var1) {
		this.spotAnimationFrame = var1;
	}

	public int getOrientation() {
		return this.orientation;
	}

	public int getSpotAnimationFrameCycle() {
		return this.spotAnimationFrameCycle;
	}

	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1"
	)
	public void overheadTextChanged(int var1) {
		String var2 = this.getOverheadText();
		if (var2 != null) {
			OverheadTextChanged var3 = new OverheadTextChanged(this, var2);
			WorldMapSection1.client.getCallbacks().post(OverheadTextChanged.class, var3);
		}

	}

	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1"
	)
	public void spotAnimationChanged(int var1) {
		SpotAnimationChanged var2 = new SpotAnimationChanged();
		var2.setActor(this);
		WorldMapSection1.client.getCallbacks().post(SpotAnimationChanged.class, var2);
	}

	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1"
	)
	public void interactingChanged(int var1) {
		InteractingChanged var2 = new InteractingChanged(this, this.getInteracting());
		WorldMapSection1.client.getCallbacks().post(InteractingChanged.class, var2);
	}

	public int getHealthRatio() {
		RSIterableNodeDeque var1 = this.getHealthBars();
		if (var1 != null) {
			RSNode var2 = var1.getCurrent();
			RSNode var3 = var2.getNext();
			if (var3 instanceof RSHealthBar) {
				RSHealthBar var4 = (RSHealthBar)var3;
				RSIterableNodeDeque var5 = var4.getUpdates();
				RSNode var6 = var5.getCurrent();
				RSNode var7 = var6.getNext();
				if (var7 instanceof RSHealthBarUpdate) {
					RSHealthBarUpdate var8 = (RSHealthBarUpdate)var7;
					return var8.getHealthRatio();
				}
			}
		}

		return -1;
	}

	public int getHealthScale() {
		RSIterableNodeDeque var1 = this.getHealthBars();
		if (var1 != null) {
			RSNode var2 = var1.getCurrent();
			RSNode var3 = var2.getNext();
			if (var3 instanceof RSHealthBar) {
				RSHealthBar var4 = (RSHealthBar)var3;
				RSHealthBarDefinition var5 = var4.getDefinition();
				return var5.getHealthScale();
			}
		}

		return -1;
	}

	public Polygon getCanvasTilePoly() {
		return Perspective.getCanvasTilePoly(WorldMapSection1.client, this.getLocalLocation());
	}

	public Point getCanvasTextLocation(Graphics2D var1, String var2, int var3) {
		return Perspective.getCanvasTextLocation(WorldMapSection1.client, var1, this.getLocalLocation(), var2, var3);
	}

	public Point getCanvasImageLocation(BufferedImage var1, int var2) {
		return Perspective.getCanvasImageLocation(WorldMapSection1.client, this.getLocalLocation(), var1, var2);
	}

	public Point getCanvasSpriteLocation(net.runelite.api.Sprite var1, int var2) {
		return Perspective.getCanvasSpriteLocation(WorldMapSection1.client, this.getLocalLocation(), var1, var2);
	}

	public Point getMinimapLocation() {
		return Perspective.localToMinimap(WorldMapSection1.client, this.getLocalLocation());
	}

	public WorldArea getWorldArea() {
		int var1 = 1;
		if (this instanceof net.runelite.api.NPC) {
			net.runelite.api.NPCDefinition var2 = ((net.runelite.api.NPC)this).getDefinition();
			if (var2 != null && var2.getConfigs() != null) {
				var2 = var2.transform();
			}

			if (var2 != null) {
				var1 = var2.getSize();
			}
		}

		return new WorldArea(this.getWorldLocation(), var1, var1);
	}

	public int getCurrentOrientation() {
		return this.rotation;
	}

	public void setIdlePoseAnimation(int var1) {
		this.idleSequence = var1;
	}

	public int getIdleAnimation() {
		return this.idleSequence;
	}

	public int getTurnLeftAnimation() {
		return this.turnLeftSequence;
	}

	public int getTurnRightAnimation() {
		return this.turnRightSequence;
	}

	public int getWalkAnimation() {
		return this.walkSequence;
	}

	public int getWalkBackAnimation() {
		return this.walkBackSequence;
	}

	public int getWalkLeftAnimation() {
		return this.walkLeftSequence;
	}

	public int getWalkRightAnimation() {
		return this.walkRightSequence;
	}

	public int getRunAnimation() {
		return this.runSequence;
	}

	public void setOverheadText(String var1) {
		this.overheadText = var1;
	}

	public int[] getHitsplatTypes() {
		return this.hitSplatTypes;
	}

	public int[] getHitsplatValues() {
		return this.hitSplatValues;
	}

	public int[] getHitsplatCycles() {
		return this.hitSplatCycles;
	}

	public void setPoseAnimation(int var1) {
		this.movementSequence = var1;
	}

	public int getMovementAnimation() {
		return this.movementSequence;
	}

	public void setAnimation(int var1) {
		this.sequence = var1;
	}

	public int getSpotAnimation() {
		return this.spotAnimation;
	}

	public void setSpotAnimation(int var1) {
		this.spotAnimation = var1;
	}

	public int getLogicalHeight() {
		return this.defaultHeight;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-2086656267"
	)
	static int method1846(int var0) {
		return (int)((Math.log((double)var0) / Interpreter.field1128 - 7.0D) * 256.0D);
	}
}
