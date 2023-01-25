import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSPlayerProvider;

@ObfuscatedName("dg")
public interface PlayerProvider extends RSPlayerProvider {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Ldw;",
      garbageValue = "65536"
   )
   PcmPlayer vmethod2442();
}
