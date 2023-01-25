import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSGameBuild;

@ObfuscatedName("ii")
public class GameBuild implements RSGameBuild {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   static final GameBuild LIVE = new GameBuild("LIVE", 0);
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   static final GameBuild BUILDLIVE = new GameBuild("BUILDLIVE", 3);
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   static final GameBuild RC = new GameBuild("RC", 1);
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   static final GameBuild WIP = new GameBuild("WIP", 2);
   @ObfuscatedName("w")
   public final String name;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1808149537
   )
   final int buildId;


   GameBuild(String var1, int var2) {
      this.name = var1;
      this.buildId = var2;
   }
}
