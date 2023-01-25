import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSPcmStream;

@ObfuscatedName("ds")
public abstract class PcmStream extends Node implements RSPcmStream {

   @ObfuscatedName("w")
   volatile boolean active = true;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lds;"
   )
   PcmStream after;
   @ObfuscatedName("a")
   int field1507;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ldf;"
   )
   AbstractSound sound;


   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "()Lds;"
   )
   protected abstract PcmStream vmethod3984();

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "()Lds;"
   )
   protected abstract PcmStream vmethod3986();

   @ObfuscatedName("z")
   protected abstract int vmethod3985();

   @ObfuscatedName("t")
   protected abstract void vmethod3988(int[] var1, int var2, int var3);

   @ObfuscatedName("s")
   protected abstract void vmethod3989(int var1);

   @ObfuscatedName("ac")
   int vmethod2820() {
      return 255;
   }

   @ObfuscatedName("fk")
   final void method2824(int[] var1, int var2, int var3) {
      if(this.active) {
         this.vmethod3988(var1, var2, var3);
      } else {
         this.vmethod3989(var3);
      }

   }
}
