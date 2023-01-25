package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSNode;
import net.runelite.rs.api.RSNodeDeque;

@ObfuscatedName("jh")
public class NodeDeque implements RSNodeDeque {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lga;"
	)
	public Node sentinel;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lga;"
	)
	Node current;

	public NodeDeque() {
		this.sentinel = new Node();
		this.sentinel.previous = this.sentinel;
		this.sentinel.next = this.sentinel;
	}

	@ObfuscatedName("x")
	public void method4925() {
		while (true) {
			Node var1 = this.sentinel.previous;
			if (var1 == this.sentinel) {
				this.current = null;
				return;
			}

			var1.method3657();
		}
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lga;)V"
	)
	public void method4952(Node var1) {
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
	public void method4927(Node var1) {
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
	public Node method4929() {
		Node var1 = this.sentinel.previous;
		if (var1 == this.sentinel) {
			return null;
		} else {
			var1.method3657();
			return var1;
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "()Lga;"
	)
	public Node method4930() {
		Node var1 = this.sentinel.next;
		if (var1 == this.sentinel) {
			return null;
		} else {
			var1.method3657();
			return var1;
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "()Lga;"
	)
	public Node method4931() {
		Node var1 = this.sentinel.previous;
		if (var1 == this.sentinel) {
			this.current = null;
			return null;
		} else {
			this.current = var1.previous;
			return var1;
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "()Lga;"
	)
	public Node method4935() {
		Node var1 = this.sentinel.next;
		if (var1 == this.sentinel) {
			this.current = null;
			return null;
		} else {
			this.current = var1.next;
			return var1;
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "()Lga;"
	)
	public Node method4949() {
		Node var1 = this.current;
		if (var1 == this.sentinel) {
			this.current = null;
			return null;
		} else {
			this.current = var1.previous;
			return var1;
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "()Lga;"
	)
	public Node method4932() {
		Node var1 = this.current;
		if (var1 == this.sentinel) {
			this.current = null;
			return null;
		} else {
			this.current = var1.next;
			return var1;
		}
	}

	public RSNode getHead() {
		return this.sentinel;
	}

	public RSNode getCurrent() {
		return this.current;
	}

	public void addFirst(RSNode var1) {
		this.method4952((Node)var1);
	}

	public RSNode last() {
		return this.method4931();
	}

	public RSNode previous() {
		return this.method4949();
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Lga;Lga;)V"
	)
	public static void method4928(Node var0, Node var1) {
		if (var0.next != null) {
			var0.method3657();
		}

		var0.next = var1.next;
		var0.previous = var1;
		var0.next.previous = var0;
		var0.previous.next = var0;
	}
}
