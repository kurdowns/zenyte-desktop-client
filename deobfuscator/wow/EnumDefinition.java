import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSEnumDefinition;

@ObfuscatedName("ji")
public class EnumDefinition extends DualNode implements RSEnumDefinition {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   static AbstractArchive EnumDefinition_archive;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Leg;"
   )
   static EvictingDualNodeHashTable EnumDefinition_cached = new EvictingDualNodeHashTable(64);
   @ObfuscatedName("k")
   public char inputType;
   @ObfuscatedName("d")
   public char outputType;
   @ObfuscatedName("w")
   public String defaultStr = "null";
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1168542031
   )
   public int defaultInt;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 744835807
   )
   public int outputCount = 0;
   @ObfuscatedName("z")
   public int[] keys;
   @ObfuscatedName("t")
   public int[] intVals;
   @ObfuscatedName("e")
   public String[] strVals;


   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lkb;I)V",
      garbageValue = "1803562371"
   )
   void method4612(Buffer var1) {
      while(true) {
         int var2 = var1.method5575();
         if(var2 == 0) {
            return;
         }

         this.method4624(var1, var2);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lkb;II)V",
      garbageValue = "-1795608149"
   )
   void method4624(Buffer var1, int var2) {
      if(var2 == 1) {
         this.inputType = (char)var1.method5575();
      } else if(var2 == 2) {
         this.outputType = (char)var1.method5575();
      } else if(var2 == 3) {
         this.defaultStr = var1.method5695();
      } else if(var2 == 4) {
         this.defaultInt = var1.method5580();
      } else {
         int var3;
         if(var2 == 5) {
            this.outputCount = var1.method5577();
            this.keys = new int[this.outputCount];
            this.strVals = new String[this.outputCount];

            for(var3 = 0; var3 < this.outputCount; ++var3) {
               this.keys[var3] = var1.method5580();
               this.strVals[var3] = var1.method5695();
            }
         } else if(var2 == 6) {
            this.outputCount = var1.method5577();
            this.keys = new int[this.outputCount];
            this.intVals = new int[this.outputCount];

            for(var3 = 0; var3 < this.outputCount; ++var3) {
               this.keys[var3] = var1.method5580();
               this.intVals[var3] = var1.method5580();
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1493924915"
   )
   public int method4614() {
      return this.outputCount;
   }

   public int[] getKeys() {
      return this.keys;
   }

   public String getDefaultString() {
      return this.defaultStr;
   }

   public int getDefaultInt() {
      return this.defaultInt;
   }

   public int[] getIntVals() {
      return this.intVals;
   }

   public String[] getStringVals() {
      return this.strVals;
   }

   public int getIntValue(int var1) {
      int[] var2 = this.getKeys();
      if(var2 == null) {
         return this.getDefaultInt();
      } else {
         for(int var3 = 0; var3 < var2.length; ++var3) {
            if(var2[var3] == var1) {
               int[] var4 = this.getIntVals();
               return var4[var3];
            }
         }

         return this.getDefaultInt();
      }
   }

   public String getStringValue(int var1) {
      int[] var2 = this.getKeys();
      if(var2 == null) {
         return this.getDefaultString();
      } else {
         for(int var3 = 0; var3 < var2.length; ++var3) {
            if(var2[var3] == var1) {
               String[] var4 = this.getStringVals();
               return var4[var3];
            }
         }

         return this.getDefaultString();
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1826844578"
   )
   public static void method4615(int var0) {
      if(var0 != -1) {
         if(Widget.Widget_loadedInterfaces[var0]) {
            Widget.Widget_archive.method4262(var0);
            if(Widget.Widget_interfaceComponents[var0] != null) {
               boolean var1 = true;

               for(int var2 = 0; var2 < Widget.Widget_interfaceComponents[var0].length; ++var2) {
                  if(Widget.Widget_interfaceComponents[var0][var2] != null) {
                     if(Widget.Widget_interfaceComponents[var0][var2].type != 2) {
                        Widget.Widget_interfaceComponents[var0][var2] = null;
                     } else {
                        var1 = false;
                     }
                  }
               }

               if(var1) {
                  Widget.Widget_interfaceComponents[var0] = null;
               }

               Widget.Widget_loadedInterfaces[var0] = false;
            }
         }
      }
   }
}
