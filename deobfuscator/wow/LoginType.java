import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSLoginType;

@ObfuscatedName("mx")
public class LoginType implements RSLoginType {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lmx;"
   )
   public static final LoginType oldscape = new LoginType(8, 0, "", "");
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lmx;"
   )
   static final LoginType field4049 = new LoginType(3, 1, "", "");
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lmx;"
   )
   static final LoginType field4051 = new LoginType(4, 2, "", "");
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lmx;"
   )
   static final LoginType field4052 = new LoginType(5, 3, "", "");
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lmx;"
   )
   static final LoginType field4057 = new LoginType(0, 4, "", "");
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lmx;"
   )
   static final LoginType field4059 = new LoginType(7, 5, "", "");
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lmx;"
   )
   static final LoginType field4055 = new LoginType(6, 6, "", "");
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lmx;"
   )
   static final LoginType field4056 = new LoginType(2, 7, "", "");
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lmx;"
   )
   public static final LoginType field4054 = new LoginType(1, -1, "", "", true, new LoginType[]{oldscape, field4049, field4051, field4057, field4052});
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 838731047
   )
   final int field4058;
   @ObfuscatedName("s")
   final String field4053;


   LoginType(int var1, int var2, String var3, String var4) {
      this.field4058 = var1;
      this.field4053 = var4;
   }

   @ObfuscatedSignature(
      signature = "(IILjava/lang/String;Ljava/lang/String;Z[Lmx;)V"
   )
   LoginType(int var1, int var2, String var3, String var4, boolean var5, LoginType[] var6) {
      this.field4058 = var1;
      this.field4053 = var4;
   }

   public String toString() {
      return this.field4053;
   }
}
