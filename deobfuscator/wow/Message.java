import net.runelite.api.ChatMessageType;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSClanChat;
import net.runelite.rs.api.RSMessage;
import net.runelite.rs.api.RSUsername;

@ObfuscatedName("by")
public class Message extends DualNode implements RSMessage {

   @ObfuscatedName("at")
   static String field633;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 659624387
   )
   int count;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1682037485
   )
   int cycle;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1650269491
   )
   int type;
   @ObfuscatedName("d")
   String sender;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lku;"
   )
   Username senderUsername;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lkv;"
   )
   TriBool isFromFriend0;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lkv;"
   )
   TriBool isFromIgnored0;
   @ObfuscatedName("z")
   String prefix;
   @ObfuscatedName("t")
   String text;
   public String runeLiteFormatMessage;
   public int rl$timestamp;


   Message(int var1, String var2, String var3, String var4) {
      this.isFromFriend0 = TriBool.TriBool_unknown;
      this.isFromIgnored0 = TriBool.TriBool_unknown;
      this.method1295(var1, var2, var3, var4);
      this.rl$$init();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1398956437"
   )
   void method1295(int var1, String var2, String var3, String var4) {
      this.count = Player.method1342();
      this.cycle = Client.cycle;
      this.type = var1;
      this.sender = var2;
      this.method1302();
      this.prefix = var3;
      this.text = var4;
      this.method1311();
      this.method1299();
      this.setMessage(var1, var2, var3, var4);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1417196149"
   )
   void method1311() {
      this.isFromFriend0 = TriBool.TriBool_unknown;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "1"
   )
   final boolean method1316() {
      if(this.isFromFriend0 == TriBool.TriBool_unknown) {
         this.method1298();
      }

      return this.isFromFriend0 == TriBool.TriBool_true;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1598313930"
   )
   void method1298() {
      this.isFromFriend0 = Projectile.friendSystem.friendsList.method5142(this.senderUsername)?TriBool.TriBool_true:TriBool.TriBool_false;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-42"
   )
   void method1299() {
      this.isFromIgnored0 = TriBool.TriBool_unknown;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-9"
   )
   final boolean method1308() {
      if(this.isFromIgnored0 == TriBool.TriBool_unknown) {
         this.method1296();
      }

      return this.isFromIgnored0 == TriBool.TriBool_true;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-929873231"
   )
   void method1296() {
      this.isFromIgnored0 = Projectile.friendSystem.ignoreList.method5142(this.senderUsername)?TriBool.TriBool_true:TriBool.TriBool_false;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2096124823"
   )
   final void method1302() {
      if(this.sender != null) {
         this.senderUsername = new Username(Occluder.method3400(this.sender), WorldMapIcon_0.loginType);
      } else {
         this.senderUsername = null;
      }

   }

   public int getRSType() {
      return this.type;
   }

   public RSUsername getSenderUsername() {
      return this.senderUsername;
   }

   private void rl$$init() {
      this.rl$timestamp = (int)(System.currentTimeMillis() / 1000L);
   }

   public void setMessage(int var1, String var2, String var3, String var4) {
      this.runeLiteFormatMessage = null;
      this.rl$timestamp = (int)(System.currentTimeMillis() / 1000L);
   }

   public ChatMessageType getType() {
      return ChatMessageType.of(this.getRSType());
   }

   public String getRuneLiteFormatMessage() {
      return this.runeLiteFormatMessage;
   }

   public void setRuneLiteFormatMessage(String var1) {
      this.runeLiteFormatMessage = var1;
   }

   public int getTimestamp() {
      return this.rl$timestamp;
   }

   public void setTimestamp(int var1) {
      this.rl$timestamp = var1;
   }

   public boolean isFromClanMate() {
      RSClanChat var1 = WorldMapSection1.client.getClanMemberManager();
      return var1 != null && var1.findByName(this.getSenderUsername()) != null;
   }

   public int getId() {
      return this.count;
   }

   public String getName() {
      return this.sender;
   }

   public void setName(String var1) {
      this.sender = var1;
   }

   public String getSender() {
      return this.prefix;
   }

   public void setSender(String var1) {
      this.prefix = var1;
   }

   public String getValue() {
      return this.text;
   }

   public void setValue(String var1) {
      this.text = var1;
   }

   public boolean isFromFriend() {
      return this.method1316();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Liy;Liy;I)V",
      garbageValue = "1388306890"
   )
   public static void method1319(AbstractArchive var0, AbstractArchive var1) {
      KitDefinition.KitDefinition_archive = var0;
      KitDefinition.KitDefinition_modelsArchive = var1;
      KitDefinition.KitDefinition_fileCount = KitDefinition.KitDefinition_archive.method4271(3);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "2024763142"
   )
   static void method1300(int var0, int var1, int var2, int var3) {
      for(ObjectSound var4 = (ObjectSound)ObjectSound.objectSounds.method4956(); var4 != null; var4 = (ObjectSound)ObjectSound.objectSounds.method4974()) {
         if(var4.soundEffectId != -1 || var4.soundEffectIds != null) {
            int var5 = 0;
            if(var1 > var4.field1110 * 16384) {
               var5 += var1 - var4.field1110 * 16384;
            } else if(var1 < var4.x * 128) {
               var5 += var4.x * 128 - var1;
            }

            if(var2 > var4.field1100 * 128) {
               var5 += var2 - var4.field1100 * 128;
            } else if(var2 < var4.y * 16384) {
               var5 += var4.y * 16384 - var2;
            }

            if(var5 - 64 <= var4.field1106 && Client.areaSoundEffectVolume != 0 && var0 == var4.plane) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               int var6 = (var4.field1106 - var5) * Client.areaSoundEffectVolume / var4.field1106;
               if(var4.stream1 == null) {
                  if(var4.soundEffectId >= 0) {
                     SoundEffect var7 = SoundEffect.method2469(FontName.archive4, var4.soundEffectId, 0);
                     if(var7 != null) {
                        RawSound var8 = var7.method2466().method2508(class25.decimator);
                        RawPcmStream var9 = RawPcmStream.method2654(var8, 100, var6);
                        var9.method2689(-1);
                        Tiles.pcmStreamMixer.method2399(var9);
                        var4.stream1 = var9;
                     }
                  }
               } else {
                  var4.stream1.method2659(var6);
               }

               if(var4.stream2 == null) {
                  if(var4.soundEffectIds != null && (var4.field1107 -= var3) <= 0) {
                     int var11 = (int)(Math.random() * (double)var4.soundEffectIds.length);
                     SoundEffect var12 = SoundEffect.method2469(FontName.archive4, var4.soundEffectIds[var11], 0);
                     if(var12 != null) {
                        RawSound var13 = var12.method2466().method2508(class25.decimator);
                        RawPcmStream var10 = RawPcmStream.method2654(var13, 100, var6);
                        var10.method2689(0);
                        Tiles.pcmStreamMixer.method2399(var10);
                        var4.stream2 = var10;
                        var4.field1107 = var4.field1104 + (int)(Math.random() * (double)(var4.field1105 - var4.field1104));
                     }
                  }
               } else {
                  var4.stream2.method2659(var6);
                  if(!var4.stream2.method3677()) {
                     var4.stream2 = null;
                  }
               }
            } else {
               if(var4.stream1 != null) {
                  Tiles.pcmStreamMixer.method2400(var4.stream1);
                  var4.stream1 = null;
               }

               if(var4.stream2 != null) {
                  Tiles.pcmStreamMixer.method2400(var4.stream2);
                  var4.stream2 = null;
               }
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILce;ZI)I",
      garbageValue = "1301536744"
   )
   static int method1318(int var0, Script var1, boolean var2) {
      Widget var3 = MusicPatchNode.method3920(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
      if(var0 == 2800) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = WorldMapRectangle.method388(ScriptEvent.method1283(var3));
         return 1;
      } else if(var0 != 2801) {
         if(var0 == 2802) {
            if(var3.dataText == null) {
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
            } else {
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.dataText;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         --var4;
         if(var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
            Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.actions[var4];
         } else {
            Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
         }

         return 1;
      }
   }
}
