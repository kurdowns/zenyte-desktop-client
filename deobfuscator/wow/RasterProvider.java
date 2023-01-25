import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Shape;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.util.Hashtable;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSRasterProvider;

@ObfuscatedName("bh")
public final class RasterProvider extends AbstractRasterProvider implements RSRasterProvider {

   @ObfuscatedName("x")
   Component component;
   @ObfuscatedName("m")
   Image image;


   RasterProvider(int var1, int var2, Component var3) {
      super.width = var1;
      super.height = var2;
      super.pixels = new int[var2 * var1 + 1];
      DataBufferInt var4 = new DataBufferInt(super.pixels, super.pixels.length);
      DirectColorModel var5 = new DirectColorModel(32, 16711680, '\uff00', 255);
      WritableRaster var6 = Raster.createWritableRaster(var5.createCompatibleSampleModel(super.width, super.height), var4, (Point)null);
      this.image = new BufferedImage(var5, var6, false, new Hashtable());
      this.method1001(var3);
      this.method6178();
      this.init(var1, var2, var3);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "894605018"
   )
   final void method1001(Component var1) {
      this.component = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1321130014"
   )
   public final void vmethod6179(int var1, int var2) {
      this.method1005(this.component.getGraphics(), var1, var2);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIIS)V",
      garbageValue = "32475"
   )
   public final void vmethod6185(int var1, int var2, int var3, int var4) {
      this.method1009(this.component.getGraphics(), var1, var2, var3, var4);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "-972433777"
   )
   final void method1005(Graphics var1, int var2, int var3) {
      WorldMapSection1.client.getCallbacks().draw(this, var1, var2, var3);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "297654999"
   )
   final void method1009(Graphics var1, int var2, int var3, int var4, int var5) {
      try {
         Shape var6 = var1.getClip();
         var1.clipRect(var2, var3, var4, var5);
         var1.drawImage(this.image, 0, 0, this.component);
         var1.setClip(var6);
      } catch (Exception var7) {
         this.component.repaint();
      }

   }

   public void setImage(Image var1) {
      this.image = var1;
   }

   public void init(int var1, int var2, Component var3) {
      if(WorldMapSection1.client.isGpu()) {
         int[] var4 = this.getPixels();
         DataBufferInt var5 = new DataBufferInt(var4, var4.length);
         DirectColorModel var6 = new DirectColorModel(ColorSpace.getInstance(1000), 32, 16711680, '\uff00', 255, -16777216, true, 3);
         WritableRaster var7 = Raster.createWritableRaster(var6.createCompatibleSampleModel(var1, var2), var5, (Point)null);
         BufferedImage var8 = new BufferedImage(var6, var7, true, new Hashtable());
         this.setImage(var8);
      }
   }

   public Component getCanvas() {
      return this.component;
   }

   public Image getImage() {
      return this.image;
   }
}
