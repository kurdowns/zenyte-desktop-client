import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSSprite;
import net.runelite.rs.api.RSWorldMapElement;

@ObfuscatedName("io")
public class WorldMapElement extends DualNode implements RSWorldMapElement {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   public static AbstractArchive WorldMapElement_archive;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "[Lio;"
   )
   public static WorldMapElement[] WorldMapElement_cached;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Leg;"
   )
   static EvictingDualNodeHashTable WorldMapElement_cachedSprites = new EvictingDualNodeHashTable(256);
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1778455375
   )
   public final int objectId;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1839539911
   )
   public int sprite1 = -1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1328409781
   )
   int sprite2 = -1;
   @ObfuscatedName("z")
   public String name;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -66498181
   )
   public int field3216;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1404661325
   )
   public int textSize = 0;
   @ObfuscatedName("p")
   public String[] menuActions = new String[5];
   @ObfuscatedName("n")
   public String menuTargetName;
   @ObfuscatedName("u")
   int[] field3220;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 244845295
   )
   int field3221 = Integer.MAX_VALUE;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1082888487
   )
   int field3222 = Integer.MAX_VALUE;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 677837161
   )
   int field3223 = Integer.MIN_VALUE;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 639685945
   )
   int field3210 = Integer.MIN_VALUE;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lje;"
   )
   public HorizontalAlignment horizontalAlignment;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   public VerticalAlignment verticalAlignment;
   @ObfuscatedName("r")
   int[] field3229;
   @ObfuscatedName("o")
   byte[] field3218;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1088538707
   )
   public int category;


   public WorldMapElement(int var1) {
      this.horizontalAlignment = HorizontalAlignment.HorizontalAlignment_centered;
      this.verticalAlignment = VerticalAlignment.VerticalAlignment_centered;
      this.category = -1;
      this.objectId = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lkb;B)V",
      garbageValue = "-115"
   )
   public void method4473(Buffer var1) {
      while(true) {
         int var2 = var1.method5575();
         if(var2 == 0) {
            return;
         }

         this.method4466(var1, var2);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lkb;II)V",
      garbageValue = "2055926497"
   )
   void method4466(Buffer var1, int var2) {
      if(var2 == 1) {
         this.sprite1 = var1.method5592();
      } else if(var2 == 2) {
         this.sprite2 = var1.method5592();
      } else if(var2 == 3) {
         this.name = var1.method5695();
      } else if(var2 == 4) {
         this.field3216 = var1.method5702();
      } else if(var2 == 5) {
         var1.method5702();
      } else if(var2 == 6) {
         this.textSize = var1.method5575();
      } else {
         int var3;
         if(var2 == 7) {
            var3 = var1.method5575();
            if((var3 & 1) == 0) {
               ;
            }

            if((var3 & 2) == 2) {
               ;
            }
         } else if(var2 == 8) {
            var1.method5575();
         } else if(var2 >= 10 && var2 <= 14) {
            this.menuActions[var2 - 10] = var1.method5695();
         } else if(var2 == 15) {
            var3 = var1.method5575();
            this.field3220 = new int[var3 * 2];

            int var4;
            for(var4 = 0; var4 < var3 * 2; ++var4) {
               this.field3220[var4] = var1.method5578();
            }

            var1.method5580();
            var4 = var1.method5575();
            this.field3229 = new int[var4];

            int var5;
            for(var5 = 0; var5 < this.field3229.length; ++var5) {
               this.field3229[var5] = var1.method5580();
            }

            this.field3218 = new byte[var3];

            for(var5 = 0; var5 < var3; ++var5) {
               this.field3218[var5] = var1.method5576();
            }
         } else if(var2 != 16) {
            if(var2 == 17) {
               this.menuTargetName = var1.method5695();
            } else if(var2 == 18) {
               var1.method5592();
            } else if(var2 == 19) {
               this.category = var1.method5577();
            } else if(var2 == 21) {
               var1.method5580();
            } else if(var2 == 22) {
               var1.method5580();
            } else if(var2 == 23) {
               var1.method5575();
               var1.method5575();
               var1.method5575();
            } else if(var2 == 24) {
               var1.method5578();
               var1.method5578();
            } else if(var2 == 25) {
               var1.method5592();
            } else if(var2 == 28) {
               var1.method5575();
            } else if(var2 == 29) {
               this.horizontalAlignment = (HorizontalAlignment)GrandExchangeEvent.method159(NetFileRequest.method4245(), var1.method5575());
            } else if(var2 == 30) {
               this.verticalAlignment = (VerticalAlignment)GrandExchangeEvent.method159(Coord.method4085(), var1.method5575());
            }
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1026224709"
   )
   public void method4467() {
      if(this.field3220 != null) {
         for(int var1 = 0; var1 < this.field3220.length; var1 += 2) {
            if(this.field3220[var1] < this.field3221) {
               this.field3221 = this.field3220[var1];
            } else if(this.field3220[var1] > this.field3223) {
               this.field3223 = this.field3220[var1];
            }

            if(this.field3220[var1 + 1] < this.field3222) {
               this.field3222 = this.field3220[var1 + 1];
            } else if(this.field3220[var1 + 1] > this.field3210) {
               this.field3210 = this.field3220[var1 + 1];
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ZI)Lla;",
      garbageValue = "2050095285"
   )
   public Sprite method4468(boolean var1) {
      int var2 = var1?this.sprite2:this.sprite1;
      return this.method4469(var2);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)Lla;",
      garbageValue = "122291326"
   )
   Sprite method4469(int var1) {
      if(var1 < 0) {
         return null;
      } else {
         Sprite var2 = (Sprite)WorldMapElement_cachedSprites.method3432((long)var1);
         if(var2 != null) {
            return var2;
         } else {
            var2 = MusicPatchNode2.method3774(WorldMapElement_archive, var1, 0, 273345835);
            if(var2 != null) {
               WorldMapElement_cachedSprites.method3438(var2, (long)var1);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1436204675"
   )
   public int method4483() {
      return this.objectId;
   }

   public RSSprite getMapIcon(boolean var1) {
      return this.method4468(var1);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Lib;",
      garbageValue = "-32366674"
   )
   public static KitDefinition method4486(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.KitDefinition_cached.method3432((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = KitDefinition.KitDefinition_archive.method4249(3, var0, (byte)-27);
         var1 = new KitDefinition();
         if(var2 != null) {
            var1.method4520(new Buffer(var2));
         }

         KitDefinition.KitDefinition_cached.method3438(var1, (long)var0);
         return var1;
      }
   }
}
