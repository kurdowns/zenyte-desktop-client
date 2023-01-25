package com.zenyte.desktop;

import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSMouseWheelHandler;

@ObfuscatedName("bc")
public final class MouseWheelHandler implements MouseWheel, MouseWheelListener, RSMouseWheelHandler {
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1145232291
	)
	int rotation;

	MouseWheelHandler() {
		this.rotation = 0;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Ljava/awt/Component;I)V",
		garbageValue = "637751715"
	)
	void method906(Component var1) {
		var1.addMouseWheelListener(this);
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Ljava/awt/Component;I)V",
		garbageValue = "-1151636604"
	)
	void method907(Component var1) {
		var1.removeMouseWheelListener(this);
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "65280"
	)
	public synchronized int vmethod3573() {
		int var1 = this.rotation;
		this.rotation = 0;
		return var1;
	}

	public synchronized void copy$mouseWheelMoved(MouseWheelEvent var1) {
		this.rotation += var1.getWheelRotation();
	}

	public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
		var1 = WorldMapSection1.client.getCallbacks().mouseWheelMoved(var1);
		if (!var1.isConsumed()) {
			this.copy$mouseWheelMoved(var1);
		}

	}
}
