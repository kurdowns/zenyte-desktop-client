package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSUserComparator5;

@ObfuscatedName("fc")
public class UserComparator5 extends AbstractUserComparator implements RSUserComparator5 {
	@ObfuscatedName("x")
	final boolean reversed;

	public UserComparator5(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lke;Lke;I)I",
		garbageValue = "261090852"
	)
	int method3503(Buddy var1, Buddy var2) {
		if (var1.world != 0) {
			if (var2.world == 0) {
				return this.reversed ? -1 : 1;
			}
		} else if (var2.world != 0) {
			return this.reversed ? 1 : -1;
		}

		return this.method5087(var1, var2);
	}

	public int compare(Object var1, Object var2) {
		return this.method3503((Buddy)var1, (Buddy)var2);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1985272675"
	)
	public static void method3506() {
		KitDefinition.KitDefinition_cached.method3413();
	}

	@ObfuscatedName("gf")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-447176134"
	)
	static final void method3509(int var0, int var1, int var2, int var3) {
		ViewportMouse.method3077();
	}

	@ObfuscatedName("if")
	@ObfuscatedSignature(
		signature = "(IB)Ljava/lang/String;",
		garbageValue = "0"
	)
	static final String method3508(int var0) {
		String var1 = Integer.toString(var0);

		for (int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
			var1 = var1.substring(0, var2) + "," + var1.substring(var2);
		}

		if (var1.length() > 9) {
			return " " + class297.method5314(65408) + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>";
		} else {
			return var1.length() > 6 ? " " + class297.method5314(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>" : " " + class297.method5314(16776960) + var1 + "</col>";
		}
	}

	@ObfuscatedName("jt")
	@ObfuscatedSignature(
		signature = "(Lhe;I)V",
		garbageValue = "-1600087023"
	)
	static final void method3507(Widget var0) {
		int var1 = var0.contentType;
		if (var1 == 324) {
			if (Client.field945 == -1) {
				Client.field945 = var0.spriteId2;
				Client.field946 = var0.spriteId;
			}

			if (Client.playerAppearance.isFemale) {
				var0.spriteId2 = Client.field945;
			} else {
				var0.spriteId2 = Client.field946;
			}

		} else if (var1 == 325) {
			if (Client.field945 == -1) {
				Client.field945 = var0.spriteId2;
				Client.field946 = var0.spriteId;
			}

			if (Client.playerAppearance.isFemale) {
				var0.spriteId2 = Client.field946;
			} else {
				var0.spriteId2 = Client.field945;
			}

		} else if (var1 == 327) {
			var0.modelAngleX = 150;
			var0.modelAngleY = (int)(Math.sin((double)Client.cycle / 40.0D) * 256.0D) & 2047;
			var0.modelType = 5;
			var0.modelId = 0;
		} else if (var1 == 328) {
			var0.modelAngleX = 150;
			var0.modelAngleY = (int)(Math.sin((double)Client.cycle / 40.0D) * 256.0D) & 2047;
			var0.modelType = 5;
			var0.modelId = 1;
		}
	}
}
