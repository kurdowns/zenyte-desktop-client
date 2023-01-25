import net.runelite.mapping.ObfuscatedName;
import net.runelite.rs.api.RSObjectNode;

@ObfuscatedName("gw")
public class ObjectNode extends Node implements RSObjectNode {

   @ObfuscatedName("x")
   public final Object obj;


   public ObjectNode(Object var1) {
      this.obj = var1;
   }
}
