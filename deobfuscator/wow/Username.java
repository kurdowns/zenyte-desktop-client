import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSUsername;

@ObfuscatedName("ku")
public class Username implements Comparable, RSUsername {

   @ObfuscatedName("x")
   String name;
   @ObfuscatedName("m")
   String cleanName;


   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Lmx;)V"
   )
   public Username(String var1, LoginType var2) {
      this.name = var1;
      String var4;
      if(var1 == null) {
         var4 = null;
      } else {
         int var5 = 0;

         int var6;
         boolean var7;
         char var8;
         for(var6 = var1.length(); var5 < var6; ++var5) {
            var8 = var1.charAt(var5);
            var7 = var8 == 160 || var8 == 32 || var8 == 95 || var8 == 45;
            if(!var7) {
               break;
            }
         }

         while(var6 > var5) {
            var8 = var1.charAt(var6 - 1);
            var7 = var8 == 160 || var8 == 32 || var8 == 95 || var8 == 45;
            if(!var7) {
               break;
            }

            --var6;
         }

         int var17 = var6 - var5;
         if(var17 >= 1 && var17 <= class228.method4206(var2)) {
            StringBuilder var15 = new StringBuilder(var17);

            for(int var9 = var5; var9 < var6; ++var9) {
               char var10 = var1.charAt(var9);
               boolean var11;
               if(Character.isISOControl(var10)) {
                  var11 = false;
               } else if(AbstractWorldMapIcon.method684(var10)) {
                  var11 = true;
               } else {
                  char[] var16 = class348.field4062;
                  int var13 = 0;

                  label90:
                  while(true) {
                     char var14;
                     if(var13 >= var16.length) {
                        var16 = class348.field4063;

                        for(var13 = 0; var13 < var16.length; ++var13) {
                           var14 = var16[var13];
                           if(var14 == var10) {
                              var11 = true;
                              break label90;
                           }
                        }

                        var11 = false;
                        break;
                     }

                     var14 = var16[var13];
                     if(var14 == var10) {
                        var11 = true;
                        break;
                     }

                     ++var13;
                  }
               }

               if(var11) {
                  char var12;
                  switch(var10) {
                  case 32:
                  case 45:
                  case 95:
                  case 160:
                     var12 = 95;
                     break;
                  case 35:
                  case 91:
                  case 93:
                     var12 = var10;
                     break;
                  case 192:
                  case 193:
                  case 194:
                  case 195:
                  case 196:
                  case 224:
                  case 225:
                  case 226:
                  case 227:
                  case 228:
                     var12 = 97;
                     break;
                  case 199:
                  case 231:
                     var12 = 99;
                     break;
                  case 200:
                  case 201:
                  case 202:
                  case 203:
                  case 232:
                  case 233:
                  case 234:
                  case 235:
                     var12 = 101;
                     break;
                  case 205:
                  case 206:
                  case 207:
                  case 237:
                  case 238:
                  case 239:
                     var12 = 105;
                     break;
                  case 209:
                  case 241:
                     var12 = 110;
                     break;
                  case 210:
                  case 211:
                  case 212:
                  case 213:
                  case 214:
                  case 242:
                  case 243:
                  case 244:
                  case 245:
                  case 246:
                     var12 = 111;
                     break;
                  case 217:
                  case 218:
                  case 219:
                  case 220:
                  case 249:
                  case 250:
                  case 251:
                  case 252:
                     var12 = 117;
                     break;
                  case 223:
                     var12 = 98;
                     break;
                  case 255:
                  case 376:
                     var12 = 121;
                     break;
                  default:
                     var12 = Character.toLowerCase(var10);
                  }

                  if(var12 != 0) {
                     var15.append(var12);
                  }
               }
            }

            if(var15.length() == 0) {
               var4 = null;
            } else {
               var4 = var15.toString();
            }
         } else {
            var4 = null;
         }
      }

      this.cleanName = var4;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-239023194"
   )
   public String method5263() {
      return this.name;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1005152425"
   )
   public boolean method5264() {
      return this.cleanName != null;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lku;B)I",
      garbageValue = "-36"
   )
   public int method5265(Username var1) {
      return this.cleanName == null?(var1.cleanName == null?0:1):(var1.cleanName == null?-1:this.cleanName.compareTo(var1.cleanName));
   }

   public boolean equals(Object var1) {
      if(var1 instanceof Username) {
         Username var2 = (Username)var1;
         return this.cleanName == null?var2.cleanName == null:(var2.cleanName == null?false:(this.hashCode() != var2.hashCode()?false:this.cleanName.equals(var2.cleanName)));
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.cleanName == null?0:this.cleanName.hashCode();
   }

   public String toString() {
      return this.method5263();
   }

   public int compareTo(Object var1) {
      return this.method5265((Username)var1);
   }

   public String getName() {
      return this.method5263();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Liy;Ljava/lang/String;Ljava/lang/String;B)[Lle;",
      garbageValue = "93"
   )
   public static IndexedSprite[] method5272(AbstractArchive var0, String var1, String var2) {
      int var3 = var0.method4265(var1);
      int var4 = var0.method4258(var3, var2);
      IndexedSprite[] var5;
      if(!UserComparator7.method3517(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = Skills.method4215();
      }

      return var5;
   }
}
