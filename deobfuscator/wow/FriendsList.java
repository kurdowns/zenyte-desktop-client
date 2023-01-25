import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSFriendsList;

@ObfuscatedName("kr")
public class FriendsList extends UserList implements RSFriendsList {

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lmx;"
   )
   final LoginType loginType;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -975708825
   )
   int field3618 = 1;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   public LinkDeque friendLoginUpdates = new LinkDeque();


   @ObfuscatedSignature(
      signature = "(Lmx;)V"
   )
   public FriendsList(LoginType var1) {
      super(400);
      this.loginType = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Ljd;",
      garbageValue = "-1332552421"
   )
   User vmethod5297() {
      return new Friend();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)[Ljd;",
      garbageValue = "-667029686"
   )
   User[] vmethod5309(int var1) {
      return new Friend[var1];
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lku;ZI)Z",
      garbageValue = "-141392117"
   )
   public boolean method5261(Username var1, boolean var2) {
      Friend var3 = (Friend)this.method5227(var1);
      return var3 == null?false:!var2 || var3.world != 0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lkb;IB)V",
      garbageValue = "51"
   )
   public void method5256(Buffer var1, int var2) {
      while(true) {
         if(var1.offset < var2) {
            boolean var3 = var1.method5575() == 1;
            Username var4 = new Username(var1.method5695(), this.loginType);
            Username var5 = new Username(var1.method5695(), this.loginType);
            int var6 = var1.method5577();
            int var7 = var1.method5575();
            int var8 = var1.method5575();
            boolean var9 = (var8 & 2) != 0;
            boolean var10 = (var8 & 1) != 0;
            if(var6 > 0) {
               var1.method5695();
               var1.method5575();
               var1.method5580();
            }

            var1.method5695();
            if(var4 != null && var4.method5264()) {
               Friend var11 = (Friend)this.method5144(var4);
               if(var3) {
                  Friend var12 = (Friend)this.method5144(var5);
                  if(var12 != null && var11 != var12) {
                     if(var11 != null) {
                        this.method5220(var12);
                     } else {
                        var11 = var12;
                     }
                  }
               }

               if(var11 != null) {
                  this.method5152(var11, var4, var5);
                  if(var6 != var11.world) {
                     boolean var14 = true;

                     for(FriendLoginUpdate var13 = (FriendLoginUpdate)this.friendLoginUpdates.method4990(); var13 != null; var13 = (FriendLoginUpdate)this.friendLoginUpdates.method4986()) {
                        if(var13.username.equals(var4)) {
                           if(var6 != 0 && var13.world == 0) {
                              var13.method3673();
                              var14 = false;
                           } else if(var6 == 0 && var13.world != 0) {
                              var13.method3673();
                              var14 = false;
                           }
                        }
                     }

                     if(var14) {
                        this.friendLoginUpdates.method4985(new FriendLoginUpdate(var4, var6));
                     }
                  }
               } else {
                  if(this.method5140() >= 400) {
                     continue;
                  }

                  var11 = (Friend)this.method5209(var4, var5);
               }

               if(var6 != var11.world) {
                  var11.int2 = ++this.field3618 - 1;
                  if(var11.world == -1 && var6 == 0) {
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

         this.method5151();
         return;
      }
   }
}
