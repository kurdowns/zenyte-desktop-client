import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSClientPreferences;

@ObfuscatedName("cq")
public class ClientPreferences implements RSClientPreferences {

   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1654668565
   )
   static int ClientPreferences_optionCount = 6;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1650607601
   )
   static int clientTickTimeIdx;
   @ObfuscatedName("k")
   boolean roofsHidden;
   @ObfuscatedName("d")
   boolean titleMusicDisabled;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1989279891
   )
   int windowMode = 1;
   @ObfuscatedName("v")
   String rememberedUsername = null;
   @ObfuscatedName("q")
   boolean hideUsername = false;
   @ObfuscatedName("z")
   LinkedHashMap parameters = new LinkedHashMap();


   ClientPreferences() {
      this.method1942(true);
   }

   @ObfuscatedSignature(
      signature = "(Lkb;)V"
   )
   ClientPreferences(Buffer var1) {
      if(var1 != null && var1.array != null) {
         int var2 = var1.method5575();
         if(var2 >= 0 && var2 <= ClientPreferences_optionCount) {
            if(var1.method5575() == 1) {
               this.roofsHidden = true;
            }

            if(var2 > 1) {
               this.titleMusicDisabled = var1.method5575() == 1;
            }

            if(var2 > 3) {
               this.windowMode = var1.method5575();
            }

            if(var2 > 2) {
               int var3 = var1.method5575();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.method5580();
                  int var6 = var1.method5580();
                  this.parameters.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }

            if(var2 > 4) {
               this.rememberedUsername = var1.method5583();
            }

            if(var2 > 5) {
               this.hideUsername = var1.method5710();
            }
         } else {
            this.method1942(true);
         }
      } else {
         this.method1942(true);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1802002327"
   )
   void method1942(boolean var1) {}

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Lkb;",
      garbageValue = "745371681"
   )
   Buffer method1943() {
      Buffer var1 = new Buffer(100);
      var1.method5559(ClientPreferences_optionCount);
      var1.method5559(this.roofsHidden?1:0);
      var1.method5559(this.titleMusicDisabled?1:0);
      var1.method5559(this.windowMode);
      var1.method5559(this.parameters.size());
      Iterator var2 = this.parameters.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.method5717(((Integer)var3.getKey()).intValue());
         var1.method5717(((Integer)var3.getValue()).intValue());
      }

      var1.method5655(this.rememberedUsername != null?this.rememberedUsername:"");
      var1.method5718(this.hideUsername);
      return var1;
   }

   public String getRememberedUsername() {
      return this.rememberedUsername;
   }

   public void setRememberedUsername(String var1) {
      this.rememberedUsername = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "102"
   )
   static final void method1950(String var0) {
      GrandExchangeEvent.method165("Please remove " + var0 + " from your ignore list first");
   }
}
