import java.util.HashMap;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSFonts;

@ObfuscatedName("kf")
public class Fonts implements RSFonts {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   AbstractArchive spritesArchive;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   AbstractArchive fontsArchive;
   @ObfuscatedName("k")
   HashMap map;


   @ObfuscatedSignature(
      signature = "(Liy;Liy;)V"
   )
   public Fonts(AbstractArchive var1, AbstractArchive var2) {
      this.spritesArchive = var1;
      this.fontsArchive = var2;
      this.map = new HashMap();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([Lka;I)Ljava/util/HashMap;",
      garbageValue = "-1813664222"
   )
   public HashMap method5392(FontName[] var1) {
      HashMap var2 = new HashMap();
      FontName[] var3 = var1;

      for(int var4 = 0; var4 < var3.length; ++var4) {
         FontName var5 = var3[var4];
         if(this.map.containsKey(var5)) {
            var2.put(var5, this.map.get(var5));
         } else {
            Font var6 = class39.method647(this.spritesArchive, this.fontsArchive, var5.name, "");
            if(var6 != null) {
               this.map.put(var5, var6);
               var2.put(var5, var6);
            }
         }
      }

      return var2;
   }
}
