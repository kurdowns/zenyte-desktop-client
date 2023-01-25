package com.zenyte.desktop;

import net.runelite.api.ClanMember;
import net.runelite.api.events.ClanMemberJoined;
import net.runelite.api.events.ClanMemberLeft;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSClanChat;
import net.runelite.rs.api.RSUser;
import net.runelite.rs.api.RSUsername;

@ObfuscatedName("ko")
public class ClanChat extends UserList<ClanMember> implements RSClanChat {
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lmx;"
	)
	final LoginType loginType;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lkt;"
	)
	final Usernamed localUser;
	@ObfuscatedName("e")
	public String name;
	@ObfuscatedName("s")
	public String owner;
	@ObfuscatedName("p")
	public byte minKick;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1347537209
	)
	public int rank;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 2146085943
	)
	int field3634;

	@ObfuscatedSignature(
		signature = "(Lmx;Lkt;)V"
	)
	public ClanChat(LoginType var1, Usernamed var2) {
		super(100);
		this.name = null;
		this.owner = null;
		this.field3634 = 1;
		this.loginType = var1;
		this.localUser = var2;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Ljd;",
		garbageValue = "-1332552421"
	)
	User vmethod5269() {
		return new ClanMate();
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(II)[Ljd;",
		garbageValue = "-667029686"
	)
	User[] vmethod5281(int var1) {
		return new ClanMate[var1];
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "105"
	)
	final void method5271(String var1) {
		this.name = DevicePcmPlayerProvider.method948(var1);
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "2103961051"
	)
	final void method5272(String var1) {
		this.owner = DevicePcmPlayerProvider.method948(var1);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lkb;I)V",
		garbageValue = "1675969989"
	)
	public final void method5273(Buffer var1) {
		this.method5272(var1.method5667());
		long var2 = var1.method5553();
		this.method5271(GameObject.method3391(var2));
		this.minKick = var1.method5548();
		int var4 = var1.method5547();
		if (var4 != 255) {
			this.method5161();

			for (int var5 = 0; var5 < var4; ++var5) {
				ClanMate var6 = (ClanMate)this.method5123(new Username(var1.method5667(), this.loginType));
				int var7 = var1.method5549();
				var6.method5213(var7, ++this.field3634 - 1);
				var6.rank = var1.method5548();
				var1.method5667();
				this.method5277(var6);
			}

		}
	}

	public void rl$add(RSUsername var1, RSUsername var2) {
		ClanMember var3 = (ClanMember)this.findByName(var1);
		if (var3 != null) {
			ClanMemberJoined var4 = new ClanMemberJoined(var3);
			WorldMapSection1.client.getCallbacks().postDeferred(ClanMemberJoined.class, var4);
		}
	}

	public void rl$remove(RSUser var1) {
		ClanMember var2 = (ClanMember)this.findByName(var1.getRsName());
		if (var2 != null) {
			ClanMemberLeft var3 = new ClanMemberLeft(var2);
			WorldMapSection1.client.getCallbacks().postDeferred(ClanMemberLeft.class, var3);
		}
	}

	public String getClanChatName() {
		return this.name;
	}

	public String getClanOwner() {
		return this.owner;
	}

	@ObfuscatedName("ca")
	@ObfuscatedSignature(
		signature = "(Lkb;I)V",
		garbageValue = "-1155305071"
	)
	public final void method5274(Buffer var1) {
		Username var2 = new Username(var1.method5667(), this.loginType);
		int var3 = var1.method5549();
		byte var4 = var1.method5548();
		boolean var5 = false;
		if (var4 == -128) {
			var5 = true;
		}

		ClanMate var6;
		if (var5) {
			if (this.method5115() == 0) {
				return;
			}

			var6 = (ClanMate)this.method5119(var2);
			if (var6 != null && var6.method5214() == var3) {
				this.method5195(var6);
			}
		} else {
			var1.method5667();
			var6 = (ClanMate)this.method5119(var2);
			if (var6 == null) {
				if (this.method5115() > super.capacity) {
					return;
				}

				var6 = (ClanMate)this.method5123(var2);
			}

			var6.method5213(var3, ++this.field3634 - 1);
			var6.rank = var4;
			this.method5277(var6);
		}

	}

	@ObfuscatedName("cj")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1797514283"
	)
	public final void method5275() {
		for (int var1 = 0; var1 < this.method5115(); ++var1) {
			((ClanMate)this.method5196(var1)).method5042();
		}

	}

	@ObfuscatedName("cp")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1089464789"
	)
	public final void method5284() {
		for (int var1 = 0; var1 < this.method5115(); ++var1) {
			((ClanMate)this.method5196(var1)).method5057();
		}

	}

	@ObfuscatedName("ck")
	@ObfuscatedSignature(
		signature = "(Ljt;I)V",
		garbageValue = "-66701208"
	)
	final void method5277(ClanMate var1) {
		if (var1.method5068().equals(this.localUser.vmethod5223())) {
			this.rank = var1.rank;
		}

	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "1033875086"
	)
	static String method5291() {
		String var0;
		if (GrandExchangeOfferOwnWorldComparator.clientPreferences.hideUsername) {
			String var2 = Login.Login_username;
			int var4 = var2.length();
			char[] var5 = new char[var4];

			for (int var6 = 0; var6 < var4; ++var6) {
				var5[var6] = '*';
			}

			String var3 = new String(var5);
			var0 = var3;
		} else {
			var0 = Login.Login_username;
		}

		return var0;
	}
}
