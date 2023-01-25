package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSMouseRecorder;

@ObfuscatedName("bn")
public class MouseRecorder implements Runnable, RSMouseRecorder {
	@ObfuscatedName("x")
	boolean isRunning;
	@ObfuscatedName("m")
	Object lock;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1833503611
	)
	int index;
	@ObfuscatedName("d")
	int[] xs;
	@ObfuscatedName("w")
	int[] ys;
	@ObfuscatedName("v")
	long[] millis;

	MouseRecorder() {
		this.isRunning = true;
		this.lock = new Object();
		this.index = 0;
		this.xs = new int[500];
		this.ys = new int[500];
		this.millis = new long[500];
	}

	public void run() {
		for (; this.isRunning; class169.method3527(50L)) {
			synchronized(this.lock) {
				if (this.index < 500) {
					this.xs[this.index] = MouseHandler.MouseHandler_x;
					this.ys[this.index] = MouseHandler.MouseHandler_y;
					this.millis[this.index] = MouseHandler.MouseHandler_millis;
					++this.index;
				}
			}
		}

	}

	public int getIndex() {
		return this.index;
	}

	public int[] getXs() {
		return this.xs;
	}

	public int[] getYs() {
		return this.ys;
	}

	public long[] getMillis() {
		return this.millis;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lkx;Lkx;Lkx;I)V",
		garbageValue = "684092055"
	)
	static void method1289(Font var0, Font var1, Font var2) {
		Login.xPadding = (WorldMapLabel.canvasWidth - 765) / 2;
		Login.loginBoxX = Login.xPadding + 202;
		PacketWriter.loginBoxCenter = Login.loginBoxX + 180;
		int var6;
		int var8;
		int var9;
		int var11;
		boolean var15;
		int var17;
		byte var23;
		int var24;
		int var47;
		int var49;
		if (Login.worldSelectOpen) {
			if (class69.worldSelectBackSprites == null) {
				class69.worldSelectBackSprites = FloorUnderlayDefinition.method4483(class228.archive8, "sl_back", "");
			}

			Archive var33;
			int var36;
			IndexedSprite[] var37;
			if (GrandExchangeEvent.worldSelectFlagSprites == null) {
				var33 = class228.archive8;
				var36 = var33.method4240("sl_flags");
				var6 = var33.method4233(var36, "");
				if (!UserComparator7.method3502(var33, var36, var6)) {
					var37 = null;
				} else {
					var37 = Skills.method4190();
				}

				GrandExchangeEvent.worldSelectFlagSprites = var37;
			}

			if (WorldMapDecoration.worldSelectArrows == null) {
				var33 = class228.archive8;
				var36 = var33.method4240("sl_arrows");
				var6 = var33.method4233(var36, "");
				if (!UserComparator7.method3502(var33, var36, var6)) {
					var37 = null;
				} else {
					var37 = Skills.method4190();
				}

				WorldMapDecoration.worldSelectArrows = var37;
			}

			if (class348.worldSelectStars == null) {
				var33 = class228.archive8;
				var36 = var33.method4240("sl_stars");
				var6 = var33.method4233(var36, "");
				if (!UserComparator7.method3502(var33, var36, var6)) {
					var37 = null;
				} else {
					var37 = Skills.method4190();
				}

				class348.worldSelectStars = var37;
			}

			if (class92.worldSelectLeftSprite == null) {
				class92.worldSelectLeftSprite = class7.method105(class228.archive8, "leftarrow", "");
			}

			if (StructDefinition.worldSelectRightSprite == null) {
				StructDefinition.worldSelectRightSprite = class7.method105(class228.archive8, "rightarrow", "");
			}

			Rasterizer2D.method6052(Login.xPadding, 23, 765, 480, 0);
			Rasterizer2D.method6053(Login.xPadding, 0, 125, 23, 12425273, 9135624);
			Rasterizer2D.method6053(Login.xPadding + 125, 0, 640, 23, 5197647, 2697513);
			var0.method5392("Select a world", Login.xPadding + 62, 15, 0, -1);
			if (class348.worldSelectStars != null) {
				class348.worldSelectStars[1].method6173(Login.xPadding + 140, 1);
				var1.method5389("Members only world", Login.xPadding + 152, 10, 16777215, -1);
				class348.worldSelectStars[0].method6173(Login.xPadding + 140, 12);
				var1.method5389("Free world", Login.xPadding + 152, 21, 16777215, -1);
			}

			if (WorldMapDecoration.worldSelectArrows != null) {
				var47 = Login.xPadding + 280;
				if (World.World_sortOption1[0] == 0 && World.World_sortOption2[0] == 0) {
					WorldMapDecoration.worldSelectArrows[2].method6173(var47, 4);
				} else {
					WorldMapDecoration.worldSelectArrows[0].method6173(var47, 4);
				}

				if (World.World_sortOption1[0] == 0 && World.World_sortOption2[0] == 1) {
					WorldMapDecoration.worldSelectArrows[3].method6173(var47 + 15, 4);
				} else {
					WorldMapDecoration.worldSelectArrows[1].method6173(var47 + 15, 4);
				}

				var0.method5389("World", var47 + 32, 17, 16777215, -1);
				var24 = Login.xPadding + 390;
				if (World.World_sortOption1[0] == 1 && World.World_sortOption2[0] == 0) {
					WorldMapDecoration.worldSelectArrows[2].method6173(var24, 4);
				} else {
					WorldMapDecoration.worldSelectArrows[0].method6173(var24, 4);
				}

				if (World.World_sortOption1[0] == 1 && World.World_sortOption2[0] == 1) {
					WorldMapDecoration.worldSelectArrows[3].method6173(var24 + 15, 4);
				} else {
					WorldMapDecoration.worldSelectArrows[1].method6173(var24 + 15, 4);
				}

				var0.method5389("Players", var24 + 32, 17, 16777215, -1);
				var36 = Login.xPadding + 500;
				if (World.World_sortOption1[0] == 2 && World.World_sortOption2[0] == 0) {
					WorldMapDecoration.worldSelectArrows[2].method6173(var36, 4);
				} else {
					WorldMapDecoration.worldSelectArrows[0].method6173(var36, 4);
				}

				if (World.World_sortOption1[0] == 2 && World.World_sortOption2[0] == 1) {
					WorldMapDecoration.worldSelectArrows[3].method6173(var36 + 15, 4);
				} else {
					WorldMapDecoration.worldSelectArrows[1].method6173(var36 + 15, 4);
				}

				var0.method5389("Location", var36 + 32, 17, 16777215, -1);
				var6 = Login.xPadding + 610;
				if (World.World_sortOption1[0] == 3 && World.World_sortOption2[0] == 0) {
					WorldMapDecoration.worldSelectArrows[2].method6173(var6, 4);
				} else {
					WorldMapDecoration.worldSelectArrows[0].method6173(var6, 4);
				}

				if (World.World_sortOption1[0] == 3 && World.World_sortOption2[0] == 1) {
					WorldMapDecoration.worldSelectArrows[3].method6173(var6 + 15, 4);
				} else {
					WorldMapDecoration.worldSelectArrows[1].method6173(var6 + 15, 4);
				}

				var0.method5389("Type", var6 + 32, 17, 16777215, -1);
			}

			Rasterizer2D.method6052(Login.xPadding + 708, 4, 50, 16, 0);
			var1.method5392("Cancel", Login.xPadding + 708 + 25, 16, 16777215, -1);
			Login.hoveredWorldIndex = -1;
			if (class69.worldSelectBackSprites != null) {
				var23 = 88;
				byte var50 = 19;
				var36 = 765 / (var23 + 1) - 1;
				var6 = 480 / (var50 + 1);

				do {
					var49 = var6;
					var8 = var36;
					if (var6 * (var36 - 1) >= World.World_count) {
						--var36;
					}

					if (var36 * (var6 - 1) >= World.World_count) {
						--var6;
					}

					if (var36 * (var6 - 1) >= World.World_count) {
						--var6;
					}
				} while(var6 != var49 || var36 != var8);

				var49 = (765 - var36 * var23) / (var36 + 1);
				if (var49 > 5) {
					var49 = 5;
				}

				var8 = (480 - var50 * var6) / (var6 + 1);
				if (var8 > 5) {
					var8 = 5;
				}

				var9 = (765 - var36 * var23 - var49 * (var36 - 1)) / 2;
				int var29 = (480 - var6 * var50 - var8 * (var6 - 1)) / 2;
				var11 = (var6 + World.World_count - 1) / var6;
				Login.worldSelectPagesCount = var11 - var36;
				if (class92.worldSelectLeftSprite != null && Login.worldSelectPage > 0) {
					class92.worldSelectLeftSprite.method6173(8, Varps.canvasHeight / 2 - class92.worldSelectLeftSprite.subHeight / 2);
				}

				if (StructDefinition.worldSelectRightSprite != null && Login.worldSelectPage < Login.worldSelectPagesCount) {
					StructDefinition.worldSelectRightSprite.method6173(WorldMapLabel.canvasWidth - StructDefinition.worldSelectRightSprite.subWidth - 8, Varps.canvasHeight / 2 - StructDefinition.worldSelectRightSprite.subHeight / 2);
				}

				int var42 = var29 + 23;
				int var13 = var9 + Login.xPadding;
				int var14 = 0;
				var15 = false;
				int var43 = Login.worldSelectPage;

				for (var17 = var43 * var6; var17 < World.World_count && var43 - Login.worldSelectPage < var36; ++var17) {
					World var30 = UserComparator2.World_worlds[var17];
					boolean var19 = true;
					String var20 = Integer.toString(var30.population);
					if (var30.population == -1) {
						var20 = "OFF";
						var19 = false;
					} else if (var30.population > 1980) {
						var20 = "FULL";
						var19 = false;
					}

					int var22 = 0;
					byte var21;
					if (var30.method1859()) {
						if (var30.method1886()) {
							var21 = 7;
						} else {
							var21 = 6;
						}
					} else if (var30.method1858()) {
						var22 = 16711680;
						if (var30.method1886()) {
							var21 = 5;
						} else {
							var21 = 4;
						}
					} else if (var30.method1865()) {
						if (var30.method1886()) {
							var21 = 9;
						} else {
							var21 = 8;
						}
					} else if (var30.method1856()) {
						if (var30.method1886()) {
							var21 = 3;
						} else {
							var21 = 2;
						}
					} else if (var30.method1886()) {
						var21 = 1;
					} else {
						var21 = 0;
					}

					if (MouseHandler.MouseHandler_x >= var13 && MouseHandler.MouseHandler_y >= var42 && MouseHandler.MouseHandler_x < var23 + var13 && MouseHandler.MouseHandler_y < var50 + var42 && var19) {
						Login.hoveredWorldIndex = var17;
						class69.worldSelectBackSprites[var21].method6249(var13, var42, 128, 16777215);
						var15 = true;
					} else {
						class69.worldSelectBackSprites[var21].method6185(var13, var42);
					}

					if (GrandExchangeEvent.worldSelectFlagSprites != null) {
						GrandExchangeEvent.worldSelectFlagSprites[(var30.method1886() ? 8 : 0) + var30.location].method6173(var13 + 29, var42);
					}

					var0.method5392(Integer.toString(var30.id), var13 + 15, var50 / 2 + var42 + 5, var22, -1);
					var1.method5392(var20, var13 + 60, var50 / 2 + var42 + 5, 268435455, -1);
					var42 = var42 + var8 + var50;
					++var14;
					if (var14 >= var6) {
						var42 = var29 + 23;
						var13 = var13 + var49 + var23;
						var14 = 0;
						++var43;
					}
				}

				if (var15) {
					var17 = var1.method5384(UserComparator2.World_worlds[Login.hoveredWorldIndex].activity) + 6;
					int var44 = var1.ascent + 8;
					int var45 = MouseHandler.MouseHandler_y + 25;
					if (var45 + var44 > 480) {
						var45 = MouseHandler.MouseHandler_y - 25 - var44;
					}

					Rasterizer2D.method6052(MouseHandler.MouseHandler_x - var17 / 2, var45, var17, var44, 16777120);
					Rasterizer2D.method6137(MouseHandler.MouseHandler_x - var17 / 2, var45, var17, var44, 0);
					var1.method5392(UserComparator2.World_worlds[Login.hoveredWorldIndex].activity, MouseHandler.MouseHandler_x, var45 + var1.ascent + 4, 0, -1);
				}
			}

			class206.rasterProvider.vmethod6139(0, 0);
		} else {
			Login.leftTitleSprite.method6185(Login.xPadding, 0);
			DirectByteArrayCopier.rightTitleSprite.method6185(Login.xPadding + 382, 0);
			class3.logoSprite.method6173(Login.xPadding + 382 - class3.logoSprite.subWidth / 2, 18);
			if (Client.gameState == 0 || Client.gameState == 5) {
				var23 = 20;
				var0.method5392("RuneScape is loading - please wait...", Login.loginBoxX + 180, 245 - var23, 16777215, -1);
				var24 = 253 - var23;
				Rasterizer2D.method6137(Login.loginBoxX + 180 - 152, var24, 304, 34, 9179409);
				Rasterizer2D.method6137(Login.loginBoxX + 180 - 151, var24 + 1, 302, 32, 0);
				Rasterizer2D.method6052(Login.loginBoxX + 180 - 150, var24 + 2, Login.Login_loadingPercent * 3, 30, 9179409);
				Rasterizer2D.method6052(Login.loginBoxX + 180 - 150 + Login.Login_loadingPercent * 3, var24 + 2, 300 - Login.Login_loadingPercent * 3, 30, 0);
				var0.method5392(Login.Login_loadingText, Login.loginBoxX + 180, 276 - var23, 16777215, -1);
			}

			String var7;
			char[] var10;
			String var25;
			String var27;
			short var46;
			short var48;
			if (Client.gameState == 20) {
				ModelData0.titleboxSprite.method6173(Login.loginBoxX + 180 - ModelData0.titleboxSprite.subWidth / 2, 271 - ModelData0.titleboxSprite.subHeight / 2);
				var46 = 201;
				var0.method5392(Login.Login_response1, Login.loginBoxX + 180, var46, 16776960, 0);
				var47 = var46 + 15;
				var0.method5392(Login.Login_response2, Login.loginBoxX + 180, var47, 16776960, 0);
				var47 += 15;
				var0.method5392(Login.Login_response3, Login.loginBoxX + 180, var47, 16776960, 0);
				var47 += 15;
				var47 += 7;
				if (Login.loginIndex != 4) {
					var0.method5389("Login: ", Login.loginBoxX + 180 - 110, var47, 16777215, 0);
					var48 = 200;

					for (var25 = ClanChat.method5291(); var0.method5384(var25) > var48; var25 = var25.substring(0, var25.length() - 1)) {
					}

					var0.method5389(AbstractFont.method5388(var25), Login.loginBoxX + 180 - 70, var47, 16777215, 0);
					var47 += 15;
					var7 = Login.Login_password;
					var9 = var7.length();
					var10 = new char[var9];

					for (var11 = 0; var11 < var9; ++var11) {
						var10[var11] = '*';
					}

					var27 = new String(var10);

					for (var27 = var27; var0.method5384(var27) > var48; var27 = var27.substring(1)) {
					}

					var0.method5389("Password: " + var27, Login.loginBoxX + 180 - 108, var47, 16777215, 0);
					var47 += 15;
				}
			}

			if (Client.gameState == 10 || Client.gameState == 11) {
				ModelData0.titleboxSprite.method6173(Login.loginBoxX, 171);
				short var5;
				if (Login.loginIndex == 0) {
					var46 = 251;
					var0.method5392("Welcome to RuneScape", Login.loginBoxX + 180, var46, 16776960, 0);
					var47 = var46 + 30;
					var24 = Login.loginBoxX + 180 - 80;
					var5 = 291;
					GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.method6173(var24 - 73, var5 - 20);
					var0.method5397("New User", var24 - 73, var5 - 20, 144, 40, 16777215, 0, 1, 1, 0);
					var24 = Login.loginBoxX + 180 + 80;
					GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.method6173(var24 - 73, var5 - 20);
					var0.method5397("Existing User", var24 - 73, var5 - 20, 144, 40, 16777215, 0, 1, 1, 0);
				} else if (Login.loginIndex == 1) {
					var0.method5392(Login.Login_response0, Login.loginBoxX + 180, 201, 16776960, 0);
					var46 = 236;
					var0.method5392(Login.Login_response1, Login.loginBoxX + 180, var46, 16777215, 0);
					var47 = var46 + 15;
					var0.method5392(Login.Login_response2, Login.loginBoxX + 180, var47, 16777215, 0);
					var47 += 15;
					var0.method5392(Login.Login_response3, Login.loginBoxX + 180, var47, 16777215, 0);
					var47 += 15;
					var24 = Login.loginBoxX + 180 - 80;
					var5 = 321;
					GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.method6173(var24 - 73, var5 - 20);
					var0.method5392("Continue", var24, var5 + 5, 16777215, 0);
					var24 = Login.loginBoxX + 180 + 80;
					GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.method6173(var24 - 73, var5 - 20);
					var0.method5392("Cancel", var24, var5 + 5, 16777215, 0);
				} else {
					IndexedSprite var39;
					if (Login.loginIndex == 2) {
						var46 = 201;
						var0.method5392(Login.Login_response1, PacketWriter.loginBoxCenter, var46, 16776960, 0);
						var47 = var46 + 15;
						var0.method5392(Login.Login_response2, PacketWriter.loginBoxCenter, var47, 16776960, 0);
						var47 += 15;
						var0.method5392(Login.Login_response3, PacketWriter.loginBoxCenter, var47, 16776960, 0);
						var47 += 15;
						var47 += 7;
						var0.method5389("Login: ", PacketWriter.loginBoxCenter - 110, var47, 16777215, 0);
						var48 = 200;

						for (var25 = ClanChat.method5291(); var0.method5384(var25) > var48; var25 = var25.substring(1)) {
						}

						var0.method5389(AbstractFont.method5388(var25) + (Login.currentLoginField == 0 & Client.cycle % 40 < 20 ? class297.method5314(16776960) + "|" : ""), PacketWriter.loginBoxCenter - 70, var47, 16777215, 0);
						var47 += 15;
						var7 = Login.Login_password;
						var9 = var7.length();
						var10 = new char[var9];

						for (var11 = 0; var11 < var9; ++var11) {
							var10[var11] = '*';
						}

						var27 = new String(var10);

						for (var27 = var27; var0.method5384(var27) > var48; var27 = var27.substring(1)) {
						}

						var0.method5389("Password: " + var27 + (Login.currentLoginField == 1 & Client.cycle % 40 < 20 ? class297.method5314(16776960) + "|" : ""), PacketWriter.loginBoxCenter - 108, var47, 16777215, 0);
						var47 += 15;
						var46 = 277;
						var9 = PacketWriter.loginBoxCenter + -117;
						boolean var40 = Client.Login_isUsernameRemembered;
						boolean var12 = Login.field1207;
						var39 = var40 ? (var12 ? Login.field1195 : Login.options_buttons_2Sprite) : (var12 ? WorldMapLabelSize.field160 : class4.options_buttons_0Sprite);
						var39.method6173(var9, var46);
						var9 = var9 + var39.subWidth + 5;
						var1.method5389("Remember username", var9, var46 + 13, 16776960, 0);
						var9 = PacketWriter.loginBoxCenter + 24;
						var15 = GrandExchangeOfferOwnWorldComparator.clientPreferences.hideUsername;
						boolean var16 = Login.field1212;
						IndexedSprite var32 = var15 ? (var16 ? Login.field1195 : Login.options_buttons_2Sprite) : (var16 ? WorldMapLabelSize.field160 : class4.options_buttons_0Sprite);
						var32.method6173(var9, var46);
						var9 = var9 + var32.subWidth + 5;
						var1.method5389("Hide username", var9, var46 + 13, 16776960, 0);
						var47 = var46 + 15;
						var17 = PacketWriter.loginBoxCenter - 80;
						short var18 = 321;
						GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.method6173(var17 - 73, var18 - 20);
						var0.method5392("Login", var17, var18 + 5, 16777215, 0);
						var17 = PacketWriter.loginBoxCenter + 80;
						GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.method6173(var17 - 73, var18 - 20);
						var0.method5392("Cancel", var17, var18 + 5, 16777215, 0);
						var46 = 357;
						switch(Login.field1218) {
						case 2:
							Message.field633 = "Having trouble logging in?";
							break;
						default:
							Message.field633 = "Can't login? Click here.";
						}

						class41.field315 = new Bounds(PacketWriter.loginBoxCenter, var46, var1.method5384(Message.field633), 11);
						MusicPatchPcmStream.field2495 = new Bounds(PacketWriter.loginBoxCenter, var46, var1.method5384("Still having trouble logging in?"), 11);
						var1.method5392(Message.field633, PacketWriter.loginBoxCenter, var46, 16777215, 0);
					} else if (Login.loginIndex == 3) {
						var46 = 201;
						var0.method5392("Invalid credentials.", Login.loginBoxX + 180, var46, 16776960, 0);
						var47 = var46 + 20;
						var1.method5392("For accounts created after 24th November 2010, please use your", Login.loginBoxX + 180, var47, 16776960, 0);
						var47 += 15;
						var1.method5392("email address to login. Otherwise please login with your username.", Login.loginBoxX + 180, var47, 16776960, 0);
						var47 += 15;
						var24 = Login.loginBoxX + 180;
						var5 = 276;
						GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.method6173(var24 - 73, var5 - 20);
						var2.method5392("Try again", var24, var5 + 5, 16777215, 0);
						var24 = Login.loginBoxX + 180;
						var5 = 326;
						GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.method6173(var24 - 73, var5 - 20);
						var2.method5392("Forgotten password?", var24, var5 + 5, 16777215, 0);
					} else if (Login.loginIndex == 4) {
						var0.method5392("Authenticator", Login.loginBoxX + 180, 201, 16776960, 0);
						var46 = 236;
						var0.method5392(Login.Login_response1, Login.loginBoxX + 180, var46, 16777215, 0);
						var47 = var46 + 15;
						var0.method5392(Login.Login_response2, Login.loginBoxX + 180, var47, 16777215, 0);
						var47 += 15;
						var0.method5392(Login.Login_response3, Login.loginBoxX + 180, var47, 16777215, 0);
						var47 += 15;
						var25 = "PIN: ";
						var7 = MilliClock.otp;
						var9 = var7.length();
						var10 = new char[var9];

						for (var11 = 0; var11 < var9; ++var11) {
							var10[var11] = '*';
						}

						var27 = new String(var10);
						var0.method5389(var25 + var27 + (Client.cycle % 40 < 20 ? class297.method5314(16776960) + "|" : ""), Login.loginBoxX + 180 - 108, var47, 16777215, 0);
						var47 -= 8;
						var0.method5389("Trust this computer", Login.loginBoxX + 180 - 9, var47, 16776960, 0);
						var47 += 15;
						var0.method5389("for 30 days: ", Login.loginBoxX + 180 - 9, var47, 16776960, 0);
						var8 = 180 + Login.loginBoxX - 9 + var0.method5384("for 30 days: ") + 15;
						var9 = var47 - var0.ascent;
						if (Login.field1214) {
							var39 = Login.options_buttons_2Sprite;
						} else {
							var39 = class4.options_buttons_0Sprite;
						}

						var39.method6173(var8, var9);
						var47 += 15;
						var11 = Login.loginBoxX + 180 - 80;
						short var41 = 321;
						GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.method6173(var11 - 73, var41 - 20);
						var0.method5392("Continue", var11, var41 + 5, 16777215, 0);
						var11 = Login.loginBoxX + 180 + 80;
						GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.method6173(var11 - 73, var41 - 20);
						var0.method5392("Cancel", var11, var41 + 5, 16777215, 0);
						var1.method5392("<u=ff>Can't Log In?</u>", Login.loginBoxX + 180, var41 + 36, 255, 0);
					} else if (Login.loginIndex == 5) {
						var0.method5392("Forgotten your password?", Login.loginBoxX + 180, 201, 16776960, 0);
						var46 = 221;
						var2.method5392(Login.Login_response1, Login.loginBoxX + 180, var46, 16776960, 0);
						var47 = var46 + 15;
						var2.method5392(Login.Login_response2, Login.loginBoxX + 180, var47, 16776960, 0);
						var47 += 15;
						var2.method5392(Login.Login_response3, Login.loginBoxX + 180, var47, 16776960, 0);
						var47 += 15;
						var47 += 14;
						var0.method5389("Username/email: ", Login.loginBoxX + 180 - 145, var47, 16777215, 0);
						var48 = 174;

						for (var25 = ClanChat.method5291(); var0.method5384(var25) > var48; var25 = var25.substring(1)) {
						}

						var0.method5389(AbstractFont.method5388(var25) + (Client.cycle % 40 < 20 ? class297.method5314(16776960) + "|" : ""), Login.loginBoxX + 180 - 34, var47, 16777215, 0);
						var47 += 15;
						var6 = Login.loginBoxX + 180 - 80;
						short var26 = 321;
						GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.method6173(var6 - 73, var26 - 20);
						var0.method5392("Recover", var6, var26 + 5, 16777215, 0);
						var6 = Login.loginBoxX + 180 + 80;
						GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.method6173(var6 - 73, var26 - 20);
						var0.method5392("Back", var6, var26 + 5, 16777215, 0);
						var26 = 356;
						var1.method5392("Still having trouble logging in?", PacketWriter.loginBoxCenter, var26, 268435455, 0);
					} else if (Login.loginIndex == 6) {
						var46 = 201;
						var0.method5392(Login.Login_response1, Login.loginBoxX + 180, var46, 16776960, 0);
						var47 = var46 + 15;
						var0.method5392(Login.Login_response2, Login.loginBoxX + 180, var47, 16776960, 0);
						var47 += 15;
						var0.method5392(Login.Login_response3, Login.loginBoxX + 180, var47, 16776960, 0);
						var47 += 15;
						var24 = Login.loginBoxX + 180;
						var5 = 321;
						GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.method6173(var24 - 73, var5 - 20);
						var0.method5392("Back", var24, var5 + 5, 16777215, 0);
					} else if (Login.loginIndex == 7) {
						var46 = 216;
						var0.method5392("Your date of birth isn't set.", Login.loginBoxX + 180, var46, 16776960, 0);
						var47 = var46 + 15;
						var2.method5392("Please verify your account status by", Login.loginBoxX + 180, var47, 16776960, 0);
						var47 += 15;
						var2.method5392("setting your date of birth.", Login.loginBoxX + 180, var47, 16776960, 0);
						var47 += 15;
						var24 = Login.loginBoxX + 180 - 80;
						var5 = 321;
						GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.method6173(var24 - 73, var5 - 20);
						var0.method5392("Set Date of Birth", var24, var5 + 5, 16777215, 0);
						var24 = Login.loginBoxX + 180 + 80;
						GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.method6173(var24 - 73, var5 - 20);
						var0.method5392("Back", var24, var5 + 5, 16777215, 0);
					} else if (Login.loginIndex == 8) {
						var46 = 216;
						var0.method5392("Sorry, but your account is not eligible to play.", Login.loginBoxX + 180, var46, 16776960, 0);
						var47 = var46 + 15;
						var2.method5392("For more information, please take a look at", Login.loginBoxX + 180, var47, 16776960, 0);
						var47 += 15;
						var2.method5392("our privacy policy.", Login.loginBoxX + 180, var47, 16776960, 0);
						var47 += 15;
						var24 = Login.loginBoxX + 180 - 80;
						var5 = 321;
						GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.method6173(var24 - 73, var5 - 20);
						var0.method5392("Privacy Policy", var24, var5 + 5, 16777215, 0);
						var24 = Login.loginBoxX + 180 + 80;
						GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.method6173(var24 - 73, var5 - 20);
						var0.method5392("Back", var24, var5 + 5, 16777215, 0);
					} else if (Login.loginIndex == 12) {
						var46 = 201;
						String var4 = "";
						var25 = "";
						String var28 = "";
						switch(Login.field1201) {
						case 0:
							var4 = "Your account has been disabled.";
							var25 = Strings.field2811;
							var28 = "";
							break;
						case 1:
							var4 = "Account locked as we suspect it has been stolen.";
							var25 = Strings.field2914;
							var28 = "";
							break;
						default:
							ObjectDefinition.method4687(false);
						}

						var0.method5392(var4, Login.loginBoxX + 180, var46, 16776960, 0);
						var47 = var46 + 15;
						var2.method5392(var25, Login.loginBoxX + 180, var47, 16776960, 0);
						var47 += 15;
						var2.method5392(var28, Login.loginBoxX + 180, var47, 16776960, 0);
						var47 += 15;
						var49 = Login.loginBoxX + 180;
						short var38 = 276;
						GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.method6173(var49 - 73, var38 - 20);
						var0.method5392("Support Page", var49, var38 + 5, 16777215, 0);
						var49 = Login.loginBoxX + 180;
						var38 = 326;
						GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.method6173(var49 - 73, var38 - 20);
						var0.method5392("Back", var49, var38 + 5, 16777215, 0);
					} else if (Login.loginIndex == 24) {
						var46 = 221;
						var0.method5392(Login.Login_response1, Login.loginBoxX + 180, var46, 16777215, 0);
						var47 = var46 + 15;
						var0.method5392(Login.Login_response2, Login.loginBoxX + 180, var47, 16777215, 0);
						var47 += 15;
						var0.method5392(Login.Login_response3, Login.loginBoxX + 180, var47, 16777215, 0);
						var47 += 15;
						var24 = Login.loginBoxX + 180;
						var5 = 301;
						GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.method6173(var24 - 73, var5 - 20);
						var0.method5392("Ok", var24, var5 + 5, 16777215, 0);
					}
				}
			}

			if (Client.gameState >= 10) {
				int[] var3 = new int[4];
				Rasterizer2D.method6047(var3);
				Rasterizer2D.method6045(Login.xPadding, 0, Login.xPadding + 765, Varps.canvasHeight);
				MilliClock.loginScreenRunesAnimation.method1918(Login.xPadding - 22, Client.cycle, (byte)10);
				MilliClock.loginScreenRunesAnimation.method1918(Login.xPadding + 22 + 765 - 128, Client.cycle, (byte)82);
				Rasterizer2D.method6048(var3);
			}

			ArchiveDisk.title_muteSprite[GrandExchangeOfferOwnWorldComparator.clientPreferences.titleMusicDisabled ? 1 : 0].method6173(Login.xPadding + 765 - 40, 463);
			if (Client.gameState > 5 && Language.Language_EN == IgnoreList.clientLanguage) {
				if (ItemContainer.field572 != null) {
					var47 = Login.xPadding + 5;
					var48 = 463;
					byte var35 = 100;
					byte var34 = 35;
					ItemContainer.field572.method6173(var47, var48);
					var0.method5392("World" + " " + Client.worldId, var35 / 2 + var47, var34 / 2 + var48 - 2, 16777215, 0);
					if (LoginPacket.World_request != null) {
						var1.method5392("Loading...", var35 / 2 + var47, var34 / 2 + var48 + 12, 16777215, 0);
					} else {
						var1.method5392("Click to switch", var35 / 2 + var47, var34 / 2 + var48 + 12, 16777215, 0);
					}
				} else {
					ItemContainer.field572 = class7.method105(class228.archive8, "sl_button", "");
				}
			}

		}
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "1787965087"
	)
	static int method1290(int var0, class101 var1, boolean var2) {
		if (var0 == 6200) {
			Interpreter.Interpreter_intStackSize -= 2;
			Client.field931 = (short)class278.method5015(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize]);
			if (Client.field931 <= 0) {
				Client.field931 = 256;
			}

			Client.field932 = (short)class278.method5015(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
			if (Client.field932 <= 0) {
				Client.field932 = 256;
			}

			return 1;
		} else if (var0 == 6201) {
			Interpreter.Interpreter_intStackSize -= 2;
			Client.zoomHeight = (short)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			if (Client.zoomHeight <= 0) {
				Client.zoomHeight = 256;
			}

			Client.zoomWidth = (short)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			if (Client.zoomWidth <= 0) {
				Client.zoomWidth = 320;
			}

			return 1;
		} else if (var0 == 6202) {
			Interpreter.Interpreter_intStackSize -= 4;
			Client.field935 = (short)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			if (Client.field935 <= 0) {
				Client.field935 = 1;
			}

			Client.field748 = (short)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			if (Client.field748 <= 0) {
				Client.field748 = 32767;
			} else if (Client.field748 < Client.field935) {
				Client.field748 = Client.field935;
			}

			Client.field937 = (short)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
			if (Client.field937 <= 0) {
				Client.field937 = 1;
			}

			Client.field938 = (short)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
			if (Client.field938 <= 0) {
				Client.field938 = 32767;
			} else if (Client.field938 < Client.field937) {
				Client.field938 = Client.field937;
			}

			return 1;
		} else if (var0 == 6203) {
			if (Client.viewportWidget != null) {
				class204.method3751(0, 0, Client.viewportWidget.width, Client.viewportWidget.height, false);
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.viewportWidth;
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.viewportHeight;
			} else {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
			}

			return 1;
		} else if (var0 == 6204) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.zoomHeight;
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.zoomWidth;
			return 1;
		} else if (var0 == 6205) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Actor.method1846(Client.field931);
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Actor.method1846(Client.field932);
			return 1;
		} else if (var0 == 6220) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
			return 1;
		} else if (var0 == 6221) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
			return 1;
		} else if (var0 == 6222) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = WorldMapLabel.canvasWidth;
			return 1;
		} else if (var0 == 6223) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Varps.canvasHeight;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("ew")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1951274332"
	)
	static void method1293(int var0) {
		if (var0 != Client.gameState) {
			if (Client.gameState == 0) {
				WorldMapSection1.client.method1025();
			}

			if (var0 == 20 || var0 == 40 || var0 == 45) {
				Client.loginState = 0;
				Client.field712 = 0;
				Client.field713 = 0;
				Client.timer.method5020(var0);
				if (var0 != 20) {
					GraphicsObject.method2108(false);
				}
			}

			if (var0 != 20 && var0 != 40 && UrlRequester.field1960 != null) {
				UrlRequester.field1960.vmethod5866();
				UrlRequester.field1960 = null;
			}

			if (Client.gameState == 25) {
				Client.field899 = 0;
				Client.field818 = 0;
				Client.field921 = 1;
				Client.field734 = 0;
				Client.field735 = 1;
			}

			if (var0 != 5 && var0 != 10) {
				if (var0 == 20) {
					class299.method5322(PlayerAppearance.archive10, class228.archive8, true, Client.gameState == 11 ? 4 : 0);
				} else if (var0 == 11) {
					class299.method5322(PlayerAppearance.archive10, class228.archive8, false, 4);
				} else {
					Calendar.method4011();
				}
			} else {
				class299.method5322(PlayerAppearance.archive10, class228.archive8, true, 0);
			}

			Client.gameState = var0;
			Client.gameStateChanged(-1);
		}
	}
}
