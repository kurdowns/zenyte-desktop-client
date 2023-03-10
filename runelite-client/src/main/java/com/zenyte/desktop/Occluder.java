package com.zenyte.desktop;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSOccluder;

@ObfuscatedName("em")
public final class Occluder implements RSOccluder {
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1489465753
	)
	int minTileX;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -252661799
	)
	int maxTileX;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1056714957
	)
	int minTileY;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1875839743
	)
	int maxTileY;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1984874267
	)
	int type;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1069465565
	)
	int minX;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1744424635
	)
	int maxX;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -104326363
	)
	int minZ;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -470429171
	)
	int maxZ;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 2023575959
	)
	int minY;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1540730751
	)
	int maxY;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 223971517
	)
	int field1916;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1903761875
	)
	int field1917;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 2065104463
	)
	int field1914;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 213261407
	)
	int field1920;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1460776299
	)
	int field1908;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1267954519
	)
	int field1921;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -1266608785
	)
	int field1922;

	Occluder() {
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "(Lfs;III)Ldw;",
		garbageValue = "2138193849"
	)
	public static final PcmPlayer method3387(TaskHandler var0, int var1, int var2) {
		if (PcmPlayer.field1421 == 0) {
			throw new IllegalStateException();
		} else if (var1 >= 0 && var1 < 2) {
			if (var2 < 256) {
				var2 = 256;
			}

			try {
				PcmPlayer var3 = PcmPlayer.pcmPlayerProvider.vmethod2428();
				var3.samples = new int[(PcmPlayer.PcmPlayer_stereo ? 2 : 1) * 256];
				var3.field1431 = var2;
				var3.vmethod2529();
				var3.capacity = (var2 & -1024) + 1024;
				if (var3.capacity > 16384) {
					var3.capacity = 16384;
				}

				var3.vmethod2530(var3.capacity);
				if (PcmPlayer.field1423 > 0 && class332.soundSystem == null) {
					class332.soundSystem = new SoundSystem();
					PcmPlayer.soundSystemExecutor = Executors.newScheduledThreadPool(1);
					PcmPlayer.soundSystemExecutor.scheduleAtFixedRate(class332.soundSystem, 0L, 10L, TimeUnit.MILLISECONDS);
				}

				if (class332.soundSystem != null) {
					if (class332.soundSystem.players[var1] != null) {
						throw new IllegalArgumentException();
					}

					class332.soundSystem.players[var1] = var3;
				}

				return var3;
			} catch (Throwable var4) {
				return new PcmPlayer();
			}
		} else {
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("lc")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)Ljava/lang/String;",
		garbageValue = "880911904"
	)
	static String method3386(String var0) {
		PlayerType[] var1 = InterfaceParent.method1278();

		for (int var2 = 0; var2 < var1.length; ++var2) {
			PlayerType var3 = var1[var2];
			if (var3.modIcon != -1 && var0.startsWith(class1.method21(var3.modIcon))) {
				var0 = var0.substring(6 + Integer.toString(var3.modIcon).length());
				break;
			}
		}

		return var0;
	}
}
