package com.zenyte.desktop;

import java.util.ArrayList;
import java.util.Collection;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSNode;
import net.runelite.rs.api.RSNodeHashTable;

@ObfuscatedName("lv")
public final class NodeHashTable implements RSNodeHashTable {
	@ObfuscatedName("x")
	int size;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "[Lga;"
	)
	Node[] buckets;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lga;"
	)
	Node currentGet;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lga;"
	)
	Node current;
	@ObfuscatedName("w")
	int index;

	public NodeHashTable(int var1) {
		this.index = 0;
		this.size = var1;
		this.buckets = new Node[var1];

		for (int var2 = 0; var2 < var1; ++var2) {
			Node var3 = this.buckets[var2] = new Node();
			var3.previous = var3;
			var3.next = var3;
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(J)Lga;"
	)
	public Node method6010(long var1) {
		Node var3 = this.buckets[(int)(var1 & (long)(this.size - 1))];

		for (this.currentGet = var3.previous; var3 != this.currentGet; this.currentGet = this.currentGet.previous) {
			if (this.currentGet.key == var1) {
				Node var4 = this.currentGet;
				this.currentGet = this.currentGet.previous;
				return var4;
			}
		}

		this.currentGet = null;
		return null;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lga;J)V"
	)
	public void method5997(Node var1, long var2) {
		if (var1.next != null) {
			var1.method3657();
		}

		Node var4 = this.buckets[(int)(var2 & (long)(this.size - 1))];
		var1.next = var4.next;
		var1.previous = var4;
		var1.next.previous = var1;
		var1.previous.next = var1;
		var1.key = var2;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "()Lga;"
	)
	public Node method5995() {
		this.index = 0;
		return this.method6003();
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "()Lga;"
	)
	public Node method6003() {
		Node var1;
		if (this.index > 0 && this.buckets[this.index - 1] != this.current) {
			var1 = this.current;
			this.current = var1.previous;
			return var1;
		} else {
			do {
				if (this.index >= this.size) {
					return null;
				}

				var1 = this.buckets[this.index++].previous;
			} while(var1 == this.buckets[this.index - 1]);

			this.current = var1.previous;
			return var1;
		}
	}

	public RSNode[] getBuckets() {
		return this.buckets;
	}

	public Collection getNodes() {
		ArrayList var1 = new ArrayList();
		RSNode[] var2 = this.getBuckets();

		for (int var3 = 0; var3 < var2.length; ++var3) {
			RSNode var4 = var2[var3];

			for (net.runelite.api.Node var5 = var4.getNext(); var5 != var4; var5 = var5.getNext()) {
				var1.add(var5);
			}
		}

		return var1;
	}

	public int getSize() {
		return this.size;
	}

	public RSNode get(long var1) {
		return this.method6010(var1);
	}
}
