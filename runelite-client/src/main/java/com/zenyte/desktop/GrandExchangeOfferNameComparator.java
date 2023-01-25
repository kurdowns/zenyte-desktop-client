package com.zenyte.desktop;

import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSGrandExchangeOfferNameComparator;

@ObfuscatedName("r")
final class GrandExchangeOfferNameComparator implements Comparator, RSGrandExchangeOfferNameComparator {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lhe;"
	)
	static Widget field115;
	@ObfuscatedName("ea")
	@ObfuscatedSignature(
		signature = "Lih;"
	)
	static Archive archive15;
	@ObfuscatedName("gp")
	@ObfuscatedSignature(
		signature = "Lla;"
	)
	static Sprite redHintArrowSprite;

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Li;Li;I)I",
		garbageValue = "-1993640176"
	)
	int method233(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		return var1.method157().compareTo(var2.method157());
	}

	public int compare(Object var1, Object var2) {
		return this.method233((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lkj;ILbi;II)V",
		garbageValue = "160137381"
	)
	static final void method239(PacketBuffer var0, int var1, Player var2, int var3) {
		byte var4 = -1;
		if ((var3 & 512) != 0) {
			var2.field990 = var0.method5548();
			var2.field1017 = var0.method5548();
			var2.field972 = var0.method5581();
			var2.field1018 = var0.method5579();
			var2.field1019 = var0.method5587() + Client.cycle;
			var2.field1020 = var0.method5587() + Client.cycle;
			var2.field1021 = var0.method5549();
			if (var2.field670) {
				var2.field990 += var2.tileX;
				var2.field1017 += var2.tileY;
				var2.field972 += var2.tileX;
				var2.field1018 += var2.tileY;
				var2.pathLength = 0;
			} else {
				var2.field990 += var2.pathX[0];
				var2.field1017 += var2.pathY[0];
				var2.field972 += var2.pathX[0];
				var2.field1018 += var2.pathY[0];
				var2.pathLength = 1;
			}

			var2.field1032 = 0;
		}

		int var5;
		if ((var3 & 2048) != 0) {
			var2.spotAnimation = var0.method5586();
			var2.spotAnimationChanged(-1);
			var5 = var0.method5592();
			var2.field1033 = var5 >> 16;
			var2.field1013 = (var5 & 65535) + Client.cycle;
			var2.spotAnimationFrame = 0;
			var2.spotAnimationFrameCycle = 0;
			if (var2.field1013 > Client.cycle) {
				var2.spotAnimationFrame = -1;
			}

			if (var2.spotAnimation == 65535) {
				var2.spotAnimation = -1;
				var2.spotAnimationChanged(-1);
			}
		}

		int var6;
		if ((var3 & 128) != 0) {
			var5 = var0.method5537();
			if (var5 == 65535) {
				var5 = -1;
			}

			var6 = var0.method5577();
			GrandExchangeOfferWorldComparator.method149(var2, var5, var6);
		}

		if ((var3 & 2) != 0) {
			var5 = var0.method5547();
			byte[] var13 = new byte[var5];
			Buffer var7 = new Buffer(var13);
			var0.method5595(var13, 0, var5);
			Players.field1269[var1] = var7;
			var2.method1330(var7, -1398428480);
		}

		if ((var3 & 32) != 0) {
			var2.overheadText = var0.method5667();
			var2.overheadTextChanged(-1);
			if (var2.overheadText.charAt(0) == '~') {
				var2.overheadText = var2.overheadText.substring(1);
				var2.overheadTextChanged(-1);
				Skeleton.method3161(2, var2.username.method5238(), var2.overheadText);
			} else if (var2 == ByteArrayPool.localPlayer) {
				Skeleton.method3161(2, var2.username.method5238(), var2.overheadText);
			}

			var2.isAutoChatting = false;
			var2.overheadTextColor = 0;
			var2.overheadTextEffect = 0;
			var2.overheadTextCyclesRemaining = 150;
		}

		if ((var3 & 4) != 0) {
			var2.targetIndex = var0.method5587();
			var2.interactingChanged(-1);
			if (var2.targetIndex == 65535) {
				var2.targetIndex = -1;
				var2.interactingChanged(-1);
			}
		}

		if ((var3 & 4096) != 0) {
			Players.field1273[var1] = var0.method5580();
		}

		int var8;
		int var9;
		int var12;
		if ((var3 & 1) != 0) {
			var5 = var0.method5586();
			PlayerType var18 = (PlayerType)GrandExchangeEvent.method159(InterfaceParent.method1278(), var0.method5577());
			boolean var14 = var0.method5577() == 1;
			var8 = var0.method5576();
			var9 = var0.offset;
			if (var2.username != null && var2.appearance != null) {
				boolean var10 = false;
				if (var18.isUser && Projectile.friendSystem.method1944(var2.username)) {
					var10 = true;
				}

				if (!var10 && Client.field794 == 0 && !var2.isHidden) {
					Players.field1268.offset = 0;
					var0.method5620(Players.field1268.array, 0, var8);
					Players.field1268.offset = 0;
					String var11 = AbstractFont.method5388(Decimator.method2622(JagexCache.method3563(Players.field1268)));
					var2.overheadText = var11.trim();
					var2.overheadTextChanged(-1);
					var2.overheadTextColor = var5 >> 8;
					var2.overheadTextEffect = var5 & 255;
					var2.overheadTextCyclesRemaining = 150;
					var2.isAutoChatting = var14;
					var2.field988 = var2 != ByteArrayPool.localPlayer && var18.isUser && "" != Client.field814 && var11.toLowerCase().indexOf(Client.field814) == -1;
					if (var18.isPrivileged) {
						var12 = var14 ? 91 : 1;
					} else {
						var12 = var14 ? 90 : 2;
					}

					if (var18.modIcon != -1) {
						Skeleton.method3161(var12, class1.method21(var18.modIcon) + var2.username.method5238(), var11);
					} else {
						Skeleton.method3161(var12, var2.username.method5238(), var11);
					}
				}
			}

			var0.offset = var9 + var8;
		}

		if ((var3 & 256) != 0) {
			for (var5 = 0; var5 < 3; ++var5) {
				var2.actions[var5] = var0.method5667();
			}
		}

		if ((var3 & 16) != 0) {
			var5 = var0.method5547();
			int var15;
			int var17;
			int var19;
			if (var5 > 0) {
				for (var6 = 0; var6 < var5; ++var6) {
					var8 = -1;
					var9 = -1;
					var17 = -1;
					var19 = var0.method5561();
					if (var19 == 32767) {
						var19 = var0.method5561();
						var9 = var0.method5561();
						var8 = var0.method5561();
						var17 = var0.method5561();
					} else if (var19 != 32766) {
						var9 = var0.method5561();
					} else {
						var19 = -1;
					}

					var15 = var0.method5561();
					var2.method1845(var19, var9, var8, var17, Client.cycle, var15);
				}
			}

			var6 = var0.method5547();
			if (var6 > 0) {
				for (var19 = 0; var19 < var6; ++var19) {
					var8 = var0.method5561();
					var9 = var0.method5561();
					if (var9 != 32767) {
						var17 = var0.method5561();
						var15 = var0.method5547();
						var12 = var9 > 0 ? var0.method5577() : var15;
						var2.method1831(var8, Client.cycle, var9, var17, var15, var12);
					} else {
						var2.method1832(var8);
					}
				}
			}
		}

		if ((var3 & 1024) != 0) {
			var4 = var0.method5580();
		}

		if ((var3 & 8) != 0) {
			var2.field1015 = var0.method5586();
			if (var2.pathLength == 0) {
				var2.orientation = var2.field1015;
				var2.field1015 = -1;
			}
		}

		if (var2.field670) {
			if (var4 == 127) {
				var2.method1379(var2.tileX, var2.tileY);
			} else {
				byte var16;
				if (var4 != -1) {
					var16 = var4;
				} else {
					var16 = Players.field1273[var1];
				}

				var2.method1339(var2.tileX, var2.tileY, var16);
			}
		}

	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(ILce;ZB)I",
		garbageValue = "75"
	)
	static int method238(int var0, class101 var1, boolean var2) {
		if (var0 == 6500) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Language.method3729() ? 1 : 0;
			return 1;
		} else {
			World var3;
			if (var0 == 6501) {
				var3 = WorldMapDecoration.method437();
				if (var3 != null) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.id;
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.properties;
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.activity;
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.location;
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.population;
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.host;
				} else {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else if (var0 == 6502) {
				var3 = MouseHandler.method1184();
				if (var3 != null) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.id;
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.properties;
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.activity;
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.location;
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.population;
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.host;
				} else {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else {
				World var4;
				int var5;
				int var7;
				if (var0 == 6506) {
					var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					var4 = null;

					for (var5 = 0; var5 < World.World_count; ++var5) {
						if (var7 == UserComparator2.World_worlds[var5].id) {
							var4 = UserComparator2.World_worlds[var5];
							break;
						}
					}

					if (var4 != null) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4.id;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4.properties;
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var4.activity;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4.location;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4.population;
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var4.host;
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == 6507) {
					Interpreter.Interpreter_intStackSize -= 4;
					var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
					boolean var10 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1] == 1;
					var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
					boolean var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3] == 1;
					Player.method1384(var7, var10, var5, var6);
					return 1;
				} else if (var0 != 6511) {
					if (var0 == 6512) {
						Client.followerOpsLowPriority = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						return 1;
					} else {
						int var8;
						ParamDefinition var9;
						if (var0 == 6513) {
							Interpreter.Interpreter_intStackSize -= 2;
							var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
							var8 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
							var9 = IgnoreList.method5110(var8);
							if (var9.method4550()) {
								Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = class237.method4201(var7).method4769(var8, var9.defaultStr);
							} else {
								Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class237.method4201(var7).method4771(var8, var9.defaultInt);
							}

							return 1;
						} else if (var0 == 6514) {
							Interpreter.Interpreter_intStackSize -= 2;
							var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
							var8 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
							var9 = IgnoreList.method5110(var8);
							if (var9.method4550()) {
								Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = WorldMapSection2.method435(var7).method4680(var8, var9.defaultStr);
							} else {
								Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = WorldMapSection2.method435(var7).method4667(var8, var9.defaultInt);
							}

							return 1;
						} else if (var0 == 6515) {
							Interpreter.Interpreter_intStackSize -= 2;
							var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
							var8 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
							var9 = IgnoreList.method5110(var8);
							if (var9.method4550()) {
								Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = AbstractWorldMapData.method373(var7).method4702(var8, var9.defaultStr);
							} else {
								Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = AbstractWorldMapData.method373(var7).method4704(var8, var9.defaultInt);
							}

							return 1;
						} else if (var0 == 6516) {
							Interpreter.Interpreter_intStackSize -= 2;
							var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
							var8 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
							var9 = IgnoreList.method5110(var8);
							if (var9.method4550()) {
								Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = FloorOverlayDefinition.method4801(var7).method4562(var8, var9.defaultStr);
							} else {
								Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = FloorOverlayDefinition.method4801(var7).method4564(var8, var9.defaultInt);
							}

							return 1;
						} else if (var0 == 6518) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.onMobile ? 1 : 0;
							return 1;
						} else if (var0 == 6519) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.clientType & 3;
							return 1;
						} else if (var0 == 6520) {
							return 1;
						} else if (var0 == 6521) {
							return 1;
						} else if (var0 == 6522) {
							--Interpreter.Interpreter_stringStackSize;
							--Interpreter.Interpreter_intStackSize;
							return 1;
						} else if (var0 == 6523) {
							--Interpreter.Interpreter_stringStackSize;
							--Interpreter.Interpreter_intStackSize;
							return 1;
						} else if (var0 == 6524) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
							return 1;
						} else if (var0 == 6525) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
							return 1;
						} else if (var0 == 6526) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
							return 1;
						} else {
							return 2;
						}
					}
				} else {
					var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					if (var7 >= 0 && var7 < World.World_count) {
						var4 = UserComparator2.World_worlds[var7];
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4.id;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4.properties;
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var4.activity;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4.location;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4.population;
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var4.host;
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				}
			}
		}
	}

	@ObfuscatedName("hs")
	@ObfuscatedSignature(
		signature = "(IIZI)V",
		garbageValue = "-1462729636"
	)
	static final void method237(int var0, int var1, boolean var2) {
		if (!var2 || var0 != class69.field585 || MouseHandler.field529 != var1) {
			class69.field585 = var0;
			MouseHandler.field529 = var1;
			MouseRecorder.method1293(25);
			AbstractByteArrayCopier.method4004("Loading - please wait.", true);
			int var3 = class69.baseX * 731242929;
			int var4 = class89.baseY * 1825982697;
			class69.baseX = (var0 - 6) * 413022856;
			class89.baseY = (var1 - 6) * 1679325896;
			int var5 = class69.baseX * 731242929 - var3;
			int var6 = class89.baseY * 1825982697 - var4;
			var3 = class69.baseX * 731242929;
			var4 = class89.baseY * 1825982697;

			int var7;
			int var9;
			int[] var10000;
			for (var7 = 0; var7 < 32768; ++var7) {
				NPC var8 = Client.npcs[var7];
				if (var8 != null) {
					for (var9 = 0; var9 < 10; ++var9) {
						var10000 = var8.pathX;
						var10000[var9] -= var5;
						var10000 = var8.pathY;
						var10000[var9] -= var6;
					}

					var8.x -= var5 * 128;
					var8.y -= var6 * 128;
				}
			}

			for (var7 = 0; var7 < 2048; ++var7) {
				Player var21 = Client.players[var7];
				if (var21 != null) {
					for (var9 = 0; var9 < 10; ++var9) {
						var10000 = var21.pathX;
						var10000[var9] -= var5;
						var10000 = var21.pathY;
						var10000[var9] -= var6;
					}

					var21.x -= var5 * 128;
					var21.y -= var6 * 128;
				}
			}

			byte var20 = 0;
			byte var18 = 104;
			byte var22 = 1;
			if (var5 < 0) {
				var20 = 103;
				var18 = -1;
				var22 = -1;
			}

			byte var10 = 0;
			byte var11 = 104;
			byte var12 = 1;
			if (var6 < 0) {
				var10 = 103;
				var11 = -1;
				var12 = -1;
			}

			int var14;
			for (int var13 = var20; var18 != var13; var13 += var22) {
				for (var14 = var10; var14 != var11; var14 += var12) {
					int var15 = var5 + var13;
					int var16 = var14 + var6;

					for (int var17 = 0; var17 < 4; ++var17) {
						if (var15 >= 0 && var16 >= 0 && var15 < 104 && var16 < 104) {
							Client.groundItems[var17][var13][var14] = Client.groundItems[var17][var15][var16];
						} else {
							Client.groundItems[var17][var13][var14] = null;
						}
					}
				}
			}

			for (PendingSpawn var19 = (PendingSpawn)Client.pendingSpawns.method4931(); var19 != null; var19 = (PendingSpawn)Client.pendingSpawns.method4949()) {
				var19.x -= var5;
				var19.y -= var6;
				if (var19.x < 0 || var19.y < 0 || var19.x >= 104 || var19.y >= 104) {
					var19.method3657();
				}
			}

			if (Client.destinationX != 0) {
				Client.destinationX -= var5;
				Client.destinationY -= var6;
			}

			Client.soundEffectCount = 0;
			Client.queuedSoundEffectCountChanged(-1);
			Client.isCameraLocked = false;
			WorldMapRectangle.cameraX -= var5 << 7;
			class200.cameraZ -= var6 << 7;
			SoundSystem.oculusOrbFocalPointX -= var5 << 7;
			ServerPacket.oculusOrbFocalPointY -= var6 << 7;
			Client.field695 = -1;
			Client.graphicsObjects.method4925();
			Client.projectiles.method4925();

			for (var14 = 0; var14 < 4; ++var14) {
				Client.collisionMaps[var14].method3618();
			}

		}
	}
}
