import net.runelite.api.events.GrandExchangeSearched;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
public class class69 {

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "[Lla;"
   )
   static Sprite[] worldSelectBackSprites;
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = 731242929
   )
   static int baseX;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = 471245099
   )
   static int field585;


   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "573845052"
   )
   static void method1277() {
      IntHashTable.field4034 = new int[2000];
      int var0 = 0;
      int var1 = 240;

      int var3;
      for(byte var2 = 12; var0 < 16; var1 -= var2) {
         var3 = NPC.method2146((double)((float)var1 / 360.0F), 0.9998999834060669D, (double)(0.425F * (float)var0 / 16.0F + 0.075F));
         IntHashTable.field4034[var0] = var3;
         ++var0;
      }

      var1 = 48;

      for(int var5 = var1 / 6; var0 < IntHashTable.field4034.length; var1 -= var5) {
         var3 = var0 * 2;

         for(int var4 = NPC.method2146((double)((float)var1 / 360.0F), 0.9998999834060669D, 0.5D); var0 < var3 && var0 < IntHashTable.field4034.length; ++var0) {
            IntHashTable.field4034[var0] = var4;
         }
      }

   }

   @ObfuscatedName("ir")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "4"
   )
   static final void method1275() {
      boolean var0 = false;

      while(!var0) {
         var0 = true;

         for(int var1 = 0; var1 < Client.menuOptionsCount - 1; ++var1) {
            if(Client.menuOpcodes[var1] < 1000 && Client.menuOpcodes[var1 + 1] > 1000) {
               String var2 = Client.menuTargets[var1];
               Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
               Client.menuTargets[var1 + 1] = var2;
               String var3 = Client.menuActions[var1];
               Client.menuActions[var1] = Client.menuActions[var1 + 1];
               Client.menuActions[var1 + 1] = var3;
               int var4 = Client.menuOpcodes[var1];
               Client.menuOpcodes[var1] = Client.menuOpcodes[var1 + 1];
               Client.menuOpcodes[var1 + 1] = var4;
               var4 = Client.menuArguments1[var1];
               Client.menuArguments1[var1] = Client.menuArguments1[var1 + 1];
               Client.menuArguments1[var1 + 1] = var4;
               var4 = Client.menuArguments2[var1];
               Client.menuArguments2[var1] = Client.menuArguments2[var1 + 1];
               Client.menuArguments2[var1 + 1] = var4;
               var4 = Client.menuIdentifiers[var1];
               Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
               Client.menuIdentifiers[var1 + 1] = var4;
               boolean var5 = Client.menuShiftClick[var1];
               Client.menuShiftClick[var1] = Client.menuShiftClick[var1 + 1];
               Client.menuShiftClick[var1 + 1] = var5;
               var0 = false;
            }
         }
      }

   }

   @ObfuscatedName("kz")
   static void method1276(String var0, boolean var1, byte var2) {
      GrandExchangeSearched var3 = new GrandExchangeSearched();
      WorldMapSection1.client.getCallbacks().post(GrandExchangeSearched.class, var3);
      if(!var3.isConsumed()) {
         Client.copy$findItemDefinitions(var0, var1, var2);
      }

   }
}
