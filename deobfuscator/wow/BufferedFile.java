import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSBufferedFile;

@ObfuscatedName("ms")
public class BufferedFile implements RSBufferedFile {

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lmb;"
   )
   AccessFile accessFile;
   @ObfuscatedName("k")
   byte[] readBuffer;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = -6621394340155458391L
   )
   long readBufferOffset = -1L;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -498492055
   )
   int readBufferLength;
   @ObfuscatedName("v")
   byte[] writeBuffer;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = -915874801967299919L
   )
   long writeBufferOffset = -1L;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 730352763
   )
   int writeBufferLength = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = 8841745747932636313L
   )
   long offset;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = -5167130975185536305L
   )
   long fileLength;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = -2996772461190095265L
   )
   long length;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = -2630268660887985841L
   )
   long fileOffset;


   @ObfuscatedSignature(
      signature = "(Lmb;II)V"
   )
   public BufferedFile(AccessFile var1, int var2, int var3) throws IOException {
      this.accessFile = var1;
      this.length = this.fileLength = var1.method6693();
      this.readBuffer = new byte[var2];
      this.writeBuffer = new byte[var3];
      this.offset = 0L;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-859079735"
   )
   public void method6661() throws IOException {
      this.method6669();
      this.accessFile.method6691();
   }

   @ObfuscatedName("m")
   public void method6655(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.offset = var1;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "65"
   )
   public long method6656() {
      return this.length;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1780472721"
   )
   public void method6657(byte[] var1) throws IOException {
      this.method6653(var1, 0, var1.length);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1941673100"
   )
   public void method6653(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(this.writeBufferOffset != -1L && this.offset >= this.writeBufferOffset && this.offset + (long)var3 <= this.writeBufferOffset + (long)this.writeBufferLength) {
            System.arraycopy(this.writeBuffer, (int)(this.offset - this.writeBufferOffset), var1, var2, var3);
            this.offset += (long)var3;
            return;
         }

         long var4 = this.offset;
         int var7 = var3;
         int var8;
         if(this.offset >= this.readBufferOffset && this.offset < this.readBufferOffset + (long)this.readBufferLength) {
            var8 = (int)((long)this.readBufferLength - (this.offset - this.readBufferOffset));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.readBuffer, (int)(this.offset - this.readBufferOffset), var1, var2, var8);
            this.offset += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.readBuffer.length) {
            this.accessFile.method6690(this.offset);

            for(this.fileOffset = this.offset; var3 > 0; var3 -= var8) {
               var8 = this.accessFile.method6705(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.fileOffset += (long)var8;
               this.offset += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method6658();
            var8 = var3;
            if(var3 > this.readBufferLength) {
               var8 = this.readBufferLength;
            }

            System.arraycopy(this.readBuffer, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.offset += (long)var8;
         }

         if(-1L != this.writeBufferOffset) {
            if(this.writeBufferOffset > this.offset && var3 > 0) {
               var8 = var2 + (int)(this.writeBufferOffset - this.offset);
               if(var8 > var3 + var2) {
                  var8 = var3 + var2;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.offset;
               }
            }

            long var13 = -1L;
            long var10 = -1L;
            if(this.writeBufferOffset >= var4 && this.writeBufferOffset < var4 + (long)var7) {
               var13 = this.writeBufferOffset;
            } else if(var4 >= this.writeBufferOffset && var4 < (long)this.writeBufferLength + this.writeBufferOffset) {
               var13 = var4;
            }

            if((long)this.writeBufferLength + this.writeBufferOffset > var4 && this.writeBufferOffset + (long)this.writeBufferLength <= (long)var7 + var4) {
               var10 = this.writeBufferOffset + (long)this.writeBufferLength;
            } else if((long)var7 + var4 > this.writeBufferOffset && var4 + (long)var7 <= (long)this.writeBufferLength + this.writeBufferOffset) {
               var10 = var4 + (long)var7;
            }

            if(var13 > -1L && var10 > var13) {
               int var12 = (int)(var10 - var13);
               System.arraycopy(this.writeBuffer, (int)(var13 - this.writeBufferOffset), var1, (int)(var13 - var4) + var2, var12);
               if(var10 > this.offset) {
                  var3 = (int)((long)var3 - (var10 - this.offset));
                  this.offset = var10;
               }
            }
         }
      } catch (IOException var16) {
         this.fileOffset = -1L;
         throw var16;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2013306645"
   )
   void method6658() throws IOException {
      this.readBufferLength = 0;
      if(this.offset != this.fileOffset) {
         this.accessFile.method6690(this.offset);
         this.fileOffset = this.offset;
      }

      int var2;
      for(this.readBufferOffset = this.offset; this.readBufferLength < this.readBuffer.length; this.readBufferLength += var2) {
         int var1 = this.readBuffer.length - this.readBufferLength;
         if(var1 > 200000000) {
            var1 = 200000000;
         }

         var2 = this.accessFile.method6705(this.readBuffer, this.readBufferLength, var1);
         if(var2 == -1) {
            break;
         }

         this.fileOffset += (long)var2;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-1"
   )
   public void method6676(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(this.offset + (long)var3 > this.length) {
            this.length = this.offset + (long)var3;
         }

         if(this.writeBufferOffset != -1L && (this.offset < this.writeBufferOffset || this.offset > (long)this.writeBufferLength + this.writeBufferOffset)) {
            this.method6669();
         }

         if(this.writeBufferOffset != -1L && (long)var3 + this.offset > this.writeBufferOffset + (long)this.writeBuffer.length) {
            int var4 = (int)((long)this.writeBuffer.length - (this.offset - this.writeBufferOffset));
            System.arraycopy(var1, var2, this.writeBuffer, (int)(this.offset - this.writeBufferOffset), var4);
            this.offset += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.writeBufferLength = this.writeBuffer.length;
            this.method6669();
         }

         if(var3 <= this.writeBuffer.length) {
            if(var3 > 0) {
               if(this.writeBufferOffset == -1L) {
                  this.writeBufferOffset = this.offset;
               }

               System.arraycopy(var1, var2, this.writeBuffer, (int)(this.offset - this.writeBufferOffset), var3);
               this.offset += (long)var3;
               if(this.offset - this.writeBufferOffset > (long)this.writeBufferLength) {
                  this.writeBufferLength = (int)(this.offset - this.writeBufferOffset);
               }

            }
         } else {
            if(this.fileOffset != this.offset) {
               this.accessFile.method6690(this.offset);
               this.fileOffset = this.offset;
            }

            this.accessFile.method6696(var1, var2, var3);
            this.fileOffset += (long)var3;
            if(this.fileOffset > this.fileLength) {
               this.fileLength = this.fileOffset;
            }

            long var9 = -1L;
            long var6 = -1L;
            if(this.offset >= this.readBufferOffset && this.offset < this.readBufferOffset + (long)this.readBufferLength) {
               var9 = this.offset;
            } else if(this.readBufferOffset >= this.offset && this.readBufferOffset < (long)var3 + this.offset) {
               var9 = this.readBufferOffset;
            }

            if(this.offset + (long)var3 > this.readBufferOffset && (long)var3 + this.offset <= this.readBufferOffset + (long)this.readBufferLength) {
               var6 = (long)var3 + this.offset;
            } else if((long)this.readBufferLength + this.readBufferOffset > this.offset && this.readBufferOffset + (long)this.readBufferLength <= (long)var3 + this.offset) {
               var6 = (long)this.readBufferLength + this.readBufferOffset;
            }

            if(var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)((long)var2 + var9 - this.offset), this.readBuffer, (int)(var9 - this.readBufferOffset), var8);
            }

            this.offset += (long)var3;
         }
      } catch (IOException var12) {
         this.fileOffset = -1L;
         throw var12;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-985506123"
   )
   void method6669() throws IOException {
      if(-1L != this.writeBufferOffset) {
         if(this.fileOffset != this.writeBufferOffset) {
            this.accessFile.method6690(this.writeBufferOffset);
            this.fileOffset = this.writeBufferOffset;
         }

         this.accessFile.method6696(this.writeBuffer, 0, this.writeBufferLength);
         this.fileOffset += (long)(this.writeBufferLength * 352301747) * 730352763L;
         if(this.fileOffset > this.fileLength) {
            this.fileLength = this.fileOffset;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.writeBufferOffset >= this.readBufferOffset && this.writeBufferOffset < this.readBufferOffset + (long)this.readBufferLength) {
            var1 = this.writeBufferOffset;
         } else if(this.readBufferOffset >= this.writeBufferOffset && this.readBufferOffset < (long)this.writeBufferLength + this.writeBufferOffset) {
            var1 = this.readBufferOffset;
         }

         if((long)this.writeBufferLength + this.writeBufferOffset > this.readBufferOffset && this.writeBufferOffset + (long)this.writeBufferLength <= this.readBufferOffset + (long)this.readBufferLength) {
            var3 = this.writeBufferOffset + (long)this.writeBufferLength;
         } else if((long)this.readBufferLength + this.readBufferOffset > this.writeBufferOffset && (long)this.readBufferLength + this.readBufferOffset <= (long)this.writeBufferLength + this.writeBufferOffset) {
            var3 = (long)this.readBufferLength + this.readBufferOffset;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.writeBuffer, (int)(var1 - this.writeBufferOffset), this.readBuffer, (int)(var1 - this.readBufferOffset), var5);
         }

         this.writeBufferOffset = -1L;
         this.writeBufferLength = 0;
      }

   }
}
