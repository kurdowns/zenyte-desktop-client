package com.zenyte.desktop;

import java.io.File;
import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
public class class92 {
	@ObfuscatedName("x")
	static final BigInteger field1181;
	@ObfuscatedName("m")
	static final BigInteger field1178;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	public static AbstractArchive SequenceDefinition_skeletonsArchive;
	@ObfuscatedName("w")
	public static File cacheDir;
	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	static IndexedSprite worldSelectLeftSprite;

	static {
		field1181 = new BigInteger("10001", 16);
		field1178 = new BigInteger("147926487101535673874481304996273029446680384572900776356741718541029295833056728580689225626839331109889051098340610277259374021239154392825073133579283354307195571644831952411288119469259428730829525599875738883869187086987379074879572536962975657340434949610404032466451957196559061637505086995393354666349");
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Liy;Liy;I)I",
		garbageValue = "-1982305886"
	)
	static int method2142(AbstractArchive var0, AbstractArchive var1) {
		int var2 = 0;
		if (var0.method4241("title.jpg", "")) {
			++var2;
		}

		if (var1.method4241("logo", "")) {
			++var2;
		}

		if (var1.method4241("logo_deadman_mode", "")) {
			++var2;
		}

		if (var1.method4241("logo_seasonal_mode", "")) {
			++var2;
		}

		if (var1.method4241("titlebox", "")) {
			++var2;
		}

		if (var1.method4241("titlebutton", "")) {
			++var2;
		}

		if (var1.method4241("runes", "")) {
			++var2;
		}

		if (var1.method4241("title_mute", "")) {
			++var2;
		}

		if (var1.method4241("options_radio_buttons,0", "")) {
			++var2;
		}

		if (var1.method4241("options_radio_buttons,2", "")) {
			++var2;
		}

		if (var1.method4241("options_radio_buttons,4", "")) {
			++var2;
		}

		if (var1.method4241("options_radio_buttons,6", "")) {
			++var2;
		}

		var1.method4241("sl_back", "");
		var1.method4241("sl_flags", "");
		var1.method4241("sl_arrows", "");
		var1.method4241("sl_stars", "");
		var1.method4241("sl_button", "");
		return var2;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-78"
	)
	public static void method2141() {
		SequenceDefinition.SequenceDefinition_cached.method3413();
		SequenceDefinition.SequenceDefinition_cachedFrames.method3413();
	}
}
