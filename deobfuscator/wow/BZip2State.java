import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.rs.api.RSBZip2State;

@ObfuscatedName("lk")
public final class BZip2State implements RSBZip2State {

   @ObfuscatedName("x")
   final int field3756 = 4096;
   @ObfuscatedName("m")
   final int field3725 = 16;
   @ObfuscatedName("k")
   final int field3726 = 258;
   @ObfuscatedName("d")
   final int field3729 = 6;
   @ObfuscatedName("w")
   final int field3750 = 50;
   @ObfuscatedName("v")
   final int field3737 = 18002;
   @ObfuscatedName("q")
   byte[] inputArray;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1520658841
   )
   int nextByte = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1705468259
   )
   int nextBit_unused;
   @ObfuscatedName("e")
   byte[] outputArray;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -530026491
   )
   int next_out = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1793031375
   )
   int outputLength;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 828020907
   )
   int field3724;
   @ObfuscatedName("u")
   byte out_char;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1550283393
   )
   int su_rNToGo;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2097262377
   )
   int bsBuff;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1241583147
   )
   int bsLive;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2129927168
   )
   int blockSize100k;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1768899761
   )
   int originalPointer;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -2111080359
   )
   int field3743;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -125465233
   )
   int su_ch2;
   @ObfuscatedName("o")
   int[] unzftab = new int[256];
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1422716731
   )
   int nblocks_used;
   @ObfuscatedName("j")
   int[] cftab = new int[257];
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1484476187
   )
   int nInUse;
   @ObfuscatedName("ae")
   boolean[] inUse = new boolean[256];
   @ObfuscatedName("an")
   boolean[] inUse16 = new boolean[16];
   @ObfuscatedName("ai")
   byte[] seqToUnseq = new byte[256];
   @ObfuscatedName("ap")
   byte[] ll8 = new byte[4096];
   @ObfuscatedName("ab")
   int[] getAndMoveToFrontDecode_yy = new int[16];
   @ObfuscatedName("ar")
   byte[] selector = new byte[18002];
   @ObfuscatedName("af")
   byte[] selectorMtf = new byte[18002];
   @ObfuscatedName("at")
   byte[][] temp_charArray2d = new byte[6][258];
   @ObfuscatedName("al")
   int[][] limit = new int[6][258];
   @ObfuscatedName("as")
   int[][] base = new int[6][258];
   @ObfuscatedName("am")
   int[][] perm = new int[6][258];
   @ObfuscatedName("au")
   int[] minLens = new int[6];
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -453266259
   )
   int field3761;


}
