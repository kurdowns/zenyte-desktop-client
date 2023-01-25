import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSWorldMapID;

@ObfuscatedName("av")
public class WorldMapID implements RSWorldMapID {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lav;"
   )
   static final WorldMapID field302 = new WorldMapID(0);
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lav;"
   )
   static final WorldMapID field303 = new WorldMapID(1);
   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "[Lle;"
   )
   static IndexedSprite[] modIconSprites;
   @ObfuscatedName("jh")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   static Widget field307;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -96015239
   )
   final int value;


   WorldMapID(int var1) {
      this.value = var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lkj;B)V",
      garbageValue = "30"
   )
   static final void method648(PacketBuffer var0) {
      int var1 = 0;
      var0.method5524();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < Players.Players_count; ++var2) {
         var3 = Players.Players_indices[var2];
         if((Players.field1267[var3] & 1) == 0) {
            if(var1 > 0) {
               --var1;
               Players.field1267[var3] = (byte)(Players.field1267[var3] | 2);
            } else {
               var4 = var0.method5523(1);
               if(var4 == 0) {
                  var1 = MouseHandler.method1200(var0);
                  Players.field1267[var3] = (byte)(Players.field1267[var3] | 2);
               } else {
                  class25.method278(var0, var3);
               }
            }
         }
      }

      var0.method5526();
      if(var1 != 0) {
         throw new RuntimeException();
      } else {
         var0.method5524();

         for(var2 = 0; var2 < Players.Players_count; ++var2) {
            var3 = Players.Players_indices[var2];
            if((Players.field1267[var3] & 1) != 0) {
               if(var1 > 0) {
                  --var1;
                  Players.field1267[var3] = (byte)(Players.field1267[var3] | 2);
               } else {
                  var4 = var0.method5523(1);
                  if(var4 == 0) {
                     var1 = MouseHandler.method1200(var0);
                     Players.field1267[var3] = (byte)(Players.field1267[var3] | 2);
                  } else {
                     class25.method278(var0, var3);
                  }
               }
            }
         }

         var0.method5526();
         if(var1 != 0) {
            throw new RuntimeException();
         } else {
            var0.method5524();

            for(var2 = 0; var2 < Players.Players_emptyIdxCount; ++var2) {
               var3 = Players.Players_emptyIndices[var2];
               if((Players.field1267[var3] & 1) != 0) {
                  if(var1 > 0) {
                     --var1;
                     Players.field1267[var3] = (byte)(Players.field1267[var3] | 2);
                  } else {
                     var4 = var0.method5523(1);
                     if(var4 == 0) {
                        var1 = MouseHandler.method1200(var0);
                        Players.field1267[var3] = (byte)(Players.field1267[var3] | 2);
                     } else if(class22.method257(var0, var3)) {
                        Players.field1267[var3] = (byte)(Players.field1267[var3] | 2);
                     }
                  }
               }
            }

            var0.method5526();
            if(var1 != 0) {
               throw new RuntimeException();
            } else {
               var0.method5524();

               for(var2 = 0; var2 < Players.Players_emptyIdxCount; ++var2) {
                  var3 = Players.Players_emptyIndices[var2];
                  if((Players.field1267[var3] & 1) == 0) {
                     if(var1 > 0) {
                        --var1;
                        Players.field1267[var3] = (byte)(Players.field1267[var3] | 2);
                     } else {
                        var4 = var0.method5523(1);
                        if(var4 == 0) {
                           var1 = MouseHandler.method1200(var0);
                           Players.field1267[var3] = (byte)(Players.field1267[var3] | 2);
                        } else if(class22.method257(var0, var3)) {
                           Players.field1267[var3] = (byte)(Players.field1267[var3] | 2);
                        }
                     }
                  }
               }

               var0.method5526();
               if(var1 != 0) {
                  throw new RuntimeException();
               } else {
                  Players.Players_count = 0;
                  Players.Players_emptyIdxCount = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     Players.field1267[var2] = (byte)(Players.field1267[var2] >> 1);
                     Player var5 = Client.players[var2];
                     if(var5 != null) {
                        Players.Players_indices[++Players.Players_count - 1] = var2;
                     } else {
                        Players.Players_emptyIndices[++Players.Players_emptyIdxCount - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }
}
