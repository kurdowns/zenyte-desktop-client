package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
public class class182 {
	@ObfuscatedName("k")
	public static int[][] directions;
	@ObfuscatedName("d")
	public static int[][] distances;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1538364035
	)
	public static int field2097;
	@ObfuscatedName("z")
	public static int[] bufferX;
	@ObfuscatedName("t")
	public static int[] bufferY;

	static {
		directions = new int[128][128];
		distances = new int[128][128];
		bufferX = new int[4096];
		bufferY = new int[4096];
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(II)[B",
		garbageValue = "130729022"
	)
	public static synchronized byte[] method3645(int var0) {
		return ByteArrayPool.method5805(var0, false);
	}
}
