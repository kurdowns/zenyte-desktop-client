import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSGraphicsDefaults;

@ObfuscatedName("lx")
public class GraphicsDefaults implements RSGraphicsDefaults {

   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 281653791
   )
   public int compass = -1;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1495832325
   )
   public int field3824 = -1;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 465334207
   )
   public int mapScenes = -1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1124129299
   )
   public int headIconsPk = -1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -392532665
   )
   public int field3817 = -1;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 505847237
   )
   public int field3818 = -1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -322608503
   )
   public int field3819 = -1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 91782019
   )
   public int field3820 = -1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -918755557
   )
   public int field3821 = -1;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1836222511
   )
   public int field3822 = -1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -581916301
   )
   public int field3823 = -1;


   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Liy;I)V",
      garbageValue = "-1759254165"
   )
   public void method5970(AbstractArchive var1) {
      byte[] var2 = var1.method4256(DefaultsGroup.field3811.group);
      Buffer var3 = new Buffer(var2);

      while(true) {
         int var4 = var3.method5575();
         if(var4 == 0) {
            return;
         }

         switch(var4) {
         case 1:
            var3.method5702();
            break;
         case 2:
            this.compass = var3.method5592();
            this.field3824 = var3.method5592();
            this.mapScenes = var3.method5592();
            this.headIconsPk = var3.method5592();
            this.field3817 = var3.method5592();
            this.field3818 = var3.method5592();
            this.field3819 = var3.method5592();
            this.field3820 = var3.method5592();
            this.field3821 = var3.method5592();
            this.field3822 = var3.method5592();
            this.field3823 = var3.method5592();
         }
      }
   }

   @ObfuscatedName("x")
   static double method5969(double var0, double var2, double var4) {
      double var8 = (var0 - var2) / var4;
      double var6 = Math.exp(-var8 * var8 / 2.0D) / Math.sqrt(6.283185307179586D);
      return var6 / var4;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lkb;Ljava/lang/String;B)I",
      garbageValue = "77"
   )
   public static int method5967(Buffer var0, String var1) {
      int var2 = var0.offset;
      byte[] var3 = WorldMapCacheName.method715(var1);
      var0.method5602(var3.length);
      var0.offset += class219.huffman.method4040(var3, 0, var3.length, var0.array, var0.offset);
      return var0.offset - var2;
   }
}
