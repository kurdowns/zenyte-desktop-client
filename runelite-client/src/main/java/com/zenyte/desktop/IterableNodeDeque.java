package com.zenyte.desktop;

import java.util.Collection;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSIterableNodeDeque;
import net.runelite.rs.api.RSNode;

@ObfuscatedName("jm")
public class IterableNodeDeque implements Iterable, Collection, RSIterableNodeDeque {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lga;"
	)
	Node sentinel;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lga;"
	)
	Node field3530;

	public IterableNodeDeque() {
		this.sentinel = new Node();
		this.sentinel.previous = this.sentinel;
		this.sentinel.next = this.sentinel;
	}

	@ObfuscatedName("x")
	public void method4866() {
		while (this.sentinel.previous != this.sentinel) {
			this.sentinel.previous.method3657();
		}

	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lga;)V"
	)
	public void method4858(Node var1) {
		if (var1.next != null) {
			var1.method3657();
		}

		var1.next = this.sentinel.next;
		var1.previous = this.sentinel;
		var1.next.previous = var1;
		var1.previous.next = var1;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lga;)V"
	)
	public void method4880(Node var1) {
		if (var1.next != null) {
			var1.method3657();
		}

		var1.next = this.sentinel;
		var1.previous = this.sentinel.previous;
		var1.next.previous = var1;
		var1.previous.next = var1;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "()Lga;"
	)
	public Node method4860() {
		return this.method4871((Node)null);
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lga;)Lga;"
	)
	Node method4871(Node var1) {
		Node var2;
		if (var1 == null) {
			var2 = this.sentinel.previous;
		} else {
			var2 = var1;
		}

		if (var2 == this.sentinel) {
			this.field3530 = null;
			return null;
		} else {
			this.field3530 = var2.previous;
			return var2;
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "()Lga;"
	)
	public Node method4915() {
		Node var1 = this.field3530;
		if (var1 == this.sentinel) {
			this.field3530 = null;
			return null;
		} else {
			this.field3530 = var1.previous;
			return var1;
		}
	}

	@ObfuscatedName("z")
	int method4903() {
		int var1 = 0;

		for (Node var2 = this.sentinel.previous; var2 != this.sentinel; var2 = var2.previous) {
			++var1;
		}

		return var1;
	}

	@ObfuscatedName("t")
	public boolean method4867() {
		return this.sentinel.previous == this.sentinel;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "()[Lga;"
	)
	Node[] method4864() {
		Node[] var1 = new Node[this.method4903()];
		int var2 = 0;

		for (Node var3 = this.sentinel.previous; var3 != this.sentinel; var3 = var3.previous) {
			var1[var2++] = var3;
		}

		return var1;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lga;)Z"
	)
	boolean method4859(Node var1) {
		this.method4858(var1);
		return true;
	}

	public int hashCode() {
		return super.hashCode();
	}

	public Iterator iterator() {
		return new IterableNodeDequeDescendingIterator(this);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	public boolean removeAll(Collection var1) {
		throw new RuntimeException();
	}

	public int size() {
		return this.method4903();
	}

	public boolean contains(Object var1) {
		throw new RuntimeException();
	}

	public Object[] toArray() {
		return this.method4864();
	}

	public Object[] toArray(Object[] var1) {
		int var2 = 0;

		for (Node var3 = this.sentinel.previous; var3 != this.sentinel; var3 = var3.previous) {
			var1[var2++] = var3;
		}

		return var1;
	}

	public boolean remove(Object var1) {
		throw new RuntimeException();
	}

	public boolean containsAll(Collection var1) {
		throw new RuntimeException();
	}

	public boolean retainAll(Collection var1) {
		throw new RuntimeException();
	}

	public void clear() {
		this.method4866();
	}

	public boolean add(Object var1) {
		return this.method4859((Node)var1);
	}

	public boolean isEmpty() {
		return this.method4867();
	}

	public boolean addAll(Collection var1) {
		throw new RuntimeException();
	}

	public RSNode getCurrent() {
		return this.sentinel;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Lga;Lga;)V"
	)
	public static void method4893(Node var0, Node var1) {
		if (var0.next != null) {
			var0.method3657();
		}

		var0.next = var1;
		var0.previous = var1.previous;
		var0.next.previous = var0;
		var0.previous.next = var0;
	}
}
