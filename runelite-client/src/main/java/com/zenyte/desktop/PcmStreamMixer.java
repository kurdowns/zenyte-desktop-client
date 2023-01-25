package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSPcmStream;
import net.runelite.rs.api.RSPcmStreamMixer;

@ObfuscatedName("dz")
public class PcmStreamMixer extends PcmStream implements RSPcmStreamMixer {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Ljh;"
	)
	NodeDeque subStreams;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Ljh;"
	)
	NodeDeque field1357;
	@ObfuscatedName("k")
	int field1358;
	@ObfuscatedName("d")
	int field1355;

	public PcmStreamMixer() {
		this.subStreams = new NodeDeque();
		this.field1357 = new NodeDeque();
		this.field1358 = 0;
		this.field1355 = -1;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lds;)V"
	)
	public final synchronized void method2385(PcmStream var1) {
		this.subStreams.method4927(var1);
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lds;)V"
	)
	public final synchronized void method2386(PcmStream var1) {
		var1.method3657();
	}

	@ObfuscatedName("k")
	void method2387() {
		if (this.field1358 > 0) {
			for (PcmStreamMixerListener var1 = (PcmStreamMixerListener)this.field1357.method4931(); var1 != null; var1 = (PcmStreamMixerListener)this.field1357.method4949()) {
				var1.field1466 -= this.field1358;
			}

			this.field1355 -= this.field1358;
			this.field1358 = 0;
		}

	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Lga;Ldo;)V"
	)
	void method2388(Node var1, PcmStreamMixerListener var2) {
		while (this.field1357.sentinel != var1 && ((PcmStreamMixerListener)var1).field1466 <= var2.field1466) {
			var1 = var1.previous;
		}

		NodeDeque.method4928(var2, var1);
		this.field1355 = ((PcmStreamMixerListener)this.field1357.sentinel.previous).field1466;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Ldo;)V"
	)
	void method2389(PcmStreamMixerListener var1) {
		var1.method3657();
		var1.method2610();
		Node var2 = this.field1357.sentinel.previous;
		if (var2 == this.field1357.sentinel) {
			this.field1355 = -1;
		} else {
			this.field1355 = ((PcmStreamMixerListener)var2).field1466;
		}

	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "()Lds;"
	)
	protected PcmStream vmethod3962() {
		return (PcmStream)this.subStreams.method4931();
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "()Lds;"
	)
	protected PcmStream vmethod3964() {
		return (PcmStream)this.subStreams.method4949();
	}

	@ObfuscatedName("z")
	protected int vmethod3963() {
		return 0;
	}

	@ObfuscatedName("t")
	public final synchronized void vmethod3966(int[] var1, int var2, int var3) {
		do {
			if (this.field1355 < 0) {
				this.method2398(var1, var2, var3);
				return;
			}

			if (var3 + this.field1358 < this.field1355) {
				this.field1358 += var3;
				this.method2398(var1, var2, var3);
				return;
			}

			int var4 = this.field1355 - this.field1358;
			this.method2398(var1, var2, var4);
			var2 += var4;
			var3 -= var4;
			this.field1358 += var4;
			this.method2387();
			PcmStreamMixerListener var5 = (PcmStreamMixerListener)this.field1357.method4931();
			synchronized(var5) {
				int var7 = var5.method2611();
				if (var7 < 0) {
					var5.field1466 = 0;
					this.method2389(var5);
				} else {
					var5.field1466 = var7;
					this.method2388(var5.previous, var5);
				}
			}
		} while(var3 != 0);

	}

	@ObfuscatedName("e")
	void method2398(int[] var1, int var2, int var3) {
		for (PcmStream var4 = (PcmStream)this.subStreams.method4931(); var4 != null; var4 = (PcmStream)this.subStreams.method4949()) {
			var4.method2810(var1, var2, var3);
		}

	}

	@ObfuscatedName("s")
	public final synchronized void vmethod3967(int var1) {
		do {
			if (this.field1355 < 0) {
				this.method2396(var1);
				return;
			}

			if (this.field1358 + var1 < this.field1355) {
				this.field1358 += var1;
				this.method2396(var1);
				return;
			}

			int var2 = this.field1355 - this.field1358;
			this.method2396(var2);
			var1 -= var2;
			this.field1358 += var2;
			this.method2387();
			PcmStreamMixerListener var3 = (PcmStreamMixerListener)this.field1357.method4931();
			synchronized(var3) {
				int var5 = var3.method2611();
				if (var5 < 0) {
					var3.field1466 = 0;
					this.method2389(var3);
				} else {
					var3.field1466 = var5;
					this.method2388(var3.previous, var3);
				}
			}
		} while(var1 != 0);

	}

	@ObfuscatedName("p")
	void method2396(int var1) {
		for (PcmStream var2 = (PcmStream)this.subStreams.method4931(); var2 != null; var2 = (PcmStream)this.subStreams.method4949()) {
			var2.vmethod3967(var1);
		}

	}

	public void addSubStream(RSPcmStream var1) {
		this.method2385((PcmStream)var1);
	}
}
