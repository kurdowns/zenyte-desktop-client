package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSArchiveDiskActionHandler;

@ObfuscatedName("ip")
public class ArchiveDiskActionHandler implements Runnable, RSArchiveDiskActionHandler {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Ljh;"
	)
	public static NodeDeque ArchiveDiskActionHandler_requestQueue;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Ljh;"
	)
	public static NodeDeque ArchiveDiskActionHandler_responseQueue;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -191724831
	)
	public static int field3151;
	@ObfuscatedName("d")
	public static Object ArchiveDiskActionHandler_lock;

	static {
		ArchiveDiskActionHandler_requestQueue = new NodeDeque();
		ArchiveDiskActionHandler_responseQueue = new NodeDeque();
		field3151 = 0;
		ArchiveDiskActionHandler_lock = new Object();
	}

	ArchiveDiskActionHandler() {
	}

	public void run() {
		try {
			while (true) {
				ArchiveDiskAction var1;
				synchronized(ArchiveDiskActionHandler_requestQueue) {
					var1 = (ArchiveDiskAction)ArchiveDiskActionHandler_requestQueue.method4931();
				}

				if (var1 != null) {
					if (var1.type == 0) {
						var1.archiveDisk.method5896((int)var1.key, var1.data, var1.data.length);
						synchronized(ArchiveDiskActionHandler_requestQueue) {
							var1.method3657();
						}
					} else if (var1.type == 1) {
						var1.data = var1.archiveDisk.method5897((int)var1.key);
						synchronized(ArchiveDiskActionHandler_requestQueue) {
							ArchiveDiskActionHandler_responseQueue.method4952(var1);
						}
					}

					synchronized(ArchiveDiskActionHandler_lock) {
						if (field3151 <= 1) {
							field3151 = 0;
							ArchiveDiskActionHandler_lock.notifyAll();
							return;
						}

						field3151 = 600;
					}
				} else {
					class169.method3527(100L);
					synchronized(ArchiveDiskActionHandler_lock) {
						if (field3151 <= 1) {
							field3151 = 0;
							ArchiveDiskActionHandler_lock.notifyAll();
							return;
						}

						--field3151;
					}
				}
			}
		} catch (Exception var13) {
			WorldMapDecorationType.method4189((String)null, var13);
		}
	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)I",
		garbageValue = "-492522565"
	)
	public static int method4316(String var0) {
		return var0.length() + 2;
	}
}
