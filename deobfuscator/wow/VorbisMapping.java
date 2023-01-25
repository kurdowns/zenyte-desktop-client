import net.runelite.mapping.ObfuscatedName;
import net.runelite.rs.api.RSVorbisMapping;

@ObfuscatedName("dt")
public class VorbisMapping implements RSVorbisMapping {

   @ObfuscatedName("x")
   int submaps;
   @ObfuscatedName("m")
   int mappingMux;
   @ObfuscatedName("k")
   int[] submapFloor;
   @ObfuscatedName("d")
   int[] submapResidue;


   VorbisMapping() {
      VorbisSample.method2476(16);
      this.submaps = VorbisSample.method2500() != 0?VorbisSample.method2476(4) + 1:1;
      if(VorbisSample.method2500() != 0) {
         VorbisSample.method2476(8);
      }

      VorbisSample.method2476(2);
      if(this.submaps > 1) {
         this.mappingMux = VorbisSample.method2476(4);
      }

      this.submapFloor = new int[this.submaps];
      this.submapResidue = new int[this.submaps];

      for(int var1 = 0; var1 < this.submaps; ++var1) {
         VorbisSample.method2476(8);
         this.submapFloor[var1] = VorbisSample.method2476(8);
         this.submapResidue[var1] = VorbisSample.method2476(8);
      }

   }
}
