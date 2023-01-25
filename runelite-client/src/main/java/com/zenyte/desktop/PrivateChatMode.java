package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSPrivateChatMode;

@ObfuscatedName("lg")
public class PrivateChatMode implements RSPrivateChatMode {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Llg;"
	)
	static final PrivateChatMode field3801;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Llg;"
	)
	public static final PrivateChatMode field3806;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Llg;"
	)
	static final PrivateChatMode field3803;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	public static AbstractArchive ItemDefinition_archive;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1679462339
	)
	public final int field3804;

	static {
		field3801 = new PrivateChatMode(0);
		field3806 = new PrivateChatMode(1);
		field3803 = new PrivateChatMode(2);
	}

	PrivateChatMode(int var1) {
		this.field3804 = var1;
	}

	@ObfuscatedName("kx")
	@ObfuscatedSignature(
		signature = "(Lhe;B)Ljava/lang/String;",
		garbageValue = "70"
	)
	static String method5931(Widget var0) {
		if (WorldMapRectangle.method388(ScriptEvent.method1283(var0)) == 0) {
			return null;
		} else {
			return var0.spellActionName != null && var0.spellActionName.trim().length() != 0 ? var0.spellActionName : null;
		}
	}
}
