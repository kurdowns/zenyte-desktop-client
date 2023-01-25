import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSWorldMapDecoration;

@ObfuscatedName("al")
public class WorldMapDecoration implements RSWorldMapDecoration {

   @ObfuscatedName("no")
   @ObfuscatedGetter(
      intValue = -1289499225
   )
   static int field245;
   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "[Lle;"
   )
   static IndexedSprite[] worldSelectArrows;
   @ObfuscatedName("lt")
   @ObfuscatedGetter(
      intValue = 620715937
   )
   static int menuX;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -727730927
   )
   final int objectDefinitionId;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1283555483
   )
   final int decoration;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 983246099
   )
   final int rotation;


   WorldMapDecoration(int var1, int var2, int var3) {
      this.objectDefinitionId = var1;
      this.decoration = var2;
      this.rotation = var3;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Lch;",
      garbageValue = "-1617483479"
   )
   static World method437() {
      World.World_listCount = 0;
      return MouseHandler.method1184();
   }

   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "(IIB)Lgx;",
      garbageValue = "123"
   )
   static RouteStrategy method438(int var0, int var1) {
      Client.field954.approxDestinationX = var0;
      Client.field954.approxDestinationY = var1;
      Client.field954.approxDestinationSizeX = 1;
      Client.field954.approxDestinationSizeY = 1;
      return Client.field954;
   }

   @ObfuscatedName("kq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2146125679"
   )
   static final void method436() {
      PacketBufferNode var0 = FaceNormal.method3377(ClientPacket.field2236, Client.packetWriter.isaacCipher);
      var0.packetBuffer.method5559(0);
      Client.packetWriter.method2375(var0);
   }
}
