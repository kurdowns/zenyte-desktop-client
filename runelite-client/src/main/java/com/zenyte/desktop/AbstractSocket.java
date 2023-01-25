package com.zenyte.desktop;

import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSAbstractSocket;

@ObfuscatedName("lt")
public abstract class AbstractSocket implements RSAbstractSocket {
	protected AbstractSocket() {
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-105"
	)
	public abstract void vmethod5866();

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1436175029"
	)
	public abstract int vmethod5863() throws IOException;

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "195119972"
	)
	public abstract int vmethod5862() throws IOException;

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(IB)Z",
		garbageValue = "0"
	)
	public abstract boolean vmethod5861(int var1) throws IOException;

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "([BIIB)I",
		garbageValue = "33"
	)
	public abstract int vmethod5864(byte[] var1, int var2, int var3) throws IOException;

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "([BIII)V",
		garbageValue = "236801869"
	)
	public abstract void vmethod5878(byte[] var1, int var2, int var3) throws IOException;

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-842833143"
	)
	public static final void method5859(int var0, int var1) {
		ViewportMouse.ViewportMouse_x = var0;
		ViewportMouse.ViewportMouse_y = var1;
		ViewportMouse.ViewportMouse_isInViewport = true;
		ViewportMouse.ViewportMouse_entityCount = 0;
		ViewportMouse.ViewportMouse_false0 = false;
	}

	@ObfuscatedName("ke")
	@ObfuscatedSignature(
		signature = "(Lhe;IIIB)V",
		garbageValue = "7"
	)
	static final void method5851(Widget var0, int var1, int var2, int var3) {
		SpriteMask var4 = var0.method4115(false);
		if (var4 != null) {
			if (Client.minimapState < 3) {
				ChatChannel.compass.method6204(var1, var2, var4.width, var4.height, 25, 25, Client.camAngleY, 256, var4.xStarts, var4.xWidths);
			} else {
				Rasterizer2D.method6101(var1, var2, 0, var4.xStarts, var4.xWidths);
			}

		}
	}
}
