package com.zenyte.desktop;

import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSMessages;

@ObfuscatedName("ck")
public class Messages implements RSMessages {
	@ObfuscatedName("x")
	static final Map Messages_channels;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lln;"
	)
	static final IterableNodeHashTable Messages_hashTable;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Ljz;"
	)
	static final IterableDualNodeQueue Messages_queue;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 211996087
	)
	static int Messages_count;

	static {
		Messages_channels = new HashMap();
		Messages_hashTable = new IterableNodeHashTable(1024);
		Messages_queue = new IterableDualNodeQueue();
		Messages_count = 0;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "479861963"
	)
	static void method2316(int var0, int var1, int var2, int var3) {
		ItemContainer var4 = (ItemContainer)ItemContainer.itemContainers.method6010((long)var0);
		if (var4 == null) {
			var4 = new ItemContainer();
			ItemContainer.itemContainers.method5997(var4, (long)var0);
		}

		if (var4.ids.length <= var1) {
			int[] var5 = new int[var1 + 1];
			int[] var6 = new int[var1 + 1];

			int var7;
			for (var7 = 0; var7 < var4.ids.length; ++var7) {
				var5[var7] = var4.ids[var7];
				var6[var7] = var4.quantities[var7];
			}

			for (var7 = var4.ids.length; var7 < var1; ++var7) {
				var5[var7] = -1;
				var6[var7] = 0;
			}

			var4.ids = var5;
			var4.quantities = var6;
		}

		var4.ids[var1] = var2;
		var4.quantities[var1] = var3;
	}

	@ObfuscatedName("gq")
	@ObfuscatedSignature(
		signature = "(ZB)V",
		garbageValue = "32"
	)
	static final void method2315(boolean var0) {
		for (int var1 = 0; var1 < Client.npcCount; ++var1) {
			NPC var2 = Client.npcs[Client.npcIndices[var1]];
			if (var2 != null && var2.vmethod2118() && var2.definition.isVisible == var0 && var2.definition.method4767()) {
				int var3 = var2.x >> 7;
				int var4 = var2.y >> 7;
				if (var3 >= 0 && var3 < 104 && var4 >= 0 && var4 < 104) {
					if (var2.field976 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
						if (Client.tileLastDrawnActor[var3][var4] == Client.viewportDrawCount) {
							continue;
						}

						Client.tileLastDrawnActor[var3][var4] = Client.viewportDrawCount;
					}

					long var5 = IsaacCipher.method6337(0, 0, 1, !var2.definition.isInteractable, Client.npcIndices[var1]);
					var2.playerCycle = Client.cycle;
					GrandExchangeOfferWorldComparator.scene.method3174(ScriptEvent.Client_plane, var2.x, var2.y, class277.method5013(var2.field976 * 64 - 64 + var2.x, var2.field976 * 64 - 64 + var2.y, ScriptEvent.Client_plane), var2.field976 * 64 - 64 + 60, var2, var2.rotation, var5, var2.isWalking);
				}
			}
		}

	}

	@ObfuscatedName("jh")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "803924766"
	)
	static boolean method2308(int var0) {
		for (int var1 = 0; var1 < Client.field901; ++var1) {
			if (Client.field872[var1] == var0) {
				return true;
			}
		}

		return false;
	}
}
