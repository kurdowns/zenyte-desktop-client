package com.zenyte.desktop;

import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSIterableDualNodeQueueIterator;

@ObfuscatedName("jg")
public class IterableDualNodeQueueIterator implements Iterator, RSIterableDualNodeQueueIterator {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Ljz;"
	)
	IterableDualNodeQueue queue;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lge;"
	)
	DualNode head;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lge;"
	)
	DualNode last;

	@ObfuscatedSignature(
		signature = "(Ljz;)V"
	)
	IterableDualNodeQueueIterator(IterableDualNodeQueue var1) {
		this.last = null;
		this.queue = var1;
		this.head = this.queue.sentinel.previousDual;
		this.last = null;
	}

	public boolean hasNext() {
		return this.queue.sentinel != this.head;
	}

	public void remove() {
		this.last.method3653();
		this.last = null;
	}

	public Object next() {
		DualNode var1 = this.head;
		if (var1 == this.queue.sentinel) {
			var1 = null;
			this.head = null;
		} else {
			this.head = var1.previousDual;
		}

		this.last = var1;
		return var1;
	}
}
