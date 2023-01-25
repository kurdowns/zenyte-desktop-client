import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSInterpreter;

@ObfuscatedName("cu")
public class Interpreter implements RSInterpreter {

   @ObfuscatedName("d")
   static String[] Interpreter_stringLocals;
   @ObfuscatedName("w")
   static int[] Interpreter_arrayLengths = new int[5];
   @ObfuscatedName("v")
   static int[][] Interpreter_arrays = new int[5][5000];
   @ObfuscatedName("q")
   static int[] Interpreter_intStack = new int[1000];
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1080849523
   )
   static int Interpreter_intStackSize;
   @ObfuscatedName("t")
   static String[] Interpreter_stringStack = new String[1000];
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 691433523
   )
   static int Interpreter_stringStackSize;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1685756683
   )
   static int Interpreter_frameDepth = 0;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "[Lbv;"
   )
   static ScriptFrame[] Interpreter_frames = new ScriptFrame[50];
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   static Widget field1130;
   @ObfuscatedName("h")
   static java.util.Calendar Interpreter_calendar = java.util.Calendar.getInstance();
   @ObfuscatedName("g")
   static final String[] Interpreter_MONTHS = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("a")
   static boolean field1125 = false;
   @ObfuscatedName("b")
   static boolean field1126 = false;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2091837547
   )
   static int field1127 = 0;
   @ObfuscatedName("j")
   static final double field1128 = Math.log(2.0D);


   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1189048729"
   )
   static void method2112() {
      Messages.Messages_channels.clear();
      Messages.Messages_hashTable.method5999();
      Messages.Messages_queue.method5035();
      Messages.Messages_count = 0;
   }

   @ObfuscatedName("kj")
   @ObfuscatedSignature(
      signature = "([BII)V",
      garbageValue = "632066186"
   )
   static void method2113(byte[] var0, int var1) {
      if(Client.randomDatData == null) {
         Client.randomDatData = new byte[24];
      }

      class310.method5813(var0, var1, Client.randomDatData, 0, 24);
   }
}
