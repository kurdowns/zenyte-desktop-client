import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSAbstractRasterProvider;

@ObfuscatedName("lj")
public abstract class AbstractRasterProvider implements RSAbstractRasterProvider {

   @ObfuscatedName("a")
   public static String[] field3871;
   @ObfuscatedName("k")
   public int[] pixels;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2037520285
   )
   public int width;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -645523785
   )
   public int height;


   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1321130014"
   )
   public abstract void vmethod6179(int var1, int var2);

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIIS)V",
      garbageValue = "32475"
   )
   public abstract void vmethod6185(int var1, int var2, int var3, int var4);

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1783812684"
   )
   public final void method6178() {
      Rasterizer2D.method6083(this.pixels, this.width, this.height);
   }

   public int[] getPixels() {
      return this.pixels;
   }

   public int getWidth() {
      return this.width;
   }

   public int getHeight() {
      return this.height;
   }

   public void setRaster() {
      this.method6178();
   }
}
