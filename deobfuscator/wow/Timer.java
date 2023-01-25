import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSTimer;

@ObfuscatedName("jr")
public class Timer implements RSTimer {

   @ObfuscatedName("pc")
   static boolean ClanChat_inClanChat;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = -8528403584903631725L
   )
   long field3585 = -1L;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 882289502926238735L
   )
   long field3577 = -1L;
   @ObfuscatedName("k")
   public boolean field3581 = false;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = -5644251787443381573L
   )
   long field3579 = 0L;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = -4670592391922777709L
   )
   long field3580 = 0L;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = 5855944608867181493L
   )
   long field3576 = 0L;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1581851235
   )
   int field3578 = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1287309283
   )
   int field3583 = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2047115993
   )
   int field3584 = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -763716735
   )
   int field3586 = 0;


   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2076802679"
   )
   public void method5052() {
      this.field3585 = class217.method4036();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1352651256"
   )
   public void method5051() {
      if(this.field3585 != -1L) {
         this.field3580 = class217.method4036() - this.field3585;
         this.field3585 = -1L;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-21"
   )
   public void method5045(int var1) {
      this.field3577 = class217.method4036();
      this.field3578 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-529025809"
   )
   public void method5046() {
      if(-1L != this.field3577) {
         this.field3579 = class217.method4036() - this.field3577;
         this.field3577 = -1L;
      }

      ++this.field3584;
      this.field3581 = true;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-93976035"
   )
   public void method5047() {
      this.field3581 = false;
      this.field3583 = 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1352132310"
   )
   public void method5048() {
      this.method5046();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lkb;I)V",
      garbageValue = "1742077322"
   )
   public void method5049(Buffer var1) {
      long var2 = this.field3580;
      var2 /= 10L;
      if(var2 < 0L) {
         var2 = 0L;
      } else if(var2 > 65535L) {
         var2 = 65535L;
      }

      var1.method5560((int)var2);
      long var4 = this.field3579;
      var4 /= 10L;
      if(var4 < 0L) {
         var4 = 0L;
      } else if(var4 > 65535L) {
         var4 = 65535L;
      }

      var1.method5560((int)var4);
      long var6 = this.field3576;
      var6 /= 10L;
      if(var6 < 0L) {
         var6 = 0L;
      } else if(var6 > 65535L) {
         var6 = 65535L;
      }

      var1.method5560((int)var6);
      var1.method5560(this.field3578);
      var1.method5560(this.field3583);
      var1.method5560(this.field3584);
      var1.method5560(this.field3586);
   }
}
