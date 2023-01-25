import java.io.IOException;
import java.math.BigInteger;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSBuffer;

@ObfuscatedName("kb")
public class Buffer extends Node implements RSBuffer {

   @ObfuscatedName("z")
   static int[] crc32Table = new int[256];
   @ObfuscatedName("e")
   static long[] crc64Table;
   @ObfuscatedName("v")
   public byte[] array;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 77261851
   )
   public int offset;


   static {
      int var2;
      for(int var1 = 0; var1 < 256; ++var1) {
         int var0 = var1;

         for(var2 = 0; var2 < 8; ++var2) {
            if((var0 & 1) == 1) {
               var0 = var0 >>> 1 ^ -306674912;
            } else {
               var0 >>>= 1;
            }
         }

         crc32Table[var1] = var0;
      }

      crc64Table = new long[256];

      for(var2 = 0; var2 < 256; ++var2) {
         long var4 = (long)var2;

         for(int var3 = 0; var3 < 8; ++var3) {
            if((var4 & 1L) == 1L) {
               var4 = var4 >>> 1 ^ -3932672073523589310L;
            } else {
               var4 >>>= 1;
            }
         }

         crc64Table[var2] = var4;
      }

   }

   public Buffer(int var1) {
      this.array = class182.method3664(var1);
      this.offset = 0;
   }

   public Buffer(byte[] var1) {
      this.array = var1;
      this.offset = 0;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public void method5558() {
      if(this.array != null) {
         WorldMapSection3.method899(this.array);
      }

      this.array = null;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1258821856"
   )
   public void method5559(int var1) {
      this.array[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-125"
   )
   public void method5560(int var1) {
      this.array[++this.offset - 1] = (byte)(var1 >> 8);
      this.array[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1120871833"
   )
   public void method5616(int var1) {
      this.array[++this.offset - 1] = (byte)(var1 >> 16);
      this.array[++this.offset - 1] = (byte)(var1 >> 8);
      this.array[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "747474969"
   )
   public void method5717(int var1) {
      this.array[++this.offset - 1] = (byte)(var1 >> 24);
      this.array[++this.offset - 1] = (byte)(var1 >> 16);
      this.array[++this.offset - 1] = (byte)(var1 >> 8);
      this.array[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("aw")
   public void method5563(long var1) {
      this.array[++this.offset - 1] = (byte)((int)(var1 >> 40));
      this.array[++this.offset - 1] = (byte)((int)(var1 >> 32));
      this.array[++this.offset - 1] = (byte)((int)(var1 >> 24));
      this.array[++this.offset - 1] = (byte)((int)(var1 >> 16));
      this.array[++this.offset - 1] = (byte)((int)(var1 >> 8));
      this.array[++this.offset - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("bf")
   public void method5557(long var1) {
      this.array[++this.offset - 1] = (byte)((int)(var1 >> 56));
      this.array[++this.offset - 1] = (byte)((int)(var1 >> 48));
      this.array[++this.offset - 1] = (byte)((int)(var1 >> 40));
      this.array[++this.offset - 1] = (byte)((int)(var1 >> 32));
      this.array[++this.offset - 1] = (byte)((int)(var1 >> 24));
      this.array[++this.offset - 1] = (byte)((int)(var1 >> 16));
      this.array[++this.offset - 1] = (byte)((int)(var1 >> 8));
      this.array[++this.offset - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1864827002"
   )
   public void method5718(boolean var1) {
      this.method5559(var1?1:0);
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1801099985"
   )
   public void method5655(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.offset += class90.method2150(var1, 0, var1.length(), this.array, this.offset);
         this.array[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)V",
      garbageValue = "21883"
   )
   public void method5669(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.array[++this.offset - 1] = 0;
         this.offset += class90.method2150(var1, 0, var1.length(), this.array, this.offset);
         this.array[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)V",
      garbageValue = "-1160654316"
   )
   public void method5568(CharSequence var1) {
      int var3 = var1.length();
      int var4 = 0;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var1.charAt(var5);
         if(var6 <= 127) {
            ++var4;
         } else if(var6 <= 2047) {
            var4 += 2;
         } else {
            var4 += 3;
         }
      }

      this.array[++this.offset - 1] = 0;
      this.method5574(var4);
      this.offset += Entity.method3372(this.array, this.offset, var1);
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1590891251"
   )
   public void method5624(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         this.array[++this.offset - 1] = var1[var4];
      }

   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(Lkb;I)V",
      garbageValue = "-1161644525"
   )
   public void method5790(Buffer var1) {
      this.method5624(var1.array, 0, var1.offset);
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-788698367"
   )
   public void method5735(int var1) {
      if(var1 < 0) {
         throw new IllegalArgumentException();
      } else {
         this.array[this.offset - var1 - 4] = (byte)(var1 >> 24);
         this.array[this.offset - var1 - 3] = (byte)(var1 >> 16);
         this.array[this.offset - var1 - 2] = (byte)(var1 >> 8);
         this.array[this.offset - var1 - 1] = (byte)var1;
      }
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "733201281"
   )
   public void method5754(int var1) {
      if(var1 >= 0 && var1 <= '\uffff') {
         this.array[this.offset - var1 - 2] = (byte)(var1 >> 8);
         this.array[this.offset - var1 - 1] = (byte)var1;
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1075172075"
   )
   public void method5684(int var1) {
      if(var1 >= 0 && var1 <= 255) {
         this.array[this.offset - var1 - 1] = (byte)var1;
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-13"
   )
   public void method5602(int var1) {
      if(var1 >= 0 && var1 < 128) {
         this.method5559(var1);
      } else if(var1 >= 0 && var1 < '\u8000') {
         this.method5560(var1 + '\u8000');
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2128339921"
   )
   public void method5574(int var1) {
      if((var1 & -128) != 0) {
         if((var1 & -16384) != 0) {
            if((var1 & -2097152) != 0) {
               if((var1 & -268435456) != 0) {
                  this.method5559(var1 >>> 28 | 128);
               }

               this.method5559(var1 >>> 21 | 128);
            }

            this.method5559(var1 >>> 14 | 128);
         }

         this.method5559(var1 >>> 7 | 128);
      }

      this.method5559(var1 & 127);
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "53"
   )
   public int method5575() {
      return this.array[++this.offset - 1] & 255;
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-477100423"
   )
   public byte method5576() {
      return this.array[++this.offset - 1];
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "67"
   )
   public int method5577() {
      this.offset += 2;
      return (this.array[this.offset - 1] & 255) + ((this.array[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1069799026"
   )
   public int method5578() {
      this.offset += 2;
      int var1 = (this.array[this.offset - 1] & 255) + ((this.array[this.offset - 2] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "3112"
   )
   public int method5702() {
      this.offset += 3;
      return ((this.array[this.offset - 3] & 255) << 16) + (this.array[this.offset - 1] & 255) + ((this.array[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "297718403"
   )
   public int method5580() {
      this.offset += 4;
      return ((this.array[this.offset - 3] & 255) << 16) + (this.array[this.offset - 1] & 255) + ((this.array[this.offset - 2] & 255) << 8) + ((this.array[this.offset - 4] & 255) << 24);
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "106"
   )
   public long method5581() {
      long var1 = (long)this.method5580() & 4294967295L;
      long var3 = (long)this.method5580() & 4294967295L;
      return (var1 << 32) + var3;
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "25"
   )
   public boolean method5710() {
      return (this.method5575() & 1) == 1;
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-43"
   )
   public String method5583() {
      if(this.array[this.offset] == 0) {
         ++this.offset;
         return null;
      } else {
         return this.method5695();
      }
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1642072117"
   )
   public String method5695() {
      int var1 = this.offset;

      while(this.array[++this.offset - 1] != 0) {
         ;
      }

      int var2 = this.offset - var1 - 1;
      return var2 == 0?"":WorldMapArea.method507(this.array, var1, var2);
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1416358410"
   )
   public String method5585() {
      byte var1 = this.array[++this.offset - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.offset;

         while(this.array[++this.offset - 1] != 0) {
            ;
         }

         int var3 = this.offset - var2 - 1;
         return var3 == 0?"":WorldMapArea.method507(this.array, var2, var3);
      }
   }

   public void copy$encryptRsa(BigInteger var1, BigInteger var2, int var3) {
      int var4 = this.offset;
      this.offset = 0;
      byte[] var5 = new byte[var4];
      this.method5648(var5, 0, var4);
      BigInteger var6 = new BigInteger(var5);
      BigInteger var7 = var6.modPow(var1, var2);
      byte[] var8 = var7.toByteArray();
      this.offset = 0;
      this.method5560(var8.length);
      this.method5624(var8, 0, var8.length);
   }

   public byte[] getPayload() {
      return this.array;
   }

   public int getOffset() {
      return this.offset;
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-902492653"
   )
   public String method5709() {
      byte var1 = this.array[++this.offset - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.method5599();
         if(var2 + this.offset > this.array.length) {
            throw new IllegalStateException("");
         } else {
            byte[] var4 = this.array;
            int var5 = this.offset;
            char[] var6 = new char[var2];
            int var7 = 0;
            int var8 = var5;

            int var11;
            for(int var9 = var5 + var2; var8 < var9; var6[var7++] = (char)var11) {
               int var10 = var4[var8++] & 255;
               if(var10 < 128) {
                  if(var10 == 0) {
                     var11 = '\ufffd';
                  } else {
                     var11 = var10;
                  }
               } else if(var10 < 192) {
                  var11 = '\ufffd';
               } else if(var10 < 224) {
                  if(var8 < var9 && (var4[var8] & 192) == 128) {
                     var11 = (var10 & 31) << 6 | var4[var8++] & 63;
                     if(var11 < 128) {
                        var11 = '\ufffd';
                     }
                  } else {
                     var11 = '\ufffd';
                  }
               } else if(var10 < 240) {
                  if(var8 + 1 < var9 && (var4[var8] & 192) == 128 && (var4[var8 + 1] & 192) == 128) {
                     var11 = (var10 & 15) << 12 | (var4[var8++] & 63) << 6 | var4[var8++] & 63;
                     if(var11 < 2048) {
                        var11 = '\ufffd';
                     }
                  } else {
                     var11 = '\ufffd';
                  }
               } else if(var10 < 248) {
                  if(var8 + 2 < var9 && (var4[var8] & 192) == 128 && (var4[var8 + 1] & 192) == 128 && (var4[var8 + 2] & 192) == 128) {
                     var11 = (var10 & 7) << 18 | (var4[var8++] & 63) << 12 | (var4[var8++] & 63) << 6 | var4[var8++] & 63;
                     if(var11 >= 65536 && var11 <= 1114111) {
                        var11 = '\ufffd';
                     } else {
                        var11 = '\ufffd';
                     }
                  } else {
                     var11 = '\ufffd';
                  }
               } else {
                  var11 = '\ufffd';
               }
            }

            String var3 = new String(var6, 0, var7);
            this.offset += var2;
            return var3;
         }
      }
   }

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-84211636"
   )
   public void method5648(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         var1[var4] = this.array[++this.offset - 1];
      }

   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1517353363"
   )
   public int method5656() {
      int var1 = this.array[this.offset] & 255;
      return var1 < 128?this.method5575() - 64:this.method5577() - '\uc000';
   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1283642471"
   )
   public int method5589() {
      int var1 = this.array[this.offset] & 255;
      return var1 < 128?this.method5575():this.method5577() - '\u8000';
   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1839551709"
   )
   public int method5590() {
      int var1 = 0;

      int var2;
      for(var2 = this.method5589(); var2 == 32767; var2 = this.method5589()) {
         var1 += 32767;
      }

      var1 += var2;
      return var1;
   }

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1537726341"
   )
   public int method5779() {
      return this.array[this.offset] < 0?this.method5580() & Integer.MAX_VALUE:this.method5577();
   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "81"
   )
   public int method5592() {
      if(this.array[this.offset] < 0) {
         return this.method5580() & Integer.MAX_VALUE;
      } else {
         int var1 = this.method5577();
         return var1 == 32767?-1:var1;
      }
   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1771949174"
   )
   public int method5599() {
      byte var1 = this.array[++this.offset - 1];

      int var2;
      for(var2 = 0; var1 < 0; var1 = this.array[++this.offset - 1]) {
         var2 = (var2 | var1 & 127) << 7;
      }

      return var2 | var1;
   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "([IS)V",
      garbageValue = "280"
   )
   public void method5564(int[] var1) {
      int var2 = this.offset / 8;
      this.offset = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method5580();
         int var5 = this.method5580();
         int var6 = 0;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var5 += var4 + (var4 << 4 ^ var4 >>> 5) ^ var1[var6 >>> 11 & 3] + var6) {
            var4 += var5 + (var5 << 4 ^ var5 >>> 5) ^ var6 + var1[var6 & 3];
            var6 += var7;
         }

         this.offset -= 8;
         this.method5717(var4);
         this.method5717(var5);
      }

   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "613143765"
   )
   public void method5726(int[] var1) {
      int var2 = this.offset / 8;
      this.offset = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method5580();
         int var5 = this.method5580();
         int var6 = -957401312;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var4 -= var5 + (var5 << 4 ^ var5 >>> 5) ^ var6 + var1[var6 & 3]) {
            var5 -= var4 + (var4 << 4 ^ var4 >>> 5) ^ var1[var6 >>> 11 & 3] + var6;
            var6 -= var7;
         }

         this.offset -= 8;
         this.method5717(var4);
         this.method5717(var5);
      }

   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "([IIIB)V",
      garbageValue = "37"
   )
   public void method5596(int[] var1, int var2, int var3) {
      int var4 = this.offset;
      this.offset = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method5580();
         int var8 = this.method5580();
         int var9 = 0;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var8 += var7 + (var7 << 4 ^ var7 >>> 5) ^ var1[var9 >>> 11 & 3] + var9) {
            var7 += var8 + (var8 << 4 ^ var8 >>> 5) ^ var9 + var1[var9 & 3];
            var9 += var10;
         }

         this.offset -= 8;
         this.method5717(var7);
         this.method5717(var8);
      }

      this.offset = var4;
   }

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "-189170169"
   )
   public void method5755(int[] var1, int var2, int var3) {
      int var4 = this.offset;
      this.offset = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method5580();
         int var8 = this.method5580();
         int var9 = -957401312;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var7 -= var8 + (var8 << 4 ^ var8 >>> 5) ^ var9 + var1[var9 & 3]) {
            var8 -= var7 + (var7 << 4 ^ var7 >>> 5) ^ var1[var9 >>> 11 & 3] + var9;
            var9 -= var10;
         }

         this.offset -= 8;
         this.method5717(var7);
         this.method5717(var8);
      }

      this.offset = var4;
   }

   @ObfuscatedName("cx")
   public void method5598(BigInteger var1, BigInteger var2, int var3) {
      if(Client.modulus != null) {
         var2 = Client.modulus;
      }

      this.copy$encryptRsa(var1, var2, var3);
   }

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-176240895"
   )
   public int method5579(int var1) {
      byte[] var3 = this.array;
      int var4 = this.offset;
      int var5 = -1;

      for(int var6 = var1; var6 < var4; ++var6) {
         var5 = var5 >>> 8 ^ crc32Table[(var5 ^ var3[var6]) & 255];
      }

      var5 = ~var5;
      this.method5717(var5);
      return var5;
   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-284855787"
   )
   public boolean method5572() {
      this.offset -= 4;
      byte[] var2 = this.array;
      int var3 = this.offset;
      int var4 = -1;

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4 = var4 >>> 8 ^ crc32Table[(var4 ^ var2[var5]) & 255];
      }

      var4 = ~var4;
      var5 = this.method5580();
      return var5 == var4;
   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-927080333"
   )
   public void method5728(int var1) {
      this.array[++this.offset - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "51"
   )
   public void method5725(int var1) {
      this.array[++this.offset - 1] = (byte)(0 - var1);
   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "16"
   )
   public void method5603(int var1) {
      this.array[++this.offset - 1] = (byte)(128 - var1);
   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "823972061"
   )
   public int method5604() {
      return this.array[++this.offset - 1] - 128 & 255;
   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "91963828"
   )
   public int method5605() {
      return 0 - this.array[++this.offset - 1] & 255;
   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-576195763"
   )
   public int method5606() {
      return 128 - this.array[++this.offset - 1] & 255;
   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-2046276387"
   )
   public byte method5607() {
      return (byte)(this.array[++this.offset - 1] - 128);
   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-587494464"
   )
   public byte method5608() {
      return (byte)(0 - this.array[++this.offset - 1]);
   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "12345678"
   )
   public byte method5609() {
      return (byte)(128 - this.array[++this.offset - 1]);
   }

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "70039705"
   )
   public void method5610(int var1) {
      this.array[++this.offset - 1] = (byte)var1;
      this.array[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-551480953"
   )
   public void method5611(int var1) {
      this.array[++this.offset - 1] = (byte)(var1 >> 8);
      this.array[++this.offset - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1104378785"
   )
   public void method5612(int var1) {
      this.array[++this.offset - 1] = (byte)(var1 + 128);
      this.array[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "45"
   )
   public int method5565() {
      this.offset += 2;
      return ((this.array[this.offset - 1] & 255) << 8) + (this.array[this.offset - 2] & 255);
   }

   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "127"
   )
   public int method5614() {
      this.offset += 2;
      return (this.array[this.offset - 1] - 128 & 255) + ((this.array[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "438416270"
   )
   public int method5615() {
      this.offset += 2;
      return ((this.array[this.offset - 1] & 255) << 8) + (this.array[this.offset - 2] - 128 & 255);
   }

   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1103250346"
   )
   public int method5744() {
      this.offset += 2;
      int var1 = (this.array[this.offset - 1] - 128 & 255) + ((this.array[this.offset - 2] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "717013158"
   )
   public void method5617(int var1) {
      this.array[++this.offset - 1] = (byte)var1;
      this.array[++this.offset - 1] = (byte)(var1 >> 8);
      this.array[++this.offset - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "42936919"
   )
   public void method5618(int var1) {
      this.array[++this.offset - 1] = (byte)var1;
      this.array[++this.offset - 1] = (byte)(var1 >> 8);
      this.array[++this.offset - 1] = (byte)(var1 >> 16);
      this.array[++this.offset - 1] = (byte)(var1 >> 24);
   }

   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1186318843"
   )
   public void method5619(int var1) {
      this.array[++this.offset - 1] = (byte)(var1 >> 8);
      this.array[++this.offset - 1] = (byte)var1;
      this.array[++this.offset - 1] = (byte)(var1 >> 24);
      this.array[++this.offset - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-598231963"
   )
   public void method5645(int var1) {
      this.array[++this.offset - 1] = (byte)(var1 >> 16);
      this.array[++this.offset - 1] = (byte)(var1 >> 24);
      this.array[++this.offset - 1] = (byte)var1;
      this.array[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "123221290"
   )
   public int method5620() {
      this.offset += 4;
      return (this.array[this.offset - 4] & 255) + ((this.array[this.offset - 3] & 255) << 8) + ((this.array[this.offset - 2] & 255) << 16) + ((this.array[this.offset - 1] & 255) << 24);
   }

   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1049580829"
   )
   public int method5639() {
      this.offset += 4;
      return ((this.array[this.offset - 2] & 255) << 24) + ((this.array[this.offset - 4] & 255) << 8) + (this.array[this.offset - 3] & 255) + ((this.array[this.offset - 1] & 255) << 16);
   }

   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "76"
   )
   public int method5622() {
      this.offset += 4;
      return ((this.array[this.offset - 1] & 255) << 8) + ((this.array[this.offset - 4] & 255) << 16) + (this.array[this.offset - 2] & 255) + ((this.array[this.offset - 3] & 255) << 24);
   }

   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "69"
   )
   public void method5623(byte[] var1, int var2, int var3) {
      for(int var4 = var3 + var2 - 1; var4 >= var2; --var4) {
         var1[var4] = (byte)(this.array[++this.offset - 1] - 128);
      }

   }

   @ObfuscatedName("k")
   public static String method5792(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); 0L != var0; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class298.base37Table[(int)(var6 - 37L * var0)];
               if(var8 == 95) {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(Ljava/net/Socket;IIB)Llt;",
      garbageValue = "88"
   )
   public static AbstractSocket method5795(Socket var0, int var1, int var2) throws IOException {
      return new BufferedNetSocket(var0, var1, var2);
   }
}
