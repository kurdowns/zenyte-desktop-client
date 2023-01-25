import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
public class class105 {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   public static IterableNodeDeque reflectionChecks = new IterableNodeDeque();
   @ObfuscatedName("ew")
   static int[] field1345;


   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Liy;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "895690551"
   )
   public static void method2394(AbstractArchive var0, String var1, String var2, int var3, boolean var4) {
      int var5 = var0.method4265(var1);
      int var6 = var0.method4258(var5, var2);
      ApproximateRouteStrategy.method1321(var0, var5, var6, var3, var4);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(DDIB)[D",
      garbageValue = "54"
   )
   public static double[] method2395(double var0, double var2, int var4) {
      int var5 = var4 * 2 + 1;
      double[] var6 = new double[var5];
      int var7 = -var4;

      for(int var8 = 0; var7 <= var4; ++var8) {
         var6[var8] = GraphicsDefaults.method5969((double)var7, var0, var2);
         ++var7;
      }

      return var6;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZB)I",
      garbageValue = "26"
   )
   public static int method2393(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  throw new NumberFormatException();
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var5 * var1 + var10;
            if(var9 / var1 != var5) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("" + var1);
      }
   }
}
