package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSTextureLoader;

@ObfuscatedName("eu")
public interface TextureLoader extends RSTextureLoader {
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(II)[I",
		garbageValue = "-1464136827"
	)
	int[] vmethod3376(int var1);

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(IS)I",
		garbageValue = "-417"
	)
	int vmethod3372(int var1);

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "19136776"
	)
	boolean vmethod3374(int var1);

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "649013843"
	)
	boolean vmethod3380(int var1);
}
