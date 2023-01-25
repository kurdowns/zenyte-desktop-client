package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSNPC;

@ObfuscatedName("ak")
public class class41 {
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "Lld;"
	)
	static Bounds field315;
	@ObfuscatedName("df")
	@ObfuscatedSignature(
		signature = "Lih;"
	)
	static Archive archive12;
	@ObfuscatedName("jd")
	@ObfuscatedSignature(
		signature = "Ldi;"
	)
	static TextureProvider textureProvider;

	@ObfuscatedName("gx")
	@ObfuscatedSignature(
		signature = "(Lcw;II)V"
	)
	static final void method649(Actor var0, int var1, int var2) {
		if (var0 instanceof RSNPC) {
			Client.lastSoundEffectSourceNPCid = ((RSNPC)var0).getId();
		}

		Client.lastSoundEffectSourceActor = var0;
		Client.copy$updateActorSequence(var0, var1, var2);
		Client.lastSoundEffectSourceActor = null;
	}

	@ObfuscatedName("jb")
	@ObfuscatedSignature(
		signature = "(Lbm;ZI)V",
		garbageValue = "590728412"
	)
	static final void method653(InterfaceParent var0, boolean var1) {
		int var2 = var0.group;
		int var3 = (int)var0.key;
		var0.method3657();
		if (var1) {
			EnumDefinition.method4590(var2);
		}

		LoginScreenAnimation.method1924(var2);
		Widget var4 = MusicPatchNode.method3898(var3);
		if (var4 != null) {
			ItemContainer.method1273(var4);
		}

		ChatChannel.method2340();
		if (Client.rootInterface != -1) {
			class198.method3714(Client.rootInterface, 1);
		}

	}

	@ObfuscatedName("kh")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
		garbageValue = "961112618"
	)
	static String method654(String var0, boolean var1) {
		String var2 = var1 ? "https://" : "http://";
		if (Client.gameBuild == 1) {
			var0 = var0 + "-wtrc";
		} else if (Client.gameBuild == 2) {
			var0 = var0 + "-wtqa";
		} else if (Client.gameBuild == 3) {
			var0 = var0 + "-wtwip";
		} else if (Client.gameBuild == 5) {
			var0 = var0 + "-wti";
		} else if (Client.gameBuild == 4) {
			var0 = "local";
		}

		String var3 = "";
		if (WorldMapData_0.field137 != null) {
			var3 = "/p=" + WorldMapData_0.field137;
		}

		String var4 = "runescape.com";
		return var2 + var0 + "." + var4 + "/l=" + IgnoreList.clientLanguage + "/a=" + KitDefinition.field3271 + var3 + "/";
	}
}
