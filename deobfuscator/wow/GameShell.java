import java.applet.Applet;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.ImageObserver;
import java.lang.management.GarbageCollectorMXBean;
import java.net.URL;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.hooks.DrawCallbacks;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSGameShell;

@ObfuscatedName("br")
public abstract class GameShell extends Applet implements Runnable, FocusListener, WindowListener, RSGameShell {

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lbr;"
   )
   static GameShell gameShell = null;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1209606099
   )
   static int GameShell_redundantStartThreadCount = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = -6369657706537563035L
   )
   static long stopTimeMs = 0L;
   @ObfuscatedName("q")
   static boolean isKilled = false;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -513334835
   )
   static int cycleDurationMillis = 20;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -906950437
   )
   static int fiveOrOne = 1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1495509389
   )
   protected static int fps = 0;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lfb;"
   )
   protected static Clock clock;
   @ObfuscatedName("h")
   protected static long[] graphicsTickTimes = new long[32];
   @ObfuscatedName("i")
   protected static long[] clientTickTimes = new long[32];
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1546513763
   )
   static int field491 = 500;
   @ObfuscatedName("az")
   static volatile boolean volatileFocus = true;
   @ObfuscatedName("aj")
   protected static boolean hasFocus;
   @ObfuscatedName("ay")
   static GarbageCollectorMXBean garbageCollector;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      longValue = -1164491573273793773L
   )
   static long garbageCollectorLastCollectionTime = -1L;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      longValue = 6497847362101811913L
   )
   static long garbageCollectorLastCheckTimeMs = -1L;
   @ObfuscatedName("z")
   boolean hasErrored = false;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1556533671
   )
   protected int contentWidth;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1571730911
   )
   protected int contentHeight;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1057349717
   )
   int canvasX = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -198261897
   )
   int canvasY = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 347663265
   )
   int field475;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 618283515
   )
   int field488;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1006498509
   )
   int maxCanvasWidth;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -654124145
   )
   int maxCanvasHeight;
   @ObfuscatedName("ar")
   Frame frame;
   @ObfuscatedName("af")
   java.awt.Canvas canvas;
   @ObfuscatedName("at")
   volatile boolean field493 = true;
   @ObfuscatedName("am")
   boolean resizeCanvasNextFrame = false;
   @ObfuscatedName("au")
   volatile boolean isCanvasInvalid = false;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      longValue = 496005376701536871L
   )
   volatile long field497;
   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "Lbc;"
   )
   MouseWheelHandler mouseWheelHandler;
   @ObfuscatedName("aa")
   Clipboard clipboard;
   @ObfuscatedName("ax")
   final EventQueue eventQueue;
   public Thread thread;


   protected GameShell() {
      this.onReplaceCanvasNextFrameChanged(-1);
      this.field497 = 0L;
      EventQueue var1 = null;

      try {
         var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var3) {
         ;
      }

      this.eventQueue = var1;
      ReflectionCheck.method2397(new DevicePcmPlayerProvider());
   }

   @ObfuscatedName("v")
   protected final void method1017(int var1, int var2, int var3) {
      if(!WorldMapSection1.client.isStretchedEnabled() || !WorldMapSection1.client.isResized()) {
         this.copy$setMaxCanvasSize(var1, var2, var3);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;I)V",
      garbageValue = "2088668403"
   )
   final void method1018(Object var1) {
      this.onPost(var1);
      if(this.eventQueue != null) {
         for(int var2 = 0; var2 < 50 && this.eventQueue.peekEvent() != null; ++var2) {
            class169.method3542(1L);
         }

         if(var1 != null) {
            this.eventQueue.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Lfq;",
      garbageValue = "-2143582784"
   )
   protected MouseWheel method1019() {
      if(this.mouseWheelHandler == null) {
         this.mouseWheelHandler = new MouseWheelHandler();
         this.mouseWheelHandler.method906(this.canvas);
      }

      return this.mouseWheelHandler;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "9"
   )
   protected void method1042() {
      this.clipboard = this.getToolkit().getSystemClipboard();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-639881287"
   )
   protected void method1021(String var1) {
      this.clipboard.setContents(new StringSelection(var1), (ClipboardOwner)null);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1901343027"
   )
   protected final void method1071() {
      Language.method3745();
      java.awt.Canvas var1 = this.canvas;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(KeyHandler.KeyHandler_instance);
      var1.addFocusListener(KeyHandler.KeyHandler_instance);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   protected final void method1059() {
      GrandExchangeOfferTotalQuantityComparator.method179(this.canvas);
   }

   @ObfuscatedName("n")
   final void method1024(byte var1) {
      if(WorldMapSection1.client.isStretchedEnabled()) {
         WorldMapSection1.client.invalidateStretching(false);
         if(WorldMapSection1.client.isResized()) {
            Dimension var2 = WorldMapSection1.client.getRealDimensions();
            this.setMaxCanvasWidth(var2.width);
            this.setMaxCanvasHeight(var2.height);
         }
      }

      this.copy$resizeCanvas(var1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "108"
   )
   protected abstract void vmethod1411();

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1120637323"
   )
   void method1026() {
      int var1 = this.canvasX;
      int var2 = this.canvasY;
      int var3 = this.contentWidth - WorldMapLabel.canvasWidth - var1;
      int var4 = this.contentHeight - Varps.canvasHeight - var2;
      if(var1 > 0 || var3 > 0 || var2 > 0 || var4 > 0) {
         try {
            Container var5 = this.method1050();
            int var6 = 0;
            int var7 = 0;
            if(var5 == this.frame) {
               Insets var8 = this.frame.getInsets();
               var6 = var8.left;
               var7 = var8.top;
            }

            Graphics var10 = var5.getGraphics();
            var10.setColor(Color.black);
            if(var1 > 0) {
               var10.fillRect(var6, var7, var1, this.contentHeight);
            }

            if(var2 > 0) {
               var10.fillRect(var6, var7, this.contentWidth, var2);
            }

            if(var3 > 0) {
               var10.fillRect(var6 + this.contentWidth - var3, var7, var3, this.contentHeight);
            }

            if(var4 > 0) {
               var10.fillRect(var6, var7 + this.contentHeight - var4, this.contentWidth, var4);
            }
         } catch (Exception var9) {
            ;
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-19"
   )
   final void method1087() {
      java.awt.Canvas var1 = this.canvas;
      var1.removeKeyListener(KeyHandler.KeyHandler_instance);
      var1.removeFocusListener(KeyHandler.KeyHandler_instance);
      KeyHandler.field429 = -1;
      class329.method6081(this.canvas);
      if(this.mouseWheelHandler != null) {
         this.mouseWheelHandler.method907(this.canvas);
      }

      this.method1029();
      java.awt.Canvas var2 = this.canvas;
      var2.setFocusTraversalKeysEnabled(false);
      var2.addKeyListener(KeyHandler.KeyHandler_instance);
      var2.addFocusListener(KeyHandler.KeyHandler_instance);
      GrandExchangeOfferTotalQuantityComparator.method179(this.canvas);
      if(this.mouseWheelHandler != null) {
         this.mouseWheelHandler.method906(this.canvas);
      }

      this.method1100();
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1396193082"
   )
   protected final void method1028(int var1, int var2, int var3) {
      try {
         if(gameShell != null) {
            ++GameShell_redundantStartThreadCount;
            if(GameShell_redundantStartThreadCount >= 3) {
               this.method1120("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         gameShell = this;
         WorldMapLabel.canvasWidth = var1;
         Client.canvasWidthChanged(-1);
         Varps.canvasHeight = var2;
         Client.canvasHeightChanged(-1);
         RunException.RunException_revision = var3;
         RunException.RunException_applet = this;
         if(class227.taskHandler == null) {
            class227.taskHandler = new TaskHandler();
         }

         class227.taskHandler.method3566(this, 1);
      } catch (Exception var5) {
         WorldMapDecorationType.method4214((String)null, var5);
         this.method1120("crash");
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   final synchronized void method1029() {
      Container var1 = this.method1050();
      if(this.canvas != null) {
         this.canvas.removeFocusListener(this);
         var1.remove(this.canvas);
      }

      WorldMapLabel.canvasWidth = Math.max(var1.getWidth(), this.field475);
      Client.canvasWidthChanged(-1);
      Varps.canvasHeight = Math.max(var1.getHeight(), this.field488);
      Client.canvasHeightChanged(-1);
      Insets var2;
      if(this.frame != null) {
         var2 = this.frame.getInsets();
         WorldMapLabel.canvasWidth -= var2.left + var2.right;
         Client.canvasWidthChanged(-1);
         Varps.canvasHeight -= var2.bottom + var2.top;
         Client.canvasHeightChanged(-1);
      }

      this.canvas = new Canvas(this);
      var1.setBackground(Color.BLACK);
      var1.setLayout((LayoutManager)null);
      var1.add(this.canvas);
      this.canvas.setSize(WorldMapLabel.canvasWidth, Varps.canvasHeight);
      this.canvas.setVisible(true);
      this.canvas.setBackground(Color.BLACK);
      if(var1 == this.frame) {
         var2 = this.frame.getInsets();
         this.canvas.setLocation(this.canvasX + var2.left, var2.top + this.canvasY);
      } else {
         this.canvas.setLocation(this.canvasX, this.canvasY);
      }

      this.canvas.addFocusListener(this);
      this.canvas.requestFocus();
      this.field493 = true;
      if(class206.rasterProvider != null && WorldMapLabel.canvasWidth == class206.rasterProvider.width && Varps.canvasHeight == class206.rasterProvider.height) {
         ((RasterProvider)class206.rasterProvider).method1001(this.canvas);
         class206.rasterProvider.vmethod6179(0, 0);
      } else {
         class206.rasterProvider = new RasterProvider(WorldMapLabel.canvasWidth, Varps.canvasHeight, this.canvas);
      }

      this.isCanvasInvalid = false;
      this.onReplaceCanvasNextFrameChanged(-1);
      this.field497 = class217.method4036();
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2067681931"
   )
   protected final boolean method1030() {
      return true;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "633792840"
   )
   void method1031() {
      long var1 = class217.method4036();
      long var3 = clientTickTimes[ClientPreferences.clientTickTimeIdx];
      clientTickTimes[ClientPreferences.clientTickTimeIdx] = var1;
      ClientPreferences.clientTickTimeIdx = ClientPreferences.clientTickTimeIdx + 1 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         hasFocus = volatileFocus;
      }

      this.vmethod1403();
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1772330803"
   )
   void method1032() {
      Container var1 = this.method1050();
      long var2 = class217.method4036();
      long var4 = graphicsTickTimes[class60.graphicsTickTimeIdx];
      graphicsTickTimes[class60.graphicsTickTimeIdx] = var2;
      class60.graphicsTickTimeIdx = class60.graphicsTickTimeIdx + 1 & 31;
      if(0L != var4 && var2 > var4) {
         int var6 = (int)(var2 - var4);
         fps = ((var6 >> 1) + 32000) / var6;
      }

      if(++field491 - 1 > 50) {
         field491 -= 50;
         this.field493 = true;
         this.canvas.setSize(WorldMapLabel.canvasWidth, Varps.canvasHeight);
         this.canvas.setVisible(true);
         if(var1 == this.frame) {
            Insets var7 = this.frame.getInsets();
            this.canvas.setLocation(var7.left + this.canvasX, this.canvasY + var7.top);
         } else {
            this.canvas.setLocation(this.canvasX, this.canvasY);
         }
      }

      if(this.isCanvasInvalid) {
         this.method1087();
      }

      this.method1033();
      this.vmethod1404(this.field493);
      if(this.field493) {
         this.method1026();
      }

      this.field493 = false;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "317204031"
   )
   final void method1033() {
      Bounds var1 = this.method1016();
      if(var1.highX != this.contentWidth || this.contentHeight != var1.highY || this.resizeCanvasNextFrame) {
         this.method1024((byte)1);
         this.resizeCanvasNextFrame = false;
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-25"
   )
   final void method1100() {
      this.resizeCanvasNextFrame = true;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1478721255"
   )
   final synchronized void method1037() {
      if(!isKilled) {
         isKilled = true;

         try {
            this.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod1405();
         } catch (Exception var4) {
            ;
         }

         if(this.frame != null) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(class227.taskHandler != null) {
            try {
               class227.taskHandler.method3563();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod1400();
      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-678556074"
   )
   protected abstract void vmethod1402();

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-113"
   )
   protected abstract void vmethod1403();

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "1"
   )
   protected abstract void vmethod1404(boolean var1);

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "8226"
   )
   protected abstract void vmethod1405();

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;ZI)V",
      garbageValue = "-1925389891"
   )
   protected final void method1066(int var1, String var2, boolean var3) {
      try {
         Graphics var4 = this.canvas.getGraphics();
         if(LoginScreenAnimation.fontHelvetica13 == null) {
            LoginScreenAnimation.fontHelvetica13 = new java.awt.Font("Helvetica", 1, 13);
            Ignored.loginScreenFontMetrics = this.canvas.getFontMetrics(LoginScreenAnimation.fontHelvetica13);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, WorldMapLabel.canvasWidth, Varps.canvasHeight);
         }

         Color var5 = new Color(140, 17, 17);

         try {
            if(WorldMapArea.field265 == null) {
               WorldMapArea.field265 = this.canvas.createImage(304, 34);
            }

            Graphics var6 = WorldMapArea.field265.getGraphics();
            var6.setColor(var5);
            var6.drawRect(0, 0, 303, 33);
            var6.fillRect(2, 2, var1 * 3, 30);
            var6.setColor(Color.black);
            var6.drawRect(1, 1, 301, 31);
            var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
            var6.setFont(LoginScreenAnimation.fontHelvetica13);
            var6.setColor(Color.white);
            var6.drawString(var2, (304 - Ignored.loginScreenFontMetrics.stringWidth(var2)) / 2, 22);
            var4.drawImage(WorldMapArea.field265, WorldMapLabel.canvasWidth / 2 - 152, Varps.canvasHeight / 2 - 18, (ImageObserver)null);
         } catch (Exception var9) {
            int var7 = WorldMapLabel.canvasWidth / 2 - 152;
            int var8 = Varps.canvasHeight / 2 - 18;
            var4.setColor(var5);
            var4.drawRect(var7, var8, 303, 33);
            var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var7 + 1, var8 + 1, 301, 31);
            var4.fillRect(var7 + var1 * 3 + 2, var8 + 2, 300 - var1 * 3, 30);
            var4.setFont(LoginScreenAnimation.fontHelvetica13);
            var4.setColor(Color.white);
            var4.drawString(var2, var7 + (304 - Ignored.loginScreenFontMetrics.stringWidth(var2)) / 2, var8 + 22);
         }
      } catch (Exception var10) {
         this.canvas.repaint();
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-104499552"
   )
   protected final void method1025() {
      WorldMapArea.field265 = null;
      LoginScreenAnimation.fontHelvetica13 = null;
      Ignored.loginScreenFontMetrics = null;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "2133222215"
   )
   protected void method1120(String var1) {
      if(!this.hasErrored) {
         this.hasErrored = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "-875370329"
   )
   Container method1050() {
      return (Container)(this.frame != null?this.frame:this);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(B)Lld;",
      garbageValue = "-13"
   )
   Bounds method1016() {
      Container var1 = this.method1050();
      int var2 = Math.max(var1.getWidth(), this.field475);
      int var3 = Math.max(var1.getHeight(), this.field488);
      if(this.frame != null) {
         Insets var4 = this.frame.getInsets();
         var2 -= var4.left + var4.right;
         var3 -= var4.top + var4.bottom;
      }

      return new Bounds(var2, var3);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-584501921"
   )
   protected final boolean method1040() {
      return this.frame != null;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-277226112"
   )
   protected abstract void vmethod1400();

   public final synchronized void paint(Graphics var1) {
      if(this == gameShell && !isKilled) {
         this.field493 = true;
         if(class217.method4036() - this.field497 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= WorldMapLabel.canvasWidth && var2.height >= Varps.canvasHeight) {
               this.isCanvasInvalid = true;
               this.onReplaceCanvasNextFrameChanged(-1);
            }
         }

      }
   }

   public final void destroy() {
      if(this == gameShell && !isKilled) {
         stopTimeMs = class217.method4036();
         class169.method3542(5000L);
         this.method1037();
      }
   }

   public void onRun() {
      this.thread = Thread.currentThread();
      this.thread.setName("Client");
   }

   public void onFocusGained(FocusEvent var1) {
      FocusChanged var2 = new FocusChanged();
      var2.setFocused(true);
      WorldMapSection1.client.getCallbacks().post(FocusChanged.class, var2);
   }

   public void onPost(Object var1) {
      DrawCallbacks var2 = WorldMapSection1.client.getDrawCallbacks();
      if(var2 != null) {
         var2.draw();
      }

   }

   public java.awt.Canvas getCanvas() {
      return this.canvas;
   }

   public boolean isClientThread() {
      return this.thread == Thread.currentThread();
   }

   public final void copy$setMaxCanvasSize(int var1, int var2, int var3) {
      if(this.maxCanvasWidth != var1 || var2 != this.maxCanvasHeight) {
         this.method1100();
      }

      this.maxCanvasWidth = var1;
      this.maxCanvasHeight = var2;
   }

   public final void copy$resizeCanvas(byte var1) {
      Container var2 = this.method1050();
      if(var2 != null) {
         Bounds var3 = this.method1016();
         this.contentWidth = Math.max(var3.highX, this.field475);
         this.contentHeight = Math.max(var3.highY, this.field488);
         if(this.contentWidth <= 0) {
            this.contentWidth = 1;
         }

         if(this.contentHeight <= 0) {
            this.contentHeight = 1;
         }

         WorldMapLabel.canvasWidth = Math.min(this.contentWidth, this.maxCanvasWidth);
         Client.canvasWidthChanged(-1);
         Varps.canvasHeight = Math.min(this.contentHeight, this.maxCanvasHeight);
         Client.canvasHeightChanged(-1);
         this.canvasX = (this.contentWidth - WorldMapLabel.canvasWidth) / 2;
         this.canvasY = 0;
         this.canvas.setSize(WorldMapLabel.canvasWidth, Varps.canvasHeight);
         class206.rasterProvider = new RasterProvider(WorldMapLabel.canvasWidth, Varps.canvasHeight, this.canvas);
         if(var2 == this.frame) {
            Insets var4 = this.frame.getInsets();
            this.canvas.setLocation(var4.left + this.canvasX, this.canvasY + var4.top);
         } else {
            this.canvas.setLocation(this.canvasX, this.canvasY);
         }

         this.field493 = true;
         this.vmethod1411();
      }
   }

   public boolean isReplaceCanvasNextFrame() {
      return this.isCanvasInvalid;
   }

   public void setReplaceCanvasNextFrame(boolean var1) {
      this.isCanvasInvalid = var1;
   }

   public void setResizeCanvasNextFrame(boolean var1) {
      this.resizeCanvasNextFrame = var1;
   }

   public void setMaxCanvasWidth(int var1) {
      this.maxCanvasWidth = var1;
   }

   public void setMaxCanvasHeight(int var1) {
      this.maxCanvasHeight = var1;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1"
   )
   public void onReplaceCanvasNextFrameChanged(int var1) {
      if(WorldMapSection1.client != null && WorldMapSection1.client.isGpu() && this.isReplaceCanvasNextFrame()) {
         this.setReplaceCanvasNextFrame(false);
         this.setResizeCanvasNextFrame(true);
      }

   }

   public void run() {
      this.onRun();

      try {
         if(TaskHandler.javaVendor != null) {
            String var1 = TaskHandler.javaVendor.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = TaskHandler.javaVersion;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method1120("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  int var3;
                  for(var3 = 6; var3 < var2.length() && PcmPlayer.method2594(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  if(MusicPatch.method3981(var4) && Tiles.method1217(var4) < 10) {
                     this.method1120("wrongjava");
                     return;
                  }
               }

               fiveOrOne = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method1029();
         this.vmethod1402();
         clock = ApproximateRouteStrategy.method1326();

         while(0L == stopTimeMs || class217.method4036() < stopTimeMs) {
            ModelData0.gameCyclesToDo = clock.vmethod3593(cycleDurationMillis, fiveOrOne);

            for(int var5 = 0; var5 < ModelData0.gameCyclesToDo; ++var5) {
               this.method1031();
            }

            this.method1032();
            this.method1018(this.canvas);
         }
      } catch (Exception var6) {
         WorldMapDecorationType.method4214((String)null, var6);
         this.method1120("crash");
      }

      this.method1037();
   }

   public final void start() {
      if(this == gameShell && !isKilled) {
         stopTimeMs = 0L;
      }
   }

   public final void stop() {
      if(this == gameShell && !isKilled) {
         stopTimeMs = class217.method4036() + 4000L;
      }
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final void focusLost(FocusEvent var1) {
      volatileFocus = false;
   }

   public abstract void init();

   public final void windowOpened(WindowEvent var1) {}

   public final void windowActivated(WindowEvent var1) {}

   public final void windowDeactivated(WindowEvent var1) {}

   public final void windowClosed(WindowEvent var1) {}

   public final void focusGained(FocusEvent var1) {
      this.onFocusGained(var1);
      volatileFocus = true;
      this.field493 = true;
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public final void windowDeiconified(WindowEvent var1) {}

   public final void windowIconified(WindowEvent var1) {}

   public Thread getClientThread() {
      return this.thread;
   }

   public boolean isResizeCanvasNextFrame() {
      return this.resizeCanvasNextFrame;
   }

   public void post(Object var1) {
      this.method1018(var1);
   }

   public void resizeCanvas() {
      this.method1024((byte)1);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1927353059"
   )
   public static final void method1155() {
      ViewportMouse.ViewportMouse_isInViewport = false;
      ViewportMouse.ViewportMouse_entityCount = 0;
   }
}
