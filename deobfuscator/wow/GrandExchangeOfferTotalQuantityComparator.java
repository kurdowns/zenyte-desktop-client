import java.awt.Component;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;
import net.runelite.rs.api.RSGrandExchangeOfferTotalQuantityComparator;

@ObfuscatedName("a")
final class GrandExchangeOfferTotalQuantityComparator implements Comparator, RSGrandExchangeOfferTotalQuantityComparator {

   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = -591154231
   )
   static int field91;


   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Li;Li;B)I",
      garbageValue = "-105"
   )
   int method170(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.grandExchangeOffer.totalQuantity < var2.grandExchangeOffer.totalQuantity?-1:(var2.grandExchangeOffer.totalQuantity == var1.grandExchangeOffer.totalQuantity?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method170((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1200132301"
   )
   static void method179(Component var0) {
      var0.addMouseListener(MouseHandler.MouseHandler_instance);
      var0.addMouseMotionListener(MouseHandler.MouseHandler_instance);
      var0.addFocusListener(MouseHandler.MouseHandler_instance);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lkb;IS)V",
      garbageValue = "-19565"
   )
   public static void method169(Buffer var0, int var1) {
      ReflectionCheck var2 = new ReflectionCheck();
      var2.size = var0.method5575();
      var2.id = var0.method5580();
      var2.operations = new int[var2.size];
      var2.creationErrors = new int[var2.size];
      var2.fields = new Field[var2.size];
      var2.intReplaceValues = new int[var2.size];
      var2.methods = new Method[var2.size];
      var2.arguments = new byte[var2.size][][];

      for(int var3 = 0; var3 < var2.size; ++var3) {
         try {
            int var4 = var0.method5575();
            String var5;
            String var6;
            int var7;
            if(var4 != 0 && var4 != 1 && var4 != 2) {
               if(var4 == 3 || var4 == 4) {
                  var5 = var0.method5695();
                  var6 = var0.method5695();
                  var7 = var0.method5575();
                  String[] var8 = new String[var7];

                  for(int var9 = 0; var9 < var7; ++var9) {
                     var8[var9] = var0.method5695();
                  }

                  String var20 = var0.method5695();
                  byte[][] var10 = new byte[var7][];
                  int var12;
                  if(var4 == 3) {
                     for(int var11 = 0; var11 < var7; ++var11) {
                        var12 = var0.method5580();
                        var10[var11] = new byte[var12];
                        var0.method5648(var10[var11], 0, var12);
                     }
                  }

                  var2.operations[var3] = var4;
                  Class[] var21 = new Class[var7];

                  for(var12 = 0; var12 < var7; ++var12) {
                     var21[var12] = class2.method24(var8[var12]);
                  }

                  Class var22 = class2.method24(var20);
                  if(class2.method24(var5).getClassLoader() == null) {
                     throw new SecurityException();
                  }

                  Method[] var13 = class2.method24(var5).getDeclaredMethods();
                  Method[] var14 = var13;

                  for(int var15 = 0; var15 < var14.length; ++var15) {
                     Method var16 = var14[var15];
                     if(Reflection.getMethodName(var16).equals(var6)) {
                        Class[] var17 = Reflection.getParameterTypes(var16);
                        if(var21.length == var17.length) {
                           boolean var18 = true;

                           for(int var19 = 0; var19 < var21.length; ++var19) {
                              if(var17[var19] != var21[var19]) {
                                 var18 = false;
                                 break;
                              }
                           }

                           if(var18 && var22 == var16.getReturnType()) {
                              var2.methods[var3] = var16;
                           }
                        }
                     }
                  }

                  var2.arguments[var3] = var10;
               }
            } else {
               var5 = var0.method5695();
               var6 = var0.method5695();
               var7 = 0;
               if(var4 == 1) {
                  var7 = var0.method5580();
               }

               var2.operations[var3] = var4;
               var2.intReplaceValues[var3] = var7;
               if(class2.method24(var5).getClassLoader() == null) {
                  throw new SecurityException();
               }

               var2.fields[var3] = Reflection.findField(class2.method24(var5), var6);
            }
         } catch (ClassNotFoundException var24) {
            var2.creationErrors[var3] = -1;
         } catch (SecurityException var25) {
            var2.creationErrors[var3] = -2;
         } catch (NullPointerException var26) {
            var2.creationErrors[var3] = -3;
         } catch (Exception var27) {
            var2.creationErrors[var3] = -4;
         } catch (Throwable var28) {
            var2.creationErrors[var3] = -5;
         }
      }

      class105.reflectionChecks.method4883(var2);
   }

   @ObfuscatedName("ka")
   @ObfuscatedSignature(
      signature = "(Lhe;B)Lhe;",
      garbageValue = "-16"
   )
   static Widget method181(Widget var0) {
      int var1 = Canvas.method958(ScriptEvent.method1283(var0));
      if(var1 == 0) {
         return null;
      } else {
         for(int var2 = 0; var2 < var1; ++var2) {
            var0 = MusicPatchNode.method3920(var0.parentId);
            if(var0 == null) {
               return null;
            }
         }

         return var0;
      }
   }
}
