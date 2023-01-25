import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSAudioFilter;

@ObfuscatedName("dc")
public class AudioFilter implements RSAudioFilter {

   @ObfuscatedName("v")
   static float[][] field1500 = new float[2][8];
   @ObfuscatedName("q")
   static int[][] coefficients = new int[2][8];
   @ObfuscatedName("z")
   static float field1505;
   @ObfuscatedName("t")
   static int forwardMultiplier;
   @ObfuscatedName("x")
   int[] pairs = new int[2];
   @ObfuscatedName("k")
   int[][][] field1497 = new int[2][2][4];
   @ObfuscatedName("d")
   int[][][] field1502 = new int[2][2][4];
   @ObfuscatedName("w")
   int[] field1504 = new int[2];


   @ObfuscatedName("x")
   float method2805(int var1, int var2, float var3) {
      float var4 = (float)this.field1502[var1][0][var2] + var3 * (float)(this.field1502[var1][1][var2] - this.field1502[var1][0][var2]);
      var4 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
   }

   @ObfuscatedName("k")
   float method2803(int var1, int var2, float var3) {
      float var4 = (float)this.field1497[var1][0][var2] + var3 * (float)(this.field1497[var1][1][var2] - this.field1497[var1][0][var2]);
      var4 *= 1.2207031E-4F;
      return method2802(var4);
   }

   @ObfuscatedName("d")
   int method2804(int var1, float var2) {
      float var3;
      if(var1 == 0) {
         var3 = (float)this.field1504[0] + (float)(this.field1504[1] - this.field1504[0]) * var2;
         var3 *= 0.0030517578F;
         field1505 = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
         forwardMultiplier = (int)(field1505 * 65536.0F);
      }

      if(this.pairs[var1] == 0) {
         return 0;
      } else {
         var3 = this.method2805(var1, 0, var2);
         field1500[var1][0] = -2.0F * var3 * (float)Math.cos((double)this.method2803(var1, 0, var2));
         field1500[var1][1] = var3 * var3;

         int var4;
         for(var4 = 1; var4 < this.pairs[var1]; ++var4) {
            var3 = this.method2805(var1, var4, var2);
            float var5 = -2.0F * var3 * (float)Math.cos((double)this.method2803(var1, var4, var2));
            float var6 = var3 * var3;
            field1500[var1][var4 * 2 + 1] = field1500[var1][var4 * 2 - 1] * var6;
            field1500[var1][var4 * 2] = field1500[var1][var4 * 2 - 1] * var5 + field1500[var1][var4 * 2 - 2] * var6;

            for(int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
               field1500[var1][var7] += field1500[var1][var7 - 1] * var5 + field1500[var1][var7 - 2] * var6;
            }

            field1500[var1][1] += field1500[var1][0] * var5 + var6;
            field1500[var1][0] += var5;
         }

         if(var1 == 0) {
            for(var4 = 0; var4 < this.pairs[0] * 2; ++var4) {
               field1500[0][var4] *= field1505;
            }
         }

         for(var4 = 0; var4 < this.pairs[var1] * 2; ++var4) {
            coefficients[var1][var4] = (int)(field1500[var1][var4] * 65536.0F);
         }

         return this.pairs[var1] * 2;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lkb;Lde;)V"
   )
   final void method2813(Buffer var1, SoundEnvelope var2) {
      int var3 = var1.method5575();
      this.pairs[0] = var3 >> 4;
      this.pairs[1] = var3 & 15;
      if(var3 != 0) {
         this.field1504[0] = var1.method5577();
         this.field1504[1] = var1.method5577();
         int var4 = var1.method5575();

         int var5;
         int var6;
         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.pairs[var5]; ++var6) {
               this.field1497[var5][0][var6] = var1.method5577();
               this.field1502[var5][0][var6] = var1.method5577();
            }
         }

         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.pairs[var5]; ++var6) {
               if((var4 & 1 << var5 * 4 << var6) != 0) {
                  this.field1497[var5][1][var6] = var1.method5577();
                  this.field1502[var5][1][var6] = var1.method5577();
               } else {
                  this.field1497[var5][1][var6] = this.field1497[var5][0][var6];
                  this.field1502[var5][1][var6] = this.field1502[var5][0][var6];
               }
            }
         }

         if(var4 != 0 || this.field1504[1] != this.field1504[0]) {
            var2.method2597(var1);
         }
      } else {
         int[] var7 = this.field1504;
         this.field1504[1] = 0;
         var7[0] = 0;
      }

   }

   @ObfuscatedName("m")
   static float method2802(float var0) {
      float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
      return var1 * 3.1415927F / 11025.0F;
   }
}
