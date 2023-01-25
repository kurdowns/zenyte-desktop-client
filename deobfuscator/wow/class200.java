import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gy")
public class class200 {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   static final class200 field2369 = new class200();
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   static final class200 field2371 = new class200();
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   static final class200 field2370 = new class200();
   @ObfuscatedName("hm")
   @ObfuscatedGetter(
      intValue = 319009619
   )
   static int cameraZ;


   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BI)Lla;",
      garbageValue = "1925772237"
   )
   public static final Sprite method3753(byte[] var0) {
      BufferedImage var1 = null;

      try {
         var1 = ImageIO.read(new ByteArrayInputStream(var0));
         int var2 = var1.getWidth();
         int var3 = var1.getHeight();
         int[] var4 = new int[var3 * var2];
         PixelGrabber var5 = new PixelGrabber(var1, 0, 0, var2, var3, var4, 0, var2);
         var5.grabPixels();
         return new Sprite(var4, var2, var3);
      } catch (IOException var7) {
         ;
      } catch (InterruptedException var8) {
         ;
      }

      return new Sprite(0, 0);
   }
}
