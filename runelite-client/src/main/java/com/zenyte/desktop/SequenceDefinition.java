package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSFrames;
import net.runelite.rs.api.RSModel;
import net.runelite.rs.api.RSSequenceDefinition;

@ObfuscatedName("jc")
public class SequenceDefinition extends DualNode implements RSSequenceDefinition {
	@ObfuscatedName("nq")
	@ObfuscatedGetter(
		intValue = -1632730769
	)
	static int field3526;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	static EvictingDualNodeHashTable SequenceDefinition_cached;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	static EvictingDualNodeHashTable SequenceDefinition_cachedFrames;
	@ObfuscatedName("o")
	public static String field3527;
	@ObfuscatedName("v")
	public int[] frameIds;
	@ObfuscatedName("q")
	int[] chatFrameIds;
	@ObfuscatedName("z")
	public int[] frameLengths;
	@ObfuscatedName("t")
	public int[] soundEffects;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -750244517
	)
	public int frameCount;
	@ObfuscatedName("s")
	int[] field3517;
	@ObfuscatedName("p")
	public boolean field3518;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1293261891
	)
	public int field3519;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1094123699
	)
	public int shield;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -17515833
	)
	public int weapon;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1281885521
	)
	public int field3522;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1964972701
	)
	public int field3520;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -457337523
	)
	public int field3524;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -789911207
	)
	public int field3525;

	static {
		SequenceDefinition_cached = new EvictingDualNodeHashTable(64);
		SequenceDefinition_cachedFrames = new EvictingDualNodeHashTable(100);
	}

	SequenceDefinition() {
		this.frameCount = -1;
		this.field3518 = false;
		this.field3519 = 5;
		this.shield = -1;
		this.weapon = -1;
		this.field3522 = 99;
		this.field3520 = -1;
		this.field3524 = -1;
		this.field3525 = 2;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lkb;I)V",
		garbageValue = "-1859351730"
	)
	void method4817(Buffer var1) {
		while (true) {
			int var2 = var1.method5547();
			if (var2 == 0) {
				return;
			}

			this.method4818(var1, var2);
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lkb;II)V",
		garbageValue = "-951623720"
	)
	void method4818(Buffer var1, int var2) {
		int var3;
		int var4;
		if (var2 == 1) {
			var3 = var1.method5549();
			this.frameLengths = new int[var3];

			for (var4 = 0; var4 < var3; ++var4) {
				this.frameLengths[var4] = var1.method5549();
			}

			this.frameIds = new int[var3];

			for (var4 = 0; var4 < var3; ++var4) {
				this.frameIds[var4] = var1.method5549();
			}

			for (var4 = 0; var4 < var3; ++var4) {
				this.frameIds[var4] += var1.method5549() << 16;
			}
		} else if (var2 == 2) {
			this.frameCount = var1.method5549();
		} else if (var2 == 3) {
			var3 = var1.method5547();
			this.field3517 = new int[var3 + 1];

			for (var4 = 0; var4 < var3; ++var4) {
				this.field3517[var4] = var1.method5547();
			}

			this.field3517[var3] = 9999999;
		} else if (var2 == 4) {
			this.field3518 = true;
		} else if (var2 == 5) {
			this.field3519 = var1.method5547();
		} else if (var2 == 6) {
			this.shield = var1.method5549();
		} else if (var2 == 7) {
			this.weapon = var1.method5549();
		} else if (var2 == 8) {
			this.field3522 = var1.method5547();
		} else if (var2 == 9) {
			this.field3520 = var1.method5547();
		} else if (var2 == 10) {
			this.field3524 = var1.method5547();
		} else if (var2 == 11) {
			this.field3525 = var1.method5547();
		} else if (var2 == 12) {
			var3 = var1.method5547();
			this.chatFrameIds = new int[var3];

			for (var4 = 0; var4 < var3; ++var4) {
				this.chatFrameIds[var4] = var1.method5549();
			}

			for (var4 = 0; var4 < var3; ++var4) {
				this.chatFrameIds[var4] += var1.method5549() << 16;
			}
		} else if (var2 == 13) {
			var3 = var1.method5547();
			this.soundEffects = new int[var3];

			for (var4 = 0; var4 < var3; ++var4) {
				this.soundEffects[var4] = var1.method5674();
			}
		}

	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-18"
	)
	void method4847() {
		if (this.field3520 == -1) {
			if (this.field3517 != null) {
				this.field3520 = 2;
			} else {
				this.field3520 = 0;
			}
		}

		if (this.field3524 == -1) {
			if (this.field3517 != null) {
				this.field3524 = 2;
			} else {
				this.field3524 = 0;
			}
		}

	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lel;II)Lel;"
	)
	public Model method4820(Model var1, int var2, int var3) {
		if (var2 >= 0) {
			return (Model)this.copy$transformActorModel(var1, var2, var3);
		} else {
			int var4 = var2 ^ Integer.MIN_VALUE;
			int var5 = var4 >> 16;
			var2 = var4 & 65535;
			int var6 = var2 + 1;
			if (var6 >= this.getFrameIDs().length) {
				var6 = -1;
			}

			int[] var7 = this.getFrameIDs();
			int var8 = var7[var2];
			RSFrames var9 = WorldMapSection1.client.getFrames(var8 >> 16);
			int var10 = var8 & 65535;
			int var11 = -1;
			RSFrames var12 = null;
			if (var6 != -1) {
				int var13 = var7[var6];
				var12 = WorldMapSection1.client.getFrames(var13 >> 16);
				var11 = var13 & 65535;
			}

			if (var9 == null) {
				return (Model)var1.toSharedModel(true);
			} else {
				RSModel var14 = var1.toSharedModel(!var9.getFrames()[var10].isShowing());
				var14.interpolateFrames(var9, var10, var12, var11, var5, this.getFrameLenths()[var2]);
				return (Model)var14;
			}
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lel;III)Lel;"
	)
	Model method4821(Model var1, int var2, int var3, int var4) {
		if (var2 >= 0) {
			return (Model)this.copy$transformObjectModel(var1, var2, var3, var4);
		} else {
			int var5 = var2 ^ Integer.MIN_VALUE;
			int var6 = var5 >> 16;
			var2 = var5 & 65535;
			int var7 = var2 + 1;
			if (var7 >= this.getFrameIDs().length) {
				var7 = -1;
			}

			int[] var8 = this.getFrameIDs();
			int var9 = var8[var2];
			RSFrames var10 = WorldMapSection1.client.getFrames(var9 >> 16);
			int var11 = var9 & 65535;
			int var12 = -1;
			RSFrames var13 = null;
			if (var7 != -1) {
				int var14 = var8[var7];
				var13 = WorldMapSection1.client.getFrames(var14 >> 16);
				var12 = var14 & 65535;
			}

			if (var10 == null) {
				return (Model)var1.toSharedModel(true);
			} else {
				RSModel var15 = var1.toSharedModel(!var10.getFrames()[var11].isShowing());
				var3 &= 3;
				if (var3 == 1) {
					var15.rotateY270Ccw();
				} else if (var3 == 2) {
					var15.rotateY180Ccw();
				} else if (var3 == 3) {
					var15.rotateY90Ccw();
				}

				var15.interpolateFrames(var10, var11, var13, var12, var6, this.getFrameLenths()[var2]);
				if (var3 == 1) {
					var15.rotateY90Ccw();
				} else if (var3 == 2) {
					var15.rotateY180Ccw();
				} else if (var3 == 3) {
					var15.rotateY270Ccw();
				}

				return (Model)var15;
			}
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lel;IB)Lel;"
	)
	Model method4819(Model var1, int var2, byte var3) {
		if (var2 >= 0) {
			return (Model)this.copy$transformSpotAnimationModel(var1, var2, var3);
		} else {
			int var4 = var2 ^ Integer.MIN_VALUE;
			int var5 = var4 >> 16;
			var2 = var4 & 65535;
			int var6 = var2 + 1;
			if (var6 >= this.getFrameIDs().length) {
				var6 = -1;
			}

			int[] var7 = this.getFrameIDs();
			int var8 = var7[var2];
			RSFrames var9 = WorldMapSection1.client.getFrames(var8 >> 16);
			int var10 = var8 & 65535;
			int var11 = -1;
			RSFrames var12 = null;
			if (var6 != -1) {
				int var13 = var7[var6];
				var12 = WorldMapSection1.client.getFrames(var13 >> 16);
				var11 = var13 & 65535;
			}

			if (var9 == null) {
				return (Model)var1.toSharedSpotAnimModel(true);
			} else {
				RSModel var14 = var1.toSharedSpotAnimModel(!var9.getFrames()[var10].isShowing());
				var14.interpolateFrames(var9, var10, var12, var11, var5, this.getFrameLenths()[var2]);
				return (Model)var14;
			}
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lel;ILjc;IB)Lel;"
	)
	public Model method4823(Model var1, int var2, SequenceDefinition var3, int var4, byte var5) {
		int var6;
		if (var2 < 0) {
			var6 = var2 ^ Integer.MIN_VALUE;
			var2 = var6 & 65535;
		}

		if (var4 < 0) {
			var6 = var4 ^ Integer.MIN_VALUE;
			var4 = var6 & 65535;
		}

		return (Model)this.copy$applyTransformations(var1, var2, var3, var4, var5);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lel;IB)Lel;"
	)
	public Model method4848(Model var1, int var2, byte var3) {
		if (var2 >= 0) {
			return (Model)this.copy$transformWidgetModel(var1, var2, var3);
		} else {
			int var4 = var2 ^ Integer.MIN_VALUE;
			int var5 = var4 >> 16;
			var2 = var4 & 65535;
			int var6 = var2 + 1;
			if (var6 >= this.getFrameIDs().length) {
				var6 = -1;
			}

			int[] var7 = this.getFrameIDs();
			int var8 = var7[var2];
			RSFrames var9 = WorldMapSection1.client.getFrames(var8 >> 16);
			int var10 = var8 & 65535;
			int var11 = -1;
			RSFrames var12 = null;
			if (var6 != -1) {
				int var13 = var7[var6];
				var12 = WorldMapSection1.client.getFrames(var13 >> 16);
				var11 = var13 & 65535;
			}

			if (var9 == null) {
				return (Model)var1.toSharedModel(true);
			} else {
				RSFrames var18 = null;
				int var14 = 0;
				if (this.getChatFrameIds() != null && var2 < this.getChatFrameIds().length) {
					int var15 = this.getChatFrameIds()[var2];
					var18 = WorldMapSection1.client.getFrames(var15 >> 16);
					var14 = var15 & 65535;
				}

				if (var18 != null && var14 != 65535) {
					RSFrames var21 = null;
					int var16 = -1;
					if (var6 != -1 && var6 < this.getChatFrameIds().length) {
						int var17 = this.getChatFrameIds()[var6];
						var21 = WorldMapSection1.client.getFrames(var17 >> 16);
						var16 = var17 & 65535;
					}

					if (var16 == 65535) {
						var21 = null;
					}

					RSModel var20 = var1.toSharedModel(!var9.getFrames()[var10].isShowing() & !var18.getFrames()[var14].isShowing());
					var20.interpolateFrames(var9, var10, var12, var11, var5, this.getFrameLenths()[var2]);
					var20.interpolateFrames(var18, var14, var21, var16, var5, this.getFrameLenths()[var2]);
					return (Model)var20;
				} else {
					RSModel var19 = var1.toSharedModel(!var9.getFrames()[var10].isShowing());
					var19.interpolateFrames(var9, var10, var12, var11, var5, this.getFrameLenths()[var2]);
					return (Model)var19;
				}
			}
		}
	}

	@ObfuscatedSignature(
		signature = "(Lel;III)Lel;"
	)
	public Model copy$transformObjectModel(Model var1, int var2, int var3, int var4) {
		var2 = this.frameIds[var2];
		Frames var5 = GrandExchangeEvents.method154(var2 >> 16);
		var2 &= 65535;
		if (var5 == null) {
			return var1.method2971(true);
		} else {
			Model var6 = var1.method2971(!var5.method3368(var2));
			var3 &= 3;
			if (var3 == 1) {
				var6.method2964();
			} else if (var3 == 2) {
				var6.method2956();
			} else if (var3 == 3) {
				var6.method2969();
			}

			var6.method2959(var5, var2);
			if (var3 == 1) {
				var6.method2969();
			} else if (var3 == 2) {
				var6.method2956();
			} else if (var3 == 3) {
				var6.method2964();
			}

			return var6;
		}
	}

	@ObfuscatedSignature(
		signature = "(Lel;IB)Lel;"
	)
	public Model copy$transformSpotAnimationModel(Model var1, int var2, byte var3) {
		var2 = this.frameIds[var2];
		Frames var4 = GrandExchangeEvents.method154(var2 >> 16);
		var2 &= 65535;
		if (var4 == null) {
			return var1.method3013(true);
		} else {
			Model var5 = var1.method3013(!var4.method3368(var2));
			var5.method2959(var4, var2);
			return var5;
		}
	}

	@ObfuscatedSignature(
		signature = "(Lel;IB)Lel;"
	)
	public Model copy$transformWidgetModel(Model var1, int var2, byte var3) {
		int var4 = this.frameIds[var2];
		Frames var5 = GrandExchangeEvents.method154(var4 >> 16);
		var4 &= 65535;
		if (var5 == null) {
			return var1.method2971(true);
		} else {
			Frames var6 = null;
			int var7 = 0;
			if (this.chatFrameIds != null && var2 < this.chatFrameIds.length) {
				var7 = this.chatFrameIds[var2];
				var6 = GrandExchangeEvents.method154(var7 >> 16);
				var7 &= 65535;
			}

			Model var8;
			if (var6 != null && var7 != 65535) {
				var8 = var1.method2971(!var5.method3368(var4) & !var6.method3368(var7));
				var8.method2959(var5, var4);
				var8.method2959(var6, var7);
				return var8;
			} else {
				var8 = var1.method2971(!var5.method3368(var4));
				var8.method2959(var5, var4);
				return var8;
			}
		}
	}

	@ObfuscatedSignature(
		signature = "(Lel;II)Lel;"
	)
	public Model copy$transformActorModel(Model var1, int var2, int var3) {
		var2 = this.frameIds[var2];
		Frames var4 = GrandExchangeEvents.method154(var2 >> 16);
		var2 &= 65535;
		if (var4 == null) {
			return var1.method2971(true);
		} else {
			Model var5 = var1.method2971(!var4.method3368(var2));
			var5.method2959(var4, var2);
			return var5;
		}
	}

	@ObfuscatedSignature(
		signature = "(Lel;ILjc;IB)Lel;"
	)
	public Model copy$applyTransformations(Model var1, int var2, SequenceDefinition var3, int var4, byte var5) {
		var2 = this.frameIds[var2];
		Frames var6 = GrandExchangeEvents.method154(var2 >> 16);
		var2 &= 65535;
		if (var6 == null) {
			return var3.method4820(var1, var4, 1747843246);
		} else {
			var4 = var3.frameIds[var4];
			Frames var7 = GrandExchangeEvents.method154(var4 >> 16);
			var4 &= 65535;
			Model var8;
			if (var7 == null) {
				var8 = var1.method2971(!var6.method3368(var2));
				var8.method2959(var6, var2);
				return var8;
			} else {
				var8 = var1.method2971(!var6.method3368(var2) & !var7.method3368(var4));
				var8.method2960(var6, var2, var7, var4, this.field3517);
				return var8;
			}
		}
	}

	public int[] getFrameIDs() {
		return this.frameIds;
	}

	public int[] getChatFrameIds() {
		return this.chatFrameIds;
	}

	public int[] getFrameLenths() {
		return this.frameLengths;
	}
}
