package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSVertexNormal;

@ObfuscatedName("en")
public class VertexNormal implements RSVertexNormal {
	@ObfuscatedName("z")
	public static short[][] field1764;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1214687281
	)
	int y;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -412976723
	)
	int x;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1667952739
	)
	int z;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 284274911
	)
	int magnitude;

	VertexNormal() {
	}

	@ObfuscatedSignature(
		signature = "(Len;)V"
	)
	VertexNormal(VertexNormal var1) {
		this.x = var1.x;
		this.y = var1.y;
		this.z = var1.z;
		this.magnitude = var1.magnitude;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "([BI)Lkx;",
		garbageValue = "-1809526292"
	)
	public static Font method3080(byte[] var0) {
		if (var0 == null) {
			return null;
		} else {
			Font var1 = new Font(var0, class335.SpriteBuffer_xOffsets, StructDefinition.SpriteBuffer_yOffsets, class335.SpriteBuffer_spriteWidths, class335.SpriteBuffer_spriteHeights, DefaultsGroup.SpriteBuffer_spritePalette, class4.SpriteBuffer_pixels);
			Ignored.method5211();
			return var1;
		}
	}

	@ObfuscatedName("fu")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "-399"
	)
	static final void method3079() {
		if (Client.logoutTimer > 0) {
			Huffman.method4019();
		} else {
			Client.timer.method5026();
			MouseRecorder.method1293(40);
			UrlRequester.field1960 = Client.packetWriter.method2359();
			Client.packetWriter.method2350();
		}
	}
}
