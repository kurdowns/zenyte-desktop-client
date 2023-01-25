import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSPendingSpawn;

@ObfuscatedName("bw")
public final class PendingSpawn extends Node implements RSPendingSpawn {

   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1216764751
   )
   int y;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1571459421
   )
   int plane;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1864356937
   )
   int type;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1344797441
   )
   int x;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1245486001
   )
   int objectId;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -547933481
   )
   int field968;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1800022501
   )
   int field963;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1336190783
   )
   int id;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1244443099
   )
   int orientation;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -668527737
   )
   int field967;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -297028933
   )
   int delay = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 718779675
   )
   int hitpoints = -1;


   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-42"
   )
   static void method1840() {
      WorldMapRegion.WorldMapRegion_cachedSprites.method3472();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Lby;",
      garbageValue = "755627010"
   )
   static Message method1839(int var0) {
      return (Message)Messages.Messages_hashTable.method6003((long)var0);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "287596023"
   )
   public static void method1838() {
      ObjectDefinition.ObjectDefinition_cached.method3427();
      ObjectDefinition.ObjectDefinition_cachedModelData.method3427();
      ObjectDefinition.ObjectDefinition_cachedEntities.method3427();
      ObjectDefinition.ObjectDefinition_cachedModels.method3427();
   }
}
