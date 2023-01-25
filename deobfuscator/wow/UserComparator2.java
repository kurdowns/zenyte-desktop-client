import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSUserComparator2;

@ObfuscatedName("lh")
public class UserComparator2 implements Comparator, RSUserComparator2 {

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lch;"
   )
   static World[] World_worlds;
   @ObfuscatedName("x")
   final boolean reversed;


   public UserComparator2(boolean var1) {
      this.reversed = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljd;Ljd;I)I",
      garbageValue = "-426139063"
   )
   int method5986(User var1, User var2) {
      return this.reversed?var1.method5093().method5265(var2.method5093()):var2.method5093().method5265(var1.method5093());
   }

   public int compare(Object var1, Object var2) {
      return this.method5986((User)var1, (User)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
