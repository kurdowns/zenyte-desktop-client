import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSIgnoreList;

@ObfuscatedName("jb")
public class IgnoreList extends UserList implements RSIgnoreList {

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   static Language clientLanguage;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lmx;"
   )
   final LoginType loginType;


   @ObfuscatedSignature(
      signature = "(Lmx;)V"
   )
   public IgnoreList(LoginType var1) {
      super(400);
      this.loginType = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Ljd;",
      garbageValue = "-1332552421"
   )
   User vmethod5297() {
      return new Ignored();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)[Ljd;",
      garbageValue = "-667029686"
   )
   User[] vmethod5309(int var1) {
      return new Ignored[var1];
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lkb;II)V",
      garbageValue = "1156120193"
   )
   public void method5137(Buffer var1, int var2) {
      while(true) {
         if(var1.offset < var2) {
            int var3 = var1.method5575();
            boolean var4 = (var3 & 1) == 1;
            Username var5 = new Username(var1.method5695(), this.loginType);
            Username var6 = new Username(var1.method5695(), this.loginType);
            var1.method5695();
            if(var5 != null && var5.method5264()) {
               Ignored var7 = (Ignored)this.method5144(var5);
               if(var4) {
                  Ignored var8 = (Ignored)this.method5144(var6);
                  if(var8 != null && var8 != var7) {
                     if(var7 != null) {
                        this.method5220(var8);
                     } else {
                        var7 = var8;
                     }
                  }
               }

               if(var7 != null) {
                  this.method5152(var7, var5, var6);
                  continue;
               }

               if(this.method5140() < 400) {
                  int var9 = this.method5140();
                  var7 = (Ignored)this.method5209(var5, var6);
                  var7.id = var9;
               }
               continue;
            }

            throw new IllegalStateException();
         }

         return;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)Lis;",
      garbageValue = "44"
   )
   public static ParamDefinition method5135(int var0) {
      ParamDefinition var1 = (ParamDefinition)ParamDefinition.ParamDefinition_cached.method3432((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ParamDefinition.ParamDefinition_archive.method4249(11, var0, (byte)-92);
         var1 = new ParamDefinition();
         if(var2 != null) {
            var1.method4582(new Buffer(var2));
         }

         var1.method4572();
         ParamDefinition.ParamDefinition_cached.method3438(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(ILce;ZI)I",
      garbageValue = "-372062346"
   )
   static int method5131(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 6600) {
         var3 = ScriptEvent.Client_plane;
         int var9 = class69.baseX * 64 + (ByteArrayPool.localPlayer.x >> 7);
         int var5 = class89.baseY * 64 + (ByteArrayPool.localPlayer.y >> 7);
         class13.method133().method6527(var3, var9, var5, true);
         return 1;
      } else {
         WorldMapArea var11;
         if(var0 == 6601) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            String var16 = "";
            var11 = class13.method133().method6474(var3);
            if(var11 != null) {
               var16 = var11.method450();
            }

            Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var16;
            return 1;
         } else if(var0 == 6602) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            class13.method133().method6505(var3);
            return 1;
         } else if(var0 == 6603) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class13.method133().method6445();
            return 1;
         } else if(var0 == 6604) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            class13.method133().method6442(var3);
            return 1;
         } else if(var0 == 6605) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class13.method133().method6447()?1:0;
            return 1;
         } else {
            Coord var15;
            if(var0 == 6606) {
               var15 = new Coord(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
               class13.method133().method6477(var15.x, var15.y);
               return 1;
            } else if(var0 == 6607) {
               var15 = new Coord(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
               class13.method133().method6498(var15.x, var15.y);
               return 1;
            } else if(var0 == 6608) {
               var15 = new Coord(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
               class13.method133().method6450(var15.plane, var15.x, var15.y);
               return 1;
            } else if(var0 == 6609) {
               var15 = new Coord(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
               class13.method133().method6451(var15.plane, var15.x, var15.y);
               return 1;
            } else if(var0 == 6610) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class13.method133().method6452();
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class13.method133().method6448();
               return 1;
            } else {
               WorldMapArea var13;
               if(var0 == 6611) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var13 = class13.method133().method6474(var3);
                  if(var13 == null) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                  } else {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var13.method460().method4065();
                  }

                  return 1;
               } else if(var0 == 6612) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var13 = class13.method133().method6474(var3);
                  if(var13 == null) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                  } else {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (var13.method454() - var13.method453() + 1) * 64;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (var13.method442() - var13.method439() + 1) * 64;
                  }

                  return 1;
               } else if(var0 == 6613) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var13 = class13.method133().method6474(var3);
                  if(var13 == null) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                  } else {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var13.method453() * 64;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var13.method439() * 64;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var13.method454() * 64 + 64 - 1;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var13.method442() * 64 + 64 - 1;
                  }

                  return 1;
               } else if(var0 == 6614) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var13 = class13.method133().method6474(var3);
                  if(var13 == null) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                  } else {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var13.method452();
                  }

                  return 1;
               } else if(var0 == 6615) {
                  var15 = class13.method133().method6454();
                  if(var15 == null) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                  } else {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var15.x;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var15.y;
                  }

                  return 1;
               } else if(var0 == 6616) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class13.method133().method6433();
                  return 1;
               } else if(var0 == 6617) {
                  var15 = new Coord(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
                  var13 = class13.method133().method6570();
                  if(var13 == null) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                     return 1;
                  } else {
                     int[] var14 = var13.method444(var15.plane, var15.x, var15.y);
                     if(var14 == null) {
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                     } else {
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var14[0];
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var14[1];
                     }

                     return 1;
                  }
               } else {
                  Coord var7;
                  if(var0 == 6618) {
                     var15 = new Coord(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
                     var13 = class13.method133().method6570();
                     if(var13 == null) {
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                        return 1;
                     } else {
                        var7 = var13.method456(var15.x, var15.y);
                        if(var7 == null) {
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                        } else {
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7.method4065();
                        }

                        return 1;
                     }
                  } else {
                     Coord var12;
                     if(var0 == 6619) {
                        Interpreter.Interpreter_intStackSize -= 2;
                        var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                        var12 = new Coord(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
                        class3.method57(var3, var12, false);
                        return 1;
                     } else if(var0 == 6620) {
                        Interpreter.Interpreter_intStackSize -= 2;
                        var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                        var12 = new Coord(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
                        class3.method57(var3, var12, true);
                        return 1;
                     } else if(var0 == 6621) {
                        Interpreter.Interpreter_intStackSize -= 2;
                        var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                        var12 = new Coord(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
                        var11 = class13.method133().method6474(var3);
                        if(var11 == null) {
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                           return 1;
                        } else {
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var11.method468(var12.plane, var12.x, var12.y)?1:0;
                           return 1;
                        }
                     } else if(var0 == 6622) {
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class13.method133().method6455();
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class13.method133().method6456();
                        return 1;
                     } else if(var0 == 6623) {
                        var15 = new Coord(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
                        var13 = class13.method133().method6430(var15.plane, var15.x, var15.y);
                        if(var13 == null) {
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                        } else {
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var13.method441();
                        }

                        return 1;
                     } else if(var0 == 6624) {
                        class13.method133().method6457(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
                        return 1;
                     } else if(var0 == 6625) {
                        class13.method133().method6438();
                        return 1;
                     } else if(var0 == 6626) {
                        class13.method133().method6622(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
                        return 1;
                     } else if(var0 == 6627) {
                        class13.method133().method6460();
                        return 1;
                     } else {
                        boolean var10;
                        if(var0 == 6628) {
                           var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
                           class13.method133().method6461(var10);
                           return 1;
                        } else if(var0 == 6629) {
                           var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                           class13.method133().method6462(var3);
                           return 1;
                        } else if(var0 == 6630) {
                           var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                           class13.method133().method6463(var3);
                           return 1;
                        } else if(var0 == 6631) {
                           class13.method133().method6458();
                           return 1;
                        } else if(var0 == 6632) {
                           var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
                           class13.method133().method6435(var10);
                           return 1;
                        } else {
                           boolean var4;
                           if(var0 == 6633) {
                              Interpreter.Interpreter_intStackSize -= 2;
                              var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                              var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1] == 1;
                              class13.method133().method6531(var3, var4);
                              return 1;
                           } else if(var0 == 6634) {
                              Interpreter.Interpreter_intStackSize -= 2;
                              var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                              var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1] == 1;
                              class13.method133().method6464(var3, var4);
                              return 1;
                           } else if(var0 == 6635) {
                              Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class13.method133().method6503()?1:0;
                              return 1;
                           } else if(var0 == 6636) {
                              var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                              Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class13.method133().method6469(var3)?1:0;
                              return 1;
                           } else if(var0 == 6637) {
                              var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                              Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class13.method133().method6470(var3)?1:0;
                              return 1;
                           } else if(var0 == 6638) {
                              Interpreter.Interpreter_intStackSize -= 2;
                              var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                              var12 = new Coord(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
                              var7 = class13.method133().method6473(var3, var12);
                              if(var7 == null) {
                                 Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                              } else {
                                 Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7.method4065();
                              }

                              return 1;
                           } else {
                              AbstractWorldMapIcon var8;
                              if(var0 == 6639) {
                                 var8 = class13.method133().method6475();
                                 if(var8 == null) {
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                                 } else {
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var8.vmethod685();
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var8.coord2.method4065();
                                 }

                                 return 1;
                              } else if(var0 == 6640) {
                                 var8 = class13.method133().method6476();
                                 if(var8 == null) {
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                                 } else {
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var8.vmethod685();
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var8.coord2.method4065();
                                 }

                                 return 1;
                              } else {
                                 WorldMapElement var6;
                                 if(var0 == 6693) {
                                    var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                                    var6 = class25.method279(var3);
                                    if(var6.name == null) {
                                       Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                                    } else {
                                       Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var6.name;
                                    }

                                    return 1;
                                 } else if(var0 == 6694) {
                                    var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                                    var6 = class25.method279(var3);
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6.textSize;
                                    return 1;
                                 } else if(var0 == 6695) {
                                    var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                                    var6 = class25.method279(var3);
                                    if(var6 == null) {
                                       Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                                    } else {
                                       Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6.category;
                                    }

                                    return 1;
                                 } else if(var0 == 6696) {
                                    var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                                    var6 = class25.method279(var3);
                                    if(var6 == null) {
                                       Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                                    } else {
                                       Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6.sprite1;
                                    }

                                    return 1;
                                 } else if(var0 == 6697) {
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = TileItem.worldMapEvent.mapElement;
                                    return 1;
                                 } else if(var0 == 6698) {
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = TileItem.worldMapEvent.coord1.method4065();
                                    return 1;
                                 } else if(var0 == 6699) {
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = TileItem.worldMapEvent.coord2.method4065();
                                    return 1;
                                 } else {
                                    return 2;
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

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIIB)V",
      garbageValue = "114"
   )
   public static final void method5136(String var0, String var1, int var2, int var3, int var4, int var5) {
      ScriptFrame.method1244(var0, var1, var2, var3, var4, var5, false);
   }
}
