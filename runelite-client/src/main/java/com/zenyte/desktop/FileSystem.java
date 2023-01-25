package com.zenyte.desktop;

import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSFileSystem;

@ObfuscatedName("fe")
public class FileSystem implements RSFileSystem {
	@ObfuscatedName("x")
	public static boolean FileSystem_hasPermissions;
	@ObfuscatedName("m")
	public static File FileSystem_cacheDir;
	@ObfuscatedName("k")
	static Hashtable FileSystem_cacheFiles;

	static {
		FileSystem_hasPermissions = false;
		FileSystem_cacheFiles = new Hashtable(16);
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(IIB)Z",
		garbageValue = "-28"
	)
	static final boolean method3574(int var0, int var1) {
		ObjectDefinition var2 = WorldMapSection2.method435(var0);
		if (var1 == 11) {
			var1 = 10;
		}

		if (var1 >= 5 && var1 <= 8) {
			var1 = 4;
		}

		return var2.method4637(var1);
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "(Lds;S)V",
		garbageValue = "4477"
	)
	static final void method3575(PcmStream var0) {
		var0.active = false;
		if (var0.sound != null) {
			var0.sound.position = 0;
		}

		for (PcmStream var1 = var0.vmethod3962(); var1 != null; var1 = var0.vmethod3964()) {
			method3575(var1);
		}

	}
}
