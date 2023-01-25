import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSTask;

@ObfuscatedName("fr")
public class Task implements RSTask {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   Task next;
   @ObfuscatedName("w")
   public volatile int status = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -2125226355
   )
   int type;
   @ObfuscatedName("q")
   public int intArgument;
   @ObfuscatedName("z")
   Object objectArgument;
   @ObfuscatedName("t")
   public volatile Object result;


}
