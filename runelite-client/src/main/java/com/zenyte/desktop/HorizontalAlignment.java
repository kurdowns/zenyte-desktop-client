package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSHorizontalAlignment;

@ObfuscatedName("je")
public class HorizontalAlignment implements Enumerated, RSHorizontalAlignment {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lje;"
	)
	static final HorizontalAlignment field3458;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lje;"
	)
	static final HorizontalAlignment HorizontalAlignment_centered;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lje;"
	)
	static final HorizontalAlignment field3453;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1684971179
	)
	static int field3456;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1294886119
	)
	public final int value;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 834302777
	)
	final int id;

	static {
		field3458 = new HorizontalAlignment(2, 0);
		HorizontalAlignment_centered = new HorizontalAlignment(0, 1);
		field3453 = new HorizontalAlignment(1, 2);
	}

	HorizontalAlignment(int var1, int var2) {
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

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IIIB)J",
		garbageValue = "3"
	)
	static long method4753(int var0, int var1, int var2) {
		return (long)(var2 << 16 | var0 << 8 | var1);
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "([BI)[B",
		garbageValue = "-1597872585"
	)
	public static byte[] method4758(byte[] var0) {
		int var1 = var0.length;
		byte[] var2 = new byte[var1];
		System.arraycopy(var0, 0, var2, 0, var1);
		return var2;
	}
}
