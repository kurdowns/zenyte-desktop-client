package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.rs.api.RSIntegerNode;

@ObfuscatedName("gz")
public class IntegerNode extends Node implements RSIntegerNode {
	@ObfuscatedName("x")
	public int integer;

	public IntegerNode(int var1) {
		this.integer = var1;
	}

	public int getValue() {
		return this.integer;
	}

	public void setValue(int var1) {
		this.integer = var1;
	}
}
