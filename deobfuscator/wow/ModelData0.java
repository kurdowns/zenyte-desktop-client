import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSModelData0;

@ObfuscatedName("ed")
public class ModelData0 implements RSModelData0 {

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lle;"
   )
   static IndexedSprite titleboxSprite;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -2057553867
   )
   protected static int gameCyclesToDo;


   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIZIZB)V",
      garbageValue = "-80"
   )
   static void method3363(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = UserComparator2.World_worlds[var6];
         UserComparator2.World_worlds[var6] = UserComparator2.World_worlds[var1];
         UserComparator2.World_worlds[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            World var11 = UserComparator2.World_worlds[var9];
            int var12 = DevicePcmPlayerProvider.method945(var11, var8, var2, var3);
            int var10;
            if(var12 != 0) {
               if(var3) {
                  var10 = -var12;
               } else {
                  var10 = var12;
               }
            } else if(var4 == -1) {
               var10 = 0;
            } else {
               int var13 = DevicePcmPlayerProvider.method945(var11, var8, var4, var5);
               if(var5) {
                  var10 = -var13;
               } else {
                  var10 = var13;
               }
            }

            if(var10 <= 0) {
               World var14 = UserComparator2.World_worlds[var9];
               UserComparator2.World_worlds[var9] = UserComparator2.World_worlds[var7];
               UserComparator2.World_worlds[var7++] = var14;
            }
         }

         UserComparator2.World_worlds[var1] = UserComparator2.World_worlds[var7];
         UserComparator2.World_worlds[var7] = var8;
         method3363(var0, var7 - 1, var2, var3, var4, var5);
         method3363(var7 + 1, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1566964636"
   )
   static void method3364(int var0, int var1, int var2) {
      if(Client.soundEffectVolume != 0 && var1 != 0 && Client.soundEffectCount < 50) {
         Client.soundEffectIds[Client.soundEffectCount] = var0;
         Client.queuedSoundEffectLoops[Client.soundEffectCount] = var1;
         Client.queuedSoundEffectDelays[Client.soundEffectCount] = var2;
         Client.soundEffects[Client.soundEffectCount] = null;
         Client.soundLocations[Client.soundEffectCount] = 0;
         ++Client.soundEffectCount;
         Client.queuedSoundEffectCountChanged(-1);
      }

   }

   @ObfuscatedName("kb")
   @ObfuscatedSignature(
      signature = "(Lkb;II)V",
      garbageValue = "-1883187928"
   )
   static void method3362(Buffer var0, int var1) {
      Interpreter.method2113(var0.array, var1);
      WorldMapSprite.method510(var0, var1);
   }
}
