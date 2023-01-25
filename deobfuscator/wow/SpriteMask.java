import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSSpriteMask;

@ObfuscatedName("hg")
public class SpriteMask extends DualNode implements RSSpriteMask {

   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1355900291
   )
   public final int width;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1444758519
   )
   public final int height;
   @ObfuscatedName("k")
   public final int[] xWidths;
   @ObfuscatedName("d")
   public final int[] xStarts;


   SpriteMask(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.width = var1;
      this.height = var2;
      this.xWidths = var3;
      this.xStarts = var4;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-822552656"
   )
   public boolean method4059(int var1, int var2) {
      if(var2 >= 0 && var2 < this.xStarts.length) {
         int var3 = this.xStarts[var2];
         if(var1 >= var3 && var1 <= var3 + this.xWidths[var2]) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IS)Liu;",
      garbageValue = "14194"
   )
   public static VarbitDefinition method4062(int var0) {
      VarbitDefinition var1 = (VarbitDefinition)VarbitDefinition.VarbitDefinition_cached.method3432((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = VarbitDefinition.VarbitDefinition_archive.method4249(14, var0, (byte)-127);
         var1 = new VarbitDefinition();
         if(var2 != null) {
            var1.method4561(new Buffer(var2));
         }

         VarbitDefinition.VarbitDefinition_cached.method3438(var1, (long)var0);
         return var1;
      }
   }
}
