import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("k")
final class class2 implements class0 {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;Lkb;B)V",
      garbageValue = "3"
   )
   public void vmethod64(Object var1, Buffer var2) {
      this.method36((Long)var1, var2);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lkb;I)Ljava/lang/Object;",
      garbageValue = "-1146837249"
   )
   public Object vmethod74(Buffer var1) {
      return Long.valueOf(var1.method5581());
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Long;Lkb;I)V",
      garbageValue = "1997729156"
   )
   void method36(Long var1, Buffer var2) {
      var2.method5557(var1.longValue());
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/lang/Class;",
      garbageValue = "15"
   )
   static Class method24(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Reflection.findClass(var0)))))))));
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILce;ZI)I",
      garbageValue = "-453717228"
   )
   static int method28(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = MusicPatchNode.method3920(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
      } else {
         var3 = var2?GrandExchangeOfferNameComparator.field115:Interpreter.field1130;
      }

      ItemContainer.method1273(var3);
      if(var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if(var0 == 1201) {
            var3.modelType = 2;
            var3.modelId = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            return 1;
         } else if(var0 == 1202) {
            var3.modelType = 3;
            var3.modelId = ByteArrayPool.localPlayer.appearance.method4096();
            return 1;
         } else {
            return 2;
         }
      } else {
         Interpreter.Interpreter_intStackSize -= 2;
         int var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
         int var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
         var3.itemId = var4;
         var3.itemQuantity = var5;
         ItemDefinition var6 = AbstractWorldMapData.method373(var4);
         var3.modelAngleX = var6.xan2d;
         var3.modelAngleY = var6.yan2d;
         var3.modelAngleZ = var6.zan2d;
         var3.modelOffsetX = var6.offsetX2d;
         var3.modelOffsetY = var6.offsetY2d;
         var3.modelZoom = var6.zoom2d;
         if(var0 == 1205) {
            var3.itemQuantityMode = 0;
         } else if(var0 == 1212 | 1 == var6.isStackable) {
            var3.itemQuantityMode = 1;
         } else {
            var3.itemQuantityMode = 2;
         }

         if(var3.field2622 > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.field2622;
         } else if(var3.rawWidth > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.rawWidth;
         }

         return 1;
      }
   }

   @ObfuscatedName("jn")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "1"
   )
   static void method34(boolean var0) {
      Client.tapToDrop = var0;
   }

   @ObfuscatedName("jl")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)V",
      garbageValue = "16"
   )
   static final void method35(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(LoginScreenAnimation.method1914(var0)) {
         WorldMapDecorationType.method4210(Widget.Widget_interfaceComponents[var0], -1, var1, var2, var3, var4, var5, var6);
      }
   }
}
