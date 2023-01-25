import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSAbstractSocket;

@ObfuscatedName("lt")
public abstract class AbstractSocket implements RSAbstractSocket {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "7"
   )
   public abstract void vmethod5894();

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1436175029"
   )
   public abstract int vmethod5891() throws IOException;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "195119972"
   )
   public abstract int vmethod5890() throws IOException;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "0"
   )
   public abstract boolean vmethod5889(int var1) throws IOException;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BIIB)I",
      garbageValue = "33"
   )
   public abstract int vmethod5892(byte[] var1, int var2, int var3) throws IOException;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "236801869"
   )
   public abstract void vmethod5909(byte[] var1, int var2, int var3) throws IOException;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-842833143"
   )
   public static final void method5887(int var0, int var1) {
      ViewportMouse.ViewportMouse_x = var0;
      ViewportMouse.ViewportMouse_y = var1;
      ViewportMouse.ViewportMouse_isInViewport = true;
      ViewportMouse.ViewportMouse_entityCount = 0;
      ViewportMouse.ViewportMouse_false0 = false;
   }

   @ObfuscatedName("ke")
   @ObfuscatedSignature(
      signature = "(Lhe;IIIB)V",
      garbageValue = "7"
   )
   static final void method5879(Widget var0, int var1, int var2, int var3) {
      SpriteMask var4 = var0.method4140(false);
      if(var4 != null) {
         if(Client.minimapState < 3) {
            ChatChannel.compass.method6244(var1, var2, var4.width, var4.height, 25, 25, Client.camAngleY, 256, var4.xStarts, var4.xWidths);
         } else {
            Rasterizer2D.method6141(var1, var2, 0, var4.xStarts, var4.xWidths);
         }

      }
   }
}
