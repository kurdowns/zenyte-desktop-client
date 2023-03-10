package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSByteArrayPool;

@ObfuscatedName("kl")
public class ByteArrayPool implements RSByteArrayPool {
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1085221259
	)
	static int ByteArrayPool_smallCount;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1727061429
	)
	static int ByteArrayPool_mediumCount;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 13537333
	)
	static int ByteArrayPool_largeCount;
	@ObfuscatedName("d")
	static byte[][] ByteArrayPool_small;
	@ObfuscatedName("w")
	static byte[][] ByteArrayPool_medium;
	@ObfuscatedName("v")
	static byte[][] ByteArrayPool_large;
	@ObfuscatedName("z")
	public static int[] ByteArrayPool_altSizeArrayCounts;
	@ObfuscatedName("t")
	public static byte[][][] ByteArrayPool_arrays;
	@ObfuscatedName("kv")
	@ObfuscatedSignature(
		signature = "Lbi;"
	)
	static Player localPlayer;

	static {
		ByteArrayPool_smallCount = 0;
		ByteArrayPool_mediumCount = 0;
		ByteArrayPool_largeCount = 0;
		ByteArrayPool_small = new byte[1000][];
		ByteArrayPool_medium = new byte[250][];
		ByteArrayPool_large = new byte[50][];
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IZI)[B",
		garbageValue = "1813888671"
	)
	static synchronized byte[] method5805(int var0, boolean var1) {
		byte[] var2;
		if (var0 != 100) {
			if (var0 < 100) {
			}
		} else if (ByteArrayPool_smallCount > 0) {
			var2 = ByteArrayPool_small[--ByteArrayPool_smallCount];
			ByteArrayPool_small[ByteArrayPool_smallCount] = null;
			return var2;
		}

		if (var0 != 5000) {
			if (var0 < 5000) {
			}
		} else if (ByteArrayPool_mediumCount > 0) {
			var2 = ByteArrayPool_medium[--ByteArrayPool_mediumCount];
			ByteArrayPool_medium[ByteArrayPool_mediumCount] = null;
			return var2;
		}

		if (var0 != 30000) {
			if (var0 < 30000) {
			}
		} else if (ByteArrayPool_largeCount > 0) {
			var2 = ByteArrayPool_large[--ByteArrayPool_largeCount];
			ByteArrayPool_large[ByteArrayPool_largeCount] = null;
			return var2;
		}

		if (ByteArrayPool_arrays != null) {
			for (int var4 = 0; var4 < RunException.ByteArrayPool_alternativeSizes.length; ++var4) {
				if (RunException.ByteArrayPool_alternativeSizes[var4] != var0) {
					if (var0 < RunException.ByteArrayPool_alternativeSizes[var4]) {
					}
				} else if (ByteArrayPool_altSizeArrayCounts[var4] > 0) {
					byte[] var3 = ByteArrayPool_arrays[var4][--ByteArrayPool_altSizeArrayCounts[var4]];
					ByteArrayPool_arrays[var4][ByteArrayPool_altSizeArrayCounts[var4]] = null;
					return var3;
				}
			}
		}

		return new byte[var0];
	}
}
