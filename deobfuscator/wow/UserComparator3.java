import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSUserComparator3;

@ObfuscatedName("fp")
public class UserComparator3 extends AbstractUserComparator implements RSUserComparator3 {

   @ObfuscatedName("pl")
   @ObfuscatedSignature(
      signature = "Llg;"
   )
   static PrivateChatMode privateChatMode;
   @ObfuscatedName("x")
   final boolean reversed;


   public UserComparator3(boolean var1) {
      this.reversed = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lke;Lke;I)I",
      garbageValue = "1767041351"
   )
   int method3530(Buddy var1, Buddy var2) {
      return var2.world != var1.world?(this.reversed?var1.world - var2.world:var2.world - var1.world):this.method5112(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3530((Buddy)var1, (Buddy)var2);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lch;S)V",
      garbageValue = "5308"
   )
   static void method3526(World var0) {
      if(var0.method1900() != Client.isMembersWorld) {
         Client.isMembersWorld = var0.method1900();
         ArchiveLoader.method1254(var0.method1900());
      }

      Script.worldHost = var0.host;
      Client.worldId = var0.id;
      Client.worldProperties = var0.properties;
      WorldMapLabelSize.port1 = Client.gameBuild == 0?'\uaa4a':var0.id + '\u9c40';
      GrandExchangeOfferAgeComparator.port2 = Client.gameBuild == 0?443:var0.id + '\uc350';
      class280.port3 = WorldMapLabelSize.port1;
   }
}
