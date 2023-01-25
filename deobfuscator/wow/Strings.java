import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSStrings;

@ObfuscatedName("hx")
public class Strings implements RSStrings {

   @ObfuscatedName("rx")
   @ObfuscatedGetter(
      intValue = 779408512
   )
   static int field2759;
   @ObfuscatedName("bd")
   public static String field2811 = "Please visit the support page for assistance.";
   @ObfuscatedName("cy")
   public static String field2914 = "Please visit the support page for assistance.";
   @ObfuscatedName("jm")
   public static String field3026 = "";
   @ObfuscatedName("jh")
   public static String field2898 = "Page has opened in a new window.";
   @ObfuscatedName("jk")
   public static String field2807 = "(Please check your popup blocker.)";


   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IS)Lii;",
      garbageValue = "18624"
   )
   public static GameBuild method4220(int var0) {
      GameBuild[] var1 = Language.method3752();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         GameBuild var3 = var1[var2];
         if(var0 == var3.buildId) {
            return var3;
         }
      }

      return null;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1791203071"
   )
   static final int method4221(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & '\uff80') + var1;
      }
   }
}
