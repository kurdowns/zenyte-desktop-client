import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSGrandExchangeOfferOwnWorldComparator;

@ObfuscatedName("bl")
public class GrandExchangeOfferOwnWorldComparator implements Comparator, RSGrandExchangeOfferOwnWorldComparator {

   @ObfuscatedName("sb")
   @ObfuscatedSignature(
      signature = "Lcq;"
   )
   static ClientPreferences clientPreferences;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lle;"
   )
   static IndexedSprite titlebuttonSprite;
   @ObfuscatedName("n")
   public static boolean field677;
   @ObfuscatedName("x")
   boolean filterWorlds;


   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Li;Li;B)I",
      garbageValue = "-63"
   )
   int method1391(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      if(var2.world == var1.world) {
         return 0;
      } else {
         if(this.filterWorlds) {
            if(Client.worldId == var1.world) {
               return -1;
            }

            if(var2.world == Client.worldId) {
               return 1;
            }
         }

         return var1.world < var2.world?-1:1;
      }
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method1391((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lbb;I)V",
      garbageValue = "193917669"
   )
   public static void method1395(ScriptEvent var0) {
      PlayerAppearance.method4124(var0, 500000, 2013269807);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-459151232"
   )
   static void method1398(int var0) {
      ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.method6046((long)var0);
      if(var1 != null) {
         for(int var2 = 0; var2 < var1.ids.length; ++var2) {
            var1.ids[var2] = -1;
            var1.quantities[var2] = 0;
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "120"
   )
   static final String method1385(int var0) {
      return var0 < 100000?"<col=ffff00>" + var0 + "</col>":(var0 < 10000000?"<col=ffffff>" + var0 / 1000 + "K" + "</col>":"<col=00ff80>" + var0 / 1000000 + "M" + "</col>");
   }

   @ObfuscatedName("ff")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-90506590"
   )
   static void method1396(int var0, int var1) {
      int[] var2 = new int[9];

      for(int var3 = 0; var3 < var2.length; ++var3) {
         int var4 = var3 * 32 + 15 + 128;
         int var5 = UserComparator4.method3483(var4);
         int var6 = Rasterizer3D.Rasterizer3D_sine[var4];
         var5 = Varcs.method2295(var5, var1);
         var2[var3] = var6 * var5 >> 16;
      }

      Scene.method3211(var2, 500, 800, var0 * 334 / var1, 334);
   }
}
