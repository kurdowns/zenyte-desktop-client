package com.zenyte.desktop;

import java.io.File;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSJagexCache;

@ObfuscatedName("fh")
public class JagexCache implements RSJagexCache {
	@ObfuscatedName("d")
	public static File JagexCache_locationFile;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lms;"
	)
	public static BufferedFile JagexCache_randomDat;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lms;"
	)
	public static BufferedFile JagexCache_dat2File;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lms;"
	)
	public static BufferedFile JagexCache_idx255File;

	static {
		JagexCache_randomDat = null;
		JagexCache_dat2File = null;
		JagexCache_idx255File = null;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lkb;I)Ljava/lang/String;",
		garbageValue = "677991921"
	)
	public static String method3563(Buffer var0) {
		String var1;
		try {
			int var2 = var0.method5561();
			if (var2 > 32767) {
				var2 = 32767;
			}

			byte[] var3 = new byte[var2];
			var0.offset += class219.huffman.method4017(var0.array, var0.offset, var3, 0, var2);
			String var4 = WorldMapArea.method507(var3, 0, var2);
			var1 = var4;
		} catch (Exception var6) {
			var1 = "Cabbage";
		}

		return var1;
	}
}
