import java.util.HashSet;
import java.util.Set;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSModeWhere;

@ObfuscatedName("gd")
public class ModeWhere implements Enumerated, RSModeWhere {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   static final ModeWhere field2375 = new ModeWhere("", 0, new class200[]{class200.field2370});
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   static final ModeWhere field2382 = new ModeWhere("", 1, new class200[]{class200.field2371, class200.field2370});
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   static final ModeWhere field2374 = new ModeWhere("", 2, new class200[]{class200.field2371, class200.field2369, class200.field2370});
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   static final ModeWhere field2376 = new ModeWhere("", 3, new class200[]{class200.field2371});
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   static final ModeWhere field2378 = new ModeWhere("", 4);
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   static final ModeWhere field2379 = new ModeWhere("", 5, new class200[]{class200.field2371, class200.field2370});
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   static final ModeWhere field2380 = new ModeWhere("", 6, new class200[]{class200.field2370});
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   static final ModeWhere field2381 = new ModeWhere("", 8, new class200[]{class200.field2371, class200.field2370});
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   static final ModeWhere field2377 = new ModeWhere("", 9, new class200[]{class200.field2371, class200.field2369});
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   static final ModeWhere field2383 = new ModeWhere("", 10, new class200[]{class200.field2371});
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   static final ModeWhere field2384 = new ModeWhere("", 11, new class200[]{class200.field2371});
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   static final ModeWhere field2385 = new ModeWhere("", 12, new class200[]{class200.field2371, class200.field2370});
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   static final ModeWhere field2386 = new ModeWhere("", 13, new class200[]{class200.field2371});
   @ObfuscatedName("bh")
   static String worldListURL;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1460687895
   )
   final int id;
   @ObfuscatedName("h")
   final Set field2388 = new HashSet();


   static {
      method3754();
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I[Lgy;)V"
   )
   ModeWhere(String var1, int var2, class200[] var3) {
      this.id = var2;
      class200[] var4 = var3;

      for(int var5 = 0; var5 < var4.length; ++var5) {
         class200 var6 = var4[var5];
         this.field2388.add(var6);
      }

   }

   ModeWhere(String var1, int var2) {
      this.id = var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "56"
   )
   public int vmethod6189() {
      return this.id;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)[Lgd;",
      garbageValue = "-2096888845"
   )
   static ModeWhere[] method3754() {
      return new ModeWhere[]{field2379, field2385, field2386, field2376, field2384, field2380, field2381, field2377, field2378, field2374, field2375, field2382, field2383};
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1010005518"
   )
   static int method3762(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.method6046((long)var0);
      return var2 == null?-1:(var1 >= 0 && var1 < var2.ids.length?var2.ids[var1]:-1);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-122"
   )
   public static int method3764(int var0, int var1) {
      int var2;
      if(var1 > var0) {
         var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      while(var1 != 0) {
         var2 = var0 % var1;
         var0 = var1;
         var1 = var2;
      }

      return var0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILce;ZI)I",
      garbageValue = "1096677335"
   )
   static int method3761(int var0, Script var1, boolean var2) {
      return var0 < 1000?WorldMapLabel.method517(var0, var1, var2):(var0 < 1100?SecureRandomCallable.method1249(var0, var1, var2):(var0 < 1200?UserList.method5226(var0, var1, var2):(var0 < 1300?class2.method28(var0, var1, var2):(var0 < 1400?Decimator.method2649(var0, var1, var2):(var0 < 1500?WorldMapEvent.method866(var0, var1, var2):(var0 < 1600?GrandExchangeOffer.method191(var0, var1, var2):(var0 < 1700?GrandExchangeOfferWorldComparator.method137(var0, var1, var2):(var0 < 1800?NPC.method2147(var0, var1, var2):(var0 < 1900?WorldMapSection1.method683(var0, var1, var2):(var0 < 2000?PlayerType.method4234(var0, var1, var2):(var0 < 2100?SecureRandomCallable.method1249(var0, var1, var2):(var0 < 2200?UserList.method5226(var0, var1, var2):(var0 < 2300?class2.method28(var0, var1, var2):(var0 < 2400?Decimator.method2649(var0, var1, var2):(var0 < 2500?WorldMapEvent.method866(var0, var1, var2):(var0 < 2600?WorldMapManager.method750(var0, var1, var2):(var0 < 2700?class7.method101(var0, var1, var2):(var0 < 2800?UrlRequest.method3423(var0, var1, var2):(var0 < 2900?Message.method1318(var0, var1, var2):(var0 < 3000?PlayerType.method4234(var0, var1, var2):(var0 < 3200?Widget.method4184(var0, var1, var2):(var0 < 3300?NPC.method2145(var0, var1, var2):(var0 < 3400?AbstractUserComparator.method5120(var0, var1, var2):(var0 < 3500?class52.method904(var0, var1, var2):(var0 < 3700?class13.method132(var0, var1, var2):(var0 < 4000?class224.method4125(var0, var1, var2):(var0 < 4100?ObjectDefinition.method4711(var0, var1, var2):(var0 < 4200?AbstractWorldMapData.method384(var0, var1, var2):(var0 < 4300?class22.method258(var0, var1, var2):(var0 < 5100?BoundaryObject.method3376(var0, var1, var2):(var0 < 5400?WorldMapEvent.method865(var0, var1, var2):(var0 < 5600?AbstractWorldMapData.method380(var0, var1, var2):(var0 < 5700?WorldMapData_1.method814(var0, var1, var2):(var0 < 6300?MouseRecorder.method1290(var0, var1, var2):(var0 < 6600?GrandExchangeOfferNameComparator.method238(var0, var1, var2):(var0 < 6700?IgnoreList.method5131(var0, var1, var2):2))))))))))))))))))))))))))))))))))));
   }
}
