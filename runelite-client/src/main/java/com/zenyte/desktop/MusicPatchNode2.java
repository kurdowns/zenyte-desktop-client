package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSMusicPatchNode2;
import net.runelite.rs.api.RSSprite;

@ObfuscatedName("gf")
public class MusicPatchNode2 implements RSMusicPatchNode2 {
	@ObfuscatedName("x")
	byte[] field2402;
	@ObfuscatedName("m")
	byte[] field2398;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -224180223
	)
	int field2396;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 227896201
	)
	int field2397;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -615138819
	)
	int field2400;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1353186567
	)
	int field2399;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 22420513
	)
	int field2395;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 2050807293
	)
	int field2401;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1299814217
	)
	int field2394;

	MusicPatchNode2() {
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Liy;III)Lla;"
	)
	public static Sprite method3752(AbstractArchive var0, int var1, int var2, int var3) {
		net.runelite.api.Sprite var4 = (net.runelite.api.Sprite)Client.spriteOverrides.get(var1);
		return var4 != null ? (Sprite)((RSSprite)var4) : (Sprite)Client.copy$SpriteBuffer_getSprite(var0, var1, var2, var3);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lkb;IIIIIIB)V",
		garbageValue = "16"
	)
	static final void method3753(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		int var7;
		if (var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
			Tiles.Tiles_renderFlags[var1][var2][var3] = 0;

			while (true) {
				var7 = var0.method5547();
				if (var7 == 0) {
					if (var1 == 0) {
						int[] var8 = Tiles.Tiles_heights[0][var2];
						int var11 = var2 + var4 + 932731;
						int var12 = var3 + var5 + 556238;
						int var13 = Canvas.method957(var11 + 45365, 91923 + var12, 4) - 128 + (Canvas.method957(10294 + var11, 37821 + var12, 2) - 128 >> 1) + (Canvas.method957(var11, var12, 1) - 128 >> 2);
						var13 = (int)(0.3D * (double)var13) + 35;
						if (var13 < 10) {
							var13 = 10;
						} else if (var13 > 60) {
							var13 = 60;
						}

						var8[var3] = -var13 * 8;
					} else {
						Tiles.Tiles_heights[var1][var2][var3] = Tiles.Tiles_heights[var1 - 1][var2][var3] - 240;
					}
					break;
				}

				if (var7 == 1) {
					int var14 = var0.method5547();
					if (var14 == 1) {
						var14 = 0;
					}

					if (var1 == 0) {
						Tiles.Tiles_heights[0][var2][var3] = -var14 * 8;
					} else {
						Tiles.Tiles_heights[var1][var2][var3] = Tiles.Tiles_heights[var1 - 1][var2][var3] - var14 * 8;
					}
					break;
				}

				if (var7 <= 49) {
					class348.field4061[var1][var2][var3] = var0.method5548();
					Tiles.field539[var1][var2][var3] = (byte)((var7 - 2) / 4);
					Tiles.field540[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
				} else if (var7 <= 81) {
					Tiles.Tiles_renderFlags[var1][var2][var3] = (byte)(var7 - 49);
				} else {
					Tiles.field538[var1][var2][var3] = (byte)(var7 - 81);
				}
			}
		} else {
			while (true) {
				var7 = var0.method5547();
				if (var7 == 0) {
					break;
				}

				if (var7 == 1) {
					var0.method5547();
					break;
				}

				if (var7 <= 49) {
					var0.method5547();
				}
			}
		}

	}
}
