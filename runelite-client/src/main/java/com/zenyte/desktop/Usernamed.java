package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSUsernamed;

@ObfuscatedName("kt")
public interface Usernamed extends RSUsernamed {
	@ObfuscatedName("kd")
	@ObfuscatedSignature(
		signature = "(I)Lku;",
		garbageValue = "-1860083598"
	)
	Username vmethod5223();
}
