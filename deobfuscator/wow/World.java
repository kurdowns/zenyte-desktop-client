import java.util.EnumSet;
import net.runelite.api.WorldType;
import net.runelite.api.events.WorldListLoad;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSWorld;

@ObfuscatedName("ch")
public class World implements RSWorld {

   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1328454415
   )
   static int World_count = 0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 89189373
   )
   static int World_listCount = 0;
   @ObfuscatedName("z")
   static int[] World_sortOption2 = new int[]{1, 1, 1, 1};
   @ObfuscatedName("t")
   static int[] World_sortOption1 = new int[]{0, 1, 2, 3};
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1023289861
   )
   int id;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -522510299
   )
   int properties;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1229908449
   )
   int population;
   @ObfuscatedName("u")
   String host;
   @ObfuscatedName("h")
   String activity;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1299711201
   )
   int location;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -281997857
   )
   int index;


   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "14"
   )
   boolean method1900() {
      return (1 & this.properties) != 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1374980076"
   )
   boolean method1869() {
      return (2 & this.properties) != 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1915504932"
   )
   boolean method1870() {
      return (4 & this.properties) != 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "53"
   )
   boolean method1871() {
      return (8 & this.properties) != 0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "248561667"
   )
   boolean method1872() {
      return (536870912 & this.properties) != 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1399101886"
   )
   boolean method1873() {
      return (33554432 & this.properties) != 0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "20"
   )
   boolean method1879() {
      return (1073741824 & this.properties) != 0;
   }

   public int getMask() {
      return this.properties;
   }

   public void setMask(int var1) {
      this.properties = var1;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1"
   )
   public void playerCountChanged(int var1) {
      RSWorld[] var2 = WorldMapSection1.client.getWorldList();
      if(var2 != null && var2.length > 0 && this == var2[var2.length - 1]) {
         WorldListLoad var3 = new WorldListLoad(var2);
         WorldMapSection1.client.getCallbacks().post(WorldListLoad.class, var3);
      }

   }

   public EnumSet getTypes() {
      return WorldType.fromMask(this.getMask());
   }

   public void setTypes(EnumSet var1) {
      this.setMask(WorldType.toMask(var1));
   }

   public int getId() {
      return this.id;
   }

   public void setId(int var1) {
      this.id = var1;
   }

   public int getPlayerCount() {
      return this.population;
   }

   public void setPlayerCount(int var1) {
      this.population = var1;
   }

   public String getAddress() {
      return this.host;
   }

   public void setAddress(String var1) {
      this.host = var1;
   }

   public String getActivity() {
      return this.activity;
   }

   public void setActivity(String var1) {
      this.activity = var1;
   }

   public int getLocation() {
      return this.location;
   }

   public void setLocation(int var1) {
      this.location = var1;
   }

   public int getIndex() {
      return this.index;
   }

   public void setIndex(int var1) {
      this.index = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Liy;Liy;Liy;Liy;S)V",
      garbageValue = "-3755"
   )
   public static void method1908(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2, AbstractArchive var3) {
      Widget.Widget_archive = var0;
      SoundSystem.Widget_modelsArchive = var1;
      Varps.Widget_spritesArchive = var2;
      Widget.Widget_fontsArchive = var3;
      Widget.Widget_interfaceComponents = new Widget[Widget.Widget_archive.method4260()][];
      Widget.Widget_loadedInterfaces = new boolean[Widget.Widget_archive.method4260()];
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "34"
   )
   public static boolean method1907(char var0) {
      return var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }

   @ObfuscatedName("ht")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1848249905"
   )
   static final void method1898(int var0, int var1) {
      NodeDeque var2 = Client.groundItems[ScriptEvent.Client_plane][var0][var1];
      if(var2 == null) {
         GrandExchangeOfferWorldComparator.scene.method3198(ScriptEvent.Client_plane, var0, var1);
      } else {
         long var3 = -99999999L;
         TileItem var5 = null;

         TileItem var6;
         for(var6 = (TileItem)var2.method4956(); var6 != null; var6 = (TileItem)var2.method4974()) {
            ItemDefinition var7 = AbstractWorldMapData.method373(var6.id);
            long var8 = (long)var7.price;
            if(var7.isStackable == 1) {
               var8 *= (long)(var6.quantity + 1);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(var5 == null) {
            GrandExchangeOfferWorldComparator.scene.method3198(ScriptEvent.Client_plane, var0, var1);
         } else {
            var2.method4952(var5);
            TileItem var12 = null;
            TileItem var11 = null;

            for(var6 = (TileItem)var2.method4956(); var6 != null; var6 = (TileItem)var2.method4974()) {
               if(var6.id != var5.id) {
                  if(var12 == null) {
                     var12 = var6;
                  }

                  if(var12.id != var6.id && var11 == null) {
                     var11 = var6;
                  }
               }
            }

            long var9 = IsaacCipher.method6377(var0, var1, 3, false, 0);
            GrandExchangeOfferWorldComparator.scene.method3184(ScriptEvent.Client_plane, var0, var1, class277.method5038(var0 * 128 + 64, var1 * 128 + 64, ScriptEvent.Client_plane), var5, var9, var12, var11);
         }
      }
   }
}
