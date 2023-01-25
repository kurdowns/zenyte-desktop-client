package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSAttackOption;

@ObfuscatedName("cb")
public class AttackOption implements Enumerated, RSAttackOption {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lcb;"
	)
	static final AttackOption AttackOption_dependsOnCombatLevels;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lcb;"
	)
	static final AttackOption AttackOption_alwaysRightClick;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lcb;"
	)
	static final AttackOption AttackOption_leftClickWhereAvailable;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lcb;"
	)
	static final AttackOption AttackOption_hidden;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1084826611
	)
	public static int field1187;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1589469367
	)
	static int field1182;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1155763571
	)
	final int id;

	static {
		AttackOption_dependsOnCombatLevels = new AttackOption(0);
		AttackOption_alwaysRightClick = new AttackOption(1);
		AttackOption_leftClickWhereAvailable = new AttackOption(2);
		AttackOption_hidden = new AttackOption(3);
	}

	AttackOption(int var1) {
		this.id = var1;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "56"
	)
	public int vmethod6149() {
		return this.id;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "2128537982"
	)
	static int method2143(int var0, int var1) {
		ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.method6010((long)var0);
		if (var2 == null) {
			return 0;
		} else if (var1 == -1) {
			return 0;
		} else {
			int var3 = 0;

			for (int var4 = 0; var4 < var2.quantities.length; ++var4) {
				if (var2.ids[var4] == var1) {
					var3 += var2.quantities[var4];
				}
			}

			return var3;
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)Lle;",
		garbageValue = "-2121463415"
	)
	static IndexedSprite method2151() {
		IndexedSprite var0 = new IndexedSprite();
		var0.width = class335.SpriteBuffer_spriteWidth;
		var0.height = class335.SpriteBuffer_spriteHeight;
		var0.xOffset = class335.SpriteBuffer_xOffsets[0];
		var0.yOffset = StructDefinition.SpriteBuffer_yOffsets[0];
		var0.subWidth = class335.SpriteBuffer_spriteWidths[0];
		var0.subHeight = class335.SpriteBuffer_spriteHeights[0];
		var0.palette = DefaultsGroup.SpriteBuffer_spritePalette;
		var0.pixels = class4.SpriteBuffer_pixels[0];
		Ignored.method5211();
		return var0;
	}
}
