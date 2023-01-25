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
public class ClanChat extends UserList implements RSClanChat {

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
   public String name = null;
   @ObfuscatedName("s")
   public String owner = null;
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
   int field3634 = 1;


   @ObfuscatedSignature(
      signature = "(Lmx;Lkt;)V"
   )
   public ClanChat(LoginType var1, Usernamed var2) {
      super(100);
      this.loginType = var1;
      this.localUser = var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Ljd;",
      garbageValue = "-1332552421"
   )
   User vmethod5297() {
      return new ClanMate();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)[Ljd;",
      garbageValue = "-667029686"
   )
   User[] vmethod5309(int var1) {
      return new ClanMate[var1];
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "105"
   )
   final void method5299(String var1) {
      this.name = DevicePcmPlayerProvider.method948(var1);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "2103961051"
   )
   final void method5300(String var1) {
      this.owner = DevicePcmPlayerProvider.method948(var1);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lkb;I)V",
      garbageValue = "1675969989"
   )
   public final void method5301(Buffer var1) {
      this.method5300(var1.method5695());
      long var2 = var1.method5581();
      this.method5299(GameObject.method3405(var2));
      this.minKick = var1.method5576();
      int var4 = var1.method5575();
      if(var4 != 255) {
         this.method5186();

         for(int var5 = 0; var5 < var4; ++var5) {
            ClanMate var6 = (ClanMate)this.method5148(new Username(var1.method5695(), this.loginType));
            int var7 = var1.method5577();
            var6.method5238(var7, ++this.field3634 - 1);
            var6.rank = var1.method5576();
            var1.method5695();
            this.method5305(var6);
         }

      }
   }

   public void rl$add(RSUsername var1, RSUsername var2) {
      ClanMember var3 = (ClanMember)this.findByName(var1);
      if(var3 != null) {
         ClanMemberJoined var4 = new ClanMemberJoined(var3);
         WorldMapSection1.client.getCallbacks().postDeferred(ClanMemberJoined.class, var4);
      }
   }

   public void rl$remove(RSUser var1) {
      ClanMember var2 = (ClanMember)this.findByName(var1.getRsName());
      if(var2 != null) {
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
   public final void method5302(Buffer var1) {
      Username var2 = new Username(var1.method5695(), this.loginType);
      int var3 = var1.method5577();
      byte var4 = var1.method5576();
      boolean var5 = false;
      if(var4 == -128) {
         var5 = true;
      }

      ClanMate var6;
      if(var5) {
         if(this.method5140() == 0) {
            return;
         }

         var6 = (ClanMate)this.method5144(var2);
         if(var6 != null && var6.method5239() == var3) {
            this.method5220(var6);
         }
      } else {
         var1.method5695();
         var6 = (ClanMate)this.method5144(var2);
         if(var6 == null) {
            if(this.method5140() > super.capacity) {
               return;
            }

            var6 = (ClanMate)this.method5148(var2);
         }

         var6.method5238(var3, ++this.field3634 - 1);
         var6.rank = var4;
         this.method5305(var6);
      }

   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1797514283"
   )
   public final void method5303() {
      for(int var1 = 0; var1 < this.method5140(); ++var1) {
         ((ClanMate)this.method5221(var1)).method5067();
      }

   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1089464789"
   )
   public final void method5312() {
      for(int var1 = 0; var1 < this.method5140(); ++var1) {
         ((ClanMate)this.method5221(var1)).method5082();
      }

   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "(Ljt;I)V",
      garbageValue = "-66701208"
   )
   final void method5305(ClanMate var1) {
      if(var1.method5093().equals(this.localUser.vmethod5248())) {
         this.rank = var1.rank;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1033875086"
   )
   static String method5319() {
      String var0;
      if(GrandExchangeOfferOwnWorldComparator.clientPreferences.hideUsername) {
         String var2 = Login.Login_username;
         int var4 = var2.length();
         char[] var5 = new char[var4];

         for(int var6 = 0; var6 < var4; ++var6) {
            var5[var6] = 42;
         }

         String var3 = new String(var5);
         var0 = var3;
      } else {
         var0 = Login.Login_username;
      }

      return var0;
   }
}
