import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSDirectByteArrayCopier;

@ObfuscatedName("hl")
public class DirectByteArrayCopier extends AbstractByteArrayCopier implements RSDirectByteArrayCopier {

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lla;"
   )
   static Sprite rightTitleSprite;
   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   static Archive archive1;
   @ObfuscatedName("x")
   ByteBuffer directBuffer;


   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1422436059"
   )
   byte[] vmethod4030() {
      byte[] var1 = new byte[this.directBuffer.capacity()];
      this.directBuffer.position(0);
      this.directBuffer.get(var1);
      return var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "0"
   )
   public void vmethod4028(byte[] var1) {
      this.directBuffer = ByteBuffer.allocateDirect(var1.length);
      this.directBuffer.position(0);
      this.directBuffer.put(var1);
   }
}
