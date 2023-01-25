package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.rs.api.RSBZip2State;

@ObfuscatedName("lk")
public final class BZip2State implements RSBZip2State {
	@ObfuscatedName("x")
	final int field3756;
	@ObfuscatedName("m")
	final int field3725;
	@ObfuscatedName("k")
	final int field3726;
	@ObfuscatedName("d")
	final int field3729;
	@ObfuscatedName("w")
	final int field3750;
	@ObfuscatedName("v")
	final int field3737;
	@ObfuscatedName("q")
	byte[] inputArray;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1520658841
	)
	int nextByte;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1705468259
	)
	int nextBit_unused;
	@ObfuscatedName("e")
	byte[] outputArray;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -530026491
	)
	int next_out;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1793031375
	)
	int outputLength;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 828020907
	)
	int field3724;
	@ObfuscatedName("u")
	byte out_char;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -1550283393
	)
	int su_rNToGo;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 2097262377
	)
	int bsBuff;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1241583147
	)
	int bsLive;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -2118828031
	)
	int blockSize100k;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1768899761
	)
	int originalPointer;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -2111080359
	)
	int field3743;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -125465233
	)
	int su_ch2;
	@ObfuscatedName("o")
	int[] unzftab;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1422716731
	)
	int nblocks_used;
	@ObfuscatedName("j")
	int[] cftab;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1484476187
	)
	int nInUse;
	@ObfuscatedName("ae")
	boolean[] inUse;
	@ObfuscatedName("an")
	boolean[] inUse16;
	@ObfuscatedName("ai")
	byte[] seqToUnseq;
	@ObfuscatedName("ap")
	byte[] ll8;
	@ObfuscatedName("ab")
	int[] getAndMoveToFrontDecode_yy;
	@ObfuscatedName("ar")
	byte[] selector;
	@ObfuscatedName("af")
	byte[] selectorMtf;
	@ObfuscatedName("at")
	byte[][] temp_charArray2d;
	@ObfuscatedName("al")
	int[][] limit;
	@ObfuscatedName("as")
	int[][] base;
	@ObfuscatedName("am")
	int[][] perm;
	@ObfuscatedName("au")
	int[] minLens;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = -453266259
	)
	int field3761;

	BZip2State() {
		this.field3756 = 4096;
		this.field3725 = 16;
		this.field3726 = 258;
		this.field3729 = 6;
		this.field3750 = 50;
		this.field3737 = 18002;
		this.nextByte = 0;
		this.next_out = 0;
		this.unzftab = new int[256];
		this.cftab = new int[257];
		this.inUse = new boolean[256];
		this.inUse16 = new boolean[16];
		this.seqToUnseq = new byte[256];
		this.ll8 = new byte[4096];
		this.getAndMoveToFrontDecode_yy = new int[16];
		this.selector = new byte[18002];
		this.selectorMtf = new byte[18002];
		this.temp_charArray2d = new byte[6][258];
		this.limit = new int[6][258];
		this.base = new int[6][258];
		this.perm = new int[6][258];
		this.minLens = new int[6];
	}
}
