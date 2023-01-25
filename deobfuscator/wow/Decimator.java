import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSDecimator;

@ObfuscatedName("dx")
public class Decimator implements RSDecimator {

   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -591203607
   )
   int inputRate;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -772700621
   )
   int outputRate;
   @ObfuscatedName("v")
   int[][] table;


   public Decimator(int var1, int var2) {
      if(var2 != var1) {
         int var3 = ModeWhere.method3764(var1, var2);
         var1 /= var3;
         var2 /= var3;
         this.inputRate = var1;
         this.outputRate = var2;
         this.table = new int[var1][14];

         for(int var4 = 0; var4 < var1; ++var4) {
            int[] var5 = this.table[var4];
            double var6 = 6.0D + (double)var4 / (double)var1;
            int var8 = (int)Math.floor(1.0D + (var6 - 7.0D));
            if(var8 < 0) {
               var8 = 0;
            }

            int var9 = (int)Math.ceil(var6 + 7.0D);
            if(var9 > 14) {
               var9 = 14;
            }

            for(double var10 = (double)var2 / (double)var1; var8 < var9; ++var8) {
               double var12 = 3.141592653589793D * ((double)var8 - var6);
               double var14 = var10;
               if(var12 < -1.0E-4D || var12 > 1.0E-4D) {
                  var14 = var10 * (Math.sin(var12) / var12);
               }

               var14 *= 0.54D + 0.46D * Math.cos(((double)var8 - var6) * 0.2243994752564138D);
               var5[var8] = (int)Math.floor(65536.0D * var14 + 0.5D);
            }
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "2035174504"
   )
   byte[] method2642(byte[] var1) {
      if(this.table != null) {
         int var2 = (int)((long)this.outputRate * (long)var1.length / (long)this.inputRate) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.table[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var4 + var9] += var8[var9] * var7;
            }

            var5 += this.outputRate;
            var9 = var5 / this.inputRate;
            var4 += var9;
            var5 -= var9 * this.inputRate;
         }

         var1 = new byte[var2];

         for(var6 = 0; var6 < var2; ++var6) {
            int var10 = var3[var6] + '\u8000' >> 16;
            if(var10 < -128) {
               var1[var6] = -128;
            } else if(var10 > 127) {
               var1[var6] = 127;
            } else {
               var1[var6] = (byte)var10;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "65"
   )
   int method2637(int var1) {
      if(this.table != null) {
         var1 = (int)((long)this.outputRate * (long)var1 / (long)this.inputRate);
      }

      return var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-548608122"
   )
   int method2648(int var1) {
      if(this.table != null) {
         var1 = (int)((long)var1 * (long)this.outputRate / (long)this.inputRate) + 6;
      }

      return var1;
   }

   @ObfuscatedName("m")
   public static boolean method2635(long var0) {
      return var0 != 0L && !WorldMapDecorationType.method4213(var0);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILce;ZI)I",
      garbageValue = "49819578"
   )
   static int method2649(int var0, Script var1, boolean var2) {
      boolean var3 = true;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = MusicPatchNode.method3920(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
         var3 = false;
      } else {
         var4 = var2?GrandExchangeOfferNameComparator.field115:Interpreter.field1130;
      }

      int var11;
      if(var0 == 1300) {
         var11 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] - 1;
         if(var11 >= 0 && var11 <= 9) {
            var4.method4170(var11, Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize]);
            return 1;
         } else {
            --Interpreter.Interpreter_stringStackSize;
            return 1;
         }
      } else {
         int var6;
         if(var0 == 1301) {
            Interpreter.Interpreter_intStackSize -= 2;
            var11 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            var4.parent = GrandExchangeOfferUnitPriceComparator.method224(var11, var6);
            return 1;
         } else if(var0 == 1302) {
            var4.isScrollBar = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
            return 1;
         } else if(var0 == 1303) {
            var4.dragZoneSize = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            return 1;
         } else if(var0 == 1304) {
            var4.dragThreshold = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            return 1;
         } else if(var0 == 1305) {
            var4.dataText = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
            return 1;
         } else if(var0 == 1306) {
            var4.spellActionName = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
            return 1;
         } else if(var0 == 1307) {
            var4.actions = null;
            return 1;
         } else if(var0 == 1308) {
            var4.field2658 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
            return 1;
         } else if(var0 == 1309) {
            --Interpreter.Interpreter_intStackSize;
            return 1;
         } else {
            int var7;
            byte[] var9;
            if(var0 != 1350) {
               byte var5;
               if(var0 == 1351) {
                  Interpreter.Interpreter_intStackSize -= 2;
                  var5 = 10;
                  var9 = new byte[]{(byte)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize]};
                  byte[] var10 = new byte[]{(byte)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]};
                  FontName.method5384(var4, var5, var9, var10);
                  return 1;
               } else if(var0 == 1352) {
                  Interpreter.Interpreter_intStackSize -= 3;
                  var11 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] - 1;
                  var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
                  var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
                  if(var11 >= 0 && var11 <= 9) {
                     MouseHandler.method1163(var4, var11, var6, var7);
                     return 1;
                  } else {
                     throw new RuntimeException();
                  }
               } else if(var0 == 1353) {
                  var5 = 10;
                  var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  MouseHandler.method1163(var4, var5, var6, var7);
                  return 1;
               } else if(var0 == 1354) {
                  --Interpreter.Interpreter_intStackSize;
                  var11 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] - 1;
                  if(var11 >= 0 && var11 <= 9) {
                     class195.method3698(var4, var11);
                     return 1;
                  } else {
                     throw new RuntimeException();
                  }
               } else if(var0 == 1355) {
                  var5 = 10;
                  class195.method3698(var4, var5);
                  return 1;
               } else {
                  return 2;
               }
            } else {
               byte[] var8 = null;
               var9 = null;
               if(var3) {
                  Interpreter.Interpreter_intStackSize -= 10;

                  for(var7 = 0; var7 < 10 && Interpreter.Interpreter_intStack[var7 + Interpreter.Interpreter_intStackSize] >= 0; var7 += 2) {
                     ;
                  }

                  if(var7 > 0) {
                     var8 = new byte[var7 / 2];
                     var9 = new byte[var7 / 2];

                     for(var7 -= 2; var7 >= 0; var7 -= 2) {
                        var8[var7 / 2] = (byte)Interpreter.Interpreter_intStack[var7 + Interpreter.Interpreter_intStackSize];
                        var9[var7 / 2] = (byte)Interpreter.Interpreter_intStack[var7 + Interpreter.Interpreter_intStackSize + 1];
                     }
                  }
               } else {
                  Interpreter.Interpreter_intStackSize -= 2;
                  var8 = new byte[]{(byte)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize]};
                  var9 = new byte[]{(byte)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]};
               }

               var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] - 1;
               if(var7 >= 0 && var7 <= 9) {
                  FontName.method5384(var4, var7, var8, var9);
                  return 1;
               } else {
                  throw new RuntimeException();
               }
            }
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "458877468"
   )
   public static String method2636(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            var5 = StructDefinition.method4590(var5);
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != 46 && var5 != 63 && var5 != 33) {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }
}
