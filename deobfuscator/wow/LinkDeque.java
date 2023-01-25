import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSLinkDeque;

@ObfuscatedName("jk")
public class LinkDeque implements RSLinkDeque {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   Link sentinel = new Link();
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   Link current;


   public LinkDeque() {
      this.sentinel.previous = this.sentinel;
      this.sentinel.next = this.sentinel;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lgt;)V"
   )
   public void method4985(Link var1) {
      if(var1.next != null) {
         var1.method3673();
      }

      var1.next = this.sentinel.next;
      var1.previous = this.sentinel;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "()Lgt;"
   )
   public Link method4990() {
      Link var1 = this.sentinel.previous;
      if(var1 == this.sentinel) {
         this.current = null;
         return null;
      } else {
         this.current = var1.previous;
         return var1;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "()Lgt;"
   )
   public Link method4986() {
      Link var1 = this.current;
      if(var1 == this.sentinel) {
         this.current = null;
         return null;
      } else {
         this.current = var1.previous;
         return var1;
      }
   }
}
