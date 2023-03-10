package com.zenyte.desktop;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSWorldMapAreaData;

@ObfuscatedName("ad")
public class WorldMapAreaData extends WorldMapArea implements RSWorldMapAreaData {
	@ObfuscatedName("hc")
	@ObfuscatedSignature(
		signature = "[Lla;"
	)
	static Sprite[] mapMarkerSprites;
	@ObfuscatedName("n")
	HashSet worldMapData0Set;
	@ObfuscatedName("u")
	HashSet worldMapData1Set;
	@ObfuscatedName("h")
	List iconList;

	WorldMapAreaData() {
	}

	@ObfuscatedName("by")
	@ObfuscatedSignature(
		signature = "(Lkb;Lkb;IZI)V",
		garbageValue = "-661163942"
	)
	void method775(Buffer var1, Buffer var2, int var3, boolean var4) {
		this.method471(var1, var3);
		int var5 = var2.method5549();
		this.worldMapData0Set = new HashSet(var5);

		int var6;
		for (var6 = 0; var6 < var5; ++var6) {
			WorldMapData_0 var7 = new WorldMapData_0();

			try {
				var7.method264(var2);
			} catch (IllegalStateException var12) {
				continue;
			}

			this.worldMapData0Set.add(var7);
		}

		var6 = var2.method5549();
		this.worldMapData1Set = new HashSet(var6);

		for (int var10 = 0; var10 < var6; ++var10) {
			WorldMapData_1 var8 = new WorldMapData_1();

			try {
				var8.method801(var2);
			} catch (IllegalStateException var11) {
				continue;
			}

			this.worldMapData1Set.add(var8);
		}

		this.method774(var2, var4);
	}

	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		signature = "(Lkb;ZI)V",
		garbageValue = "1078269638"
	)
	void method774(Buffer var1, boolean var2) {
		this.iconList = new LinkedList();
		int var3 = var1.method5549();

		for (int var4 = 0; var4 < var3; ++var4) {
			int var5 = var1.method5564();
			Coord var6 = new Coord(var1.method5552());
			boolean var7 = var1.method5547() == 1;
			if (var2 || !var7) {
				this.iconList.add(new WorldMapIcon_0((Coord)null, var6, var5, (WorldMapLabel)null));
			}
		}

	}

	@ObfuscatedName("is")
	@ObfuscatedSignature(
		signature = "(Lhe;IIZS)V",
		garbageValue = "11869"
	)
	static void method781(Widget var0, int var1, int var2, boolean var3) {
		int var4 = var0.width;
		int var5 = var0.height;
		if (var0.widthAlignment == 0) {
			var0.width = var0.rawWidth;
		} else if (var0.widthAlignment == 1) {
			var0.width = var1 - var0.rawWidth;
		} else if (var0.widthAlignment == 2) {
			var0.width = var0.rawWidth * var1 >> 14;
		}

		if (var0.heightAlignment == 0) {
			var0.height = var0.rawHeight;
		} else if (var0.heightAlignment == 1) {
			var0.height = var2 - var0.rawHeight;
		} else if (var0.heightAlignment == 2) {
			var0.height = var2 * var0.rawHeight >> 14;
		}

		if (var0.widthAlignment == 4) {
			var0.width = var0.field2584 * var0.height / var0.field2585;
		}

		if (var0.heightAlignment == 4) {
			var0.height = var0.field2585 * var0.width / var0.field2584;
		}

		if (var0.contentType == 1337) {
			Client.viewportWidget = var0;
		}

		if (var3 && var0.onResize != null && (var4 != var0.width || var5 != var0.height)) {
			ScriptEvent var6 = new ScriptEvent();
			var6.widget = var0;
			var6.args = var0.onResize;
			Client.scriptEvents.method4952(var6);
		}

	}
}
