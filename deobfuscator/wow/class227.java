import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
public class class227 {

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lfs;"
   )
   protected static TaskHandler taskHandler;


   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-673521466"
   )
   public static int method4201(int var0) {
      return var0 > 0?1:(var0 < 0?-1:0);
   }

   @ObfuscatedName("jd")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1891530232"
   )
   static final void method4185() {
      PacketBufferNode var0 = FaceNormal.method3377(ClientPacket.field2245, Client.packetWriter.isaacCipher);
      Client.packetWriter.method2375(var0);

      for(InterfaceParent var1 = (InterfaceParent)Client.interfaceParents.method6031(); var1 != null; var1 = (InterfaceParent)Client.interfaceParents.method6039()) {
         if(var1.type == 0 || var1.type == 3) {
            class41.method653(var1, true);
         }
      }

      if(Client.meslayerContinueWidget != null) {
         ItemContainer.method1273(Client.meslayerContinueWidget);
         Client.meslayerContinueWidget = null;
      }

   }
}
