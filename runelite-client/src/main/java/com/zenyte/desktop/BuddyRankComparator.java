package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSBuddyRankComparator;

@ObfuscatedName("fg")
public class BuddyRankComparator extends AbstractUserComparator implements RSBuddyRankComparator {
	@ObfuscatedName("x")
	final boolean reversed;

	public BuddyRankComparator(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lke;Lke;I)I",
		garbageValue = "258923483"
	)
	int method3517(Buddy var1, Buddy var2) {
		if (var2.rank != var1.rank) {
			return this.reversed ? var1.rank - var2.rank : var2.rank - var1.rank;
		} else {
			return this.method5087(var1, var2);
		}
	}

	public int compare(Object var1, Object var2) {
		return this.method3517((Buddy)var1, (Buddy)var2);
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "16"
	)
	public static void method3519() {
		WorldMapElement.WorldMapElement_cachedSprites.method3413();
	}
}
