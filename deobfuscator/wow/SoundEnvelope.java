import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSSoundEnvelope;

@ObfuscatedName("de")
public class SoundEnvelope implements RSSoundEnvelope {

   @ObfuscatedName("m")
   int segments = 2;
   @ObfuscatedName("k")
   int[] durations = new int[2];
   @ObfuscatedName("d")
   int[] phases = new int[2];
   @ObfuscatedName("w")
   int start;
   @ObfuscatedName("v")
   int end;
   @ObfuscatedName("q")
   int form;
   @ObfuscatedName("z")
   int ticks;
   @ObfuscatedName("t")
   int phaseIndex;
   @ObfuscatedName("e")
   int step;
   @ObfuscatedName("s")
   int amplitude;
   @ObfuscatedName("p")
   int max;


   SoundEnvelope() {
      this.durations[0] = 0;
      this.durations[1] = '\uffff';
      this.phases[0] = 0;
      this.phases[1] = '\uffff';
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lkb;)V"
   )
   final void method2595(Buffer var1) {
      this.form = var1.method5575();
      this.start = var1.method5580();
      this.end = var1.method5580();
      this.method2597(var1);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lkb;)V"
   )
   final void method2597(Buffer var1) {
      this.segments = var1.method5575();
      this.durations = new int[this.segments];
      this.phases = new int[this.segments];

      for(int var2 = 0; var2 < this.segments; ++var2) {
         this.durations[var2] = var1.method5577();
         this.phases[var2] = var1.method5577();
      }

   }

   @ObfuscatedName("k")
   final void method2598() {
      this.ticks = 0;
      this.phaseIndex = 0;
      this.step = 0;
      this.amplitude = 0;
      this.max = 0;
   }

   @ObfuscatedName("d")
   final int method2599(int var1) {
      if(this.max >= this.ticks) {
         this.amplitude = this.phases[this.phaseIndex++] << 15;
         if(this.phaseIndex >= this.segments) {
            this.phaseIndex = this.segments - 1;
         }

         this.ticks = (int)((double)this.durations[this.phaseIndex] / 65536.0D * (double)var1);
         if(this.ticks > this.max) {
            this.step = ((this.phases[this.phaseIndex] << 15) - this.amplitude) / (this.ticks - this.max);
         }
      }

      this.amplitude += this.step;
      ++this.max;
      return this.amplitude - this.step >> 15;
   }
}
