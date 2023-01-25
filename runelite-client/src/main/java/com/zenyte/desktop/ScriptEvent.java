package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSScriptEvent;

@ObfuscatedName("bb")
public class ScriptEvent extends Node implements RSScriptEvent {
	@ObfuscatedName("km")
	@ObfuscatedGetter(
		intValue = -2032356267
	)
	static int Client_plane;
	@ObfuscatedName("x")
	Object[] args;
	@ObfuscatedName("m")
	boolean isMouseInputEvent;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lhe;"
	)
	Widget widget;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 662449011
	)
	int mouseX;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1491668133
	)
	int mouseY;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -44479267
	)
	int opIndex;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lhe;"
	)
	Widget dragTarget;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 128989033
	)
	int keyTyped;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1018201725
	)
	int keyPressed;
	@ObfuscatedName("e")
	String targetName;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 171881153
	)
	int field604;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -893996953
	)
	int type;

	public ScriptEvent() {
		this.type = 76;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "([Ljava/lang/Object;I)V",
		garbageValue = "-1877597946"
	)
	public void method1284(Object[] var1) {
		this.args = var1;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "77"
	)
	public void method1282(int var1) {
		this.type = var1;
	}

	public Object[] getArguments() {
		return this.args;
	}

	public void setArguments(Object[] var1) {
		this.args = var1;
	}

	public net.runelite.api.widgets.Widget getSource() {
		return this.widget;
	}

	public int getMouseX() {
		return this.mouseX;
	}

	public int getOp() {
		return this.opIndex;
	}

	public int getTypedKeyCode() {
		return this.keyTyped;
	}

	public int getTypedKeyChar() {
		return this.keyPressed;
	}

	public String getOpbase() {
		return this.targetName;
	}

	@ObfuscatedName("kv")
	@ObfuscatedSignature(
		signature = "(IIIILla;Lhg;B)V",
		garbageValue = "-20"
	)
	static final void method1288(int var0, int var1, int var2, int var3, Sprite var4, SpriteMask var5) {
		if (var4 != null) {
			int var6 = Client.camAngleY & 2047;
			int var7 = var3 * var3 + var2 * var2;
			if (var7 <= 6400) {
				int var8 = Rasterizer3D.Rasterizer3D_sine[var6];
				int var9 = Rasterizer3D.Rasterizer3D_cosine[var6];
				int var10 = var9 * var2 + var3 * var8 >> 16;
				int var11 = var3 * var9 - var8 * var2 >> 16;
				if (var7 > 2500) {
					var4.method6203(var10 + var5.width / 2 - var4.width / 2, var5.height / 2 - var11 - var4.height / 2, var0, var1, var5.width, var5.height, var5.xStarts, var5.xWidths);
				} else {
					var4.method6187(var0 + var10 + var5.width / 2 - var4.width / 2, var5.height / 2 + var1 - var11 - var4.height / 2);
				}

			}
		}
	}

	@ObfuscatedName("kc")
	@ObfuscatedSignature(
		signature = "(Lhe;I)I",
		garbageValue = "-1500770780"
	)
	static int method1283(Widget var0) {
		net.runelite.api.IntegerNode var1 = (net.runelite.api.IntegerNode)WorldMapSection1.client.getWidgetFlags().get(((long)var0.getId() << 32) + (long)var0.getIndex());
		int var2;
		if (var1 == null) {
			var2 = var0.getClickMask();
		} else {
			var2 = var1.getValue();
		}

		if (Client.allWidgetsAreOpTargetable) {
			var2 |= 2097152;
		}

		return var2;
	}
}
