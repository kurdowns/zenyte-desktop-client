import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSAbstractWorldMapIcon;

@ObfuscatedName("ax")
public abstract class AbstractWorldMapIcon implements RSAbstractWorldMapIcon {

   @ObfuscatedName("sq")
   @ObfuscatedGetter(
      intValue = -1106675929
   )
   static int foundItemIndex;
   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   static Archive archive6;
   @ObfuscatedName("dy")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   static Archive archive7;
   @ObfuscatedName("fp")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   static Task socketTask;
   @ObfuscatedName("la")
   @ObfuscatedSignature(
      signature = "Lci;"
   )
   static MenuAction tempMenuAction;
   @ObfuscatedName("my")
   @ObfuscatedGetter(
      intValue = 468589673
   )
   static int selectedSpellFlags;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   public final Coord coord2;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   public final Coord coord1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1506769643
   )
   int screenX;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -896182235
   )
   int screenY;


   @ObfuscatedSignature(
      signature = "(Lhj;Lhj;)V"
   )
   AbstractWorldMapIcon(Coord var1, Coord var2) {
      this.coord1 = var1;
      this.coord2 = var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "69"
   )
   public abstract int vmethod685();

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Lau;",
      garbageValue = "2077771117"
   )
   abstract WorldMapLabel vmethod710();

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "650401890"
   )
   abstract int vmethod688();

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1828864081"
   )
   abstract int vmethod693();

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-57056512"
   )
   boolean method711(int var1, int var2) {
      return this.method698(var1, var2)?true:this.method691(var1, var2);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "-27709"
   )
   boolean method689() {
      return this.vmethod685() >= 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1127928990"
   )
   boolean method698(int var1, int var2) {
      if(!this.method689()) {
         return false;
      } else {
         WorldMapElement var3 = class25.method279(this.vmethod685());
         int var4 = this.vmethod688();
         int var5 = this.vmethod693();
         switch(var3.horizontalAlignment.value) {
         case 0:
            if(var1 < this.screenX - var4 / 2 || var1 > var4 / 2 + this.screenX) {
               return false;
            }
            break;
         case 1:
            if(var1 < this.screenX || var1 >= var4 + this.screenX) {
               return false;
            }
            break;
         case 2:
            if(var1 <= this.screenX - var4 || var1 > this.screenX) {
               return false;
            }
         }

         switch(var3.verticalAlignment.value) {
         case 0:
            if(var2 <= this.screenY - var5 || var2 > this.screenY) {
               return false;
            }
            break;
         case 1:
            if(var2 < this.screenY - var5 / 2 || var2 > var5 / 2 + this.screenY) {
               return false;
            }
            break;
         case 2:
            if(var2 < this.screenY || var2 >= var5 + this.screenY) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-411865092"
   )
   boolean method691(int var1, int var2) {
      WorldMapLabel var3 = this.vmethod710();
      return var3 == null?false:(var1 >= this.screenX - var3.width / 2 && var1 <= var3.width / 2 + this.screenX?var2 >= this.screenY && var2 <= this.screenY + var3.height:false);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "0"
   )
   public static boolean method684(char var0) {
      return var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }
}
