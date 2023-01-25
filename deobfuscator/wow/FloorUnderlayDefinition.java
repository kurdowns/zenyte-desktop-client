import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSFloorUnderlayDefinition;

@ObfuscatedName("if")
public class FloorUnderlayDefinition extends DualNode implements RSFloorUnderlayDefinition {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   public static AbstractArchive FloorUnderlayDefinition_archive;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Leg;"
   )
   public static EvictingDualNodeHashTable FloorUnderlayDefinition_cached = new EvictingDualNodeHashTable(64);
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -982291311
   )
   int rgb = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1361572975
   )
   public int hue;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -932748815
   )
   public int saturation;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -26214431
   )
   public int lightness;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -667494965
   )
   public int hueMultiplier;


   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1794462402"
   )
   void method4504() {
      this.method4507(this.rgb);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lkb;II)V",
      garbageValue = "1422019917"
   )
   void method4516(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.method5575();
         if(var3 == 0) {
            return;
         }

         this.method4506(var1, var3, var2);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lkb;III)V",
      garbageValue = "-1237610564"
   )
   void method4506(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.rgb = var1.method5702();
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2124532512"
   )
   void method4507(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if(var4 < var2) {
         var8 = var4;
      }

      if(var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if(var4 > var2) {
         var10 = var4;
      }

      if(var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var10 + var8) / 2.0D;
      if(var10 != var8) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var10 + var8);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var10 == var6) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.saturation = (int)(256.0D * var14);
      this.lightness = (int)(var16 * 256.0D);
      if(this.saturation < 0) {
         this.saturation = 0;
      } else if(this.saturation > 255) {
         this.saturation = 255;
      }

      if(this.lightness < 0) {
         this.lightness = 0;
      } else if(this.lightness > 255) {
         this.lightness = 255;
      }

      if(var16 > 0.5D) {
         this.hueMultiplier = (int)((1.0D - var16) * var14 * 512.0D);
      } else {
         this.hueMultiplier = (int)(512.0D * var16 * var14);
      }

      if(this.hueMultiplier < 1) {
         this.hueMultiplier = 1;
      }

      this.hue = (int)(var12 * (double)this.hueMultiplier);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Liy;Ljava/lang/String;Ljava/lang/String;I)[Lla;",
      garbageValue = "-1984453529"
   )
   public static Sprite[] method4508(AbstractArchive var0, String var1, String var2) {
      int var3 = var0.method4265(var1);
      int var4 = var0.method4258(var3, var2);
      return ClientPacket.method3689(var0, var3, var4);
   }
}
