import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSVarcInt;

@ObfuscatedName("it")
public class VarcInt extends DualNode implements RSVarcInt {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   public static AbstractArchive VarcInt_archive;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Leg;"
   )
   public static EvictingDualNodeHashTable VarcInt_cached = new EvictingDualNodeHashTable(64);
   @ObfuscatedName("k")
   public boolean persist = false;


   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lkb;B)V",
      garbageValue = "-75"
   )
   public void method4488(Buffer var1) {
      while(true) {
         int var2 = var1.method5575();
         if(var2 == 0) {
            return;
         }

         this.method4489(var1, var2);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lkb;II)V",
      garbageValue = "-1942328984"
   )
   void method4489(Buffer var1, int var2) {
      if(var2 == 2) {
         this.persist = true;
      }

   }
}
