import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSDecimator;
import net.runelite.rs.api.RSRawSound;

@ObfuscatedName("dm")
public class RawSound extends AbstractSound implements RSRawSound {

   @ObfuscatedName("x")
   public int sampleRate;
   @ObfuscatedName("m")
   public byte[] samples;
   @ObfuscatedName("k")
   public int start;
   @ObfuscatedName("d")
   int end;
   @ObfuscatedName("w")
   public boolean field1407;


   RawSound(int var1, byte[] var2, int var3, int var4) {
      this.sampleRate = var1;
      this.samples = var2;
      this.start = var3;
      this.end = var4;
   }

   RawSound(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.sampleRate = var1;
      this.samples = var2;
      this.start = var3;
      this.end = var4;
      this.field1407 = var5;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ldx;)Ldm;"
   )
   public RawSound method2508(Decimator var1) {
      this.samples = var1.method2642(this.samples);
      this.sampleRate = var1.method2637(this.sampleRate);
      if(this.start == this.end) {
         this.start = this.end = var1.method2648(this.start);
      } else {
         this.start = var1.method2648(this.start);
         this.end = var1.method2648(this.end);
         if(this.start == this.end) {
            --this.start;
         }
      }

      return this;
   }

   public RSRawSound applyResampler(RSDecimator var1) {
      return this.method2508((Decimator)var1);
   }
}
