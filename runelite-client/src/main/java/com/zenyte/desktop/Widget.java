package com.zenyte.desktop;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import net.runelite.api.Point;
import net.runelite.api.WidgetNode;
import net.runelite.api.events.WidgetHiddenChanged;
import net.runelite.api.events.WidgetPositioned;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSFont;
import net.runelite.rs.api.RSNode;
import net.runelite.rs.api.RSNodeHashTable;
import net.runelite.rs.api.RSSprite;
import net.runelite.rs.api.RSWidget;

@ObfuscatedName("he")
public class Widget extends Node implements RSWidget {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "[[Lhe;"
	)
	public static Widget[][] Widget_interfaceComponents;
	@ObfuscatedName("z")
	static boolean[] Widget_loadedInterfaces;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	static AbstractArchive Widget_archive;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	static AbstractArchive Widget_fontsArchive;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	public static EvictingDualNodeHashTable Widget_cachedSprites;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	public static EvictingDualNodeHashTable Widget_cachedModels;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	public static EvictingDualNodeHashTable Widget_cachedFonts;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	public static EvictingDualNodeHashTable Widget_cachedSpriteMasks;
	@ObfuscatedName("i")
	public static boolean field2565;
	// $FF: synthetic field
	public static boolean $assertionsDisabled;
	public static int rl$widgetLastPosChanged;
	@ObfuscatedName("a")
	public boolean isIf3;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -957641141
	)
	public int id;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -611900971
	)
	public int childIndex;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -802488779
	)
	public int type;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -248776571
	)
	public int buttonType;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1856343159
	)
	public int contentType;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1508256889
	)
	public int xAlignment;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 286003577
	)
	public int yAlignment;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1131410983
	)
	public int widthAlignment;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = 357993753
	)
	public int heightAlignment;
	@ObfuscatedName("an")
	@ObfuscatedGetter(
		intValue = -1997338621
	)
	public int rawX;
	@ObfuscatedName("ai")
	@ObfuscatedGetter(
		intValue = -1586734249
	)
	public int rawY;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = -1225404085
	)
	public int rawWidth;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = -568238685
	)
	public int rawHeight;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = 893339967
	)
	public int x;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = -426365475
	)
	public int y;
	@ObfuscatedName("at")
	@ObfuscatedGetter(
		intValue = -1065823023
	)
	public int width;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = 379197055
	)
	public int height;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = 162401447
	)
	public int field2584;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = 1885155777
	)
	public int field2585;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = 1237608307
	)
	public int parentId;
	@ObfuscatedName("ao")
	public boolean isHidden;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = 615773905
	)
	public int scrollX;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = 1171290753
	)
	public int scrollY;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = 108625295
	)
	public int scrollWidth;
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = 1982360223
	)
	public int scrollHeight;
	@ObfuscatedName("ax")
	@ObfuscatedGetter(
		intValue = 1176894453
	)
	public int color;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = 306036279
	)
	public int color2;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		intValue = 466751965
	)
	public int mouseOverColor;
	@ObfuscatedName("ay")
	@ObfuscatedGetter(
		intValue = 1324656195
	)
	public int mouseOverColor2;
	@ObfuscatedName("ad")
	public boolean fill;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		signature = "Llu;"
	)
	public class332 fillMode;
	@ObfuscatedName("ah")
	@ObfuscatedGetter(
		intValue = 14590311
	)
	public int transparencyTop;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		intValue = 974116043
	)
	public int transparencyBot;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = 2009428193
	)
	public int lineWid;
	@ObfuscatedName("bf")
	public boolean field2601;
	@ObfuscatedName("bc")
	@ObfuscatedGetter(
		intValue = 66057751
	)
	public int spriteId2;
	@ObfuscatedName("bo")
	@ObfuscatedGetter(
		intValue = -1011748949
	)
	public int spriteId;
	@ObfuscatedName("bd")
	@ObfuscatedGetter(
		intValue = -911208959
	)
	public int spriteAngle;
	@ObfuscatedName("bk")
	public boolean spriteTiling;
	@ObfuscatedName("bu")
	@ObfuscatedGetter(
		intValue = -551996645
	)
	public int outline;
	@ObfuscatedName("be")
	@ObfuscatedGetter(
		intValue = 898417273
	)
	public int spriteShadow;
	@ObfuscatedName("bg")
	public boolean spriteFlipV;
	@ObfuscatedName("bt")
	public boolean spriteFlipH;
	@ObfuscatedName("bh")
	@ObfuscatedGetter(
		intValue = -1679439917
	)
	public int modelType;
	@ObfuscatedName("br")
	@ObfuscatedGetter(
		intValue = 483051319
	)
	public int modelId;
	@ObfuscatedName("bq")
	@ObfuscatedGetter(
		intValue = 125406963
	)
	int modelType2;
	@ObfuscatedName("ba")
	@ObfuscatedGetter(
		intValue = 1734767957
	)
	int modelId2;
	@ObfuscatedName("bv")
	@ObfuscatedGetter(
		intValue = -166910705
	)
	public int sequenceId;
	@ObfuscatedName("bx")
	@ObfuscatedGetter(
		intValue = -389521949
	)
	public int sequenceId2;
	@ObfuscatedName("bz")
	@ObfuscatedGetter(
		intValue = 1269071469
	)
	public int modelOffsetX;
	@ObfuscatedName("bs")
	@ObfuscatedGetter(
		intValue = -924975785
	)
	public int modelOffsetY;
	@ObfuscatedName("bp")
	@ObfuscatedGetter(
		intValue = -1358169901
	)
	public int modelAngleX;
	@ObfuscatedName("bm")
	@ObfuscatedGetter(
		intValue = 283299325
	)
	public int modelAngleY;
	@ObfuscatedName("bb")
	@ObfuscatedGetter(
		intValue = 1945900441
	)
	public int modelAngleZ;
	@ObfuscatedName("bn")
	@ObfuscatedGetter(
		intValue = -1346742871
	)
	public int modelZoom;
	@ObfuscatedName("by")
	@ObfuscatedGetter(
		intValue = -1413539479
	)
	public int field2622;
	@ObfuscatedName("bj")
	@ObfuscatedGetter(
		intValue = 1706662487
	)
	public int field2623;
	@ObfuscatedName("bi")
	public boolean modelOrthog;
	@ObfuscatedName("bl")
	public boolean modelTransparency;
	public int rl$x;
	public int rl$y;
	public int rl$parentId;
	@ObfuscatedName("bw")
	@ObfuscatedGetter(
		intValue = 1321908019
	)
	public int itemQuantityMode;
	@ObfuscatedName("cw")
	@ObfuscatedGetter(
		intValue = -1118352365
	)
	public int fontId;
	@ObfuscatedName("cc")
	public String text;
	@ObfuscatedName("ch")
	public String text2;
	@ObfuscatedName("cr")
	@ObfuscatedGetter(
		intValue = -1838623877
	)
	public int textLineHeight;
	@ObfuscatedName("cq")
	@ObfuscatedGetter(
		intValue = -1124877935
	)
	public int textXAlignment;
	@ObfuscatedName("co")
	@ObfuscatedGetter(
		intValue = 1212909225
	)
	public int textYAlignment;
	@ObfuscatedName("cm")
	public boolean textShadowed;
	@ObfuscatedName("cu")
	@ObfuscatedGetter(
		intValue = 99927781
	)
	public int paddingX;
	@ObfuscatedName("cs")
	@ObfuscatedGetter(
		intValue = -534420979
	)
	public int paddingY;
	@ObfuscatedName("cg")
	public int[] inventoryXOffsets;
	@ObfuscatedName("cd")
	public int[] inventoryYOffsets;
	@ObfuscatedName("cx")
	public int[] inventorySprites;
	@ObfuscatedName("cn")
	public String[] itemActions;
	@ObfuscatedName("ci")
	@ObfuscatedGetter(
		intValue = 1025348499
	)
	public int clickMask;
	@ObfuscatedName("cz")
	public boolean field2641;
	@ObfuscatedName("cb")
	public byte[][] field2555;
	@ObfuscatedName("cy")
	public byte[][] field2643;
	@ObfuscatedName("cj")
	public int[] field2644;
	@ObfuscatedName("cp")
	public int[] field2695;
	@ObfuscatedName("dv")
	public String dataText;
	@ObfuscatedName("dd")
	public String[] actions;
	@ObfuscatedName("du")
	@ObfuscatedSignature(
		signature = "Lhe;"
	)
	public Widget parent;
	@ObfuscatedName("dz")
	@ObfuscatedGetter(
		intValue = -1434163873
	)
	public int dragZoneSize;
	@ObfuscatedName("dg")
	@ObfuscatedGetter(
		intValue = -1149387947
	)
	public int dragThreshold;
	@ObfuscatedName("dq")
	public boolean isScrollBar;
	@ObfuscatedName("dj")
	public String spellActionName;
	@ObfuscatedName("dl")
	public boolean hasListener;
	@ObfuscatedName("dm")
	public Object[] onLoad;
	@ObfuscatedName("db")
	public Object[] onClick;
	@ObfuscatedName("dw")
	public Object[] onClickRepeat;
	@ObfuscatedName("de")
	public Object[] onRelease;
	@ObfuscatedName("dh")
	public Object[] onHold;
	@ObfuscatedName("dk")
	public Object[] onMouseOver;
	@ObfuscatedName("da")
	public Object[] onMouseRepeat;
	@ObfuscatedName("do")
	public Object[] onMouseLeave;
	@ObfuscatedName("dr")
	public Object[] onDrag;
	@ObfuscatedName("dx")
	public Object[] onDragComplete;
	@ObfuscatedName("dy")
	public Object[] onTargetEnter;
	@ObfuscatedName("dc")
	public Object[] onTargetLeave;
	@ObfuscatedName("ds")
	public Object[] onVarTransmit;
	@ObfuscatedName("dt")
	public int[] varTransmitTriggers;
	@ObfuscatedName("dp")
	public Object[] onInvTransmit;
	@ObfuscatedName("df")
	public int[] invTransmitTriggers;
	@ObfuscatedName("di")
	public Object[] onStatTransmit;
	@ObfuscatedName("dn")
	public int[] statTransmitTriggers;
	@ObfuscatedName("ea")
	public Object[] onTimer;
	@ObfuscatedName("ex")
	public Object[] onOp;
	@ObfuscatedName("eo")
	public Object[] onScroll;
	@ObfuscatedName("et")
	public Object[] onChatTransmit;
	@ObfuscatedName("eh")
	public Object[] onKey;
	@ObfuscatedName("eq")
	public Object[] onFriendTransmit;
	@ObfuscatedName("el")
	public Object[] onClanTransmit;
	@ObfuscatedName("ei")
	public Object[] onMiscTransmit;
	@ObfuscatedName("en")
	public Object[] onDialogAbort;
	@ObfuscatedName("ec")
	public Object[] onSubChange;
	@ObfuscatedName("ev")
	public Object[] onResize;
	@ObfuscatedName("eb")
	public Object[] onStockTransmit;
	@ObfuscatedName("ej")
	public Object[] field2691;
	@ObfuscatedName("ed")
	public int[][] cs1Instructions;
	@ObfuscatedName("ee")
	public int[] cs1Comparisons;
	@ObfuscatedName("ep")
	public int[] cs1ComparisonValues;
	@ObfuscatedName("er")
	@ObfuscatedGetter(
		intValue = 58254591
	)
	public int mouseOverRedirect;
	@ObfuscatedName("ef")
	public String spellName;
	@ObfuscatedName("eu")
	public String buttonText;
	@ObfuscatedName("em")
	public int[] itemIds;
	@ObfuscatedName("ez")
	public int[] itemQuantities;
	@ObfuscatedName("ek")
	@ObfuscatedGetter(
		intValue = -1761852993
	)
	public int itemId;
	@ObfuscatedName("ey")
	@ObfuscatedGetter(
		intValue = 612667463
	)
	public int itemQuantity;
	@ObfuscatedName("ew")
	@ObfuscatedGetter(
		intValue = 1022717263
	)
	public int modelFrame;
	@ObfuscatedName("eg")
	@ObfuscatedGetter(
		intValue = -1039552423
	)
	public int modelFrameCycle;
	@ObfuscatedName("es")
	@ObfuscatedSignature(
		signature = "[Lhe;"
	)
	public Widget[] children;
	@ObfuscatedName("fk")
	public boolean containsMouse;
	@ObfuscatedName("fw")
	public boolean isClicked;
	@ObfuscatedName("fl")
	@ObfuscatedGetter(
		intValue = -1024561307
	)
	public int field2700;
	@ObfuscatedName("fy")
	@ObfuscatedGetter(
		intValue = 1220339105
	)
	public int field2701;
	@ObfuscatedName("ff")
	@ObfuscatedGetter(
		intValue = -524679265
	)
	public int field2620;
	@ObfuscatedName("fd")
	@ObfuscatedGetter(
		intValue = -1480837579
	)
	public int field2588;
	@ObfuscatedName("fo")
	@ObfuscatedGetter(
		intValue = -612332201
	)
	public int rootIndex;
	@ObfuscatedName("fi")
	@ObfuscatedGetter(
		intValue = 847308047
	)
	public int cycle;
	@ObfuscatedName("fv")
	public int[] field2706;
	@ObfuscatedName("fc")
	public boolean noClickThrough;
	@ObfuscatedName("fp")
	public boolean noScrollThrough;
	@ObfuscatedName("fg")
	public boolean field2658;

	static {
		Widget_cachedSprites = new EvictingDualNodeHashTable(200);
		Widget_cachedModels = new EvictingDualNodeHashTable(50);
		Widget_cachedFonts = new EvictingDualNodeHashTable(20);
		Widget_cachedSpriteMasks = new EvictingDualNodeHashTable(8);
		field2565 = false;
		rl$$clinit();
	}

	public Widget() {
		this.isIf3 = false;
		this.id = -1;
		this.childIndex = -1;
		this.buttonType = 0;
		this.contentType = 0;
		this.xAlignment = 0;
		this.yAlignment = 0;
		this.widthAlignment = 0;
		this.heightAlignment = 0;
		this.rawX = 0;
		this.rawY = 0;
		this.rawWidth = 0;
		this.rawHeight = 0;
		this.x = 0;
		this.y = 0;
		this.onPositionChanged(-1);
		this.width = 0;
		this.height = 0;
		this.field2584 = 1;
		this.field2585 = 1;
		this.parentId = -1;
		this.isHidden = false;
		this.onHiddenChanged(-1);
		this.scrollX = 0;
		this.scrollY = 0;
		this.scrollWidth = 0;
		this.scrollHeight = 0;
		this.color = 0;
		this.color2 = 0;
		this.mouseOverColor = 0;
		this.mouseOverColor2 = 0;
		this.fill = false;
		this.fillMode = class332.SOLID;
		this.transparencyTop = 0;
		this.transparencyBot = 0;
		this.lineWid = 1;
		this.field2601 = false;
		this.spriteId2 = -1;
		this.spriteId = -1;
		this.spriteAngle = 0;
		this.spriteTiling = false;
		this.outline = 0;
		this.spriteShadow = 0;
		this.modelType = 1;
		this.modelId = -1;
		this.modelType2 = 1;
		this.modelId2 = -1;
		this.sequenceId = -1;
		this.sequenceId2 = -1;
		this.modelOffsetX = 0;
		this.modelOffsetY = 0;
		this.modelAngleX = 0;
		this.modelAngleY = 0;
		this.modelAngleZ = 0;
		this.modelZoom = 100;
		this.field2622 = 0;
		this.field2623 = 0;
		this.modelOrthog = false;
		this.modelTransparency = false;
		this.itemQuantityMode = 2;
		this.fontId = -1;
		this.text = "";
		this.text2 = "";
		this.textLineHeight = 0;
		this.textXAlignment = 0;
		this.textYAlignment = 0;
		this.textShadowed = false;
		this.paddingX = 0;
		this.paddingY = 0;
		this.clickMask = 0;
		this.field2641 = false;
		this.dataText = "";
		this.parent = null;
		this.dragZoneSize = 0;
		this.dragThreshold = 0;
		this.isScrollBar = false;
		this.spellActionName = "";
		this.hasListener = false;
		this.mouseOverRedirect = -1;
		this.spellName = "";
		this.buttonText = "Ok";
		this.itemId = -1;
		this.itemQuantity = 0;
		this.modelFrame = 0;
		this.modelFrameCycle = 0;
		this.containsMouse = false;
		this.isClicked = false;
		this.field2700 = -1;
		this.field2701 = 0;
		this.field2620 = 0;
		this.field2588 = 0;
		this.rootIndex = -1;
		this.cycle = -1;
		this.noClickThrough = false;
		this.noScrollThrough = false;
		this.field2658 = false;
		this.rl$$init();
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lkb;B)V",
		garbageValue = "-113"
	)
	void method4109(Buffer var1) {
		this.isIf3 = false;
		this.type = var1.method5547();
		this.buttonType = var1.method5547();
		this.contentType = var1.method5549();
		this.rawX = var1.method5550();
		this.rawY = var1.method5550();
		this.rawWidth = var1.method5549();
		this.rawHeight = var1.method5549();
		this.transparencyTop = var1.method5547();
		this.parentId = var1.method5549();
		if (this.parentId == 65535) {
			this.parentId = -1;
		} else {
			this.parentId += this.id & -65536;
		}

		this.mouseOverRedirect = var1.method5549();
		if (this.mouseOverRedirect == 65535) {
			this.mouseOverRedirect = -1;
		}

		int var2 = var1.method5547();
		int var3;
		if (var2 > 0) {
			this.cs1Comparisons = new int[var2];
			this.cs1ComparisonValues = new int[var2];

			for (var3 = 0; var3 < var2; ++var3) {
				this.cs1Comparisons[var3] = var1.method5547();
				this.cs1ComparisonValues[var3] = var1.method5549();
			}
		}

		var3 = var1.method5547();
		int var4;
		int var5;
		int var6;
		if (var3 > 0) {
			this.cs1Instructions = new int[var3][];

			for (var4 = 0; var4 < var3; ++var4) {
				var5 = var1.method5549();
				this.cs1Instructions[var4] = new int[var5];

				for (var6 = 0; var6 < var5; ++var6) {
					this.cs1Instructions[var4][var6] = var1.method5549();
					if (this.cs1Instructions[var4][var6] == 65535) {
						this.cs1Instructions[var4][var6] = -1;
					}
				}
			}
		}

		if (this.type == 0) {
			this.scrollHeight = var1.method5549();
			this.isHidden = var1.method5547() == 1;
			this.onHiddenChanged(-1);
		}

		if (this.type == 1) {
			var1.method5549();
			var1.method5547();
		}

		if (this.type == 2) {
			this.itemIds = new int[this.rawWidth * this.rawHeight];
			this.itemQuantities = new int[this.rawHeight * this.rawWidth];
			var4 = var1.method5547();
			if (var4 == 1) {
				this.clickMask |= 268435456;
			}

			var5 = var1.method5547();
			if (var5 == 1) {
				this.clickMask |= 1073741824;
			}

			var6 = var1.method5547();
			if (var6 == 1) {
				this.clickMask |= Integer.MIN_VALUE;
			}

			int var7 = var1.method5547();
			if (var7 == 1) {
				this.clickMask |= 536870912;
			}

			this.paddingX = var1.method5547();
			this.paddingY = var1.method5547();
			this.inventoryXOffsets = new int[20];
			this.inventoryYOffsets = new int[20];
			this.inventorySprites = new int[20];

			int var8;
			for (var8 = 0; var8 < 20; ++var8) {
				int var9 = var1.method5547();
				if (var9 == 1) {
					this.inventoryXOffsets[var8] = var1.method5550();
					this.inventoryYOffsets[var8] = var1.method5550();
					this.inventorySprites[var8] = var1.method5552();
				} else {
					this.inventorySprites[var8] = -1;
				}
			}

			this.itemActions = new String[5];

			for (var8 = 0; var8 < 5; ++var8) {
				String var11 = var1.method5667();
				if (var11.length() > 0) {
					this.itemActions[var8] = var11;
					this.clickMask |= 1 << var8 + 23;
				}
			}
		}

		if (this.type == 3) {
			this.fill = var1.method5547() == 1;
		}

		if (this.type == 4 || this.type == 1) {
			this.textXAlignment = var1.method5547();
			this.textYAlignment = var1.method5547();
			this.textLineHeight = var1.method5547();
			this.fontId = var1.method5549();
			if (this.fontId == 65535) {
				this.fontId = -1;
			}

			this.textShadowed = var1.method5547() == 1;
		}

		if (this.type == 4) {
			this.text = var1.method5667();
			this.text2 = var1.method5667();
		}

		if (this.type == 1 || this.type == 3 || this.type == 4) {
			this.color = var1.method5552();
		}

		if (this.type == 3 || this.type == 4) {
			this.color2 = var1.method5552();
			this.mouseOverColor = var1.method5552();
			this.mouseOverColor2 = var1.method5552();
		}

		if (this.type == 5) {
			this.spriteId2 = var1.method5552();
			this.spriteId = var1.method5552();
		}

		if (this.type == 6) {
			this.modelType = 1;
			this.modelId = var1.method5549();
			if (this.modelId == 65535) {
				this.modelId = -1;
			}

			this.modelType2 = 1;
			this.modelId2 = var1.method5549();
			if (this.modelId2 == 65535) {
				this.modelId2 = -1;
			}

			this.sequenceId = var1.method5549();
			if (this.sequenceId == 65535) {
				this.sequenceId = -1;
			}

			this.sequenceId2 = var1.method5549();
			if (this.sequenceId2 == 65535) {
				this.sequenceId2 = -1;
			}

			this.modelZoom = var1.method5549();
			this.modelAngleX = var1.method5549();
			this.modelAngleY = var1.method5549();
		}

		if (this.type == 7) {
			this.itemIds = new int[this.rawHeight * this.rawWidth];
			this.itemQuantities = new int[this.rawWidth * this.rawHeight];
			this.textXAlignment = var1.method5547();
			this.fontId = var1.method5549();
			if (this.fontId == 65535) {
				this.fontId = -1;
			}

			this.textShadowed = var1.method5547() == 1;
			this.color = var1.method5552();
			this.paddingX = var1.method5550();
			this.paddingY = var1.method5550();
			var4 = var1.method5547();
			if (var4 == 1) {
				this.clickMask |= 1073741824;
			}

			this.itemActions = new String[5];

			for (var5 = 0; var5 < 5; ++var5) {
				String var10 = var1.method5667();
				if (var10.length() > 0) {
					this.itemActions[var5] = var10;
					this.clickMask |= 1 << var5 + 23;
				}
			}
		}

		if (this.type == 8) {
			this.text = var1.method5667();
		}

		if (this.buttonType == 2 || this.type == 2) {
			this.spellActionName = var1.method5667();
			this.spellName = var1.method5667();
			var4 = var1.method5549() & 63;
			this.clickMask |= var4 << 11;
		}

		if (this.buttonType == 1 || this.buttonType == 4 || this.buttonType == 5 || this.buttonType == 6) {
			this.buttonText = var1.method5667();
			if (this.buttonText.length() == 0) {
				if (this.buttonType == 1) {
					this.buttonText = "Ok";
				}

				if (this.buttonType == 4) {
					this.buttonText = "Select";
				}

				if (this.buttonType == 5) {
					this.buttonText = "Select";
				}

				if (this.buttonType == 6) {
					this.buttonText = "Continue";
				}
			}
		}

		if (this.buttonType == 1 || this.buttonType == 4 || this.buttonType == 5) {
			this.clickMask |= 4194304;
		}

		if (this.buttonType == 6) {
			this.clickMask |= 1;
		}

	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lkb;I)V",
		garbageValue = "1292756714"
	)
	void method4153(Buffer var1) {
		var1.method5547();
		this.isIf3 = true;
		this.type = var1.method5547();
		this.contentType = var1.method5549();
		this.rawX = var1.method5550();
		this.rawY = var1.method5550();
		this.rawWidth = var1.method5549();
		if (this.type == 9) {
			this.rawHeight = var1.method5550();
		} else {
			this.rawHeight = var1.method5549();
		}

		this.widthAlignment = var1.method5548();
		this.heightAlignment = var1.method5548();
		this.xAlignment = var1.method5548();
		this.yAlignment = var1.method5548();
		this.parentId = var1.method5549();
		if (this.parentId == 65535) {
			this.parentId = -1;
		} else {
			this.parentId += this.id & -65536;
		}

		this.isHidden = var1.method5547() == 1;
		this.onHiddenChanged(-1);
		if (this.type == 0) {
			this.scrollWidth = var1.method5549();
			this.scrollHeight = var1.method5549();
			this.noClickThrough = var1.method5547() == 1;
		}

		if (this.type == 5) {
			this.spriteId2 = var1.method5552();
			this.spriteAngle = var1.method5549();
			this.spriteTiling = var1.method5547() == 1;
			this.transparencyTop = var1.method5547();
			this.outline = var1.method5547();
			this.spriteShadow = var1.method5552();
			this.spriteFlipV = var1.method5547() == 1;
			this.spriteFlipH = var1.method5547() == 1;
		}

		if (this.type == 6) {
			this.modelType = 1;
			this.modelId = var1.method5549();
			if (this.modelId == 65535) {
				this.modelId = -1;
			}

			this.modelOffsetX = var1.method5550();
			this.modelOffsetY = var1.method5550();
			this.modelAngleX = var1.method5549();
			this.modelAngleY = var1.method5549();
			this.modelAngleZ = var1.method5549();
			this.modelZoom = var1.method5549();
			this.sequenceId = var1.method5549();
			if (this.sequenceId == 65535) {
				this.sequenceId = -1;
			}

			this.modelOrthog = var1.method5547() == 1;
			var1.method5549();
			if (this.widthAlignment != 0) {
				this.field2622 = var1.method5549();
			}

			if (this.heightAlignment != 0) {
				var1.method5549();
			}
		}

		if (this.type == 4) {
			this.fontId = var1.method5549();
			if (this.fontId == 65535) {
				this.fontId = -1;
			}

			this.text = var1.method5667();
			this.textLineHeight = var1.method5547();
			this.textXAlignment = var1.method5547();
			this.textYAlignment = var1.method5547();
			this.textShadowed = var1.method5547() == 1;
			this.color = var1.method5552();
		}

		if (this.type == 3) {
			this.color = var1.method5552();
			this.fill = var1.method5547() == 1;
			this.transparencyTop = var1.method5547();
		}

		if (this.type == 9) {
			this.lineWid = var1.method5547();
			this.color = var1.method5552();
			this.field2601 = var1.method5547() == 1;
		}

		this.clickMask = var1.method5674();
		this.dataText = var1.method5667();
		int var2 = var1.method5547();
		if (var2 > 0) {
			this.actions = new String[var2];

			for (int var3 = 0; var3 < var2; ++var3) {
				this.actions[var3] = var1.method5667();
			}
		}

		this.dragZoneSize = var1.method5547();
		this.dragThreshold = var1.method5547();
		this.isScrollBar = var1.method5547() == 1;
		this.spellActionName = var1.method5667();
		this.onLoad = this.method4111(var1);
		this.onMouseOver = this.method4111(var1);
		this.onMouseLeave = this.method4111(var1);
		this.onTargetLeave = this.method4111(var1);
		this.onTargetEnter = this.method4111(var1);
		this.onVarTransmit = this.method4111(var1);
		this.onInvTransmit = this.method4111(var1);
		this.onStatTransmit = this.method4111(var1);
		this.onTimer = this.method4111(var1);
		this.onOp = this.method4111(var1);
		this.onMouseRepeat = this.method4111(var1);
		this.onClick = this.method4111(var1);
		this.onClickRepeat = this.method4111(var1);
		this.onRelease = this.method4111(var1);
		this.onHold = this.method4111(var1);
		this.onDrag = this.method4111(var1);
		this.onDragComplete = this.method4111(var1);
		this.onScroll = this.method4111(var1);
		this.varTransmitTriggers = this.method4120(var1);
		this.invTransmitTriggers = this.method4120(var1);
		this.statTransmitTriggers = this.method4120(var1);
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lkb;I)[Ljava/lang/Object;",
		garbageValue = "2142536544"
	)
	Object[] method4111(Buffer var1) {
		int var2 = var1.method5547();
		if (var2 == 0) {
			return null;
		} else {
			Object[] var3 = new Object[var2];

			for (int var4 = 0; var4 < var2; ++var4) {
				int var5 = var1.method5547();
				if (var5 == 0) {
					var3[var4] = new Integer(var1.method5552());
				} else if (var5 == 1) {
					var3[var4] = var1.method5667();
				}
			}

			this.hasListener = true;
			return var3;
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lkb;I)[I",
		garbageValue = "-1956943483"
	)
	int[] method4120(Buffer var1) {
		int var2 = var1.method5547();
		if (var2 == 0) {
			return null;
		} else {
			int[] var3 = new int[var2];

			for (int var4 = 0; var4 < var2; ++var4) {
				var3[var4] = var1.method5552();
			}

			return var3;
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "880946996"
	)
	public void method4113(int var1, int var2) {
		int var3 = this.itemIds[var2];
		this.itemIds[var2] = this.itemIds[var1];
		this.itemIds[var1] = var3;
		var3 = this.itemQuantities[var2];
		this.itemQuantities[var2] = this.itemQuantities[var1];
		this.itemQuantities[var1] = var3;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(ZB)Lla;"
	)
	public Sprite method4114(boolean var1, byte var2) {
		if (this.getSpriteId() != -1) {
			net.runelite.api.Sprite var3 = (net.runelite.api.Sprite)Client.widgetSpriteOverrides.get(this.getId());
			if (var3 != null) {
				return (Sprite)((RSSprite)var3);
			}
		}

		return (Sprite)this.copy$getSprite(var1, var2);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(B)Lkx;",
		garbageValue = "-18"
	)
	public Font method4121() {
		field2565 = false;
		if (this.fontId == -1) {
			return null;
		} else {
			Font var1 = (Font)Widget_cachedFonts.method3418((long)this.fontId);
			if (var1 != null) {
				return var1;
			} else {
				AbstractArchive var3 = Varps.Widget_spritesArchive;
				AbstractArchive var4 = Widget_fontsArchive;
				int var5 = this.fontId;
				Font var2;
				if (!UserComparator7.method3502(var3, var5, 0)) {
					var2 = null;
				} else {
					var2 = VertexNormal.method3080(var4.method4224(var5, 0, (byte)-101));
				}

				if (var2 != null) {
					Widget_cachedFonts.method3424(var2, (long)this.fontId);
				} else {
					field2565 = true;
				}

				return var2;
			}
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(IB)Lla;",
		garbageValue = "14"
	)
	public Sprite method4116(int var1) {
		field2565 = false;
		if (var1 >= 0 && var1 < this.inventorySprites.length) {
			int var2 = this.inventorySprites[var1];
			if (var2 == -1) {
				return null;
			} else {
				Sprite var3 = (Sprite)Widget_cachedSprites.method3418((long)var2);
				if (var3 != null) {
					return var3;
				} else {
					var3 = MusicPatchNode2.method3752(Varps.Widget_spritesArchive, var2, 0, 273345835);
					if (var3 != null) {
						Widget_cachedSprites.method3424(var3, (long)var2);
					} else {
						field2565 = true;
					}

					return var3;
				}
			}
		} else {
			return null;
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ljc;IZLhk;B)Lel;"
	)
	public Model method4117(SequenceDefinition var1, int var2, boolean var3, PlayerAppearance var4, byte var5) {
		if (var2 != -1 && WorldMapSection1.client.isInterpolateWidgetAnimations()) {
			var2 = var2 | this.getModelFrameCycle() << 16 | Integer.MIN_VALUE;
		}

		return (Model)this.copy$getModel(var1, var2, var3, var4, var5);
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(ZB)Lhg;",
		garbageValue = "-84"
	)
	public SpriteMask method4115(boolean var1) {
		if (this.spriteId == -1) {
			var1 = false;
		}

		int var2 = var1 ? this.spriteId : this.spriteId2;
		if (var2 == -1) {
			return null;
		} else {
			long var3 = ((this.spriteFlipV ? 1L : 0L) << 38) + ((long)this.outline << 36) + (long)var2 + ((this.spriteFlipH ? 1L : 0L) << 39) + ((long)this.spriteShadow << 40);
			SpriteMask var5 = (SpriteMask)Widget_cachedSpriteMasks.method3418(var3);
			if (var5 != null) {
				return var5;
			} else {
				Sprite var6 = this.method4114(var1, (byte)-24);
				if (var6 == null) {
					return null;
				} else {
					Sprite var7 = var6.method6178();
					int[] var8 = new int[var7.subHeight];
					int[] var9 = new int[var7.subHeight];

					for (int var10 = 0; var10 < var7.subHeight; ++var10) {
						int var11 = 0;
						int var12 = var7.subWidth;

						int var13;
						for (var13 = 0; var13 < var7.subWidth; ++var13) {
							if (var7.pixels[var13 + var10 * var7.subWidth] == 0) {
								var11 = var13;
								break;
							}
						}

						for (var13 = var7.subWidth - 1; var13 >= var11; --var13) {
							if (var7.pixels[var13 + var10 * var7.subWidth] == 0) {
								var12 = var13 + 1;
								break;
							}
						}

						var8[var10] = var11;
						var9[var10] = var12 - var11;
					}

					var5 = new SpriteMask(var7.subWidth, var7.subHeight, var9, var8, var2);
					Widget_cachedSpriteMasks.method3424(var5, var3);
					return var5;
				}
			}
		}
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)V",
		garbageValue = "-207986115"
	)
	public void method4145(int var1, String var2) {
		if (this.actions == null || this.actions.length <= var1) {
			String[] var3 = new String[var1 + 1];
			if (this.actions != null) {
				for (int var4 = 0; var4 < this.actions.length; ++var4) {
					var3[var4] = this.actions[var4];
				}
			}

			this.actions = var3;
		}

		this.actions[var1] = var2;
	}

	public Rectangle getBounds() {
		Point var1 = this.getCanvasLocation();
		return new Rectangle(var1.getX(), var1.getY(), this.getWidth(), this.getHeight());
	}

	public String getRSText() {
		return this.text;
	}

	public String getRSName() {
		return this.dataText;
	}

	public RSSprite getSprite(boolean var1) {
		return this.method4114(var1, (byte)-39);
	}

	public Point getCanvasLocation() {
		return new Point(this.rl$x, this.rl$y);
	}

	public int getParentId() {
		if (!$assertionsDisabled && !WorldMapSection1.client.isClientThread()) {
			throw new AssertionError();
		} else {
			int var1 = this.getRSParentId();
			if (var1 != -1) {
				return var1;
			} else {
				int var2 = this.getId();
				if (WidgetInfo.TO_GROUP(var2) == WorldMapSection1.client.getWidgetRoot()) {
					return -1;
				} else {
					int var3 = this.rl$parentId;
					if (var3 != -1) {
						RSNodeHashTable var4 = WorldMapSection1.client.getComponentTable();
						WidgetNode var5 = (WidgetNode)var4.get((long)var3);
						if (var5 != null && var5.getId() == WidgetInfo.TO_GROUP(var2)) {
							return var3;
						}

						this.rl$parentId = -1;
					}

					int var13 = WidgetInfo.TO_GROUP(this.getId());
					RSNodeHashTable var14 = WorldMapSection1.client.getComponentTable();
					RSNode[] var6 = var14.getBuckets();
					RSNode[] var7 = var6;
					int var8 = var6.length;

					for (int var9 = 0; var9 < var8; ++var9) {
						RSNode var10 = var7[var9];

						for (Object var11 = var10.getNext(); var11 != var10; var11 = ((net.runelite.api.Node)var11).getNext()) {
							WidgetNode var12 = (WidgetNode)var11;
							if (var13 == var12.getId()) {
								return (int)var12.getHash();
							}
						}
					}

					return -1;
				}
			}
		}
	}

	public int[] getItemIds() {
		return this.itemIds;
	}

	public int getSpriteId() {
		return this.spriteId2;
	}

	public RSWidget[] getChildren() {
		return this.children;
	}

	public int getRSParentId() {
		return this.parentId;
	}

	public int getId() {
		return this.id;
	}

	public void setRSName(String var1) {
		this.dataText = var1;
	}

	@ObfuscatedSignature(
		signature = "(Ljc;IZLhk;B)Lel;"
	)
	public Model copy$getModel(SequenceDefinition var1, int var2, boolean var3, PlayerAppearance var4, byte var5) {
		field2565 = false;
		int var6;
		int var7;
		if (var3) {
			var6 = this.modelType2;
			var7 = this.modelId2;
		} else {
			var6 = this.modelType;
			var7 = this.modelId;
		}

		if (var6 == 0) {
			return null;
		} else if (var6 == 1 && var7 == -1) {
			return null;
		} else {
			Model var8 = (Model)Widget_cachedModels.method3418((long)(var7 + (var6 << 16)));
			if (var8 == null) {
				ModelData var9;
				if (var6 == 1) {
					var9 = ModelData.method2865(SoundSystem.Widget_modelsArchive, var7, 0);
					if (var9 == null) {
						field2565 = true;
						return null;
					}

					var8 = var9.method2886(64, 768, -50, -10, -50);
				}

				if (var6 == 2) {
					var9 = class237.method4201(var7).method4760();
					if (var9 == null) {
						field2565 = true;
						return null;
					}

					var8 = var9.method2886(64, 768, -50, -10, -50);
				}

				if (var6 == 3) {
					if (var4 == null) {
						return null;
					}

					var9 = var4.method4070();
					if (var9 == null) {
						field2565 = true;
						return null;
					}

					var8 = var9.method2886(64, 768, -50, -10, -50);
				}

				if (var6 == 4) {
					ItemDefinition var10 = AbstractWorldMapData.method373(var7);
					var9 = var10.method4695(10);
					if (var9 == null) {
						field2565 = true;
						return null;
					}

					var8 = var9.method2886(var10.ambient + 64, var10.contrast + 768, -50, -10, -50);
				}

				Widget_cachedModels.method3424(var8, (long)(var7 + (var6 << 16)));
			}

			if (var1 != null) {
				var8 = var1.method4848(var8, var2, (byte)14);
			}

			return var8;
		}
	}

	public int[] getItemQuantities() {
		return this.itemQuantities;
	}

	public boolean isSelfHidden() {
		return this.isHidden;
	}

	public net.runelite.api.widgets.Widget getParent() {
		int var1 = this.getParentId();
		return var1 == -1 ? null : WorldMapSection1.client.getWidget(WidgetInfo.TO_GROUP(var1), WidgetInfo.TO_CHILD(var1));
	}

	@ObfuscatedSignature(
		signature = "(ZB)Lla;"
	)
	public Sprite copy$getSprite(boolean var1, byte var2) {
		field2565 = false;
		int var3;
		if (var1) {
			var3 = this.spriteId;
		} else {
			var3 = this.spriteId2;
		}

		if (var3 == -1) {
			return null;
		} else {
			long var4 = ((long)this.spriteShadow << 40) + ((this.spriteFlipH ? 1L : 0L) << 39) + (long)var3 + ((long)this.outline << 36) + ((this.spriteFlipV ? 1L : 0L) << 38);
			Sprite var6 = (Sprite)Widget_cachedSprites.method3418(var4);
			if (var6 != null) {
				return var6;
			} else {
				var6 = MusicPatchNode2.method3752(Varps.Widget_spritesArchive, var3, 0, 273345835);
				if (var6 == null) {
					field2565 = true;
					return null;
				} else {
					if (this.spriteFlipV) {
						var6.method6190();
					}

					if (this.spriteFlipH) {
						var6.method6288();
					}

					if (this.outline > 0) {
						var6.method6181(this.outline);
					}

					if (this.outline >= 1) {
						var6.method6269(1);
					}

					if (this.outline >= 2) {
						var6.method6269(16777215);
					}

					if (this.spriteShadow != 0) {
						var6.method6184(this.spriteShadow);
					}

					Widget_cachedSprites.method3424(var6, var4);
					return var6;
				}
			}
		}
	}

	public int getModelFrameCycle() {
		return this.modelFrameCycle;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public WidgetItem getWidgetItem(int var1) {
		int[] var2 = this.getItemIds();
		int[] var3 = this.getItemQuantities();
		if (var2 != null && var3 != null) {
			int var4 = this.getWidth();
			int var5 = this.getXPitch();
			int var6 = this.getYPitch();
			int var7 = var2[var1];
			int var8 = var3[var1];
			if (var4 <= 0) {
				return null;
			} else {
				int var9 = var1 / var4;
				int var10 = var1 % var4;
				int var11 = var10 * (var5 + 32) + this.rl$x;
				int var12 = var9 * (var6 + 32) + this.rl$y;
				boolean var13 = this.isWidgetItemDragged(var1);
				int var14 = 0;
				int var15 = 0;
				if (var13) {
					Point var16 = this.getWidgetItemDragOffsets();
					var14 = var16.getX();
					var15 = var16.getY();
				}

				Rectangle var18 = new Rectangle(var11 - 1, var12 - 1, 32, 32);
				Rectangle var17 = new Rectangle(var11 + var14, var12 + var15, 32, 32);
				return new WidgetItem(var7 - 1, var8, var1, var18, this, var17);
			}
		} else {
			return null;
		}
	}

	public int getXPitch() {
		return this.paddingX;
	}

	public net.runelite.api.widgets.Widget[] getNestedChildren() {
		if (!$assertionsDisabled && !WorldMapSection1.client.isClientThread()) {
			throw new AssertionError();
		} else if (this.getRSParentId() == this.getId()) {
			return new net.runelite.api.widgets.Widget[0];
		} else {
			RSNodeHashTable var1 = WorldMapSection1.client.getComponentTable();
			WidgetNode var2 = (WidgetNode)var1.get((long)this.getId());
			if (var2 == null) {
				return new Widget[0];
			} else {
				int var3 = var2.getId();
				ArrayList var4 = new ArrayList();
				RSWidget[] var5 = WorldMapSection1.client.getGroup(var3);
				int var6 = var5.length;

				for (int var7 = 0; var7 < var6; ++var7) {
					RSWidget var8 = var5[var7];
					if (var8 != null && var8.getRSParentId() == -1) {
						var4.add(var8);
					}
				}

				return (net.runelite.api.widgets.Widget[])var4.toArray(new Widget[var4.size()]);
			}
		}
	}

	public int getYPitch() {
		return this.paddingY;
	}

	public void broadcastHidden(boolean var1) {
		WidgetHiddenChanged var2 = new WidgetHiddenChanged();
		var2.setWidget(this);
		var2.setHidden(var1);
		WorldMapSection1.client.getCallbacks().post(WidgetHiddenChanged.class, var2);
		RSWidget[] var3 = this.getChildren();
		int var6;
		if (var3 != null) {
			RSWidget[] var4 = var3;
			int var5 = var3.length;

			for (var6 = 0; var6 < var5; ++var6) {
				RSWidget var7 = var4[var6];
				if (var7 != null && !var7.isSelfHidden()) {
					var7.broadcastHidden(var1);
				}
			}
		}

		net.runelite.api.widgets.Widget[] var11 = this.getNestedChildren();
		net.runelite.api.widgets.Widget[] var9 = var11;
		var6 = var11.length;

		for (int var10 = 0; var10 < var6; ++var10) {
			net.runelite.api.widgets.Widget var8 = var9[var10];
			if (var8 != null && !var8.isSelfHidden()) {
				((RSWidget)var8).broadcastHidden(var1);
			}
		}

	}

	public void setChildren(net.runelite.api.widgets.Widget[] var1) {
		this.children = (Widget[])var1;
	}

	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1"
	)
	public void onPositionChanged(int var1) {
		int var2 = this.getId();
		if (var2 != -1) {
			int var3 = WorldMapSection1.client.getGameCycle();
			if (var3 != rl$widgetLastPosChanged) {
				rl$widgetLastPosChanged = var3;
				WorldMapSection1.client.getLogger().trace("Posting widget position changed");
				WidgetPositioned var4 = WidgetPositioned.INSTANCE;
				WorldMapSection1.client.getCallbacks().postDeferred(WidgetPositioned.class, var4);
			}
		}
	}

	public boolean isWidgetItemDragged(int var1) {
		return WorldMapSection1.client.getIf1DraggedWidget() == this && WorldMapSection1.client.getItemPressedDuration() >= 5 && WorldMapSection1.client.getIf1DraggedItemIndex() == var1;
	}

	public Point getWidgetItemDragOffsets() {
		int var1 = WorldMapSection1.client.getMouseX() - WorldMapSection1.client.getDraggedWidgetX();
		int var2 = WorldMapSection1.client.getMouseY() - WorldMapSection1.client.getDraggedWidgetY();
		if (var1 < 5 && var1 > -5) {
			var1 = 0;
		}

		if (var2 < 5 && var2 > -5) {
			var2 = 0;
		}

		return new Point(var1, var2);
	}

	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1"
	)
	public void onHiddenChanged(int var1) {
		int var2 = this.getId();
		if (var2 != -1) {
			net.runelite.api.widgets.Widget var3 = this.getParent();
			if (var3 != null) {
				if (var3.isHidden()) {
					return;
				}
			} else if (WidgetInfo.TO_GROUP(var2) != WorldMapSection1.client.getWidgetRoot()) {
				return;
			}

			this.broadcastHidden(this.isSelfHidden());
		}
	}

	private void rl$$init() {
		this.rl$parentId = -1;
		this.rl$x = -1;
		this.rl$y = -1;
	}

	public void setRenderParentId(int var1) {
		this.rl$parentId = var1;
	}

	public void setRenderX(int var1) {
		this.rl$x = var1;
	}

	public void setRenderY(int var1) {
		this.rl$y = var1;
	}

	public String getText() {
		return this.getRSText().replace(' ', ' ');
	}

	public String getName() {
		return this.getRSName().replace(' ', ' ');
	}

	public void setName(String var1) {
		this.setRSName(var1.replace(' ', ' '));
	}

	public boolean isHidden() {
		if (!$assertionsDisabled && !WorldMapSection1.client.isClientThread()) {
			throw new AssertionError();
		} else if (this.isSelfHidden()) {
			return true;
		} else {
			net.runelite.api.widgets.Widget var1 = this.getParent();
			return var1 == null ? WidgetInfo.TO_GROUP(this.getId()) != WorldMapSection1.client.getWidgetRoot() : var1.isHidden();
		}
	}

	public Collection getWidgetItems() {
		int[] var1 = this.getItemIds();
		if (var1 == null) {
			return null;
		} else {
			ArrayList var2 = new ArrayList(var1.length);

			for (int var3 = 0; var3 < var1.length; ++var3) {
				if (var1[var3] > 0) {
					WidgetItem var4 = this.getWidgetItem(var3);
					if (var4 != null) {
						var2.add(var4);
					}
				}
			}

			return var2;
		}
	}

	public net.runelite.api.widgets.Widget getChild(int var1) {
		RSWidget[] var2 = this.getChildren();
		return var2 != null && var2[var1] != null ? var2[var1] : null;
	}

	public net.runelite.api.widgets.Widget[] getDynamicChildren() {
		RSWidget[] var1 = this.getChildren();
		if (var1 == null) {
			return new net.runelite.api.widgets.Widget[0];
		} else {
			ArrayList var2 = new ArrayList();
			RSWidget[] var3 = var1;
			int var4 = var1.length;

			for (int var5 = 0; var5 < var4; ++var5) {
				RSWidget var6 = var3[var5];
				if (var6 != null && var6.getRSParentId() == this.getId()) {
					var2.add(var6);
				}
			}

			return (net.runelite.api.widgets.Widget[])var2.toArray(new net.runelite.api.widgets.Widget[var2.size()]);
		}
	}

	public net.runelite.api.widgets.Widget[] getStaticChildren() {
		if (this.getRSParentId() == this.getId()) {
			return new net.runelite.api.widgets.Widget[0];
		} else {
			ArrayList var1 = new ArrayList();
			RSWidget[] var2 = WorldMapSection1.client.getGroup(WidgetInfo.TO_GROUP(this.getId()));
			int var3 = var2.length;

			for (int var4 = 0; var4 < var3; ++var4) {
				RSWidget var5 = var2[var4];
				if (var5 != null && var5.getRSParentId() == this.getId()) {
					var1.add(var5);
				}
			}

			return (net.runelite.api.widgets.Widget[])var1.toArray(new Widget[var1.size()]);
		}
	}

	public boolean contains(Point var1) {
		Rectangle var2 = this.getBounds();
		return var2 != null && var2.contains(new java.awt.Point(var1.getX(), var1.getY()));
	}

	public net.runelite.api.widgets.Widget createChild(int var1, int var2) {
		if (!$assertionsDisabled && !WorldMapSection1.client.isClientThread()) {
			throw new AssertionError();
		} else {
			RSWidget var3 = WorldMapSection1.client.createWidget();
			var3.setType(var2);
			var3.setParentId(this.getId());
			var3.setId(this.getId());
			var3.setIsIf3(true);
			Object var4 = this.getChildren();
			if (var1 < 0) {
				if (var4 == null) {
					var1 = 0;
				} else {
					var1 = 0;

					for (int var6 = ((Object[])var4).length - 1; var6 >= 0; --var6) {
						if (((Object[])var4)[var6] != null) {
							var1 = var6 + 1;
							break;
						}
					}
				}
			}

			if (var4 == null) {
				var4 = new Widget[var1 + 1];
				this.setChildren((net.runelite.api.widgets.Widget[])var4);
			} else if (((Object[])var4).length <= var1) {
				Widget[] var5 = new Widget[var1 + 1];
				System.arraycopy(var4, 0, var5, 0, ((Object[])var4).length);
				var4 = var5;
				this.setChildren(var5);
			}

			((Object[])var4)[var1] = var3;
			var3.setIndex(var1);
			return var3;
		}
	}

	public void revalidate() {
		if (!$assertionsDisabled && !WorldMapSection1.client.isClientThread()) {
			throw new AssertionError();
		} else {
			WorldMapSection1.client.revalidateWidget(this);
		}
	}

	public void revalidateScroll() {
		if (!$assertionsDisabled && !WorldMapSection1.client.isClientThread()) {
			throw new AssertionError();
		} else {
			WorldMapSection1.client.revalidateWidget(this);
			WorldMapSection1.client.revalidateWidgetScroll(WorldMapSection1.client.getWidgets()[WidgetInfo.TO_GROUP(this.getId())], this, false);
		}
	}

	public void deleteAllChildren() {
		if (this.getChildren() != null) {
			Arrays.fill(this.getChildren(), (Object)null);
		}

	}

	public net.runelite.api.Sprite getSprite() {
		return this.getSprite(false);
	}

	public boolean isIf3() {
		return this.isIf3;
	}

	public void setIsIf3(boolean var1) {
		this.isIf3 = var1;
	}

	public void setId(int var1) {
		this.id = var1;
	}

	public int getIndex() {
		return this.childIndex;
	}

	public void setIndex(int var1) {
		this.childIndex = var1;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int var1) {
		this.type = var1;
	}

	public int getContentType() {
		return this.contentType;
	}

	public void setContentType(int var1) {
		this.contentType = var1;
	}

	public int getXPositionMode() {
		return this.xAlignment;
	}

	public void setXPositionMode(int var1) {
		this.xAlignment = var1;
	}

	public int getYPositionMode() {
		return this.yAlignment;
	}

	public void setYPositionMode(int var1) {
		this.yAlignment = var1;
	}

	public int getWidthMode() {
		return this.widthAlignment;
	}

	public void setWidthMode(int var1) {
		this.widthAlignment = var1;
	}

	public int getHeightMode() {
		return this.heightAlignment;
	}

	public void setHeightMode(int var1) {
		this.heightAlignment = var1;
	}

	public int getOriginalX() {
		return this.rawX;
	}

	public void setOriginalX(int var1) {
		this.rawX = var1;
	}

	public int getOriginalY() {
		return this.rawY;
	}

	public void setOriginalY(int var1) {
		this.rawY = var1;
	}

	public int getOriginalWidth() {
		return this.rawWidth;
	}

	public void setOriginalWidth(int var1) {
		this.rawWidth = var1;
	}

	public int getOriginalHeight() {
		return this.rawHeight;
	}

	public void setOriginalHeight(int var1) {
		this.rawHeight = var1;
	}

	public int getRelativeX() {
		return this.x;
	}

	public void setRelativeX(int var1) {
		this.x = var1;
	}

	public int getRelativeY() {
		return this.y;
	}

	public void setRelativeY(int var1) {
		this.y = var1;
	}

	public void setWidth(int var1) {
		this.width = var1;
	}

	public void setHeight(int var1) {
		this.height = var1;
	}

	public void setParentId(int var1) {
		this.parentId = var1;
	}

	public void setHidden(boolean var1) {
		this.isHidden = var1;
	}

	public int getScrollX() {
		return this.scrollX;
	}

	public void setScrollX(int var1) {
		this.scrollX = var1;
	}

	public int getScrollY() {
		return this.scrollY;
	}

	public void setScrollY(int var1) {
		this.scrollY = var1;
	}

	public int getScrollWidth() {
		return this.scrollWidth;
	}

	public void setScrollWidth(int var1) {
		this.scrollWidth = var1;
	}

	public int getScrollHeight() {
		return this.scrollHeight;
	}

	public void setScrollHeight(int var1) {
		this.scrollHeight = var1;
	}

	public int getTextColor() {
		return this.color;
	}

	public void setTextColor(int var1) {
		this.color = var1;
	}

	public boolean isFilled() {
		return this.fill;
	}

	public void setFilled(boolean var1) {
		this.fill = var1;
	}

	public int getOpacity() {
		return this.transparencyTop;
	}

	public void setOpacity(int var1) {
		this.transparencyTop = var1;
	}

	public void setSpriteId(int var1) {
		this.spriteId2 = var1;
	}

	public int getBorderType() {
		return this.outline;
	}

	public void setBorderType(int var1) {
		this.outline = var1;
	}

	public int getModelType() {
		return this.modelType;
	}

	public void setModelType(int var1) {
		this.modelType = var1;
	}

	public int getModelId() {
		return this.modelId;
	}

	public void setModelId(int var1) {
		this.modelId = var1;
	}

	public int getRotationX() {
		return this.modelAngleX;
	}

	public void setRotationX(int var1) {
		this.modelAngleX = var1;
	}

	public int getRotationY() {
		return this.modelAngleY;
	}

	public void setRotationY(int var1) {
		this.modelAngleY = var1;
	}

	public int getRotationZ() {
		return this.modelAngleZ;
	}

	public void setRotationZ(int var1) {
		this.modelAngleZ = var1;
	}

	public int getModelZoom() {
		return this.modelZoom;
	}

	public void setModelZoom(int var1) {
		this.modelZoom = var1;
	}

	public int getItemQuantityMode() {
		return this.itemQuantityMode;
	}

	public void setItemQuantityMode(int var1) {
		this.itemQuantityMode = var1;
	}

	public int getFontId() {
		return this.fontId;
	}

	public void setFontId(int var1) {
		this.fontId = var1;
	}

	public void setText(String var1) {
		this.text = var1;
	}

	public int getXTextAlignment() {
		return this.textXAlignment;
	}

	public void setXTextAlignment(int var1) {
		this.textXAlignment = var1;
	}

	public int getYTextAlignment() {
		return this.textYAlignment;
	}

	public void setYTextAlignment(int var1) {
		this.textYAlignment = var1;
	}

	public boolean getTextShadowed() {
		return this.textShadowed;
	}

	public void setTextShadowed(boolean var1) {
		this.textShadowed = var1;
	}

	public int getClickMask() {
		return this.clickMask;
	}

	public void setClickMask(int var1) {
		this.clickMask = var1;
	}

	public String[] getActions() {
		return this.actions;
	}

	public int getDragDeadZone() {
		return this.dragZoneSize;
	}

	public void setDragDeadZone(int var1) {
		this.dragZoneSize = var1;
	}

	public int getDragDeadTime() {
		return this.dragThreshold;
	}

	public void setDragDeadTime(int var1) {
		this.dragThreshold = var1;
	}

	public String getTargetVerb() {
		return this.spellActionName;
	}

	public void setTargetVerb(String var1) {
		this.spellActionName = var1;
	}

	public boolean hasListener() {
		return this.hasListener;
	}

	public void setHasListener(boolean var1) {
		this.hasListener = var1;
	}

	public Object[] getOnLoadListener() {
		return this.onLoad;
	}

	public void setOnClickListener(Object[] var1) {
		this.onClick = var1;
	}

	public void setOnReleaseListener(Object[] var1) {
		this.onRelease = var1;
	}

	public void setOnHoldListener(Object[] var1) {
		this.onHold = var1;
	}

	public void setOnMouseOverListener(Object[] var1) {
		this.onMouseOver = var1;
	}

	public void setOnMouseRepeatListener(Object[] var1) {
		this.onMouseRepeat = var1;
	}

	public void setOnMouseLeaveListener(Object[] var1) {
		this.onMouseLeave = var1;
	}

	public void setOnTargetEnterListener(Object[] var1) {
		this.onTargetEnter = var1;
	}

	public void setOnTargetLeaveListener(Object[] var1) {
		this.onTargetLeave = var1;
	}

	public void setVarTransmitTrigger(int[] var1) {
		this.varTransmitTriggers = var1;
	}

	public Object[] getOnInvTransmit() {
		return this.onInvTransmit;
	}

	@Override
	public Object[] getOnOp() {
		return this.onOp;
	}

	@Override
	public Object[] getOnInvTransmitListener() {
		return onInvTransmit;
	}

	public void setOnTimerListener(Object[] var1) {
		this.onTimer = var1;
	}

	public void setOnOpListener(Object[] var1) {
		this.onOp = var1;
	}

	public Object[] getOnOpListener() {
		return this.onOp;
	}

	public Object[] getOnKeyListener() {
		return this.onKey;
	}

	public void setOnKeyListener(Object[] var1) {
		this.onKey = var1;
	}

	public void setOnDialogAbortListener(Object[] var1) {
		this.onDialogAbort = var1;
	}

	public int getItemId() {
		return this.itemId;
	}

	public void setItemId(int var1) {
		this.itemId = var1;
	}

	public int getItemQuantity() {
		return this.itemQuantity;
	}

	public void setItemQuantity(int var1) {
		this.itemQuantity = var1;
	}

	public int getModelFrame() {
		return this.modelFrame;
	}

	public boolean containsMouse() {
		return this.containsMouse;
	}

	public boolean getNoClickThrough() {
		return this.noClickThrough;
	}

	public void setNoClickThrough(boolean var1) {
		this.noClickThrough = var1;
	}

	public boolean getNoScrollThrough() {
		return this.noScrollThrough;
	}

	public void setNoScrollThrough(boolean var1) {
		this.noScrollThrough = var1;
	}

	public RSFont getFont() {
		return this.method4121();
	}

	public void setAction(int var1, String var2) {
		this.method4145(var1, var2);
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "1024781244"
	)
	static int method4159(int var0, class101 var1, boolean var2) {
		String var3;
		if (var0 == 3100) {
			var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
			Skeleton.method3161(0, "", var3);
			return 1;
		} else if (var0 == 3101) {
			Interpreter.Interpreter_intStackSize -= 2;
			GrandExchangeOfferWorldComparator.method149(ByteArrayPool.localPlayer, Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
			return 1;
		} else if (var0 == 3103) {
			if (!Interpreter.field1126) {
				Interpreter.field1125 = true;
			}

			return 1;
		} else {
			int var10;
			if (var0 == 3104) {
				var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
				var10 = 0;
				if (MusicPatch.method3959(var3)) {
					var10 = Tiles.method1217(var3);
				}

				PacketBufferNode var12 = FaceNormal.method3363(ClientPacket.field2279, Client.packetWriter.isaacCipher);
				var12.packetBuffer.method5689(var10);
				Client.packetWriter.method2361(var12);
				return 1;
			} else {
				PacketBufferNode var14;
				if (var0 == 3105) {
					var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
					var14 = FaceNormal.method3363(ClientPacket.field2213, Client.packetWriter.isaacCipher);
					var14.packetBuffer.method5531(var3.length() + 1);
					var14.packetBuffer.method5627(var3);
					Client.packetWriter.method2361(var14);
					return 1;
				} else if (var0 == 3106) {
					var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
					var14 = FaceNormal.method3363(ClientPacket.field2273, Client.packetWriter.isaacCipher);
					var14.packetBuffer.method5531(var3.length() + 1);
					var14.packetBuffer.method5627(var3);
					Client.packetWriter.method2361(var14);
					return 1;
				} else {
					String var7;
					int var15;
					if (var0 == 3107) {
						var15 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var7 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
						class39.method646(var15, var7);
						return 1;
					} else if (var0 == 3108) {
						Interpreter.Interpreter_intStackSize -= 3;
						var15 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
						var10 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
						int var9 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
						Widget var13 = MusicPatchNode.method3898(var9);
						Player.method1380(var13, var15, var10);
						return 1;
					} else if (var0 == 3109) {
						Interpreter.Interpreter_intStackSize -= 2;
						var15 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
						var10 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
						Widget var11 = var2 ? GrandExchangeOfferNameComparator.field115 : Interpreter.field1130;
						Player.method1380(var11, var15, var10);
						return 1;
					} else if (var0 == 3110) {
						class217.mouseCam = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == 3111) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = GrandExchangeOfferOwnWorldComparator.clientPreferences.roofsHidden ? 1 : 0;
						return 1;
					} else if (var0 == 3112) {
						GrandExchangeOfferOwnWorldComparator.clientPreferences.roofsHidden = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						WorldMapArea.method509();
						return 1;
					} else if (var0 == 3113) {
						var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
						boolean var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						class101.method2322(var3, var4, false);
						return 1;
					} else if (var0 == 3115) {
						var15 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var14 = FaceNormal.method3363(ClientPacket.field2253, Client.packetWriter.isaacCipher);
						var14.packetBuffer.method5532(var15);
						Client.packetWriter.method2361(var14);
						return 1;
					} else if (var0 == 3116) {
						var15 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						Interpreter.Interpreter_stringStackSize -= 2;
						var7 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
						String var5 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1];
						if (var7.length() > 500) {
							return 1;
						} else if (var5.length() > 500) {
							return 1;
						} else {
							PacketBufferNode var6 = FaceNormal.method3363(ClientPacket.field2214, Client.packetWriter.isaacCipher);
							var6.packetBuffer.method5532(1 + class234.method4198(var7) + class234.method4198(var5));
							var6.packetBuffer.method5700(var15);
							var6.packetBuffer.method5627(var7);
							var6.packetBuffer.method5627(var5);
							Client.packetWriter.method2361(var6);
							return 1;
						}
					} else if (var0 == 3117) {
						Client.shiftClickDrop = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == 3118) {
						Client.showMouseOverText = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == 3119) {
						Client.renderSelf = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == 3120) {
						if (Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 1;
						} else {
							Client.drawPlayerNames &= -2;
						}

						return 1;
					} else if (var0 == 3121) {
						if (Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 2;
						} else {
							Client.drawPlayerNames &= -3;
						}

						return 1;
					} else if (var0 == 3122) {
						if (Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 4;
						} else {
							Client.drawPlayerNames &= -5;
						}

						return 1;
					} else if (var0 == 3123) {
						if (Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 8;
						} else {
							Client.drawPlayerNames &= -9;
						}

						return 1;
					} else if (var0 == 3124) {
						Client.drawPlayerNames = 0;
						return 1;
					} else if (var0 == 3125) {
						Client.showMouseCross = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == 3126) {
						Client.showLoadingMessages = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == 3127) {
						class2.method34(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1);
						return 1;
					} else if (var0 == 3128) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = WorldMapSection3.method880() ? 1 : 0;
						return 1;
					} else if (var0 == 3129) {
						Interpreter.Interpreter_intStackSize -= 2;
						Client.oculusOrbNormalSpeed = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
						Client.oculusOrbSlowedSpeed = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
						return 1;
					} else if (var0 == 3130) {
						Interpreter.Interpreter_intStackSize -= 2;
						return 1;
					} else if (var0 == 3131) {
						--Interpreter.Interpreter_intStackSize;
						return 1;
					} else if (var0 == 3132) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = WorldMapLabel.canvasWidth;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Varps.canvasHeight;
						return 1;
					} else if (var0 == 3133) {
						--Interpreter.Interpreter_intStackSize;
						return 1;
					} else if (var0 == 3134) {
						return 1;
					} else if (var0 == 3135) {
						Interpreter.Interpreter_intStackSize -= 2;
						return 1;
					} else if (var0 == 3136) {
						Client.field842 = 3;
						Client.field843 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						return 1;
					} else if (var0 == 3137) {
						Client.field842 = 2;
						Client.field843 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						return 1;
					} else if (var0 == 3138) {
						Client.field842 = 0;
						return 1;
					} else if (var0 == 3139) {
						Client.field842 = 1;
						return 1;
					} else if (var0 == 3140) {
						Client.field842 = 3;
						Client.field843 = var2 ? GrandExchangeOfferNameComparator.field115.id : Interpreter.field1130.id;
						return 1;
					} else {
						boolean var8;
						if (var0 == 3141) {
							var8 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							GrandExchangeOfferOwnWorldComparator.clientPreferences.hideUsername = var8;
							WorldMapArea.method509();
							return 1;
						} else if (var0 == 3142) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = GrandExchangeOfferOwnWorldComparator.clientPreferences.hideUsername ? 1 : 0;
							return 1;
						} else if (var0 == 3143) {
							var8 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							Client.Login_isUsernameRemembered = var8;
							if (!var8) {
								GrandExchangeOfferOwnWorldComparator.clientPreferences.rememberedUsername = "";
								WorldMapArea.method509();
							}

							return 1;
						} else if (var0 == 3144) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.Login_isUsernameRemembered ? 1 : 0;
							return 1;
						} else if (var0 == 3145) {
							return 1;
						} else if (var0 == 3146) {
							var8 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							if (var8 == GrandExchangeOfferOwnWorldComparator.clientPreferences.titleMusicDisabled) {
								GrandExchangeOfferOwnWorldComparator.clientPreferences.titleMusicDisabled = !var8;
								WorldMapArea.method509();
							}

							return 1;
						} else if (var0 == 3147) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = GrandExchangeOfferOwnWorldComparator.clientPreferences.titleMusicDisabled ? 0 : 1;
							return 1;
						} else if (var0 == 3148) {
							return 1;
						} else if (var0 == 3149) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3150) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3151) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3152) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3153) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Login.Login_loadingPercent;
							return 1;
						} else if (var0 == 3154) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = GrandExchangeOfferWorldComparator.method147();
							return 1;
						} else if (var0 == 3155) {
							--Interpreter.Interpreter_stringStackSize;
							return 1;
						} else if (var0 == 3156) {
							return 1;
						} else if (var0 == 3157) {
							Interpreter.Interpreter_intStackSize -= 2;
							return 1;
						} else if (var0 == 3158) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3159) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3160) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3161) {
							--Interpreter.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3162) {
							--Interpreter.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3163) {
							--Interpreter.Interpreter_stringStackSize;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3164) {
							--Interpreter.Interpreter_intStackSize;
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
							return 1;
						} else if (var0 == 3165) {
							--Interpreter.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3166) {
							Interpreter.Interpreter_intStackSize -= 2;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3167) {
							Interpreter.Interpreter_intStackSize -= 2;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3168) {
							Interpreter.Interpreter_intStackSize -= 2;
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
							return 1;
						} else if (var0 == 3169) {
							return 1;
						} else if (var0 == 3170) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3171) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3172) {
							--Interpreter.Interpreter_intStackSize;
							return 1;
						} else if (var0 == 3173) {
							--Interpreter.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3174) {
							--Interpreter.Interpreter_intStackSize;
							return 1;
						} else if (var0 == 3175) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3176) {
							return 1;
						} else if (var0 == 3177) {
							return 1;
						} else if (var0 == 3178) {
							--Interpreter.Interpreter_stringStackSize;
							return 1;
						} else if (var0 == 3179) {
							return 1;
						} else if (var0 == 3180) {
							--Interpreter.Interpreter_stringStackSize;
							return 1;
						} else {
							return 2;
						}
					}
				}
			}
		}
	}

	private static void rl$$clinit() {
		$assertionsDisabled = !Client.class.desiredAssertionStatus();
	}
}
