import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSIterableNodeDequeDescendingIterator;

@ObfuscatedName("ju")
public class IterableNodeDequeDescendingIterator implements Iterator, RSIterableNodeDequeDescendingIterator {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   IterableNodeDeque deque;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   Node field3539;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   Node last = null;


   @ObfuscatedSignature(
      signature = "(Ljm;)V"
   )
   IterableNodeDequeDescendingIterator(IterableNodeDeque var1) {
      this.method5001(var1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljm;)V"
   )
   void method5001(IterableNodeDeque var1) {
      this.deque = var1;
      this.method5009();
   }

   @ObfuscatedName("z")
   void method5009() {
      this.field3539 = this.deque != null?this.deque.sentinel.previous:null;
      this.last = null;
   }

   public Object next() {
      Node var1 = this.field3539;
      if(var1 == this.deque.sentinel) {
         var1 = null;
         this.field3539 = null;
      } else {
         this.field3539 = var1.previous;
      }

      this.last = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.deque.sentinel != this.field3539;
   }

   public void remove() {
      this.last.method3676();
      this.last = null;
   }
}
