package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSUserComparator10;

@ObfuscatedName("fi")
public class UserComparator10 extends AbstractUserComparator implements RSUserComparator10 {
	@ObfuscatedName("x")
	final boolean reversed;

	public UserComparator10(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lke;Lke;I)I",
		garbageValue = "1762023297"
	)
	int method3491(Buddy var1, Buddy var2) {
		if (Client.worldId == var1.world && var2.world == Client.worldId) {
			return this.reversed ? var1.int2 - var2.int2 : var2.int2 - var1.int2;
		} else {
			return this.method5087(var1, var2);
		}
	}

	public int compare(Object var1, Object var2) {
		return this.method3491((Buddy)var1, (Buddy)var2);
	}
}
