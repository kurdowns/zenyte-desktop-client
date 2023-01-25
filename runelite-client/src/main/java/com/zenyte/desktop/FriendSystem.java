package com.zenyte.desktop;

import net.runelite.api.events.FriendAdded;
import net.runelite.api.events.FriendRemoved;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSFriendSystem;
import net.runelite.rs.api.RSFriendsList;
import net.runelite.rs.api.RSIgnoreList;
import net.runelite.rs.api.RSUsername;

@ObfuscatedName("co")
public class FriendSystem implements RSFriendSystem {
	@ObfuscatedName("u")
	static int[] field1086;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lmx;"
	)
	final LoginType loginType;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lkr;"
	)
	public final FriendsList friendsList;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Ljb;"
	)
	public final IgnoreList ignoreList;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 429745001
	)
	int field1092;

	@ObfuscatedSignature(
		signature = "(Lmx;)V"
	)
	FriendSystem(LoginType var1) {
		this.field1092 = 0;
		this.loginType = var1;
		this.friendsList = new FriendsList(var1);
		this.ignoreList = new IgnoreList(var1);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1209289020"
	)
	boolean method1938() {
		return this.field1092 == 2;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "104"
	)
	final void method1939() {
		this.field1092 = 1;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lkb;II)V",
		garbageValue = "1535812566"
	)
	final void method1949(Buffer var1, int var2) {
		this.friendsList.method5231(var1, var2);
		this.field1092 = 2;
		class236.method4200();
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1051336580"
	)
	final void method1941() {
		for (FriendLoginUpdate var1 = (FriendLoginUpdate)this.friendsList.friendLoginUpdates.method4965(); var1 != null; var1 = (FriendLoginUpdate)this.friendsList.friendLoginUpdates.method4961()) {
			if ((long)var1.field3636 < class217.method4014() / 1000L - 5L) {
				if (var1.world > 0) {
					Skeleton.method3161(5, "", var1.username + " has logged in.");
				}

				if (var1.world == 0) {
					Skeleton.method3161(5, "", var1.username + " has logged out.");
				}

				var1.method3654();
			}
		}

	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-589542332"
	)
	final void method1996() {
		this.field1092 = 0;
		this.friendsList.method5161();
		this.ignoreList.method5161();
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lku;ZI)Z",
		garbageValue = "-1932720892"
	)
	final boolean method1977(Username var1, boolean var2) {
		if (var1 == null) {
			return false;
		} else if (var1.equals(ByteArrayPool.localPlayer.username)) {
			return true;
		} else {
			return this.friendsList.method5236(var1, var2);
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lku;B)Z",
		garbageValue = "-125"
	)
	final boolean method1944(Username var1) {
		if (var1 == null) {
			return false;
		} else {
			return this.ignoreList.method5117(var1);
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "-36"
	)
	final void method1945(String var1) {
		this.rl$addFriend(var1);
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.method5239()) {
				if (this.method1946()) {
					LoginPacket.method3674();
				} else if (ByteArrayPool.localPlayer.username.equals(var2)) {
					GrandExchangeEvent.method165("You can't add yourself to your own friend list");
				} else if (this.method1977(var2, false)) {
					DevicePcmPlayerProvider.method946(var1);
				} else if (this.method1944(var2)) {
					ClientPreferences.method1936(var1);
				} else {
					PacketBufferNode var3 = FaceNormal.method3363(ClientPacket.field2290, Client.packetWriter.isaacCipher);
					var3.packetBuffer.method5531(class234.method4198(var1));
					var3.packetBuffer.method5627(var1);
					Client.packetWriter.method2361(var3);
				}
			}
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "2128609566"
	)
	final boolean method1946() {
		return this.friendsList.method5174() || this.friendsList.method5115() >= 200 && Client.field798 != 1;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "-110"
	)
	final void method1947(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.method5239()) {
				if (this.method1948()) {
					GrandExchangeEvent.method165("Your ignore list is full. Max of 100 for free users, and 400 for members");
				} else if (ByteArrayPool.localPlayer.username.equals(var2)) {
					ChatChannel.method2337();
				} else if (this.method1944(var2)) {
					GrandExchangeEvent.method165(var1 + " is already on your ignore list");
				} else if (this.method1977(var2, false)) {
					class195.method3678(var1);
				} else {
					PacketBufferNode var3 = FaceNormal.method3363(ClientPacket.field2216, Client.packetWriter.isaacCipher);
					var3.packetBuffer.method5531(class234.method4198(var1));
					var3.packetBuffer.method5627(var1);
					Client.packetWriter.method2361(var3);
				}
			}
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-46"
	)
	final boolean method1948() {
		return this.ignoreList.method5174() || this.ignoreList.method5115() >= 100 && Client.field798 != 1;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "-31"
	)
	final void method1981(String var1) {
		this.rl$removeFriend(var1);
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.method5239()) {
				if (this.friendsList.method5121(var2)) {
					Clock.method3585();
					PacketBufferNode var3 = FaceNormal.method3363(ClientPacket.field2297, Client.packetWriter.isaacCipher);
					var3.packetBuffer.method5531(class234.method4198(var1));
					var3.packetBuffer.method5627(var1);
					Client.packetWriter.method2361(var3);
				}

				class236.method4200();
			}
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "-29"
	)
	final void method1950(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.method5239()) {
				if (this.ignoreList.method5121(var2)) {
					Clock.method3585();
					PacketBufferNode var3 = FaceNormal.method3363(ClientPacket.field2222, Client.packetWriter.isaacCipher);
					var3.packetBuffer.method5531(class234.method4198(var1));
					var3.packetBuffer.method5627(var1);
					Client.packetWriter.method2361(var3);
				}

				FontName.method5359();
			}
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lku;I)Z",
		garbageValue = "-407468573"
	)
	final boolean method1951(Username var1) {
		Friend var2 = (Friend)this.friendsList.method5202(var1);
		return var2 != null && var2.method5215();
	}

	public void rl$removeFriend(String var1) {
		FriendRemoved var2 = new FriendRemoved(var1);
		WorldMapSection1.client.getCallbacks().post(FriendRemoved.class, var2);
	}

	public void rl$addFriend(String var1) {
		FriendAdded var2 = new FriendAdded(var1);
		WorldMapSection1.client.getCallbacks().post(FriendAdded.class, var2);
	}

	public RSFriendsList getFriendContainer() {
		return this.friendsList;
	}

	public RSIgnoreList getIgnoreContainer() {
		return this.ignoreList;
	}

	public boolean isFriended(RSUsername var1, boolean var2) {
		return this.method1977((Username)var1, var2);
	}

	public void addFriend(String var1) {
		this.method1945(var1);
	}

	public void removeFriend(String var1) {
		this.method1981(var1);
	}
}
