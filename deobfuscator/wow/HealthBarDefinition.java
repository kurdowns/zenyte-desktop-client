import net.runelite.api.events.PostHealthBar;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSBuffer;
import net.runelite.rs.api.RSHealthBarDefinition;
import net.runelite.rs.api.RSSprite;

@ObfuscatedName("id")
public class HealthBarDefinition extends DualNode implements RSHealthBarDefinition {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   public static AbstractArchive HealthBarDefinition_archive;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Leg;"
   )
   public static EvictingDualNodeHashTable HealthBarDefinition_cached = new EvictingDualNodeHashTable(64);
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Leg;"
   )
   public static EvictingDualNodeHashTable HealthBarDefinition_cachedSprites = new EvictingDualNodeHashTable(64);
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -418379087
   )
   public int field3276;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 257214369
   )
   public int int1 = 255;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1626711481
   )
   public int int2 = 255;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -519347749
   )
   public int int3 = -1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 125223577
   )
   public int field3272 = 1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -211627759
   )
   public int int5 = 70;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1469087681
   )
   int frontSpriteID = -1;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1575037275
   )
   int backSpriteID = -1;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 411601749
   )
   public int width = 30;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1992936291
   )
   public int widthPadding = 0;


   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lkb;I)V",
      garbageValue = "-1815085637"
   )
   public void method4546(Buffer var1) {
      while(true) {
         int var2 = var1.method5575();
         if(var2 == 0) {
            this.onRead(var1);
            return;
         }

         this.method4547(var1, var2);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lkb;II)V",
      garbageValue = "1931441853"
   )
   void method4547(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.method5577();
      } else if(var2 == 2) {
         this.int1 = var1.method5575();
      } else if(var2 == 3) {
         this.int2 = var1.method5575();
      } else if(var2 == 4) {
         this.int3 = 0;
      } else if(var2 == 5) {
         this.int5 = var1.method5577();
      } else if(var2 == 6) {
         var1.method5575();
      } else if(var2 == 7) {
         this.frontSpriteID = var1.method5592();
      } else if(var2 == 8) {
         this.backSpriteID = var1.method5592();
      } else if(var2 == 11) {
         this.int3 = var1.method5577();
      } else if(var2 == 14) {
         this.width = var1.method5575();
      } else if(var2 == 15) {
         this.widthPadding = var1.method5575();
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(S)Lla;",
      garbageValue = "1701"
   )
   public Sprite method4548() {
      if(this.frontSpriteID < 0) {
         return null;
      } else {
         Sprite var1 = (Sprite)HealthBarDefinition_cachedSprites.method3432((long)this.frontSpriteID);
         if(var1 != null) {
            return var1;
         } else {
            var1 = MusicPatchNode2.method3774(UserComparator1.HitSplatDefinition_spritesArchive, this.frontSpriteID, 0, 273345835);
            if(var1 != null) {
               HealthBarDefinition_cachedSprites.method3438(var1, (long)this.frontSpriteID);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Lla;",
      garbageValue = "1861000233"
   )
   public Sprite method4549() {
      if(this.backSpriteID < 0) {
         return null;
      } else {
         Sprite var1 = (Sprite)HealthBarDefinition_cachedSprites.method3432((long)this.backSpriteID);
         if(var1 != null) {
            return var1;
         } else {
            var1 = MusicPatchNode2.method3774(UserComparator1.HitSplatDefinition_spritesArchive, this.backSpriteID, 0, 273345835);
            if(var1 != null) {
               HealthBarDefinition_cachedSprites.method3438(var1, (long)this.backSpriteID);
            }

            return var1;
         }
      }
   }

   public void onRead(RSBuffer var1) {
      PostHealthBar var2 = new PostHealthBar();
      var2.setHealthBar(this);
      WorldMapSection1.client.getCallbacks().post(PostHealthBar.class, var2);
   }

   public int getHealthBarFrontSpriteId() {
      return this.frontSpriteID;
   }

   public int getHealthScale() {
      return this.width;
   }

   public void setPadding(int var1) {
      this.widthPadding = var1;
   }

   public RSSprite getHealthBarFrontSprite() {
      return this.method4548();
   }

   public RSSprite getHealthBarBackSprite() {
      return this.method4549();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "1768819219"
   )
   public static int method4558(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + TaskHandler.method3574(var0.charAt(var3));
      }

      return var2;
   }
}
