package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.rs.api.RSAbstractSound;

@ObfuscatedName("df")
public abstract class AbstractSound extends Node implements RSAbstractSound {
	@ObfuscatedName("v")
	int position;

	AbstractSound() {
	}
}
