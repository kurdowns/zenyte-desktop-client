import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSHealthBar;
import net.runelite.rs.api.RSHealthBarDefinition;
import net.runelite.rs.api.RSIterableNodeDeque;

@ObfuscatedName("cg")
public class HealthBar extends Node implements RSHealthBar {

   @ObfuscatedName("rf")
   @ObfuscatedGetter(
      intValue = 1395604352
   )
   static int field1145;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   HealthBarDefinition definition;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   IterableNodeDeque updates = new IterableNodeDeque();


   @ObfuscatedSignature(
      signature = "(Lid;)V"
   )
   HealthBar(HealthBarDefinition var1) {
      this.definition = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "86"
   )
   void method2125(int var1, int var2, int var3, int var4) {
      HealthBarUpdate var5 = null;
      int var6 = 0;

      for(HealthBarUpdate var7 = (HealthBarUpdate)this.updates.method4885(); var7 != null; var7 = (HealthBarUpdate)this.updates.method4940()) {
         ++var6;
         if(var7.cycle == var1) {
            var7.method1862(var1, var2, var3, var4);
            return;
         }

         if(var7.cycle <= var1) {
            var5 = var7;
         }
      }

      if(var5 == null) {
         if(var6 < 4) {
            this.updates.method4905(new HealthBarUpdate(var1, var2, var3, var4));
         }

      } else {
         IterableNodeDeque.method4918(new HealthBarUpdate(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.updates.method4885().method3676();
         }

      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Lcc;",
      garbageValue = "1772939720"
   )
   HealthBarUpdate method2129(int var1) {
      HealthBarUpdate var2 = (HealthBarUpdate)this.updates.method4885();
      if(var2 != null && var2.cycle <= var1) {
         for(HealthBarUpdate var3 = (HealthBarUpdate)this.updates.method4940(); var3 != null && var3.cycle <= var1; var3 = (HealthBarUpdate)this.updates.method4940()) {
            var2.method3676();
            var2 = var3;
         }

         if(this.definition.int5 + var2.cycle + var2.cycleOffset > var1) {
            return var2;
         } else {
            var2.method3676();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1327552245"
   )
   boolean method2126() {
      return this.updates.method4892();
   }

   public RSHealthBarDefinition getDefinition() {
      return this.definition;
   }

   public RSIterableNodeDeque getUpdates() {
      return this.updates;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1544257049"
   )
   static void method2124() {
      Login.worldSelectOpen = false;
      Login.leftTitleSprite.method6225(Login.xPadding, 0);
      DirectByteArrayCopier.rightTitleSprite.method6225(Login.xPadding + 382, 0);
      class3.logoSprite.method6213(Login.xPadding + 382 - class3.logoSprite.subWidth / 2, 18);
   }
}
