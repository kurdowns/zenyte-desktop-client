package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSVarbitDefinition;

@ObfuscatedName("iu")
public class VarbitDefinition extends DualNode implements RSVarbitDefinition {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	public static AbstractArchive VarbitDefinition_archive;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	public static EvictingDualNodeHashTable VarbitDefinition_cached;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -927244413
	)
	public int baseVar;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -326860353
	)
	public int startBit;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1659687913
	)
	public int endBit;

	static {
		VarbitDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lkb;B)V",
		garbageValue = "113"
	)
	public void method4536(Buffer var1) {
		while (true) {
			int var2 = var1.method5547();
			if (var2 == 0) {
				return;
			}

			this.method4537(var1, var2);
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lkb;II)V",
		garbageValue = "842018241"
	)
	void method4537(Buffer var1, int var2) {
		if (var2 == 1) {
			this.baseVar = var1.method5549();
			this.startBit = var1.method5547();
			this.endBit = var1.method5547();
		}

	}

	public int getIndex() {
		return this.baseVar;
	}

	public int getLeastSignificantBit() {
		return this.startBit;
	}

	public int getMostSignificantBit() {
		return this.endBit;
	}
}
