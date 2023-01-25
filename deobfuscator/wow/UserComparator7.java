import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSUserComparator7;

@ObfuscatedName("fv")
public class UserComparator7 extends AbstractUserComparator implements RSUserComparator7 {

   @ObfuscatedName("x")
   final boolean reversed;


   public UserComparator7(boolean var1) {
      this.reversed = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lke;Lke;I)I",
      garbageValue = "-1450384887"
   )
   int method3512(Buddy var1, Buddy var2) {
      return var1.world != 0 && var2.world != 0?(this.reversed?var1.int2 - var2.int2:var2.int2 - var1.int2):this.method5112(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3512((Buddy)var1, (Buddy)var2);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Liy;III)Z",
      garbageValue = "-1870952127"
   )
   public static boolean method3517(AbstractArchive var0, int var1, int var2) {
      byte[] var3 = var0.method4249(var1, var2, (byte)-1);
      if(var3 == null) {
         return false;
      } else {
         MusicPatch.method3982(var3);
         return true;
      }
   }
}
