import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSIterableDualNodeQueue;

@ObfuscatedName("jz")
public class IterableDualNodeQueue implements Iterable, RSIterableDualNodeQueue {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   public DualNode sentinel = new DualNode();
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   DualNode head;


   public IterableDualNodeQueue() {
      this.sentinel.previousDual = this.sentinel;
      this.sentinel.nextDual = this.sentinel;
   }

   @ObfuscatedName("x")
   public void method5035() {
      while(this.sentinel.previousDual != this.sentinel) {
         this.sentinel.previousDual.method3672();
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lge;)V"
   )
   public void method5024(DualNode var1) {
      if(var1.nextDual != null) {
         var1.method3672();
      }

      var1.nextDual = this.sentinel.nextDual;
      var1.previousDual = this.sentinel;
      var1.nextDual.previousDual = var1;
      var1.previousDual.nextDual = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "()Lge;"
   )
   public DualNode method5018() {
      DualNode var1 = this.sentinel.previousDual;
      if(var1 == this.sentinel) {
         return null;
      } else {
         var1.method3672();
         return var1;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "()Lge;"
   )
   public DualNode method5032() {
      return this.method5030((DualNode)null);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lge;)Lge;"
   )
   DualNode method5030(DualNode var1) {
      DualNode var2;
      if(var1 == null) {
         var2 = this.sentinel.previousDual;
      } else {
         var2 = var1;
      }

      if(var2 == this.sentinel) {
         this.head = null;
         return null;
      } else {
         this.head = var2.previousDual;
         return var2;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "()Lge;"
   )
   public DualNode method5021() {
      DualNode var1 = this.head;
      if(var1 == this.sentinel) {
         this.head = null;
         return null;
      } else {
         this.head = var1.previousDual;
         return var1;
      }
   }

   public Iterator iterator() {
      return new IterableDualNodeQueueIterator(this);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lge;Lge;)V"
   )
   public static void method5017(DualNode var0, DualNode var1) {
      if(var0.nextDual != null) {
         var0.method3672();
      }

      var0.nextDual = var1;
      var0.previousDual = var1.previousDual;
      var0.nextDual.previousDual = var0;
      var0.previousDual.nextDual = var0;
   }
}
