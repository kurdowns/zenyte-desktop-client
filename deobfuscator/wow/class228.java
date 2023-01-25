import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
public class class228 {

   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   static Archive archive8;


   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)Lik;",
      garbageValue = "2"
   )
   public static VarpDefinition method4204(int var0) {
      VarpDefinition var1 = (VarpDefinition)VarpDefinition.VarpDefinition_cached.method3432((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = VarpDefinition.VarpDefinition_archive.method4249(16, var0, (byte)-70);
         var1 = new VarpDefinition();
         if(var2 != null) {
            var1.method4452(new Buffer(var2));
         }

         VarpDefinition.VarpDefinition_cached.method3438(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lmx;I)I",
      garbageValue = "-1599704151"
   )
   public static final int method4206(LoginType var0) {
      if(var0 == null) {
         return 12;
      } else {
         switch(var0.field4058) {
         case 7:
            return 20;
         default:
            return 12;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILlq;Lih;I)V",
      garbageValue = "-70206811"
   )
   static void method4205(int var0, ArchiveDisk var1, Archive var2) {
      ArchiveDiskAction var3 = new ArchiveDiskAction();
      var3.type = 1;
      var3.key = (long)var0;
      var3.archiveDisk = var1;
      var3.archive = var2;
      NodeDeque var4 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue;
      synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
         ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.method4977(var3);
      }

      Object var9 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock;
      synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
         if(ArchiveDiskActionHandler.field3151 == 0) {
            class197.ArchiveDiskActionHandler_thread = new Thread(new ArchiveDiskActionHandler());
            class197.ArchiveDiskActionHandler_thread.setDaemon(true);
            class197.ArchiveDiskActionHandler_thread.start();
            class197.ArchiveDiskActionHandler_thread.setPriority(5);
         }

         ArchiveDiskActionHandler.field3151 = 600;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Liy;II)Z",
      garbageValue = "-2041528291"
   )
   static boolean method4203(AbstractArchive var0, int var1) {
      byte[] var2 = var0.method4256(var1);
      if(var2 == null) {
         return false;
      } else {
         MusicPatch.method3982(var2);
         return true;
      }
   }
}
