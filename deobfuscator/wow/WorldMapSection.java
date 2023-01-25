import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSWorldMapSection;

@ObfuscatedName("ay")
public interface WorldMapSection extends RSWorldMapSection {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Las;I)V",
      garbageValue = "1890497148"
   )
   void vmethod870(WorldMapArea var1);

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-65934716"
   )
   boolean vmethod871(int var1, int var2, int var3);

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1383343929"
   )
   boolean vmethod872(int var1, int var2);

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "1656767825"
   )
   int[] vmethod873(int var1, int var2, int var3);

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)Lhj;",
      garbageValue = "-226825052"
   )
   Coord vmethod890(int var1, int var2);

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lkb;I)V",
      garbageValue = "-1393433755"
   )
   void vmethod885(Buffer var1);
}
