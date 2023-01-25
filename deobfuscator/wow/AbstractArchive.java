import com.google.common.hash.Hashing;
import com.google.common.io.ByteStreams;
import com.google.common.io.CharStreams;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import net.runelite.api.overlay.OverlayIndex;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSAbstractArchive;
import net.runelite.rs.api.RSArchive;
import org.slf4j.Logger;

@ObfuscatedName("iy")
public abstract class AbstractArchive implements RSAbstractArchive {

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lmw;"
   )
   static GZipDecompressor gzipDecompressor = new GZipDecompressor();
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1088785149
   )
   static int field3143 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1667499623
   )
   int groupCount;
   @ObfuscatedName("k")
   int[] groupIds;
   @ObfuscatedName("d")
   int[] groupNameHashes;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lmj;"
   )
   IntHashTable groupNameHashTable;
   @ObfuscatedName("v")
   int[] groupCrcs;
   @ObfuscatedName("q")
   int[] groupVersions;
   @ObfuscatedName("z")
   int[] fileCounts;
   @ObfuscatedName("t")
   int[][] fileIds;
   @ObfuscatedName("e")
   int[][] fileNameHashes;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "[Lmj;"
   )
   IntHashTable[] fileNameHashTables;
   @ObfuscatedName("p")
   Object[] groups;
   @ObfuscatedName("n")
   Object[][] files;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1296799789
   )
   public int hash;
   @ObfuscatedName("g")
   boolean releaseGroups;
   @ObfuscatedName("i")
   boolean shallowFiles;
   public boolean overlayOutdated;


   AbstractArchive(boolean var1, boolean var2) {
      this.releaseGroups = var1;
      this.shallowFiles = var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "32768"
   )
   void method4247(byte[] var1) {
      this.hash = GrandExchangeOfferUnitPriceComparator.method225(var1, var1.length);
      Buffer var2 = new Buffer(class217.method4035(var1));
      int var3 = var2.method5575();
      if(var3 >= 5 && var3 <= 7) {
         if(var3 >= 6) {
            var2.method5580();
         }

         int var4 = var2.method5575();
         if(var3 >= 7) {
            this.groupCount = var2.method5779();
         } else {
            this.groupCount = var2.method5577();
         }

         int var5 = 0;
         int var6 = -1;
         this.groupIds = new int[this.groupCount];
         int var7;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.groupCount; ++var7) {
               this.groupIds[var7] = var5 += var2.method5779();
               if(this.groupIds[var7] > var6) {
                  var6 = this.groupIds[var7];
               }
            }
         } else {
            for(var7 = 0; var7 < this.groupCount; ++var7) {
               this.groupIds[var7] = var5 += var2.method5577();
               if(this.groupIds[var7] > var6) {
                  var6 = this.groupIds[var7];
               }
            }
         }

         this.groupCrcs = new int[var6 + 1];
         this.groupVersions = new int[var6 + 1];
         this.fileCounts = new int[var6 + 1];
         this.fileIds = new int[var6 + 1][];
         this.groups = new Object[var6 + 1];
         this.files = new Object[var6 + 1][];
         if(var4 != 0) {
            this.groupNameHashes = new int[var6 + 1];

            for(var7 = 0; var7 < this.groupCount; ++var7) {
               this.groupNameHashes[this.groupIds[var7]] = var2.method5580();
            }

            this.groupNameHashTable = new IntHashTable(this.groupNameHashes);
         }

         for(var7 = 0; var7 < this.groupCount; ++var7) {
            this.groupCrcs[this.groupIds[var7]] = var2.method5580();
         }

         for(var7 = 0; var7 < this.groupCount; ++var7) {
            this.groupVersions[this.groupIds[var7]] = var2.method5580();
         }

         for(var7 = 0; var7 < this.groupCount; ++var7) {
            this.fileCounts[this.groupIds[var7]] = var2.method5577();
         }

         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.groupCount; ++var7) {
               var8 = this.groupIds[var7];
               var9 = this.fileCounts[var8];
               var5 = 0;
               var10 = -1;
               this.fileIds[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.fileIds[var8][var11] = var5 += var2.method5779();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.files[var8] = new Object[var10 + 1];
            }
         } else {
            for(var7 = 0; var7 < this.groupCount; ++var7) {
               var8 = this.groupIds[var7];
               var9 = this.fileCounts[var8];
               var5 = 0;
               var10 = -1;
               this.fileIds[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.fileIds[var8][var11] = var5 += var2.method5577();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.files[var8] = new Object[var10 + 1];
            }
         }

         if(var4 != 0) {
            this.fileNameHashes = new int[var6 + 1][];
            this.fileNameHashTables = new IntHashTable[var6 + 1];

            for(var7 = 0; var7 < this.groupCount; ++var7) {
               var8 = this.groupIds[var7];
               var9 = this.fileCounts[var8];
               this.fileNameHashes[var8] = new int[this.files[var8].length];

               for(var10 = 0; var10 < var9; ++var10) {
                  this.fileNameHashes[var8][this.fileIds[var8][var10]] = var2.method5580();
               }

               this.fileNameHashTables[var8] = new IntHashTable(this.fileNameHashes[var8]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-11"
   )
   void vmethod4346(int var1) {}

   @ObfuscatedName("k")
   public byte[] method4249(int var1, int var2, byte var3) {
      byte[] var4 = this.copy$takeFile(var1, var2, var3);
      int var5 = ((RSArchive)this).getIndex();
      if(!OverlayIndex.hasOverlay(var5, var1)) {
         return var4;
      } else {
         Logger var6 = WorldMapSection1.client.getLogger();
         String var7 = String.format("/runelite/%s/%s", new Object[]{Integer.valueOf(var5), Integer.valueOf(var1)});
         if(var4 != null) {
            String var8;
            String var9;
            try {
               InputStream var10 = this.getClass().getResourceAsStream(var7 + ".hash");

               try {
                  var8 = CharStreams.toString(new InputStreamReader(var10));
                  var9 = Hashing.sha256().hashBytes(var4).toString();
               } catch (Throwable var15) {
                  if(var10 != null) {
                     try {
                        var10.close();
                     } catch (Throwable var13) {
                        var15.addSuppressed(var13);
                     }
                  }

                  throw var15;
               }

               if(var10 != null) {
                  var10.close();
               }
            } catch (IOException var18) {
               var6.warn("Missing overlay hash for {}/{}", Integer.valueOf(var5), Integer.valueOf(var1));
               return var4;
            }

            if(!var8.equalsIgnoreCase(var9)) {
               var6.warn("Mismatch in overlaid cache archive hash for {}/{}: {} != {}", new Object[]{Integer.valueOf(var5), Integer.valueOf(var1), var8, var9});
               this.overlayOutdated = true;
               return var4;
            }
         }

         try {
            InputStream var19 = this.getClass().getResourceAsStream(var7);

            byte[] var20;
            try {
               var20 = ByteStreams.toByteArray(var19);
            } catch (Throwable var16) {
               if(var19 != null) {
                  try {
                     var19.close();
                  } catch (Throwable var14) {
                     var16.addSuppressed(var14);
                  }
               }

               throw var16;
            }

            if(var19 != null) {
               var19.close();
            }

            return var20;
         } catch (IOException var17) {
            var6.warn("Missing overlay data for {}/{}", Integer.valueOf(var5), Integer.valueOf(var1));
            return var4;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II[II)[B",
      garbageValue = "867631074"
   )
   public byte[] method4288(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.files.length && this.files[var1] != null && var2 >= 0 && var2 < this.files[var1].length) {
         if(this.files[var1][var2] == null) {
            boolean var4 = this.method4264(var1, var3);
            if(!var4) {
               this.vmethod4347(var1);
               var4 = this.method4264(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = class39.method644(this.files[var1][var2], false);
         if(this.shallowFiles) {
            this.files[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1838243967"
   )
   public boolean method4263(int var1, int var2) {
      if(var1 >= 0 && var1 < this.files.length && this.files[var1] != null && var2 >= 0 && var2 < this.files[var1].length) {
         if(this.files[var1][var2] != null) {
            return true;
         } else if(this.groups[var1] != null) {
            return true;
         } else {
            this.vmethod4347(var1);
            return this.groups[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-700946668"
   )
   public boolean method4252(int var1) {
      if(this.files.length == 1) {
         return this.method4263(0, var1);
      } else if(this.files[var1].length == 1) {
         return this.method4263(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-121"
   )
   public boolean method4275(int var1) {
      if(this.groups[var1] != null) {
         return true;
      } else {
         this.vmethod4347(var1);
         return this.groups[var1] != null;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2004742407"
   )
   public boolean method4254() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.groupIds.length; ++var2) {
         int var3 = this.groupIds[var2];
         if(this.groups[var3] == null) {
            this.vmethod4347(var3);
            if(this.groups[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "9"
   )
   int vmethod4371(int var1) {
      return this.groups[var1] != null?100:0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "1070095083"
   )
   public byte[] method4256(int var1) {
      if(this.files.length == 1) {
         return this.method4249(0, var1, (byte)-120);
      } else if(this.files[var1].length == 1) {
         return this.method4249(var1, 0, (byte)-88);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "1361179955"
   )
   public byte[] method4257(int var1, int var2) {
      if(var1 >= 0 && var1 < this.files.length && this.files[var1] != null && var2 >= 0 && var2 < this.files[var1].length) {
         if(this.files[var1][var2] == null) {
            boolean var3 = this.method4264(var1, (int[])null);
            if(!var3) {
               this.vmethod4347(var1);
               var3 = this.method4264(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = class39.method644(this.files[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "100"
   )
   public byte[] method4250(int var1) {
      if(this.files.length == 1) {
         return this.method4257(0, var1);
      } else if(this.files[var1].length == 1) {
         return this.method4257(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-48"
   )
   void vmethod4347(int var1) {}

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-2049646423"
   )
   public int[] method4259(int var1) {
      return var1 >= 0 && var1 < this.fileIds.length?this.fileIds[var1]:null;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "26"
   )
   public int method4271(int var1) {
      return this.files[var1].length;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-30"
   )
   public int method4260() {
      return this.files.length;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "504262227"
   )
   public void method4261() {
      for(int var1 = 0; var1 < this.groups.length; ++var1) {
         this.groups[var1] = null;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1058828801"
   )
   public void method4262(int var1) {
      for(int var2 = 0; var2 < this.files[var1].length; ++var2) {
         this.files[var1][var2] = null;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "3"
   )
   public void method4298() {
      for(int var1 = 0; var1 < this.files.length; ++var1) {
         if(this.files[var1] != null) {
            for(int var2 = 0; var2 < this.files[var1].length; ++var2) {
               this.files[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I[II)Z",
      garbageValue = "1499207460"
   )
   boolean method4264(int var1, int[] var2) {
      if(this.groups[var1] == null) {
         return false;
      } else {
         int var3 = this.fileCounts[var1];
         int[] var4 = this.fileIds[var1];
         Object[] var5 = this.files[var1];
         boolean var6 = true;

         for(int var7 = 0; var7 < var3; ++var7) {
            if(var5[var4[var7]] == null) {
               var6 = false;
               break;
            }
         }

         if(var6) {
            return true;
         } else {
            byte[] var21;
            if(var2 != null && (var2[0] != 0 || var2[1] != 0 || var2[2] != 0 || var2[3] != 0)) {
               var21 = class39.method644(this.groups[var1], true);
               Buffer var8 = new Buffer(var21);
               var8.method5755(var2, 5, var8.array.length);
            } else {
               var21 = class39.method644(this.groups[var1], false);
            }

            byte[] var25 = class217.method4035(var21);
            if(this.releaseGroups) {
               this.groups[var1] = null;
            }

            int var10;
            if(var3 > 1) {
               int var9 = var25.length;
               --var9;
               var10 = var25[var9] & 255;
               var9 -= var3 * var10 * 4;
               Buffer var11 = new Buffer(var25);
               int[] var12 = new int[var3];
               var11.offset = var9;

               int var14;
               int var15;
               for(int var13 = 0; var13 < var10; ++var13) {
                  var14 = 0;

                  for(var15 = 0; var15 < var3; ++var15) {
                     var14 += var11.method5580();
                     var12[var15] += var14;
                  }
               }

               byte[][] var23 = new byte[var3][];

               for(var14 = 0; var14 < var3; ++var14) {
                  var23[var14] = new byte[var12[var14]];
                  var12[var14] = 0;
               }

               var11.offset = var9;
               var14 = 0;

               int var17;
               for(var15 = 0; var15 < var10; ++var15) {
                  int var16 = 0;

                  for(var17 = 0; var17 < var3; ++var17) {
                     var16 += var11.method5580();
                     System.arraycopy(var25, var14, var23[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var14 += var16;
                  }
               }

               for(var15 = 0; var15 < var3; ++var15) {
                  if(!this.shallowFiles) {
                     var17 = var4[var15];
                     byte[] var19 = var23[var15];
                     Object var18;
                     if(var19 == null) {
                        var18 = null;
                     } else if(var19.length > 136) {
                        DirectByteArrayCopier var20 = new DirectByteArrayCopier();
                        var20.vmethod4028(var19);
                        var18 = var20;
                     } else {
                        var18 = var19;
                     }

                     var5[var17] = var18;
                  } else {
                     var5[var4[var15]] = var23[var15];
                  }
               }
            } else if(!this.shallowFiles) {
               var10 = var4[0];
               Object var26;
               if(var25 == null) {
                  var26 = null;
               } else if(var25.length > 136) {
                  DirectByteArrayCopier var27 = new DirectByteArrayCopier();
                  var27.vmethod4028(var25);
                  var26 = var27;
               } else {
                  var26 = var25;
               }

               var5[var10] = var26;
            } else {
               var5[var4[0]] = var25;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)I",
      garbageValue = "20025"
   )
   public int method4265(String var1) {
      var1 = var1.toLowerCase();
      return this.groupNameHashTable.method6634(HealthBarDefinition.method4558(var1));
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)I",
      garbageValue = "709668582"
   )
   public int method4258(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.fileNameHashTables[var1].method6634(HealthBarDefinition.method4558(var2));
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "1971024882"
   )
   public boolean method4324(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.groupNameHashTable.method6634(HealthBarDefinition.method4558(var1));
      if(var3 < 0) {
         return false;
      } else {
         int var4 = this.fileNameHashTables[var3].method6634(HealthBarDefinition.method4558(var2));
         return var4 >= 0;
      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)[B",
      garbageValue = "-1226254785"
   )
   public byte[] method4248(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.groupNameHashTable.method6634(HealthBarDefinition.method4558(var1));
      int var4 = this.fileNameHashTables[var3].method6634(HealthBarDefinition.method4558(var2));
      return this.method4249(var3, var4, (byte)-55);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "-612487532"
   )
   public boolean method4266(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.groupNameHashTable.method6634(HealthBarDefinition.method4558(var1));
      int var4 = this.fileNameHashTables[var3].method6634(HealthBarDefinition.method4558(var2));
      return this.method4263(var3, var4);
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)Z",
      garbageValue = "5353"
   )
   public boolean method4270(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.groupNameHashTable.method6634(HealthBarDefinition.method4558(var1));
      return this.method4275(var2);
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "904314096"
   )
   public void method4285(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.groupNameHashTable.method6634(HealthBarDefinition.method4558(var1));
      if(var2 >= 0) {
         this.vmethod4346(var2);
      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "-63"
   )
   public int method4286(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.groupNameHashTable.method6634(HealthBarDefinition.method4558(var1));
      return this.vmethod4371(var2);
   }

   public byte[] copy$takeFile(int var1, int var2, byte var3) {
      return this.method4288(var1, var2, (int[])null);
   }

   public boolean isOverlayOutdated() {
      return this.overlayOutdated;
   }

   public byte[] getConfigData(int var1, int var2) {
      return this.method4249(var1, var2, (byte)-30);
   }
}
