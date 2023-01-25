package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("im")
public class class234 {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "([Ljava/lang/String;[SB)V",
		garbageValue = "-127"
	)
	public static void method4197(String[] var0, short[] var1) {
		GrandExchangeOffer.method198(var0, var1, 0, var0.length - 1);
	}

	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)I",
		garbageValue = "-14"
	)
	public static int method4198(String var0) {
		return var0.length() + 1;
	}
}
