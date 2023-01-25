package com.zenyte.desktop;

import java.text.DecimalFormat;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSLogin;

@ObfuscatedName("cy")
public class Login implements RSLogin {
	@ObfuscatedName("m")
	static boolean clearLoginScreen;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1204959409
	)
	static int xPadding;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "[Lle;"
	)
	static IndexedSprite[] runesSprite;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lla;"
	)
	static Sprite leftTitleSprite;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	static IndexedSprite options_buttons_2Sprite;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	static IndexedSprite field1195;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 677991921
	)
	static int loginBoxX;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 351147085
	)
	static int Login_loadingPercent;
	@ObfuscatedName("c")
	static String Login_loadingText;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = 811959291
	)
	static int field1201;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = -1263209859
	)
	static int field1218;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = -1027214845
	)
	static int loginIndex;
	@ObfuscatedName("au")
	static String Login_response0;
	@ObfuscatedName("ao")
	static String Login_response1;
	@ObfuscatedName("aq")
	static String Login_response2;
	@ObfuscatedName("av")
	static String Login_response3;
	@ObfuscatedName("ak")
	static String Login_username;
	@ObfuscatedName("aa")
	static String Login_password;
	@ObfuscatedName("ah")
	static boolean field1207;
	@ObfuscatedName("ag")
	static boolean field1212;
	@ObfuscatedName("bc")
	static boolean field1214;
	@ObfuscatedName("bo")
	@ObfuscatedGetter(
		intValue = 463020899
	)
	static int currentLoginField;
	@ObfuscatedName("be")
	static boolean worldSelectOpen;
	@ObfuscatedName("bx")
	@ObfuscatedGetter(
		intValue = 1533382117
	)
	static int hoveredWorldIndex;
	@ObfuscatedName("bz")
	@ObfuscatedGetter(
		intValue = 623076751
	)
	static int worldSelectPage;
	@ObfuscatedName("bs")
	@ObfuscatedGetter(
		intValue = 1665656509
	)
	static int worldSelectPagesCount;
	@ObfuscatedName("bm")
	@ObfuscatedGetter(
		longValue = 7899458563171084207L
	)
	static long field1223;
	@ObfuscatedName("bb")
	@ObfuscatedGetter(
		longValue = -6287034345881583105L
	)
	static long field1224;

	static {
		xPadding = 0;
		loginBoxX = xPadding + 202;
		Login_loadingPercent = 10;
		Login_loadingText = "";
		field1201 = -1;
		field1218 = 1;
		loginIndex = 0;
		Login_response0 = "";
		Login_response1 = "";
		Login_response2 = "";
		Login_response3 = "";
		Login_username = "";
		Login_password = "";
		field1207 = false;
		field1212 = false;
		field1214 = true;
		currentLoginField = 0;
		worldSelectOpen = false;
		hoveredWorldIndex = -1;
		worldSelectPage = 0;
		worldSelectPagesCount = 0;
		new DecimalFormat("##0.00");
		new class171();
		field1223 = -1L;
		field1224 = -1L;
	}

	@ObfuscatedName("lo")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2118716971"
	)
	static void method2163() {
		if (WorldMapRectangle.field222 != null) {
			Client.field891 = Client.cycle;
			WorldMapRectangle.field222.method4382();

			for (int var0 = 0; var0 < Client.players.length; ++var0) {
				if (Client.players[var0] != null) {
					WorldMapRectangle.field222.method4381((Client.players[var0].x >> 7) + class69.baseX * 731242929, class89.baseY * 1825982697 + (Client.players[var0].y >> 7));
				}
			}
		}

	}
}
