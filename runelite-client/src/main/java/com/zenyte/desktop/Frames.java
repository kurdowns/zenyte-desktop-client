package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSAnimation;
import net.runelite.rs.api.RSFrames;

@ObfuscatedName("ef")
public class Frames extends DualNode implements RSFrames {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "[Leh;"
	)
	Animation[] frames;

	@ObfuscatedSignature(
		signature = "(Liy;Liy;IZ)V",
		garbageValue = "0"
	)
	public Frames(AbstractArchive var1, AbstractArchive var2, int var3, boolean var4) {
		NodeDeque var5 = new NodeDeque();
		int var6 = var1.method4246(var3);
		this.frames = new Animation[var6];
		int[] var7 = var1.method4234(var3);

		for (int var8 = 0; var8 < var7.length; ++var8) {
			byte[] var9 = var1.method4224(var3, var7[var8], (byte)-98);
			Skeleton var10 = null;
			int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

			for (Skeleton var12 = (Skeleton)var5.method4931(); var12 != null; var12 = (Skeleton)var5.method4949()) {
				if (var11 == var12.id) {
					var10 = var12;
					break;
				}
			}

			if (var10 == null) {
				byte[] var13 = var2.method4232(var11, 0);
				var10 = new Skeleton(var11, var13);
				var5.method4952(var10);
			}

			this.frames[var7[var8]] = new Animation(var9, var10);
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "861900150"
	)
	public boolean method3368(int var1) {
		return this.frames[var1].hasAlphaTransform;
	}

	public RSAnimation[] getFrames() {
		return this.frames;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lih;IIIBZI)V",
		garbageValue = "-626508532"
	)
	static void method3371(Archive var0, int var1, int var2, int var3, byte var4, boolean var5) {
		long var6 = (long)((var1 << 16) + var2);
		NetFileRequest var8 = (NetFileRequest)NetCache.NetCache_pendingPriorityWrites.method6010(var6);
		if (var8 == null) {
			var8 = (NetFileRequest)NetCache.NetCache_pendingPriorityResponses.method6010(var6);
			if (var8 == null) {
				var8 = (NetFileRequest)NetCache.NetCache_pendingWrites.method6010(var6);
				if (var8 != null) {
					if (var5) {
						var8.method3653();
						NetCache.NetCache_pendingPriorityWrites.method5997(var8, var6);
						--NetCache.NetCache_pendingWritesCount;
						++NetCache.NetCache_pendingPriorityWritesCount;
					}

				} else {
					if (!var5) {
						var8 = (NetFileRequest)NetCache.NetCache_pendingResponses.method6010(var6);
						if (var8 != null) {
							return;
						}
					}

					var8 = new NetFileRequest();
					var8.archive = var0;
					var8.crc = var3;
					var8.padding = var4;
					if (var5) {
						NetCache.NetCache_pendingPriorityWrites.method5997(var8, var6);
						++NetCache.NetCache_pendingPriorityWritesCount;
					} else {
						NetCache.NetCache_pendingWritesQueue.method4850(var8);
						NetCache.NetCache_pendingWrites.method5997(var8, var6);
						++NetCache.NetCache_pendingWritesCount;
					}

				}
			}
		}
	}
}
