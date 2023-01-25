import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSWorldMapLabelSize;

@ObfuscatedName("ae")
public class WorldMapLabelSize implements RSWorldMapLabelSize {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lae;"
   )
   public static final WorldMapLabelSize WorldMapLabelSize_small = new WorldMapLabelSize(1, 0, 4);
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lae;"
   )
   public static final WorldMapLabelSize WorldMapLabelSize_medium = new WorldMapLabelSize(0, 1, 2);
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lae;"
   )
   public static final WorldMapLabelSize WorldMapLabelSize_large = new WorldMapLabelSize(2, 2, 0);
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lle;"
   )
   static IndexedSprite field160;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1219677423
   )
   static int field158;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = -1644127547
   )
   static int port1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 17541419
   )
   final int field153;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1519176047
   )
   final int field155;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 2055310893
   )
   final int field152;


   WorldMapLabelSize(int var1, int var2, int var3) {
      this.field153 = var1;
      this.field155 = var2;
      this.field152 = var3;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(FB)Z",
      garbageValue = "-55"
   )
   boolean method289(float var1) {
      return var1 >= (float)this.field152;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)[Lae;",
      garbageValue = "-1367790562"
   )
   static WorldMapLabelSize[] method284() {
      return new WorldMapLabelSize[]{WorldMapLabelSize_large, WorldMapLabelSize_medium, WorldMapLabelSize_small};
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Liy;Liy;ZI)V",
      garbageValue = "-1100564340"
   )
   public static void method290(AbstractArchive var0, AbstractArchive var1, boolean var2) {
      ObjectDefinition.ObjectDefinition_archive = var0;
      ObjectDefinition.ObjectDefinition_modelsArchive = var1;
      ObjectDefinition.ObjectDefinition_isLowDetail = var2;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ZZB)I",
      garbageValue = "98"
   )
   public static int method292(boolean var0, boolean var1) {
      byte var2 = 0;
      int var3 = var2 + NetCache.NetCache_pendingPriorityWritesCount + NetCache.NetCache_pendingPriorityResponsesCount;
      return var3;
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "723862906"
   )
   static boolean method282(int var0) {
      return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
   }

   @ObfuscatedName("jq")
   @ObfuscatedSignature(
      signature = "(Lhe;III)V",
      garbageValue = "255772747"
   )
   static void method291(Widget var0, int var1, int var2) {
      if(var0.xAlignment == 0) {
         var0.x = var0.rawX;
      } else if(var0.xAlignment == 1) {
         var0.x = var0.rawX + (var1 - var0.width) / 2;
      } else if(var0.xAlignment == 2) {
         var0.x = var1 - var0.width - var0.rawX;
      } else if(var0.xAlignment == 3) {
         var0.x = var0.rawX * var1 >> 14;
      } else if(var0.xAlignment == 4) {
         var0.x = (var0.rawX * var1 >> 14) + (var1 - var0.width) / 2;
      } else {
         var0.x = var1 - var0.width - (var0.rawX * var1 >> 14);
      }

      if(var0.yAlignment == 0) {
         var0.y = var0.rawY;
         var0.onPositionChanged(-1);
      } else if(var0.yAlignment == 1) {
         var0.y = (var2 - var0.height) / 2 + var0.rawY;
         var0.onPositionChanged(-1);
      } else if(var0.yAlignment == 2) {
         var0.y = var2 - var0.height - var0.rawY;
         var0.onPositionChanged(-1);
      } else if(var0.yAlignment == 3) {
         var0.y = var2 * var0.rawY >> 14;
         var0.onPositionChanged(-1);
      } else if(var0.yAlignment == 4) {
         var0.y = (var2 * var0.rawY >> 14) + (var2 - var0.height) / 2;
         var0.onPositionChanged(-1);
      } else {
         var0.y = var2 - var0.height - (var2 * var0.rawY >> 14);
         var0.onPositionChanged(-1);
      }

   }

   @ObfuscatedName("jj")
   @ObfuscatedSignature(
      signature = "(Lhe;III)V",
      garbageValue = "-1189563111"
   )
   static final void method288(Widget var0, int var1, int var2) {
      if(var0.buttonType == 1) {
         IgnoreList.method5136(var0.buttonText, "", 24, 0, 0, var0.id);
      }

      String var3;
      if(var0.buttonType == 2 && !Client.isSpellSelected) {
         var3 = PrivateChatMode.method5966(var0);
         if(var3 != null) {
            IgnoreList.method5136(var3, class297.method5342('\uff00') + var0.spellName, 25, 0, -1, var0.id);
         }
      }

      if(var0.buttonType == 3) {
         IgnoreList.method5136("Close", "", 26, 0, 0, var0.id);
      }

      if(var0.buttonType == 4) {
         IgnoreList.method5136(var0.buttonText, "", 28, 0, 0, var0.id);
      }

      if(var0.buttonType == 5) {
         IgnoreList.method5136(var0.buttonText, "", 29, 0, 0, var0.id);
      }

      if(var0.buttonType == 6 && Client.meslayerContinueWidget == null) {
         IgnoreList.method5136(var0.buttonText, "", 30, 0, -1, var0.id);
      }

      int var4;
      int var19;
      if(var0.type == 2) {
         var19 = 0;

         for(var4 = 0; var4 < var0.height; ++var4) {
            for(int var5 = 0; var5 < var0.width; ++var5) {
               int var6 = (var0.paddingX + 32) * var5;
               int var7 = (var0.paddingY + 32) * var4;
               if(var19 < 20) {
                  var6 += var0.inventoryXOffsets[var19];
                  var7 += var0.inventoryYOffsets[var19];
               }

               if(var1 >= var6 && var2 >= var7 && var1 < var6 + 32 && var2 < var7 + 32) {
                  Client.dragItemSlotDestination = var19;
                  RouteStrategy.field2106 = var0;
                  if(var0.itemIds[var19] > 0) {
                     label321: {
                        ItemDefinition var8 = AbstractWorldMapData.method373(var0.itemIds[var19] - 1);
                        boolean var9;
                        int var10;
                        if(Client.isItemSelected == 1) {
                           var10 = ScriptEvent.method1283(var0);
                           var9 = (var10 >> 30 & 1) != 0;
                           if(var9) {
                              if(var0.id != WorldMapSection2.selectedItemWidget || var19 != Client.selectedItemSlot) {
                                 IgnoreList.method5136("Use", Client.selectedItemName + " " + "->" + " " + class297.method5342(16748608) + var8.name, 31, var8.id, var19, var0.id);
                              }
                              break label321;
                           }
                        }

                        if(Client.isSpellSelected) {
                           var10 = ScriptEvent.method1283(var0);
                           var9 = (var10 >> 30 & 1) != 0;
                           if(var9) {
                              if((AbstractWorldMapIcon.selectedSpellFlags & 16) == 16) {
                                 IgnoreList.method5136(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + class297.method5342(16748608) + var8.name, 32, var8.id, var19, var0.id);
                              }
                              break label321;
                           }
                        }

                        String[] var20 = var8.inventoryActions;
                        var10 = -1;
                        boolean var11;
                        if(Client.shiftClickDrop) {
                           var11 = Client.tapToDrop || KeyHandler.KeyHandler_pressedKeys[81];
                           if(var11) {
                              var10 = var8.method4742(782275365);
                           }
                        }

                        int var12 = ScriptEvent.method1283(var0);
                        var11 = (var12 >> 30 & 1) != 0;
                        if(var11) {
                           for(int var13 = 4; var13 >= 3; --var13) {
                              if(var13 != var10) {
                                 ItemContainer.method1272(var0, var8, var19, var13, false);
                              }
                           }
                        }

                        int var14 = ScriptEvent.method1283(var0);
                        boolean var23 = (var14 >> 31 & 1) != 0;
                        if(var23) {
                           IgnoreList.method5136("Use", class297.method5342(16748608) + var8.name, 38, var8.id, var19, var0.id);
                        }

                        int var16 = ScriptEvent.method1283(var0);
                        boolean var15 = (var16 >> 30 & 1) != 0;
                        int var17;
                        if(var15) {
                           for(var17 = 2; var17 >= 0; --var17) {
                              if(var17 != var10) {
                                 ItemContainer.method1272(var0, var8, var19, var17, false);
                              }
                           }

                           if(var10 >= 0) {
                              ItemContainer.method1272(var0, var8, var19, var10, true);
                           }
                        }

                        var20 = var0.itemActions;
                        if(var20 != null) {
                           for(var17 = 4; var17 >= 0; --var17) {
                              if(var20[var17] != null) {
                                 byte var18 = 0;
                                 if(var17 == 0) {
                                    var18 = 39;
                                 }

                                 if(var17 == 1) {
                                    var18 = 40;
                                 }

                                 if(var17 == 2) {
                                    var18 = 41;
                                 }

                                 if(var17 == 3) {
                                    var18 = 42;
                                 }

                                 if(var17 == 4) {
                                    var18 = 43;
                                 }

                                 IgnoreList.method5136(var20[var17], class297.method5342(16748608) + var8.name, var18, var8.id, var19, var0.id);
                              }
                           }
                        }

                        IgnoreList.method5136("Examine", class297.method5342(16748608) + var8.name, 1005, var8.id, var19, var0.id);
                     }
                  }
               }

               ++var19;
            }
         }
      }

      if(var0.isIf3) {
         if(Client.isSpellSelected) {
            if(class194.method3695(ScriptEvent.method1283(var0)) && (AbstractWorldMapIcon.selectedSpellFlags & 32) == 32) {
               IgnoreList.method5136(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + var0.dataText, 58, 0, var0.childIndex, var0.id);
            }
         } else {
            for(var19 = 9; var19 >= 5; --var19) {
               String var21 = class217.method4037(var0, var19);
               if(var21 != null) {
                  IgnoreList.method5136(var21, var0.dataText, 1007, var19 + 1, var0.childIndex, var0.id);
               }
            }

            var3 = PrivateChatMode.method5966(var0);
            if(var3 != null) {
               IgnoreList.method5136(var3, var0.dataText, 25, 0, var0.childIndex, var0.id);
            }

            for(var4 = 4; var4 >= 0; --var4) {
               String var22 = class217.method4037(var0, var4);
               if(var22 != null) {
                  ScriptFrame.method1244(var22, var0.dataText, 57, var4 + 1, var0.childIndex, var0.id, var0.field2658);
               }
            }

            if(LoginScreenAnimation.method1939(ScriptEvent.method1283(var0))) {
               IgnoreList.method5136("Continue", "", 30, 0, var0.childIndex, var0.id);
            }
         }
      }

   }
}
