import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kq")
public final class class298 {

   @ObfuscatedName("x")
   static final char[] base37Table = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
   @ObfuscatedName("m")
   static long[] field3643 = new long[12];


   static {
      for(int var0 = 0; var0 < field3643.length; ++var0) {
         field3643[var0] = (long)Math.pow(37.0D, (double)var0);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Liy;II)Lhy;",
      garbageValue = "16711680"
   )
   static MusicPatch method5344(AbstractArchive var0, int var1) {
      byte[] var2 = var0.method4256(var1);
      return var2 == null?null:new MusicPatch(var2);
   }
}
