package com.zenyte.desktop;

import java.util.Date;
import java.util.LinkedList;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSAbstractWorldMapData;

@ObfuscatedName("ab")
public abstract class AbstractWorldMapData implements RSAbstractWorldMapData {
	@ObfuscatedName("qb")
	@ObfuscatedSignature(
		signature = "Ldw;"
	)
	static PcmPlayer pcmPlayer1;
	@ObfuscatedName("c")
	public static String userHomeDirectory;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1424511881
	)
	int regionXLow;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -338405967
	)
	int regionYLow;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -407468573
	)
	int regionX;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -62405571
	)
	int regionY;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 594626733
	)
	int minPlane;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 275280081
	)
	int planes;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1377406919
	)
	int groupId;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -687693039
	)
	int fileId;
	@ObfuscatedName("t")
	short[][][] floorUnderlayIds;
	@ObfuscatedName("e")
	short[][][] floorOverlayIds;
	@ObfuscatedName("s")
	byte[][][] field205;
	@ObfuscatedName("p")
	byte[][][] field206;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "[[[[Lal;"
	)
	WorldMapDecoration[][][][] decorations;
	@ObfuscatedName("u")
	boolean field210;
	@ObfuscatedName("h")
	boolean field209;

	AbstractWorldMapData() {
		this.groupId = -1;
		this.fileId = -1;
		new LinkedList();
		this.field210 = false;
		this.field209 = false;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lkb;B)V",
		garbageValue = "-78"
	)
	abstract void vmethod806(Buffer var1);

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-2034466824"
	)
	boolean method370() {
		return this.field210 && this.field209;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Liy;I)V",
		garbageValue = "-1013927348"
	)
	void method352(AbstractArchive var1) {
		if (!this.method370()) {
			byte[] var2 = var1.method4224(this.groupId, this.fileId, (byte)-108);
			if (var2 != null) {
				this.vmethod806(new Buffer(var2));
				this.field210 = true;
				this.field209 = true;
			}

		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "778691024"
	)
	void method360() {
		this.floorUnderlayIds = null;
		this.floorOverlayIds = null;
		this.field205 = null;
		this.field206 = null;
		this.decorations = null;
		this.field210 = false;
		this.field209 = false;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IILkb;B)V",
		garbageValue = "20"
	)
	void method354(int var1, int var2, Buffer var3) {
		int var4 = var3.method5547();
		if (var4 != 0) {
			if ((var4 & 1) != 0) {
				this.method355(var1, var2, var3, var4);
			} else {
				this.method372(var1, var2, var3, var4);
			}

		}
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(IILkb;IB)V",
		garbageValue = "-123"
	)
	void method355(int var1, int var2, Buffer var3, int var4) {
		boolean var5 = (var4 & 2) != 0;
		if (var5) {
			this.floorOverlayIds[0][var1][var2] = (short)var3.method5547();
		}

		this.floorUnderlayIds[0][var1][var2] = (short)var3.method5547();
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IILkb;II)V",
		garbageValue = "-1501964087"
	)
	void method372(int var1, int var2, Buffer var3, int var4) {
		int var5 = ((var4 & 24) >> 3) + 1;
		boolean var6 = (var4 & 2) != 0;
		boolean var7 = (var4 & 4) != 0;
		this.floorUnderlayIds[0][var1][var2] = (short)var3.method5547();
		int var8;
		int var9;
		int var11;
		if (var6) {
			var8 = var3.method5547();

			for (var9 = 0; var9 < var8; ++var9) {
				int var10 = var3.method5547();
				if (var10 != 0) {
					this.floorOverlayIds[var9][var1][var2] = (short)var10;
					var11 = var3.method5547();
					this.field205[var9][var1][var2] = (byte)(var11 >> 2);
					this.field206[var9][var1][var2] = (byte)(var11 & 3);
				}
			}
		}

		if (var7) {
			for (var8 = 0; var8 < var5; ++var8) {
				var9 = var3.method5547();
				if (var9 != 0) {
					WorldMapDecoration[] var14 = this.decorations[var8][var1][var2] = new WorldMapDecoration[var9];

					for (var11 = 0; var11 < var9; ++var11) {
						int var12 = var3.method5564();
						int var13 = var3.method5547();
						var14[var11] = new WorldMapDecoration(var12, var13 >> 2, var13 & 3);
					}
				}
			}
		}

	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1491010463"
	)
	int method358() {
		return this.regionX;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1765071550"
	)
	int method359() {
		return this.regionY;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IB)Ljx;",
		garbageValue = "57"
	)
	public static ItemDefinition method373(int var0) {
		ItemDefinition var1 = (ItemDefinition)ItemDefinition.ItemDefinition_cached.method3418((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = PrivateChatMode.ItemDefinition_archive.method4224(10, var0, (byte)-127);
			var1 = new ItemDefinition();
			var1.id = var0;
			if (var2 != null) {
				var1.method4703(new Buffer(var2));
			}

			var1.method4742();
			if (var1.noteTemplate != -1) {
				var1.method4739(method373(var1.noteTemplate), method373(var1.note));
			}

			if (var1.notedId != -1) {
				var1.method4693(method373(var1.notedId), method373(var1.unnotedId));
			}

			if (var1.placeholderTemplate != -1) {
				var1.method4694(method373(var1.placeholderTemplate), method373(var1.placeholder));
			}

			if (!class169.ItemDefinition_inMembersWorld && var1.isMembersOnly) {
				var1.name = "Members object";
				var1.isTradable = false;
				var1.groundActions = null;
				var1.inventoryActions = null;
				var1.shiftClickIndex = -1;
				var1.team = 0;
				if (var1.params != null) {
					boolean var3 = false;

					for (Node var4 = var1.params.method5978(); var4 != null; var4 = var1.params.method5966()) {
						ParamDefinition var5 = IgnoreList.method5110((int)var4.key);
						if (var5.autoDisable) {
							var4.method3657();
						} else {
							var3 = true;
						}
					}

					if (!var3) {
						var1.params = null;
					}
				}
			}

			ItemDefinition.ItemDefinition_cached.method3424(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "99208963"
	)
	static int method384(int var0, class101 var1, boolean var2) {
		String var3;
		int var4;
		if (var0 == 4100) {
			var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
			var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3 + var4;
			return 1;
		} else {
			String var9;
			if (var0 == 4101) {
				Interpreter.Interpreter_stringStackSize -= 2;
				var3 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
				var9 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1];
				Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3 + var9;
				return 1;
			} else if (var0 == 4102) {
				var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
				var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3 + class280.method5016(var4, true);
				return 1;
			} else if (var0 == 4103) {
				var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
				Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.toLowerCase();
				return 1;
			} else {
				int var6;
				int var10;
				if (var0 == 4104) {
					var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					long var11 = 86400000L * (11745L + (long)var10);
					Interpreter.Interpreter_calendar.setTime(new Date(var11));
					var6 = Interpreter.Interpreter_calendar.get(5);
					int var16 = Interpreter.Interpreter_calendar.get(2);
					int var8 = Interpreter.Interpreter_calendar.get(1);
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var6 + "-" + Interpreter.Interpreter_MONTHS[var16] + "-" + var8;
					return 1;
				} else if (var0 != 4105) {
					if (var0 == 4106) {
						var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = Integer.toString(var10);
						return 1;
					} else if (var0 == 4107) {
						Interpreter.Interpreter_stringStackSize -= 2;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class227.method4176(Huffman.method4025(Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize], Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1], IgnoreList.clientLanguage));
						return 1;
					} else {
						int var5;
						byte[] var13;
						Font var14;
						if (var0 == 4108) {
							var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
							Interpreter.Interpreter_intStackSize -= 2;
							var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
							var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
							var13 = NPC.archive13.method4224(var5, 0, (byte)-38);
							var14 = new Font(var13);
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var14.method5454(var3, var4);
							return 1;
						} else if (var0 == 4109) {
							var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
							Interpreter.Interpreter_intStackSize -= 2;
							var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
							var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
							var13 = NPC.archive13.method4224(var5, 0, (byte)-51);
							var14 = new Font(var13);
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var14.method5386(var3, var4);
							return 1;
						} else if (var0 == 4110) {
							Interpreter.Interpreter_stringStackSize -= 2;
							var3 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
							var9 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1];
							if (Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1) {
								Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3;
							} else {
								Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var9;
							}

							return 1;
						} else if (var0 == 4111) {
							var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = AbstractFont.method5388(var3);
							return 1;
						} else if (var0 == 4112) {
							var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
							var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3 + (char)var4;
							return 1;
						} else if (var0 == 4113) {
							var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ArchiveLoader.method1258((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == 4114) {
							var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = AbstractWorldMapIcon.method684((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == 4115) {
							var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = World.method1893((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == 4116) {
							var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = PcmPlayer.method2580((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == 4117) {
							var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
							if (var3 != null) {
								Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.length();
							} else {
								Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							}

							return 1;
						} else if (var0 == 4118) {
							var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
							Interpreter.Interpreter_intStackSize -= 2;
							var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
							var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.substring(var4, var5);
							return 1;
						} else if (var0 == 4119) {
							var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
							StringBuilder var17 = new StringBuilder(var3.length());
							boolean var15 = false;

							for (var6 = 0; var6 < var3.length(); ++var6) {
								char var7 = var3.charAt(var6);
								if (var7 == '<') {
									var15 = true;
								} else if (var7 == '>') {
									var15 = false;
								} else if (!var15) {
									var17.append(var7);
								}
							}

							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var17.toString();
							return 1;
						} else if (var0 == 4120) {
							var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
							var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.indexOf(var4);
							return 1;
						} else if (var0 == 4121) {
							Interpreter.Interpreter_stringStackSize -= 2;
							var3 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
							var9 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1];
							var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.indexOf(var9, var5);
							return 1;
						} else if (var0 == 4122) {
							var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.toUpperCase();
							return 1;
						} else {
							return 2;
						}
					}
				} else {
					Interpreter.Interpreter_stringStackSize -= 2;
					var3 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
					var9 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1];
					if (ByteArrayPool.localPlayer.appearance != null && ByteArrayPool.localPlayer.appearance.isFemale) {
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var9;
					} else {
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3;
					}

					return 1;
				}
			}
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "1350082309"
	)
	static int method380(int var0, class101 var1, boolean var2) {
		int var3;
		if (var0 == 5504) {
			Interpreter.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			int var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			if (!Client.isCameraLocked) {
				Client.camAngleX = var3;
				Client.onCameraPitchTargetChanged(-1);
				Client.camAngleY = var4;
			}

			return 1;
		} else if (var0 == 5505) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.camAngleX;
			return 1;
		} else if (var0 == 5506) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.camAngleY;
			return 1;
		} else if (var0 == 5530) {
			var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			if (var3 < 0) {
				var3 = 0;
			}

			Client.camFollowHeight = var3;
			return 1;
		} else if (var0 == 5531) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.camFollowHeight;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("ip")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "13"
	)
	static final int method381() {
		return Client.menuOptionsCount - 1;
	}

	@ObfuscatedName("js")
	@ObfuscatedSignature(
		signature = "(IIII)Lbm;",
		garbageValue = "-1715974914"
	)
	static final InterfaceParent method382(int var0, int var1, int var2) {
		InterfaceParent var3 = new InterfaceParent();
		var3.group = var1;
		var3.type = var2;
		Client.interfaceParents.method5997(var3, (long)var0);
		class4.method73(var1);
		Widget var4 = MusicPatchNode.method3898(var0);
		ItemContainer.method1273(var4);
		if (Client.meslayerContinueWidget != null) {
			ItemContainer.method1273(Client.meslayerContinueWidget);
			Client.meslayerContinueWidget = null;
		}

		ChatChannel.method2340();
		MouseHandler.method1161(Widget.Widget_interfaceComponents[var0 >> 16], var4, false);
		WorldMapSectionType.method349(var1, -1886131870);
		if (Client.rootInterface != -1) {
			class198.method3714(Client.rootInterface, 1);
		}

		return var3;
	}

	@ObfuscatedName("kf")
	@ObfuscatedSignature(
		signature = "(Lhe;I)Z",
		garbageValue = "-1425924887"
	)
	static boolean method356(Widget var0) {
		return var0.isHidden;
	}
}
