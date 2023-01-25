package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSStructDefinition;

@ObfuscatedName("jq")
public class StructDefinition extends DualNode implements RSStructDefinition {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	static AbstractArchive StructDefinition_archive;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	static EvictingDualNodeHashTable StructDefinition_cached;
	@ObfuscatedName("w")
	static int[] SpriteBuffer_yOffsets;
	@ObfuscatedName("p")
	static int[] Tiles_lightness;
	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	static IndexedSprite worldSelectRightSprite;
	@ObfuscatedName("gc")
	static int[] regions;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lln;"
	)
	IterableNodeHashTable params;

	static {
		StructDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	StructDefinition() {
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1990105365"
	)
	void method4585() {
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Lkb;B)V",
		garbageValue = "-61"
	)
	void method4563(Buffer var1) {
		while (true) {
			int var2 = var1.method5547();
			if (var2 == 0) {
				return;
			}

			this.method4561(var1, var2);
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lkb;II)V",
		garbageValue = "675280031"
	)
	void method4561(Buffer var1, int var2) {
		if (var2 == 249) {
			this.params = NetCache.method4375(var1, this.params);
		}

	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "1605132881"
	)
	public int method4564(int var1, int var2) {
		IterableNodeHashTable var4 = this.params;
		int var3;
		if (var4 == null) {
			var3 = var2;
		} else {
			IntegerNode var5 = (IntegerNode)var4.method5968((long)var1);
			if (var5 == null) {
				var3 = var2;
			} else {
				var3 = var5.integer;
			}
		}

		return var3;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)Ljava/lang/String;",
		garbageValue = "-1577444936"
	)
	public String method4562(int var1, String var2) {
		return class9.method122(this.params, var1, var2);
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(CS)C",
		garbageValue = "255"
	)
	static char method4565(char var0) {
		return var0 != 181 && var0 != 402 ? Character.toTitleCase(var0) : var0;
	}
}
