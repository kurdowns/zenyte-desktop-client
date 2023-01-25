import java.util.concurrent.ScheduledExecutorService;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSPcmPlayer;

@ObfuscatedName("dw")
public class PcmPlayer implements RSPcmPlayer {

   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1186957939
   )
   public static int field1421;
   @ObfuscatedName("v")
   protected static boolean PcmPlayer_stereo;
   @ObfuscatedName("z")
   static ScheduledExecutorService soundSystemExecutor;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 964748607
   )
   static int field1423;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ldg;"
   )
   static PlayerProvider pcmPlayerProvider;
   @ObfuscatedName("u")
   protected int[] samples;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lds;"
   )
   PcmStream stream;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1104250369
   )
   int field1433 = 32;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = -5529745032621792639L
   )
   long timeMs = class217.method4036();
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1410666215
   )
   int capacity;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1563986159
   )
   int field1431;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1383720405
   )
   int field1432;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = 8518304347901097889L
   )
   long field1441 = 0L;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -2057730941
   )
   int field1436 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1413544229
   )
   int field1435 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1350082309
   )
   int field1428 = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = -7306304429594816925L
   )
   long field1424 = 0L;
   @ObfuscatedName("f")
   boolean field1438 = true;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -91931307
   )
   int field1439 = 0;
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "[Lds;"
   )
   PcmStream[] field1440 = new PcmStream[8];
   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "[Lds;"
   )
   PcmStream[] field1434 = new PcmStream[8];


   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-515177845"
   )
   protected void vmethod2543() throws Exception {}

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1831392073"
   )
   protected void vmethod2544(int var1) throws Exception {}

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1722515255"
   )
   protected int vmethod2545() throws Exception {
      return this.capacity;
   }

   @ObfuscatedName("d")
   protected void vmethod2557() throws Exception {}

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-100"
   )
   protected void vmethod2572() {}

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-801705902"
   )
   protected void vmethod2548() throws Exception {}

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(Lds;I)V",
      garbageValue = "1722615809"
   )
   public final synchronized void method2535(PcmStream var1) {
      this.stream = var1;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "53"
   )
   public final synchronized void method2536() {
      if(this.samples != null) {
         long var1 = class217.method4036();

         try {
            if(0L != this.field1441) {
               if(var1 < this.field1441) {
                  return;
               }

               this.vmethod2544(this.capacity);
               this.field1441 = 0L;
               this.field1438 = true;
            }

            int var3 = this.vmethod2545();
            if(this.field1428 - var3 > this.field1436) {
               this.field1436 = this.field1428 - var3;
            }

            int var4 = this.field1431 + this.field1432;
            if(var4 + 256 > 16384) {
               var4 = 16128;
            }

            if(var4 + 256 > this.capacity) {
               this.capacity += 1024;
               if(this.capacity > 16384) {
                  this.capacity = 16384;
               }

               this.vmethod2572();
               this.vmethod2544(this.capacity);
               var3 = 0;
               this.field1438 = true;
               if(var4 + 256 > this.capacity) {
                  var4 = this.capacity - 256;
                  this.field1432 = var4 - this.field1431;
               }
            }

            while(var3 < var4) {
               this.method2541(this.samples, 256);
               this.vmethod2557();
               var3 += 256;
            }

            if(var1 > this.field1424) {
               if(!this.field1438) {
                  if(this.field1436 == 0 && this.field1435 == 0) {
                     this.vmethod2572();
                     this.field1441 = var1 + 2000L;
                     return;
                  }

                  this.field1432 = Math.min(this.field1435, this.field1436);
                  this.field1435 = this.field1436;
               } else {
                  this.field1438 = false;
               }

               this.field1436 = 0;
               this.field1424 = 2000L + var1;
            }

            this.field1428 = var3;
         } catch (Exception var7) {
            this.vmethod2572();
            this.field1441 = 2000L + var1;
         }

         try {
            if(var1 > 500000L + this.timeMs) {
               var1 = this.timeMs;
            }

            while(var1 > 5000L + this.timeMs) {
               this.method2540(256);
               this.timeMs += (long)(256000 / field1421);
            }
         } catch (Exception var6) {
            this.timeMs = var1;
         }

      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1215131222"
   )
   public final void method2537() {
      this.field1438 = true;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "255"
   )
   public final synchronized void method2575() {
      this.field1438 = true;

      try {
         this.vmethod2548();
      } catch (Exception var2) {
         this.vmethod2572();
         this.field1441 = class217.method4036() + 2000L;
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1390717833"
   )
   public final synchronized void method2539() {
      if(class332.soundSystem != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == class332.soundSystem.players[var2]) {
               class332.soundSystem.players[var2] = null;
            }

            if(class332.soundSystem.players[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            soundSystemExecutor.shutdownNow();
            soundSystemExecutor = null;
            class332.soundSystem = null;
         }
      }

      this.vmethod2572();
      this.samples = null;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1537467116"
   )
   final void method2540(int var1) {
      this.field1439 -= var1;
      if(this.field1439 < 0) {
         this.field1439 = 0;
      }

      if(this.stream != null) {
         this.stream.vmethod3989(var1);
      }

   }

   @ObfuscatedName("au")
   final void method2541(int[] var1, int var2) {
      int var3 = var2;
      if(PcmPlayer_stereo) {
         var3 = var2 << 1;
      }

      class310.method5803(var1, 0, var3);
      this.field1439 -= var2;
      if(this.stream != null && this.field1439 <= 0) {
         this.field1439 += field1421 >> 4;
         FileSystem.method3590(this.stream);
         this.method2571(this.stream, this.stream.vmethod2820());
         int var4 = 0;
         int var5 = 255;

         int var6;
         PcmStream var10;
         label99:
         for(var6 = 7; var5 != 0; --var6) {
            int var7;
            int var8;
            if(var6 < 0) {
               var7 = var6 & 3;
               var8 = -(var6 >> 2);
            } else {
               var7 = var6;
               var8 = 0;
            }

            for(int var9 = var5 >>> var7 & 286331153; var9 != 0; var9 >>>= 4) {
               if((var9 & 1) != 0) {
                  var5 &= ~(1 << var7);
                  var10 = null;
                  PcmStream var11 = this.field1440[var7];

                  while(var11 != null) {
                     AbstractSound var12 = var11.sound;
                     if(var12 != null && var12.position > var8) {
                        var5 |= 1 << var7;
                        var10 = var11;
                        var11 = var11.after;
                     } else {
                        var11.active = true;
                        int var13 = var11.vmethod3985();
                        var4 += var13;
                        if(var12 != null) {
                           var12.position += var13;
                        }

                        if(var4 >= this.field1433) {
                           break label99;
                        }

                        PcmStream var14 = var11.vmethod3984();
                        if(var14 != null) {
                           for(int var15 = var11.field1507; var14 != null; var14 = var11.vmethod3986()) {
                              this.method2571(var14, var15 * var14.vmethod2820() >> 8);
                           }
                        }

                        PcmStream var18 = var11.after;
                        var11.after = null;
                        if(var10 == null) {
                           this.field1440[var7] = var18;
                        } else {
                           var10.after = var18;
                        }

                        if(var18 == null) {
                           this.field1434[var7] = var10;
                        }

                        var11 = var18;
                     }
                  }
               }

               var7 += 4;
               ++var8;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            PcmStream var16 = this.field1440[var6];
            PcmStream[] var17 = this.field1440;
            this.field1434[var6] = null;

            for(var17[var6] = null; var16 != null; var16 = var10) {
               var10 = var16.after;
               var16.after = null;
            }
         }
      }

      if(this.field1439 < 0) {
         this.field1439 = 0;
      }

      if(this.stream != null) {
         this.stream.vmethod3988(var1, 0, var2);
      }

      this.timeMs = class217.method4036();
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(Lds;II)V",
      garbageValue = "2093201048"
   )
   final void method2571(PcmStream var1, int var2) {
      int var3 = var2 >> 5;
      PcmStream var4 = this.field1434[var3];
      if(var4 == null) {
         this.field1440[var3] = var1;
      } else {
         var4.after = var1;
      }

      this.field1434[var3] = var1;
      var1.field1507 = var2;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "210668082"
   )
   public static boolean method2594(char var0) {
      return var0 >= 48 && var0 <= 57;
   }
}
