package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSPlatformInfoProvider;

@ObfuscatedName("mm")
public interface PlatformInfoProvider extends RSPlatformInfoProvider {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(B)Lmq;",
		garbageValue = "1"
	)
	PlatformInfo vmethod6355();
}
