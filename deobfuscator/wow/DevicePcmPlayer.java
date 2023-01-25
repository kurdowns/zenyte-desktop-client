import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSDevicePcmPlayer;

@ObfuscatedName("bg")
public class DevicePcmPlayer extends PcmPlayer implements RSDevicePcmPlayer {

   @ObfuscatedName("x")
   AudioFormat format;
   @ObfuscatedName("m")
   SourceDataLine line;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1537774017
   )
   int capacity2;
   @ObfuscatedName("d")
   byte[] byteSamples;


   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-515177845"
   )
   protected void vmethod2543() {
      this.format = new AudioFormat((float)PcmPlayer.field1421, 16, PcmPlayer.PcmPlayer_stereo?2:1, true, false);
      this.byteSamples = new byte[256 << (PcmPlayer.PcmPlayer_stereo?2:1)];
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1831392073"
   )
   protected void vmethod2544(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.format, var1 << (PcmPlayer.PcmPlayer_stereo?2:1));
         this.line = (SourceDataLine)AudioSystem.getLine(var2);
         this.line.open();
         this.line.start();
         this.capacity2 = var1;
      } catch (LineUnavailableException var3) {
         if(Clock.method3591(var1) != 1) {
            this.vmethod2544(Calendar.method4034(var1));
         } else {
            this.line = null;
            throw var3;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1722515255"
   )
   protected int vmethod2545() {
      return this.capacity2 - (this.line.available() >> (PcmPlayer.PcmPlayer_stereo?2:1));
   }

   @ObfuscatedName("d")
   protected void vmethod2557() {
      int var1 = 256;
      if(PcmPlayer.PcmPlayer_stereo) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.samples[var2];
         if((var3 + 8388608 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.byteSamples[var2 * 2] = (byte)(var3 >> 8);
         this.byteSamples[var2 * 2 + 1] = (byte)(var3 >> 16);
      }

      this.line.write(this.byteSamples, 0, var1 << 1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-100"
   )
   protected void vmethod2572() {
      if(this.line != null) {
         this.line.close();
         this.line = null;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-801705902"
   )
   protected void vmethod2548() {
      this.line.flush();
   }
}
