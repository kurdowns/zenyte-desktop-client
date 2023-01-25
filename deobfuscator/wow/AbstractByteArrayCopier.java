import net.runelite.api.events.MenuOptionClicked;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSAbstractByteArrayCopier;

@ObfuscatedName("hi")
public abstract class AbstractByteArrayCopier implements RSAbstractByteArrayCopier {

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1422436059"
   )
   abstract byte[] vmethod4030();

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "0"
   )
   public abstract void vmethod4028(byte[] var1);

   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-411552883"
   )
   static final void method4026(String var0, boolean var1) {
      if(Client.showLoadingMessages) {
         byte var2 = 4;
         int var3 = var2 + 6;
         int var4 = var2 + 6;
         int var5 = WorldMapData_0.fontPlain12.method5414(var0, 250);
         int var6 = WorldMapData_0.fontPlain12.method5482(var0, 250) * 13;
         Rasterizer2D.method6092(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var2 + var6, 0);
         Rasterizer2D.method6177(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 16777215);
         WorldMapData_0.fontPlain12.method5425(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
         int var7 = var3 - var2;
         int var8 = var4 - var2;
         int var9 = var2 + var5 + var2;
         int var10 = var2 + var6 + var2;

         for(int var11 = 0; var11 < Client.rootWidgetCount; ++var11) {
            if(Client.rootWidgetWidths[var11] + Client.rootWidgetXs[var11] > var7 && Client.rootWidgetXs[var11] < var9 + var7 && Client.rootWidgetHeights[var11] + Client.rootWidgetYs[var11] > var8 && Client.rootWidgetYs[var11] < var10 + var8) {
               Client.field679[var11] = true;
            }
         }

         if(var1) {
            class206.rasterProvider.vmethod6179(0, 0);
         } else {
            WorldMapScaleHandler.method848(var3, var4, var5, var6);
         }

      }
   }

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1582432822"
   )
   static void method4024() {
      Client.menuOptionsCount = 0;
      Client.onMenuOptionsChanged(-1);
      Client.isMenuOpen = false;
   }

   @ObfuscatedName("ij")
   static final void method4027(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7, int var8) {
      boolean var9 = true;
      if(var5 != null && var5.startsWith("!AUTHENTIC")) {
         var9 = false;
         var5 = var5.substring(10);
      }

      if(Client.printMenuActions && WorldMapSection1.client.getLogger().isDebugEnabled()) {
         WorldMapSection1.client.getLogger().debug("|MenuAction|: MenuOption={} MenuTarget={} Id={} Opcode={} Param0={} Param1={} CanvasX={} CanvasY={} Authentic={}", new Object[]{var4, var5, Integer.valueOf(var3), Integer.valueOf(var2), Integer.valueOf(var0), Integer.valueOf(var1), Integer.valueOf(var6), Integer.valueOf(var7), Boolean.valueOf(var9)});
      }

      if(var2 >= 2000) {
         var2 -= 2000;
      }

      MenuOptionClicked var10 = new MenuOptionClicked(var4, var5, var3, var2, var0, var1, false, var9, WorldMapSection1.client.getMouseCurrentButton());
      WorldMapSection1.client.getCallbacks().post(MenuOptionClicked.class, var10);
      if(!var10.isConsumed()) {
         Client.copy$menuAction(var10.getParam0(), var10.getParam1(), var10.getOpcode(), var10.getIdentifier(), var10.getOption(), var10.getTarget(), var6, var7, var8);
      }
   }
}
