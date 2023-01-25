import net.runelite.mapping.ObfuscatedName;
import net.runelite.rs.api.RSWrapper;

@ObfuscatedName("fw")
public abstract class Wrapper extends DualNode implements RSWrapper {

   @ObfuscatedName("m")
   final int size;


   Wrapper(int var1) {
      this.size = var1;
   }

   @ObfuscatedName("x")
   abstract Object vmethod3476();

   @ObfuscatedName("m")
   abstract boolean vmethod3477();
}
