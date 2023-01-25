import java.io.IOException;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSGrandExchangeOfferUnitPriceComparator;

@ObfuscatedName("l")
final class GrandExchangeOfferUnitPriceComparator implements Comparator, RSGrandExchangeOfferUnitPriceComparator {

   @ObfuscatedName("s")
   public static boolean musicTrackBoolean;


   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Li;Li;B)I",
      garbageValue = "-48"
   )
   int method219(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.grandExchangeOffer.unitPrice < var2.grandExchangeOffer.unitPrice?-1:(var2.grandExchangeOffer.unitPrice == var1.grandExchangeOffer.unitPrice?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method219((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Ljv;",
      garbageValue = "-1592336859"
   )
   public static HitSplatDefinition method213(int var0) {
      HitSplatDefinition var1 = (HitSplatDefinition)HitSplatDefinition.HitSplatDefinition_cached.method3432((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = HitSplatDefinition.HitSplatDefinition_archive.method4249(32, var0, (byte)-31);
         var1 = new HitSplatDefinition();
         if(var2 != null) {
            var1.method4627(new Buffer(var2));
         }

         HitSplatDefinition.HitSplatDefinition_cached.method3438(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Llt;ZB)V",
      garbageValue = "1"
   )
   public static void method222(AbstractSocket var0, boolean var1) {
      if(NetCache.NetCache_socket != null) {
         try {
            NetCache.NetCache_socket.vmethod5894();
         } catch (Exception var8) {
            ;
         }

         NetCache.NetCache_socket = null;
      }

      NetCache.NetCache_socket = var0;
      Buffer var2;
      if(NetCache.NetCache_socket != null) {
         try {
            var2 = new Buffer(4);
            var2.method5559(var1?2:3);
            var2.method5616(0);
            NetCache.NetCache_socket.vmethod5909(var2.array, 0, 4);
         } catch (IOException var7) {
            try {
               NetCache.NetCache_socket.vmethod5894();
            } catch (Exception var6) {
               ;
            }

            ++NetCache.NetCache_ioExceptions;
            NetCache.NetCache_socket = null;
         }
      }

      NetCache.NetCache_responseHeaderBuffer.offset = 0;
      NetCache.NetCache_currentResponse = null;
      NetCache.NetCache_responseArchiveBuffer = null;
      NetCache.field3178 = 0;

      while(true) {
         NetFileRequest var9 = (NetFileRequest)NetCache.NetCache_pendingPriorityResponses.method6031();
         if(var9 == null) {
            while(true) {
               var9 = (NetFileRequest)NetCache.NetCache_pendingResponses.method6031();
               if(var9 == null) {
                  if(NetCache.field3163 != 0) {
                     try {
                        var2 = new Buffer(4);
                        var2.method5559(4);
                        var2.method5559(NetCache.field3163);
                        var2.method5560(0);
                        NetCache.NetCache_socket.vmethod5909(var2.array, 0, 4);
                     } catch (IOException var5) {
                        try {
                           NetCache.NetCache_socket.vmethod5894();
                        } catch (Exception var4) {
                           ;
                        }

                        ++NetCache.NetCache_ioExceptions;
                        NetCache.NetCache_socket = null;
                     }
                  }

                  NetCache.NetCache_loadTime = 0;
                  NetCache.field3165 = class217.method4036();
                  return;
               }

               NetCache.NetCache_pendingWritesQueue.method4876(var9);
               NetCache.NetCache_pendingWrites.method6033(var9, var9.key);
               ++NetCache.NetCache_pendingWritesCount;
               --NetCache.NetCache_pendingResponsesCount;
            }
         }

         NetCache.NetCache_pendingPriorityWrites.method6033(var9, var9.key);
         ++NetCache.NetCache_pendingPriorityWritesCount;
         --NetCache.NetCache_pendingPriorityResponsesCount;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)Lhe;",
      garbageValue = "166208311"
   )
   public static Widget method224(int var0, int var1) {
      Widget var2 = MusicPatchNode.method3920(var0);
      return var1 == -1?var2:(var2 != null && var2.children != null && var1 < var2.children.length?var2.children[var1]:null);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1968739504"
   )
   public static boolean method218(int var0) {
      return (var0 >> 20 & 1) != 0;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "([BII)I",
      garbageValue = "-1953007669"
   )
   public static int method225(byte[] var0, int var1) {
      int var3 = -1;

      for(int var4 = 0; var4 < var1; ++var4) {
         var3 = var3 >>> 8 ^ Buffer.crc32Table[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }
}
