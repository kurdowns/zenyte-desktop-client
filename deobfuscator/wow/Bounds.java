import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSBounds;

@ObfuscatedName("ld")
public class Bounds implements RSBounds {

   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1060370967
   )
   public int lowY;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1597072337
   )
   public int lowX;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -456113605
   )
   public int highX;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -239139767
   )
   public int highY;


   public Bounds(int var1, int var2, int var3, int var4) {
      this.method6051(var1, var2);
      this.method6052(var3, var4);
   }

   public Bounds(int var1, int var2) {
      this(0, 0, var1, var2);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1269806188"
   )
   public void method6051(int var1, int var2) {
      this.lowX = var1;
      this.lowY = var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "838675503"
   )
   public void method6052(int var1, int var2) {
      this.highX = var1;
      this.highY = var2;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lld;Lld;B)V",
      garbageValue = "-7"
   )
   public void method6050(Bounds var1, Bounds var2) {
      this.method6054(var1, var2);
      this.method6055(var1, var2);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lld;Lld;I)V",
      garbageValue = "-1938755982"
   )
   void method6054(Bounds var1, Bounds var2) {
      var2.lowX = this.lowX;
      var2.highX = this.highX;
      if(this.lowX < var1.lowX) {
         var2.highX -= var1.lowX - this.lowX;
         var2.lowX = var1.lowX;
      }

      if(var2.method6056() > var1.method6056()) {
         var2.highX -= var2.method6056() - var1.method6056();
      }

      if(var2.highX < 0) {
         var2.highX = 0;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lld;Lld;I)V",
      garbageValue = "-642069303"
   )
   void method6055(Bounds var1, Bounds var2) {
      var2.lowY = this.lowY;
      var2.highY = this.highY;
      if(this.lowY < var1.lowY) {
         var2.highY -= var1.lowY - this.lowY;
         var2.lowY = var1.lowY;
      }

      if(var2.method6053() > var1.method6053()) {
         var2.highY -= var2.method6053() - var1.method6053();
      }

      if(var2.highY < 0) {
         var2.highY = 0;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   int method6056() {
      return this.lowX + this.highX;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "180335993"
   )
   int method6053() {
      return this.highY + this.lowY;
   }

   public String toString() {
      return null;
   }
}
