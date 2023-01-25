package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public enum class7 implements Enumerated {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lz;"
	)
	field34(0, 0);

	@ObfuscatedName("el")
	@ObfuscatedSignature(
		signature = "Llx;"
	)
	static GraphicsDefaults spriteIds;
	@ObfuscatedName("eu")
	@ObfuscatedGetter(
		intValue = 1683303309
	)
	static int field33;
	@ObfuscatedName("ml")
	@ObfuscatedGetter(
		intValue = 1709634405
	)
	static int selectedSpellWidget;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1301024931
	)
	public final int field30;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -32487403
	)
	final int index;

	class7(int var3, int var4) {
		this.field30 = var3;
		this.index = var4;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "56"
	)
	public int vmethod6149() {
		return this.index;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-185431723"
	)
	static int method98() {
		return 12;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Liy;Ljava/lang/String;Ljava/lang/String;B)Lle;",
		garbageValue = "1"
	)
	public static IndexedSprite method105(AbstractArchive var0, String var1, String var2) {
		int var3 = var0.method4240(var1);
		int var4 = var0.method4233(var3, var2);
		IndexedSprite var5;
		if (!UserComparator7.method3502(var0, var3, var4)) {
			var5 = null;
		} else {
			var5 = AttackOption.method2151();
		}

		return var5;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1823376013"
	)
	public static void method104() {
		if (NetCache.NetCache_socket != null) {
			NetCache.NetCache_socket.vmethod5866();
		}

	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "1393352524"
	)
	static int method101(int var0, class101 var1, boolean var2) {
		Widget var3 = MusicPatchNode.method3898(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
		if (var0 == 2600) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.scrollX;
			return 1;
		} else if (var0 == 2601) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.scrollY;
			return 1;
		} else if (var0 == 2602) {
			Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.text;
			return 1;
		} else if (var0 == 2603) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.scrollWidth;
			return 1;
		} else if (var0 == 2604) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.scrollHeight;
			return 1;
		} else if (var0 == 2605) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.modelZoom;
			return 1;
		} else if (var0 == 2606) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.modelAngleX;
			return 1;
		} else if (var0 == 2607) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.modelAngleZ;
			return 1;
		} else if (var0 == 2608) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.modelAngleY;
			return 1;
		} else if (var0 == 2609) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.transparencyTop;
			return 1;
		} else if (var0 == 2610) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.transparencyBot;
			return 1;
		} else if (var0 == 2611) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.color;
			return 1;
		} else if (var0 == 2612) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.color2;
			return 1;
		} else if (var0 == 2613) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.fillMode.vmethod6149();
			return 1;
		} else if (var0 == 2614) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.modelTransparency ? 1 : 0;
			return 1;
		} else {
			return 2;
		}
	}
}
