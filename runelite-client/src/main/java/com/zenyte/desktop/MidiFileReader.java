package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSMidiFileReader;

@ObfuscatedName("hc")
public class MidiFileReader implements RSMidiFileReader {
	@ObfuscatedName("e")
	static final byte[] field2478;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lkb;"
	)
	Buffer buffer;
	@ObfuscatedName("m")
	int division;
	@ObfuscatedName("k")
	int[] trackStarts;
	@ObfuscatedName("d")
	int[] trackPositions;
	@ObfuscatedName("w")
	int[] trackLengths;
	@ObfuscatedName("v")
	int[] field2474;
	@ObfuscatedName("q")
	int field2471;
	@ObfuscatedName("t")
	long field2477;

	static {
		field2478 = new byte[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	}

	MidiFileReader(byte[] var1) {
		this.buffer = new Buffer((byte[])null);
		this.method3915(var1);
	}

	MidiFileReader() {
		this.buffer = new Buffer((byte[])null);
	}

	@ObfuscatedName("x")
	void method3915(byte[] var1) {
		this.buffer.array = var1;
		this.buffer.offset = 10;
		int var2 = this.buffer.method5549();
		this.division = this.buffer.method5549();
		this.field2471 = 500000;
		this.trackStarts = new int[var2];

		Buffer var10000;
		int var3;
		int var5;
		for (var3 = 0; var3 < var2; var10000.offset += var5) {
			int var4 = this.buffer.method5552();
			var5 = this.buffer.method5552();
			if (var4 == 1297379947) {
				this.trackStarts[var3] = this.buffer.offset;
				++var3;
			}

			var10000 = this.buffer;
		}

		this.field2477 = 0L;
		this.trackPositions = new int[var2];

		for (var3 = 0; var3 < var2; ++var3) {
			this.trackPositions[var3] = this.trackStarts[var3];
		}

		this.trackLengths = new int[var2];
		this.field2474 = new int[var2];
	}

	@ObfuscatedName("m")
	void method3920() {
		this.buffer.array = null;
		this.trackStarts = null;
		this.trackPositions = null;
		this.trackLengths = null;
		this.field2474 = null;
	}

	@ObfuscatedName("k")
	boolean method3905() {
		return this.buffer.array != null;
	}

	@ObfuscatedName("d")
	int method3906() {
		return this.trackPositions.length;
	}

	@ObfuscatedName("w")
	void method3907(int var1) {
		this.buffer.offset = this.trackPositions[var1];
	}

	@ObfuscatedName("v")
	void method3944(int var1) {
		this.trackPositions[var1] = this.buffer.offset;
	}

	@ObfuscatedName("q")
	void method3909() {
		this.buffer.offset = -1;
	}

	@ObfuscatedName("z")
	void method3910(int var1) {
		int var2 = this.buffer.method5571();
		int[] var10000 = this.trackLengths;
		var10000[var1] += var2;
	}

	@ObfuscatedName("t")
	int method3911(int var1) {
		int var2 = this.method3908(var1);
		return var2;
	}

	@ObfuscatedName("e")
	int method3908(int var1) {
		byte var2 = this.buffer.array[this.buffer.offset];
		int var5;
		if (var2 < 0) {
			var5 = var2 & 255;
			this.field2474[var1] = var5;
			++this.buffer.offset;
		} else {
			var5 = this.field2474[var1];
		}

		if (var5 != 240 && var5 != 247) {
			return this.method3913(var1, var5);
		} else {
			int var3 = this.buffer.method5571();
			if (var5 == 247 && var3 > 0) {
				int var4 = this.buffer.array[this.buffer.offset] & 255;
				if (var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
					++this.buffer.offset;
					this.field2474[var1] = var4;
					return this.method3913(var1, var4);
				}
			}

			Buffer var10000 = this.buffer;
			var10000.offset += var3;
			return 0;
		}
	}

	@ObfuscatedName("s")
	int method3913(int var1, int var2) {
		int var4;
		if (var2 == 255) {
			int var7 = this.buffer.method5547();
			var4 = this.buffer.method5571();
			Buffer var10000;
			if (var7 == 47) {
				var10000 = this.buffer;
				var10000.offset += var4;
				return 1;
			} else if (var7 == 81) {
				int var5 = this.buffer.method5674();
				var4 -= 3;
				int var6 = this.trackLengths[var1];
				this.field2477 += (long)var6 * (long)(this.field2471 - var5);
				this.field2471 = var5;
				var10000 = this.buffer;
				var10000.offset += var4;
				return 2;
			} else {
				var10000 = this.buffer;
				var10000.offset += var4;
				return 3;
			}
		} else {
			byte var3 = field2478[var2 - 128];
			var4 = var2;
			if (var3 >= 1) {
				var4 = var2 | this.buffer.method5547() << 8;
			}

			if (var3 >= 2) {
				var4 |= this.buffer.method5547() << 16;
			}

			return var4;
		}
	}

	@ObfuscatedName("p")
	long method3914(int var1) {
		return this.field2477 + (long)var1 * (long)this.field2471;
	}

	@ObfuscatedName("n")
	int method3902() {
		int var1 = this.trackPositions.length;
		int var2 = -1;
		int var3 = Integer.MAX_VALUE;

		for (int var4 = 0; var4 < var1; ++var4) {
			if (this.trackPositions[var4] >= 0 && this.trackLengths[var4] < var3) {
				var2 = var4;
				var3 = this.trackLengths[var4];
			}
		}

		return var2;
	}

	@ObfuscatedName("u")
	boolean method3916() {
		int var1 = this.trackPositions.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			if (this.trackPositions[var2] >= 0) {
				return false;
			}
		}

		return true;
	}

	@ObfuscatedName("h")
	void method3917(long var1) {
		this.field2477 = var1;
		int var3 = this.trackPositions.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			this.trackLengths[var4] = 0;
			this.field2474[var4] = 0;
			this.buffer.offset = this.trackStarts[var4];
			this.method3910(var4);
			this.trackPositions[var4] = this.buffer.offset;
		}

	}
}
