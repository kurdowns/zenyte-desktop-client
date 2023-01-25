package com.zenyte.desktop;

import java.net.URL;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSUrlRequest;

@ObfuscatedName("ew")
public class UrlRequest implements RSUrlRequest {
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Ldk;"
	)
	public static SoundCache soundCache;
	@ObfuscatedName("x")
	final URL url;
	@ObfuscatedName("m")
	volatile boolean isDone0;
	@ObfuscatedName("k")
	volatile byte[] response0;

	UrlRequest(URL var1) {
		this.url = var1;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1424081834"
	)
	public boolean method3403() {
		return this.isDone0;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)[B",
		garbageValue = "484192233"
	)
	public byte[] method3406() {
		return this.response0;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "65535"
	)
	static int method3409(int var0, class101 var1, boolean var2) {
		Widget var3;
		if (var0 == 2700) {
			var3 = MusicPatchNode.method3898(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.itemId;
			return 1;
		} else if (var0 == 2701) {
			var3 = MusicPatchNode.method3898(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
			if (var3.itemId != -1) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.itemQuantity;
			} else {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
			}

			return 1;
		} else if (var0 == 2702) {
			int var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.method6010((long)var5);
			if (var4 != null) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
			} else {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
			}

			return 1;
		} else if (var0 == 2706) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.rootInterface;
			return 1;
		} else {
			return 2;
		}
	}
}
