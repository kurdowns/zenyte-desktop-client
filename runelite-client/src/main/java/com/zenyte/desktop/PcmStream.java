package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSPcmStream;

@ObfuscatedName("ds")
public abstract class PcmStream extends Node implements RSPcmStream {
	@ObfuscatedName("w")
	volatile boolean active;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lds;"
	)
	PcmStream after;
	@ObfuscatedName("a")
	int field1507;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Ldf;"
	)
	AbstractSound sound;

	protected PcmStream() {
		this.active = true;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "()Lds;"
	)
	protected abstract PcmStream vmethod3962();

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "()Lds;"
	)
	protected abstract PcmStream vmethod3964();

	@ObfuscatedName("z")
	protected abstract int vmethod3963();

	@ObfuscatedName("t")
	protected abstract void vmethod3966(int[] var1, int var2, int var3);

	@ObfuscatedName("s")
	protected abstract void vmethod3967(int var1);

	@ObfuscatedName("ac")
	int vmethod2806() {
		return 255;
	}

	@ObfuscatedName("fk")
	final void method2810(int[] var1, int var2, int var3) {
		if (this.active) {
			this.vmethod3966(var1, var2, var3);
		} else {
			this.vmethod3967(var3);
		}

	}
}
