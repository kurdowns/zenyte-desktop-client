import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSPlayerType;

@ObfuscatedName("iz")
public class PlayerType implements Enumerated, RSPlayerType {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   static final PlayerType PlayerType_normal = new PlayerType(0, -1, true, false, true);
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   static final PlayerType PlayerType_playerModerator = new PlayerType(1, 0, true, true, true);
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   static final PlayerType PlayerType_jagexModerator = new PlayerType(2, 1, true, true, false);
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   static final PlayerType PlayerType_ironman = new PlayerType(3, 2, false, false, true);
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   static final PlayerType PlayerType_ultimateIronman = new PlayerType(4, 3, false, false, true);
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   static final PlayerType PlayerType_hardcoreIronman = new PlayerType(5, 10, false, false, true);
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 188785687
   )
   final int id;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -25874505
   )
   public final int modIcon;
   @ObfuscatedName("t")
   public final boolean isPrivileged;
   @ObfuscatedName("e")
   public final boolean isUser;


   PlayerType(int var1, int var2, boolean var3, boolean var4, boolean var5) {
      this.id = var1;
      this.modIcon = var2;
      this.isPrivileged = var4;
      this.isUser = var5;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "56"
   )
   public int vmethod6189() {
      return this.id;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILce;ZI)I",
      garbageValue = "-512423566"
   )
   static int method4234(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = MusicPatchNode.method3920(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
      } else {
         var3 = var2?GrandExchangeOfferNameComparator.field115:Interpreter.field1130;
      }

      if(var0 == 1927) {
         if(Interpreter.field1127 >= 10) {
            throw new RuntimeException();
         } else if(var3.onResize == null) {
            return 0;
         } else {
            ScriptEvent var4 = new ScriptEvent();
            var4.widget = var3;
            var4.args = var3.onResize;
            var4.field604 = Interpreter.field1127 + 1;
            Client.scriptEvents.method4977(var4);
            return 1;
         }
      } else {
         return 2;
      }
   }
}
