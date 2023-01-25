package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSMenuAction;

@ObfuscatedName("ci")
public class MenuAction implements RSMenuAction {
	@ObfuscatedName("eh")
	@ObfuscatedSignature(
		signature = "Lih;"
	)
	static Archive archive17;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1152596883
	)
	int param1;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 950122555
	)
	int param0;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 935644857
	)
	int opcode;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -83774921
	)
	int identifier;
	@ObfuscatedName("w")
	String action;

	MenuAction() {
	}

	public void setParam1(int var1) {
		this.param1 = var1;
	}

	public void setParam0(int var1) {
		this.param0 = var1;
	}

	public void setOpcode(int var1) {
		this.opcode = var1;
	}

	public void setIdentifier(int var1) {
		this.identifier = var1;
	}

	public void setOption(String var1) {
		this.action = var1;
	}
}
