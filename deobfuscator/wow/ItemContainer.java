import java.applet.Applet;
import java.net.URL;
import net.runelite.api.Item;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSItemContainer;
import netscape.javascript.JSObject;

@ObfuscatedName("bs")
public class ItemContainer extends Node implements RSItemContainer {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   static NodeHashTable itemContainers = new NodeHashTable(32);
   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "Lle;"
   )
   static IndexedSprite field572;
   @ObfuscatedName("fr")
   @ObfuscatedSignature(
      signature = "Lkf;"
   )
   static Fonts WorldMapElement_fonts;
   @ObfuscatedName("m")
   int[] ids = new int[]{-1};
   @ObfuscatedName("k")
   int[] quantities = new int[]{0};


   public int[] getItemIds() {
      return this.ids;
   }

   public int[] getStackSizes() {
      return this.quantities;
   }

   public Item[] getItems() {
      int[] var1 = this.getItemIds();
      int[] var2 = this.getStackSizes();
      Item[] var3 = new Item[var1.length];

      for(int var4 = 0; var4 < var1.length; ++var4) {
         Item var5 = new Item(var1[var4], var2[var4]);
         var3[var4] = var5;
      }

      return var3;
   }

   public Item getItem(int var1) {
      int[] var2 = this.getItemIds();
      int[] var3 = this.getStackSizes();
      return var1 >= 0 && var1 < var2.length && var2[var1] != -1?new Item(var2[var1], var3[var1]):null;
   }

   public boolean contains(int var1) {
      int[] var2 = this.getItemIds();
      int[] var3 = var2;
      int var4 = var2.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         int var6 = var3[var5];
         if(var6 == var1) {
            return true;
         }
      }

      return false;
   }

   public int count(int var1) {
      int[] var2 = this.getItemIds();
      int[] var3 = this.getStackSizes();
      int var4 = 0;

      for(int var5 = 0; var5 < var2.length; ++var5) {
         if(var2[var5] == var1) {
            int var6 = var3[var5];
            if(var6 > 1) {
               return var6;
            }

            ++var4;
         }
      }

      return var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;B)Z",
      garbageValue = "17"
   )
   static boolean method1274(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class60.field462.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var13 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var13.indexOf(var0.charAt(var4)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var8) {
            return false;
         }
      } else if(var1 == 1) {
         try {
            Applet var7 = class60.applet;
            Object[] var5 = new Object[]{(new URL(class60.applet.getCodeBase(), var0)).toString()};
            Object var3 = JSObject.getWindow(var7).call(var2, var5);
            return var3 != null;
         } catch (Throwable var9) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class60.applet.getAppletContext().showDocument(new URL(class60.applet.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var10) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            class56.method950(class60.applet, "loggedout");
         } catch (Throwable var12) {
            ;
         }

         try {
            class60.applet.getAppletContext().showDocument(new URL(class60.applet.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var11) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   public static void onItemContainerUpdate(int var0) {
      if(var0 != -1) {
         int var1 = var0 - 1 & 31;
         int var2 = Client.changedItemContainers[var1];
         RSItemContainer var3 = (RSItemContainer)WorldMapSection1.client.getItemContainers().get((long)var2);
         if(var3 != null) {
            ItemContainerChanged var4 = new ItemContainerChanged(var2, var3);
            WorldMapSection1.client.getCallbacks().postDeferred(ItemContainerChanged.class, var4);
         }
      }

   }

   @ObfuscatedName("je")
   @ObfuscatedSignature(
      signature = "(Lhe;Ljx;IIZI)V",
      garbageValue = "1190936651"
   )
   static final void method1272(Widget var0, ItemDefinition var1, int var2, int var3, boolean var4) {
      String[] var5 = var1.inventoryActions;
      byte var6 = -1;
      String var7 = null;
      if(var5 != null && var5[var3] != null) {
         if(var3 == 0) {
            var6 = 33;
         } else if(var3 == 1) {
            var6 = 34;
         } else if(var3 == 2) {
            var6 = 35;
         } else if(var3 == 3) {
            var6 = 36;
         } else {
            var6 = 37;
         }

         var7 = var5[var3];
      } else if(var3 == 4) {
         var6 = 37;
         var7 = "Drop";
      }

      if(var6 != -1 && var7 != null) {
         ScriptFrame.method1244(var7, class297.method5342(16748608) + var1.name, var6, var1.id, var2, var0.id, var4);
      }

   }

   @ObfuscatedName("jo")
   @ObfuscatedSignature(
      signature = "(Lhe;I)V",
      garbageValue = "1094341109"
   )
   static void method1273(Widget var0) {
      if(var0.cycle == Client.field884) {
         Client.field679[var0.rootIndex] = true;
      }

   }
}
