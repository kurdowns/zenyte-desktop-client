package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSVerticalAlignment;

@ObfuscatedName("ie")
public class VerticalAlignment implements Enumerated, RSVerticalAlignment {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lie;"
	)
	static final VerticalAlignment field3193;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lie;"
	)
	static final VerticalAlignment VerticalAlignment_centered;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lie;"
	)
	static final VerticalAlignment field3196;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1209420553
	)
	public final int value;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1378606847
	)
	final int id;

	static {
		field3193 = new VerticalAlignment(0, 0);
		VerticalAlignment_centered = new VerticalAlignment(1, 1);
		field3196 = new VerticalAlignment(2, 2);
	}

	VerticalAlignment(int var1, int var2) {
		this.value = var1;
		this.id = var2;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "56"
	)
	public int vmethod6149() {
		return this.id;
	}

	@ObfuscatedName("fq")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1708311518"
	)
	static void method4415(int var0, int var1) {
		if (Client.musicVolume != 0 && var0 != -1) {
			ApproximateRouteStrategy.method1321(WorldMapRegion.archive11, var0, 0, Client.musicVolume, false);
			Client.field915 = true;
		}

	}
}
