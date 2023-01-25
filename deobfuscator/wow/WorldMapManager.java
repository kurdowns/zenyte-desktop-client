import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSWorldMapManager;

@ObfuscatedName("aj")
public final class WorldMapManager implements RSWorldMapManager {

   @ObfuscatedName("qd")
   @ObfuscatedSignature(
      signature = "Ldw;"
   )
   static PcmPlayer pcmPlayer0;
   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   static Task js5SocketTask;
   @ObfuscatedName("x")
   boolean loaded = false;
   @ObfuscatedName("m")
   boolean loadStarted = false;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lad;"
   )
   WorldMapAreaData mapAreaData;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lla;"
   )
   Sprite compositeTextureSprite;
   @ObfuscatedName("w")
   HashMap icons;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "[[Lao;"
   )
   WorldMapRegion[][] regions;
   @ObfuscatedName("q")
   HashMap scaleHandlers = new HashMap();
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "[Lle;"
   )
   IndexedSprite[] mapSceneSprites;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   final AbstractArchive geographyArchive;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   final AbstractArchive groundArchive;
   @ObfuscatedName("s")
   final HashMap fonts;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1968902592
   )
   int tileX;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2084338799
   )
   int tileY;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -504935744
   )
   int tileWidth;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 793863639
   )
   int tileHeight;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1333710855
   )
   public int pixelsPerTile = 0;


   @ObfuscatedSignature(
      signature = "([Lle;Ljava/util/HashMap;Liy;Liy;)V"
   )
   public WorldMapManager(IndexedSprite[] var1, HashMap var2, AbstractArchive var3, AbstractArchive var4) {
      this.mapSceneSprites = var1;
      this.fonts = var2;
      this.geographyArchive = var3;
      this.groundArchive = var4;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Liy;Ljava/lang/String;ZI)V",
      garbageValue = "1660505626"
   )
   public void method725(AbstractArchive var1, String var2, boolean var3) {
      if(!this.loadStarted) {
         this.loaded = false;
         this.loadStarted = true;
         System.nanoTime();
         int var4 = var1.method4265(WorldMapCacheName.field339.name);
         int var5 = var1.method4258(var4, var2);
         Buffer var6 = new Buffer(var1.method4248(WorldMapCacheName.field339.name, var2));
         Buffer var7 = new Buffer(var1.method4248(WorldMapCacheName.field340.name, var2));
         System.nanoTime();
         System.nanoTime();
         this.mapAreaData = new WorldMapAreaData();

         try {
            this.mapAreaData.method775(var6, var7, var5, var3);
         } catch (IllegalStateException var19) {
            return;
         }

         this.mapAreaData.method457();
         this.mapAreaData.method496();
         this.mapAreaData.method447();
         this.tileX = this.mapAreaData.method453() * 4096;
         this.tileY = this.mapAreaData.method439() * 64;
         this.tileWidth = (this.mapAreaData.method454() - this.mapAreaData.method453() + 1) * 4096;
         this.tileHeight = (this.mapAreaData.method442() - this.mapAreaData.method439() + 1) * 64;
         int var16 = this.mapAreaData.method454() - this.mapAreaData.method453() + 1;
         int var9 = this.mapAreaData.method442() - this.mapAreaData.method439() + 1;
         System.nanoTime();
         System.nanoTime();
         PendingSpawn.method1840();
         this.regions = new WorldMapRegion[var16][var9];
         Iterator var10 = this.mapAreaData.worldMapData0Set.iterator();

         while(var10.hasNext()) {
            WorldMapData_0 var11 = (WorldMapData_0)var10.next();
            int var12 = var11.regionX;
            int var13 = var11.regionY;
            int var14 = var12 - this.mapAreaData.method453();
            int var15 = var13 - this.mapAreaData.method439();
            this.regions[var14][var15] = new WorldMapRegion(var12, var13, this.mapAreaData.method451(), this.fonts);
            this.regions[var14][var15].method520(var11, this.mapAreaData.iconList);
         }

         for(int var17 = 0; var17 < var16; ++var17) {
            for(int var18 = 0; var18 < var9; ++var18) {
               if(this.regions[var17][var18] == null) {
                  this.regions[var17][var18] = new WorldMapRegion(this.mapAreaData.method453() + var17, this.mapAreaData.method439() + var18, this.mapAreaData.method451(), this.fonts);
                  this.regions[var17][var18].method561(this.mapAreaData.worldMapData1Set, this.mapAreaData.iconList);
               }
            }
         }

         System.nanoTime();
         System.nanoTime();
         if(var1.method4324(WorldMapCacheName.field341.name, var2)) {
            byte[] var20 = var1.method4248(WorldMapCacheName.field341.name, var2);
            this.compositeTextureSprite = class200.method3753(var20);
         }

         System.nanoTime();
         var1.method4261();
         var1.method4298();
         this.loaded = true;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2062651870"
   )
   public final void method733() {
      this.icons = null;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "8"
   )
   public final void method720(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int[] var9 = Rasterizer2D.Rasterizer2D_pixels;
      int var10 = Rasterizer2D.Rasterizer2D_width;
      int var11 = Rasterizer2D.Rasterizer2D_height;
      int[] var12 = new int[4];
      Rasterizer2D.method6087(var12);
      WorldMapRectangle var13 = this.method723(var1, var2, var3, var4);
      float var14 = this.method727(var7 - var5, var3 - var1);
      int var15 = (int)Math.ceil((double)var14);
      this.pixelsPerTile = var15;
      if(!this.scaleHandlers.containsKey(Integer.valueOf(var15))) {
         WorldMapScaleHandler var16 = new WorldMapScaleHandler(var15);
         var16.method821();
         this.scaleHandlers.put(Integer.valueOf(var15), var16);
      }

      int var23 = var13.width + var13.x - 1;
      int var17 = var13.height + var13.y - 1;

      int var18;
      int var19;
      for(var18 = var13.x; var18 <= var23; ++var18) {
         for(var19 = var13.y; var19 <= var17; ++var19) {
            this.regions[var18][var19].method528(var15, (WorldMapScaleHandler)this.scaleHandlers.get(Integer.valueOf(var15)), this.mapSceneSprites, this.geographyArchive, this.groundArchive);
         }
      }

      Rasterizer2D.method6083(var9, var10, var11);
      Rasterizer2D.method6088(var12);
      var18 = (int)(var14 * 64.0F);
      var19 = this.tileX * 64 + var1;
      int var20 = this.tileY * 4096 + var2;

      for(int var21 = var13.x; var21 < var13.width + var13.x; ++var21) {
         for(int var22 = var13.y; var22 < var13.height + var13.y; ++var22) {
            this.regions[var21][var22].method519(var5 + var18 * (this.regions[var21][var22].regionX * 64 - var19) / 64, var8 - var18 * (this.regions[var21][var22].regionY * 64 - var20 + 64) / 64, var18);
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIIIIILjava/util/HashSet;Ljava/util/HashSet;IIZB)V",
      garbageValue = "18"
   )
   public final void method721(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, HashSet var9, HashSet var10, int var11, int var12, boolean var13) {
      WorldMapRectangle var14 = this.method723(var1, var2, var3, var4);
      float var15 = this.method727(var7 - var5, var3 - var1);
      int var16 = (int)(var15 * 64.0F);
      int var17 = this.tileX * 64 + var1;
      int var18 = this.tileY * 4096 + var2;

      int var19;
      int var20;
      for(var19 = var14.x; var19 < var14.width + var14.x; ++var19) {
         for(var20 = var14.y; var20 < var14.height + var14.y; ++var20) {
            if(var13) {
               this.regions[var19][var20].method581();
            }

            this.regions[var19][var20].method529(var5 + var16 * (this.regions[var19][var20].regionX * 64 - var17) / 64, var8 - var16 * (this.regions[var19][var20].regionY * 64 - var18 + 64) / 64, var16, var9);
         }
      }

      if(var10 != null && var11 > 0) {
         for(var19 = var14.x; var19 < var14.width + var14.x; ++var19) {
            for(var20 = var14.y; var20 < var14.height + var14.y; ++var20) {
               this.regions[var19][var20].method618(var10, var11, var12);
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIILjava/util/HashSet;IIB)V",
      garbageValue = "73"
   )
   public void method729(int var1, int var2, int var3, int var4, HashSet var5, int var6, int var7) {
      if(this.compositeTextureSprite != null) {
         this.compositeTextureSprite.method6229(var1, var2, var3, var4);
         if(var6 > 0 && var6 % var7 < var7 / 2) {
            if(this.icons == null) {
               this.method724();
            }

            Iterator var8 = var5.iterator();

            while(var8.hasNext()) {
               int var9 = ((Integer)var8.next()).intValue();
               List var10 = (List)this.icons.get(Integer.valueOf(var9));
               if(var10 != null) {
                  Iterator var11 = var10.iterator();

                  while(var11.hasNext()) {
                     AbstractWorldMapIcon var12 = (AbstractWorldMapIcon)var11.next();
                     int var13 = var3 * (var12.coord2.x - this.tileX * 64) / (this.tileWidth * 64);
                     int var14 = var4 - (var12.coord2.y - this.tileY * 4096) * var4 / (this.tileHeight * 4096);
                     Rasterizer2D.method6150(var13 + var1, var14 + var2, 2, 16776960, 256);
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIII)Ljava/util/List;",
      garbageValue = "1400578411"
   )
   public List method722(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      LinkedList var11 = new LinkedList();
      if(!this.loaded) {
         return var11;
      } else {
         WorldMapRectangle var12 = this.method723(var1, var2, var3, var4);
         float var13 = this.method727(var7, var3 - var1);
         int var14 = (int)(var13 * 64.0F);
         int var15 = this.tileX * 64 + var1;
         int var16 = this.tileY * 4096 + var2;

         for(int var17 = var12.x; var17 < var12.width + var12.x; ++var17) {
            for(int var18 = var12.y; var18 < var12.height + var12.y; ++var18) {
               List var19 = this.regions[var17][var18].method606(var5 + var14 * (this.regions[var17][var18].regionX * 64 - var15) / 64, var8 + var6 - var14 * (this.regions[var17][var18].regionY * 64 - var16 + 64) / 64, var14, var9, var10);
               if(!var19.isEmpty()) {
                  var11.addAll(var19);
               }
            }
         }

         return var11;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIII)Lar;",
      garbageValue = "-1850062895"
   )
   WorldMapRectangle method723(int var1, int var2, int var3, int var4) {
      WorldMapRectangle var5 = new WorldMapRectangle(this);
      int var6 = this.tileX * 64 + var1;
      int var7 = this.tileY * 4096 + var2;
      int var8 = var3 + this.tileX * 64;
      int var9 = this.tileY * 4096 + var4;
      int var10 = var6 / 64;
      int var11 = var7 / 64;
      int var12 = var8 / 64;
      int var13 = var9 / 64;
      var5.width = var12 - var10 + 1;
      var5.height = var13 - var11 + 1;
      var5.x = var10 - this.mapAreaData.method453();
      var5.y = var11 - this.mapAreaData.method439();
      if(var5.x < 0) {
         var5.width += var5.x;
         var5.x = 0;
      }

      if(var5.x > this.regions.length - var5.width) {
         var5.width = this.regions.length - var5.x;
      }

      if(var5.y < 0) {
         var5.height += var5.y;
         var5.y = 0;
      }

      if(var5.y > this.regions[0].length - var5.height) {
         var5.height = this.regions[0].length - var5.y;
      }

      var5.width = Math.min(var5.width, this.regions.length);
      var5.height = Math.min(var5.height, this.regions[0].length);
      return var5;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "8"
   )
   public boolean method743() {
      return this.loaded;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)Ljava/util/HashMap;",
      garbageValue = "-55"
   )
   public HashMap method719() {
      this.method724();
      return this.icons;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1193052281"
   )
   void method724() {
      if(this.icons == null) {
         this.icons = new HashMap();
      }

      this.icons.clear();

      for(int var1 = 0; var1 < this.regions.length; ++var1) {
         for(int var2 = 0; var2 < this.regions[var1].length; ++var2) {
            List var3 = this.regions[var1][var2].method551();
            Iterator var4 = var3.iterator();

            while(var4.hasNext()) {
               AbstractWorldMapIcon var5 = (AbstractWorldMapIcon)var4.next();
               if(var5.method689()) {
                  int var6 = var5.vmethod685();
                  if(!this.icons.containsKey(Integer.valueOf(var6))) {
                     LinkedList var7 = new LinkedList();
                     var7.add(var5);
                     this.icons.put(Integer.valueOf(var6), var7);
                  } else {
                     List var8 = (List)this.icons.get(Integer.valueOf(var6));
                     var8.add(var5);
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)F",
      garbageValue = "-1899828753"
   )
   float method727(int var1, int var2) {
      return WorldMapSection1.client.getRenderOverview().getWorldMapZoom();
   }

   public int getSurfaceOffsetX() {
      return this.tileX * 64;
   }

   public int getSurfaceOffsetY() {
      return this.tileY * 4096;
   }

   public boolean isLoaded() {
      return this.method743();
   }

   public float getPixelsPerTile(int var1, int var2) {
      return this.method727(var1, var2);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILce;ZI)I",
      garbageValue = "345752229"
   )
   static int method750(int var0, Script var1, boolean var2) {
      Widget var3 = MusicPatchNode.method3920(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
      if(var0 == 2500) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.x;
         return 1;
      } else if(var0 == 2501) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.y;
         return 1;
      } else if(var0 == 2502) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.width;
         return 1;
      } else if(var0 == 2503) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.height;
         return 1;
      } else if(var0 == 2504) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 2505) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }
}
