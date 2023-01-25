package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSDefaultsGroup;

@ObfuscatedName("lf")
public class DefaultsGroup implements RSDefaultsGroup {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Llf;"
	)
	static final DefaultsGroup field3811;
	@ObfuscatedName("z")
	static int[] SpriteBuffer_spritePalette;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1057296275
	)
	final int group;

	static {
		field3811 = new DefaultsGroup(3);
	}

	DefaultsGroup(int var1) {
		this.group = var1;
	}
}
