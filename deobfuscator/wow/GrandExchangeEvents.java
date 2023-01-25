import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSGrandExchangeEvents;

@ObfuscatedName("g")
public class GrandExchangeEvents implements RSGrandExchangeEvents {

   @ObfuscatedName("nl")
   @ObfuscatedSignature(
      signature = "[Lhe;"
   )
   static Widget[] field70;
   @ObfuscatedName("m")
   public static Comparator GrandExchangeEvents_ageComparator = new GrandExchangeOfferAgeComparator();
   @ObfuscatedName("k")
   public static Comparator GrandExchangeEvents_priceComparator;
   @ObfuscatedName("d")
   public static Comparator GrandExchangeEvents_nameComparator;
   @ObfuscatedName("w")
   public static Comparator GrandExchangeEvents_quantityComparator;
   @ObfuscatedName("er")
   @ObfuscatedGetter(
      intValue = 745968807
   )
   static int field71;
   @ObfuscatedName("x")
   public final List events;


   static {
      new GrandExchangeOfferWorldComparator();
      GrandExchangeEvents_priceComparator = new GrandExchangeOfferUnitPriceComparator();
      GrandExchangeEvents_nameComparator = new GrandExchangeOfferNameComparator();
      GrandExchangeEvents_quantityComparator = new GrandExchangeOfferTotalQuantityComparator();
   }

   @ObfuscatedSignature(
      signature = "(Lkb;Z)V",
      garbageValue = "1"
   )
   public GrandExchangeEvents(Buffer var1, boolean var2) {
      int var3 = var1.method5577();
      boolean var4 = var1.method5575() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.method5577();
      this.events = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.events.add(new GrandExchangeEvent(var1, var5, var3));
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "-1613593832"
   )
   public void method152(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.events, var1);
      } else {
         Collections.sort(this.events, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Lef;",
      garbageValue = "1600674213"
   )
   static Frames method154(int var0) {
      Frames var1 = (Frames)SequenceDefinition.SequenceDefinition_cachedFrames.method3432((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         AbstractArchive var3 = GZipDecompressor.SequenceDefinition_animationsArchive;
         AbstractArchive var4 = class92.SequenceDefinition_skeletonsArchive;
         boolean var5 = true;
         int[] var6 = var3.method4259(var0);

         for(int var7 = 0; var7 < var6.length; ++var7) {
            byte[] var8 = var3.method4257(var0, var6[var7]);
            if(var8 == null) {
               var5 = false;
            } else {
               int var9 = (var8[0] & 255) << 8 | var8[1] & 255;
               byte[] var10 = var4.method4257(var9, 0);
               if(var10 == null) {
                  var5 = false;
               }
            }
         }

         Frames var2;
         if(!var5) {
            var2 = null;
         } else {
            try {
               var2 = new Frames(var3, var4, var0, false);
            } catch (Exception var12) {
               var2 = null;
            }
         }

         if(var2 != null) {
            SequenceDefinition.SequenceDefinition_cachedFrames.method3438(var2, (long)var0);
         }

         return var2;
      }
   }

   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "23"
   )
   static final void method155() {
      class8.method109();
      FloorUnderlayDefinition.FloorUnderlayDefinition_cached.method3427();
      UserComparator5.method3521();
      PendingSpawn.method1838();
      class277.method5039();
      class257.method4559();
      class92.method2155();
      SpotAnimationDefinition.SpotAnimationDefinition_cached.method3427();
      SpotAnimationDefinition.SpotAnimationDefinition_cachedModels.method3427();
      MusicPatch.method3980();
      VarpDefinition.VarpDefinition_cached.method3427();
      HitSplatDefinition.HitSplatDefinition_cached.method3427();
      HitSplatDefinition.HitSplatDefinition_cachedSprites.method3427();
      HitSplatDefinition.HitSplatDefinition_cachedFonts.method3427();
      HealthBarDefinition.HealthBarDefinition_cached.method3427();
      HealthBarDefinition.HealthBarDefinition_cachedSprites.method3427();
      ClientPacket.method3688();
      ParamDefinition.ParamDefinition_cached.method3427();
      BuddyRankComparator.method3534();
      Huffman.method4049();
      Widget.Widget_cachedSprites.method3427();
      Widget.Widget_cachedModels.method3427();
      Widget.Widget_cachedFonts.method3427();
      Widget.Widget_cachedSpriteMasks.method3427();
      ((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).method2858();
      Script.Script_cached.method3427();
      ArchiveDiskAction.archive0.method4298();
      DirectByteArrayCopier.archive1.method4298();
      WorldMapSprite.archive3.method4298();
      FontName.archive4.method4298();
      WorldMapIcon_0.archive5.method4298();
      AbstractWorldMapIcon.archive6.method4298();
      AbstractWorldMapIcon.archive7.method4298();
      class228.archive8.method4298();
      SecureRandomFuture.archive9.method4298();
      PlayerAppearance.archive10.method4298();
      WorldMapRegion.archive11.method4298();
      class41.archive12.method4298();
   }
}
