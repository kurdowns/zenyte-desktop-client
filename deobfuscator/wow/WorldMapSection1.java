import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSWorldMapSection1;

@ObfuscatedName("aa")
public class WorldMapSection1 implements WorldMapSection, RSWorldMapSection1 {

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "Lclient;"
   )
   static Client client;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1637377849
   )
   int minPlane;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1999475083
   )
   int planes;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1574888169
   )
   int regionStartX;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1761506511
   )
   int regionStartY;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2112462573
   )
   int regionEndX;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 731154353
   )
   int regionEndY;


   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Las;I)V",
      garbageValue = "1890497148"
   )
   public void vmethod870(WorldMapArea var1) {
      if(var1.regionLowX > this.regionEndX) {
         var1.regionLowX = this.regionEndX;
      }

      if(var1.regionHighX < this.regionEndX) {
         var1.regionHighX = this.regionEndX;
      }

      if(var1.regionLowY > this.regionEndY) {
         var1.regionLowY = this.regionEndY;
      }

      if(var1.regionHighY < this.regionEndY) {
         var1.regionHighY = this.regionEndY;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-65934716"
   )
   public boolean vmethod871(int var1, int var2, int var3) {
      return var1 >= this.minPlane && var1 < this.planes + this.minPlane?var2 >> 6 == this.regionStartX && var3 >> 6 == this.regionStartY:false;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1383343929"
   )
   public boolean vmethod872(int var1, int var2) {
      return var1 >> 6 == this.regionEndX && var2 >> 6 == this.regionEndY;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "1656767825"
   )
   public int[] vmethod873(int var1, int var2, int var3) {
      if(!this.vmethod871(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.regionEndX * 64 - this.regionStartX * 64 + var2, var3 + (this.regionEndY * 64 - this.regionStartY * 64)};
         return var4;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)Lhj;",
      garbageValue = "-226825052"
   )
   public Coord vmethod890(int var1, int var2) {
      if(!this.vmethod872(var1, var2)) {
         return null;
      } else {
         int var3 = this.regionStartX * 64 - this.regionEndX * 64 + var1;
         int var4 = this.regionStartY * 64 - this.regionEndY * 64 + var2;
         return new Coord(this.minPlane, var3, var4);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lkb;I)V",
      garbageValue = "-1393433755"
   )
   public void vmethod885(Buffer var1) {
      this.minPlane = var1.method5575();
      this.planes = var1.method5575();
      this.regionStartX = var1.method5577();
      this.regionStartY = var1.method5577();
      this.regionEndX = var1.method5577();
      this.regionEndY = var1.method5577();
      this.method662();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1986942295"
   )
   void method662() {}

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-1"
   )
   public static int method663(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0:7 - var1));
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILce;ZB)I",
      garbageValue = "-116"
   )
   static int method683(int var0, Script var1, boolean var2) {
      Widget var3 = var2?GrandExchangeOfferNameComparator.field115:Interpreter.field1130;
      if(var0 == 1800) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = WorldMapRectangle.method388(ScriptEvent.method1283(var3));
         return 1;
      } else if(var0 != 1801) {
         if(var0 == 1802) {
            if(var3.dataText == null) {
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
            } else {
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.dataText;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         --var4;
         if(var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
            Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.actions[var4];
         } else {
            Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
         }

         return 1;
      }
   }

   @ObfuscatedName("gj")
   @ObfuscatedSignature(
      signature = "(Lcw;IIIIII)V"
   )
   static final void method655(Actor var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(Scene.shouldDraw(var0, true)) {
         Scene.copy$drawActor2d(var0, var1, var2, var3, var4, var5, var6);
      }

   }
}
