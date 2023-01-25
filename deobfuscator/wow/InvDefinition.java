import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSInvDefinition;

@ObfuscatedName("iq")
public class InvDefinition extends DualNode implements RSInvDefinition {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   static AbstractArchive InvDefinition_archive;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Leg;"
   )
   static EvictingDualNodeHashTable InvDefinition_cached = new EvictingDualNodeHashTable(64);
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -307651921
   )
   public int size = 0;


   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lkb;I)V",
      garbageValue = "117570412"
   )
   void method4442(Buffer var1) {
      while(true) {
         int var2 = var1.method5575();
         if(var2 == 0) {
            return;
         }

         this.method4443(var1, var2);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lkb;II)V",
      garbageValue = "-72548916"
   )
   void method4443(Buffer var1, int var2) {
      if(var2 == 2) {
         this.size = var1.method5577();
      }

   }

   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "566997565"
   )
   static final void method4444() {
      if(ScriptEvent.Client_plane != Client.field695) {
         Client.field695 = ScriptEvent.Client_plane;
         int var0 = ScriptEvent.Client_plane;
         int[] var1 = ArchiveDisk.sceneMinimapSprite.pixels;
         int var2 = var1.length;

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            var1[var3] = 0;
         }

         int var4;
         int var5;
         for(var3 = 1; var3 < 103; ++var3) {
            var4 = (103 - var3) * 2048 + 24628;

            for(var5 = 1; var5 < 103; ++var5) {
               if((Tiles.Tiles_renderFlags[var0][var5][var3] & 24) == 0) {
                  GrandExchangeOfferWorldComparator.scene.method3359(var1, var4, 512, var0, var5, var3);
               }

               if(var0 < 3 && (Tiles.Tiles_renderFlags[var0 + 1][var5][var3] & 8) != 0) {
                  GrandExchangeOfferWorldComparator.scene.method3359(var1, var4, 512, var0 + 1, var5, var3);
               }

               var4 += 4;
            }
         }

         var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
         var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
         ArchiveDisk.sceneMinimapSprite.method6219();

         int var6;
         for(var5 = 1; var5 < 103; ++var5) {
            for(var6 = 1; var6 < 103; ++var6) {
               if((Tiles.Tiles_renderFlags[var0][var6][var5] & 24) == 0) {
                  ScriptFrame.method1243(var0, var6, var5, var3, var4);
               }

               if(var0 < 3 && (Tiles.Tiles_renderFlags[var0 + 1][var6][var5] & 8) != 0) {
                  ScriptFrame.method1243(var0 + 1, var6, var5, var3, var4);
               }
            }
         }

         Client.mapIconCount = 0;

         for(var5 = 0; var5 < 104; ++var5) {
            for(var6 = 0; var6 < 104; ++var6) {
               long var7 = GrandExchangeOfferWorldComparator.scene.method3323(ScriptEvent.Client_plane, var5, var6);
               if(0L != var7) {
                  int var9 = WorldMapRectangle.method387(var7);
                  int var10 = WorldMapSection2.method435(var9).mapIconId;
                  if(var10 >= 0) {
                     Client.mapIcons[Client.mapIconCount] = class25.method279(var10).method4468(false);
                     Client.mapIconXs[Client.mapIconCount] = var5;
                     Client.mapIconYs[Client.mapIconCount] = var6;
                     ++Client.mapIconCount;
                  }
               }
            }
         }

         class206.rasterProvider.method6178();
      }

   }
}
