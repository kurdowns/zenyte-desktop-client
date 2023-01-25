import java.io.IOException;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSBufferedNetSocket;

@ObfuscatedName("lc")
public class BufferedNetSocket extends AbstractSocket implements RSBufferedNetSocket {

   @ObfuscatedName("x")
   Socket socket;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Llm;"
   )
   BufferedSource source;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Llo;"
   )
   BufferedSink sink;


   BufferedNetSocket(Socket var1, int var2, int var3) throws IOException {
      this.socket = var1;
      this.socket.setSoTimeout(30000);
      this.socket.setTcpNoDelay(true);
      this.socket.setReceiveBufferSize(65536);
      this.socket.setSendBufferSize(65536);
      this.source = new BufferedSource(this.socket.getInputStream(), var2);
      this.sink = new BufferedSink(this.socket.getOutputStream(), var3);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "7"
   )
   public void vmethod5894() {
      this.sink.method5920();

      try {
         this.socket.close();
      } catch (IOException var2) {
         ;
      }

      this.source.method5953();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1436175029"
   )
   public int vmethod5891() throws IOException {
      return this.source.method5944();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "195119972"
   )
   public int vmethod5890() throws IOException {
      return this.source.method5943();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "0"
   )
   public boolean vmethod5889(int var1) throws IOException {
      return this.source.method5942(var1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BIIB)I",
      garbageValue = "33"
   )
   public int vmethod5892(byte[] var1, int var2, int var3) throws IOException {
      return this.source.method5946(var1, var2, var3);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "236801869"
   )
   public void vmethod5909(byte[] var1, int var2, int var3) throws IOException {
      this.sink.method5913(var1, var2, var3);
   }

   protected void finalize() {
      this.vmethod5894();
   }
}
