package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSFriendsList;

@ObfuscatedName("kr")
public class FriendsList extends UserList<net.runelite.api.Friend> implements RSFriendsList {
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lmx;"
	)
	final LoginType loginType;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -975708825
	)
	int field3618;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Ljk;"
	)
	public LinkDeque friendLoginUpdates;

	@ObfuscatedSignature(
		signature = "(Lmx;)V"
	)
	public FriendsList(LoginType var1) {
		super(400);
		this.field3618 = 1;
		this.friendLoginUpdates = new LinkDeque();
		this.loginType = var1;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Ljd;",
		garbageValue = "-1332552421"
	)
	User vmethod5269() {
		return new Friend();
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(II)[Ljd;",
		garbageValue = "-667029686"
	)
	User[] vmethod5281(int var1) {
		return new Friend[var1];
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lku;ZI)Z",
		garbageValue = "-141392117"
	)
	public boolean method5236(Username var1, boolean var2) {
		Friend var3 = (Friend)this.method5202(var1);
		if (var3 == null) {
			return false;
		} else {
			return !var2 || var3.world != 0;
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lkb;IB)V",
		garbageValue = "51"
	)
	public void method5231(Buffer var1, int var2) {
		while (true) {
			if (var1.offset < var2) {
				boolean var3 = var1.method5547() == 1;
				Username var4 = new Username(var1.method5667(), this.loginType);
				Username var5 = new Username(var1.method5667(), this.loginType);
				int var6 = var1.method5549();
				int var7 = var1.method5547();
				int var8 = var1.method5547();
				boolean var9 = (var8 & 2) != 0;
				boolean var10 = (var8 & 1) != 0;
				if (var6 > 0) {
					var1.method5667();
					var1.method5547();
					var1.method5552();
				}

				var1.method5667();
				if (var4 != null && var4.method5239()) {
					Friend var11 = (Friend)this.method5119(var4);
					if (var3) {
						Friend var12 = (Friend)this.method5119(var5);
						if (var12 != null && var11 != var12) {
							if (var11 != null) {
								this.method5195(var12);
							} else {
								var11 = var12;
							}
						}
					}

					if (var11 != null) {
						this.method5127(var11, var4, var5);
						if (var6 != var11.world) {
							boolean var14 = true;

							for (FriendLoginUpdate var13 = (FriendLoginUpdate)this.friendLoginUpdates.method4965(); var13 != null; var13 = (FriendLoginUpdate)this.friendLoginUpdates.method4961()) {
								if (var13.username.equals(var4)) {
									if (var6 != 0 && var13.world == 0) {
										var13.method3654();
										var14 = false;
									} else if (var6 == 0 && var13.world != 0) {
										var13.method3654();
										var14 = false;
									}
								}
							}

							if (var14) {
								this.friendLoginUpdates.method4960(new FriendLoginUpdate(var4, var6));
							}
						}
					} else {
						if (this.method5115() >= 400) {
							continue;
						}

						var11 = (Friend)this.method5184(var4, var5);
					}

					if (var6 != var11.world) {
						var11.int2 = ++this.field3618 - 1;
						if (var11.world == -1 && var6 == 0) {
							var11.int2 = -(var11.int2 * -1563374063) * 1414783729;
						}

						var11.world = var6;
					}

					var11.rank = var7;
					var11.field3625 = var9;
					var11.field3623 = var10;
					continue;
				}

				throw new IllegalStateException();
			}

			this.method5126();
			return;
		}
	}
}
