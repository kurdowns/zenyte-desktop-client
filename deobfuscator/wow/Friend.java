import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSFriend;

@ObfuscatedName("ky")
public class Friend extends Buddy implements RSFriend {

   @ObfuscatedName("rc")
   @ObfuscatedGetter(
      intValue = -1119785599
   )
   static int field3626;
   @ObfuscatedName("x")
   boolean field3625;
   @ObfuscatedName("m")
   boolean field3623;


   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lky;I)I",
      garbageValue = "-1645564523"
   )
   int method5286(Friend var1) {
      return super.world == Client.worldId && Client.worldId != var1.world?-1:(Client.worldId == var1.world && super.world != Client.worldId?1:(super.world != 0 && var1.world == 0?-1:(var1.world != 0 && super.world == 0?1:(this.field3625 && !var1.field3625?-1:(!this.field3625 && var1.field3625?1:(this.field3623 && !var1.field3623?-1:(!this.field3623 && var1.field3623?1:(super.world != 0?super.int2 - var1.int2:var1.int2 - super.int2))))))));
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(Ljd;I)I",
      garbageValue = "-1956183743"
   )
   public int vmethod5285(User var1) {
      return this.method5286((Friend)var1);
   }

   public int compareTo(Object var1) {
      return this.method5286((Friend)var1);
   }
}
