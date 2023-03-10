package com.zenyte.desktop;

import java.io.IOException;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSCalendar;

@ObfuscatedName("hq")
public class Calendar implements RSCalendar {
	@ObfuscatedName("x")
	public static final String[][] MONTH_NAMES_ENGLISH_GERMAN;
	@ObfuscatedName("m")
	public static final String[] DAYS_OF_THE_WEEK;
	@ObfuscatedName("k")
	public static java.util.Calendar Calendar_calendar;

	static {
		MONTH_NAMES_ENGLISH_GERMAN = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}, {"jan", "fév", "mars", "avr", "mai", "juin", "juil", "août", "sept", "oct", "nov", "déc"}, {"jan", "fev", "mar", "abr", "mai", "jun", "jul", "ago", "set", "out", "nov", "dez"}, {"jan", "feb", "mrt", "apr", "mei", "jun", "jul", "aug", "sep", "okt", "nov", "dec"}, {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"ene", "feb", "mar", "abr", "may", "jun", "jul", "ago", "sep", "oct", "nov", "dic"}};
		DAYS_OF_THE_WEEK = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
		java.util.Calendar.getInstance();
		Calendar_calendar = java.util.Calendar.getInstance(TimeZone.getTimeZone("GMT"));
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-2094888461"
	)
	public static int method4012(int var0) {
		--var0;
		var0 |= var0 >>> 1;
		var0 |= var0 >>> 2;
		var0 |= var0 >>> 4;
		var0 |= var0 >>> 8;
		var0 |= var0 >>> 16;
		return var0 + 1;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1281352540"
	)
	static void method4011() {
		if (Login.clearLoginScreen) {
			ModelData0.titleboxSprite = null;
			GrandExchangeOfferOwnWorldComparator.titlebuttonSprite = null;
			Login.runesSprite = null;
			Login.leftTitleSprite = null;
			Client.setLeftTitleSprite(-1);
			DirectByteArrayCopier.rightTitleSprite = null;
			Client.setRightTitleSprite(-1);
			class3.logoSprite = null;
			ArchiveDisk.title_muteSprite = null;
			class4.options_buttons_0Sprite = null;
			Login.options_buttons_2Sprite = null;
			class69.worldSelectBackSprites = null;
			GrandExchangeEvent.worldSelectFlagSprites = null;
			WorldMapDecoration.worldSelectArrows = null;
			class348.worldSelectStars = null;
			ItemContainer.field572 = null;
			MilliClock.loginScreenRunesAnimation.method1895();
			class206.field2406 = 1;
			class206.musicTrackArchive = null;
			class206.musicTrackGroupId = -1;
			class206.musicTrackFileId = -1;
			class219.musicTrackVolume = 0;
			GrandExchangeOfferUnitPriceComparator.musicTrackBoolean = false;
			AttackOption.field1187 = 2;
			if (NetCache.NetCache_socket != null) {
				try {
					Buffer var0 = new Buffer(4);
					var0.method5531(2);
					var0.method5588(0);
					NetCache.NetCache_socket.vmethod5878(var0.array, 0, 4);
				} catch (IOException var3) {
					try {
						NetCache.NetCache_socket.vmethod5866();
					} catch (Exception var2) {
					}

					++NetCache.NetCache_ioExceptions;
					NetCache.NetCache_socket = null;
				}
			}

			Login.clearLoginScreen = false;
		}
	}
}
