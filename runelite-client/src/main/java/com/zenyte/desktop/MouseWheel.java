package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSMouseWheel;

@ObfuscatedName("fq")
public interface MouseWheel extends RSMouseWheel {
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "65280"
	)
	int vmethod3573();
}
