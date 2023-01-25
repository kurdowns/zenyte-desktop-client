import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSNetFileRequest;

@ObfuscatedName("ix")
public class NetFileRequest extends DualNode implements RSNetFileRequest {

   @ObfuscatedName("re")
   @ObfuscatedGetter(
      intValue = 642121189
   )
   static int field3126;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   public Archive archive;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -782171773
   )
   public int crc;
   @ObfuscatedName("k")
   public byte padding;


   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)[Lje;",
      garbageValue = "534124687"
   )
   static HorizontalAlignment[] method4245() {
      return new HorizontalAlignment[]{HorizontalAlignment.HorizontalAlignment_centered, HorizontalAlignment.field3453, HorizontalAlignment.field3458};
   }
}
