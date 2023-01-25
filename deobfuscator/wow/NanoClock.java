import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSNanoClock;

@ObfuscatedName("fn")
public class NanoClock extends Clock implements RSNanoClock {

   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = 4971967116578097939L
   )
   long lastTimeNano = System.nanoTime();


   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1351231250"
   )
   public void vmethod3592() {
      this.lastTimeNano = System.nanoTime();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1723558008"
   )
   public int vmethod3593(int var1, int var2) {
      long var3 = 1000000L * (long)var2;
      long var5 = this.lastTimeNano - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      class169.method3542(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.lastTimeNano < var7); this.lastTimeNano += 1000000L * (long)var1) {
         ++var9;
      }

      if(this.lastTimeNano < var7) {
         this.lastTimeNano = var7;
      }

      return var9;
   }
}
