import net.runelite.api.IndexDataBase;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSTexture;
import net.runelite.rs.api.RSTextureProvider;

@ObfuscatedName("di")
public class TextureProvider implements TextureLoader, RSTextureProvider {

   @ObfuscatedName("sy")
   @ObfuscatedGetter(
      intValue = 33349477
   )
   static int foundItemIdCount;
   @ObfuscatedName("rl")
   @ObfuscatedGetter(
      intValue = -726366613
   )
   static int field1549;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "[Let;"
   )
   Texture[] textures;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   NodeDeque deque = new NodeDeque();
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1467645999
   )
   int capacity;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2063974961
   )
   int remaining = 0;
   @ObfuscatedName("w")
   double brightness = 1.0D;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 499295403
   )
   int textureSize = 128;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   AbstractArchive archive;


   @ObfuscatedSignature(
      signature = "(Liy;Liy;IDI)V"
   )
   public TextureProvider(AbstractArchive var1, AbstractArchive var2, int var3, double var4, int var6) {
      this.archive = var2;
      this.capacity = var3;
      this.remaining = this.capacity;
      this.brightness = var4;
      this.textureSize = var6;
      int[] var7 = var1.method4259(0);
      int var8 = var7.length;
      this.textures = new Texture[var1.method4271(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         Buffer var10 = new Buffer(var1.method4249(0, var7[var9], (byte)-71));
         this.textures[var7[var9]] = new Texture(var10);
      }

      this.rl$init(var1, var2, var3, var4, var6);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1161894618"
   )
   public int method2852() {
      int var1 = 0;
      int var2 = 0;
      Texture[] var3 = this.textures;

      for(int var4 = 0; var4 < var3.length; ++var4) {
         Texture var5 = var3[var4];
         if(var5 != null && var5.fileIds != null) {
            var1 += var5.fileIds.length;
            int[] var6 = var5.fileIds;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               int var8 = var6[var7];
               if(this.archive.method4252(var8)) {
                  ++var2;
               }
            }
         }
      }

      if(var1 == 0) {
         return 0;
      } else {
         return var2 * 100 / var1;
      }
   }

   @ObfuscatedName("m")
   public void method2853(double var1) {
      this.brightness = var1;
      this.method2858();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-1464136827"
   )
   public int[] vmethod3390(int var1) {
      Texture var2 = this.textures[var1];
      if(var2 != null) {
         if(var2.pixels != null) {
            this.deque.method4952(var2);
            var2.isLoaded = true;
            return var2.pixels;
         }

         boolean var3 = var2.method2954(this.brightness, this.textureSize, this.archive);
         if(var3) {
            if(this.remaining == 0) {
               Texture var4 = (Texture)this.deque.method4955();
               var4.method2955();
            } else {
               --this.remaining;
            }

            this.deque.method4952(var2);
            var2.isLoaded = true;
            return var2.pixels;
         }
      }

      return null;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "-417"
   )
   public int vmethod3386(int var1) {
      return this.textures[var1] != null?this.textures[var1].averageRGB:0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "19136776"
   )
   public boolean vmethod3388(int var1) {
      return this.textures[var1].field1638;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "649013843"
   )
   public boolean vmethod3394(int var1) {
      return this.textureSize == 64;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1865024943"
   )
   public void method2858() {
      for(int var1 = 0; var1 < this.textures.length; ++var1) {
         if(this.textures[var1] != null) {
            this.textures[var1].method2955();
         }
      }

      this.deque = new NodeDeque();
      this.remaining = this.capacity;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2066840456"
   )
   public void method2859(int var1) {
      for(int var2 = 0; var2 < this.textures.length; ++var2) {
         Texture var3 = this.textures[var2];
         if(var3 != null && var3.animationDirection != 0 && var3.isLoaded) {
            var3.method2956(var1);
            var3.isLoaded = false;
         }
      }

      this.checkTextures(var1);
   }

   public void setMaxSize(int var1) {
      this.capacity = var1;
   }

   public void checkTextures(int var1) {
      WorldMapSection1.client.getCallbacks().drawAboveOverheads();
   }

   public void setSize(int var1) {
      this.remaining = var1;
   }

   public void rl$init(IndexDataBase var1, IndexDataBase var2, int var3, double var4, int var6) {
      this.setMaxSize(64);
      this.setSize(64);
   }

   public RSTexture[] getTextures() {
      return this.textures;
   }

   public double getBrightness() {
      return this.brightness;
   }

   public void setBrightness(double var1) {
      this.method2853(var1);
   }

   public int[] load(int var1) {
      return this.vmethod3390(var1);
   }
}
