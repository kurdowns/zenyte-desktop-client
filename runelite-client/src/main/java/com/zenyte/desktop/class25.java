package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
public class class25 {
	@ObfuscatedName("qt")
	@ObfuscatedSignature(
		signature = "Ldx;"
	)
	static Decimator decimator;
	@ObfuscatedName("et")
	@ObfuscatedSignature(
		signature = "Lih;"
	)
	static Archive archive20;

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(II)Lio;",
		garbageValue = "-897330887"
	)
	public static WorldMapElement method279(int var0) {
		return var0 >= 0 && var0 < WorldMapElement.WorldMapElement_cached.length && WorldMapElement.WorldMapElement_cached[var0] != null ? WorldMapElement.WorldMapElement_cached[var0] : new WorldMapElement(var0);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-1245361009"
	)
	public static boolean method280(int var0) {
		return var0 == 10 || var0 == 11 || var0 == 12 || var0 == 13 || var0 == 14 || var0 == 15 || var0 == 16 || var0 == 17;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1853542199"
	)
	public static void method277() {
		class105.reflectionChecks = new IterableNodeDeque();
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lkj;IS)V",
		garbageValue = "10549"
	)
	static void method278(PacketBuffer var0, int var1) {
		boolean var2 = var0.method5495(1) == 1;
		if (var2) {
			Players.Players_pendingUpdateIndices[++Players.Players_pendingUpdateCount - 1] = var1;
		}

		int var3 = var0.method5495(2);
		Player var4 = Client.players[var1];
		if (var3 == 0) {
			if (var2) {
				var4.field670 = false;
			} else if (Client.localPlayerIndex == var1) {
				throw new RuntimeException();
			} else {
				Players.Players_regions[var1] = (var4.plane << 28) + (class69.baseX * 731242929 + var4.pathX[0] >> 13 << 14) + (var4.pathY[0] + class89.baseY * 1825982697 >> 13);
				if (var4.field1015 != -1) {
					Players.Players_orientations[var1] = var4.field1015;
				} else {
					Players.Players_orientations[var1] = var4.orientation;
				}

				Players.Players_targetIndices[var1] = var4.targetIndex;
				Client.players[var1] = null;
				Client.cachedPlayersChanged(var1);
				if (var0.method5495(1) != 0) {
					class22.method257(var0, var1);
				}

			}
		} else {
			int var5;
			int var6;
			int var7;
			if (var3 == 1) {
				var5 = var0.method5495(3);
				var6 = var4.pathX[0];
				var7 = var4.pathY[0];
				if (var5 == 0) {
					--var6;
					--var7;
				} else if (var5 == 1) {
					--var7;
				} else if (var5 == 2) {
					++var6;
					--var7;
				} else if (var5 == 3) {
					--var6;
				} else if (var5 == 4) {
					++var6;
				} else if (var5 == 5) {
					--var6;
					++var7;
				} else if (var5 == 6) {
					++var7;
				} else if (var5 == 7) {
					++var6;
					++var7;
				}

				if (Client.localPlayerIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
					if (var2) {
						var4.field670 = true;
						var4.tileX = var6;
						var4.tileY = var7;
					} else {
						var4.field670 = false;
						var4.method1339(var6, var7, Players.field1273[var1]);
					}
				} else {
					var4.method1379(var6, var7);
					var4.field670 = false;
				}

			} else if (var3 == 2) {
				var5 = var0.method5495(4);
				var6 = var4.pathX[0];
				var7 = var4.pathY[0];
				if (var5 == 0) {
					var6 -= 2;
					var7 -= 2;
				} else if (var5 == 1) {
					--var6;
					var7 -= 2;
				} else if (var5 == 2) {
					var7 -= 2;
				} else if (var5 == 3) {
					++var6;
					var7 -= 2;
				} else if (var5 == 4) {
					var6 += 2;
					var7 -= 2;
				} else if (var5 == 5) {
					var6 -= 2;
					--var7;
				} else if (var5 == 6) {
					var6 += 2;
					--var7;
				} else if (var5 == 7) {
					var6 -= 2;
				} else if (var5 == 8) {
					var6 += 2;
				} else if (var5 == 9) {
					var6 -= 2;
					++var7;
				} else if (var5 == 10) {
					var6 += 2;
					++var7;
				} else if (var5 == 11) {
					var6 -= 2;
					var7 += 2;
				} else if (var5 == 12) {
					--var6;
					var7 += 2;
				} else if (var5 == 13) {
					var7 += 2;
				} else if (var5 == 14) {
					++var6;
					var7 += 2;
				} else if (var5 == 15) {
					var6 += 2;
					var7 += 2;
				}

				if (Client.localPlayerIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
					var4.method1379(var6, var7);
					var4.field670 = false;
				} else if (var2) {
					var4.field670 = true;
					var4.tileX = var6;
					var4.tileY = var7;
				} else {
					var4.field670 = false;
					var4.method1339(var6, var7, Players.field1273[var1]);
				}

			} else {
				var5 = var0.method5495(1);
				int var8;
				int var9;
				int var10;
				int var11;
				if (var5 == 0) {
					var6 = var0.method5495(12);
					var7 = var6 >> 10;
					var8 = var6 >> 5 & 31;
					if (var8 > 15) {
						var8 -= 32;
					}

					var9 = var6 & 31;
					if (var9 > 15) {
						var9 -= 32;
					}

					var10 = var8 + var4.pathX[0];
					var11 = var9 + var4.pathY[0];
					if (Client.localPlayerIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
						if (var2) {
							var4.field670 = true;
							var4.tileX = var10;
							var4.tileY = var11;
						} else {
							var4.field670 = false;
							var4.method1339(var10, var11, Players.field1273[var1]);
						}
					} else {
						var4.method1379(var10, var11);
						var4.field670 = false;
					}

					var4.plane = (byte)(var7 + var4.plane & 3);
					if (Client.localPlayerIndex == var1) {
						ScriptEvent.Client_plane = var4.plane;
					}

				} else {
					var6 = var0.method5495(30);
					var7 = var6 >> 28;
					var8 = var6 >> 14 & 16383;
					var9 = var6 & 16383;
					var10 = (var8 + var4.pathX[0] + class69.baseX * 731242929 & 16383) - class69.baseX * 731242929;
					var11 = (var9 + class89.baseY * 1825982697 + var4.pathY[0] & 16383) - class89.baseY * 1825982697;
					if (Client.localPlayerIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
						if (var2) {
							var4.field670 = true;
							var4.tileX = var10;
							var4.tileY = var11;
						} else {
							var4.field670 = false;
							var4.method1339(var10, var11, Players.field1273[var1]);
						}
					} else {
						var4.method1379(var10, var11);
						var4.field670 = false;
					}

					var4.plane = (byte)(var7 + var4.plane & 3);
					if (Client.localPlayerIndex == var1) {
						ScriptEvent.Client_plane = var4.plane;
					}

				}
			}
		}
	}
}
