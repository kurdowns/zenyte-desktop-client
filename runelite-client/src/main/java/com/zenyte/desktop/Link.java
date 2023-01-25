package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSLink;

@ObfuscatedName("gt")
public class Link implements RSLink {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lgt;"
	)
	public Link previous;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lgt;"
	)
	public Link next;

	@ObfuscatedName("x")
	public void method3654() {
		if (this.next != null) {
			this.next.previous = this.previous;
			this.previous.next = this.next;
			this.previous = null;
			this.next = null;
		}
	}
}
