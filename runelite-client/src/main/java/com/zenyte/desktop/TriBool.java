package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSTriBool;

@ObfuscatedName("kv")
public class TriBool implements RSTriBool {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lkv;"
	)
	public static final TriBool TriBool_unknown;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lkv;"
	)
	public static final TriBool TriBool_true;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lkv;"
	)
	public static final TriBool TriBool_false;

	static {
		TriBool_unknown = new TriBool();
		TriBool_true = new TriBool();
		TriBool_false = new TriBool();
	}

	TriBool() {
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1904373301"
	)
	static void method5225() {
		for (ObjectSound var0 = (ObjectSound)ObjectSound.objectSounds.method4931(); var0 != null; var0 = (ObjectSound)ObjectSound.objectSounds.method4949()) {
			if (var0.stream1 != null) {
				Tiles.pcmStreamMixer.method2386(var0.stream1);
				var0.stream1 = null;
			}

			if (var0.stream2 != null) {
				Tiles.pcmStreamMixer.method2386(var0.stream2);
				var0.stream2 = null;
			}
		}

		ObjectSound.objectSounds.method4925();
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lkj;B)V",
		garbageValue = "-100"
	)
	static final void method5226(PacketBuffer var0) {
		var0.method5496();
		int var1 = Client.localPlayerIndex;
		Player var10000 = Client.players[var1] = new Player();
		Client.cachedPlayersChanged(var1);
		ByteArrayPool.localPlayer = var10000;
		Player var2 = var10000;
		var2.index = var1;
		int var3 = var0.method5495(30);
		byte var4 = (byte)(var3 >> 28);
		int var5 = var3 >> 14 & 16383;
		int var6 = var3 & 16383;
		var2.pathX[0] = var5 - class69.baseX * 731242929;
		var2.x = (var2.pathX[0] << 7) + (var2.method1337() << 6);
		var2.pathY[0] = var6 - class89.baseY * 1825982697;
		var2.y = (var2.pathY[0] << 7) + (var2.method1337() << 6);
		ScriptEvent.Client_plane = var2.plane = var4;
		if (Players.field1269[var1] != null) {
			var2.method1330(Players.field1269[var1], -2042142749);
		}

		Players.Players_count = 0;
		Players.Players_indices[++Players.Players_count - 1] = var1;
		Players.field1267[var1] = 0;
		Players.Players_emptyIdxCount = 0;

		for (int var7 = 1; var7 < 2048; ++var7) {
			if (var1 != var7) {
				int var8 = var0.method5495(18);
				int var9 = var8 >> 16;
				int var10 = var8 >> 8 & 597;
				int var11 = var8 & 597;
				Players.Players_regions[var7] = (var10 << 14) + var11 + (var9 << 28);
				Players.Players_orientations[var7] = 0;
				Players.Players_targetIndices[var7] = -1;
				Players.Players_emptyIndices[++Players.Players_emptyIdxCount - 1] = var7;
				Players.field1267[var7] = 0;
			}
		}

		var0.method5498();
	}
}
