package com.zenyte.desktop;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.security.SecureRandom;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSMouseHandler;

@ObfuscatedName("bq")
public class MouseHandler implements MouseListener, MouseMotionListener, FocusListener, RSMouseHandler {
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1802673633
	)
	public static int MouseHandler_y;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 9279483
	)
	public static int MouseHandler_x;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lbq;"
	)
	static MouseHandler MouseHandler_instance;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 481106497
	)
	public static volatile int MouseHandler_idleCycles;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -853983883
	)
	static volatile int MouseHandler_currentButtonVolatile;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -2069980405
	)
	static volatile int MouseHandler_xVolatile;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1032976335
	)
	static volatile int MouseHandler_yVolatile;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		longValue = 8440490709549879739L
	)
	static volatile long MouseHandler_lastMovedVolatile;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 440702865
	)
	public static int MouseHandler_currentButton;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		longValue = -7274898948584366517L
	)
	public static long MouseHandler_millis;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 329598021
	)
	static volatile int MouseHandler_lastButtonVolatile;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -2102823313
	)
	static volatile int MouseHandler_lastPressedXVolatile;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 44004483
	)
	static volatile int MouseHandler_lastPressedYVolatile;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		longValue = -4336093553213135153L
	)
	static volatile long MouseHandler_lastPressedTimeMillisVolatile;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1894311513
	)
	public static int MouseHandler_lastButton;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -894585521
	)
	public static int MouseHandler_lastPressedX;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -880195683
	)
	public static int MouseHandler_lastPressedY;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		longValue = 5747430308835367139L
	)
	public static long MouseHandler_lastPressedTimeMillis;
	@ObfuscatedName("ey")
	static SecureRandom secureRandom;
	@ObfuscatedName("ge")
	@ObfuscatedGetter(
		intValue = 1073160651
	)
	static int field529;
	public int isInEvent;

	static {
		MouseHandler_instance = new MouseHandler();
		MouseHandler_idleCycles = 0;
		MouseHandler_currentButtonVolatile = 0;
		MouseHandler_xVolatile = -1;
		MouseHandler_yVolatile = -1;
		MouseHandler_lastMovedVolatile = -1L;
		MouseHandler_currentButton = 0;
		MouseHandler_x = 0;
		MouseHandler_y = 0;
		MouseHandler_millis = 0L;
		MouseHandler_lastButtonVolatile = 0;
		MouseHandler_lastPressedXVolatile = 0;
		MouseHandler_lastPressedYVolatile = 0;
		MouseHandler_lastPressedTimeMillisVolatile = 0L;
		MouseHandler_lastButton = 0;
		MouseHandler_lastPressedX = 0;
		MouseHandler_lastPressedY = 0;
		MouseHandler_lastPressedTimeMillis = 0L;
	}

	MouseHandler() {
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Ljava/awt/event/MouseEvent;I)I",
		garbageValue = "-1992651704"
	)
	final int method1162(MouseEvent var1) {
		int var2 = var1.getButton();
		if (!var1.isAltDown() && var2 != 2) {
			return !var1.isMetaDown() && var2 != 3 ? 1 : 2;
		} else {
			return 4;
		}
	}

	public final synchronized void mouseMoved(MouseEvent var1) {
		if (this.isInEvent == 0) {
			var1 = WorldMapSection1.client.getCallbacks().mouseMoved(var1);
		}

		if (!var1.isConsumed()) {
			++this.isInEvent;

			try {
				this.copy$mouseMoved(var1);
			} finally {
				--this.isInEvent;
			}
		}

	}

	public final void copy$mouseClicked(MouseEvent var1) {
		if (var1.isPopupTrigger()) {
			var1.consume();
		}

	}

	public final synchronized void copy$mousePressed(MouseEvent var1) {
		if (MouseHandler_instance != null) {
			MouseHandler_idleCycles = 0;
			MouseHandler_lastPressedXVolatile = var1.getX();
			MouseHandler_lastPressedYVolatile = var1.getY();
			MouseHandler_lastPressedTimeMillisVolatile = class217.method4014();
			MouseHandler_lastButtonVolatile = this.method1162(var1);
			if (MouseHandler_lastButtonVolatile != 0) {
				MouseHandler_currentButtonVolatile = MouseHandler_lastButtonVolatile;
			}
		}

		if (var1.isPopupTrigger()) {
			var1.consume();
		}

	}

	public final synchronized void copy$mouseReleased(MouseEvent var1) {
		if (MouseHandler_instance != null) {
			MouseHandler_idleCycles = 0;
			MouseHandler_currentButtonVolatile = 0;
		}

		if (var1.isPopupTrigger()) {
			var1.consume();
		}

	}

	public final synchronized void copy$mouseEntered(MouseEvent var1) {
		this.mouseMoved(var1);
	}

	public final synchronized void copy$mouseExited(MouseEvent var1) {
		if (MouseHandler_instance != null) {
			MouseHandler_idleCycles = 0;
			MouseHandler_xVolatile = -1;
			MouseHandler_yVolatile = -1;
			MouseHandler_lastMovedVolatile = var1.getWhen();
		}

	}

	public final synchronized void copy$mouseDragged(MouseEvent var1) {
		this.mouseMoved(var1);
	}

	public final synchronized void copy$mouseMoved(MouseEvent var1) {
		if (MouseHandler_instance != null) {
			MouseHandler_idleCycles = 0;
			MouseHandler_xVolatile = var1.getX();
			MouseHandler_yVolatile = var1.getY();
			MouseHandler_lastMovedVolatile = var1.getWhen();
		}

	}

	public final synchronized void mousePressed(MouseEvent var1) {
		if (this.isInEvent == 0) {
			var1 = WorldMapSection1.client.getCallbacks().mousePressed(var1);
		}

		if (!var1.isConsumed()) {
			++this.isInEvent;

			try {
				this.copy$mousePressed(var1);
			} finally {
				--this.isInEvent;
			}
		}

	}

	public final synchronized void mouseReleased(MouseEvent var1) {
		if (this.isInEvent == 0) {
			var1 = WorldMapSection1.client.getCallbacks().mouseReleased(var1);
		}

		if (!var1.isConsumed()) {
			++this.isInEvent;

			try {
				this.copy$mouseReleased(var1);
			} finally {
				--this.isInEvent;
			}
		}

	}

	public final void mouseClicked(MouseEvent var1) {
		var1 = WorldMapSection1.client.getCallbacks().mouseClicked(var1);
		if (!var1.isConsumed()) {
			this.copy$mouseClicked(var1);
		}

	}

	public final synchronized void mouseEntered(MouseEvent var1) {
		if (this.isInEvent == 0) {
			var1 = WorldMapSection1.client.getCallbacks().mouseEntered(var1);
		}

		if (!var1.isConsumed()) {
			++this.isInEvent;

			try {
				this.copy$mouseEntered(var1);
			} finally {
				--this.isInEvent;
			}
		}

	}

	public final synchronized void mouseExited(MouseEvent var1) {
		if (this.isInEvent == 0) {
			var1 = WorldMapSection1.client.getCallbacks().mouseExited(var1);
		}

		if (!var1.isConsumed()) {
			++this.isInEvent;

			try {
				this.copy$mouseExited(var1);
			} finally {
				--this.isInEvent;
			}
		}

	}

	public final void focusGained(FocusEvent var1) {
	}

	public final synchronized void focusLost(FocusEvent var1) {
		if (MouseHandler_instance != null) {
			MouseHandler_currentButtonVolatile = 0;
		}

	}

	public final synchronized void mouseDragged(MouseEvent var1) {
		if (this.isInEvent == 0) {
			var1 = WorldMapSection1.client.getCallbacks().mouseDragged(var1);
		}

		if (!var1.isConsumed()) {
			++this.isInEvent;

			try {
				this.copy$mouseDragged(var1);
			} finally {
				--this.isInEvent;
			}
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(II)Liw;",
		garbageValue = "1540398140"
	)
	public static SpotAnimationDefinition method1205(int var0) {
		SpotAnimationDefinition var1 = (SpotAnimationDefinition)SpotAnimationDefinition.SpotAnimationDefinition_cached.method3418((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = SpotAnimationDefinition.SpotAnimationDefinition_archive.method4224(13, var0, (byte)-47);
			var1 = new SpotAnimationDefinition();
			var1.id = var0;
			if (var2 != null) {
				var1.method4470(new Buffer(var2));
			}

			SpotAnimationDefinition.SpotAnimationDefinition_cached.method3424(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Liy;I)V",
		garbageValue = "-50420172"
	)
	public static void method1206(AbstractArchive var0) {
		EnumDefinition.EnumDefinition_archive = var0;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
		garbageValue = "2112458178"
	)
	public static String method1187(CharSequence var0) {
		int var1 = var0.length();
		StringBuilder var2 = new StringBuilder(var1);

		for (int var3 = 0; var3 < var1; ++var3) {
			char var4 = var0.charAt(var3);
			if ((var4 < 'a' || var4 > 'z') && (var4 < 'A' || var4 > 'Z') && (var4 < '0' || var4 > '9') && var4 != '.' && var4 != '-' && var4 != '*' && var4 != '_') {
				if (var4 == ' ') {
					var2.append('+');
				} else {
					byte var5 = TaskHandler.method3559(var4);
					var2.append('%');
					int var6 = var5 >> 4 & 15;
					if (var6 >= 10) {
						var2.append((char)(var6 + 55));
					} else {
						var2.append((char)(var6 + 48));
					}

					var6 = var5 & 15;
					if (var6 >= 10) {
						var2.append((char)(var6 + 55));
					} else {
						var2.append((char)(var6 + 48));
					}
				}
			} else {
				var2.append(var4);
			}
		}

		return var2.toString();
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Lkj;I)I",
		garbageValue = "537227900"
	)
	static int method1200(PacketBuffer var0) {
		int var1 = var0.method5495(2);
		int var2;
		if (var1 == 0) {
			var2 = 0;
		} else if (var1 == 1) {
			var2 = var0.method5495(5);
		} else if (var1 == 2) {
			var2 = var0.method5495(8);
		} else {
			var2 = var0.method5495(11);
		}

		return var2;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)Lch;",
		garbageValue = "815744206"
	)
	static World method1184() {
		return World.World_listCount < World.World_count ? UserComparator2.World_worlds[++World.World_listCount - 1] : null;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lhe;IIII)V",
		garbageValue = "-951911792"
	)
	static final void method1163(Widget var0, int var1, int var2, int var3) {
		if (var0.field2644 == null) {
			throw new RuntimeException();
		} else {
			var0.field2644[var1] = var2;
			var0.field2695[var1] = var3;
		}
	}

	@ObfuscatedName("go")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-2142619406"
	)
	static final void method1202(int var0, int var1, int var2, int var3) {
		Client.overheadTextCount = 0;
		boolean var4 = false;
		int var5 = -1;
		int var6 = -1;
		int var7 = Players.Players_count;
		int[] var8 = Players.Players_indices;

		int var9;
		for (var9 = 0; var9 < var7 + Client.npcCount; ++var9) {
			Object var10;
			if (var9 < var7) {
				var10 = Client.players[var8[var9]];
				if (var8[var9] == Client.combatTargetPlayerIndex) {
					var4 = true;
					var5 = var9;
					continue;
				}

				if (var10 == ByteArrayPool.localPlayer) {
					var6 = var9;
					continue;
				}
			} else {
				var10 = Client.npcs[Client.npcIndices[var9 - var7]];
			}

			WorldMapSection1.method655((Actor)var10, var9, var0, var1, var2, var3, -535954243);
		}

		if (Client.renderSelf && var6 != -1) {
			WorldMapSection1.method655(ByteArrayPool.localPlayer, var6, var0, var1, var2, var3, -1464461419);
		}

		if (var4) {
			WorldMapSection1.method655(Client.players[Client.combatTargetPlayerIndex], var5, var0, var1, var2, var3, 559484924);
		}

		for (var9 = 0; var9 < Client.overheadTextCount; ++var9) {
			int var19 = Client.overheadTextXs[var9];
			int var11 = Client.overheadTextYs[var9];
			int var12 = Client.overheadTextXOffsets[var9];
			int var13 = Client.overheadTextAscents[var9];
			boolean var14 = true;

			while (var14) {
				var14 = false;

				for (int var15 = 0; var15 < var9; ++var15) {
					if (var11 + 2 > Client.overheadTextYs[var15] - Client.overheadTextAscents[var15] && var11 - var13 < Client.overheadTextYs[var15] + 2 && var19 - var12 < Client.overheadTextXOffsets[var15] + Client.overheadTextXs[var15] && var12 + var19 > Client.overheadTextXs[var15] - Client.overheadTextXOffsets[var15] && Client.overheadTextYs[var15] - Client.overheadTextAscents[var15] < var11) {
						var11 = Client.overheadTextYs[var15] - Client.overheadTextAscents[var15];
						var14 = true;
					}
				}
			}

			Client.viewportTempX = Client.overheadTextXs[var9];
			Client.viewportTempY = Client.overheadTextYs[var9] = var11;
			String var20 = Client.overheadText[var9];
			if (Client.chatEffects == 0) {
				int var16 = 16776960;
				if (Client.overheadTextColors[var9] < 6) {
					var16 = Client.field895[Client.overheadTextColors[var9]];
				}

				if (Client.overheadTextColors[var9] == 6) {
					var16 = Client.viewportDrawCount % 20 < 10 ? 16711680 : 16776960;
				}

				if (Client.overheadTextColors[var9] == 7) {
					var16 = Client.viewportDrawCount % 20 < 10 ? 255 : '\uffff';
				}

				if (Client.overheadTextColors[var9] == 8) {
					var16 = Client.viewportDrawCount % 20 < 10 ? '뀀' : 8454016;
				}

				int var17;
				if (Client.overheadTextColors[var9] == 9) {
					var17 = 150 - Client.overheadTextCyclesRemaining[var9];
					if (var17 < 50) {
						var16 = var17 * 1280 + 16711680;
					} else if (var17 < 100) {
						var16 = 16776960 - (var17 - 50) * 327680;
					} else if (var17 < 150) {
						var16 = (var17 - 100) * 5 + 65280;
					}
				}

				if (Client.overheadTextColors[var9] == 10) {
					var17 = 150 - Client.overheadTextCyclesRemaining[var9];
					if (var17 < 50) {
						var16 = var17 * 5 + 16711680;
					} else if (var17 < 100) {
						var16 = 16711935 - (var17 - 50) * 327680;
					} else if (var17 < 150) {
						var16 = (var17 - 100) * 327680 + 255 - (var17 - 100) * 5;
					}
				}

				if (Client.overheadTextColors[var9] == 11) {
					var17 = 150 - Client.overheadTextCyclesRemaining[var9];
					if (var17 < 50) {
						var16 = 16777215 - var17 * 327685;
					} else if (var17 < 100) {
						var16 = (var17 - 50) * 327685 + 65280;
					} else if (var17 < 150) {
						var16 = 16777215 - (var17 - 100) * 327680;
					}
				}

				if (Client.overheadTextEffects[var9] == 0) {
					TaskHandler.fontBold12.method5392(var20, var0 + Client.viewportTempX, Client.viewportTempY + var1, var16, 0);
				}

				if (Client.overheadTextEffects[var9] == 1) {
					TaskHandler.fontBold12.method5394(var20, var0 + Client.viewportTempX, Client.viewportTempY + var1, var16, 0, Client.viewportDrawCount);
				}

				if (Client.overheadTextEffects[var9] == 2) {
					TaskHandler.fontBold12.method5395(var20, var0 + Client.viewportTempX, Client.viewportTempY + var1, var16, 0, Client.viewportDrawCount);
				}

				if (Client.overheadTextEffects[var9] == 3) {
					TaskHandler.fontBold12.method5396(var20, var0 + Client.viewportTempX, Client.viewportTempY + var1, var16, 0, Client.viewportDrawCount, 150 - Client.overheadTextCyclesRemaining[var9]);
				}

				if (Client.overheadTextEffects[var9] == 4) {
					var17 = (150 - Client.overheadTextCyclesRemaining[var9]) * (TaskHandler.fontBold12.method5384(var20) + 100) / 150;
					Rasterizer2D.method6066(var0 + Client.viewportTempX - 50, var1, var0 + Client.viewportTempX + 50, var3 + var1);
					TaskHandler.fontBold12.method5389(var20, var0 + Client.viewportTempX + 50 - var17, Client.viewportTempY + var1, var16, 0);
					Rasterizer2D.method6045(var0, var1, var0 + var2, var3 + var1);
				}

				if (Client.overheadTextEffects[var9] == 5) {
					var17 = 150 - Client.overheadTextCyclesRemaining[var9];
					int var18 = 0;
					if (var17 < 25) {
						var18 = var17 - 25;
					} else if (var17 > 125) {
						var18 = var17 - 125;
					}

					Rasterizer2D.method6066(var0, Client.viewportTempY + var1 - TaskHandler.fontBold12.ascent - 1, var0 + var2, Client.viewportTempY + var1 + 5);
					TaskHandler.fontBold12.method5392(var20, var0 + Client.viewportTempX, var18 + Client.viewportTempY + var1, var16, 0);
					Rasterizer2D.method6045(var0, var1, var0 + var2, var3 + var1);
				}
			} else {
				TaskHandler.fontBold12.method5392(var20, var0 + Client.viewportTempX, Client.viewportTempY + var1, 16776960, 0);
			}
		}

	}

	@ObfuscatedName("il")
	@ObfuscatedSignature(
		signature = "([Lhe;Lhe;ZI)V",
		garbageValue = "584998144"
	)
	static void method1161(Widget[] var0, Widget var1, boolean var2) {
		int var3 = var1.scrollWidth != 0 ? var1.scrollWidth : var1.width;
		int var4 = var1.scrollHeight != 0 ? var1.scrollHeight : var1.height;
		InterfaceParent.method1280(var0, var1.id, var3, var4, var2);
		if (var1.children != null) {
			InterfaceParent.method1280(var1.children, var1.id, var3, var4, var2);
		}

		InterfaceParent var5 = (InterfaceParent)Client.interfaceParents.method6010((long)var1.id);
		if (var5 != null) {
			int var6 = var5.group;
			if (LoginScreenAnimation.method1900(var6)) {
				InterfaceParent.method1280(Widget.Widget_interfaceComponents[var6], -1, var3, var4, var2);
			}
		}

		if (var1.contentType == 1337) {
		}

	}
}
