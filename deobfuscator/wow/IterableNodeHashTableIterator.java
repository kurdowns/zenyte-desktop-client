import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSIterableNodeHashTableIterator;

@ObfuscatedName("lw")
public class IterableNodeHashTableIterator implements Iterator, RSIterableNodeHashTableIterator {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lln;"
   )
   IterableNodeHashTable hashTable;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   Node head;
   @ObfuscatedName("k")
   int index;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   Node last = null;


   @ObfuscatedSignature(
      signature = "(Lln;)V"
   )
   IterableNodeHashTableIterator(IterableNodeHashTable var1) {
      this.hashTable = var1;
      this.method6022();
   }

   @ObfuscatedName("q")
   void method6022() {
      this.head = this.hashTable.buckets[0].previous;
      this.index = 1;
      this.last = null;
   }

   public void remove() {
      if(this.last == null) {
         throw new IllegalStateException();
      } else {
         this.last.method3676();
         this.last = null;
      }
   }

   public Object next() {
      Node var1;
      if(this.hashTable.buckets[this.index - 1] != this.head) {
         var1 = this.head;
         this.head = var1.previous;
         this.last = var1;
         return var1;
      } else {
         do {
            if(this.index >= this.hashTable.size) {
               return null;
            }

            var1 = this.hashTable.buckets[this.index++].previous;
         } while(var1 == this.hashTable.buckets[this.index - 1]);

         this.head = var1.previous;
         this.last = var1;
         return var1;
      }
   }

   public boolean hasNext() {
      if(this.hashTable.buckets[this.index - 1] != this.head) {
         return true;
      } else {
         while(this.index < this.hashTable.size) {
            if(this.hashTable.buckets[this.index++].previous != this.hashTable.buckets[this.index - 1]) {
               this.head = this.hashTable.buckets[this.index - 1].previous;
               return true;
            }

            this.head = this.hashTable.buckets[this.index - 1];
         }

         return false;
      }
   }
}
