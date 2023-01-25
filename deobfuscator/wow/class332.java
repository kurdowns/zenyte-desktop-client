import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lu")
public enum class332 implements Enumerated {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Llu;"
   )
   SOLID("runelite", 0, 0, 0),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Llu;"
   )
   field3874("runelite", 1, 1, 1),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Llu;"
   )
   field3875("runelite", 2, 2, 2);
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ldh;"
   )
   static SoundSystem soundSystem;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1537098807
   )
   public final int field3873;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -92633923
   )
   final int id;


   class332(String var1, int var2, int var3, int var4) {
      this.field3873 = var3;
      this.id = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "56"
   )
   public int vmethod6189() {
      return this.id;
   }
}
