import java.util.zip.Inflater;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSGZipDecompressor;

@ObfuscatedName("mw")
public class GZipDecompressor implements RSGZipDecompressor {

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   public static AbstractArchive SequenceDefinition_animationsArchive;
   @ObfuscatedName("x")
   Inflater inflater;


   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1000000"
   )
   GZipDecompressor(int var1, int var2, int var3) {}

   public GZipDecompressor() {
      this(-1, 1000000, 1000000);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lkb;[BI)V",
      garbageValue = "-631538696"
   )
   public void method6630(Buffer var1, byte[] var2) {
      if(var1.array[var1.offset] == 31 && var1.array[var1.offset + 1] == -117) {
         if(this.inflater == null) {
            this.inflater = new Inflater(true);
         }

         try {
            this.inflater.setInput(var1.array, var1.offset + 10, var1.array.length - (var1.offset + 8 + 10));
            this.inflater.inflate(var2);
         } catch (Exception var4) {
            this.inflater.reset();
            throw new RuntimeException("");
         }

         this.inflater.reset();
      } else {
         throw new RuntimeException("");
      }
   }
}
