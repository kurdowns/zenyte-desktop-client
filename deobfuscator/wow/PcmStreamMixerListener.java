import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSPcmStreamMixerListener;

@ObfuscatedName("do")
public abstract class PcmStreamMixerListener extends Node implements RSPcmStreamMixerListener {

   @ObfuscatedName("x")
   int field1466;


   @ObfuscatedName("x")
   abstract void method2624();

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ldz;)I"
   )
   abstract int method2625();
}
