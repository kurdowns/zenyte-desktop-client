import java.applet.Applet;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.rs.api.RSRunException;

@ObfuscatedName("mf")
public class RunException extends RuntimeException implements RSRunException {

   @ObfuscatedName("x")
   public static Applet RunException_applet;
   @ObfuscatedName("m")
   public static String localPlayerName;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 858852849
   )
   public static int RunException_revision;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -834136847
   )
   public static int clientType;
   @ObfuscatedName("q")
   public static int[] ByteArrayPool_alternativeSizes;
   @ObfuscatedName("w")
   String message;
   @ObfuscatedName("v")
   Throwable throwable;


   RunException(Throwable var1, String var2) {
      this.message = var2;
      this.throwable = var1;
   }

   public Throwable getParent() {
      return this.throwable;
   }
}
