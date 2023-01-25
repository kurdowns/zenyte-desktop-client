import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSArchiveDiskActionHandler;

@ObfuscatedName("ip")
public class ArchiveDiskActionHandler implements Runnable, RSArchiveDiskActionHandler {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   public static NodeDeque ArchiveDiskActionHandler_requestQueue = new NodeDeque();
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   public static NodeDeque ArchiveDiskActionHandler_responseQueue = new NodeDeque();
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -191724831
   )
   public static int field3151 = 0;
   @ObfuscatedName("d")
   public static Object ArchiveDiskActionHandler_lock = new Object();


   public void run() {
      try {
         while(true) {
            NodeDeque var2 = ArchiveDiskActionHandler_requestQueue;
            ArchiveDiskAction var1;
            synchronized(ArchiveDiskActionHandler_requestQueue) {
               var1 = (ArchiveDiskAction)ArchiveDiskActionHandler_requestQueue.method4956();
            }

            Object var14;
            if(var1 != null) {
               if(var1.type == 0) {
                  var1.archiveDisk.method5929((int)var1.key, var1.data, var1.data.length);
                  var2 = ArchiveDiskActionHandler_requestQueue;
                  synchronized(ArchiveDiskActionHandler_requestQueue) {
                     var1.method3676();
                  }
               } else if(var1.type == 1) {
                  var1.data = var1.archiveDisk.method5930((int)var1.key);
                  var2 = ArchiveDiskActionHandler_requestQueue;
                  synchronized(ArchiveDiskActionHandler_requestQueue) {
                     ArchiveDiskActionHandler_responseQueue.method4977(var1);
                  }
               }

               var14 = ArchiveDiskActionHandler_lock;
               synchronized(ArchiveDiskActionHandler_lock) {
                  if(field3151 <= 1) {
                     field3151 = 0;
                     ArchiveDiskActionHandler_lock.notifyAll();
                     return;
                  }

                  field3151 = 600;
               }
            } else {
               class169.method3542(100L);
               var14 = ArchiveDiskActionHandler_lock;
               synchronized(ArchiveDiskActionHandler_lock) {
                  if(field3151 <= 1) {
                     field3151 = 0;
                     ArchiveDiskActionHandler_lock.notifyAll();
                     return;
                  }

                  --field3151;
               }
            }
         }
      } catch (Exception var13) {
         WorldMapDecorationType.method4214((String)null, var13);
      }
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-492522565"
   )
   public static int method4341(String var0) {
      return var0.length() + 2;
   }
}
