import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSNetCache;

@ObfuscatedName("ia")
public class NetCache implements RSNetCache {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Llt;"
   )
   public static AbstractSocket NetCache_socket;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1826620623
   )
   public static int NetCache_loadTime = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = 2064372708518790169L
   )
   public static long field3165;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   public static NodeHashTable NetCache_pendingPriorityWrites = new NodeHashTable(4096);
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1340946103
   )
   public static int NetCache_pendingPriorityWritesCount = 0;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   public static NodeHashTable NetCache_pendingPriorityResponses = new NodeHashTable(32);
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1858030685
   )
   public static int NetCache_pendingPriorityResponsesCount = 0;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Ljl;"
   )
   public static DualNodeDeque NetCache_pendingWritesQueue = new DualNodeDeque();
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   static NodeHashTable NetCache_pendingWrites = new NodeHashTable(4096);
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2108405401
   )
   public static int NetCache_pendingWritesCount = 0;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   public static NodeHashTable NetCache_pendingResponses = new NodeHashTable(4096);
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1540381013
   )
   public static int NetCache_pendingResponsesCount = 0;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   public static NetFileRequest NetCache_currentResponse;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   public static Buffer NetCache_responseHeaderBuffer = new Buffer(8);
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   public static Buffer NetCache_responseArchiveBuffer;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -488987433
   )
   public static int field3178 = 0;
   @ObfuscatedName("b")
   public static CRC32 NetCache_crc = new CRC32();
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "[Lih;"
   )
   public static Archive[] NetCache_archives = new Archive[256];
   @ObfuscatedName("o")
   public static byte field3163 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 2067454381
   )
   public static int NetCache_crcMismatches = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1675917745
   )
   public static int NetCache_ioExceptions = 0;


   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)J",
      garbageValue = "706335608"
   )
   static long method4401(CharSequence var0) {
      long var1 = 0L;
      int var3 = var0.length();

      for(int var4 = 0; var4 < var3; ++var4) {
         var1 *= 37L;
         char var5 = var0.charAt(var4);
         if(var5 >= 65 && var5 <= 90) {
            var1 += (long)(var5 + 1 - 65);
         } else if(var5 >= 97 && var5 <= 122) {
            var1 += (long)(var5 + 1 - 97);
         } else if(var5 >= 48 && var5 <= 57) {
            var1 += (long)(var5 + 27 - 48);
         }

         if(var1 >= 177917621779460413L) {
            break;
         }
      }

      while(0L == var1 % 37L && var1 != 0L) {
         var1 /= 37L;
      }

      return var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lkb;Lln;I)Lln;",
      garbageValue = "-810420491"
   )
   static final IterableNodeHashTable method4400(Buffer var0, IterableNodeHashTable var1) {
      int var2 = var0.method5575();
      int var3;
      if(var1 == null) {
         var3 = Calendar.method4034(var2);
         var1 = new IterableNodeHashTable(var3);
      }

      for(var3 = 0; var3 < var2; ++var3) {
         boolean var4 = var0.method5575() == 1;
         int var5 = var0.method5702();
         Object var6;
         if(var4) {
            var6 = new ObjectNode(var0.method5695());
         } else {
            var6 = new IntegerNode(var0.method5580());
         }

         var1.method5998((Node)var6, (long)var5);
      }

      return var1;
   }
}
