package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSWorldMapSection2;

@ObfuscatedName("at")
public class WorldMapSection2 implements WorldMapSection, RSWorldMapSection2 {
	@ObfuscatedName("ix")
	@ObfuscatedGetter(
		intValue = 1088959325
	)
	static int selectedItemWidget;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 108027763
	)
	int minPlane;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -970262457
	)
	int planes;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1813632253
	)
	int regionStartX;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 460883399
	)
	int regionStartY;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -2027857729
	)
	int regionEndX;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -848152655
	)
	int regionEndY;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -2043506095
	)
	int field232;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1803971443
	)
	int field239;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1772744581
	)
	int field234;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1804974207
	)
	int field241;

	WorldMapSection2() {
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Las;I)V",
		garbageValue = "1890497148"
	)
	public void vmethod870(WorldMapArea var1) {
		if (var1.regionLowX > this.field232) {
			var1.regionLowX = this.field232;
		}

		if (var1.regionHighX < this.field234) {
			var1.regionHighX = this.field234;
		}

		if (var1.regionLowY > this.field239) {
			var1.regionLowY = this.field239;
		}

		if (var1.regionHighY < this.field241) {
			var1.regionHighY = this.field241;
		}

	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "-65934716"
	)
	public boolean vmethod871(int var1, int var2, int var3) {
		if (var1 >= this.minPlane && var1 < this.minPlane + this.planes) {
			return var2 >> 6 >= this.regionStartX && var2 >> 6 <= this.regionEndX && var3 >> 6 >= this.regionStartY && var3 >> 6 <= this.regionEndY;
		} else {
			return false;
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "-1383343929"
	)
	public boolean vmethod872(int var1, int var2) {
		return var1 >> 6 >= this.field232 && var1 >> 6 <= this.field234 && var2 >> 6 >= this.field239 && var2 >> 6 <= this.field241;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "1656767825"
	)
	public int[] vmethod873(int var1, int var2, int var3) {
		if (!this.vmethod871(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{this.field232 * 64 - this.regionStartX * 64 + var2, var3 + (this.field239 * 64 - this.regionStartY * 64)};
			return var4;
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(III)Lhj;",
		garbageValue = "-226825052"
	)
	public Coord vmethod890(int var1, int var2) {
		if (!this.vmethod872(var1, var2)) {
			return null;
		} else {
			int var3 = this.regionStartX * 64 - this.field232 * 64 + var1;
			int var4 = this.regionStartY * 64 - this.field239 * 64 + var2;
			return new Coord(this.minPlane, var3, var4);
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lkb;I)V",
		garbageValue = "-1393433755"
	)
	public void vmethod885(Buffer var1) {
		this.minPlane = var1.method5547();
		this.planes = var1.method5547();
		this.regionStartX = var1.method5549();
		this.regionStartY = var1.method5549();
		this.regionEndX = var1.method5549();
		this.regionEndY = var1.method5549();
		this.field232 = var1.method5549();
		this.field239 = var1.method5549();
		this.field234 = var1.method5549();
		this.field241 = var1.method5549();
		this.method415();
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1585844448"
	)
	void method415() {
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)[Lgh;",
		garbageValue = "-615033295"
	)
	public static class194[] method434() {
		return new class194[]{class194.field2324, class194.field2325, class194.field2327, class194.field2326, class194.field2332, class194.field2328, class194.field2329, class194.field2330, class194.field2331, class194.field2323};
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(II)Ljw;",
		garbageValue = "1650295452"
	)
	public static ObjectDefinition method435(int var0) {
		ObjectDefinition var1 = (ObjectDefinition)ObjectDefinition.ObjectDefinition_cached.method3418((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = ObjectDefinition.ObjectDefinition_archive.method4224(6, var0, (byte)-45);
			var1 = new ObjectDefinition();
			var1.id = var0;
			if (var2 != null) {
				var1.method4635(new Buffer(var2));
			}

			var1.method4634();
			if (var1.isSolid) {
				var1.interactType = 0;
				var1.boolean1 = false;
			}

			ObjectDefinition.ObjectDefinition_cached.method3424(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(CI)Z",
		garbageValue = "65280"
	)
	static boolean method433(char var0) {
		return "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".indexOf(var0) != -1;
	}
}
