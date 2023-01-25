import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.events.ScriptPreFired;
import net.runelite.api.kit.KitType;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSPlayerAppearance;

@ObfuscatedName("hk")
public class PlayerAppearance implements RSPlayerAppearance {

   @ObfuscatedName("t")
   public static short[] field2539;
   @ObfuscatedName("e")
   public static short[][] field2535;
   @ObfuscatedName("s")
   static final int[] equipmentIndices = new int[]{8, 11, 4, 6, 9, 7, 10};
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Leg;"
   )
   static EvictingDualNodeHashTable PlayerAppearance_cachedModels = new EvictingDualNodeHashTable(260);
   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   static Archive archive10;
   @ObfuscatedName("x")
   int[] equipment;
   @ObfuscatedName("m")
   int[] bodyColors;
   @ObfuscatedName("k")
   public boolean isFemale;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1293293343
   )
   public int npcTransformId;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = 3080768602890783779L
   )
   long hash;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = 1388997665214268647L
   )
   long field2538;


   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "522059742"
   )
   public void method4105(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.KitDefinition_fileCount; ++var6) {
               KitDefinition var7 = WorldMapElement.method4486(var6);
               if(var7 != null && !var7.nonSelectable && var7.bodypartID == (var3?7:0) + var5) {
                  var1[equipmentIndices[var5]] = var6 + 256;
                  break;
               }
            }
         }
      }

      this.equipment = var1;
      this.bodyColors = var2;
      this.isFemale = var3;
      this.npcTransformId = var4;
      this.method4093();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "1928193476"
   )
   public void method4089(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipment[equipmentIndices[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = KitDefinition.KitDefinition_fileCount - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= KitDefinition.KitDefinition_fileCount) {
                     var3 = 0;
                  }
               }

               var4 = WorldMapElement.method4486(var3);
            } while(var4 == null || var4.nonSelectable || var1 + (this.isFemale?7:0) != var4.bodypartID);

            this.equipment[equipmentIndices[var1]] = var3 + 256;
            this.method4093();
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-1053799565"
   )
   public void method4090(int var1, boolean var2) {
      int var3 = this.bodyColors[var1];
      boolean var4;
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = VertexNormal.field1764[var1].length - 1;
            }

            if(var1 == 4 && var3 >= 8) {
               var4 = false;
            } else {
               var4 = true;
            }
         } while(!var4);
      } else {
         do {
            ++var3;
            if(var3 >= VertexNormal.field1764[var1].length) {
               var3 = 0;
            }

            if(var1 == 4 && var3 >= 8) {
               var4 = false;
            } else {
               var4 = true;
            }
         } while(!var4);
      }

      this.bodyColors[var1] = var3;
      this.method4093();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1082412676"
   )
   public void method4091(boolean var1) {
      if(this.isFemale != var1) {
         this.method4105((int[])null, this.bodyColors, var1, -1);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lkb;I)V",
      garbageValue = "-1419902667"
   )
   public void method4092(Buffer var1) {
      var1.method5559(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipment[equipmentIndices[var2]];
         if(var3 == 0) {
            var1.method5559(-1);
         } else {
            var1.method5559(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.method5559(this.bodyColors[var2]);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "110"
   )
   void method4093() {
      long var1 = this.hash;
      int var3 = this.equipment[5];
      int var4 = this.equipment[9];
      this.equipment[5] = var4;
      this.equipment[9] = var3;
      this.hash = 0L;

      int var5;
      for(var5 = 0; var5 < 12; ++var5) {
         this.hash <<= 4;
         if(this.equipment[var5] >= 256) {
            this.hash += (long)(this.equipment[var5] - 256);
         }
      }

      if(this.equipment[0] >= 256) {
         this.hash += (long)(this.equipment[0] - 256 >> 4);
      }

      if(this.equipment[1] >= 256) {
         this.hash += (long)(this.equipment[1] - 256 >> 8);
      }

      for(var5 = 0; var5 < 5; ++var5) {
         this.hash <<= 3;
         this.hash += (long)this.bodyColors[var5];
      }

      this.hash <<= 1;
      this.hash += (long)(this.isFemale?1:0);
      this.equipment[5] = var3;
      this.equipment[9] = var4;
      if(var1 != 0L && this.hash != var1) {
         PlayerAppearance_cachedModels.method3425(var1);
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljc;ILjc;II)Lel;",
      garbageValue = "-1571730911"
   )
   public Model method4094(SequenceDefinition var1, int var2, SequenceDefinition var3, int var4) {
      if(this.npcTransformId != -1) {
         return class237.method4226(this.npcTransformId).method4789(var1, var2, var3, var4);
      } else {
         long var5 = this.hash;
         int[] var7 = this.equipment;
         if(var1 != null && (var1.shield >= 0 || var1.weapon >= 0)) {
            var7 = new int[12];

            for(int var15 = 0; var15 < 12; ++var15) {
               var7[var15] = this.equipment[var15];
            }

            if(var1.shield >= 0) {
               var5 += (long)(var1.shield - this.equipment[5] << 40);
               var7[5] = var1.shield;
            }

            if(var1.weapon >= 0) {
               var5 += (long)(var1.weapon - this.equipment[3] << 48);
               var7[3] = var1.weapon;
            }
         }

         Model var8 = (Model)PlayerAppearance_cachedModels.method3432(var5);
         if(var8 == null) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !WorldMapElement.method4486(var11 - 256).method4522()) {
                  var9 = true;
               }

               if(var11 >= 512 && !AbstractWorldMapData.method373(var11 - 512).method4722(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(this.field2538 != -1L) {
                  var8 = (Model)PlayerAppearance_cachedModels.method3432(this.field2538);
               }

               if(var8 == null) {
                  return null;
               }
            }

            if(var8 == null) {
               ModelData[] var16 = new ModelData[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = var7[var12];
                  ModelData var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = WorldMapElement.method4486(var13 - 256).method4523();
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = AbstractWorldMapData.method373(var13 - 512).method4723(this.isFemale);
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }
               }

               ModelData var17 = new ModelData(var16, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyColors[var13] < VertexNormal.field1764[var13].length) {
                     var17.method2893(WorldMapLabel.field278[var13], VertexNormal.field1764[var13][this.bodyColors[var13]]);
                  }

                  if(this.bodyColors[var13] < field2535[var13].length) {
                     var17.method2893(field2539[var13], field2535[var13][this.bodyColors[var13]]);
                  }
               }

               var8 = var17.method2900(64, 850, -30, -50, -30);
               PlayerAppearance_cachedModels.method3438(var8, var5);
               this.field2538 = var5;
            }
         }

         if(var1 == null && var3 == null) {
            return var8;
         } else {
            Model var18;
            if(var1 != null && var3 != null) {
               var18 = var1.method4848(var8, var2, var3, var4, (byte)1);
            } else if(var1 != null) {
               var18 = var1.method4845(var8, var2, 1747843246);
            } else {
               var18 = var3.method4845(var8, var4, 1747843246);
            }

            return var18;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(S)Lea;",
      garbageValue = "180"
   )
   ModelData method4095() {
      if(this.npcTransformId != -1) {
         return class237.method4226(this.npcTransformId).method4785();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipment[var2];
            if(var3 >= 256 && var3 < 512 && !WorldMapElement.method4486(var3 - 256).method4524()) {
               var1 = true;
            }

            if(var3 >= 512 && !AbstractWorldMapData.method373(var3 - 512).method4773(this.isFemale)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            ModelData[] var7 = new ModelData[12];
            var3 = 0;

            int var5;
            for(int var4 = 0; var4 < 12; ++var4) {
               var5 = this.equipment[var4];
               ModelData var6;
               if(var5 >= 256 && var5 < 512) {
                  var6 = WorldMapElement.method4486(var5 - 256).method4525();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = AbstractWorldMapData.method373(var5 - 512).method4725(this.isFemale);
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }
            }

            ModelData var8 = new ModelData(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyColors[var5] < VertexNormal.field1764[var5].length) {
                  var8.method2893(WorldMapLabel.field278[var5], VertexNormal.field1764[var5][this.bodyColors[var5]]);
               }

               if(this.bodyColors[var5] < field2535[var5].length) {
                  var8.method2893(field2539[var5], field2535[var5][this.bodyColors[var5]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2000496598"
   )
   public int method4096() {
      return this.npcTransformId == -1?(this.equipment[0] << 15) + this.equipment[1] + (this.equipment[11] << 5) + (this.equipment[8] << 10) + (this.bodyColors[0] << 25) + (this.bodyColors[4] << 20):305419896 + class237.method4226(this.npcTransformId).id;
   }

   public int[] getEquipmentIds() {
      return this.equipment;
   }

   public int getEquipmentId(KitType var1) {
      int var2 = this.getEquipmentIds()[var1.getIndex()];
      return var2 < 512?-1:var2 - 512;
   }

   public int getKitId(KitType var1) {
      int var2 = this.getEquipmentIds()[var1.getIndex()];
      return var2 >= 256 && var2 < 512?var2 - 256:-1;
   }

   public int[] getBodyPartColours() {
      return this.bodyColors;
   }

   public boolean isFemale() {
      return this.isFemale;
   }

   public void setTransformedNpcId(int var1) {
      this.npcTransformId = var1;
   }

   public long getHash() {
      return this.hash;
   }

   public void setHash() {
      this.method4093();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lbb;II)V"
   )
   static void method4124(ScriptEvent var0, int var1, int var2) {
      Object[] var3 = var0.getArguments();
      ScriptPreFired var4;
      if(var3 != null && var3.length > 0 && var3[0] instanceof JavaScriptCallback) {
         try {
            var4 = new ScriptPreFired(-1);
            var4.setScriptEvent(var0);
            WorldMapSection1.client.getCallbacks().post(ScriptPreFired.class, var4);
            ((JavaScriptCallback)var3[0]).run(var0);
            ScriptPostFired var5 = new ScriptPostFired(-1);
            WorldMapSection1.client.getCallbacks().post(ScriptPostFired.class, var5);
         } catch (Exception var11) {
            WorldMapSection1.client.getLogger().error("Error in JavaScriptCallback", var11);
         }
      } else {
         try {
            try {
               Client.scriptIds.push((Integer)var0.getArguments()[0]);
               var4 = new ScriptPreFired(((Integer)Client.scriptIds.peek()).intValue());
               var4.setScriptEvent(var0);
               WorldMapSection1.client.getCallbacks().post(ScriptPreFired.class, var4);
            } catch (ClassCastException var10) {
               ;
            }

            Client.copy$runScript(var0, var1, var2);
            if(!Client.scriptIds.empty()) {
               ScriptPostFired var13 = new ScriptPostFired(((Integer)Client.scriptIds.pop()).intValue());
               if(!Client.$assertionsDisabled && !Client.scriptIds.empty()) {
                  throw new AssertionError("Script ID stack should be empty! Contains: " + Client.getAllScriptIds());
               }

               WorldMapSection1.client.getCallbacks().post(ScriptPostFired.class, var13);
            }
         } finally {
            Client.currentScript = null;

            while(!Client.scriptIds.empty()) {
               Client.scriptIds.pop();
            }

         }
      }

   }

   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-167013262"
   )
   static void method4123(int var0) {
      if(var0 == -3) {
         HealthBarUpdate.method1866("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         HealthBarUpdate.method1866("Error connecting to server.", "Please try using a different world.", "");
      } else if(var0 == -1) {
         HealthBarUpdate.method1866("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         Login.loginIndex = 3;
         Login.field1218 = 1;
      } else if(var0 == 4) {
         class39.method645(0);
      } else if(var0 == 5) {
         Login.field1218 = 2;
         HealthBarUpdate.method1866("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
      } else if(var0 != 68 && (Client.onMobile || var0 != 6)) {
         if(var0 == 7) {
            HealthBarUpdate.method1866("This world is full.", "Please use a different world.", "");
         } else if(var0 == 8) {
            HealthBarUpdate.method1866("Unable to connect.", "Login server offline.", "");
         } else if(var0 == 9) {
            HealthBarUpdate.method1866("Login limit exceeded.", "Too many connections from your address.", "");
         } else if(var0 == 10) {
            HealthBarUpdate.method1866("Unable to connect.", "Bad session id.", "");
         } else if(var0 == 11) {
            HealthBarUpdate.method1866("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
         } else if(var0 == 12) {
            HealthBarUpdate.method1866("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
         } else if(var0 == 13) {
            HealthBarUpdate.method1866("Could not complete login.", "Please try using a different world.", "");
         } else if(var0 == 14) {
            HealthBarUpdate.method1866("The server is being updated.", "Please wait 1 minute and try again.", "");
         } else if(var0 == 16) {
            HealthBarUpdate.method1866("Too many login attempts.", "Please wait a few minutes before trying again.", "");
         } else if(var0 == 17) {
            HealthBarUpdate.method1866("You are standing in a members-only area.", "To play on this world move to a free area first", "");
         } else if(var0 == 18) {
            class39.method645(1);
         } else if(var0 == 19) {
            HealthBarUpdate.method1866("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
         } else if(var0 == 20) {
            HealthBarUpdate.method1866("Invalid loginserver requested.", "Please try using a different world.", "");
         } else if(var0 == 22) {
            HealthBarUpdate.method1866("Malformed login packet.", "Please try again.", "");
         } else if(var0 == 23) {
            HealthBarUpdate.method1866("No reply from loginserver.", "Please wait 1 minute and try again.", "");
         } else if(var0 == 24) {
            HealthBarUpdate.method1866("Error loading your profile.", "Please contact customer support.", "");
         } else if(var0 == 25) {
            HealthBarUpdate.method1866("Unexpected loginserver response.", "Please try using a different world.", "");
         } else if(var0 == 26) {
            HealthBarUpdate.method1866("This computers address has been blocked", "as it was used to break our rules.", "");
         } else if(var0 == 27) {
            HealthBarUpdate.method1866("", "Service unavailable.", "");
         } else if(var0 == 31) {
            HealthBarUpdate.method1866("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
         } else if(var0 == 32) {
            HealthBarUpdate.method1866("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
         } else if(var0 == 37) {
            HealthBarUpdate.method1866("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
         } else if(var0 == 38) {
            HealthBarUpdate.method1866("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
         } else if(var0 == 55) {
            Login.loginIndex = 8;
         } else {
            if(var0 == 56) {
               HealthBarUpdate.method1866("Enter the 6-digit code generated by your", "authenticator app.", "");
               MouseRecorder.method1293(11);
               return;
            }

            if(var0 == 57) {
               HealthBarUpdate.method1866("The code you entered was incorrect.", "Please try again.", "");
               MouseRecorder.method1293(11);
               return;
            }

            if(var0 == 61) {
               Login.loginIndex = 7;
            } else {
               HealthBarUpdate.method1866("Unexpected server response", "Please try using a different world.", "");
            }
         }
      } else {
         HealthBarUpdate.method1866("RuneScape has been updated!", "Please reload this page.", "");
      }

      MouseRecorder.method1293(10);
   }

   @ObfuscatedName("kk")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1233914639"
   )
   static final void method4088(String var0) {
      if(InterfaceParent.clanChat != null) {
         PacketBufferNode var1 = FaceNormal.method3377(ClientPacket.field2217, Client.packetWriter.isaacCipher);
         var1.packetBuffer.method5559(class234.method4223(var0));
         var1.packetBuffer.method5655(var0);
         Client.packetWriter.method2375(var1);
      }
   }
}
