import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hr")
public class class231 {

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)Liq;",
      garbageValue = "111"
   )
   public static InvDefinition method4218(int var0) {
      InvDefinition var1 = (InvDefinition)InvDefinition.InvDefinition_cached.method3432((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = InvDefinition.InvDefinition_archive.method4249(5, var0, (byte)-81);
         var1 = new InvDefinition();
         if(var2 != null) {
            var1.method4442(new Buffer(var2));
         }

         InvDefinition.InvDefinition_cached.method3438(var1, (long)var0);
         return var1;
      }
   }
}
