import javax.imageio.ImageIO;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
public class class58 {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   public static AbstractArchive musicPatchesArchive;
   @ObfuscatedName("dw")
   @ObfuscatedGetter(
      longValue = 3841945927555236577L
   )
   static long field455;


   static {
      ImageIO.setUseCache(false);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2115896796"
   )
   public static int method963(int var0, int var1) {
      return (var0 + '\u9c40' << 8) + var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)Lji;",
      garbageValue = "-86"
   )
   public static EnumDefinition method967(int var0) {
      EnumDefinition var1 = (EnumDefinition)EnumDefinition.EnumDefinition_cached.method3432((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = EnumDefinition.EnumDefinition_archive.method4249(8, var0, (byte)-68);
         var1 = new EnumDefinition();
         if(var2 != null) {
            var1.method4612(new Buffer(var2));
         }

         EnumDefinition.EnumDefinition_cached.method3438(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-91"
   )
   static int method965(int var0) {
      Message var1 = (Message)Messages.Messages_hashTable.method6003((long)var0);
      return var1 == null?-1:(var1.nextDual == Messages.Messages_queue.sentinel?-1:((Message)var1.nextDual).count);
   }

   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "70910120"
   )
   static void method968(int var0, int var1) {
      PacketBufferNode var2 = FaceNormal.method3377(ClientPacket.field2291, Client.packetWriter.isaacCipher);
      var2.packetBuffer.method5619(var0);
      var2.packetBuffer.method5610(var1);
      Client.packetWriter.method2375(var2);
   }

   @ObfuscatedName("ja")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "36"
   )
   static void method966() {
      for(InterfaceParent var0 = (InterfaceParent)Client.interfaceParents.method6031(); var0 != null; var0 = (InterfaceParent)Client.interfaceParents.method6039()) {
         int var1 = var0.group;
         if(LoginScreenAnimation.method1914(var1)) {
            boolean var2 = true;
            Widget[] var3 = Widget.Widget_interfaceComponents[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].isIf3;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.key;
               Widget var5 = MusicPatchNode.method3920(var4);
               if(var5 != null) {
                  ItemContainer.method1273(var5);
               }
            }
         }
      }

   }
}
