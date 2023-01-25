package com.zenyte.desktop;

import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ig")
public final class class236 {
	@ObfuscatedName("ju")
	@ObfuscatedSignature(
		signature = "Lhe;"
	)
	static Widget dragInventoryWidget;

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(BI)C",
		garbageValue = "-1712005839"
	)
	public static char method4199(byte var0) {
		int var1 = var0 & 255;
		if (var1 == 0) {
			throw new IllegalArgumentException("" + Integer.toString(var1, 16));
		} else {
			if (var1 >= 128 && var1 < 160) {
				char var2 = class297.cp1252AsciiExtension[var1 - 128];
				if (var2 == 0) {
					var2 = '?';
				}

				var1 = var2;
			}

			return (char)var1;
		}
	}

	@ObfuscatedName("kr")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "75"
	)
	static final void method4200() {
		for (int var0 = 0; var0 < Players.Players_count; ++var0) {
			Player var1 = Client.players[Players.Players_indices[var0]];
			var1.method1332();
		}

		Iterator var2 = Messages.Messages_hashTable.iterator();

		while (var2.hasNext()) {
			Message var3 = (Message)var2.next();
			var3.method1311();
		}

		if (InterfaceParent.clanChat != null) {
			InterfaceParent.clanChat.method5275();
		}

	}
}
