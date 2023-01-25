package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSFloorOverlayDefinition;

@ObfuscatedName("jn")
public class FloorOverlayDefinition extends DualNode implements RSFloorOverlayDefinition {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	public static AbstractArchive FloorOverlayDefinition_archive;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	static EvictingDualNodeHashTable FloorOverlayDefinition_cached;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1157024387
	)
	public int primaryRgb;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 512679167
	)
	public int texture;
	@ObfuscatedName("w")
	public boolean hideUnderlay;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1191999743
	)
	public int secondaryRgb;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 273345835
	)
	public int hue;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1834266941
	)
	public int saturation;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1392901101
	)
	public int lightness;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1368031931
	)
	public int secondaryHue;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -1913373455
	)
	public int secondarySaturation;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 262091387
	)
	public int secondaryLightness;

	static {
		FloorOverlayDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	FloorOverlayDefinition() {
		this.primaryRgb = 0;
		this.texture = -1;
		this.hideUnderlay = true;
		this.secondaryRgb = -1;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1555097959"
	)
	void method4798() {
		if (this.secondaryRgb != -1) {
			this.method4807(this.secondaryRgb);
			this.secondaryHue = this.hue;
			this.secondarySaturation = this.saturation;
			this.secondaryLightness = this.lightness;
		}

		this.method4807(this.primaryRgb);
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lkb;II)V",
		garbageValue = "-1372531887"
	)
	void method4799(Buffer var1, int var2) {
		while (true) {
			int var3 = var1.method5547();
			if (var3 == 0) {
				return;
			}

			this.method4805(var1, var3, var2);
		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Lkb;IIB)V",
		garbageValue = "109"
	)
	void method4805(Buffer var1, int var2, int var3) {
		if (var2 == 1) {
			this.primaryRgb = var1.method5674();
		} else if (var2 == 2) {
			this.texture = var1.method5547();
		} else if (var2 == 5) {
			this.hideUnderlay = false;
		} else if (var2 == 7) {
			this.secondaryRgb = var1.method5674();
		} else if (var2 == 8) {
		}

	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-726592820"
	)
	void method4807(int var1) {
		double var2 = (double)(var1 >> 16 & 255) / 256.0D;
		double var4 = (double)(var1 >> 8 & 255) / 256.0D;
		double var6 = (double)(var1 & 255) / 256.0D;
		double var8 = var2;
		if (var4 < var2) {
			var8 = var4;
		}

		if (var6 < var8) {
			var8 = var6;
		}

		double var10 = var2;
		if (var4 > var2) {
			var10 = var4;
		}

		if (var6 > var10) {
			var10 = var6;
		}

		double var12 = 0.0D;
		double var14 = 0.0D;
		double var16 = (var10 + var8) / 2.0D;
		if (var8 != var10) {
			if (var16 < 0.5D) {
				var14 = (var10 - var8) / (var8 + var10);
			}

			if (var16 >= 0.5D) {
				var14 = (var10 - var8) / (2.0D - var10 - var8);
			}

			if (var2 == var10) {
				var12 = (var4 - var6) / (var10 - var8);
			} else if (var4 == var10) {
				var12 = (var6 - var2) / (var10 - var8) + 2.0D;
			} else if (var10 == var6) {
				var12 = (var2 - var4) / (var10 - var8) + 4.0D;
			}
		}

		var12 /= 6.0D;
		this.hue = (int)(var12 * 256.0D);
		this.saturation = (int)(var14 * 256.0D);
		this.lightness = (int)(256.0D * var16);
		if (this.saturation < 0) {
			this.saturation = 0;
		} else if (this.saturation > 255) {
			this.saturation = 255;
		}

		if (this.lightness < 0) {
			this.lightness = 0;
		} else if (this.lightness > 255) {
			this.lightness = 255;
		}

	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IB)Ljq;",
		garbageValue = "6"
	)
	public static StructDefinition method4801(int var0) {
		StructDefinition var1 = (StructDefinition)StructDefinition.StructDefinition_cached.method3418((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = StructDefinition.StructDefinition_archive.method4224(34, var0, (byte)-121);
			var1 = new StructDefinition();
			if (var2 != null) {
				var1.method4563(new Buffer(var2));
			}

			var1.method4585();
			StructDefinition.StructDefinition_cached.method3424(var1, (long)var0);
			return var1;
		}
	}
}
