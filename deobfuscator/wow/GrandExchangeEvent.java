import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSGrandExchangeEvent;

@ObfuscatedName("i")
public class GrandExchangeEvent implements RSGrandExchangeEvent {

   @ObfuscatedName("sx")
   @ObfuscatedSignature(
      signature = "Lg;"
   )
   static GrandExchangeEvents grandExchangeEvents;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1236605669
   )
   static int field75;
   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "[Lle;"
   )
   static IndexedSprite[] worldSelectFlagSprites;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 658095085
   )
   public final int world;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 2297014437459523259L
   )
   public final long age;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lb;"
   )
   public final GrandExchangeOffer grandExchangeOffer;
   @ObfuscatedName("d")
   String offerName;
   @ObfuscatedName("w")
   String previousOfferName;


   @ObfuscatedSignature(
      signature = "(Lkb;BI)V"
   )
   GrandExchangeEvent(Buffer var1, byte var2, int var3) {
      this.offerName = var1.method5695();
      this.previousOfferName = var1.method5695();
      this.world = var1.method5577();
      this.age = var1.method5581();
      int var4 = var1.method5580();
      int var5 = var1.method5580();
      this.grandExchangeOffer = new GrandExchangeOffer();
      this.grandExchangeOffer.method211(2);
      this.grandExchangeOffer.method187(var2);
      this.grandExchangeOffer.unitPrice = var4;
      this.grandExchangeOffer.totalQuantity = var5;
      this.grandExchangeOffer.currentQuantity = 0;
      this.grandExchangeOffer.currentPrice = 0;
      this.grandExchangeOffer.id = var3;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1636604960"
   )
   public String method157() {
      return this.offerName;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-119"
   )
   public String method158() {
      return this.previousOfferName;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([Lgo;II)Lgo;",
      garbageValue = "-1609956543"
   )
   public static Enumerated method159(Enumerated[] var0, int var1) {
      Enumerated[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         Enumerated var4 = var2[var3];
         if(var1 == var4.vmethod6189()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)I",
      garbageValue = "30"
   )
   public static int method166(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0 - (var3 - 1):(var2 == 2?7 - var1 - (var4 - 1):var0));
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "62688093"
   )
   static final void method165(String var0) {
      Skeleton.method3175(30, "", var0);
   }

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-97"
   )
   static final void method161() {
      class303.method5398(false);
      Client.field818 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < WorldMapData_0.regionLandArchives.length; ++var1) {
         if(KeyHandler.regionMapArchiveIds[var1] != -1 && WorldMapData_0.regionLandArchives[var1] == null) {
            WorldMapData_0.regionLandArchives[var1] = WorldMapIcon_0.archive5.method4249(KeyHandler.regionMapArchiveIds[var1], 0, (byte)-86);
            if(WorldMapData_0.regionLandArchives[var1] == null) {
               var0 = false;
               ++Client.field818;
            }
         }

         if(WorldMapArea.regionLandArchiveIds[var1] != -1 && class23.regionMapArchives[var1] == null) {
            class23.regionMapArchives[var1] = WorldMapIcon_0.archive5.method4288(WorldMapArea.regionLandArchiveIds[var1], 0, UrlRequester.xteaKeys[var1]);
            if(class23.regionMapArchives[var1] == null) {
               var0 = false;
               ++Client.field818;
            }
         }
      }

      if(!var0) {
         Client.field899 = 1;
      } else {
         Client.field734 = 0;
         var0 = true;

         int var3;
         int var4;
         Buffer var8;
         int var9;
         int var10;
         int var11;
         int var13;
         int var14;
         int var15;
         int var16;
         int var17;
         int var18;
         for(var1 = 0; var1 < WorldMapData_0.regionLandArchives.length; ++var1) {
            byte[] var2 = class23.regionMapArchives[var1];
            if(var2 != null) {
               var3 = (StructDefinition.regions[var1] >> 8) * 64 - class69.baseX * 64;
               var4 = (StructDefinition.regions[var1] & 255) * 64 - class89.baseY * 64;
               if(Client.isInInstance) {
                  var3 = 10;
                  var4 = 10;
               }

               boolean var7 = true;
               var8 = new Buffer(var2);
               var9 = -1;

               label630:
               while(true) {
                  var10 = var8.method5590();
                  if(var10 == 0) {
                     var0 &= var7;
                     break;
                  }

                  var9 += var10;
                  var11 = 0;
                  boolean var12 = false;

                  while(true) {
                     while(!var12) {
                        var13 = var8.method5589();
                        if(var13 == 0) {
                           continue label630;
                        }

                        var11 += var13 - 1;
                        var14 = var11 & 63;
                        var15 = var11 >> 6 & 63;
                        var16 = var8.method5575() >> 2;
                        var17 = var3 + var15;
                        var18 = var14 + var4;
                        if(var17 > 0 && var18 > 0 && var17 < 103 && var18 < 103) {
                           ObjectDefinition var19 = WorldMapSection2.method435(var9);
                           if(var16 != 22 || !Client.isLowDetail || var19.int1 != 0 || var19.interactType == 1 || var19.boolean2) {
                              if(!var19.method4663()) {
                                 ++Client.field734;
                                 var7 = false;
                              }

                              var12 = true;
                           }
                        }
                     }

                     var13 = var8.method5589();
                     if(var13 == 0) {
                        break;
                     }

                     var8.method5575();
                  }
               }
            }
         }

         if(!var0) {
            Client.field899 = 2;
         } else {
            if(Client.field899 != 0) {
               AbstractByteArrayCopier.method4026("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            ChatChannel.method2356();
            GrandExchangeOfferWorldComparator.scene.method3208();

            for(var1 = 0; var1 < 4; ++var1) {
               Client.collisionMaps[var1].method3637();
            }

            int var35;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var35 = 0; var35 < 104; ++var35) {
                  for(var3 = 0; var3 < 104; ++var3) {
                     Tiles.Tiles_renderFlags[var1][var35][var3] = 0;
                  }
               }
            }

            ChatChannel.method2356();
            UserComparator9.method3499();
            var1 = WorldMapData_0.regionLandArchives.length;
            TriBool.method5250();
            class303.method5398(true);
            int var5;
            int var20;
            int var21;
            int var40;
            int var51;
            if(!Client.isInInstance) {
               byte[] var36;
               for(var35 = 0; var35 < var1; ++var35) {
                  var3 = (StructDefinition.regions[var35] >> 8) * 64 - class69.baseX * 64;
                  var4 = (StructDefinition.regions[var35] & 255) * 64 - class89.baseY * 64;
                  var36 = WorldMapData_0.regionLandArchives[var35];
                  if(var36 != null) {
                     ChatChannel.method2356();
                     WorldMapData_0.method275(var36, var3, var4, class69.field585 * 8 - 48, MouseHandler.field529 * 8 - 48, Client.collisionMaps);
                  }
               }

               for(var35 = 0; var35 < var1; ++var35) {
                  var3 = (StructDefinition.regions[var35] >> 8) * 64 - class69.baseX * 64;
                  var4 = (StructDefinition.regions[var35] & 255) * 64 - class89.baseY * 64;
                  var36 = WorldMapData_0.regionLandArchives[var35];
                  if(var36 == null && MouseHandler.field529 < 800) {
                     ChatChannel.method2356();
                     WorldMapSprite.method514(var3, var4, 64, 64);
                  }
               }

               class303.method5398(true);

               for(var35 = 0; var35 < var1; ++var35) {
                  byte[] var41 = class23.regionMapArchives[var35];
                  if(var41 != null) {
                     var4 = (StructDefinition.regions[var35] >> 8) * 64 - class69.baseX * 64;
                     var5 = (StructDefinition.regions[var35] & 255) * 64 - class89.baseY * 64;
                     ChatChannel.method2356();
                     Scene var42 = GrandExchangeOfferWorldComparator.scene;
                     CollisionMap[] var43 = Client.collisionMaps;
                     var8 = new Buffer(var41);
                     var9 = -1;

                     while(true) {
                        var10 = var8.method5590();
                        if(var10 == 0) {
                           break;
                        }

                        var9 += var10;
                        var11 = 0;

                        while(true) {
                           var51 = var8.method5589();
                           if(var51 == 0) {
                              break;
                           }

                           var11 += var51 - 1;
                           var13 = var11 & 63;
                           var14 = var11 >> 6 & 63;
                           var15 = var11 >> 12;
                           var16 = var8.method5575();
                           var17 = var16 >> 2;
                           var18 = var16 & 3;
                           var40 = var14 + var4;
                           var20 = var13 + var5;
                           if(var40 > 0 && var20 > 0 && var40 < 103 && var20 < 103) {
                              var21 = var15;
                              if((Tiles.Tiles_renderFlags[1][var40][var20] & 2) == 2) {
                                 var21 = var15 - 1;
                              }

                              CollisionMap var47 = null;
                              if(var21 >= 0) {
                                 var47 = var43[var21];
                              }

                              PacketBuffer.method5555(var15, var40, var20, var9, var18, var17, var42, var47);
                           }
                        }
                     }
                  }
               }
            }

            int var6;
            int var37;
            int var50;
            if(Client.isInInstance) {
               int var22;
               int var25;
               int var27;
               int var28;
               int var29;
               CollisionMap[] var39;
               Buffer var52;
               for(var35 = 0; var35 < 4; ++var35) {
                  ChatChannel.method2356();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        boolean var49 = false;
                        var6 = Client.instanceChunkTemplates[var35][var3][var4];
                        if(var6 != -1) {
                           var50 = var6 >> 24 & 3;
                           var37 = var6 >> 1 & 3;
                           var9 = var6 >> 14 & 1023;
                           var10 = var6 >> 3 & 2047;
                           var11 = (var9 / 8 << 8) + var10 / 8;

                           for(var51 = 0; var51 < StructDefinition.regions.length; ++var51) {
                              if(StructDefinition.regions[var51] == var11 && WorldMapData_0.regionLandArchives[var51] != null) {
                                 byte[] var38 = WorldMapData_0.regionLandArchives[var51];
                                 var14 = var3 * 8;
                                 var15 = var4 * 8;
                                 var16 = (var9 & 7) * 8;
                                 var17 = (var10 & 7) * 8;
                                 var39 = Client.collisionMaps;

                                 for(var40 = 0; var40 < 8; ++var40) {
                                    for(var20 = 0; var20 < 8; ++var20) {
                                       if(var14 + var40 > 0 && var14 + var40 < 103 && var20 + var15 > 0 && var15 + var20 < 103) {
                                          var39[var35].flags[var40 + var14][var20 + var15] &= -16777217;
                                       }
                                    }
                                 }

                                 var52 = new Buffer(var38);

                                 for(var20 = 0; var20 < 4; ++var20) {
                                    for(var21 = 0; var21 < 64; ++var21) {
                                       for(var22 = 0; var22 < 64; ++var22) {
                                          if(var50 == var20 && var21 >= var16 && var21 < var16 + 8 && var22 >= var17 && var22 < var17 + 8) {
                                             var25 = var14 + WorldMapSection1.method663(var21 & 7, var22 & 7, var37);
                                             var28 = var21 & 7;
                                             var29 = var22 & 7;
                                             int var30 = var37 & 3;
                                             if(var30 == 0) {
                                                var27 = var29;
                                             } else if(var30 == 1) {
                                                var27 = 7 - var28;
                                             } else if(var30 == 2) {
                                                var27 = 7 - var29;
                                             } else {
                                                var27 = var28;
                                             }

                                             MusicPatchNode2.method3775(var52, var35, var25, var27 + var15, 0, 0, var37);
                                          } else {
                                             MusicPatchNode2.method3775(var52, 0, -1, -1, 0, 0, 0);
                                          }
                                       }
                                    }
                                 }

                                 var49 = true;
                                 break;
                              }
                           }
                        }

                        if(!var49) {
                           FontName.method5386(var35, var3 * 8, var4 * 8);
                        }
                     }
                  }
               }

               for(var35 = 0; var35 < 13; ++var35) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = Client.instanceChunkTemplates[0][var35][var3];
                     if(var4 == -1) {
                        WorldMapSprite.method514(var35 * 8, var3 * 8, 8, 8);
                     }
                  }
               }

               class303.method5398(true);

               for(var35 = 0; var35 < 4; ++var35) {
                  ChatChannel.method2356();

                  for(var3 = 0; var3 < 13; ++var3) {
                     label470:
                     for(var4 = 0; var4 < 13; ++var4) {
                        var5 = Client.instanceChunkTemplates[var35][var3][var4];
                        if(var5 != -1) {
                           var6 = var5 >> 24 & 3;
                           var50 = var5 >> 1 & 3;
                           var37 = var5 >> 14 & 1023;
                           var9 = var5 >> 3 & 2047;
                           var10 = (var37 / 8 << 8) + var9 / 8;

                           for(var11 = 0; var11 < StructDefinition.regions.length; ++var11) {
                              if(StructDefinition.regions[var11] == var10 && class23.regionMapArchives[var11] != null) {
                                 byte[] var44 = class23.regionMapArchives[var11];
                                 var13 = var3 * 8;
                                 var14 = var4 * 8;
                                 var15 = (var37 & 7) * 8;
                                 var16 = (var9 & 7) * 8;
                                 Scene var45 = GrandExchangeOfferWorldComparator.scene;
                                 var39 = Client.collisionMaps;
                                 var52 = new Buffer(var44);
                                 var20 = -1;

                                 while(true) {
                                    var21 = var52.method5590();
                                    if(var21 == 0) {
                                       continue label470;
                                    }

                                    var20 += var21;
                                    var22 = 0;

                                    while(true) {
                                       int var46 = var52.method5589();
                                       if(var46 == 0) {
                                          break;
                                       }

                                       var22 += var46 - 1;
                                       int var24 = var22 & 63;
                                       var25 = var22 >> 6 & 63;
                                       int var26 = var22 >> 12;
                                       var27 = var52.method5575();
                                       var28 = var27 >> 2;
                                       var29 = var27 & 3;
                                       if(var6 == var26 && var25 >= var15 && var25 < var15 + 8 && var24 >= var16 && var24 < var16 + 8) {
                                          ObjectDefinition var48 = WorldMapSection2.method435(var20);
                                          int var31 = var13 + Language.method3750(var25 & 7, var24 & 7, var50, var48.sizeX, var48.sizeY, var29);
                                          int var32 = var14 + method166(var25 & 7, var24 & 7, var50, var48.sizeX, var48.sizeY, var29);
                                          if(var31 > 0 && var32 > 0 && var31 < 103 && var32 < 103) {
                                             int var33 = var35;
                                             if((Tiles.Tiles_renderFlags[1][var31][var32] & 2) == 2) {
                                                var33 = var35 - 1;
                                             }

                                             CollisionMap var34 = null;
                                             if(var33 >= 0) {
                                                var34 = var39[var33];
                                             }

                                             PacketBuffer.method5555(var35, var31, var32, var20, var29 + var50 & 3, var28, var45, var34);
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            class303.method5398(true);
            ChatChannel.method2356();
            GrandExchangeOfferAgeComparator.method248(GrandExchangeOfferWorldComparator.scene, Client.collisionMaps);
            class303.method5398(true);
            var35 = Tiles.Tiles_minPlane;
            if(var35 > ScriptEvent.Client_plane) {
               var35 = ScriptEvent.Client_plane;
            }

            if(var35 < ScriptEvent.Client_plane - 1) {
               var35 = ScriptEvent.Client_plane - 1;
            }

            if(Client.isLowDetail) {
               GrandExchangeOfferWorldComparator.scene.method3178(Tiles.Tiles_minPlane);
            } else {
               GrandExchangeOfferWorldComparator.scene.method3178(0);
            }

            for(var3 = 0; var3 < 104; ++var3) {
               for(var4 = 0; var4 < 104; ++var4) {
                  World.method1898(var3, var4);
               }
            }

            ChatChannel.method2356();
            ScriptFrame.method1241();
            ObjectDefinition.ObjectDefinition_cachedModelData.method3427();
            PacketBufferNode var53;
            if(WorldMapSection1.client.method1040()) {
               var53 = FaceNormal.method3377(ClientPacket.field2215, Client.packetWriter.isaacCipher);
               var53.packetBuffer.method5717(1057001181);
               Client.packetWriter.method2375(var53);
            }

            if(!Client.isInInstance) {
               var3 = (class69.field585 - 6) / 8;
               var4 = (class69.field585 + 6) / 8;
               var5 = (MouseHandler.field529 - 6) / 8;
               var6 = (MouseHandler.field529 + 6) / 8;

               for(var50 = var3 - 1; var50 <= var4 + 1; ++var50) {
                  for(var37 = var5 - 1; var37 <= var6 + 1; ++var37) {
                     if(var50 < var3 || var50 > var4 || var37 < var5 || var37 > var6) {
                        WorldMapIcon_0.archive5.method4285("m" + var50 + "_" + var37);
                        WorldMapIcon_0.archive5.method4285("l" + var50 + "_" + var37);
                     }
                  }
               }
            }

            MouseRecorder.method1293(30);
            ChatChannel.method2356();
            Tiles.field538 = null;
            class348.field4061 = null;
            Tiles.field539 = null;
            Tiles.field540 = null;
            WorldMapSection3.field404 = null;
            SoundCache.field1462 = null;
            Tiles.field545 = null;
            GrandExchangeOfferAgeComparator.Tiles_hue = null;
            UserComparator6.Tiles_saturation = null;
            StructDefinition.Tiles_lightness = null;
            Tiles.Tiles_hueMultiplier = null;
            FriendSystem.field1086 = null;
            var53 = FaceNormal.method3377(ClientPacket.field2241, Client.packetWriter.isaacCipher);
            Client.packetWriter.method2375(var53);
            GameShell.clock.vmethod3592();

            for(var4 = 0; var4 < 32; ++var4) {
               GameShell.graphicsTickTimes[var4] = 0L;
            }

            for(var4 = 0; var4 < 32; ++var4) {
               GameShell.clientTickTimes[var4] = 0L;
            }

            ModelData0.gameCyclesToDo = 0;
         }
      }
   }

   @ObfuscatedName("kn")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "209958068"
   )
   static final void method156(String var0) {
      if(!var0.equals("")) {
         PacketBufferNode var1 = FaceNormal.method3377(ClientPacket.field2236, Client.packetWriter.isaacCipher);
         var1.packetBuffer.method5559(class234.method4223(var0));
         var1.packetBuffer.method5655(var0);
         Client.packetWriter.method2375(var1);
      }
   }
}
