import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import net.runelite.api.Point;
import net.runelite.api.WorldMapData;
import net.runelite.api.coords.WorldPoint;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSWorldMap;
import net.runelite.rs.api.RSWorldMapArea;
import net.runelite.rs.api.RSWorldMapManager;

@ObfuscatedName("ml")
public class WorldMap implements RSWorldMap {

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lka;"
   )
   static final FontName fontNameVerdana11 = FontName.FontName_verdana11;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lka;"
   )
   static final FontName fontNameVerdana13 = FontName.FontName_verdana13;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lka;"
   )
   static final FontName fontNameVerdana15 = FontName.FontName_verdana15;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   AbstractArchive WorldMap_archive;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   AbstractArchive WorldMap_geographyArchive;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   AbstractArchive WorldMap_groundArchive;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lkx;"
   )
   Font font;
   @ObfuscatedName("u")
   HashMap fonts;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "[Lle;"
   )
   IndexedSprite[] mapSceneSprites;
   @ObfuscatedName("g")
   HashMap details;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Las;"
   )
   WorldMapArea mainMapArea;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Las;"
   )
   WorldMapArea currentMapArea;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Las;"
   )
   WorldMapArea field3984;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Laj;"
   )
   WorldMapManager worldMapManager;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lmi;"
   )
   WorldMapArchiveLoader cacheLoader;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1156713059
   )
   int centerTileX;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1112780801
   )
   int centerTileY;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1961416767
   )
   int worldMapTargetX = -1;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 291588009
   )
   int worldMapTargetY = -1;
   @ObfuscatedName("f")
   float zoom;
   @ObfuscatedName("ae")
   float zoomTarget;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 2108230877
   )
   int worldMapDisplayWidth = -1;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 835636901
   )
   int worldMapDisplayHeight = -1;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 982152301
   )
   int worldMapDisplayX = -1;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 2052237249
   )
   int worldMapDisplayY = -1;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1593055275
   )
   int maxFlashCount = 3;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1055110607
   )
   int cyclesPerFlash = 50;
   @ObfuscatedName("at")
   boolean perpetualFlash = false;
   @ObfuscatedName("al")
   HashSet flashingElements = null;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1658498297
   )
   int flashCount = -1;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -818253269
   )
   int flashCycle = -1;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 2062517591
   )
   int field4003 = -1;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -582417353
   )
   int field4004 = -1;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1399744773
   )
   int field3970 = -1;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1747511571
   )
   int field4022 = -1;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      longValue = -7492465693749449203L
   )
   long field4007;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1948821495
   )
   int field4008;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 785384757
   )
   int field4023;
   @ObfuscatedName("az")
   boolean field3993 = true;
   @ObfuscatedName("ad")
   HashSet enabledElements = new HashSet();
   @ObfuscatedName("ac")
   HashSet enabledCategories = new HashSet();
   @ObfuscatedName("ah")
   HashSet enabledElementIds = new HashSet();
   @ObfuscatedName("ag")
   HashSet field3997 = new HashSet();
   @ObfuscatedName("aw")
   boolean elementsDisabled = false;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = -754982927
   )
   int field4016 = 0;
   @ObfuscatedName("bo")
   final int[] menuOpcodes = new int[]{1008, 1009, 1010, 1011, 1012};
   @ObfuscatedName("bd")
   List field4018;
   @ObfuscatedName("bk")
   Iterator iconIterator;
   @ObfuscatedName("bu")
   HashSet field4019 = new HashSet();
   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   Coord mouseCoord = null;
   @ObfuscatedName("bg")
   public boolean showCoord = false;
   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "Lla;"
   )
   Sprite sprite;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -1704097389
   )
   int cachedPixelsPerTile;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -1222435813
   )
   int minCachedTileX = -1;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 1773937531
   )
   int minCachedTileY = -1;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 1017317495
   )
   int field3999 = -1;


   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Liy;Liy;Liy;Lkx;Ljava/util/HashMap;[Lle;I)V",
      garbageValue = "-1632082744"
   )
   public void method6420(AbstractArchive var1, AbstractArchive var2, AbstractArchive var3, Font var4, HashMap var5, IndexedSprite[] var6) {
      this.mapSceneSprites = var6;
      this.WorldMap_archive = var1;
      this.WorldMap_geographyArchive = var2;
      this.WorldMap_groundArchive = var3;
      this.font = var4;
      this.fonts = new HashMap();
      this.fonts.put(WorldMapLabelSize.WorldMapLabelSize_small, var5.get(fontNameVerdana11));
      this.fonts.put(WorldMapLabelSize.WorldMapLabelSize_medium, var5.get(fontNameVerdana13));
      this.fonts.put(WorldMapLabelSize.WorldMapLabelSize_large, var5.get(fontNameVerdana15));
      this.cacheLoader = new WorldMapArchiveLoader(var1);
      int var7 = this.WorldMap_archive.method4265(WorldMapCacheName.field339.name);
      int[] var8 = this.WorldMap_archive.method4259(var7);
      this.details = new HashMap(var8.length);

      for(int var9 = 0; var9 < var8.length; ++var9) {
         Buffer var10 = new Buffer(this.WorldMap_archive.method4249(var7, var8[var9], (byte)-88));
         WorldMapArea var11 = new WorldMapArea();
         var11.method471(var10, var8[var9]);
         this.details.put(var11.method449(), var11);
         if(var11.method458()) {
            this.mainMapArea = var11;
         }
      }

      this.method6431(this.mainMapArea);
      this.field3984 = null;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "902859893"
   )
   public void method6512() {
      WorldMapRegion.WorldMapRegion_cachedSprites.method3461(5);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIZIIIII)V",
      garbageValue = "-1392973406"
   )
   public void method6422(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
      if(this.cacheLoader.method6407()) {
         this.method6425();
         this.method6426();
         if(var3) {
            int var8 = (int)Math.ceil((double)((float)var6 / this.zoom));
            int var9 = (int)Math.ceil((double)((float)var7 / this.zoom));
            List var10 = this.worldMapManager.method722(this.centerTileX - var8 / 2 - 1, this.centerTileY - var9 / 2 - 1, var8 / 2 + this.centerTileX + 1, var9 / 2 + this.centerTileY + 1, var4, var5, var6, var7, var1, var2);
            HashSet var11 = new HashSet();

            Iterator var12;
            AbstractWorldMapIcon var13;
            ScriptEvent var14;
            WorldMapEvent var15;
            for(var12 = var10.iterator(); var12.hasNext(); GrandExchangeOfferOwnWorldComparator.method1395(var14)) {
               var13 = (AbstractWorldMapIcon)var12.next();
               var11.add(var13);
               var14 = new ScriptEvent();
               var15 = new WorldMapEvent(var13.vmethod685(), var13.coord1, var13.coord2);
               var14.method1284(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
               if(this.field4019.contains(var13)) {
                  var14.method1282(17);
               } else {
                  var14.method1282(15);
               }
            }

            var12 = this.field4019.iterator();

            while(var12.hasNext()) {
               var13 = (AbstractWorldMapIcon)var12.next();
               if(!var11.contains(var13)) {
                  var14 = new ScriptEvent();
                  var15 = new WorldMapEvent(var13.vmethod685(), var13.coord1, var13.coord2);
                  var14.method1284(new Object[]{var15, Integer.valueOf(var1), Integer.valueOf(var2)});
                  var14.method1282(16);
                  GrandExchangeOfferOwnWorldComparator.method1395(var14);
               }
            }

            this.field4019 = var11;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIZZI)V",
      garbageValue = "2122785833"
   )
   public void method6423(int var1, int var2, boolean var3, boolean var4) {
      long var5 = class217.method4036();
      this.method6490(var1, var2, var4, var5);
      if(!this.method6607() && (var4 || var3)) {
         if(var4) {
            this.field3970 = var1;
            this.field4022 = var2;
            this.field4003 = this.centerTileX;
            this.field4004 = this.centerTileY;
         }

         if(this.field4003 != -1) {
            int var7 = var1 - this.field3970;
            int var8 = var2 - this.field4022;
            this.method6427(this.field4003 - (int)((float)var7 / this.zoomTarget), (int)((float)var8 / this.zoomTarget) + this.field4004, false);
         }
      } else {
         this.method6428();
      }

      if(var4) {
         this.field4007 = var5;
         this.field4008 = var1;
         this.field4023 = var2;
      }

   }

   @ObfuscatedName("w")
   void method6490(int var1, int var2, boolean var3, long var4) {
      if(this.currentMapArea != null) {
         int var6 = (int)((float)this.centerTileX + ((float)(var1 - this.worldMapDisplayX) - (float)this.method6455() * this.zoom / 2.0F) / this.zoom);
         int var7 = (int)((float)this.centerTileY - ((float)(var2 - this.worldMapDisplayY) - (float)this.method6456() * this.zoom / 2.0F) / this.zoom);
         this.mouseCoord = this.currentMapArea.method456(var6 + this.currentMapArea.method453() * 64, var7 + this.currentMapArea.method439() * 64);
         if(this.mouseCoord != null && var3) {
            if(FaceNormal.method3379() && KeyHandler.KeyHandler_pressedKeys[82] && KeyHandler.KeyHandler_pressedKeys[81]) {
               GrandExchangeOfferWorldComparator.method148(this.mouseCoord.x, this.mouseCoord.y, this.mouseCoord.plane, false);
            } else {
               boolean var8 = true;
               if(this.field3993) {
                  int var9 = var1 - this.field4008;
                  int var10 = var2 - this.field4023;
                  if(var4 - this.field4007 > 500L || var9 < -25 || var9 > 25 || var10 < -25 || var10 > 25) {
                     var8 = false;
                  }
               }

               if(var8) {
                  PacketBufferNode var11 = FaceNormal.method3377(ClientPacket.field2260, Client.packetWriter.isaacCipher);
                  var11.packetBuffer.method5717(this.mouseCoord.method4065());
                  Client.packetWriter.method2375(var11);
                  this.field4007 = 0L;
               }
            }
         }
      } else {
         this.mouseCoord = null;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "22"
   )
   void method6425() {
      if(WorldMapRectangle.field222 != null) {
         this.zoom = this.zoomTarget;
      } else {
         if(this.zoom < this.zoomTarget) {
            this.zoom = Math.min(this.zoomTarget, this.zoom / 30.0F + this.zoom);
         }

         if(this.zoom > this.zoomTarget) {
            this.zoom = Math.max(this.zoomTarget, this.zoom - this.zoom / 30.0F);
         }

      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "819469805"
   )
   void method6426() {
      if(this.method6607()) {
         int var1 = this.worldMapTargetX - this.centerTileX;
         int var2 = this.worldMapTargetY - this.centerTileY;
         if(var1 != 0) {
            var1 /= Math.min(8, Math.abs(var1));
         }

         if(var2 != 0) {
            var2 /= Math.min(8, Math.abs(var2));
         }

         this.method6427(var1 + this.centerTileX, var2 + this.centerTileY, true);
         if(this.centerTileX == this.worldMapTargetX && this.centerTileY == this.worldMapTargetY) {
            this.worldMapTargetX = -1;
            this.worldMapTargetY = -1;
         }

      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "353769390"
   )
   final void method6427(int var1, int var2, boolean var3) {
      this.centerTileX = var1;
      this.centerTileY = var2;
      class217.method4036();
      if(var3) {
         this.method6428();
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "12"
   )
   final void method6428() {
      this.field4022 = -1;
      this.field3970 = -1;
      this.field4004 = -1;
      this.field4003 = -1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "408108894"
   )
   boolean method6607() {
      return this.worldMapTargetX != -1 && this.worldMapTargetY != -1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIII)Las;",
      garbageValue = "1872957167"
   )
   public WorldMapArea method6430(int var1, int var2, int var3) {
      Iterator var4 = this.details.values().iterator();

      WorldMapArea var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapArea)var4.next();
      } while(!var5.method468(var1, var2, var3));

      return var5;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "1519014469"
   )
   public void method6527(int var1, int var2, int var3, boolean var4) {
      WorldMapArea var5 = this.method6430(var1, var2, var3);
      if(var5 == null) {
         if(!var4) {
            return;
         }

         var5 = this.mainMapArea;
      }

      boolean var6 = false;
      if(var5 != this.field3984 || var4) {
         this.field3984 = var5;
         this.method6431(var5);
         var6 = true;
      }

      if(var6 || var4) {
         this.method6593(var1, var2, var3);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-513513568"
   )
   public void method6505(int var1) {
      WorldMapArea var2 = this.method6474(var1);
      if(var2 != null) {
         this.method6431(var2);
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "583895693"
   )
   public int method6433() {
      return this.currentMapArea == null?-1:this.currentMapArea.method441();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Las;",
      garbageValue = "683414686"
   )
   public WorldMapArea method6570() {
      return this.currentMapArea;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Las;B)V",
      garbageValue = "23"
   )
   void method6431(WorldMapArea var1) {
      if(this.currentMapArea == null || var1 != this.currentMapArea) {
         this.method6484(var1);
         this.method6593(-1, -1, -1);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Las;I)V",
      garbageValue = "-1810722368"
   )
   void method6484(WorldMapArea var1) {
      this.currentMapArea = var1;
      this.worldMapManager = new WorldMapManager(this.mapSceneSprites, this.fonts, this.WorldMap_geographyArchive, this.WorldMap_groundArchive);
      this.cacheLoader.method6406(this.currentMapArea.method449());
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Las;Lhj;Lhj;ZI)V",
      garbageValue = "698052085"
   )
   public void method6591(WorldMapArea var1, Coord var2, Coord var3, boolean var4) {
      if(var1 != null) {
         if(this.currentMapArea == null || var1 != this.currentMapArea) {
            this.method6484(var1);
         }

         if(!var4 && this.currentMapArea.method468(var2.plane, var2.x, var2.y)) {
            this.method6593(var2.plane, var2.x, var2.y);
         } else {
            this.method6593(var3.plane, var3.x, var3.y);
         }

      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "45"
   )
   void method6593(int var1, int var2, int var3) {
      if(this.currentMapArea != null) {
         int[] var4 = this.currentMapArea.method444(var1, var2, var3);
         if(var4 == null) {
            var4 = this.currentMapArea.method444(this.currentMapArea.method496(), this.currentMapArea.method457(), this.currentMapArea.method447());
         }

         this.method6427(var4[0] - this.currentMapArea.method453() * 64, var4[1] - this.currentMapArea.method439() * 64, true);
         this.worldMapTargetX = -1;
         this.worldMapTargetY = -1;
         this.zoom = this.method6444(this.currentMapArea.method452());
         this.zoomTarget = this.zoom;
         this.field4018 = null;
         this.iconIterator = null;
         this.worldMapManager.method733();
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "0"
   )
   public void method6472(int var1, int var2, int var3, int var4, int var5) {
      int[] var6 = new int[4];
      Rasterizer2D.method6087(var6);
      Rasterizer2D.method6085(var1, var2, var3 + var1, var2 + var4);
      Rasterizer2D.method6092(var1, var2, var3, var4, -16777216);
      int var7 = this.cacheLoader.method6409();
      if(var7 < 100) {
         this.method6443(var1, var2, var3, var4, var7);
      } else {
         if(!this.worldMapManager.method743()) {
            this.worldMapManager.method725(this.WorldMap_archive, this.currentMapArea.method449(), Client.isMembersWorld);
            if(!this.worldMapManager.method743()) {
               return;
            }
         }

         if(this.flashingElements != null) {
            ++this.flashCycle;
            if(this.flashCycle % this.cyclesPerFlash == 0) {
               this.flashCycle = 0;
               ++this.flashCount;
            }

            if(this.flashCount >= this.maxFlashCount && !this.perpetualFlash) {
               this.flashingElements = null;
            }
         }

         int var8 = (int)Math.ceil((double)((float)var3 / this.zoom));
         int var9 = (int)Math.ceil((double)((float)var4 / this.zoom));
         this.worldMapManager.method720(this.centerTileX - var8 / 2, this.centerTileY - var9 / 2, var8 / 2 + this.centerTileX, var9 / 2 + this.centerTileY, var1, var2, var3 + var1, var2 + var4);
         if(!this.elementsDisabled) {
            boolean var10 = false;
            if(var5 - this.field4016 > 100) {
               this.field4016 = var5;
               var10 = true;
            }

            this.worldMapManager.method721(this.centerTileX - var8 / 2, this.centerTileY - var9 / 2, var8 / 2 + this.centerTileX, var9 / 2 + this.centerTileY, var1, var2, var3 + var1, var2 + var4, this.field3997, this.flashingElements, this.flashCycle, this.cyclesPerFlash, var10);
         }

         this.method6429(var1, var2, var3, var4, var8, var9);
         if(FaceNormal.method3379() && this.showCoord && this.mouseCoord != null) {
            this.font.method5417("Coord: " + this.mouseCoord, Rasterizer2D.Rasterizer2D_xClipStart + 10, Rasterizer2D.Rasterizer2D_yClipStart + 20, 16776960, -1);
         }

         this.worldMapDisplayWidth = var8;
         this.worldMapDisplayHeight = var9;
         this.worldMapDisplayX = var1;
         this.worldMapDisplayY = var2;
         Rasterizer2D.method6088(var6);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIIIII)Z",
      garbageValue = "-1422166631"
   )
   boolean method6440(int var1, int var2, int var3, int var4, int var5, int var6) {
      return this.sprite == null?true:(this.sprite.subWidth == var1 && this.sprite.subHeight == var2?(this.worldMapManager.pixelsPerTile != this.cachedPixelsPerTile?true:(this.field3999 != Client.field891?true:(var3 <= 0 && var4 <= 0?var3 + var1 < var5 || var2 + var4 < var6:true))):true);
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "8"
   )
   void method6429(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(WorldMapRectangle.field222 != null) {
         int var7 = 512 / (this.worldMapManager.pixelsPerTile * 2);
         int var8 = var3 + 512;
         int var9 = var4 + 512;
         float var10 = 1.0F;
         var8 = (int)((float)var8 / var10);
         var9 = (int)((float)var9 / var10);
         int var11 = this.method6452() - var5 / 2 - var7;
         int var12 = this.method6448() - var6 / 2 - var7;
         int var13 = var1 - (var7 + var11 - this.minCachedTileX) * this.worldMapManager.pixelsPerTile;
         int var14 = var2 - this.worldMapManager.pixelsPerTile * (var7 - (var12 - this.minCachedTileY));
         if(this.method6440(var8, var9, var13, var14, var3, var4)) {
            if(this.sprite != null && this.sprite.subWidth == var8 && this.sprite.subHeight == var9) {
               Arrays.fill(this.sprite.pixels, 0);
            } else {
               this.sprite = new Sprite(var8, var9);
            }

            this.minCachedTileX = this.method6452() - var5 / 2 - var7;
            this.minCachedTileY = this.method6448() - var6 / 2 - var7;
            this.cachedPixelsPerTile = this.worldMapManager.pixelsPerTile;
            WorldMapRectangle.field222.method4408(this.minCachedTileX, this.minCachedTileY, this.sprite, (float)this.cachedPixelsPerTile / var10);
            this.field3999 = Client.field891;
            var13 = var1 - (var11 + var7 - this.minCachedTileX) * this.worldMapManager.pixelsPerTile;
            var14 = var2 - this.worldMapManager.pixelsPerTile * (var7 - (var12 - this.minCachedTileY));
         }

         Rasterizer2D.method6091(var1, var2, var3, var4, 0, 128);
         if(var10 == 1.0F) {
            this.sprite.method6237(var13, var14, 192);
         } else {
            this.sprite.method6271(var13, var14, (int)(var10 * (float)var8), (int)(var10 * (float)var9), 192);
         }
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-54"
   )
   public void method6441(int var1, int var2, int var3, int var4) {
      if(this.cacheLoader.method6407()) {
         if(!this.worldMapManager.method743()) {
            this.worldMapManager.method725(this.WorldMap_archive, this.currentMapArea.method449(), Client.isMembersWorld);
            if(!this.worldMapManager.method743()) {
               return;
            }
         }

         this.worldMapManager.method729(var1, var2, var3, var4, this.flashingElements, this.flashCycle, this.cyclesPerFlash);
      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1466740410"
   )
   public void method6442(int var1) {
      this.zoomTarget = this.method6444(var1);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "1603223574"
   )
   void method6443(int var1, int var2, int var3, int var4, int var5) {
      byte var6 = 20;
      int var7 = var3 / 2 + var1;
      int var8 = var4 / 2 + var2 - 18 - var6;
      Rasterizer2D.method6092(var1, var2, var3, var4, -16777216);
      Rasterizer2D.method6177(var7 - 152, var8, 304, 34, -65536);
      Rasterizer2D.method6092(var7 - 150, var8 + 2, var5 * 3, 30, -65536);
      this.font.method5420("Loading...", var7, var8 + var6, -1, -1);
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(II)F",
      garbageValue = "836995318"
   )
   float method6444(int var1) {
      return var1 == 25?1.0F:(var1 == 37?1.5F:(var1 == 50?2.0F:(var1 == 75?3.0F:(var1 == 100?4.0F:8.0F))));
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "600440321"
   )
   public int method6445() {
      return (double)this.zoomTarget == 1.0D?25:(1.5D == (double)this.zoomTarget?37:((double)this.zoomTarget == 2.0D?50:(3.0D == (double)this.zoomTarget?75:((double)this.zoomTarget == 4.0D?100:200))));
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-182915585"
   )
   public void method6446() {
      this.cacheLoader.method6410();
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1191452508"
   )
   public boolean method6447() {
      return this.cacheLoader.method6407();
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(II)Las;",
      garbageValue = "-982696781"
   )
   public WorldMapArea method6474(int var1) {
      Iterator var2 = this.details.values().iterator();

      WorldMapArea var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (WorldMapArea)var2.next();
      } while(var3.method441() != var1);

      return var3;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "441252120"
   )
   public void method6477(int var1, int var2) {
      if(this.currentMapArea != null && this.currentMapArea.method443(var1, var2)) {
         this.worldMapTargetX = var1 - this.currentMapArea.method453() * 64;
         this.worldMapTargetY = var2 - this.currentMapArea.method439() * 64;
      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "103"
   )
   public void method6498(int var1, int var2) {
      if(this.currentMapArea != null) {
         this.method6427(var1 - this.currentMapArea.method453() * 64, var2 - this.currentMapArea.method439() * 64, true);
         this.worldMapTargetX = -1;
         this.worldMapTargetY = -1;
      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "991204183"
   )
   public void method6450(int var1, int var2, int var3) {
      if(this.currentMapArea != null) {
         int[] var4 = this.currentMapArea.method444(var1, var2, var3);
         if(var4 != null) {
            this.method6477(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "0"
   )
   public void method6451(int var1, int var2, int var3) {
      if(this.currentMapArea != null) {
         int[] var4 = this.currentMapArea.method444(var1, var2, var3);
         if(var4 != null) {
            this.method6498(var4[0], var4[1]);
         }

      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-12"
   )
   public int method6452() {
      return this.currentMapArea == null?-1:this.centerTileX + this.currentMapArea.method453() * 64;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1454836009"
   )
   public int method6448() {
      return this.currentMapArea == null?-1:this.centerTileY + this.currentMapArea.method439() * 64;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(B)Lhj;",
      garbageValue = "-24"
   )
   public Coord method6454() {
      return this.currentMapArea == null?null:this.currentMapArea.method456(this.method6452(), this.method6448());
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-5"
   )
   public int method6455() {
      return this.worldMapDisplayWidth;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "484191109"
   )
   public int method6456() {
      return this.worldMapDisplayHeight;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-4"
   )
   public void method6457(int var1) {
      if(var1 >= 1) {
         this.maxFlashCount = var1;
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1765651870"
   )
   public void method6438() {
      this.maxFlashCount = 3;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-544500674"
   )
   public void method6622(int var1) {
      if(var1 >= 1) {
         this.cyclesPerFlash = var1;
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1325127509"
   )
   public void method6460() {
      this.cyclesPerFlash = 50;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "2030274031"
   )
   public void method6461(boolean var1) {
      this.perpetualFlash = var1;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-843738086"
   )
   public void method6462(int var1) {
      this.flashingElements = new HashSet();
      this.flashingElements.add(Integer.valueOf(var1));
      this.flashCount = 0;
      this.flashCycle = 0;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2123087925"
   )
   public void method6463(int var1) {
      this.flashingElements = new HashSet();
      this.flashCount = 0;
      this.flashCycle = 0;

      for(int var2 = 0; var2 < class277.WorldMapElement_count; ++var2) {
         if(class25.method279(var2) != null && class25.method279(var2).category == var1) {
            this.flashingElements.add(Integer.valueOf(class25.method279(var2).objectId));
         }
      }

   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2104531068"
   )
   public void method6458() {
      this.flashingElements = null;
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "560446249"
   )
   public void method6435(boolean var1) {
      this.elementsDisabled = !var1;
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-2066473112"
   )
   public void method6531(int var1, boolean var2) {
      if(!var2) {
         this.enabledElements.add(Integer.valueOf(var1));
      } else {
         this.enabledElements.remove(Integer.valueOf(var1));
      }

      this.method6514();
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "741156816"
   )
   public void method6464(int var1, boolean var2) {
      if(!var2) {
         this.enabledCategories.add(Integer.valueOf(var1));
      } else {
         this.enabledCategories.remove(Integer.valueOf(var1));
      }

      for(int var3 = 0; var3 < class277.WorldMapElement_count; ++var3) {
         if(class25.method279(var3) != null && class25.method279(var3).category == var1) {
            int var4 = class25.method279(var3).objectId;
            if(!var2) {
               this.enabledElementIds.add(Integer.valueOf(var4));
            } else {
               this.enabledElementIds.remove(Integer.valueOf(var4));
            }
         }
      }

      this.method6514();
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "149249835"
   )
   public boolean method6503() {
      return !this.elementsDisabled;
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1744055471"
   )
   public boolean method6469(int var1) {
      return !this.enabledElements.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "-18946"
   )
   public boolean method6470(int var1) {
      return !this.enabledCategories.contains(Integer.valueOf(var1));
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "105577872"
   )
   void method6514() {
      this.field3997.clear();
      this.field3997.addAll(this.enabledElements);
      this.field3997.addAll(this.enabledElementIds);
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "91"
   )
   public void method6466(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(this.cacheLoader.method6407()) {
         int var7 = (int)Math.ceil((double)((float)var3 / this.zoom));
         int var8 = (int)Math.ceil((double)((float)var4 / this.zoom));
         List var9 = this.worldMapManager.method722(this.centerTileX - var7 / 2 - 1, this.centerTileY - var8 / 2 - 1, var7 / 2 + this.centerTileX + 1, var8 / 2 + this.centerTileY + 1, var1, var2, var3, var4, var5, var6);
         if(!var9.isEmpty()) {
            Iterator var10 = var9.iterator();

            boolean var13;
            do {
               if(!var10.hasNext()) {
                  return;
               }

               AbstractWorldMapIcon var11 = (AbstractWorldMapIcon)var10.next();
               WorldMapElement var12 = class25.method279(var11.vmethod685());
               var13 = false;

               for(int var14 = this.menuOpcodes.length - 1; var14 >= 0; --var14) {
                  if(var12.menuActions[var14] != null) {
                     IgnoreList.method5136(var12.menuActions[var14], var12.menuTargetName, this.menuOpcodes[var14], var11.vmethod685(), var11.coord1.method4065(), var11.coord2.method4065());
                     var13 = true;
                  }
               }
            } while(!var13);

         }
      }
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(ILhj;B)Lhj;",
      garbageValue = "32"
   )
   public Coord method6473(int var1, Coord var2) {
      if(!this.cacheLoader.method6407()) {
         return null;
      } else if(!this.worldMapManager.method743()) {
         return null;
      } else if(!this.currentMapArea.method443(var2.x, var2.y)) {
         return null;
      } else {
         HashMap var3 = this.worldMapManager.method719();
         List var4 = (List)var3.get(Integer.valueOf(var1));
         if(var4 != null && !var4.isEmpty()) {
            AbstractWorldMapIcon var5 = null;
            int var6 = -1;
            Iterator var7 = var4.iterator();

            while(var7.hasNext()) {
               AbstractWorldMapIcon var8 = (AbstractWorldMapIcon)var7.next();
               int var9 = var8.coord2.x - var2.x;
               int var10 = var8.coord2.y - var2.y;
               int var11 = var9 * var9 + var10 * var10;
               if(var11 == 0) {
                  return var8.coord2;
               }

               if(var11 < var6 || var5 == null) {
                  var5 = var8;
                  var6 = var11;
               }
            }

            return var5.coord2;
         } else {
            return null;
         }
      }
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(IILhj;Lhj;B)V",
      garbageValue = "35"
   )
   public void method6508(int var1, int var2, Coord var3, Coord var4) {
      ScriptEvent var5 = new ScriptEvent();
      WorldMapEvent var6 = new WorldMapEvent(var2, var3, var4);
      var5.method1284(new Object[]{var6});
      switch(var1) {
      case 1008:
         var5.method1282(10);
         break;
      case 1009:
         var5.method1282(11);
         break;
      case 1010:
         var5.method1282(12);
         break;
      case 1011:
         var5.method1282(13);
         break;
      case 1012:
         var5.method1282(14);
      }

      GrandExchangeOfferOwnWorldComparator.method1395(var5);
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(I)Lax;",
      garbageValue = "-295029476"
   )
   public AbstractWorldMapIcon method6475() {
      if(!this.cacheLoader.method6407()) {
         return null;
      } else if(!this.worldMapManager.method743()) {
         return null;
      } else {
         HashMap var1 = this.worldMapManager.method719();
         this.field4018 = new LinkedList();
         Iterator var2 = var1.values().iterator();

         while(var2.hasNext()) {
            List var3 = (List)var2.next();
            this.field4018.addAll(var3);
         }

         this.iconIterator = this.field4018.iterator();
         return this.method6476();
      }
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(I)Lax;",
      garbageValue = "-528069180"
   )
   public AbstractWorldMapIcon method6476() {
      if(this.iconIterator == null) {
         return null;
      } else {
         AbstractWorldMapIcon var1;
         do {
            if(!this.iconIterator.hasNext()) {
               return null;
            }

            var1 = (AbstractWorldMapIcon)this.iconIterator.next();
         } while(var1.vmethod685() == -1);

         return var1;
      }
   }

   public RSWorldMapManager getWorldMapManager() {
      return this.worldMapManager;
   }

   public int getWorldMapX() {
      return this.centerTileX;
   }

   public void setWorldMapPositionTarget(int var1, int var2) {
      this.method6477(var1, var2);
   }

   public int getWorldMapY() {
      return this.centerTileY;
   }

   public Point getWorldMapPosition() {
      RSWorldMapManager var1 = this.getWorldMapManager();
      int var2 = this.getWorldMapX() + var1.getSurfaceOffsetX();
      int var3 = this.getWorldMapY() + var1.getSurfaceOffsetY();
      return new Point(var2, var3);
   }

   public void setWorldMapPositionTarget(WorldPoint var1) {
      this.setWorldMapPositionTarget(var1.getX(), var1.getY());
   }

   public int getWorldMapTargetX() {
      return this.worldMapTargetX;
   }

   public int getWorldMapTargetY() {
      return this.worldMapTargetY;
   }

   public float getWorldMapZoom() {
      return this.zoom;
   }

   public int getWorldMapDisplayWidth() {
      return this.worldMapDisplayWidth;
   }

   public int getWorldMapDisplayHeight() {
      return this.worldMapDisplayHeight;
   }

   public int getWorldMapDisplayX() {
      return this.worldMapDisplayX;
   }

   public int getWorldMapDisplayY() {
      return this.worldMapDisplayY;
   }

   public void setWorldMapPosition(int var1, int var2, boolean var3) {
      this.method6427(var1, var2, var3);
   }

   public RSWorldMapArea getWorldMapData() {
      return this.method6570();
   }

   public void initializeWorldMap(WorldMapData var1) {
      this.method6484((WorldMapArea)var1);
   }
}
