package com.zenyte.desktop;

import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSSecureRandomFuture;

@ObfuscatedName("ca")
public class SecureRandomFuture implements RSSecureRandomFuture {
	@ObfuscatedName("ol")
	@ObfuscatedSignature(
		signature = "Lfq;"
	)
	static MouseWheel mouseWheel;
	@ObfuscatedName("ds")
	@ObfuscatedSignature(
		signature = "Lih;"
	)
	static Archive archive9;
	@ObfuscatedName("x")
	ExecutorService executor;
	@ObfuscatedName("m")
	Future future;

	SecureRandomFuture() {
		this.executor = Executors.newSingleThreadExecutor();
		this.future = this.executor.submit(new SecureRandomCallable());
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-128"
	)
	void method2206() {
		this.executor.shutdown();
		this.executor = null;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-126"
	)
	boolean method2203() {
		return this.future.isDone();
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)Ljava/security/SecureRandom;",
		garbageValue = "876677352"
	)
	SecureRandom method2204() {
		try {
			return (SecureRandom)this.future.get();
		} catch (Exception var4) {
			SecureRandom var3 = new SecureRandom();
			var3.nextInt();
			return var3;
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "1233974315"
	)
	public static int method2212(int var0, int var1) {
		int var2;
		for (var2 = 1; var1 > 1; var1 >>= 1) {
			if ((var1 & 1) != 0) {
				var2 = var0 * var2;
			}

			var0 *= var0;
		}

		if (var1 == 1) {
			return var0 * var2;
		} else {
			return var2;
		}
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(IIIIIZI)Lla;",
		garbageValue = "-2006803252"
	)
	public static final Sprite method2213(int var0, int var1, int var2, int var3, int var4, boolean var5) {
		if (var1 == -1) {
			var4 = 0;
		} else if (var4 == 2 && var1 != 1) {
			var4 = 1;
		}

		long var6 = ((long)var3 << 42) + ((long)var1 << 16) + (long)var0 + ((long)var2 << 38) + ((long)var4 << 40);
		Sprite var8;
		if (!var5) {
			var8 = (Sprite)ItemDefinition.ItemDefinition_cachedSprites.method3418(var6);
			if (var8 != null) {
				return var8;
			}
		}

		ItemDefinition var9 = AbstractWorldMapData.method373(var0);
		if (var1 > 1 && var9.countobj != null) {
			int var10 = -1;

			for (int var11 = 0; var11 < 10; ++var11) {
				if (var1 >= var9.countco[var11] && var9.countco[var11] != 0) {
					var10 = var9.countobj[var11];
				}
			}

			if (var10 != -1) {
				var9 = AbstractWorldMapData.method373(var10);
			}
		}

		Model var19 = var9.method4696(1, (byte)-96);
		if (var19 == null) {
			return null;
		} else {
			Sprite var20 = null;
			if (var9.noteTemplate != -1) {
				var20 = method2213(var9.note, 10, 1, 0, 0, true);
				if (var20 == null) {
					return null;
				}
			} else if (var9.notedId != -1) {
				var20 = method2213(var9.unnotedId, var1, var2, var3, 0, false);
				if (var20 == null) {
					return null;
				}
			} else if (var9.placeholderTemplate != -1) {
				var20 = method2213(var9.placeholder, var1, 0, 0, 0, false);
				if (var20 == null) {
					return null;
				}
			}

			int[] var12 = Rasterizer2D.Rasterizer2D_pixels;
			int var13 = Rasterizer2D.Rasterizer2D_width;
			int var14 = Rasterizer2D.Rasterizer2D_height;
			int[] var15 = new int[4];
			Rasterizer2D.method6047(var15);
			var8 = new Sprite(36, 32);
			Rasterizer2D.method6043(var8.pixels, 36, 32);
			Rasterizer2D.method6049();
			Rasterizer3D.method3133();
			Rasterizer3D.method3085(16, 16);
			Rasterizer3D.field1772 = false;
			if (var9.placeholderTemplate != -1) {
				var20.method6187(0, 0);
			}

			int var16 = var9.zoom2d;
			if (var5) {
				var16 = (int)(1.5D * (double)var16);
			} else if (var2 == 2) {
				var16 = (int)((double)var16 * 1.04D);
			}

			int var17 = var16 * Rasterizer3D.Rasterizer3D_sine[var9.xan2d] >> 16;
			int var18 = var16 * Rasterizer3D.Rasterizer3D_cosine[var9.xan2d] >> 16;
			var19.method2955();
			var19.method2968(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var19.height / 2 + var17 + var9.offsetY2d, var18 + var9.offsetY2d);
			if (var9.notedId != -1) {
				var20.method6187(0, 0);
			}

			if (var2 >= 1) {
				var8.method6269(1);
			}

			if (var2 >= 2) {
				var8.method6269(16777215);
			}

			if (var3 != 0) {
				var8.method6184(var3);
			}

			Rasterizer2D.method6043(var8.pixels, 36, 32);
			if (var9.noteTemplate != -1) {
				var20.method6187(0, 0);
			}

			if (var4 == 1 || var4 == 2 && var9.isStackable == 1) {
				WorldMapSection3.ItemDefinition_fontPlain11.method5389(GrandExchangeOfferOwnWorldComparator.method1385(var1), 0, 9, 16776960, 1);
			}

			if (!var5) {
				ItemDefinition.ItemDefinition_cachedSprites.method3424(var8, var6);
			}

			Rasterizer2D.method6043(var12, var13, var14);
			Rasterizer2D.method6048(var15);
			Rasterizer3D.method3133();
			Rasterizer3D.field1772 = true;
			return var8;
		}
	}
}
