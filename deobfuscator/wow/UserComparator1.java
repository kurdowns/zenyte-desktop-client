import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSUserComparator1;

@ObfuscatedName("ll")
public class UserComparator1 implements Comparator, RSUserComparator1 {

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   public static AbstractArchive HitSplatDefinition_spritesArchive;
   @ObfuscatedName("x")
   final boolean reversed;


   public UserComparator1(boolean var1) {
      this.reversed = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljd;Ljd;I)I",
      garbageValue = "-1609540202"
   )
   int method5978(User var1, User var2) {
      return this.reversed?var1.vmethod5285(var2):var2.vmethod5285(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method5978((User)var1, (User)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
