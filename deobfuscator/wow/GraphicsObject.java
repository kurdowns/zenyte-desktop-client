import java.io.IOException;
import java.util.LinkedHashMap;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.GraphicsObjectCreated;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSGraphicsObject;

@ObfuscatedName("cs")
public final class GraphicsObject extends Entity implements RSGraphicsObject {

   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 2069035029
   )
   static int field1141;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1892453991
   )
   int y;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -760249917
   )
   int id;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1800328217
   )
   int cycleStart;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1899634503
   )
   int plane;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1416163877
   )
   int x;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1568421589
   )
   int height;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   SequenceDefinition sequenceDefinition;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 137908093
   )
   int frame = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1659950887
   )
   int frameCycle = 0;
   @ObfuscatedName("e")
   boolean isFinished = false;


   GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.id = var1;
      this.plane = var2;
      this.x = var3;
      this.y = var4;
      this.height = var5;
      this.cycleStart = var7 + var6;
      int var8 = MouseHandler.method1205(this.id).sequence;
      if(var8 != -1) {
         this.isFinished = false;
         this.sequenceDefinition = SpotAnimationDefinition.method4503(var8);
      } else {
         this.isFinished = true;
      }

      this.rl$$init();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-937691597"
   )
   final void method2115(int var1) {
      if(!this.isFinished) {
         this.frameCycle += var1;

         while(this.frameCycle > this.sequenceDefinition.frameLengths[this.frame]) {
            this.frameCycle -= this.sequenceDefinition.frameLengths[this.frame];
            ++this.frame;
            if(this.frame >= this.sequenceDefinition.frameIds.length) {
               this.isFinished = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Lel;"
   )
   protected final Model vmethod3367(int var1) {
      SpotAnimationDefinition var2 = MouseHandler.method1205(this.id);
      Model var3;
      if(!this.isFinished) {
         var3 = var2.method4492(this.frame);
      } else {
         var3 = var2.method4492(-1);
      }

      return var3 == null?null:var3;
   }

   public int getX() {
      return this.x;
   }

   public int getY() {
      return this.y;
   }

   private void rl$$init() {
      GraphicsObjectCreated var1 = new GraphicsObjectCreated(this);
      WorldMapSection1.client.getCallbacks().post(GraphicsObjectCreated.class, var1);
   }

   public LocalPoint getLocation() {
      return new LocalPoint(this.getX(), this.getY());
   }

   public int getId() {
      return this.id;
   }

   public int getStartCycle() {
      return this.cycleStart;
   }

   public int getLevel() {
      return this.plane;
   }

   public int getHeight() {
      return this.height;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-22"
   )
   public static void method2121() {
      if(MouseHandler.MouseHandler_instance != null) {
         MouseHandler var0 = MouseHandler.MouseHandler_instance;
         synchronized(MouseHandler.MouseHandler_instance) {
            MouseHandler.MouseHandler_instance = null;
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1774574647"
   )
   public static byte[] method2120() {
      byte[] var0 = new byte[24];

      try {
         JagexCache.JagexCache_randomDat.method6655(0L);
         JagexCache.JagexCache_randomDat.method6657(var0);

         int var1;
         for(var1 = 0; var1 < 24 && var0[var1] == 0; ++var1) {
            ;
         }

         if(var1 >= 24) {
            throw new IOException();
         }
      } catch (Exception var4) {
         for(int var2 = 0; var2 < 24; ++var2) {
            var0[var2] = -1;
         }
      }

      return var0;
   }

   @ObfuscatedName("ft")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1537467605"
   )
   static final void method2122(boolean var0) {
      if(var0) {
         Client.field715 = Login.field1214?class169.field2007:class169.field2006;
      } else {
         LinkedHashMap var1 = GrandExchangeOfferOwnWorldComparator.clientPreferences.parameters;
         String var3 = Login.Login_username;
         int var4 = var3.length();
         int var5 = 0;

         for(int var6 = 0; var6 < var4; ++var6) {
            var5 = (var5 << 5) - var5 + var3.charAt(var6);
         }

         Client.field715 = var1.containsKey(Integer.valueOf(var5))?class169.field2012:class169.field2008;
      }

   }
}
