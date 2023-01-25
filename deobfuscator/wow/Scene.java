import java.util.Iterator;
import net.runelite.api.Perspective;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.hooks.DrawCallbacks;
import net.runelite.api.util.Text;
import net.runelite.client.callback.Hooks;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSBoundaryObject;
import net.runelite.rs.api.RSEntity;
import net.runelite.rs.api.RSFloorDecoration;
import net.runelite.rs.api.RSGameObject;
import net.runelite.rs.api.RSNPC;
import net.runelite.rs.api.RSNodeDeque;
import net.runelite.rs.api.RSPlayer;
import net.runelite.rs.api.RSProjectile;
import net.runelite.rs.api.RSScene;
import net.runelite.rs.api.RSTile;
import net.runelite.rs.api.RSTileItem;
import net.runelite.rs.api.RSTileItemPile;
import net.runelite.rs.api.RSTileModel;
import net.runelite.rs.api.RSWallDecoration;

@ObfuscatedName("ej")
public class Scene implements RSScene {

   @ObfuscatedName("x")
   public static boolean Scene_isLowDetail = true;
   @ObfuscatedName("h")
   static int tileUpdateCount = 0;
   @ObfuscatedName("g")
   static int Scene_plane = 0;
   @ObfuscatedName("i")
   static int Scene_drawnCount;
   @ObfuscatedName("a")
   static int Scene_cameraXTileMin;
   @ObfuscatedName("b")
   static int Scene_cameraXTileMax;
   @ObfuscatedName("l")
   static int Scene_cameraYTileMin;
   @ObfuscatedName("r")
   static int Scene_cameraYTileMax;
   @ObfuscatedName("o")
   static int Scene_cameraXTile;
   @ObfuscatedName("c")
   static int Scene_cameraYTile;
   @ObfuscatedName("j")
   static int Scene_cameraX;
   @ObfuscatedName("y")
   static int Scene_cameraY;
   @ObfuscatedName("f")
   static int Scene_cameraZ;
   @ObfuscatedName("ae")
   static int Scene_cameraPitchSine;
   @ObfuscatedName("an")
   static int Scene_cameraPitchCosine;
   @ObfuscatedName("ai")
   static int Scene_cameraYawSine;
   @ObfuscatedName("ap")
   static int Scene_cameraYawCosine;
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "[Lek;"
   )
   static GameObject[] gameObjects = new GameObject[100];
   @ObfuscatedName("ar")
   static boolean checkClick = false;
   @ObfuscatedName("af")
   static int Scene_selectedPlane = 0;
   @ObfuscatedName("at")
   static int Scene_selectedScreenX = 0;
   @ObfuscatedName("al")
   static int Scene_selectedScreenY = 0;
   @ObfuscatedName("as")
   public static int Scene_selectedX = -1;
   @ObfuscatedName("am")
   public static int Scene_selectedY = -1;
   @ObfuscatedName("au")
   static boolean viewportWalking = false;
   @ObfuscatedName("av")
   static int Scene_planesCount = 4;
   @ObfuscatedName("ak")
   static int[] Scene_planeOccluderCounts = new int[Scene_planesCount];
   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "[[Lem;"
   )
   static Occluder[][] Scene_planeOccluders = new Occluder[Scene_planesCount][500];
   @ObfuscatedName("ax")
   static int Scene_currentOccludersCount = 0;
   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "[Lem;"
   )
   static Occluder[] Scene_currentOccluders = new Occluder[500];
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   static NodeDeque Scene_tilesDeque = new NodeDeque();
   @ObfuscatedName("ay")
   static final int[] field1856 = new int[]{19, 55, 38, 155, 255, 110, 137, 205, 76};
   @ObfuscatedName("ad")
   static final int[] field1870 = new int[]{160, 192, 80, 96, 0, 144, 80, 48, 160};
   @ObfuscatedName("ac")
   static final int[] field1858 = new int[]{76, 8, 137, 4, 0, 1, 38, 2, 19};
   @ObfuscatedName("ah")
   static final int[] field1820 = new int[]{0, 0, 2, 0, 0, 2, 1, 1, 0};
   @ObfuscatedName("ag")
   static final int[] field1842 = new int[]{2, 0, 0, 2, 0, 0, 0, 4, 4};
   @ObfuscatedName("aw")
   static final int[] field1861 = new int[]{0, 4, 4, 8, 0, 0, 8, 0, 0};
   @ObfuscatedName("bf")
   static final int[] field1814 = new int[]{1, 1, 0, 0, 0, 8, 0, 0, 8};
   @ObfuscatedName("bg")
   static boolean[][][][] visibilityMap = new boolean[8][32][51][51];
   @ObfuscatedName("bt")
   static boolean[][] visibleTiles;
   @ObfuscatedName("bh")
   static int Scene_viewportXCenter;
   @ObfuscatedName("br")
   static int Scene_viewportYCenter;
   @ObfuscatedName("bq")
   static int Scene_viewportXMin;
   @ObfuscatedName("ba")
   static int Scene_viewportYMin;
   @ObfuscatedName("bv")
   static int Scene_viewportXMax;
   @ObfuscatedName("bx")
   static int Scene_viewportYMax;
   public static int rl$drawDistance;
   public static int[] tmpX;
   public static int[] tmpY;
   @ObfuscatedName("m")
   int planes;
   @ObfuscatedName("k")
   int xSize;
   @ObfuscatedName("d")
   int ySize;
   @ObfuscatedName("w")
   int[][][] tileHeights;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "[[[Leq;"
   )
   Tile[][][] tiles;
   @ObfuscatedName("q")
   int minPlane = 0;
   @ObfuscatedName("z")
   int tempGameObjectsCount = 0;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "[Lek;"
   )
   GameObject[] tempGameObjects = new GameObject[5000];
   @ObfuscatedName("e")
   int[][][] field1819;
   @ObfuscatedName("bu")
   int[][] tileShape2D = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1}, {0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1}};
   @ObfuscatedName("be")
   int[][] tileRotation2D = new int[][]{{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, {12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 6, 2, 15, 11, 7, 3}, {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, {3, 7, 11, 15, 2, 6, 10, 14, 1, 5, 9, 13, 0, 4, 8, 12}};


   static {
      rl$$clinit();
   }

   public Scene(int var1, int var2, int var3, int[][][] var4) {
      this.planes = var1;
      this.xSize = var2;
      this.ySize = var3;
      this.tiles = new Tile[var1][var2][var3];
      this.field1819 = new int[var1][var2 + 1][var3 + 1];
      this.tileHeights = var4;
      this.method3208();
   }

   @ObfuscatedName("x")
   public void method3208() {
      int var1;
      int var2;
      for(var1 = 0; var1 < this.planes; ++var1) {
         for(var2 = 0; var2 < this.xSize; ++var2) {
            for(int var3 = 0; var3 < this.ySize; ++var3) {
               this.tiles[var1][var2][var3] = null;
            }
         }
      }

      for(var1 = 0; var1 < Scene_planesCount; ++var1) {
         for(var2 = 0; var2 < Scene_planeOccluderCounts[var1]; ++var2) {
            Scene_planeOccluders[var1][var2] = null;
         }

         Scene_planeOccluderCounts[var1] = 0;
      }

      for(var1 = 0; var1 < this.tempGameObjectsCount; ++var1) {
         this.tempGameObjects[var1] = null;
      }

      this.tempGameObjectsCount = 0;

      for(var1 = 0; var1 < gameObjects.length; ++var1) {
         gameObjects[var1] = null;
      }

   }

   @ObfuscatedName("m")
   public void method3178(int var1) {
      this.minPlane = var1;

      for(int var2 = 0; var2 < this.xSize; ++var2) {
         for(int var3 = 0; var3 < this.ySize; ++var3) {
            if(this.tiles[var1][var2][var3] == null) {
               this.tiles[var1][var2][var3] = new Tile(var1, var2, var3);
            }
         }
      }

   }

   @ObfuscatedName("k")
   public void method3179(int var1, int var2) {
      Tile var3 = this.tiles[0][var1][var2];

      for(int var4 = 0; var4 < 3; ++var4) {
         Tile var5 = this.tiles[var4][var1][var2] = this.tiles[var4 + 1][var1][var2];
         if(var5 != null) {
            --var5.plane;

            for(int var6 = 0; var6 < var5.gameObjectsCount; ++var6) {
               GameObject var7 = var5.gameObjects[var6];
               long var9 = var7.tag;
               int var11 = (int)(var9 >>> 14 & 3L);
               boolean var8 = var11 == 2;
               if(var8 && var7.startX == var1 && var2 == var7.startY) {
                  --var7.plane;
               }
            }
         }
      }

      if(this.tiles[0][var1][var2] == null) {
         this.tiles[0][var1][var2] = new Tile(0, var1, var2);
      }

      this.tiles[0][var1][var2].linkedBelowTile = var3;
      this.tiles[3][var1][var2] = null;
   }

   @ObfuscatedName("w")
   public void method3181(int var1, int var2, int var3, int var4) {
      Tile var5 = this.tiles[var1][var2][var3];
      if(var5 != null) {
         this.tiles[var1][var2][var3].minPlane = var4;
      }
   }

   @ObfuscatedName("v")
   public void method3182(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18, int var19, int var20) {
      TilePaint var21;
      int var22;
      if(var4 == 0) {
         var21 = new TilePaint(var11, var12, var13, var14, -1, var19, false);

         for(var22 = var1; var22 >= 0; --var22) {
            if(this.tiles[var22][var2][var3] == null) {
               this.tiles[var22][var2][var3] = new Tile(var22, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].paint = var21;
         this.rl$addTile(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20);
      } else if(var4 != 1) {
         TileModel var23 = new TileModel(var4, var5, var6, var2, var3, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20);

         for(var22 = var1; var22 >= 0; --var22) {
            if(this.tiles[var22][var2][var3] == null) {
               this.tiles[var22][var2][var3] = new Tile(var22, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].model = var23;
         this.rl$addTile(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20);
      } else {
         var21 = new TilePaint(var15, var16, var17, var18, var6, var20, var8 == var7 && var7 == var9 && var10 == var7);

         for(var22 = var1; var22 >= 0; --var22) {
            if(this.tiles[var22][var2][var3] == null) {
               this.tiles[var22][var2][var3] = new Tile(var22, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].paint = var21;
         this.rl$addTile(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIILee;JI)V"
   )
   public void method3176(int var1, int var2, int var3, int var4, Entity var5, long var6, int var8) {
      this.copy$newFloorDecoration(var1, var2, var3, var4, var5, var6, var8);
      RSTile var9 = this.getTiles()[var1][var2][var3];
      if(var9 != null) {
         RSFloorDecoration var10 = (RSFloorDecoration)var9.getGroundObject();
         if(var10 != null) {
            var10.setPlane(var1);
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIILee;JLee;Lee;)V"
   )
   public void method3184(int var1, int var2, int var3, int var4, Entity var5, long var6, Entity var8, Entity var9) {
      this.copy$newGroundItemPile(var1, var2, var3, var4, var5, var6, var8, var9);
      RSTile var10 = this.getTiles()[var1][var2][var3];
      if(var10 != null) {
         RSTileItemPile var11 = (RSTileItemPile)var10.getItemLayer();
         if(var11 != null) {
            var11.setPlane(var1);
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIILee;Lee;IIJI)V"
   )
   public void method3283(int var1, int var2, int var3, int var4, Entity var5, Entity var6, int var7, int var8, long var9, int var11) {
      this.copy$newBoundaryObject(var1, var2, var3, var4, var5, var6, var7, var8, var9, var11);
      RSTile var12 = this.getTiles()[var1][var2][var3];
      if(var12 != null) {
         RSBoundaryObject var13 = (RSBoundaryObject)var12.getWallObject();
         if(var13 != null) {
            var13.setPlane(var1);
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIILee;Lee;IIIIJI)V"
   )
   public void method3299(int var1, int var2, int var3, int var4, Entity var5, Entity var6, int var7, int var8, int var9, int var10, long var11, int var13) {
      this.copy$newWallDecoration(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var13);
      RSTile var14 = this.getTiles()[var1][var2][var3];
      if(var14 != null) {
         RSWallDecoration var15 = (RSWallDecoration)var14.getDecorativeObject();
         if(var15 != null) {
            var15.setPlane(var1);
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIIIILee;IJI)Z"
   )
   public boolean method3187(int var1, int var2, int var3, int var4, int var5, int var6, Entity var7, int var8, long var9, int var11) {
      if(var7 == null) {
         return true;
      } else {
         int var12 = var5 * 64 + var2 * 128;
         int var13 = var6 * 64 + var3 * 128;
         return this.method3195(var1, var2, var3, var5, var6, var12, var13, var4, var7, var8, false, var9, var11);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIIILee;IJZ)Z"
   )
   public boolean method3188(int var1, int var2, int var3, int var4, int var5, Entity var6, int var7, long var8, boolean var10) {
      if(var6 == null) {
         return true;
      } else {
         int var11 = var2 - var5;
         int var12 = var3 - var5;
         int var13 = var5 + var2;
         int var14 = var3 + var5;
         if(var10) {
            if(var7 > 640 && var7 < 1408) {
               var14 += 128;
            }

            if(var7 > 1152 && var7 < 1920) {
               var13 += 128;
            }

            if(var7 > 1664 || var7 < 384) {
               var12 -= 128;
            }

            if(var7 > 128 && var7 < 896) {
               var11 -= 128;
            }
         }

         var11 /= 128;
         var12 /= 128;
         var13 /= 128;
         var14 /= 128;
         return this.method3195(var1, var11, var12, var13 - var11 + 1, var14 - var12 + 1, var2, var3, var4, var6, var7, true, var8, 0);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIIILee;IJIIII)Z"
   )
   public boolean method3189(int var1, int var2, int var3, int var4, int var5, Entity var6, int var7, long var8, int var10, int var11, int var12, int var13) {
      return var6 == null?true:this.method3195(var1, var10, var11, var12 - var10 + 1, var13 - var11 + 1, var2, var3, var4, var6, var7, true, var8, 0);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIIIIIILee;IZJI)Z"
   )
   boolean method3195(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, Entity var9, int var10, boolean var11, long var12, int var14) {
      boolean var15 = shouldDraw(var9, false);
      if(!var15) {
         int var16 = var6 >> 7;
         int var17 = var7 >> 7;
         WorldMapSection1.client.getOccupiedTilesTick()[var16][var17] = -1;
      }

      return var15 && this.copy$newGameObject(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var14);
   }

   @ObfuscatedName("h")
   public void method3191() {
      for(int var1 = 0; var1 < this.tempGameObjectsCount; ++var1) {
         GameObject var2 = this.tempGameObjects[var1];
         this.method3192(var2);
         this.tempGameObjects[var1] = null;
      }

      this.tempGameObjectsCount = 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lek;)V"
   )
   void method3192(GameObject var1) {
      for(int var2 = var1.startX; var2 <= var1.endX; ++var2) {
         for(int var3 = var1.startY; var3 <= var1.endY; ++var3) {
            Tile var4 = this.tiles[var1.plane][var2][var3];
            if(var4 != null) {
               int var5;
               for(var5 = 0; var5 < var4.gameObjectsCount; ++var5) {
                  if(var4.gameObjects[var5] == var1) {
                     --var4.gameObjectsCount;

                     for(int var6 = var5; var6 < var4.gameObjectsCount; ++var6) {
                        var4.gameObjects[var6] = var4.gameObjects[var6 + 1];
                        var4.gameObjectsChanged(var6);
                        var4.gameObjectEdgeMasks[var6] = var4.gameObjectEdgeMasks[var6 + 1];
                     }

                     var4.gameObjects[var4.gameObjectsCount] = null;
                     var4.gameObjectsChanged(var4.gameObjectsCount);
                     break;
                  }
               }

               var4.gameObjectsEdgeMask = 0;

               for(var5 = 0; var5 < var4.gameObjectsCount; ++var5) {
                  var4.gameObjectsEdgeMask |= var4.gameObjectEdgeMasks[var5];
               }
            }
         }
      }

   }

   @ObfuscatedName("i")
   public void method3210(int var1, int var2, int var3, int var4) {
      Tile var5 = this.tiles[var1][var2][var3];
      if(var5 != null) {
         WallDecoration var6 = var5.wallDecoration;
         if(var6 != null) {
            var6.xOffset = var4 * var6.xOffset / 16;
            var6.yOffset = var4 * var6.yOffset / 16;
         }
      }
   }

   @ObfuscatedName("a")
   public void method3194(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.boundaryObject = null;
         var4.wallObjectChanged(-1);
      }
   }

   @ObfuscatedName("o")
   public void method3276(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.wallDecoration = null;
         var4.decorativeObjectChanged(-1);
      }
   }

   @ObfuscatedName("c")
   public void method3196(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         for(int var5 = 0; var5 < var4.gameObjectsCount; ++var5) {
            GameObject var6 = var4.gameObjects[var5];
            long var8 = var6.tag;
            int var10 = (int)(var8 >>> 14 & 3L);
            boolean var7 = var10 == 2;
            if(var7 && var2 == var6.startX && var3 == var6.startY) {
               this.method3192(var6);
               return;
            }
         }

      }
   }

   @ObfuscatedName("f")
   public void method3197(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.floorDecoration = null;
         var4.groundObjectChanged(-1);
      }
   }

   @ObfuscatedName("ae")
   public void method3198(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 != null) {
         var4.tileItemPile = null;
         var4.itemLayerChanged(-1);
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(III)Lep;"
   )
   public BoundaryObject method3199(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 == null?null:var4.boundaryObject;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(III)Lez;"
   )
   public WallDecoration method3252(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 == null?null:var4.wallDecoration;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(III)Lek;"
   )
   public GameObject method3201(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 == null) {
         return null;
      } else {
         for(int var5 = 0; var5 < var4.gameObjectsCount; ++var5) {
            GameObject var6 = var4.gameObjects[var5];
            long var8 = var6.tag;
            int var10 = (int)(var8 >>> 14 & 3L);
            boolean var7 = var10 == 2;
            if(var7 && var2 == var6.startX && var3 == var6.startY) {
               return var6;
            }
         }

         return null;
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(III)Leo;"
   )
   public FloorDecoration method3202(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.floorDecoration != null?var4.floorDecoration:null;
   }

   @ObfuscatedName("ar")
   public long method3203(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.boundaryObject != null?var4.boundaryObject.tag:0L;
   }

   @ObfuscatedName("af")
   public long method3204(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.wallDecoration != null?var4.wallDecoration.tag:0L;
   }

   @ObfuscatedName("at")
   public long method3205(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      if(var4 == null) {
         return 0L;
      } else {
         for(int var5 = 0; var5 < var4.gameObjectsCount; ++var5) {
            GameObject var6 = var4.gameObjects[var5];
            long var8 = var6.tag;
            int var10 = (int)(var8 >>> 14 & 3L);
            boolean var7 = var10 == 2;
            if(var7 && var2 == var6.startX && var3 == var6.startY) {
               return var6.tag;
            }
         }

         return 0L;
      }
   }

   @ObfuscatedName("as")
   public long method3323(int var1, int var2, int var3) {
      Tile var4 = this.tiles[var1][var2][var3];
      return var4 != null && var4.floorDecoration != null?var4.floorDecoration.tag:0L;
   }

   @ObfuscatedName("am")
   public int method3207(int var1, int var2, int var3, long var4) {
      Tile var6 = this.tiles[var1][var2][var3];
      if(var6 == null) {
         return -1;
      } else if(var6.boundaryObject != null && var6.boundaryObject.tag == var4) {
         return var6.boundaryObject.flags & 255;
      } else if(var6.wallDecoration != null && var6.wallDecoration.tag == var4) {
         return var6.wallDecoration.flags & 255;
      } else if(var6.floorDecoration != null && var6.floorDecoration.tag == var4) {
         return var6.floorDecoration.flags & 255;
      } else {
         for(int var7 = 0; var7 < var6.gameObjectsCount; ++var7) {
            if(var6.gameObjects[var7].tag == var4) {
               return var6.gameObjects[var7].flags & 255;
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("au")
   public void method3262(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.planes; ++var4) {
         for(int var5 = 0; var5 < this.xSize; ++var5) {
            for(int var6 = 0; var6 < this.ySize; ++var6) {
               Tile var7 = this.tiles[var4][var5][var6];
               if(var7 != null) {
                  BoundaryObject var8 = var7.boundaryObject;
                  ModelData var10;
                  if(var8 != null && var8.entity1 instanceof ModelData) {
                     ModelData var9 = (ModelData)var8.entity1;
                     this.method3209(var9, var4, var5, var6, 1, 1);
                     if(var8.entity2 instanceof ModelData) {
                        var10 = (ModelData)var8.entity2;
                        this.method3209(var10, var4, var5, var6, 1, 1);
                        ModelData.method2890(var9, var10, 0, 0, 0, false);
                        var8.entity2 = var10.method2900(var10.ambient, var10.contrast, var1, var2, var3);
                     }

                     var8.entity1 = var9.method2900(var9.ambient, var9.contrast, var1, var2, var3);
                  }

                  for(int var12 = 0; var12 < var7.gameObjectsCount; ++var12) {
                     GameObject var14 = var7.gameObjects[var12];
                     if(var14 != null && var14.entity instanceof ModelData) {
                        ModelData var11 = (ModelData)var14.entity;
                        this.method3209(var11, var4, var5, var6, var14.endX - var14.startX + 1, var14.endY - var14.startY + 1);
                        var14.entity = var11.method2900(var11.ambient, var11.contrast, var1, var2, var3);
                     }
                  }

                  FloorDecoration var13 = var7.floorDecoration;
                  if(var13 != null && var13.entity instanceof ModelData) {
                     var10 = (ModelData)var13.entity;
                     this.method3308(var10, var4, var5, var6);
                     var13.entity = var10.method2900(var10.ambient, var10.contrast, var1, var2, var3);
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(Lea;III)V"
   )
   void method3308(ModelData var1, int var2, int var3, int var4) {
      Tile var5;
      ModelData var6;
      if(var3 < this.xSize) {
         var5 = this.tiles[var2][var3 + 1][var4];
         if(var5 != null && var5.floorDecoration != null && var5.floorDecoration.entity instanceof ModelData) {
            var6 = (ModelData)var5.floorDecoration.entity;
            ModelData.method2890(var1, var6, 128, 0, 0, true);
         }
      }

      if(var4 < this.xSize) {
         var5 = this.tiles[var2][var3][var4 + 1];
         if(var5 != null && var5.floorDecoration != null && var5.floorDecoration.entity instanceof ModelData) {
            var6 = (ModelData)var5.floorDecoration.entity;
            ModelData.method2890(var1, var6, 0, 0, 128, true);
         }
      }

      if(var3 < this.xSize && var4 < this.ySize) {
         var5 = this.tiles[var2][var3 + 1][var4 + 1];
         if(var5 != null && var5.floorDecoration != null && var5.floorDecoration.entity instanceof ModelData) {
            var6 = (ModelData)var5.floorDecoration.entity;
            ModelData.method2890(var1, var6, 128, 0, 128, true);
         }
      }

      if(var3 < this.xSize && var4 > 0) {
         var5 = this.tiles[var2][var3 + 1][var4 - 1];
         if(var5 != null && var5.floorDecoration != null && var5.floorDecoration.entity instanceof ModelData) {
            var6 = (ModelData)var5.floorDecoration.entity;
            ModelData.method2890(var1, var6, 128, 0, -128, true);
         }
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(Lea;IIIII)V"
   )
   void method3209(ModelData var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = true;
      int var8 = var3;
      int var9 = var3 + var5;
      int var10 = var4 - 1;
      int var11 = var4 + var6;

      for(int var12 = var2; var12 <= var2 + 1; ++var12) {
         if(var12 != this.planes) {
            for(int var13 = var8; var13 <= var9; ++var13) {
               if(var13 >= 0 && var13 < this.xSize) {
                  for(int var14 = var10; var14 <= var11; ++var14) {
                     if(var14 >= 0 && var14 < this.ySize && (!var7 || var13 >= var9 || var14 >= var11 || var14 < var4 && var3 != var13)) {
                        Tile var15 = this.tiles[var12][var13][var14];
                        if(var15 != null) {
                           int var16 = (this.tileHeights[var12][var13 + 1][var14] + this.tileHeights[var12][var13 + 1][var14 + 1] + this.tileHeights[var12][var13][var14] + this.tileHeights[var12][var13][var14 + 1]) / 4 - (this.tileHeights[var2][var3 + 1][var4] + this.tileHeights[var2][var3][var4] + this.tileHeights[var2][var3 + 1][var4 + 1] + this.tileHeights[var2][var3][var4 + 1]) / 4;
                           BoundaryObject var17 = var15.boundaryObject;
                           if(var17 != null) {
                              ModelData var18;
                              if(var17.entity1 instanceof ModelData) {
                                 var18 = (ModelData)var17.entity1;
                                 ModelData.method2890(var1, var18, (1 - var5) * 64 + (var13 - var3) * 128, var16, (var14 - var4) * 128 + (1 - var6) * 64, var7);
                              }

                              if(var17.entity2 instanceof ModelData) {
                                 var18 = (ModelData)var17.entity2;
                                 ModelData.method2890(var1, var18, (1 - var5) * 64 + (var13 - var3) * 128, var16, (var14 - var4) * 128 + (1 - var6) * 64, var7);
                              }
                           }

                           for(int var23 = 0; var23 < var15.gameObjectsCount; ++var23) {
                              GameObject var19 = var15.gameObjects[var23];
                              if(var19 != null && var19.entity instanceof ModelData) {
                                 ModelData var20 = (ModelData)var19.entity;
                                 int var21 = var19.endX - var19.startX + 1;
                                 int var22 = var19.endY - var19.startY + 1;
                                 ModelData.method2890(var1, var20, (var21 - var5) * 64 + (var19.startX - var3) * 128, var16, (var19.startY - var4) * 128 + (var22 - var6) * 64, var7);
                              }
                           }
                        }
                     }
                  }
               }
            }

            --var8;
            var7 = false;
         }
      }

   }

   @ObfuscatedName("av")
   public void method3359(int[] var1, int var2, int var3, int var4, int var5, int var6) {
      if(!Client.hdMinimapEnabled) {
         this.copy$drawTileMinimap(var1, var2, var3, var4, var5, var6);
      } else {
         RSTile var7 = this.getTiles()[var4][var5][var6];
         if(var7 != null) {
            net.runelite.api.TilePaint var8 = var7.getTilePaint();
            int var10;
            int var11;
            int var12;
            int var13;
            int var16;
            if(var8 != null) {
               int var9 = var8.getRBG();
               if(var8.getSwColor() != 12345678) {
                  var10 = var8.getSwColor() & -128;
                  var11 = var8.getNwColor() & 127;
                  var12 = var8.getNeColor() & 127;
                  var13 = (var8.getSwColor() & 127) - var11;
                  int var14 = (var8.getSeColor() & 127) - var12;
                  var11 <<= 2;
                  var12 <<= 2;

                  for(int var15 = 0; var15 < 4; ++var15) {
                     if(var8.getTexture() == -1) {
                        var1[var2] = Rasterizer3D.Rasterizer3D_colorPalette[var10 | var11 >> 2];
                        var1[var2 + 1] = Rasterizer3D.Rasterizer3D_colorPalette[var10 | var12 + var11 * 3 >> 4];
                        var1[var2 + 2] = Rasterizer3D.Rasterizer3D_colorPalette[var10 | var11 + var12 >> 3];
                        var1[var2 + 3] = Rasterizer3D.Rasterizer3D_colorPalette[var10 | var11 + var12 * 3 >> 4];
                     } else {
                        var16 = 255 - ((var11 >> 1) * (var11 >> 1) >> 8);
                        var1[var2] = (var16 * (var9 & '\uff00') & 16711680) + ((var9 & 16711935) * var16 & -16711936) >> 8;
                        var16 = 255 - ((var12 + var11 * 3 >> 3) * (var12 + var11 * 3 >> 3) >> 8);
                        var1[var2 + 1] = (var16 * (var9 & '\uff00') & 16711680) + ((var9 & 16711935) * var16 & -16711936) >> 8;
                        var16 = 255 - ((var11 + var12 >> 2) * (var11 + var12 >> 2) >> 8);
                        var1[var2 + 2] = (var16 * (var9 & '\uff00') & 16711680) + ((var9 & 16711935) * var16 & -16711936) >> 8;
                        var16 = 255 - ((var11 + var12 * 3 >> 3) * (var11 + var12 * 3 >> 3) >> 8);
                        var1[var2 + 3] = (var16 * (var9 & '\uff00') & 16711680) + ((var9 & 16711935) * var16 & -16711936) >> 8;
                     }

                     var11 += var13;
                     var12 += var14;
                     var2 += var3;
                  }
               } else if(var9 != 0) {
                  for(var10 = 0; var10 < 4; ++var10) {
                     var1[var2] = var9;
                     var1[var2 + 1] = var9;
                     var1[var2 + 2] = var9;
                     var1[var2 + 3] = var9;
                     var2 += var3;
                  }
               }

            } else {
               net.runelite.api.TileModel var24 = var7.getTileModel();
               if(var24 != null) {
                  var10 = var24.getShape();
                  var11 = var24.getRotation();
                  var12 = var24.getModelOverlay();
                  var13 = var24.getModelUnderlay();
                  int[] var25 = this.getTileShape2D()[var10];
                  int[] var26 = this.getTileRotation2D()[var11];
                  var16 = 0;
                  int var17;
                  if(var24.getOverlaySwColor() != 12345678) {
                     var17 = var24.getOverlaySwColor() & -128;
                     int var18 = var24.getOverlaySeColor() & 127;
                     int var19 = var24.getOverlayNeColor() & 127;
                     int var20 = (var24.getOverlaySwColor() & 127) - var18;
                     int var21 = (var24.getOverlayNwColor() & 127) - var19;
                     var18 <<= 2;
                     var19 <<= 2;

                     int var22;
                     for(var22 = 0; var22 < 4; ++var22) {
                        if(var24.getTriangleTextureId() == null) {
                           if(var25[var26[var16++]] != 0) {
                              var1[var2] = Rasterizer3D.Rasterizer3D_colorPalette[var17 | var18 >> 2];
                           }

                           if(var25[var26[var16++]] != 0) {
                              var1[var2 + 1] = Rasterizer3D.Rasterizer3D_colorPalette[var17 | var19 + var18 * 3 >> 4];
                           }

                           if(var25[var26[var16++]] != 0) {
                              var1[var2 + 2] = Rasterizer3D.Rasterizer3D_colorPalette[var17 | var18 + var19 >> 3];
                           }

                           if(var25[var26[var16++]] != 0) {
                              var1[var2 + 3] = Rasterizer3D.Rasterizer3D_colorPalette[var17 | var18 + var19 * 3 >> 4];
                           }
                        } else {
                           int var23;
                           if(var25[var26[var16++]] != 0) {
                              var23 = 255 - ((var18 >> 1) * (var18 >> 1) >> 8);
                              var1[var2] = (var23 * (var12 & '\uff00') & 16711680) + ((var12 & 16711935) * var23 & -16711936) >> 8;
                           }

                           if(var25[var26[var16++]] != 0) {
                              var23 = 255 - ((var19 + var18 * 3 >> 3) * (var19 + var18 * 3 >> 3) >> 8);
                              var1[var2 + 1] = (var23 * (var12 & '\uff00') & 16711680) + ((var12 & 16711935) * var23 & -16711936) >> 8;
                           }

                           if(var25[var26[var16++]] != 0) {
                              var23 = 255 - ((var18 + var19 >> 2) * (var18 + var19 >> 2) >> 8);
                              var1[var2 + 2] = (var23 * (var12 & '\uff00') & 16711680) + ((var12 & 16711935) * var23 & -16711936) >> 8;
                           }

                           if(var25[var26[var16++]] != 0) {
                              var23 = 255 - ((var18 + var19 * 3 >> 3) * (var18 + var19 * 3 >> 3) >> 8);
                              var1[var2 + 3] = (var23 * (var12 & '\uff00') & 16711680) + ((var12 & 16711935) * var23 & -16711936) >> 8;
                           }
                        }

                        var18 += var20;
                        var19 += var21;
                        var2 += var3;
                     }

                     if(var13 != 0 && var24.getUnderlaySwColor() != 12345678) {
                        var2 -= var3 << 2;
                        var16 -= 16;
                        var17 = var24.getUnderlaySwColor() & -128;
                        var18 = var24.getUnderlaySeColor() & 127;
                        var19 = var24.getUnderlayNeColor() & 127;
                        var20 = (var24.getUnderlaySwColor() & 127) - var18;
                        var21 = (var24.getUnderlayNwColor() & 127) - var19;
                        var18 <<= 2;
                        var19 <<= 2;

                        for(var22 = 0; var22 < 4; ++var22) {
                           if(var25[var26[var16++]] == 0) {
                              var1[var2] = Rasterizer3D.Rasterizer3D_colorPalette[var17 | var18 >> 2];
                           }

                           if(var25[var26[var16++]] == 0) {
                              var1[var2 + 1] = Rasterizer3D.Rasterizer3D_colorPalette[var17 | var19 + var18 * 3 >> 4];
                           }

                           if(var25[var26[var16++]] == 0) {
                              var1[var2 + 2] = Rasterizer3D.Rasterizer3D_colorPalette[var17 | var18 + var19 >> 3];
                           }

                           if(var25[var26[var16++]] == 0) {
                              var1[var2 + 3] = Rasterizer3D.Rasterizer3D_colorPalette[var17 | var18 + var19 * 3 >> 4];
                           }

                           var18 += var20;
                           var19 += var21;
                           var2 += var3;
                        }
                     }
                  } else if(var13 != 0) {
                     for(var17 = 0; var17 < 4; ++var17) {
                        var1[var2] = var25[var26[var16++]] != 0?var12:var13;
                        var1[var2 + 1] = var25[var26[var16++]] != 0?var12:var13;
                        var1[var2 + 2] = var25[var26[var16++]] != 0?var12:var13;
                        var1[var2 + 3] = var25[var26[var16++]] != 0?var12:var13;
                        var2 += var3;
                     }
                  } else {
                     for(var17 = 0; var17 < 4; ++var17) {
                        if(var25[var26[var16++]] != 0) {
                           var1[var2] = var12;
                        }

                        if(var25[var26[var16++]] != 0) {
                           var1[var2 + 1] = var12;
                        }

                        if(var25[var26[var16++]] != 0) {
                           var1[var2 + 2] = var12;
                        }

                        if(var25[var26[var16++]] != 0) {
                           var1[var2 + 3] = var12;
                        }

                        var2 += var3;
                     }
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("ax")
   public void method3213(int var1, int var2, int var3, boolean var4) {
      if(!method3215() || var4) {
         checkClick = true;
         viewportWalking = var4;
         Scene_selectedPlane = var1;
         Scene_selectedScreenX = var2;
         Scene_selectedScreenY = var3;
         Scene_selectedX = -1;
         Scene_selectedY = -1;
      }
   }

   @ObfuscatedName("az")
   public void method3339() {
      viewportWalking = true;
   }

   @ObfuscatedName("ad")
   public void method3217(int var1, int var2, int var3, int var4, int var5, int var6) {
      DrawCallbacks var7 = WorldMapSection1.client.getDrawCallbacks();
      if(var7 != null) {
         var7.drawScene(var1, var2, var3, var4, var5, var6);
      }

      boolean var8 = WorldMapSection1.client.isGpu();
      boolean var9 = WorldMapSection1.client.isCheckClick();
      int var10;
      int var11;
      if(!WorldMapSection1.client.isMenuOpen()) {
         WorldMapSection1.client.setCheckClick(true);
         var10 = WorldMapSection1.client.getMouseX();
         var11 = WorldMapSection1.client.getMouseY();
         WorldMapSection1.client.setMouseCanvasHoverPositionX(var10 - WorldMapSection1.client.getViewportXOffset());
         WorldMapSection1.client.setMouseCanvasHoverPositionY(var11 - WorldMapSection1.client.getViewportYOffset());
      }

      if(!var8 && Client.skyboxColor != 0) {
         WorldMapSection1.client.rasterizerFillRectangle(WorldMapSection1.client.getViewportXOffset(), WorldMapSection1.client.getViewportYOffset(), WorldMapSection1.client.getViewportWidth(), WorldMapSection1.client.getViewportHeight(), Client.skyboxColor);
      }

      var10 = this.getMaxX();
      var11 = this.getMaxY();
      int var12 = this.getMaxZ();
      int var13 = this.getMinLevel();
      RSTile[][][] var14 = this.getTiles();
      int var15 = var8?rl$drawDistance:25;
      if(var1 < 0) {
         var1 = 0;
      } else if(var1 >= var10 * 128) {
         var1 = var10 * 128 - 1;
      }

      if(var3 < 0) {
         var3 = 0;
      } else if(var3 >= var12 * 128) {
         var3 = var12 * 128 - 1;
      }

      int var16 = var4;
      if(var4 < 128) {
         var4 = 128;
      } else if(var4 > 383) {
         var4 = 383;
      }

      if(!Client.pitchRelaxEnabled) {
         var16 = var4;
      }

      WorldMapSection1.client.setCycle(WorldMapSection1.client.getCycle() + 1);
      WorldMapSection1.client.setPitchSin(Perspective.SINE[var16]);
      WorldMapSection1.client.setPitchCos(Perspective.COSINE[var16]);
      WorldMapSection1.client.setYawSin(Perspective.SINE[var5]);
      WorldMapSection1.client.setYawCos(Perspective.COSINE[var5]);
      int[][][] var17 = WorldMapSection1.client.getTileHeights();
      boolean[][] var18 = WorldMapSection1.client.getVisibilityMaps()[(var4 - 128) / 32][var5 / 64];
      WorldMapSection1.client.setRenderArea(var18);
      WorldMapSection1.client.setCameraX2(var1);
      WorldMapSection1.client.setCameraY2(var2);
      WorldMapSection1.client.setCameraZ2(var3);
      int var19 = var1 / 128;
      int var20 = var3 / 128;
      WorldMapSection1.client.setScreenCenterX(var19);
      WorldMapSection1.client.setScreenCenterZ(var20);
      WorldMapSection1.client.setScenePlane(var6);
      int var21 = var19 - var15;
      if(var21 < 0) {
         var21 = 0;
      }

      int var22 = var20 - var15;
      if(var22 < 0) {
         var22 = 0;
      }

      int var23 = var19 + var15;
      if(var23 > var10) {
         var23 = var10;
      }

      int var24 = var20 + var15;
      if(var24 > var12) {
         var24 = var12;
      }

      WorldMapSection1.client.setMinTileX(var21);
      WorldMapSection1.client.setMinTileZ(var22);
      WorldMapSection1.client.setMaxTileX(var23);
      WorldMapSection1.client.setMaxTileZ(var24);
      this.updateOccluders();
      WorldMapSection1.client.setTileUpdateCount(0);

      int var25;
      RSTile[][] var26;
      int var27;
      int var28;
      for(var25 = var13; var25 < var11; ++var25) {
         var26 = var14[var25];

         for(var27 = var21; var27 < var23; ++var27) {
            for(var28 = var22; var28 < var24; ++var28) {
               RSTile var29 = var26[var27][var28];
               if(var29 != null) {
                  if(var29.getPhysicalLevel() <= var6 && (var8 || var18[var27 - var19 + 25][var28 - var20 + 25] || var17[var25][var27][var28] - var2 >= 2000)) {
                     var29.setDraw(true);
                     var29.setVisible(true);
                     var29.setDrawEntities(true);
                     WorldMapSection1.client.setTileUpdateCount(WorldMapSection1.client.getTileUpdateCount() + 1);
                  } else {
                     var29.setDraw(false);
                     var29.setVisible(false);
                     var29.setWallCullDirection(0);
                  }
               }
            }
         }
      }

      int var30;
      int var31;
      int var32;
      RSTile var33;
      int var34;
      for(var25 = var13; var25 < var11; ++var25) {
         var26 = var14[var25];

         for(var27 = -var15; var27 <= 0; ++var27) {
            var28 = var27 + var19;
            var34 = var19 - var27;
            if(var28 >= var21 || var34 < var23) {
               for(var30 = -var15; var30 <= 0; ++var30) {
                  var31 = var30 + var20;
                  var32 = var20 - var30;
                  if(var28 >= var21) {
                     if(var31 >= var22) {
                        var33 = var26[var28][var31];
                        if(var33 != null && var33.isDraw()) {
                           this.draw(var33, true);
                        }
                     }

                     if(var32 < var24) {
                        var33 = var26[var28][var32];
                        if(var33 != null && var33.isDraw()) {
                           this.draw(var33, true);
                        }
                     }
                  }

                  if(var34 < var23) {
                     if(var31 >= var22) {
                        var33 = var26[var34][var31];
                        if(var33 != null && var33.isDraw()) {
                           this.draw(var33, true);
                        }
                     }

                     if(var32 < var24) {
                        var33 = var26[var34][var32];
                        if(var33 != null && var33.isDraw()) {
                           this.draw(var33, true);
                        }
                     }
                  }

                  if(WorldMapSection1.client.getTileUpdateCount() == 0) {
                     if(!var8 && WorldMapSection1.client.getOculusOrbState() != 0 && !WorldMapSection1.client.getComplianceValue("orbInteraction")) {
                        WorldMapSection1.client.setEntitiesAtMouseCount(0);
                     }

                     WorldMapSection1.client.setCheckClick(false);
                     if(!var9) {
                        WorldMapSection1.client.setViewportWalking(false);
                     }

                     WorldMapSection1.client.getCallbacks().drawScene();
                     return;
                  }
               }
            }
         }
      }

      for(var25 = var13; var25 < var11; ++var25) {
         var26 = var14[var25];

         for(var27 = -var15; var27 <= 0; ++var27) {
            var28 = var27 + var19;
            var34 = var19 - var27;
            if(var28 >= var21 || var34 < var23) {
               for(var30 = -var15; var30 <= 0; ++var30) {
                  var31 = var30 + var20;
                  var32 = var20 - var30;
                  if(var28 >= var21) {
                     if(var31 >= var22) {
                        var33 = var26[var28][var31];
                        if(var33 != null && var33.isDraw()) {
                           this.draw(var33, false);
                        }
                     }

                     if(var32 < var24) {
                        var33 = var26[var28][var32];
                        if(var33 != null && var33.isDraw()) {
                           this.draw(var33, false);
                        }
                     }
                  }

                  if(var34 < var23) {
                     if(var31 >= var22) {
                        var33 = var26[var34][var31];
                        if(var33 != null && var33.isDraw()) {
                           this.draw(var33, false);
                        }
                     }

                     if(var32 < var24) {
                        var33 = var26[var34][var32];
                        if(var33 != null && var33.isDraw()) {
                           this.draw(var33, false);
                        }
                     }
                  }

                  if(WorldMapSection1.client.getTileUpdateCount() == 0) {
                     if(!var8 && WorldMapSection1.client.getOculusOrbState() != 0 && !WorldMapSection1.client.getComplianceValue("orbInteraction")) {
                        WorldMapSection1.client.setEntitiesAtMouseCount(0);
                     }

                     WorldMapSection1.client.setCheckClick(false);
                     if(!var9) {
                        WorldMapSection1.client.setViewportWalking(false);
                     }

                     WorldMapSection1.client.getCallbacks().drawScene();
                     return;
                  }
               }
            }
         }
      }

      if(!var8 && WorldMapSection1.client.getOculusOrbState() != 0 && !WorldMapSection1.client.getComplianceValue("orbInteraction")) {
         WorldMapSection1.client.setEntitiesAtMouseCount(0);
      }

      WorldMapSection1.client.setCheckClick(false);
      if(!var9) {
         WorldMapSection1.client.setViewportWalking(false);
      }

      WorldMapSection1.client.getCallbacks().drawScene();
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Leq;Z)V"
   )
   void method3317(Tile var1, boolean var2) {
      Scene_tilesDeque.method4977(var1);

      while(true) {
         Tile var3 = (Tile)Scene_tilesDeque.method4954();
         if(var3 == null) {
            return;
         }

         if(var3.drawSecondary) {
            int var4 = var3.x;
            int var5 = var3.y;
            int var6 = var3.plane;
            int var7 = var3.originalPlane;
            Tile[][] var8 = this.tiles[var6];
            Tile var9;
            BoundaryObject var10;
            int var11;
            GameObject var12;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            boolean var20;
            int var21;
            Tile var36;
            if(var3.drawPrimary) {
               if(var2) {
                  if(var6 > 0) {
                     var9 = this.tiles[var6 - 1][var4][var5];
                     if(var9 != null && var9.drawSecondary) {
                        continue;
                     }
                  }

                  if(var4 <= Scene_cameraXTile && var4 > Scene_cameraXTileMin) {
                     var9 = var8[var4 - 1][var5];
                     if(var9 != null && var9.drawSecondary && (var9.drawPrimary || (var3.gameObjectsEdgeMask & 1) == 0)) {
                        continue;
                     }
                  }

                  if(var4 >= Scene_cameraXTile && var4 < Scene_cameraXTileMax - 1) {
                     var9 = var8[var4 + 1][var5];
                     if(var9 != null && var9.drawSecondary && (var9.drawPrimary || (var3.gameObjectsEdgeMask & 4) == 0)) {
                        continue;
                     }
                  }

                  if(var5 <= Scene_cameraYTile && var5 > Scene_cameraYTileMin) {
                     var9 = var8[var4][var5 - 1];
                     if(var9 != null && var9.drawSecondary && (var9.drawPrimary || (var3.gameObjectsEdgeMask & 8) == 0)) {
                        continue;
                     }
                  }

                  if(var5 >= Scene_cameraYTile && var5 < Scene_cameraYTileMax - 1) {
                     var9 = var8[var4][var5 + 1];
                     if(var9 != null && var9.drawSecondary && (var9.drawPrimary || (var3.gameObjectsEdgeMask & 2) == 0)) {
                        continue;
                     }
                  }
               } else {
                  var2 = true;
               }

               var3.drawPrimary = false;
               if(var3.linkedBelowTile != null) {
                  var9 = var3.linkedBelowTile;
                  if(var9.paint != null) {
                     if(!this.method3177(0, var4, var5)) {
                        this.method3219(var9.paint, 0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var4, var5);
                     }
                  } else if(var9.model != null && !this.method3177(0, var4, var5)) {
                     this.method3300(var9.model, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var4, var5);
                  }

                  var10 = var9.boundaryObject;
                  if(var10 != null) {
                     Hooks.renderDraw(var10.entity1, 0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var10.x * 64 - Scene_cameraX, var10.tileHeight - Scene_cameraY, var10.y * 64 - Scene_cameraZ, var10.tag);
                  }

                  for(var11 = 0; var11 < var9.gameObjectsCount; ++var11) {
                     var12 = var9.gameObjects[var11];
                     if(var12 != null) {
                        Hooks.renderDraw(var12.entity, var12.orientation, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var12.centerX - Scene_cameraX, var12.height - Scene_cameraY, var12.centerY - Scene_cameraZ, var12.tag);
                     }
                  }
               }

               var20 = false;
               if(var3.paint != null) {
                  if(!this.method3177(var7, var4, var5)) {
                     var20 = true;
                     if(var3.paint.neColor != 12345678 || checkClick && var6 <= Scene_selectedPlane) {
                        this.method3219(var3.paint, var7, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var4, var5);
                     }
                  }
               } else if(var3.model != null && !this.method3177(var7, var4, var5)) {
                  var20 = true;
                  this.method3300(var3.model, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var4, var5);
               }

               var21 = 0;
               var11 = 0;
               BoundaryObject var31 = var3.boundaryObject;
               WallDecoration var13 = var3.wallDecoration;
               if(var31 != null || var13 != null) {
                  if(var4 == Scene_cameraXTile) {
                     ++var21;
                  } else if(Scene_cameraXTile < var4) {
                     var21 += 2;
                  }

                  if(var5 == Scene_cameraYTile) {
                     var21 += 3;
                  } else if(Scene_cameraYTile > var5) {
                     var21 += 6;
                  }

                  var11 = field1856[var21];
                  var3.field1680 = field1858[var21];
               }

               if(var31 != null) {
                  if((var31.orientationA & field1870[var21]) != 0) {
                     if(var31.orientationA == 16) {
                        var3.drawGameObjectEdges = 3;
                        var3.field1678 = field1820[var21];
                        var3.field1679 = 3 - var3.field1678;
                     } else if(var31.orientationA == 32) {
                        var3.drawGameObjectEdges = 6;
                        var3.field1678 = field1842[var21];
                        var3.field1679 = 6 - var3.field1678;
                     } else if(var31.orientationA == 64) {
                        var3.drawGameObjectEdges = 12;
                        var3.field1678 = field1861[var21];
                        var3.field1679 = 12 - var3.field1678;
                     } else {
                        var3.drawGameObjectEdges = 9;
                        var3.field1678 = field1814[var21];
                        var3.field1679 = 9 - var3.field1678;
                     }
                  } else {
                     var3.drawGameObjectEdges = 0;
                  }

                  if((var31.orientationA & var11) != 0 && !this.method3303(var7, var4, var5, var31.orientationA)) {
                     Hooks.renderDraw(var31.entity1, 0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var31.x * 64 - Scene_cameraX, var31.tileHeight - Scene_cameraY, var31.y * 64 - Scene_cameraZ, var31.tag);
                  }

                  if((var31.orientationB & var11) != 0 && !this.method3303(var7, var4, var5, var31.orientationB)) {
                     Hooks.renderDraw(var31.entity2, 0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var31.x * 64 - Scene_cameraX, var31.tileHeight - Scene_cameraY, var31.y * 64 - Scene_cameraZ, var31.tag);
                  }
               }

               if(var13 != null && !this.method3226(var7, var4, var5, var13.entity1.height)) {
                  if((var13.orientation & var11) != 0) {
                     Hooks.renderDraw(var13.entity1, 0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var13.x * 64 - Scene_cameraX + var13.xOffset, var13.tileHeight - Scene_cameraY, var13.y * 64 - Scene_cameraZ + var13.yOffset, var13.tag);
                  } else if(var13.orientation == 256) {
                     var14 = var13.x * 64 - Scene_cameraX;
                     var15 = var13.tileHeight - Scene_cameraY;
                     var16 = var13.y * 64 - Scene_cameraZ;
                     var17 = var13.orientation2;
                     if(var17 != 1 && var17 != 2) {
                        var18 = var14;
                     } else {
                        var18 = -var14;
                     }

                     int var19;
                     if(var17 != 2 && var17 != 3) {
                        var19 = var16;
                     } else {
                        var19 = -var16;
                     }

                     if(var19 < var18) {
                        Hooks.renderDraw(var13.entity1, 0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var14 + var13.xOffset, var15, var16 + var13.yOffset, var13.tag);
                     } else if(var13.entity2 != null) {
                        Hooks.renderDraw(var13.entity2, 0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var14, var15, var16, var13.tag);
                     }
                  }
               }

               if(var20) {
                  FloorDecoration var22 = var3.floorDecoration;
                  if(var22 != null) {
                     Hooks.renderDraw(var22.entity, 0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var22.x * 4096 - Scene_cameraX, var22.tileHeight - Scene_cameraY, var22.y * 4096 - Scene_cameraZ, var22.tag);
                  }

                  TileItemPile var23 = var3.tileItemPile;
                  if(var23 != null && var23.height == 0) {
                     if(var23.second != null) {
                        Hooks.renderDraw(var23.second, 0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var23.x * 64 - Scene_cameraX, var23.tileHeight - Scene_cameraY, var23.y * 64 - Scene_cameraZ, var23.tag);
                     }

                     if(var23.third != null) {
                        Hooks.renderDraw(var23.third, 0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var23.x * 64 - Scene_cameraX, var23.tileHeight - Scene_cameraY, var23.y * 64 - Scene_cameraZ, var23.tag);
                     }

                     if(var23.first != null) {
                        Hooks.renderDraw(var23.first, 0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var23.x * 64 - Scene_cameraX, var23.tileHeight - Scene_cameraY, var23.y * 64 - Scene_cameraZ, var23.tag);
                     }
                  }
               }

               var14 = var3.gameObjectsEdgeMask;
               if(var14 != 0) {
                  if(var4 < Scene_cameraXTile && (var14 & 4) != 0) {
                     var36 = var8[var4 + 1][var5];
                     if(var36 != null && var36.drawSecondary) {
                        Scene_tilesDeque.method4977(var36);
                     }
                  }

                  if(var5 < Scene_cameraYTile && (var14 & 2) != 0) {
                     var36 = var8[var4][var5 + 1];
                     if(var36 != null && var36.drawSecondary) {
                        Scene_tilesDeque.method4977(var36);
                     }
                  }

                  if(var4 > Scene_cameraXTile && (var14 & 1) != 0) {
                     var36 = var8[var4 - 1][var5];
                     if(var36 != null && var36.drawSecondary) {
                        Scene_tilesDeque.method4977(var36);
                     }
                  }

                  if(var5 > Scene_cameraYTile && (var14 & 8) != 0) {
                     var36 = var8[var4][var5 - 1];
                     if(var36 != null && var36.drawSecondary) {
                        Scene_tilesDeque.method4977(var36);
                     }
                  }
               }
            }

            if(var3.drawGameObjectEdges != 0) {
               var20 = true;

               for(var21 = 0; var21 < var3.gameObjectsCount; ++var21) {
                  if(var3.gameObjects[var21].lastDrawn != Scene_drawnCount && (var3.gameObjectEdgeMasks[var21] & var3.drawGameObjectEdges) == var3.field1678) {
                     var20 = false;
                     break;
                  }
               }

               if(var20) {
                  var10 = var3.boundaryObject;
                  if(!this.method3303(var7, var4, var5, var10.orientationA)) {
                     Hooks.renderDraw(var10.entity1, 0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var10.x * 64 - Scene_cameraX, var10.tileHeight - Scene_cameraY, var10.y * 64 - Scene_cameraZ, var10.tag);
                  }

                  var3.drawGameObjectEdges = 0;
               }
            }

            int var24;
            int var25;
            if(var3.drawGameObjects) {
               try {
                  int var34 = var3.gameObjectsCount;
                  var3.drawGameObjects = false;
                  var21 = 0;

                  label544:
                  for(var11 = 0; var11 < var34; ++var11) {
                     var12 = var3.gameObjects[var11];
                     if(var12.lastDrawn != Scene_drawnCount) {
                        for(var24 = var12.startX; var24 <= var12.endX; ++var24) {
                           for(var14 = var12.startY; var14 <= var12.endY; ++var14) {
                              var36 = var8[var24][var14];
                              if(var36.drawPrimary) {
                                 var3.drawGameObjects = true;
                                 continue label544;
                              }

                              if(var36.drawGameObjectEdges != 0) {
                                 var16 = 0;
                                 if(var24 > var12.startX) {
                                    ++var16;
                                 }

                                 if(var24 < var12.endX) {
                                    var16 += 4;
                                 }

                                 if(var14 > var12.startY) {
                                    var16 += 8;
                                 }

                                 if(var14 < var12.endY) {
                                    var16 += 2;
                                 }

                                 if((var16 & var36.drawGameObjectEdges) == var3.field1679) {
                                    var3.drawGameObjects = true;
                                    continue label544;
                                 }
                              }
                           }
                        }

                        gameObjects[var21++] = var12;
                        var24 = Scene_cameraXTile - var12.startX;
                        var14 = var12.endX - Scene_cameraXTile;
                        if(var14 > var24) {
                           var24 = var14;
                        }

                        var15 = Scene_cameraYTile - var12.startY;
                        var16 = var12.endY - Scene_cameraYTile;
                        if(var16 > var15) {
                           var12.field1950 = var24 + var16;
                        } else {
                           var12.field1950 = var24 + var15;
                        }
                     }
                  }

                  while(var21 > 0) {
                     var11 = -50;
                     var25 = -1;

                     for(var24 = 0; var24 < var21; ++var24) {
                        GameObject var35 = gameObjects[var24];
                        if(var35.lastDrawn != Scene_drawnCount) {
                           if(var35.field1950 > var11) {
                              var11 = var35.field1950;
                              var25 = var24;
                           } else if(var11 == var35.field1950) {
                              var15 = var35.centerX - Scene_cameraX;
                              var16 = var35.centerY - Scene_cameraZ;
                              var17 = gameObjects[var25].centerX - Scene_cameraX;
                              var18 = gameObjects[var25].centerY - Scene_cameraZ;
                              if(var15 * var15 + var16 * var16 > var17 * var17 + var18 * var18) {
                                 var25 = var24;
                              }
                           }
                        }
                     }

                     if(var25 == -1) {
                        break;
                     }

                     GameObject var33 = gameObjects[var25];
                     var33.lastDrawn = Scene_drawnCount;
                     if(!this.method3227(var7, var33.startX, var33.endX, var33.startY, var33.endY, var33.entity.height)) {
                        Hooks.renderDraw(var33.entity, var33.orientation, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var33.centerX - Scene_cameraX, var33.height - Scene_cameraY, var33.centerY - Scene_cameraZ, var33.tag);
                     }

                     for(var14 = var33.startX; var14 <= var33.endX; ++var14) {
                        for(var15 = var33.startY; var15 <= var33.endY; ++var15) {
                           Tile var26 = var8[var14][var15];
                           if(var26.drawGameObjectEdges != 0) {
                              Scene_tilesDeque.method4977(var26);
                           } else if((var14 != var4 || var15 != var5) && var26.drawSecondary) {
                              Scene_tilesDeque.method4977(var26);
                           }
                        }
                     }
                  }

                  if(var3.drawGameObjects) {
                     continue;
                  }
               } catch (Exception var28) {
                  var3.drawGameObjects = false;
               }
            }

            if(var3.drawSecondary && var3.drawGameObjectEdges == 0) {
               if(var4 <= Scene_cameraXTile && var4 > Scene_cameraXTileMin) {
                  var9 = var8[var4 - 1][var5];
                  if(var9 != null && var9.drawSecondary) {
                     continue;
                  }
               }

               if(var4 >= Scene_cameraXTile && var4 < Scene_cameraXTileMax - 1) {
                  var9 = var8[var4 + 1][var5];
                  if(var9 != null && var9.drawSecondary) {
                     continue;
                  }
               }

               if(var5 <= Scene_cameraYTile && var5 > Scene_cameraYTileMin) {
                  var9 = var8[var4][var5 - 1];
                  if(var9 != null && var9.drawSecondary) {
                     continue;
                  }
               }

               if(var5 >= Scene_cameraYTile && var5 < Scene_cameraYTileMax - 1) {
                  var9 = var8[var4][var5 + 1];
                  if(var9 != null && var9.drawSecondary) {
                     continue;
                  }
               }

               var3.drawSecondary = false;
               --tileUpdateCount;
               TileItemPile var32 = var3.tileItemPile;
               if(var32 != null && var32.height != 0) {
                  if(var32.second != null) {
                     Hooks.renderDraw(var32.second, 0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var32.x * 64 - Scene_cameraX, var32.tileHeight - Scene_cameraY - var32.height, var32.y * 64 - Scene_cameraZ, var32.tag);
                  }

                  if(var32.third != null) {
                     Hooks.renderDraw(var32.third, 0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var32.x * 64 - Scene_cameraX, var32.tileHeight - Scene_cameraY - var32.height, var32.y * 64 - Scene_cameraZ, var32.tag);
                  }

                  if(var32.first != null) {
                     Hooks.renderDraw(var32.first, 0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var32.x * 64 - Scene_cameraX, var32.tileHeight - Scene_cameraY - var32.height, var32.y * 64 - Scene_cameraZ, var32.tag);
                  }
               }

               if(var3.field1680 != 0) {
                  WallDecoration var29 = var3.wallDecoration;
                  if(var29 != null && !this.method3226(var7, var4, var5, var29.entity1.height)) {
                     if((var29.orientation & var3.field1680) != 0) {
                        Hooks.renderDraw(var29.entity1, 0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var29.x * 64 - Scene_cameraX + var29.xOffset, var29.tileHeight - Scene_cameraY, var29.y * 64 - Scene_cameraZ + var29.yOffset, var29.tag);
                     } else if(var29.orientation == 256) {
                        var11 = var29.x * 64 - Scene_cameraX;
                        var25 = var29.tileHeight - Scene_cameraY;
                        var24 = var29.y * 64 - Scene_cameraZ;
                        var14 = var29.orientation2;
                        if(var14 != 1 && var14 != 2) {
                           var15 = var11;
                        } else {
                           var15 = -var11;
                        }

                        if(var14 != 2 && var14 != 3) {
                           var16 = var24;
                        } else {
                           var16 = -var24;
                        }

                        if(var16 >= var15) {
                           Hooks.renderDraw(var29.entity1, 0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var11 + var29.xOffset, var25, var24 + var29.yOffset, var29.tag);
                        } else if(var29.entity2 != null) {
                           Hooks.renderDraw(var29.entity2, 0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var11, var25, var24, var29.tag);
                        }
                     }
                  }

                  BoundaryObject var27 = var3.boundaryObject;
                  if(var27 != null) {
                     if((var27.orientationB & var3.field1680) != 0 && !this.method3303(var7, var4, var5, var27.orientationB)) {
                        Hooks.renderDraw(var27.entity2, 0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var27.x * 64 - Scene_cameraX, var27.tileHeight - Scene_cameraY, var27.y * 64 - Scene_cameraZ, var27.tag);
                     }

                     if((var27.orientationA & var3.field1680) != 0 && !this.method3303(var7, var4, var5, var27.orientationA)) {
                        Hooks.renderDraw(var27.entity1, 0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var27.x * 64 - Scene_cameraX, var27.tileHeight - Scene_cameraY, var27.y * 64 - Scene_cameraZ, var27.tag);
                     }
                  }
               }

               Tile var30;
               if(var6 < this.planes - 1) {
                  var30 = this.tiles[var6 + 1][var4][var5];
                  if(var30 != null && var30.drawSecondary) {
                     Scene_tilesDeque.method4977(var30);
                  }
               }

               if(var4 < Scene_cameraXTile) {
                  var30 = var8[var4 + 1][var5];
                  if(var30 != null && var30.drawSecondary) {
                     Scene_tilesDeque.method4977(var30);
                  }
               }

               if(var5 < Scene_cameraYTile) {
                  var30 = var8[var4][var5 + 1];
                  if(var30 != null && var30.drawSecondary) {
                     Scene_tilesDeque.method4977(var30);
                  }
               }

               if(var4 > Scene_cameraXTile) {
                  var30 = var8[var4 - 1][var5];
                  if(var30 != null && var30.drawSecondary) {
                     Scene_tilesDeque.method4977(var30);
                  }
               }

               if(var5 > Scene_cameraYTile) {
                  var30 = var8[var4][var5 - 1];
                  if(var30 != null && var30.drawSecondary) {
                     Scene_tilesDeque.method4977(var30);
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Lev;IIIIIII)V"
   )
   void method3219(TilePaint var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if(!WorldMapSection1.client.isGpu()) {
         try {
            this.copy$drawTileUnderlay(var1, var2, var3, var4, var5, var6, var7, var8);
         } catch (Exception var41) {
            WorldMapSection1.client.getLogger().warn("error during tile underlay rendering", var41);
         }

      } else {
         DrawCallbacks var9 = WorldMapSection1.client.getDrawCallbacks();
         if(var9 != null) {
            try {
               int[][][] var10 = this.getTileHeights();
               int var11 = WorldMapSection1.client.getCameraX2();
               int var12 = WorldMapSection1.client.getCameraY2();
               int var13 = WorldMapSection1.client.getCameraZ2();
               int var14 = WorldMapSection1.client.get3dZoom();
               int var15 = WorldMapSection1.client.getCenterX();
               int var16 = WorldMapSection1.client.getCenterY();
               int var17 = WorldMapSection1.client.getMouseX2();
               int var18 = WorldMapSection1.client.getMouseY2();
               boolean var19 = WorldMapSection1.client.isCheckClick();
               int var20;
               int var21 = var20 = (var7 << 7) - var11;
               int var22;
               int var23 = var22 = (var8 << 7) - var13;
               int var24;
               int var25 = var24 = var21 + 128;
               int var26;
               int var27 = var26 = var23 + 128;
               int var28 = var10[var2][var7][var8] - var12;
               int var29 = var10[var2][var7 + 1][var8] - var12;
               int var30 = var10[var2][var7 + 1][var8 + 1] - var12;
               int var31 = var10[var2][var7][var8 + 1] - var12;
               int var32 = var21 * var6 + var5 * var23 >> 16;
               var23 = var23 * var6 - var5 * var21 >> 16;
               var21 = var32;
               var32 = var28 * var4 - var3 * var23 >> 16;
               var23 = var23 * var4 + var3 * var28 >> 16;
               var28 = var32;
               if(var23 >= 50) {
                  var32 = var25 * var6 + var5 * var22 >> 16;
                  var22 = var22 * var6 - var5 * var25 >> 16;
                  var25 = var32;
                  var32 = var29 * var4 - var3 * var22 >> 16;
                  var22 = var22 * var4 + var3 * var29 >> 16;
                  var29 = var32;
                  if(var22 >= 50) {
                     var32 = var24 * var6 + var5 * var27 >> 16;
                     var27 = var27 * var6 - var5 * var24 >> 16;
                     var24 = var32;
                     var32 = var30 * var4 - var3 * var27 >> 16;
                     var27 = var27 * var4 + var3 * var30 >> 16;
                     var30 = var32;
                     if(var27 >= 50) {
                        var32 = var20 * var6 + var5 * var26 >> 16;
                        var26 = var26 * var6 - var5 * var20 >> 16;
                        var20 = var32;
                        var32 = var31 * var4 - var3 * var26 >> 16;
                        var26 = var26 * var4 + var3 * var31 >> 16;
                        if(var26 >= 50) {
                           int var33 = var21 * var14 / var23 + var15;
                           int var34 = var28 * var14 / var23 + var16;
                           int var35 = var25 * var14 / var22 + var15;
                           int var36 = var29 * var14 / var22 + var16;
                           int var37 = var24 * var14 / var27 + var15;
                           int var38 = var30 * var14 / var27 + var16;
                           int var39 = var20 * var14 / var26 + var15;
                           int var40 = var32 * var14 / var26 + var16;
                           var9.drawScenePaint(0, var3, var4, var5, var6, -var11, -var12, -var13, var1, var2, var7, var8, var14, var15, var16);
                           if((var37 - var39) * (var36 - var40) - (var38 - var40) * (var35 - var39) > 0 && var19 && WorldMapSection1.client.containsBounds(var17, var18, var38, var40, var36, var37, var39, var35)) {
                              setTargetTile(var7, var8);
                           }

                           if((var33 - var35) * (var40 - var36) - (var34 - var36) * (var39 - var35) > 0 && var19 && WorldMapSection1.client.containsBounds(var17, var18, var34, var36, var40, var33, var35, var39)) {
                              setTargetTile(var7, var8);
                           }
                        }
                     }
                  }
               }
            } catch (Exception var42) {
               WorldMapSection1.client.getLogger().warn("error during underlay rendering", var42);
            }

         }
      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Lex;IIIIII)V"
   )
   void method3300(TileModel var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(!WorldMapSection1.client.isGpu()) {
         this.copy$drawTileOverlay(var1, var2, var3, var4, var5, var6, var7);
      } else {
         DrawCallbacks var8 = WorldMapSection1.client.getDrawCallbacks();
         if(var8 != null) {
            try {
               int var9 = WorldMapSection1.client.getCameraX2();
               int var10 = WorldMapSection1.client.getCameraY2();
               int var11 = WorldMapSection1.client.getCameraZ2();
               int var12 = WorldMapSection1.client.get3dZoom();
               int var13 = WorldMapSection1.client.getCenterX();
               int var14 = WorldMapSection1.client.getCenterY();
               var8.drawSceneModel(0, var2, var3, var4, var5, -var9, -var10, -var11, var1, WorldMapSection1.client.getPlane(), var6, var7, var12, var13, var14);
               boolean var15 = WorldMapSection1.client.isCheckClick();
               if(!var15) {
                  return;
               }

               RSTileModel var16 = (RSTileModel)var1;
               int[] var17 = var16.getFaceX();
               int[] var18 = var16.getFaceY();
               int[] var19 = var16.getFaceZ();
               int[] var20 = var16.getVertexX();
               int[] var21 = var16.getVertexY();
               int[] var22 = var16.getVertexZ();
               int var23 = var20.length;
               int var24 = var17.length;
               int var25 = WorldMapSection1.client.getMouseX2();
               int var26 = WorldMapSection1.client.getMouseY2();

               int var27;
               int var28;
               int var29;
               int var30;
               int var31;
               int var32;
               int var33;
               int var34;
               int var35;
               int var36;
               for(var27 = 0; var27 < var23; ++var27) {
                  var28 = var20[var27] - var9;
                  var29 = var21[var27] - var10;
                  var30 = var22[var27] - var11;
                  var31 = var30 * var4 + var5 * var28 >> 16;
                  var32 = var5 * var30 - var28 * var4 >> 16;
                  var33 = var3 * var29 - var32 * var2 >> 16;
                  var34 = var29 * var2 + var3 * var32 >> 16;
                  if(var34 < 50) {
                     return;
                  }

                  var35 = var31 * var12 / var34 + var13;
                  var36 = var33 * var12 / var34 + var14;
                  tmpX[var27] = var35;
                  tmpY[var27] = var36;
               }

               for(var27 = 0; var27 < var24; ++var27) {
                  var28 = var17[var27];
                  var29 = var18[var27];
                  var30 = var19[var27];
                  var31 = tmpX[var28];
                  var32 = tmpX[var29];
                  var33 = tmpX[var30];
                  var34 = tmpY[var28];
                  var35 = tmpY[var29];
                  var36 = tmpY[var30];
                  if((var31 - var32) * (var36 - var35) - (var34 - var35) * (var33 - var32) > 0 && WorldMapSection1.client.containsBounds(var25, var26, var34, var35, var36, var31, var32, var33)) {
                     setTargetTile(var6, var7);
                     break;
                  }
               }
            } catch (Exception var38) {
               WorldMapSection1.client.getLogger().warn("error during overlay rendering", var38);
            }

         }
      }
   }

   @ObfuscatedName("bc")
   void method3223() {
      int var1 = Scene_planeOccluderCounts[Scene_plane];
      Occluder[] var2 = Scene_planeOccluders[Scene_plane];
      Scene_currentOccludersCount = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         Occluder var4 = var2[var3];
         int var5;
         int var6;
         int var7;
         boolean var8;
         int var9;
         if(var4.type == 1) {
            var5 = var4.minTileX - Scene_cameraXTile + 90;
            if(var5 >= 0 && var5 <= 50) {
               var6 = var4.minTileY - Scene_cameraYTile + 90;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = var4.maxTileY - Scene_cameraYTile + 90;
               if(var7 > 50) {
                  var7 = 50;
               }

               var8 = false;

               while(var6 <= var7) {
                  if(visibleTiles[var5][var6++]) {
                     var8 = true;
                     break;
                  }
               }

               if(var8) {
                  var9 = Scene_cameraX - var4.minX;
                  if(var9 > 32) {
                     var4.field1916 = 1;
                  } else {
                     if(var9 >= -32) {
                        continue;
                     }

                     var4.field1916 = 2;
                     var9 = -var9;
                  }

                  var4.field1920 = (var4.minZ - Scene_cameraZ << 8) / var9;
                  var4.field1908 = (var4.maxZ - Scene_cameraZ << 8) / var9;
                  var4.field1921 = (var4.minY - Scene_cameraY << 8) / var9;
                  var4.field1922 = (var4.maxY - Scene_cameraY << 8) / var9;
                  Scene_currentOccluders[Scene_currentOccludersCount++] = var4;
               }
            }
         } else if(var4.type == 2) {
            var5 = var4.minTileY - Scene_cameraYTile + 90;
            if(var5 >= 0 && var5 <= 50) {
               var6 = var4.minTileX - Scene_cameraXTile + 90;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = var4.maxTileX - Scene_cameraXTile + 90;
               if(var7 > 50) {
                  var7 = 50;
               }

               var8 = false;

               while(var6 <= var7) {
                  if(visibleTiles[var6++][var5]) {
                     var8 = true;
                     break;
                  }
               }

               if(var8) {
                  var9 = Scene_cameraZ - var4.minZ;
                  if(var9 > 32) {
                     var4.field1916 = 3;
                  } else {
                     if(var9 >= -32) {
                        continue;
                     }

                     var4.field1916 = 4;
                     var9 = -var9;
                  }

                  var4.field1917 = (var4.minX - Scene_cameraX << 8) / var9;
                  var4.field1914 = (var4.maxX - Scene_cameraX << 8) / var9;
                  var4.field1921 = (var4.minY - Scene_cameraY << 8) / var9;
                  var4.field1922 = (var4.maxY - Scene_cameraY << 8) / var9;
                  Scene_currentOccluders[Scene_currentOccludersCount++] = var4;
               }
            }
         } else if(var4.type == 4) {
            var5 = var4.minY - Scene_cameraY;
            if(var5 > 128) {
               var6 = var4.minTileY - Scene_cameraYTile + 90;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = var4.maxTileY - Scene_cameraYTile + 90;
               if(var7 > 50) {
                  var7 = 50;
               }

               if(var6 <= var7) {
                  int var13 = var4.minTileX - Scene_cameraXTile + 90;
                  if(var13 < 0) {
                     var13 = 0;
                  }

                  var9 = var4.maxTileX - Scene_cameraXTile + 90;
                  if(var9 > 50) {
                     var9 = 50;
                  }

                  boolean var10 = false;

                  label129:
                  for(int var11 = var13; var11 <= var9; ++var11) {
                     for(int var12 = var6; var12 <= var7; ++var12) {
                        if(visibleTiles[var11][var12]) {
                           var10 = true;
                           break label129;
                        }
                     }
                  }

                  if(var10) {
                     var4.field1916 = 5;
                     var4.field1917 = (var4.minX - Scene_cameraX << 8) / var5;
                     var4.field1914 = (var4.maxX - Scene_cameraX << 8) / var5;
                     var4.field1920 = (var4.minZ - Scene_cameraZ << 8) / var5;
                     var4.field1908 = (var4.maxZ - Scene_cameraZ << 8) / var5;
                     Scene_currentOccluders[Scene_currentOccludersCount++] = var4;
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("bo")
   boolean method3177(int var1, int var2, int var3) {
      int var4 = this.field1819[var1][var2][var3];
      if(var4 == -Scene_drawnCount) {
         return false;
      } else if(var4 == Scene_drawnCount) {
         return true;
      } else {
         int var5 = var2 << 7;
         int var6 = var3 << 7;
         if(this.method3228(var5 + 1, this.tileHeights[var1][var2][var3], var6 + 1) && this.method3228(var5 + 128 - 1, this.tileHeights[var1][var2 + 1][var3], var6 + 1) && this.method3228(var5 + 128 - 1, this.tileHeights[var1][var2 + 1][var3 + 1], var6 + 128 - 1) && this.method3228(var5 + 1, this.tileHeights[var1][var2][var3 + 1], var6 + 128 - 1)) {
            this.field1819[var1][var2][var3] = Scene_drawnCount;
            return true;
         } else {
            this.field1819[var1][var2][var3] = -Scene_drawnCount;
            return false;
         }
      }
   }

   @ObfuscatedName("bd")
   boolean method3303(int var1, int var2, int var3, int var4) {
      if(!this.method3177(var1, var2, var3)) {
         return false;
      } else {
         int var5 = var2 << 7;
         int var6 = var3 << 7;
         int var7 = this.tileHeights[var1][var2][var3] - 1;
         int var8 = var7 - 120;
         int var9 = var7 - 230;
         int var10 = var7 - 238;
         if(var4 < 16) {
            if(var4 == 1) {
               if(var5 > Scene_cameraX) {
                  if(!this.method3228(var5, var7, var6)) {
                     return false;
                  }

                  if(!this.method3228(var5, var7, var6 + 128)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method3228(var5, var8, var6)) {
                     return false;
                  }

                  if(!this.method3228(var5, var8, var6 + 128)) {
                     return false;
                  }
               }

               if(!this.method3228(var5, var9, var6)) {
                  return false;
               }

               if(!this.method3228(var5, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if(var4 == 2) {
               if(var6 < Scene_cameraZ) {
                  if(!this.method3228(var5, var7, var6 + 128)) {
                     return false;
                  }

                  if(!this.method3228(var5 + 128, var7, var6 + 128)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method3228(var5, var8, var6 + 128)) {
                     return false;
                  }

                  if(!this.method3228(var5 + 128, var8, var6 + 128)) {
                     return false;
                  }
               }

               if(!this.method3228(var5, var9, var6 + 128)) {
                  return false;
               }

               if(!this.method3228(var5 + 128, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if(var4 == 4) {
               if(var5 < Scene_cameraX) {
                  if(!this.method3228(var5 + 128, var7, var6)) {
                     return false;
                  }

                  if(!this.method3228(var5 + 128, var7, var6 + 128)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method3228(var5 + 128, var8, var6)) {
                     return false;
                  }

                  if(!this.method3228(var5 + 128, var8, var6 + 128)) {
                     return false;
                  }
               }

               if(!this.method3228(var5 + 128, var9, var6)) {
                  return false;
               }

               if(!this.method3228(var5 + 128, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if(var4 == 8) {
               if(var6 > Scene_cameraZ) {
                  if(!this.method3228(var5, var7, var6)) {
                     return false;
                  }

                  if(!this.method3228(var5 + 128, var7, var6)) {
                     return false;
                  }
               }

               if(var1 > 0) {
                  if(!this.method3228(var5, var8, var6)) {
                     return false;
                  }

                  if(!this.method3228(var5 + 128, var8, var6)) {
                     return false;
                  }
               }

               if(!this.method3228(var5, var9, var6)) {
                  return false;
               }

               if(!this.method3228(var5 + 128, var9, var6)) {
                  return false;
               }

               return true;
            }
         }

         return !this.method3228(var5 + 64, var10, var6 + 64)?false:(var4 == 16?this.method3228(var5, var9, var6 + 128):(var4 == 32?this.method3228(var5 + 128, var9, var6 + 128):(var4 == 64?this.method3228(var5 + 128, var9, var6):(var4 == 128?this.method3228(var5, var9, var6):true))));
      }
   }

   @ObfuscatedName("bk")
   boolean method3226(int var1, int var2, int var3, int var4) {
      if(!this.method3177(var1, var2, var3)) {
         return false;
      } else {
         int var5 = var2 << 7;
         int var6 = var3 << 7;
         return this.method3228(var5 + 1, this.tileHeights[var1][var2][var3] - var4, var6 + 1) && this.method3228(var5 + 128 - 1, this.tileHeights[var1][var2 + 1][var3] - var4, var6 + 1) && this.method3228(var5 + 128 - 1, this.tileHeights[var1][var2 + 1][var3 + 1] - var4, var6 + 128 - 1) && this.method3228(var5 + 1, this.tileHeights[var1][var2][var3 + 1] - var4, var6 + 128 - 1);
      }
   }

   @ObfuscatedName("bu")
   boolean method3227(int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      int var8;
      if(var3 == var2 && var5 == var4) {
         if(!this.method3177(var1, var2, var4)) {
            return false;
         } else {
            var7 = var2 << 7;
            var8 = var4 << 7;
            return this.method3228(var7 + 1, this.tileHeights[var1][var2][var4] - var6, var8 + 1) && this.method3228(var7 + 128 - 1, this.tileHeights[var1][var2 + 1][var4] - var6, var8 + 1) && this.method3228(var7 + 128 - 1, this.tileHeights[var1][var2 + 1][var4 + 1] - var6, var8 + 128 - 1) && this.method3228(var7 + 1, this.tileHeights[var1][var2][var4 + 1] - var6, var8 + 128 - 1);
         }
      } else {
         for(var7 = var2; var7 <= var3; ++var7) {
            for(var8 = var4; var8 <= var5; ++var8) {
               if(this.field1819[var1][var7][var8] == -Scene_drawnCount) {
                  return false;
               }
            }
         }

         var7 = (var2 << 7) + 1;
         var8 = (var4 << 7) + 2;
         int var9 = this.tileHeights[var1][var2][var4] - var6;
         if(!this.method3228(var7, var9, var8)) {
            return false;
         } else {
            int var10 = (var3 << 7) - 1;
            if(!this.method3228(var10, var9, var8)) {
               return false;
            } else {
               int var11 = (var5 << 7) - 1;
               if(!this.method3228(var7, var9, var11)) {
                  return false;
               } else if(!this.method3228(var10, var9, var11)) {
                  return false;
               } else {
                  return true;
               }
            }
         }
      }
   }

   @ObfuscatedName("be")
   boolean method3228(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Scene_currentOccludersCount; ++var4) {
         Occluder var5 = Scene_currentOccluders[var4];
         int var6;
         int var7;
         int var8;
         int var9;
         int var10;
         if(var5.field1916 == 1) {
            var6 = var5.minX - var1;
            if(var6 > 0) {
               var7 = (var6 * var5.field1920 >> 8) + var5.minZ;
               var8 = (var6 * var5.field1908 >> 8) + var5.maxZ;
               var9 = (var6 * var5.field1921 >> 8) + var5.minY;
               var10 = (var6 * var5.field1922 >> 8) + var5.maxY;
               if(var3 >= var7 && var3 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field1916 == 2) {
            var6 = var1 - var5.minX;
            if(var6 > 0) {
               var7 = (var6 * var5.field1920 >> 8) + var5.minZ;
               var8 = (var6 * var5.field1908 >> 8) + var5.maxZ;
               var9 = (var6 * var5.field1921 >> 8) + var5.minY;
               var10 = (var6 * var5.field1922 >> 8) + var5.maxY;
               if(var3 >= var7 && var3 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field1916 == 3) {
            var6 = var5.minZ - var3;
            if(var6 > 0) {
               var7 = (var6 * var5.field1917 >> 8) + var5.minX;
               var8 = (var6 * var5.field1914 >> 8) + var5.maxX;
               var9 = (var6 * var5.field1921 >> 8) + var5.minY;
               var10 = (var6 * var5.field1922 >> 8) + var5.maxY;
               if(var1 >= var7 && var1 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field1916 == 4) {
            var6 = var3 - var5.minZ;
            if(var6 > 0) {
               var7 = (var6 * var5.field1917 >> 8) + var5.minX;
               var8 = (var6 * var5.field1914 >> 8) + var5.maxX;
               var9 = (var6 * var5.field1921 >> 8) + var5.minY;
               var10 = (var6 * var5.field1922 >> 8) + var5.maxY;
               if(var1 >= var7 && var1 <= var8 && var2 >= var9 && var2 <= var10) {
                  return true;
               }
            }
         } else if(var5.field1916 == 5) {
            var6 = var2 - var5.minY;
            if(var6 > 0) {
               var7 = (var6 * var5.field1917 >> 8) + var5.minX;
               var8 = (var6 * var5.field1914 >> 8) + var5.maxX;
               var9 = (var6 * var5.field1920 >> 8) + var5.minZ;
               var10 = (var6 * var5.field1908 >> 8) + var5.maxZ;
               if(var1 >= var7 && var1 <= var8 && var3 >= var9 && var3 <= var10) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   @ObfuscatedSignature(
      signature = "(IIIILee;JLee;Lee;)V"
   )
   public void copy$newGroundItemPile(int var1, int var2, int var3, int var4, Entity var5, long var6, Entity var8, Entity var9) {
      TileItemPile var10 = new TileItemPile();
      var10.first = var5;
      var10.x = var2 * 8192 + 4096;
      var10.y = var3 * 8192 + 4096;
      var10.tileHeight = var4;
      var10.tag = var6;
      var10.second = var8;
      var10.third = var9;
      int var11 = 0;
      Tile var12 = this.tiles[var1][var2][var3];
      if(var12 != null) {
         for(int var13 = 0; var13 < var12.gameObjectsCount; ++var13) {
            if((var12.gameObjects[var13].flags & 256) == 256 && var12.gameObjects[var13].entity instanceof Model) {
               Model var14 = (Model)var12.gameObjects[var13].entity;
               var14.method2969();
               if(var14.height > var11) {
                  var11 = var14.height;
               }
            }
         }
      }

      var10.height = var11;
      if(this.tiles[var1][var2][var3] == null) {
         this.tiles[var1][var2][var3] = new Tile(var1, var2, var3);
      }

      this.tiles[var1][var2][var3].tileItemPile = var10;
      this.tiles[var1][var2][var3].itemLayerChanged(-1);
   }

   @ObfuscatedSignature(
      signature = "(IIIILee;JI)V"
   )
   public void copy$newFloorDecoration(int var1, int var2, int var3, int var4, Entity var5, long var6, int var8) {
      if(var5 != null) {
         FloorDecoration var9 = new FloorDecoration();
         var9.entity = var5;
         var9.x = var2 * 128 + 64;
         var9.y = var3 * 128 + 64;
         var9.tileHeight = var4;
         var9.tag = var6;
         var9.flags = var8;
         if(this.tiles[var1][var2][var3] == null) {
            this.tiles[var1][var2][var3] = new Tile(var1, var2, var3);
         }

         this.tiles[var1][var2][var3].floorDecoration = var9;
         this.tiles[var1][var2][var3].groundObjectChanged(-1);
      }
   }

   @ObfuscatedSignature(
      signature = "(IIIILee;Lee;IIJI)V"
   )
   public void copy$newBoundaryObject(int var1, int var2, int var3, int var4, Entity var5, Entity var6, int var7, int var8, long var9, int var11) {
      if(var5 != null || var6 != null) {
         BoundaryObject var12 = new BoundaryObject();
         var12.tag = var9;
         var12.flags = var11;
         var12.x = var2 * 8192 + 4096;
         var12.y = var3 * 8192 + 4096;
         var12.tileHeight = var4;
         var12.entity1 = var5;
         var12.entity2 = var6;
         var12.orientationA = var7;
         var12.orientationB = var8;

         for(int var13 = var1; var13 >= 0; --var13) {
            if(this.tiles[var13][var2][var3] == null) {
               this.tiles[var13][var2][var3] = new Tile(var13, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].boundaryObject = var12;
         this.tiles[var1][var2][var3].wallObjectChanged(-1);
      }
   }

   @ObfuscatedSignature(
      signature = "(IIIILee;Lee;IIIIJI)V"
   )
   public void copy$newWallDecoration(int var1, int var2, int var3, int var4, Entity var5, Entity var6, int var7, int var8, int var9, int var10, long var11, int var13) {
      if(var5 != null) {
         WallDecoration var14 = new WallDecoration();
         var14.tag = var11;
         var14.flags = var13;
         var14.x = var2 * 8192 + 4096;
         var14.y = var3 * 8192 + 4096;
         var14.tileHeight = var4;
         var14.entity1 = var5;
         var14.entity2 = var6;
         var14.orientation = var7;
         var14.orientation2 = var8;
         var14.xOffset = var9;
         var14.yOffset = var10;

         for(int var15 = var1; var15 >= 0; --var15) {
            if(this.tiles[var15][var2][var3] == null) {
               this.tiles[var15][var2][var3] = new Tile(var15, var2, var3);
            }
         }

         this.tiles[var1][var2][var3].wallDecoration = var14;
         this.tiles[var1][var2][var3].decorativeObjectChanged(-1);
      }
   }

   public void copy$drawTileMinimap(int[] var1, int var2, int var3, int var4, int var5, int var6) {
      Tile var7 = this.tiles[var4][var5][var6];
      if(var7 != null) {
         TilePaint var8 = var7.paint;
         int var10;
         if(var8 != null) {
            int var9 = var8.rgb;
            if(var9 != 0) {
               for(var10 = 0; var10 < 4; ++var10) {
                  var1[var2] = var9;
                  var1[var2 + 1] = var9;
                  var1[var2 + 2] = var9;
                  var1[var2 + 3] = var9;
                  var2 += var3;
               }

            }
         } else {
            TileModel var18 = var7.model;
            if(var18 != null) {
               var10 = var18.shape;
               int var11 = var18.rotation;
               int var12 = var18.underlayRgb;
               int var13 = var18.overlayRgb;
               int[] var14 = this.tileShape2D[var10];
               int[] var15 = this.tileRotation2D[var11];
               int var16 = 0;
               int var17;
               if(var12 != 0) {
                  for(var17 = 0; var17 < 4; ++var17) {
                     var1[var2] = var14[var15[var16++]] == 0?var12:var13;
                     var1[var2 + 1] = var14[var15[var16++]] == 0?var12:var13;
                     var1[var2 + 2] = var14[var15[var16++]] == 0?var12:var13;
                     var1[var2 + 3] = var14[var15[var16++]] == 0?var12:var13;
                     var2 += var3;
                  }
               } else {
                  for(var17 = 0; var17 < 4; ++var17) {
                     if(var14[var15[var16++]] != 0) {
                        var1[var2] = var13;
                     }

                     if(var14[var15[var16++]] != 0) {
                        var1[var2 + 1] = var13;
                     }

                     if(var14[var15[var16++]] != 0) {
                        var1[var2 + 2] = var13;
                     }

                     if(var14[var15[var16++]] != 0) {
                        var1[var2 + 3] = var13;
                     }

                     var2 += var3;
                  }
               }

            }
         }
      }
   }

   public RSTile[][][] getTiles() {
      return this.tiles;
   }

   @ObfuscatedSignature(
      signature = "(Lex;IIIIII)V"
   )
   public void copy$drawTileOverlay(TileModel var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      int var8 = var1.vertexX.length;

      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      for(var9 = 0; var9 < var8; ++var9) {
         var10 = var1.vertexX[var9] - Scene_cameraX;
         var11 = var1.vertexY[var9] - Scene_cameraY;
         var12 = var1.vertexZ[var9] - Scene_cameraZ;
         var13 = var12 * var4 + var5 * var10 >> 16;
         var12 = var5 * var12 - var10 * var4 >> 16;
         var10 = var13;
         var13 = var3 * var11 - var12 * var2 >> 16;
         var12 = var11 * var2 + var3 * var12 >> 16;
         if(var12 < 50) {
            return;
         }

         if(var1.triangleTextureId != null) {
            TileModel.field1613[var9] = var10;
            TileModel.field1623[var9] = var13;
            TileModel.field1620[var9] = var12;
         }

         TileModel.field1615[var9] = var10 * Rasterizer3D.Rasterizer3D_zoom / var12 + Rasterizer3D.Rasterizer3D_clipMidX;
         TileModel.field1605[var9] = var13 * Rasterizer3D.Rasterizer3D_zoom / var12 + Rasterizer3D.Rasterizer3D_clipMidY;
      }

      Rasterizer3D.Rasterizer3D_alpha = 0;
      var8 = var1.faceX.length;

      for(var9 = 0; var9 < var8; ++var9) {
         var10 = var1.faceX[var9];
         var11 = var1.faceY[var9];
         var12 = var1.faceZ[var9];
         var13 = TileModel.field1615[var10];
         int var14 = TileModel.field1615[var11];
         int var15 = TileModel.field1615[var12];
         int var16 = TileModel.field1605[var10];
         int var17 = TileModel.field1605[var11];
         int var18 = TileModel.field1605[var12];
         if((var13 - var14) * (var18 - var17) - (var16 - var17) * (var15 - var14) > 0) {
            Rasterizer3D.field1778 = false;
            if(var13 < 0 || var14 < 0 || var15 < 0 || var13 > Rasterizer3D.Rasterizer3D_clipWidth || var14 > Rasterizer3D.Rasterizer3D_clipWidth || var15 > Rasterizer3D.Rasterizer3D_clipWidth) {
               Rasterizer3D.field1778 = true;
            }

            if(checkClick && method3222(Scene_selectedScreenX, Scene_selectedScreenY, var16, var17, var18, var13, var14, var15)) {
               Scene_selectedX = var6;
               Scene_selectedY = var7;
            }

            if(var1.triangleTextureId != null && var1.triangleTextureId[var9] != -1) {
               if(!Scene_isLowDetail) {
                  if(var1.isFlat) {
                     Rasterizer3D.method3135(var16, var17, var18, var13, var14, var15, var1.triangleColorA[var9], var1.triangleColorB[var9], var1.triangleColorC[var9], TileModel.field1613[0], TileModel.field1613[1], TileModel.field1613[3], TileModel.field1623[0], TileModel.field1623[1], TileModel.field1623[3], TileModel.field1620[0], TileModel.field1620[1], TileModel.field1620[3], var1.triangleTextureId[var9]);
                  } else {
                     Rasterizer3D.method3135(var16, var17, var18, var13, var14, var15, var1.triangleColorA[var9], var1.triangleColorB[var9], var1.triangleColorC[var9], TileModel.field1613[var10], TileModel.field1613[var11], TileModel.field1613[var12], TileModel.field1623[var10], TileModel.field1623[var11], TileModel.field1623[var12], TileModel.field1620[var10], TileModel.field1620[var11], TileModel.field1620[var12], var1.triangleTextureId[var9]);
                  }
               } else {
                  int var19 = Rasterizer3D.Rasterizer3D_textureLoader.vmethod3386(var1.triangleTextureId[var9]);
                  Rasterizer3D.method3105(var16, var17, var18, var13, var14, var15, method3221(var19, var1.triangleColorA[var9]), method3221(var19, var1.triangleColorB[var9]), method3221(var19, var1.triangleColorC[var9]));
               }
            } else if(var1.triangleColorA[var9] != 12345678) {
               Rasterizer3D.method3105(var16, var17, var18, var13, var14, var15, var1.triangleColorA[var9], var1.triangleColorB[var9], var1.triangleColorC[var9]);
            }
         }
      }

   }

   @ObfuscatedSignature(
      signature = "(Lev;IIIIIII)V"
   )
   public void copy$drawTileUnderlay(TilePaint var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int var9;
      int var10 = var9 = (var7 << 7) - Scene_cameraX;
      int var11;
      int var12 = var11 = (var8 << 7) - Scene_cameraZ;
      int var13;
      int var14 = var13 = var10 + 128;
      int var15;
      int var16 = var15 = var12 + 128;
      int var17 = this.tileHeights[var2][var7][var8] - Scene_cameraY;
      int var18 = this.tileHeights[var2][var7 + 1][var8] - Scene_cameraY;
      int var19 = this.tileHeights[var2][var7 + 1][var8 + 1] - Scene_cameraY;
      int var20 = this.tileHeights[var2][var7][var8 + 1] - Scene_cameraY;
      int var21 = var10 * var6 + var5 * var12 >> 16;
      var12 = var12 * var6 - var5 * var10 >> 16;
      var10 = var21;
      var21 = var17 * var4 - var3 * var12 >> 16;
      var12 = var12 * var4 + var3 * var17 >> 16;
      var17 = var21;
      if(var12 >= 50) {
         var21 = var14 * var6 + var5 * var11 >> 16;
         var11 = var11 * var6 - var5 * var14 >> 16;
         var14 = var21;
         var21 = var18 * var4 - var3 * var11 >> 16;
         var11 = var11 * var4 + var3 * var18 >> 16;
         var18 = var21;
         if(var11 >= 50) {
            var21 = var13 * var6 + var5 * var16 >> 16;
            var16 = var16 * var6 - var5 * var13 >> 16;
            var13 = var21;
            var21 = var19 * var4 - var3 * var16 >> 16;
            var16 = var16 * var4 + var3 * var19 >> 16;
            var19 = var21;
            if(var16 >= 50) {
               var21 = var9 * var6 + var5 * var15 >> 16;
               var15 = var15 * var6 - var5 * var9 >> 16;
               var9 = var21;
               var21 = var20 * var4 - var3 * var15 >> 16;
               var15 = var15 * var4 + var3 * var20 >> 16;
               if(var15 >= 50) {
                  int var22 = var10 * Rasterizer3D.Rasterizer3D_zoom / var12 + Rasterizer3D.Rasterizer3D_clipMidX;
                  int var23 = var17 * Rasterizer3D.Rasterizer3D_zoom / var12 + Rasterizer3D.Rasterizer3D_clipMidY;
                  int var24 = var14 * Rasterizer3D.Rasterizer3D_zoom / var11 + Rasterizer3D.Rasterizer3D_clipMidX;
                  int var25 = var18 * Rasterizer3D.Rasterizer3D_zoom / var11 + Rasterizer3D.Rasterizer3D_clipMidY;
                  int var26 = var13 * Rasterizer3D.Rasterizer3D_zoom / var16 + Rasterizer3D.Rasterizer3D_clipMidX;
                  int var27 = var19 * Rasterizer3D.Rasterizer3D_zoom / var16 + Rasterizer3D.Rasterizer3D_clipMidY;
                  int var28 = var9 * Rasterizer3D.Rasterizer3D_zoom / var15 + Rasterizer3D.Rasterizer3D_clipMidX;
                  int var29 = var21 * Rasterizer3D.Rasterizer3D_zoom / var15 + Rasterizer3D.Rasterizer3D_clipMidY;
                  Rasterizer3D.Rasterizer3D_alpha = 0;
                  int var30;
                  if((var26 - var28) * (var25 - var29) - (var27 - var29) * (var24 - var28) > 0) {
                     Rasterizer3D.field1778 = false;
                     if(var26 < 0 || var28 < 0 || var24 < 0 || var26 > Rasterizer3D.Rasterizer3D_clipWidth || var28 > Rasterizer3D.Rasterizer3D_clipWidth || var24 > Rasterizer3D.Rasterizer3D_clipWidth) {
                        Rasterizer3D.field1778 = true;
                     }

                     if(checkClick && method3222(Scene_selectedScreenX, Scene_selectedScreenY, var27, var29, var25, var26, var28, var24)) {
                        Scene_selectedX = var7;
                        Scene_selectedY = var8;
                     }

                     if(var1.texture == -1) {
                        if(var1.neColor != 12345678) {
                           Rasterizer3D.method3105(var27, var29, var25, var26, var28, var24, var1.neColor, var1.nwColor, var1.seColor);
                        }
                     } else if(!Scene_isLowDetail) {
                        if(var1.isFlat) {
                           Rasterizer3D.method3135(var27, var29, var25, var26, var28, var24, var1.neColor, var1.nwColor, var1.seColor, var10, var14, var9, var17, var18, var21, var12, var11, var15, var1.texture);
                        } else {
                           Rasterizer3D.method3135(var27, var29, var25, var26, var28, var24, var1.neColor, var1.nwColor, var1.seColor, var13, var9, var14, var19, var21, var18, var16, var15, var11, var1.texture);
                        }
                     } else {
                        var30 = Rasterizer3D.Rasterizer3D_textureLoader.vmethod3386(var1.texture);
                        Rasterizer3D.method3105(var27, var29, var25, var26, var28, var24, method3221(var30, var1.neColor), method3221(var30, var1.nwColor), method3221(var30, var1.seColor));
                     }
                  }

                  if((var22 - var24) * (var29 - var25) - (var23 - var25) * (var28 - var24) > 0) {
                     Rasterizer3D.field1778 = false;
                     if(var22 < 0 || var24 < 0 || var28 < 0 || var22 > Rasterizer3D.Rasterizer3D_clipWidth || var24 > Rasterizer3D.Rasterizer3D_clipWidth || var28 > Rasterizer3D.Rasterizer3D_clipWidth) {
                        Rasterizer3D.field1778 = true;
                     }

                     if(checkClick && method3222(Scene_selectedScreenX, Scene_selectedScreenY, var23, var25, var29, var22, var24, var28)) {
                        Scene_selectedX = var7;
                        Scene_selectedY = var8;
                     }

                     if(var1.texture == -1) {
                        if(var1.swColor != 12345678) {
                           Rasterizer3D.method3105(var23, var25, var29, var22, var24, var28, var1.swColor, var1.seColor, var1.nwColor);
                        }
                     } else if(!Scene_isLowDetail) {
                        Rasterizer3D.method3135(var23, var25, var29, var22, var24, var28, var1.swColor, var1.seColor, var1.nwColor, var10, var14, var9, var17, var18, var21, var12, var11, var15, var1.texture);
                     } else {
                        var30 = Rasterizer3D.Rasterizer3D_textureLoader.vmethod3386(var1.texture);
                        Rasterizer3D.method3105(var23, var25, var29, var22, var24, var28, method3221(var30, var1.swColor), method3221(var30, var1.seColor), method3221(var30, var1.nwColor));
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedSignature(
      signature = "(IIIIIIIILee;IZJI)Z"
   )
   public boolean copy$newGameObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, Entity var9, int var10, boolean var11, long var12, int var14) {
      int var16;
      for(int var15 = var2; var15 < var2 + var4; ++var15) {
         for(var16 = var3; var16 < var3 + var5; ++var16) {
            if(var15 < 0 || var16 < 0 || var15 >= this.xSize || var16 >= this.ySize) {
               return false;
            }

            Tile var17 = this.tiles[var1][var15][var16];
            if(var17 != null && var17.gameObjectsCount >= 5) {
               return false;
            }
         }
      }

      GameObject var21 = new GameObject();
      var21.tag = var12;
      var21.flags = var14;
      var21.plane = var1;
      var21.centerX = var6;
      var21.centerY = var7;
      var21.height = var8;
      var21.entity = var9;
      var21.orientation = var10;
      var21.startX = var2;
      var21.startY = var3;
      var21.endX = var2 + var4 - 1;
      var21.endY = var3 + var5 - 1;

      for(var16 = var2; var16 < var2 + var4; ++var16) {
         for(int var22 = var3; var22 < var3 + var5; ++var22) {
            int var18 = 0;
            if(var16 > var2) {
               ++var18;
            }

            if(var16 < var2 + var4 - 1) {
               var18 += 4;
            }

            if(var22 > var3) {
               var18 += 8;
            }

            if(var22 < var3 + var5 - 1) {
               var18 += 2;
            }

            for(int var19 = var1; var19 >= 0; --var19) {
               if(this.tiles[var19][var16][var22] == null) {
                  this.tiles[var19][var16][var22] = new Tile(var19, var16, var22);
               }
            }

            Tile var23 = this.tiles[var1][var16][var22];
            var23.gameObjects[var23.gameObjectsCount] = var21;
            var23.gameObjectsChanged(var23.gameObjectsCount);
            var23.gameObjectEdgeMasks[var23.gameObjectsCount] = var18;
            var23.gameObjectsEdgeMask |= var18;
            ++var23.gameObjectsCount;
         }
      }

      if(var11) {
         this.tempGameObjects[this.tempGameObjectsCount++] = var21;
      }

      return true;
   }

   public int[][][] getTileHeights() {
      return this.tileHeights;
   }

   public void rl$addTile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18, int var19, int var20) {
      if(var4 != 0 && var4 != 1) {
         RSTile var21 = this.getTiles()[var1][var2][var3];
         net.runelite.api.TileModel var22 = var21.getTileModel();
         var22.setUnderlaySwColor(var11);
         var22.setUnderlayNwColor(var12);
         var22.setUnderlayNeColor(var13);
         var22.setUnderlaySeColor(var14);
         var22.setOverlaySwColor(var15);
         var22.setOverlayNwColor(var16);
         var22.setOverlayNeColor(var17);
         var22.setOverlaySeColor(var18);
      }

   }

   public int[][] getTileShape2D() {
      return this.tileShape2D;
   }

   public int[][] getTileRotation2D() {
      return this.tileRotation2D;
   }

   public int getMaxX() {
      return this.xSize;
   }

   public int getMaxY() {
      return this.planes;
   }

   public int getMaxZ() {
      return this.ySize;
   }

   public int getMinLevel() {
      return this.minPlane;
   }

   public void updateOccluders() {
      this.method3223();
   }

   public void draw(net.runelite.api.Tile var1, boolean var2) {
      this.method3317((Tile)var1, var2);
   }

   public int getDrawDistance() {
      return rl$drawDistance;
   }

   public void setDrawDistance(int var1) {
      rl$drawDistance = var1;
   }

   public void addItem(int var1, int var2, WorldPoint var3) {
      int var4 = var3.getX() - WorldMapSection1.client.getBaseX();
      int var5 = var3.getY() - WorldMapSection1.client.getBaseY();
      int var6 = var3.getPlane();
      if(var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
         RSTileItem var7 = WorldMapSection1.client.newTileItem();
         var7.setId(var1);
         var7.setQuantity(var2);
         RSNodeDeque[][][] var8 = WorldMapSection1.client.getGroundItemDeque();
         if(var8[var6][var4][var5] == null) {
            var8[var6][var4][var5] = WorldMapSection1.client.newNodeDeque();
         }

         var8[var6][var4][var5].addFirst(var7);
         if(var6 == WorldMapSection1.client.getPlane()) {
            WorldMapSection1.client.updateItemPile(var4, var5);
         }

      }
   }

   public void removeItem(int var1, int var2, WorldPoint var3) {
      int var4 = var3.getX() - WorldMapSection1.client.getBaseX();
      int var5 = var3.getY() - WorldMapSection1.client.getBaseY();
      int var6 = var3.getPlane();
      if(var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
         RSNodeDeque var7 = WorldMapSection1.client.getGroundItemDeque()[var6][var4][var5];
         if(var7 != null) {
            for(RSTileItem var8 = (RSTileItem)var7.last(); var8 != null; var8 = (RSTileItem)var7.previous()) {
               if(var8.getId() == var1 && var2 == 1) {
                  var8.unlink();
                  break;
               }
            }

            if(var7.last() == null) {
               WorldMapSection1.client.getGroundItemDeque()[var6][var4][var5] = null;
            }

            WorldMapSection1.client.updateItemPile(var4, var5);
         }
      }
   }

   public RSGameObject[] getObjects() {
      return this.tempGameObjects;
   }

   public void newGroundItemPile(int var1, int var2, int var3, int var4, RSEntity var5, long var6, RSEntity var8, RSEntity var9) {
      this.method3184(var1, var2, var3, var4, (Entity)var5, var6, (Entity)var8, (Entity)var9);
   }

   public void drawTile(int[] var1, int var2, int var3, int var4, int var5, int var6) {
      this.method3359(var1, var2, var3, var4, var5, var6);
   }

   @ObfuscatedName("d")
   public static void method3277(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      Occluder var8 = new Occluder();
      var8.minTileX = var2 / 128;
      var8.maxTileX = var3 / 128;
      var8.minTileY = var4 / 128;
      var8.maxTileY = var5 / 128;
      var8.type = var1;
      var8.minX = var2;
      var8.maxX = var3;
      var8.minZ = var4;
      var8.maxZ = var5;
      var8.minY = var6;
      var8.maxY = var7;
      Scene_planeOccluders[var0][Scene_planeOccluderCounts[var0]++] = var8;
   }

   @ObfuscatedName("ak")
   public static void method3211(int[] var0, int var1, int var2, int var3, int var4) {
      Scene_viewportXMin = 0;
      Scene_viewportYMin = 0;
      Scene_viewportXMax = var3;
      Scene_viewportYMax = var4;
      Scene_viewportXCenter = var3 / 2;
      Scene_viewportYCenter = var4 / 2;
      boolean[][][][] var5 = new boolean[var0.length][32][53][53];

      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      for(var6 = 128; var6 <= 383; var6 += 32) {
         for(var7 = 0; var7 < 2048; var7 += 64) {
            Scene_cameraPitchSine = Rasterizer3D.Rasterizer3D_sine[var6];
            Scene_cameraPitchCosine = Rasterizer3D.Rasterizer3D_cosine[var6];
            Scene_cameraYawSine = Rasterizer3D.Rasterizer3D_sine[var7];
            Scene_cameraYawCosine = Rasterizer3D.Rasterizer3D_cosine[var7];
            var8 = (var6 - 128) / 32;
            var9 = var7 / 64;

            for(int var10 = -26; var10 < 26; ++var10) {
               var11 = -26;

               while(var11 < 26) {
                  var12 = var10 * 128;
                  int var13 = var11 * 128;
                  boolean var14 = false;
                  int var15 = -var1;

                  while(true) {
                     if(var15 <= var2) {
                        if(!method3212(var12, var0[var8] + var15, var13)) {
                           var15 += 128;
                           continue;
                        }

                        var14 = true;
                     }

                     var5[var8][var9][var10 + 1 + 25][var11 + 1 + 25] = var14;
                     ++var11;
                     break;
                  }
               }
            }
         }
      }

      for(var6 = 0; var6 < 8; ++var6) {
         for(var7 = 0; var7 < 32; ++var7) {
            for(var8 = -25; var8 < 25; ++var8) {
               var9 = -25;

               while(var9 < 25) {
                  boolean var16 = false;
                  var11 = -1;

                  label66:
                  while(true) {
                     if(var11 <= 1) {
                        var12 = -1;

                        while(true) {
                           if(var12 > 1) {
                              ++var11;
                              continue label66;
                           }

                           if(var5[var6][var7][var8 + var11 + 1 + 25][var9 + var12 + 1 + 25]) {
                              var16 = true;
                              break;
                           }

                           if(var5[var6][(var7 + 1) % 31][var8 + var11 + 1 + 25][var9 + var12 + 1 + 25]) {
                              var16 = true;
                              break;
                           }

                           if(var5[var6 + 1][var7][var8 + var11 + 1 + 25][var9 + var12 + 1 + 25]) {
                              var16 = true;
                              break;
                           }

                           if(var5[var6 + 1][(var7 + 1) % 31][var8 + var11 + 1 + 25][var9 + var12 + 1 + 25]) {
                              var16 = true;
                              break;
                           }

                           ++var12;
                        }
                     }

                     visibilityMap[var6][var7][var8 + 25][var9 + 25] = var16;
                     ++var9;
                     break;
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("aa")
   static boolean method3212(int var0, int var1, int var2) {
      int var3 = var0 * Scene_cameraYawCosine + var2 * Scene_cameraYawSine >> 16;
      int var4 = var2 * Scene_cameraYawCosine - var0 * Scene_cameraYawSine >> 16;
      int var5 = var4 * Scene_cameraPitchCosine + Scene_cameraPitchSine * var1 >> 16;
      int var6 = Scene_cameraPitchCosine * var1 - var4 * Scene_cameraPitchSine >> 16;
      if(var5 >= 50 && var5 <= 3500) {
         int var7 = var3 * 128 / var5 + Scene_viewportXCenter;
         int var8 = var6 * 128 / var5 + Scene_viewportYCenter;
         return var7 >= Scene_viewportXMin && var7 <= Scene_viewportXMax && var8 >= Scene_viewportYMin && var8 <= Scene_viewportYMax;
      } else {
         return false;
      }
   }

   @ObfuscatedName("aj")
   public static boolean method3215() {
      return viewportWalking && Scene_selectedX != -1;
   }

   @ObfuscatedName("ay")
   public static void method3347() {
      Scene_selectedX = -1;
      viewportWalking = false;
   }

   @ObfuscatedName("aw")
   static final int method3221(int var0, int var1) {
      var1 = (var0 & 127) * var1 >> 7;
      if(var1 < 2) {
         var1 = 2;
      } else if(var1 > 126) {
         var1 = 126;
      }

      return (var0 & '\uff80') + var1;
   }

   @ObfuscatedName("bf")
   static boolean method3222(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(var1 < var2 && var1 < var3 && var1 < var4) {
         return false;
      } else if(var1 > var2 && var1 > var3 && var1 > var4) {
         return false;
      } else if(var0 < var5 && var0 < var6 && var0 < var7) {
         return false;
      } else if(var0 > var5 && var0 > var6 && var0 > var7) {
         return false;
      } else {
         int var8 = (var1 - var2) * (var6 - var5) - (var0 - var5) * (var3 - var2);
         int var9 = (var7 - var6) * (var1 - var3) - (var0 - var6) * (var4 - var3);
         int var10 = (var5 - var7) * (var1 - var4) - (var2 - var4) * (var0 - var7);
         return var8 == 0?(var9 != 0?(var9 < 0?var10 <= 0:var10 >= 0):true):(var8 < 0?var9 <= 0 && var10 <= 0:var9 >= 0 && var10 >= 0);
      }
   }

   public static boolean shouldDraw(Object var0, boolean var1) {
      if(!Client.isHidingEntities) {
         return true;
      } else if(var0 instanceof RSPlayer) {
         boolean var2 = var1?Client.hideLocalPlayer2D:Client.hideLocalPlayer;
         boolean var3 = var1?Client.hidePlayers2D:Client.hidePlayers;
         boolean var4 = var0 == WorldMapSection1.client.getLocalPlayer();
         RSPlayer var5 = (RSPlayer)var0;
         Iterator var6 = Client.hideSpecificPlayers.iterator();

         while(var6.hasNext()) {
            String var7 = (String)var6.next();
            if(var7 != null && !var7.equals("") && var5.getName() != null && var5.getName().equalsIgnoreCase(var7)) {
               return false;
            }
         }

         if(var4) {
            if(!var2) {
               return true;
            }
         } else if(!var3) {
            return true;
         }

         if(!Client.hideAttackers && var5.getInteracting() == WorldMapSection1.client.getLocalPlayer()) {
            return true;
         } else if(var5.getName() == null) {
            return false;
         } else {
            return !Client.hideFriends && var5.isFriend() || !var4 && !Client.hideClanMates && var5.isClanMember();
         }
      } else if(var0 instanceof RSNPC) {
         RSNPC var8 = (RSNPC)var0;
         if(!Client.hideAttackers && var8.getInteracting() == WorldMapSection1.client.getLocalPlayer()) {
            return true;
         } else if(Client.hidePets && var8.getDefinition().isFollower()) {
            return false;
         } else if(Client.hideDeadNPCs && var8.getHealthRatio() == 0 && !Client.blacklistDeadNpcs.contains(Integer.valueOf(var8.getId()))) {
            return false;
         } else if(var8.getName() != null && ((Integer)Client.hiddenNpcsName.getOrDefault(Text.standardize(var8.getName().toLowerCase()), Integer.valueOf(0))).intValue() > 0) {
            return false;
         } else if(var8.getName() != null && var8.getHealthRatio() == 0 && ((Integer)Client.hiddenNpcsDeath.getOrDefault(Text.standardize(var8.getName().toLowerCase()), Integer.valueOf(0))).intValue() > 0) {
            return false;
         } else {
            return var1?!Client.hideNPCs2D:!Client.hideNPCs;
         }
      } else if(var0 instanceof RSProjectile) {
         return !Client.hideProjectiles;
      } else {
         return true;
      }
   }

   public static void setTargetTile(int var0, int var1) {
      WorldMapSection1.client.setSelectedSceneTileX(var0);
      WorldMapSection1.client.setSelectedSceneTileY(var1);
   }

   private static void rl$$clinit() {
      tmpX = new int[6];
      tmpY = new int[6];
   }

   @ObfuscatedSignature(
      signature = "(Lcw;IIIIII)V"
   )
   public static final void copy$drawActor2d(Actor var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var0 != null && var0.vmethod2132()) {
         if(var0 instanceof NPC) {
            NPCDefinition var7 = ((NPC)var0).definition;
            if(var7.transforms != null) {
               var7 = var7.method4791();
            }

            if(var7 == null) {
               return;
            }
         }

         int var76 = Players.Players_count;
         int[] var8 = Players.Players_indices;
         byte var9 = 0;
         Player var11;
         if(var1 < var76 && var0.playerCycle == Client.cycle) {
            var11 = (Player)var0;
            boolean var10;
            if(Client.drawPlayerNames == 0) {
               if(var6 == -636757955) {
                  return;
               }

               var10 = false;
            } else {
               boolean var78;
               if(var11 != ByteArrayPool.localPlayer) {
                  if(var6 == -636757955) {
                     return;
                  }

                  boolean var10000;
                  label846: {
                     var78 = (Client.drawPlayerNames & 4) != 0;
                     if(!var78) {
                        if(!WorldMapRectangle.method386() || !var11.method1351()) {
                           var10000 = false;
                           break label846;
                        }

                        if(var6 == -636757955) {
                           return;
                        }
                     }

                     var10000 = true;
                  }

                  boolean var79 = var10000;
                  if(!var79) {
                     label834: {
                        boolean var14 = (Client.drawPlayerNames & 2) != 0;
                        if(var14) {
                           if(var6 == -636757955) {
                              return;
                           }

                           if(var11.method1334()) {
                              var10000 = true;
                              break label834;
                           }
                        }

                        var10000 = false;
                     }

                     var79 = var10000;
                  }

                  var10 = var79;
               } else {
                  var78 = (Client.drawPlayerNames & 8) != 0;
                  var10 = var78;
               }
            }

            if(var10) {
               Player var12 = (Player)var0;
               if(var1 < var76) {
                  KeyHandler.method939(var0, var0.defaultHeight + 15);
                  AbstractFont var13 = (AbstractFont)Client.fontsMap.get(FontName.FontName_plain12);
                  byte var93 = 9;
                  var13.method5420(var12.username.method5263(), var2 + Client.viewportTempX, var3 + Client.viewportTempY - var93, 16777215, 0);
                  var9 = 18;
               }
            }
         }

         int var88 = -2;
         int var16;
         int var23;
         int var24;
         if(!var0.healthBars.method4892()) {
            if(var6 == -636757955) {
               return;
            }

            KeyHandler.method939(var0, var0.defaultHeight + 15);

            for(HealthBar var89 = (HealthBar)var0.healthBars.method4885(); var89 != null; var89 = (HealthBar)var0.healthBars.method4940()) {
               HealthBarUpdate var91 = var89.method2129(Client.cycle);
               if(var91 != null) {
                  HealthBarDefinition var92 = var89.definition;
                  Sprite var77 = var92.method4549();
                  Sprite var15 = var92.method4548();
                  int var17 = 0;
                  if(var77 != null && var15 != null) {
                     if(var92.widthPadding * 2 < var15.subWidth) {
                        var17 = var92.widthPadding;
                     }

                     var16 = var15.subWidth - var17 * 2;
                  } else {
                     var16 = var92.width;
                  }

                  int var18 = 255;
                  boolean var19 = true;
                  int var20 = Client.cycle - var91.cycle;
                  int var21 = var16 * var91.health2 / var92.width;
                  int var22;
                  int var94;
                  if(var91.cycleOffset > var20) {
                     var22 = var92.field3272 == 0?0:var92.field3272 * (var20 / var92.field3272);
                     var23 = var16 * var91.health / var92.width;
                     var94 = var22 * (var21 - var23) / var91.cycleOffset + var23;
                  } else {
                     var94 = var21;
                     var22 = var92.int5 + var91.cycleOffset - var20;
                     if(var92.int3 >= 0) {
                        var18 = (var22 << 8) / (var92.int5 - var92.int3);
                     }
                  }

                  if(var91.health2 > 0 && var94 < 1) {
                     if(var6 == -636757955) {
                        return;
                     }

                     var94 = 1;
                  }

                  if(var77 != null && var15 != null) {
                     if(var16 == var94) {
                        var94 += var17 * 2;
                     } else {
                        var94 += var17;
                     }

                     var22 = var77.subHeight;
                     var88 += var22;
                     var23 = var2 + Client.viewportTempX - (var16 >> 1);
                     var24 = var3 + Client.viewportTempY - var88;
                     var23 -= var17;
                     if(var18 >= 0 && var18 < 255) {
                        if(var6 == -636757955) {
                           return;
                        }

                        var77.method6233(var23, var24, var18);
                        Rasterizer2D.method6106(var23, var24, var23 + var94, var24 + var22);
                        var15.method6233(var23, var24, var18);
                     } else {
                        var77.method6227(var23, var24);
                        Rasterizer2D.method6106(var23, var24, var23 + var94, var24 + var22);
                        var15.method6227(var23, var24);
                     }

                     Rasterizer2D.method6085(var2, var3, var2 + var4, var3 + var5);
                     var88 += 2;
                  } else {
                     var88 += 5;
                     if(Client.viewportTempX > -1) {
                        var22 = var2 + Client.viewportTempX - (var16 >> 1);
                        var23 = var3 + Client.viewportTempY - var88;
                        Rasterizer2D.method6092(var22, var23, var94, 5, '\uff00');
                        Rasterizer2D.method6092(var94 + var22, var23, var16 - var94, 5, 16711680);
                     }

                     var88 += 2;
                  }
               } else if(var89.method2126()) {
                  var89.method3676();
               }
            }
         }

         if(var88 == -2) {
            var88 += 7;
         }

         var88 += var9;
         if(var1 < var76) {
            var11 = (Player)var0;
            if(var11.isHidden) {
               return;
            }

            if(var11.headIconPk != -1 || var11.headIconPrayer != -1) {
               KeyHandler.method939(var0, var0.defaultHeight + 15);
               if(Client.viewportTempX > -1) {
                  if(var11.headIconPk != -1) {
                     var88 += 25;
                     class52.headIconPkSprites[var11.headIconPk].method6227(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var88);
                  }

                  if(var11.headIconPrayer != -1) {
                     var88 += 25;
                     ReflectionCheck.headIconPrayerSprites[var11.headIconPrayer].method6227(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var88);
                  }
               }
            }

            if(var1 >= 0 && Client.hintArrowType == 10) {
               if(var6 == -636757955) {
                  return;
               }

               if(var8[var1] == Client.hintArrowPlayerIndex) {
                  KeyHandler.method939(var0, var0.defaultHeight + 15);
                  if(Client.viewportTempX > -1) {
                     var88 += class4.headIconHintSprites[1].subHeight;
                     class4.headIconHintSprites[1].method6227(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var88);
                  }
               }
            }
         } else {
            NPCDefinition var90 = ((NPC)var0).definition;
            if(var90.transforms != null) {
               if(var6 == -636757955) {
                  return;
               }

               var90 = var90.method4791();
            }

            if(var90.headIconPrayer >= 0 && var90.headIconPrayer < ReflectionCheck.headIconPrayerSprites.length) {
               KeyHandler.method939(var0, var0.defaultHeight + 15);
               if(Client.viewportTempX > -1) {
                  ReflectionCheck.headIconPrayerSprites[var90.headIconPrayer].method6227(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - 30);
               }
            }

            if(Client.hintArrowType == 1 && Client.npcIndices[var1 - var76] == Client.hintArrowNpcIndex && Client.cycle % 20 < 10) {
               KeyHandler.method939(var0, var0.defaultHeight + 15);
               if(Client.viewportTempX > -1) {
                  class4.headIconHintSprites[0].method6227(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - 28);
               }
            }
         }

         if(var0.overheadText != null) {
            label793: {
               if(var1 < var76) {
                  if(var6 == -636757955) {
                     return;
                  }

                  if(var0.field988) {
                     break label793;
                  }

                  if(Client.publicChatMode != 4) {
                     if(var0.isAutoChatting) {
                        break label793;
                     }

                     if(Client.publicChatMode != 0) {
                        if(var6 == -636757955) {
                           return;
                        }

                        if(Client.publicChatMode != 3 && (Client.publicChatMode != 1 || !((Player)var0).method1351())) {
                           break label793;
                        }
                     }
                  }
               }

               KeyHandler.method939(var0, var0.defaultHeight);
               if(Client.viewportTempX > -1 && Client.overheadTextCount < Client.overheadTextLimit) {
                  Client.overheadTextXOffsets[Client.overheadTextCount] = TaskHandler.fontBold12.method5412(var0.overheadText) / 2;
                  Client.overheadTextAscents[Client.overheadTextCount] = TaskHandler.fontBold12.ascent;
                  Client.overheadTextXs[Client.overheadTextCount] = Client.viewportTempX;
                  Client.overheadTextYs[Client.overheadTextCount] = Client.viewportTempY;
                  Client.overheadTextColors[Client.overheadTextCount] = var0.overheadTextColor;
                  Client.overheadTextEffects[Client.overheadTextCount] = var0.overheadTextEffect;
                  Client.overheadTextCyclesRemaining[Client.overheadTextCount] = var0.overheadTextCyclesRemaining;
                  Client.overheadText[Client.overheadTextCount] = var0.overheadText;
                  ++Client.overheadTextCount;
               }
            }
         }

         for(int var80 = 0; var80 < 4; ++var80) {
            int var97 = var0.hitSplatCycles[var80];
            int var98 = var0.hitSplatTypes[var80];
            HitSplatDefinition var96 = null;
            int var81 = 0;
            if(var98 >= 0) {
               if(var97 <= Client.cycle) {
                  if(var6 == -636757955) {
                     return;
                  }
                  continue;
               }

               var96 = GrandExchangeOfferUnitPriceComparator.method213(var0.hitSplatTypes[var80]);
               var81 = var96.field3329;
               if(var96 != null && var96.transforms != null) {
                  if(var6 == -636757955) {
                     return;
                  }

                  var96 = var96.method4629();
                  if(var96 == null) {
                     var0.hitSplatCycles[var80] = -1;
                     continue;
                  }
               }
            } else if(var97 < 0) {
               if(var6 == -636757955) {
                  return;
               }
               continue;
            }

            var16 = var0.hitSplatTypes2[var80];
            HitSplatDefinition var82 = null;
            if(var16 >= 0) {
               var82 = GrandExchangeOfferUnitPriceComparator.method213(var16);
               if(var82 != null && var82.transforms != null) {
                  var82 = var82.method4629();
               }
            }

            if(var97 - var81 <= Client.cycle) {
               if(var96 == null) {
                  if(var6 == -636757955) {
                     return;
                  }

                  var0.hitSplatCycles[var80] = -1;
               } else {
                  KeyHandler.method939(var0, var0.defaultHeight / 2);
                  if(Client.viewportTempX > -1) {
                     if(var80 == 1) {
                        Client.viewportTempY -= 20;
                     }

                     if(var80 == 2) {
                        Client.viewportTempX -= 15;
                        Client.viewportTempY -= 10;
                     }

                     if(var80 == 3) {
                        if(var6 == -636757955) {
                           return;
                        }

                        Client.viewportTempX += 15;
                        Client.viewportTempY -= 10;
                     }

                     Sprite var83 = null;
                     Sprite var84 = null;
                     Sprite var85 = null;
                     Sprite var86 = null;
                     var23 = 0;
                     var24 = 0;
                     int var25 = 0;
                     int var26 = 0;
                     int var27 = 0;
                     int var28 = 0;
                     int var29 = 0;
                     int var30 = 0;
                     Sprite var31 = null;
                     Sprite var32 = null;
                     Sprite var33 = null;
                     Sprite var34 = null;
                     int var35 = 0;
                     int var36 = 0;
                     int var37 = 0;
                     int var38 = 0;
                     int var39 = 0;
                     int var40 = 0;
                     int var41 = 0;
                     int var42 = 0;
                     int var43 = 0;
                     var83 = var96.method4643();
                     int var44;
                     if(var83 != null) {
                        var23 = var83.subWidth;
                        var44 = var83.subHeight;
                        if(var44 > var43) {
                           if(var6 == -636757955) {
                              return;
                           }

                           var43 = var44;
                        }

                        var27 = var83.xOffset;
                     }

                     var84 = var96.method4632();
                     if(var84 != null) {
                        var24 = var84.subWidth;
                        var44 = var84.subHeight;
                        if(var44 > var43) {
                           var43 = var44;
                        }

                        var28 = var84.xOffset;
                     }

                     var85 = var96.method4633();
                     if(var85 != null) {
                        var25 = var85.subWidth;
                        var44 = var85.subHeight;
                        if(var44 > var43) {
                           var43 = var44;
                        }

                        var29 = var85.xOffset;
                     }

                     var86 = var96.method4634();
                     if(var86 != null) {
                        var26 = var86.subWidth;
                        var44 = var86.subHeight;
                        if(var44 > var43) {
                           var43 = var44;
                        }

                        var30 = var86.xOffset;
                     }

                     if(var82 != null) {
                        if(var6 == -636757955) {
                           return;
                        }

                        var31 = var82.method4643();
                        if(var31 != null) {
                           var35 = var31.subWidth;
                           var44 = var31.subHeight;
                           if(var44 > var43) {
                              var43 = var44;
                           }

                           var39 = var31.xOffset;
                        }

                        var32 = var82.method4632();
                        if(var32 != null) {
                           var36 = var32.subWidth;
                           var44 = var32.subHeight;
                           if(var44 > var43) {
                              var43 = var44;
                           }

                           var40 = var32.xOffset;
                        }

                        var33 = var82.method4633();
                        if(var33 != null) {
                           if(var6 == -636757955) {
                              return;
                           }

                           var37 = var33.subWidth;
                           var44 = var33.subHeight;
                           if(var44 > var43) {
                              if(var6 == -636757955) {
                                 return;
                              }

                              var43 = var44;
                           }

                           var41 = var33.xOffset;
                        }

                        var34 = var82.method4634();
                        if(var34 != null) {
                           var38 = var34.subWidth;
                           var44 = var34.subHeight;
                           if(var44 > var43) {
                              if(var6 == -636757955) {
                                 return;
                              }

                              var43 = var44;
                           }

                           var42 = var34.xOffset;
                        }
                     }

                     Font var87 = var96.method4637();
                     if(var87 == null) {
                        var87 = Script.fontPlain11;
                     }

                     Font var45;
                     if(var82 != null) {
                        var45 = var82.method4637();
                        if(var45 == null) {
                           var45 = Script.fontPlain11;
                        }
                     } else {
                        var45 = Script.fontPlain11;
                     }

                     String var46 = null;
                     String var47 = null;
                     boolean var48 = false;
                     int var49 = 0;
                     var46 = var96.method4630(var0.hitSplatValues[var80]);
                     int var95 = var87.method5412(var46);
                     if(var82 != null) {
                        var47 = var82.method4630(var0.hitSplatValues2[var80]);
                        var49 = var45.method5412(var47);
                     }

                     int var50 = 0;
                     int var51 = 0;
                     if(var24 > 0) {
                        if(var85 == null && var86 == null) {
                           var50 = 1;
                        } else {
                           var50 = var95 / var24 + 1;
                        }
                     }

                     if(var82 != null && var36 > 0) {
                        label736: {
                           if(var33 == null) {
                              if(var6 == -636757955) {
                                 return;
                              }

                              if(var34 == null) {
                                 var51 = 1;
                                 break label736;
                              }
                           }

                           var51 = var49 / var36 + 1;
                        }
                     }

                     int var52 = 0;
                     int var53 = var52;
                     if(var23 > 0) {
                        var52 += var23;
                     }

                     var52 += 2;
                     int var54 = var52;
                     if(var25 > 0) {
                        var52 += var25;
                     }

                     int var55 = var52;
                     int var56 = var52;
                     int var57;
                     if(var24 > 0) {
                        var57 = var50 * var24;
                        var52 += var57;
                        var56 += (var57 - var95) / 2;
                     } else {
                        var52 += var95;
                     }

                     var57 = var52;
                     if(var26 > 0) {
                        var52 += var26;
                     }

                     int var58 = 0;
                     int var59 = 0;
                     int var60 = 0;
                     int var61 = 0;
                     int var62 = 0;
                     int var63;
                     if(var82 != null) {
                        var52 += 2;
                        var58 = var52;
                        if(var35 > 0) {
                           var52 += var35;
                        }

                        var52 += 2;
                        var59 = var52;
                        if(var37 > 0) {
                           var52 += var37;
                        }

                        var60 = var52;
                        var62 = var52;
                        if(var36 > 0) {
                           var63 = var51 * var36;
                           var52 += var63;
                           var62 += (var63 - var49) / 2;
                        } else {
                           var52 += var49;
                        }

                        var61 = var52;
                        if(var38 > 0) {
                           var52 += var38;
                        }
                     }

                     var63 = var0.hitSplatCycles[var80] - Client.cycle;
                     int var64 = var96.field3338 - var63 * var96.field3338 / var96.field3329;
                     int var65 = var63 * var96.field3341 / var96.field3329 + -var96.field3341;
                     int var66 = var64 + (var2 + Client.viewportTempX - (var52 >> 1));
                     int var67 = var65 + (var3 + Client.viewportTempY - 12);
                     int var68 = var67;
                     int var69 = var67 + var43;
                     int var70 = var67 + var96.field3339 + 15;
                     int var71 = var70 - var87.maxAscent;
                     int var72 = var70 + var87.maxDescent;
                     if(var71 < var67) {
                        var68 = var71;
                     }

                     if(var72 > var69) {
                        if(var6 == -636757955) {
                           return;
                        }

                        var69 = var72;
                     }

                     int var73 = 0;
                     int var74;
                     int var75;
                     if(var82 != null) {
                        var73 = var67 + var82.field3339 + 15;
                        var74 = var73 - var45.maxAscent;
                        var75 = var73 + var45.maxDescent;
                        if(var74 < var68) {
                           ;
                        }

                        if(var75 > var69) {
                           ;
                        }
                     }

                     var74 = 255;
                     if(var96.field3334 >= 0) {
                        var74 = (var63 << 8) / (var96.field3329 - var96.field3334);
                     }

                     if(var74 >= 0 && var74 < 255) {
                        if(var83 != null) {
                           var83.method6233(var53 + var66 - var27, var67, var74);
                        }

                        if(var85 != null) {
                           var85.method6233(var66 + var54 - var29, var67, var74);
                        }

                        if(var84 != null) {
                           for(var75 = 0; var75 < var50; ++var75) {
                              var84.method6233(var24 * var75 + (var66 + var55 - var28), var67, var74);
                           }
                        }

                        if(var86 != null) {
                           var86.method6233(var66 + var57 - var30, var67, var74);
                        }

                        var87.method5418(var46, var56 + var66, var70, var96.textColor, 0, var74);
                        if(var82 != null) {
                           if(var31 != null) {
                              if(var6 == -636757955) {
                                 return;
                              }

                              var31.method6233(var66 + var58 - var39, var67, var74);
                           }

                           if(var33 != null) {
                              var33.method6233(var66 + var59 - var41, var67, var74);
                           }

                           if(var32 != null) {
                              for(var75 = 0; var75 < var51; ++var75) {
                                 var32.method6233(var75 * var36 + (var66 + var60 - var40), var67, var74);
                              }
                           }

                           if(var34 != null) {
                              var34.method6233(var61 + var66 - var42, var67, var74);
                           }

                           var45.method5418(var47, var62 + var66, var73, var82.textColor, 0, var74);
                        }
                     } else {
                        if(var83 != null) {
                           var83.method6227(var53 + var66 - var27, var67);
                        }

                        if(var85 != null) {
                           var85.method6227(var54 + var66 - var29, var67);
                        }

                        if(var84 != null) {
                           for(var75 = 0; var75 < var50; ++var75) {
                              if(var6 == -636757955) {
                                 return;
                              }

                              var84.method6227(var75 * var24 + (var66 + var55 - var28), var67);
                           }
                        }

                        if(var86 != null) {
                           var86.method6227(var57 + var66 - var30, var67);
                        }

                        var87.method5417(var46, var56 + var66, var70, var96.textColor | -16777216, 0);
                        if(var82 != null) {
                           if(var31 != null) {
                              var31.method6227(var66 + var58 - var39, var67);
                           }

                           if(var33 != null) {
                              var33.method6227(var66 + var59 - var41, var67);
                           }

                           if(var32 != null) {
                              if(var6 == -636757955) {
                                 return;
                              }

                              for(var75 = 0; var75 < var51; ++var75) {
                                 var32.method6227(var36 * var75 + (var66 + var60 - var40), var67);
                              }
                           }

                           if(var34 != null) {
                              var34.method6227(var61 + var66 - var42, var67);
                           }

                           var45.method5417(var47, var62 + var66, var73, var82.textColor | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
