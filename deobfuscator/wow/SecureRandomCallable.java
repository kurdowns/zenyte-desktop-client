import java.security.SecureRandom;
import java.util.concurrent.Callable;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSSecureRandomCallable;

@ObfuscatedName("bx")
public class SecureRandomCallable implements Callable, RSSecureRandomCallable {

   public Object call() {
      SecureRandom var2 = new SecureRandom();
      var2.nextInt();
      return var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1446972814"
   )
   public static int method1250() {
      return ViewportMouse.ViewportMouse_entityCount;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BI)Lce;",
      garbageValue = "-932748815"
   )
   static Script method1246(byte[] var0) {
      Script var1 = new Script();
      Buffer var2 = new Buffer(var0);
      var2.offset = var2.array.length - 2;
      int var3 = var2.method5577();
      int var4 = var2.array.length - 2 - var3 - 12;
      var2.offset = var4;
      int var5 = var2.method5580();
      var1.localIntCount = var2.method5577();
      var1.localStringCount = var2.method5577();
      var1.intArgumentCount = var2.method5577();
      var1.stringArgumentCount = var2.method5577();
      int var6 = var2.method5575();
      int var7;
      int var8;
      if(var6 > 0) {
         var1.switches = var1.method2339(var6);

         for(var7 = 0; var7 < var6; ++var7) {
            var8 = var2.method5577();
            IterableNodeHashTable var9 = new IterableNodeHashTable(var8 > 0?Calendar.method4034(var8):1);
            var1.switches[var7] = var9;

            while(var8-- > 0) {
               int var10 = var2.method5580();
               int var11 = var2.method5580();
               var9.method5998(new IntegerNode(var11), (long)var10);
            }
         }
      }

      var2.offset = 0;
      var2.method5583();
      var1.opcodes = new int[var5];
      var1.intOperands = new int[var5];
      var1.stringOperands = new String[var5];

      for(var7 = 0; var2.offset < var4; var1.opcodes[var7++] = var8) {
         var8 = var2.method5577();
         if(var8 == 3) {
            var1.stringOperands[var7] = var2.method5695();
         } else if(var8 < 100 && var8 != 21 && var8 != 38 && var8 != 39) {
            var1.intOperands[var7] = var2.method5580();
         } else {
            var1.intOperands[var7] = var2.method5575();
         }
      }

      return var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILce;ZI)I",
      garbageValue = "-153982607"
   )
   static int method1249(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         var4 = MusicPatchNode.method3920(var3);
      } else {
         var4 = var2?GrandExchangeOfferNameComparator.field115:Interpreter.field1130;
      }

      if(var0 == 1000) {
         Interpreter.Interpreter_intStackSize -= 4;
         var4.rawX = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
         var4.rawY = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
         var4.xAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
         var4.yAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
         ItemContainer.method1273(var4);
         WorldMapSection1.client.method1419(var4);
         if(var3 != -1 && var4.type == 0) {
            MouseHandler.method1161(Widget.Widget_interfaceComponents[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1001) {
         Interpreter.Interpreter_intStackSize -= 4;
         var4.rawWidth = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
         var4.rawHeight = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
         var4.widthAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
         var4.heightAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
         ItemContainer.method1273(var4);
         WorldMapSection1.client.method1419(var4);
         if(var3 != -1 && var4.type == 0) {
            MouseHandler.method1161(Widget.Widget_interfaceComponents[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1003) {
         boolean var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
         if(var5 != var4.isHidden) {
            var4.isHidden = var5;
            var4.onHiddenChanged(-1);
            ItemContainer.method1273(var4);
         }

         return 1;
      } else if(var0 == 1005) {
         var4.noClickThrough = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
         return 1;
      } else if(var0 == 1006) {
         var4.noScrollThrough = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lel;IIII)Z",
      garbageValue = "1749928116"
   )
   static final boolean method1252(Model var0, int var1, int var2, int var3) {
      boolean var4 = ViewportMouse.ViewportMouse_isInViewport;
      if(!var4) {
         return false;
      } else {
         Varcs.method2294();
         int var5 = var0.xMid + var1;
         int var6 = var2 + var0.yMid;
         int var7 = var3 + var0.zMid;
         int var8 = var0.xMidOffset;
         int var9 = var0.yMidOffset;
         int var10 = var0.zMidOffset;
         int var11 = ViewportMouse.field1756 - var5;
         int var12 = class300.field3653 - var6;
         int var13 = HorizontalAlignment.field3456 - var7;
         return Math.abs(var11) > var8 + class23.field134?false:(Math.abs(var12) > var9 + ViewportMouse.field1758?false:(Math.abs(var13) > var10 + AttackOption.field1182?false:(Math.abs(var13 * Clock.field2061 - var12 * GrandExchangeEvent.field75) > var9 * AttackOption.field1182 + var10 * ViewportMouse.field1758?false:(Math.abs(var11 * GrandExchangeEvent.field75 - var13 * ViewportMouse.field1753) > var10 * class23.field134 + var8 * AttackOption.field1182?false:Math.abs(var12 * ViewportMouse.field1753 - var11 * Clock.field2061) <= var8 * ViewportMouse.field1758 + var9 * class23.field134))));
      }
   }

   @ObfuscatedName("jg")
   @ObfuscatedSignature(
      signature = "([Lhe;IB)V",
      garbageValue = "112"
   )
   static final void method1251(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method1251(var3.children, var1);
               }

               InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.method6046((long)var3.id);
               if(var4 != null) {
                  class198.method3733(var4.group, var1);
               }
            }

            ScriptEvent var5;
            if(var1 == 0 && var3.onDialogAbort != null) {
               var5 = new ScriptEvent();
               var5.widget = var3;
               var5.args = var3.onDialogAbort;
               GrandExchangeOfferOwnWorldComparator.method1395(var5);
            }

            if(var1 == 1 && var3.onSubChange != null) {
               if(var3.childIndex >= 0) {
                  Widget var6 = MusicPatchNode.method3920(var3.id);
                  if(var6 == null || var6.children == null || var3.childIndex >= var6.children.length || var3 != var6.children[var3.childIndex]) {
                     continue;
                  }
               }

               var5 = new ScriptEvent();
               var5.widget = var3;
               var5.args = var3.onSubChange;
               GrandExchangeOfferOwnWorldComparator.method1395(var5);
            }
         }
      }

   }
}
