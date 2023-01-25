package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSBuddy;

@ObfuscatedName("ke")
public class Buddy extends User implements RSBuddy {
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1726409249
	)
	public int world;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1414783729
	)
	public int int2;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -25627413
	)
	public int rank;

	Buddy() {
		this.world = -1;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1769610141"
	)
	void method5213(int var1, int var2) {
		this.world = var1;
		this.int2 = var2;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "734760061"
	)
	public int method5214() {
		return this.world;
	}

	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-182915585"
	)
	public boolean method5215() {
		return this.world > 0;
	}

	public int getRSRank() {
		return this.rank;
	}

	public int getWorld() {
		return this.method5214();
	}
}
