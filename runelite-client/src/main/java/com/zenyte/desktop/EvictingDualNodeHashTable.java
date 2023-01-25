package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSDualNode;
import net.runelite.rs.api.RSEvictingDualNodeHashTable;

@ObfuscatedName("eg")
public final class EvictingDualNodeHashTable implements RSEvictingDualNodeHashTable {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lge;"
	)
	DualNode field1973;
	@ObfuscatedName("m")
	int capacity;
	@ObfuscatedName("k")
	int remainingCapacity;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lln;"
	)
	IterableNodeHashTable hashTable;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Ljz;"
	)
	IterableDualNodeQueue deque;

	public EvictingDualNodeHashTable(int var1) {
		this.field1973 = new DualNode();
		this.deque = new IterableDualNodeQueue();
		this.capacity = var1;
		this.remainingCapacity = var1;

		int var2;
		for (var2 = 1; var2 + var2 < var1; var2 += var2) {
		}

		this.hashTable = new IterableNodeHashTable(var2);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(J)Lge;"
	)
	public DualNode method3418(long var1) {
		DualNode var3 = (DualNode)this.hashTable.method5968(var1);
		if (var3 != null) {
			this.deque.method4999(var3);
		}

		return var3;
	}

	@ObfuscatedName("m")
	public void method3411(long var1) {
		DualNode var3 = (DualNode)this.hashTable.method5968(var1);
		if (var3 != null) {
			var3.method3657();
			var3.method3653();
			++this.remainingCapacity;
		}

	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lge;J)V"
	)
	public void method3424(DualNode var1, long var2) {
		if (this.remainingCapacity == 0) {
			DualNode var4 = this.deque.method4993();
			var4.method3657();
			var4.method3653();
			if (var4 == this.field1973) {
				var4 = this.deque.method4993();
				var4.method3657();
				var4.method3653();
			}
		} else {
			--this.remainingCapacity;
		}

		this.hashTable.method5963(var1, var2);
		this.deque.method4999(var1);
	}

	@ObfuscatedName("d")
	public void method3413() {
		this.deque.method5010();
		this.hashTable.method5964();
		this.field1973 = new DualNode();
		this.remainingCapacity = this.capacity;
	}

	public void setCapacity(int var1) {
		this.capacity = var1;
	}

	public void setRemainingCapacity(int var1) {
		this.remainingCapacity = var1;
	}

	public RSDualNode get(long var1) {
		return this.method3418(var1);
	}

	public void reset() {
		this.method3413();
	}
}
