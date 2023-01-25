import java.text.DecimalFormat;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSLogin;

@ObfuscatedName("cy")
public class Login implements RSLogin {

   @ObfuscatedName("m")
   static boolean clearLoginScreen;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1204959409
   )
   static int xPadding = 0;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "[Lle;"
   )
   static IndexedSprite[] runesSprite;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lla;"
   )
   static Sprite leftTitleSprite;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lle;"
   )
   static IndexedSprite options_buttons_2Sprite;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lle;"
   )
   static IndexedSprite field1195;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 677991921
   )
   static int loginBoxX = xPadding + 202;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 351147085
   )
   static int Login_loadingPercent = 10;
   @ObfuscatedName("c")
   static String Login_loadingText = "";
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 811959291
   )
   static int field1201 = -1;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1263209859
   )
   static int field1218 = 1;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1027214845
   )
   static int loginIndex = 0;
   @ObfuscatedName("au")
   static String Login_response0 = "";
   @ObfuscatedName("ao")
   static String Login_response1 = "";
   @ObfuscatedName("aq")
   static String Login_response2 = "";
   @ObfuscatedName("av")
   static String Login_response3 = "";
   @ObfuscatedName("ak")
   static String Login_username = "";
   @ObfuscatedName("aa")
   static String Login_password = "";
   @ObfuscatedName("ah")
   static boolean field1207 = false;
   @ObfuscatedName("ag")
   static boolean field1212 = false;
   @ObfuscatedName("bc")
   static boolean field1214 = true;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 463020899
   )
   static int currentLoginField = 0;
   @ObfuscatedName("be")
   static boolean worldSelectOpen = false;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = 1533382117
   )
   static int hoveredWorldIndex = -1;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 623076751
   )
   static int worldSelectPage = 0;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 1665656509
   )
   static int worldSelectPagesCount = 0;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      longValue = 7899458563171084207L
   )
   static long field1223;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      longValue = -6287034345881583105L
   )
   static long field1224;


   static {
      new DecimalFormat("##0.00");
      new class171();
      field1223 = -1L;
      field1224 = -1L;
   }

   @ObfuscatedName("lo")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2118716971"
   )
   static void method2177() {
      if(WorldMapRectangle.field222 != null) {
         Client.field891 = Client.cycle;
         WorldMapRectangle.field222.method4407();

         for(int var0 = 0; var0 < Client.players.length; ++var0) {
            if(Client.players[var0] != null) {
               WorldMapRectangle.field222.method4406(class69.baseX * 64 + (Client.players[var0].x >> 7), class89.baseY * 64 + (Client.players[var0].y >> 7));
            }
         }
      }

   }
}
