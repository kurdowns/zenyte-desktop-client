package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.rs.api.RSTilePaint;

@ObfuscatedName("ev")
public final class TilePaint implements RSTilePaint {
	@ObfuscatedName("sl")
	@ObfuscatedGetter(
		longValue = 8743466258274073007L
	)
	static long field1802;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 2078169707
	)
	int swColor;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 321008861
	)
	int seColor;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -841305589
	)
	int neColor;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 658515107
	)
	int nwColor;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1776502689
	)
	int texture;
	@ObfuscatedName("v")
	boolean isFlat;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1035631343
	)
	int rgb;
	public int rl$paintModelBufferOffset;
	public int rl$paintModelUvBufferOffset;
	public int rl$paintModelBufferLen;

	TilePaint(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
		this.isFlat = true;
		this.swColor = var1;
		this.seColor = var2;
		this.neColor = var3;
		this.nwColor = var4;
		this.texture = var5;
		this.rgb = var6;
		this.isFlat = var7;
	}

	public int getBufferOffset() {
		return this.rl$paintModelBufferOffset;
	}

	public void setBufferOffset(int var1) {
		this.rl$paintModelBufferOffset = var1;
	}

	public int getUvBufferOffset() {
		return this.rl$paintModelUvBufferOffset;
	}

	public void setUvBufferOffset(int var1) {
		this.rl$paintModelUvBufferOffset = var1;
	}

	public int getBufferLen() {
		return this.rl$paintModelBufferLen;
	}

	public void setBufferLen(int var1) {
		this.rl$paintModelBufferLen = var1;
	}

	public int getSwColor() {
		return this.swColor;
	}

	public int getSeColor() {
		return this.seColor;
	}

	public int getNeColor() {
		return this.neColor;
	}

	public int getNwColor() {
		return this.nwColor;
	}

	public int getTexture() {
		return this.texture;
	}

	public int getRBG() {
		return this.rgb;
	}
}
