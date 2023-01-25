package com.zenyte.desktop;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSClientPreferences;

@ObfuscatedName("cq")
public class ClientPreferences implements RSClientPreferences {
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1654668565
	)
	static int ClientPreferences_optionCount;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1650607601
	)
	static int clientTickTimeIdx;
	@ObfuscatedName("k")
	boolean roofsHidden;
	@ObfuscatedName("d")
	boolean titleMusicDisabled;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1989279891
	)
	int windowMode;
	@ObfuscatedName("v")
	String rememberedUsername;
	@ObfuscatedName("q")
	boolean hideUsername;
	@ObfuscatedName("z")
	LinkedHashMap parameters;

	static {
		ClientPreferences_optionCount = 6;
	}

	ClientPreferences() {
		this.windowMode = 1;
		this.rememberedUsername = null;
		this.hideUsername = false;
		this.parameters = new LinkedHashMap();
		this.method1928(true);
	}

	@ObfuscatedSignature(
		signature = "(Lkb;)V"
	)
	ClientPreferences(Buffer var1) {
		this.windowMode = 1;
		this.rememberedUsername = null;
		this.hideUsername = false;
		this.parameters = new LinkedHashMap();
		if (var1 != null && var1.array != null) {
			int var2 = var1.method5547();
			if (var2 >= 0 && var2 <= ClientPreferences_optionCount) {
				if (var1.method5547() == 1) {
					this.roofsHidden = true;
				}

				if (var2 > 1) {
					this.titleMusicDisabled = var1.method5547() == 1;
				}

				if (var2 > 3) {
					this.windowMode = var1.method5547();
				}

				if (var2 > 2) {
					int var3 = var1.method5547();

					for (int var4 = 0; var4 < var3; ++var4) {
						int var5 = var1.method5552();
						int var6 = var1.method5552();
						this.parameters.put(var5, var6);
					}
				}

				if (var2 > 4) {
					this.rememberedUsername = var1.method5555();
				}

				if (var2 > 5) {
					this.hideUsername = var1.method5682();
				}
			} else {
				this.method1928(true);
			}
		} else {
			this.method1928(true);
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-1802002327"
	)
	void method1928(boolean var1) {
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)Lkb;",
		garbageValue = "745371681"
	)
	Buffer method1929() {
		Buffer var1 = new Buffer(100);
		var1.method5531(ClientPreferences_optionCount);
		var1.method5531(this.roofsHidden ? 1 : 0);
		var1.method5531(this.titleMusicDisabled ? 1 : 0);
		var1.method5531(this.windowMode);
		var1.method5531(this.parameters.size());
		Iterator var2 = this.parameters.entrySet().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry)var2.next();
			var1.method5689((Integer)var3.getKey());
			var1.method5689((Integer)var3.getValue());
		}

		var1.method5627(this.rememberedUsername != null ? this.rememberedUsername : "");
		var1.method5690(this.hideUsername);
		return var1;
	}

	public String getRememberedUsername() {
		return this.rememberedUsername;
	}

	public void setRememberedUsername(String var1) {
		this.rememberedUsername = var1;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "102"
	)
	static final void method1936(String var0) {
		GrandExchangeEvent.method165("Please remove " + var0 + " from your ignore list first");
	}
}
