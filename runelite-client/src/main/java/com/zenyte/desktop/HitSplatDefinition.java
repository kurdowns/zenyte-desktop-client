package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSHitSplatDefinition;

@ObfuscatedName("jv")
public class HitSplatDefinition extends DualNode implements RSHitSplatDefinition {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	public static AbstractArchive HitSplatDefinition_archive;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	public static AbstractArchive field3322;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	public static EvictingDualNodeHashTable HitSplatDefinition_cached;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	public static EvictingDualNodeHashTable HitSplatDefinition_cachedSprites;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	public static EvictingDualNodeHashTable HitSplatDefinition_cachedFonts;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1275511307
	)
	int fontId;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1688289147
	)
	public int textColor;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 500240173
	)
	public int field3329;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -1934317107
	)
	int field3330;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -26542295
	)
	int field3331;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -907663429
	)
	int field3332;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1874324581
	)
	int field3333;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1914060719
	)
	public int field3338;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 56695995
	)
	public int field3341;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -990470317
	)
	public int field3334;
	@ObfuscatedName("o")
	String field3337;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1652547133
	)
	public int field3327;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -6083753
	)
	public int field3339;
	@ObfuscatedName("y")
	public int[] transforms;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 752219759
	)
	int transformVarbit;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = -250584565
	)
	int transformVarp;

	static {
		HitSplatDefinition_cached = new EvictingDualNodeHashTable(64);
		HitSplatDefinition_cachedSprites = new EvictingDualNodeHashTable(64);
		HitSplatDefinition_cachedFonts = new EvictingDualNodeHashTable(20);
	}

	HitSplatDefinition() {
		this.fontId = -1;
		this.textColor = 16777215;
		this.field3329 = 70;
		this.field3330 = -1;
		this.field3331 = -1;
		this.field3332 = -1;
		this.field3333 = -1;
		this.field3338 = 0;
		this.field3341 = 0;
		this.field3334 = -1;
		this.field3337 = "";
		this.field3327 = -1;
		this.field3339 = 0;
		this.transformVarbit = -1;
		this.transformVarp = -1;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lkb;I)V",
		garbageValue = "1621555289"
	)
	void method4602(Buffer var1) {
		while (true) {
			int var2 = var1.method5547();
			if (var2 == 0) {
				return;
			}

			this.method4603(var1, var2);
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lkb;II)V",
		garbageValue = "575571509"
	)
	void method4603(Buffer var1, int var2) {
		if (var2 == 1) {
			this.fontId = var1.method5564();
		} else if (var2 == 2) {
			this.textColor = var1.method5674();
		} else if (var2 == 3) {
			this.field3330 = var1.method5564();
		} else if (var2 == 4) {
			this.field3332 = var1.method5564();
		} else if (var2 == 5) {
			this.field3331 = var1.method5564();
		} else if (var2 == 6) {
			this.field3333 = var1.method5564();
		} else if (var2 == 7) {
			this.field3338 = var1.method5550();
		} else if (var2 == 8) {
			this.field3337 = var1.method5557();
		} else if (var2 == 9) {
			this.field3329 = var1.method5549();
		} else if (var2 == 10) {
			this.field3341 = var1.method5550();
		} else if (var2 == 11) {
			this.field3334 = 0;
		} else if (var2 == 12) {
			this.field3327 = var1.method5547();
		} else if (var2 == 13) {
			this.field3339 = var1.method5550();
		} else if (var2 == 14) {
			this.field3334 = var1.method5549();
		} else if (var2 == 17 || var2 == 18) {
			this.transformVarbit = var1.method5549();
			if (this.transformVarbit == 65535) {
				this.transformVarbit = -1;
			}

			this.transformVarp = var1.method5549();
			if (this.transformVarp == 65535) {
				this.transformVarp = -1;
			}

			int var3 = -1;
			if (var2 == 18) {
				var3 = var1.method5549();
				if (var3 == 65535) {
					var3 = -1;
				}
			}

			int var4 = var1.method5547();
			this.transforms = new int[var4 + 2];

			for (int var5 = 0; var5 <= var4; ++var5) {
				this.transforms[var5] = var1.method5549();
				if (this.transforms[var5] == 65535) {
					this.transforms[var5] = -1;
				}
			}

			this.transforms[var4 + 1] = var3;
		}

	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)Ljv;",
		garbageValue = "-951570117"
	)
	public final HitSplatDefinition method4604() {
		int var1 = -1;
		if (this.transformVarbit != -1) {
			var1 = Projectile.method2197(this.transformVarbit);
		} else if (this.transformVarp != -1) {
			var1 = Varps.Varps_main[this.transformVarp];
		}

		int var2;
		if (var1 >= 0 && var1 < this.transforms.length - 1) {
			var2 = this.transforms[var1];
		} else {
			var2 = this.transforms[this.transforms.length - 1];
		}

		return var2 != -1 ? GrandExchangeOfferUnitPriceComparator.method213(var2) : null;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(II)Ljava/lang/String;",
		garbageValue = "-940233797"
	)
	public String method4605(int var1) {
		String var2 = this.field3337;

		while (true) {
			int var3 = var2.indexOf("%1");
			if (var3 < 0) {
				return var2;
			}

			var2 = var2.substring(0, var3) + class280.method5016(var1, false) + var2.substring(var3 + 2);
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)Lla;",
		garbageValue = "1656176054"
	)
	public Sprite method4618() {
		if (this.field3330 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.method3418((long)this.field3330);
			if (var1 != null) {
				return var1;
			} else {
				var1 = MusicPatchNode2.method3752(field3322, this.field3330, 0, 273345835);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.method3424(var1, (long)this.field3330);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)Lla;",
		garbageValue = "-743591767"
	)
	public Sprite method4607() {
		if (this.field3331 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.method3418((long)this.field3331);
			if (var1 != null) {
				return var1;
			} else {
				var1 = MusicPatchNode2.method3752(field3322, this.field3331, 0, 273345835);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.method3424(var1, (long)this.field3331);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)Lla;",
		garbageValue = "-1442192880"
	)
	public Sprite method4608() {
		if (this.field3332 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.method3418((long)this.field3332);
			if (var1 != null) {
				return var1;
			} else {
				var1 = MusicPatchNode2.method3752(field3322, this.field3332, 0, 273345835);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.method3424(var1, (long)this.field3332);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)Lla;",
		garbageValue = "-2137932181"
	)
	public Sprite method4609() {
		if (this.field3333 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.method3418((long)this.field3333);
			if (var1 != null) {
				return var1;
			} else {
				var1 = MusicPatchNode2.method3752(field3322, this.field3333, 0, 273345835);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.method3424(var1, (long)this.field3333);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)Lkx;",
		garbageValue = "607832420"
	)
	public Font method4612() {
		if (this.fontId == -1) {
			return null;
		} else {
			Font var1 = (Font)HitSplatDefinition_cachedFonts.method3418((long)this.fontId);
			if (var1 != null) {
				return var1;
			} else {
				AbstractArchive var3 = field3322;
				AbstractArchive var4 = class296.HitSplatDefinition_fontsArchive;
				int var5 = this.fontId;
				Font var2;
				if (!UserComparator7.method3502(var3, var5, 0)) {
					var2 = null;
				} else {
					var2 = VertexNormal.method3080(var4.method4224(var5, 0, (byte)-116));
				}

				if (var2 != null) {
					HitSplatDefinition_cachedFonts.method3424(var2, (long)this.fontId);
				}

				return var2;
			}
		}
	}
}
