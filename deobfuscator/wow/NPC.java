import java.awt.Shape;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.NpcDefinitionChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSModel;
import net.runelite.rs.api.RSNPC;
import net.runelite.rs.api.RSNPCDefinition;

@ObfuscatedName("cd")
public final class NPC extends Actor implements RSNPC {

   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   static Archive archive13;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   NPCDefinition definition;
   public int npcIndex;
   public boolean dead;


   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IBI)V",
      garbageValue = "1357831491"
   )
   final void method2133(int var1, byte var2) {
      int var3 = super.pathX[0];
      int var4 = super.pathY[0];
      if(var1 == 0) {
         --var3;
         ++var4;
      }

      if(var1 == 1) {
         ++var4;
      }

      if(var1 == 2) {
         ++var3;
         ++var4;
      }

      if(var1 == 3) {
         --var3;
      }

      if(var1 == 4) {
         ++var3;
      }

      if(var1 == 5) {
         --var3;
         --var4;
      }

      if(var1 == 6) {
         --var4;
      }

      if(var1 == 7) {
         ++var3;
         --var4;
      }

      if(super.sequence != -1 && SpotAnimationDefinition.method4503(super.sequence).field3524 == 1) {
         super.sequence = -1;
         this.animationChanged(-1);
      }

      if(super.pathLength < 9) {
         ++super.pathLength;
      }

      for(int var5 = super.pathLength; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.pathTraversed[var5] = super.pathTraversed[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.pathTraversed[0] = var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "88"
   )
   final void method2136(int var1, int var2, boolean var3) {
      if(super.sequence != -1 && SpotAnimationDefinition.method4503(super.sequence).field3524 == 1) {
         super.sequence = -1;
         this.animationChanged(-1);
      }

      if(!var3) {
         int var4 = var1 - super.pathX[0];
         int var5 = var2 - super.pathY[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.pathLength < 9) {
               ++super.pathLength;
            }

            for(int var6 = super.pathLength; var6 > 0; --var6) {
               super.pathX[var6] = super.pathX[var6 - 1];
               super.pathY[var6] = super.pathY[var6 - 1];
               super.pathTraversed[var6] = super.pathTraversed[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.pathTraversed[0] = 1;
            return;
         }
      }

      super.pathLength = 0;
      super.field1032 = 0;
      super.field1031 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.field976 * 64 + super.pathX[0] * 128;
      super.y = super.field976 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Lel;"
   )
   protected final Model vmethod3367(int var1) {
      if(WorldMapSection1.client.isInterpolateNpcAnimations() && this.getAnimation() != 6566) {
         int var2 = this.getActionFrame();
         int var3 = this.getPoseFrame();
         int var4 = this.getSpotAnimationFrame();

         Model var5;
         try {
            this.setActionFrame(Integer.MIN_VALUE | this.getActionFrameCycle() << 16 | var2);
            this.setPoseFrame(Integer.MIN_VALUE | this.getPoseFrameCycle() << 16 | var3);
            this.setSpotAnimationFrame(Integer.MIN_VALUE | this.getSpotAnimationFrameCycle() << 16 | var4);
            var5 = this.copy$getModel(var1);
         } finally {
            this.setActionFrame(var2);
            this.setPoseFrame(var3);
            this.setSpotAnimationFrame(var4);
         }

         return (Model)var5;
      } else {
         return (Model)this.copy$getModel(var1);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "116176402"
   )
   final boolean vmethod2132() {
      return this.definition != null;
   }

   public RSNPCDefinition getDefinition() {
      return this.definition;
   }

   public int getId() {
      RSNPCDefinition var1 = this.getDefinition();
      if(var1 != null && var1.getConfigs() != null) {
         var1 = var1.transform();
      }

      return var1 == null?-1:var1.getId();
   }

   @ObfuscatedSignature(
      signature = "(I)Lel;"
   )
   public final Model copy$getModel(int var1) {
      if(this.definition == null) {
         return null;
      } else {
         SequenceDefinition var2 = super.sequence != -1 && super.sequenceDelay == 0?SpotAnimationDefinition.method4503(super.sequence):null;
         SequenceDefinition var3 = super.movementSequence != -1 && (super.idleSequence != super.movementSequence || var2 == null)?SpotAnimationDefinition.method4503(super.movementSequence):null;
         Model var4 = this.definition.method4789(var2, super.sequenceFrame, var3, super.movementFrame);
         if(var4 == null) {
            return null;
         } else {
            var4.method2969();
            super.defaultHeight = var4.height;
            if(super.spotAnimation != -1 && super.spotAnimationFrame != -1) {
               Model var5 = MouseHandler.method1205(super.spotAnimation).method4492(super.spotAnimationFrame);
               if(var5 != null) {
                  var5.method2980(0, -super.field1033, 0);
                  Model[] var6 = new Model[]{var4, var5};
                  var4 = new Model(var6, 2);
               }
            }

            if(this.definition.size == 1) {
               var4.isSingleTile = true;
            }

            return var4;
         }
      }
   }

   public void onDefinitionChanged(RSNPCDefinition var1) {
      if(var1 == null) {
         WorldMapSection1.client.getCallbacks().post(NpcDespawned.class, new NpcDespawned(this));
      } else if(this.getId() != -1) {
         WorldMapSection1.client.getCallbacks().post(NpcDefinitionChanged.class, new NpcDefinitionChanged(this));
      }

   }

   public String getName() {
      RSNPCDefinition var1 = this.getDefinition();
      if(var1 != null && var1.getConfigs() != null) {
         var1 = var1.transform();
      }

      return var1 == null?null:var1.getName().replace('\u00a0', ' ');
   }

   public int getCombatLevel() {
      RSNPCDefinition var1 = this.getDefinition();
      if(var1 != null && var1.getConfigs() != null) {
         var1 = var1.transform();
      }

      return var1 == null?-1:var1.getCombatLevel();
   }

   public int getIndex() {
      return this.npcIndex;
   }

   public void setIndex(int var1) {
      this.npcIndex = var1;
   }

   public net.runelite.api.NPCDefinition getTransformedDefinition() {
      RSNPCDefinition var1 = this.getDefinition();
      if(var1 != null && var1.getConfigs() != null) {
         var1 = var1.transform();
      }

      return var1;
   }

   public boolean isDead() {
      return this.dead;
   }

   public void setDead(boolean var1) {
      this.dead = var1;
   }

   public Shape getConvexHull() {
      RSModel var1 = this.getModel();
      if(var1 == null) {
         return null;
      } else {
         int var2 = this.getDefinition().getSize();
         LocalPoint var3 = new LocalPoint(var2 * 64 - 64 + this.getX(), var2 * 64 - 64 + this.getY());
         int var4 = Perspective.getTileHeight(WorldMapSection1.client, var3, WorldMapSection1.client.getPlane());
         return var1.getConvexHull(this.getX(), this.getY(), this.getOrientation(), var4);
      }
   }

   @ObfuscatedName("x")
   public static final int method2146(double var0, double var2, double var4) {
      double var6 = var4;
      double var8 = var4;
      double var10 = var4;
      if(0.0D != var2) {
         double var12;
         if(var4 < 0.5D) {
            var12 = (1.0D + var2) * var4;
         } else {
            var12 = var2 + var4 - var4 * var2;
         }

         double var14 = var4 * 2.0D - var12;
         double var16 = var0 + 0.3333333333333333D;
         if(var16 > 1.0D) {
            --var16;
         }

         double var20 = var0 - 0.3333333333333333D;
         if(var20 < 0.0D) {
            ++var20;
         }

         if(var16 * 6.0D < 1.0D) {
            var6 = var14 + var16 * (var12 - var14) * 6.0D;
         } else if(var16 * 2.0D < 1.0D) {
            var6 = var12;
         } else if(var16 * 3.0D < 2.0D) {
            var6 = (var12 - var14) * (0.6666666666666666D - var16) * 6.0D + var14;
         } else {
            var6 = var14;
         }

         if(var0 * 6.0D < 1.0D) {
            var8 = var14 + (var12 - var14) * 6.0D * var0;
         } else if(var0 * 2.0D < 1.0D) {
            var8 = var12;
         } else if(3.0D * var0 < 2.0D) {
            var8 = var14 + (var12 - var14) * (0.6666666666666666D - var0) * 6.0D;
         } else {
            var8 = var14;
         }

         if(var20 * 6.0D < 1.0D) {
            var10 = var14 + 6.0D * (var12 - var14) * var20;
         } else if(var20 * 2.0D < 1.0D) {
            var10 = var12;
         } else if(3.0D * var20 < 2.0D) {
            var10 = (var12 - var14) * (0.6666666666666666D - var20) * 6.0D + var14;
         } else {
            var10 = var14;
         }
      }

      int var22 = (int)(var6 * 256.0D);
      int var13 = (int)(var8 * 256.0D);
      int var23 = (int)(var10 * 256.0D);
      int var15 = var23 + (var13 << 8) + (var22 << 16);
      return var15;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILce;ZI)I",
      garbageValue = "-1441905186"
   )
   static int method2147(int var0, Script var1, boolean var2) {
      Widget var3 = var2?GrandExchangeOfferNameComparator.field115:Interpreter.field1130;
      if(var0 == 1700) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.itemId;
         return 1;
      } else if(var0 == 1701) {
         if(var3.itemId != -1) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.itemQuantity;
         } else {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 1702) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.childIndex;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(ILce;ZB)I",
      garbageValue = "-41"
   )
   static int method2145(int var0, Script var1, boolean var2) {
      if(var0 == 3200) {
         Interpreter.Interpreter_intStackSize -= 3;
         ModelData0.method3364(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2]);
         return 1;
      } else if(var0 == 3201) {
         StudioGame.method4244(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
         return 1;
      } else if(var0 == 3202) {
         Interpreter.Interpreter_intStackSize -= 2;
         VerticalAlignment.method4440(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
         return 1;
      } else {
         return 2;
      }
   }
}
