import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSFriendLoginUpdate;

@ObfuscatedName("ki")
public class FriendLoginUpdate extends Link implements RSFriendLoginUpdate {

   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1923420853
   )
   public int field3636 = (int)(class217.method4036() / 1000L);
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lku;"
   )
   public Username username;
   @ObfuscatedName("w")
   public short world;


   @ObfuscatedSignature(
      signature = "(Lku;I)V"
   )
   FriendLoginUpdate(Username var1, int var2) {
      this.username = var1;
      this.world = (short)var2;
   }
}
