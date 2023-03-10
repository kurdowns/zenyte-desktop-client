package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSUserComparator9;

@ObfuscatedName("fd")
public class UserComparator9 extends AbstractUserComparator implements RSUserComparator9 {
	@ObfuscatedName("eo")
	@ObfuscatedSignature(
		signature = "Lih;"
	)
	static Archive archive18;
	@ObfuscatedName("x")
	final boolean reversed;

	public UserComparator9(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lke;Lke;I)I",
		garbageValue = "-54374446"
	)
	int method3485(Buddy var1, Buddy var2) {
		if (Client.worldId == var1.world && var2.world == Client.worldId) {
			return this.reversed ? var1.method5068().method5240(var2.method5068()) : var2.method5068().method5240(var1.method5068());
		} else {
			return this.method5087(var1, var2);
		}
	}

	public int compare(Object var1, Object var2) {
		return this.method3485((Buddy)var1, (Buddy)var2);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(II)Ljn;",
		garbageValue = "-1711395255"
	)
	public static FloorOverlayDefinition method3477(int var0) {
		FloorOverlayDefinition var1 = (FloorOverlayDefinition)FloorOverlayDefinition.FloorOverlayDefinition_cached.method3418((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = FloorOverlayDefinition.FloorOverlayDefinition_archive.method4224(4, var0, (byte)-43);
			var1 = new FloorOverlayDefinition();
			if (var2 != null) {
				var1.method4799(new Buffer(var2), var0);
			}

			var1.method4798();
			FloorOverlayDefinition.FloorOverlayDefinition_cached.method3424(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(B)Lgq;",
		garbageValue = "-87"
	)
	public static PacketBufferNode method3482() {
		return PacketBufferNode.PacketBufferNode_packetBufferNodeCount == 0 ? new PacketBufferNode() : PacketBufferNode.PacketBufferNode_packetBufferNodes[--PacketBufferNode.PacketBufferNode_packetBufferNodeCount];
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1233574382"
	)
	static void method3484() {
		Tiles.Tiles_minPlane = 99;
		Tiles.field538 = new byte[4][104][104];
		class348.field4061 = new byte[4][104][104];
		Tiles.field539 = new byte[4][104][104];
		Tiles.field540 = new byte[4][104][104];
		WorldMapSection3.field404 = new int[4][105][105];
		SoundCache.field1462 = new byte[4][105][105];
		Tiles.field545 = new int[105][105];
		GrandExchangeOfferAgeComparator.Tiles_hue = new int[104];
		UserComparator6.Tiles_saturation = new int[104];
		StructDefinition.Tiles_lightness = new int[104];
		Tiles.Tiles_hueMultiplier = new int[104];
		FriendSystem.field1086 = new int[104];
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "([Lch;II[I[II)V",
		garbageValue = "943885059"
	)
	static void method3483(World[] var0, int var1, int var2, int[] var3, int[] var4) {
		if (var1 < var2) {
			int var5 = var1 - 1;
			int var6 = var2 + 1;
			int var7 = (var2 + var1) / 2;
			World var8 = var0[var7];
			var0[var7] = var0[var1];
			var0[var1] = var8;

			while (var5 < var6) {
				boolean var9 = true;

				int var10;
				int var11;
				int var12;
				do {
					--var6;

					for (var10 = 0; var10 < 4; ++var10) {
						if (var3[var10] == 2) {
							var11 = var0[var6].index;
							var12 = var8.index;
						} else if (var3[var10] == 1) {
							var11 = var0[var6].population;
							var12 = var8.population;
							if (var11 == -1 && var4[var10] == 1) {
								var11 = 2001;
							}

							if (var12 == -1 && var4[var10] == 1) {
								var12 = 2001;
							}
						} else if (var3[var10] == 3) {
							var11 = var0[var6].method1886() ? 1 : 0;
							var12 = var8.method1886() ? 1 : 0;
						} else {
							var11 = var0[var6].id;
							var12 = var8.id;
						}

						if (var11 != var12) {
							if ((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
								var9 = false;
							}
							break;
						}

						if (var10 == 3) {
							var9 = false;
						}
					}
				} while(var9);

				var9 = true;

				do {
					++var5;

					for (var10 = 0; var10 < 4; ++var10) {
						if (var3[var10] == 2) {
							var11 = var0[var5].index;
							var12 = var8.index;
						} else if (var3[var10] == 1) {
							var11 = var0[var5].population;
							var12 = var8.population;
							if (var11 == -1 && var4[var10] == 1) {
								var11 = 2001;
							}

							if (var12 == -1 && var4[var10] == 1) {
								var12 = 2001;
							}
						} else if (var3[var10] == 3) {
							var11 = var0[var5].method1886() ? 1 : 0;
							var12 = var8.method1886() ? 1 : 0;
						} else {
							var11 = var0[var5].id;
							var12 = var8.id;
						}

						if (var11 != var12) {
							if ((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
								var9 = false;
							}
							break;
						}

						if (var10 == 3) {
							var9 = false;
						}
					}
				} while(var9);

				if (var5 < var6) {
					World var13 = var0[var5];
					var0[var5] = var0[var6];
					var0[var6] = var13;
				}
			}

			method3483(var0, var1, var6, var3, var4);
			method3483(var0, var6 + 1, var2, var3, var4);
		}

	}

	@ObfuscatedName("v")
	public static int method3486(long var0) {
		return (int)(var0 >>> 7 & 127L);
	}
}
