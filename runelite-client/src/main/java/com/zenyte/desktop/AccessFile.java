package com.zenyte.desktop;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.SyncFailedException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSAccessFile;

@ObfuscatedName("mb")
public final class AccessFile implements RSAccessFile {
	@ObfuscatedName("x")
	RandomAccessFile file;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		longValue = 1632378019072179927L
	)
	final long maxSize;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		longValue = 3271085237778542147L
	)
	long offset;

	public AccessFile(File var1, String var2, long var3) throws IOException {
		if (var3 == -1L) {
			var3 = Long.MAX_VALUE;
		}

		if (var1.length() > var3) {
			var1.delete();
		}

		this.file = new RandomAccessFile(var1, var2);
		this.maxSize = var3;
		this.offset = 0L;
		int var5 = this.file.read();
		if (var5 != -1 && !var2.equals("r")) {
			this.file.seek(0L);
			this.file.write(var5);
		}

		this.file.seek(0L);
	}

	@ObfuscatedName("x")
	final void method6647(long var1) throws IOException {
		this.file.seek(var1);
		this.offset = var1;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "([BIIB)V",
		garbageValue = "47"
	)
	public final void method6653(byte[] var1, int var2, int var3) throws IOException {
		if (this.offset + (long)var3 > this.maxSize) {
			this.file.seek(this.maxSize);
			this.file.write(1);
			throw new EOFException();
		} else {
			this.file.write(var1, var2, var3);
			this.offset += (long)var3;
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "10"
	)
	public final void method6648() throws IOException {
		this.method6651(false);
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "2141113619"
	)
	public final void method6651(boolean var1) throws IOException {
		if (this.file != null) {
			if (var1) {
				try {
					this.file.getFD().sync();
				} catch (SyncFailedException var3) {
				}
			}

			this.file.close();
			this.file = null;
		}

	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(B)J",
		garbageValue = "74"
	)
	public final long method6650() throws IOException {
		return this.file.length();
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "([BIII)I",
		garbageValue = "-316484023"
	)
	public final int method6658(byte[] var1, int var2, int var3) throws IOException {
		int var4 = this.file.read(var1, var2, var3);
		if (var4 > 0) {
			this.offset += (long)var4;
		}

		return var4;
	}

	protected void aaw() throws Throwable {
		if (this.file != null) {
			System.out.println("");
			this.method6648();
		}

	}

	protected void aaf() throws Throwable {
		if (this.file != null) {
			System.out.println("");
			this.method6648();
		}

	}

	protected void finalize() throws Throwable {
		if (this.file != null) {
			System.out.println("");
			this.method6648();
		}

	}

	protected void aav() throws Throwable {
		if (this.file != null) {
			System.out.println("");
			this.method6648();
		}

	}

	protected void aay() throws Throwable {
		if (this.file != null) {
			System.out.println("");
			this.method6648();
		}

	}

	public RandomAccessFile getFile() {
		return this.file;
	}

	public long getLength() {
		return this.maxSize;
	}

	public long getPosition() {
		return this.offset;
	}
}
