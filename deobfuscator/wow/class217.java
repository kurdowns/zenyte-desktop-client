import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
public class class217 {

   @ObfuscatedName("dd")
   static boolean mouseCam;


   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "717184533"
   )
   public static final synchronized long method4036() {
      long var0 = System.currentTimeMillis();
      if(var0 < class306.field3698) {
         class306.field3699 += class306.field3698 - var0;
      }

      class306.field3698 = var0;
      return var0 + class306.field3699;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-472194185"
   )
   static final byte[] method4035(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.method5575();
      int var3 = var1.method5580();
      if(var3 >= 0 && (AbstractArchive.field3143 == 0 || var3 <= AbstractArchive.field3143)) {
         if(var2 == 0) {
            byte[] var4 = new byte[var3];
            var1.method5648(var4, 0, var3);
            return var4;
         } else {
            int var6 = var1.method5580();
            if(var6 >= 0 && (AbstractArchive.field3143 == 0 || var6 <= AbstractArchive.field3143)) {
               byte[] var5 = new byte[var6];
               if(var2 == 1) {
                  BZip2Decompressor.method5859(var5, var6, var0, var3, 9);
               } else {
                  AbstractArchive.gzipDecompressor.method6630(var1, var5);
               }

               return var5;
            } else {
               throw new RuntimeException();
            }
         }
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("kg")
   @ObfuscatedSignature(
      signature = "(Lhe;II)Ljava/lang/String;",
      garbageValue = "1493859077"
   )
   static String method4037(Widget var0, int var1) {
      int var3 = ScriptEvent.method1283(var0);
      boolean var2 = (var3 >> var1 + 1 & 1) != 0;
      return !var2 && var0.onOp == null?null:(var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0?var0.actions[var1]:null);
   }
}
