package com.zenyte.desktop;

import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ks")
public class class299 {
	@ObfuscatedName("x")
	static char[] field3646;
	@ObfuscatedName("m")
	static char[] field3647;
	@ObfuscatedName("k")
	static char[] field3648;
	@ObfuscatedName("d")
	static int[] field3649;
	@ObfuscatedName("hy")
	@ObfuscatedSignature(
		signature = "[Lla;"
	)
	static Sprite[] crossSprites;

	static {
		field3646 = new char[64];

		int var0;
		for (var0 = 0; var0 < 26; ++var0) {
			field3646[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3646[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3646[var0] = (char)(var0 + 48 - 52);
		}

		field3646[62] = '+';
		field3646[63] = '/';
		field3647 = new char[64];

		for (var0 = 0; var0 < 26; ++var0) {
			field3647[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3647[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3647[var0] = (char)(var0 + 48 - 52);
		}

		field3647[62] = '*';
		field3647[63] = '-';
		field3648 = new char[64];

		for (var0 = 0; var0 < 26; ++var0) {
			field3648[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3648[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3648[var0] = (char)(var0 + 48 - 52);
		}

		field3648[62] = '-';
		field3648[63] = '_';
		field3649 = new int[128];

		for (var0 = 0; var0 < field3649.length; ++var0) {
			field3649[var0] = -1;
		}

		for (var0 = 65; var0 <= 90; ++var0) {
			field3649[var0] = var0 - 65;
		}

		for (var0 = 97; var0 <= 122; ++var0) {
			field3649[var0] = var0 - 97 + 26;
		}

		for (var0 = 48; var0 <= 57; ++var0) {
			field3649[var0] = var0 - 48 + 52;
		}

		int[] var2 = field3649;
		field3649[43] = 62;
		var2[42] = 62;
		int[] var1 = field3649;
		field3649[47] = 63;
		var1[45] = 63;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Liy;Liy;ZII)V",
		garbageValue = "53757689"
	)
	static void method5322(AbstractArchive var0, AbstractArchive var1, boolean var2, int var3) {
		if (Login.clearLoginScreen) {
			if (var3 == 4) {
				Login.loginIndex = 4;
			}

		} else {
			Login.loginIndex = var3;
			Rasterizer2D.method6049();
			byte[] var4 = var0.method4223("title.jpg", "");
			Login.leftTitleSprite = class200.method3731(var4);
			Client.setLeftTitleSprite(-1);
			DirectByteArrayCopier.rightTitleSprite = Login.leftTitleSprite.method6177();
			Client.setRightTitleSprite(-1);
			if ((Client.worldProperties & 536870912) != 0) {
				class3.logoSprite = class7.method105(var1, "logo_deadman_mode", "");
			} else if ((Client.worldProperties & 1073741824) != 0) {
				class3.logoSprite = class7.method105(var1, "logo_seasonal_mode", "");
			} else {
				class3.logoSprite = class7.method105(var1, "logo", "");
			}

			ModelData0.titleboxSprite = class7.method105(var1, "titlebox", "");
			GrandExchangeOfferOwnWorldComparator.titlebuttonSprite = class7.method105(var1, "titlebutton", "");
			int var6 = var1.method4240("runes");
			int var7 = var1.method4233(var6, "");
			IndexedSprite[] var8;
			if (!UserComparator7.method3502(var1, var6, var7)) {
				var8 = null;
			} else {
				var8 = Skills.method4190();
			}

			Login.runesSprite = var8;
			ArchiveDisk.title_muteSprite = Username.method5246(var1, "title_mute", "");
			class4.options_buttons_0Sprite = class7.method105(var1, "options_radio_buttons,0", "");
			WorldMapLabelSize.field160 = class7.method105(var1, "options_radio_buttons,4", "");
			Login.options_buttons_2Sprite = class7.method105(var1, "options_radio_buttons,2", "");
			Login.field1195 = class7.method105(var1, "options_radio_buttons,6", "");
			WorldMapLabelSize.field158 = class4.options_buttons_0Sprite.subWidth;
			class219.field2515 = class4.options_buttons_0Sprite.subHeight;
			MilliClock.loginScreenRunesAnimation = new LoginScreenAnimation(Login.runesSprite);
			if (var2) {
				Login.Login_username = "";
				Client.onUsernameChanged(-1);
				Login.Login_password = "";
			}

			GraphicsObject.field1141 = 0;
			MilliClock.otp = "";
			Login.field1214 = true;
			Login.worldSelectOpen = false;
			if (!GrandExchangeOfferOwnWorldComparator.clientPreferences.titleMusicDisabled) {
				WorldMapArea.method461(2, AbstractWorldMapIcon.archive6, "scape main", "", 255, false);
			} else {
				class206.field2406 = 1;
				class206.musicTrackArchive = null;
				class206.musicTrackGroupId = -1;
				class206.musicTrackFileId = -1;
				class219.musicTrackVolume = 0;
				GrandExchangeOfferUnitPriceComparator.musicTrackBoolean = false;
				AttackOption.field1187 = 2;
			}

			if (NetCache.NetCache_socket != null) {
				try {
					Buffer var9 = new Buffer(4);
					var9.method5531(3);
					var9.method5588(0);
					NetCache.NetCache_socket.vmethod5878(var9.array, 0, 4);
				} catch (IOException var12) {
					try {
						NetCache.NetCache_socket.vmethod5866();
					} catch (Exception var11) {
					}

					++NetCache.NetCache_ioExceptions;
					NetCache.NetCache_socket = null;
				}
			}

			Login.clearLoginScreen = true;
			Login.xPadding = (WorldMapLabel.canvasWidth - 765) / 2;
			Login.loginBoxX = Login.xPadding + 202;
			PacketWriter.loginBoxCenter = Login.loginBoxX + 180;
			Login.leftTitleSprite.method6185(Login.xPadding, 0);
			DirectByteArrayCopier.rightTitleSprite.method6185(Login.xPadding + 382, 0);
			class3.logoSprite.method6173(Login.xPadding + 382 - class3.logoSprite.subWidth / 2, 18);
		}
	}
}
