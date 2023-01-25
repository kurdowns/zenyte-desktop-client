package com.zenyte.desktop;

import java.util.HashSet;
import java.util.Set;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSModeWhere;

@ObfuscatedName("gd")
public class ModeWhere implements Enumerated, RSModeWhere {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	static final ModeWhere field2375;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	static final ModeWhere field2382;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	static final ModeWhere field2374;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	static final ModeWhere field2376;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	static final ModeWhere field2378;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	static final ModeWhere field2379;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	static final ModeWhere field2380;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	static final ModeWhere field2381;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	static final ModeWhere field2377;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	static final ModeWhere field2383;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	static final ModeWhere field2384;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	static final ModeWhere field2385;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	static final ModeWhere field2386;
	@ObfuscatedName("bh")
	static String worldListURL;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1460687895
	)
	final int id;
	@ObfuscatedName("h")
	final Set field2388;

	static {
		field2375 = new ModeWhere("", 0, new class200[]{class200.field2370});
		field2382 = new ModeWhere("", 1, new class200[]{class200.field2371, class200.field2370});
		field2374 = new ModeWhere("", 2, new class200[]{class200.field2371, class200.field2369, class200.field2370});
		field2376 = new ModeWhere("", 3, new class200[]{class200.field2371});
		field2378 = new ModeWhere("", 4);
		field2379 = new ModeWhere("", 5, new class200[]{class200.field2371, class200.field2370});
		field2380 = new ModeWhere("", 6, new class200[]{class200.field2370});
		field2381 = new ModeWhere("", 8, new class200[]{class200.field2371, class200.field2370});
		field2377 = new ModeWhere("", 9, new class200[]{class200.field2371, class200.field2369});
		field2383 = new ModeWhere("", 10, new class200[]{class200.field2371});
		field2384 = new ModeWhere("", 11, new class200[]{class200.field2371});
		field2385 = new ModeWhere("", 12, new class200[]{class200.field2371, class200.field2370});
		field2386 = new ModeWhere("", 13, new class200[]{class200.field2371});
		method3732();
	}

	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I[Lgy;)V"
	)
	ModeWhere(String var1, int var2, class200[] var3) {
		this.field2388 = new HashSet();
		this.id = var2;
		class200[] var4 = var3;

		for (int var5 = 0; var5 < var4.length; ++var5) {
			class200 var6 = var4[var5];
			this.field2388.add(var6);
		}

	}

	ModeWhere(String var1, int var2) {
		this.field2388 = new HashSet();
		this.id = var2;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "56"
	)
	public int vmethod6149() {
		return this.id;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)[Lgd;",
		garbageValue = "-2096888845"
	)
	static ModeWhere[] method3732() {
		return new ModeWhere[]{field2379, field2385, field2386, field2376, field2384, field2380, field2381, field2377, field2378, field2374, field2375, field2382, field2383};
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "1010005518"
	)
	static int method3740(int var0, int var1) {
		ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.method6010((long)var0);
		if (var2 == null) {
			return -1;
		} else {
			return var1 >= 0 && var1 < var2.ids.length ? var2.ids[var1] : -1;
		}
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IIB)I",
		garbageValue = "-122"
	)
	public static int method3742(int var0, int var1) {
		int var2;
		if (var1 > var0) {
			var2 = var0;
			var0 = var1;
			var1 = var2;
		}

		while (var1 != 0) {
			var2 = var0 % var1;
			var0 = var1;
			var1 = var2;
		}

		return var0;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "1096677335"
	)
	static int method3739(int var0, class101 var1, boolean var2) {
		if (var0 < 1000) {
			return WorldMapLabel.method517(var0, var1, var2);
		} else if (var0 < 1100) {
			return SecureRandomCallable.method1249(var0, var1, var2);
		} else if (var0 < 1200) {
			return UserList.method5201(var0, var1, var2);
		} else if (var0 < 1300) {
			return class2.method28(var0, var1, var2);
		} else if (var0 < 1400) {
			return Decimator.method2635(var0, var1, var2);
		} else if (var0 < 1500) {
			return WorldMapEvent.method866(var0, var1, var2);
		} else if (var0 < 1600) {
			return GrandExchangeOffer.method191(var0, var1, var2);
		} else if (var0 < 1700) {
			return GrandExchangeOfferWorldComparator.method137(var0, var1, var2);
		} else if (var0 < 1800) {
			return NPC.method2133(var0, var1, var2);
		} else if (var0 < 1900) {
			return WorldMapSection1.method683(var0, var1, var2);
		} else if (var0 < 2000) {
			return PlayerType.method4209(var0, var1, var2);
		} else if (var0 < 2100) {
			return SecureRandomCallable.method1249(var0, var1, var2);
		} else if (var0 < 2200) {
			return UserList.method5201(var0, var1, var2);
		} else if (var0 < 2300) {
			return class2.method28(var0, var1, var2);
		} else if (var0 < 2400) {
			return Decimator.method2635(var0, var1, var2);
		} else if (var0 < 2500) {
			return WorldMapEvent.method866(var0, var1, var2);
		} else if (var0 < 2600) {
			return WorldMapManager.method750(var0, var1, var2);
		} else if (var0 < 2700) {
			return class7.method101(var0, var1, var2);
		} else if (var0 < 2800) {
			return UrlRequest.method3409(var0, var1, var2);
		} else if (var0 < 2900) {
			return Message.method1318(var0, var1, var2);
		} else if (var0 < 3000) {
			return PlayerType.method4209(var0, var1, var2);
		} else if (var0 < 3200) {
			return Widget.method4159(var0, var1, var2);
		} else if (var0 < 3300) {
			return NPC.method2131(var0, var1, var2);
		} else if (var0 < 3400) {
			return AbstractUserComparator.method5095(var0, var1, var2);
		} else if (var0 < 3500) {
			return class52.method904(var0, var1, var2);
		} else if (var0 < 3700) {
			return class13.method132(var0, var1, var2);
		} else if (var0 < 4000) {
			return class224.method4100(var0, var1, var2);
		} else if (var0 < 4100) {
			return ObjectDefinition.method4686(var0, var1, var2);
		} else if (var0 < 4200) {
			return AbstractWorldMapData.method384(var0, var1, var2);
		} else if (var0 < 4300) {
			return class22.method258(var0, var1, var2);
		} else if (var0 < 5100) {
			return BoundaryObject.method3362(var0, var1, var2);
		} else if (var0 < 5400) {
			return WorldMapEvent.method865(var0, var1, var2);
		} else if (var0 < 5600) {
			return AbstractWorldMapData.method380(var0, var1, var2);
		} else if (var0 < 5700) {
			return WorldMapData_1.method814(var0, var1, var2);
		} else if (var0 < 6300) {
			return MouseRecorder.method1290(var0, var1, var2);
		} else if (var0 < 6600) {
			return GrandExchangeOfferNameComparator.method238(var0, var1, var2);
		} else {
			return var0 < 6700 ? IgnoreList.method5106(var0, var1, var2) : 2;
		}
	}
}
