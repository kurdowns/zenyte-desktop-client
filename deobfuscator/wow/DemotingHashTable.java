import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSDemotingHashTable;

@ObfuscatedName("fl")
public final class DemotingHashTable implements RSDemotingHashTable {

   @ObfuscatedName("x")
   int capacity;
   @ObfuscatedName("m")
   int remaining;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lln;"
   )
   IterableNodeHashTable hashTable;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljz;"
   )
   IterableDualNodeQueue queue = new IterableDualNodeQueue();
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Les;"
   )
   class155 field1980;


   public DemotingHashTable(int var1, int var2) {
      this.capacity = var1;
      this.remaining = var1;

      int var3;
      for(var3 = 1; var3 + var3 < var1 && var3 < var2; var3 += var3) {
         ;
      }

      this.hashTable = new IterableNodeHashTable(var3);
   }

   @ObfuscatedName("x")
   public Object method3473(long var1) {
      Wrapper var3 = (Wrapper)this.hashTable.method6003(var1);
      if(var3 == null) {
         return null;
      } else {
         Object var4 = var3.vmethod3476();
         if(var4 == null) {
            var3.method3676();
            var3.method3672();
            this.remaining += var3.size;
            return null;
         } else {
            if(var3.vmethod3477()) {
               DirectWrapper var5 = new DirectWrapper(var4, var3.size);
               this.hashTable.method5998(var5, var3.key);
               this.queue.method5024(var5);
               var5.keyDual = 0L;
               var3.method3676();
               var3.method3672();
            } else {
               this.queue.method5024(var3);
               var3.keyDual = 0L;
            }

            return var4;
         }
      }
   }

   @ObfuscatedName("m")
   void method3458(long var1) {
      Wrapper var3 = (Wrapper)this.hashTable.method6003(var1);
      this.method3462(var3);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lfw;)V"
   )
   void method3462(Wrapper var1) {
      if(var1 != null) {
         var1.method3676();
         var1.method3672();
         this.remaining += var1.size;
      }

   }

   @ObfuscatedName("d")
   public void method3460(Object var1, long var2, int var4) {
      if(var4 > this.capacity) {
         throw new IllegalStateException();
      } else {
         this.method3458(var2);
         this.remaining -= var4;

         while(this.remaining < 0) {
            Wrapper var5 = (Wrapper)this.queue.method5018();
            if(var5 == null) {
               throw new RuntimeException("");
            }

            if(!var5.vmethod3477()) {
               ;
            }

            this.method3462(var5);
            if(this.field1980 != null) {
               this.field1980.method3443(var5.vmethod3476());
            }
         }

         DirectWrapper var6 = new DirectWrapper(var1, var4);
         this.hashTable.method5998(var6, var2);
         this.queue.method5024(var6);
         var6.keyDual = 0L;
      }
   }

   @ObfuscatedName("w")
   public void method3461(int var1) {
      for(Wrapper var2 = (Wrapper)this.queue.method5032(); var2 != null; var2 = (Wrapper)this.queue.method5021()) {
         if(var2.vmethod3477()) {
            if(var2.vmethod3476() == null) {
               var2.method3676();
               var2.method3672();
               this.remaining += var2.size;
            }
         } else if(++var2.keyDual > (long)var1) {
            SoftWrapper var3 = new SoftWrapper(var2.vmethod3476(), var2.size);
            this.hashTable.method5998(var3, var2.key);
            IterableDualNodeQueue.method5017(var3, var2);
            var2.method3676();
            var2.method3672();
         }
      }

   }

   @ObfuscatedName("v")
   public void method3472() {
      this.queue.method5035();
      this.hashTable.method5999();
      this.remaining = this.capacity;
   }
}
