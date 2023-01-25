package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSKitDefinition;

@ObfuscatedName("ib")
public class KitDefinition extends DualNode implements RSKitDefinition {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	static AbstractArchive KitDefinition_archive;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	static AbstractArchive KitDefinition_modelsArchive;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1436575363
	)
	public static int KitDefinition_fileCount;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	static EvictingDualNodeHashTable KitDefinition_cached;
	@ObfuscatedName("bq")
	@ObfuscatedGetter(
		intValue = -724929863
	)
	static int field3271;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1932693097
	)
	public int bodypartID;
	@ObfuscatedName("v")
	int[] models2;
	@ObfuscatedName("q")
	short[] recolorFrom;
	@ObfuscatedName("z")
	short[] recolorTo;
	@ObfuscatedName("t")
	short[] retextureFrom;
	@ObfuscatedName("e")
	short[] retextureTo;
	@ObfuscatedName("s")
	int[] models;
	@ObfuscatedName("p")
	public boolean nonSelectable;

	static {
		KitDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	KitDefinition() {
		this.bodypartID = -1;
		this.models = new int[]{-1, -1, -1, -1, -1};
		this.nonSelectable = false;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lkb;I)V",
		garbageValue = "1401612766"
	)
	void method4495(Buffer var1) {
		while (true) {
			int var2 = var1.method5547();
			if (var2 == 0) {
				return;
			}

			this.method4496(var1, var2);
		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Lkb;IB)V",
		garbageValue = "53"
	)
	void method4496(Buffer var1, int var2) {
		if (var2 == 1) {
			this.bodypartID = var1.method5547();
		} else {
			int var3;
			int var4;
			if (var2 == 2) {
				var3 = var1.method5547();
				this.models2 = new int[var3];

				for (var4 = 0; var4 < var3; ++var4) {
					this.models2[var4] = var1.method5549();
				}
			} else if (var2 == 3) {
				this.nonSelectable = true;
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
			} else if (var2 >= 60 && var2 < 70) {
				this.models[var2 - 60] = var1.method5549();
			}
		}

	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "1"
	)
	public boolean method4497() {
		if (this.models2 == null) {
			return true;
		} else {
			boolean var1 = true;

			for (int var2 = 0; var2 < this.models2.length; ++var2) {
				if (!KitDefinition_modelsArchive.method4238(this.models2[var2], 0)) {
					var1 = false;
				}
			}

			return var1;
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)Lea;",
		garbageValue = "-898584179"
	)
	public ModelData method4498() {
		if (this.models2 == null) {
			return null;
		} else {
			ModelData[] var1 = new ModelData[this.models2.length];

			for (int var2 = 0; var2 < this.models2.length; ++var2) {
				var1[var2] = ModelData.method2865(KitDefinition_modelsArchive, this.models2[var2], 0);
			}

			ModelData var4;
			if (var1.length == 1) {
				var4 = var1[0];
			} else {
				var4 = new ModelData(var1, var1.length);
			}

			int var3;
			if (this.recolorFrom != null) {
				for (var3 = 0; var3 < this.recolorFrom.length; ++var3) {
					var4.method2879(this.recolorFrom[var3], this.recolorTo[var3]);
				}
			}

			if (this.retextureFrom != null) {
				for (var3 = 0; var3 < this.retextureFrom.length; ++var3) {
					var4.method2931(this.retextureFrom[var3], this.retextureTo[var3]);
				}
			}

			return var4;
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1856166332"
	)
	public boolean method4499() {
		boolean var1 = true;

		for (int var2 = 0; var2 < 5; ++var2) {
			if (this.models[var2] != -1 && !KitDefinition_modelsArchive.method4238(this.models[var2], 0)) {
				var1 = false;
			}
		}

		return var1;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)Lea;",
		garbageValue = "2142658297"
	)
	public ModelData method4500() {
		ModelData[] var1 = new ModelData[5];
		int var2 = 0;

		for (int var3 = 0; var3 < 5; ++var3) {
			if (this.models[var3] != -1) {
				var1[var2++] = ModelData.method2865(KitDefinition_modelsArchive, this.models[var3], 0);
			}
		}

		ModelData var5 = new ModelData(var1, var2);
		int var4;
		if (this.recolorFrom != null) {
			for (var4 = 0; var4 < this.recolorFrom.length; ++var4) {
				var5.method2879(this.recolorFrom[var4], this.recolorTo[var4]);
			}
		}

		if (this.retextureFrom != null) {
			for (var4 = 0; var4 < this.retextureFrom.length; ++var4) {
				var5.method2931(this.retextureFrom[var4], this.retextureTo[var4]);
			}
		}

		return var5;
	}

	@ObfuscatedName("jp")
	@ObfuscatedSignature(
		signature = "(Lhe;B)Lhe;",
		garbageValue = "-1"
	)
	static Widget method4514(Widget var0) {
		Widget var1 = GrandExchangeOfferTotalQuantityComparator.method181(var0);
		if (var1 == null) {
			var1 = var0.parent;
		}

		return var1;
	}
}
