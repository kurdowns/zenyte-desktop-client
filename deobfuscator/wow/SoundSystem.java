import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSSoundSystem;

@ObfuscatedName("dh")
public class SoundSystem implements Runnable, RSSoundSystem {

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   static AbstractArchive Widget_modelsArchive;
   @ObfuscatedName("ij")
   @ObfuscatedGetter(
      intValue = -1992828169
   )
   static int oculusOrbFocalPointX;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "[Ldw;"
   )
   volatile PcmPlayer[] players = new PcmPlayer[2];


   public void run() {
      try {
         for(int var1 = 0; var1 < 2; ++var1) {
            PcmPlayer var2 = this.players[var1];
            if(var2 != null) {
               var2.method2536();
            }
         }
      } catch (Exception var4) {
         WorldMapDecorationType.method4214((String)null, var4);
      }

   }
}
