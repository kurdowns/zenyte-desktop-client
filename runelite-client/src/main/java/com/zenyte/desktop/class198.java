package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
public class class198 {
	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	static GameBuild field2353;

	@ObfuscatedName("jk")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "1"
	)
	static final void method3714(int var0, int var1) {
		if (LoginScreenAnimation.method1900(var0)) {
			SecureRandomCallable.method1251(Widget.Widget_interfaceComponents[var0], var1);
		}
	}
}
