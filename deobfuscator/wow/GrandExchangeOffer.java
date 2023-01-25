import net.runelite.api.GrandExchangeOfferState;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSGrandExchangeOffer;
import net.runelite.rs.api.RSNPCDefinition;

@ObfuscatedName("b")
public class GrandExchangeOffer implements RSGrandExchangeOffer {

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   public static AbstractArchive ItemDefinition_modelArchive;
   @ObfuscatedName("dk")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   static Archive archive2;
   @ObfuscatedName("x")
   byte state;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1191314621
   )
   public int id;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1373983325
   )
   public int unitPrice;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -435168387
   )
   public int totalQuantity;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1383495981
   )
   public int currentQuantity;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1519014469
   )
   public int currentPrice;


   public GrandExchangeOffer() {}

   @ObfuscatedSignature(
      signature = "(Lkb;Z)V",
      garbageValue = "0"
   )
   public GrandExchangeOffer(Buffer var1, boolean var2) {
      this.state = var1.method5576();
      this.id = var1.method5577();
      this.unitPrice = var1.method5580();
      this.totalQuantity = var1.method5580();
      this.currentQuantity = var1.method5580();
      this.currentPrice = var1.method5580();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1689314705"
   )
   public int method185() {
      return this.state & 7;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1922096625"
   )
   public int method186() {
      return (this.state & 8) == 8?1:0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "587802237"
   )
   void method211(int var1) {
      this.state &= -8;
      this.state = (byte)(this.state | var1 & 7);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-582599399"
   )
   void method187(int var1) {
      this.state &= -9;
      if(var1 == 1) {
         this.state = (byte)(this.state | 8);
      }

   }

   public byte getRSState() {
      return this.state;
   }

   public int getQuantitySold() {
      return this.currentQuantity;
   }

   public int getTotalQuantity() {
      return this.totalQuantity;
   }

   public GrandExchangeOfferState getState() {
      byte var1 = this.getRSState();
      boolean var2 = (var1 & 8) == 8;
      boolean var3 = (var1 & 4) == 4;
      return var1 == 0?GrandExchangeOfferState.EMPTY:(var3 && this.getQuantitySold() < this.getTotalQuantity()?(var2?GrandExchangeOfferState.CANCELLED_SELL:GrandExchangeOfferState.CANCELLED_BUY):(var2?(var3?GrandExchangeOfferState.SOLD:GrandExchangeOfferState.SELLING):(var3?GrandExchangeOfferState.BOUGHT:GrandExchangeOfferState.BUYING)));
   }

   public int getItemId() {
      return this.id;
   }

   public int getPrice() {
      return this.unitPrice;
   }

   public int getSpent() {
      return this.currentPrice;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIII)V",
      garbageValue = "922781737"
   )
   static void method198(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var3 + var2) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method198(var0, var1, var2, var5 - 1);
         method198(var0, var1, var5 + 1, var3);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILce;ZB)I",
      garbageValue = "19"
   )
   static int method191(int var0, Script var1, boolean var2) {
      Widget var3 = var2?GrandExchangeOfferNameComparator.field115:Interpreter.field1130;
      if(var0 == 1500) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.x;
         return 1;
      } else if(var0 == 1501) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.y;
         return 1;
      } else if(var0 == 1502) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.width;
         return 1;
      } else if(var0 == 1503) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.height;
         return 1;
      } else if(var0 == 1504) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 1505) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("hj")
   @ObfuscatedSignature(
      signature = "(ZLkj;B)V",
      garbageValue = "18"
   )
   static final void method212(boolean var0, PacketBuffer var1) {
      Client.updateNpcs(var0, var1);
      Client.field801 = 0;
      Client.field851 = 0;
      WorldMapIcon_0.method304();

      int var2;
      while(var1.method5516(Client.packetWriter.serverPacketLength) >= 27) {
         var2 = var1.method5523(15);
         if(var2 == 32767) {
            break;
         }

         boolean var3 = false;
         if(Client.npcs[var2] == null) {
            Client.npcs[var2] = new NPC();
            Client.cachedNPCsChanged(var2);
            var3 = true;
         }

         NPC var4 = Client.npcs[var2];
         Client.npcIndices[++Client.npcCount - 1] = var2;
         var4.npcCycle = Client.cycle;
         int var5;
         if(var0) {
            var5 = var1.method5523(8);
            if(var5 > 127) {
               var5 -= 256;
            }
         } else {
            var5 = var1.method5523(5);
            if(var5 > 15) {
               var5 -= 32;
            }
         }

         int var6 = Client.defaultRotations[var1.method5523(3)];
         if(var3) {
            var4.orientation = var4.rotation = var6;
         }

         int var7 = var1.method5523(1);
         int var8 = var1.method5523(1);
         if(var8 == 1) {
            Client.field725[++Client.field851 - 1] = var2;
         }

         int var9;
         if(var0) {
            var9 = var1.method5523(8);
            if(var9 > 127) {
               var9 -= 256;
            }
         } else {
            var9 = var1.method5523(5);
            if(var9 > 15) {
               var9 -= 32;
            }
         }

         NPCDefinition var10001 = class237.method4226(var1.method5523(14));
         var4.onDefinitionChanged((RSNPCDefinition)var10001);
         var4.definition = var10001;
         var4.field976 = var4.definition.size;
         var4.field1026 = var4.definition.rotation;
         if(var4.field1026 == 0) {
            var4.rotation = 0;
         }

         var4.walkSequence = var4.definition.walkSequence;
         var4.walkBackSequence = var4.definition.walkBackSequence;
         var4.walkLeftSequence = var4.definition.walkLeftSequence;
         var4.walkRightSequence = var4.definition.walkRightSequence;
         var4.idleSequence = var4.definition.idleSequence;
         var4.turnLeftSequence = var4.definition.turnLeftSequence;
         var4.turnRightSequence = var4.definition.turnRightSequence;
         var4.method2136(ByteArrayPool.localPlayer.pathX[0] + var9, ByteArrayPool.localPlayer.pathY[0] + var5, var7 == 1);
      }

      var1.method5526();
      WorldMapSection0.method335(var1);

      for(var2 = 0; var2 < Client.field801; ++var2) {
         int var10 = Client.field918[var2];
         if(Client.npcs[var10].npcCycle != Client.cycle) {
            NPC var10000 = Client.npcs[var10];
            Client.npcs[var10].onDefinitionChanged((RSNPCDefinition)null);
            var10000.definition = null;
            Client.npcs[var10] = null;
            Client.cachedNPCsChanged(var10);
         }
      }

      if(var1.offset != Client.packetWriter.serverPacketLength) {
         throw new RuntimeException(var1.offset + "," + Client.packetWriter.serverPacketLength);
      } else {
         for(var2 = 0; var2 < Client.npcCount; ++var2) {
            if(Client.npcs[Client.npcIndices[var2]] == null) {
               throw new RuntimeException(var2 + "," + Client.npcCount);
            }
         }

      }
   }

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-21"
   )
   static void method210() {
      if(Client.isSpellSelected) {
         Widget var0 = GrandExchangeOfferUnitPriceComparator.method224(class7.selectedSpellWidget, Client.selectedSpellChildIndex);
         if(var0 != null && var0.onTargetLeave != null) {
            ScriptEvent var1 = new ScriptEvent();
            var1.widget = var0;
            var1.args = var0.onTargetLeave;
            GrandExchangeOfferOwnWorldComparator.method1395(var1);
         }

         Client.isSpellSelected = false;
         ItemContainer.method1273(var0);
      }
   }
}
