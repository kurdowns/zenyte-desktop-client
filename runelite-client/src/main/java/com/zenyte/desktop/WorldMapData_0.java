package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSWorldMapData_0;

@ObfuscatedName("y")
public class WorldMapData_0 extends AbstractWorldMapData implements RSWorldMapData_0 {
	@ObfuscatedName("y")
	static int[] BZip2Decompressor_block;
	@ObfuscatedName("br")
	static String field137;
	@ObfuscatedName("fh")
	@ObfuscatedSignature(
		signature = "Lkx;"
	)
	static Font fontPlain12;
	@ObfuscatedName("gh")
	static byte[][] regionLandArchives;

	WorldMapData_0() {
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lkb;I)V",
		garbageValue = "-1716650970"
	)
	void method264(Buffer var1) {
		int var2 = var1.method5547();
		if (var2 != WorldMapID.field302.value) {
			throw new IllegalStateException("");
		} else {
			super.minPlane = var1.method5547();
			super.planes = var1.method5547();
			super.regionXLow = var1.method5549();
			super.regionYLow = var1.method5549();
			super.regionX = var1.method5549();
			super.regionY = var1.method5549();
			super.groupId = var1.method5564();
			super.fileId = var1.method5564();
		}
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lkb;B)V",
		garbageValue = "-78"
	)
	void vmethod806(Buffer var1) {
		super.planes = Math.min(super.planes, 4);
		super.floorUnderlayIds = new short[1][64][64];
		super.floorOverlayIds = new short[super.planes][64][64];
		super.field205 = new byte[super.planes][64][64];
		super.field206 = new byte[super.planes][64][64];
		super.decorations = new WorldMapDecoration[super.planes][64][64][];
		int var2 = var1.method5547();
		if (var2 != class39.field300.value) {
			throw new IllegalStateException("");
		} else {
			int var3 = var1.method5547();
			int var4 = var1.method5547();
			if (var3 == super.regionX && var4 == super.regionY) {
				for (int var5 = 0; var5 < 64; ++var5) {
					for (int var6 = 0; var6 < 64; ++var6) {
						this.method354(var5, var6, var1);
					}
				}

			} else {
				throw new IllegalStateException("");
			}
		}
	}

	public boolean equals(Object var1) {
		if (!(var1 instanceof WorldMapData_0)) {
			return false;
		} else {
			WorldMapData_0 var2 = (WorldMapData_0)var1;
			return super.regionX == var2.regionX && var2.regionY == super.regionY;
		}
	}

	public int hashCode() {
		return super.regionX | super.regionY << 8;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "([BIIII[Lfm;B)V",
		garbageValue = "-108"
	)
	static final void method275(byte[] var0, int var1, int var2, int var3, int var4, CollisionMap[] var5) {
		int var7;
		int var8;
		for (int var6 = 0; var6 < 4; ++var6) {
			for (var7 = 0; var7 < 64; ++var7) {
				for (var8 = 0; var8 < 64; ++var8) {
					if (var7 + var1 > 0 && var7 + var1 < 103 && var8 + var2 > 0 && var8 + var2 < 103) {
						int[] var10000 = var5[var6].flags[var7 + var1];
						var10000[var8 + var2] &= -16777217;
					}
				}
			}
		}

		Buffer var10 = new Buffer(var0);

		for (var7 = 0; var7 < 4; ++var7) {
			for (var8 = 0; var8 < 64; ++var8) {
				for (int var9 = 0; var9 < 64; ++var9) {
					MusicPatchNode2.method3753(var10, var7, var8 + var1, var9 + var2, var3, var4, 0);
				}
			}
		}

	}

	@ObfuscatedName("ki")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1448123046"
	)
	static final void method263() {
		Client.field874 = Client.cycleCntr;
		Timer.ClanChat_inClanChat = true;
	}
}
