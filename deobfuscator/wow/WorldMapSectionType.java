import net.runelite.api.events.WidgetLoaded;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSWidget;
import net.runelite.rs.api.RSWorldMapSectionType;

@ObfuscatedName("ap")
public class WorldMapSectionType implements Enumerated, RSWorldMapSectionType {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lap;"
   )
   static final WorldMapSectionType WORLDMAPSECTIONTYPE0 = new WorldMapSectionType(3, (byte)0);
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lap;"
   )
   static final WorldMapSectionType WORLDMAPSECTIONTYPE1 = new WorldMapSectionType(2, (byte)1);
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lap;"
   )
   static final WorldMapSectionType WORLDMAPSECTIONTYPE2 = new WorldMapSectionType(0, (byte)2);
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lap;"
   )
   static final WorldMapSectionType WORLDMAPSECTIONTYPE3 = new WorldMapSectionType(1, (byte)3);
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -27254411
   )
   final int type;
   @ObfuscatedName("v")
   final byte id;


   WorldMapSectionType(int var1, byte var2) {
      this.type = var1;
      this.id = var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "56"
   )
   public int vmethod6189() {
      return this.id;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)[Lap;",
      garbageValue = "-1086432793"
   )
   static WorldMapSectionType[] method345() {
      return new WorldMapSectionType[]{WORLDMAPSECTIONTYPE0, WORLDMAPSECTIONTYPE1, WORLDMAPSECTIONTYPE2, WORLDMAPSECTIONTYPE3};
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1841927686"
   )
   static void method346(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(World.World_sortOption1[var5] != var0) {
            var2[var4] = World.World_sortOption1[var5];
            var3[var4] = World.World_sortOption2[var5];
            ++var4;
         }
      }

      World.World_sortOption1 = var2;
      World.World_sortOption2 = var3;
      UserComparator9.method3498(UserComparator2.World_worlds, 0, UserComparator2.World_worlds.length - 1, World.World_sortOption1, World.World_sortOption2);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1148353199"
   )
   public static int method347(int var0) {
      return UserComparator9.method3501(ViewportMouse.ViewportMouse_entityTags[var0]);
   }

   @ObfuscatedName("aj")
   static void method349(int var0, int var1) {
      Client.copy$runWidgetOnLoadListener(var0, var1);
      RSWidget[][] var2 = WorldMapSection1.client.getWidgets();
      boolean var3 = var2 != null && var2[var0] != null;
      if(var3) {
         WidgetLoaded var4 = new WidgetLoaded();
         var4.setGroupId(var0);
         WorldMapSection1.client.getCallbacks().post(WidgetLoaded.class, var4);
      }

   }

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "(Lbw;B)V",
      garbageValue = "80"
   )
   static final void method348(PendingSpawn var0) {
      long var1 = 0L;
      int var3 = -1;
      int var4 = 0;
      int var5 = 0;
      if(var0.type == 0) {
         var1 = GrandExchangeOfferWorldComparator.scene.method3203(var0.plane, var0.x, var0.y);
      }

      if(var0.type == 1) {
         var1 = GrandExchangeOfferWorldComparator.scene.method3204(var0.plane, var0.x, var0.y);
      }

      if(var0.type == 2) {
         var1 = GrandExchangeOfferWorldComparator.scene.method3205(var0.plane, var0.x, var0.y);
      }

      if(var0.type == 3) {
         var1 = GrandExchangeOfferWorldComparator.scene.method3323(var0.plane, var0.x, var0.y);
      }

      if(var1 != 0L) {
         int var6 = GrandExchangeOfferWorldComparator.scene.method3207(var0.plane, var0.x, var0.y, var1);
         var3 = WorldMapRectangle.method387(var1);
         var4 = var6 & 31;
         var5 = var6 >> 6 & 3;
      }

      var0.objectId = var3;
      var0.field963 = var4;
      var0.field968 = var5;
   }

   @ObfuscatedName("kw")
   @ObfuscatedSignature(
      signature = "(Lhe;B)Z",
      garbageValue = "47"
   )
   static final boolean method344(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.logoutTimer = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.playerAppearance.method4089(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.playerAppearance.method4090(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.playerAppearance.method4091(false);
         }

         if(var1 == 325) {
            Client.playerAppearance.method4091(true);
         }

         if(var1 == 326) {
            PacketBufferNode var4 = FaceNormal.method3377(ClientPacket.field2239, Client.packetWriter.isaacCipher);
            Client.playerAppearance.method4092(var4.packetBuffer);
            Client.packetWriter.method2375(var4);
            return true;
         } else {
            return false;
         }
      }
   }
}
