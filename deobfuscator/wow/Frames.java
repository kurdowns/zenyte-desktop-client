import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSAnimation;
import net.runelite.rs.api.RSFrames;

@ObfuscatedName("ef")
public class Frames extends DualNode implements RSFrames {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "[Leh;"
   )
   Animation[] frames;


   @ObfuscatedSignature(
      signature = "(Liy;Liy;IZ)V",
      garbageValue = "0"
   )
   public Frames(AbstractArchive var1, AbstractArchive var2, int var3, boolean var4) {
      NodeDeque var5 = new NodeDeque();
      int var6 = var1.method4271(var3);
      this.frames = new Animation[var6];
      int[] var7 = var1.method4259(var3);
      int var8 = 0;

      while(var8 < var7.length) {
         byte[] var9 = var1.method4249(var3, var7[var8], (byte)-98);
         Skeleton var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;
         Skeleton var12 = (Skeleton)var5.method4956();

         while(true) {
            if(var12 != null) {
               if(var11 != var12.id) {
                  var12 = (Skeleton)var5.method4974();
                  continue;
               }

               var10 = var12;
            }

            if(var10 == null) {
               byte[] var13 = var2.method4257(var11, 0);
               var10 = new Skeleton(var11, var13);
               var5.method4977(var10);
            }

            this.frames[var7[var8]] = new Animation(var9, var10);
            ++var8;
            break;
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "861900150"
   )
   public boolean method3382(int var1) {
      return this.frames[var1].hasAlphaTransform;
   }

   public RSAnimation[] getFrames() {
      return this.frames;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lih;IIIBZI)V",
      garbageValue = "-626508532"
   )
   static void method3385(Archive var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      NetFileRequest var8 = (NetFileRequest)NetCache.NetCache_pendingPriorityWrites.method6046(var6);
      if(var8 == null) {
         var8 = (NetFileRequest)NetCache.NetCache_pendingPriorityResponses.method6046(var6);
         if(var8 == null) {
            var8 = (NetFileRequest)NetCache.NetCache_pendingWrites.method6046(var6);
            if(var8 != null) {
               if(var5) {
                  var8.method3672();
                  NetCache.NetCache_pendingPriorityWrites.method6033(var8, var6);
                  --NetCache.NetCache_pendingWritesCount;
                  ++NetCache.NetCache_pendingPriorityWritesCount;
               }

            } else {
               if(!var5) {
                  var8 = (NetFileRequest)NetCache.NetCache_pendingResponses.method6046(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new NetFileRequest();
               var8.archive = var0;
               var8.crc = var3;
               var8.padding = var4;
               if(var5) {
                  NetCache.NetCache_pendingPriorityWrites.method6033(var8, var6);
                  ++NetCache.NetCache_pendingPriorityWritesCount;
               } else {
                  NetCache.NetCache_pendingWritesQueue.method4875(var8);
                  NetCache.NetCache_pendingWrites.method6033(var8, var6);
                  ++NetCache.NetCache_pendingWritesCount;
               }

            }
         }
      }
   }
}
