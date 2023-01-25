package com.zenyte.desktop;

import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kg")
public class class303 {
	@ObfuscatedName("hh")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "83308919"
	)
	static final void method5370(boolean var0) {
		ChatChannel.method2342();
		++Client.packetWriter.pendingWrites;
		if (Client.packetWriter.pendingWrites >= 50 || var0) {
			Client.packetWriter.pendingWrites = 0;
			if (!Client.field728 && Client.packetWriter.method2359() != null) {
				PacketBufferNode var1 = FaceNormal.method3363(ClientPacket.field2295, Client.packetWriter.isaacCipher);
				Client.packetWriter.method2361(var1);

				try {
					Client.packetWriter.method2346();
				} catch (IOException var3) {
					Client.field728 = true;
				}
			}

		}
	}
}
