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
   int field1092 = 0;


   @ObfuscatedSignature(
      signature = "(Lmx;)V"
   )
   FriendSystem(LoginType var1) {
      this.loginType = var1;
      this.friendsList = new FriendsList(var1);
      this.ignoreList = new IgnoreList(var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1209289020"
   )
   boolean method1952() {
      return this.field1092 == 2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "104"
   )
   final void method1953() {
      this.field1092 = 1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lkb;II)V",
      garbageValue = "1535812566"
   )
   final void method1963(Buffer var1, int var2) {
      this.friendsList.method5256(var1, var2);
      this.field1092 = 2;
      class236.method4225();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1051336580"
   )
   final void method1955() {
      for(FriendLoginUpdate var1 = (FriendLoginUpdate)this.friendsList.friendLoginUpdates.method4990(); var1 != null; var1 = (FriendLoginUpdate)this.friendsList.friendLoginUpdates.method4986()) {
         if((long)var1.field3636 < class217.method4036() / 1000L - 5L) {
            if(var1.world > 0) {
               Skeleton.method3175(5, "", var1.username + " has logged in.");
            }

            if(var1.world == 0) {
               Skeleton.method3175(5, "", var1.username + " has logged out.");
            }

            var1.method3673();
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-589542332"
   )
   final void method2010() {
      this.field1092 = 0;
      this.friendsList.method5186();
      this.ignoreList.method5186();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lku;ZI)Z",
      garbageValue = "-1932720892"
   )
   final boolean method1991(Username var1, boolean var2) {
      return var1 == null?false:(var1.equals(ByteArrayPool.localPlayer.username)?true:this.friendsList.method5261(var1, var2));
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lku;B)Z",
      garbageValue = "-125"
   )
   final boolean method1958(Username var1) {
      return var1 == null?false:this.ignoreList.method5142(var1);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-36"
   )
   final void method1959(String var1) {
      this.rl$addFriend(var1);
      if(var1 != null) {
         Username var2 = new Username(var1, this.loginType);
         if(var2.method5264()) {
            if(this.method1960()) {
               LoginPacket.method3693();
            } else if(ByteArrayPool.localPlayer.username.equals(var2)) {
               GrandExchangeEvent.method165("You can\'t add yourself to your own friend list");
            } else if(this.method1991(var2, false)) {
               DevicePcmPlayerProvider.method946(var1);
            } else if(this.method1958(var2)) {
               ClientPreferences.method1950(var1);
            } else {
               PacketBufferNode var3 = FaceNormal.method3377(ClientPacket.field2290, Client.packetWriter.isaacCipher);
               var3.packetBuffer.method5559(class234.method4223(var1));
               var3.packetBuffer.method5655(var1);
               Client.packetWriter.method2375(var3);
            }
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2128609566"
   )
   final boolean method1960() {
      return this.friendsList.method5199() || this.friendsList.method5140() >= 200 && Client.field798 != 1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-110"
   )
   final void method1961(String var1) {
      if(var1 != null) {
         Username var2 = new Username(var1, this.loginType);
         if(var2.method5264()) {
            if(this.method1962()) {
               GrandExchangeEvent.method165("Your ignore list is full. Max of 100 for free users, and 400 for members");
            } else if(ByteArrayPool.localPlayer.username.equals(var2)) {
               ChatChannel.method2351();
            } else if(this.method1958(var2)) {
               GrandExchangeEvent.method165(var1 + " is already on your ignore list");
            } else if(this.method1991(var2, false)) {
               class195.method3697(var1);
            } else {
               PacketBufferNode var3 = FaceNormal.method3377(ClientPacket.field2216, Client.packetWriter.isaacCipher);
               var3.packetBuffer.method5559(class234.method4223(var1));
               var3.packetBuffer.method5655(var1);
               Client.packetWriter.method2375(var3);
            }
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-46"
   )
   final boolean method1962() {
      return this.ignoreList.method5199() || this.ignoreList.method5140() >= 100 && Client.field798 != 1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-31"
   )
   final void method1995(String var1) {
      this.rl$removeFriend(var1);
      if(var1 != null) {
         Username var2 = new Username(var1, this.loginType);
         if(var2.method5264()) {
            if(this.friendsList.method5146(var2)) {
               Clock.method3600();
               PacketBufferNode var3 = FaceNormal.method3377(ClientPacket.field2297, Client.packetWriter.isaacCipher);
               var3.packetBuffer.method5559(class234.method4223(var1));
               var3.packetBuffer.method5655(var1);
               Client.packetWriter.method2375(var3);
            }

            class236.method4225();
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-29"
   )
   final void method1964(String var1) {
      if(var1 != null) {
         Username var2 = new Username(var1, this.loginType);
         if(var2.method5264()) {
            if(this.ignoreList.method5146(var2)) {
               Clock.method3600();
               PacketBufferNode var3 = FaceNormal.method3377(ClientPacket.field2222, Client.packetWriter.isaacCipher);
               var3.packetBuffer.method5559(class234.method4223(var1));
               var3.packetBuffer.method5655(var1);
               Client.packetWriter.method2375(var3);
            }

            FontName.method5387();
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lku;I)Z",
      garbageValue = "-407468573"
   )
   final boolean method1965(Username var1) {
      Friend var2 = (Friend)this.friendsList.method5227(var1);
      return var2 != null && var2.method5240();
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
      return this.method1991((Username)var1, var2);
   }

   public void addFriend(String var1) {
      this.method1959(var1);
   }

   public void removeFriend(String var1) {
      this.method1995(var1);
   }
}
