package com.zenyte.desktop;

import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSFontName;

@ObfuscatedName("ka")
public class FontName implements RSFontName {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lka;"
	)
	public static final FontName FontName_plain11;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lka;"
	)
	public static final FontName FontName_plain12;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lka;"
	)
	public static final FontName FontName_bold12;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lka;"
	)
	public static final FontName FontName_verdana11;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lka;"
	)
	public static final FontName FontName_verdana13;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lka;"
	)
	public static final FontName FontName_verdana15;
	@ObfuscatedName("do")
	@ObfuscatedSignature(
		signature = "Lih;"
	)
	static Archive archive4;
	@ObfuscatedName("q")
	String name;

	static {
		FontName_plain11 = new FontName("p11_full");
		FontName_plain12 = new FontName("p12_full");
		FontName_bold12 = new FontName("b12_full");
		FontName_verdana11 = new FontName("verdana_11pt_regular");
		FontName_verdana13 = new FontName("verdana_13pt_regular");
		FontName_verdana15 = new FontName("verdana_15pt_regular");
	}

	FontName(String var1) {
		this.name = var1;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)[Lka;",
		garbageValue = "-2101151753"
	)
	public static FontName[] method5360() {
		return new FontName[]{FontName_bold12, FontName_verdana13, FontName_verdana11, FontName_plain11, FontName_plain12, FontName_verdana15};
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "-1439449778"
	)
	static final void method5358(int var0, int var1, int var2) {
		int var3;
		for (var3 = 0; var3 < 8; ++var3) {
			for (int var4 = 0; var4 < 8; ++var4) {
				Tiles.Tiles_heights[var0][var3 + var1][var4 + var2] = 0;
			}
		}

		if (var1 > 0) {
			for (var3 = 1; var3 < 8; ++var3) {
				Tiles.Tiles_heights[var0][var1][var3 + var2] = Tiles.Tiles_heights[var0][var1 - 1][var3 + var2];
			}
		}

		if (var2 > 0) {
			for (var3 = 1; var3 < 8; ++var3) {
				Tiles.Tiles_heights[var0][var3 + var1][var2] = Tiles.Tiles_heights[var0][var3 + var1][var2 - 1];
			}
		}

		if (var1 > 0 && Tiles.Tiles_heights[var0][var1 - 1][var2] != 0) {
			Tiles.Tiles_heights[var0][var1][var2] = Tiles.Tiles_heights[var0][var1 - 1][var2];
		} else if (var2 > 0 && Tiles.Tiles_heights[var0][var1][var2 - 1] != 0) {
			Tiles.Tiles_heights[var0][var1][var2] = Tiles.Tiles_heights[var0][var1][var2 - 1];
		} else if (var1 > 0 && var2 > 0 && Tiles.Tiles_heights[var0][var1 - 1][var2 - 1] != 0) {
			Tiles.Tiles_heights[var0][var1][var2] = Tiles.Tiles_heights[var0][var1 - 1][var2 - 1];
		}

	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "79"
	)
	static void method5361() {
		if (Client.Login_isUsernameRemembered && Login.Login_username != null && Login.Login_username.length() > 0) {
			Login.currentLoginField = 1;
		} else {
			Login.currentLoginField = 0;
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lhe;I[B[BI)V",
		garbageValue = "-481571835"
	)
	static final void method5356(Widget var0, int var1, byte[] var2, byte[] var3) {
		if (var0.field2555 == null) {
			if (var2 == null) {
				return;
			}

			var0.field2555 = new byte[11][];
			var0.field2643 = new byte[11][];
			var0.field2644 = new int[11];
			var0.field2695 = new int[11];
		}

		var0.field2555[var1] = var2;
		if (var2 != null) {
			var0.field2641 = true;
		} else {
			var0.field2641 = false;

			for (int var4 = 0; var4 < var0.field2555.length; ++var4) {
				if (var0.field2555[var4] != null) {
					var0.field2641 = true;
					break;
				}
			}
		}

		var0.field2643[var1] = var3;
	}

	@ObfuscatedName("jv")
	@ObfuscatedSignature(
		signature = "(IIIIII)V",
		garbageValue = "2092614789"
	)
	static final void method5354(int var0, int var1, int var2, int var3, int var4) {
		class232.scrollBarSprites[0].method6173(var0, var1);
		class232.scrollBarSprites[1].method6173(var0, var3 + var1 - 16);
		Rasterizer2D.method6052(var0, var1 + 16, 16, var3 - 32, Client.field742);
		int var5 = var3 * (var3 - 32) / var4;
		if (var5 < 8) {
			var5 = 8;
		}

		int var6 = (var3 - 32 - var5) * var2 / (var4 - var3);
		Rasterizer2D.method6052(var0, var6 + var1 + 16, 16, var5, Client.field747);
		Rasterizer2D.method6059(var0, var6 + var1 + 16, var5, Client.field745);
		Rasterizer2D.method6059(var0 + 1, var6 + var1 + 16, var5, Client.field745);
		Rasterizer2D.method6057(var0, var6 + var1 + 16, 16, Client.field745);
		Rasterizer2D.method6057(var0, var6 + var1 + 17, 16, Client.field745);
		Rasterizer2D.method6059(var0 + 15, var6 + var1 + 16, var5, Client.field744);
		Rasterizer2D.method6059(var0 + 14, var6 + var1 + 17, var5 - 1, Client.field744);
		Rasterizer2D.method6057(var0, var6 + var5 + var1 + 15, 16, Client.field744);
		Rasterizer2D.method6057(var0 + 1, var5 + var6 + var1 + 14, 15, Client.field744);
	}

	@ObfuscatedName("ku")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "946943550"
	)
	static final void method5359() {
		Iterator var0 = Messages.Messages_hashTable.iterator();

		while (var0.hasNext()) {
			Message var1 = (Message)var0.next();
			var1.method1299();
		}

		if (InterfaceParent.clanChat != null) {
			InterfaceParent.clanChat.method5284();
		}

	}
}
