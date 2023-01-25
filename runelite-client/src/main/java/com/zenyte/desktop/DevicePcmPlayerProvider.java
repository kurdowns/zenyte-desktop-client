package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSDevicePcmPlayerProvider;

@ObfuscatedName("bd")
public class DevicePcmPlayerProvider implements PlayerProvider, RSDevicePcmPlayerProvider {
	DevicePcmPlayerProvider() {
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Ldw;",
		garbageValue = "65536"
	)
	public PcmPlayer vmethod2428() {
		return new DevicePcmPlayer();
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
		garbageValue = "-989870675"
	)
	public static String method948(CharSequence var0) {
		String var1 = Buffer.method5764(NetCache.method4376(var0));
		if (var1 == null) {
			var1 = "";
		}

		return var1;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lch;Lch;IZB)I",
		garbageValue = "1"
	)
	static int method945(World var0, World var1, int var2, boolean var3) {
		if (var2 == 1) {
			int var4 = var0.population;
			int var5 = var1.population;
			if (!var3) {
				if (var4 == -1) {
					var4 = 2001;
				}

				if (var5 == -1) {
					var5 = 2001;
				}
			}

			return var4 - var5;
		} else if (var2 == 2) {
			return var0.location - var1.location;
		} else if (var2 == 3) {
			if (var0.activity.equals("-")) {
				if (var1.activity.equals("-")) {
					return 0;
				} else {
					return var3 ? -1 : 1;
				}
			} else if (var1.activity.equals("-")) {
				return var3 ? 1 : -1;
			} else {
				return var0.activity.compareTo(var1.activity);
			}
		} else if (var2 == 4) {
			return var0.method1857() ? (var1.method1857() ? 0 : 1) : (var1.method1857() ? -1 : 0);
		} else if (var2 == 5) {
			return var0.method1855() ? (var1.method1855() ? 0 : 1) : (var1.method1855() ? -1 : 0);
		} else if (var2 == 6) {
			return var0.method1856() ? (var1.method1856() ? 0 : 1) : (var1.method1856() ? -1 : 0);
		} else if (var2 == 7) {
			return var0.method1886() ? (var1.method1886() ? 0 : 1) : (var1.method1886() ? -1 : 0);
		} else {
			return var0.id - var1.id;
		}
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "1003949082"
	)
	static final void method946(String var0) {
		GrandExchangeEvent.method165(var0 + " is already on your friend list");
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IIII)I",
		garbageValue = "137174344"
	)
	static final int method947(int var0, int var1, int var2) {
		if (var2 > 179) {
			var1 /= 2;
		}

		if (var2 > 192) {
			var1 /= 2;
		}

		if (var2 > 217) {
			var1 /= 2;
		}

		if (var2 > 243) {
			var1 /= 2;
		}

		int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
		return var3;
	}
}
