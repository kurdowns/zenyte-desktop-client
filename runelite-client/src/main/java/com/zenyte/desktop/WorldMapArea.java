package com.zenyte.desktop;

import java.awt.Image;
import java.util.Iterator;
import java.util.LinkedList;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSWorldMapArea;

@ObfuscatedName("as")
public class WorldMapArea implements RSWorldMapArea {
	@ObfuscatedName("al")
	static Image field265;
	@ObfuscatedName("gn")
	static int[] regionLandArchiveIds;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -631635031
	)
	int id;
	@ObfuscatedName("m")
	String internalName;
	@ObfuscatedName("k")
	String externalName;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -46653521
	)
	int backGroundColor;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1356940577
	)
	int zoom;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lhj;"
	)
	Coord origin;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 739572021
	)
	int regionLowX;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1052240037
	)
	int regionHighX;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1837208227
	)
	int regionLowY;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -884560367
	)
	int regionHighY;
	@ObfuscatedName("s")
	boolean isMain;
	@ObfuscatedName("p")
	LinkedList sections;

	public WorldMapArea() {
		this.id = -1;
		this.backGroundColor = -1;
		this.zoom = -1;
		this.origin = null;
		this.regionLowX = Integer.MAX_VALUE;
		this.regionHighX = 0;
		this.regionLowY = Integer.MAX_VALUE;
		this.regionHighY = 0;
		this.isMain = false;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lkb;IB)V",
		garbageValue = "9"
	)
	public void method471(Buffer var1, int var2) {
		this.id = var2;
		this.internalName = var1.method5667();
		this.externalName = var1.method5667();
		this.origin = new Coord(var1.method5552());
		this.backGroundColor = var1.method5552();
		var1.method5547();
		this.isMain = var1.method5547() == 1;
		this.zoom = var1.method5547();
		int var3 = var1.method5547();
		this.sections = new LinkedList();

		for (int var4 = 0; var4 < var3; ++var4) {
			this.sections.add(this.method455(var1));
		}

		this.method446();
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lkb;I)Lay;",
		garbageValue = "647857344"
	)
	WorldMapSection method455(Buffer var1) {
		int var2 = var1.method5547();
		WorldMapSectionType var3 = (WorldMapSectionType)GrandExchangeEvent.method159(WorldMapSectionType.method345(), var2);
		Object var4 = null;
		switch(var3.type) {
		case 0:
			var4 = new WorldMapSection0();
			break;
		case 1:
			var4 = new WorldMapSection3();
			break;
		case 2:
			var4 = new WorldMapSection1();
			break;
		case 3:
			var4 = new WorldMapSection2();
			break;
		default:
			throw new IllegalStateException("");
		}

		((WorldMapSection)var4).vmethod885(var1);
		return (WorldMapSection)var4;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(IIIB)Z",
		garbageValue = "-9"
	)
	public boolean method468(int var1, int var2, int var3) {
		Iterator var4 = this.sections.iterator();

		WorldMapSection var5;
		do {
			if (!var4.hasNext()) {
				return false;
			}

			var5 = (WorldMapSection)var4.next();
		} while(!var5.vmethod871(var1, var2, var3));

		return true;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "-541055130"
	)
	public boolean method443(int var1, int var2) {
		int var3 = var1 / 64;
		int var4 = var2 / 64;
		if (var3 >= this.regionLowX && var3 <= this.regionHighX) {
			if (var4 >= this.regionLowY && var4 <= this.regionHighY) {
				Iterator var5 = this.sections.iterator();

				WorldMapSection var6;
				do {
					if (!var5.hasNext()) {
						return false;
					}

					var6 = (WorldMapSection)var5.next();
				} while(!var6.vmethod872(var1, var2));

				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IIIB)[I",
		garbageValue = "-58"
	)
	public int[] method444(int var1, int var2, int var3) {
		Iterator var4 = this.sections.iterator();

		WorldMapSection var5;
		do {
			if (!var4.hasNext()) {
				return null;
			}

			var5 = (WorldMapSection)var4.next();
		} while(!var5.vmethod871(var1, var2, var3));

		return var5.vmethod873(var1, var2, var3);
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(IIB)Lhj;",
		garbageValue = "-127"
	)
	public Coord method456(int var1, int var2) {
		Iterator var3 = this.sections.iterator();

		WorldMapSection var4;
		do {
			if (!var3.hasNext()) {
				return null;
			}

			var4 = (WorldMapSection)var3.next();
		} while(!var4.vmethod872(var1, var2));

		return var4.vmethod890(var1, var2);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "969855429"
	)
	void method446() {
		Iterator var1 = this.sections.iterator();

		while (var1.hasNext()) {
			WorldMapSection var2 = (WorldMapSection)var1.next();
			var2.vmethod870(this);
		}

	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "39"
	)
	public int method441() {
		return this.id;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-126"
	)
	public boolean method458() {
		return this.isMain;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)Ljava/lang/String;",
		garbageValue = "21"
	)
	public String method449() {
		return this.internalName;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "1379257785"
	)
	public String method450() {
		return this.externalName;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "0"
	)
	int method451() {
		return this.backGroundColor;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "2036158074"
	)
	public int method452() {
		return this.zoom;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1003198197"
	)
	public int method453() {
		return this.regionLowX;
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1380383839"
	)
	public int method454() {
		return this.regionHighX;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "2084739447"
	)
	public int method439() {
		return this.regionLowY;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "851351546"
	)
	public int method442() {
		return this.regionHighY;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-2108645613"
	)
	public int method457() {
		return this.origin.x;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "567530142"
	)
	public int method496() {
		return this.origin.plane;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-86"
	)
	public int method447() {
		return this.origin.y;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)Lhj;",
		garbageValue = "710873415"
	)
	public Coord method460() {
		return new Coord(this.origin);
	}

	public boolean surfaceContainsPosition(int var1, int var2) {
		return this.method443(var1, var2);
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1802604469"
	)
	static void method509() {
		AccessFile var0 = null;

		try {
			var0 = KeyHandler.method919("", WorldMapArchiveLoader.field3965.name, true);
			Buffer var1 = GrandExchangeOfferOwnWorldComparator.clientPreferences.method1929();
			var0.method6653(var1.array, 0, var1.offset);
		} catch (Exception var3) {
		}

		try {
			if (var0 != null) {
				var0.method6651(true);
			}
		} catch (Exception var2) {
		}

	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(ILiy;Ljava/lang/String;Ljava/lang/String;IZI)V",
		garbageValue = "350541226"
	)
	public static void method461(int var0, AbstractArchive var1, String var2, String var3, int var4, boolean var5) {
		int var6 = var1.method4240(var2);
		int var7 = var1.method4233(var6, var3);
		FaceNormal.method3364(var0, var1, var6, var7, var4, var5);
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "([BIIB)Ljava/lang/String;",
		garbageValue = "-37"
	)
	public static String method507(byte[] var0, int var1, int var2) {
		char[] var3 = new char[var2];
		int var4 = 0;

		for (int var5 = 0; var5 < var2; ++var5) {
			int var6 = var0[var5 + var1] & 255;
			if (var6 != 0) {
				if (var6 >= 128 && var6 < 160) {
					char var7 = class297.cp1252AsciiExtension[var6 - 128];
					if (var7 == 0) {
						var7 = '?';
					}

					var6 = var7;
				}

				var3[var4++] = (char)var6;
			}
		}

		return new String(var3, 0, var4);
	}

	@ObfuscatedName("gw")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "749778877"
	)
	static void method508() {
		if (GrandExchangeOfferAgeComparator.worldMap != null) {
			GrandExchangeOfferAgeComparator.worldMap.method6487(ScriptEvent.Client_plane, (ByteArrayPool.localPlayer.x >> 7) + class69.baseX * 731242929, (ByteArrayPool.localPlayer.y >> 7) + class89.baseY * 1825982697, false);
			GrandExchangeOfferAgeComparator.worldMap.method6406();
		}

	}
}
