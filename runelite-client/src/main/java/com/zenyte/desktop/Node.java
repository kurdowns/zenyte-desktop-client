package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSNode;

@ObfuscatedName("ga")
public class Node implements RSNode {
	@ObfuscatedName("ct")
	public long key;
	@ObfuscatedName("cf")
	@ObfuscatedSignature(
		signature = "Lga;"
	)
	public Node previous;
	@ObfuscatedName("ca")
	@ObfuscatedSignature(
		signature = "Lga;"
	)
	public Node next;

	public void onUnlink() {
	}

	public void rl$unlink() {
		this.onUnlink();
	}

	public long getHash() {
		return this.key;
	}

	public RSNode getNext() {
		return this.previous;
	}

	public RSNode getPrevious() {
		return this.next;
	}

	public void unlink() {
		this.method3657();
	}

	@ObfuscatedName("fd")
	public void method3657() {
		this.rl$unlink();
		if (this.next != null) {
			this.next.previous = this.previous;
			this.previous.next = this.next;
			this.previous = null;
			this.next = null;
		}
	}

	@ObfuscatedName("fo")
	public boolean method3658() {
		return this.next != null;
	}
}
