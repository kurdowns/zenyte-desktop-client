import java.util.Random;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSInstrument;

@ObfuscatedName("dp")
public class Instrument implements RSInstrument {

   @ObfuscatedName("a")
   static int[] Instrument_samples;
   @ObfuscatedName("b")
   static int[] Instrument_noise = new int['\u8000'];
   @ObfuscatedName("l")
   static int[] Instrument_sine;
   @ObfuscatedName("o")
   static int[] Instrument_phases;
   @ObfuscatedName("c")
   static int[] Instrument_delays;
   @ObfuscatedName("j")
   static int[] Instrument_volumeSteps;
   @ObfuscatedName("y")
   static int[] Instrument_pitchSteps;
   @ObfuscatedName("f")
   static int[] Instrument_pitchBaseSteps;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   SoundEnvelope pitch;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   SoundEnvelope volume;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   SoundEnvelope pitchModifier;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   SoundEnvelope pitchModifierAmplitude;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   SoundEnvelope volumeMultiplier;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   SoundEnvelope volumeMultiplierAmplitude;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   SoundEnvelope release;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   SoundEnvelope attack;
   @ObfuscatedName("t")
   int[] oscillatorVolume = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("e")
   int[] oscillatorPitch = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("s")
   int[] oscillatorDelays = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("p")
   int delayTime = 0;
   @ObfuscatedName("n")
   int delayDecay = 100;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Ldc;"
   )
   AudioFilter filter;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   SoundEnvelope filterEnvelope;
   @ObfuscatedName("g")
   int duration = 500;
   @ObfuscatedName("i")
   int offset = 0;


   static {
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '\u8000'; ++var1) {
         Instrument_noise[var1] = (var0.nextInt() & 2) - 1;
      }

      Instrument_sine = new int['\u8000'];

      for(var1 = 0; var1 < '\u8000'; ++var1) {
         Instrument_sine[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      Instrument_samples = new int[220500];
      Instrument_phases = new int[5];
      Instrument_delays = new int[5];
      Instrument_volumeSteps = new int[5];
      Instrument_pitchSteps = new int[5];
      Instrument_pitchBaseSteps = new int[5];
   }

   @ObfuscatedName("x")
   final int[] method2844(int var1, int var2) {
      class310.method5803(Instrument_samples, 0, var1);
      if(var2 < 10) {
         return Instrument_samples;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.pitch.method2598();
         this.volume.method2598();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.pitchModifier != null) {
            this.pitchModifier.method2598();
            this.pitchModifierAmplitude.method2598();
            var5 = (int)((double)(this.pitchModifier.end - this.pitchModifier.start) * 32.768D / var3);
            var6 = (int)((double)this.pitchModifier.start * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.volumeMultiplier != null) {
            this.volumeMultiplier.method2598();
            this.volumeMultiplierAmplitude.method2598();
            var8 = (int)((double)(this.volumeMultiplier.end - this.volumeMultiplier.start) * 32.768D / var3);
            var9 = (int)((double)this.volumeMultiplier.start * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.oscillatorVolume[var11] != 0) {
               Instrument_phases[var11] = 0;
               Instrument_delays[var11] = (int)((double)this.oscillatorDelays[var11] * var3);
               Instrument_volumeSteps[var11] = (this.oscillatorVolume[var11] << 14) / 100;
               Instrument_pitchSteps[var11] = (int)((double)(this.pitch.end - this.pitch.start) * 32.768D * Math.pow(1.0057929410678534D, (double)this.oscillatorPitch[var11]) / var3);
               Instrument_pitchBaseSteps[var11] = (int)((double)this.pitch.start * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.pitch.method2599(var1);
            var13 = this.volume.method2599(var1);
            if(this.pitchModifier != null) {
               var14 = this.pitchModifier.method2599(var1);
               var15 = this.pitchModifierAmplitude.method2599(var1);
               var12 += this.method2848(var7, var15, this.pitchModifier.form) >> 1;
               var7 = var7 + var6 + (var14 * var5 >> 16);
            }

            if(this.volumeMultiplier != null) {
               var14 = this.volumeMultiplier.method2599(var1);
               var15 = this.volumeMultiplierAmplitude.method2599(var1);
               var13 = var13 * ((this.method2848(var10, var15, this.volumeMultiplier.form) >> 1) + '\u8000') >> 15;
               var10 = var10 + var9 + (var14 * var8 >> 16);
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.oscillatorVolume[var14] != 0) {
                  var15 = Instrument_delays[var14] + var11;
                  if(var15 < var1) {
                     Instrument_samples[var15] += this.method2848(Instrument_phases[var14], var13 * Instrument_volumeSteps[var14] >> 15, this.pitch.form);
                     Instrument_phases[var14] += (var12 * Instrument_pitchSteps[var14] >> 16) + Instrument_pitchBaseSteps[var14];
                  }
               }
            }
         }

         int var16;
         if(this.release != null) {
            this.release.method2598();
            this.attack.method2598();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.release.method2599(var1);
               var16 = this.attack.method2599(var1);
               if(var20) {
                  var12 = (var15 * (this.release.end - this.release.start) >> 8) + this.release.start;
               } else {
                  var12 = (var16 * (this.release.end - this.release.start) >> 8) + this.release.start;
               }

               var11 += 256;
               if(var11 >= var12) {
                  var11 = 0;
                  var20 = !var20;
               }

               if(var20) {
                  Instrument_samples[var14] = 0;
               }
            }
         }

         if(this.delayTime > 0 && this.delayDecay > 0) {
            var11 = (int)((double)this.delayTime * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               Instrument_samples[var12] += Instrument_samples[var12 - var11] * this.delayDecay / 100;
            }
         }

         if(this.filter.pairs[0] > 0 || this.filter.pairs[1] > 0) {
            this.filterEnvelope.method2598();
            var11 = this.filterEnvelope.method2599(var1 + 1);
            var12 = this.filter.method2804(0, (float)var11 / 65536.0F);
            var13 = this.filter.method2804(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)Instrument_samples[var14 + var12] * (long)AudioFilter.forwardMultiplier >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)Instrument_samples[var14 + var12 - 1 - var17] * (long)AudioFilter.coefficients[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)Instrument_samples[var14 - 1 - var17] * (long)AudioFilter.coefficients[1][var17] >> 16);
                  }

                  Instrument_samples[var14] = var16;
                  var11 = this.filterEnvelope.method2599(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)Instrument_samples[var14 + var12] * (long)AudioFilter.forwardMultiplier >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)Instrument_samples[var14 + var12 - 1 - var18] * (long)AudioFilter.coefficients[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)Instrument_samples[var14 - 1 - var18] * (long)AudioFilter.coefficients[1][var18] >> 16);
                     }

                     Instrument_samples[var14] = var17;
                     var11 = this.filterEnvelope.method2599(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)Instrument_samples[var14 + var12 - 1 - var18] * (long)AudioFilter.coefficients[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)Instrument_samples[var14 - 1 - var18] * (long)AudioFilter.coefficients[1][var18] >> 16);
                        }

                        Instrument_samples[var14] = var17;
                        this.filterEnvelope.method2599(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.filter.method2804(0, (float)var11 / 65536.0F);
                  var13 = this.filter.method2804(1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if(Instrument_samples[var11] < -32768) {
               Instrument_samples[var11] = -32768;
            }

            if(Instrument_samples[var11] > 32767) {
               Instrument_samples[var11] = 32767;
            }
         }

         return Instrument_samples;
      }
   }

   @ObfuscatedName("m")
   final int method2848(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?Instrument_sine[var1 & 32767] * var2 >> 14:(var3 == 3?(var2 * (var1 & 32767) >> 14) - var2:(var3 == 4?var2 * Instrument_noise[var1 / 2607 & 32767]:0)));
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lkb;)V"
   )
   final void method2845(Buffer var1) {
      this.pitch = new SoundEnvelope();
      this.pitch.method2595(var1);
      this.volume = new SoundEnvelope();
      this.volume.method2595(var1);
      int var2 = var1.method5575();
      if(var2 != 0) {
         --var1.offset;
         this.pitchModifier = new SoundEnvelope();
         this.pitchModifier.method2595(var1);
         this.pitchModifierAmplitude = new SoundEnvelope();
         this.pitchModifierAmplitude.method2595(var1);
      }

      var2 = var1.method5575();
      if(var2 != 0) {
         --var1.offset;
         this.volumeMultiplier = new SoundEnvelope();
         this.volumeMultiplier.method2595(var1);
         this.volumeMultiplierAmplitude = new SoundEnvelope();
         this.volumeMultiplierAmplitude.method2595(var1);
      }

      var2 = var1.method5575();
      if(var2 != 0) {
         --var1.offset;
         this.release = new SoundEnvelope();
         this.release.method2595(var1);
         this.attack = new SoundEnvelope();
         this.attack.method2595(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method5589();
         if(var4 == 0) {
            break;
         }

         this.oscillatorVolume[var3] = var4;
         this.oscillatorPitch[var3] = var1.method5656();
         this.oscillatorDelays[var3] = var1.method5589();
      }

      this.delayTime = var1.method5589();
      this.delayDecay = var1.method5589();
      this.duration = var1.method5577();
      this.offset = var1.method5577();
      this.filter = new AudioFilter();
      this.filterEnvelope = new SoundEnvelope();
      this.filter.method2813(var1, this.filterEnvelope);
   }
}
