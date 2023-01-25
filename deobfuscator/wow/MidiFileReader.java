import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSMidiFileReader;

@ObfuscatedName("hc")
public class MidiFileReader implements RSMidiFileReader {

   @ObfuscatedName("e")
   static final byte[] field2478 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   Buffer buffer = new Buffer((byte[])null);
   @ObfuscatedName("m")
   int division;
   @ObfuscatedName("k")
   int[] trackStarts;
   @ObfuscatedName("d")
   int[] trackPositions;
   @ObfuscatedName("w")
   int[] trackLengths;
   @ObfuscatedName("v")
   int[] field2474;
   @ObfuscatedName("q")
   int field2471;
   @ObfuscatedName("t")
   long field2477;


   MidiFileReader(byte[] var1) {
      this.method3937(var1);
   }

   MidiFileReader() {}

   @ObfuscatedName("x")
   void method3937(byte[] var1) {
      this.buffer.array = var1;
      this.buffer.offset = 10;
      int var2 = this.buffer.method5577();
      this.division = this.buffer.method5577();
      this.field2471 = 500000;
      this.trackStarts = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.buffer.offset += var5) {
         int var4 = this.buffer.method5580();
         var5 = this.buffer.method5580();
         if(var4 == 1297379947) {
            this.trackStarts[var3] = this.buffer.offset;
            ++var3;
         }
      }

      this.field2477 = 0L;
      this.trackPositions = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.trackPositions[var3] = this.trackStarts[var3];
      }

      this.trackLengths = new int[var2];
      this.field2474 = new int[var2];
   }

   @ObfuscatedName("m")
   void method3942() {
      this.buffer.array = null;
      this.trackStarts = null;
      this.trackPositions = null;
      this.trackLengths = null;
      this.field2474 = null;
   }

   @ObfuscatedName("k")
   boolean method3927() {
      return this.buffer.array != null;
   }

   @ObfuscatedName("d")
   int method3928() {
      return this.trackPositions.length;
   }

   @ObfuscatedName("w")
   void method3929(int var1) {
      this.buffer.offset = this.trackPositions[var1];
   }

   @ObfuscatedName("v")
   void method3966(int var1) {
      this.trackPositions[var1] = this.buffer.offset;
   }

   @ObfuscatedName("q")
   void method3931() {
      this.buffer.offset = -1;
   }

   @ObfuscatedName("z")
   void method3932(int var1) {
      int var2 = this.buffer.method5599();
      this.trackLengths[var1] += var2;
   }

   @ObfuscatedName("t")
   int method3933(int var1) {
      int var2 = this.method3930(var1);
      return var2;
   }

   @ObfuscatedName("e")
   int method3930(int var1) {
      byte var2 = this.buffer.array[this.buffer.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2474[var1] = var5;
         ++this.buffer.offset;
      } else {
         var5 = this.field2474[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method3935(var1, var5);
      } else {
         int var3 = this.buffer.method5599();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.buffer.array[this.buffer.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.buffer.offset;
               this.field2474[var1] = var4;
               return this.method3935(var1, var4);
            }
         }

         this.buffer.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("s")
   int method3935(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.buffer.method5575();
         var4 = this.buffer.method5599();
         if(var7 == 47) {
            this.buffer.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.buffer.method5702();
            var4 -= 3;
            int var6 = this.trackLengths[var1];
            this.field2477 += (long)var6 * (long)(this.field2471 - var5);
            this.field2471 = var5;
            this.buffer.offset += var4;
            return 2;
         } else {
            this.buffer.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field2478[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.buffer.method5575() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.buffer.method5575() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("p")
   long method3936(int var1) {
      return this.field2477 + (long)var1 * (long)this.field2471;
   }

   @ObfuscatedName("n")
   int method3924() {
      int var1 = this.trackPositions.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.trackPositions[var4] >= 0 && this.trackLengths[var4] < var3) {
            var2 = var4;
            var3 = this.trackLengths[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("u")
   boolean method3938() {
      int var1 = this.trackPositions.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.trackPositions[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("h")
   void method3939(long var1) {
      this.field2477 = var1;
      int var3 = this.trackPositions.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.trackLengths[var4] = 0;
         this.field2474[var4] = 0;
         this.buffer.offset = this.trackStarts[var4];
         this.method3932(var4);
         this.trackPositions[var4] = this.buffer.offset;
      }

   }
}
