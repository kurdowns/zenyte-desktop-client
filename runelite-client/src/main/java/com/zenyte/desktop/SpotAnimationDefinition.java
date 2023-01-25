package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSSpotAnimationDefinition;

@ObfuscatedName("iw")
public class SpotAnimationDefinition extends DualNode implements RSSpotAnimationDefinition {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	public static AbstractArchive SpotAnimationDefinition_archive;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	public static AbstractArchive SpotAnimationDefinition_modelArchive;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	public static EvictingDualNodeHashTable SpotAnimationDefinition_cached;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	public static EvictingDualNodeHashTable SpotAnimationDefinition_cachedModels;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1568663321
	)
	int id;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -2124513073
	)
	int archive;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 872877257
	)
	public int sequence;
	@ObfuscatedName("z")
	short[] recolorFrom;
	@ObfuscatedName("t")
	short[] recolorTo;
	@ObfuscatedName("e")
	short[] retextureFrom;
	@ObfuscatedName("s")
	short[] retextureTo;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1719223697
	)
	int widthScale;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1056397705
	)
	int heightScale;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 378362489
	)
	int orientation;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -811477227
	)
	int ambient;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 551721489
	)
	int contrast;

	static {
		SpotAnimationDefinition_cached = new EvictingDualNodeHashTable(64);
		SpotAnimationDefinition_cachedModels = new EvictingDualNodeHashTable(30);
	}

	SpotAnimationDefinition() {
		this.sequence = -1;
		this.widthScale = 128;
		this.heightScale = 128;
		this.orientation = 0;
		this.ambient = 0;
		this.contrast = 0;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lkb;B)V",
		garbageValue = "-55"
	)
	void method4470(Buffer var1) {
		while (true) {
			int var2 = var1.method5547();
			if (var2 == 0) {
				return;
			}

			this.method4468(var1, var2);
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lkb;IB)V",
		garbageValue = "0"
	)
	void method4468(Buffer var1, int var2) {
		if (var2 == 1) {
			this.archive = var1.method5549();
		} else if (var2 == 2) {
			this.sequence = var1.method5549();
		} else if (var2 == 4) {
			this.widthScale = var1.method5549();
		} else if (var2 == 5) {
			this.heightScale = var1.method5549();
		} else if (var2 == 6) {
			this.orientation = var1.method5549();
		} else if (var2 == 7) {
			this.ambient = var1.method5547();
		} else if (var2 == 8) {
			this.contrast = var1.method5547();
		} else {
			int var3;
			int var4;
			if (var2 == 40) {
				var3 = var1.method5547();
				this.recolorFrom = new short[var3];
				this.recolorTo = new short[var3];

				for (var4 = 0; var4 < var3; ++var4) {
					this.recolorFrom[var4] = (short)var1.method5549();
					this.recolorTo[var4] = (short)var1.method5549();
				}
			} else if (var2 == 41) {
				var3 = var1.method5547();
				this.retextureFrom = new short[var3];
				this.retextureTo = new short[var3];

				for (var4 = 0; var4 < var3; ++var4) {
					this.retextureFrom[var4] = (short)var1.method5549();
					this.retextureTo[var4] = (short)var1.method5549();
				}
			}
		}

	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(II)Lel;",
		garbageValue = "-1314564797"
	)
	public final Model method4467(int var1) {
		Model var2 = (Model)SpotAnimationDefinition_cachedModels.method3418((long)this.id);
		if (var2 == null) {
			ModelData var3 = ModelData.method2865(SpotAnimationDefinition_modelArchive, this.archive, 0);
			if (var3 == null) {
				return null;
			}

			int var4;
			if (this.recolorFrom != null) {
				for (var4 = 0; var4 < this.recolorFrom.length; ++var4) {
					var3.method2879(this.recolorFrom[var4], this.recolorTo[var4]);
				}
			}

			if (this.retextureFrom != null) {
				for (var4 = 0; var4 < this.retextureFrom.length; ++var4) {
					var3.method2931(this.retextureFrom[var4], this.retextureTo[var4]);
				}
			}

			var2 = var3.method2886(this.ambient + 64, this.contrast + 850, -30, -50, -30);
			SpotAnimationDefinition_cachedModels.method3424(var2, (long)this.id);
		}

		Model var5;
		if (this.sequence != -1 && var1 != -1) {
			var5 = method4478(this.sequence).method4819(var2, var1, (byte)66);
		} else {
			var5 = var2.method3013(true);
		}

		if (this.widthScale != 128 || this.heightScale != 128) {
			var5.method2967(this.widthScale, this.heightScale, this.widthScale);
		}

		if (this.orientation != 0) {
			if (this.orientation == 90) {
				var5.method2969();
			}

			if (this.orientation == 180) {
				var5.method2969();
				var5.method2969();
			}

			if (this.orientation == 270) {
				var5.method2969();
				var5.method2969();
				var5.method2969();
			}
		}

		return var5;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(II)Ljc;",
		garbageValue = "1792244593"
	)
	public static SequenceDefinition method4478(int var0) {
		SequenceDefinition var1 = (SequenceDefinition)SequenceDefinition.SequenceDefinition_cached.method3418((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = Varcs.SequenceDefinition_archive.method4224(12, var0, (byte)-51);
			var1 = new SequenceDefinition();
			if (var2 != null) {
				var1.method4817(new Buffer(var2));
			}

			var1.method4847();
			SequenceDefinition.SequenceDefinition_cached.method3424(var1, (long)var0);
			return var1;
		}
	}
}
