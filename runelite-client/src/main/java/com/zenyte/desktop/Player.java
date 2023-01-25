package com.zenyte.desktop;

import java.awt.Polygon;
import java.awt.Shape;
import java.util.ArrayList;
import net.runelite.api.HeadIcon;
import net.runelite.api.Perspective;
import net.runelite.api.SkullIcon;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.PlayerAppearanceChanged;
import net.runelite.api.events.player.headicon.OverheadPrayerChanged;
import net.runelite.api.events.player.headicon.PlayerSkullChanged;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSModel;
import net.runelite.rs.api.RSPlayer;
import net.runelite.rs.api.RSPlayerAppearance;
import net.runelite.rs.api.RSUsername;

@ObfuscatedName("bi")
public final class Player extends Actor implements RSPlayer {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lku;"
	)
	Username username;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lhk;"
	)
	PlayerAppearance appearance;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -955452579
	)
	int headIconPk;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1682761079
	)
	int headIconPrayer;
	@ObfuscatedName("v")
	String[] actions;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1517162387
	)
	int combatLevel;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 614146335
	)
	int skillLevel;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -550900363
	)
	int tileHeight;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1364374011
	)
	int animationCycleStart;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -1470813775
	)
	int animationCycleEnd;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 168679087
	)
	int field662;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 620810729
	)
	int tileHeight2;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -2027049547
	)
	int field657;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lel;"
	)
	Model model0;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1127396435
	)
	int field659;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 240208849
	)
	int field660;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -2013432115
	)
	int field661;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -971151235
	)
	int field664;
	@ObfuscatedName("l")
	boolean isUnanimated;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -1431900799
	)
	int team;
	@ObfuscatedName("o")
	boolean isHidden;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -777722891
	)
	int plane;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1532250791
	)
	int index;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lkv;"
	)
	TriBool isFriendTriBool;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lkv;"
	)
	TriBool isInClanChat;
	@ObfuscatedName("ae")
	boolean field670;
	@ObfuscatedName("ai")
	@ObfuscatedGetter(
		intValue = 1349885547
	)
	int tileX;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = -1671422285
	)
	int tileY;
	public boolean friended;
	public int oldHeadIcon;
	public int oldSkullIcon;

	Player() {
		this.headIconPk = -1;
		this.skullChanged(-1);
		this.headIconPrayer = -1;
		this.prayerChanged(-1);
		this.actions = new String[3];

		for (int var1 = 0; var1 < 3; ++var1) {
			this.actions[var1] = "";
		}

		this.combatLevel = 0;
		this.skillLevel = 0;
		this.animationCycleStart = 0;
		this.animationCycleEnd = 0;
		this.isUnanimated = false;
		this.team = 0;
		this.isHidden = false;
		this.isFriendTriBool = TriBool.TriBool_unknown;
		this.isInClanChat = TriBool.TriBool_unknown;
		this.field670 = false;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lkb;I)V"
	)
	final void method1330(Buffer var1, int var2) {
		long var3 = this.getPlayerAppearance() == null ? 0L : this.getPlayerAppearance().getHash();
		this.copy$read(var1, var2);
		if (this.getPlayerAppearance().getHash() != var3) {
			WorldMapSection1.client.getCallbacks().post(PlayerAppearanceChanged.class, new PlayerAppearanceChanged(this));
		}

	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "990067508"
	)
	boolean method1351() {
		if (this.isFriendTriBool == TriBool.TriBool_unknown) {
			this.method1333();
		}

		return this.isFriendTriBool == TriBool.TriBool_true;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "77261851"
	)
	void method1332() {
		this.isFriendTriBool = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1863320246"
	)
	void method1333() {
		this.isFriendTriBool = Projectile.friendSystem.method1951(this.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
		this.updateFriended();
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1535464163"
	)
	boolean method1334() {
		if (this.isInClanChat == TriBool.TriBool_unknown) {
			this.method1336();
		}

		return this.isInClanChat == TriBool.TriBool_true;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "52"
	)
	void method1375() {
		this.isInClanChat = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "101"
	)
	void method1336() {
		this.isInClanChat = InterfaceParent.clanChat != null && InterfaceParent.clanChat.method5117(this.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "52"
	)
	int method1337() {
		return this.appearance != null && this.appearance.npcTransformId != -1 ? class237.method4201(this.appearance.npcTransformId).size : 1;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)Lel;"
	)
	protected final Model vmethod3353(int var1) {
		if (!WorldMapSection1.client.isInterpolatePlayerAnimations()) {
			return (Model)this.copy$getModel(var1);
		} else {
			int var2 = this.getActionFrame();
			int var3 = this.getPoseFrame();
			int var4 = this.getSpotAnimationFrame();

			Model var5;
			try {
				this.setActionFrame(Integer.MIN_VALUE | this.getActionFrameCycle() << 16 | var2);
				this.setPoseFrame(Integer.MIN_VALUE | this.getPoseFrameCycle() << 16 | var3);
				this.setSpotAnimationFrame(Integer.MIN_VALUE | this.getSpotAnimationFrameCycle() << 16 | var4);
				var5 = this.copy$getModel(var1);
			} finally {
				this.setActionFrame(var2);
				this.setPoseFrame(var3);
				this.setSpotAnimationFrame(var4);
			}

			return (Model)var5;
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IIBI)V",
		garbageValue = "-618087503"
	)
	final void method1339(int var1, int var2, byte var3) {
		if (super.sequence != -1 && SpotAnimationDefinition.method4478(super.sequence).field3524 == 1) {
			super.sequence = -1;
			this.animationChanged(-1);
		}

		super.field1015 = -1;
		if (var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
			if (super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
				if (var3 == 2) {
					SoundCache.method2595(this, var1, var2, (byte)2);
				}

				this.method1341(var1, var2, var3);
			} else {
				this.method1379(var1, var2);
			}
		} else {
			this.method1379(var1, var2);
		}

	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-2118599552"
	)
	void method1379(int var1, int var2) {
		super.pathLength = 0;
		super.field1032 = 0;
		super.field1031 = 0;
		super.pathX[0] = var1;
		super.pathY[0] = var2;
		int var3 = this.method1337();
		super.x = super.pathX[0] * 128 + var3 * 64;
		super.y = super.pathY[0] * 128 + var3 * 64;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IIBI)V",
		garbageValue = "1447911882"
	)
	final void method1341(int var1, int var2, byte var3) {
		if (super.pathLength < 9) {
			++super.pathLength;
		}

		for (int var4 = super.pathLength; var4 > 0; --var4) {
			super.pathX[var4] = super.pathX[var4 - 1];
			super.pathY[var4] = super.pathY[var4 - 1];
			super.pathTraversed[var4] = super.pathTraversed[var4 - 1];
		}

		super.pathX[0] = var1;
		super.pathY[0] = var2;
		super.pathTraversed[0] = var3;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "116176402"
	)
	final boolean vmethod2118() {
		return this.appearance != null;
	}

	public boolean isFriend() {
		return this.method1351();
	}

	public RSUsername getRsName() {
		return this.username;
	}

	public RSPlayerAppearance getPlayerAppearance() {
		return this.appearance;
	}

	public int getRsSkullIcon() {
		return this.headIconPk;
	}

	public int getRsOverheadIcon() {
		return this.headIconPrayer;
	}

	public SkullIcon skullFromInt(int var1) {
		switch(var1) {
		case 0:
			return SkullIcon.SKULL;
		case 1:
			return SkullIcon.SKULL_FIGHT_PIT;
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		default:
			return null;
		case 8:
			return SkullIcon.DEAD_MAN_FIVE;
		case 9:
			return SkullIcon.DEAD_MAN_FOUR;
		case 10:
			return SkullIcon.DEAD_MAN_THREE;
		case 11:
			return SkullIcon.DEAD_MAN_TWO;
		case 12:
			return SkullIcon.DEAD_MAN_ONE;
		}
	}

	public HeadIcon getHeadIcon(int var1) {
		switch(var1) {
		case 0:
			return HeadIcon.MELEE;
		case 1:
			return HeadIcon.RANGED;
		case 2:
			return HeadIcon.MAGIC;
		case 3:
			return HeadIcon.RETRIBUTION;
		case 4:
			return HeadIcon.SMITE;
		case 5:
			return HeadIcon.REDEMPTION;
		default:
			return null;
		}
	}

	@ObfuscatedSignature(
		signature = "(Lkb;I)V"
	)
	public final void copy$read(Buffer var1, int var2) {
		var1.offset = 0;
		int var3 = var1.method5547();
		this.headIconPk = var1.method5548();
		this.skullChanged(-1);
		this.headIconPrayer = var1.method5548();
		this.prayerChanged(-1);
		int var4 = -1;
		this.team = 0;
		int[] var5 = new int[12];

		int var7;
		int var8;
		for (int var6 = 0; var6 < 12; ++var6) {
			if (var2 >= -1370407384) {
				return;
			}

			var7 = var1.method5547();
			if (var7 == 0) {
				var5[var6] = 0;
			} else {
				var8 = var1.method5547();
				var5[var6] = var8 + (var7 << 8);
				if (var6 == 0 && var5[0] == 65535) {
					var4 = var1.method5549();
					break;
				}

				if (var5[var6] >= 512) {
					int var9 = AbstractWorldMapData.method373(var5[var6] - 512).team;
					if (var9 != 0) {
						this.team = var9;
					}
				}
			}
		}

		int[] var10 = new int[5];

		for (var7 = 0; var7 < 5; ++var7) {
			if (var2 >= -1370407384) {
				return;
			}

			label113: {
				var8 = var1.method5547();
				if (var8 >= 0) {
					if (var8 < VertexNormal.field1764[var7].length) {
						break label113;
					}

					if (var2 >= -1370407384) {
						return;
					}
				}

				var8 = 0;
			}

			var10[var7] = var8;
		}

		super.idleSequence = var1.method5549();
		if (super.idleSequence == 65535) {
			super.idleSequence = -1;
		}

		super.turnLeftSequence = var1.method5549();
		if (super.turnLeftSequence == 65535) {
			super.turnLeftSequence = -1;
		}

		super.turnRightSequence = super.turnLeftSequence;
		super.walkSequence = var1.method5549();
		if (super.walkSequence == 65535) {
			super.walkSequence = -1;
		}

		super.walkBackSequence = var1.method5549();
		if (super.walkBackSequence == 65535) {
			super.walkBackSequence = -1;
		}

		super.walkLeftSequence = var1.method5549();
		if (super.walkLeftSequence == 65535) {
			if (var2 >= -1370407384) {
				return;
			}

			super.walkLeftSequence = -1;
		}

		super.walkRightSequence = var1.method5549();
		if (super.walkRightSequence == 65535) {
			super.walkRightSequence = -1;
		}

		super.runSequence = var1.method5549();
		if (super.runSequence == 65535) {
			super.runSequence = -1;
		}

		this.username = new Username(var1.method5667(), WorldMapIcon_0.loginType);
		this.method1332();
		this.method1375();
		if (this == ByteArrayPool.localPlayer) {
			RunException.localPlayerName = this.username.method5238();
		}

		this.combatLevel = var1.method5547();
		this.skillLevel = var1.method5549();
		boolean var10001;
		if (var1.method5547() == 1) {
			if (var2 >= -1370407384) {
				return;
			}

			var10001 = true;
		} else {
			var10001 = false;
		}

		this.isHidden = var10001;
		if (Client.gameBuild == 0 && Client.staffModLevel >= 2) {
			this.isHidden = false;
		}

		if (this.appearance == null) {
			this.appearance = new PlayerAppearance();
		}

		this.appearance.method4080(var5, var10, var3 == 1, var4);
	}

	@ObfuscatedSignature(
		signature = "(I)Lel;"
	)
	public final Model copy$getModel(int var1) {
		if (this.appearance == null) {
			return null;
		} else {
			SequenceDefinition var2 = super.sequence != -1 && super.sequenceDelay == 0 ? SpotAnimationDefinition.method4478(super.sequence) : null;
			SequenceDefinition var3 = super.movementSequence == -1 || this.isUnanimated || super.idleSequence == super.movementSequence && var2 != null ? null : SpotAnimationDefinition.method4478(super.movementSequence);
			Model var4 = this.appearance.method4069(var2, super.sequenceFrame, var3, super.movementFrame);
			if (var4 == null) {
				return null;
			} else {
				var4.method2955();
				super.defaultHeight = var4.height;
				Model var5;
				Model[] var6;
				if (!this.isUnanimated && super.spotAnimation != -1 && super.spotAnimationFrame != -1) {
					var5 = MouseHandler.method1205(super.spotAnimation).method4467(super.spotAnimationFrame);
					if (var5 != null) {
						var5.method2966(0, -super.field1033, 0);
						var6 = new Model[]{var4, var5};
						var4 = new Model(var6, 2);
					}
				}

				if (!this.isUnanimated && this.model0 != null) {
					if (Client.cycle >= this.animationCycleEnd) {
						this.model0 = null;
					}

					if (Client.cycle >= this.animationCycleStart && Client.cycle < this.animationCycleEnd) {
						var5 = this.model0;
						var5.method2966(this.field662 - super.x, this.tileHeight2 - this.tileHeight, this.field657 - super.y);
						if (super.orientation == 512) {
							var5.method2969();
							var5.method2969();
							var5.method2969();
						} else if (super.orientation == 1024) {
							var5.method2969();
							var5.method2969();
						} else if (super.orientation == 1536) {
							var5.method2969();
						}

						var6 = new Model[]{var4, var5};
						var4 = new Model(var6, 2);
						if (super.orientation == 512) {
							var5.method2969();
						} else if (super.orientation == 1024) {
							var5.method2969();
							var5.method2969();
						} else if (super.orientation == 1536) {
							var5.method2969();
							var5.method2969();
							var5.method2969();
						}

						var5.method2966(super.x - this.field662, this.tileHeight - this.tileHeight2, super.y - this.field657);
					}
				}

				var4.isSingleTile = true;
				return var4;
			}
		}
	}

	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1"
	)
	public void skullChanged(int var1) {
		SkullIcon var2 = this.skullFromInt(this.getRsSkullIcon());
		if (this.getRsSkullIcon() != this.oldSkullIcon) {
			WorldMapSection1.client.getCallbacks().post(PlayerSkullChanged.class, new PlayerSkullChanged(this, this.skullFromInt(this.getRsSkullIcon()), var2));
		}

		this.oldSkullIcon = this.getRsSkullIcon();
	}

	public void updateFriended() {
		this.friended = WorldMapSection1.client.getFriendManager().isFriended(this.getRsName(), false);
	}

	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1"
	)
	public void prayerChanged(int var1) {
		if (this.getRsOverheadIcon() != -1 || this.oldHeadIcon != -1) {
			HeadIcon var2 = this.getHeadIcon(this.getRsOverheadIcon());
			if (this.getRsOverheadIcon() != this.oldHeadIcon) {
				WorldMapSection1.client.getCallbacks().post(OverheadPrayerChanged.class, new OverheadPrayerChanged(this, this.getHeadIcon(this.oldHeadIcon), var2));
			}
		}

		this.oldHeadIcon = this.getRsOverheadIcon();
	}

	public String getName() {
		RSUsername var1 = this.getRsName();
		if (var1 == null) {
			return null;
		} else {
			String var2 = var1.getName();
			return var2 == null ? null : var2.replace(' ', ' ');
		}
	}

	public HeadIcon getOverheadIcon() {
		return this.getHeadIcon(this.getRsOverheadIcon());
	}

	public SkullIcon getSkullIcon() {
		return this.skullFromInt(this.getRsSkullIcon());
	}

	public Polygon[] getPolygons() {
		RSModel var1 = this.getModel();
		if (var1 == null) {
			return null;
		} else {
			int[] var2 = new int[var1.getVerticesCount()];
			int[] var3 = new int[var1.getVerticesCount()];
			int var4 = this.getX();
			int var5 = this.getY();
			int var6 = Perspective.getTileHeight(WorldMapSection1.client, new LocalPoint(var4, var5), WorldMapSection1.client.getPlane());
			Perspective.modelToCanvas(WorldMapSection1.client, var1.getVerticesCount(), var4, var5, var6, this.getOrientation(), var1.getVerticesX(), var1.getVerticesZ(), var1.getVerticesY(), var2, var3);
			ArrayList var7 = new ArrayList(var1.getTrianglesCount());
			int[] var8 = var1.getTrianglesX();
			int[] var9 = var1.getTrianglesY();
			int[] var10 = var1.getTrianglesZ();

			for (int var11 = 0; var11 < var1.getTrianglesCount(); ++var11) {
				int[] var12 = new int[]{var2[var8[var11]], var2[var9[var11]], var2[var10[var11]]};
				int[] var13 = new int[]{var3[var8[var11]], var3[var9[var11]], var3[var10[var11]]};
				var7.add(new Polygon(var12, var13, 3));
			}

			return (Polygon[])var7.toArray(new Polygon[0]);
		}
	}

	public Shape getConvexHull() {
		RSModel var1 = this.getModel();
		if (var1 == null) {
			return null;
		} else {
			int var2 = Perspective.getTileHeight(WorldMapSection1.client, new LocalPoint(this.getX(), this.getY()), WorldMapSection1.client.getPlane());
			return var1.getConvexHull(this.getX(), this.getY(), this.getOrientation(), var2);
		}
	}

	public boolean isFriended() {
		return this.isFriend() || this.friended;
	}

	public int getCombatLevel() {
		return this.combatLevel;
	}

	public int getTotalLevel() {
		return this.skillLevel;
	}

	public int getTeam() {
		return this.team;
	}

	public int getPlayerId() {
		return this.index;
	}

	public boolean isClanMember() {
		return this.method1334();
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "556074954"
	)
	static int method1342() {
		return ++Messages.Messages_count - 1;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(IZIZI)V",
		garbageValue = "1788243043"
	)
	static void method1384(int var0, boolean var1, int var2, boolean var3) {
		if (UserComparator2.World_worlds != null) {
			ModelData0.method3349(0, UserComparator2.World_worlds.length - 1, var0, var1, var2, var3);
		}

	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-389992863"
	)
	static void method1383() {
		Players.Players_count = 0;

		for (int var0 = 0; var0 < 2048; ++var0) {
			Players.field1269[var0] = null;
			Players.field1273[var0] = 1;
		}

	}

	@ObfuscatedName("fg")
	static final void method1369(int var0, int var1) {
		Client.copy$forceDisconnect(var0, var1);
		if (Client.hideDisconnect && var0 == 1) {
			WorldMapSection1.client.promptCredentials(true);
		}

	}

	@ObfuscatedName("ju")
	@ObfuscatedSignature(
		signature = "(Lhe;IIB)V",
		garbageValue = "2"
	)
	static final void method1380(Widget var0, int var1, int var2) {
		if (Client.clickedWidget == null && !Client.isMenuOpen) {
			if (var0 != null && KitDefinition.method4514(var0) != null) {
				Client.clickedWidget = var0;
				Client.clickedWidgetParent = KitDefinition.method4514(var0);
				Client.widgetClickX = var1;
				Client.widgetClickY = var2;
				MilliClock.widgetDragDuration = 0;
				Client.isDraggingWidget = false;
				Client.draggingWidgetChanged(-1);
				int var3 = AbstractWorldMapData.method381();
				if (var3 != -1) {
					AbstractWorldMapIcon.tempMenuAction = new MenuAction();
					Client.onTempMenuActionChanged(-1);
					AbstractWorldMapIcon.tempMenuAction.param0 = Client.menuArguments1[var3];
					AbstractWorldMapIcon.tempMenuAction.param1 = Client.menuArguments2[var3];
					AbstractWorldMapIcon.tempMenuAction.opcode = Client.menuOpcodes[var3];
					AbstractWorldMapIcon.tempMenuAction.identifier = Client.menuIdentifiers[var3];
					AbstractWorldMapIcon.tempMenuAction.action = Client.menuActions[var3];
				}

			}
		}
	}
}
