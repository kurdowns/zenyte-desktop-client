import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSMilliClock;

@ObfuscatedName("fz")
public class MilliClock extends Clock implements RSMilliClock {

   @ObfuscatedName("nw")
   @ObfuscatedGetter(
      intValue = -1060623823
   )
   static int widgetDragDuration;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lcr;"
   )
   static LoginScreenAnimation loginScreenRunesAnimation;
   @ObfuscatedName("bf")
   static String otp;
   @ObfuscatedName("em")
   @ObfuscatedGetter(
      intValue = 119222289
   )
   static int field2026;
   @ObfuscatedName("x")
   long[] field2028 = new long[10];
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 370183015
   )
   int field2020 = 256;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -542018665
   )
   int field2021 = 1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = 8140433523785303581L
   )
   long field2019 = class217.method4036();
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1658910693
   )
   int field2023 = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -371780323
   )
   int field2024;


   MilliClock() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2028[var1] = this.field2019;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1351231250"
   )
   public void vmethod3592() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2028[var1] = 0L;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1723558008"
   )
   public int vmethod3593(int var1, int var2) {
      int var3 = this.field2020;
      int var4 = this.field2021;
      this.field2020 = 300;
      this.field2021 = 1;
      this.field2019 = class217.method4036();
      if(this.field2028[this.field2024] == 0L) {
         this.field2020 = var3;
         this.field2021 = var4;
      } else if(this.field2019 > this.field2028[this.field2024]) {
         this.field2020 = (int)((long)(var1 * 2560) / (this.field2019 - this.field2028[this.field2024]));
      }

      if(this.field2020 < 25) {
         this.field2020 = 25;
      }

      if(this.field2020 > 256) {
         this.field2020 = 256;
         this.field2021 = (int)((long)var1 - (this.field2019 - this.field2028[this.field2024]) / 10L);
      }

      if(this.field2021 > var1) {
         this.field2021 = var1;
      }

      this.field2028[this.field2024] = this.field2019;
      this.field2024 = (this.field2024 + 1) % 10;
      int var5;
      if(this.field2021 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(this.field2028[var5] != 0L) {
               this.field2028[var5] += (long)this.field2021;
            }
         }
      }

      if(this.field2021 < var2) {
         this.field2021 = var2;
      }

      class169.method3542((long)this.field2021);

      for(var5 = 0; this.field2023 < 256; this.field2023 += this.field2020) {
         ++var5;
      }

      this.field2023 &= 255;
      return var5;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "178370369"
   )
   public static boolean method3561(int var0) {
      return (var0 >> 29 & 1) != 0;
   }

   @ObfuscatedName("jf")
   @ObfuscatedSignature(
      signature = "([Lhe;II)V",
      garbageValue = "1317800526"
   )
   static final void method3554(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var3.parentId == var1 && (!var3.isIf3 || !AbstractWorldMapData.method356(var3))) {
            int var5;
            if(var3.type == 0) {
               if(!var3.isIf3 && AbstractWorldMapData.method356(var3) && var3 != class9.mousedOverWidgetIf1) {
                  continue;
               }

               method3554(var0, var3.id);
               if(var3.children != null) {
                  method3554(var3.children, var3.id);
               }

               InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.method6046((long)var3.id);
               if(var4 != null) {
                  var5 = var4.group;
                  if(LoginScreenAnimation.method1914(var5)) {
                     method3554(Widget.Widget_interfaceComponents[var5], -1);
                  }
               }
            }

            if(var3.type == 6) {
               if(var3.sequenceId != -1 || var3.sequenceId2 != -1) {
                  boolean var7 = GrandExchangeOfferAgeComparator.method250(var3);
                  if(var7) {
                     var5 = var3.sequenceId2;
                  } else {
                     var5 = var3.sequenceId;
                  }

                  if(var5 != -1) {
                     SequenceDefinition var6 = SpotAnimationDefinition.method4503(var5);

                     for(var3.modelFrameCycle += Client.field741; var3.modelFrameCycle > var6.frameLengths[var3.modelFrame]; ItemContainer.method1273(var3)) {
                        var3.modelFrameCycle -= var6.frameLengths[var3.modelFrame];
                        ++var3.modelFrame;
                        if(var3.modelFrame >= var6.frameIds.length) {
                           var3.modelFrame -= var6.frameCount;
                           if(var3.modelFrame < 0 || var3.modelFrame >= var6.frameIds.length) {
                              var3.modelFrame = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2623 != 0 && !var3.isIf3) {
                  int var8 = var3.field2623 >> 16;
                  var5 = var3.field2623 << 16 >> 16;
                  var8 *= Client.field741;
                  var5 *= Client.field741;
                  var3.modelAngleX = var8 + var3.modelAngleX & 2047;
                  var3.modelAngleY = var5 + var3.modelAngleY & 2047;
                  ItemContainer.method1273(var3);
               }
            }
         }
      }

   }
}
