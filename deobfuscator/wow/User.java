import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSUser;
import net.runelite.rs.api.RSUsername;

@ObfuscatedName("jd")
public class User implements Comparable, RSUser {

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lku;"
   )
   Username username;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lku;"
   )
   Username previousUsername;


   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)Lku;",
      garbageValue = "-1106641864"
   )
   public Username method5093() {
      return this.username;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1751830464"
   )
   public String method5108() {
      return this.username == null?"":this.username.method5263();
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1275191870"
   )
   public String method5095() {
      return this.previousUsername == null?"":this.previousUsername.method5263();
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Lku;Lku;S)V",
      garbageValue = "255"
   )
   void method5104(Username var1, Username var2) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.username = var1;
         this.previousUsername = var2;
      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(Ljd;I)I",
      garbageValue = "-1956183743"
   )
   public int vmethod5285(User var1) {
      return this.username.method5265(var1.username);
   }

   public RSUsername getRsName() {
      return this.username;
   }

   public RSUsername getRsPrevName() {
      return this.previousUsername;
   }

   public int compareTo(Object var1) {
      return this.vmethod5285((User)var1);
   }

   public String getName() {
      return this.getRsName().getName();
   }

   public String getPrevName() {
      RSUsername var1 = this.getRsPrevName();
      return var1 == null?null:var1.getName();
   }
}
