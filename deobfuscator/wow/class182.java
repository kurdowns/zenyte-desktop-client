import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
public class class182 {

   @ObfuscatedName("k")
   public static int[][] directions = new int[128][128];
   @ObfuscatedName("d")
   public static int[][] distances = new int[128][128];
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1538364035
   )
   public static int field2097;
   @ObfuscatedName("z")
   public static int[] bufferX = new int[4096];
   @ObfuscatedName("t")
   public static int[] bufferY = new int[4096];


   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "130729022"
   )
   public static synchronized byte[] method3664(int var0) {
      return ByteArrayPool.method5833(var0, false);
   }
}
