package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSObjectSound;

@ObfuscatedName("cm")
public final class ObjectSound extends Node implements RSObjectSound {
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Ljh;"
	)
	static NodeDeque objectSounds;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1413400591
	)
	int y;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1795590701
	)
	int plane;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -877292205
	)
	int x;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1466364365
	)
	int field1110;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -878503687
	)
	int field1100;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 2082519321
	)
	int field1106;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1984124175
	)
	int soundEffectId;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Ldy;"
	)
	RawPcmStream stream1;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -240636841
	)
	int field1104;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -901475347
	)
	int field1105;
	@ObfuscatedName("p")
	int[] soundEffectIds;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1043802301
	)
	int field1107;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Ldy;"
	)
	RawPcmStream stream2;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Ljw;"
	)
	ObjectDefinition obj;

	static {
		objectSounds = new NodeDeque();
	}

	ObjectSound() {
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "72"
	)
	void method2007() {
		int var1 = this.soundEffectId;
		ObjectDefinition var2 = this.obj.method4645();
		if (var2 != null) {
			this.soundEffectId = var2.ambientSoundId;
			this.field1106 = var2.int4 * 128;
			this.field1104 = var2.int5;
			this.field1105 = var2.int6;
			this.soundEffectIds = var2.soundEffectIds;
		} else {
			this.soundEffectId = -1;
			this.field1106 = 0;
			this.field1104 = 0;
			this.field1105 = 0;
			this.soundEffectIds = null;
		}

		if (var1 != this.soundEffectId && this.stream1 != null) {
			Tiles.pcmStreamMixer.method2386(this.stream1);
			this.stream1 = null;
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-1791981608"
	)
	static int method2002(int var0) {
		Message var1 = (Message)Messages.Messages_hashTable.method5968((long)var0);
		if (var1 == null) {
			return -1;
		} else {
			return var1.previousDual == Messages.Messages_queue.sentinel ? -1 : ((Message)var1.previousDual).count;
		}
	}
}
