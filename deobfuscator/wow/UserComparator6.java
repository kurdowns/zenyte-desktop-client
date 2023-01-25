import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSUserComparator6;

@ObfuscatedName("fx")
public class UserComparator6 extends AbstractUserComparator implements RSUserComparator6 {

   @ObfuscatedName("s")
   static int[] Tiles_saturation;
   @ObfuscatedName("x")
   final boolean reversed;


   public UserComparator6(boolean var1) {
      this.reversed = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lke;Lke;I)I",
      garbageValue = "1973806284"
   )
   int method3538(Buddy var1, Buddy var2) {
      return var1.world != 0 && var2.world != 0?(this.reversed?var1.method5093().method5265(var2.method5093()):var2.method5093().method5265(var1.method5093())):this.method5112(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3538((Buddy)var1, (Buddy)var2);
   }
}
