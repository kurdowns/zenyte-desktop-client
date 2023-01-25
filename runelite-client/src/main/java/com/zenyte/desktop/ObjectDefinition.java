package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSObjectDefinition;

@ObfuscatedName("jw")
public class ObjectDefinition extends DualNode implements RSObjectDefinition {
	@ObfuscatedName("x")
	static boolean ObjectDefinition_isLowDetail;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	static AbstractArchive ObjectDefinition_archive;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	static AbstractArchive ObjectDefinition_modelsArchive;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	static EvictingDualNodeHashTable ObjectDefinition_cached;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	public static EvictingDualNodeHashTable ObjectDefinition_cachedModelData;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	static EvictingDualNodeHashTable ObjectDefinition_cachedEntities;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	static EvictingDualNodeHashTable ObjectDefinition_cachedModels;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "[Lea;"
	)
	static ModelData[] field3376;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1540034327
	)
	public int id;
	@ObfuscatedName("e")
	int[] modelIds;
	@ObfuscatedName("s")
	int[] models;
	@ObfuscatedName("p")
	public String name;
	@ObfuscatedName("n")
	short[] recolorFrom;
	@ObfuscatedName("u")
	short[] recolorTo;
	@ObfuscatedName("h")
	short[] retextureFrom;
	@ObfuscatedName("g")
	short[] retextureTo;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 907984177
	)
	public int sizeX;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 840243271
	)
	public int sizeY;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 969965047
	)
	public int interactType;
	@ObfuscatedName("l")
	public boolean boolean1;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -1367724563
	)
	public int int1;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -1336003431
	)
	int clipType;
	@ObfuscatedName("c")
	boolean nonFlatShading;
	@ObfuscatedName("j")
	public boolean modelClipped;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -450300581
	)
	public int animationId;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -84642935
	)
	public int int2;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = -1160377515
	)
	int ambient;
	@ObfuscatedName("an")
	@ObfuscatedGetter(
		intValue = -1766971271
	)
	int contrast;
	@ObfuscatedName("ai")
	public String[] actions;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = -481571835
	)
	public int mapIconId;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = -337227603
	)
	public int mapSceneId;
	@ObfuscatedName("ar")
	boolean isRotated;
	@ObfuscatedName("af")
	public boolean clipped;
	@ObfuscatedName("at")
	@ObfuscatedGetter(
		intValue = -878255357
	)
	int modelSizeX;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = -344043167
	)
	int modelHeight;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = 710022213
	)
	int modelSizeY;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = 720076445
	)
	int offsetX;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = -278523345
	)
	int offsetHeight;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = 1100577685
	)
	int offsetY;
	@ObfuscatedName("aq")
	public boolean boolean2;
	@ObfuscatedName("av")
	boolean isSolid;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = -1270005767
	)
	public int int3;
	@ObfuscatedName("aa")
	public int[] transforms;
	@ObfuscatedName("ax")
	@ObfuscatedGetter(
		intValue = 1641253039
	)
	int transformVarbit;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = -948693409
	)
	int transformVarp;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		intValue = 1264376143
	)
	public int ambientSoundId;
	@ObfuscatedName("ay")
	@ObfuscatedGetter(
		intValue = -1413235621
	)
	public int int4;
	@ObfuscatedName("ad")
	@ObfuscatedGetter(
		intValue = 1914618679
	)
	public int int5;
	@ObfuscatedName("ac")
	@ObfuscatedGetter(
		intValue = -279261471
	)
	public int int6;
	@ObfuscatedName("ah")
	public int[] soundEffectIds;
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "Lln;"
	)
	IterableNodeHashTable params;

	static {
		ObjectDefinition_isLowDetail = false;
		ObjectDefinition_cached = new EvictingDualNodeHashTable(4096);
		ObjectDefinition_cachedModelData = new EvictingDualNodeHashTable(500);
		ObjectDefinition_cachedEntities = new EvictingDualNodeHashTable(30);
		ObjectDefinition_cachedModels = new EvictingDualNodeHashTable(30);
		field3376 = new ModelData[4];
	}

	ObjectDefinition() {
		this.name = "null";
		this.sizeX = 1;
		this.sizeY = 1;
		this.interactType = 2;
		this.boolean1 = true;
		this.int1 = -1;
		this.clipType = -1;
		this.nonFlatShading = false;
		this.modelClipped = false;
		this.animationId = -1;
		this.int2 = 16;
		this.ambient = 0;
		this.contrast = 0;
		this.actions = new String[5];
		this.mapIconId = -1;
		this.mapSceneId = -1;
		this.isRotated = false;
		this.clipped = true;
		this.modelSizeX = 128;
		this.modelHeight = 128;
		this.modelSizeY = 128;
		this.offsetX = 0;
		this.offsetHeight = 0;
		this.offsetY = 0;
		this.boolean2 = false;
		this.isSolid = false;
		this.int3 = -1;
		this.transformVarbit = -1;
		this.transformVarp = -1;
		this.ambientSoundId = -1;
		this.int4 = 0;
		this.int5 = 0;
		this.int6 = 0;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-720129530"
	)
	void method4634() {
		if (this.int1 == -1) {
			this.int1 = 0;
			if (this.modelIds != null && (this.models == null || this.models[0] == 10)) {
				this.int1 = 1;
			}

			for (int var1 = 0; var1 < 5; ++var1) {
				if (this.actions[var1] != null) {
					this.int1 = 1;
				}
			}
		}

		if (this.int3 == -1) {
			this.int3 = this.interactType != 0 ? 1 : 0;
		}

	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Lkb;I)V",
		garbageValue = "680070630"
	)
	void method4635(Buffer var1) {
		while (true) {
			int var2 = var1.method5547();
			if (var2 == 0) {
				return;
			}

			this.method4636(var1, var2);
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lkb;II)V",
		garbageValue = "1616364474"
	)
	void method4636(Buffer var1, int var2) {
		int var3;
		int var4;
		if (var2 == 1) {
			var3 = var1.method5547();
			if (var3 > 0) {
				if (this.modelIds != null && !ObjectDefinition_isLowDetail) {
					var1.offset += 3 * var3;
				} else {
					this.models = new int[var3];
					this.modelIds = new int[var3];

					for (var4 = 0; var4 < var3; ++var4) {
						this.modelIds[var4] = var1.method5549();
						this.models[var4] = var1.method5547();
					}
				}
			}
		} else if (var2 == 2) {
			this.name = var1.method5667();
		} else if (var2 == 5) {
			var3 = var1.method5547();
			if (var3 > 0) {
				if (this.modelIds != null && !ObjectDefinition_isLowDetail) {
					var1.offset += var3 * 2;
				} else {
					this.models = null;
					this.modelIds = new int[var3];

					for (var4 = 0; var4 < var3; ++var4) {
						this.modelIds[var4] = var1.method5549();
					}
				}
			}
		} else if (var2 == 14) {
			this.sizeX = var1.method5547();
		} else if (var2 == 15) {
			this.sizeY = var1.method5547();
		} else if (var2 == 17) {
			this.interactType = 0;
			this.boolean1 = false;
		} else if (var2 == 18) {
			this.boolean1 = false;
		} else if (var2 == 19) {
			this.int1 = var1.method5547();
		} else if (var2 == 21) {
			this.clipType = 0;
		} else if (var2 == 22) {
			this.nonFlatShading = true;
		} else if (var2 == 23) {
			this.modelClipped = true;
		} else if (var2 == 24) {
			this.animationId = var1.method5549();
			if (this.animationId == 65535) {
				this.animationId = -1;
			}
		} else if (var2 == 27) {
			this.interactType = 1;
		} else if (var2 == 28) {
			this.int2 = var1.method5547();
		} else if (var2 == 29) {
			this.ambient = var1.method5548();
		} else if (var2 == 39) {
			this.contrast = var1.method5548() * 25;
		} else if (var2 >= 30 && var2 < 35) {
			this.actions[var2 - 30] = var1.method5667();
			if (this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
				this.actions[var2 - 30] = null;
			}
		} else if (var2 == 40) {
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
		} else if (var2 == 62) {
			this.isRotated = true;
		} else if (var2 == 64) {
			this.clipped = false;
		} else if (var2 == 65) {
			this.modelSizeX = var1.method5549();
		} else if (var2 == 66) {
			this.modelHeight = var1.method5549();
		} else if (var2 == 67) {
			this.modelSizeY = var1.method5549();
		} else if (var2 == 68) {
			this.mapSceneId = var1.method5549();
		} else if (var2 == 69) {
			var1.method5547();
		} else if (var2 == 70) {
			this.offsetX = var1.method5550();
		} else if (var2 == 71) {
			this.offsetHeight = var1.method5550();
		} else if (var2 == 72) {
			this.offsetY = var1.method5550();
		} else if (var2 == 73) {
			this.boolean2 = true;
		} else if (var2 == 74) {
			this.isSolid = true;
		} else if (var2 == 75) {
			this.int3 = var1.method5547();
		} else if (var2 != 77 && var2 != 92) {
			if (var2 == 78) {
				this.ambientSoundId = var1.method5549();
				this.int4 = var1.method5547();
			} else if (var2 == 79) {
				this.int5 = var1.method5549();
				this.int6 = var1.method5549();
				this.int4 = var1.method5547();
				var3 = var1.method5547();
				this.soundEffectIds = new int[var3];

				for (var4 = 0; var4 < var3; ++var4) {
					this.soundEffectIds[var4] = var1.method5549();
				}
			} else if (var2 == 81) {
				this.clipType = var1.method5547() * 256;
			} else if (var2 == 82) {
				this.mapIconId = var1.method5549();
			} else if (var2 == 249) {
				this.params = NetCache.method4375(var1, this.params);
			}
		} else {
			this.transformVarbit = var1.method5549();
			if (this.transformVarbit == 65535) {
				this.transformVarbit = -1;
			}

			this.transformVarp = var1.method5549();
			if (this.transformVarp == 65535) {
				this.transformVarp = -1;
			}

			var3 = -1;
			if (var2 == 92) {
				var3 = var1.method5549();
				if (var3 == 65535) {
					var3 = -1;
				}
			}

			var4 = var1.method5547();
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

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "54022350"
	)
	public final boolean method4637(int var1) {
		if (this.models != null) {
			for (int var4 = 0; var4 < this.models.length; ++var4) {
				if (this.models[var4] == var1) {
					return ObjectDefinition_modelsArchive.method4238(this.modelIds[var4] & 65535, 0);
				}
			}

			return true;
		} else if (this.modelIds == null) {
			return true;
		} else if (var1 != 10) {
			return true;
		} else {
			boolean var2 = true;

			for (int var3 = 0; var3 < this.modelIds.length; ++var3) {
				var2 &= ObjectDefinition_modelsArchive.method4238(this.modelIds[var3] & 65535, 0);
			}

			return var2;
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "53"
	)
	public final boolean method4638() {
		if (this.modelIds == null) {
			return true;
		} else {
			boolean var1 = true;

			for (int var2 = 0; var2 < this.modelIds.length; ++var2) {
				var1 &= ObjectDefinition_modelsArchive.method4238(this.modelIds[var2] & 65535, 0);
			}

			return var1;
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(II[[IIIII)Lee;",
		garbageValue = "-557802915"
	)
	public final Entity method4654(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
		long var7;
		if (this.models == null) {
			var7 = (long)(var2 + (this.id << 10));
		} else {
			var7 = (long)(var2 + (var1 << 3) + (this.id << 10));
		}

		Object var9 = (Entity)ObjectDefinition_cachedEntities.method3418(var7);
		if (var9 == null) {
			ModelData var10 = this.method4652(var1, var2);
			if (var10 == null) {
				return null;
			}

			if (!this.nonFlatShading) {
				var9 = var10.method2886(this.ambient + 64, this.contrast + 768, -50, -10, -50);
			} else {
				var10.ambient = (short)(this.ambient + 64);
				var10.contrast = (short)(this.contrast + 768);
				var10.method2883();
				var9 = var10;
			}

			ObjectDefinition_cachedEntities.method3424((DualNode)var9, var7);
		}

		if (this.nonFlatShading) {
			var9 = ((ModelData)var9).method2871();
		}

		if (this.clipType >= 0) {
			if (var9 instanceof Model) {
				var9 = ((Model)var9).method2985(var3, var4, var5, var6, true, this.clipType);
			} else if (var9 instanceof ModelData) {
				var9 = ((ModelData)var9).method2872(var3, var4, var5, var6, true, this.clipType);
			}
		}

		return (Entity)var9;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(II[[IIIII)Lel;",
		garbageValue = "1873775908"
	)
	public final Model method4639(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
		long var7;
		if (this.models == null) {
			var7 = (long)(var2 + (this.id << 10));
		} else {
			var7 = (long)(var2 + (var1 << 3) + (this.id << 10));
		}

		Model var9 = (Model)ObjectDefinition_cachedModels.method3418(var7);
		if (var9 == null) {
			ModelData var10 = this.method4652(var1, var2);
			if (var10 == null) {
				return null;
			}

			var9 = var10.method2886(this.ambient + 64, this.contrast + 768, -50, -10, -50);
			ObjectDefinition_cachedModels.method3424(var9, var7);
		}

		if (this.clipType >= 0) {
			var9 = var9.method2985(var3, var4, var5, var6, true, this.clipType);
		}

		return var9;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(II[[IIIILjc;IS)Lel;",
		garbageValue = "255"
	)
	public final Model method4641(int var1, int var2, int[][] var3, int var4, int var5, int var6, SequenceDefinition var7, int var8) {
		long var9;
		if (this.models == null) {
			var9 = (long)(var2 + (this.id << 10));
		} else {
			var9 = (long)(var2 + (var1 << 3) + (this.id << 10));
		}

		Model var11 = (Model)ObjectDefinition_cachedModels.method3418(var9);
		if (var11 == null) {
			ModelData var12 = this.method4652(var1, var2);
			if (var12 == null) {
				return null;
			}

			var11 = var12.method2886(this.ambient + 64, this.contrast + 768, -50, -10, -50);
			ObjectDefinition_cachedModels.method3424(var11, var9);
		}

		if (var7 == null && this.clipType == -1) {
			return var11;
		} else {
			if (var7 != null) {
				var11 = var7.method4821(var11, var8, var2, -1535419363);
			} else {
				var11 = var11.method2971(true);
			}

			if (this.clipType >= 0) {
				var11 = var11.method2985(var3, var4, var5, var6, false, this.clipType);
			}

			return var11;
		}
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(III)Lea;",
		garbageValue = "-1299581949"
	)
	final ModelData method4652(int var1, int var2) {
		ModelData var3 = null;
		boolean var4;
		int var5;
		int var7;
		if (this.models == null) {
			if (var1 != 10) {
				return null;
			}

			if (this.modelIds == null) {
				return null;
			}

			var4 = this.isRotated;
			if (var1 == 2 && var2 > 3) {
				var4 = !var4;
			}

			var5 = this.modelIds.length;

			for (int var6 = 0; var6 < var5; ++var6) {
				var7 = this.modelIds[var6];
				if (var4) {
					var7 += 65536;
				}

				var3 = (ModelData)ObjectDefinition_cachedModelData.method3418((long)var7);
				if (var3 == null) {
					var3 = ModelData.method2865(ObjectDefinition_modelsArchive, var7 & 65535, 0);
					if (var3 == null) {
						return null;
					}

					if (var4) {
						var3.method2881();
					}

					ObjectDefinition_cachedModelData.method3424(var3, (long)var7);
				}

				if (var5 > 1) {
					field3376[var6] = var3;
				}
			}

			if (var5 > 1) {
				var3 = new ModelData(field3376, var5);
			}
		} else {
			int var9 = -1;

			for (var5 = 0; var5 < this.models.length; ++var5) {
				if (this.models[var5] == var1) {
					var9 = var5;
					break;
				}
			}

			if (var9 == -1) {
				return null;
			}

			var5 = this.modelIds[var9];
			boolean var10 = this.isRotated ^ var2 > 3;
			if (var10) {
				var5 += 65536;
			}

			var3 = (ModelData)ObjectDefinition_cachedModelData.method3418((long)var5);
			if (var3 == null) {
				var3 = ModelData.method2865(ObjectDefinition_modelsArchive, var5 & 65535, 0);
				if (var3 == null) {
					return null;
				}

				if (var10) {
					var3.method2881();
				}

				ObjectDefinition_cachedModelData.method3424(var3, (long)var5);
			}
		}

		if (this.modelSizeX == 128 && this.modelHeight == 128 && this.modelSizeY == 128) {
			var4 = false;
		} else {
			var4 = true;
		}

		boolean var11;
		if (this.offsetX == 0 && this.offsetHeight == 0 && this.offsetY == 0) {
			var11 = false;
		} else {
			var11 = true;
		}

		ModelData var8 = new ModelData(var3, var2 == 0 && !var4 && !var11, this.recolorFrom == null, this.retextureFrom == null, true);
		if (var1 == 4 && var2 > 3) {
			var8.method2877(256);
			var8.method2878(45, 0, -45);
		}

		var2 &= 3;
		if (var2 == 1) {
			var8.method2874();
		} else if (var2 == 2) {
			var8.method2875();
		} else if (var2 == 3) {
			var8.method2896();
		}

		if (this.recolorFrom != null) {
			for (var7 = 0; var7 < this.recolorFrom.length; ++var7) {
				var8.method2879(this.recolorFrom[var7], this.recolorTo[var7]);
			}
		}

		if (this.retextureFrom != null) {
			for (var7 = 0; var7 < this.retextureFrom.length; ++var7) {
				var8.method2931(this.retextureFrom[var7], this.retextureTo[var7]);
			}
		}

		if (var4) {
			var8.method2882(this.modelSizeX, this.modelHeight, this.modelSizeY);
		}

		if (var11) {
			var8.method2878(this.offsetX, this.offsetHeight, this.offsetY);
		}

		return var8;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(S)Ljw;",
		garbageValue = "128"
	)
	public final ObjectDefinition method4645() {
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

		return var2 != -1 ? WorldMapSection2.method435(var2) : null;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(IIB)I",
		garbageValue = "-99"
	)
	public int method4667(int var1, int var2) {
		IterableNodeHashTable var4 = this.params;
		int var3;
		if (var4 == null) {
			var3 = var2;
		} else {
			IntegerNode var5 = (IntegerNode)var4.method5968((long)var1);
			if (var5 == null) {
				var3 = var2;
			} else {
				var3 = var5.integer;
			}
		}

		return var3;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)Ljava/lang/String;",
		garbageValue = "-1816202472"
	)
	public String method4680(int var1, String var2) {
		return class9.method122(this.params, var1, var2);
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1998255719"
	)
	public boolean method4646() {
		if (this.transforms == null) {
			return this.ambientSoundId != -1 || this.soundEffectIds != null;
		} else {
			for (int var1 = 0; var1 < this.transforms.length; ++var1) {
				if (this.transforms[var1] != -1) {
					ObjectDefinition var2 = WorldMapSection2.method435(this.transforms[var1]);
					if (var2.ambientSoundId != -1 || var2.soundEffectIds != null) {
						return true;
					}
				}
			}

			return false;
		}
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String[] getActions() {
		return this.actions;
	}

	public int getMapIconId() {
		return this.mapIconId;
	}

	public int getMapSceneId() {
		return this.mapSceneId;
	}

	public int[] getImpostorIds() {
		return this.transforms;
	}

	public RSObjectDefinition getImpostor() {
		return this.method4645();
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "649887816"
	)
	static void method4687(boolean var0) {
		Login.Login_response1 = "";
		Login.Login_response2 = "Enter your username/email & password.";
		Login.Login_response3 = "";
		Login.loginIndex = 2;
		if (var0) {
			Login.Login_password = "";
		}

		if (Login.Login_username == null || Login.Login_username.length() <= 0) {
			if (GrandExchangeOfferOwnWorldComparator.clientPreferences.rememberedUsername != null) {
				Login.Login_username = GrandExchangeOfferOwnWorldComparator.clientPreferences.rememberedUsername;
				Client.onUsernameChanged(-1);
				Client.Login_isUsernameRemembered = true;
			} else {
				Client.Login_isUsernameRemembered = false;
			}
		}

		FontName.method5361();
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "1104732115"
	)
	static int method4686(int var0, class101 var1, boolean var2) {
		int var3;
		int var4;
		if (var0 == 4000) {
			Interpreter.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 + var4;
			return 1;
		} else if (var0 == 4001) {
			Interpreter.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 - var4;
			return 1;
		} else if (var0 == 4002) {
			Interpreter.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 * var4;
			return 1;
		} else if (var0 == 4003) {
			Interpreter.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 / var4;
			return 1;
		} else if (var0 == 4004) {
			var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (int)(Math.random() * (double)var3);
			return 1;
		} else if (var0 == 4005) {
			var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (int)(Math.random() * (double)(var3 + 1));
			return 1;
		} else if (var0 == 4006) {
			Interpreter.Interpreter_intStackSize -= 5;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			int var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
			int var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
			int var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 4];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 + (var4 - var3) * (var7 - var5) / (var6 - var5);
			return 1;
		} else if (var0 == 4007) {
			Interpreter.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 + var4 * var3 / 100;
			return 1;
		} else if (var0 == 4008) {
			Interpreter.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 | 1 << var4;
			return 1;
		} else if (var0 == 4009) {
			Interpreter.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 & -1 - (1 << var4);
			return 1;
		} else if (var0 == 4010) {
			Interpreter.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (var3 & 1 << var4) != 0 ? 1 : 0;
			return 1;
		} else if (var0 == 4011) {
			Interpreter.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 % var4;
			return 1;
		} else if (var0 == 4012) {
			Interpreter.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			if (var3 == 0) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
			} else {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (int)Math.pow((double)var3, (double)var4);
			}

			return 1;
		} else if (var0 == 4013) {
			Interpreter.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			if (var3 == 0) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
				return 1;
			} else {
				switch(var4) {
				case 0:
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Integer.MAX_VALUE;
					break;
				case 1:
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3;
					break;
				case 2:
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (int)Math.sqrt((double)var3);
					break;
				case 3:
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (int)Math.cbrt((double)var3);
					break;
				case 4:
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (int)Math.sqrt(Math.sqrt((double)var3));
					break;
				default:
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (int)Math.pow((double)var3, 1.0D / (double)var4);
				}

				return 1;
			}
		} else if (var0 == 4014) {
			Interpreter.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 & var4;
			return 1;
		} else if (var0 == 4015) {
			Interpreter.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 | var4;
			return 1;
		} else if (var0 == 4018) {
			Interpreter.Interpreter_intStackSize -= 3;
			long var9 = (long)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			long var11 = (long)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			long var13 = (long)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (int)(var13 * var9 / var11);
			return 1;
		} else {
			return 2;
		}
	}
}
