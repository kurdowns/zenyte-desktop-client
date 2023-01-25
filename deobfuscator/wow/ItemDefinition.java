import net.runelite.api.events.PostItemDefinition;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSItemDefinition;
import net.runelite.rs.api.RSModel;

@ObfuscatedName("jx")
public class ItemDefinition extends DualNode implements RSItemDefinition {

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Leg;"
   )
   static EvictingDualNodeHashTable ItemDefinition_cached = new EvictingDualNodeHashTable(64);
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Leg;"
   )
   static EvictingDualNodeHashTable ItemDefinition_cachedModels = new EvictingDualNodeHashTable(50);
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Leg;"
   )
   public static EvictingDualNodeHashTable ItemDefinition_cachedSprites = new EvictingDualNodeHashTable(200);
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -32704117
   )
   public int id;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1028533167
   )
   int model;
   @ObfuscatedName("g")
   public String name = "null";
   @ObfuscatedName("i")
   short[] recolorFrom;
   @ObfuscatedName("a")
   short[] recolorTo;
   @ObfuscatedName("b")
   short[] retextureFrom;
   @ObfuscatedName("l")
   short[] retextureTo;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 790198705
   )
   public int zoom2d = 2000;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -512511795
   )
   public int xan2d = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1120938463
   )
   public int yan2d = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2126697049
   )
   public int zan2d = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 2124715319
   )
   public int offsetX2d = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1998077465
   )
   public int offsetY2d = 0;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -496150603
   )
   public int isStackable = 0;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1128123323
   )
   public int price = 1;
   @ObfuscatedName("ai")
   public boolean isMembersOnly = false;
   @ObfuscatedName("ap")
   public String[] groundActions = new String[]{null, null, "Take", null, null};
   @ObfuscatedName("ab")
   public String[] inventoryActions = new String[]{null, null, null, null, "Drop"};
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 2022658475
   )
   int shiftClickIndex = -2;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -198787353
   )
   int maleModel = -1;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1595882143
   )
   int maleModel1 = -1;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1755438589
   )
   int maleOffset = 0;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 384600509
   )
   int femaleModel = -1;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1401958483
   )
   int femaleModel1 = -1;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -289691561
   )
   int femaleOffset = 0;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 270064135
   )
   int maleModel2 = -1;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -2092220545
   )
   int femaleModel2 = -1;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -687751073
   )
   int maleHeadModel = -1;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -726951563
   )
   int maleHeadModel2 = -1;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 515679975
   )
   int femaleHeadModel = -1;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 54393855
   )
   int femaleHeadModel2 = -1;
   @ObfuscatedName("aj")
   int[] countobj;
   @ObfuscatedName("ay")
   int[] countco;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1943254675
   )
   public int note = -1;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1721963949
   )
   public int noteTemplate = -1;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1325952823
   )
   int resizeX = 128;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1293336691
   )
   int resizeY = 128;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -2092594315
   )
   int resizeZ = 128;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 701446973
   )
   public int ambient = 0;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 1489802711
   )
   public int contrast = 0;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -499099671
   )
   public int team = 0;
   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "Lln;"
   )
   IterableNodeHashTable params;
   @ObfuscatedName("bk")
   public boolean isTradable = false;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -997556147
   )
   int unnotedId = -1;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -1745550989
   )
   int notedId = -1;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -355307627
   )
   public int placeholder = -1;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = 1596605635
   )
   public int placeholderTemplate = -1;
   public int shiftClickActionIndex;
   public int modelOverride;


   ItemDefinition() {
      this.rl$$init();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1255281949"
   )
   void method4767() {
      this.post();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lkb;I)V",
      garbageValue = "-160078979"
   )
   void method4728(Buffer var1) {
      while(true) {
         int var2 = var1.method5575();
         if(var2 == 0) {
            return;
         }

         this.method4716(var1, var2);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lkb;II)V",
      garbageValue = "-1270586282"
   )
   void method4716(Buffer var1, int var2) {
      if(var2 == 1) {
         this.model = var1.method5577();
      } else if(var2 == 2) {
         this.name = var1.method5695();
      } else if(var2 == 4) {
         this.zoom2d = var1.method5577();
      } else if(var2 == 5) {
         this.xan2d = var1.method5577();
      } else if(var2 == 6) {
         this.yan2d = var1.method5577();
      } else if(var2 == 7) {
         this.offsetX2d = var1.method5577();
         if(this.offsetX2d > 32767) {
            this.offsetX2d -= 65536;
         }
      } else if(var2 == 8) {
         this.offsetY2d = var1.method5577();
         if(this.offsetY2d > 32767) {
            this.offsetY2d -= 65536;
         }
      } else if(var2 == 11) {
         this.isStackable = 1;
      } else if(var2 == 12) {
         this.price = var1.method5580();
      } else if(var2 == 16) {
         this.isMembersOnly = true;
      } else if(var2 == 23) {
         this.maleModel = var1.method5577();
         this.maleOffset = var1.method5575();
      } else if(var2 == 24) {
         this.maleModel1 = var1.method5577();
      } else if(var2 == 25) {
         this.femaleModel = var1.method5577();
         this.femaleOffset = var1.method5575();
      } else if(var2 == 26) {
         this.femaleModel1 = var1.method5577();
      } else if(var2 >= 30 && var2 < 35) {
         this.groundActions[var2 - 30] = var1.method5695();
         if(this.groundActions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.groundActions[var2 - 30] = null;
         }
      } else if(var2 >= 35 && var2 < 40) {
         this.inventoryActions[var2 - 35] = var1.method5695();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.method5575();
            this.recolorFrom = new short[var3];
            this.recolorTo = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.recolorFrom[var4] = (short)var1.method5577();
               this.recolorTo[var4] = (short)var1.method5577();
            }
         } else if(var2 == 41) {
            var3 = var1.method5575();
            this.retextureFrom = new short[var3];
            this.retextureTo = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.retextureFrom[var4] = (short)var1.method5577();
               this.retextureTo[var4] = (short)var1.method5577();
            }
         } else if(var2 == 42) {
            this.shiftClickIndex = var1.method5576();
         } else if(var2 == 65) {
            this.isTradable = true;
         } else if(var2 == 78) {
            this.maleModel2 = var1.method5577();
         } else if(var2 == 79) {
            this.femaleModel2 = var1.method5577();
         } else if(var2 == 90) {
            this.maleHeadModel = var1.method5577();
         } else if(var2 == 91) {
            this.femaleHeadModel = var1.method5577();
         } else if(var2 == 92) {
            this.maleHeadModel2 = var1.method5577();
         } else if(var2 == 93) {
            this.femaleHeadModel2 = var1.method5577();
         } else if(var2 == 95) {
            this.zan2d = var1.method5577();
         } else if(var2 == 97) {
            this.note = var1.method5577();
         } else if(var2 == 98) {
            this.noteTemplate = var1.method5577();
         } else if(var2 >= 100 && var2 < 110) {
            if(this.countobj == null) {
               this.countobj = new int[10];
               this.countco = new int[10];
            }

            this.countobj[var2 - 100] = var1.method5577();
            this.countco[var2 - 100] = var1.method5577();
         } else if(var2 == 110) {
            this.resizeX = var1.method5577();
         } else if(var2 == 111) {
            this.resizeY = var1.method5577();
         } else if(var2 == 112) {
            this.resizeZ = var1.method5577();
         } else if(var2 == 113) {
            this.ambient = var1.method5576();
         } else if(var2 == 114) {
            this.contrast = var1.method5576() * 5;
         } else if(var2 == 115) {
            this.team = var1.method5575();
         } else if(var2 == 139) {
            this.unnotedId = var1.method5577();
         } else if(var2 == 140) {
            this.notedId = var1.method5577();
         } else if(var2 == 148) {
            this.placeholder = var1.method5577();
         } else if(var2 == 149) {
            this.placeholderTemplate = var1.method5577();
         } else if(var2 == 249) {
            this.params = NetCache.method4400(var1, this.params);
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljx;Ljx;B)V",
      garbageValue = "98"
   )
   void method4764(ItemDefinition var1, ItemDefinition var2) {
      this.model = var1.model;
      this.zoom2d = var1.zoom2d;
      this.xan2d = var1.xan2d;
      this.yan2d = var1.yan2d;
      this.zan2d = var1.zan2d;
      this.offsetX2d = var1.offsetX2d;
      this.offsetY2d = var1.offsetY2d;
      this.recolorFrom = var1.recolorFrom;
      this.recolorTo = var1.recolorTo;
      this.retextureFrom = var1.retextureFrom;
      this.retextureTo = var1.retextureTo;
      this.name = var2.name;
      this.isMembersOnly = var2.isMembersOnly;
      this.price = var2.price;
      this.isStackable = 1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljx;Ljx;I)V",
      garbageValue = "2110553543"
   )
   void method4718(ItemDefinition var1, ItemDefinition var2) {
      this.model = var1.model;
      this.zoom2d = var1.zoom2d;
      this.xan2d = var1.xan2d;
      this.yan2d = var1.yan2d;
      this.zan2d = var1.zan2d;
      this.offsetX2d = var1.offsetX2d;
      this.offsetY2d = var1.offsetY2d;
      this.recolorFrom = var2.recolorFrom;
      this.recolorTo = var2.recolorTo;
      this.retextureFrom = var2.retextureFrom;
      this.retextureTo = var2.retextureTo;
      this.name = var2.name;
      this.isMembersOnly = var2.isMembersOnly;
      this.isStackable = var2.isStackable;
      this.maleModel = var2.maleModel;
      this.maleModel1 = var2.maleModel1;
      this.maleModel2 = var2.maleModel2;
      this.femaleModel = var2.femaleModel;
      this.femaleModel1 = var2.femaleModel1;
      this.femaleModel2 = var2.femaleModel2;
      this.maleHeadModel = var2.maleHeadModel;
      this.maleHeadModel2 = var2.maleHeadModel2;
      this.femaleHeadModel = var2.femaleHeadModel;
      this.femaleHeadModel2 = var2.femaleHeadModel2;
      this.team = var2.team;
      this.groundActions = var2.groundActions;
      this.inventoryActions = new String[5];
      if(var2.inventoryActions != null) {
         for(int var3 = 0; var3 < 4; ++var3) {
            this.inventoryActions[var3] = var2.inventoryActions[var3];
         }
      }

      this.inventoryActions[4] = "Discard";
      this.price = 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljx;Ljx;I)V",
      garbageValue = "231591867"
   )
   void method4719(ItemDefinition var1, ItemDefinition var2) {
      this.model = var1.model;
      this.zoom2d = var1.zoom2d;
      this.xan2d = var1.xan2d;
      this.yan2d = var1.yan2d;
      this.zan2d = var1.zan2d;
      this.offsetX2d = var1.offsetX2d;
      this.offsetY2d = var1.offsetY2d;
      this.recolorFrom = var1.recolorFrom;
      this.recolorTo = var1.recolorTo;
      this.retextureFrom = var1.retextureFrom;
      this.retextureTo = var1.retextureTo;
      this.isStackable = var1.isStackable;
      this.name = var2.name;
      this.price = 0;
      this.isMembersOnly = false;
      this.isTradable = false;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)Lea;",
      garbageValue = "-1152870229"
   )
   public final ModelData method4720(int var1) {
      int var3;
      if(this.countobj != null && var1 > 1) {
         int var2 = -1;

         for(var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countco[var3] && this.countco[var3] != 0) {
               var2 = this.countobj[var3];
            }
         }

         if(var2 != -1) {
            return AbstractWorldMapData.method373(var2).method4720(1);
         }
      }

      ModelData var4 = ModelData.method2879(GrandExchangeOffer.ItemDefinition_modelArchive, this.model, 0);
      if(var4 == null) {
         return null;
      } else {
         if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
            var4.method2896(this.resizeX, this.resizeY, this.resizeZ);
         }

         if(this.recolorFrom != null) {
            for(var3 = 0; var3 < this.recolorFrom.length; ++var3) {
               var4.method2893(this.recolorFrom[var3], this.recolorTo[var3]);
            }
         }

         if(this.retextureFrom != null) {
            for(var3 = 0; var3 < this.retextureFrom.length; ++var3) {
               var4.method2945(this.retextureFrom[var3], this.retextureTo[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)Lel;"
   )
   public final Model method4721(int var1, byte var2) {
      return this.modelOverride == -1?(Model)this.copy$getModel(var1, var2):(Model)WorldMapSection1.client.getRSItemDefinition(this.modelOverride).getModel(var1);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Ljx;",
      garbageValue = "-2117466306"
   )
   public ItemDefinition method4714(int var1) {
      if(this.countobj != null && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countco[var3] && this.countco[var3] != 0) {
               var2 = this.countobj[var3];
            }
         }

         if(var2 != -1) {
            return AbstractWorldMapData.method373(var2);
         }
      }

      return this;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "1659080166"
   )
   public final boolean method4722(boolean var1) {
      int var2 = this.maleModel;
      int var3 = this.maleModel1;
      int var4 = this.maleModel2;
      if(var1) {
         var2 = this.femaleModel;
         var3 = this.femaleModel1;
         var4 = this.femaleModel2;
      }

      if(var2 == -1) {
         return true;
      } else {
         boolean var5 = true;
         if(!GrandExchangeOffer.ItemDefinition_modelArchive.method4263(var2, 0)) {
            var5 = false;
         }

         if(var3 != -1 && !GrandExchangeOffer.ItemDefinition_modelArchive.method4263(var3, 0)) {
            var5 = false;
         }

         if(var4 != -1 && !GrandExchangeOffer.ItemDefinition_modelArchive.method4263(var4, 0)) {
            var5 = false;
         }

         return var5;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ZI)Lea;",
      garbageValue = "475767309"
   )
   public final ModelData method4723(boolean var1) {
      int var2 = this.maleModel;
      int var3 = this.maleModel1;
      int var4 = this.maleModel2;
      if(var1) {
         var2 = this.femaleModel;
         var3 = this.femaleModel1;
         var4 = this.femaleModel2;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var5 = ModelData.method2879(GrandExchangeOffer.ItemDefinition_modelArchive, var2, 0);
         if(var3 != -1) {
            ModelData var6 = ModelData.method2879(GrandExchangeOffer.ItemDefinition_modelArchive, var3, 0);
            if(var4 != -1) {
               ModelData var7 = ModelData.method2879(GrandExchangeOffer.ItemDefinition_modelArchive, var4, 0);
               ModelData[] var8 = new ModelData[]{var5, var6, var7};
               var5 = new ModelData(var8, 3);
            } else {
               ModelData[] var10 = new ModelData[]{var5, var6};
               var5 = new ModelData(var10, 2);
            }
         }

         if(!var1 && this.maleOffset != 0) {
            var5.method2892(0, this.maleOffset, 0);
         }

         if(var1 && this.femaleOffset != 0) {
            var5.method2892(0, this.femaleOffset, 0);
         }

         int var9;
         if(this.recolorFrom != null) {
            for(var9 = 0; var9 < this.recolorFrom.length; ++var9) {
               var5.method2893(this.recolorFrom[var9], this.recolorTo[var9]);
            }
         }

         if(this.retextureFrom != null) {
            for(var9 = 0; var9 < this.retextureFrom.length; ++var9) {
               var5.method2945(this.retextureFrom[var9], this.retextureTo[var9]);
            }
         }

         return var5;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "-846973377"
   )
   public final boolean method4773(boolean var1) {
      int var2 = this.maleHeadModel;
      int var3 = this.maleHeadModel2;
      if(var1) {
         var2 = this.femaleHeadModel;
         var3 = this.femaleHeadModel2;
      }

      if(var2 == -1) {
         return true;
      } else {
         boolean var4 = true;
         if(!GrandExchangeOffer.ItemDefinition_modelArchive.method4263(var2, 0)) {
            var4 = false;
         }

         if(var3 != -1 && !GrandExchangeOffer.ItemDefinition_modelArchive.method4263(var3, 0)) {
            var4 = false;
         }

         return var4;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ZI)Lea;",
      garbageValue = "2065185270"
   )
   public final ModelData method4725(boolean var1) {
      int var2 = this.maleHeadModel;
      int var3 = this.maleHeadModel2;
      if(var1) {
         var2 = this.femaleHeadModel;
         var3 = this.femaleHeadModel2;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var4 = ModelData.method2879(GrandExchangeOffer.ItemDefinition_modelArchive, var2, 0);
         if(var3 != -1) {
            ModelData var5 = ModelData.method2879(GrandExchangeOffer.ItemDefinition_modelArchive, var3, 0);
            ModelData[] var6 = new ModelData[]{var4, var5};
            var4 = new ModelData(var6, 2);
         }

         int var7;
         if(this.recolorFrom != null) {
            for(var7 = 0; var7 < this.recolorFrom.length; ++var7) {
               var4.method2893(this.recolorFrom[var7], this.recolorTo[var7]);
            }
         }

         if(this.retextureFrom != null) {
            for(var7 = 0; var7 < this.retextureFrom.length; ++var7) {
               var4.method2945(this.retextureFrom[var7], this.retextureTo[var7]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1313437382"
   )
   public int method4729(int var1, int var2) {
      IterableNodeHashTable var4 = this.params;
      int var3;
      if(var4 == null) {
         var3 = var2;
      } else {
         IntegerNode var5 = (IntegerNode)var4.method6003((long)var1);
         if(var5 == null) {
            var3 = var2;
         } else {
            var3 = var5.integer;
         }
      }

      return var3;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "1527088310"
   )
   public String method4727(int var1, String var2) {
      return class9.method122(this.params, var1, var2);
   }

   @ObfuscatedName("o")
   public int method4742(int var1) {
      return this.shiftClickActionIndex == -2?this.copy$getShiftClickIndex(var1):this.shiftClickActionIndex;
   }

   public int getIsStackable() {
      return this.isStackable;
   }

   public void post() {
      PostItemDefinition var1 = new PostItemDefinition();
      var1.setItemDefinition(this);
      WorldMapSection1.client.getCallbacks().post(PostItemDefinition.class, var1);
   }

   public int copy$getShiftClickIndex(int var1) {
      return this.shiftClickIndex != -1 && this.inventoryActions != null?(this.shiftClickIndex >= 0?(this.inventoryActions[this.shiftClickIndex] != null?this.shiftClickIndex:-1):("Drop".equalsIgnoreCase(this.inventoryActions[4])?4:-1)):-1;
   }

   @ObfuscatedSignature(
      signature = "(IB)Lel;"
   )
   public final Model copy$getModel(int var1, byte var2) {
      if(this.countobj != null && var1 > 1) {
         int var3 = -1;

         for(int var4 = 0; var4 < 10; ++var4) {
            if(var1 >= this.countco[var4] && this.countco[var4] != 0) {
               var3 = this.countobj[var4];
            }
         }

         if(var3 != -1) {
            return AbstractWorldMapData.method373(var3).method4721(1, (byte)-42);
         }
      }

      Model var6 = (Model)ItemDefinition_cachedModels.method3432((long)this.id);
      if(var6 != null) {
         return var6;
      } else {
         ModelData var7 = ModelData.method2879(GrandExchangeOffer.ItemDefinition_modelArchive, this.model, 0);
         if(var7 == null) {
            return null;
         } else {
            if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
               var7.method2896(this.resizeX, this.resizeY, this.resizeZ);
            }

            int var5;
            if(this.recolorFrom != null) {
               for(var5 = 0; var5 < this.recolorFrom.length; ++var5) {
                  var7.method2893(this.recolorFrom[var5], this.recolorTo[var5]);
               }
            }

            if(this.retextureFrom != null) {
               for(var5 = 0; var5 < this.retextureFrom.length; ++var5) {
                  var7.method2945(this.retextureFrom[var5], this.retextureTo[var5]);
               }
            }

            var6 = var7.method2900(this.ambient + 64, this.contrast + 768, -50, -10, -50);
            var6.isSingleTile = true;
            ItemDefinition_cachedModels.method3438(var6, (long)this.id);
            return var6;
         }
      }
   }

   private void rl$$init() {
      this.shiftClickActionIndex = -2;
      this.modelOverride = -1;
   }

   public void setModelOverride(int var1) {
      this.modelOverride = var1;
   }

   public boolean isStackable() {
      return this.getIsStackable() != 0;
   }

   public void setShiftClickActionIndex(int var1) {
      this.shiftClickActionIndex = var1;
   }

   public void resetShiftClickActionIndex() {
      this.shiftClickActionIndex = -2;
   }

   public int getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public void setName(String var1) {
      this.name = var1;
   }

   public short[] getColorToReplaceWith() {
      return this.recolorTo;
   }

   public short[] getTextureToReplaceWith() {
      return this.retextureTo;
   }

   public int getPrice() {
      return this.price;
   }

   public boolean isMembers() {
      return this.isMembersOnly;
   }

   public String[] getInventoryActions() {
      return this.inventoryActions;
   }

   public int getMaleModel() {
      return this.maleModel;
   }

   public int getLinkedNoteId() {
      return this.note;
   }

   public int getNote() {
      return this.noteTemplate;
   }

   public boolean isTradeable() {
      return this.isTradable;
   }

   public void setTradeable(boolean var1) {
      this.isTradable = var1;
   }

   public int getInventoryModel() {
      return this.unnotedId;
   }

   public int getPlaceholderId() {
      return this.placeholder;
   }

   public int getPlaceholderTemplateId() {
      return this.placeholderTemplate;
   }

   public RSModel getModel(int var1) {
      return this.method4721(var1, (byte)-60);
   }

   public int getShiftClickActionIndex() {
      return this.method4742(782275365);
   }
}
