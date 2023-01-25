package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSDualNode;

@ObfuscatedName("ge")
public class DualNode extends Node implements RSDualNode {
	@ObfuscatedName("cz")
	public long keyDual;
	@ObfuscatedName("cb")
	@ObfuscatedSignature(
		signature = "Lge;"
	)
	public DualNode previousDual;
	@ObfuscatedName("cy")
	@ObfuscatedSignature(
		signature = "Lge;"
	)
	public DualNode nextDual;

	public void unlinkDual() {
		this.method3653();
	}

	@ObfuscatedName("cz")
	public void method3653() {
		if (this.nextDual != null) {
			this.nextDual.previousDual = this.previousDual;
			this.previousDual.nextDual = this.nextDual;
			this.previousDual = null;
			this.nextDual = null;
		}
	}
}
