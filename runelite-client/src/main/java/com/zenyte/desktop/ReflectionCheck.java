package com.zenyte.desktop;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSReflectionCheck;

@ObfuscatedName("du")
public class ReflectionCheck extends Node implements RSReflectionCheck {
	@ObfuscatedName("gi")
	@ObfuscatedSignature(
		signature = "[Lla;"
	)
	static Sprite[] headIconPrayerSprites;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1911756689
	)
	int id;
	@ObfuscatedName("m")
	byte[][][] arguments;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -28201163
	)
	int size;
	@ObfuscatedName("d")
	int[] operations;
	@ObfuscatedName("w")
	int[] creationErrors;
	@ObfuscatedName("v")
	Field[] fields;
	@ObfuscatedName("q")
	int[] intReplaceValues;
	@ObfuscatedName("z")
	Method[] methods;

	ReflectionCheck() {
	}

	public byte[][][] getArgs() {
		return this.arguments;
	}

	public Field[] getFields() {
		return this.fields;
	}

	public Method[] getMethods() {
		return this.methods;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "100"
	)
	static void method2382() {
		Login.loginIndex = 24;
		HealthBarUpdate.method1852("", "You were disconnected from the server.", "");
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(Ldg;S)V",
		garbageValue = "-25430"
	)
	public static final void method2383(PlayerProvider var0) {
		PcmPlayer.pcmPlayerProvider = var0;
	}
}
