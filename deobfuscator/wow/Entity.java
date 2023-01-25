import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSEntity;
import net.runelite.rs.api.RSModel;

@ObfuscatedName("ee")
public abstract class Entity extends DualNode implements RSEntity {

   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = 566997565
   )
   public int height = 1000;


   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Lel;"
   )
   protected Model vmethod3367(int var1) {
      return null;
   }

   public RSModel getModel() {
      return this.vmethod3367(480835067);
   }

   public int getModelHeight() {
      return this.height;
   }

   public void setModelHeight(int var1) {
      this.height = var1;
   }

   public void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9) {
      this.vmethod3365(var1, var2, var3, var4, var5, var6, var7, var8, var9);
   }

   @ObfuscatedName("cq")
   void vmethod3365(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9) {
      Model var11 = this.vmethod3367(-2064792762);
      if(var11 != null) {
         this.height = var11.height;
         var11.vmethod3365(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1030899417"
   )
   public static boolean method3374(int var0) {
      return var0 >= WorldMapDecorationType.field2719.id && var0 <= WorldMapDecorationType.field2739.id;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BILjava/lang/CharSequence;I)I",
      garbageValue = "-304633818"
   )
   public static int method3372(byte[] var0, int var1, CharSequence var2) {
      int var3 = var2.length();
      int var4 = var1;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var2.charAt(var5);
         if(var6 <= 127) {
            var0[var4++] = (byte)var6;
         } else if(var6 <= 2047) {
            var0[var4++] = (byte)(192 | var6 >> 6);
            var0[var4++] = (byte)(128 | var6 & 63);
         } else {
            var0[var4++] = (byte)(224 | var6 >> 12);
            var0[var4++] = (byte)(128 | var6 >> 6 & 63);
            var0[var4++] = (byte)(128 | var6 & 63);
         }
      }

      return var4 - var1;
   }
}
