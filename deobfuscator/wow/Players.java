import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSPlayers;

@ObfuscatedName("cj")
public class Players implements RSPlayers {

   @ObfuscatedName("rh")
   @ObfuscatedGetter(
      intValue = 1328419047
   )
   static int field1280;
   @ObfuscatedName("k")
   static byte[] field1267 = new byte[2048];
   @ObfuscatedName("d")
   static byte[] field1273 = new byte[2048];
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lkb;"
   )
   static Buffer[] field1269 = new Buffer[2048];
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 2104068463
   )
   static int Players_count = 0;
   @ObfuscatedName("q")
   static int[] Players_indices = new int[2048];
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1941416783
   )
   static int Players_emptyIdxCount = 0;
   @ObfuscatedName("t")
   static int[] Players_emptyIndices = new int[2048];
   @ObfuscatedName("e")
   static int[] Players_regions = new int[2048];
   @ObfuscatedName("s")
   static int[] Players_orientations = new int[2048];
   @ObfuscatedName("p")
   static int[] Players_targetIndices = new int[2048];
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1119363991
   )
   static int Players_pendingUpdateCount = 0;
   @ObfuscatedName("u")
   static int[] Players_pendingUpdateIndices = new int[2048];
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   static Buffer field1268 = new Buffer(new byte[5000]);


   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Liy;I)V",
      garbageValue = "731875079"
   )
   public static void method2251(AbstractArchive var0) {
      VarcInt.VarcInt_archive = var0;
   }
}
