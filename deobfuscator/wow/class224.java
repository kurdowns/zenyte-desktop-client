import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hm")
public class class224 {

   @ObfuscatedName("x")
   public static final short[] field2544 = new short[]{(short)6798, (short)8741, (short)25238, (short)4626, (short)4550};
   @ObfuscatedName("m")
   public static final short[][] field2547 = new short[][]{{(short)6798, (short)107, (short)10283, (short)16, (short)4797, (short)7744, (short)5799, (short)4634, (short)-31839, (short)22433, (short)2983, (short)-11343, (short)8, (short)5281, (short)10438, (short)3650, (short)-27322, (short)-21845, (short)200, (short)571, (short)908, (short)21830, (short)28946, (short)-15701, (short)-14010}, {(short)8741, (short)12, (short)-1506, (short)-22374, (short)7735, (short)8404, (short)1701, (short)-27106, (short)24094, (short)10153, (short)-8915, (short)4783, (short)1341, (short)16578, (short)-30533, (short)25239, (short)8, (short)5281, (short)10438, (short)3650, (short)-27322, (short)-21845, (short)200, (short)571, (short)908, (short)21830, (short)28946, (short)-15701, (short)-14010}, {(short)25238, (short)8742, (short)12, (short)-1506, (short)-22374, (short)7735, (short)8404, (short)1701, (short)-27106, (short)24094, (short)10153, (short)-8915, (short)4783, (short)1341, (short)16578, (short)-30533, (short)8, (short)5281, (short)10438, (short)3650, (short)-27322, (short)-21845, (short)200, (short)571, (short)908, (short)21830, (short)28946, (short)-15701, (short)-14010}, {(short)4626, (short)11146, (short)6439, (short)12, (short)4758, (short)10270}, {(short)4550, (short)4537, (short)5681, (short)5673, (short)5790, (short)6806, (short)8076, (short)4574, (short)17050, (short)0, (short)127, (short)-31821, (short)-17991}};
   @ObfuscatedName("k")
   public static final short[] field2546 = new short[]{(short)-10304, (short)9104, (short)-1, (short)-1, (short)-1};
   @ObfuscatedName("d")
   public static final short[][] field2545 = new short[][]{{(short)6554, (short)115, (short)10304, (short)28, (short)5702, (short)7756, (short)5681, (short)4510, (short)-31835, (short)22437, (short)2859, (short)-11339, (short)16, (short)5157, (short)10446, (short)3658, (short)-27314, (short)-21965, (short)472, (short)580, (short)784, (short)21966, (short)28950, (short)-15697, (short)-14002}, {(short)9104, (short)10275, (short)7595, (short)3610, (short)7975, (short)8526, (short)918, (short)-26734, (short)24466, (short)10145, (short)-6882, (short)5027, (short)1457, (short)16565, (short)-30545, (short)25486, (short)24, (short)5392, (short)10429, (short)3673, (short)-27335, (short)-21957, (short)192, (short)687, (short)412, (short)21821, (short)28835, (short)-15460, (short)-14019}, new short[0], new short[0], new short[0]};
   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   static Archive archive14;


   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZLjava/lang/String;ZI)V",
      garbageValue = "-222701931"
   )
   static void method4126(String var0, boolean var1, String var2, boolean var3) {
      if(var1) {
         if(!var3 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var5) {
               ;
            }
         }

         if(class60.field462.startsWith("win") && !var3) {
            WorldMapIcon_0.method306(var0, 0);
            return;
         }

         if(class60.field462.startsWith("mac")) {
            ItemContainer.method1274(var0, 1, var2);
            return;
         }

         WorldMapIcon_0.method306(var0, 2);
      } else {
         WorldMapIcon_0.method306(var0, 3);
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(ILce;ZS)I",
      garbageValue = "10447"
   )
   static int method4125(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 3903) {
         var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].method186();
         return 1;
      } else if(var0 == 3904) {
         var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].id;
         return 1;
      } else if(var0 == 3905) {
         var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].unitPrice;
         return 1;
      } else if(var0 == 3906) {
         var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].totalQuantity;
         return 1;
      } else if(var0 == 3907) {
         var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].currentQuantity;
         return 1;
      } else if(var0 == 3908) {
         var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].currentPrice;
         return 1;
      } else {
         int var12;
         if(var0 == 3910) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            var12 = Client.grandExchangeOffers[var3].method185();
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var12 == 0?1:0;
            return 1;
         } else if(var0 == 3911) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            var12 = Client.grandExchangeOffers[var3].method185();
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var12 == 2?1:0;
            return 1;
         } else if(var0 == 3912) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            var12 = Client.grandExchangeOffers[var3].method185();
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var12 == 5?1:0;
            return 1;
         } else if(var0 == 3913) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            var12 = Client.grandExchangeOffers[var3].method185();
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var12 == 1?1:0;
            return 1;
         } else {
            boolean var13;
            if(var0 == 3914) {
               var13 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
               if(GrandExchangeEvent.grandExchangeEvents != null) {
                  GrandExchangeEvent.grandExchangeEvents.method152(GrandExchangeEvents.GrandExchangeEvents_nameComparator, var13);
               }

               return 1;
            } else if(var0 == 3915) {
               var13 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
               if(GrandExchangeEvent.grandExchangeEvents != null) {
                  GrandExchangeEvent.grandExchangeEvents.method152(GrandExchangeEvents.GrandExchangeEvents_priceComparator, var13);
               }

               return 1;
            } else if(var0 == 3916) {
               Interpreter.Interpreter_intStackSize -= 2;
               var13 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] == 1;
               boolean var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1] == 1;
               if(GrandExchangeEvent.grandExchangeEvents != null) {
                  Client.GrandExchangeEvents_worldComparator.filterWorlds = var4;
                  GrandExchangeEvent.grandExchangeEvents.method152(Client.GrandExchangeEvents_worldComparator, var13);
               }

               return 1;
            } else if(var0 == 3917) {
               var13 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
               if(GrandExchangeEvent.grandExchangeEvents != null) {
                  GrandExchangeEvent.grandExchangeEvents.method152(GrandExchangeEvents.GrandExchangeEvents_ageComparator, var13);
               }

               return 1;
            } else if(var0 == 3918) {
               var13 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
               if(GrandExchangeEvent.grandExchangeEvents != null) {
                  GrandExchangeEvent.grandExchangeEvents.method152(GrandExchangeEvents.GrandExchangeEvents_quantityComparator, var13);
               }

               return 1;
            } else if(var0 == 3919) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = GrandExchangeEvent.grandExchangeEvents == null?0:GrandExchangeEvent.grandExchangeEvents.events.size();
               return 1;
            } else {
               GrandExchangeEvent var11;
               if(var0 == 3920) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var11 = (GrandExchangeEvent)GrandExchangeEvent.grandExchangeEvents.events.get(var3);
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var11.world;
                  return 1;
               } else if(var0 == 3921) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var11 = (GrandExchangeEvent)GrandExchangeEvent.grandExchangeEvents.events.get(var3);
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var11.method157();
                  return 1;
               } else if(var0 == 3922) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var11 = (GrandExchangeEvent)GrandExchangeEvent.grandExchangeEvents.events.get(var3);
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var11.method158();
                  return 1;
               } else if(var0 == 3923) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var11 = (GrandExchangeEvent)GrandExchangeEvent.grandExchangeEvents.events.get(var3);
                  long var5 = class217.method4036() - TilePaint.field1802 - var11.age;
                  int var7 = (int)(var5 / 3600000L);
                  int var8 = (int)((var5 - (long)(var7 * 3600000)) / 60000L);
                  int var9 = (int)((var5 - (long)(var7 * 3600000) - (long)(var8 * '\uea60')) / 1000L);
                  String var10 = var7 + ":" + var8 / 10 + var8 % 10 + ":" + var9 / 10 + var9 % 10;
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var10;
                  return 1;
               } else if(var0 == 3924) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var11 = (GrandExchangeEvent)GrandExchangeEvent.grandExchangeEvents.events.get(var3);
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var11.grandExchangeOffer.totalQuantity;
                  return 1;
               } else if(var0 == 3925) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var11 = (GrandExchangeEvent)GrandExchangeEvent.grandExchangeEvents.events.get(var3);
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var11.grandExchangeOffer.unitPrice;
                  return 1;
               } else if(var0 == 3926) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var11 = (GrandExchangeEvent)GrandExchangeEvent.grandExchangeEvents.events.get(var3);
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var11.grandExchangeOffer.id;
                  return 1;
               } else {
                  return 2;
               }
            }
         }
      }
   }
}
