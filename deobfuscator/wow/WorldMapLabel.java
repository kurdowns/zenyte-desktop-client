import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSWorldMapLabel;

@ObfuscatedName("au")
public class WorldMapLabel implements RSWorldMapLabel {

   @ObfuscatedName("q")
   public static short[] field278;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 710663083
   )
   public static int canvasWidth;
   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "Ley;"
   )
   static UrlRequester urlRequester;
   @ObfuscatedName("x")
   String text;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 622921631
   )
   int width;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 939857441
   )
   int height;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lae;"
   )
   WorldMapLabelSize size;


   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IILae;)V"
   )
   WorldMapLabel(String var1, int var2, int var3, WorldMapLabelSize var4) {
      this.text = var1;
      this.width = var2;
      this.height = var3;
      this.size = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILce;ZI)I",
      garbageValue = "-461076613"
   )
   static int method517(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 100) {
         Interpreter.Interpreter_intStackSize -= 3;
         var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
         int var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
         if(var4 == 0) {
            throw new RuntimeException();
         } else {
            Widget var6 = MusicPatchNode.method3920(var3);
            if(var6.children == null) {
               var6.children = new Widget[var5 + 1];
            }

            if(var6.children.length <= var5) {
               Widget[] var7 = new Widget[var5 + 1];

               for(int var8 = 0; var8 < var6.children.length; ++var8) {
                  var7[var8] = var6.children[var8];
               }

               var6.children = var7;
            }

            if(var5 > 0 && var6.children[var5 - 1] == null) {
               throw new RuntimeException("" + (var5 - 1));
            } else {
               Widget var12 = new Widget();
               var12.type = var4;
               var12.parentId = var12.id = var6.id;
               var12.childIndex = var5;
               var12.isIf3 = true;
               var6.children[var5] = var12;
               if(var2) {
                  GrandExchangeOfferNameComparator.field115 = var12;
               } else {
                  Interpreter.field1130 = var12;
               }

               ItemContainer.method1273(var6);
               return 1;
            }
         }
      } else {
         Widget var9;
         if(var0 == 101) {
            var9 = var2?GrandExchangeOfferNameComparator.field115:Interpreter.field1130;
            Widget var10 = MusicPatchNode.method3920(var9.id);
            var10.children[var9.childIndex] = null;
            ItemContainer.method1273(var10);
            return 1;
         } else if(var0 == 102) {
            var9 = MusicPatchNode.method3920(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
            var9.children = null;
            ItemContainer.method1273(var9);
            return 1;
         } else if(var0 != 200) {
            if(var0 == 201) {
               var9 = MusicPatchNode.method3920(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
               if(var9 != null) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
                  if(var2) {
                     GrandExchangeOfferNameComparator.field115 = var9;
                  } else {
                     Interpreter.field1130 = var9;
                  }
               } else {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else {
               return 2;
            }
         } else {
            Interpreter.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            Widget var11 = GrandExchangeOfferUnitPriceComparator.method224(var3, var4);
            if(var11 != null && var4 != -1) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
               if(var2) {
                  GrandExchangeOfferNameComparator.field115 = var11;
               } else {
                  Interpreter.field1130 = var11;
               }
            } else {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }
}
