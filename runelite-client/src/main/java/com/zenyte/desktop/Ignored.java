package com.zenyte.desktop;

import java.awt.FontMetrics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSIgnored;

@ObfuscatedName("km")
public class Ignored extends User implements RSIgnored {
	@ObfuscatedName("ab")
	static FontMetrics loginScreenFontMetrics;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1613598915
	)
	int id;

	Ignored() {
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lkm;I)I",
		garbageValue = "105996759"
	)
	int method5203(Ignored var1) {
		return this.id - var1.id;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(Ljd;I)I",
		garbageValue = "-1956183743"
	)
	public int vmethod5257(User var1) {
		return this.method5203((Ignored)var1);
	}

	public int compareTo(Object var1) {
		return this.method5203((Ignored)var1);
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-11"
	)
	static void method5211() {
		class335.SpriteBuffer_xOffsets = null;
		StructDefinition.SpriteBuffer_yOffsets = null;
		class335.SpriteBuffer_spriteWidths = null;
		class335.SpriteBuffer_spriteHeights = null;
		DefaultsGroup.SpriteBuffer_spritePalette = null;
		class4.SpriteBuffer_pixels = null;
	}
}
