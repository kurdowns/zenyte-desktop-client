import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Named;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Constants;
import net.runelite.api.GameState;
import net.runelite.api.HintArrowType;
import net.runelite.api.IndexDataBase;
import net.runelite.api.InventoryID;
import net.runelite.api.MenuEntry;
import net.runelite.api.MenuOpcode;
import net.runelite.api.NameableContainer;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.Prayer;
import net.runelite.api.Skill;
import net.runelite.api.VarClientInt;
import net.runelite.api.VarClientStr;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.WidgetNode;
import net.runelite.api.WorldType;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AreaSoundEffectPlayed;
import net.runelite.api.events.CanvasSizeChanged;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ClanChanged;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.DraggingWidgetChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GrandExchangeOfferChanged;
import net.runelite.api.events.Menu;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOpened;
import net.runelite.api.events.MenuShouldLeftClick;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.PlayerDespawned;
import net.runelite.api.events.PlayerMenuOptionsChanged;
import net.runelite.api.events.PlayerSpawned;
import net.runelite.api.events.ResizeableChanged;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.events.ScriptPreFired;
import net.runelite.api.events.SoundEffectPlayed;
import net.runelite.api.events.StatChanged;
import net.runelite.api.events.UsernameChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetPressed;
import net.runelite.api.hooks.Callbacks;
import net.runelite.api.hooks.DrawCallbacks;
import net.runelite.api.vars.AccountType;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.callback.Hooks;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSAbstractArchive;
import net.runelite.rs.api.RSAbstractRasterProvider;
import net.runelite.rs.api.RSActor;
import net.runelite.rs.api.RSArchive;
import net.runelite.rs.api.RSChatChannel;
import net.runelite.rs.api.RSClanChat;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSClientPreferences;
import net.runelite.rs.api.RSCollisionMap;
import net.runelite.rs.api.RSDecimator;
import net.runelite.rs.api.RSEnumDefinition;
import net.runelite.rs.api.RSEvictingDualNodeHashTable;
import net.runelite.rs.api.RSFont;
import net.runelite.rs.api.RSFrames;
import net.runelite.rs.api.RSFriendSystem;
import net.runelite.rs.api.RSGrandExchangeOffer;
import net.runelite.rs.api.RSIndexedSprite;
import net.runelite.rs.api.RSItemContainer;
import net.runelite.rs.api.RSItemDefinition;
import net.runelite.rs.api.RSIterableNodeHashTable;
import net.runelite.rs.api.RSLoginType;
import net.runelite.rs.api.RSMessage;
import net.runelite.rs.api.RSMidiPcmStream;
import net.runelite.rs.api.RSModel;
import net.runelite.rs.api.RSMouseRecorder;
import net.runelite.rs.api.RSNPC;
import net.runelite.rs.api.RSNPCDefinition;
import net.runelite.rs.api.RSNode;
import net.runelite.rs.api.RSNodeDeque;
import net.runelite.rs.api.RSNodeHashTable;
import net.runelite.rs.api.RSObjectDefinition;
import net.runelite.rs.api.RSPacketBuffer;
import net.runelite.rs.api.RSPcmStream;
import net.runelite.rs.api.RSPcmStreamMixer;
import net.runelite.rs.api.RSPlayer;
import net.runelite.rs.api.RSRawPcmStream;
import net.runelite.rs.api.RSRawSound;
import net.runelite.rs.api.RSScene;
import net.runelite.rs.api.RSScript;
import net.runelite.rs.api.RSScriptEvent;
import net.runelite.rs.api.RSSoundEffect;
import net.runelite.rs.api.RSSprite;
import net.runelite.rs.api.RSTextureProvider;
import net.runelite.rs.api.RSTileItem;
import net.runelite.rs.api.RSUsername;
import net.runelite.rs.api.RSVarbitDefinition;
import net.runelite.rs.api.RSVarcs;
import net.runelite.rs.api.RSVarpDefinition;
import net.runelite.rs.api.RSWidget;
import net.runelite.rs.api.RSWorld;
import net.runelite.rs.api.RSWorldMap;
import net.runelite.rs.api.RSWorldMapElement;
import netscape.javascript.JSObject;
import org.slf4j.Logger;

@ObfuscatedName("client")
public final class Client extends GameShell implements Usernamed, RSClient {

   @ObfuscatedName("ps")
   @ObfuscatedSignature(
      signature = "[Lla;"
   )
   static Sprite[] mapIcons = new Sprite[1000];
   @ObfuscatedName("mo")
   @ObfuscatedGetter(
      intValue = 1227039409
   )
   static int runEnergy = 0;
   @ObfuscatedName("mz")
   @ObfuscatedGetter(
      intValue = 1509251187
   )
   static int weight = 0;
   @ObfuscatedName("nb")
   static int[] changedSkills = new int[32];
   @ObfuscatedName("ro")
   @ObfuscatedGetter(
      intValue = -367442815
   )
   static int viewportOffsetX = 0;
   @ObfuscatedName("sh")
   @ObfuscatedGetter(
      intValue = -1701342831
   )
   static int viewportOffsetY = 0;
   @ObfuscatedName("og")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   static NodeHashTable widgetClickMasks = new NodeHashTable(512);
   @ObfuscatedName("np")
   @ObfuscatedGetter(
      intValue = 1891755493
   )
   static int widgetClickX = 0;
   @ObfuscatedName("nd")
   @ObfuscatedGetter(
      intValue = -1161612029
   )
   static int widgetClickY = 0;
   @ObfuscatedName("pu")
   @ObfuscatedGetter(
      intValue = 636733525
   )
   static int tradeChatMode = 0;
   @ObfuscatedName("oy")
   @ObfuscatedGetter(
      intValue = 881881039
   )
   static int gameDrawingMode = 0;
   @ObfuscatedName("sd")
   @ObfuscatedSignature(
      signature = "[Lb;"
   )
   static GrandExchangeOffer[] grandExchangeOffers = new GrandExchangeOffer[8];
   @ObfuscatedName("si")
   @ObfuscatedGetter(
      intValue = 2055926497
   )
   static int viewportHeight = 0;
   @ObfuscatedName("qz")
   @ObfuscatedGetter(
      intValue = 1919940513
   )
   static int soundEffectVolume = 127;
   @ObfuscatedName("nf")
   static boolean isDraggingWidget = false;
   @ObfuscatedName("pr")
   @ObfuscatedGetter(
      intValue = 336519687
   )
   static int publicChatMode = 0;
   @ObfuscatedName("os")
   @ObfuscatedGetter(
      intValue = -1525951485
   )
   static int chatCycle = 0;
   @ObfuscatedName("st")
   @ObfuscatedGetter(
      intValue = 1508238603
   )
   static int viewportZoom = 0;
   @ObfuscatedName("mt")
   @ObfuscatedGetter(
      intValue = 1604597695
   )
   static int staffModLevel = 0;
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = 19610687
   )
   static int changedSkillsCount = 0;
   @ObfuscatedName("sc")
   @ObfuscatedGetter(
      intValue = 1112173289
   )
   static int viewportWidth = 0;
   @ObfuscatedName("qv")
   @ObfuscatedGetter(
      intValue = 702335711
   )
   static int musicVolume = 255;
   @ObfuscatedName("qc")
   @ObfuscatedGetter(
      intValue = 1328358885
   )
   static int currentTrackGroupId = -1;
   @ObfuscatedName("qw")
   static int[] soundEffectIds = new int[50];
   @ObfuscatedName("qy")
   @ObfuscatedGetter(
      intValue = 1461372687
   )
   static int areaSoundEffectVolume = 127;
   @ObfuscatedName("ni")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   static Widget draggedOnWidget = null;
   @ObfuscatedName("qf")
   static int[] queuedSoundEffectLoops = new int[50];
   @ObfuscatedName("qu")
   @ObfuscatedSignature(
      signature = "[Ldj;"
   )
   static SoundEffect[] soundEffects = new SoundEffect[50];
   @ObfuscatedName("ov")
   static boolean isResizable = true;
   @ObfuscatedName("ob")
   static int[] rootWidgetYs = new int[100];
   @ObfuscatedName("op")
   static int[] rootWidgetXs = new int[100];
   @ObfuscatedName("qp")
   static int[] soundLocations = new int[50];
   @ObfuscatedName("qm")
   static int[] queuedSoundEffectDelays = new int[50];
   @ObfuscatedName("nv")
   @ObfuscatedGetter(
      intValue = 777988173
   )
   static int cycleCntr = 1;
   @ObfuscatedName("oq")
   @ObfuscatedGetter(
      intValue = -1534976767
   )
   static int rootWidgetCount = 0;
   @ObfuscatedName("nc")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   static Widget clickedWidget = null;
   @ObfuscatedName("qk")
   @ObfuscatedGetter(
      intValue = 1618575593
   )
   static int destinationY = 0;
   @ObfuscatedName("qa")
   @ObfuscatedGetter(
      intValue = -1279257455
   )
   static int destinationX = 0;
   @ObfuscatedName("qr")
   @ObfuscatedGetter(
      intValue = 2086274421
   )
   static int soundEffectCount = 0;
   @ObfuscatedName("nm")
   static int[] changedItemContainers = new int[32];
   @ObfuscatedName("oo")
   @ObfuscatedGetter(
      intValue = -1032308699
   )
   static int field884 = -2;
   @ObfuscatedName("od")
   @ObfuscatedGetter(
      longValue = 7541257458804320211L
   )
   static long field893 = 0L;
   @ObfuscatedName("oa")
   static boolean[] field679 = new boolean[100];
   @ObfuscatedName("ok")
   static boolean[] field813 = new boolean[100];
   @ObfuscatedName("ou")
   static boolean[] field886 = new boolean[100];
   @ObfuscatedName("na")
   static boolean field861 = false;
   @ObfuscatedName("su")
   @ObfuscatedGetter(
      intValue = 2073816179
   )
   public static int field891 = -1;
   @ObfuscatedName("oe")
   @ObfuscatedGetter(
      intValue = -2140267163
   )
   static int field873 = 0;
   @ObfuscatedName("ns")
   static boolean field732 = false;
   @ObfuscatedName("md")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   static Widget meslayerContinueWidget = null;
   @ObfuscatedName("qn")
   static boolean field915 = false;
   @ObfuscatedName("mu")
   @ObfuscatedGetter(
      intValue = -1182225561
   )
   static int chatEffects = 0;
   @ObfuscatedName("me")
   @ObfuscatedGetter(
      intValue = -1652911979
   )
   static int field845 = 0;
   @ObfuscatedName("nx")
   @ObfuscatedGetter(
      intValue = 1561528451
   )
   static int field859 = -1;
   @ObfuscatedName("ma")
   @ObfuscatedGetter(
      intValue = 1416910623
   )
   static int followerIndex = -1;
   @ObfuscatedName("oz")
   static int[] rootWidgetWidths = new int[100];
   @ObfuscatedName("ng")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   static Widget clickedWidgetParent = null;
   @ObfuscatedName("nk")
   @ObfuscatedGetter(
      intValue = -2134546849
   )
   static int field881 = -1;
   @ObfuscatedName("so")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   static PlayerAppearance playerAppearance = new PlayerAppearance();
   @ObfuscatedName("ne")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   static Widget viewportWidget = null;
   @ObfuscatedName("oc")
   static int[] rootWidgetHeights = new int[100];
   @ObfuscatedName("ow")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   static NodeDeque scriptEvents = new NodeDeque();
   @ObfuscatedName("tp")
   @ObfuscatedSignature(
      signature = "Lbj;"
   )
   static final ApproximateRouteStrategy field954 = new ApproximateRouteStrategy();
   @ObfuscatedName("nt")
   @ObfuscatedGetter(
      intValue = 1322546357
   )
   static int field834 = -1;
   @ObfuscatedName("ri")
   static boolean isCameraLocked = false;
   @ObfuscatedName("rq")
   static boolean[] field926 = new boolean[5];
   @ObfuscatedName("nu")
   @ObfuscatedGetter(
      intValue = -206540409
   )
   static int field863 = -1;
   @ObfuscatedName("ru")
   static int[] field788 = new int[5];
   @ObfuscatedName("rp")
   static int[] field730 = new int[5];
   @ObfuscatedName("rs")
   static int[] field929 = new int[5];
   @ObfuscatedName("nr")
   static int[] field866 = new int[32];
   @ObfuscatedName("nj")
   @ObfuscatedGetter(
      intValue = -1815085637
   )
   static int field772 = 0;
   @ObfuscatedName("rz")
   static int[] field930 = new int[5];
   @ObfuscatedName("tj")
   static int[] field955 = new int[50];
   @ObfuscatedName("tk")
   static int[] field956 = new int[50];
   @ObfuscatedName("sv")
   @ObfuscatedGetter(
      intValue = 1159687403
   )
   static int field945 = -1;
   @ObfuscatedName("on")
   @ObfuscatedGetter(
      intValue = -929260201
   )
   static int mouseWheelRotation = 0;
   @ObfuscatedName("om")
   @ObfuscatedGetter(
      intValue = -649542909
   )
   static int field877 = 0;
   @ObfuscatedName("se")
   @ObfuscatedGetter(
      intValue = -276070485
   )
   static int field946 = -1;
   @ObfuscatedName("qx")
   @ObfuscatedGetter(
      intValue = -1155655175
   )
   static int minimapState = 0;
   @ObfuscatedName("sf")
   static ArrayList archiveLoaders = new ArrayList(10);
   @ObfuscatedName("oh")
   @ObfuscatedGetter(
      intValue = 1453786377
   )
   static int field726 = 0;
   @ObfuscatedName("sz")
   @ObfuscatedGetter(
      intValue = 1144280751
   )
   static int archiveLoadersDone = 0;
   @ObfuscatedName("rn")
   static short zoomHeight = 256;
   @ObfuscatedName("ny")
   @ObfuscatedGetter(
      intValue = 387310397
   )
   static int field869 = 0;
   @ObfuscatedName("rr")
   static short field935 = 1;
   @ObfuscatedName("mh")
   static boolean playerMod = false;
   @ObfuscatedName("rg")
   static short field931 = 256;
   @ObfuscatedName("pe")
   @ObfuscatedGetter(
      longValue = 1482293430841042491L
   )
   static long field904 = -1L;
   @ObfuscatedName("rk")
   static short field932 = 205;
   @ObfuscatedName("rm")
   static short field937 = 1;
   @ObfuscatedName("rd")
   static short zoomWidth = 320;
   @ObfuscatedName("pt")
   static String field814 = "";
   @ObfuscatedName("rw")
   static short field748 = 32767;
   @ObfuscatedName("ra")
   static short field938 = 32767;
   @ObfuscatedName("sk")
   @ObfuscatedSignature(
      signature = "Lbl;"
   )
   static GrandExchangeOfferOwnWorldComparator GrandExchangeEvents_worldComparator = new GrandExchangeOfferOwnWorldComparator();
   @ObfuscatedName("mv")
   @ObfuscatedGetter(
      intValue = -651344111
   )
   static int field842 = 0;
   @ObfuscatedName("pz")
   @ObfuscatedGetter(
      intValue = -720502757
   )
   static int field695 = -1;
   @ObfuscatedName("mk")
   @ObfuscatedGetter(
      intValue = -1472818425
   )
   static int field843 = -1;
   @ObfuscatedName("or")
   @ObfuscatedGetter(
      intValue = -29948065
   )
   static int field874 = 0;
   @ObfuscatedName("sp")
   @ObfuscatedSignature(
      signature = "Lmm;"
   )
   static PlatformInfoProvider platformInfoProvider = new DesktopPlatformInfoProvider();
   @ObfuscatedName("pp")
   static long[] field846 = new long[100];
   @ObfuscatedName("pm")
   @ObfuscatedGetter(
      intValue = 2023934429
   )
   static int mapIconCount = 0;
   @ObfuscatedName("px")
   static int[] mapIconXs = new int[1000];
   @ObfuscatedName("sn")
   @ObfuscatedGetter(
      intValue = -453519891
   )
   static int field898 = 0;
   @ObfuscatedName("pg")
   static int[] mapIconYs = new int[1000];
   @ObfuscatedName("ph")
   @ObfuscatedGetter(
      intValue = 180652911
   )
   static int field900 = 0;
   @ObfuscatedName("rj")
   @ObfuscatedGetter(
      intValue = 1179123328
   )
   static int field925;
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      intValue = -2121206743
   )
   static int field901 = 0;
   @ObfuscatedName("pw")
   static int[] field872 = new int[128];
   @ObfuscatedName("pk")
   static int[] field902 = new int[128];
   @ObfuscatedName("of")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   static NodeDeque field727 = new NodeDeque();
   @ObfuscatedName("ox")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   static NodeDeque field919 = new NodeDeque();
   @ObfuscatedName("oi")
   @ObfuscatedGetter(
      intValue = -681527765
   )
   static int field774 = 0;
   @ObfuscatedName("pi")
   static int[] field895 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lfm;"
   )
   static CollisionMap[] collisionMaps = new CollisionMap[4];
   @ObfuscatedName("aw")
   static boolean field749 = true;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 67970213
   )
   public static int worldId = 1;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = -454237971
   )
   static int worldProperties = 0;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 50872335
   )
   static int gameBuild = 0;
   @ObfuscatedName("be")
   public static boolean isMembersWorld = false;
   @ObfuscatedName("bg")
   static boolean isLowDetail = false;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -1948298563
   )
   static int clientType = -1;
   @ObfuscatedName("bv")
   static boolean onMobile = false;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -734659311
   )
   static int gameState = 0;
   public static int tickCount;
   public static boolean interpolatePlayerAnimations;
   public static boolean interpolateNpcAnimations;
   public static boolean interpolateObjectAnimations;
   public static boolean interpolateWidgetAnimations;
   public static RSTileItem lastItemDespawn;
   public static boolean stretchedFast;
   public static boolean stretchedKeepAspectRatio;
   public static boolean stretchedEnabled;
   public static boolean stretchedIntegerScaling;
   public static boolean isHidingEntities;
   public static boolean hidePlayers;
   public static boolean hideFriends;
   public static boolean hideLocalPlayer;
   public static boolean hideLocalPlayer2D;
   public static boolean hideNPCs;
   public static boolean hideProjectiles;
   public static boolean shouldRenderLoginScreenFire;
   public static double scalingFactor;
   public static boolean invertPitch;
   public static boolean hdMinimapEnabled;
   public static net.runelite.api.Sprite loginScreenBackground;
   public static int inventoryDragDelay;
   public static boolean invertYaw;
   public static int skyboxColor;
   public static boolean hideDisconnect;
   public static boolean hideFriendAttackOptions;
   public static boolean hideFriendCastOptions;
   public static boolean hidePlayers2D;
   public static boolean hideClanMates;
   public static boolean hidePets;
   public static boolean hideDeadNPCs;
   public static final Map widgetSpriteOverrides;
   public static Dimension cachedStretchedDimensions;
   public static final int[] rl$modelViewportXs;
   public static BigInteger modulus;
   public static Set blacklistDeadNpcs;
   public static ScriptPostFired deferredEvent;
   public static boolean hideClanmateAttackOptions;
   public static boolean hideClanmateCastOptions;
   public static Set unhiddenCasts;
   public static boolean hideNPCs2D;
   public static boolean hideAttackers;
   public static int oldMenuEntryCount;
   public static final Map spriteOverrides;
   public static Dimension cachedRealDimensions;
   public static boolean printMenuActions;
   public static List hideSpecificPlayers;
   public static boolean pitchRelaxEnabled;
   public static boolean allWidgetsAreOpTargetable;
   // $FF: synthetic field
   public static final boolean $assertionsDisabled;
   public static Stack scriptIds;
   public static Map complianceMap;
   public static HashMap hiddenNpcsDeath;
   public static HashMap hiddenNpcsName;
   public static boolean oldIsResized;
   public static final int[] rl$modelViewportYs;
   public static int lastSoundEffectCount;
   public static int lastPitch;
   public static int itemPressedDurationBuffer;
   public static RSScript currentScript;
   public static RSPlayer[] oldPlayers;
   public static int lastPitchTarget;
   public static int currentScriptPC;
   public static RSActor lastSoundEffectSourceActor;
   public static int lastSoundEffectSourceNPCid;
   @ObfuscatedName("cg")
   static boolean isLoading = true;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = -2024138363
   )
   static int cycle = 0;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      longValue = -2067581052141850097L
   )
   static long mouseLastLastPressedTimeMillis = -1L;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = -1167045491
   )
   static int field691 = -1;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = 736381377
   )
   static int field692 = -1;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      longValue = -9018780370059554257L
   )
   static long field875 = -1L;
   @ObfuscatedName("cy")
   static boolean hadFocus = true;
   @ObfuscatedName("ct")
   static boolean displayFps = false;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = -475175391
   )
   static int rebootTimer = 0;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = -1953007669
   )
   static int hintArrowType = 0;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = 538709907
   )
   static int hintArrowNpcIndex = 0;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = 1820154893
   )
   static int hintArrowPlayerIndex = 0;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = -528461793
   )
   static int hintArrowX = 0;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = -89638729
   )
   static int hintArrowY = 0;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = -1070430812
   )
   static int hintArrowHeight = 0;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = 1105349969
   )
   static int hintArrowSubX = 0;
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = 634022549
   )
   static int hintArrowSubY = 0;
   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "Lcb;"
   )
   static AttackOption playerAttackOption = AttackOption.AttackOption_hidden;
   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "Lcb;"
   )
   static AttackOption npcAttackOption = AttackOption.AttackOption_hidden;
   @ObfuscatedName("dq")
   @ObfuscatedGetter(
      intValue = 1329734549
   )
   static int titleLoadingStage = 0;
   @ObfuscatedName("dm")
   @ObfuscatedGetter(
      intValue = 887284589
   )
   static int js5ConnectState = 0;
   @ObfuscatedName("db")
   @ObfuscatedGetter(
      intValue = -1245813257
   )
   static int field709 = 0;
   @ObfuscatedName("eq")
   @ObfuscatedGetter(
      intValue = -303941171
   )
   static int js5Errors = 0;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = 1964000781
   )
   static int loginState = 0;
   @ObfuscatedName("en")
   @ObfuscatedGetter(
      intValue = -1937308451
   )
   static int field712 = 0;
   @ObfuscatedName("ec")
   @ObfuscatedGetter(
      intValue = -1595212999
   )
   static int field713 = 0;
   @ObfuscatedName("ev")
   @ObfuscatedGetter(
      intValue = -1280111513
   )
   static int field714 = 0;
   @ObfuscatedName("eb")
   @ObfuscatedSignature(
      signature = "Lfu;"
   )
   static class169 field715 = class169.field2008;
   @ObfuscatedName("ez")
   static boolean Login_isUsernameRemembered = false;
   @ObfuscatedName("ek")
   @ObfuscatedSignature(
      signature = "Lca;"
   )
   static SecureRandomFuture secureRandomFuture = new SecureRandomFuture();
   @ObfuscatedName("fk")
   static byte[] randomDatData = null;
   @ObfuscatedName("ff")
   @ObfuscatedSignature(
      signature = "[Lcd;"
   )
   static NPC[] npcs = new NPC['\u8000'];
   @ObfuscatedName("fd")
   @ObfuscatedGetter(
      intValue = -13803859
   )
   static int npcCount = 0;
   @ObfuscatedName("fo")
   static int[] npcIndices = new int['\u8000'];
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = 1186510191
   )
   static int field851 = 0;
   @ObfuscatedName("fv")
   static int[] field725 = new int[250];
   @ObfuscatedName("fg")
   @ObfuscatedSignature(
      signature = "Ldv;"
   )
   public static final PacketWriter packetWriter = new PacketWriter();
   @ObfuscatedName("fu")
   @ObfuscatedGetter(
      intValue = -842980155
   )
   static int logoutTimer = 0;
   @ObfuscatedName("ft")
   static boolean field728 = false;
   @ObfuscatedName("fj")
   static boolean useBufferedSocket = true;
   @ObfuscatedName("fn")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   static Timer timer = new Timer();
   @ObfuscatedName("fe")
   static HashMap fontsMap = new HashMap();
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = 1736766239
   )
   static int field818 = 0;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = 237208089
   )
   static int field921 = 1;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = -1880791937
   )
   static int field734 = 0;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = 313478257
   )
   static int field735 = 1;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = -965509961
   )
   static int field899 = 0;
   @ObfuscatedName("gs")
   static boolean isInInstance = false;
   @ObfuscatedName("gk")
   static int[][][] instanceChunkTemplates = new int[4][13][13];
   @ObfuscatedName("gl")
   static final int[] field699 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = -352208827
   )
   static int field741 = 0;
   @ObfuscatedName("hi")
   @ObfuscatedGetter(
      intValue = 952516679
   )
   static int field742 = 2301979;
   @ObfuscatedName("hl")
   @ObfuscatedGetter(
      intValue = -499490457
   )
   static int field747 = 5063219;
   @ObfuscatedName("hq")
   @ObfuscatedGetter(
      intValue = 1112772085
   )
   static int field744 = 3353893;
   @ObfuscatedName("hw")
   @ObfuscatedGetter(
      intValue = 59309843
   )
   static int field745 = 7759444;
   @ObfuscatedName("hb")
   static boolean field746 = false;
   @ObfuscatedName("hd")
   @ObfuscatedGetter(
      intValue = -71090641
   )
   static int alternativeScrollbarWidth = 0;
   @ObfuscatedName("hn")
   @ObfuscatedGetter(
      intValue = -1566395531
   )
   static int camAngleX = 128;
   @ObfuscatedName("hu")
   @ObfuscatedGetter(
      intValue = 442725255
   )
   static int camAngleY = 0;
   @ObfuscatedName("ha")
   @ObfuscatedGetter(
      intValue = 139375317
   )
   static int camAngleDY = 0;
   @ObfuscatedName("ho")
   @ObfuscatedGetter(
      intValue = -2038484537
   )
   static int camAngleDX = 0;
   @ObfuscatedName("hr")
   @ObfuscatedGetter(
      intValue = 702140089
   )
   static int mouseCamClickedX = 0;
   @ObfuscatedName("hv")
   @ObfuscatedGetter(
      intValue = 1980402249
   )
   static int mouseCamClickedY = 0;
   @ObfuscatedName("hx")
   @ObfuscatedGetter(
      intValue = -167717143
   )
   static int oculusOrbState = 0;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = 1280381451
   )
   static int camFollowHeight = 50;
   @ObfuscatedName("ig")
   @ObfuscatedGetter(
      intValue = -586245253
   )
   static int field756;
   @ObfuscatedName("ii")
   @ObfuscatedGetter(
      intValue = 1464169135
   )
   static int field757 = 0;
   @ObfuscatedName("iv")
   @ObfuscatedGetter(
      intValue = -660367395
   )
   static int field724 = 0;
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = -949088515
   )
   static int field759 = 0;
   @ObfuscatedName("ip")
   @ObfuscatedGetter(
      intValue = -412319227
   )
   static int oculusOrbNormalSpeed = 12;
   @ObfuscatedName("ih")
   @ObfuscatedGetter(
      intValue = -493333163
   )
   static int oculusOrbSlowedSpeed = 6;
   @ObfuscatedName("ia")
   @ObfuscatedGetter(
      intValue = 1356416223
   )
   static int field762 = 0;
   @ObfuscatedName("in")
   static boolean field770 = false;
   @ObfuscatedName("ie")
   @ObfuscatedGetter(
      intValue = -472895563
   )
   static int field764 = 0;
   @ObfuscatedName("iq")
   static boolean field765 = false;
   @ObfuscatedName("ik")
   @ObfuscatedGetter(
      intValue = 575633547
   )
   static int field941 = 0;
   @ObfuscatedName("io")
   @ObfuscatedGetter(
      intValue = -39115273
   )
   static int overheadTextCount = 0;
   @ObfuscatedName("it")
   static String selectedItemName = null;
   @ObfuscatedName("iw")
   @ObfuscatedGetter(
      intValue = 975397305
   )
   static int overheadTextLimit = 50;
   @ObfuscatedName("if")
   static int[] overheadTextXs = new int[overheadTextLimit];
   @ObfuscatedName("ib")
   static int[] overheadTextYs = new int[overheadTextLimit];
   @ObfuscatedName("id")
   static int[] overheadTextAscents = new int[overheadTextLimit];
   @ObfuscatedName("il")
   static int[] overheadTextXOffsets = new int[overheadTextLimit];
   @ObfuscatedName("iu")
   static int[] overheadTextColors = new int[overheadTextLimit];
   @ObfuscatedName("is")
   static int[] overheadTextEffects = new int[overheadTextLimit];
   @ObfuscatedName("jq")
   static int[] overheadTextCyclesRemaining = new int[overheadTextLimit];
   @ObfuscatedName("ji")
   static String[] overheadText = new String[overheadTextLimit];
   @ObfuscatedName("jv")
   static int[][] tileLastDrawnActor = new int[104][104];
   @ObfuscatedName("jw")
   @ObfuscatedGetter(
      intValue = -2121599307
   )
   static int viewportDrawCount = 0;
   @ObfuscatedName("jx")
   @ObfuscatedGetter(
      intValue = 367239901
   )
   static int viewportTempX = -1;
   @ObfuscatedName("je")
   @ObfuscatedGetter(
      intValue = 315568117
   )
   static int viewportTempY = -1;
   @ObfuscatedName("jj")
   @ObfuscatedGetter(
      intValue = 1079427097
   )
   static int mouseCrossX = 0;
   @ObfuscatedName("jn")
   @ObfuscatedGetter(
      intValue = 2092751039
   )
   static int mouseCrossY = 0;
   @ObfuscatedName("jc")
   @ObfuscatedGetter(
      intValue = -1785291428
   )
   static int mouseCrossState = 0;
   @ObfuscatedName("jl")
   @ObfuscatedGetter(
      intValue = -806793857
   )
   static int mouseCrossColor = 0;
   @ObfuscatedName("jm")
   static boolean showMouseCross = true;
   @ObfuscatedName("jk")
   @ObfuscatedGetter(
      intValue = 2013290137
   )
   static int field786 = 0;
   @ObfuscatedName("jg")
   @ObfuscatedGetter(
      intValue = -1764977003
   )
   static int field880 = 0;
   @ObfuscatedName("jo")
   @ObfuscatedGetter(
      intValue = -540153301
   )
   static int dragItemSlotSource = 0;
   @ObfuscatedName("ja")
   @ObfuscatedGetter(
      intValue = -1956792499
   )
   static int draggedWidgetX = 0;
   @ObfuscatedName("jp")
   @ObfuscatedGetter(
      intValue = -1891050173
   )
   static int draggedWidgetY = 0;
   @ObfuscatedName("jy")
   @ObfuscatedGetter(
      intValue = -1965076329
   )
   static int dragItemSlotDestination = 0;
   @ObfuscatedName("jf")
   static boolean field887 = false;
   @ObfuscatedName("jr")
   @ObfuscatedGetter(
      intValue = -1524629153
   )
   static int itemDragDuration = 0;
   @ObfuscatedName("jt")
   @ObfuscatedGetter(
      intValue = -1322333605
   )
   static int field794 = 0;
   @ObfuscatedName("js")
   static boolean showLoadingMessages = true;
   @ObfuscatedName("kw")
   @ObfuscatedSignature(
      signature = "[Lbi;"
   )
   static Player[] players = new Player[2048];
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = -767774261
   )
   static int localPlayerIndex = -1;
   @ObfuscatedName("kt")
   @ObfuscatedGetter(
      intValue = -1853665647
   )
   static int field798 = 0;
   @ObfuscatedName("kr")
   static boolean renderSelf = true;
   @ObfuscatedName("kk")
   @ObfuscatedGetter(
      intValue = -931711387
   )
   static int drawPlayerNames = 0;
   @ObfuscatedName("kn")
   @ObfuscatedGetter(
      intValue = 2084987415
   )
   static int field801 = 0;
   @ObfuscatedName("kq")
   static int[] field918 = new int[1000];
   @ObfuscatedName("kc")
   static final int[] playerMenuOpcodes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
   @ObfuscatedName("ka")
   static String[] playerMenuActions = new String[8];
   @ObfuscatedName("kf")
   static boolean[] playerOptionsPriorities = new boolean[8];
   @ObfuscatedName("kg")
   static int[] defaultRotations = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
   @ObfuscatedName("kx")
   @ObfuscatedGetter(
      intValue = -246802771
   )
   static int combatTargetPlayerIndex = -1;
   @ObfuscatedName("kh")
   @ObfuscatedSignature(
      signature = "[[[Ljh;"
   )
   static NodeDeque[][][] groundItems = new NodeDeque[4][104][104];
   @ObfuscatedName("kp")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   static NodeDeque pendingSpawns = new NodeDeque();
   @ObfuscatedName("kz")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   static NodeDeque projectiles = new NodeDeque();
   @ObfuscatedName("kj")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   static NodeDeque graphicsObjects = new NodeDeque();
   @ObfuscatedName("kb")
   static int[] currentLevels = new int[25];
   @ObfuscatedName("kd")
   static int[] levels = new int[25];
   @ObfuscatedName("kl")
   static int[] experience = new int[25];
   @ObfuscatedName("lk")
   @ObfuscatedGetter(
      intValue = 1453030713
   )
   static int leftClickOpensMenu = 0;
   @ObfuscatedName("lb")
   static boolean isMenuOpen = false;
   @ObfuscatedName("lg")
   @ObfuscatedGetter(
      intValue = -637671939
   )
   static int menuOptionsCount = 0;
   @ObfuscatedName("lf")
   static int[] menuArguments1 = new int[500];
   @ObfuscatedName("lx")
   static int[] menuArguments2 = new int[500];
   @ObfuscatedName("ly")
   static int[] menuOpcodes = new int[500];
   @ObfuscatedName("ll")
   static int[] menuIdentifiers = new int[500];
   @ObfuscatedName("lh")
   static String[] menuActions = new String[500];
   @ObfuscatedName("ln")
   static String[] menuTargets = new String[500];
   @ObfuscatedName("lw")
   static boolean[] menuShiftClick = new boolean[500];
   @ObfuscatedName("lv")
   static boolean followerOpsLowPriority = false;
   @ObfuscatedName("lz")
   static boolean shiftClickDrop = false;
   @ObfuscatedName("li")
   static boolean tapToDrop = false;
   @ObfuscatedName("lj")
   static boolean showMouseOverText = true;
   @ObfuscatedName("lu")
   @ObfuscatedGetter(
      intValue = -79678249
   )
   static int viewportX = -1;
   @ObfuscatedName("le")
   @ObfuscatedGetter(
      intValue = 521048769
   )
   static int viewportY = -1;
   @ObfuscatedName("lp")
   @ObfuscatedGetter(
      intValue = -1517512791
   )
   static int field871 = 0;
   @ObfuscatedName("mp")
   @ObfuscatedGetter(
      intValue = 668929195
   )
   static int field832 = 50;
   @ObfuscatedName("mm")
   @ObfuscatedGetter(
      intValue = -19686459
   )
   static int isItemSelected = 0;
   @ObfuscatedName("mq")
   @ObfuscatedGetter(
      intValue = 630410191
   )
   static int selectedItemSlot;
   @ObfuscatedName("mi")
   static boolean isSpellSelected = false;
   @ObfuscatedName("mw")
   @ObfuscatedGetter(
      intValue = -335979293
   )
   static int selectedSpellChildIndex = -1;
   @ObfuscatedName("mj")
   @ObfuscatedGetter(
      intValue = -167301685
   )
   static int field837 = -1;
   @ObfuscatedName("mc")
   static String selectedSpellActionName = null;
   @ObfuscatedName("mx")
   static String selectedSpellName = null;
   @ObfuscatedName("mr")
   @ObfuscatedGetter(
      intValue = -1504817189
   )
   static int rootInterface = -1;
   @ObfuscatedName("mn")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   static NodeHashTable interfaceParents = new NodeHashTable(8);
   @ObfuscatedName("gpu")
   public boolean field958;
   public DrawCallbacks drawCallbacks;
   @Inject
   @Named("Core Logger")
   public Logger logger;
   public boolean isMirrored;
   @Inject
   public Callbacks callbacks;
   public Cache varbitCache;
   public final Cache enumCache;
   @ObfuscatedName("eg")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   Buffer field718;
   @ObfuscatedName("es")
   @ObfuscatedSignature(
      signature = "Le;"
   )
   class9 field719;


   static {
      rl$$clinit();
      rl$$clinit1();
      rl$$clinit2();
      rl$$clinit3();
      rl$$clinit4();
      rl$$clinit5();
      rl$$clinit6();
      rl$$clinit7();
      rl$$clinit8();
      rl$$clinit9();
   }

   public Client() {
      this.rl$$init();
      this.rl$$init1();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "108"
   )
   protected final void vmethod1411() {
      field893 = class217.method4036() + 500L;
      this.method1446();
      if(rootInterface != -1) {
         this.method1418(true);
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-678556074"
   )
   protected final void vmethod1402() {
      int[] var1 = new int[]{20, 260, 10000};
      int[] var2 = new int[]{1000, 100, 500};
      if(var1 != null && var2 != null) {
         RunException.ByteArrayPool_alternativeSizes = var1;
         ByteArrayPool.ByteArrayPool_altSizeArrayCounts = new int[var1.length];
         ByteArrayPool.ByteArrayPool_arrays = new byte[var1.length][][];

         for(int var5 = 0; var5 < RunException.ByteArrayPool_alternativeSizes.length; ++var5) {
            ByteArrayPool.ByteArrayPool_arrays[var5] = new byte[var2[var5]][];
         }
      } else {
         RunException.ByteArrayPool_alternativeSizes = null;
         ByteArrayPool.ByteArrayPool_altSizeArrayCounts = null;
         ByteArrayPool.ByteArrayPool_arrays = null;
      }

      WorldMapLabelSize.port1 = gameBuild == 0?'\uaa4a':worldId + '\u9c40';
      GrandExchangeOfferAgeComparator.port2 = gameBuild == 0?443:worldId + '\uc350';
      class280.port3 = WorldMapLabelSize.port1;
      WorldMapLabel.field278 = class224.field2544;
      VertexNormal.field1764 = class224.field2547;
      PlayerAppearance.field2539 = class224.field2546;
      PlayerAppearance.field2535 = class224.field2545;
      WorldMapLabel.urlRequester = new UrlRequester();
      this.method1071();
      this.method1059();
      SecureRandomFuture.mouseWheel = this.method1019();
      WorldMapRegion.masterDisk = new ArchiveDisk(255, JagexCache.JagexCache_dat2File, JagexCache.JagexCache_idx255File, 500000);
      GrandExchangeOfferOwnWorldComparator.clientPreferences = WorldMapData_1.method813();
      this.method1042();
      String var4 = WorldMapCacheName.null_string;
      class60.applet = this;
      if(var4 != null) {
         class60.field462 = var4;
      }

      if(gameBuild != 0) {
         displayFps = true;
      }

      WorldMapIcon_1.method406(GrandExchangeOfferOwnWorldComparator.clientPreferences.windowMode);
      Projectile.friendSystem = new FriendSystem(WorldMapIcon_0.loginType);
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-113"
   )
   protected final void vmethod1403() {
      ++cycle;
      this.method1444();

      while(true) {
         NodeDeque var2 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue;
         ArchiveDiskAction var1;
         synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
            var1 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_responseQueue.method4954();
         }

         if(var1 == null) {
            int var5;
            try {
               if(class206.field2406 == 1) {
                  var5 = class206.midiPcmStream.method3794();
                  if(var5 > 0 && class206.midiPcmStream.method3904()) {
                     var5 -= AttackOption.field1187;
                     if(var5 < 0) {
                        var5 = 0;
                     }

                     class206.midiPcmStream.method3815(var5);
                  } else {
                     class206.midiPcmStream.method3883();
                     class206.midiPcmStream.method3804();
                     if(class206.musicTrackArchive != null) {
                        class206.field2406 = 2;
                     } else {
                        class206.field2406 = 0;
                     }

                     class206.musicTrack = null;
                     UrlRequest.soundCache = null;
                  }
               }
            } catch (Exception var9) {
               var9.printStackTrace();
               class206.midiPcmStream.method3883();
               class206.field2406 = 0;
               class206.musicTrack = null;
               UrlRequest.soundCache = null;
               class206.musicTrackArchive = null;
            }

            ChatChannel.method2356();
            KeyHandler var10 = KeyHandler.KeyHandler_instance;
            synchronized(KeyHandler.KeyHandler_instance) {
               ++KeyHandler.KeyHandler_idleCycles;
               KeyHandler.field434 = KeyHandler.field436;
               KeyHandler.field417 = 0;
               int var6;
               if(KeyHandler.field429 < 0) {
                  for(var6 = 0; var6 < 112; ++var6) {
                     KeyHandler.KeyHandler_pressedKeys[var6] = false;
                  }

                  KeyHandler.field429 = KeyHandler.field439;
               } else {
                  while(KeyHandler.field439 != KeyHandler.field429) {
                     var6 = KeyHandler.field427[KeyHandler.field439];
                     KeyHandler.field439 = KeyHandler.field439 + 1 & 127;
                     if(var6 < 0) {
                        KeyHandler.KeyHandler_pressedKeys[~var6] = false;
                     } else {
                        if(!KeyHandler.KeyHandler_pressedKeys[var6] && KeyHandler.field417 < KeyHandler.field432.length - 1) {
                           KeyHandler.field432[++KeyHandler.field417 - 1] = var6;
                        }

                        KeyHandler.KeyHandler_pressedKeys[var6] = true;
                     }
                  }
               }

               if(KeyHandler.field417 > 0) {
                  KeyHandler.KeyHandler_idleCycles = 0;
               }

               KeyHandler.field436 = KeyHandler.field433;
            }

            class52.method900();
            if(SecureRandomFuture.mouseWheel != null) {
               var5 = SecureRandomFuture.mouseWheel.vmethod3588();
               mouseWheelRotation = var5;
            }

            if(gameState == 0) {
               class237.method4227();
               GameShell.clock.vmethod3592();

               for(var5 = 0; var5 < 32; ++var5) {
                  GameShell.graphicsTickTimes[var5] = 0L;
               }

               for(var5 = 0; var5 < 32; ++var5) {
                  GameShell.clientTickTimes[var5] = 0L;
               }

               ModelData0.gameCyclesToDo = 0;
            } else if(gameState == 5) {
               GrandExchangeOfferAgeComparator.method241(this);
               class237.method4227();
               GameShell.clock.vmethod3592();

               for(var5 = 0; var5 < 32; ++var5) {
                  GameShell.graphicsTickTimes[var5] = 0L;
               }

               for(var5 = 0; var5 < 32; ++var5) {
                  GameShell.clientTickTimes[var5] = 0L;
               }

               ModelData0.gameCyclesToDo = 0;
            } else if(gameState != 10 && gameState != 11) {
               if(gameState == 20) {
                  GrandExchangeOfferAgeComparator.method241(this);
                  this.method1409();
               } else if(gameState == 25) {
                  GrandExchangeEvent.method161();
               }
            } else {
               GrandExchangeOfferAgeComparator.method241(this);
            }

            if(gameState == 30) {
               this.method1410();
            } else if(gameState == 40 || gameState == 45) {
               this.method1409();
            }

            return;
         }

         var1.archive.method4374(var1.archiveDisk, (int)var1.key, var1.data, false);
      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "1"
   )
   protected final void vmethod1404(boolean var1) {
      this.draw(var1);

      boolean var2;
      label174: {
         try {
            if(class206.field2406 == 2) {
               if(class206.musicTrack == null) {
                  class206.musicTrack = MusicTrack.method4015(class206.musicTrackArchive, class206.musicTrackGroupId, class206.musicTrackFileId);
                  if(class206.musicTrack == null) {
                     var2 = false;
                     break label174;
                  }
               }

               if(UrlRequest.soundCache == null) {
                  UrlRequest.soundCache = new SoundCache(class206.soundEffectsArchive, class206.musicSamplesArchive);
               }

               if(class206.midiPcmStream.method3795(class206.musicTrack, class58.musicPatchesArchive, UrlRequest.soundCache, 22050)) {
                  class206.midiPcmStream.method3875();
                  class206.midiPcmStream.method3815(class219.musicTrackVolume);
                  class206.midiPcmStream.method3829(class206.musicTrack, GrandExchangeOfferUnitPriceComparator.musicTrackBoolean);
                  class206.field2406 = 0;
                  class206.musicTrack = null;
                  UrlRequest.soundCache = null;
                  class206.musicTrackArchive = null;
                  var2 = true;
                  break label174;
               }
            }
         } catch (Exception var6) {
            var6.printStackTrace();
            class206.midiPcmStream.method3883();
            class206.field2406 = 0;
            class206.musicTrack = null;
            UrlRequest.soundCache = null;
            class206.musicTrackArchive = null;
         }

         var2 = false;
      }

      if(var2 && field915 && WorldMapManager.pcmPlayer0 != null) {
         WorldMapManager.pcmPlayer0.method2575();
      }

      if((gameState == 10 || gameState == 20 || gameState == 30) && 0L != field893 && class217.method4036() > field893) {
         WorldMapIcon_1.method406(ApproximateRouteStrategy.method1327());
      }

      int var4;
      if(var1) {
         for(var4 = 0; var4 < 100; ++var4) {
            field679[var4] = true;
         }
      }

      if(gameState == 0) {
         this.method1066(Login.Login_loadingPercent, Login.Login_loadingText, var1);
      } else if(gameState == 5) {
         MouseRecorder.method1289(TaskHandler.fontBold12, Script.fontPlain11, WorldMapData_0.fontPlain12);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            MouseRecorder.method1289(TaskHandler.fontBold12, Script.fontPlain11, WorldMapData_0.fontPlain12);
         } else if(gameState == 25) {
            if(field899 == 1) {
               if(field818 > field921) {
                  field921 = field818;
               }

               var4 = (field921 * 50 - field818 * 50) / field921;
               AbstractByteArrayCopier.method4026("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else if(field899 == 2) {
               if(field734 > field735) {
                  field735 = field734;
               }

               var4 = (field735 * 50 - field734 * 50) / field735 + 50;
               AbstractByteArrayCopier.method4026("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else {
               AbstractByteArrayCopier.method4026("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            this.method1806();
         } else if(gameState == 40) {
            AbstractByteArrayCopier.method4026("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            AbstractByteArrayCopier.method4026("Please wait...", false);
         }
      } else {
         MouseRecorder.method1289(TaskHandler.fontBold12, Script.fontPlain11, WorldMapData_0.fontPlain12);
      }

      if(gameState == 30 && gameDrawingMode == 0 && !var1 && !isResizable) {
         for(var4 = 0; var4 < rootWidgetCount; ++var4) {
            if(field886[var4]) {
               class206.rasterProvider.vmethod6185(rootWidgetXs[var4], rootWidgetYs[var4], rootWidgetWidths[var4], rootWidgetHeights[var4]);
               field886[var4] = false;
            }
         }
      } else if(gameState > 0) {
         class206.rasterProvider.vmethod6179(0, 0);

         for(var4 = 0; var4 < rootWidgetCount; ++var4) {
            field886[var4] = false;
         }
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "8226"
   )
   protected final void vmethod1405() {
      if(UserComparator4.varcs.method2264()) {
         UserComparator4.varcs.method2261();
      }

      if(MidiPcmStream.mouseRecorder != null) {
         MidiPcmStream.mouseRecorder.isRunning = false;
      }

      MidiPcmStream.mouseRecorder = null;
      packetWriter.method2363();
      if(KeyHandler.KeyHandler_instance != null) {
         KeyHandler var1 = KeyHandler.KeyHandler_instance;
         synchronized(KeyHandler.KeyHandler_instance) {
            KeyHandler.KeyHandler_instance = null;
         }
      }

      GraphicsObject.method2121();
      SecureRandomFuture.mouseWheel = null;
      if(WorldMapManager.pcmPlayer0 != null) {
         WorldMapManager.pcmPlayer0.method2539();
      }

      if(AbstractWorldMapData.pcmPlayer1 != null) {
         AbstractWorldMapData.pcmPlayer1.method2539();
      }

      class7.method104();
      Object var9 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock;
      synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
         if(ArchiveDiskActionHandler.field3151 != 0) {
            ArchiveDiskActionHandler.field3151 = 1;

            try {
               ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock.wait();
            } catch (InterruptedException var5) {
               ;
            }
         }
      }

      if(WorldMapLabel.urlRequester != null) {
         WorldMapLabel.urlRequester.method3409();
         WorldMapLabel.urlRequester = null;
      }

      try {
         JagexCache.JagexCache_dat2File.method6661();

         for(int var4 = 0; var4 < InterfaceParent.idxCount; ++var4) {
            PacketBufferNode.JagexCache_idxFiles[var4].method6661();
         }

         JagexCache.JagexCache_idx255File.method6661();
         JagexCache.JagexCache_randomDat.method6661();
      } catch (Exception var7) {
         ;
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-277226112"
   )
   protected final void vmethod1400() {}

   public RSSprite drawInstanceMap(int var1) {
      RSSprite var2 = this.createSprite(new int[262144], 512, 512);
      RSSprite var3 = this.getMinimapSprite();
      RSScene var4 = this.getScene();
      int[] var5 = var2.getPixels();
      byte[][][] var6 = this.getTileSettings();

      try {
         this.setMinimapSprite(var2);

         int var8;
         int var9;
         for(var8 = 1; var8 < 103; ++var8) {
            int var7 = (103 - var8) * 2048 + 24628;

            for(var9 = 1; var9 < 103; ++var9) {
               if((var6[var1][var9][var8] & 24) == 0) {
                  var4.drawTile(var5, var7, 512, var1, var9, var8);
               }

               if(var1 < 3 && (var6[var1 + 1][var9][var8] & 8) != 0) {
                  var4.drawTile(var5, var7, 512, var1 + 1, var9, var8);
               }

               var7 += 4;
            }
         }

         var8 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
         var9 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
         var2.setRaster();

         for(int var10 = 1; var10 < 103; ++var10) {
            for(int var11 = 1; var11 < 103; ++var11) {
               if((var6[var1][var11][var10] & 24) == 0) {
                  this.drawObject(var1, var11, var10, var8, var9);
               }

               if(var1 < 3 && (var6[var1 + 1][var11][var10] & 8) != 0) {
                  this.drawObject(var1 + 1, var11, var10, var8, var9);
               }
            }
         }

         return var2;
      } finally {
         this.getBufferProvider().setRaster();
         this.setMinimapSprite(var3);
      }
   }

   public RSItemContainer getItemContainer(InventoryID var1) {
      RSNodeHashTable var2 = this.getItemContainers();
      return (RSItemContainer)var2.get((long)var1.getId());
   }

   public void draw(boolean var1) {
      this.callbacks.clientMainLoop();
   }

   public RSSprite[] getSprites(IndexDataBase var1, int var2, int var3) {
      RSAbstractArchive var4 = (RSAbstractArchive)var1;
      byte[] var5 = var4.getConfigData(var2, var3);
      if(var5 == null) {
         return null;
      } else {
         this.decodeSprite(var5);
         int var6 = this.getIndexedSpriteCount();
         int var7 = this.getIndexedSpriteWidth();
         int var8 = this.getIndexedSpriteHeight();
         int[] var9 = this.getIndexedSpriteOffsetXs();
         int[] var10 = this.getIndexedSpriteOffsetYs();
         int[] var11 = this.getIndexedSpriteWidths();
         int[] var12 = this.getIndexedSpriteHeights();
         byte[][] var13 = this.getSpritePixels();
         int[] var14 = this.getIndexedSpritePalette();
         Sprite[] var15 = new Sprite[var6];

         for(int var16 = 0; var16 < var6; ++var16) {
            int var17 = var11[var16];
            int var18 = var12[var16];
            byte[] var19 = var13[var16];
            int[] var20 = new int[var17 * var18];
            RSSprite var21 = this.createSprite(var20, var17, var18);
            var21.setMaxHeight(var8);
            var21.setMaxWidth(var7);
            var21.setOffsetX(var9[var16]);
            var21.setOffsetY(var10[var16]);

            for(int var22 = 0; var22 < var17 * var18; ++var22) {
               var20[var22] = var14[var19[var22] & 255];
            }

            var15[var16] = var21;
         }

         this.setIndexedSpriteOffsetXs((int[])null);
         this.setIndexedSpriteOffsetYs((int[])null);
         this.setIndexedSpriteWidths((int[])null);
         this.setIndexedSpriteHeights((int[])null);
         this.setIndexedSpritePalette((int[])null);
         this.setSpritePixels((byte[][])null);
         return var15;
      }
   }

   public RSLoginType getLoginType() {
      return WorldMapIcon_0.loginType;
   }

   public int getPlayerIndexesCount() {
      return Players.Players_count;
   }

   public int getCycleCntr() {
      return cycleCntr;
   }

   public int getDestinationX() {
      return destinationX;
   }

   public int getFlags() {
      return worldProperties;
   }

   public void setLowMemory(boolean var1) {
      isLowDetail = var1;
   }

   public int getNpcIndexesCount() {
      return npcCount;
   }

   public int[] getBoostedSkillLevels() {
      return currentLevels;
   }

   public int[] getRealSkillLevels() {
      return levels;
   }

   public int getWidgetRoot() {
      return rootInterface;
   }

   public int getSelectedSceneTileX() {
      return Scene.Scene_selectedX;
   }

   public void setStopTimeMs(long var1) {
      GameShell.stopTimeMs = var1;
   }

   public RSEvictingDualNodeHashTable getHealthBarCache() {
      return HealthBarDefinition.HealthBarDefinition_cached;
   }

   public void setRSModIcons(RSIndexedSprite[] var1) {
      AbstractFont.AbstractFont_modIconSprites = (IndexedSprite[])var1;
   }

   public void playSoundEffect(int var1, int var2, int var3, int var4, int var5) {
      if(!$assertionsDisabled && !this.isClientThread()) {
         throw new AssertionError("playSoundEffect must be called on client thread!");
      } else {
         int var6 = ((var2 & 255) << 16) + ((var3 & 255) << 8) + (var4 & 255);
         int[] var7 = this.getQueuedSoundEffectIDs();
         int[] var8 = this.getQueuedSoundEffectLoops();
         int[] var9 = this.getQueuedSoundEffectDelays();
         RSSoundEffect[] var10 = this.getAudioEffects();
         int[] var11 = this.getSoundLocations();
         int var12 = this.getQueuedSoundEffectCount();
         var7[var12] = var1;
         var8[var12] = 1;
         var9[var12] = var5;
         var10[var12] = null;
         var11[var12] = var6;
         this.setQueuedSoundEffectCount(var12 + 1);
      }
   }

   public boolean isStretchedEnabled() {
      return stretchedEnabled;
   }

   public int getMenuX() {
      return WorldMapDecoration.menuX;
   }

   public int getRSGameState() {
      return gameState;
   }

   public RSNodeHashTable getItemContainers() {
      return ItemContainer.itemContainers;
   }

   public int getVar(Varbits var1) {
      int var2 = var1.getId();
      return this.getVarbitValue(this.getVarps(), var2);
   }

   public HintArrowType getHintArrowType() {
      int var1 = WorldMapSection1.client.getHintArrowTargetType();
      return var1 == HintArrowType.NPC.getValue()?HintArrowType.NPC:(var1 == HintArrowType.PLAYER.getValue()?HintArrowType.PLAYER:(var1 == HintArrowType.WORLD_POSITION.getValue()?HintArrowType.WORLD_POSITION:HintArrowType.NONE));
   }

   public void menuOpened(int var1, int var2) {
      MenuOpened var3 = new MenuOpened();
      var3.setMenuEntries(this.getMenuEntries());
      this.callbacks.post(MenuOpened.class, var3);
      if(var3.isModified()) {
         this.setMenuEntries(var3.getMenuEntries());
      }

   }

   public int[] getSkillExperiences() {
      return experience;
   }

   public int getMouseX() {
      return MouseHandler.MouseHandler_xVolatile;
   }

   public final boolean copy$shouldLeftClickOpenMenu(int var1) {
      int var2 = AbstractWorldMapData.method381();
      return (leftClickOpensMenu == 1 && menuOptionsCount > 2 || class9.method121(var2)) && !menuShiftClick[var2];
   }

   public boolean isResized() {
      return isResizable;
   }

   public RSWidget[][] getWidgets() {
      return Widget.Widget_interfaceComponents;
   }

   public RSVarcs getVarcs() {
      return UserComparator4.varcs;
   }

   public RSFriendSystem getFriendManager() {
      return Projectile.friendSystem;
   }

   public Map getVarcMap() {
      return this.getVarcs().getVarcMap();
   }

   public RSSprite createSprite(int[] var1, int var2, int var3) {
      return new Sprite(var1, var2, var3);
   }

   public String[] getMenuOptions() {
      return menuActions;
   }

   public int[] getVarps() {
      return Varps.Varps_main;
   }

   public int getMenuOptionCount() {
      return menuOptionsCount;
   }

   public int getVarcIntValue(int var1) {
      Map var2 = this.getVarcMap();
      Object var3 = var2.get(Integer.valueOf(var1));
      return var3 instanceof Integer?((Integer)var3).intValue():0;
   }

   public String getVarcStrValue(int var1) {
      Map var2 = this.getVarcMap();
      Object var3 = var2.get(Integer.valueOf(var1));
      return var3 instanceof String?(String)var3:"";
   }

   public Callbacks getCallbacks() {
      return this.callbacks;
   }

   public void addChatMessage(int var1, String var2, String var3, String var4) {
      if(!$assertionsDisabled && !this.isClientThread()) {
         throw new AssertionError("addChatMessage must be called on client thread");
      } else {
         this.addRSChatMessage(var1, var2, var3, var4);
      }
   }

   public RSNodeDeque getProjectilesDeque() {
      return projectiles;
   }

   public RSNodeDeque getGraphicsObjectDeque() {
      return graphicsObjects;
   }

   public MenuEntry[] getMenuEntries() {
      int var1 = this.getMenuOptionCount();
      String[] var2 = this.getMenuOptions();
      String[] var3 = this.getMenuTargets();
      int[] var4 = this.getMenuIdentifiers();
      int[] var5 = this.getMenuOpcodes();
      int[] var6 = this.getMenuArguments1();
      int[] var7 = this.getMenuArguments2();
      boolean[] var8 = this.getMenuForceLeftClick();
      MenuEntry[] var9 = new MenuEntry[var1];

      for(int var10 = 0; var10 < var1; ++var10) {
         MenuEntry var11 = var9[var10] = new MenuEntry();
         var11.setOption(var2[var10]);
         var11.setTarget(var3[var10]);
         var11.setIdentifier(var4[var10]);
         var11.setOpcode(var5[var10]);
         var11.setParam0(var6[var10]);
         var11.setParam1(var7[var10]);
         var11.setForceLeftClick(var8[var10]);
      }

      return var9;
   }

   private void rl$$init() {
      this.varbitCache = CacheBuilder.newBuilder().maximumSize(128L).build();
   }

   public int getVarpValue(int[] var1, int var2) {
      return var1[var2];
   }

   public RSUsername createName(String var1, RSLoginType var2) {
      return new Username(var1, (LoginType)var2);
   }

   public int[] getPlayerIndices() {
      return Players.Players_indices;
   }

   public int getDestinationY() {
      return destinationY;
   }

   public void setChatCycle(int var1) {
      chatCycle = var1;
   }

   public int[] getNpcIndices() {
      return npcIndices;
   }

   public void setSceneLowMemory(boolean var1) {
      Scene.Scene_isLowDetail = var1;
   }

   public int getSelectedSceneTileY() {
      return Scene.Scene_selectedY;
   }

   public void invokeMenuAction(String var1, String var2, int var3, int var4, int var5, int var6) {
      if(!$assertionsDisabled && !this.isClientThread()) {
         throw new AssertionError();
      } else {
         WorldMapSection1.client.sendMenuAction(var5, var6, var4, var3, var1, "!AUTHENTIC" + var2, 658, 384);
      }
   }

   public void decodeSprite(byte[] var1) {
      MusicPatch.method3982(var1);
   }

   public RSArchive getIndexCache4() {
      return FontName.archive4;
   }

   public RSNPCDefinition getRSNpcDefinition(int var1) {
      return class237.method4226(var1);
   }

   public RSItemDefinition getRSItemDefinition(int var1) {
      return AbstractWorldMapData.method373(var1);
   }

   public RSObjectDefinition getRSObjectDefinition(int var1) {
      return WorldMapSection2.method435(var1);
   }

   public int get3dZoom() {
      return Rasterizer3D.Rasterizer3D_zoom;
   }

   public int getMenuY() {
      return PacketBufferNode.menuY;
   }

   public RSSprite getMinimapSprite() {
      return ArchiveDisk.sceneMinimapSprite;
   }

   public int getMouseY() {
      return MouseHandler.MouseHandler_yVolatile;
   }

   public net.runelite.api.widgets.Widget getWidget(int var1, int var2) {
      RSWidget[][] var3 = this.getWidgets();
      if(var3 != null && var3.length > var1) {
         RSWidget[] var4 = var3[var1];
         return var4 != null && var4.length > var2?var4[var2]:null;
      } else {
         return null;
      }
   }

   public RSSprite createRSItemSprite(int var1, int var2, int var3, int var4, int var5, boolean var6) {
      return SecureRandomFuture.method2227(var1, var2, var3, var4, var5, var6);
   }

   public void addRSChatMessage(int var1, String var2, String var3, String var4) {
      ChatChannel.method2355(var1, var2, var3, var4);
   }

   public int getVarbitValue(int[] var1, int var2) {
      if(!$assertionsDisabled && !WorldMapSection1.client.isClientThread()) {
         throw new AssertionError();
      } else {
         RSVarbitDefinition var3 = (RSVarbitDefinition)this.varbitCache.getIfPresent(Integer.valueOf(var2));
         if(var3 == null) {
            WorldMapSection1.client.getVarbit(var2);
            RSEvictingDualNodeHashTable var4 = WorldMapSection1.client.getVarbitCache();
            var3 = (RSVarbitDefinition)var4.get((long)var2);
            this.varbitCache.put(Integer.valueOf(var2), var3);
         }

         if(var3.getIndex() == 0 && var3.getLeastSignificantBit() == 0 && var3.getMostSignificantBit() == 0) {
            throw new IndexOutOfBoundsException("Varbit " + var2 + " does not exist");
         } else {
            int var8 = var1[var3.getIndex()];
            int var5 = var3.getLeastSignificantBit();
            int var6 = var3.getMostSignificantBit();
            int var7 = (1 << var6 - var5 + 1) - 1;
            return var8 >> var5 & var7;
         }
      }
   }

   public String[] getMenuTargets() {
      return menuTargets;
   }

   public void setVarbitValue(int[] var1, int var2, int var3) {
      RSVarbitDefinition var4 = (RSVarbitDefinition)this.varbitCache.getIfPresent(Integer.valueOf(var2));
      if(var4 == null) {
         WorldMapSection1.client.getVarbit(var2);
         RSEvictingDualNodeHashTable var5 = WorldMapSection1.client.getVarbitCache();
         var4 = (RSVarbitDefinition)var5.get((long)var2);
         this.varbitCache.put(Integer.valueOf(var2), var4);
      }

      int var8 = var4.getLeastSignificantBit();
      int var6 = var4.getMostSignificantBit();
      int var7 = (1 << var6 - var8 + 1) - 1;
      var1[var4.getIndex()] = var1[var4.getIndex()] & ~(var7 << var8) | (var3 & var7) << var8;
   }

   public RSEvictingDualNodeHashTable getHealthBarSpriteCache() {
      return HealthBarDefinition.HealthBarDefinition_cachedSprites;
   }

   public net.runelite.api.widgets.Widget getWidget(WidgetInfo var1) {
      int var2 = var1.getGroupId();
      int var3 = var1.getChildId();
      return this.getWidget(var2, var3);
   }

   public void setGameState(int var1) {
      if(!$assertionsDisabled && !this.isClientThread()) {
         throw new AssertionError("setGameState must be called on client thread");
      } else {
         WorldMapSection1.client.setRSGameState(var1);
      }
   }

   private void rl$$init1() {
      this.enumCache = CacheBuilder.newBuilder().maximumSize(64L).build();
      this.isMirrored = false;
   }

   public RSNPC[] getCachedNPCs() {
      return npcs;
   }

   public RSPlayer[] getCachedPlayers() {
      return players;
   }

   public void setAudioHighMemory(boolean var1) {
      PcmPlayer.PcmPlayer_stereo = var1;
   }

   public RSSoundEffect getTrack(RSAbstractArchive var1, int var2, int var3) {
      return SoundEffect.method2469((AbstractArchive)var1, var2, var3);
   }

   public int getIndexedSpriteCount() {
      return class335.SpriteBuffer_spriteCount;
   }

   public int getMenuWidth() {
      return WorldMapScaleHandler.menuWidth;
   }

   public RSScene getScene() {
      return GrandExchangeOfferWorldComparator.scene;
   }

   public int[] getQueuedSoundEffectIDs() {
      return soundEffectIds;
   }

   public int[] getMenuIdentifiers() {
      return menuIdentifiers;
   }

   public void set3dZoom(int var1) {
      Rasterizer3D.Rasterizer3D_zoom = var1;
   }

   public long getOverallExperience() {
      int[] var1 = this.getSkillExperiences();
      long var2 = 0L;
      int[] var4 = var1;
      int var5 = var1.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = var4[var6];
         var2 += (long)var7;
      }

      return var2;
   }

   public final void copy$menu(byte var1) {
      class69.method1275();
      if(class236.dragInventoryWidget == null) {
         if(clickedWidget == null) {
            int var2 = MouseHandler.MouseHandler_lastButton;
            int var3;
            int var4;
            int var5;
            int var6;
            int var7;
            int var9;
            int var10;
            int var11;
            if(isMenuOpen) {
               int var8;
               if(var2 != 1 && (class217.mouseCam || var2 != 4)) {
                  var3 = MouseHandler.MouseHandler_x;
                  var4 = MouseHandler.MouseHandler_y;
                  if(var3 < WorldMapDecoration.menuX - 10 || var3 > WorldMapScaleHandler.menuWidth + WorldMapDecoration.menuX + 10 || var4 < PacketBufferNode.menuY - 10 || var4 > WorldMapData_1.menuHeight + PacketBufferNode.menuY + 10) {
                     isMenuOpen = false;
                     var5 = WorldMapDecoration.menuX;
                     var6 = PacketBufferNode.menuY;
                     var7 = WorldMapScaleHandler.menuWidth;
                     var8 = WorldMapData_1.menuHeight;

                     for(var9 = 0; var9 < rootWidgetCount; ++var9) {
                        if(rootWidgetWidths[var9] + rootWidgetXs[var9] > var5 && rootWidgetXs[var9] < var7 + var5 && rootWidgetHeights[var9] + rootWidgetYs[var9] > var6 && rootWidgetYs[var9] < var8 + var6) {
                           field679[var9] = true;
                        }
                     }
                  }
               }

               if(var2 != 1) {
                  if(class217.mouseCam) {
                     return;
                  }

                  if(var1 <= 28) {
                     return;
                  }

                  if(var2 != 4) {
                     return;
                  }

                  if(var1 <= 28) {
                     return;
                  }
               }

               var3 = WorldMapDecoration.menuX;
               var4 = PacketBufferNode.menuY;
               var5 = WorldMapScaleHandler.menuWidth;
               var6 = MouseHandler.MouseHandler_lastPressedX;
               var7 = MouseHandler.MouseHandler_lastPressedY;
               var8 = -1;

               for(var9 = 0; var9 < menuOptionsCount; ++var9) {
                  if(var1 <= 28) {
                     return;
                  }

                  var10 = (menuOptionsCount - 1 - var9) * 15 + var4 + 31;
                  if(var6 > var3) {
                     if(var1 <= 28) {
                        return;
                     }

                     if(var6 < var5 + var3 && var7 > var10 - 13 && var7 < var10 + 3) {
                        var8 = var9;
                     }
                  }
               }

               int var12;
               if(var8 != -1) {
                  if(var1 <= 28) {
                     return;
                  }

                  if(var8 >= 0) {
                     var9 = menuArguments1[var8];
                     var10 = menuArguments2[var8];
                     var11 = menuOpcodes[var8];
                     var12 = menuIdentifiers[var8];
                     String var19 = menuActions[var8];
                     String var14 = menuTargets[var8];
                     AbstractByteArrayCopier.method4027(var9, var10, var11, var12, var19, var14, MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY, 2035808655);
                  }
               }

               isMenuOpen = false;
               var9 = WorldMapDecoration.menuX;
               var10 = PacketBufferNode.menuY;
               var11 = WorldMapScaleHandler.menuWidth;
               var12 = WorldMapData_1.menuHeight;

               for(int var13 = 0; var13 < rootWidgetCount; ++var13) {
                  if(rootWidgetWidths[var13] + rootWidgetXs[var13] > var9 && rootWidgetXs[var13] < var9 + var11 && rootWidgetHeights[var13] + rootWidgetYs[var13] > var10 && rootWidgetYs[var13] < var12 + var10) {
                     field679[var13] = true;
                  }
               }
            } else {
               label325: {
                  var3 = AbstractWorldMapData.method381();
                  if(var2 != 1) {
                     if(var1 <= 28) {
                        return;
                     }

                     if(class217.mouseCam || var2 != 4) {
                        break label325;
                     }
                  }

                  if(var3 >= 0) {
                     label341: {
                        var4 = menuOpcodes[var3];
                        if(var4 != 39 && var4 != 40 && var4 != 41 && var4 != 42 && var4 != 43 && var4 != 33 && var4 != 34) {
                           if(var1 <= 28) {
                              return;
                           }

                           if(var4 != 35) {
                              if(var1 <= 28) {
                                 return;
                              }

                              if(var4 != 36 && var4 != 37 && var4 != 38 && var4 != 1005) {
                                 break label341;
                              }
                           }
                        }

                        var5 = menuArguments1[var3];
                        var6 = menuArguments2[var3];
                        Widget var15 = MusicPatchNode.method3920(var6);
                        var9 = ScriptEvent.method1283(var15);
                        boolean var10000;
                        if((var9 >> 28 & 1) != 0) {
                           if(var1 <= 28) {
                              return;
                           }

                           var10000 = true;
                        } else {
                           var10000 = false;
                        }

                        boolean var20 = var10000;
                        if(!var20) {
                           Object var21 = null;
                           if(!MilliClock.method3561(ScriptEvent.method1283(var15))) {
                              break label341;
                           }
                        }

                        if(class236.dragInventoryWidget != null) {
                           if(var1 <= 28) {
                              return;
                           }

                           if(!field887) {
                              if(var1 <= 28) {
                                 return;
                              }

                              if(menuOptionsCount > 0) {
                                 if(var1 <= 28) {
                                    return;
                                 }

                                 if(!this.method1800(-113814261)) {
                                    var10 = draggedWidgetX;
                                    var11 = draggedWidgetY;
                                    MenuAction var16 = AbstractWorldMapIcon.tempMenuAction;
                                    AbstractByteArrayCopier.method4027(var16.param0, var16.param1, var16.opcode, var16.identifier, var16.action, var16.action, var10, var11, 2102652919);
                                    AbstractWorldMapIcon.tempMenuAction = null;
                                    onTempMenuActionChanged(-1);
                                 }
                              }
                           }
                        }

                        field887 = false;
                        itemDragDuration = 0;
                        itemPressedDurationChanged(-1);
                        if(class236.dragInventoryWidget != null) {
                           ItemContainer.method1273(class236.dragInventoryWidget);
                        }

                        class236.dragInventoryWidget = MusicPatchNode.method3920(var6);
                        dragItemSlotSource = var5;
                        draggedWidgetX = MouseHandler.MouseHandler_lastPressedX;
                        draggedWidgetY = MouseHandler.MouseHandler_lastPressedY;
                        if(var3 >= 0) {
                           AbstractWorldMapIcon.tempMenuAction = new MenuAction();
                           onTempMenuActionChanged(-1);
                           AbstractWorldMapIcon.tempMenuAction.param0 = menuArguments1[var3];
                           AbstractWorldMapIcon.tempMenuAction.param1 = menuArguments2[var3];
                           AbstractWorldMapIcon.tempMenuAction.opcode = menuOpcodes[var3];
                           AbstractWorldMapIcon.tempMenuAction.identifier = menuIdentifiers[var3];
                           AbstractWorldMapIcon.tempMenuAction.action = menuActions[var3];
                        }

                        ItemContainer.method1273(class236.dragInventoryWidget);
                        return;
                     }
                  }
               }

               label257: {
                  if(var2 != 1) {
                     if(class217.mouseCam || var2 != 4) {
                        break label257;
                     }

                     if(var1 <= 28) {
                        return;
                     }
                  }

                  if(this.method1800(968239940)) {
                     var2 = 2;
                  }
               }

               label249: {
                  if(var2 != 1) {
                     if(class217.mouseCam) {
                        break label249;
                     }

                     if(var1 <= 28) {
                        return;
                     }

                     if(var2 != 4) {
                        break label249;
                     }
                  }

                  if(menuOptionsCount > 0 && var3 >= 0) {
                     var4 = menuArguments1[var3];
                     var5 = menuArguments2[var3];
                     var6 = menuOpcodes[var3];
                     var7 = menuIdentifiers[var3];
                     String var17 = menuActions[var3];
                     String var18 = menuTargets[var3];
                     AbstractByteArrayCopier.method4027(var4, var5, var6, var7, var17, var18, MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY, 1565406540);
                  }
               }

               if(var2 == 2) {
                  if(var1 <= 28) {
                     return;
                  }

                  if(menuOptionsCount > 0) {
                     this.method1705(MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
                  }
               }
            }

         }
      }
   }

   public void setObjectDefinitionLowDetail(boolean var1) {
      ObjectDefinition.ObjectDefinition_isLowDetail = var1;
   }

   public RSEnumDefinition getRsEnum(int var1) {
      return class58.method967(var1);
   }

   public RSSprite createItemSprite(int var1, int var2, int var3, int var4, int var5, boolean var6) {
      if(!$assertionsDisabled && !this.isClientThread()) {
         throw new AssertionError("createItemSprite must be called on client thread");
      } else {
         return this.createRSItemSprite(var1, var2, var3, var4, var5, var6);
      }
   }

   public int getIndexedSpriteWidth() {
      return class335.SpriteBuffer_spriteWidth;
   }

   public int getMenuHeight() {
      return WorldMapData_1.menuHeight;
   }

   public RSScriptEvent createScriptEvent() {
      return new ScriptEvent();
   }

   public int[] getQueuedSoundEffectLoops() {
      return queuedSoundEffectLoops;
   }

   public int[] getMenuOpcodes() {
      return menuOpcodes;
   }

   public Dimension getRealDimensions() {
      if(!this.isStretchedEnabled()) {
         return this.getCanvas().getSize();
      } else {
         if(cachedRealDimensions == null) {
            if(this.isResized()) {
               Container var1 = this.getCanvas().getParent();
               int var2 = var1.getWidth();
               int var3 = var1.getHeight();
               int var4 = (int)((double)var2 / scalingFactor);
               int var5 = (int)((double)var3 / scalingFactor);
               if(var4 < 765 || var5 < 503) {
                  double var6 = (double)var2 / 765.0D;
                  double var8 = (double)var3 / 503.0D;
                  double var10 = Math.min(var6, var8);
                  var4 = (int)((double)var2 / var10);
                  var5 = (int)((double)var3 / var10);
               }

               cachedRealDimensions = new Dimension(var4, var5);
            } else {
               cachedRealDimensions = Constants.GAME_FIXED_SIZE;
            }
         }

         return cachedRealDimensions;
      }
   }

   public int getSoundEffectVolume() {
      return soundEffectVolume;
   }

   public byte[][][] getTileSettings() {
      return Tiles.Tiles_renderFlags;
   }

   public GameState getGameState() {
      return GameState.of(this.getRSGameState());
   }

   public int getIndexedSpriteHeight() {
      return class335.SpriteBuffer_spriteHeight;
   }

   public int[] getQueuedSoundEffectDelays() {
      return queuedSoundEffectDelays;
   }

   public int[] getMenuArguments1() {
      return menuArguments1;
   }

   public void rasterizerFillRectangleAlpha(int var1, int var2, int var3, int var4, int var5, int var6) {
      Rasterizer2D.method6091(var1, var2, var3, var4, var5, var6);
   }

   public int getPlane() {
      return ScriptEvent.Client_plane;
   }

   public void setMenuEntries(MenuEntry[] var1) {
      int var2 = 0;
      String[] var3 = this.getMenuOptions();
      String[] var4 = this.getMenuTargets();
      int[] var5 = this.getMenuIdentifiers();
      int[] var6 = this.getMenuOpcodes();
      int[] var7 = this.getMenuArguments1();
      int[] var8 = this.getMenuArguments2();
      boolean[] var9 = this.getMenuForceLeftClick();
      MenuEntry[] var10 = var1;
      int var11 = var1.length;

      for(int var12 = 0; var12 < var11; ++var12) {
         MenuEntry var13 = var10[var12];
         if(var13 != null) {
            var3[var2] = var13.getOption();
            var4[var2] = var13.getTarget();
            var5[var2] = var13.getIdentifier();
            var6[var2] = var13.getOpcode();
            var7[var2] = var13.getParam0();
            var8[var2] = var13.getParam1();
            var9[var2] = var13.isForceLeftClick();
            ++var2;
         }
      }

      this.setMenuOptionCount(var2);
      oldMenuEntryCount = var2;
   }

   public void runScript(RSScriptEvent var1, int var2) {
      PlayerAppearance.method4124((ScriptEvent)var1, var2, 2013269807);
   }

   public RSAbstractRasterProvider getBufferProvider() {
      return class206.rasterProvider;
   }

   public void setMinimapSprite(net.runelite.api.Sprite var1) {
      ArchiveDisk.sceneMinimapSprite = (Sprite)var1;
   }

   public boolean boundingboxCheck(net.runelite.api.Model var1, int var2, int var3, int var4) {
      int var5 = WorldMapSection1.client.getCameraPitch();
      int var6 = WorldMapSection1.client.getCameraYaw();
      int var7 = Perspective.SINE[var5];
      int var8 = Perspective.COSINE[var5];
      int var9 = Perspective.SINE[var6];
      int var10 = Perspective.COSINE[var6];
      int var11 = WorldMapSection1.client.getCenterX();
      int var12 = WorldMapSection1.client.getCenterY();
      int var13 = WorldMapSection1.client.getViewportMouseX();
      int var14 = WorldMapSection1.client.getViewportMouseY();
      int var15 = WorldMapSection1.client.get3dZoom();
      int var16 = (var13 - var11) * 50 / var15;
      int var17 = (var14 - var12) * 50 / var15;
      int var18 = (var13 - var11) * 10000 / var15;
      int var19 = (var14 - var12) * 10000 / var15;
      int var20 = rl$rot1(var17, 50, var8, var7);
      int var21 = rl$rot2(var17, 50, var8, var7);
      var17 = var20;
      var20 = rl$rot1(var19, 10000, var8, var7);
      int var22 = rl$rot2(var19, 10000, var8, var7);
      var19 = var20;
      var20 = rl$rot3(var16, var21, var10, var9);
      var21 = rl$rot4(var16, var21, var10, var9);
      var16 = var20;
      var20 = rl$rot3(var18, var22, var10, var9);
      var22 = rl$rot4(var18, var22, var10, var9);
      int var23 = (var20 - var16) / 2;
      int var24 = (var19 - var17) / 2;
      int var25 = (var22 - var21) / 2;
      int var26 = Math.abs(var23);
      int var27 = Math.abs(var24);
      int var28 = Math.abs(var25);
      int var29 = var2 + var1.getCenterX();
      int var30 = var3 + var1.getCenterY();
      int var31 = var4 + var1.getCenterZ();
      int var32 = var1.getExtremeX();
      int var33 = var1.getExtremeY();
      int var34 = var1.getExtremeZ();
      int var35 = (var16 + var20) / 2;
      int var36 = (var17 + var19) / 2;
      int var37 = (var22 + var21) / 2;
      int var38 = var35 - var29;
      int var39 = var36 - var30;
      int var40 = var37 - var31;
      boolean var41;
      if(Math.abs(var38) > var32 + var26) {
         var41 = false;
      } else if(Math.abs(var39) > var33 + var27) {
         var41 = false;
      } else if(Math.abs(var40) > var34 + var28) {
         var41 = false;
      } else if(Math.abs(var40 * var24 - var39 * var25) > var33 * var28 + var34 * var27) {
         var41 = false;
      } else if(Math.abs(var38 * var25 - var40 * var23) > var34 * var26 + var32 * var28) {
         var41 = false;
      } else if(Math.abs(var39 * var23 - var38 * var24) > var33 * var26 + var32 * var27) {
         var41 = false;
      } else {
         var41 = true;
      }

      return var41;
   }

   public int[] getIndexedSpriteOffsetXs() {
      return class335.SpriteBuffer_xOffsets;
   }

   public void rasterizerDrawRectangleAlpha(int var1, int var2, int var3, int var4, int var5, int var6) {
      Rasterizer2D.method6096(var1, var2, var3, var4, var5, var6);
   }

   public void rasterizerDrawHorizontalLineAlpha(int var1, int var2, int var3, int var4, int var5) {
      Rasterizer2D.method6163(var1, var2, var3, var4, var5);
   }

   public RSSoundEffect[] getAudioEffects() {
      return soundEffects;
   }

   public int[] getMenuArguments2() {
      return menuArguments2;
   }

   public void setGameState(GameState var1) {
      if(!$assertionsDisabled && !this.isClientThread()) {
         throw new AssertionError();
      } else {
         this.setGameState(var1.getState());
      }
   }

   public RSDecimator getSoundEffectResampler() {
      return class25.decimator;
   }

   public int[] getIndexedSpriteOffsetYs() {
      return StructDefinition.SpriteBuffer_yOffsets;
   }

   public int[] getSoundLocations() {
      return soundLocations;
   }

   public boolean[] getMenuForceLeftClick() {
      return menuShiftClick;
   }

   public int[] getIndexedSpriteWidths() {
      return class335.SpriteBuffer_spriteWidths;
   }

   public RSRawPcmStream createRawPcmStream(RSRawSound var1, int var2, int var3) {
      return RawPcmStream.method2654((RawSound)var1, var2, var3);
   }

   public int getQueuedSoundEffectCount() {
      return soundEffectCount;
   }

   public void setMenuOptionCount(int var1) {
      menuOptionsCount = var1;
   }

   public int[] getIndexedSpriteHeights() {
      return class335.SpriteBuffer_spriteHeights;
   }

   public RSPcmStreamMixer getSoundEffectAudioQueue() {
      return Tiles.pcmStreamMixer;
   }

   public byte[][] getSpritePixels() {
      return class4.SpriteBuffer_pixels;
   }

   public void addHashAtMouse(long var1) {
      long[] var3 = WorldMapSection1.client.getEntitiesAtMouse();
      int var4 = WorldMapSection1.client.getEntitiesAtMouseCount();
      if(var4 < 1000) {
         var3[var4] = var1;
         WorldMapSection1.client.setEntitiesAtMouseCount(var4 + 1);
      }

   }

   public int[] getIndexedSpritePalette() {
      return DefaultsGroup.SpriteBuffer_spritePalette;
   }

   public void rasterizerDrawVerticalLineAlpha(int var1, int var2, int var3, int var4, int var5) {
      Rasterizer2D.method6144(var1, var2, var3, var4, var5);
   }

   public void setQueuedSoundEffectCount(int var1) {
      soundEffectCount = var1;
   }

   public void setIndexedSpriteOffsetXs(int[] var1) {
      class335.SpriteBuffer_xOffsets = var1;
   }

   public RSFont getFontBold12() {
      return TaskHandler.fontBold12;
   }

   public void setIndexedSpriteOffsetYs(int[] var1) {
      StructDefinition.SpriteBuffer_yOffsets = var1;
   }

   public void setIndexedSpriteWidths(int[] var1) {
      class335.SpriteBuffer_spriteWidths = var1;
   }

   public void setIndexedSpriteHeights(int[] var1) {
      class335.SpriteBuffer_spriteHeights = var1;
   }

   public void setIndexedSpritePalette(int[] var1) {
      DefaultsGroup.SpriteBuffer_spritePalette = var1;
   }

   public void setSpritePixels(byte[][] var1) {
      class4.SpriteBuffer_pixels = var1;
   }

   public void drawObject(int var1, int var2, int var3, int var4, int var5) {
      ScriptFrame.method1243(var1, var2, var3, var4, var5);
   }

   public void rasterizerDrawCircleAlpha(int var1, int var2, int var3, int var4, int var5) {
      Rasterizer2D.method6150(var1, var2, var3, var4, var5);
   }

   public void rasterizerDrawGradientAlpha(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.method6117(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public final void init() {
      try {
         if(this.method1030()) {
            for(int var1 = 0; var1 <= 19; ++var1) {
               String var2 = this.getParameter(Integer.toString(var1));
               if(var2 != null) {
                  switch(var1) {
                  case 1:
                     useBufferedSocket = Integer.parseInt(var2) != 0;
                  case 2:
                  case 11:
                  case 13:
                  case 16:
                  default:
                     break;
                  case 3:
                     if(var2.equalsIgnoreCase("true")) {
                        isMembersWorld = true;
                     } else {
                        isMembersWorld = false;
                     }
                     break;
                  case 4:
                     if(clientType == -1) {
                        clientType = Integer.parseInt(var2);
                     }
                     break;
                  case 5:
                     worldProperties = Integer.parseInt(var2);
                     break;
                  case 6:
                     IgnoreList.clientLanguage = Language.method3737(Integer.parseInt(var2));
                     break;
                  case 7:
                     class198.field2353 = Strings.method4220(Integer.parseInt(var2));
                     break;
                  case 8:
                     if(var2.equalsIgnoreCase("true")) {
                        ;
                     }
                     break;
                  case 9:
                     WorldMapData_0.field137 = var2;
                     break;
                  case 10:
                     StudioGame[] var3 = new StudioGame[]{StudioGame.runescape, StudioGame.stellardawn, StudioGame.oldscape, StudioGame.game5, StudioGame.game3, StudioGame.game4};
                     WorldMapArchiveLoader.field3965 = (StudioGame)GrandExchangeEvent.method159(var3, Integer.parseInt(var2));
                     if(WorldMapArchiveLoader.field3965 == StudioGame.oldscape) {
                        WorldMapIcon_0.loginType = LoginType.oldscape;
                     } else {
                        WorldMapIcon_0.loginType = LoginType.field4054;
                     }
                     break;
                  case 12:
                     worldId = Integer.parseInt(var2);
                     break;
                  case 14:
                     KitDefinition.field3271 = Integer.parseInt(var2);
                     break;
                  case 15:
                     gameBuild = Integer.parseInt(var2);
                     break;
                  case 17:
                     ModeWhere.worldListURL = var2;
                  }
               }
            }

            Scene.Scene_isLowDetail = false;
            isLowDetail = false;
            Script.worldHost = this.getCodeBase().getHost();
            String var17 = class198.field2353.name;
            byte var18 = 0;

            try {
               InterfaceParent.idxCount = 21;
               class8.cacheGamebuild = var18;

               try {
                  SequenceDefinition.field3527 = System.getProperty("os.name");
               } catch (Exception var34) {
                  SequenceDefinition.field3527 = "Unknown";
               }

               class171.field2016 = SequenceDefinition.field3527.toLowerCase();

               try {
                  AbstractWorldMapData.userHomeDirectory = System.getProperty("user.home");
                  if(AbstractWorldMapData.userHomeDirectory != null) {
                     AbstractWorldMapData.userHomeDirectory = AbstractWorldMapData.userHomeDirectory + "/";
                  }
               } catch (Exception var33) {
                  ;
               }

               try {
                  if(class171.field2016.startsWith("win")) {
                     if(AbstractWorldMapData.userHomeDirectory == null) {
                        AbstractWorldMapData.userHomeDirectory = System.getenv("USERPROFILE");
                     }
                  } else if(AbstractWorldMapData.userHomeDirectory == null) {
                     AbstractWorldMapData.userHomeDirectory = System.getenv("HOME");
                  }

                  if(AbstractWorldMapData.userHomeDirectory != null) {
                     AbstractWorldMapData.userHomeDirectory = AbstractWorldMapData.userHomeDirectory + "/";
                  }
               } catch (Exception var32) {
                  ;
               }

               if(AbstractWorldMapData.userHomeDirectory == null) {
                  AbstractWorldMapData.userHomeDirectory = "~/";
               }

               Varps.field2522 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", AbstractWorldMapData.userHomeDirectory, "/tmp/", ""};
               AbstractRasterProvider.field3871 = new String[]{".jagex_cache_" + class8.cacheGamebuild, ".file_store_" + class8.cacheGamebuild};
               int var19 = 0;

               label276:
               while(var19 < 4) {
                  String var5 = var19 == 0?"":"" + var19;
                  JagexCache.JagexCache_locationFile = new File(AbstractWorldMapData.userHomeDirectory, "jagex_cl_oldschool_" + var17 + var5 + ".dat");
                  String var6 = null;
                  String var7 = null;
                  boolean var8 = false;
                  int var11;
                  int var13;
                  File var42;
                  if(JagexCache.JagexCache_locationFile.exists()) {
                     try {
                        AccessFile var9 = new AccessFile(JagexCache.JagexCache_locationFile, "rw", 10000L);

                        Buffer var10;
                        for(var10 = new Buffer((int)var9.method6693()); var10.offset < var10.array.length; var10.offset += var11) {
                           var11 = var9.method6705(var10.array, var10.offset, var10.array.length - var10.offset);
                           if(var11 == -1) {
                              throw new IOException();
                           }
                        }

                        var10.offset = 0;
                        var11 = var10.method5575();
                        if(var11 < 1 || var11 > 3) {
                           throw new IOException("" + var11);
                        }

                        int var12 = 0;
                        if(var11 > 1) {
                           var12 = var10.method5575();
                        }

                        if(var11 <= 2) {
                           var6 = var10.method5585();
                           if(var12 == 1) {
                              var7 = var10.method5585();
                           }
                        } else {
                           var6 = var10.method5709();
                           if(var12 == 1) {
                              var7 = var10.method5709();
                           }
                        }

                        var9.method6691();
                     } catch (IOException var36) {
                        var36.printStackTrace();
                     }

                     if(var6 != null) {
                        var42 = new File(var6);
                        if(!var42.exists()) {
                           var6 = null;
                        }
                     }

                     if(var6 != null) {
                        var42 = new File(var6, "test.dat");

                        boolean var45;
                        try {
                           RandomAccessFile var20 = new RandomAccessFile(var42, "rw");
                           var13 = var20.read();
                           var20.seek(0L);
                           var20.write(var13);
                           var20.seek(0L);
                           var20.close();
                           var42.delete();
                           var45 = true;
                        } catch (Exception var31) {
                           var45 = false;
                        }

                        if(!var45) {
                           var6 = null;
                        }
                     }
                  }

                  if(var6 == null && var19 == 0) {
                     label240:
                     for(int var21 = 0; var21 < AbstractRasterProvider.field3871.length; ++var21) {
                        for(int var22 = 0; var22 < Varps.field2522.length; ++var22) {
                           File var23 = new File(Varps.field2522[var22] + AbstractRasterProvider.field3871[var21] + File.separatorChar + "oldschool" + File.separatorChar);
                           if(var23.exists()) {
                              File var24 = new File(var23, "test.dat");

                              boolean var46;
                              try {
                                 RandomAccessFile var14 = new RandomAccessFile(var24, "rw");
                                 int var15 = var14.read();
                                 var14.seek(0L);
                                 var14.write(var15);
                                 var14.seek(0L);
                                 var14.close();
                                 var24.delete();
                                 var46 = true;
                              } catch (Exception var30) {
                                 var46 = false;
                              }

                              if(var46) {
                                 var6 = var23.toString();
                                 var8 = true;
                                 break label240;
                              }
                           }
                        }
                     }
                  }

                  if(var6 == null) {
                     var6 = AbstractWorldMapData.userHomeDirectory + File.separatorChar + "jagexcache" + var5 + File.separatorChar + "oldschool" + File.separatorChar + var17 + File.separatorChar;
                     var8 = true;
                  }

                  if(var7 != null) {
                     File var41 = new File(var7);
                     var42 = new File(var6);

                     try {
                        File[] var50 = var41.listFiles();
                        File[] var48 = var50;

                        for(var13 = 0; var13 < var48.length; ++var13) {
                           File var47 = var48[var13];
                           File var25 = new File(var42, var47.getName());
                           boolean var16 = var47.renameTo(var25);
                           if(!var16) {
                              throw new IOException();
                           }
                        }
                     } catch (Exception var35) {
                        var35.printStackTrace();
                     }

                     var8 = true;
                  }

                  if(var8) {
                     GameObject.method3408(new File(var6), (File)null);
                  }

                  File var4 = new File(var6);
                  class92.cacheDir = var4;
                  if(!class92.cacheDir.exists()) {
                     class92.cacheDir.mkdirs();
                  }

                  File[] var40 = class92.cacheDir.listFiles();
                  if(var40 == null) {
                     break;
                  }

                  File[] var43 = var40;
                  int var26 = 0;

                  while(true) {
                     if(var26 >= var43.length) {
                        break label276;
                     }

                     File var27 = var43[var26];

                     boolean var49;
                     try {
                        RandomAccessFile var44 = new RandomAccessFile(var27, "rw");
                        var11 = var44.read();
                        var44.seek(0L);
                        var44.write(var11);
                        var44.seek(0L);
                        var44.close();
                        var49 = true;
                     } catch (Exception var29) {
                        var49 = false;
                     }

                     if(!var49) {
                        ++var19;
                        break;
                     }

                     ++var26;
                  }
               }

               File var39 = class92.cacheDir;
               FileSystem.FileSystem_cacheDir = var39;
               if(!FileSystem.FileSystem_cacheDir.exists()) {
                  throw new RuntimeException("");
               }

               FileSystem.FileSystem_hasPermissions = true;
               Huffman.method4046();
               JagexCache.JagexCache_dat2File = new BufferedFile(new AccessFile(ViewportMouse.method3090("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
               JagexCache.JagexCache_idx255File = new BufferedFile(new AccessFile(ViewportMouse.method3090("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
               PacketBufferNode.JagexCache_idxFiles = new BufferedFile[InterfaceParent.idxCount];

               for(int var28 = 0; var28 < InterfaceParent.idxCount; ++var28) {
                  PacketBufferNode.JagexCache_idxFiles[var28] = new BufferedFile(new AccessFile(ViewportMouse.method3090("main_file_cache.idx" + var28), "rw", 1048576L), 6000, 0);
               }
            } catch (Exception var37) {
               WorldMapDecorationType.method4214((String)null, var37);
            }

            WorldMapSection1.client = this;
            RunException.clientType = clientType;
            this.method1028(765, 503, 189);
         }
      } catch (RuntimeException var38) {
         throw WorldMapSection3.method893(var38, "client.init(" + ')');
      }
   }

   public int getVarbitValue(int var1) {
      return this.getVarbitValue(this.getVarps(), var1);
   }

   public void setVarbit(Varbits var1, int var2) {
      int var3 = var1.getId();
      this.setVarbitValue(this.getVarps(), var3, var2);
   }

   public int getVar(VarClientInt var1) {
      return this.getVarcIntValue(var1.getIndex());
   }

   public String getVar(VarClientStr var1) {
      return this.getVarcStrValue(var1.getIndex());
   }

   public void setVar(VarClientStr var1, String var2) {
      Map var3 = this.getVarcMap();
      var3.put(Integer.valueOf(var1.getIndex()), var2);
   }

   public void setVar(VarClientInt var1, int var2) {
      Map var3 = this.getVarcMap();
      var3.put(Integer.valueOf(var1.getIndex()), Integer.valueOf(var2));
   }

   public void playSoundEffect(int var1) {
      this.playSoundEffect(var1, 0, 0, 0, 0);
   }

   public void playSoundEffect(int var1, int var2, int var3, int var4) {
      this.playSoundEffect(var1, var2, var3, var4, 0);
   }

   public void playSoundEffect(int var1, int var2) {
      if(!$assertionsDisabled && !WorldMapSection1.client.isClientThread()) {
         throw new AssertionError("playSoundEffect must be called on client thread");
      } else {
         RSSoundEffect var3 = this.getTrack(this.getIndexCache4(), var1, 0);
         if(var3 != null) {
            int var4 = this.getSoundEffectVolume();
            if(var4 != 0) {
               var2 = var4;
            }

            RSRawSound var5 = var3.toRawAudioNode().applyResampler(this.getSoundEffectResampler());
            RSRawPcmStream var6 = this.createRawPcmStream(var5, 100, var2);
            var6.setNumLoops(1);
            this.getSoundEffectAudioQueue().addSubStream((RSPcmStream)var6);
         }
      }
   }

   public void runScript(Object ... var1) {
      if(!$assertionsDisabled && !this.isClientThread()) {
         throw new AssertionError();
      } else if(!$assertionsDisabled && currentScript != null) {
         throw new AssertionError();
      } else if(!$assertionsDisabled && !(var1[0] instanceof Integer) && !(var1[0] instanceof JavaScriptCallback)) {
         throw new AssertionError("The first argument should always be a ScriptID!");
      } else {
         RSScriptEvent var2 = this.createScriptEvent();
         var2.setArguments(var1);
         this.runScript(var2, 5000000);
      }
   }

   public void draw2010Menu(int var1) {
      int var2 = this.getMenuX();
      int var3 = this.getMenuY();
      int var4 = this.getMenuWidth();
      int var5 = this.getMenuHeight();
      this.rasterizerDrawHorizontalLineAlpha(var2 + 2, var3, var4 - 4, 7170651, var1);
      this.rasterizerDrawHorizontalLineAlpha(var2 + 2, var3 + var5 - 1, var4 - 4, 7170651, var1);
      this.rasterizerDrawVerticalLineAlpha(var2, var3 + 2, var5 - 4, 7170651, var1);
      this.rasterizerDrawVerticalLineAlpha(var2 + var4 - 1, var3 + 2, var5 - 4, 7170651, var1);
      this.rasterizerDrawRectangleAlpha(var2 + 1, var3 + 5, var4 - 2, var5 - 6, 2827810, var1);
      this.rasterizerDrawHorizontalLineAlpha(var2 + 1, var3 + 17, var4 - 2, 2827810, var1);
      this.rasterizerDrawCircleAlpha(var2 + 2, var3 + var5 - 3, 0, 2827810, var1);
      this.rasterizerDrawCircleAlpha(var2 + var4 - 3, var3 + var5 - 3, 0, 2827810, var1);
      this.rasterizerDrawGradientAlpha(var2 + 2, var3 + 1, var4 - 4, 16, 3288610, 592388, var1, var1);
      this.rasterizerFillRectangleAlpha(var2 + 1, var3 + 1, 2, 4, 2827810, var1);
      this.rasterizerFillRectangleAlpha(var2 + var4 - 3, var3 + 1, 2, 4, 2827810, var1);
      this.rasterizerDrawHorizontalLineAlpha(var2 + 2, var3 + 18, var4 - 4, 5392957, var1);
      this.rasterizerDrawHorizontalLineAlpha(var2 + 3, var3 + var5 - 3, var4 - 6, 5392957, var1);
      this.rasterizerDrawVerticalLineAlpha(var2 + 2, var3 + 18, var5 - 21, 5392957, var1);
      this.rasterizerDrawVerticalLineAlpha(var2 + var4 - 3, var3 + 18, var5 - 21, 5392957, var1);
      this.rasterizerFillRectangleAlpha(var2 + 3, var3 + 19, var4 - 6, var5 - 22, 2828060, var1);
      this.rasterizerDrawCircleAlpha(var2 + 1, var3 + 1, 0, 7170651, var1);
      this.rasterizerDrawCircleAlpha(var2 + var4 - 2, var3 + 1, 0, 7170651, var1);
      this.rasterizerDrawCircleAlpha(var2 + 1, var3 + var5 - 2, 0, 7170651, var1);
      this.rasterizerDrawCircleAlpha(var2 + var4 - 2, var3 + var5 - 2, 0, 7170651, var1);
      RSFont var6 = this.getFontBold12();
      var6.drawTextLeftAligned("Choose Option", var2 + 3, var3 + 14, 13023381, -1);
      int var7 = this.getMouseX();
      int var8 = this.getMouseY();
      int var9 = this.getMenuOptionCount();
      String[] var10 = this.getMenuTargets();
      String[] var11 = this.getMenuOptions();

      for(int var12 = 0; var12 < var9; ++var12) {
         int var13 = (var9 - 1 - var12) * 15 + var3 + 31;
         String var14 = var11[var12];
         if(!var10[var12].isEmpty()) {
            var14 = var14 + " " + var10[var12];
         }

         var6.drawTextLeftAligned(var14, var2 + 3, var13, 13023381, -1);
         if(var7 > var2 && var7 < var4 + var2 && var8 > var13 - 13 && var8 < var13 + 3) {
            this.rasterizerFillRectangleAlpha(var2 + 3, var13 - 12, var4 - 6, 15, 16777215, 80);
         }
      }

   }

   public void drawOriginalMenu(int var1) {
      int var2 = this.getMenuX();
      int var3 = this.getMenuY();
      int var4 = this.getMenuWidth();
      int var5 = this.getMenuHeight();
      this.rasterizerFillRectangleAlpha(var2, var3, var4, var5, 6116423, var1);
      this.rasterizerDrawRectangleAlpha(var2, var3, var4, var5, 6116423, var1);
      this.rasterizerFillRectangleAlpha(var2 + 1, var3 + 1, var4 - 2, 16, 0, var1);
      this.rasterizerDrawRectangleAlpha(var2 + 1, var3 + 18, var4 - 2, var5 - 19, 0, var1);
      RSFont var6 = this.getFontBold12();
      var6.drawTextLeftAligned("Choose Option", var2 + 3, var3 + 14, 6116423, -1);
      int var7 = this.getMouseX();
      int var8 = this.getMouseY();
      int var9 = this.getMenuOptionCount();
      String[] var10 = this.getMenuTargets();
      String[] var11 = this.getMenuOptions();

      for(int var12 = 0; var12 < var9; ++var12) {
         int var13 = (var9 - 1 - var12) * 15 + var3 + 31;
         String var14 = var11[var12];
         if(!var10[var12].isEmpty()) {
            var14 = var14 + " " + var10[var12];
         }

         int var15 = 16777215;
         if(var7 > var2 && var7 < var4 + var2 && var8 > var13 - 13 && var8 < var13 + 3) {
            var15 = 16776960;
         }

         var6.drawTextLeftAligned(var14, var2 + 3, var13, var15, -1);
      }

   }

   public MenuEntry getLeftClickMenuEntry() {
      int var1 = this.getMenuOptionCount() - 1;
      return new MenuEntry(this.getMenuOptions()[var1], this.getMenuTargets()[var1], this.getMenuIdentifiers()[var1], this.getMenuOpcodes()[var1], this.getMenuArguments1()[var1], this.getMenuArguments2()[var1], this.getMenuForceLeftClick()[var1]);
   }

   public void setLeftClickMenuEntry(MenuEntry var1) {
      int var2 = this.getMenuOptionCount() - 1;
      this.getMenuOptions()[var2] = var1.getOption();
      this.getMenuTargets()[var2] = var1.getTarget();
      this.getMenuIdentifiers()[var2] = var1.getIdentifier();
      this.getMenuOpcodes()[var2] = var1.getOpcode();
      this.getMenuArguments1()[var2] = var1.getParam0();
      this.getMenuArguments2()[var2] = var1.getParam1();
      this.getMenuForceLeftClick()[var2] = var1.isForceLeftClick();
   }

   public void setTempMenuEntry(MenuEntry var1) {
      if(var1 != null && AbstractWorldMapIcon.tempMenuAction != null) {
         AbstractWorldMapIcon.tempMenuAction.setOption(var1.getOption());
         AbstractWorldMapIcon.tempMenuAction.setOpcode(var1.getOpcode());
         AbstractWorldMapIcon.tempMenuAction.setIdentifier(var1.getIdentifier());
         AbstractWorldMapIcon.tempMenuAction.setParam0(var1.getParam0());
         AbstractWorldMapIcon.tempMenuAction.setParam1(var1.getParam1());
      }
   }

   public void openWorldHopper() {
      this.invokeMenuAction("World Switcher", "", 1, MenuOpcode.CC_OP.getId(), -1, WidgetInfo.WORLD_SWITCHER_BUTTON.getId());
   }

   public void hopToWorld(net.runelite.api.World var1) {
      int var2 = var1.getId();
      this.invokeMenuAction("Switch", "<col=ff9040>" + (var2 - 300) + "</col>", 1, MenuOpcode.CC_OP.getId(), var2, WidgetInfo.WORLD_SWITCHER_LIST.getId());
   }

   public void setShouldRenderLoginScreenFire(boolean var1) {
      shouldRenderLoginScreenFire = var1;
   }

   public boolean shouldRenderLoginScreenFire() {
      return shouldRenderLoginScreenFire;
   }

   public void setLoginScreen(net.runelite.api.Sprite var1) {
      if(!$assertionsDisabled && !WorldMapSection1.client.isClientThread()) {
         throw new AssertionError("setLoginScreen must be called on client thread");
      } else {
         loginScreenBackground = var1;
         WorldMapSection1.client.clearLoginScreen(false);
         if(WorldMapSection1.client.getGameState() == GameState.LOGIN_SCREEN) {
            try {
               WorldMapSection1.client.setGameState(GameState.UNKNOWN);
            } finally {
               WorldMapSection1.client.setGameState(GameState.LOGIN_SCREEN);
            }
         }

      }
   }

   public void setPrintMenuActions(boolean var1) {
      printMenuActions = var1;
   }

   public void setHideDisconnect(boolean var1) {
      hideDisconnect = var1;
   }

   public void setHideFriendAttackOptions(boolean var1) {
      hideFriendAttackOptions = var1;
   }

   public void setHideFriendCastOptions(boolean var1) {
      hideFriendCastOptions = var1;
   }

   public void setHideClanmateAttackOptions(boolean var1) {
      hideClanmateAttackOptions = var1;
   }

   public void setHideClanmateCastOptions(boolean var1) {
      hideClanmateCastOptions = var1;
   }

   public void setAllWidgetsAreOpTargetable(boolean var1) {
      allWidgetsAreOpTargetable = var1;
   }

   public void setUnhiddenCasts(Set var1) {
      unhiddenCasts = var1;
   }

   public DrawCallbacks getDrawCallbacks() {
      return this.drawCallbacks;
   }

   public void setDrawCallbacks(DrawCallbacks var1) {
      this.drawCallbacks = var1;
   }

   public Logger getLogger() {
      return this.logger;
   }

   public boolean isInterpolatePlayerAnimations() {
      return interpolatePlayerAnimations;
   }

   public void setInterpolatePlayerAnimations(boolean var1) {
      interpolatePlayerAnimations = var1;
   }

   public boolean isInterpolateNpcAnimations() {
      return interpolateNpcAnimations;
   }

   public void setInterpolateNpcAnimations(boolean var1) {
      interpolateNpcAnimations = var1;
   }

   public boolean isInterpolateObjectAnimations() {
      return interpolateObjectAnimations;
   }

   public void setInterpolateObjectAnimations(boolean var1) {
      interpolateObjectAnimations = var1;
   }

   public boolean isInterpolateWidgetAnimations() {
      return interpolateWidgetAnimations;
   }

   public void setInterpolateWidgetAnimations(boolean var1) {
      interpolateWidgetAnimations = var1;
   }

   public void setInventoryDragDelay(int var1) {
      inventoryDragDelay = var1;
   }

   public boolean isHdMinimapEnabled() {
      return hdMinimapEnabled;
   }

   public void setHdMinimapEnabled(boolean var1) {
      hdMinimapEnabled = var1;
   }

   public AccountType getAccountType() {
      int var1 = this.getVar(Varbits.ACCOUNT_TYPE);
      switch(var1) {
      case 1:
         return AccountType.IRONMAN;
      case 2:
         return AccountType.ULTIMATE_IRONMAN;
      case 3:
         return AccountType.HARDCORE_IRONMAN;
      default:
         return AccountType.NORMAL;
      }
   }

   public net.runelite.api.Tile getSelectedSceneTile() {
      int var1 = this.getSelectedSceneTileX();
      int var2 = this.getSelectedSceneTileY();
      return var1 != -1 && var2 != -1?this.getScene().getTiles()[this.getPlane()][var1][var2]:null;
   }

   public List getPlayers() {
      int var1 = this.getPlayerIndexesCount();
      int[] var2 = this.getPlayerIndices();
      RSPlayer[] var3 = this.getCachedPlayers();
      ArrayList var4 = new ArrayList(var1);

      for(int var5 = 0; var5 < var1; ++var5) {
         var4.add(var3[var2[var5]]);
      }

      return var4;
   }

   public List getNpcs() {
      int var1 = this.getNpcIndexesCount();
      int[] var2 = this.getNpcIndices();
      RSNPC[] var3 = this.getCachedNPCs();
      ArrayList var4 = new ArrayList(var1);

      for(int var5 = 0; var5 < var1; ++var5) {
         var4.add(var3[var2[var5]]);
      }

      return var4;
   }

   public int getBoostedSkillLevel(Skill var1) {
      int[] var2 = this.getBoostedSkillLevels();
      return var2[var1.ordinal()];
   }

   public int getRealSkillLevel(Skill var1) {
      int[] var2 = this.getRealSkillLevels();
      return var2[var1.ordinal()];
   }

   public int getTotalLevel() {
      int var1 = 0;
      int[] var2 = WorldMapSection1.client.getRealSkillLevels();
      int var3 = Skill.CONSTRUCTION.ordinal();

      for(int var4 = 0; var4 < var2.length; ++var4) {
         if(var4 <= var3) {
            var1 += var2[var4];
         }
      }

      return var1;
   }

   public void addChatMessage(ChatMessageType var1, String var2, String var3, String var4) {
      this.addChatMessage(var1.getType(), var2, var3, var4);
   }

   public Point getMouseCanvasPosition() {
      return new Point(this.getMouseX(), this.getMouseY());
   }

   public net.runelite.api.widgets.Widget[] getWidgetRoots() {
      int var1 = this.getWidgetRoot();
      if(var1 == -1) {
         return new net.runelite.api.widgets.Widget[0];
      } else {
         ArrayList var2 = new ArrayList();
         RSWidget[] var3 = this.getWidgets()[var1];
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            RSWidget var6 = var3[var5];
            if(var6 != null && var6.getRSParentId() == -1) {
               var2.add(var6);
            }
         }

         return (net.runelite.api.widgets.Widget[])var2.toArray(new net.runelite.api.widgets.Widget[var2.size()]);
      }
   }

   public RSWidget[] getGroup(int var1) {
      RSWidget[][] var2 = this.getWidgets();
      return var2 != null && var1 >= 0 && var1 < var2.length && var2[var1] != null?var2[var1]:null;
   }

   public int getVar(VarPlayer var1) {
      int[] var2 = this.getVarps();
      return var2[var1.getId()];
   }

   public int getVarpValue(int var1) {
      return this.getVarpValue(this.getVarps(), var1);
   }

   public void setVarpValue(int[] var1, int var2, int var3) {
      var1[var2] = var3;
   }

   public boolean isPrayerActive(Prayer var1) {
      return this.getVar(var1.getVarbit()) == 1;
   }

   public int getSkillExperience(Skill var1) {
      int[] var2 = this.getSkillExperiences();
      if(var1 == Skill.OVERALL) {
         this.logger.debug("getSkillExperience called for {}!", var1);
         return (int)this.getOverallExperience();
      } else {
         int var3 = var1.ordinal();
         return var3 >= var2.length?-1:var2[var3];
      }
   }

   public void refreshChat() {
      this.setChatCycle(this.getCycleCntr());
   }

   public net.runelite.api.widgets.Widget getViewportWidget() {
      return this.isResized()?(this.getVar(Varbits.SIDE_PANELS) == 1?this.getWidget(WidgetInfo.RESIZABLE_VIEWPORT_BOTTOM_LINE):this.getWidget(WidgetInfo.RESIZABLE_VIEWPORT_OLD_SCHOOL_BOX)):this.getWidget(WidgetInfo.FIXED_VIEWPORT);
   }

   public List getProjectiles() {
      ArrayList var1 = new ArrayList();
      RSNodeDeque var2 = this.getProjectilesDeque();
      RSNode var3 = var2.getHead();

      for(net.runelite.api.Node var4 = var3.getNext(); var4 != var3; var4 = var4.getNext()) {
         var1.add((net.runelite.api.Projectile)var4);
      }

      return var1;
   }

   public List getGraphicsObjects() {
      ArrayList var1 = new ArrayList();
      RSNodeDeque var2 = this.getGraphicsObjectDeque();
      RSNode var3 = var2.getHead();

      for(net.runelite.api.Node var4 = var3.getNext(); var4 != var3; var4 = var4.getNext()) {
         var1.add((net.runelite.api.GraphicsObject)var4);
      }

      return var1;
   }

   public void setModIcons(net.runelite.api.IndexedSprite[] var1) {
      this.setRSModIcons((RSIndexedSprite[])var1);
   }

   public LocalPoint getLocalDestinationLocation() {
      int var1 = this.getDestinationX();
      int var2 = this.getDestinationY();
      return var1 != 0 && var2 != 0?LocalPoint.fromScene(var1, var2):null;
   }

   public void changeMemoryMode(boolean var1) {
      this.setLowMemory(var1);
      this.setSceneLowMemory(var1);
      this.setAudioHighMemory(true);
      this.setObjectDefinitionLowDetail(var1);
      if(this.getGameState() == GameState.LOGGED_IN) {
         this.setGameState(GameState.LOADING);
      }

   }

   public boolean isFriended(String var1, boolean var2) {
      RSUsername var3 = this.createName(var1, this.getLoginType());
      return this.getFriendManager().isFriended(var3, var2);
   }

   public NameableContainer getFriendContainer() {
      return this.getFriendManager().getFriendContainer();
   }

   public NameableContainer getIgnoreContainer() {
      return this.getFriendManager().getIgnoreContainer();
   }

   public net.runelite.api.Sprite createItemSprite(int var1, int var2, int var3, int var4, int var5, boolean var6, int var7) {
      if(!$assertionsDisabled && !this.isClientThread()) {
         throw new AssertionError();
      } else {
         int var8 = this.get3dZoom();
         this.set3dZoom(var7);

         RSSprite var9;
         try {
            var9 = this.createItemSprite(var1, var2, var3, var4, var5, var6);
         } finally {
            this.set3dZoom(var8);
         }

         return var9;
      }
   }

   public boolean hasHintArrow() {
      return WorldMapSection1.client.getHintArrowTargetType() != HintArrowType.NONE.getValue();
   }

   public void clearHintArrow() {
      WorldMapSection1.client.setHintArrowTargetType(HintArrowType.NONE.getValue());
   }

   public void setHintArrow(net.runelite.api.NPC var1) {
      WorldMapSection1.client.setHintArrowTargetType(HintArrowType.NPC.getValue());
      WorldMapSection1.client.setHintArrowNpcTargetIdx(var1.getIndex());
   }

   public void setHintArrow(net.runelite.api.Player var1) {
      WorldMapSection1.client.setHintArrowTargetType(HintArrowType.PLAYER.getValue());
      WorldMapSection1.client.setHintArrowPlayerTargetIdx(((RSPlayer)var1).getPlayerId());
   }

   public void setHintArrow(WorldPoint var1) {
      WorldMapSection1.client.setHintArrowTargetType(HintArrowType.WORLD_POSITION.getValue());
      WorldMapSection1.client.setHintArrowX(var1.getX());
      WorldMapSection1.client.setHintArrowY(var1.getY());
      WorldMapSection1.client.setHintArrowOffsetX(64);
      WorldMapSection1.client.setHintArrowOffsetY(64);
   }

   public WorldPoint getHintArrowPoint() {
      if(this.getHintArrowType() == HintArrowType.WORLD_POSITION) {
         int var1 = WorldMapSection1.client.getHintArrowX();
         int var2 = WorldMapSection1.client.getHintArrowY();
         return new WorldPoint(var1, var2, WorldMapSection1.client.getPlane());
      } else {
         return null;
      }
   }

   public net.runelite.api.Player getHintArrowPlayer() {
      if(this.getHintArrowType() == HintArrowType.PLAYER) {
         int var1 = WorldMapSection1.client.getHintArrowPlayerTargetIdx();
         RSPlayer[] var2 = WorldMapSection1.client.getCachedPlayers();
         return var1 >= 0 && var1 < var2.length?var2[var1]:null;
      } else {
         return null;
      }
   }

   public net.runelite.api.NPC getHintArrowNpc() {
      if(this.getHintArrowType() == HintArrowType.NPC) {
         int var1 = WorldMapSection1.client.getHintArrowNpcTargetIdx();
         RSNPC[] var2 = WorldMapSection1.client.getCachedNPCs();
         return var1 >= 0 && var1 < var2.length?var2[var1]:null;
      } else {
         return null;
      }
   }

   public int getTickCount() {
      return tickCount;
   }

   public void setTickCount(int var1) {
      tickCount = var1;
   }

   public EnumSet getWorldType() {
      int var1 = this.getFlags();
      return WorldType.fromMask(var1);
   }

   public RSTileItem getLastItemDespawn() {
      return lastItemDespawn;
   }

   public void setLastItemDespawn(RSTileItem var1) {
      lastItemDespawn = var1;
   }

   public boolean isGpu() {
      return this.field958;
   }

   public void setGpu(boolean var1) {
      this.field958 = var1;
   }

   public void queueChangedSkill(Skill var1) {
      int[] var2 = WorldMapSection1.client.getChangedSkills();
      int var3 = WorldMapSection1.client.getChangedSkillsCount();
      ++var3;
      var2[var3 - 1 & 31] = var1.ordinal();
      WorldMapSection1.client.setChangedSkillsCount(var3);
   }

   public void setSkyboxColor(int var1) {
      skyboxColor = var1;
   }

   public int getSkyboxColor() {
      return skyboxColor;
   }

   public net.runelite.api.EnumDefinition getEnum(int var1) {
      if(!$assertionsDisabled && !this.isClientThread()) {
         throw new AssertionError("getEnum must be called on client thread");
      } else {
         RSEnumDefinition var2 = (RSEnumDefinition)this.enumCache.getIfPresent(Integer.valueOf(var1));
         if(var2 != null) {
            return var2;
         } else {
            var2 = this.getRsEnum(var1);
            this.enumCache.put(Integer.valueOf(var1), var2);
            return var2;
         }
      }
   }

   public void resetHealthBarCaches() {
      this.getHealthBarCache().reset();
      this.getHealthBarSpriteCache().reset();
   }

   public void addFriend(String var1) {
      RSFriendSystem var2 = this.getFriendManager();
      var2.addFriend(var1);
   }

   public void removeFriend(String var1) {
      RSFriendSystem var2 = this.getFriendManager();
      var2.removeFriend(var1);
   }

   public void setModulus(BigInteger var1) {
      modulus = var1;
   }

   public void setMusicVolume(int var1) {
      if(var1 > 0 && WorldMapSection1.client.getMusicVolume() <= 0 && WorldMapSection1.client.getCurrentTrackGroupId() != -1) {
         WorldMapSection1.client.playMusicTrack(1000, WorldMapSection1.client.getMusicTracks(), WorldMapSection1.client.getCurrentTrackGroupId(), 0, var1, false);
      }

      WorldMapSection1.client.setClientMusicVolume(var1);
      WorldMapSection1.client.setMusicTrackVolume(var1);
      if(WorldMapSection1.client.getMidiPcmStream() != null) {
         WorldMapSection1.client.getMidiPcmStream().setPcmStreamVolume(var1);
      }

   }

   public void setInvertPitch(boolean var1) {
      invertPitch = var1;
   }

   public void setInvertYaw(boolean var1) {
      invertYaw = var1;
   }

   public void stopNow() {
      this.setStopTimeMs(1L);
   }

   public boolean isMirrored() {
      return this.isMirrored;
   }

   public void setMirrored(boolean var1) {
      this.isMirrored = var1;
   }

   public net.runelite.api.ObjectDefinition getObjectDefinition(int var1) {
      if(!$assertionsDisabled && !this.isClientThread()) {
         throw new AssertionError("getObjectDefinition must be called on client thread");
      } else {
         return this.getRSObjectDefinition(var1);
      }
   }

   public net.runelite.api.ItemDefinition getItemDefinition(int var1) {
      if(!$assertionsDisabled && !this.isClientThread()) {
         throw new AssertionError("getItemDefinition must be called on client thread");
      } else {
         return this.getRSItemDefinition(var1);
      }
   }

   public net.runelite.api.NPCDefinition getNpcDefinition(int var1) {
      if(!$assertionsDisabled && !this.isClientThread()) {
         throw new AssertionError("getNpcDefinition must be called on client thread");
      } else {
         return this.getRSNpcDefinition(var1);
      }
   }

   public void setIsHidingEntities(boolean var1) {
      isHidingEntities = var1;
   }

   public void setPlayersHidden(boolean var1) {
      hidePlayers = var1;
   }

   public void setPlayersHidden2D(boolean var1) {
      hidePlayers2D = var1;
   }

   public void setFriendsHidden(boolean var1) {
      hideFriends = var1;
   }

   public void setClanMatesHidden(boolean var1) {
      hideClanMates = var1;
   }

   public void setLocalPlayerHidden(boolean var1) {
      hideLocalPlayer = var1;
   }

   public void setLocalPlayerHidden2D(boolean var1) {
      hideLocalPlayer2D = var1;
   }

   public void setNPCsHidden(boolean var1) {
      hideNPCs = var1;
   }

   public void setNPCsHidden2D(boolean var1) {
      hideNPCs2D = var1;
   }

   public void addHiddenNpcName(String var1) {
      var1 = var1.toLowerCase();
      int var2 = ((Integer)hiddenNpcsName.getOrDefault(var1, Integer.valueOf(0))).intValue();
      if(var2 == Integer.MAX_VALUE) {
         throw new RuntimeException("NPC name " + var1 + " has been hidden Integer.MAX_VALUE times, is something wrong?");
      } else {
         ++var2;
         hiddenNpcsName.put(var1, Integer.valueOf(var2));
      }
   }

   public void removeHiddenNpcName(String var1) {
      var1 = var1.toLowerCase();
      int var2 = ((Integer)hiddenNpcsName.getOrDefault(var1, Integer.valueOf(0))).intValue();
      if(var2 != 0) {
         --var2;
         hiddenNpcsName.put(var1, Integer.valueOf(var2));
      }
   }

   public void forciblyUnhideNpcName(String var1) {
      var1 = var1.toLowerCase();
      hiddenNpcsName.put(var1, Integer.valueOf(0));
   }

   public void addHiddenNpcDeath(String var1) {
      var1 = var1.toLowerCase();
      int var2 = ((Integer)hiddenNpcsDeath.getOrDefault(var1, Integer.valueOf(0))).intValue();
      if(var2 == Integer.MAX_VALUE) {
         throw new RuntimeException("NPC death " + var1 + " has been hidden Integer.MAX_VALUE times, is something wrong?");
      } else {
         ++var2;
         hiddenNpcsDeath.put(var1, Integer.valueOf(var2));
      }
   }

   public void removeHiddenNpcDeath(String var1) {
      var1 = var1.toLowerCase();
      int var2 = ((Integer)hiddenNpcsDeath.getOrDefault(var1, Integer.valueOf(0))).intValue();
      if(var2 != 0) {
         --var2;
         hiddenNpcsDeath.put(var1, Integer.valueOf(var2));
      }
   }

   public void forciblyUnhideNpcDeath(String var1) {
      var1 = var1.toLowerCase();
      hiddenNpcsDeath.put(var1, Integer.valueOf(0));
   }

   public void setHideSpecificPlayers(List var1) {
      hideSpecificPlayers = var1;
   }

   public void setBlacklistDeadNpcs(Set var1) {
      blacklistDeadNpcs = var1;
   }

   public void setPetsHidden(boolean var1) {
      hidePets = var1;
   }

   public void setAttackersHidden(boolean var1) {
      hideAttackers = var1;
   }

   public void setProjectilesHidden(boolean var1) {
      hideProjectiles = var1;
   }

   public void setDeadNPCsHidden(boolean var1) {
      hideDeadNPCs = var1;
   }

   public Map getSpriteOverrides() {
      return spriteOverrides;
   }

   public Map getWidgetSpriteOverrides() {
      return widgetSpriteOverrides;
   }

   public void setCameraPitchRelaxerEnabled(boolean var1) {
      if(pitchRelaxEnabled != var1) {
         pitchRelaxEnabled = var1;
         if(!var1) {
            int var2 = WorldMapSection1.client.getCameraPitchTarget();
            if(var2 > 383) {
               WorldMapSection1.client.setCameraPitchTarget(383);
            }
         }

      }
   }

   public boolean getComplianceValue(String var1) {
      return var1 == null?false:(complianceMap.containsKey(var1)?((Boolean)complianceMap.get(var1)).booleanValue():false);
   }

   public void setComplianceValue(String var1, boolean var2) {
      if(var1 != null) {
         WorldMapSection1.client.getLogger().debug("Compliance: {} being set to {}", var1, Boolean.valueOf(var2));
         complianceMap.put(var1, Boolean.valueOf(var2));
      }
   }

   public void setStretchedEnabled(boolean var1) {
      stretchedEnabled = var1;
   }

   public boolean isStretchedFast() {
      return stretchedFast;
   }

   public void setStretchedFast(boolean var1) {
      stretchedFast = var1;
   }

   public void setStretchedIntegerScaling(boolean var1) {
      stretchedIntegerScaling = var1;
   }

   public void setStretchedKeepAspectRatio(boolean var1) {
      stretchedKeepAspectRatio = var1;
   }

   public void setScalingFactor(int var1) {
      scalingFactor = 1.0D + (double)var1 / 100.0D;
   }

   public double getScalingFactor() {
      return scalingFactor;
   }

   public Dimension getStretchedDimensions() {
      if(cachedStretchedDimensions == null) {
         Container var1 = this.getCanvas().getParent();
         int var2 = var1.getWidth();
         int var3 = var1.getHeight();
         Dimension var4 = this.getRealDimensions();
         if(stretchedKeepAspectRatio) {
            double var5 = var4.getWidth() / var4.getHeight();
            int var7 = (int)((double)var3 * var5);
            if(var7 > var2) {
               var3 = (int)((double)var2 / var5);
            } else {
               var2 = var7;
            }
         }

         if(stretchedIntegerScaling) {
            if(var2 > var4.width) {
               var2 -= var2 % var4.width;
            }

            if(var3 > var4.height) {
               var3 -= var3 % var4.height;
            }
         }

         cachedStretchedDimensions = new Dimension(var2, var3);
      }

      return cachedStretchedDimensions;
   }

   public void invalidateStretching(boolean var1) {
      cachedRealDimensions = null;
      cachedStretchedDimensions = null;
      if(var1 && this.isResized()) {
         this.setResizeCanvasNextFrame(true);
      }

   }

   public void checkClickbox(net.runelite.api.Model var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, long var10) {
      RSModel var12 = (RSModel)var1;
      boolean var13 = var10 != 0L && (int)(var10 >>> 16 & 1L) != 1;
      boolean var14 = WorldMapSection1.client.getViewportContainsMouse();
      if(var13 && var14 && (WorldMapSection1.client.getOculusOrbState() == 0 || WorldMapSection1.client.getComplianceValue("orbInteraction"))) {
         if(this.boundingboxCheck(var12, var7, var8, var9)) {
            if(Math.sqrt((double)(var7 * var7 + var9 * var9)) <= 12800.0D) {
               if(var12.isClickable()) {
                  this.addHashAtMouse(var10);
               } else {
                  int var15 = var12.getVerticesCount();
                  int var16 = var12.getTrianglesCount();
                  int[] var17 = var12.getVerticesX();
                  int[] var18 = var12.getVerticesY();
                  int[] var19 = var12.getVerticesZ();
                  int[] var20 = var12.getTrianglesX();
                  int[] var21 = var12.getTrianglesY();
                  int[] var22 = var12.getTrianglesZ();
                  int[] var23 = var12.getFaceColors3();
                  int var24 = WorldMapSection1.client.get3dZoom();
                  int var25 = WorldMapSection1.client.getCenterX();
                  int var26 = WorldMapSection1.client.getCenterY();
                  int var27 = 0;
                  int var28 = 0;
                  if(var2 != 0) {
                     var27 = Perspective.SINE[var2];
                     var28 = Perspective.COSINE[var2];
                  }

                  int var29;
                  int var30;
                  int var31;
                  int var32;
                  int var33;
                  for(var29 = 0; var29 < var15; ++var29) {
                     var30 = var17[var29];
                     var31 = var18[var29];
                     var32 = var19[var29];
                     if(var2 != 0) {
                        var33 = var32 * var27 + var30 * var28 >> 16;
                        var32 = var32 * var28 - var30 * var27 >> 16;
                        var30 = var33;
                     }

                     var30 += var7;
                     var31 += var8;
                     var32 += var9;
                     var33 = var30 * var6 + var5 * var32 >> 16;
                     var32 = var32 * var6 - var5 * var30 >> 16;
                     var30 = var33;
                     var33 = var31 * var4 - var3 * var32 >> 16;
                     var32 = var32 * var4 + var3 * var31 >> 16;
                     if(var32 >= 50) {
                        rl$modelViewportYs[var29] = var30 * var24 / var32 + var25;
                        rl$modelViewportXs[var29] = var33 * var24 / var32 + var26;
                     } else {
                        rl$modelViewportYs[var29] = -5000;
                     }
                  }

                  var29 = WorldMapSection1.client.getViewportMouseX();
                  var30 = WorldMapSection1.client.getViewportMouseY();

                  for(var31 = 0; var31 < var16; ++var31) {
                     if(var23[var31] != -2) {
                        var32 = var20[var31];
                        var33 = var21[var31];
                        int var34 = var22[var31];
                        int var35 = rl$modelViewportYs[var32];
                        int var36 = rl$modelViewportYs[var33];
                        int var37 = rl$modelViewportYs[var34];
                        int var38 = rl$modelViewportXs[var32];
                        int var39 = rl$modelViewportXs[var33];
                        int var40 = rl$modelViewportXs[var34];
                        if(var35 != -5000 && var36 != -5000 && var37 != -5000) {
                           int var41 = var12.isClickable()?20:5;
                           int var42 = var41 + var30;
                           boolean var43;
                           if(var42 < var38 && var42 < var39 && var42 < var40) {
                              var43 = false;
                           } else {
                              var42 = var30 - var41;
                              if(var42 > var38 && var42 > var39 && var42 > var40) {
                                 var43 = false;
                              } else {
                                 var42 = var41 + var29;
                                 if(var42 < var35 && var42 < var36 && var42 < var37) {
                                    var43 = false;
                                 } else {
                                    var42 = var29 - var41;
                                    if(var42 > var35 && var42 > var36 && var42 > var37) {
                                       var43 = false;
                                    } else {
                                       var43 = true;
                                    }
                                 }
                              }
                           }

                           if(var43) {
                              this.addHashAtMouse(var10);
                              break;
                           }
                        }
                     }
                  }

               }
            }
         }
      }
   }

   public RSIndexedSprite createIndexedSprite() {
      return new IndexedSprite();
   }

   public RSWorld createWorld() {
      return new World();
   }

   public RSWidget createWidget() {
      return new Widget();
   }

   public RSTileItem newTileItem() {
      return new TileItem();
   }

   public RSNodeDeque newNodeDeque() {
      return new NodeDeque();
   }

   public int getCameraZ() {
      return GrandExchangeOfferWorldComparator.cameraY;
   }

   public int getSelectedSpellWidget() {
      return class7.selectedSpellWidget;
   }

   public void setSelectedSpellWidget(int var1) {
      class7.selectedSpellWidget = var1;
   }

   public int getCameraY() {
      return class200.cameraZ;
   }

   public void setRSGameState(int var1) {
      MouseRecorder.method1293(var1);
   }

   public RSSprite[] getCrossSprites() {
      return class299.crossSprites;
   }

   public RSSprite[] getMapDots() {
      return VarpDefinition.mapDotSprites;
   }

   public int getRevision() {
      return RunException.RunException_revision;
   }

   public int[][] getXteaKeys() {
      return UrlRequester.xteaKeys;
   }

   public int getCameraYaw() {
      return WorldMapIcon_1.cameraYaw;
   }

   public int getCameraPitch() {
      return ApproximateRouteStrategy.cameraPitch;
   }

   public void setCameraPitch(int var1) {
      ApproximateRouteStrategy.cameraPitch = var1;
   }

   public void setSelectedItemID(int var1) {
      FaceNormal.selectedItemId = var1;
   }

   public void playMusicTrack(int var1, RSAbstractArchive var2, int var3, int var4, int var5, boolean var6) {
      FaceNormal.method3378(var1, (AbstractArchive)var2, var3, var4, var5, var6);
   }

   public void setRightTitleSprite(net.runelite.api.Sprite var1) {
      DirectByteArrayCopier.rightTitleSprite = (Sprite)var1;
   }

   public int getBaseY() {
      return class89.baseY * 64;
   }

   public int getOculusOrbFocalPointY() {
      return ServerPacket.oculusOrbFocalPointY;
   }

   public RSWidget getDraggedWidget() {
      return clickedWidget;
   }

   public int getRootWidgetCount() {
      return rootWidgetCount;
   }

   public int getWidgetClickX() {
      return widgetClickX;
   }

   public int getWidgetClickY() {
      return widgetClickY;
   }

   public RSNodeHashTable getWidgetFlags() {
      return widgetClickMasks;
   }

   public int[] getWidgetPositionsX() {
      return rootWidgetXs;
   }

   public int getGameDrawingMode() {
      return gameDrawingMode;
   }

   public void setGameDrawingMode(int var1) {
      gameDrawingMode = var1;
   }

   public int getStaffModLevel() {
      return staffModLevel;
   }

   public int[] getWidgetPositionsY() {
      return rootWidgetYs;
   }

   public int getTradeChatMode() {
      return tradeChatMode;
   }

   public int getPublicChatMode() {
      return publicChatMode;
   }

   public boolean isDraggingWidget() {
      return isDraggingWidget;
   }

   public int getCurrentTrackGroupId() {
      return currentTrackGroupId;
   }

   public int getEnergy() {
      return runEnergy;
   }

   public int getWeight() {
      return weight;
   }

   public int getAreaSoundEffectVolume() {
      return areaSoundEffectVolume;
   }

   public void setAreaSoundEffectVolume(int var1) {
      areaSoundEffectVolume = var1;
   }

   public RSWidget getDraggedOnWidget() {
      return draggedOnWidget;
   }

   public void setDraggedOnWidget(net.runelite.api.widgets.Widget var1) {
      draggedOnWidget = (Widget)var1;
   }

   public int getMusicVolume() {
      return musicVolume;
   }

   public void setClientMusicVolume(int var1) {
      musicVolume = var1;
   }

   public void setSoundEffectVolume(int var1) {
      soundEffectVolume = var1;
   }

   public int getScale() {
      return viewportZoom;
   }

   public int getViewportWidth() {
      return viewportWidth;
   }

   public int[] getChangedSkills() {
      return changedSkills;
   }

   public int[] getChangedSkillLevels() {
      return changedSkills;
   }

   public int getChangedSkillsCount() {
      return changedSkillsCount;
   }

   public void setChangedSkillsCount(int var1) {
      changedSkillsCount = var1;
   }

   public RSSprite[] getMapIcons() {
      return mapIcons;
   }

   public int getViewportHeight() {
      return viewportHeight;
   }

   public int getViewportXOffset() {
      return viewportOffsetX;
   }

   public int getViewportYOffset() {
      return viewportOffsetY;
   }

   public RSGrandExchangeOffer[] getGrandExchangeOffers() {
      return grandExchangeOffers;
   }

   public RSCollisionMap[] getCollisionMaps() {
      return collisionMaps;
   }

   public int getWorld() {
      return worldId;
   }

   public int getClientType() {
      return clientType;
   }

   public boolean isOnMobile() {
      return onMobile;
   }

   public int getGameCycle() {
      return cycle;
   }

   public long getClientMouseLastPressedMillis() {
      return mouseLastLastPressedTimeMillis;
   }

   public void setClientMouseLastPressedMillis(long var1) {
      mouseLastLastPressedTimeMillis = var1;
   }

   public boolean hadFocus() {
      return hadFocus;
   }

   public void setHintArrowTargetType(int var1) {
      hintArrowType = var1;
   }

   public int getHintArrowTargetType() {
      return hintArrowType;
   }

   public void setHintArrowNpcTargetIdx(int var1) {
      hintArrowNpcIndex = var1;
   }

   public int getHintArrowNpcTargetIdx() {
      return hintArrowNpcIndex;
   }

   public void setHintArrowPlayerTargetIdx(int var1) {
      hintArrowPlayerIndex = var1;
   }

   public int getHintArrowPlayerTargetIdx() {
      return hintArrowPlayerIndex;
   }

   public void setHintArrowX(int var1) {
      hintArrowX = var1;
   }

   public int getHintArrowX() {
      return hintArrowX;
   }

   public void setHintArrowY(int var1) {
      hintArrowY = var1;
   }

   public int getHintArrowY() {
      return hintArrowY;
   }

   public void setHintArrowOffsetX(int var1) {
      hintArrowSubX = var1;
   }

   public void setHintArrowOffsetY(int var1) {
      hintArrowSubY = var1;
   }

   public boolean isInInstancedRegion() {
      return isInInstance;
   }

   public int[][][] getInstanceTemplateChunks() {
      return instanceChunkTemplates;
   }

   public int getCameraPitchTarget() {
      return camAngleX;
   }

   public void setCameraPitchTarget(int var1) {
      camAngleX = var1;
   }

   public int getMapAngle() {
      return camAngleY;
   }

   public int getCamAngleDY() {
      return camAngleDY;
   }

   public void setCamAngleDY(int var1) {
      camAngleDY = var1;
   }

   public int getCamAngleDX() {
      return camAngleDX;
   }

   public void setCamAngleDX(int var1) {
      camAngleDX = var1;
   }

   public int getOculusOrbState() {
      return oculusOrbState;
   }

   public void setOculusOrbState(int var1) {
      oculusOrbState = var1;
   }

   public void setOculusOrbNormalSpeed(int var1) {
      oculusOrbNormalSpeed = var1;
   }

   public int[][] getOccupiedTilesTick() {
      return tileLastDrawnActor;
   }

   public int getMouseCrossColor() {
      return mouseCrossColor;
   }

   public void setMouseCrossColor(int var1) {
      mouseCrossColor = var1;
   }

   public void setShowMouseCross(boolean var1) {
      showMouseCross = var1;
   }

   public int getIf1DraggedItemIndex() {
      return dragItemSlotSource;
   }

   public int getDraggedWidgetX() {
      return draggedWidgetX;
   }

   public int getDraggedWidgetY() {
      return draggedWidgetY;
   }

   public int getItemPressedDuration() {
      return itemDragDuration;
   }

   public void setItemPressedDuration(int var1) {
      itemDragDuration = var1;
   }

   public boolean getShowLoadingMessages() {
      return showLoadingMessages;
   }

   public void setShowLoadingMessages(boolean var1) {
      showLoadingMessages = var1;
   }

   public int getLocalPlayerIndex() {
      return localPlayerIndex;
   }

   public boolean getRenderSelf() {
      return renderSelf;
   }

   public void setRenderSelf(boolean var1) {
      renderSelf = var1;
   }

   public int[] getPlayerMenuTypes() {
      return playerMenuOpcodes;
   }

   public String[] getPlayerOptions() {
      return playerMenuActions;
   }

   public boolean[] getPlayerOptionsPriorities() {
      return playerOptionsPriorities;
   }

   public int[] getDefaultRotations() {
      return defaultRotations;
   }

   public int getLocalInteractingIndex() {
      return combatTargetPlayerIndex;
   }

   public RSNodeDeque[][][] getGroundItemDeque() {
      return groundItems;
   }

   public int getLeftClickOpensMenu() {
      return leftClickOpensMenu;
   }

   public boolean isMenuOpen() {
      return isMenuOpen;
   }

   public boolean getShowMouseOverText() {
      return showMouseOverText;
   }

   public void setShowMouseOverText(boolean var1) {
      showMouseOverText = var1;
   }

   public void setSelectedItemSlot(int var1) {
      selectedItemSlot = var1;
   }

   public void setSpellSelected(boolean var1) {
      isSpellSelected = var1;
   }

   public boolean isSpellSelected() {
      return isSpellSelected;
   }

   public int getSelectedSpellChildIndex() {
      return selectedSpellChildIndex;
   }

   public void setSelectedSpellChildIndex(int var1) {
      selectedSpellChildIndex = var1;
   }

   public String getSelectedSpellName() {
      return selectedSpellName;
   }

   public void setSelectedSpellName(String var1) {
      selectedSpellName = var1;
   }

   public RSNodeHashTable getComponentTable() {
      return interfaceParents;
   }

   public void revalidateWidget(net.runelite.api.widgets.Widget var1) {
      this.method1419((Widget)var1);
   }

   public int getTileUpdateCount() {
      return Scene.tileUpdateCount;
   }

   public void setTileUpdateCount(int var1) {
      Scene.tileUpdateCount = var1;
   }

   public void setScenePlane(int var1) {
      Scene.Scene_plane = var1;
   }

   public int getCycle() {
      return Scene.Scene_drawnCount;
   }

   public void setCycle(int var1) {
      Scene.Scene_drawnCount = var1;
   }

   public void setMinTileX(int var1) {
      Scene.Scene_cameraXTileMin = var1;
   }

   public void setMaxTileX(int var1) {
      Scene.Scene_cameraXTileMax = var1;
   }

   public void setMinTileZ(int var1) {
      Scene.Scene_cameraYTileMin = var1;
   }

   public void setMaxTileZ(int var1) {
      Scene.Scene_cameraYTileMax = var1;
   }

   public void setScreenCenterX(int var1) {
      Scene.Scene_cameraXTile = var1;
   }

   public void setScreenCenterZ(int var1) {
      Scene.Scene_cameraYTile = var1;
   }

   public int getCameraX2() {
      return Scene.Scene_cameraX;
   }

   public void setCameraX2(int var1) {
      Scene.Scene_cameraX = var1;
   }

   public int getCameraY2() {
      return Scene.Scene_cameraY;
   }

   public void setCameraY2(int var1) {
      Scene.Scene_cameraY = var1;
   }

   public int getCameraZ2() {
      return Scene.Scene_cameraZ;
   }

   public void setCameraZ2(int var1) {
      Scene.Scene_cameraZ = var1;
   }

   public void setPitchSin(int var1) {
      Scene.Scene_cameraPitchSine = var1;
   }

   public void setPitchCos(int var1) {
      Scene.Scene_cameraPitchCosine = var1;
   }

   public void setYawSin(int var1) {
      Scene.Scene_cameraYawSine = var1;
   }

   public void setYawCos(int var1) {
      Scene.Scene_cameraYawCosine = var1;
   }

   public void setCheckClick(boolean var1) {
      Scene.checkClick = var1;
   }

   public boolean isCheckClick() {
      return Scene.checkClick;
   }

   public void setMouseCanvasHoverPositionX(int var1) {
      Scene.Scene_selectedScreenX = var1;
   }

   public int getMouseX2() {
      return Scene.Scene_selectedScreenX;
   }

   public void setMouseCanvasHoverPositionY(int var1) {
      Scene.Scene_selectedScreenY = var1;
   }

   public int getMouseY2() {
      return Scene.Scene_selectedScreenY;
   }

   public void setSelectedSceneTileX(int var1) {
      Scene.Scene_selectedX = var1;
   }

   public void setSelectedSceneTileY(int var1) {
      Scene.Scene_selectedY = var1;
   }

   public void setViewportWalking(boolean var1) {
      Scene.viewportWalking = var1;
   }

   public boolean[][][][] getVisibilityMaps() {
      return Scene.visibilityMap;
   }

   public void setRenderArea(boolean[][] var1) {
      Scene.visibleTiles = var1;
   }

   public boolean containsBounds(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      return Scene.method3222(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public RSWorld[] getWorldList() {
      return UserComparator2.World_worlds;
   }

   public Map getChatLineMap() {
      return Messages.Messages_channels;
   }

   public RSIterableNodeHashTable getMessages() {
      return Messages.Messages_hashTable;
   }

   public int getItemCount() {
      return class336.ItemDefinition_fileCount;
   }

   public int[] getMapRegions() {
      return StructDefinition.regions;
   }

   public int getOculusOrbFocalPointX() {
      return SoundSystem.oculusOrbFocalPointX;
   }

   public void sendMenuAction(int var1, int var2, int var3, int var4, String var5, String var6, int var7, int var8) {
      AbstractByteArrayCopier.method4027(var1, var2, var3, var4, var5, var6, var7, var8, 2048227519);
   }

   public void setSelectedItemWidget(int var1) {
      WorldMapSection2.selectedItemWidget = var1;
   }

   public boolean[] getPressedKeys() {
      return KeyHandler.KeyHandler_pressedKeys;
   }

   public void setKeyboardIdleTicks(int var1) {
      KeyHandler.KeyHandler_idleCycles = var1;
   }

   public int getKeyboardIdleTicks() {
      return KeyHandler.KeyHandler_idleCycles;
   }

   public RSEvictingDualNodeHashTable getWidgetSpriteCache() {
      return Widget.Widget_cachedSprites;
   }

   public void scaleSprite(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12) {
      Sprite.method6285(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12);
   }

   public int getCenterX() {
      return Rasterizer3D.Rasterizer3D_clipMidX;
   }

   public int getCenterY() {
      return Rasterizer3D.Rasterizer3D_clipMidY;
   }

   public int getRasterizer3D_clipNegativeMidX() {
      return Rasterizer3D.Rasterizer3D_clipNegativeMidX;
   }

   public int getRasterizer3D_clipMidX2() {
      return Rasterizer3D.Rasterizer3D_clipMidX2;
   }

   public int getRasterizer3D_clipNegativeMidY() {
      return Rasterizer3D.Rasterizer3D_clipNegativeMidY;
   }

   public int getRasterizer3D_clipMidY2() {
      return Rasterizer3D.Rasterizer3D_clipMidY2;
   }

   public int getBaseX() {
      return class69.baseX * 64;
   }

   public void clearLoginScreen(boolean var1) {
      Login.clearLoginScreen = var1;
   }

   public void setLeftTitleSprite(net.runelite.api.Sprite var1) {
      Login.leftTitleSprite = (Sprite)var1;
   }

   public int getLoginIndex() {
      return Login.loginIndex;
   }

   public String getUsername() {
      return Login.Login_username;
   }

   public void setUsername(String var1) {
      Login.Login_username = var1;
   }

   public void setPassword(String var1) {
      Login.Login_password = var1;
   }

   public int getCurrentLoginField() {
      return Login.currentLoginField;
   }

   public int getCanvasWidth() {
      return WorldMapLabel.canvasWidth;
   }

   public RSEvictingDualNodeHashTable getCachedModels2() {
      return ObjectDefinition.ObjectDefinition_cachedModels;
   }

   public void promptCredentials(boolean var1) {
      ObjectDefinition.method4712(var1);
   }

   public RSArchive getIndexScripts() {
      return class41.archive12;
   }

   public RSTextureProvider getTextureProvider() {
      return class41.textureProvider;
   }

   public void setGeSearchResultIndex(int var1) {
      AbstractWorldMapIcon.foundItemIndex = var1;
   }

   public RSArchive getMusicTracks() {
      return AbstractWorldMapIcon.archive6;
   }

   public RSClientPreferences getPreferences() {
      return GrandExchangeOfferOwnWorldComparator.clientPreferences;
   }

   public int getFPS() {
      return GameShell.fps;
   }

   public RSIndexedSprite[] getMapScene() {
      return class169.mapSceneSprites;
   }

   public void queueSoundEffect(int var1, int var2, int var3) {
      ModelData0.method3364(var1, var2, var3);
   }

   public int getVarbit(int var1) {
      return Projectile.method2211(var1);
   }

   public void updateItemPile(int var1, int var2) {
      World.method1898(var1, var2);
   }

   public void setCompass(net.runelite.api.Sprite var1) {
      ChatChannel.compass = (Sprite)var1;
   }

   public RSMidiPcmStream getMidiPcmStream() {
      return class206.midiPcmStream;
   }

   public void setMusicTrackVolume(int var1) {
      class219.musicTrackVolume = var1;
   }

   public int[][][] getTileHeights() {
      return Tiles.Tiles_heights;
   }

   public void insertMenuItem(String var1, String var2, int var3, int var4, int var5, int var6, boolean var7) {
      ScriptFrame.method1244(var1, var2, var3, var4, var5, var6, var7);
   }

   public RSPlayer getLocalPlayer() {
      return ByteArrayPool.localPlayer;
   }

   public void setGeSearchResultCount(int var1) {
      TextureProvider.foundItemIdCount = var1;
   }

   public RSFrames getFrames(int var1) {
      return GrandExchangeEvents.method154(var1);
   }

   public RSArchive getIndexSprites() {
      return class228.archive8;
   }

   public RSVarpDefinition getVarpDefinition(int var1) {
      return class228.method4204(var1);
   }

   public int[] getGraphicsPixels() {
      return Rasterizer2D.Rasterizer2D_pixels;
   }

   public int getGraphicsPixelsWidth() {
      return Rasterizer2D.Rasterizer2D_width;
   }

   public int getGraphicsPixelsHeight() {
      return Rasterizer2D.Rasterizer2D_height;
   }

   public int getStartY() {
      return Rasterizer2D.Rasterizer2D_yClipStart;
   }

   public int getEndY() {
      return Rasterizer2D.Rasterizer2D_yClipEnd;
   }

   public int getStartX() {
      return Rasterizer2D.Rasterizer2D_xClipStart;
   }

   public int getEndX() {
      return Rasterizer2D.Rasterizer2D_xClipEnd;
   }

   public void rasterizerDrawCircle(int var1, int var2, int var3, int var4) {
      Rasterizer2D.method6102(var1, var2, var3, var4);
   }

   public void rasterizerFillRectangle(int var1, int var2, int var3, int var4, int var5) {
      Rasterizer2D.method6092(var1, var2, var3, var4, var5);
   }

   public void rasterizerDrawGradient(int var1, int var2, int var3, int var4, int var5, int var6) {
      Rasterizer2D.method6093(var1, var2, var3, var4, var5, var6);
   }

   public void rasterizerDrawRectangle(int var1, int var2, int var3, int var4, int var5) {
      Rasterizer2D.method6177(var1, var2, var3, var4, var5);
   }

   public void rasterizerDrawHorizontalLine(int var1, int var2, int var3, int var4) {
      Rasterizer2D.method6097(var1, var2, var3, var4);
   }

   public void rasterizerDrawVerticalLine(int var1, int var2, int var3, int var4) {
      Rasterizer2D.method6099(var1, var2, var3, var4);
   }

   public RSWidget getIf1DraggedWidget() {
      return class236.dragInventoryWidget;
   }

   public void setAnimOffsetX(int var1) {
      Model.Model_transformTempX = var1;
   }

   public void setAnimOffsetY(int var1) {
      Model.Model_transformTempY = var1;
   }

   public void setAnimOffsetZ(int var1) {
      Model.Model_transformTempZ = var1;
   }

   public boolean isMouseCam() {
      return class217.mouseCam;
   }

   public RSWorldMap getRenderOverview() {
      return class13.method133();
   }

   public RSEvictingDualNodeHashTable getItemDefinitionCache() {
      return ItemDefinition.ItemDefinition_cached;
   }

   public RSMouseRecorder getMouseRecorder() {
      return MidiPcmStream.mouseRecorder;
   }

   public RSWorldMapElement[] getMapElementConfigs() {
      return WorldMapElement.WorldMapElement_cached;
   }

   public void changeWorld(net.runelite.api.World var1) {
      UserComparator3.method3526((World)var1);
   }

   public RSEvictingDualNodeHashTable getVarbitCache() {
      return VarbitDefinition.VarbitDefinition_cached;
   }

   public RSClanChat getClanMemberManager() {
      return InterfaceParent.clanChat;
   }

   public int getCanvasHeight() {
      return Varps.canvasHeight;
   }

   public int[] getIntStack() {
      return Interpreter.Interpreter_intStack;
   }

   public int getIntStackSize() {
      return Interpreter.Interpreter_intStackSize;
   }

   public void setIntStackSize(int var1) {
      Interpreter.Interpreter_intStackSize = var1;
   }

   public String[] getStringStack() {
      return Interpreter.Interpreter_stringStack;
   }

   public int getStringStackSize() {
      return Interpreter.Interpreter_stringStackSize;
   }

   public void setStringStackSize(int var1) {
      Interpreter.Interpreter_stringStackSize = var1;
   }

   public void setOtp(String var1) {
      MilliClock.otp = var1;
   }

   public int getCameraX() {
      return WorldMapRectangle.cameraX;
   }

   public RSIndexedSprite[] getModIcons() {
      return AbstractFont.AbstractFont_modIconSprites;
   }

   public int getMouseIdleTicks() {
      return MouseHandler.MouseHandler_idleCycles;
   }

   public void setMouseIdleTicks(int var1) {
      MouseHandler.MouseHandler_idleCycles = var1;
   }

   public int getMouseCurrentButton() {
      return MouseHandler.MouseHandler_currentButton;
   }

   public long getMouseLastPressedMillis() {
      return MouseHandler.MouseHandler_lastPressedTimeMillis;
   }

   public void setMouseLastPressedMillis(long var1) {
      MouseHandler.MouseHandler_lastPressedTimeMillis = var1;
   }

   public void revalidateWidgetScroll(net.runelite.api.widgets.Widget[] var1, net.runelite.api.widgets.Widget var2, boolean var3) {
      MouseHandler.method1161((Widget[])var1, (Widget)var2, var3);
   }

   public void setGeSearchResultIds(short[] var1) {
      WorldMapEvent.foundItemIds = var1;
   }

   public boolean getViewportContainsMouse() {
      return ViewportMouse.ViewportMouse_isInViewport;
   }

   public int getViewportMouseX() {
      return ViewportMouse.ViewportMouse_x;
   }

   public int getViewportMouseY() {
      return ViewportMouse.ViewportMouse_y;
   }

   public int getEntitiesAtMouseCount() {
      return ViewportMouse.ViewportMouse_entityCount;
   }

   public void setEntitiesAtMouseCount(int var1) {
      ViewportMouse.ViewportMouse_entityCount = var1;
   }

   public long[] getEntitiesAtMouse() {
      return ViewportMouse.ViewportMouse_entityTags;
   }

   @ObfuscatedName("eg")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void method1444() {
      if(gameState != 1000) {
         long var2 = class217.method4036();
         int var4 = (int)(var2 - NetCache.field3165);
         NetCache.field3165 = var2;
         if(var4 > 200) {
            var4 = 200;
         }

         NetCache.NetCache_loadTime += var4;
         boolean var1;
         if(NetCache.NetCache_pendingResponsesCount == 0 && NetCache.NetCache_pendingPriorityResponsesCount == 0 && NetCache.NetCache_pendingWritesCount == 0 && NetCache.NetCache_pendingPriorityWritesCount == 0) {
            var1 = true;
         } else if(NetCache.NetCache_socket == null) {
            var1 = false;
         } else {
            try {
               if(NetCache.NetCache_loadTime > 30000) {
                  throw new IOException();
               }

               NetFileRequest var5;
               Buffer var6;
               while(NetCache.NetCache_pendingPriorityResponsesCount < 200 && NetCache.NetCache_pendingPriorityWritesCount > 0) {
                  var5 = (NetFileRequest)NetCache.NetCache_pendingPriorityWrites.method6031();
                  var6 = new Buffer(4);
                  var6.method5559(1);
                  var6.method5616((int)var5.key);
                  NetCache.NetCache_socket.vmethod5909(var6.array, 0, 4);
                  NetCache.NetCache_pendingPriorityResponses.method6033(var5, var5.key);
                  --NetCache.NetCache_pendingPriorityWritesCount;
                  ++NetCache.NetCache_pendingPriorityResponsesCount;
               }

               while(NetCache.NetCache_pendingResponsesCount < 200 && NetCache.NetCache_pendingWritesCount > 0) {
                  var5 = (NetFileRequest)NetCache.NetCache_pendingWritesQueue.method4879();
                  var6 = new Buffer(4);
                  var6.method5559(0);
                  var6.method5616((int)var5.key);
                  NetCache.NetCache_socket.vmethod5909(var6.array, 0, 4);
                  var5.method3672();
                  NetCache.NetCache_pendingResponses.method6033(var5, var5.key);
                  --NetCache.NetCache_pendingWritesCount;
                  ++NetCache.NetCache_pendingResponsesCount;
               }

               int var17 = 0;

               while(true) {
                  if(var17 < 100) {
                     int var18 = NetCache.NetCache_socket.vmethod5890();
                     if(var18 < 0) {
                        throw new IOException();
                     }

                     if(var18 != 0) {
                        label243: {
                           NetCache.NetCache_loadTime = 0;
                           byte var7 = 0;
                           if(NetCache.NetCache_currentResponse == null) {
                              var7 = 8;
                           } else if(NetCache.field3178 == 0) {
                              var7 = 1;
                           }

                           int var8;
                           int var9;
                           int var10;
                           int var12;
                           if(var7 > 0) {
                              var8 = var7 - NetCache.NetCache_responseHeaderBuffer.offset;
                              if(var8 > var18) {
                                 var8 = var18;
                              }

                              NetCache.NetCache_socket.vmethod5892(NetCache.NetCache_responseHeaderBuffer.array, NetCache.NetCache_responseHeaderBuffer.offset, var8);
                              if(NetCache.field3163 != 0) {
                                 for(var9 = 0; var9 < var8; ++var9) {
                                    NetCache.NetCache_responseHeaderBuffer.array[NetCache.NetCache_responseHeaderBuffer.offset + var9] ^= NetCache.field3163;
                                 }
                              }

                              NetCache.NetCache_responseHeaderBuffer.offset += var8;
                              if(NetCache.NetCache_responseHeaderBuffer.offset < var7) {
                                 break label243;
                              }

                              if(NetCache.NetCache_currentResponse == null) {
                                 NetCache.NetCache_responseHeaderBuffer.offset = 0;
                                 var9 = NetCache.NetCache_responseHeaderBuffer.method5575();
                                 var10 = NetCache.NetCache_responseHeaderBuffer.method5577();
                                 int var11 = NetCache.NetCache_responseHeaderBuffer.method5575();
                                 var12 = NetCache.NetCache_responseHeaderBuffer.method5580();
                                 long var13 = (long)(var10 + (var9 << 16));
                                 NetFileRequest var15 = (NetFileRequest)NetCache.NetCache_pendingPriorityResponses.method6046(var13);
                                 GrandExchangeOfferOwnWorldComparator.field677 = true;
                                 if(var15 == null) {
                                    var15 = (NetFileRequest)NetCache.NetCache_pendingResponses.method6046(var13);
                                    GrandExchangeOfferOwnWorldComparator.field677 = false;
                                 }

                                 if(var15 == null) {
                                    throw new IOException();
                                 }

                                 int var16 = var11 == 0?5:9;
                                 NetCache.NetCache_currentResponse = var15;
                                 NetCache.NetCache_responseArchiveBuffer = new Buffer(var12 + var16 + NetCache.NetCache_currentResponse.padding);
                                 NetCache.NetCache_responseArchiveBuffer.method5559(var11);
                                 NetCache.NetCache_responseArchiveBuffer.method5717(var12);
                                 NetCache.field3178 = 8;
                                 NetCache.NetCache_responseHeaderBuffer.offset = 0;
                              } else if(NetCache.field3178 == 0) {
                                 if(NetCache.NetCache_responseHeaderBuffer.array[0] == -1) {
                                    NetCache.field3178 = 1;
                                    NetCache.NetCache_responseHeaderBuffer.offset = 0;
                                 } else {
                                    NetCache.NetCache_currentResponse = null;
                                 }
                              }
                           } else {
                              var8 = NetCache.NetCache_responseArchiveBuffer.array.length - NetCache.NetCache_currentResponse.padding;
                              var9 = 512 - NetCache.field3178;
                              if(var9 > var8 - NetCache.NetCache_responseArchiveBuffer.offset) {
                                 var9 = var8 - NetCache.NetCache_responseArchiveBuffer.offset;
                              }

                              if(var9 > var18) {
                                 var9 = var18;
                              }

                              NetCache.NetCache_socket.vmethod5892(NetCache.NetCache_responseArchiveBuffer.array, NetCache.NetCache_responseArchiveBuffer.offset, var9);
                              if(NetCache.field3163 != 0) {
                                 for(var10 = 0; var10 < var9; ++var10) {
                                    NetCache.NetCache_responseArchiveBuffer.array[var10 + NetCache.NetCache_responseArchiveBuffer.offset] ^= NetCache.field3163;
                                 }
                              }

                              NetCache.NetCache_responseArchiveBuffer.offset += var9;
                              NetCache.field3178 += var9;
                              if(var8 == NetCache.NetCache_responseArchiveBuffer.offset) {
                                 if(NetCache.NetCache_currentResponse.key == 16711935L) {
                                    class13.NetCache_reference = NetCache.NetCache_responseArchiveBuffer;

                                    for(var10 = 0; var10 < 256; ++var10) {
                                       Archive var19 = NetCache.NetCache_archives[var10];
                                       if(var19 != null) {
                                          class13.NetCache_reference.offset = var10 * 8 + 5;
                                          var12 = class13.NetCache_reference.method5580();
                                          int var20 = class13.NetCache_reference.method5580();
                                          var19.method4348(var12, var20);
                                       }
                                    }
                                 } else {
                                    NetCache.NetCache_crc.reset();
                                    NetCache.NetCache_crc.update(NetCache.NetCache_responseArchiveBuffer.array, 0, var8);
                                    var10 = (int)NetCache.NetCache_crc.getValue();
                                    if(var10 != NetCache.NetCache_currentResponse.crc) {
                                       try {
                                          NetCache.NetCache_socket.vmethod5894();
                                       } catch (Exception var23) {
                                          ;
                                       }

                                       ++NetCache.NetCache_crcMismatches;
                                       NetCache.NetCache_socket = null;
                                       NetCache.field3163 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                                       var1 = false;
                                       break;
                                    }

                                    NetCache.NetCache_crcMismatches = 0;
                                    NetCache.NetCache_ioExceptions = 0;
                                    NetCache.NetCache_currentResponse.archive.method4345((int)(NetCache.NetCache_currentResponse.key & 65535L), NetCache.NetCache_responseArchiveBuffer.array, (NetCache.NetCache_currentResponse.key & 16711680L) == 16711680L, GrandExchangeOfferOwnWorldComparator.field677);
                                 }

                                 NetCache.NetCache_currentResponse.method3676();
                                 if(GrandExchangeOfferOwnWorldComparator.field677) {
                                    --NetCache.NetCache_pendingPriorityResponsesCount;
                                 } else {
                                    --NetCache.NetCache_pendingResponsesCount;
                                 }

                                 NetCache.field3178 = 0;
                                 NetCache.NetCache_currentResponse = null;
                                 NetCache.NetCache_responseArchiveBuffer = null;
                              } else {
                                 if(NetCache.field3178 != 512) {
                                    break label243;
                                 }

                                 NetCache.field3178 = 0;
                              }
                           }

                           ++var17;
                           continue;
                        }
                     }
                  }

                  var1 = true;
                  break;
               }
            } catch (IOException var24) {
               try {
                  NetCache.NetCache_socket.vmethod5894();
               } catch (Exception var22) {
                  ;
               }

               ++NetCache.NetCache_ioExceptions;
               NetCache.NetCache_socket = null;
               var1 = false;
            }
         }

         if(!var1) {
            this.method1407();
         }

      }
   }

   @ObfuscatedName("es")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1183665566"
   )
   void method1407() {
      if(NetCache.NetCache_crcMismatches >= 4) {
         this.method1120("js5crc");
         gameState = 1000;
         gameStateChanged(-1);
      } else {
         if(NetCache.NetCache_ioExceptions >= 4) {
            if(gameState <= 5) {
               this.method1120("js5io");
               gameState = 1000;
               gameStateChanged(-1);
               return;
            }

            field709 = 3000;
            NetCache.NetCache_ioExceptions = 3;
         }

         if(--field709 + 1 <= 0) {
            try {
               if(js5ConnectState == 0) {
                  WorldMapManager.js5SocketTask = class227.taskHandler.method3565(Script.worldHost, class280.port3);
                  ++js5ConnectState;
               }

               if(js5ConnectState == 1) {
                  if(WorldMapManager.js5SocketTask.status == 2) {
                     this.method1651(-1);
                     return;
                  }

                  if(WorldMapManager.js5SocketTask.status == 1) {
                     ++js5ConnectState;
                  }
               }

               if(js5ConnectState == 2) {
                  if(useBufferedSocket) {
                     MusicPatchNode.js5Socket = Buffer.method5795((Socket)WorldMapManager.js5SocketTask.result, '\u9c40', 5000);
                  } else {
                     MusicPatchNode.js5Socket = new NetSocket((Socket)WorldMapManager.js5SocketTask.result, class227.taskHandler, 5000);
                  }

                  Buffer var1 = new Buffer(5);
                  var1.method5559(15);
                  var1.method5717(189);
                  MusicPatchNode.js5Socket.vmethod5909(var1.array, 0, 5);
                  ++js5ConnectState;
                  class58.field455 = class217.method4036();
               }

               if(js5ConnectState == 3) {
                  if(MusicPatchNode.js5Socket.vmethod5890() <= 0 && (useBufferedSocket || gameState > 5)) {
                     if(class217.method4036() - class58.field455 > 30000L) {
                        this.method1651(-2);
                        return;
                     }
                  } else {
                     int var2 = MusicPatchNode.js5Socket.vmethod5891();
                     if(var2 != 0) {
                        this.method1651(var2);
                        return;
                     }

                     ++js5ConnectState;
                  }
               }

               if(js5ConnectState == 4) {
                  GrandExchangeOfferUnitPriceComparator.method222(MusicPatchNode.js5Socket, gameState > 20);
                  WorldMapManager.js5SocketTask = null;
                  MusicPatchNode.js5Socket = null;
                  js5ConnectState = 0;
                  js5Errors = 0;
               }
            } catch (IOException var3) {
               this.method1651(-3);
            }

         }
      }
   }

   @ObfuscatedName("fk")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2003740384"
   )
   void method1651(int var1) {
      WorldMapManager.js5SocketTask = null;
      MusicPatchNode.js5Socket = null;
      js5ConnectState = 0;
      if(WorldMapLabelSize.port1 == class280.port3) {
         class280.port3 = GrandExchangeOfferAgeComparator.port2;
      } else {
         class280.port3 = WorldMapLabelSize.port1;
      }

      ++js5Errors;
      if(js5Errors >= 2 && (var1 == 7 || var1 == 9)) {
         if(gameState <= 5) {
            this.method1120("js5connect_full");
            gameState = 1000;
            gameStateChanged(-1);
         } else {
            field709 = 3000;
         }
      } else if(js5Errors >= 2 && var1 == 6) {
         this.method1120("js5connect_outofdate");
         gameState = 1000;
         gameStateChanged(-1);
      } else if(js5Errors >= 4) {
         if(gameState <= 5) {
            this.method1120("js5connect");
            gameState = 1000;
            gameStateChanged(-1);
         } else {
            field709 = 3000;
         }
      }

   }

   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "931463513"
   )
   final void method1409() {
      Object var1 = packetWriter.method2373();
      PacketBuffer var2 = packetWriter.packetBuffer;

      try {
         if(loginState == 0) {
            if(MouseHandler.secureRandom == null && (secureRandomFuture.method2217() || field712 > 250)) {
               MouseHandler.secureRandom = secureRandomFuture.method2218();
               secureRandomFuture.method2220();
               secureRandomFuture = null;
            }

            if(MouseHandler.secureRandom != null) {
               if(var1 != null) {
                  ((AbstractSocket)var1).vmethod5894();
                  var1 = null;
               }

               AbstractWorldMapIcon.socketTask = null;
               field728 = false;
               field712 = 0;
               loginState = 1;
            }
         }

         if(loginState == 1) {
            if(AbstractWorldMapIcon.socketTask == null) {
               AbstractWorldMapIcon.socketTask = class227.taskHandler.method3565(Script.worldHost, class280.port3);
            }

            if(AbstractWorldMapIcon.socketTask.status == 2) {
               throw new IOException();
            }

            if(AbstractWorldMapIcon.socketTask.status == 1) {
               if(useBufferedSocket) {
                  var1 = Buffer.method5795((Socket)AbstractWorldMapIcon.socketTask.result, '\u9c40', 5000);
               } else {
                  var1 = new NetSocket((Socket)AbstractWorldMapIcon.socketTask.result, class227.taskHandler, 5000);
               }

               packetWriter.method2368((AbstractSocket)var1);
               AbstractWorldMapIcon.socketTask = null;
               loginState = 2;
            }
         }

         PacketBufferNode var4;
         if(loginState == 2) {
            packetWriter.method2359();
            var4 = UserComparator9.method3497();
            var4.clientPacket = null;
            var4.clientPacketLength = 0;
            var4.packetBuffer = new PacketBuffer(5000);
            var4.packetBuffer.method5559(LoginPacket.field2315.id);
            packetWriter.method2375(var4);
            packetWriter.method2360();
            var2.offset = 0;
            loginState = 3;
         }

         boolean var13;
         int var14;
         if(loginState == 3) {
            if(WorldMapManager.pcmPlayer0 != null) {
               WorldMapManager.pcmPlayer0.method2537();
            }

            if(AbstractWorldMapData.pcmPlayer1 != null) {
               AbstractWorldMapData.pcmPlayer1.method2537();
            }

            var13 = true;
            if(useBufferedSocket && !((AbstractSocket)var1).vmethod5889(1)) {
               var13 = false;
            }

            if(var13) {
               var14 = ((AbstractSocket)var1).vmethod5891();
               if(WorldMapManager.pcmPlayer0 != null) {
                  WorldMapManager.pcmPlayer0.method2537();
               }

               if(AbstractWorldMapData.pcmPlayer1 != null) {
                  AbstractWorldMapData.pcmPlayer1.method2537();
               }

               if(var14 != 0) {
                  PlayerAppearance.method4123(var14);
                  return;
               }

               var2.offset = 0;
               loginState = 4;
            }
         }

         int var36;
         if(loginState == 4) {
            if(var2.offset < 8) {
               var36 = ((AbstractSocket)var1).vmethod5890();
               if(var36 > 8 - var2.offset) {
                  var36 = 8 - var2.offset;
               }

               if(var36 > 0) {
                  ((AbstractSocket)var1).vmethod5892(var2.array, var2.offset, var36);
                  var2.offset += var36;
               }
            }

            if(var2.offset == 8) {
               var2.offset = 0;
               ChatChannel.field1319 = var2.method5581();
               loginState = 5;
            }
         }

         int var7;
         int var9;
         int var15;
         if(loginState == 5) {
            packetWriter.packetBuffer.offset = 0;
            packetWriter.method2359();
            PacketBuffer var3 = new PacketBuffer(500);
            int[] var27 = new int[]{MouseHandler.secureRandom.nextInt(), MouseHandler.secureRandom.nextInt(), MouseHandler.secureRandom.nextInt(), MouseHandler.secureRandom.nextInt()};
            var3.offset = 0;
            var3.method5559(1);
            var3.method5717(var27[0]);
            var3.method5717(var27[1]);
            var3.method5717(var27[2]);
            var3.method5717(var27[3]);
            var3.method5557(ChatChannel.field1319);
            if(gameState == 40) {
               var3.method5717(class105.field1345[0]);
               var3.method5717(class105.field1345[1]);
               var3.method5717(class105.field1345[2]);
               var3.method5717(class105.field1345[3]);
            } else {
               var3.method5559(field715.vmethod6189());
               switch(field715.field2014) {
               case 0:
                  LinkedHashMap var6 = GrandExchangeOfferOwnWorldComparator.clientPreferences.parameters;
                  String var8 = Login.Login_username;
                  var9 = var8.length();
                  int var10 = 0;

                  for(int var11 = 0; var11 < var9; ++var11) {
                     var10 = (var10 << 5) - var10 + var8.charAt(var11);
                  }

                  var3.method5717(((Integer)var6.get(Integer.valueOf(var10))).intValue());
                  break;
               case 1:
               case 2:
                  var3.method5616(GraphicsObject.field1141);
                  ++var3.offset;
                  break;
               case 3:
                  var3.offset += 4;
               }

               var3.method5559(class322.field3825.vmethod6189());
               var3.method5655(Login.Login_password);
            }

            var3.method5598(class92.field1181, class92.field1178, -1668495798);
            class105.field1345 = var27;
            PacketBufferNode var33 = UserComparator9.method3497();
            var33.clientPacket = null;
            var33.clientPacketLength = 0;
            var33.packetBuffer = new PacketBuffer(5000);
            var33.packetBuffer.offset = 0;
            if(gameState == 40) {
               var33.packetBuffer.method5559(LoginPacket.field2313.id);
            } else {
               var33.packetBuffer.method5559(LoginPacket.field2317.id);
            }

            var33.packetBuffer.method5560(0);
            var7 = var33.packetBuffer.offset;
            var33.packetBuffer.method5717(189);
            var33.packetBuffer.method5717(1);
            var33.packetBuffer.method5559(clientType);
            var33.packetBuffer.method5624(var3.array, 0, var3.offset);
            var15 = var33.packetBuffer.offset;
            var33.packetBuffer.method5655(Login.Login_username);
            var33.packetBuffer.method5559((isResizable?1:0) << 1 | (isLowDetail?1:0));
            var33.packetBuffer.method5560(WorldMapLabel.canvasWidth);
            var33.packetBuffer.method5560(Varps.canvasHeight);
            PacketBuffer var16 = var33.packetBuffer;
            if(randomDatData != null) {
               var16.method5624(randomDatData, 0, randomDatData.length);
            } else {
               byte[] var17 = GraphicsObject.method2120();
               var16.method5624(var17, 0, var17.length);
            }

            var33.packetBuffer.method5655(WorldMapData_0.field137);
            var33.packetBuffer.method5717(KitDefinition.field3271);
            Buffer var38 = new Buffer(Varcs.platformInfo.method6400());
            Varcs.platformInfo.method6399(var38);
            var33.packetBuffer.method5624(var38.array, 0, var38.array.length);
            var33.packetBuffer.method5559(clientType);
            var33.packetBuffer.method5717(0);
            var33.packetBuffer.method5717(ArchiveDiskAction.archive0.hash);
            var33.packetBuffer.method5717(DirectByteArrayCopier.archive1.hash);
            var33.packetBuffer.method5717(GrandExchangeOffer.archive2.hash);
            var33.packetBuffer.method5717(WorldMapSprite.archive3.hash);
            var33.packetBuffer.method5717(FontName.archive4.hash);
            var33.packetBuffer.method5717(WorldMapIcon_0.archive5.hash);
            var33.packetBuffer.method5717(AbstractWorldMapIcon.archive6.hash);
            var33.packetBuffer.method5717(AbstractWorldMapIcon.archive7.hash);
            var33.packetBuffer.method5717(class228.archive8.hash);
            var33.packetBuffer.method5717(SecureRandomFuture.archive9.hash);
            var33.packetBuffer.method5717(PlayerAppearance.archive10.hash);
            var33.packetBuffer.method5717(WorldMapRegion.archive11.hash);
            var33.packetBuffer.method5717(class41.archive12.hash);
            var33.packetBuffer.method5717(NPC.archive13.hash);
            var33.packetBuffer.method5717(class224.archive14.hash);
            var33.packetBuffer.method5717(GrandExchangeOfferNameComparator.archive15.hash);
            var33.packetBuffer.method5717(0);
            var33.packetBuffer.method5717(MenuAction.archive17.hash);
            var33.packetBuffer.method5717(UserComparator9.archive18.hash);
            var33.packetBuffer.method5717(class278.archive19.hash);
            var33.packetBuffer.method5717(class25.archive20.hash);
            var33.packetBuffer.method5596(var27, var15, var33.packetBuffer.offset);
            var33.packetBuffer.method5754(var33.packetBuffer.offset - var7);
            packetWriter.method2375(var33);
            packetWriter.method2360();
            packetWriter.isaacCipher = new IsaacCipher(var27);
            int[] var18 = new int[4];

            for(int var12 = 0; var12 < 4; ++var12) {
               var18[var12] = var27[var12] + 50;
            }

            var2.method5553(var18);
            loginState = 6;
         }

         if(loginState == 6 && ((AbstractSocket)var1).vmethod5890() > 0) {
            var36 = ((AbstractSocket)var1).vmethod5891();
            if(var36 == 21 && gameState == 20) {
               loginState = 12;
            } else if(var36 == 2) {
               loginState = 14;
            } else if(var36 == 15 && gameState == 40) {
               packetWriter.serverPacketLength = -1;
               loginState = 19;
            } else if(var36 == 64) {
               loginState = 10;
            } else if(var36 == 23 && field713 < 1) {
               ++field713;
               loginState = 0;
            } else if(var36 == 29) {
               loginState = 17;
            } else {
               if(var36 != 69) {
                  PlayerAppearance.method4123(var36);
                  return;
               }

               loginState = 7;
            }
         }

         if(loginState == 7 && ((AbstractSocket)var1).vmethod5890() >= 2) {
            ((AbstractSocket)var1).vmethod5892(var2.array, 0, 2);
            var2.offset = 0;
            MilliClock.field2026 = var2.method5577();
            loginState = 8;
         }

         if(loginState == 8 && ((AbstractSocket)var1).vmethod5890() >= MilliClock.field2026) {
            var2.offset = 0;
            ((AbstractSocket)var1).vmethod5892(var2.array, var2.offset, MilliClock.field2026);
            class7[] var25 = new class7[]{class7.field34};
            class7 var28 = var25[var2.method5575()];

            try {
               switch(var28.field30) {
               case 0:
                  class5 var5 = new class5();
                  this.field719 = new class9(var2, var5);
                  loginState = 9;
                  break;
               default:
                  throw new IllegalArgumentException();
               }
            } catch (Exception var23) {
               PlayerAppearance.method4123(22);
               return;
            }
         }

         if(loginState == 9 && this.field719.method111()) {
            this.field718 = this.field719.method113();
            this.field719.method110();
            this.field719 = null;
            if(this.field718 == null) {
               PlayerAppearance.method4123(22);
               return;
            }

            packetWriter.method2359();
            var4 = UserComparator9.method3497();
            var4.clientPacket = null;
            var4.clientPacketLength = 0;
            var4.packetBuffer = new PacketBuffer(5000);
            var4.packetBuffer.method5559(LoginPacket.field2314.id);
            var4.packetBuffer.method5560(this.field718.offset);
            var4.packetBuffer.method5790(this.field718);
            packetWriter.method2375(var4);
            packetWriter.method2360();
            this.field718 = null;
            loginState = 6;
         }

         if(loginState == 10 && ((AbstractSocket)var1).vmethod5890() > 0) {
            class52.field407 = ((AbstractSocket)var1).vmethod5891();
            loginState = 11;
         }

         if(loginState == 11 && ((AbstractSocket)var1).vmethod5890() >= class52.field407) {
            ((AbstractSocket)var1).vmethod5892(var2.array, 0, class52.field407);
            var2.offset = 0;
            loginState = 6;
         }

         if(loginState == 12 && ((AbstractSocket)var1).vmethod5890() > 0) {
            field714 = (((AbstractSocket)var1).vmethod5891() + 3) * 60;
            loginState = 13;
         }

         if(loginState == 13) {
            field712 = 0;
            HealthBarUpdate.method1866("You have only just left another world.", "Your profile will be transferred in:", field714 / 60 + " seconds.");
            if(--field714 <= 0) {
               loginState = 0;
            }

         } else {
            if(loginState == 14 && ((AbstractSocket)var1).vmethod5890() >= 1) {
               GrandExchangeEvents.field71 = ((AbstractSocket)var1).vmethod5891();
               loginState = 15;
            }

            if(loginState == 15 && ((AbstractSocket)var1).vmethod5890() >= GrandExchangeEvents.field71) {
               var13 = ((AbstractSocket)var1).vmethod5891() == 1;
               ((AbstractSocket)var1).vmethod5892(var2.array, 0, 4);
               var2.offset = 0;
               boolean var37 = false;
               if(var13) {
                  var14 = var2.method5539() << 24;
                  var14 |= var2.method5539() << 16;
                  var14 |= var2.method5539() << 8;
                  var14 |= var2.method5539();
                  String var34 = Login.Login_username;
                  var7 = var34.length();
                  var15 = 0;

                  for(var9 = 0; var9 < var7; ++var9) {
                     var15 = (var15 << 5) - var15 + var34.charAt(var9);
                  }

                  if(GrandExchangeOfferOwnWorldComparator.clientPreferences.parameters.size() >= 10 && !GrandExchangeOfferOwnWorldComparator.clientPreferences.parameters.containsKey(Integer.valueOf(var15))) {
                     Iterator var35 = GrandExchangeOfferOwnWorldComparator.clientPreferences.parameters.entrySet().iterator();
                     var35.next();
                     var35.remove();
                  }

                  GrandExchangeOfferOwnWorldComparator.clientPreferences.parameters.put(Integer.valueOf(var15), Integer.valueOf(var14));
               }

               if(Login_isUsernameRemembered) {
                  GrandExchangeOfferOwnWorldComparator.clientPreferences.rememberedUsername = Login.Login_username;
               } else {
                  GrandExchangeOfferOwnWorldComparator.clientPreferences.rememberedUsername = null;
               }

               WorldMapArea.method509();
               staffModLevel = ((AbstractSocket)var1).vmethod5891();
               playerMod = ((AbstractSocket)var1).vmethod5891() == 1;
               localPlayerIndex = ((AbstractSocket)var1).vmethod5891();
               localPlayerIndex <<= 8;
               localPlayerIndex += ((AbstractSocket)var1).vmethod5891();
               field798 = ((AbstractSocket)var1).vmethod5891();
               ((AbstractSocket)var1).vmethod5892(var2.array, 0, 1);
               var2.offset = 0;
               ServerPacket[] var29 = KeyHandler.method938();
               int var20 = var2.method5522();
               if(var20 < 0 || var20 >= var29.length) {
                  throw new IOException(var20 + " " + var2.offset);
               }

               packetWriter.serverPacket = var29[var20];
               packetWriter.serverPacketLength = packetWriter.serverPacket.length;
               ((AbstractSocket)var1).vmethod5892(var2.array, 0, 2);
               var2.offset = 0;
               packetWriter.serverPacketLength = var2.method5577();

               try {
                  class56.method950(WorldMapSection1.client, "zap");
               } catch (Throwable var22) {
                  ;
               }

               loginState = 16;
            }

            if(loginState == 16) {
               if(((AbstractSocket)var1).vmethod5890() >= packetWriter.serverPacketLength) {
                  var2.offset = 0;
                  ((AbstractSocket)var1).vmethod5892(var2.array, 0, packetWriter.serverPacketLength);
                  timer.method5046();
                  MusicPatchPcmStream.method4005();
                  TriBool.method5251(var2);
                  class69.field585 = -1;
                  GameObject.method3407(false, var2);
                  packetWriter.serverPacket = null;
               }

            } else {
               if(loginState == 17 && ((AbstractSocket)var1).vmethod5890() >= 2) {
                  var2.offset = 0;
                  ((AbstractSocket)var1).vmethod5892(var2.array, 0, 2);
                  var2.offset = 0;
                  class7.field33 = var2.method5577();
                  loginState = 18;
               }

               if(loginState == 18 && ((AbstractSocket)var1).vmethod5890() >= class7.field33) {
                  var2.offset = 0;
                  ((AbstractSocket)var1).vmethod5892(var2.array, 0, class7.field33);
                  var2.offset = 0;
                  String var26 = var2.method5695();
                  String var30 = var2.method5695();
                  String var31 = var2.method5695();
                  HealthBarUpdate.method1866(var26, var30, var31);
                  MouseRecorder.method1293(10);
               }

               if(loginState != 19) {
                  ++field712;
                  if(field712 > 2000) {
                     if(field713 < 1) {
                        if(class280.port3 == WorldMapLabelSize.port1) {
                           class280.port3 = GrandExchangeOfferAgeComparator.port2;
                        } else {
                           class280.port3 = WorldMapLabelSize.port1;
                        }

                        ++field713;
                        loginState = 0;
                     } else {
                        PlayerAppearance.method4123(-3);
                     }
                  }
               } else {
                  if(packetWriter.serverPacketLength == -1) {
                     if(((AbstractSocket)var1).vmethod5890() < 2) {
                        return;
                     }

                     ((AbstractSocket)var1).vmethod5892(var2.array, 0, 2);
                     var2.offset = 0;
                     packetWriter.serverPacketLength = var2.method5577();
                  }

                  if(((AbstractSocket)var1).vmethod5890() >= packetWriter.serverPacketLength) {
                     ((AbstractSocket)var1).vmethod5892(var2.array, 0, packetWriter.serverPacketLength);
                     var2.offset = 0;
                     var36 = packetWriter.serverPacketLength;
                     timer.method5048();
                     packetWriter.method2359();
                     packetWriter.packetBuffer.offset = 0;
                     packetWriter.serverPacket = null;
                     packetWriter.field1334 = null;
                     packetWriter.field1329 = null;
                     packetWriter.field1339 = null;
                     packetWriter.serverPacketLength = 0;
                     packetWriter.field1338 = 0;
                     rebootTimer = 0;
                     AbstractByteArrayCopier.method4024();
                     minimapState = 0;
                     destinationX = 0;

                     for(var14 = 0; var14 < 2048; ++var14) {
                        players[var14] = null;
                        cachedPlayersChanged(var14);
                     }

                     ByteArrayPool.localPlayer = null;

                     for(var14 = 0; var14 < npcs.length; ++var14) {
                        NPC var32 = npcs[var14];
                        if(var32 != null) {
                           var32.targetIndex = -1;
                           var32.interactingChanged(-1);
                           var32.false0 = false;
                        }
                     }

                     ItemContainer.itemContainers = new NodeHashTable(32);
                     MouseRecorder.method1293(30);

                     for(var14 = 0; var14 < 100; ++var14) {
                        field679[var14] = true;
                     }

                     var4 = FaceNormal.method3377(ClientPacket.field2257, packetWriter.isaacCipher);
                     var4.packetBuffer.method5559(ApproximateRouteStrategy.method1327());
                     var4.packetBuffer.method5560(WorldMapLabel.canvasWidth);
                     var4.packetBuffer.method5560(Varps.canvasHeight);
                     packetWriter.method2375(var4);
                     TriBool.method5251(var2);
                     if(var36 != var2.offset) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var24) {
         if(field713 < 1) {
            if(class280.port3 == WorldMapLabelSize.port1) {
               class280.port3 = GrandExchangeOfferAgeComparator.port2;
            } else {
               class280.port3 = WorldMapLabelSize.port1;
            }

            ++field713;
            loginState = 0;
         } else {
            PlayerAppearance.method4123(-2);
         }
      }
   }

   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1428106045"
   )
   final void method1410() {
      if(rebootTimer > 1) {
         --rebootTimer;
      }

      if(logoutTimer > 0) {
         --logoutTimer;
      }

      if(field728) {
         field728 = false;
         VertexNormal.method3093();
      } else {
         if(!isMenuOpen) {
            Tile.method2960();
         }

         int var1;
         for(var1 = 0; var1 < 100 && this.method1524(packetWriter); ++var1) {
            ;
         }

         if(gameState == 30) {
            while(true) {
               ReflectionCheck var2 = (ReflectionCheck)class105.reflectionChecks.method4885();
               boolean var31;
               if(var2 == null) {
                  var31 = false;
               } else {
                  var31 = true;
               }

               int var3;
               PacketBufferNode var32;
               if(!var31) {
                  PacketBufferNode var15;
                  int var16;
                  if(timer.field3581) {
                     var15 = FaceNormal.method3377(ClientPacket.field2270, packetWriter.isaacCipher);
                     var15.packetBuffer.method5559(0);
                     var16 = var15.packetBuffer.offset;
                     timer.method5049(var15.packetBuffer);
                     var15.packetBuffer.method5684(var15.packetBuffer.offset - var16);
                     packetWriter.method2375(var15);
                     timer.method5047();
                  }

                  Object var37 = MidiPcmStream.mouseRecorder.lock;
                  int var4;
                  int var5;
                  int var6;
                  int var7;
                  int var8;
                  int var9;
                  int var10;
                  int var11;
                  int var12;
                  synchronized(MidiPcmStream.mouseRecorder.lock) {
                     if(field749) {
                        if(MouseHandler.MouseHandler_lastButton != 0 || MidiPcmStream.mouseRecorder.index >= 40) {
                           var32 = null;
                           var3 = 0;
                           var4 = 0;
                           var5 = 0;
                           var6 = 0;

                           for(var7 = 0; var7 < MidiPcmStream.mouseRecorder.index && (var32 == null || var32.packetBuffer.offset - var3 < 246); ++var7) {
                              var4 = var7;
                              var8 = MidiPcmStream.mouseRecorder.ys[var7];
                              if(var8 < -1) {
                                 var8 = -1;
                              } else if(var8 > '\ufffe') {
                                 var8 = '\ufffe';
                              }

                              var9 = MidiPcmStream.mouseRecorder.xs[var7];
                              if(var9 < -1) {
                                 var9 = -1;
                              } else if(var9 > '\ufffe') {
                                 var9 = '\ufffe';
                              }

                              if(var9 != field691 || var8 != field692) {
                                 if(var32 == null) {
                                    var32 = FaceNormal.method3377(ClientPacket.field2281, packetWriter.isaacCipher);
                                    var32.packetBuffer.method5559(0);
                                    var3 = var32.packetBuffer.offset;
                                    var32.packetBuffer.offset += 2;
                                    var5 = 0;
                                    var6 = 0;
                                 }

                                 if(field875 != -1L) {
                                    var10 = var9 - field691;
                                    var11 = var8 - field692;
                                    var12 = (int)((MidiPcmStream.mouseRecorder.millis[var7] - field875) / 20L);
                                    var5 = (int)((long)var5 + (MidiPcmStream.mouseRecorder.millis[var7] - field875) % 20L);
                                 } else {
                                    var10 = var9;
                                    var11 = var8;
                                    var12 = Integer.MAX_VALUE;
                                 }

                                 field691 = var9;
                                 field692 = var8;
                                 if(var12 < 8 && var10 >= -32 && var10 <= 31 && var11 >= -32 && var11 <= 31) {
                                    var10 += 32;
                                    var11 += 32;
                                    var32.packetBuffer.method5560((var12 << 12) + var11 + (var10 << 6));
                                 } else if(var12 < 32 && var10 >= -128 && var10 <= 127 && var11 >= -128 && var11 <= 127) {
                                    var10 += 128;
                                    var11 += 128;
                                    var32.packetBuffer.method5559(var12 + 128);
                                    var32.packetBuffer.method5560(var11 + (var10 << 8));
                                 } else if(var12 < 32) {
                                    var32.packetBuffer.method5559(var12 + 192);
                                    if(var9 != -1 && var8 != -1) {
                                       var32.packetBuffer.method5717(var9 | var8 << 16);
                                    } else {
                                       var32.packetBuffer.method5717(Integer.MIN_VALUE);
                                    }
                                 } else {
                                    var32.packetBuffer.method5560((var12 & 8191) + '\ue000');
                                    if(var9 != -1 && var8 != -1) {
                                       var32.packetBuffer.method5717(var9 | var8 << 16);
                                    } else {
                                       var32.packetBuffer.method5717(Integer.MIN_VALUE);
                                    }
                                 }

                                 ++var6;
                                 field875 = MidiPcmStream.mouseRecorder.millis[var7];
                              }
                           }

                           if(var32 != null) {
                              var32.packetBuffer.method5684(var32.packetBuffer.offset - var3);
                              var7 = var32.packetBuffer.offset;
                              var32.packetBuffer.offset = var3;
                              var32.packetBuffer.method5559(var5 / var6);
                              var32.packetBuffer.method5559(var5 % var6);
                              var32.packetBuffer.offset = var7;
                              packetWriter.method2375(var32);
                           }

                           if(var4 >= MidiPcmStream.mouseRecorder.index) {
                              MidiPcmStream.mouseRecorder.index = 0;
                           } else {
                              MidiPcmStream.mouseRecorder.index -= var4;
                              System.arraycopy(MidiPcmStream.mouseRecorder.xs, var4, MidiPcmStream.mouseRecorder.xs, 0, MidiPcmStream.mouseRecorder.index);
                              System.arraycopy(MidiPcmStream.mouseRecorder.ys, var4, MidiPcmStream.mouseRecorder.ys, 0, MidiPcmStream.mouseRecorder.index);
                              System.arraycopy(MidiPcmStream.mouseRecorder.millis, var4, MidiPcmStream.mouseRecorder.millis, 0, MidiPcmStream.mouseRecorder.index);
                           }
                        }
                     } else {
                        MidiPcmStream.mouseRecorder.index = 0;
                     }
                  }

                  PacketBufferNode var19;
                  if(MouseHandler.MouseHandler_lastButton == 1 || !class217.mouseCam && MouseHandler.MouseHandler_lastButton == 4 || MouseHandler.MouseHandler_lastButton == 2) {
                     long var17 = MouseHandler.MouseHandler_lastPressedTimeMillis - mouseLastLastPressedTimeMillis;
                     if(var17 > 32767L) {
                        var17 = 32767L;
                     }

                     mouseLastLastPressedTimeMillis = MouseHandler.MouseHandler_lastPressedTimeMillis;
                     var3 = MouseHandler.MouseHandler_lastPressedY;
                     if(var3 < 0) {
                        var3 = 0;
                     } else if(var3 > Varps.canvasHeight) {
                        var3 = Varps.canvasHeight;
                     }

                     var4 = MouseHandler.MouseHandler_lastPressedX;
                     if(var4 < 0) {
                        var4 = 0;
                     } else if(var4 > WorldMapLabel.canvasWidth) {
                        var4 = WorldMapLabel.canvasWidth;
                     }

                     var5 = (int)var17;
                     var19 = FaceNormal.method3377(ClientPacket.field2209, packetWriter.isaacCipher);
                     var19.packetBuffer.method5560((var5 << 1) + (MouseHandler.MouseHandler_lastButton == 2?1:0));
                     var19.packetBuffer.method5560(var4);
                     var19.packetBuffer.method5560(var3);
                     packetWriter.method2375(var19);
                  }

                  if(KeyHandler.field417 > 0) {
                     var15 = FaceNormal.method3377(ClientPacket.field2210, packetWriter.isaacCipher);
                     var15.packetBuffer.method5560(0);
                     var16 = var15.packetBuffer.offset;
                     long var20 = class217.method4036();

                     for(var5 = 0; var5 < KeyHandler.field417; ++var5) {
                        long var22 = var20 - field904;
                        if(var22 > 16777215L) {
                           var22 = 16777215L;
                        }

                        field904 = var20;
                        var15.packetBuffer.method5617((int)var22);
                        var15.packetBuffer.method5559(KeyHandler.field432[var5]);
                     }

                     var15.packetBuffer.method5754(var15.packetBuffer.offset - var16);
                     packetWriter.method2375(var15);
                  }

                  if(field764 > 0) {
                     --field764;
                  }

                  if(KeyHandler.KeyHandler_pressedKeys[96] || KeyHandler.KeyHandler_pressedKeys[97] || KeyHandler.KeyHandler_pressedKeys[98] || KeyHandler.KeyHandler_pressedKeys[99]) {
                     field765 = true;
                  }

                  if(field765 && field764 <= 0) {
                     field764 = 20;
                     field765 = false;
                     var15 = FaceNormal.method3377(ClientPacket.field2220, packetWriter.isaacCipher);
                     var15.packetBuffer.method5612(camAngleY);
                     var15.packetBuffer.method5612(camAngleX);
                     packetWriter.method2375(var15);
                  }

                  if(GameShell.hasFocus && !hadFocus) {
                     hadFocus = true;
                     var15 = FaceNormal.method3377(ClientPacket.field2261, packetWriter.isaacCipher);
                     var15.packetBuffer.method5559(1);
                     packetWriter.method2375(var15);
                  }

                  if(!GameShell.hasFocus && hadFocus) {
                     hadFocus = false;
                     var15 = FaceNormal.method3377(ClientPacket.field2261, packetWriter.isaacCipher);
                     var15.packetBuffer.method5559(0);
                     packetWriter.method2375(var15);
                  }

                  if(GrandExchangeOfferAgeComparator.worldMap != null) {
                     GrandExchangeOfferAgeComparator.worldMap.method6512();
                  }

                  if(Timer.ClanChat_inClanChat) {
                     if(InterfaceParent.clanChat != null) {
                        InterfaceParent.clanChat.method5151();
                     }

                     WorldMapRegion.method537();
                     Timer.ClanChat_inClanChat = false;
                  }

                  InvDefinition.method4444();
                  if(gameState != 30) {
                     return;
                  }

                  for(PendingSpawn var38 = (PendingSpawn)pendingSpawns.method4956(); var38 != null; var38 = (PendingSpawn)pendingSpawns.method4974()) {
                     if(var38.hitpoints > 0) {
                        --var38.hitpoints;
                     }

                     if(var38.hitpoints == 0) {
                        if(var38.objectId < 0 || FileSystem.method3589(var38.objectId, var38.field963)) {
                           SoundCache.method2620(var38.plane, var38.type, var38.x, var38.y, var38.objectId, var38.field968, var38.field963);
                           var38.method3676();
                        }
                     } else {
                        if(var38.delay > 0) {
                           --var38.delay;
                        }

                        if(var38.delay == 0 && var38.x >= 1 && var38.y >= 1 && var38.x <= 102 && var38.y <= 102 && (var38.id < 0 || FileSystem.method3589(var38.id, var38.field967))) {
                           SoundCache.method2620(var38.plane, var38.type, var38.x, var38.y, var38.id, var38.orientation, var38.field967);
                           var38.delay = -1;
                           if(var38.id == var38.objectId && var38.objectId == -1) {
                              var38.method3676();
                           } else if(var38.objectId == var38.id && var38.field968 == var38.orientation && var38.field967 == var38.field963) {
                              var38.method3676();
                           }
                        }
                     }
                  }

                  class22.method252();
                  ++packetWriter.field1338;
                  if(packetWriter.field1338 > 750) {
                     VertexNormal.method3093();
                     return;
                  }

                  var1 = Players.Players_count;
                  int[] var33 = Players.Players_indices;

                  for(var3 = 0; var3 < var1; ++var3) {
                     Player var24 = players[var33[var3]];
                     if(var24 != null) {
                        class41.method649(var24, 1, 1452661344);
                     }
                  }

                  for(var1 = 0; var1 < npcCount; ++var1) {
                     var16 = npcIndices[var1];
                     NPC var25 = npcs[var16];
                     if(var25 != null) {
                        class41.method649(var25, var25.definition.size, 1393413824);
                     }
                  }

                  WorldMapRegion.method630();
                  ++field741;
                  if(mouseCrossColor != 0) {
                     mouseCrossState = mouseCrossState * 400 + 400;
                     if(mouseCrossState * 20 >= 400) {
                        mouseCrossColor = 0;
                     }
                  }

                  if(WorldMapID.field307 != null) {
                     ++field786;
                     if(field786 >= 15) {
                        ItemContainer.method1273(WorldMapID.field307);
                        WorldMapID.field307 = null;
                     }
                  }

                  Widget var39 = class9.mousedOverWidgetIf1;
                  Widget var34 = Language.field2368;
                  class9.mousedOverWidgetIf1 = null;
                  Language.field2368 = null;
                  draggedOnWidget = null;
                  field861 = false;
                  field732 = false;
                  field901 = 0;

                  while(class22.method255() && field901 < 128) {
                     if(staffModLevel >= 2 && KeyHandler.KeyHandler_pressedKeys[82] && class3.field16 == 66) {
                        String var43 = "";

                        Message var40;
                        for(Iterator var26 = Messages.Messages_hashTable.iterator(); var26.hasNext(); var43 = var43 + var40.sender + ':' + var40.text + '\n') {
                           var40 = (Message)var26.next();
                        }

                        WorldMapSection1.client.method1021(var43);
                     } else if(oculusOrbState != 1 || Coord.field2531 <= 0) {
                        field872[field901] = class3.field16;
                        field902[field901] = Coord.field2531;
                        ++field901;
                     }
                  }

                  boolean var35 = staffModLevel >= 2;
                  if(var35 && KeyHandler.KeyHandler_pressedKeys[82] && KeyHandler.KeyHandler_pressedKeys[81] && mouseWheelRotation != 0) {
                     var4 = ByteArrayPool.localPlayer.plane - mouseWheelRotation;
                     if(var4 < 0) {
                        var4 = 0;
                     } else if(var4 > 3) {
                        var4 = 3;
                     }

                     if(var4 != ByteArrayPool.localPlayer.plane) {
                        GrandExchangeOfferWorldComparator.method148(ByteArrayPool.localPlayer.pathX[0] + class69.baseX * 64, ByteArrayPool.localPlayer.pathY[0] + class89.baseY * 64, var4, false);
                     }

                     mouseWheelRotation = 0;
                  }

                  if(rootInterface != -1) {
                     class2.method35(rootInterface, 0, 0, WorldMapLabel.canvasWidth, Varps.canvasHeight, 0, 0);
                  }

                  ++cycleCntr;
                  onCycleCntrChanged(-1);

                  while(true) {
                     ScriptEvent var44 = (ScriptEvent)field727.method4954();
                     Widget var41;
                     Widget var46;
                     if(var44 == null) {
                        while(true) {
                           var44 = (ScriptEvent)field919.method4954();
                           if(var44 == null) {
                              while(true) {
                                 var44 = (ScriptEvent)scriptEvents.method4954();
                                 if(var44 == null) {
                                    this.method1415((byte)93);
                                    WorldMapArea.method508();
                                    if(clickedWidget != null) {
                                       this.method1420();
                                    }

                                    if(class236.dragInventoryWidget != null) {
                                       ItemContainer.method1273(class236.dragInventoryWidget);
                                       ++itemDragDuration;
                                       itemPressedDurationChanged(-1);
                                       if(MouseHandler.MouseHandler_currentButton == 0) {
                                          if(field887) {
                                             if(class236.dragInventoryWidget == RouteStrategy.field2106 && dragItemSlotSource != dragItemSlotDestination) {
                                                Widget var45 = class236.dragInventoryWidget;
                                                byte var36 = 0;
                                                if(field845 == 1 && var45.contentType == 206) {
                                                   var36 = 1;
                                                }

                                                if(var45.itemIds[dragItemSlotDestination] <= 0) {
                                                   var36 = 0;
                                                }

                                                if(MilliClock.method3561(ScriptEvent.method1283(var45))) {
                                                   var6 = dragItemSlotSource;
                                                   var7 = dragItemSlotDestination;
                                                   var45.itemIds[var7] = var45.itemIds[var6];
                                                   var45.itemQuantities[var7] = var45.itemQuantities[var6];
                                                   var45.itemIds[var6] = -1;
                                                   var45.itemQuantities[var6] = 0;
                                                } else if(var36 == 1) {
                                                   var6 = dragItemSlotSource;
                                                   var7 = dragItemSlotDestination;

                                                   while(var6 != var7) {
                                                      if(var6 > var7) {
                                                         var45.method4138(var6 - 1, var6);
                                                         --var6;
                                                      } else if(var6 < var7) {
                                                         var45.method4138(var6 + 1, var6);
                                                         ++var6;
                                                      }
                                                   }
                                                } else {
                                                   var45.method4138(dragItemSlotDestination, dragItemSlotSource);
                                                }

                                                var19 = FaceNormal.method3377(ClientPacket.field2298, packetWriter.isaacCipher);
                                                var19.packetBuffer.method5612(dragItemSlotDestination);
                                                var19.packetBuffer.method5611(dragItemSlotSource);
                                                var19.packetBuffer.method5559(var36);
                                                var19.packetBuffer.method5619(class236.dragInventoryWidget.id);
                                                packetWriter.method2375(var19);
                                             }
                                          } else if(this.method1800(1329547181)) {
                                             this.method1705(draggedWidgetX, draggedWidgetY);
                                          } else if(menuOptionsCount > 0) {
                                             var4 = draggedWidgetX;
                                             var5 = draggedWidgetY;
                                             MenuAction var42 = AbstractWorldMapIcon.tempMenuAction;
                                             AbstractByteArrayCopier.method4027(var42.param0, var42.param1, var42.opcode, var42.identifier, var42.action, var42.action, var4, var5, 2048227519);
                                             AbstractWorldMapIcon.tempMenuAction = null;
                                             onTempMenuActionChanged(-1);
                                          }

                                          field786 = 10;
                                          MouseHandler.MouseHandler_lastButton = 0;
                                          class236.dragInventoryWidget = null;
                                       } else if(itemDragDuration >= 5 && (MouseHandler.MouseHandler_x > draggedWidgetX + 5 || MouseHandler.MouseHandler_x < draggedWidgetX - 5 || MouseHandler.MouseHandler_y > draggedWidgetY + 5 || MouseHandler.MouseHandler_y < draggedWidgetY - 5)) {
                                          field887 = true;
                                       }
                                    }

                                    if(Scene.method3215()) {
                                       var4 = Scene.Scene_selectedX;
                                       var5 = Scene.Scene_selectedY;
                                       var19 = FaceNormal.method3377(ClientPacket.field2248, packetWriter.isaacCipher);
                                       var19.packetBuffer.method5559(5);
                                       var19.packetBuffer.method5560(class69.baseX * 64 + var4);
                                       var19.packetBuffer.method5559(KeyHandler.KeyHandler_pressedKeys[82]?(KeyHandler.KeyHandler_pressedKeys[81]?2:1):0);
                                       var19.packetBuffer.method5560(class89.baseY * 64 + var5);
                                       packetWriter.method2375(var19);
                                       Scene.method3347();
                                       mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                                       mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                                       mouseCrossColor = 1;
                                       mouseCrossState = 0;
                                       destinationX = var4;
                                       destinationY = var5;
                                    }

                                    if(var39 != class9.mousedOverWidgetIf1) {
                                       if(var39 != null) {
                                          ItemContainer.method1273(var39);
                                       }

                                       if(class9.mousedOverWidgetIf1 != null) {
                                          ItemContainer.method1273(class9.mousedOverWidgetIf1);
                                       }
                                    }

                                    if(var34 != Language.field2368 && field871 == field832) {
                                       if(var34 != null) {
                                          ItemContainer.method1273(var34);
                                       }

                                       if(Language.field2368 != null) {
                                          ItemContainer.method1273(Language.field2368);
                                       }
                                    }

                                    if(Language.field2368 != null) {
                                       if(field871 < field832) {
                                          ++field871;
                                          if(field832 == field871) {
                                             ItemContainer.method1273(Language.field2368);
                                          }
                                       }
                                    } else if(field871 > 0) {
                                       --field871;
                                    }

                                    Tile.method2961();
                                    if(isCameraLocked) {
                                       var4 = HealthBar.field1145 * 16384 + 64;
                                       var5 = WorldMapRectangle.field217 * 16384 + 64;
                                       var6 = class277.method5038(var4, var5, ScriptEvent.Client_plane) - class4.field20;
                                       if(WorldMapRectangle.cameraX < var4) {
                                          WorldMapRectangle.cameraX = (var4 - WorldMapRectangle.cameraX) * NetFileRequest.field3126 / 1000 + WorldMapRectangle.cameraX + GrandExchangeOfferWorldComparator.field64;
                                          if(WorldMapRectangle.cameraX > var4) {
                                             WorldMapRectangle.cameraX = var4;
                                          }
                                       }

                                       if(WorldMapRectangle.cameraX > var4) {
                                          WorldMapRectangle.cameraX -= NetFileRequest.field3126 * (WorldMapRectangle.cameraX - var4) / 1000 + GrandExchangeOfferWorldComparator.field64;
                                          if(WorldMapRectangle.cameraX < var4) {
                                             WorldMapRectangle.cameraX = var4;
                                          }
                                       }

                                       if(GrandExchangeOfferWorldComparator.cameraY < var6) {
                                          GrandExchangeOfferWorldComparator.cameraY = (var6 - GrandExchangeOfferWorldComparator.cameraY) * NetFileRequest.field3126 / 1000 + GrandExchangeOfferWorldComparator.cameraY + GrandExchangeOfferWorldComparator.field64;
                                          if(GrandExchangeOfferWorldComparator.cameraY > var6) {
                                             GrandExchangeOfferWorldComparator.cameraY = var6;
                                          }
                                       }

                                       if(GrandExchangeOfferWorldComparator.cameraY > var6) {
                                          GrandExchangeOfferWorldComparator.cameraY -= NetFileRequest.field3126 * (GrandExchangeOfferWorldComparator.cameraY - var6) / 1000 + GrandExchangeOfferWorldComparator.field64;
                                          if(GrandExchangeOfferWorldComparator.cameraY < var6) {
                                             GrandExchangeOfferWorldComparator.cameraY = var6;
                                          }
                                       }

                                       if(class200.cameraZ < var5) {
                                          class200.cameraZ = (var5 - class200.cameraZ) * NetFileRequest.field3126 / 1000 + class200.cameraZ + GrandExchangeOfferWorldComparator.field64;
                                          if(class200.cameraZ > var5) {
                                             class200.cameraZ = var5;
                                          }
                                       }

                                       if(class200.cameraZ > var5) {
                                          class200.cameraZ -= NetFileRequest.field3126 * (class200.cameraZ - var5) / 1000 + GrandExchangeOfferWorldComparator.field64;
                                          if(class200.cameraZ < var5) {
                                             class200.cameraZ = var5;
                                          }
                                       }

                                       var4 = field925 * 16384 + 64;
                                       var5 = Strings.field2759 * 16384 + 64;
                                       var6 = class277.method5038(var4, var5, ScriptEvent.Client_plane) - TextureProvider.field1549;
                                       var7 = var4 - WorldMapRectangle.cameraX;
                                       var8 = var6 - GrandExchangeOfferWorldComparator.cameraY;
                                       var9 = var5 - class200.cameraZ;
                                       var10 = (int)Math.sqrt((double)(var7 * var7 + var9 * var9));
                                       var11 = (int)(Math.atan2((double)var8, (double)var10) * 325.949D) & 2047;
                                       var12 = (int)(Math.atan2((double)var7, (double)var9) * -325.949D) & 2047;
                                       if(var11 < 128) {
                                          var11 = 128;
                                       }

                                       if(var11 > 383) {
                                          var11 = 383;
                                       }

                                       if(ApproximateRouteStrategy.cameraPitch < var11) {
                                          ApproximateRouteStrategy.cameraPitch = (var11 - ApproximateRouteStrategy.cameraPitch) * Players.field1280 / 1000 + ApproximateRouteStrategy.cameraPitch + Friend.field3626;
                                          onCameraPitchChanged(-1);
                                          if(ApproximateRouteStrategy.cameraPitch > var11) {
                                             ApproximateRouteStrategy.cameraPitch = var11;
                                             onCameraPitchChanged(-1);
                                          }
                                       }

                                       if(ApproximateRouteStrategy.cameraPitch > var11) {
                                          ApproximateRouteStrategy.cameraPitch -= Players.field1280 * (ApproximateRouteStrategy.cameraPitch - var11) / 1000 + Friend.field3626;
                                          onCameraPitchChanged(-1);
                                          if(ApproximateRouteStrategy.cameraPitch < var11) {
                                             ApproximateRouteStrategy.cameraPitch = var11;
                                             onCameraPitchChanged(-1);
                                          }
                                       }

                                       int var27 = var12 - WorldMapIcon_1.cameraYaw;
                                       if(var27 > 1024) {
                                          var27 -= 2048;
                                       }

                                       if(var27 < -1024) {
                                          var27 += 2048;
                                       }

                                       if(var27 > 0) {
                                          WorldMapIcon_1.cameraYaw = var27 * Players.field1280 / 1000 + WorldMapIcon_1.cameraYaw + Friend.field3626;
                                          WorldMapIcon_1.cameraYaw &= 2047;
                                       }

                                       if(var27 < 0) {
                                          WorldMapIcon_1.cameraYaw -= Friend.field3626 + -var27 * Players.field1280 / 1000;
                                          WorldMapIcon_1.cameraYaw &= 2047;
                                       }

                                       int var14 = var12 - WorldMapIcon_1.cameraYaw;
                                       if(var14 > 1024) {
                                          var14 -= 2048;
                                       }

                                       if(var14 < -1024) {
                                          var14 += 2048;
                                       }

                                       if(var14 < 0 && var27 > 0 || var14 > 0 && var27 < 0) {
                                          WorldMapIcon_1.cameraYaw = var12;
                                       }
                                    }

                                    for(var4 = 0; var4 < 5; ++var4) {
                                       ++field930[var4];
                                    }

                                    UserComparator4.varcs.method2288();
                                    var4 = ++MouseHandler.MouseHandler_idleCycles - 1;
                                    var6 = KeyHandler.KeyHandler_idleCycles;
                                    PacketBufferNode var28;
                                    if(var4 > 15000 && var6 > 15000) {
                                       logoutTimer = 250;
                                       ServerPacket.method3685(14500);
                                       var28 = FaceNormal.method3377(ClientPacket.field2251, packetWriter.isaacCipher);
                                       packetWriter.method2375(var28);
                                    }

                                    Projectile.friendSystem.method1955();
                                    ++packetWriter.pendingWrites;
                                    if(packetWriter.pendingWrites > 50) {
                                       var28 = FaceNormal.method3377(ClientPacket.field2295, packetWriter.isaacCipher);
                                       packetWriter.method2375(var28);
                                    }

                                    try {
                                       packetWriter.method2360();
                                    } catch (IOException var29) {
                                       VertexNormal.method3093();
                                    }

                                    return;
                                 }

                                 var46 = var44.widget;
                                 if(var46.childIndex >= 0) {
                                    var41 = MusicPatchNode.method3920(var46.parentId);
                                    if(var41 == null || var41.children == null || var46.childIndex >= var41.children.length || var46 != var41.children[var46.childIndex]) {
                                       continue;
                                    }
                                 }

                                 GrandExchangeOfferOwnWorldComparator.method1395(var44);
                              }
                           }

                           var46 = var44.widget;
                           if(var46.childIndex >= 0) {
                              var41 = MusicPatchNode.method3920(var46.parentId);
                              if(var41 == null || var41.children == null || var46.childIndex >= var41.children.length || var46 != var41.children[var46.childIndex]) {
                                 continue;
                              }
                           }

                           GrandExchangeOfferOwnWorldComparator.method1395(var44);
                        }
                     }

                     var46 = var44.widget;
                     if(var46.childIndex >= 0) {
                        var41 = MusicPatchNode.method3920(var46.parentId);
                        if(var41 == null || var41.children == null || var46.childIndex >= var41.children.length || var46 != var41.children[var46.childIndex]) {
                           continue;
                        }
                     }

                     GrandExchangeOfferOwnWorldComparator.method1395(var44);
                  }
               }

               var32 = FaceNormal.method3377(ClientPacket.field2304, packetWriter.isaacCipher);
               var32.packetBuffer.method5559(0);
               var3 = var32.packetBuffer.offset;
               GameObject.method3406(var32.packetBuffer);
               var32.packetBuffer.method5684(var32.packetBuffer.offset - var3);
               packetWriter.method2375(var32);
            }
         }
      }
   }

   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-61779781"
   )
   void method1446() {
      int var1 = WorldMapLabel.canvasWidth;
      int var2 = Varps.canvasHeight;
      if(super.contentWidth < var1) {
         var1 = super.contentWidth;
      }

      if(super.contentHeight < var2) {
         var2 = super.contentHeight;
      }

      if(GrandExchangeOfferOwnWorldComparator.clientPreferences != null) {
         try {
            Client var3 = WorldMapSection1.client;
            Object[] var4 = new Object[]{Integer.valueOf(ApproximateRouteStrategy.method1327())};
            JSObject.getWindow(var3).call("resize", var4);
         } catch (Throwable var5) {
            ;
         }
      }

   }

   @ObfuscatedName("gc")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "38"
   )
   final void method1806() {
      int var1;
      if(rootInterface != -1) {
         var1 = rootInterface;
         if(LoginScreenAnimation.method1914(var1)) {
            MilliClock.method3554(Widget.Widget_interfaceComponents[var1], -1);
         }
      }

      for(var1 = 0; var1 < rootWidgetCount; ++var1) {
         if(field679[var1]) {
            field886[var1] = true;
         }

         field813[var1] = field679[var1];
         field679[var1] = false;
      }

      field884 = cycle;
      viewportX = -1;
      viewportY = -1;
      RouteStrategy.field2106 = null;
      if(rootInterface != -1) {
         rootWidgetCount = 0;
         MusicPatch.method3979(rootInterface, 0, 0, WorldMapLabel.canvasWidth, Varps.canvasHeight, 0, 0, -1);
      }

      Hooks.drawAfterWidgets();
      Rasterizer2D.method6084();
      if(showMouseCross) {
         if(mouseCrossColor == 1) {
            class299.crossSprites[mouseCrossState * 20 / 100].method6227(mouseCrossX - 8, mouseCrossY - 8);
         }

         if(mouseCrossColor == 2) {
            class299.crossSprites[mouseCrossState * 20 / 100 + 4].method6227(mouseCrossX - 8, mouseCrossY - 8);
         }
      }

      int var2;
      int var3;
      if(!isMenuOpen) {
         if(viewportX != -1) {
            var1 = viewportX;
            var2 = viewportY;
            if((menuOptionsCount >= 2 || isItemSelected != 0 || isSpellSelected) && showMouseOverText) {
               var3 = AbstractWorldMapData.method381();
               String var4;
               if(isItemSelected == 1 && menuOptionsCount < 2) {
                  var4 = "Use" + " " + selectedItemName + " " + "->";
               } else if(isSpellSelected && menuOptionsCount < 2) {
                  var4 = selectedSpellActionName + " " + selectedSpellName + " " + "->";
               } else {
                  String var5;
                  if(var3 < 0) {
                     var5 = "";
                  } else if(menuTargets[var3].length() > 0) {
                     var5 = menuActions[var3] + " " + menuTargets[var3];
                  } else {
                     var5 = menuActions[var3];
                  }

                  var4 = var5;
               }

               if(menuOptionsCount > 2) {
                  var4 = var4 + class297.method5342(16777215) + " " + '/' + " " + (menuOptionsCount - 2) + " more options";
               }

               TaskHandler.fontBold12.method5435(var4, var1 + 4, var2 + 15, 16777215, 0, cycle / 1000);
            }
         }
      } else if(!Hooks.drawMenu()) {
         var1 = WorldMapDecoration.menuX;
         var2 = PacketBufferNode.menuY;
         var3 = WorldMapScaleHandler.menuWidth;
         int var13 = WorldMapData_1.menuHeight;
         int var14 = 6116423;
         Rasterizer2D.method6092(var1, var2, var3, var13, var14);
         Rasterizer2D.method6092(var1 + 1, var2 + 1, var3 - 2, 16, 0);
         Rasterizer2D.method6177(var1 + 1, var2 + 18, var3 - 2, var13 - 19, 0);
         TaskHandler.fontBold12.method5417("Choose Option", var1 + 3, var2 + 14, var14, -1);
         int var6 = MouseHandler.MouseHandler_x;
         int var7 = MouseHandler.MouseHandler_y;

         for(int var8 = 0; var8 < menuOptionsCount; ++var8) {
            int var9 = var2 + (menuOptionsCount - 1 - var8) * 15 + 31;
            int var10 = 16777215;
            if(var6 > var1 && var6 < var3 + var1 && var7 > var9 - 13 && var7 < var9 + 3) {
               var10 = 16776960;
            }

            Font var11 = TaskHandler.fontBold12;
            String var12;
            if(var8 < 0) {
               var12 = "";
            } else if(menuTargets[var8].length() > 0) {
               var12 = menuActions[var8] + " " + menuTargets[var8];
            } else {
               var12 = menuActions[var8];
            }

            var11.method5417(var12, var1 + 3, var9, var10, 0);
         }

         WorldMapScaleHandler.method848(WorldMapDecoration.menuX, PacketBufferNode.menuY, WorldMapScaleHandler.menuWidth, WorldMapData_1.menuHeight);
      }

      if(gameDrawingMode == 3) {
         for(var1 = 0; var1 < rootWidgetCount; ++var1) {
            if(field813[var1]) {
               Rasterizer2D.method6091(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711935, 128);
            } else if(field886[var1]) {
               Rasterizer2D.method6091(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711680, 128);
            }
         }
      }

      Message.method1300(ScriptEvent.Client_plane, ByteArrayPool.localPlayer.x, ByteArrayPool.localPlayer.y, field741);
      field741 = 0;
   }

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "(Ldv;I)Z",
      garbageValue = "-124055306"
   )
   final boolean method1524(PacketWriter var1) {
      AbstractSocket var2 = var1.method2373();
      PacketBuffer var3 = var1.packetBuffer;
      if(var2 == null) {
         return false;
      } else {
         int var6;
         String var27;
         try {
            int var5;
            if(var1.serverPacket == null) {
               if(var1.field1335) {
                  if(!var2.vmethod5889(1)) {
                     return false;
                  }

                  var2.vmethod5892(var1.packetBuffer.array, 0, 1);
                  var1.field1338 = 0;
                  var1.field1335 = false;
               }

               var3.offset = 0;
               if(var3.method5525()) {
                  if(!var2.vmethod5889(1)) {
                     return false;
                  }

                  var2.vmethod5892(var1.packetBuffer.array, 1, 1);
                  var1.field1338 = 0;
               }

               var1.field1335 = true;
               ServerPacket[] var4 = KeyHandler.method938();
               var5 = var3.method5522();
               if(var5 < 0 || var5 >= var4.length) {
                  throw new IOException(var5 + " " + var3.offset);
               }

               var1.serverPacket = var4[var5];
               var1.serverPacketLength = var1.serverPacket.length;
            }

            if(var1.serverPacketLength == -1) {
               if(!var2.vmethod5889(1)) {
                  return false;
               }

               var1.method2373().vmethod5892(var3.array, 0, 1);
               var1.serverPacketLength = var3.array[0] & 255;
            }

            if(var1.serverPacketLength == -2) {
               if(!var2.vmethod5889(2)) {
                  return false;
               }

               var1.method2373().vmethod5892(var3.array, 0, 2);
               var3.offset = 0;
               var1.serverPacketLength = var3.method5577();
            }

            if(!var2.vmethod5889(var1.serverPacketLength)) {
               return false;
            }

            var3.offset = 0;
            var2.vmethod5892(var3.array, 0, var1.serverPacketLength);
            var1.field1338 = 0;
            timer.method5052();
            var1.field1339 = var1.field1329;
            var1.field1329 = var1.field1334;
            var1.field1334 = var1.serverPacket;
            int var16;
            if(ServerPacket.field2204 == var1.serverPacket) {
               var16 = var3.method5615();
               var5 = var3.method5639();
               Varps.Varps_temp[var16] = var5;
               if(Varps.Varps_main[var16] != var5) {
                  Varps.Varps_main[var16] = var5;
                  settingsChanged(var16);
               }

               class22.method253(var16, (byte)-116);
               field866[++field772 - 1 & 31] = var16;
               var1.serverPacket = null;
               return true;
            }

            int var42;
            if(ServerPacket.field2129 == var1.serverPacket) {
               var16 = var3.method5575();
               var5 = var3.method5575();
               var6 = var3.method5575();
               var42 = var3.method5575();
               field926[var16] = true;
               field788[var16] = var5;
               field730[var16] = var6;
               field929[var16] = var42;
               field930[var16] = 0;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2160 == var1.serverPacket) {
               WorldMapData_1.method816(class194.field2325);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2187 == var1.serverPacket) {
               isCameraLocked = true;
               HealthBar.field1145 = var3.method5575() * 128;
               WorldMapRectangle.field217 = var3.method5575() * 128;
               class4.field20 = var3.method5577();
               GrandExchangeOfferWorldComparator.field64 = var3.method5575();
               NetFileRequest.field3126 = var3.method5575();
               if(NetFileRequest.field3126 >= 100) {
                  WorldMapRectangle.cameraX = HealthBar.field1145 * 16384 + 64;
                  class200.cameraZ = WorldMapRectangle.field217 * 16384 + 64;
                  GrandExchangeOfferWorldComparator.cameraY = class277.method5038(WorldMapRectangle.cameraX, class200.cameraZ, ScriptEvent.Client_plane) - class4.field20;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2199 == var1.serverPacket) {
               tradeChatMode = var3.method5605();
               publicChatMode = var3.method5605();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2144 == var1.serverPacket) {
               Projectile.friendSystem.method1963(var3, var1.serverPacketLength);
               field873 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            Widget var47;
            if(ServerPacket.field2186 == var1.serverPacket) {
               var16 = var3.method5565();
               var5 = var3.method5565();
               var6 = var3.method5622();
               var47 = MusicPatchNode.method3920(var6);
               var47.field2623 = var5 + (var16 << 16);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2145 == var1.serverPacket) {
               hintArrowType = var3.method5575();
               if(hintArrowType == 1) {
                  hintArrowNpcIndex = var3.method5577();
               }

               if(hintArrowType >= 2 && hintArrowType <= 6) {
                  if(hintArrowType == 2) {
                     hintArrowSubX = 64;
                     hintArrowSubY = 64;
                  }

                  if(hintArrowType == 3) {
                     hintArrowSubX = 0;
                     hintArrowSubY = 64;
                  }

                  if(hintArrowType == 4) {
                     hintArrowSubX = 128;
                     hintArrowSubY = 64;
                  }

                  if(hintArrowType == 5) {
                     hintArrowSubX = 64;
                     hintArrowSubY = 0;
                  }

                  if(hintArrowType == 6) {
                     hintArrowSubX = 64;
                     hintArrowSubY = 128;
                  }

                  hintArrowType = 2;
                  hintArrowX = var3.method5577();
                  hintArrowY = var3.method5577();
                  hintArrowHeight = var3.method5575() * 4;
               }

               if(hintArrowType == 10) {
                  hintArrowPlayerIndex = var3.method5577();
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2119 == var1.serverPacket) {
               var16 = var3.method5565();
               byte var45 = var3.method5609();
               Varps.Varps_temp[var16] = var45;
               if(Varps.Varps_main[var16] != var45) {
                  Varps.Varps_main[var16] = var45;
                  settingsChanged(var16);
               }

               class22.method253(var16, (byte)-58);
               field866[++field772 - 1 & 31] = var16;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2125 == var1.serverPacket) {
               WorldMapData_1.method816(class194.field2328);
               var1.serverPacket = null;
               return true;
            }

            boolean var60;
            if(ServerPacket.field2164 == var1.serverPacket) {
               var60 = var3.method5710();
               if(var60) {
                  if(WorldMapRectangle.field222 == null) {
                     WorldMapRectangle.field222 = new class247();
                  }
               } else {
                  WorldMapRectangle.field222 = null;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2146 == var1.serverPacket) {
               var16 = var3.method5577();
               rootInterface = var16;
               this.method1418(false);
               class4.method73(var16);
               WorldMapSectionType.method349(rootInterface, -1668286639);

               for(var5 = 0; var5 < 100; ++var5) {
                  field679[var5] = true;
               }

               var1.serverPacket = null;
               return true;
            }

            Widget var50;
            if(ServerPacket.field2179 == var1.serverPacket) {
               var16 = var3.method5580();
               var5 = var3.method5614();
               var50 = MusicPatchNode.method3920(var16);
               if(var50.modelType != 1 || var5 != var50.modelId) {
                  var50.modelType = 1;
                  var50.modelId = var5;
                  ItemContainer.method1273(var50);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2121 == var1.serverPacket) {
               var16 = var3.method5575();
               Player.method1369(var16, -357843101);
               var1.serverPacket = null;
               return false;
            }

            if(ServerPacket.field2197 == var1.serverPacket) {
               WorldMapData_1.method816(class194.field2331);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2200 == var1.serverPacket) {
               Huffman.method4041();
               var1.serverPacket = null;
               return false;
            }

            if(ServerPacket.field2202 == var1.serverPacket) {
               rebootTimer = var3.method5577() * 30;
               field877 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2161 == var1.serverPacket) {
               WorldMapData_1.method816(class194.field2329);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2195 == var1.serverPacket) {
               class58.method966();
               weight = var3.method5578();
               field877 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2183 == var1.serverPacket) {
               WorldMapData_1.method816(class194.field2323);
               var1.serverPacket = null;
               return true;
            }

            int var8;
            int var9;
            int var10;
            if(ServerPacket.field2177 == var1.serverPacket) {
               var16 = var3.method5580();
               var5 = var3.method5577();
               if(var16 < -70000) {
                  var5 += '\u8000';
               }

               if(var16 >= 0) {
                  var50 = MusicPatchNode.method3920(var16);
               } else {
                  var50 = null;
               }

               if(var50 != null) {
                  for(var42 = 0; var42 < var50.itemIds.length; ++var42) {
                     var50.itemIds[var42] = 0;
                     var50.itemQuantities[var42] = 0;
                  }
               }

               GrandExchangeOfferOwnWorldComparator.method1398(var5);
               var42 = var3.method5577();

               for(var8 = 0; var8 < var42; ++var8) {
                  var9 = var3.method5615();
                  var10 = var3.method5605();
                  if(var10 == 255) {
                     var10 = var3.method5622();
                  }

                  if(var50 != null && var8 < var50.itemIds.length) {
                     var50.itemIds[var8] = var9;
                     var50.itemQuantities[var8] = var10;
                  }

                  Messages.method2330(var5, var8, var9 - 1, var10);
               }

               if(var50 != null) {
                  ItemContainer.method1273(var50);
               }

               class58.method966();
               changedItemContainers[++field869 - 1 & 31] = var5 & 32767;
               ItemContainer.onItemContainerUpdate(field869 + 1 - 1 & 31);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2147 == var1.serverPacket) {
               Projectile.friendSystem.method1953();
               field873 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2185 == var1.serverPacket) {
               var16 = var3.method5620();
               var5 = var3.method5744();
               var6 = var3.method5744();
               var47 = MusicPatchNode.method3920(var16);
               if(var5 != var47.rawX || var6 != var47.rawY || var47.xAlignment != 0 || var47.yAlignment != 0) {
                  var47.rawX = var5;
                  var47.rawY = var6;
                  var47.xAlignment = 0;
                  var47.yAlignment = 0;
                  ItemContainer.method1273(var47);
                  this.method1419(var47);
                  if(var47.type == 0) {
                     MouseHandler.method1161(Widget.Widget_interfaceComponents[var16 >> 16], var47, false);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2162 == var1.serverPacket) {
               var60 = var3.method5575() == 1;
               if(var60) {
                  TilePaint.field1802 = class217.method4036() - var3.method5581();
                  GrandExchangeEvent.grandExchangeEvents = new GrandExchangeEvents(var3, true);
               } else {
                  GrandExchangeEvent.grandExchangeEvents = null;
               }

               field726 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            long var12;
            long var19;
            long var21;
            long var23;
            String var37;
            if(ServerPacket.field2193 == var1.serverPacket) {
               var37 = var3.method5695();
               var19 = var3.method5581();
               var21 = (long)var3.method5577();
               var23 = (long)var3.method5702();
               PlayerType var43 = (PlayerType)GrandExchangeEvent.method159(InterfaceParent.method1278(), var3.method5575());
               var12 = var23 + (var21 << 32);
               boolean var44 = false;

               for(int var15 = 0; var15 < 100; ++var15) {
                  if(var12 == field846[var15]) {
                     var44 = true;
                     break;
                  }
               }

               if(var43.isUser && Projectile.friendSystem.method1958(new Username(var37, WorldMapIcon_0.loginType))) {
                  var44 = true;
               }

               if(!var44 && field794 == 0) {
                  field846[field900] = var12;
                  field900 = (field900 + 1) % 100;
                  String var25 = AbstractFont.method5416(Decimator.method2636(JagexCache.method3578(var3)));
                  if(var43.modIcon != -1) {
                     ChatChannel.method2355(9, class1.method21(var43.modIcon) + var37, var25, Buffer.method5792(var19));
                  } else {
                     ChatChannel.method2355(9, var37, var25, Buffer.method5792(var19));
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2176 == var1.serverPacket) {
               var16 = var3.method5565();
               var5 = var3.method5580();
               var6 = var16 >> 10 & 31;
               var42 = var16 >> 5 & 31;
               var8 = var16 & 31;
               var9 = (var42 << 11) + (var6 << 19) + (var8 << 3);
               Widget var51 = MusicPatchNode.method3920(var5);
               if(var9 != var51.color) {
                  var51.color = var9;
                  ItemContainer.method1273(var51);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2137 == var1.serverPacket) {
               var16 = var3.method5580();
               if(var16 != field762) {
                  field762 = var16;
                  class3.method48();
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2184 == var1.serverPacket) {
               isCameraLocked = false;

               for(var16 = 0; var16 < 5; ++var16) {
                  field926[var16] = false;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2143 == var1.serverPacket) {
               destinationX = var3.method5575();
               if(destinationX == 255) {
                  destinationX = 0;
               }

               destinationY = var3.method5575();
               if(destinationY == 255) {
                  destinationY = 0;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2153 == var1.serverPacket) {
               var16 = var3.method5580();
               var5 = var3.method5577();
               if(var16 < -70000) {
                  var5 += '\u8000';
               }

               if(var16 >= 0) {
                  var50 = MusicPatchNode.method3920(var16);
               } else {
                  var50 = null;
               }

               for(; var3.offset < var1.serverPacketLength; Messages.method2330(var5, var42, var8 - 1, var9)) {
                  var42 = var3.method5589();
                  var8 = var3.method5577();
                  var9 = 0;
                  if(var8 != 0) {
                     var9 = var3.method5575();
                     if(var9 == 255) {
                        var9 = var3.method5580();
                     }
                  }

                  if(var50 != null && var42 >= 0 && var42 < var50.itemIds.length) {
                     var50.itemIds[var42] = var8;
                     var50.itemQuantities[var42] = var9;
                  }
               }

               if(var50 != null) {
                  ItemContainer.method1273(var50);
               }

               class58.method966();
               changedItemContainers[++field869 - 1 & 31] = var5 & 32767;
               ItemContainer.onItemContainerUpdate(field869 + 1 - 1 & 31);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2133 == var1.serverPacket) {
               var16 = var3.method5580();
               var27 = var3.method5695();
               var50 = MusicPatchNode.method3920(var16);
               if(!var27.equals(var50.text)) {
                  var50.text = var27;
                  ItemContainer.method1273(var50);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2171 == var1.serverPacket) {
               var16 = var3.method5615();
               if(var16 == '\uffff') {
                  var16 = -1;
               }

               StudioGame.method4244(var16);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2173 == var1.serverPacket) {
               var16 = var3.method5702();
               var5 = var3.method5577();
               if(var5 == '\uffff') {
                  var5 = -1;
               }

               VerticalAlignment.method4440(var5, var16);
               var1.serverPacket = null;
               return true;
            }

            Widget var28;
            if(ServerPacket.field2168 == var1.serverPacket) {
               var16 = var3.method5614();
               var5 = var3.method5620();
               var6 = var3.method5615();
               var42 = var3.method5577();
               var28 = MusicPatchNode.method3920(var5);
               if(var42 != var28.modelAngleX || var16 != var28.modelAngleY || var6 != var28.modelZoom) {
                  var28.modelAngleX = var42;
                  var28.modelAngleY = var16;
                  var28.modelZoom = var6;
                  ItemContainer.method1273(var28);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2203 == var1.serverPacket) {
               if(InterfaceParent.clanChat != null) {
                  InterfaceParent.clanChat.method5302(var3);
               }

               WorldMapData_0.method263();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2155 == var1.serverPacket) {
               class58.method966();
               var16 = var3.method5605();
               var5 = var3.method5604();
               var6 = var3.method5620();
               experience[var5] = var6;
               experiencedChanged(var5);
               currentLevels[var5] = var16;
               boostedSkillLevelsChanged(var5);
               levels[var5] = 1;

               for(var42 = 0; var42 < 98; ++var42) {
                  if(var6 >= Skills.Skills_experienceTable[var42]) {
                     levels[var5] = var42 + 2;
                  }
               }

               changedSkills[++changedSkillsCount - 1 & 31] = var5;
               var1.serverPacket = null;
               return true;
            }

            InterfaceParent var17;
            if(ServerPacket.field2182 == var1.serverPacket) {
               var16 = var3.method5605();
               var5 = var3.method5614();
               var6 = var3.method5639();
               var17 = (InterfaceParent)interfaceParents.method6046((long)var6);
               if(var17 != null) {
                  class41.method653(var17, var5 != var17.group);
               }

               AbstractWorldMapData.method382(var6, var5, var16);
               var1.serverPacket = null;
               return true;
            }

            String var48;
            if(ServerPacket.field2175 == var1.serverPacket) {
               byte[] var41 = new byte[var1.serverPacketLength];
               var3.method5517(var41, 0, var41.length);
               Buffer var59 = new Buffer(var41);
               var48 = var59.method5695();
               Script.method2336(var48, true, false);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2150 == var1.serverPacket) {
               WorldMapData_1.method816(class194.field2330);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2154 == var1.serverPacket) {
               if(rootInterface != -1) {
                  class198.method3733(rootInterface, 0);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2172 == var1.serverPacket) {
               var3.offset += 28;
               if(var3.method5572()) {
                  ModelData0.method3362(var3, var3.offset - 28);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2152 == var1.serverPacket) {
               ApproximateRouteStrategy.method1328(var3.method5695());
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2141 == var1.serverPacket) {
               WorldMapData_1.method816(class194.field2324);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2198 == var1.serverPacket) {
               WorldMapData_1.method816(class194.field2326);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2159 == var1.serverPacket) {
               World var40 = new World();
               var40.host = var3.method5695();
               var40.id = var3.method5577();
               var5 = var3.method5580();
               var40.properties = var5;
               MouseRecorder.method1293(45);
               var2.vmethod5894();
               var2 = null;
               UserComparator3.method3526(var40);
               var1.serverPacket = null;
               return false;
            }

            if(ServerPacket.field2126 == var1.serverPacket) {
               var16 = var3.method5744();
               var5 = var3.method5622();
               var50 = MusicPatchNode.method3920(var5);
               if(var16 != var50.sequenceId || var16 == -1) {
                  var50.sequenceId = var16;
                  var50.modelFrame = 0;
                  var50.modelFrameCycle = 0;
                  ItemContainer.method1273(var50);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2132 == var1.serverPacket) {
               var16 = var3.method5577();
               var5 = var3.method5575();
               var6 = var3.method5577();
               ModelData0.method3364(var16, var5, var6);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2158 == var1.serverPacket) {
               PlatformInfo.field3959 = var3.method5606();
               GrandExchangeOfferTotalQuantityComparator.field91 = var3.method5606();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2166 == var1.serverPacket) {
               isCameraLocked = true;
               field925 = var3.method5575() * 128;
               Strings.field2759 = var3.method5575() * 128;
               TextureProvider.field1549 = var3.method5577();
               Friend.field3626 = var3.method5575();
               Players.field1280 = var3.method5575();
               if(Players.field1280 >= 100) {
                  var16 = field925 * 16384 + 64;
                  var5 = Strings.field2759 * 16384 + 64;
                  var6 = class277.method5038(var16, var5, ScriptEvent.Client_plane) - TextureProvider.field1549;
                  var42 = var16 - WorldMapRectangle.cameraX;
                  var8 = var6 - GrandExchangeOfferWorldComparator.cameraY;
                  var9 = var5 - class200.cameraZ;
                  var10 = (int)Math.sqrt((double)(var42 * var42 + var9 * var9));
                  ApproximateRouteStrategy.cameraPitch = (int)(Math.atan2((double)var8, (double)var10) * 325.949D) & 2047;
                  onCameraPitchChanged(-1);
                  WorldMapIcon_1.cameraYaw = (int)(Math.atan2((double)var42, (double)var9) * -325.949D) & 2047;
                  if(ApproximateRouteStrategy.cameraPitch < 128) {
                     ApproximateRouteStrategy.cameraPitch = 128;
                     onCameraPitchChanged(-1);
                  }

                  if(ApproximateRouteStrategy.cameraPitch > 383) {
                     ApproximateRouteStrategy.cameraPitch = 383;
                     onCameraPitchChanged(-1);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2139 == var1.serverPacket) {
               GameObject.method3407(false, var1.packetBuffer);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2140 == var1.serverPacket) {
               var16 = var3.method5639();
               var5 = var3.method5614();
               var50 = MusicPatchNode.method3920(var16);
               if(var50.modelType != 2 || var5 != var50.modelId) {
                  var50.modelType = 2;
                  var50.modelId = var5;
                  ItemContainer.method1273(var50);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2128 == var1.serverPacket) {
               for(var16 = 0; var16 < Varps.Varps_main.length; ++var16) {
                  if(Varps.Varps_temp[var16] != Varps.Varps_main[var16]) {
                     Varps.Varps_main[var16] = Varps.Varps_temp[var16];
                     settingsChanged(var16);
                     class22.method253(var16, (byte)-63);
                     field866[++field772 - 1 & 31] = var16;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2130 == var1.serverPacket) {
               GameObject.method3407(true, var1.packetBuffer);
               var1.serverPacket = null;
               return true;
            }

            boolean var39;
            if(ServerPacket.field2196 == var1.serverPacket) {
               var16 = var3.method5639();
               var39 = var3.method5575() == 1;
               var50 = MusicPatchNode.method3920(var16);
               if(var39 != var50.isHidden) {
                  var50.isHidden = var39;
                  var50.onHiddenChanged(-1);
                  ItemContainer.method1273(var50);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2142 == var1.serverPacket) {
               var37 = var3.method5695();
               var27 = AbstractFont.method5416(Decimator.method2636(JagexCache.method3578(var3)));
               Skeleton.method3175(6, var37, var27);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2194 == var1.serverPacket) {
               PlatformInfo.field3959 = var3.method5606();
               GrandExchangeOfferTotalQuantityComparator.field91 = var3.method5575();

               while(var3.offset < var1.serverPacketLength) {
                  var16 = var3.method5575();
                  class194 var58 = WorldMapSection2.method434()[var16];
                  WorldMapData_1.method816(var58);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2131 == var1.serverPacket) {
               if(var1.serverPacketLength == 0) {
                  InterfaceParent.clanChat = null;
                  clanMemberManagerChanged(-1);
               } else {
                  if(InterfaceParent.clanChat == null) {
                     InterfaceParent.clanChat = new ClanChat(WorldMapIcon_0.loginType, WorldMapSection1.client);
                     clanMemberManagerChanged(-1);
                  }

                  InterfaceParent.clanChat.method5301(var3);
               }

               WorldMapData_0.method263();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2148 == var1.serverPacket) {
               var37 = var3.method5695();
               var19 = (long)var3.method5577();
               var21 = (long)var3.method5702();
               PlayerType var29 = (PlayerType)GrandExchangeEvent.method159(InterfaceParent.method1278(), var3.method5575());
               long var30 = (var19 << 32) + var21;
               boolean var32 = false;

               for(int var13 = 0; var13 < 100; ++var13) {
                  if(field846[var13] == var30) {
                     var32 = true;
                     break;
                  }
               }

               if(Projectile.friendSystem.method1958(new Username(var37, WorldMapIcon_0.loginType))) {
                  var32 = true;
               }

               if(!var32 && field794 == 0) {
                  field846[field900] = var30;
                  field900 = (field900 + 1) % 100;
                  String var33 = AbstractFont.method5416(Decimator.method2636(JagexCache.method3578(var3)));
                  byte var14;
                  if(var29.isPrivileged) {
                     var14 = 7;
                  } else {
                     var14 = 3;
                  }

                  if(var29.modIcon != -1) {
                     Skeleton.method3175(var14, class1.method21(var29.modIcon) + var37, var33);
                  } else {
                     Skeleton.method3175(var14, var37, var33);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2189 == var1.serverPacket) {
               var16 = var3.method5615();
               if(var16 == '\uffff') {
                  var16 = -1;
               }

               var5 = var3.method5620();
               var6 = var3.method5622();
               var47 = MusicPatchNode.method3920(var6);
               ItemDefinition var56;
               if(!var47.isIf3) {
                  if(var16 == -1) {
                     var47.modelType = 0;
                     var1.serverPacket = null;
                     return true;
                  }

                  var56 = AbstractWorldMapData.method373(var16);
                  var47.modelType = 4;
                  var47.modelId = var16;
                  var47.modelAngleX = var56.xan2d;
                  var47.modelAngleY = var56.yan2d;
                  var47.modelZoom = var56.zoom2d * 100 / var5;
                  ItemContainer.method1273(var47);
               } else {
                  var47.itemId = var16;
                  var47.itemQuantity = var5;
                  var56 = AbstractWorldMapData.method373(var16);
                  var47.modelAngleX = var56.xan2d;
                  var47.modelAngleY = var56.yan2d;
                  var47.modelAngleZ = var56.zan2d;
                  var47.modelOffsetX = var56.offsetX2d;
                  var47.modelOffsetY = var56.offsetY2d;
                  var47.modelZoom = var56.zoom2d;
                  if(var56.isStackable == 1) {
                     var47.itemQuantityMode = 1;
                  } else {
                     var47.itemQuantityMode = 2;
                  }

                  if(var47.field2622 > 0) {
                     var47.modelZoom = var47.modelZoom * 32 / var47.field2622;
                  } else if(var47.rawWidth > 0) {
                     var47.modelZoom = var47.modelZoom * 32 / var47.rawWidth;
                  }

                  ItemContainer.method1273(var47);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2180 == var1.serverPacket) {
               GrandExchangeOffer.method212(false, var3);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2165 == var1.serverPacket) {
               class58.method966();
               runEnergy = var3.method5575();
               field877 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2192 == var1.serverPacket) {
               var37 = var3.method5695();
               var5 = var3.method5605();
               var6 = var3.method5604();
               if(var6 >= 1 && var6 <= 8) {
                  if(var37.equalsIgnoreCase("null")) {
                     var37 = null;
                  }

                  playerMenuActions[var6 - 1] = var37;
                  playerOptionsChanged(var6 - 1);
                  playerOptionsPriorities[var6 - 1] = var5 == 0;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2163 == var1.serverPacket) {
               UserComparator3.privateChatMode = class219.method4053(var3.method5575());
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2149 == var1.serverPacket) {
               WorldMapData_1.method816(class194.field2332);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2156 == var1.serverPacket) {
               WorldMapData_1.method816(class194.field2327);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2127 == var1.serverPacket) {
               minimapState = var3.method5575();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2191 == var1.serverPacket) {
               var16 = var3.offset + var1.serverPacketLength;
               var5 = var3.method5577();
               var6 = var3.method5577();
               if(var5 != rootInterface) {
                  rootInterface = var5;
                  this.method1418(false);
                  class4.method73(rootInterface);
                  WorldMapSectionType.method349(rootInterface, -1408689953);

                  for(var42 = 0; var42 < 100; ++var42) {
                     field679[var42] = true;
                  }
               }

               InterfaceParent var26;
               for(; var6-- > 0; var26.field594 = true) {
                  var42 = var3.method5580();
                  var8 = var3.method5577();
                  var9 = var3.method5575();
                  var26 = (InterfaceParent)interfaceParents.method6046((long)var42);
                  if(var26 != null && var8 != var26.group) {
                     class41.method653(var26, true);
                     var26 = null;
                  }

                  if(var26 == null) {
                     var26 = AbstractWorldMapData.method382(var42, var8, var9);
                  }
               }

               for(var17 = (InterfaceParent)interfaceParents.method6031(); var17 != null; var17 = (InterfaceParent)interfaceParents.method6039()) {
                  if(var17.field594) {
                     var17.field594 = false;
                  } else {
                     class41.method653(var17, true);
                  }
               }

               widgetClickMasks = new NodeHashTable(512);

               while(var3.offset < var16) {
                  var42 = var3.method5580();
                  var8 = var3.method5577();
                  var9 = var3.method5577();
                  var10 = var3.method5580();

                  for(int var34 = var8; var34 <= var9; ++var34) {
                     var12 = (long)var34 + ((long)var42 << 32);
                     widgetClickMasks.method6033(new IntegerNode(var10), var12);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2188 == var1.serverPacket) {
               var16 = var3.method5580();
               InterfaceParent var57 = (InterfaceParent)interfaceParents.method6046((long)var16);
               if(var57 != null) {
                  class41.method653(var57, true);
               }

               if(meslayerContinueWidget != null) {
                  ItemContainer.method1273(meslayerContinueWidget);
                  meslayerContinueWidget = null;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2134 == var1.serverPacket) {
               GrandExchangeOfferTotalQuantityComparator.field91 = var3.method5575();
               PlatformInfo.field3959 = var3.method5606();

               for(var16 = GrandExchangeOfferTotalQuantityComparator.field91; var16 < GrandExchangeOfferTotalQuantityComparator.field91 + 8; ++var16) {
                  for(var5 = PlatformInfo.field3959; var5 < PlatformInfo.field3959 + 8; ++var5) {
                     if(groundItems[ScriptEvent.Client_plane][var16][var5] != null) {
                        groundItems[ScriptEvent.Client_plane][var16][var5] = null;
                        World.method1898(var16, var5);
                     }
                  }
               }

               for(PendingSpawn var38 = (PendingSpawn)pendingSpawns.method4956(); var38 != null; var38 = (PendingSpawn)pendingSpawns.method4974()) {
                  if(var38.x >= GrandExchangeOfferTotalQuantityComparator.field91 && var38.x < GrandExchangeOfferTotalQuantityComparator.field91 + 8 && var38.y >= PlatformInfo.field3959 && var38.y < PlatformInfo.field3959 + 8 && var38.plane == ScriptEvent.Client_plane) {
                     var38.hitpoints = 0;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2169 == var1.serverPacket) {
               for(var16 = 0; var16 < VarpDefinition.VarpDefinition_fileCount; ++var16) {
                  VarpDefinition var54 = class228.method4204(var16);
                  if(var54 != null) {
                     Varps.Varps_temp[var16] = 0;
                     Varps.Varps_main[var16] = 0;
                     settingsChanged(var16);
                  }
               }

               class58.method966();
               field772 += 32;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2136 == var1.serverPacket) {
               var16 = var3.method5575();
               class22.method256(var16);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2178 == var1.serverPacket) {
               var16 = var3.method5565();
               var5 = var3.method5620();
               var50 = MusicPatchNode.method3920(var5);
               if(var50 != null && var50.type == 0) {
                  if(var16 > var50.scrollHeight - var50.height) {
                     var16 = var50.scrollHeight - var50.height;
                  }

                  if(var16 < 0) {
                     var16 = 0;
                  }

                  if(var16 != var50.scrollY) {
                     var50.scrollY = var16;
                     ItemContainer.method1273(var50);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2190 == var1.serverPacket) {
               GrandExchangeOfferTotalQuantityComparator.method169(var3, var1.serverPacketLength);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2118 == var1.serverPacket) {
               var16 = var3.method5565();
               ScriptFrame.method1242(var16);
               changedItemContainers[++field869 - 1 & 31] = var16 & 32767;
               ItemContainer.onItemContainerUpdate(field869 + 1 - 1 & 31);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2120 == var1.serverPacket) {
               GrandExchangeOffer.method212(true, var3);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2122 == var1.serverPacket) {
               var16 = var3.method5580();
               var5 = var3.method5580();
               var6 = RouteStrategy.method3669();
               PacketBufferNode var46 = FaceNormal.method3377(ClientPacket.field2218, packetWriter.isaacCipher);
               var46.packetBuffer.method5619(var16);
               var46.packetBuffer.method5618(var5);
               var46.packetBuffer.method5728(GameShell.fps);
               var46.packetBuffer.method5728(var6);
               packetWriter.method2375(var46);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2138 == var1.serverPacket) {
               Projectile.friendSystem.ignoreList.method5137(var3, var1.serverPacketLength);
               FontName.method5387();
               field873 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2174 == var1.serverPacket) {
               class4.method72(var3, var1.serverPacketLength);
               Login.method2177();
               var1.serverPacket = null;
               return true;
            }

            Widget var53;
            if(ServerPacket.field2181 == var1.serverPacket) {
               var16 = var3.method5620();
               var53 = MusicPatchNode.method3920(var16);

               for(var6 = 0; var6 < var53.itemIds.length; ++var6) {
                  var53.itemIds[var6] = -1;
                  var53.itemIds[var6] = 0;
               }

               ItemContainer.method1273(var53);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2201 == var1.serverPacket) {
               var16 = var3.method5565();
               if(var16 == '\uffff') {
                  var16 = -1;
               }

               var5 = var3.method5639();
               var6 = var3.method5580();
               var42 = var3.method5615();
               if(var42 == '\uffff') {
                  var42 = -1;
               }

               for(var8 = var16; var8 <= var42; ++var8) {
                  var23 = (long)var8 + ((long)var5 << 32);
                  Node var11 = widgetClickMasks.method6046(var23);
                  if(var11 != null) {
                     var11.method3676();
                  }

                  widgetClickMasks.method6033(new IntegerNode(var6), var23);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2123 == var1.serverPacket) {
               var16 = var3.method5622();
               var53 = MusicPatchNode.method3920(var16);
               var53.modelType = 3;
               var53.modelId = ByteArrayPool.localPlayer.appearance.method4096();
               ItemContainer.method1273(var53);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2167 == var1.serverPacket) {
               var37 = var3.method5695();
               Object[] var52 = new Object[var37.length() + 1];

               for(var6 = var37.length() - 1; var6 >= 0; --var6) {
                  if(var37.charAt(var6) == 115) {
                     var52[var6 + 1] = var3.method5695();
                  } else {
                     var52[var6 + 1] = new Integer(var3.method5580());
                  }
               }

               var52[0] = new Integer(var3.method5580());
               ScriptEvent var49 = new ScriptEvent();
               var49.args = var52;
               GrandExchangeOfferOwnWorldComparator.method1395(var49);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2157 == var1.serverPacket) {
               var16 = var3.method5589();
               var39 = var3.method5575() == 1;
               var48 = "";
               boolean var7 = false;
               if(var39) {
                  var48 = var3.method5695();
                  if(Projectile.friendSystem.method1958(new Username(var48, WorldMapIcon_0.loginType))) {
                     var7 = true;
                  }
               }

               String var55 = var3.method5695();
               if(!var7) {
                  Skeleton.method3175(var16, var48, var55);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2151 == var1.serverPacket) {
               for(var16 = 0; var16 < players.length; ++var16) {
                  if(players[var16] != null) {
                     players[var16].sequence = -1;
                     players[var16].animationChanged(-1);
                  }
               }

               for(var16 = 0; var16 < npcs.length; ++var16) {
                  if(npcs[var16] != null) {
                     npcs[var16].sequence = -1;
                     npcs[var16].animationChanged(-1);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2170 == var1.serverPacket) {
               var16 = var3.method5575();
               if(var3.method5575() == 0) {
                  grandExchangeOffers[var16] = new GrandExchangeOffer();
                  onGrandExchangeOffersChanged(var16);
                  var3.offset += 18;
               } else {
                  --var3.offset;
                  grandExchangeOffers[var16] = new GrandExchangeOffer(var3, false);
                  onGrandExchangeOffersChanged(var16);
               }

               field774 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2124 == var1.serverPacket) {
               var16 = var3.method5639();
               var5 = var3.method5580();
               InterfaceParent var18 = (InterfaceParent)interfaceParents.method6046((long)var5);
               var17 = (InterfaceParent)interfaceParents.method6046((long)var16);
               if(var17 != null) {
                  class41.method653(var17, var18 == null || var18.group != var17.group);
               }

               if(var18 != null) {
                  var18.method3676();
                  interfaceParents.method6033(var18, (long)var16);
               }

               var28 = MusicPatchNode.method3920(var5);
               if(var28 != null) {
                  ItemContainer.method1273(var28);
               }

               var28 = MusicPatchNode.method3920(var16);
               if(var28 != null) {
                  ItemContainer.method1273(var28);
                  MouseHandler.method1161(Widget.Widget_interfaceComponents[var28.id >>> 16], var28, true);
               }

               if(rootInterface != -1) {
                  class198.method3733(rootInterface, 1);
               }

               var1.serverPacket = null;
               return true;
            }

            WorldMapDecorationType.method4214("" + (var1.serverPacket != null?var1.serverPacket.id:-1) + "," + (var1.field1329 != null?var1.field1329.id:-1) + "," + (var1.field1339 != null?var1.field1339.id:-1) + "," + var1.serverPacketLength, (Throwable)null);
            Huffman.method4041();
         } catch (IOException var35) {
            VertexNormal.method3093();
         } catch (Exception var36) {
            var27 = "" + (var1.serverPacket != null?var1.serverPacket.id:-1) + "," + (var1.field1329 != null?var1.field1329.id:-1) + "," + (var1.field1339 != null?var1.field1339.id:-1) + "," + var1.serverPacketLength + "," + (ByteArrayPool.localPlayer.pathX[0] + class69.baseX * 64) + "," + (ByteArrayPool.localPlayer.pathY[0] + class89.baseY * 64) + ",";

            for(var6 = 0; var6 < var1.serverPacketLength && var6 < 50; ++var6) {
               var27 = var27 + var3.array[var6] + ",";
            }

            WorldMapDecorationType.method4214(var27, var36);
            Huffman.method4041();
         }

         return true;
      }
   }

   @ObfuscatedName("ho")
   final void method1415(byte var1) {
      Menu var2 = Menu.MENU;
      var2.reset();
      this.getCallbacks().post(Menu.class, var2);
      if(var2.shouldRun()) {
         this.copy$menu(var1);
      }

   }

   @ObfuscatedName("hr")
   final boolean method1800(int var1) {
      if(this.copy$shouldLeftClickOpenMenu(var1)) {
         return true;
      } else {
         MenuShouldLeftClick var2 = new MenuShouldLeftClick();
         WorldMapSection1.client.getCallbacks().post(MenuShouldLeftClick.class, var2);
         if(var2.isForceRightClick()) {
            return true;
         } else {
            int var3 = this.getMenuOptionCount();
            if(var3 > 0) {
               int var4 = this.getMenuOpcodes()[var3 - 1];
               return var4 == MenuOpcode.RUNELITE_OVERLAY.getId();
            } else {
               return false;
            }
         }
      }
   }

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1195546849"
   )
   final void method1705(int var1, int var2) {
      this.menuOpened(var1, var2);
      MusicPatchNode.method3923(var1, var2);
      GrandExchangeOfferWorldComparator.scene.method3213(ScriptEvent.Client_plane, var1, var2, false);
      isMenuOpen = true;
   }

   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "0"
   )
   final void method1418(boolean var1) {
      int var2 = rootInterface;
      int var3 = WorldMapLabel.canvasWidth;
      int var4 = Varps.canvasHeight;
      if(LoginScreenAnimation.method1914(var2)) {
         InterfaceParent.method1280(Widget.Widget_interfaceComponents[var2], -1, var3, var4, var1);
      }

   }

   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "(Lhe;I)V",
      garbageValue = "-159825150"
   )
   void method1419(Widget var1) {
      Widget var2 = var1.parentId == -1?null:MusicPatchNode.method3920(var1.parentId);
      int var3;
      int var4;
      if(var2 == null) {
         var3 = WorldMapLabel.canvasWidth;
         var4 = Varps.canvasHeight;
      } else {
         var3 = var2.width;
         var4 = var2.height;
      }

      WorldMapAreaData.method781(var1, var3, var4, false);
      WorldMapLabelSize.method291(var1, var3, var4);
   }

   @ObfuscatedName("jz")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "22074"
   )
   final void method1420() {
      ItemContainer.method1273(clickedWidget);
      ++MilliClock.widgetDragDuration;
      if(field861 && field732) {
         int var1 = MouseHandler.MouseHandler_x;
         int var2 = MouseHandler.MouseHandler_y;
         var1 -= widgetClickX;
         var2 -= widgetClickY;
         if(var1 < field859) {
            var1 = field859;
         }

         if(var1 + clickedWidget.width > field859 + clickedWidgetParent.width) {
            var1 = field859 + clickedWidgetParent.width - clickedWidget.width;
         }

         if(var2 < field881) {
            var2 = field881;
         }

         if(var2 + clickedWidget.height > field881 + clickedWidgetParent.height) {
            var2 = field881 + clickedWidgetParent.height - clickedWidget.height;
         }

         int var3 = var1 - field834;
         int var4 = var2 - field863;
         int var5 = clickedWidget.dragZoneSize;
         if(MilliClock.widgetDragDuration > clickedWidget.dragThreshold && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
            isDraggingWidget = true;
            draggingWidgetChanged(-1);
         }

         int var6 = var1 - field859 + clickedWidgetParent.scrollX;
         int var7 = var2 - field881 + clickedWidgetParent.scrollY;
         ScriptEvent var8;
         if(clickedWidget.onDrag != null && isDraggingWidget) {
            var8 = new ScriptEvent();
            var8.widget = clickedWidget;
            var8.mouseX = var6;
            var8.mouseY = var7;
            var8.args = clickedWidget.onDrag;
            GrandExchangeOfferOwnWorldComparator.method1395(var8);
         }

         if(MouseHandler.MouseHandler_currentButton == 0) {
            if(isDraggingWidget) {
               if(clickedWidget.onDragComplete != null) {
                  var8 = new ScriptEvent();
                  var8.widget = clickedWidget;
                  var8.mouseX = var6;
                  var8.mouseY = var7;
                  var8.dragTarget = draggedOnWidget;
                  var8.args = clickedWidget.onDragComplete;
                  GrandExchangeOfferOwnWorldComparator.method1395(var8);
               }

               if(draggedOnWidget != null && GrandExchangeOfferTotalQuantityComparator.method181(clickedWidget) != null) {
                  PacketBufferNode var12 = FaceNormal.method3377(ClientPacket.field2234, packetWriter.isaacCipher);
                  var12.packetBuffer.method5618(draggedOnWidget.id);
                  var12.packetBuffer.method5611(draggedOnWidget.childIndex);
                  var12.packetBuffer.method5619(clickedWidget.id);
                  var12.packetBuffer.method5610(draggedOnWidget.itemId);
                  var12.packetBuffer.method5610(clickedWidget.childIndex);
                  var12.packetBuffer.method5610(clickedWidget.itemId);
                  packetWriter.method2375(var12);
               }
            } else if(this.method1800(815051864)) {
               this.method1705(field834 + widgetClickX, widgetClickY + field863);
            } else if(menuOptionsCount > 0) {
               int var11 = field834 + widgetClickX;
               int var9 = widgetClickY + field863;
               MenuAction var10 = AbstractWorldMapIcon.tempMenuAction;
               AbstractByteArrayCopier.method4027(var10.param0, var10.param1, var10.opcode, var10.identifier, var10.action, var10.action, var11, var9, 1911566700);
               AbstractWorldMapIcon.tempMenuAction = null;
               onTempMenuActionChanged(-1);
            }

            clickedWidget = null;
         }

      } else {
         if(MilliClock.widgetDragDuration > 1) {
            clickedWidget = null;
         }

      }
   }

   @ObfuscatedName("kd")
   @ObfuscatedSignature(
      signature = "(I)Lku;",
      garbageValue = "-1860083598"
   )
   public Username vmethod5248() {
      return ByteArrayPool.localPlayer != null?ByteArrayPool.localPlayer.username:null;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "11"
   )
   public static void method1496() {
      class206.midiPcmStream.method3883();
      class206.field2406 = 1;
      class206.musicTrackArchive = null;
   }

   @ObfuscatedSignature(
      signature = "(Lbb;II)V"
   )
   public static void copy$runScript(ScriptEvent var0, int var1, int var2) {
      Object[] var3 = var0.args;
      Script var4;
      int var18;
      if(class25.method280(var0.type)) {
         if(var2 == 954895284) {
            return;
         }

         TileItem.worldMapEvent = (WorldMapEvent)var3[0];
         WorldMapElement var5 = class25.method279(TileItem.worldMapEvent.mapElement);
         var4 = currentScript = BoundaryObject.method3375(var0.type, var5.objectId, var5.category);
      } else {
         var18 = currentScriptPC = ((Integer)var3[0]).intValue();
         var4 = currentScript = WorldMapSprite.method511(var18);
      }

      if(var4 != null) {
         Interpreter.Interpreter_intStackSize = 0;
         Interpreter.Interpreter_stringStackSize = 0;
         currentScriptPC = -1;
         var18 = -1;
         int[] var6 = var4.opcodes;
         int[] var7 = var4.intOperands;
         byte var8 = -1;
         Interpreter.Interpreter_frameDepth = 0;
         Interpreter.field1125 = false;
         boolean var28 = false;

         label873: {
            label874: {
               try {
                  int var11;
                  try {
                     var28 = true;
                     AbstractUserComparator.Interpreter_intLocals = new int[var4.localIntCount];
                     int var9 = 0;
                     Interpreter.Interpreter_stringLocals = new String[var4.localStringCount];
                     int var10 = 0;

                     int var12;
                     String var19;
                     for(var11 = 1; var11 < var3.length; ++var11) {
                        if(var2 == 954895284) {
                           return;
                        }

                        if(var3[var11] instanceof Integer) {
                           if(var2 == 954895284) {
                              return;
                           }

                           var12 = ((Integer)var3[var11]).intValue();
                           if(var12 == -2147483647) {
                              var12 = var0.mouseX;
                           }

                           if(var12 == -2147483646) {
                              var12 = var0.mouseY;
                           }

                           if(var12 == -2147483645) {
                              var12 = var0.widget != null?var0.widget.id:-1;
                           }

                           if(var12 == -2147483644) {
                              var12 = var0.opIndex;
                           }

                           if(var12 == -2147483643) {
                              var12 = var0.widget != null?var0.widget.childIndex:-1;
                           }

                           if(var12 == -2147483642) {
                              if(var2 == 954895284) {
                                 return;
                              }

                              var12 = var0.dragTarget != null?var0.dragTarget.id:-1;
                           }

                           if(var12 == -2147483641) {
                              var12 = var0.dragTarget != null?var0.dragTarget.childIndex:-1;
                           }

                           if(var12 == -2147483640) {
                              var12 = var0.keyTyped;
                           }

                           if(var12 == -2147483639) {
                              var12 = var0.keyPressed;
                           }

                           AbstractUserComparator.Interpreter_intLocals[var9++] = var12;
                        } else if(var3[var11] instanceof String) {
                           if(var2 == 954895284) {
                              return;
                           }

                           var19 = (String)var3[var11];
                           if(var19.equals("event_opbase")) {
                              var19 = var0.targetName;
                           }

                           Interpreter.Interpreter_stringLocals[var10++] = var19;
                        }
                     }

                     var11 = 0;
                     Interpreter.field1127 = var0.field604;

                     label854:
                     while(true) {
                        ++var11;
                        if(var11 > var1) {
                           if(var2 == 954895284) {
                              return;
                           }

                           throw new RuntimeException();
                        }

                        int var31;
                        do {
                           ++var18;
                           currentScriptPC = var18;
                           var31 = var6[var18];
                        } while(vmExecuteOpcode(var31));

                        int var21;
                        if(var31 < 100) {
                           if(var2 == 954895284) {
                              return;
                           }

                           if(var31 == 0) {
                              if(var2 == 954895284) {
                                 return;
                              }

                              Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7[var18];
                           } else if(var31 == 1) {
                              var12 = var7[var18];
                              Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Varps.Varps_main[var12];
                           } else if(var31 == 2) {
                              var12 = var7[var18];
                              Varps.Varps_main[var12] = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                              settingsChanged(var12);
                              class22.method253(var12, (byte)-55);
                           } else if(var31 == 3) {
                              Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var4.stringOperands[var18];
                           } else {
                              int var10000;
                              int var10001;
                              if(var31 == 6) {
                                 var10001 = var7[var18];
                                 var10000 = var18 + var7[var18];
                                 currentScriptPC = var18 + var10001;
                                 var18 = var10000;
                              } else if(var31 == 7) {
                                 Interpreter.Interpreter_intStackSize -= 2;
                                 if(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] != Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
                                    var10001 = var7[var18];
                                    var10000 = var18 + var7[var18];
                                    currentScriptPC = var18 + var10001;
                                    var18 = var10000;
                                 }
                              } else if(var31 == 8) {
                                 Interpreter.Interpreter_intStackSize -= 2;
                                 if(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] == Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
                                    if(var2 == 954895284) {
                                       return;
                                    }

                                    var10001 = var7[var18];
                                    var10000 = var18 + var7[var18];
                                    currentScriptPC = var18 + var10001;
                                    var18 = var10000;
                                 }
                              } else if(var31 == 9) {
                                 Interpreter.Interpreter_intStackSize -= 2;
                                 if(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] < Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
                                    var10001 = var7[var18];
                                    var10000 = var18 + var7[var18];
                                    currentScriptPC = var18 + var10001;
                                    var18 = var10000;
                                 }
                              } else if(var31 == 10) {
                                 Interpreter.Interpreter_intStackSize -= 2;
                                 if(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] > Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
                                    if(var2 == 954895284) {
                                       return;
                                    }

                                    var10001 = var7[var18];
                                    var10000 = var18 + var7[var18];
                                    currentScriptPC = var18 + var10001;
                                    var18 = var10000;
                                 }
                              } else if(var31 == 21) {
                                 if(Interpreter.Interpreter_frameDepth == 0) {
                                    var28 = false;
                                    break label874;
                                 }

                                 ScriptFrame var34 = Interpreter.Interpreter_frames[--Interpreter.Interpreter_frameDepth];
                                 var4 = currentScript = var34.script;
                                 var6 = var4.opcodes;
                                 var7 = var4.intOperands;
                                 var18 = currentScriptPC = var34.pc;
                                 AbstractUserComparator.Interpreter_intLocals = var34.intLocals;
                                 Interpreter.Interpreter_stringLocals = var34.stringLocals;
                              } else if(var31 == 25) {
                                 var12 = var7[var18];
                                 Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Projectile.method2211(var12);
                              } else if(var31 == 27) {
                                 if(var2 == 954895284) {
                                    return;
                                 }

                                 var12 = var7[var18];
                                 FloorDecoration.method2952(var12, Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
                              } else if(var31 == 31) {
                                 if(var2 == 954895284) {
                                    return;
                                 }

                                 Interpreter.Interpreter_intStackSize -= 2;
                                 if(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] <= Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
                                    var10001 = var7[var18];
                                    var10000 = var18 + var7[var18];
                                    currentScriptPC = var18 + var10001;
                                    var18 = var10000;
                                 }
                              } else if(var31 == 32) {
                                 Interpreter.Interpreter_intStackSize -= 2;
                                 if(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] >= Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
                                    var10001 = var7[var18];
                                    var10000 = var18 + var7[var18];
                                    currentScriptPC = var18 + var10001;
                                    var18 = var10000;
                                 }
                              } else if(var31 == 33) {
                                 if(var2 == 954895284) {
                                    return;
                                 }

                                 Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = AbstractUserComparator.Interpreter_intLocals[var7[var18]];
                              } else if(var31 == 34) {
                                 AbstractUserComparator.Interpreter_intLocals[var7[var18]] = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                              } else if(var31 == 35) {
                                 Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = Interpreter.Interpreter_stringLocals[var7[var18]];
                              } else if(var31 == 36) {
                                 Interpreter.Interpreter_stringLocals[var7[var18]] = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                              } else if(var31 == 37) {
                                 if(var2 == 954895284) {
                                    return;
                                 }

                                 var12 = var7[var18];
                                 Interpreter.Interpreter_stringStackSize -= var12;
                                 String var13 = MusicPatchNode.method3922(Interpreter.Interpreter_stringStack, Interpreter.Interpreter_stringStackSize, var12);
                                 Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var13;
                              } else if(var31 == 38) {
                                 --Interpreter.Interpreter_intStackSize;
                              } else if(var31 == 39) {
                                 --Interpreter.Interpreter_stringStackSize;
                              } else {
                                 int var16;
                                 if(var31 == 40) {
                                    var12 = var7[var18];
                                    Script var32 = WorldMapSprite.method511(var12);
                                    int[] var14 = new int[var32.localIntCount];
                                    String[] var15 = new String[var32.localStringCount];

                                    for(var16 = 0; var16 < var32.intArgumentCount; ++var16) {
                                       var14[var16] = Interpreter.Interpreter_intStack[var16 + (Interpreter.Interpreter_intStackSize - var32.intArgumentCount)];
                                    }

                                    for(var16 = 0; var16 < var32.stringArgumentCount; ++var16) {
                                       var15[var16] = Interpreter.Interpreter_stringStack[var16 + (Interpreter.Interpreter_stringStackSize - var32.stringArgumentCount)];
                                    }

                                    Interpreter.Interpreter_intStackSize -= var32.intArgumentCount;
                                    Interpreter.Interpreter_stringStackSize -= var32.stringArgumentCount;
                                    ScriptFrame var20 = new ScriptFrame();
                                    var20.script = var4;
                                    var20.pc = var18;
                                    var20.intLocals = AbstractUserComparator.Interpreter_intLocals;
                                    var20.stringLocals = Interpreter.Interpreter_stringLocals;
                                    Interpreter.Interpreter_frames[++Interpreter.Interpreter_frameDepth - 1] = var20;
                                    currentScript = var32;
                                    var4 = var32;
                                    var6 = var32.opcodes;
                                    var7 = var32.intOperands;
                                    currentScriptPC = -1;
                                    var18 = -1;
                                    AbstractUserComparator.Interpreter_intLocals = var14;
                                    Interpreter.Interpreter_stringLocals = var15;
                                 } else if(var31 == 42) {
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = UserComparator4.varcs.method2254(var7[var18]);
                                 } else if(var31 == 43) {
                                    UserComparator4.varcs.method2253(var7[var18], Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
                                 } else if(var31 == 44) {
                                    var12 = var7[var18] >> 16;
                                    var21 = var7[var18] & '\uffff';
                                    int var22 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                                    if(var22 < 0 || var22 > 5000) {
                                       throw new RuntimeException();
                                    }

                                    Interpreter.Interpreter_arrayLengths[var12] = var22;
                                    byte var23 = -1;
                                    if(var21 == 105) {
                                       var23 = 0;
                                    }

                                    for(var16 = 0; var16 < var22; ++var16) {
                                       Interpreter.Interpreter_arrays[var12][var16] = var23;
                                    }
                                 } else if(var31 == 45) {
                                    var12 = var7[var18];
                                    var21 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                                    if(var21 < 0 || var21 >= Interpreter.Interpreter_arrayLengths[var12]) {
                                       throw new RuntimeException();
                                    }

                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Interpreter.Interpreter_arrays[var12][var21];
                                 } else if(var31 == 46) {
                                    var12 = var7[var18];
                                    Interpreter.Interpreter_intStackSize -= 2;
                                    var21 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                                    if(var21 < 0 || var21 >= Interpreter.Interpreter_arrayLengths[var12]) {
                                       throw new RuntimeException();
                                    }

                                    Interpreter.Interpreter_arrays[var12][var21] = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
                                 } else if(var31 == 47) {
                                    var19 = UserComparator4.varcs.method2258(var7[var18]);
                                    if(var19 == null) {
                                       var19 = "null";
                                    }

                                    Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var19;
                                 } else if(var31 == 48) {
                                    if(var2 == 954895284) {
                                       return;
                                    }

                                    UserComparator4.varcs.method2280(var7[var18], Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize]);
                                 } else if(var31 == 49) {
                                    var19 = UserComparator4.varcs.method2278(var7[var18]);
                                    Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var19;
                                 } else if(var31 == 50) {
                                    UserComparator4.varcs.method2286(var7[var18], Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize]);
                                 } else {
                                    if(var31 != 60) {
                                       throw new IllegalStateException();
                                    }

                                    IterableNodeHashTable var36 = var4.switches[var7[var18]];
                                    IntegerNode var33 = (IntegerNode)var36.method6003((long)Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
                                    if(var33 != null) {
                                       if(var2 == 954895284) {
                                          return;
                                       }

                                       var18 = currentScriptPC = var18 + var33.integer;
                                    }
                                 }
                              }
                           }
                        } else {
                           boolean var35;
                           if(var4.intOperands[var18] == 1) {
                              var35 = true;
                           } else {
                              var35 = false;
                           }

                           var21 = ModeWhere.method3761(var31, var4, var35);
                           switch(var21) {
                           case 0:
                              var28 = false;
                              break label854;
                           case 1:
                           default:
                              break;
                           case 2:
                              throw new IllegalStateException();
                           }
                        }
                     }
                  } catch (Exception var29) {
                     StringBuilder var25 = new StringBuilder(30);
                     var25.append("").append(var4.key).append(" ");

                     for(var11 = Interpreter.Interpreter_frameDepth - 1; var11 >= 0; --var11) {
                        if(var2 == 954895284) {
                           return;
                        }

                        var25.append("").append(Interpreter.Interpreter_frames[var11].script.key).append(" ");
                     }

                     var25.append("").append(var8);
                     WorldMapDecorationType.method4214(var25.toString(), var29);
                     var28 = false;
                     break label873;
                  }
               } finally {
                  if(var28) {
                     if(Interpreter.field1125) {
                        if(var2 == 954895284) {
                           return;
                        }

                        Interpreter.field1126 = true;
                        class227.method4185();
                        Interpreter.field1126 = false;
                        Interpreter.field1125 = false;
                     }

                  }
               }

               if(Interpreter.field1125) {
                  Interpreter.field1126 = true;
                  class227.method4185();
                  Interpreter.field1126 = false;
                  Interpreter.field1125 = false;
               }

               return;
            }

            if(Interpreter.field1125) {
               Interpreter.field1126 = true;
               class227.method4185();
               Interpreter.field1126 = false;
               Interpreter.field1125 = false;
            }

            return;
         }

         if(Interpreter.field1125) {
            Interpreter.field1126 = true;
            class227.method4185();
            Interpreter.field1126 = false;
            Interpreter.field1125 = false;
         }

      }
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1"
   )
   public static void canvasWidthChanged(int var0) {
      WorldMapSection1.client.getCallbacks().post(CanvasSizeChanged.class, CanvasSizeChanged.INSTANCE);
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1"
   )
   public static void gameStateChanged(int var0) {
      GameStateChanged var1 = new GameStateChanged();
      var1.setGameState(WorldMapSection1.client.getGameState());
      WorldMapSection1.client.getCallbacks().post(GameStateChanged.class, var1);
   }

   @ObfuscatedSignature(
      signature = "(Liy;III)Lla;"
   )
   public static Sprite copy$SpriteBuffer_getSprite(AbstractArchive var0, int var1, int var2, int var3) {
      return !UserComparator7.method3517(var0, var1, var2)?null:ArchiveDisk.method5933();
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1"
   )
   public static void canvasHeightChanged(int var0) {
      WorldMapSection1.client.getCallbacks().post(CanvasSizeChanged.class, CanvasSizeChanged.INSTANCE);
   }

   public static void copy$Rasterizer2D_fillRectangleGradientAlpha(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(var2 > 0 && var3 > 0) {
         int var8 = 0;
         int var9 = 65536 / var3;
         if(var0 < Rasterizer2D.Rasterizer2D_xClipStart) {
            var2 -= Rasterizer2D.Rasterizer2D_xClipStart - var0;
            var0 = Rasterizer2D.Rasterizer2D_xClipStart;
         }

         if(var1 < Rasterizer2D.Rasterizer2D_yClipStart) {
            var8 += (Rasterizer2D.Rasterizer2D_yClipStart - var1) * var9;
            var3 -= Rasterizer2D.Rasterizer2D_yClipStart - var1;
            var1 = Rasterizer2D.Rasterizer2D_yClipStart;
         }

         if(var0 + var2 > Rasterizer2D.Rasterizer2D_xClipEnd) {
            var2 = Rasterizer2D.Rasterizer2D_xClipEnd - var0;
         }

         if(var3 + var1 > Rasterizer2D.Rasterizer2D_yClipEnd) {
            var3 = Rasterizer2D.Rasterizer2D_yClipEnd - var1;
         }

         int var10 = Rasterizer2D.Rasterizer2D_width - var2;
         int var11 = Rasterizer2D.Rasterizer2D_width * var1 + var0;

         for(int var12 = -var3; var12 < 0; ++var12) {
            int var13 = 65536 - var8 >> 8;
            int var14 = var8 >> 8;
            int var15 = (var13 * var6 + var14 * var7 & '\uff00') >>> 8;
            if(var15 == 0) {
               var11 += Rasterizer2D.Rasterizer2D_width;
               var8 += var9;
            } else {
               int var16 = (var13 * (var4 & '\uff00') + var14 * (var5 & '\uff00') & 16711680) + (var13 * (var4 & 16711935) + var14 * (var5 & 16711935) & -16711936) >>> 8;
               int var17 = 255 - var15;
               int var18 = ((var16 & 16711935) * var15 >> 8 & 16711935) + (var15 * (var16 & '\uff00') >> 8 & '\uff00');

               for(int var19 = -var2; var19 < 0; ++var19) {
                  int var20 = Rasterizer2D.Rasterizer2D_pixels[var11];
                  if(var20 == 0) {
                     Rasterizer2D.Rasterizer2D_pixels[var11++] = var18 | -16777216;
                  } else {
                     var20 = ((var20 & 16711935) * var17 >> 8 & 16711935) + (var17 * (var20 & '\uff00') >> 8 & '\uff00');
                     Rasterizer2D.Rasterizer2D_pixels[var11++] = var18 + var20 | -16777216;
                  }
               }

               var11 += var10;
               var8 += var9;
            }
         }

      }
   }

   public static void onAddChatMessage(int var0, String var1, String var2, String var3) {
      Logger var4 = WorldMapSection1.client.getLogger();
      if(var4.isDebugEnabled()) {
         var4.debug("Chat message type {}: {}", ChatMessageType.of(var0), var2);
      }

      Map var5 = WorldMapSection1.client.getChatLineMap();
      RSChatChannel var6 = (RSChatChannel)var5.get(Integer.valueOf(var0));
      RSMessage var7 = var6.getLines()[0];
      ChatMessageType var8 = ChatMessageType.of(var0);
      ChatMessage var9 = new ChatMessage(var7, var8, var1, var2, var3, var7.getTimestamp());
      WorldMapSection1.client.getCallbacks().post(ChatMessage.class, var9);
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1"
   )
   public static void onMenuOptionsChanged(int var0) {
      int var1 = oldMenuEntryCount;
      int var2 = WorldMapSection1.client.getMenuOptionCount();
      oldMenuEntryCount = var2;
      String[] var3 = WorldMapSection1.client.getMenuOptions();
      String[] var4 = WorldMapSection1.client.getMenuTargets();
      int[] var5 = WorldMapSection1.client.getMenuIdentifiers();
      int[] var6 = WorldMapSection1.client.getMenuOpcodes();
      int[] var7 = WorldMapSection1.client.getMenuArguments1();
      int[] var8 = WorldMapSection1.client.getMenuArguments2();
      boolean[] var9 = WorldMapSection1.client.getMenuForceLeftClick();
      if(var2 == var1 + 1) {
         MenuEntryAdded var10 = new MenuEntryAdded(var3[var1], var4[var1], var5[var1], var6[var1], var7[var1], var8[var1], var9[var1]);
         WorldMapSection1.client.getCallbacks().post(MenuEntryAdded.class, var10);
         if(var10.isModified() && WorldMapSection1.client.getMenuOptionCount() == var2) {
            var3[var1] = var10.getOption();
            var4[var1] = var10.getTarget();
            var5[var1] = var10.getIdentifier();
            var6[var1] = var10.getOpcode();
            var7[var1] = var10.getParam0();
            var8[var1] = var10.getParam1();
            var9[var1] = var10.isForceLeftClick();
         }
      }

   }

   public static String getAllScriptIds() {
      ArrayList var0 = new ArrayList(scriptIds);
      StringBuilder var1 = new StringBuilder();
      boolean var2 = true;

      Object var4;
      for(Iterator var3 = var0.iterator(); var3.hasNext(); var1.append(var4)) {
         var4 = var3.next();
         if(var2) {
            var2 = false;
         } else {
            var1.append(", ");
         }
      }

      return var1.toString();
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1"
   )
   public static void onUsernameChanged(int var0) {
      WorldMapSection1.client.getCallbacks().post(UsernameChanged.class, UsernameChanged.INSTANCE);
   }

   public static void copy$Rasterizer2D_drawGradientPixels(int var0, int var1, int var2, int var3, int var4, int var5, byte[] var6, int var7, boolean var8) {
      if(var0 + var2 >= 0 && var3 + var1 >= 0) {
         if(var0 < Rasterizer2D.Rasterizer2D_width && var1 < Rasterizer2D.Rasterizer2D_height) {
            int var9 = 0;
            int var10 = 0;
            if(var0 < 0) {
               var9 -= var0;
               var2 += var0;
            }

            if(var1 < 0) {
               var10 -= var1;
               var3 += var1;
            }

            if(var0 + var2 > Rasterizer2D.Rasterizer2D_width) {
               var2 = Rasterizer2D.Rasterizer2D_width - var0;
            }

            if(var3 + var1 > Rasterizer2D.Rasterizer2D_height) {
               var3 = Rasterizer2D.Rasterizer2D_height - var1;
            }

            int var11 = var6.length / var7;
            int var12 = Rasterizer2D.Rasterizer2D_width - var2;
            int var13 = var4 >>> 24;
            int var14 = var5 >>> 24;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            if(var8 && (var13 != 255 || var14 != 255)) {
               var15 = var0 + var9 + (var10 + var1) * Rasterizer2D.Rasterizer2D_width;

               for(var16 = var10 + var1; var16 < var3 + var10 + var1; ++var16) {
                  for(var17 = var0 + var9; var17 < var0 + var9 + var2; ++var17) {
                     var18 = (var16 - var1) % var11;
                     var19 = (var17 - var0) % var7;
                     int var20 = var4;
                     if(var6[var19 + var18 * var7] != 0) {
                        var20 = var5;
                     }

                     int var21 = var20 >>> 24;
                     int var22 = 255 - var21;
                     int var23 = Rasterizer2D.Rasterizer2D_pixels[var15];
                     int var24 = (var21 * (var20 & '\uff00') + var22 * (var23 & '\uff00') & 16711680) + ((var20 & 16711935) * var21 + (var23 & 16711935) * var22 & -16711936) >> 8;
                     Rasterizer2D.Rasterizer2D_pixels[var15++] = var24 | -16777216;
                  }

                  var15 += var12;
               }
            } else {
               var15 = var0 + var9 + (var10 + var1) * Rasterizer2D.Rasterizer2D_width;

               for(var16 = var10 + var1; var16 < var3 + var10 + var1; ++var16) {
                  for(var17 = var0 + var9; var17 < var0 + var9 + var2; ++var17) {
                     var18 = (var16 - var1) % var11;
                     var19 = (var17 - var0) % var7;
                     if(var6[var19 + var18 * var7] != 0) {
                        Rasterizer2D.Rasterizer2D_pixels[var15++] = var5 | -16777216;
                     } else {
                        Rasterizer2D.Rasterizer2D_pixels[var15++] = var4 | -16777216;
                     }
                  }

                  var15 += var12;
               }
            }

         }
      }
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1"
   )
   public static void queuedSoundEffectCountChanged(int var0) {
      int var1 = WorldMapSection1.client.getQueuedSoundEffectCount();
      if(var1 == lastSoundEffectCount + 1) {
         int var2 = var1 - 1;
         int var3 = WorldMapSection1.client.getSoundLocations()[var2];
         boolean var4;
         if(var3 == 0) {
            SoundEffectPlayed var5 = new SoundEffectPlayed(lastSoundEffectSourceActor);
            var5.setNpcid(lastSoundEffectSourceNPCid);
            lastSoundEffectSourceNPCid = -1;
            var5.setSoundId(WorldMapSection1.client.getQueuedSoundEffectIDs()[var2]);
            var5.setDelay(WorldMapSection1.client.getQueuedSoundEffectDelays()[var2]);
            WorldMapSection1.client.getCallbacks().post(SoundEffectPlayed.class, var5);
            var4 = var5.isConsumed();
         } else {
            int var9 = var3 >> 16 & 255;
            int var6 = var3 >> 8 & 255;
            int var7 = var3 & 255;
            AreaSoundEffectPlayed var8 = new AreaSoundEffectPlayed(lastSoundEffectSourceActor);
            var8.setSoundId(WorldMapSection1.client.getQueuedSoundEffectIDs()[var2]);
            var8.setSceneX(var9);
            var8.setSceneY(var6);
            var8.setRange(var7);
            var8.setDelay(WorldMapSection1.client.getQueuedSoundEffectDelays()[var2]);
            WorldMapSection1.client.getCallbacks().post(AreaSoundEffectPlayed.class, var8);
            var4 = var8.isConsumed();
         }

         if(var4) {
            --var1;
            WorldMapSection1.client.setQueuedSoundEffectCount(var1);
         }
      }

      lastSoundEffectCount = var1;
   }

   public static int rl$rot1(int var0, int var1, int var2, int var3) {
      return var0 * var2 + var3 * var1 >> 16;
   }

   public static void drawAlpha(int[] var0, int var1, int var2, int var3) {
      if(WorldMapSection1.client.isGpu() && var0 == WorldMapSection1.client.getBufferProvider().getPixels()) {
         int var4 = var3 + ((var0[var1] >>> 24) * (255 - var3) * '\u8081' >>> 23);
         var0[var1] = var2 & 16777215 | var4 << 24;
      } else {
         var0[var1] = var2;
      }
   }

   public static int rl$rot2(int var0, int var1, int var2, int var3) {
      return var2 * var1 - var3 * var0 >> 16;
   }

   public static void renderWidgetLayer(net.runelite.api.widgets.Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Callbacks var9 = WorldMapSection1.client.getCallbacks();
      RSNodeHashTable var10 = WorldMapSection1.client.getComponentTable();
      net.runelite.api.widgets.Widget[] var11 = var0;
      int var12 = var0.length;

      for(int var13 = 0; var13 < var12; ++var13) {
         net.runelite.api.widgets.Widget var14 = var11[var13];
         RSWidget var15 = (RSWidget)var14;
         if(var15 != null && var15.getRSParentId() == var1 && !var15.isSelfHidden()) {
            if(var1 != -1) {
               var15.setRenderParentId(var1);
            }

            int var16 = var6 + var15.getRelativeX();
            int var17 = var7 + var15.getRelativeY();
            var15.setRenderX(var16);
            var15.setRenderY(var17);
            int var18 = var15.getType();
            if(var18 == 5 && var15.getItemId() != -1) {
               if(var16 >= var2 && var16 <= var4 && var17 >= var3 && var17 <= var5) {
                  WidgetItem var29 = new WidgetItem(var15.getItemId(), var15.getItemQuantity(), -1, var15.getBounds(), var15, (Rectangle)null);
                  var9.drawItem(var15.getItemId(), var29);
               }
            } else if(var18 == 2) {
               Collection var19 = var15.getWidgetItems();
               Iterator var27 = var19.iterator();

               while(var27.hasNext()) {
                  WidgetItem var28 = (WidgetItem)var27.next();
                  var9.drawItem(var28.getId(), var28);
               }
            }

            WidgetNode var30 = (WidgetNode)var10.get((long)var15.getId());
            if(var30 != null) {
               int var20 = var15.getId();
               int var21 = var30.getId();
               RSWidget[] var22 = WorldMapSection1.client.getWidgets()[var21];
               RSWidget[] var23 = var22;
               int var24 = var22.length;

               for(int var25 = 0; var25 < var24; ++var25) {
                  RSWidget var26 = var23[var25];
                  if(var26.getRSParentId() == -1) {
                     var26.setRenderParentId(var20);
                  }
               }
            }
         }
      }

   }

   public static int rl$rot3(int var0, int var1, int var2, int var3) {
      return var0 * var2 - var3 * var1 >> 16;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1"
   )
   public static void itemPressedDurationChanged(int var0) {
      if(WorldMapSection1.client.getItemPressedDuration() > 0) {
         ++itemPressedDurationBuffer;
         if(itemPressedDurationBuffer >= inventoryDragDelay) {
            WorldMapSection1.client.setItemPressedDuration(itemPressedDurationBuffer);
         } else {
            WorldMapSection1.client.setItemPressedDuration(0);
         }
      } else {
         itemPressedDurationBuffer = 0;
      }

   }

   public static int rl$rot4(int var0, int var1, int var2, int var3) {
      return var2 * var1 + var3 * var0 >> 16;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1"
   )
   public static void resizeChanged(int var0) {
      boolean var1 = WorldMapSection1.client.isResized();
      if(var1 != oldIsResized) {
         ResizeableChanged var2 = new ResizeableChanged();
         var2.setResized(var1);
         WorldMapSection1.client.getCallbacks().post(ResizeableChanged.class, var2);
         oldIsResized = var1;
      }

   }

   public static final void copy$menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7, int var8) {
      if(var2 >= 2000) {
         if(var8 <= 1385798528) {
            return;
         }

         var2 -= 2000;
      }

      label824: {
         PacketBufferNode var9;
         if(var2 == 1) {
            if(var8 <= 1385798528) {
               return;
            }

            mouseCrossX = var6;
            mouseCrossY = var7;
            mouseCrossColor = 2;
            mouseCrossState = 0;
            destinationX = var0;
            destinationY = var1;
            var9 = FaceNormal.method3377(ClientPacket.field2240, packetWriter.isaacCipher);
            var9.packetBuffer.method5611(selectedItemSlot);
            var9.packetBuffer.method5619(WorldMapSection2.selectedItemWidget);
            var9.packetBuffer.method5610(class89.baseY * 64 + var1);
            var9.packetBuffer.method5610(class69.baseX * 64 + var0);
            var9.packetBuffer.method5610(var3);
            var9.packetBuffer.method5610(FaceNormal.selectedItemId);
            var9.packetBuffer.method5728(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
            packetWriter.method2375(var9);
         } else {
            label822: {
               if(var2 == 2) {
                  mouseCrossX = var6;
                  mouseCrossY = var7;
                  mouseCrossColor = 2;
                  mouseCrossState = 0;
                  destinationX = var0;
                  destinationY = var1;
                  var9 = FaceNormal.method3377(ClientPacket.field2252, packetWriter.isaacCipher);
                  var9.packetBuffer.method5560(selectedSpellChildIndex);
                  var9.packetBuffer.method5717(class7.selectedSpellWidget);
                  var9.packetBuffer.method5611(var3);
                  var9.packetBuffer.method5610(class89.baseY * 64 + var1);
                  var9.packetBuffer.method5603(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                  var9.packetBuffer.method5610(class69.baseX * 64 + var0);
                  packetWriter.method2375(var9);
               } else if(var2 == 3) {
                  mouseCrossX = var6;
                  mouseCrossY = var7;
                  mouseCrossColor = 2;
                  mouseCrossState = 0;
                  destinationX = var0;
                  destinationY = var1;
                  var9 = FaceNormal.method3377(ClientPacket.field2221, packetWriter.isaacCipher);
                  var9.packetBuffer.method5603(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                  var9.packetBuffer.method5612(class69.baseX * 64 + var0);
                  var9.packetBuffer.method5610(var3);
                  var9.packetBuffer.method5610(class89.baseY * 64 + var1);
                  packetWriter.method2375(var9);
               } else if(var2 == 4) {
                  mouseCrossX = var6;
                  mouseCrossY = var7;
                  mouseCrossColor = 2;
                  mouseCrossState = 0;
                  destinationX = var0;
                  destinationY = var1;
                  var9 = FaceNormal.method3377(ClientPacket.field2243, packetWriter.isaacCipher);
                  var9.packetBuffer.method5560(var3);
                  var9.packetBuffer.method5612(class69.baseX * 64 + var0);
                  var9.packetBuffer.method5612(class89.baseY * 64 + var1);
                  var9.packetBuffer.method5725(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                  packetWriter.method2375(var9);
               } else if(var2 == 5) {
                  mouseCrossX = var6;
                  mouseCrossY = var7;
                  mouseCrossColor = 2;
                  mouseCrossState = 0;
                  destinationX = var0;
                  destinationY = var1;
                  var9 = FaceNormal.method3377(ClientPacket.field2296, packetWriter.isaacCipher);
                  var9.packetBuffer.method5611(class69.baseX * 64 + var0);
                  var9.packetBuffer.method5612(class89.baseY * 64 + var1);
                  var9.packetBuffer.method5728(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                  var9.packetBuffer.method5611(var3);
                  packetWriter.method2375(var9);
               } else {
                  byte var10001;
                  if(var2 == 6) {
                     mouseCrossX = var6;
                     mouseCrossY = var7;
                     mouseCrossColor = 2;
                     mouseCrossState = 0;
                     destinationX = var0;
                     destinationY = var1;
                     var9 = FaceNormal.method3377(ClientPacket.field2288, packetWriter.isaacCipher);
                     var9.packetBuffer.method5611(var3);
                     if(KeyHandler.KeyHandler_pressedKeys[82]) {
                        if(var8 <= 1385798528) {
                           return;
                        }

                        var10001 = 1;
                     } else {
                        var10001 = 0;
                     }

                     var9.packetBuffer.method5559(var10001);
                     var9.packetBuffer.method5560(class69.baseX * 64 + var0);
                     var9.packetBuffer.method5610(class89.baseY * 64 + var1);
                     packetWriter.method2375(var9);
                     break label824;
                  }

                  PacketBufferNode var10;
                  NPC var14;
                  if(var2 == 7) {
                     var14 = npcs[var3];
                     if(var14 != null) {
                        mouseCrossX = var6;
                        mouseCrossY = var7;
                        mouseCrossColor = 2;
                        mouseCrossState = 0;
                        destinationX = var0;
                        destinationY = var1;
                        var10 = FaceNormal.method3377(ClientPacket.field2237, packetWriter.isaacCipher);
                        var10.packetBuffer.method5560(selectedItemSlot);
                        var10.packetBuffer.method5560(FaceNormal.selectedItemId);
                        var10.packetBuffer.method5717(WorldMapSection2.selectedItemWidget);
                        var10.packetBuffer.method5728(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                        var10.packetBuffer.method5610(var3);
                        packetWriter.method2375(var10);
                     }
                  } else if(var2 == 8) {
                     var14 = npcs[var3];
                     if(var14 != null) {
                        mouseCrossX = var6;
                        mouseCrossY = var7;
                        mouseCrossColor = 2;
                        mouseCrossState = 0;
                        destinationX = var0;
                        destinationY = var1;
                        var10 = FaceNormal.method3377(ClientPacket.field2271, packetWriter.isaacCipher);
                        var10.packetBuffer.method5603(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                        var10.packetBuffer.method5717(class7.selectedSpellWidget);
                        var10.packetBuffer.method5560(selectedSpellChildIndex);
                        var10.packetBuffer.method5560(var3);
                        packetWriter.method2375(var10);
                     }
                  } else if(var2 == 9) {
                     var14 = npcs[var3];
                     if(var14 != null) {
                        mouseCrossX = var6;
                        mouseCrossY = var7;
                        mouseCrossColor = 2;
                        mouseCrossState = 0;
                        destinationX = var0;
                        destinationY = var1;
                        var10 = FaceNormal.method3377(ClientPacket.field2263, packetWriter.isaacCipher);
                        var10.packetBuffer.method5610(var3);
                        var10.packetBuffer.method5725(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                        packetWriter.method2375(var10);
                     }
                  } else if(var2 == 10) {
                     var14 = npcs[var3];
                     if(var14 != null) {
                        mouseCrossX = var6;
                        mouseCrossY = var7;
                        mouseCrossColor = 2;
                        mouseCrossState = 0;
                        destinationX = var0;
                        destinationY = var1;
                        var10 = FaceNormal.method3377(ClientPacket.field2211, packetWriter.isaacCipher);
                        var10.packetBuffer.method5560(var3);
                        var10.packetBuffer.method5725(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                        packetWriter.method2375(var10);
                     }
                  } else {
                     if(var2 == 11) {
                        var14 = npcs[var3];
                        if(var14 != null) {
                           mouseCrossX = var6;
                           mouseCrossY = var7;
                           mouseCrossColor = 2;
                           mouseCrossState = 0;
                           destinationX = var0;
                           destinationY = var1;
                           var10 = FaceNormal.method3377(ClientPacket.field2277, packetWriter.isaacCipher);
                           var10.packetBuffer.method5611(var3);
                           var10.packetBuffer.method5725(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                           packetWriter.method2375(var10);
                        }
                        break label822;
                     }

                     if(var2 == 12) {
                        var14 = npcs[var3];
                        if(var14 != null) {
                           mouseCrossX = var6;
                           mouseCrossY = var7;
                           mouseCrossColor = 2;
                           mouseCrossState = 0;
                           destinationX = var0;
                           destinationY = var1;
                           var10 = FaceNormal.method3377(ClientPacket.field2219, packetWriter.isaacCipher);
                           var10.packetBuffer.method5603(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                           var10.packetBuffer.method5610(var3);
                           packetWriter.method2375(var10);
                        }
                        break label824;
                     }

                     if(var2 == 13) {
                        if(var8 <= 1385798528) {
                           return;
                        }

                        var14 = npcs[var3];
                        if(var14 != null) {
                           mouseCrossX = var6;
                           mouseCrossY = var7;
                           mouseCrossColor = 2;
                           mouseCrossState = 0;
                           destinationX = var0;
                           destinationY = var1;
                           var10 = FaceNormal.method3377(ClientPacket.field2303, packetWriter.isaacCipher);
                           var10.packetBuffer.method5559(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                           var10.packetBuffer.method5560(var3);
                           packetWriter.method2375(var10);
                        }
                     } else {
                        Player var18;
                        if(var2 == 14) {
                           if(var8 <= 1385798528) {
                              return;
                           }

                           var18 = players[var3];
                           if(var18 != null) {
                              mouseCrossX = var6;
                              mouseCrossY = var7;
                              mouseCrossColor = 2;
                              mouseCrossState = 0;
                              destinationX = var0;
                              destinationY = var1;
                              var10 = FaceNormal.method3377(ClientPacket.field2225, packetWriter.isaacCipher);
                              var10.packetBuffer.method5611(FaceNormal.selectedItemId);
                              var10.packetBuffer.method5611(var3);
                              var10.packetBuffer.method5728(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                              var10.packetBuffer.method5612(selectedItemSlot);
                              var10.packetBuffer.method5717(WorldMapSection2.selectedItemWidget);
                              packetWriter.method2375(var10);
                           }
                           break label822;
                        }

                        if(var2 == 15) {
                           var18 = players[var3];
                           if(var18 != null) {
                              mouseCrossX = var6;
                              mouseCrossY = var7;
                              mouseCrossColor = 2;
                              mouseCrossState = 0;
                              destinationX = var0;
                              destinationY = var1;
                              var10 = FaceNormal.method3377(ClientPacket.field2300, packetWriter.isaacCipher);
                              var10.packetBuffer.method5560(var3);
                              var10.packetBuffer.method5618(class7.selectedSpellWidget);
                              var10.packetBuffer.method5559(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                              var10.packetBuffer.method5611(selectedSpellChildIndex);
                              packetWriter.method2375(var10);
                           }
                           break label822;
                        }

                        if(var2 == 16) {
                           if(var8 <= 1385798528) {
                              return;
                           }

                           mouseCrossX = var6;
                           mouseCrossY = var7;
                           mouseCrossColor = 2;
                           mouseCrossState = 0;
                           destinationX = var0;
                           destinationY = var1;
                           var9 = FaceNormal.method3377(ClientPacket.field2302, packetWriter.isaacCipher);
                           var9.packetBuffer.method5611(FaceNormal.selectedItemId);
                           var9.packetBuffer.method5612(var3);
                           var9.packetBuffer.method5725(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                           var9.packetBuffer.method5619(WorldMapSection2.selectedItemWidget);
                           var9.packetBuffer.method5612(class69.baseX * 64 + var0);
                           var9.packetBuffer.method5612(selectedItemSlot);
                           var9.packetBuffer.method5610(class89.baseY * 64 + var1);
                           packetWriter.method2375(var9);
                        } else if(var2 == 17) {
                           if(var8 <= 1385798528) {
                              return;
                           }

                           mouseCrossX = var6;
                           mouseCrossY = var7;
                           mouseCrossColor = 2;
                           mouseCrossState = 0;
                           destinationX = var0;
                           destinationY = var1;
                           var9 = FaceNormal.method3377(ClientPacket.field2233, packetWriter.isaacCipher);
                           if(KeyHandler.KeyHandler_pressedKeys[82]) {
                              if(var8 <= 1385798528) {
                                 return;
                              }

                              var10001 = 1;
                           } else {
                              var10001 = 0;
                           }

                           var9.packetBuffer.method5725(var10001);
                           var9.packetBuffer.method5610(var3);
                           var9.packetBuffer.method5612(selectedSpellChildIndex);
                           var9.packetBuffer.method5560(class89.baseY * 64 + var1);
                           var9.packetBuffer.method5618(class7.selectedSpellWidget);
                           var9.packetBuffer.method5612(class69.baseX * 64 + var0);
                           packetWriter.method2375(var9);
                        } else if(var2 == 18) {
                           mouseCrossX = var6;
                           mouseCrossY = var7;
                           mouseCrossColor = 2;
                           mouseCrossState = 0;
                           destinationX = var0;
                           destinationY = var1;
                           var9 = FaceNormal.method3377(ClientPacket.field2287, packetWriter.isaacCipher);
                           var9.packetBuffer.method5612(var3);
                           var9.packetBuffer.method5612(class69.baseX * 64 + var0);
                           var9.packetBuffer.method5610(class89.baseY * 64 + var1);
                           var9.packetBuffer.method5725(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                           packetWriter.method2375(var9);
                        } else if(var2 == 19) {
                           mouseCrossX = var6;
                           mouseCrossY = var7;
                           mouseCrossColor = 2;
                           mouseCrossState = 0;
                           destinationX = var0;
                           destinationY = var1;
                           var9 = FaceNormal.method3377(ClientPacket.field2286, packetWriter.isaacCipher);
                           var9.packetBuffer.method5560(class89.baseY * 64 + var1);
                           var9.packetBuffer.method5611(class69.baseX * 64 + var0);
                           var9.packetBuffer.method5728(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                           var9.packetBuffer.method5560(var3);
                           packetWriter.method2375(var9);
                        } else if(var2 == 20) {
                           mouseCrossX = var6;
                           mouseCrossY = var7;
                           mouseCrossColor = 2;
                           mouseCrossState = 0;
                           destinationX = var0;
                           destinationY = var1;
                           var9 = FaceNormal.method3377(ClientPacket.field2275, packetWriter.isaacCipher);
                           var9.packetBuffer.method5559(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                           var9.packetBuffer.method5610(class69.baseX * 64 + var0);
                           var9.packetBuffer.method5611(class89.baseY * 64 + var1);
                           var9.packetBuffer.method5612(var3);
                           packetWriter.method2375(var9);
                        } else {
                           if(var2 == 21) {
                              if(var8 <= 1385798528) {
                                 return;
                              }

                              mouseCrossX = var6;
                              mouseCrossY = var7;
                              mouseCrossColor = 2;
                              mouseCrossState = 0;
                              destinationX = var0;
                              destinationY = var1;
                              var9 = FaceNormal.method3377(ClientPacket.field2227, packetWriter.isaacCipher);
                              if(KeyHandler.KeyHandler_pressedKeys[82]) {
                                 if(var8 <= 1385798528) {
                                    return;
                                 }

                                 var10001 = 1;
                              } else {
                                 var10001 = 0;
                              }

                              var9.packetBuffer.method5559(var10001);
                              var9.packetBuffer.method5610(var3);
                              var9.packetBuffer.method5610(class69.baseX * 64 + var0);
                              var9.packetBuffer.method5611(class89.baseY * 64 + var1);
                              packetWriter.method2375(var9);
                              break label822;
                           }

                           if(var2 == 22) {
                              mouseCrossX = var6;
                              mouseCrossY = var7;
                              mouseCrossColor = 2;
                              mouseCrossState = 0;
                              destinationX = var0;
                              destinationY = var1;
                              var9 = FaceNormal.method3377(ClientPacket.field2235, packetWriter.isaacCipher);
                              var9.packetBuffer.method5560(var3);
                              var9.packetBuffer.method5611(class89.baseY * 64 + var1);
                              var9.packetBuffer.method5728(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                              var9.packetBuffer.method5611(class69.baseX * 64 + var0);
                              packetWriter.method2375(var9);
                           } else if(var2 == 23) {
                              if(var8 <= 1385798528) {
                                 return;
                              }

                              if(isMenuOpen) {
                                 GrandExchangeOfferWorldComparator.scene.method3339();
                              } else {
                                 GrandExchangeOfferWorldComparator.scene.method3213(ScriptEvent.Client_plane, var0, var1, true);
                              }
                           } else {
                              PacketBufferNode var11;
                              Widget var16;
                              if(var2 == 24) {
                                 if(var8 <= 1385798528) {
                                    return;
                                 }

                                 var16 = MusicPatchNode.method3920(var1);
                                 boolean var12 = true;
                                 if(var16.contentType > 0) {
                                    var12 = WorldMapSectionType.method344(var16);
                                 }

                                 if(var12) {
                                    if(var8 <= 1385798528) {
                                       return;
                                    }

                                    var11 = FaceNormal.method3377(ClientPacket.field2231, packetWriter.isaacCipher);
                                    var11.packetBuffer.method5717(var1);
                                    packetWriter.method2375(var11);
                                 }
                              } else {
                                 if(var2 == 25) {
                                    var16 = GrandExchangeOfferUnitPriceComparator.method224(var1, var0);
                                    if(var16 != null) {
                                       if(var8 <= 1385798528) {
                                          return;
                                       }

                                       GrandExchangeOffer.method210();
                                       WorldMapData_1.method815(var1, var0, WorldMapRectangle.method388(ScriptEvent.method1283(var16)), var16.itemId);
                                       isItemSelected = 0;
                                       selectedSpellActionName = PrivateChatMode.method5966(var16);
                                       if(selectedSpellActionName == null) {
                                          selectedSpellActionName = "null";
                                       }

                                       if(var16.isIf3) {
                                          selectedSpellName = var16.dataText + class297.method5342(16777215);
                                       } else {
                                          selectedSpellName = class297.method5342('\uff00') + var16.spellName + class297.method5342(16777215);
                                       }
                                    }

                                    return;
                                 }

                                 if(var2 == 26) {
                                    class227.method4185();
                                 } else {
                                    int var13;
                                    Widget var15;
                                    if(var2 == 28) {
                                       var9 = FaceNormal.method3377(ClientPacket.field2231, packetWriter.isaacCipher);
                                       var9.packetBuffer.method5717(var1);
                                       packetWriter.method2375(var9);
                                       var15 = MusicPatchNode.method3920(var1);
                                       if(var15.cs1Instructions != null) {
                                          if(var8 <= 1385798528) {
                                             return;
                                          }

                                          if(var15.cs1Instructions[0][0] == 5) {
                                             var13 = var15.cs1Instructions[0][1];
                                             Varps.Varps_main[var13] = 1 - Varps.Varps_main[var13];
                                             settingsChanged(var13);
                                             class22.method253(var13, (byte)-121);
                                          }
                                       }
                                    } else if(var2 == 29) {
                                       var9 = FaceNormal.method3377(ClientPacket.field2231, packetWriter.isaacCipher);
                                       var9.packetBuffer.method5717(var1);
                                       packetWriter.method2375(var9);
                                       var15 = MusicPatchNode.method3920(var1);
                                       if(var15.cs1Instructions != null && var15.cs1Instructions[0][0] == 5) {
                                          if(var8 <= 1385798528) {
                                             return;
                                          }

                                          var13 = var15.cs1Instructions[0][1];
                                          if(Varps.Varps_main[var13] != var15.cs1ComparisonValues[0]) {
                                             Varps.Varps_main[var13] = var15.cs1ComparisonValues[0];
                                             settingsChanged(var13);
                                             class22.method253(var13, (byte)-109);
                                          }
                                       }
                                    } else if(var2 == 30) {
                                       if(meslayerContinueWidget == null) {
                                          if(var8 <= 1385798528) {
                                             return;
                                          }

                                          class58.method968(var1, var0);
                                          meslayerContinueWidget = GrandExchangeOfferUnitPriceComparator.method224(var1, var0);
                                          ItemContainer.method1273(meslayerContinueWidget);
                                       }
                                    } else if(var2 == 31) {
                                       var9 = FaceNormal.method3377(ClientPacket.field2305, packetWriter.isaacCipher);
                                       var9.packetBuffer.method5619(var1);
                                       var9.packetBuffer.method5612(selectedItemSlot);
                                       var9.packetBuffer.method5645(WorldMapSection2.selectedItemWidget);
                                       var9.packetBuffer.method5611(var0);
                                       var9.packetBuffer.method5560(var3);
                                       var9.packetBuffer.method5611(FaceNormal.selectedItemId);
                                       packetWriter.method2375(var9);
                                       field786 = 0;
                                       WorldMapID.field307 = MusicPatchNode.method3920(var1);
                                       field880 = var0;
                                    } else {
                                       if(var2 == 32) {
                                          var9 = FaceNormal.method3377(ClientPacket.field2228, packetWriter.isaacCipher);
                                          var9.packetBuffer.method5610(selectedSpellChildIndex);
                                          var9.packetBuffer.method5645(class7.selectedSpellWidget);
                                          var9.packetBuffer.method5611(var3);
                                          var9.packetBuffer.method5611(var0);
                                          var9.packetBuffer.method5645(var1);
                                          packetWriter.method2375(var9);
                                          field786 = 0;
                                          WorldMapID.field307 = MusicPatchNode.method3920(var1);
                                          field880 = var0;
                                          break label824;
                                       }

                                       if(var2 == 33) {
                                          var9 = FaceNormal.method3377(ClientPacket.field2292, packetWriter.isaacCipher);
                                          var9.packetBuffer.method5610(var3);
                                          var9.packetBuffer.method5618(var1);
                                          var9.packetBuffer.method5560(var0);
                                          packetWriter.method2375(var9);
                                          field786 = 0;
                                          WorldMapID.field307 = MusicPatchNode.method3920(var1);
                                          field880 = var0;
                                          break label824;
                                       }

                                       if(var2 == 34) {
                                          var9 = FaceNormal.method3377(ClientPacket.field2265, packetWriter.isaacCipher);
                                          var9.packetBuffer.method5717(var1);
                                          var9.packetBuffer.method5611(var3);
                                          var9.packetBuffer.method5612(var0);
                                          packetWriter.method2375(var9);
                                          field786 = 0;
                                          WorldMapID.field307 = MusicPatchNode.method3920(var1);
                                          field880 = var0;
                                       } else if(var2 == 35) {
                                          if(var8 <= 1385798528) {
                                             return;
                                          }

                                          var9 = FaceNormal.method3377(ClientPacket.field2268, packetWriter.isaacCipher);
                                          var9.packetBuffer.method5717(var1);
                                          var9.packetBuffer.method5610(var3);
                                          var9.packetBuffer.method5560(var0);
                                          packetWriter.method2375(var9);
                                          field786 = 0;
                                          WorldMapID.field307 = MusicPatchNode.method3920(var1);
                                          field880 = var0;
                                       } else {
                                          if(var2 == 36) {
                                             var9 = FaceNormal.method3377(ClientPacket.field2208, packetWriter.isaacCipher);
                                             var9.packetBuffer.method5610(var0);
                                             var9.packetBuffer.method5618(var1);
                                             var9.packetBuffer.method5610(var3);
                                             packetWriter.method2375(var9);
                                             field786 = 0;
                                             WorldMapID.field307 = MusicPatchNode.method3920(var1);
                                             field880 = var0;
                                             break label822;
                                          }

                                          if(var2 == 37) {
                                             var9 = FaceNormal.method3377(ClientPacket.field2244, packetWriter.isaacCipher);
                                             var9.packetBuffer.method5612(var0);
                                             var9.packetBuffer.method5645(var1);
                                             var9.packetBuffer.method5611(var3);
                                             packetWriter.method2375(var9);
                                             field786 = 0;
                                             WorldMapID.field307 = MusicPatchNode.method3920(var1);
                                             field880 = var0;
                                          } else {
                                             if(var2 == 38) {
                                                GrandExchangeOffer.method210();
                                                var16 = MusicPatchNode.method3920(var1);
                                                isItemSelected = 1;
                                                selectedItemSlot = var0;
                                                WorldMapSection2.selectedItemWidget = var1;
                                                FaceNormal.selectedItemId = var3;
                                                ItemContainer.method1273(var16);
                                                selectedItemName = class297.method5342(16748608) + AbstractWorldMapData.method373(var3).name + class297.method5342(16777215);
                                                if(selectedItemName == null) {
                                                   if(var8 <= 1385798528) {
                                                      return;
                                                   }

                                                   selectedItemName = "null";
                                                }

                                                return;
                                             }

                                             if(var2 == 39) {
                                                if(var8 <= 1385798528) {
                                                   return;
                                                }

                                                var9 = FaceNormal.method3377(ClientPacket.field2258, packetWriter.isaacCipher);
                                                var9.packetBuffer.method5560(var3);
                                                var9.packetBuffer.method5610(var0);
                                                var9.packetBuffer.method5618(var1);
                                                packetWriter.method2375(var9);
                                                field786 = 0;
                                                WorldMapID.field307 = MusicPatchNode.method3920(var1);
                                                field880 = var0;
                                             } else {
                                                if(var2 == 40) {
                                                   var9 = FaceNormal.method3377(ClientPacket.field2276, packetWriter.isaacCipher);
                                                   var9.packetBuffer.method5619(var1);
                                                   var9.packetBuffer.method5612(var3);
                                                   var9.packetBuffer.method5560(var0);
                                                   packetWriter.method2375(var9);
                                                   field786 = 0;
                                                   WorldMapID.field307 = MusicPatchNode.method3920(var1);
                                                   field880 = var0;
                                                   break label824;
                                                }

                                                if(var2 == 41) {
                                                   var9 = FaceNormal.method3377(ClientPacket.field2285, packetWriter.isaacCipher);
                                                   var9.packetBuffer.method5610(var0);
                                                   var9.packetBuffer.method5645(var1);
                                                   var9.packetBuffer.method5560(var3);
                                                   packetWriter.method2375(var9);
                                                   field786 = 0;
                                                   WorldMapID.field307 = MusicPatchNode.method3920(var1);
                                                   field880 = var0;
                                                } else if(var2 == 42) {
                                                   var9 = FaceNormal.method3377(ClientPacket.field2299, packetWriter.isaacCipher);
                                                   var9.packetBuffer.method5717(var1);
                                                   var9.packetBuffer.method5611(var0);
                                                   var9.packetBuffer.method5611(var3);
                                                   packetWriter.method2375(var9);
                                                   field786 = 0;
                                                   WorldMapID.field307 = MusicPatchNode.method3920(var1);
                                                   field880 = var0;
                                                } else if(var2 == 43) {
                                                   if(var8 <= 1385798528) {
                                                      return;
                                                   }

                                                   var9 = FaceNormal.method3377(ClientPacket.field2238, packetWriter.isaacCipher);
                                                   var9.packetBuffer.method5612(var0);
                                                   var9.packetBuffer.method5618(var1);
                                                   var9.packetBuffer.method5612(var3);
                                                   packetWriter.method2375(var9);
                                                   field786 = 0;
                                                   WorldMapID.field307 = MusicPatchNode.method3920(var1);
                                                   field880 = var0;
                                                } else if(var2 == 44) {
                                                   var18 = players[var3];
                                                   if(var18 != null) {
                                                      mouseCrossX = var6;
                                                      mouseCrossY = var7;
                                                      mouseCrossColor = 2;
                                                      mouseCrossState = 0;
                                                      destinationX = var0;
                                                      destinationY = var1;
                                                      var10 = FaceNormal.method3377(ClientPacket.field2267, packetWriter.isaacCipher);
                                                      var10.packetBuffer.method5559(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                                                      var10.packetBuffer.method5612(var3);
                                                      packetWriter.method2375(var10);
                                                   }
                                                } else if(var2 == 45) {
                                                   var18 = players[var3];
                                                   if(var18 != null) {
                                                      if(var8 <= 1385798528) {
                                                         return;
                                                      }

                                                      mouseCrossX = var6;
                                                      mouseCrossY = var7;
                                                      mouseCrossColor = 2;
                                                      mouseCrossState = 0;
                                                      destinationX = var0;
                                                      destinationY = var1;
                                                      var10 = FaceNormal.method3377(ClientPacket.field2232, packetWriter.isaacCipher);
                                                      var10.packetBuffer.method5611(var3);
                                                      var10.packetBuffer.method5728(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                                                      packetWriter.method2375(var10);
                                                   }
                                                } else {
                                                   if(var2 == 46) {
                                                      var18 = players[var3];
                                                      if(var18 != null) {
                                                         mouseCrossX = var6;
                                                         mouseCrossY = var7;
                                                         mouseCrossColor = 2;
                                                         mouseCrossState = 0;
                                                         destinationX = var0;
                                                         destinationY = var1;
                                                         var10 = FaceNormal.method3377(ClientPacket.field2266, packetWriter.isaacCipher);
                                                         var10.packetBuffer.method5728(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                                                         var10.packetBuffer.method5560(var3);
                                                         packetWriter.method2375(var10);
                                                      }
                                                      break label822;
                                                   }

                                                   if(var2 == 47) {
                                                      if(var8 <= 1385798528) {
                                                         return;
                                                      }

                                                      var18 = players[var3];
                                                      if(var18 != null) {
                                                         mouseCrossX = var6;
                                                         mouseCrossY = var7;
                                                         mouseCrossColor = 2;
                                                         mouseCrossState = 0;
                                                         destinationX = var0;
                                                         destinationY = var1;
                                                         var10 = FaceNormal.method3377(ClientPacket.field2282, packetWriter.isaacCipher);
                                                         var10.packetBuffer.method5560(var3);
                                                         var10.packetBuffer.method5603(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                                                         packetWriter.method2375(var10);
                                                      }
                                                   } else if(var2 == 48) {
                                                      var18 = players[var3];
                                                      if(var18 != null) {
                                                         mouseCrossX = var6;
                                                         mouseCrossY = var7;
                                                         mouseCrossColor = 2;
                                                         mouseCrossState = 0;
                                                         destinationX = var0;
                                                         destinationY = var1;
                                                         var10 = FaceNormal.method3377(ClientPacket.field2254, packetWriter.isaacCipher);
                                                         var10.packetBuffer.method5728(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                                                         var10.packetBuffer.method5560(var3);
                                                         packetWriter.method2375(var10);
                                                      }
                                                   } else if(var2 == 49) {
                                                      var18 = players[var3];
                                                      if(var18 != null) {
                                                         mouseCrossX = var6;
                                                         mouseCrossY = var7;
                                                         mouseCrossColor = 2;
                                                         mouseCrossState = 0;
                                                         destinationX = var0;
                                                         destinationY = var1;
                                                         var10 = FaceNormal.method3377(ClientPacket.field2250, packetWriter.isaacCipher);
                                                         if(KeyHandler.KeyHandler_pressedKeys[82]) {
                                                            if(var8 <= 1385798528) {
                                                               return;
                                                            }

                                                            var10001 = 1;
                                                         } else {
                                                            var10001 = 0;
                                                         }

                                                         var10.packetBuffer.method5725(var10001);
                                                         var10.packetBuffer.method5612(var3);
                                                         packetWriter.method2375(var10);
                                                      }
                                                   } else if(var2 == 50) {
                                                      var18 = players[var3];
                                                      if(var18 != null) {
                                                         mouseCrossX = var6;
                                                         mouseCrossY = var7;
                                                         mouseCrossColor = 2;
                                                         mouseCrossState = 0;
                                                         destinationX = var0;
                                                         destinationY = var1;
                                                         var10 = FaceNormal.method3377(ClientPacket.field2301, packetWriter.isaacCipher);
                                                         if(KeyHandler.KeyHandler_pressedKeys[82]) {
                                                            if(var8 <= 1385798528) {
                                                               return;
                                                            }

                                                            var10001 = 1;
                                                         } else {
                                                            var10001 = 0;
                                                         }

                                                         var10.packetBuffer.method5559(var10001);
                                                         var10.packetBuffer.method5560(var3);
                                                         packetWriter.method2375(var10);
                                                      }
                                                   } else if(var2 == 51) {
                                                      var18 = players[var3];
                                                      if(var18 != null) {
                                                         mouseCrossX = var6;
                                                         mouseCrossY = var7;
                                                         mouseCrossColor = 2;
                                                         mouseCrossState = 0;
                                                         destinationX = var0;
                                                         destinationY = var1;
                                                         var10 = FaceNormal.method3377(ClientPacket.field2247, packetWriter.isaacCipher);
                                                         var10.packetBuffer.method5559(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                                                         var10.packetBuffer.method5560(var3);
                                                         packetWriter.method2375(var10);
                                                      }
                                                   } else {
                                                      label771: {
                                                         if(var2 != 57) {
                                                            if(var2 == 58) {
                                                               var16 = GrandExchangeOfferUnitPriceComparator.method224(var1, var0);
                                                               if(var16 != null) {
                                                                  var10 = FaceNormal.method3377(ClientPacket.field2272, packetWriter.isaacCipher);
                                                                  var10.packetBuffer.method5611(field837);
                                                                  var10.packetBuffer.method5611(selectedSpellChildIndex);
                                                                  var10.packetBuffer.method5612(var0);
                                                                  var10.packetBuffer.method5610(var16.itemId);
                                                                  var10.packetBuffer.method5717(class7.selectedSpellWidget);
                                                                  var10.packetBuffer.method5645(var1);
                                                                  packetWriter.method2375(var10);
                                                               }
                                                               break label824;
                                                            }

                                                            if(var2 == 1001) {
                                                               mouseCrossX = var6;
                                                               mouseCrossY = var7;
                                                               mouseCrossColor = 2;
                                                               mouseCrossState = 0;
                                                               destinationX = var0;
                                                               destinationY = var1;
                                                               var9 = FaceNormal.method3377(ClientPacket.field2274, packetWriter.isaacCipher);
                                                               var9.packetBuffer.method5612(var3);
                                                               var9.packetBuffer.method5610(class69.baseX * 64 + var0);
                                                               var9.packetBuffer.method5559(KeyHandler.KeyHandler_pressedKeys[82]?1:0);
                                                               var9.packetBuffer.method5560(class89.baseY * 64 + var1);
                                                               packetWriter.method2375(var9);
                                                               break label822;
                                                            }

                                                            if(var2 == 1002) {
                                                               if(var8 <= 1385798528) {
                                                                  return;
                                                               }

                                                               mouseCrossX = var6;
                                                               mouseCrossY = var7;
                                                               mouseCrossColor = 2;
                                                               mouseCrossState = 0;
                                                               var9 = FaceNormal.method3377(ClientPacket.field2284, packetWriter.isaacCipher);
                                                               var9.packetBuffer.method5611(var3);
                                                               packetWriter.method2375(var9);
                                                               break label822;
                                                            }

                                                            if(var2 == 1003) {
                                                               if(var8 <= 1385798528) {
                                                                  return;
                                                               }

                                                               mouseCrossX = var6;
                                                               mouseCrossY = var7;
                                                               mouseCrossColor = 2;
                                                               mouseCrossState = 0;
                                                               var14 = npcs[var3];
                                                               if(var14 != null) {
                                                                  if(var8 <= 1385798528) {
                                                                     return;
                                                                  }

                                                                  NPCDefinition var17 = var14.definition;
                                                                  if(var17.transforms != null) {
                                                                     var17 = var17.method4791();
                                                                  }

                                                                  if(var17 != null) {
                                                                     var11 = FaceNormal.method3377(ClientPacket.field2242, packetWriter.isaacCipher);
                                                                     var11.packetBuffer.method5612(var17.id);
                                                                     packetWriter.method2375(var11);
                                                                  }
                                                               }
                                                               break label771;
                                                            }

                                                            if(var2 == 1004) {
                                                               mouseCrossX = var6;
                                                               mouseCrossY = var7;
                                                               mouseCrossColor = 2;
                                                               mouseCrossState = 0;
                                                               var9 = FaceNormal.method3377(ClientPacket.field2294, packetWriter.isaacCipher);
                                                               var9.packetBuffer.method5611(var3);
                                                               packetWriter.method2375(var9);
                                                               break label822;
                                                            }

                                                            if(var2 == 1005) {
                                                               var16 = MusicPatchNode.method3920(var1);
                                                               if(var16 != null && var16.itemQuantities[var0] >= 100000) {
                                                                  Skeleton.method3175(27, "", var16.itemQuantities[var0] + " x " + AbstractWorldMapData.method373(var3).name);
                                                               } else {
                                                                  var10 = FaceNormal.method3377(ClientPacket.field2294, packetWriter.isaacCipher);
                                                                  var10.packetBuffer.method5611(var3);
                                                                  packetWriter.method2375(var10);
                                                               }

                                                               field786 = 0;
                                                               WorldMapID.field307 = MusicPatchNode.method3920(var1);
                                                               field880 = var0;
                                                               break label771;
                                                            }

                                                            if(var2 != 1007) {
                                                               if(var2 == 1010 || var2 == 1008 || var2 == 1011 || var2 == 1009 || var2 == 1012) {
                                                                  GrandExchangeOfferAgeComparator.worldMap.method6508(var2, var3, new Coord(var0), new Coord(var1));
                                                                  break label822;
                                                               }
                                                               break label771;
                                                            }

                                                            if(var8 <= 1385798528) {
                                                               return;
                                                            }
                                                         }

                                                         var16 = GrandExchangeOfferUnitPriceComparator.method224(var1, var0);
                                                         if(var16 != null) {
                                                            ClientPacket.method3686(var3, var1, var0, var16.itemId, var5);
                                                         }
                                                         break label824;
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
                     }
                  }
               }

               if(var8 <= 1385798528) {
                  return;
               }
            }
         }

         if(var8 <= 1385798528) {
            return;
         }
      }

      if(isItemSelected != 0) {
         isItemSelected = 0;
         ItemContainer.method1273(MusicPatchNode.method3920(WorldMapSection2.selectedItemWidget));
      }

      if(isSpellSelected) {
         if(var8 <= 1385798528) {
            return;
         }

         GrandExchangeOffer.method210();
      }

      if(WorldMapID.field307 != null && field786 == 0) {
         ItemContainer.method1273(WorldMapID.field307);
      }

   }

   public static boolean vmExecuteOpcode(int var0) {
      if(deferredEvent != null) {
         WorldMapSection1.client.getCallbacks().post(ScriptPostFired.class, deferredEvent);
         deferredEvent = null;
      }

      int var1;
      if(var0 == 6599) {
         if(!$assertionsDisabled && currentScript.getInstructions()[currentScriptPC] != 6599) {
            throw new AssertionError();
         } else {
            var1 = WorldMapSection1.client.getStringStackSize();
            String[] var10000 = WorldMapSection1.client.getStringStack();
            --var1;
            String var8 = var10000[var1];
            WorldMapSection1.client.setStringStackSize(var1);
            if("debug".equals(var8)) {
               int var3 = WorldMapSection1.client.getIntStackSize();
               var10000 = WorldMapSection1.client.getStringStack();
               --var1;
               String var4 = var10000[var1];
               StringBuffer var5 = new StringBuffer();
               Matcher var6 = Pattern.compile("%(.)").matcher(var4);

               while(var6.find()) {
                  var6.appendReplacement(var5, "");
                  switch(var6.group(1).charAt(0)) {
                  case 100:
                  case 105:
                     int[] var9 = WorldMapSection1.client.getIntStack();
                     --var3;
                     var5.append(var9[var3]);
                     break;
                  case 115:
                     String[] var10001 = WorldMapSection1.client.getStringStack();
                     --var1;
                     var5.append(var10001[var1]);
                     break;
                  default:
                     var5.append(var6.group(0)).append("=unknown");
                  }
               }

               var6.appendTail(var5);
               WorldMapSection1.client.getLogger().debug(var5.toString());
               WorldMapSection1.client.setStringStackSize(var1);
               WorldMapSection1.client.setIntStackSize(var3);
               return true;
            } else {
               ScriptCallbackEvent var7 = new ScriptCallbackEvent();
               var7.setScript(currentScript);
               var7.setEventName(var8);
               WorldMapSection1.client.getCallbacks().post(ScriptCallbackEvent.class, var7);
               return true;
            }
         }
      } else {
         if(var0 == 40) {
            var1 = currentScript.getIntOperands()[currentScriptPC];
            scriptIds.push(Integer.valueOf(var1));
            ScriptPreFired var2 = new ScriptPreFired(var1);
            var2.setScriptEvent((net.runelite.api.ScriptEvent)null);
            WorldMapSection1.client.getCallbacks().post(ScriptPreFired.class, var2);
         } else if(var0 == 21 && scriptIds.size() > 1) {
            deferredEvent = new ScriptPostFired(((Integer)scriptIds.pop()).intValue());
         }

         return false;
      }
   }

   public static final void copy$changeGameOptions(int var0, byte var1) {
      class58.method966();

      for(ObjectSound var2 = (ObjectSound)ObjectSound.objectSounds.method4956(); var2 != null; var2 = (ObjectSound)ObjectSound.objectSounds.method4974()) {
         if(var2.obj != null) {
            if(var1 >= 0) {
               return;
            }

            var2.method2021();
         }
      }

      int var5 = class228.method4204(var0).type;
      if(var5 != 0) {
         int var3 = Varps.Varps_main[var0];
         if(var5 == 1) {
            if(var1 >= 0) {
               return;
            }

            if(var3 == 1) {
               Rasterizer3D.method3101(0.9D);
               ((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).method2853(0.9D);
            }

            if(var3 == 2) {
               Rasterizer3D.method3101(0.8D);
               ((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).method2853(0.8D);
            }

            if(var3 == 3) {
               if(var1 >= 0) {
                  return;
               }

               Rasterizer3D.method3101(0.7D);
               ((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).method2853(0.7D);
            }

            if(var3 == 4) {
               Rasterizer3D.method3101(0.6D);
               ((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).method2853(0.6D);
            }

            ItemDefinition.ItemDefinition_cachedSprites.method3427();
         }

         if(var5 == 3) {
            if(var1 >= 0) {
               return;
            }

            short var4 = 0;
            if(var3 == 0) {
               if(var1 >= 0) {
                  return;
               }

               var4 = 255;
            }

            if(var3 == 1) {
               var4 = 192;
            }

            if(var3 == 2) {
               var4 = 128;
            }

            if(var3 == 3) {
               var4 = 64;
            }

            if(var3 == 4) {
               var4 = 0;
            }

            if(var4 != musicVolume) {
               if(var1 >= 0) {
                  return;
               }

               label211: {
                  if(musicVolume == 0) {
                     if(var1 >= 0) {
                        return;
                     }

                     if(currentTrackGroupId != -1) {
                        ApproximateRouteStrategy.method1321(AbstractWorldMapIcon.archive6, currentTrackGroupId, 0, var4, false);
                        field915 = false;
                        break label211;
                     }
                  }

                  if(var4 == 0) {
                     method1496();
                     field915 = false;
                  } else {
                     class219.method4058(var4);
                  }
               }

               musicVolume = var4;
            }
         }

         if(var5 == 4) {
            if(var3 == 0) {
               soundEffectVolume = 127;
            }

            if(var3 == 1) {
               soundEffectVolume = 96;
            }

            if(var3 == 2) {
               if(var1 >= 0) {
                  return;
               }

               soundEffectVolume = 64;
            }

            if(var3 == 3) {
               soundEffectVolume = 32;
            }

            if(var3 == 4) {
               soundEffectVolume = 0;
            }
         }

         if(var5 == 5) {
            leftClickOpensMenu = var3;
         }

         if(var5 == 6) {
            if(var1 >= 0) {
               return;
            }

            chatEffects = var3;
         }

         if(var5 == 9) {
            field845 = var3;
         }

         if(var5 == 10) {
            if(var3 == 0) {
               areaSoundEffectVolume = 127;
            }

            if(var3 == 1) {
               areaSoundEffectVolume = 96;
            }

            if(var3 == 2) {
               areaSoundEffectVolume = 64;
            }

            if(var3 == 3) {
               if(var1 >= 0) {
                  return;
               }

               areaSoundEffectVolume = 32;
            }

            if(var3 == 4) {
               areaSoundEffectVolume = 0;
            }
         }

         if(var5 == 17) {
            followerIndex = var3 & '\uffff';
         }

         if(var5 == 18) {
            playerAttackOption = (AttackOption)GrandExchangeEvent.method159(class39.method643(), var3);
            if(playerAttackOption == null) {
               playerAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
            }
         }

         if(var5 == 19) {
            if(var3 == -1) {
               combatTargetPlayerIndex = -1;
            } else {
               combatTargetPlayerIndex = var3 & 2047;
            }
         }

         if(var5 == 22) {
            if(var1 >= 0) {
               return;
            }

            npcAttackOption = (AttackOption)GrandExchangeEvent.method159(class39.method643(), var3);
            if(npcAttackOption == null) {
               if(var1 >= 0) {
                  return;
               }

               npcAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
            }
         }

      }
   }

   public static void settingsChanged(int var0) {
      VarbitChanged var1 = new VarbitChanged();
      var1.setIndex(var0);
      WorldMapSection1.client.getCallbacks().post(VarbitChanged.class, var1);
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1"
   )
   public static void onTempMenuActionChanged(int var0) {
      if(AbstractWorldMapIcon.tempMenuAction != null) {
         WorldMapSection1.client.getCallbacks().post(WidgetPressed.class, WidgetPressed.INSTANCE);
      }

   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1"
   )
   public static void draggingWidgetChanged(int var0) {
      DraggingWidgetChanged var1 = new DraggingWidgetChanged();
      var1.setDraggingWidget(WorldMapSection1.client.isDraggingWidget());
      WorldMapSection1.client.getCallbacks().post(DraggingWidgetChanged.class, var1);
   }

   public static final void copy$forceDisconnect(int var0, int var1) {
      Huffman.method4041();
      switch(var0) {
      case 1:
         ReflectionCheck.method2396();
         break;
      case 2:
         Login.loginIndex = 24;
         HealthBarUpdate.method1866("The game servers are currently being updated.", "Please wait a few minutes and try again.", "");
      }

   }

   public static void copy$runWidgetOnLoadListener(int var0, int var1) {
      if(var0 != -1) {
         if(LoginScreenAnimation.method1914(var0)) {
            Widget[] var2 = Widget.Widget_interfaceComponents[var0];

            for(int var3 = 0; var3 < var2.length; ++var3) {
               if(var1 >= -1296799789) {
                  return;
               }

               Widget var4 = var2[var3];
               if(var4.onLoad != null) {
                  ScriptEvent var5 = new ScriptEvent();
                  var5.widget = var4;
                  var5.args = var4.onLoad;
                  PlayerAppearance.method4124(var5, 5000000, -1708038674);
               }
            }

         }
      }
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1"
   )
   public static void onCameraPitchTargetChanged(int var0) {
      int var1 = WorldMapSection1.client.getCameraPitchTarget();
      int var2 = var1;
      if(pitchRelaxEnabled && lastPitchTarget > 383 && var1 == 383) {
         var2 = lastPitchTarget;
         if(var2 > 512) {
            var2 = 512;
         }

         WorldMapSection1.client.setCameraPitchTarget(var2);
      }

      lastPitchTarget = var2;
   }

   public static void copy$findItemDefinitions(String var0, boolean var1, byte var2) {
      var0 = var0.toLowerCase();
      short[] var3 = new short[16];
      int var4 = 0;

      for(int var5 = 0; var5 < class336.ItemDefinition_fileCount; ++var5) {
         ItemDefinition var6 = AbstractWorldMapData.method373(var5);
         if(var1 && !var6.isTradable) {
            if(var2 >= 32) {
               return;
            }
         } else if(var6.noteTemplate == -1 && var6.name.toLowerCase().indexOf(var0) != -1) {
            if(var4 >= 250) {
               TextureProvider.foundItemIdCount = -1;
               WorldMapEvent.foundItemIds = null;
               return;
            }

            if(var4 >= var3.length) {
               short[] var7 = new short[var3.length * 2];

               for(int var8 = 0; var8 < var4; ++var8) {
                  var7[var8] = var3[var8];
               }

               var3 = var7;
            }

            var3[var4++] = (short)var5;
         }
      }

      WorldMapEvent.foundItemIds = var3;
      AbstractWorldMapIcon.foundItemIndex = 0;
      TextureProvider.foundItemIdCount = var4;
      String[] var9 = new String[TextureProvider.foundItemIdCount];

      for(int var10 = 0; var10 < TextureProvider.foundItemIdCount; ++var10) {
         var9[var10] = AbstractWorldMapData.method373(var3[var10]).name;
      }

      class234.method4222(var9, WorldMapEvent.foundItemIds);
   }

   public static void experiencedChanged(int var0) {
      Skill[] var1 = Skill.values();
      if(var0 < var1.length - 1) {
         Skill var2 = var1[var0];
         StatChanged var3 = new StatChanged(var2, WorldMapSection1.client.getSkillExperience(var2), WorldMapSection1.client.getRealSkillLevel(var2), WorldMapSection1.client.getBoostedSkillLevel(var2));
         WorldMapSection1.client.getCallbacks().post(StatChanged.class, var3);
      }

   }

   public static void boostedSkillLevelsChanged(int var0) {
      if(var0 != 0) {
         int var1 = var0 - 1 & 31;
         int var2 = WorldMapSection1.client.getChangedSkillLevels()[var1];
         Skill[] var3 = Skill.values();
         if(var2 >= 0 && var2 < var3.length - 1) {
            StatChanged var4 = new StatChanged(var3[var2], WorldMapSection1.client.getSkillExperiences()[var2], WorldMapSection1.client.getRealSkillLevels()[var2], WorldMapSection1.client.getBoostedSkillLevels()[var2]);
            WorldMapSection1.client.getCallbacks().post(StatChanged.class, var4);
         }

      }
   }

   @ObfuscatedSignature(
      signature = "(Lcw;II)V"
   )
   public static final void copy$updateActorSequence(Actor var0, int var1, int var2) {
      int var3;
      int var4;
      int var5;
      if(var0.field1019 >= cycle) {
         var3 = Math.max(1, var0.field1019 - cycle);
         var4 = var0.field990 * 128 + var0.field976 * 64;
         var5 = var0.field1017 * 128 + var0.field976 * 64;
         var0.x += (var4 - var0.x) / var3;
         var0.y += (var5 - var0.y) / var3;
         var0.field1031 = 0;
         var0.orientation = var0.field1021;
      } else if(var0.field1020 >= cycle) {
         label377: {
            if(var0.field1020 != cycle && var0.sequence != -1 && var0.sequenceDelay == 0) {
               if(var2 <= 320210311) {
                  return;
               }

               if(var0.sequenceFrameCycle + 1 <= SpotAnimationDefinition.method4503(var0.sequence).frameLengths[var0.sequenceFrame]) {
                  break label377;
               }
            }

            var3 = var0.field1020 - var0.field1019;
            var4 = cycle - var0.field1019;
            var5 = var0.field990 * 128 + var0.field976 * 64;
            int var6 = var0.field1017 * 128 + var0.field976 * 64;
            int var7 = var0.field972 * 128 + var0.field976 * 64;
            int var8 = var0.field1018 * 128 + var0.field976 * 64;
            var0.x = (var4 * var7 + var5 * (var3 - var4)) / var3;
            var0.y = (var8 * var4 + var6 * (var3 - var4)) / var3;
         }

         var0.field1031 = 0;
         var0.orientation = var0.field1021;
         var0.rotation = var0.orientation;
      } else {
         ClientPacket.method3687(var0);
      }

      label369: {
         if(var0.x >= 128) {
            if(var2 <= 320210311) {
               return;
            }

            if(var0.y >= 128 && var0.x < 13184 && var0.y < 13184) {
               break label369;
            }
         }

         var0.sequence = -1;
         var0.animationChanged(-1);
         var0.spotAnimation = -1;
         var0.spotAnimationChanged(-1);
         var0.field1019 = 0;
         var0.field1020 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field976 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field976 * 64;
         var0.method1842();
      }

      if(ByteArrayPool.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.sequence = -1;
         var0.animationChanged(-1);
         var0.spotAnimation = -1;
         var0.spotAnimationChanged(-1);
         var0.field1019 = 0;
         var0.field1020 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field976 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field976 * 64;
         var0.method1842();
      }

      if(var0.field1026 != 0) {
         if(var0.targetIndex != -1) {
            Object var9 = null;
            if(var0.targetIndex < '\u8000') {
               var9 = npcs[var0.targetIndex];
            } else if(var0.targetIndex >= '\u8000') {
               if(var2 <= 320210311) {
                  return;
               }

               var9 = players[var0.targetIndex - '\u8000'];
            }

            if(var9 != null) {
               label348: {
                  var4 = var0.x - ((Actor)var9).x;
                  var5 = var0.y - ((Actor)var9).y;
                  if(var4 == 0) {
                     if(var2 <= 320210311) {
                        return;
                     }

                     if(var5 == 0) {
                        break label348;
                     }
                  }

                  var0.orientation = (int)(Math.atan2((double)var4, (double)var5) * 325.949D) & 2047;
               }
            } else if(var0.false0) {
               var0.targetIndex = -1;
               var0.interactingChanged(-1);
               var0.false0 = false;
            }
         }

         if(var0.field1015 != -1 && (var0.pathLength == 0 || var0.field1031 > 0)) {
            var0.orientation = var0.field1015;
            var0.field1015 = -1;
         }

         var3 = var0.orientation - var0.rotation & 2047;
         if(var3 == 0 && var0.false0) {
            var0.targetIndex = -1;
            var0.interactingChanged(-1);
            var0.false0 = false;
         }

         if(var3 != 0) {
            ++var0.field1025;
            boolean var11;
            if(var3 > 1024) {
               var0.rotation -= var0.field1026;
               var11 = true;
               if(var3 < var0.field1026 || var3 > 2048 - var0.field1026) {
                  var0.rotation = var0.orientation;
                  var11 = false;
               }

               if(var0.movementSequence == var0.idleSequence) {
                  if(var2 <= 320210311) {
                     return;
                  }

                  if(var0.field1025 > 25 || var11) {
                     if(var0.turnLeftSequence != -1) {
                        if(var2 <= 320210311) {
                           return;
                        }

                        var0.movementSequence = var0.turnLeftSequence;
                     } else {
                        var0.movementSequence = var0.walkSequence;
                     }
                  }
               }
            } else {
               var0.rotation += var0.field1026;
               var11 = true;
               if(var3 < var0.field1026 || var3 > 2048 - var0.field1026) {
                  var0.rotation = var0.orientation;
                  var11 = false;
               }

               if(var0.movementSequence == var0.idleSequence) {
                  label316: {
                     if(var0.field1025 <= 25) {
                        if(!var11) {
                           break label316;
                        }

                        if(var2 <= 320210311) {
                           return;
                        }
                     }

                     if(var0.turnRightSequence != -1) {
                        var0.movementSequence = var0.turnRightSequence;
                     } else {
                        var0.movementSequence = var0.walkSequence;
                     }
                  }
               }
            }

            var0.rotation &= 2047;
         } else {
            var0.field1025 = 0;
         }
      }

      var0.isWalking = false;
      SequenceDefinition var12;
      if(var0.movementSequence != -1) {
         var12 = SpotAnimationDefinition.method4503(var0.movementSequence);
         if(var12 != null && var12.frameIds != null) {
            ++var0.movementFrameCycle;
            if(var0.movementFrame < var12.frameIds.length) {
               if(var2 <= 320210311) {
                  return;
               }

               if(var0.movementFrameCycle > var12.frameLengths[var0.movementFrame]) {
                  var0.movementFrameCycle = 1;
                  ++var0.movementFrame;
                  PacketWriter.method2382(var12, var0.movementFrame, var0.x, var0.y);
               }
            }

            if(var0.movementFrame >= var12.frameIds.length) {
               var0.movementFrameCycle = 0;
               var0.movementFrame = 0;
               PacketWriter.method2382(var12, var0.movementFrame, var0.x, var0.y);
            }
         } else {
            var0.movementSequence = -1;
         }
      }

      if(var0.spotAnimation != -1 && cycle >= var0.field1013) {
         if(var0.spotAnimationFrame < 0) {
            var0.spotAnimationFrame = 0;
         }

         var3 = MouseHandler.method1205(var0.spotAnimation).sequence;
         if(var3 != -1) {
            SequenceDefinition var10 = SpotAnimationDefinition.method4503(var3);
            if(var10 != null && var10.frameIds != null) {
               ++var0.spotAnimationFrameCycle;
               if(var0.spotAnimationFrame < var10.frameIds.length && var0.spotAnimationFrameCycle > var10.frameLengths[var0.spotAnimationFrame]) {
                  var0.spotAnimationFrameCycle = 1;
                  ++var0.spotAnimationFrame;
                  PacketWriter.method2382(var10, var0.spotAnimationFrame, var0.x, var0.y);
               }

               if(var0.spotAnimationFrame >= var10.frameIds.length) {
                  label294: {
                     if(var0.spotAnimationFrame >= 0) {
                        if(var0.spotAnimationFrame < var10.frameIds.length) {
                           break label294;
                        }

                        if(var2 <= 320210311) {
                           return;
                        }
                     }

                     var0.spotAnimation = -1;
                     var0.spotAnimationChanged(-1);
                  }
               }
            } else {
               var0.spotAnimation = -1;
               var0.spotAnimationChanged(-1);
            }
         } else {
            var0.spotAnimation = -1;
            var0.spotAnimationChanged(-1);
         }
      }

      if(var0.sequence != -1 && var0.sequenceDelay <= 1) {
         var12 = SpotAnimationDefinition.method4503(var0.sequence);
         if(var12.field3520 == 1) {
            if(var2 <= 320210311) {
               return;
            }

            if(var0.field1032 > 0 && var0.field1019 <= cycle) {
               if(var2 <= 320210311) {
                  return;
               }

               if(var0.field1020 < cycle) {
                  var0.sequenceDelay = 1;
                  return;
               }
            }
         }
      }

      if(var0.sequence != -1 && var0.sequenceDelay == 0) {
         var12 = SpotAnimationDefinition.method4503(var0.sequence);
         if(var12 != null && var12.frameIds != null) {
            ++var0.sequenceFrameCycle;
            if(var0.sequenceFrame < var12.frameIds.length) {
               if(var2 <= 320210311) {
                  return;
               }

               if(var0.sequenceFrameCycle > var12.frameLengths[var0.sequenceFrame]) {
                  if(var2 <= 320210311) {
                     return;
                  }

                  var0.sequenceFrameCycle = 1;
                  ++var0.sequenceFrame;
                  PacketWriter.method2382(var12, var0.sequenceFrame, var0.x, var0.y);
               }
            }

            if(var0.sequenceFrame >= var12.frameIds.length) {
               var0.sequenceFrame -= var12.frameCount;
               ++var0.field1011;
               if(var0.field1011 >= var12.field3522) {
                  var0.sequence = -1;
                  var0.animationChanged(-1);
               } else if(var0.sequenceFrame >= 0 && var0.sequenceFrame < var12.frameIds.length) {
                  PacketWriter.method2382(var12, var0.sequenceFrame, var0.x, var0.y);
               } else {
                  var0.sequence = -1;
                  var0.animationChanged(-1);
               }
            }

            var0.isWalking = var12.field3518;
         } else {
            var0.sequence = -1;
            var0.animationChanged(-1);
         }
      }

      if(var0.sequenceDelay > 0) {
         --var0.sequenceDelay;
      }

   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1"
   )
   public static void clanMemberManagerChanged(int var0) {
      WorldMapSection1.client.getCallbacks().post(ClanChanged.class, new ClanChanged(WorldMapSection1.client.getClanMemberManager() != null));
   }

   public static void updateNpcs(boolean var0, RSPacketBuffer var1) {
      WorldMapSection1.client.getCallbacks().updateNpcs();
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1"
   )
   public static void setLeftTitleSprite(int var0) {
      net.runelite.api.Sprite var1 = loginScreenBackground;
      if(var1 != null) {
         WorldMapSection1.client.setLeftTitleSprite(var1);
      }

   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1"
   )
   public static void onCycleCntrChanged(int var0) {
      WorldMapSection1.client.getCallbacks().post(ClientTick.class, ClientTick.INSTANCE);
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1"
   )
   public static void onCameraPitchChanged(int var0) {
      int var1 = WorldMapSection1.client.getCameraPitch();
      int var2 = var1;
      if(pitchRelaxEnabled && lastPitch > 383 && var1 == 383) {
         var2 = lastPitch;
         if(var2 > 512) {
            var2 = 512;
         }

         WorldMapSection1.client.setCameraPitch(var2);
      }

      lastPitch = var2;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1"
   )
   public static void setRightTitleSprite(int var0) {
      net.runelite.api.Sprite var1 = loginScreenBackground;
      if(var1 != null && var1.getWidth() > 383) {
         WorldMapSection1.client.setRightTitleSprite(WorldMapSection1.client.createSprite(new int[]{var1.getPixels()[383]}, 1, 1));
      }

   }

   public static void playerOptionsChanged(int var0) {
      MenuOpcode[] var1 = new MenuOpcode[]{MenuOpcode.PLAYER_FIRST_OPTION, MenuOpcode.PLAYER_SECOND_OPTION, MenuOpcode.PLAYER_THIRD_OPTION, MenuOpcode.PLAYER_FOURTH_OPTION, MenuOpcode.PLAYER_FIFTH_OPTION, MenuOpcode.PLAYER_SIXTH_OPTION, MenuOpcode.PLAYER_SEVENTH_OPTION, MenuOpcode.PLAYER_EIGTH_OPTION};
      if(var0 >= 0 && var0 < var1.length) {
         MenuOpcode var2 = var1[var0];
         WorldMapSection1.client.getPlayerMenuTypes()[var0] = var2.getId();
      }

      PlayerMenuOptionsChanged var3 = new PlayerMenuOptionsChanged();
      var3.setIndex(var0);
      WorldMapSection1.client.getCallbacks().post(PlayerMenuOptionsChanged.class, var3);
   }

   public static void cachedPlayersChanged(int var0) {
      RSPlayer[] var1 = WorldMapSection1.client.getCachedPlayers();
      if(var0 >= 0 && var0 < var1.length) {
         RSPlayer var2 = var1[var0];
         RSPlayer var3 = oldPlayers[var0];
         oldPlayers[var0] = var2;
         if(var3 != null) {
            WorldMapSection1.client.getCallbacks().post(PlayerDespawned.class, new PlayerDespawned(var3));
         }

         if(var2 != null) {
            WorldMapSection1.client.getCallbacks().postDeferred(PlayerSpawned.class, new PlayerSpawned(var2));
         }

      }
   }

   public static void cachedNPCsChanged(int var0) {
      RSNPC[] var1 = WorldMapSection1.client.getCachedNPCs();
      if(var0 >= 0 && var0 < var1.length) {
         RSNPC var2 = var1[var0];
         if(var2 != null) {
            var2.setIndex(var0);
            WorldMapSection1.client.getCallbacks().postDeferred(NpcSpawned.class, new NpcSpawned(var2));
         }

      }
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1"
   )
   public static void onCamAngleDXChange(int var0) {
      if(invertPitch && WorldMapSection1.client.getMouseCurrentButton() == 4 && WorldMapSection1.client.isMouseCam()) {
         WorldMapSection1.client.setCamAngleDX(-WorldMapSection1.client.getCamAngleDX());
      }

   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1"
   )
   public static void onCamAngleDYChange(int var0) {
      if(invertYaw && WorldMapSection1.client.getMouseCurrentButton() == 4 && WorldMapSection1.client.isMouseCam()) {
         WorldMapSection1.client.setCamAngleDY(-WorldMapSection1.client.getCamAngleDY());
      }

   }

   public static void onGrandExchangeOffersChanged(int var0) {
      if(var0 != -1) {
         RSGrandExchangeOffer var1 = WorldMapSection1.client.getGrandExchangeOffers()[var0];
         if(var1 != null) {
            GrandExchangeOfferChanged var2 = new GrandExchangeOfferChanged();
            var2.setOffer(var1);
            var2.setSlot(var0);
            WorldMapSection1.client.getCallbacks().post(GrandExchangeOfferChanged.class, var2);
         }
      }
   }

   public static boolean shouldHideAttackOptionFor(RSPlayer var0) {
      return WorldMapSection1.client.isSpellSelected()?(hideFriendCastOptions && var0.isFriended() || hideClanmateCastOptions && var0.isClanMember()) && !unhiddenCasts.contains(WorldMapSection1.client.getSelectedSpellName().replaceAll("<[^>]*>", "").toLowerCase()):hideFriendAttackOptions && var0.isFriended() || hideClanmateAttackOptions && var0.isClanMember();
   }

   private static void rl$$clinit() {
      $assertionsDisabled = !client.class.desiredAssertionStatus();
   }

   private static void rl$$clinit1() {
      $assertionsDisabled = !client.class.desiredAssertionStatus();
   }

   private static void rl$$clinit2() {
      $assertionsDisabled = !client.class.desiredAssertionStatus();
      deferredEvent = null;
      scriptIds = new Stack();
   }

   private static void rl$$clinit3() {
      $assertionsDisabled = !client.class.desiredAssertionStatus();
      shouldRenderLoginScreenFire = true;
   }

   private static void rl$$clinit4() {
      $assertionsDisabled = !client.class.desiredAssertionStatus();
      oldPlayers = new Player[2048];
      hideDisconnect = false;
      hideFriendAttackOptions = false;
      hideClanmateAttackOptions = false;
      hideFriendCastOptions = false;
      hideClanmateCastOptions = false;
      allWidgetsAreOpTargetable = false;
      unhiddenCasts = new HashSet();
   }

   private static void rl$$clinit5() {
      hiddenNpcsName = new HashMap();
      hiddenNpcsDeath = new HashMap();
      hideSpecificPlayers = new ArrayList();
      blacklistDeadNpcs = new HashSet();
   }

   private static void rl$$clinit6() {
      spriteOverrides = new HashMap();
      widgetSpriteOverrides = new HashMap();
   }

   private static void rl$$clinit7() {
      pitchRelaxEnabled = false;
      lastPitch = 128;
      lastPitchTarget = 128;
   }

   private static void rl$$clinit8() {
      complianceMap = new HashMap();
   }

   private static void rl$$clinit9() {
      rl$modelViewportXs = new int[4700];
      rl$modelViewportYs = new int[4700];
   }
}
