import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSPcmStream;
import net.runelite.rs.api.RSPcmStreamMixer;

@ObfuscatedName("dz")
public class PcmStreamMixer extends PcmStream implements RSPcmStreamMixer {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   NodeDeque subStreams = new NodeDeque();
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   NodeDeque field1357 = new NodeDeque();
   @ObfuscatedName("k")
   int field1358 = 0;
   @ObfuscatedName("d")
   int field1355 = -1;


   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lds;)V"
   )
   public final synchronized void method2399(PcmStream var1) {
      this.subStreams.method4952(var1);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lds;)V"
   )
   public final synchronized void method2400(PcmStream var1) {
      var1.method3676();
   }

   @ObfuscatedName("k")
   void method2401() {
      if(this.field1358 > 0) {
         for(PcmStreamMixerListener var1 = (PcmStreamMixerListener)this.field1357.method4956(); var1 != null; var1 = (PcmStreamMixerListener)this.field1357.method4974()) {
            var1.field1466 -= this.field1358;
         }

         this.field1355 -= this.field1358;
         this.field1358 = 0;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lga;Ldo;)V"
   )
   void method2402(Node var1, PcmStreamMixerListener var2) {
      while(this.field1357.sentinel != var1 && ((PcmStreamMixerListener)var1).field1466 <= var2.field1466) {
         var1 = var1.previous;
      }

      NodeDeque.method4953(var2, var1);
      this.field1355 = ((PcmStreamMixerListener)this.field1357.sentinel.previous).field1466;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ldo;)V"
   )
   void method2403(PcmStreamMixerListener var1) {
      var1.method3676();
      var1.method2624();
      Node var2 = this.field1357.sentinel.previous;
      if(var2 == this.field1357.sentinel) {
         this.field1355 = -1;
      } else {
         this.field1355 = ((PcmStreamMixerListener)var2).field1466;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "()Lds;"
   )
   protected PcmStream vmethod3984() {
      return (PcmStream)this.subStreams.method4956();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "()Lds;"
   )
   protected PcmStream vmethod3986() {
      return (PcmStream)this.subStreams.method4974();
   }

   @ObfuscatedName("z")
   protected int vmethod3985() {
      return 0;
   }

   @ObfuscatedName("t")
   public final synchronized void vmethod3988(int[] var1, int var2, int var3) {
      do {
         if(this.field1355 < 0) {
            this.method2412(var1, var2, var3);
            return;
         }

         if(var3 + this.field1358 < this.field1355) {
            this.field1358 += var3;
            this.method2412(var1, var2, var3);
            return;
         }

         int var4 = this.field1355 - this.field1358;
         this.method2412(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1358 += var4;
         this.method2401();
         PcmStreamMixerListener var5 = (PcmStreamMixerListener)this.field1357.method4956();
         synchronized(var5) {
            int var7 = var5.method2625();
            if(var7 < 0) {
               var5.field1466 = 0;
               this.method2403(var5);
            } else {
               var5.field1466 = var7;
               this.method2402(var5.previous, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("e")
   void method2412(int[] var1, int var2, int var3) {
      for(PcmStream var4 = (PcmStream)this.subStreams.method4956(); var4 != null; var4 = (PcmStream)this.subStreams.method4974()) {
         var4.method2824(var1, var2, var3);
      }

   }

   @ObfuscatedName("s")
   public final synchronized void vmethod3989(int var1) {
      do {
         if(this.field1355 < 0) {
            this.method2410(var1);
            return;
         }

         if(this.field1358 + var1 < this.field1355) {
            this.field1358 += var1;
            this.method2410(var1);
            return;
         }

         int var2 = this.field1355 - this.field1358;
         this.method2410(var2);
         var1 -= var2;
         this.field1358 += var2;
         this.method2401();
         PcmStreamMixerListener var3 = (PcmStreamMixerListener)this.field1357.method4956();
         synchronized(var3) {
            int var5 = var3.method2625();
            if(var5 < 0) {
               var3.field1466 = 0;
               this.method2403(var3);
            } else {
               var3.field1466 = var5;
               this.method2402(var3.previous, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("p")
   void method2410(int var1) {
      for(PcmStream var2 = (PcmStream)this.subStreams.method4956(); var2 != null; var2 = (PcmStream)this.subStreams.method4974()) {
         var2.vmethod3989(var1);
      }

   }

   public void addSubStream(RSPcmStream var1) {
      this.method2399((PcmStream)var1);
   }
}
