package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSUserComparator6;

@ObfuscatedName("fx")
public class UserComparator6 extends AbstractUserComparator implements RSUserComparator6 {
	@ObfuscatedName("s")
	static int[] Tiles_saturation;
	@ObfuscatedName("x")
	final boolean reversed;

	public UserComparator6(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lke;Lke;I)I",
		garbageValue = "1973806284"
	)
	int method3523(Buddy var1, Buddy var2) {
		if (var1.world != 0 && var2.world != 0) {
			return this.reversed ? var1.method5068().method5240(var2.method5068()) : var2.method5068().method5240(var1.method5068());
		} else {
			return this.method5087(var1, var2);
		}
	}

	public int compare(Object var1, Object var2) {
		return this.method3523((Buddy)var1, (Buddy)var2);
	}
}
