package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSSoundEnvelope;

@ObfuscatedName("de")
public class SoundEnvelope implements RSSoundEnvelope {
	@ObfuscatedName("m")
	int segments;
	@ObfuscatedName("k")
	int[] durations;
	@ObfuscatedName("d")
	int[] phases;
	@ObfuscatedName("w")
	int start;
	@ObfuscatedName("v")
	int end;
	@ObfuscatedName("q")
	int form;
	@ObfuscatedName("z")
	int ticks;
	@ObfuscatedName("t")
	int phaseIndex;
	@ObfuscatedName("e")
	int step;
	@ObfuscatedName("s")
	int amplitude;
	@ObfuscatedName("p")
	int max;

	SoundEnvelope() {
		this.segments = 2;
		this.durations = new int[2];
		this.phases = new int[2];
		this.durations[0] = 0;
		this.durations[1] = 65535;
		this.phases[0] = 0;
		this.phases[1] = 65535;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lkb;)V"
	)
	final void method2581(Buffer var1) {
		this.form = var1.method5547();
		this.start = var1.method5552();
		this.end = var1.method5552();
		this.method2583(var1);
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lkb;)V"
	)
	final void method2583(Buffer var1) {
		this.segments = var1.method5547();
		this.durations = new int[this.segments];
		this.phases = new int[this.segments];

		for (int var2 = 0; var2 < this.segments; ++var2) {
			this.durations[var2] = var1.method5549();
			this.phases[var2] = var1.method5549();
		}

	}

	@ObfuscatedName("k")
	final void method2584() {
		this.ticks = 0;
		this.phaseIndex = 0;
		this.step = 0;
		this.amplitude = 0;
		this.max = 0;
	}

	@ObfuscatedName("d")
	final int method2585(int var1) {
		if (this.max >= this.ticks) {
			this.amplitude = this.phases[this.phaseIndex++] << 15;
			if (this.phaseIndex >= this.segments) {
				this.phaseIndex = this.segments - 1;
			}

			this.ticks = (int)((double)this.durations[this.phaseIndex] / 65536.0D * (double)var1);
			if (this.ticks > this.max) {
				this.step = ((this.phases[this.phaseIndex] << 15) - this.amplitude) / (this.ticks - this.max);
			}
		}

		this.amplitude += this.step;
		++this.max;
		return this.amplitude - this.step >> 15;
	}
}
