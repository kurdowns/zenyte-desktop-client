import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSParamDefinition;

@ObfuscatedName("is")
public class ParamDefinition extends DualNode implements RSParamDefinition {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   public static AbstractArchive ParamDefinition_archive;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Leg;"
   )
   public static EvictingDualNodeHashTable ParamDefinition_cached = new EvictingDualNodeHashTable(64);
   @ObfuscatedName("k")
   char type;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 493165411
   )
   public int defaultInt;
   @ObfuscatedName("w")
   public String defaultStr;
   @ObfuscatedName("v")
   boolean autoDisable = true;


   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "65"
   )
   void method4572() {}

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lkb;I)V",
      garbageValue = "1593854390"
   )
   void method4582(Buffer var1) {
      while(true) {
         int var2 = var1.method5575();
         if(var2 == 0) {
            return;
         }

         this.method4574(var1, var2);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lkb;II)V",
      garbageValue = "-1589952103"
   )
   void method4574(Buffer var1, int var2) {
      if(var2 == 1) {
         this.type = class236.method4224(var1.method5576());
      } else if(var2 == 2) {
         this.defaultInt = var1.method5580();
      } else if(var2 == 4) {
         this.autoDisable = false;
      } else if(var2 == 5) {
         this.defaultStr = var1.method5695();
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "861109850"
   )
   public boolean method4575() {
      return this.type == 115;
   }
}
