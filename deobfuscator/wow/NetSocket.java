import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSNetSocket;

@ObfuscatedName("fa")
public final class NetSocket extends AbstractSocket implements Runnable, RSNetSocket {

   @ObfuscatedName("x")
   InputStream inputStream;
   @ObfuscatedName("m")
   OutputStream outputStream;
   @ObfuscatedName("k")
   Socket socket;
   @ObfuscatedName("d")
   boolean isClosed = false;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lfs;"
   )
   TaskHandler taskHandler;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   Task task;
   @ObfuscatedName("q")
   byte[] outBuffer;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -883377573
   )
   int outLength = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1663813013
   )
   int outOffset = 0;
   @ObfuscatedName("e")
   boolean exceptionWriting = false;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -667900149
   )
   final int bufferLength;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1103298859
   )
   final int maxPacketLength;


   @ObfuscatedSignature(
      signature = "(Ljava/net/Socket;Lfs;I)V"
   )
   public NetSocket(Socket var1, TaskHandler var2, int var3) throws IOException {
      this.taskHandler = var2;
      this.socket = var1;
      this.bufferLength = var3;
      this.maxPacketLength = var3 - 100;
      this.socket.setSoTimeout(30000);
      this.socket.setTcpNoDelay(true);
      this.socket.setReceiveBufferSize(65536);
      this.socket.setSendBufferSize(65536);
      this.inputStream = this.socket.getInputStream();
      this.outputStream = this.socket.getOutputStream();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "7"
   )
   public void vmethod5894() {
      if(!this.isClosed) {
         synchronized(this) {
            this.isClosed = true;
            this.notifyAll();
         }

         if(this.task != null) {
            while(this.task.status == 0) {
               class169.method3542(1L);
            }

            if(this.task.status == 1) {
               try {
                  ((Thread)this.task.result).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.task = null;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1436175029"
   )
   public int vmethod5891() throws IOException {
      return this.isClosed?0:this.inputStream.read();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "195119972"
   )
   public int vmethod5890() throws IOException {
      return this.isClosed?0:this.inputStream.available();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "0"
   )
   public boolean vmethod5889(int var1) throws IOException {
      return this.isClosed?false:this.inputStream.available() >= var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BIIB)I",
      garbageValue = "33"
   )
   public int vmethod5892(byte[] var1, int var2, int var3) throws IOException {
      if(this.isClosed) {
         return 0;
      } else {
         int var4;
         int var5;
         for(var4 = var3; var3 > 0; var3 -= var5) {
            var5 = this.inputStream.read(var1, var2, var3);
            if(var5 <= 0) {
               throw new EOFException();
            }

            var2 += var5;
         }

         return var4;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-21"
   )
   void method3608(byte[] var1, int var2, int var3) throws IOException {
      if(!this.isClosed) {
         if(this.exceptionWriting) {
            this.exceptionWriting = false;
            throw new IOException();
         } else {
            if(this.outBuffer == null) {
               this.outBuffer = new byte[this.bufferLength];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.outBuffer[this.outOffset] = var1[var5 + var2];
                  this.outOffset = (this.outOffset + 1) % this.bufferLength;
                  if((this.outLength + this.maxPacketLength) % this.bufferLength == this.outOffset) {
                     throw new IOException();
                  }
               }

               if(this.task == null) {
                  this.task = this.taskHandler.method3566(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "236801869"
   )
   public void vmethod5909(byte[] var1, int var2, int var3) throws IOException {
      this.method3608(var1, var2, var3);
   }

   protected void finalize() {
      this.vmethod5894();
   }

   public void run() {
      while(true) {
         try {
            label83: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.outOffset == this.outLength) {
                     if(this.isClosed) {
                        break label83;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.outLength;
                  if(this.outOffset >= this.outLength) {
                     var1 = this.outOffset - this.outLength;
                  } else {
                     var1 = this.bufferLength - this.outLength;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.outputStream.write(this.outBuffer, var2, var1);
               } catch (IOException var9) {
                  this.exceptionWriting = true;
               }

               this.outLength = (var1 + this.outLength) % this.bufferLength;

               try {
                  if(this.outOffset == this.outLength) {
                     this.outputStream.flush();
                  }
               } catch (IOException var8) {
                  this.exceptionWriting = true;
               }
               continue;
            }

            try {
               if(this.inputStream != null) {
                  this.inputStream.close();
               }

               if(this.outputStream != null) {
                  this.outputStream.close();
               }

               if(this.socket != null) {
                  this.socket.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.outBuffer = null;
         } catch (Exception var12) {
            WorldMapDecorationType.method4214((String)null, var12);
         }

         return;
      }
   }
}
