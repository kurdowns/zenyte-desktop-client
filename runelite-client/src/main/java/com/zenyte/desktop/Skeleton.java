package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSSkeleton;

@ObfuscatedName("eb")
public class Skeleton extends Node implements RSSkeleton {
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1117986987
	)
	int id;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1228230163
	)
	int count;
	@ObfuscatedName("k")
	int[] transformTypes;
	@ObfuscatedName("d")
	int[][] labels;

	Skeleton(int var1, byte[] var2) {
		this.id = var1;
		Buffer var3 = new Buffer(var2);
		this.count = var3.method5547();
		this.transformTypes = new int[this.count];
		this.labels = new int[this.count][];

		int var4;
		for (var4 = 0; var4 < this.count; ++var4) {
			this.transformTypes[var4] = var3.method5547();
		}

		for (var4 = 0; var4 < this.count; ++var4) {
			this.labels[var4] = new int[var3.method5547()];
		}

		for (var4 = 0; var4 < this.count; ++var4) {
			for (int var5 = 0; var5 < this.labels[var4].length; ++var5) {
				this.labels[var4][var5] = var3.method5547();
			}
		}

	}

	public int getCount() {
		return this.count;
	}

	public int[] getTypes() {
		return this.transformTypes;
	}

	public int[][] getList() {
		return this.labels;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
		garbageValue = "-801302607"
	)
	static void method3161(int var0, String var1, String var2) {
		ChatChannel.method2341(var0, var1, var2, (String)null);
	}

	@ObfuscatedName("hw")
	@ObfuscatedSignature(
		signature = "(IIIIIIIIII)V",
		garbageValue = "-903187990"
	)
	static final void method3160(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		PendingSpawn var9 = null;

		for (PendingSpawn var10 = (PendingSpawn)Client.pendingSpawns.method4931(); var10 != null; var10 = (PendingSpawn)Client.pendingSpawns.method4949()) {
			if (var0 == var10.plane && var10.x == var1 && var2 == var10.y && var3 == var10.type) {
				var9 = var10;
				break;
			}
		}

		if (var9 == null) {
			var9 = new PendingSpawn();
			var9.plane = var0;
			var9.type = var3;
			var9.x = var1;
			var9.y = var2;
			WorldMapSectionType.method348(var9);
			Client.pendingSpawns.method4952(var9);
		}

		var9.id = var4;
		var9.field967 = var5;
		var9.orientation = var6;
		var9.delay = var7;
		var9.hitpoints = var8;
	}
}
