package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hr")
public class class231 {
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IB)Liq;",
		garbageValue = "111"
	)
	public static InvDefinition method4193(int var0) {
		InvDefinition var1 = (InvDefinition)InvDefinition.InvDefinition_cached.method3418((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = InvDefinition.InvDefinition_archive.method4224(5, var0, (byte)-81);
			var1 = new InvDefinition();
			if (var2 != null) {
				var1.method4417(new Buffer(var2));
			}

			InvDefinition.InvDefinition_cached.method3424(var1, (long)var0);
			return var1;
		}
	}
}
