package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
public final class class13 {
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lkb;"
	)
	public static Buffer NetCache_reference;

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "1707746438"
	)
	static int method132(int var0, class101 var1, boolean var2) {
		if (var0 == 3600) {
			if (Projectile.friendSystem.field1092 == 0) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -2;
			} else if (Projectile.friendSystem.field1092 == 1) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
			} else {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Projectile.friendSystem.friendsList.method5115();
			}

			return 1;
		} else {
			int var3;
			if (var0 == 3601) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				if (Projectile.friendSystem.method1938() && var3 >= 0 && var3 < Projectile.friendSystem.friendsList.method5115()) {
					Friend var8 = (Friend)Projectile.friendSystem.friendsList.method5196(var3);
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var8.method5083();
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var8.method5070();
				} else {
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else if (var0 == 3602) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				if (Projectile.friendSystem.method1938() && var3 >= 0 && var3 < Projectile.friendSystem.friendsList.method5115()) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ((Buddy)Projectile.friendSystem.friendsList.method5196(var3)).world;
				} else {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			} else if (var0 == 3603) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				if (Projectile.friendSystem.method1938() && var3 >= 0 && var3 < Projectile.friendSystem.friendsList.method5115()) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ((Buddy)Projectile.friendSystem.friendsList.method5196(var3)).rank;
				} else {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			} else {
				String var5;
				if (var0 == 3604) {
					var5 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
					int var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					class52.method902(var5, var6);
					return 1;
				} else if (var0 == 3605) {
					var5 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
					Projectile.friendSystem.method1945(var5);
					return 1;
				} else if (var0 == 3606) {
					var5 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
					Projectile.friendSystem.method1981(var5);
					return 1;
				} else if (var0 == 3607) {
					var5 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
					Projectile.friendSystem.method1947(var5);
					return 1;
				} else if (var0 == 3608) {
					var5 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
					Projectile.friendSystem.method1950(var5);
					return 1;
				} else if (var0 == 3609) {
					var5 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
					var5 = Occluder.method3386(var5);
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Projectile.friendSystem.method1977(new Username(var5, WorldMapIcon_0.loginType), false) ? 1 : 0;
					return 1;
				} else if (var0 == 3611) {
					if (InterfaceParent.clanChat != null) {
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = InterfaceParent.clanChat.name;
					} else {
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == 3612) {
					if (InterfaceParent.clanChat != null) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = InterfaceParent.clanChat.method5115();
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == 3613) {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					if (InterfaceParent.clanChat != null && var3 < InterfaceParent.clanChat.method5115()) {
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = InterfaceParent.clanChat.method5196(var3).method5068().method5238();
					} else {
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == 3614) {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					if (InterfaceParent.clanChat != null && var3 < InterfaceParent.clanChat.method5115()) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ((Buddy)InterfaceParent.clanChat.method5196(var3)).method5214();
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == 3615) {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					if (InterfaceParent.clanChat != null && var3 < InterfaceParent.clanChat.method5115()) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ((Buddy)InterfaceParent.clanChat.method5196(var3)).rank;
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == 3616) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = InterfaceParent.clanChat != null ? InterfaceParent.clanChat.minKick : 0;
					return 1;
				} else if (var0 == 3617) {
					var5 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
					PlayerAppearance.method4063(var5);
					return 1;
				} else if (var0 == 3618) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = InterfaceParent.clanChat != null ? InterfaceParent.clanChat.rank : 0;
					return 1;
				} else if (var0 == 3619) {
					var5 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
					GrandExchangeEvent.method156(var5);
					return 1;
				} else if (var0 == 3620) {
					WorldMapDecoration.method436();
					return 1;
				} else if (var0 == 3621) {
					if (!Projectile.friendSystem.method1938()) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Projectile.friendSystem.ignoreList.method5115();
					}

					return 1;
				} else if (var0 == 3622) {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					if (Projectile.friendSystem.method1938() && var3 >= 0 && var3 < Projectile.friendSystem.ignoreList.method5115()) {
						Ignored var4 = (Ignored)Projectile.friendSystem.ignoreList.method5196(var3);
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var4.method5083();
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var4.method5070();
					} else {
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == 3623) {
					var5 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
					var5 = Occluder.method3386(var5);
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Projectile.friendSystem.method1944(new Username(var5, WorldMapIcon_0.loginType)) ? 1 : 0;
					return 1;
				} else if (var0 == 3624) {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					if (InterfaceParent.clanChat != null && var3 < InterfaceParent.clanChat.method5115() && InterfaceParent.clanChat.method5196(var3).method5068().equals(ByteArrayPool.localPlayer.username)) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == 3625) {
					if (InterfaceParent.clanChat != null && InterfaceParent.clanChat.owner != null) {
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = InterfaceParent.clanChat.owner;
					} else {
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == 3626) {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					if (InterfaceParent.clanChat != null && var3 < InterfaceParent.clanChat.method5115() && ((ClanMate)InterfaceParent.clanChat.method5196(var3)).method5041()) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 != 3627) {
					if (var0 == 3628) {
						Projectile.friendSystem.friendsList.method5135();
						return 1;
					} else {
						boolean var7;
						if (var0 == 3629) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							Projectile.friendSystem.friendsList.method5136(new UserComparator1(var7));
							return 1;
						} else if (var0 == 3630) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							Projectile.friendSystem.friendsList.method5136(new UserComparator2(var7));
							return 1;
						} else if (var0 == 3631) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							Projectile.friendSystem.friendsList.method5136(new UserComparator3(var7));
							return 1;
						} else if (var0 == 3632) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							Projectile.friendSystem.friendsList.method5136(new UserComparator4(var7));
							return 1;
						} else if (var0 == 3633) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							Projectile.friendSystem.friendsList.method5136(new UserComparator5(var7));
							return 1;
						} else if (var0 == 3634) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							Projectile.friendSystem.friendsList.method5136(new UserComparator6(var7));
							return 1;
						} else if (var0 == 3635) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							Projectile.friendSystem.friendsList.method5136(new UserComparator7(var7));
							return 1;
						} else if (var0 == 3636) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							Projectile.friendSystem.friendsList.method5136(new UserComparator8(var7));
							return 1;
						} else if (var0 == 3637) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							Projectile.friendSystem.friendsList.method5136(new UserComparator9(var7));
							return 1;
						} else if (var0 == 3638) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							Projectile.friendSystem.friendsList.method5136(new UserComparator10(var7));
							return 1;
						} else if (var0 == 3639) {
							Projectile.friendSystem.friendsList.method5126();
							return 1;
						} else if (var0 == 3640) {
							Projectile.friendSystem.ignoreList.method5135();
							return 1;
						} else if (var0 == 3641) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							Projectile.friendSystem.ignoreList.method5136(new UserComparator1(var7));
							return 1;
						} else if (var0 == 3642) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							Projectile.friendSystem.ignoreList.method5136(new UserComparator2(var7));
							return 1;
						} else if (var0 == 3643) {
							Projectile.friendSystem.ignoreList.method5126();
							return 1;
						} else if (var0 == 3644) {
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.method5135();
							}

							return 1;
						} else if (var0 == 3645) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.method5136(new UserComparator1(var7));
							}

							return 1;
						} else if (var0 == 3646) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.method5136(new UserComparator2(var7));
							}

							return 1;
						} else if (var0 == 3647) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.method5136(new UserComparator3(var7));
							}

							return 1;
						} else if (var0 == 3648) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.method5136(new UserComparator4(var7));
							}

							return 1;
						} else if (var0 == 3649) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.method5136(new UserComparator5(var7));
							}

							return 1;
						} else if (var0 == 3650) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.method5136(new UserComparator6(var7));
							}

							return 1;
						} else if (var0 == 3651) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.method5136(new UserComparator7(var7));
							}

							return 1;
						} else if (var0 == 3652) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.method5136(new UserComparator8(var7));
							}

							return 1;
						} else if (var0 == 3653) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.method5136(new UserComparator9(var7));
							}

							return 1;
						} else if (var0 == 3654) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.method5136(new UserComparator10(var7));
							}

							return 1;
						} else if (var0 == 3655) {
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.method5126();
							}

							return 1;
						} else if (var0 == 3656) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							Projectile.friendSystem.friendsList.method5136(new BuddyRankComparator(var7));
							return 1;
						} else if (var0 == 3657) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.method5136(new BuddyRankComparator(var7));
							}

							return 1;
						} else {
							return 2;
						}
					}
				} else {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					if (InterfaceParent.clanChat != null && var3 < InterfaceParent.clanChat.method5115() && ((ClanMate)InterfaceParent.clanChat.method5196(var3)).method5047()) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				}
			}
		}
	}

	@ObfuscatedName("ek")
	@ObfuscatedSignature(
		signature = "(I)Lml;",
		garbageValue = "637526899"
	)
	static WorldMap method133() {
		return GrandExchangeOfferAgeComparator.worldMap;
	}
}
