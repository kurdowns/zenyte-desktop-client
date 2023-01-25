package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSVarps;

@ObfuscatedName("ht")
public class Varps implements RSVarps {
	@ObfuscatedName("x")
	static int[] Varps_masks;
	@ObfuscatedName("m")
	public static int[] Varps_temp;
	@ObfuscatedName("k")
	public static int[] Varps_main;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	static AbstractArchive Widget_spritesArchive;
	@ObfuscatedName("i")
	public static String[] field2522;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 675557919
	)
	public static int canvasHeight;

	static {
		Varps_masks = new int[32];
		int var0 = 2;

		for (int var1 = 0; var1 < 32; ++var1) {
			Varps_masks[var1] = var0 - 1;
			var0 += var0;
		}

		Varps_temp = new int[4000];
		Varps_main = new int[4000];
	}
}
