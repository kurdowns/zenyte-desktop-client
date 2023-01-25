package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
public class class227 {
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lfs;"
	)
	protected static TaskHandler taskHandler;

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-673521466"
	)
	public static int method4176(int var0) {
		if (var0 > 0) {
			return 1;
		} else {
			return var0 < 0 ? -1 : 0;
		}
	}

	@ObfuscatedName("jd")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1891530232"
	)
	static final void method4160() {
		PacketBufferNode var0 = FaceNormal.method3363(ClientPacket.field2245, Client.packetWriter.isaacCipher);
		Client.packetWriter.method2361(var0);

		for (InterfaceParent var1 = (InterfaceParent)Client.interfaceParents.method5995(); var1 != null; var1 = (InterfaceParent)Client.interfaceParents.method6003()) {
			if (var1.type == 0 || var1.type == 3) {
				class41.method653(var1, true);
			}
		}

		if (Client.meslayerContinueWidget != null) {
			ItemContainer.method1273(Client.meslayerContinueWidget);
			Client.meslayerContinueWidget = null;
		}

	}
}
