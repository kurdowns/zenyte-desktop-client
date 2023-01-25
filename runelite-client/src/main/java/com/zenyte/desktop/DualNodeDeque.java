package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSDualNodeDeque;

@ObfuscatedName("jl")
public final class DualNodeDeque implements RSDualNodeDeque {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lge;"
	)
	DualNode sentinel;

	public DualNodeDeque() {
		this.sentinel = new DualNode();
		this.sentinel.previousDual = this.sentinel;
		this.sentinel.nextDual = this.sentinel;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lge;)V"
	)
	public void method4850(DualNode var1) {
		if (var1.nextDual != null) {
			var1.method3653();
		}

		var1.nextDual = this.sentinel.nextDual;
		var1.previousDual = this.sentinel;
		var1.nextDual.previousDual = var1;
		var1.previousDual.nextDual = var1;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lge;)V"
	)
	public void method4851(DualNode var1) {
		if (var1.nextDual != null) {
			var1.method3653();
		}

		var1.nextDual = this.sentinel;
		var1.previousDual = this.sentinel.previousDual;
		var1.nextDual.previousDual = var1;
		var1.previousDual.nextDual = var1;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "()Lge;"
	)
	public DualNode method4854() {
		DualNode var1 = this.sentinel.previousDual;
		return var1 == this.sentinel ? null : var1;
	}
}
