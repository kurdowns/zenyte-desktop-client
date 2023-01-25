import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSSpotAnimationDefinition;

@ObfuscatedName("iw")
public class SpotAnimationDefinition extends DualNode implements RSSpotAnimationDefinition {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   public static AbstractArchive SpotAnimationDefinition_archive;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   public static AbstractArchive SpotAnimationDefinition_modelArchive;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Leg;"
   )
   public static EvictingDualNodeHashTable SpotAnimationDefinition_cached = new EvictingDualNodeHashTable(64);
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Leg;"
   )
   public static EvictingDualNodeHashTable SpotAnimationDefinition_cachedModels = new EvictingDualNodeHashTable(30);
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1568663321
   )
   int id;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -2124513073
   )
   int archive;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 872877257
   )
   public int sequence = -1;
   @ObfuscatedName("z")
   short[] recolorFrom;
   @ObfuscatedName("t")
   short[] recolorTo;
   @ObfuscatedName("e")
   short[] retextureFrom;
   @ObfuscatedName("s")
   short[] retextureTo;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1719223697
   )
   int widthScale = 128;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1056397705
   )
   int heightScale = 128;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 378362489
   )
   int orientation = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -811477227
   )
   int ambient = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 551721489
   )
   int contrast = 0;


   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lkb;B)V",
      garbageValue = "-55"
   )
   void method4495(Buffer var1) {
      while(true) {
         int var2 = var1.method5575();
         if(var2 == 0) {
            return;
         }

         this.method4493(var1, var2);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lkb;IB)V",
      garbageValue = "0"
   )
   void method4493(Buffer var1, int var2) {
      if(var2 == 1) {
         this.archive = var1.method5577();
      } else if(var2 == 2) {
         this.sequence = var1.method5577();
      } else if(var2 == 4) {
         this.widthScale = var1.method5577();
      } else if(var2 == 5) {
         this.heightScale = var1.method5577();
      } else if(var2 == 6) {
         this.orientation = var1.method5577();
      } else if(var2 == 7) {
         this.ambient = var1.method5575();
      } else if(var2 == 8) {
         this.contrast = var1.method5575();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.method5575();
            this.recolorFrom = new short[var3];
            this.recolorTo = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.recolorFrom[var4] = (short)var1.method5577();
               this.recolorTo[var4] = (short)var1.method5577();
            }
         } else if(var2 == 41) {
            var3 = var1.method5575();
            this.retextureFrom = new short[var3];
            this.retextureTo = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.retextureFrom[var4] = (short)var1.method5577();
               this.retextureTo[var4] = (short)var1.method5577();
            }
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Lel;",
      garbageValue = "-1314564797"
   )
   public final Model method4492(int var1) {
      Model var2 = (Model)SpotAnimationDefinition_cachedModels.method3432((long)this.id);
      if(var2 == null) {
         ModelData var3 = ModelData.method2879(SpotAnimationDefinition_modelArchive, this.archive, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.recolorFrom != null) {
            for(var4 = 0; var4 < this.recolorFrom.length; ++var4) {
               var3.method2893(this.recolorFrom[var4], this.recolorTo[var4]);
            }
         }

         if(this.retextureFrom != null) {
            for(var4 = 0; var4 < this.retextureFrom.length; ++var4) {
               var3.method2945(this.retextureFrom[var4], this.retextureTo[var4]);
            }
         }

         var2 = var3.method2900(this.ambient + 64, this.contrast + 850, -30, -50, -30);
         SpotAnimationDefinition_cachedModels.method3438(var2, (long)this.id);
      }

      Model var5;
      if(this.sequence != -1 && var1 != -1) {
         var5 = method4503(this.sequence).method4844(var2, var1, (byte)66);
      } else {
         var5 = var2.method3027(true);
      }

      if(this.widthScale != 128 || this.heightScale != 128) {
         var5.method2981(this.widthScale, this.heightScale, this.widthScale);
      }

      if(this.orientation != 0) {
         if(this.orientation == 90) {
            var5.method2983();
         }

         if(this.orientation == 180) {
            var5.method2983();
            var5.method2983();
         }

         if(this.orientation == 270) {
            var5.method2983();
            var5.method2983();
            var5.method2983();
         }
      }

      return var5;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Ljc;",
      garbageValue = "1792244593"
   )
   public static SequenceDefinition method4503(int var0) {
      SequenceDefinition var1 = (SequenceDefinition)SequenceDefinition.SequenceDefinition_cached.method3432((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Varcs.SequenceDefinition_archive.method4249(12, var0, (byte)-51);
         var1 = new SequenceDefinition();
         if(var2 != null) {
            var1.method4842(new Buffer(var2));
         }

         var1.method4872();
         SequenceDefinition.SequenceDefinition_cached.method3438(var1, (long)var0);
         return var1;
      }
   }
}
