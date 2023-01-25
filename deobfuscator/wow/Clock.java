import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSClock;

@ObfuscatedName("fb")
public abstract class Clock implements RSClock {

   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2046484107
   )
   static int field2061;


   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1351231250"
   )
   public abstract void vmethod3592();

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1723558008"
   )
   public abstract int vmethod3593(int var1, int var2);

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "16"
   )
   public static int method3591(int var0) {
      var0 = (var0 & 1431655765) + (var0 >>> 1 & 1431655765);
      var0 = (var0 >>> 2 & 858993459) + (var0 & 858993459);
      var0 = var0 + (var0 >>> 4) & 252645135;
      var0 += var0 >>> 8;
      var0 += var0 >>> 16;
      return var0 & 255;
   }

   @ObfuscatedName("ko")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   static final void method3600() {
      Client.field873 = Client.cycleCntr;
   }
}
