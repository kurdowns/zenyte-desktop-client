package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSScript;

@ObfuscatedName("ce")
public class class101 extends DualNode implements RSScript {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	static EvictingDualNodeHashTable Script_cached;
	@ObfuscatedName("ej")
	static String worldHost;
	@ObfuscatedName("fs")
	@ObfuscatedSignature(
		signature = "Lkx;"
	)
	static Font fontPlain11;
	@ObfuscatedName("m")
	int[] opcodes;
	@ObfuscatedName("k")
	int[] intOperands;
	@ObfuscatedName("d")
	String[] stringOperands;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1902344849
	)
	int localIntCount;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1904164233
	)
	int localStringCount;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -335811903
	)
	int intArgumentCount;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 931655197
	)
	int stringArgumentCount;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "[Lln;"
	)
	IterableNodeHashTable[] switches;

	static {
		Script_cached = new EvictingDualNodeHashTable(128);
	}

	class101() {
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(II)[Lln;",
		garbageValue = "-1946257941"
	)
	IterableNodeHashTable[] method2325(int var1) {
		return new IterableNodeHashTable[var1];
	}

	public int[] getInstructions() {
		return this.opcodes;
	}

	public int[] getIntOperands() {
		return this.intOperands;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZZI)V",
		garbageValue = "189719634"
	)
	public static void method2322(String var0, boolean var1, boolean var2) {
		class224.method4101(var0, var1, "openjs", var2);
	}
}
