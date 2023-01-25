import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSVarpDefinition;

@ObfuscatedName("ik")
public class VarpDefinition extends DualNode implements RSVarpDefinition {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   public static AbstractArchive VarpDefinition_archive;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 701979543
   )
   public static int VarpDefinition_fileCount;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Leg;"
   )
   public static EvictingDualNodeHashTable VarpDefinition_cached = new EvictingDualNodeHashTable(64);
   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "[Lla;"
   )
   static Sprite[] mapDotSprites;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2041406857
   )
   public int type = 0;


   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lkb;I)V",
      garbageValue = "888817873"
   )
   void method4452(Buffer var1) {
      while(true) {
         int var2 = var1.method5575();
         if(var2 == 0) {
            return;
         }

         this.method4453(var1, var2);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lkb;II)V",
      garbageValue = "-478549548"
   )
   void method4453(Buffer var1, int var2) {
      if(var2 == 5) {
         this.type = var1.method5577();
      }

   }

   public int getType() {
      return this.type;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "42"
   )
   public static int method4454(int var0, int var1) {
      int var2;
      for(var2 = 0; var1 > 0; --var1) {
         var2 = var2 << 1 | var0 & 1;
         var0 >>>= 1;
      }

      return var2;
   }
}
