package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSGameBuild;

@ObfuscatedName("ii")
public class GameBuild implements RSGameBuild {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	static final GameBuild LIVE;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	static final GameBuild BUILDLIVE;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	static final GameBuild RC;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	static final GameBuild WIP;
	@ObfuscatedName("w")
	public final String name;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1808149537
	)
	final int buildId;

	static {
		LIVE = new GameBuild("LIVE", 0);
		BUILDLIVE = new GameBuild("BUILDLIVE", 3);
		RC = new GameBuild("RC", 1);
		WIP = new GameBuild("WIP", 2);
	}

	GameBuild(String var1, int var2) {
		this.name = var1;
		this.buildId = var2;
	}
}
