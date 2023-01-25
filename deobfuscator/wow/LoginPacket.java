import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSLoginPacket;

@ObfuscatedName("gb")
public class LoginPacket implements class190, RSLoginPacket {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgb;"
   )
   public static final LoginPacket field2315 = new LoginPacket(14, 0);
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgb;"
   )
   static final LoginPacket field2311 = new LoginPacket(15, 4);
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgb;"
   )
   public static final LoginPacket field2317 = new LoginPacket(16, -2);
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgb;"
   )
   public static final LoginPacket field2313 = new LoginPacket(18, -2);
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgb;"
   )
   public static final LoginPacket field2314 = new LoginPacket(19, -2);
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lgb;"
   )
   static final LoginPacket field2319 = new LoginPacket(27, 0);
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "[Lgb;"
   )
   static final LoginPacket[] LoginPacket_indexedValues = new LoginPacket[32];
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lew;"
   )
   static UrlRequest World_request;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 774244909
   )
   public final int id;


   static {
      LoginPacket[] var0 = WorldMapSection3.method895();

      for(int var1 = 0; var1 < var0.length; ++var1) {
         LoginPacket_indexedValues[var0[var1].id] = var0[var1];
      }

   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   LoginPacket(int var1, int var2) {
      this.id = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1902674476"
   )
   static final void method3693() {
      GrandExchangeEvent.method165("Your friend list is full. Max of 200 for free users, and 400 for members");
   }
}
