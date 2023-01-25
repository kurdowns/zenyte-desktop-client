package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSHealthBar;
import net.runelite.rs.api.RSHealthBarDefinition;
import net.runelite.rs.api.RSIterableNodeDeque;

@ObfuscatedName("cg")
public class HealthBar extends Node implements RSHealthBar {
	@ObfuscatedName("rf")
	@ObfuscatedGetter(
		intValue = -1163501961
	)
	static int field1145;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lid;"
	)
	HealthBarDefinition definition;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Ljm;"
	)
	IterableNodeDeque updates;

	@ObfuscatedSignature(
		signature = "(Lid;)V"
	)
	HealthBar(HealthBarDefinition var1) {
		this.updates = new IterableNodeDeque();
		this.definition = var1;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IIIIB)V",
		garbageValue = "86"
	)
	void method2111(int var1, int var2, int var3, int var4) {
		HealthBarUpdate var5 = null;
		int var6 = 0;

		for (HealthBarUpdate var7 = (HealthBarUpdate)this.updates.method4860(); var7 != null; var7 = (HealthBarUpdate)this.updates.method4915()) {
			++var6;
			if (var7.cycle == var1) {
				var7.method1848(var1, var2, var3, var4);
				return;
			}

			if (var7.cycle <= var1) {
				var5 = var7;
			}
		}

		if (var5 == null) {
			if (var6 < 4) {
				this.updates.method4880(new HealthBarUpdate(var1, var2, var3, var4));
			}

		} else {
			IterableNodeDeque.method4893(new HealthBarUpdate(var1, var2, var3, var4), var5);
			if (var6 >= 4) {
				this.updates.method4860().method3657();
			}

		}
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(II)Lcc;",
		garbageValue = "1772939720"
	)
	HealthBarUpdate method2115(int var1) {
		HealthBarUpdate var2 = (HealthBarUpdate)this.updates.method4860();
		if (var2 != null && var2.cycle <= var1) {
			for (HealthBarUpdate var3 = (HealthBarUpdate)this.updates.method4915(); var3 != null && var3.cycle <= var1; var3 = (HealthBarUpdate)this.updates.method4915()) {
				var2.method3657();
				var2 = var3;
			}

			if (this.definition.int5 + var2.cycle + var2.cycleOffset > var1) {
				return var2;
			} else {
				var2.method3657();
				return null;
			}
		} else {
			return null;
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1327552245"
	)
	boolean method2112() {
		return this.updates.method4867();
	}

	public RSHealthBarDefinition getDefinition() {
		return this.definition;
	}

	public RSIterableNodeDeque getUpdates() {
		return this.updates;
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1544257049"
	)
	static void method2110() {
		Login.worldSelectOpen = false;
		Login.leftTitleSprite.method6185(Login.xPadding, 0);
		DirectByteArrayCopier.rightTitleSprite.method6185(Login.xPadding + 382, 0);
		class3.logoSprite.method6173(Login.xPadding + 382 - class3.logoSprite.subWidth / 2, 18);
	}
}
