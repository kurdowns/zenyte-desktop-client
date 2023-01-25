import net.runelite.api.HeadIcon;
import net.runelite.api.events.NpcActionChanged;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSNPCDefinition;

@ObfuscatedName("jj")
public class NPCDefinition extends DualNode implements RSNPCDefinition {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   public static AbstractArchive NpcDefinition_archive;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   public static AbstractArchive NpcDefinition_modelArchive;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Leg;"
   )
   static EvictingDualNodeHashTable NpcDefinition_cached = new EvictingDualNodeHashTable(64);
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Leg;"
   )
   static EvictingDualNodeHashTable NpcDefinition_cachedModels = new EvictingDualNodeHashTable(50);
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -389469873
   )
   public int id;
   @ObfuscatedName("v")
   public String name = "null";
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1343476403
   )
   public int size = 1;
   @ObfuscatedName("z")
   int[] models;
   @ObfuscatedName("t")
   int[] field3483;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1727903795
   )
   public int idleSequence = -1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1188737805
   )
   public int turnLeftSequence = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1064545751
   )
   public int turnRightSequence = -1;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1167118343
   )
   public int walkSequence = -1;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -899359333
   )
   public int walkBackSequence = -1;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1764143325
   )
   public int walkLeftSequence = -1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 594616055
   )
   public int walkRightSequence = -1;
   @ObfuscatedName("i")
   short[] recolorFrom;
   @ObfuscatedName("a")
   short[] recolorTo;
   @ObfuscatedName("b")
   short[] retextureFrom;
   @ObfuscatedName("l")
   short[] retextureTo;
   @ObfuscatedName("r")
   public String[] actions = new String[5];
   @ObfuscatedName("o")
   public boolean drawMapDot;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1913171313
   )
   public int combatLevel;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -628781453
   )
   int widthScale;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 831579505
   )
   int heightScale;
   @ObfuscatedName("f")
   public boolean isVisible;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -2049591517
   )
   int ambient;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1268595579
   )
   int contrast;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1614239771
   )
   public int headIconPrayer;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1421039835
   )
   public int rotation;
   @ObfuscatedName("ab")
   public int[] transforms;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1643554833
   )
   int transformVarbit;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1966128939
   )
   int transformVarp;
   @ObfuscatedName("at")
   public boolean isInteractable;
   @ObfuscatedName("al")
   public boolean isClickable;
   @ObfuscatedName("as")
   public boolean isFollower;
   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "Lln;"
   )
   IterableNodeHashTable params;


   NPCDefinition() {
      this.actionsHook(-1);
      this.drawMapDot = true;
      this.combatLevel = -1;
      this.widthScale = 128;
      this.heightScale = 128;
      this.isVisible = false;
      this.ambient = 0;
      this.contrast = 0;
      this.headIconPrayer = -1;
      this.rotation = 32;
      this.transformVarbit = -1;
      this.transformVarp = -1;
      this.isInteractable = true;
      this.isClickable = true;
      this.isFollower = false;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "33"
   )
   void method4790() {}

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lkb;B)V",
      garbageValue = "-24"
   )
   void method4787(Buffer var1) {
      while(true) {
         int var2 = var1.method5575();
         if(var2 == 0) {
            return;
         }

         this.method4788(var1, var2);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lkb;II)V",
      garbageValue = "269088844"
   )
   void method4788(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method5575();
         this.models = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.models[var4] = var1.method5577();
         }
      } else if(var2 == 2) {
         this.name = var1.method5695();
      } else if(var2 == 12) {
         this.size = var1.method5575();
      } else if(var2 == 13) {
         this.idleSequence = var1.method5577();
      } else if(var2 == 14) {
         this.walkSequence = var1.method5577();
      } else if(var2 == 15) {
         this.turnLeftSequence = var1.method5577();
      } else if(var2 == 16) {
         this.turnRightSequence = var1.method5577();
      } else if(var2 == 17) {
         this.walkSequence = var1.method5577();
         this.walkBackSequence = var1.method5577();
         this.walkLeftSequence = var1.method5577();
         this.walkRightSequence = var1.method5577();
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.method5695();
         this.actionsHook(var2 - 30);
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
            this.actionsHook(var2 - 30);
         }
      } else if(var2 == 40) {
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
      } else if(var2 == 60) {
         var3 = var1.method5575();
         this.field3483 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3483[var4] = var1.method5577();
         }
      } else if(var2 == 93) {
         this.drawMapDot = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.method5577();
      } else if(var2 == 97) {
         this.widthScale = var1.method5577();
      } else if(var2 == 98) {
         this.heightScale = var1.method5577();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.ambient = var1.method5576();
      } else if(var2 == 101) {
         this.contrast = var1.method5576() * 5;
      } else if(var2 == 102) {
         this.headIconPrayer = var1.method5577();
      } else if(var2 == 103) {
         this.rotation = var1.method5577();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.isInteractable = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.isFollower = true;
         } else if(var2 == 249) {
            this.params = NetCache.method4400(var1, this.params);
         }
      } else {
         this.transformVarbit = var1.method5577();
         if(this.transformVarbit == '\uffff') {
            this.transformVarbit = -1;
         }

         this.transformVarp = var1.method5577();
         if(this.transformVarp == '\uffff') {
            this.transformVarp = -1;
         }

         var3 = -1;
         if(var2 == 118) {
            var3 = var1.method5577();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         var4 = var1.method5575();
         this.transforms = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.transforms[var5] = var1.method5577();
            if(this.transforms[var5] == '\uffff') {
               this.transforms[var5] = -1;
            }
         }

         this.transforms[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljc;ILjc;II)Lel;",
      garbageValue = "-251854058"
   )
   public final Model method4789(SequenceDefinition var1, int var2, SequenceDefinition var3, int var4) {
      if(this.transforms != null) {
         NPCDefinition var12 = this.method4791();
         return var12 == null?null:var12.method4789(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)NpcDefinition_cachedModels.method3432((long)this.id);
         if(var5 == null) {
            boolean var6 = false;

            for(int var7 = 0; var7 < this.models.length; ++var7) {
               if(!NpcDefinition_modelArchive.method4263(this.models[var7], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method2879(NpcDefinition_modelArchive, this.models[var9], 0);
            }

            ModelData var11;
            if(var8.length == 1) {
               var11 = var8[0];
            } else {
               var11 = new ModelData(var8, var8.length);
            }

            if(this.recolorFrom != null) {
               for(var9 = 0; var9 < this.recolorFrom.length; ++var9) {
                  var11.method2893(this.recolorFrom[var9], this.recolorTo[var9]);
               }
            }

            if(this.retextureFrom != null) {
               for(var9 = 0; var9 < this.retextureFrom.length; ++var9) {
                  var11.method2945(this.retextureFrom[var9], this.retextureTo[var9]);
               }
            }

            var5 = var11.method2900(this.ambient + 64, this.contrast + 850, -30, -50, -30);
            NpcDefinition_cachedModels.method3438(var5, (long)this.id);
         }

         Model var10;
         if(var1 != null && var3 != null) {
            var10 = var1.method4848(var5, var2, var3, var4, (byte)1);
         } else if(var1 != null) {
            var10 = var1.method4845(var5, var2, 1747843246);
         } else if(var3 != null) {
            var10 = var3.method4845(var5, var4, 1747843246);
         } else {
            var10 = var5.method2985(true);
         }

         if(this.widthScale != 128 || this.heightScale != 128) {
            var10.method2981(this.widthScale, this.heightScale, this.widthScale);
         }

         return var10;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)Lea;",
      garbageValue = "4"
   )
   public final ModelData method4785() {
      if(this.transforms != null) {
         NPCDefinition var1 = this.method4791();
         return var1 == null?null:var1.method4785();
      } else if(this.field3483 == null) {
         return null;
      } else {
         boolean var5 = false;

         for(int var2 = 0; var2 < this.field3483.length; ++var2) {
            if(!NpcDefinition_modelArchive.method4263(this.field3483[var2], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var6 = new ModelData[this.field3483.length];

            for(int var3 = 0; var3 < this.field3483.length; ++var3) {
               var6[var3] = ModelData.method2879(NpcDefinition_modelArchive, this.field3483[var3], 0);
            }

            ModelData var7;
            if(var6.length == 1) {
               var7 = var6[0];
            } else {
               var7 = new ModelData(var6, var6.length);
            }

            int var4;
            if(this.recolorFrom != null) {
               for(var4 = 0; var4 < this.recolorFrom.length; ++var4) {
                  var7.method2893(this.recolorFrom[var4], this.recolorTo[var4]);
               }
            }

            if(this.retextureFrom != null) {
               for(var4 = 0; var4 < this.retextureFrom.length; ++var4) {
                  var7.method2945(this.retextureFrom[var4], this.retextureTo[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Ljj;",
      garbageValue = "-2051225078"
   )
   public final NPCDefinition method4791() {
      int var1 = -1;
      if(this.transformVarbit != -1) {
         var1 = Projectile.method2211(this.transformVarbit);
      } else if(this.transformVarp != -1) {
         var1 = Varps.Varps_main[this.transformVarp];
      }

      int var2;
      if(var1 >= 0 && var1 < this.transforms.length - 1) {
         var2 = this.transforms[var1];
      } else {
         var2 = this.transforms[this.transforms.length - 1];
      }

      return var2 != -1?class237.method4226(var2):null;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1945900441"
   )
   public boolean method4792() {
      if(this.transforms == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.transformVarbit != -1) {
            var1 = Projectile.method2211(this.transformVarbit);
         } else if(this.transformVarp != -1) {
            var1 = Varps.Varps_main[this.transformVarp];
         }

         return var1 >= 0 && var1 < this.transforms.length?this.transforms[var1] != -1:this.transforms[this.transforms.length - 1] != -1;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "-11262"
   )
   public int method4796(int var1, int var2) {
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)Ljava/lang/String;",
      garbageValue = "-61"
   )
   public String method4794(int var1, String var2) {
      return class9.method122(this.params, var1, var2);
   }

   public int getRsOverheadIcon() {
      return this.headIconPrayer;
   }

   public void actionsHook(int var1) {
      NpcActionChanged var2 = new NpcActionChanged();
      var2.setNpcDefinition(this);
      var2.setIdx(var1);
      WorldMapSection1.client.getCallbacks().post(NpcActionChanged.class, var2);
   }

   public HeadIcon getOverheadIcon() {
      switch(this.getRsOverheadIcon()) {
      case 0:
         return HeadIcon.MELEE;
      case 1:
         return HeadIcon.RANGED;
      case 2:
         return HeadIcon.MAGIC;
      case 3:
      case 4:
      case 5:
      default:
         return null;
      case 6:
         return HeadIcon.RANGE_MAGE;
      }
   }

   public int getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public int getSize() {
      return this.size;
   }

   public int[] getModels() {
      return this.models;
   }

   public String[] getActions() {
      return this.actions;
   }

   public boolean isMinimapVisible() {
      return this.drawMapDot;
   }

   public int getCombatLevel() {
      return this.combatLevel;
   }

   public boolean isVisible() {
      return this.isVisible;
   }

   public int[] getConfigs() {
      return this.transforms;
   }

   public boolean isInteractible() {
      return this.isInteractable;
   }

   public boolean isClickable() {
      return this.isClickable;
   }

   public boolean isFollower() {
      return this.isFollower;
   }

   public RSNPCDefinition transform() {
      return this.method4791();
   }
}
