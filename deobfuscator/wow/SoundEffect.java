import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSRawSound;
import net.runelite.rs.api.RSSoundEffect;

@ObfuscatedName("dj")
public class SoundEffect implements RSSoundEffect {

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "[Ldp;"
   )
   Instrument[] instruments = new Instrument[10];
   @ObfuscatedName("k")
   int start;
   @ObfuscatedName("d")
   int end;


   @ObfuscatedSignature(
      signature = "(Lkb;)V"
   )
   SoundEffect(Buffer var1) {
      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = var1.method5575();
         if(var3 != 0) {
            --var1.offset;
            this.instruments[var2] = new Instrument();
            this.instruments[var2].method2845(var1);
         }
      }

      this.start = var1.method5577();
      this.end = var1.method5577();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "()Ldm;"
   )
   public RawSound method2466() {
      byte[] var1 = this.method2460();
      return new RawSound(22050, var1, this.start * 22050 / 1000, this.end * 22050 / 1000);
   }

   @ObfuscatedName("k")
   public final int method2471() {
      int var1 = 9999999;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.instruments[var2] != null && this.instruments[var2].offset / 20 < var1) {
            var1 = this.instruments[var2].offset / 20;
         }
      }

      if(this.start < this.end && this.start / 20 < var1) {
         var1 = this.start / 20;
      }

      if(var1 != 9999999 && var1 != 0) {
         for(var2 = 0; var2 < 10; ++var2) {
            if(this.instruments[var2] != null) {
               this.instruments[var2].offset -= var1 * 20;
            }
         }

         if(this.start < this.end) {
            this.start -= var1 * 20;
            this.end -= var1 * 20;
         }

         return var1;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("d")
   final byte[] method2460() {
      int var1 = 0;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.instruments[var2] != null && this.instruments[var2].duration + this.instruments[var2].offset > var1) {
            var1 = this.instruments[var2].duration + this.instruments[var2].offset;
         }
      }

      if(var1 == 0) {
         return new byte[0];
      } else {
         var2 = var1 * 22050 / 1000;
         byte[] var3 = new byte[var2];

         for(int var4 = 0; var4 < 10; ++var4) {
            if(this.instruments[var4] != null) {
               int var5 = this.instruments[var4].duration * 22050 / 1000;
               int var6 = this.instruments[var4].offset * 22050 / 1000;
               int[] var7 = this.instruments[var4].method2844(var5, this.instruments[var4].duration);

               for(int var8 = 0; var8 < var5; ++var8) {
                  int var9 = (var7[var8] >> 8) + var3[var8 + var6];
                  if((var9 + 128 & -256) != 0) {
                     var9 = var9 >> 31 ^ 127;
                  }

                  var3[var8 + var6] = (byte)var9;
               }
            }
         }

         return var3;
      }
   }

   public RSRawSound toRawAudioNode() {
      return this.method2466();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Liy;II)Ldj;"
   )
   public static SoundEffect method2469(AbstractArchive var0, int var1, int var2) {
      byte[] var3 = var0.method4249(var1, var2, (byte)-10);
      return var3 == null?null:new SoundEffect(new Buffer(var3));
   }
}
