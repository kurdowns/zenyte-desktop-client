package com.zenyte.desktop;

import net.runelite.api.events.VolumeChanged;
import net.runelite.api.events.VolumeChanged.Type;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
public class class22 {
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "32517854"
	)
	public static final boolean method255() {
		synchronized(KeyHandler.KeyHandler_instance) {
			if (KeyHandler.field434 == KeyHandler.field436) {
				return false;
			} else {
				class3.field16 = KeyHandler.field414[KeyHandler.field434];
				Coord.field2531 = KeyHandler.field424[KeyHandler.field434];
				KeyHandler.field434 = KeyHandler.field434 + 1 & 127;
				return true;
			}
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lkj;IB)Z",
		garbageValue = "127"
	)
	static boolean method257(PacketBuffer var0, int var1) {
		int var2 = var0.method5495(2);
		int var3;
		int var4;
		int var7;
		int var8;
		int var9;
		int var10;
		if (var2 == 0) {
			if (var0.method5495(1) != 0) {
				method257(var0, var1);
			}

			var3 = var0.method5495(13);
			var4 = var0.method5495(13);
			boolean var12 = var0.method5495(1) == 1;
			if (var12) {
				Players.Players_pendingUpdateIndices[++Players.Players_pendingUpdateCount - 1] = var1;
			}

			if (Client.players[var1] != null) {
				throw new RuntimeException();
			} else {
				Player var10000 = Client.players[var1] = new Player();
				Client.cachedPlayersChanged(var1);
				Player var6 = var10000;
				var6.index = var1;
				if (Players.field1269[var1] != null) {
					var6.method1330(Players.field1269[var1], -1516590648);
				}

				var6.orientation = Players.Players_orientations[var1];
				var6.targetIndex = Players.Players_targetIndices[var1];
				var6.interactingChanged(-1);
				var7 = Players.Players_regions[var1];
				var8 = var7 >> 28;
				var9 = var7 >> 14 & 255;
				var10 = var7 & 255;
				var6.pathTraversed[0] = Players.field1273[var1];
				var6.plane = (byte)var8;
				var6.method1379((var9 << 13) + var3 - class69.baseX * 731242929, (var10 << 13) + var4 - class89.baseY * 1825982697);
				var6.field670 = false;
				return true;
			}
		} else if (var2 == 1) {
			var3 = var0.method5495(2);
			var4 = Players.Players_regions[var1];
			Players.Players_regions[var1] = (var4 & 268435455) + (((var4 >> 28) + var3 & 3) << 28);
			return false;
		} else {
			int var5;
			int var11;
			if (var2 == 2) {
				var3 = var0.method5495(5);
				var4 = var3 >> 3;
				var5 = var3 & 7;
				var11 = Players.Players_regions[var1];
				var7 = (var11 >> 28) + var4 & 3;
				var8 = var11 >> 14 & 255;
				var9 = var11 & 255;
				if (var5 == 0) {
					--var8;
					--var9;
				}

				if (var5 == 1) {
					--var9;
				}

				if (var5 == 2) {
					++var8;
					--var9;
				}

				if (var5 == 3) {
					--var8;
				}

				if (var5 == 4) {
					++var8;
				}

				if (var5 == 5) {
					--var8;
					++var9;
				}

				if (var5 == 6) {
					++var9;
				}

				if (var5 == 7) {
					++var8;
					++var9;
				}

				Players.Players_regions[var1] = (var8 << 14) + var9 + (var7 << 28);
				return false;
			} else {
				var3 = var0.method5495(18);
				var4 = var3 >> 16;
				var5 = var3 >> 8 & 255;
				var11 = var3 & 255;
				var7 = Players.Players_regions[var1];
				var8 = (var7 >> 28) + var4 & 3;
				var9 = var5 + (var7 >> 14) & 255;
				var10 = var7 + var11 & 255;
				Players.Players_regions[var1] = (var9 << 14) + var10 + (var8 << 28);
				return false;
			}
		}
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "257352924"
	)
	static int method258(int var0, class101 var1, boolean var2) {
		int var3;
		if (var0 == 4200) {
			var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = AbstractWorldMapData.method373(var3).name;
			return 1;
		} else {
			int var4;
			ItemDefinition var5;
			if (var0 == 4201) {
				Interpreter.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
				var5 = AbstractWorldMapData.method373(var3);
				if (var4 >= 1 && var4 <= 5 && var5.groundActions[var4 - 1] != null) {
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var5.groundActions[var4 - 1];
				} else {
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else if (var0 == 4202) {
				Interpreter.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
				var5 = AbstractWorldMapData.method373(var3);
				if (var4 >= 1 && var4 <= 5 && var5.inventoryActions[var4 - 1] != null) {
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var5.inventoryActions[var4 - 1];
				} else {
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else if (var0 == 4203) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = AbstractWorldMapData.method373(var3).price;
				return 1;
			} else if (var0 == 4204) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = AbstractWorldMapData.method373(var3).isStackable == 1 ? 1 : 0;
				return 1;
			} else {
				ItemDefinition var6;
				if (var0 == 4205) {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					var6 = AbstractWorldMapData.method373(var3);
					if (var6.noteTemplate == -1 && var6.note >= 0) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6.note;
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3;
					}

					return 1;
				} else if (var0 == 4206) {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					var6 = AbstractWorldMapData.method373(var3);
					if (var6.noteTemplate >= 0 && var6.note >= 0) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6.note;
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3;
					}

					return 1;
				} else if (var0 == 4207) {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = AbstractWorldMapData.method373(var3).isMembersOnly ? 1 : 0;
					return 1;
				} else if (var0 == 4208) {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					var6 = AbstractWorldMapData.method373(var3);
					if (var6.placeholderTemplate == -1 && var6.placeholder >= 0) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6.placeholder;
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3;
					}

					return 1;
				} else if (var0 == 4209) {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					var6 = AbstractWorldMapData.method373(var3);
					if (var6.placeholderTemplate >= 0 && var6.placeholder >= 0) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6.placeholder;
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3;
					}

					return 1;
				} else if (var0 == 4210) {
					String var7 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
					var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					class69.method1276(var7, var4 == 1, (byte)-93);
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = TextureProvider.foundItemIdCount;
					return 1;
				} else if (var0 != 4211) {
					if (var0 == 4212) {
						AbstractWorldMapIcon.foundItemIndex = 0;
						return 1;
					} else {
						return 2;
					}
				} else {
					if (WorldMapEvent.foundItemIds != null && AbstractWorldMapIcon.foundItemIndex < TextureProvider.foundItemIdCount) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = WorldMapEvent.foundItemIds[++AbstractWorldMapIcon.foundItemIndex - 1] & '\uffff';
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
					}

					return 1;
				}
			}
		}
	}

	@ObfuscatedName("fz")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "16256"
	)
	static final void method252() {
		for (int var0 = 0; var0 < Client.soundEffectCount; ++var0) {
			int var10002 = Client.queuedSoundEffectDelays[var0]--;
			if (Client.queuedSoundEffectDelays[var0] >= -10) {
				SoundEffect var9 = Client.soundEffects[var0];
				if (var9 == null) {
					Object var10000 = null;
					var9 = SoundEffect.method2455(FontName.archive4, Client.soundEffectIds[var0], 0);
					if (var9 == null) {
						continue;
					}

					int[] var13 = Client.queuedSoundEffectDelays;
					var13[var0] += var9.method2457();
					Client.soundEffects[var0] = var9;
				}

				if (Client.queuedSoundEffectDelays[var0] < 0) {
					int var2;
					if (Client.soundLocations[var0] != 0) {
						int var3 = (Client.soundLocations[var0] & 255) * 128;
						int var4 = Client.soundLocations[var0] >> 16 & 255;
						int var5 = var4 * 128 + 64 - ByteArrayPool.localPlayer.x;
						if (var5 < 0) {
							var5 = -var5;
						}

						int var6 = Client.soundLocations[var0] >> 8 & 255;
						int var7 = var6 * 128 + 64 - ByteArrayPool.localPlayer.y;
						if (var7 < 0) {
							var7 = -var7;
						}

						int var8 = var7 + var5 - 128;
						if (var8 > var3) {
							Client.queuedSoundEffectDelays[var0] = -100;
							continue;
						}

						if (var8 < 0) {
							var8 = 0;
						}

						var2 = (var3 - var8) * Client.areaSoundEffectVolume / var3;
					} else {
						var2 = Client.soundEffectVolume;
					}

					if (var2 > 0) {
						RawSound var10 = var9.method2452().method2494(class25.decimator);
						RawPcmStream var11 = RawPcmStream.method2640(var10, 100, var2);
						var11.method2675(Client.queuedSoundEffectLoops[var0] - 1);
						Tiles.pcmStreamMixer.method2385(var11);
					}

					Client.queuedSoundEffectDelays[var0] = -100;
				}
			} else {
				--Client.soundEffectCount;
				Client.queuedSoundEffectCountChanged(-1);

				for (int var1 = var0; var1 < Client.soundEffectCount; ++var1) {
					Client.soundEffectIds[var1] = Client.soundEffectIds[var1 + 1];
					Client.soundEffects[var1] = Client.soundEffects[var1 + 1];
					Client.queuedSoundEffectLoops[var1] = Client.queuedSoundEffectLoops[var1 + 1];
					Client.queuedSoundEffectDelays[var1] = Client.queuedSoundEffectDelays[var1 + 1];
					Client.soundLocations[var1] = Client.soundLocations[var1 + 1];
				}

				--var0;
			}
		}

		if (Client.field915) {
			boolean var12;
			if (class206.field2406 != 0) {
				var12 = true;
			} else {
				var12 = class206.midiPcmStream.method3882();
			}

			if (!var12) {
				if (Client.musicVolume != 0 && Client.currentTrackGroupId != -1) {
					ApproximateRouteStrategy.method1321(AbstractWorldMapIcon.archive6, Client.currentTrackGroupId, 0, Client.musicVolume, false);
				}

				Client.field915 = false;
			}
		}

	}

	@ObfuscatedName("gm")
	@ObfuscatedSignature(
		signature = "(Lbi;ZI)V",
		garbageValue = "-591154231"
	)
	static void method254(Player var0, boolean var1) {
		if (var0 != null && var0.vmethod2118() && !var0.isHidden) {
			var0.isUnanimated = false;
			if ((Client.isLowDetail && Players.Players_count > 50 || Players.Players_count > 200) && var1 && var0.movementSequence == var0.idleSequence) {
				var0.isUnanimated = true;
			}

			int var2 = var0.x >> 7;
			int var3 = var0.y >> 7;
			if (var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
				long var4 = IsaacCipher.method6337(0, 0, 0, false, var0.index);
				if (var0.model0 != null && Client.cycle >= var0.animationCycleStart && Client.cycle < var0.animationCycleEnd) {
					var0.isUnanimated = false;
					var0.tileHeight = class277.method5013(var0.x, var0.y, ScriptEvent.Client_plane);
					var0.playerCycle = Client.cycle;
					GrandExchangeOfferWorldComparator.scene.method3175(ScriptEvent.Client_plane, var0.x, var0.y, var0.tileHeight, 60, var0, var0.rotation, var4, var0.field659, var0.field660, var0.field661, var0.field664);
				} else {
					if ((var0.x & 127) == 64 && (var0.y & 127) == 64) {
						if (Client.tileLastDrawnActor[var2][var3] == Client.viewportDrawCount) {
							return;
						}

						Client.tileLastDrawnActor[var2][var3] = Client.viewportDrawCount;
					}

					var0.tileHeight = class277.method5013(var0.x, var0.y, ScriptEvent.Client_plane);
					var0.playerCycle = Client.cycle;
					GrandExchangeOfferWorldComparator.scene.method3174(ScriptEvent.Client_plane, var0.x, var0.y, var0.tileHeight, 60, var0, var0.rotation, var4, var0.isWalking);
				}
			}
		}

	}

	@ObfuscatedName("jr")
	static final void method253(int var0, byte var1) {
		Client.copy$changeGameOptions(var0, var1);
		int var2 = WorldMapSection1.client.getVarpDefinition(var0).getType();
		if (var2 == 3 || var2 == 4 || var2 == 10) {
			VolumeChanged var3 = new VolumeChanged(var2 == 3 ? Type.MUSIC : (var2 == 4 ? Type.EFFECTS : Type.AREA));
			WorldMapSection1.client.getCallbacks().post(VolumeChanged.class, var3);
		}

	}

	@ObfuscatedName("lb")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "2"
	)
	static void method256(int var0) {
		Client.oculusOrbState = var0;
	}
}
