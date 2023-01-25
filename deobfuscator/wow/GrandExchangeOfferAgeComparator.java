import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSGrandExchangeOfferAgeComparator;

@ObfuscatedName("o")
final class GrandExchangeOfferAgeComparator implements Comparator, RSGrandExchangeOfferAgeComparator {

   @ObfuscatedName("sg")
   @ObfuscatedSignature(
      signature = "Lml;"
   )
   static WorldMap worldMap;
   @ObfuscatedName("e")
   static int[] Tiles_hue;
   @ObfuscatedName("ee")
   @ObfuscatedGetter(
      intValue = 1640375913
   )
   static int port2;


   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Li;Li;I)I",
      garbageValue = "-720251669"
   )
   int method240(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.age < var2.age?-1:(var2.age == var1.age?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method240((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lbr;I)V",
      garbageValue = "1934352071"
   )
   static void method241(GameShell var0) {
      int var4;
      if(Login.worldSelectOpen) {
         while(true) {
            if(!class22.method255()) {
               if(MouseHandler.MouseHandler_lastButton != 1 && (class217.mouseCam || MouseHandler.MouseHandler_lastButton != 4)) {
                  break;
               }

               int var1 = Login.xPadding + 280;
               if(MouseHandler.MouseHandler_lastPressedX >= var1 && MouseHandler.MouseHandler_lastPressedX <= var1 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                  WorldMapSectionType.method346(0, 0);
                  break;
               }

               if(MouseHandler.MouseHandler_lastPressedX >= var1 + 15 && MouseHandler.MouseHandler_lastPressedX <= var1 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                  WorldMapSectionType.method346(0, 1);
                  break;
               }

               int var2 = Login.xPadding + 390;
               if(MouseHandler.MouseHandler_lastPressedX >= var2 && MouseHandler.MouseHandler_lastPressedX <= var2 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                  WorldMapSectionType.method346(1, 0);
                  break;
               }

               if(MouseHandler.MouseHandler_lastPressedX >= var2 + 15 && MouseHandler.MouseHandler_lastPressedX <= var2 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                  WorldMapSectionType.method346(1, 1);
                  break;
               }

               int var32 = Login.xPadding + 500;
               if(MouseHandler.MouseHandler_lastPressedX >= var32 && MouseHandler.MouseHandler_lastPressedX <= var32 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                  WorldMapSectionType.method346(2, 0);
                  break;
               }

               if(MouseHandler.MouseHandler_lastPressedX >= var32 + 15 && MouseHandler.MouseHandler_lastPressedX <= var32 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                  WorldMapSectionType.method346(2, 1);
                  break;
               }

               var4 = Login.xPadding + 610;
               if(MouseHandler.MouseHandler_lastPressedX >= var4 && MouseHandler.MouseHandler_lastPressedX <= var4 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                  WorldMapSectionType.method346(3, 0);
                  break;
               }

               if(MouseHandler.MouseHandler_lastPressedX >= var4 + 15 && MouseHandler.MouseHandler_lastPressedX <= var4 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                  WorldMapSectionType.method346(3, 1);
                  break;
               }

               if(MouseHandler.MouseHandler_lastPressedX >= Login.xPadding + 708 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedX <= Login.xPadding + 708 + 50 && MouseHandler.MouseHandler_lastPressedY <= 20) {
                  Login.worldSelectOpen = false;
                  Login.leftTitleSprite.method6225(Login.xPadding, 0);
                  DirectByteArrayCopier.rightTitleSprite.method6225(Login.xPadding + 382, 0);
                  class3.logoSprite.method6213(Login.xPadding + 382 - class3.logoSprite.subWidth / 2, 18);
                  break;
               }

               if(Login.hoveredWorldIndex != -1) {
                  World var5 = UserComparator2.World_worlds[Login.hoveredWorldIndex];
                  UserComparator3.method3526(var5);
                  Login.worldSelectOpen = false;
                  Login.leftTitleSprite.method6225(Login.xPadding, 0);
                  DirectByteArrayCopier.rightTitleSprite.method6225(Login.xPadding + 382, 0);
                  class3.logoSprite.method6213(Login.xPadding + 382 - class3.logoSprite.subWidth / 2, 18);
               } else {
                  if(Login.worldSelectPage > 0 && class92.worldSelectLeftSprite != null && MouseHandler.MouseHandler_lastPressedX >= 0 && MouseHandler.MouseHandler_lastPressedX <= class92.worldSelectLeftSprite.subWidth && MouseHandler.MouseHandler_lastPressedY >= Varps.canvasHeight / 2 - 50 && MouseHandler.MouseHandler_lastPressedY <= Varps.canvasHeight / 2 + 50) {
                     --Login.worldSelectPage;
                  }

                  if(Login.worldSelectPage < Login.worldSelectPagesCount && StructDefinition.worldSelectRightSprite != null && MouseHandler.MouseHandler_lastPressedX >= WorldMapLabel.canvasWidth - StructDefinition.worldSelectRightSprite.subWidth - 5 && MouseHandler.MouseHandler_lastPressedX <= WorldMapLabel.canvasWidth && MouseHandler.MouseHandler_lastPressedY >= Varps.canvasHeight / 2 - 50 && MouseHandler.MouseHandler_lastPressedY <= Varps.canvasHeight / 2 + 50) {
                     ++Login.worldSelectPage;
                  }
               }
               break;
            }

            if(class3.field16 == 13) {
               HealthBar.method2124();
               break;
            }

            if(class3.field16 == 96) {
               if(Login.worldSelectPage > 0 && class92.worldSelectLeftSprite != null) {
                  --Login.worldSelectPage;
               }
            } else if(class3.field16 == 97 && Login.worldSelectPage < Login.worldSelectPagesCount && StructDefinition.worldSelectRightSprite != null) {
               ++Login.worldSelectPage;
            }
         }

      } else {
         if((MouseHandler.MouseHandler_lastButton == 1 || !class217.mouseCam && MouseHandler.MouseHandler_lastButton == 4) && MouseHandler.MouseHandler_lastPressedX >= Login.xPadding + 765 - 50 && MouseHandler.MouseHandler_lastPressedY >= 453) {
            GrandExchangeOfferOwnWorldComparator.clientPreferences.titleMusicDisabled = !GrandExchangeOfferOwnWorldComparator.clientPreferences.titleMusicDisabled;
            WorldMapArea.method509();
            if(!GrandExchangeOfferOwnWorldComparator.clientPreferences.titleMusicDisabled) {
               class105.method2394(AbstractWorldMapIcon.archive6, "scape main", "", 255, false);
            } else {
               Client.method1496();
            }
         }

         if(Client.gameState != 5) {
            if(Login.field1223 == -1L) {
               Login.field1223 = class217.method4036() + 1000L;
            }

            long var21 = class217.method4036();
            boolean var3;
            if(Client.archiveLoaders != null && Client.archiveLoadersDone < Client.archiveLoaders.size()) {
               while(true) {
                  if(Client.archiveLoadersDone >= Client.archiveLoaders.size()) {
                     var3 = true;
                     break;
                  }

                  ArchiveLoader var23 = (ArchiveLoader)Client.archiveLoaders.get(Client.archiveLoadersDone);
                  if(!var23.method1253()) {
                     var3 = false;
                     break;
                  }

                  ++Client.archiveLoadersDone;
               }
            } else {
               var3 = true;
            }

            if(var3 && -1L == Login.field1224) {
               Login.field1224 = var21;
               if(Login.field1224 > Login.field1223) {
                  Login.field1223 = Login.field1224;
               }
            }

            if(Client.gameState == 10 || Client.gameState == 11) {
               if(IgnoreList.clientLanguage == Language.Language_EN) {
                  if(MouseHandler.MouseHandler_lastButton == 1 || !class217.mouseCam && MouseHandler.MouseHandler_lastButton == 4) {
                     var4 = Login.xPadding + 5;
                     short var24 = 463;
                     byte var6 = 100;
                     byte var7 = 35;
                     if(MouseHandler.MouseHandler_lastPressedX >= var4 && MouseHandler.MouseHandler_lastPressedX <= var6 + var4 && MouseHandler.MouseHandler_lastPressedY >= var24 && MouseHandler.MouseHandler_lastPressedY <= var7 + var24) {
                        if(Language.method3751()) {
                           Login.worldSelectOpen = true;
                           Login.worldSelectPage = 0;
                           Login.worldSelectPagesCount = 0;
                        }

                        return;
                     }
                  }

                  if(LoginPacket.World_request != null && Language.method3751()) {
                     Login.worldSelectOpen = true;
                     Login.worldSelectPage = 0;
                     Login.worldSelectPagesCount = 0;
                  }
               }

               var4 = MouseHandler.MouseHandler_lastButton;
               int var46 = MouseHandler.MouseHandler_lastPressedX;
               int var33 = MouseHandler.MouseHandler_lastPressedY;
               if(var4 == 0) {
                  var46 = MouseHandler.MouseHandler_x;
                  var33 = MouseHandler.MouseHandler_y;
               }

               if(!class217.mouseCam && var4 == 4) {
                  var4 = 1;
               }

               int var8;
               short var9;
               if(Login.loginIndex == 0) {
                  boolean var34 = false;

                  while(class22.method255()) {
                     if(class3.field16 == 84) {
                        var34 = true;
                     }
                  }

                  var8 = PacketWriter.loginBoxCenter - 80;
                  var9 = 291;
                  if(var4 == 1 && var46 >= var8 - 75 && var46 <= var8 + 75 && var33 >= var9 - 20 && var33 <= var9 + 20) {
                     Script.method2336(class41.method654("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var8 = PacketWriter.loginBoxCenter + 80;
                  if(var4 == 1 && var46 >= var8 - 75 && var46 <= var8 + 75 && var33 >= var9 - 20 && var33 <= var9 + 20 || var34) {
                     if((Client.worldProperties & 33554432) != 0) {
                        Login.Login_response0 = "";
                        Login.Login_response1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        Login.Login_response2 = "Your normal account will not be affected.";
                        Login.Login_response3 = "";
                        Login.loginIndex = 1;
                        FontName.method5389();
                     } else if((Client.worldProperties & 4) != 0) {
                        if((Client.worldProperties & 1024) != 0) {
                           Login.Login_response1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           Login.Login_response2 = "Players can attack each other almost everywhere";
                           Login.Login_response3 = "and the Protect Item prayer won\'t work.";
                        } else {
                           Login.Login_response1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           Login.Login_response2 = "Players can attack each other";
                           Login.Login_response3 = "almost everywhere.";
                        }

                        Login.Login_response0 = "Warning!";
                        Login.loginIndex = 1;
                        FontName.method5389();
                     } else if((Client.worldProperties & 1024) != 0) {
                        Login.Login_response1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        Login.Login_response2 = "The Protect Item prayer will";
                        Login.Login_response3 = "not work on this world.";
                        Login.Login_response0 = "Warning!";
                        Login.loginIndex = 1;
                        FontName.method5389();
                     } else {
                        ObjectDefinition.method4712(false);
                     }
                  }
               } else {
                  int var35;
                  short var37;
                  if(Login.loginIndex == 1) {
                     while(class22.method255()) {
                        if(class3.field16 == 84) {
                           ObjectDefinition.method4712(false);
                        } else if(class3.field16 == 13) {
                           Login.loginIndex = 0;
                        }
                     }

                     var35 = PacketWriter.loginBoxCenter - 80;
                     var37 = 321;
                     if(var4 == 1 && var46 >= var35 - 75 && var46 <= var35 + 75 && var33 >= var37 - 20 && var33 <= var37 + 20) {
                        ObjectDefinition.method4712(false);
                     }

                     var35 = PacketWriter.loginBoxCenter + 80;
                     if(var4 == 1 && var46 >= var35 - 75 && var46 <= var35 + 75 && var33 >= var37 - 20 && var33 <= var37 + 20) {
                        Login.loginIndex = 0;
                     }
                  } else {
                     boolean var10;
                     short var36;
                     int var40;
                     if(Login.loginIndex == 2) {
                        var36 = 201;
                        var35 = var36 + 52;
                        if(var4 == 1 && var33 >= var35 - 12 && var33 < var35 + 2) {
                           Login.currentLoginField = 0;
                        }

                        var35 += 15;
                        if(var4 == 1 && var33 >= var35 - 12 && var33 < var35 + 2) {
                           Login.currentLoginField = 1;
                        }

                        var35 += 15;
                        var36 = 361;
                        if(class41.field315 != null) {
                           var8 = class41.field315.highX / 2;
                           if(var4 == 1 && var46 >= class41.field315.lowX - var8 && var46 <= var8 + class41.field315.lowX && var33 >= var36 - 15 && var33 < var36) {
                              switch(Login.field1218) {
                              case 1:
                                 HealthBarUpdate.method1866("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                                 Login.loginIndex = 5;
                                 return;
                              case 2:
                                 Script.method2336("https://support.runescape.com/hc/en-gb", true, false);
                              }
                           }
                        }

                        var8 = PacketWriter.loginBoxCenter - 80;
                        var9 = 321;
                        if(var4 == 1 && var46 >= var8 - 75 && var46 <= var8 + 75 && var33 >= var9 - 20 && var33 <= var9 + 20) {
                           Login.Login_username = Login.Login_username.trim();
                           Client.onUsernameChanged(-1);
                           if(Login.Login_username.length() == 0) {
                              HealthBarUpdate.method1866("", "Please enter your username/email address.", "");
                              return;
                           }

                           if(Login.Login_password.length() == 0) {
                              HealthBarUpdate.method1866("", "Please enter your password.", "");
                              return;
                           }

                           HealthBarUpdate.method1866("", "Connecting to server...", "");
                           GraphicsObject.method2122(false);
                           MouseRecorder.method1293(20);
                           return;
                        }

                        var8 = Login.loginBoxX + 180 + 80;
                        if(var4 == 1 && var46 >= var8 - 75 && var46 <= var8 + 75 && var33 >= var9 - 20 && var33 <= var9 + 20) {
                           Login.loginIndex = 0;
                           Login.Login_username = "";
                           Client.onUsernameChanged(-1);
                           Login.Login_password = "";
                           GraphicsObject.field1141 = 0;
                           MilliClock.otp = "";
                           Login.field1214 = true;
                        }

                        var8 = PacketWriter.loginBoxCenter + -117;
                        var9 = 277;
                        Login.field1207 = var46 >= var8 && var46 < var8 + WorldMapLabelSize.field158 && var33 >= var9 && var33 < var9 + class219.field2515;
                        if(var4 == 1 && Login.field1207) {
                           Client.Login_isUsernameRemembered = !Client.Login_isUsernameRemembered;
                           if(!Client.Login_isUsernameRemembered && GrandExchangeOfferOwnWorldComparator.clientPreferences.rememberedUsername != null) {
                              GrandExchangeOfferOwnWorldComparator.clientPreferences.rememberedUsername = null;
                              WorldMapArea.method509();
                           }
                        }

                        var8 = PacketWriter.loginBoxCenter + 24;
                        var9 = 277;
                        Login.field1212 = var46 >= var8 && var46 < var8 + WorldMapLabelSize.field158 && var33 >= var9 && var33 < var9 + class219.field2515;
                        if(var4 == 1 && Login.field1212) {
                           GrandExchangeOfferOwnWorldComparator.clientPreferences.hideUsername = !GrandExchangeOfferOwnWorldComparator.clientPreferences.hideUsername;
                           if(!GrandExchangeOfferOwnWorldComparator.clientPreferences.hideUsername) {
                              Login.Login_username = "";
                              Client.onUsernameChanged(-1);
                              GrandExchangeOfferOwnWorldComparator.clientPreferences.rememberedUsername = null;
                              FontName.method5389();
                           }

                           WorldMapArea.method509();
                        }

                        while(class22.method255()) {
                           if(class3.field16 == 13) {
                              Login.loginIndex = 0;
                              Login.Login_username = "";
                              Client.onUsernameChanged(-1);
                              Login.Login_password = "";
                              GraphicsObject.field1141 = 0;
                              MilliClock.otp = "";
                              Login.field1214 = true;
                           } else if(Login.currentLoginField == 0) {
                              char var39 = Coord.field2531;

                              for(var40 = 0; var40 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length() && var39 != "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var40); ++var40) {
                                 ;
                              }

                              if(class3.field16 == 85 && Login.Login_username.length() > 0) {
                                 Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
                                 Client.onUsernameChanged(-1);
                              }

                              if(class3.field16 == 84 || class3.field16 == 80) {
                                 Login.currentLoginField = 1;
                              }

                              char var44 = Coord.field2531;
                              boolean var42 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".indexOf(var44) != -1;
                              if(var42 && Login.Login_username.length() < 320) {
                                 Login.Login_username = Login.Login_username + Coord.field2531;
                                 Client.onUsernameChanged(-1);
                              }
                           } else if(Login.currentLoginField == 1) {
                              if(class3.field16 == 85 && Login.Login_password.length() > 0) {
                                 Login.Login_password = Login.Login_password.substring(0, Login.Login_password.length() - 1);
                              } else if(class3.field16 == 84 || class3.field16 == 80) {
                                 Login.currentLoginField = 0;
                                 if(class3.field16 == 84) {
                                    Login.Login_username = Login.Login_username.trim();
                                    Client.onUsernameChanged(-1);
                                    if(Login.Login_username.length() == 0) {
                                       HealthBarUpdate.method1866("", "Please enter your username/email address.", "");
                                       return;
                                    }

                                    if(Login.Login_password.length() == 0) {
                                       HealthBarUpdate.method1866("", "Please enter your password.", "");
                                       return;
                                    }

                                    HealthBarUpdate.method1866("", "Connecting to server...", "");
                                    GraphicsObject.method2122(false);
                                    MouseRecorder.method1293(20);
                                    return;
                                 }
                              }

                              if((KeyHandler.KeyHandler_pressedKeys[82] || KeyHandler.KeyHandler_pressedKeys[87]) && class3.field16 == 67) {
                                 Clipboard var25 = Toolkit.getDefaultToolkit().getSystemClipboard();
                                 Transferable var26 = var25.getContents(WorldMapSection1.client);
                                 int var43 = 20 - Login.Login_password.length();
                                 if(var43 > 0) {
                                    try {
                                       String var13 = (String)var26.getTransferData(DataFlavor.stringFlavor);
                                       int var45 = Math.min(var43, var13.length());
                                       int var15 = 0;

                                       while(true) {
                                          if(var15 < var45) {
                                             char var17 = var13.charAt(var15);
                                             boolean var16;
                                             if((var17 < 32 || var17 >= 127) && (var17 <= 127 || var17 >= 160) && (var17 <= 160 || var17 > 255)) {
                                                label1345: {
                                                   if(var17 != 0) {
                                                      char[] var18 = class297.cp1252AsciiExtension;

                                                      for(int var19 = 0; var19 < var18.length; ++var19) {
                                                         char var20 = var18[var19];
                                                         if(var20 == var17) {
                                                            var16 = true;
                                                            break label1345;
                                                         }
                                                      }
                                                   }

                                                   var16 = false;
                                                }
                                             } else {
                                                var16 = true;
                                             }

                                             if(var16 && WorldMapSection2.method433(var13.charAt(var15))) {
                                                ++var15;
                                                continue;
                                             }

                                             Login.loginIndex = 3;
                                             return;
                                          }

                                          Login.Login_password = Login.Login_password + var13.substring(0, var45);
                                          break;
                                       }
                                    } catch (UnsupportedFlavorException var30) {
                                       ;
                                    } catch (IOException var31) {
                                       ;
                                    }
                                 }
                              } else {
                                 char var11 = Coord.field2531;
                                 if((var11 < 32 || var11 >= 127) && (var11 <= 127 || var11 >= 160) && (var11 <= 160 || var11 > 255)) {
                                    label1348: {
                                       if(var11 != 0) {
                                          char[] var27 = class297.cp1252AsciiExtension;

                                          for(int var28 = 0; var28 < var27.length; ++var28) {
                                             char var14 = var27[var28];
                                             if(var11 == var14) {
                                                var10 = true;
                                                break label1348;
                                             }
                                          }
                                       }

                                       var10 = false;
                                    }
                                 } else {
                                    var10 = true;
                                 }

                                 if(var10) {
                                    char var47 = Coord.field2531;
                                    boolean var12 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".indexOf(var47) != -1;
                                    if(var12 && Login.Login_password.length() < 20) {
                                       Login.Login_password = Login.Login_password + Coord.field2531;
                                    }
                                 }
                              }
                           }
                        }
                     } else if(Login.loginIndex == 3) {
                        var35 = Login.loginBoxX + 180;
                        var37 = 276;
                        if(var4 == 1 && var46 >= var35 - 75 && var46 <= var35 + 75 && var33 >= var37 - 20 && var33 <= var37 + 20) {
                           ObjectDefinition.method4712(false);
                        }

                        var35 = Login.loginBoxX + 180;
                        var37 = 326;
                        if(var4 == 1 && var46 >= var35 - 75 && var46 <= var35 + 75 && var33 >= var37 - 20 && var33 <= var37 + 20) {
                           HealthBarUpdate.method1866("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           Login.loginIndex = 5;
                           return;
                        }
                     } else {
                        int var41;
                        if(Login.loginIndex == 4) {
                           var35 = Login.loginBoxX + 180 - 80;
                           var37 = 321;
                           if(var4 == 1 && var46 >= var35 - 75 && var46 <= var35 + 75 && var33 >= var37 - 20 && var33 <= var37 + 20) {
                              MilliClock.otp.trim();
                              if(MilliClock.otp.length() != 6) {
                                 HealthBarUpdate.method1866("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              GraphicsObject.field1141 = Integer.parseInt(MilliClock.otp);
                              MilliClock.otp = "";
                              GraphicsObject.method2122(true);
                              HealthBarUpdate.method1866("", "Connecting to server...", "");
                              MouseRecorder.method1293(20);
                              return;
                           }

                           if(var4 == 1 && var46 >= Login.loginBoxX + 180 - 9 && var46 <= Login.loginBoxX + 180 + 130 && var33 >= 263 && var33 <= 296) {
                              Login.field1214 = !Login.field1214;
                           }

                           if(var4 == 1 && var46 >= Login.loginBoxX + 180 - 34 && var46 <= Login.loginBoxX + 34 + 180 && var33 >= 351 && var33 <= 363) {
                              Script.method2336(class41.method654("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                           }

                           var35 = Login.loginBoxX + 180 + 80;
                           if(var4 == 1 && var46 >= var35 - 75 && var46 <= var35 + 75 && var33 >= var37 - 20 && var33 <= var37 + 20) {
                              Login.loginIndex = 0;
                              Login.Login_username = "";
                              Client.onUsernameChanged(-1);
                              Login.Login_password = "";
                              GraphicsObject.field1141 = 0;
                              MilliClock.otp = "";
                           }

                           while(class22.method255()) {
                              boolean var38 = false;

                              for(var41 = 0; var41 < "1234567890".length(); ++var41) {
                                 if(Coord.field2531 == "1234567890".charAt(var41)) {
                                    var38 = true;
                                    break;
                                 }
                              }

                              if(class3.field16 == 13) {
                                 Login.loginIndex = 0;
                                 Login.Login_username = "";
                                 Client.onUsernameChanged(-1);
                                 Login.Login_password = "";
                                 GraphicsObject.field1141 = 0;
                                 MilliClock.otp = "";
                              } else {
                                 if(class3.field16 == 85 && MilliClock.otp.length() > 0) {
                                    MilliClock.otp = MilliClock.otp.substring(0, MilliClock.otp.length() - 1);
                                 }

                                 if(class3.field16 == 84) {
                                    MilliClock.otp.trim();
                                    if(MilliClock.otp.length() != 6) {
                                       HealthBarUpdate.method1866("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    GraphicsObject.field1141 = Integer.parseInt(MilliClock.otp);
                                    MilliClock.otp = "";
                                    GraphicsObject.method2122(true);
                                    HealthBarUpdate.method1866("", "Connecting to server...", "");
                                    MouseRecorder.method1293(20);
                                    return;
                                 }

                                 if(var38 && MilliClock.otp.length() < 6) {
                                    MilliClock.otp = MilliClock.otp + Coord.field2531;
                                 }
                              }
                           }
                        } else if(Login.loginIndex == 5) {
                           var35 = Login.loginBoxX + 180 - 80;
                           var37 = 321;
                           if(var4 == 1 && var46 >= var35 - 75 && var46 <= var35 + 75 && var33 >= var37 - 20 && var33 <= var37 + 20) {
                              WorldMapEvent.method864();
                              return;
                           }

                           var35 = Login.loginBoxX + 180 + 80;
                           if(var4 == 1 && var46 >= var35 - 75 && var46 <= var35 + 75 && var33 >= var37 - 20 && var33 <= var37 + 20) {
                              ObjectDefinition.method4712(true);
                           }

                           var9 = 361;
                           if(MusicPatchPcmStream.field2495 != null) {
                              var41 = MusicPatchPcmStream.field2495.highX / 2;
                              if(var4 == 1 && var46 >= MusicPatchPcmStream.field2495.lowX - var41 && var46 <= var41 + MusicPatchPcmStream.field2495.lowX && var33 >= var9 - 15 && var33 < var9) {
                                 Script.method2336(class41.method654("secure", true) + "m=weblogin/g=oldscape/cant_log_in", true, false);
                              }
                           }

                           while(class22.method255()) {
                              var10 = false;

                              for(var40 = 0; var40 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var40) {
                                 if(Coord.field2531 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var40)) {
                                    var10 = true;
                                    break;
                                 }
                              }

                              if(class3.field16 == 13) {
                                 ObjectDefinition.method4712(true);
                              } else {
                                 if(class3.field16 == 85 && Login.Login_username.length() > 0) {
                                    Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
                                    Client.onUsernameChanged(-1);
                                 }

                                 if(class3.field16 == 84) {
                                    WorldMapEvent.method864();
                                    return;
                                 }

                                 if(var10 && Login.Login_username.length() < 320) {
                                    Login.Login_username = Login.Login_username + Coord.field2531;
                                    Client.onUsernameChanged(-1);
                                 }
                              }
                           }
                        } else if(Login.loginIndex == 6) {
                           while(class22.method255()) {
                              if(class3.field16 == 84 || class3.field16 == 13) {
                                 ObjectDefinition.method4712(true);
                              }
                           }

                           var36 = 321;
                           if(var4 == 1 && var33 >= var36 - 20 && var33 <= var36 + 20) {
                              ObjectDefinition.method4712(true);
                           }
                        } else if(Login.loginIndex == 7) {
                           var35 = Login.loginBoxX + 180 - 80;
                           var37 = 321;
                           if(var4 == 1 && var46 >= var35 - 75 && var46 <= var35 + 75 && var33 >= var37 - 20 && var33 <= var37 + 20) {
                              Script.method2336(class41.method654("secure", true) + "m=dob/set_dob.ws", true, false);
                              HealthBarUpdate.method1866("", "Page has opened in a new window.", "(Please check your popup blocker.)");
                              Login.loginIndex = 6;
                              return;
                           }

                           var35 = Login.loginBoxX + 180 + 80;
                           if(var4 == 1 && var46 >= var35 - 75 && var46 <= var35 + 75 && var33 >= var37 - 20 && var33 <= var37 + 20) {
                              ObjectDefinition.method4712(true);
                           }
                        } else if(Login.loginIndex == 8) {
                           var35 = Login.loginBoxX + 180 - 80;
                           var37 = 321;
                           if(var4 == 1 && var46 >= var35 - 75 && var46 <= var35 + 75 && var33 >= var37 - 20 && var33 <= var37 + 20) {
                              Script.method2336("https://www.jagex.com/terms/privacy", true, false);
                              HealthBarUpdate.method1866("", "Page has opened in a new window.", "(Please check your popup blocker.)");
                              Login.loginIndex = 6;
                              return;
                           }

                           var35 = Login.loginBoxX + 180 + 80;
                           if(var4 == 1 && var46 >= var35 - 75 && var46 <= var35 + 75 && var33 >= var37 - 20 && var33 <= var37 + 20) {
                              ObjectDefinition.method4712(true);
                           }
                        } else if(Login.loginIndex == 12) {
                           String var29 = "";
                           switch(Login.field1201) {
                           case 0:
                              var29 = "https://support.runescape.com/hc/en-gb/articles/115002238729-Account-Bans";
                              break;
                           case 1:
                              var29 = "https://support.runescape.com/hc/en-gb/articles/206103939-My-account-is-locked";
                              break;
                           default:
                              ObjectDefinition.method4712(false);
                           }

                           var8 = Login.loginBoxX + 180;
                           var9 = 276;
                           if(var4 == 1 && var46 >= var8 - 75 && var46 <= var8 + 75 && var33 >= var9 - 20 && var33 <= var9 + 20) {
                              Script.method2336(var29, true, false);
                              HealthBarUpdate.method1866("", "Page has opened in a new window.", "(Please check your popup blocker.)");
                              Login.loginIndex = 6;
                              return;
                           }

                           var8 = Login.loginBoxX + 180;
                           var9 = 326;
                           if(var4 == 1 && var46 >= var8 - 75 && var46 <= var8 + 75 && var33 >= var9 - 20 && var33 <= var9 + 20) {
                              ObjectDefinition.method4712(false);
                           }
                        } else if(Login.loginIndex == 24) {
                           var35 = Login.loginBoxX + 180;
                           var37 = 301;
                           if(var4 == 1 && var46 >= var35 - 75 && var46 <= var35 + 75 && var33 >= var37 - 20 && var33 <= var37 + 20) {
                              ObjectDefinition.method4712(false);
                           }
                        }
                     }
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lej;[Lfm;I)V",
      garbageValue = "-1662285695"
   )
   static final void method248(Scene var0, CollisionMap[] var1) {
      int var2;
      int var3;
      int var4;
      int var5;
      for(var2 = 0; var2 < 4; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            for(var4 = 0; var4 < 104; ++var4) {
               if((Tiles.Tiles_renderFlags[var2][var3][var4] & 1) == 1) {
                  var5 = var2;
                  if((Tiles.Tiles_renderFlags[1][var3][var4] & 2) == 2) {
                     var5 = var2 - 1;
                  }

                  if(var5 >= 0) {
                     var1[var5].method3633(var3, var4);
                  }
               }
            }
         }
      }

      Tiles.field550 += (int)(Math.random() * 5.0D) - 2;
      if(Tiles.field550 < -8) {
         Tiles.field550 = -8;
      }

      if(Tiles.field550 > 8) {
         Tiles.field550 = 8;
      }

      Tiles.field548 += (int)(Math.random() * 5.0D) - 2;
      if(Tiles.field548 < -16) {
         Tiles.field548 = -16;
      }

      if(Tiles.field548 > 16) {
         Tiles.field548 = 16;
      }

      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var16;
      int var17;
      int var18;
      for(var2 = 0; var2 < 4; ++var2) {
         byte[][] var42 = SoundCache.field1462[var2];
         var9 = (int)Math.sqrt(5100.0D);
         var10 = var9 * 768 >> 8;

         int var19;
         int var20;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var13 = Tiles.Tiles_heights[var2][var12 + 1][var11] - Tiles.Tiles_heights[var2][var12 - 1][var11];
               var14 = Tiles.Tiles_heights[var2][var12][var11 + 1] - Tiles.Tiles_heights[var2][var12][var11 - 1];
               var15 = (int)Math.sqrt((double)(var13 * var13 + var14 * var14 + 65536));
               var16 = (var13 << 8) / var15;
               var17 = 65536 / var15;
               var18 = (var14 << 8) / var15;
               var19 = (var16 * -50 + var18 * -50 + var17 * -10) / var10 + 96;
               var20 = (var42[var12 - 1][var11] >> 2) + (var42[var12][var11 - 1] >> 2) + (var42[var12 + 1][var11] >> 3) + (var42[var12][var11 + 1] >> 3) + (var42[var12][var11] >> 1);
               Tiles.field545[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            Tiles_hue[var11] = 0;
            UserComparator6.Tiles_saturation[var11] = 0;
            StructDefinition.Tiles_lightness[var11] = 0;
            Tiles.Tiles_hueMultiplier[var11] = 0;
            FriendSystem.field1086[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = var11 + 5;
               if(var13 >= 0 && var13 < 104) {
                  var14 = Tiles.field538[var2][var13][var12] & 255;
                  if(var14 > 0) {
                     FloorUnderlayDefinition var43 = class60.method995(var14 - 1);
                     Tiles_hue[var12] += var43.hue;
                     UserComparator6.Tiles_saturation[var12] += var43.saturation;
                     StructDefinition.Tiles_lightness[var12] += var43.lightness;
                     Tiles.Tiles_hueMultiplier[var12] += var43.hueMultiplier;
                     ++FriendSystem.field1086[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = Tiles.field538[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     FloorUnderlayDefinition var44 = class60.method995(var15 - 1);
                     Tiles_hue[var12] -= var44.hue;
                     UserComparator6.Tiles_saturation[var12] -= var44.saturation;
                     StructDefinition.Tiles_lightness[var12] -= var44.lightness;
                     Tiles.Tiles_hueMultiplier[var12] -= var44.hueMultiplier;
                     --FriendSystem.field1086[var12];
                  }
               }
            }

            if(var11 >= 1 && var11 < 103) {
               var12 = 0;
               var13 = 0;
               var14 = 0;
               var15 = 0;
               var16 = 0;

               for(var17 = -5; var17 < 109; ++var17) {
                  var18 = var17 + 5;
                  if(var18 >= 0 && var18 < 104) {
                     var12 += Tiles_hue[var18];
                     var13 += UserComparator6.Tiles_saturation[var18];
                     var14 += StructDefinition.Tiles_lightness[var18];
                     var15 += Tiles.Tiles_hueMultiplier[var18];
                     var16 += FriendSystem.field1086[var18];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= Tiles_hue[var19];
                     var13 -= UserComparator6.Tiles_saturation[var19];
                     var14 -= StructDefinition.Tiles_lightness[var19];
                     var15 -= Tiles.Tiles_hueMultiplier[var19];
                     var16 -= FriendSystem.field1086[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!Client.isLowDetail || (Tiles.Tiles_renderFlags[0][var11][var17] & 2) != 0 || (Tiles.Tiles_renderFlags[var2][var11][var17] & 16) == 0)) {
                     if(var2 < Tiles.Tiles_minPlane) {
                        Tiles.Tiles_minPlane = var2;
                     }

                     var20 = Tiles.field538[var2][var11][var17] & 255;
                     int var21 = class348.field4061[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = Tiles.Tiles_heights[var2][var11][var17];
                        int var23 = Tiles.Tiles_heights[var2][var11 + 1][var17];
                        int var24 = Tiles.Tiles_heights[var2][var11 + 1][var17 + 1];
                        int var25 = Tiles.Tiles_heights[var2][var11][var17 + 1];
                        int var26 = Tiles.field545[var11][var17];
                        int var27 = Tiles.field545[var11 + 1][var17];
                        int var28 = Tiles.field545[var11 + 1][var17 + 1];
                        int var29 = Tiles.field545[var11][var17 + 1];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        if(var20 > 0) {
                           var32 = var12 * 256 / var15;
                           var33 = var13 / var16;
                           int var34 = var14 / var16;
                           var30 = DevicePcmPlayerProvider.method947(var32, var33, var34);
                           var32 = var32 + Tiles.field550 & 255;
                           var34 += Tiles.field548;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = DevicePcmPlayerProvider.method947(var32, var33, var34);
                        }

                        if(var2 > 0) {
                           boolean var47 = true;
                           if(var20 == 0 && Tiles.field539[var2][var11][var17] != 0) {
                              var47 = false;
                           }

                           if(var21 > 0 && !UserComparator9.method3492(var21 - 1).hideUnderlay) {
                              var47 = false;
                           }

                           if(var47 && var22 == var23 && var24 == var22 && var22 == var25) {
                              WorldMapSection3.field404[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = Rasterizer3D.Rasterizer3D_colorPalette[Strings.method4221(var31, 96)];
                        }

                        if(var21 == 0) {
                           var0.method3182(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, Strings.method4221(var30, var26), Strings.method4221(var30, var27), Strings.method4221(var30, var28), Strings.method4221(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = Tiles.field539[var2][var11][var17] + 1;
                           byte var48 = Tiles.field540[var2][var11][var17];
                           FloorOverlayDefinition var35 = UserComparator9.method3492(var21 - 1);
                           int var36 = var35.texture;
                           int var37;
                           int var38;
                           int var39;
                           int var40;
                           if(var36 >= 0) {
                              var38 = Rasterizer3D.Rasterizer3D_textureLoader.vmethod3386(var36);
                              var37 = -1;
                           } else if(var35.primaryRgb == 16711935) {
                              var37 = -2;
                              var36 = -1;
                              var38 = -2;
                           } else {
                              var37 = DevicePcmPlayerProvider.method947(var35.hue, var35.saturation, var35.lightness);
                              var39 = var35.hue + Tiles.field550 & 255;
                              var40 = var35.lightness + Tiles.field548;
                              if(var40 < 0) {
                                 var40 = 0;
                              } else if(var40 > 255) {
                                 var40 = 255;
                              }

                              var38 = DevicePcmPlayerProvider.method947(var39, var35.saturation, var40);
                           }

                           var39 = 0;
                           if(var38 != -2) {
                              var39 = Rasterizer3D.Rasterizer3D_colorPalette[class297.method5333(var38, 96)];
                           }

                           if(var35.secondaryRgb != -1) {
                              var40 = var35.secondaryHue + Tiles.field550 & 255;
                              int var41 = var35.secondaryLightness + Tiles.field548;
                              if(var41 < 0) {
                                 var41 = 0;
                              } else if(var41 > 255) {
                                 var41 = 255;
                              }

                              var38 = DevicePcmPlayerProvider.method947(var40, var35.secondarySaturation, var41);
                              var39 = Rasterizer3D.Rasterizer3D_colorPalette[class297.method5333(var38, 96)];
                           }

                           var0.method3182(var2, var11, var17, var33, var48, var36, var22, var23, var24, var25, Strings.method4221(var30, var26), Strings.method4221(var30, var27), Strings.method4221(var30, var28), Strings.method4221(var30, var29), class297.method5333(var37, var26), class297.method5333(var37, var27), class297.method5333(var37, var28), class297.method5333(var37, var29), var32, var39);
                        }
                     }
                  }
               }
            }
         }

         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               if((Tiles.Tiles_renderFlags[var2][var12][var11] & 8) != 0) {
                  var17 = 0;
               } else if(var2 > 0 && (Tiles.Tiles_renderFlags[1][var12][var11] & 2) != 0) {
                  var17 = var2 - 1;
               } else {
                  var17 = var2;
               }

               var0.method3181(var2, var12, var11, var17);
            }
         }

         Tiles.field538[var2] = null;
         class348.field4061[var2] = null;
         Tiles.field539[var2] = null;
         Tiles.field540[var2] = null;
         SoundCache.field1462[var2] = null;
      }

      var0.method3262(-50, -10, -50);

      for(var2 = 0; var2 < 104; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            if((Tiles.Tiles_renderFlags[1][var2][var3] & 2) == 2) {
               var0.method3179(var2, var3);
            }
         }
      }

      var2 = 1;
      var3 = 2;
      var4 = 4;

      for(var5 = 0; var5 < 4; ++var5) {
         if(var5 > 0) {
            var2 <<= 3;
            var3 <<= 3;
            var4 <<= 3;
         }

         for(int var6 = 0; var6 <= var5; ++var6) {
            for(int var7 = 0; var7 <= 104; ++var7) {
               for(int var8 = 0; var8 <= 104; ++var8) {
                  short var46;
                  if((WorldMapSection3.field404[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (WorldMapSection3.field404[var6][var8][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (WorldMapSection3.field404[var6][var8][var10 + 1] & var2) != 0) {
                        ++var10;
                     }

                     label444:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((WorldMapSection3.field404[var11 - 1][var8][var13] & var2) == 0) {
                              break label444;
                           }
                        }

                        --var11;
                     }

                     label455:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((WorldMapSection3.field404[var12 + 1][var8][var13] & var2) == 0) {
                              break label455;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
                     if(var13 >= 8) {
                        var46 = 240;
                        var15 = Tiles.Tiles_heights[var12][var8][var9] - var46;
                        var16 = Tiles.Tiles_heights[var11][var8][var9];
                        Scene.method3277(var5, 1, var8 * 128, var8 * 128, var9 * 128, var10 * 128 + 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              WorldMapSection3.field404[var17][var8][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if((WorldMapSection3.field404[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (WorldMapSection3.field404[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (WorldMapSection3.field404[var6][var10 + 1][var7] & var3) != 0) {
                        ++var10;
                     }

                     label493:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((WorldMapSection3.field404[var11 - 1][var13][var7] & var3) == 0) {
                              break label493;
                           }
                        }

                        --var11;
                     }

                     label504:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((WorldMapSection3.field404[var12 + 1][var13][var7] & var3) == 0) {
                              break label504;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var12 + 1 - var11) * (var10 - var9 + 1);
                     if(var13 >= 8) {
                        var46 = 240;
                        var15 = Tiles.Tiles_heights[var12][var9][var7] - var46;
                        var16 = Tiles.Tiles_heights[var11][var9][var7];
                        Scene.method3277(var5, 2, var9 * 128, var10 * 128 + 128, var7 * 128, var7 * 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              WorldMapSection3.field404[var17][var18][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((WorldMapSection3.field404[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (WorldMapSection3.field404[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (WorldMapSection3.field404[var6][var8][var12 + 1] & var4) != 0) {
                        ++var12;
                     }

                     label543:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((WorldMapSection3.field404[var6][var9 - 1][var13] & var4) == 0) {
                              break label543;
                           }
                        }

                        --var9;
                     }

                     label554:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((WorldMapSection3.field404[var6][var10 + 1][var13] & var4) == 0) {
                              break label554;
                           }
                        }

                        ++var10;
                     }

                     if((var12 - var11 + 1) * (var10 - var9 + 1) >= 4) {
                        var13 = Tiles.Tiles_heights[var6][var9][var11];
                        Scene.method3277(var5, 4, var9 * 128, var10 * 128 + 128, var11 * 128, var12 * 128 + 128, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              WorldMapSection3.field404[var6][var14][var15] &= ~var4;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("gs")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2010586363"
   )
   static final void method249() {
      for(GraphicsObject var0 = (GraphicsObject)Client.graphicsObjects.method4956(); var0 != null; var0 = (GraphicsObject)Client.graphicsObjects.method4974()) {
         if(var0.plane == ScriptEvent.Client_plane && !var0.isFinished) {
            if(Client.cycle >= var0.cycleStart) {
               var0.method2115(Client.field741);
               if(var0.isFinished) {
                  var0.method3676();
               } else {
                  GrandExchangeOfferWorldComparator.scene.method3188(var0.plane, var0.x, var0.y, var0.height, 60, var0, 0, -1L, false);
               }
            }
         } else {
            var0.method3676();
         }
      }

   }

   @ObfuscatedName("jw")
   @ObfuscatedSignature(
      signature = "(Lhe;I)Z",
      garbageValue = "-74932209"
   )
   static final boolean method250(Widget var0) {
      if(var0.cs1Comparisons == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.cs1Comparisons.length; ++var1) {
            int var2 = Tiles.method1227(var0, var1);
            int var3 = var0.cs1ComparisonValues[var1];
            if(var0.cs1Comparisons[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.cs1Comparisons[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.cs1Comparisons[var1] == 4) {
               if(var3 == var2) {
                  return false;
               }
            } else if(var2 != var3) {
               return false;
            }
         }

         return true;
      }
   }
}
