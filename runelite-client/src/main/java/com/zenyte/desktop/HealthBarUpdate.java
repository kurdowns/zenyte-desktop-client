package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSHealthBarUpdate;

@ObfuscatedName("cc")
public class HealthBarUpdate extends Node implements RSHealthBarUpdate {
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -186864867
	)
	int cycle;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 134168981
	)
	int health;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1066019297
	)
	int health2;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 442713571
	)
	int cycleOffset;

	HealthBarUpdate(int var1, int var2, int var3, int var4) {
		this.cycle = var1;
		this.health = var2;
		this.health2 = var3;
		this.cycleOffset = var4;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-2054467883"
	)
	void method1848(int var1, int var2, int var3, int var4) {
		this.cycle = var1;
		this.health = var2;
		this.health2 = var3;
		this.cycleOffset = var4;
	}

	public int getHealthRatio() {
		return this.health;
	}

	public int getHealth() {
		return this.health2;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
		garbageValue = "21"
	)
	static void method1852(String var0, String var1, String var2) {
		Login.Login_response1 = var0;
		Login.Login_response2 = var1;
		Login.Login_response3 = var2;
	}
}
