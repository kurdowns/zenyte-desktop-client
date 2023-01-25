package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSRunException;
import net.runelite.rs.api.RSWorldMapDecorationType;

@ObfuscatedName("ha")
public class WorldMapDecorationType implements Enumerated, RSWorldMapDecorationType {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	public static final WorldMapDecorationType field2732;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	static final WorldMapDecorationType field2718;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	public static final WorldMapDecorationType field2728;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	public static final WorldMapDecorationType field2742;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	public static final WorldMapDecorationType field2722;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	static final WorldMapDecorationType field2723;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	static final WorldMapDecorationType field2724;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	static final WorldMapDecorationType field2721;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	static final WorldMapDecorationType field2726;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	static final WorldMapDecorationType field2730;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	static final WorldMapDecorationType field2734;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	static final WorldMapDecorationType field2729;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	static final WorldMapDecorationType field2720;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	static final WorldMapDecorationType field2731;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	static final WorldMapDecorationType field2725;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	static final WorldMapDecorationType field2738;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	static final WorldMapDecorationType field2737;
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	static final WorldMapDecorationType field2735;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	static final WorldMapDecorationType field2736;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	static final WorldMapDecorationType field2733;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	static final WorldMapDecorationType field2719;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	static final WorldMapDecorationType field2739;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	public static final WorldMapDecorationType field2740;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1867992849
	)
	public final int id;

	static {
		field2732 = new WorldMapDecorationType(0, 0);
		field2718 = new WorldMapDecorationType(1, 0);
		field2728 = new WorldMapDecorationType(2, 0);
		field2742 = new WorldMapDecorationType(3, 0);
		field2722 = new WorldMapDecorationType(9, 2);
		field2723 = new WorldMapDecorationType(4, 1);
		field2724 = new WorldMapDecorationType(5, 1);
		field2721 = new WorldMapDecorationType(6, 1);
		field2726 = new WorldMapDecorationType(7, 1);
		field2730 = new WorldMapDecorationType(8, 1);
		field2734 = new WorldMapDecorationType(12, 2);
		field2729 = new WorldMapDecorationType(13, 2);
		field2720 = new WorldMapDecorationType(14, 2);
		field2731 = new WorldMapDecorationType(15, 2);
		field2725 = new WorldMapDecorationType(16, 2);
		field2738 = new WorldMapDecorationType(17, 2);
		field2737 = new WorldMapDecorationType(18, 2);
		field2735 = new WorldMapDecorationType(19, 2);
		field2736 = new WorldMapDecorationType(20, 2);
		field2733 = new WorldMapDecorationType(21, 2);
		field2719 = new WorldMapDecorationType(10, 2);
		field2739 = new WorldMapDecorationType(11, 2);
		field2740 = new WorldMapDecorationType(22, 3);
	}

	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "0"
	)
	WorldMapDecorationType(int var1, int var2) {
		this.id = var1;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "56"
	)
	public int vmethod6149() {
		return this.id;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
		garbageValue = "-1131770525"
	)
	public static void method4189(String var0, Throwable var1) {
		if (var1 != null) {
			var1.printStackTrace();
		} else {
			if (var1 != null) {
				Throwable var2 = var1;
				if (var1 instanceof RSRunException) {
					var2 = ((RSRunException)var1).getParent();
				}

				WorldMapSection1.client.getLogger().error("Game crash: {}", var0, var2);
			}

		}
	}

	@ObfuscatedName("z")
	static boolean method4188(long var0) {
		return (int)(var0 >>> 16 & 1L) == 1;
	}

	@ObfuscatedName("jm")
	@ObfuscatedSignature(
		signature = "([Lhe;IIIIIIII)V",
		garbageValue = "635809234"
	)
	static final void method4185(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		for (int var8 = 0; var8 < var0.length; ++var8) {
			Widget var9 = var0[var8];
			if (var9 != null && var9.parentId == var1 && (!var9.isIf3 || var9.type == 0 || var9.hasListener || ScriptEvent.method1283(var9) != 0 || var9 == Client.clickedWidgetParent || var9.contentType == 1338)) {
				if (var9.isIf3) {
					if (AbstractWorldMapData.method356(var9)) {
						continue;
					}
				} else if (var9.type == 0 && var9 != class9.mousedOverWidgetIf1 && AbstractWorldMapData.method356(var9)) {
					continue;
				}

				int var10 = var9.x + var6;
				int var11 = var7 + var9.y;
				int var12;
				int var13;
				int var14;
				int var15;
				int var17;
				int var18;
				if (var9.type == 2) {
					var12 = var2;
					var13 = var3;
					var14 = var4;
					var15 = var5;
				} else {
					int var16;
					if (var9.type == 9) {
						var16 = var10;
						var17 = var11;
						var18 = var10 + var9.width;
						int var19 = var11 + var9.height;
						if (var18 < var10) {
							var16 = var18;
							var18 = var10;
						}

						if (var19 < var11) {
							var17 = var19;
							var19 = var11;
						}

						++var18;
						++var19;
						var12 = var16 > var2 ? var16 : var2;
						var13 = var17 > var3 ? var17 : var3;
						var14 = var18 < var4 ? var18 : var4;
						var15 = var19 < var5 ? var19 : var5;
					} else {
						var16 = var10 + var9.width;
						var17 = var11 + var9.height;
						var12 = var10 > var2 ? var10 : var2;
						var13 = var11 > var3 ? var11 : var3;
						var14 = var16 < var4 ? var16 : var4;
						var15 = var17 < var5 ? var17 : var5;
					}
				}

				if (var9 == Client.clickedWidget) {
					Client.field861 = true;
					Client.field834 = var10;
					Client.field863 = var11;
				}

				boolean var32 = false;
				if (var9.field2641) {
					switch(Client.field842) {
					case 0:
						var32 = true;
					case 1:
					default:
						break;
					case 2:
						if (Client.field843 == var9.id >>> 16) {
							var32 = true;
						}
						break;
					case 3:
						if (var9.id == Client.field843) {
							var32 = true;
						}
					}
				}

				if (var32 || !var9.isIf3 || var12 < var14 && var13 < var15) {
					if (var9.isIf3) {
						ScriptEvent var26;
						if (var9.noClickThrough) {
							if (MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
								for (var26 = (ScriptEvent)Client.scriptEvents.method4931(); var26 != null; var26 = (ScriptEvent)Client.scriptEvents.method4949()) {
									if (var26.isMouseInputEvent) {
										var26.method3657();
										var26.widget.containsMouse = false;
									}
								}

								if (MilliClock.widgetDragDuration == 0) {
									Client.clickedWidget = null;
									Client.clickedWidgetParent = null;
								}

								if (!Client.isMenuOpen) {
									Tile.method2946();
								}
							}
						} else if (var9.noScrollThrough && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
							for (var26 = (ScriptEvent)Client.scriptEvents.method4931(); var26 != null; var26 = (ScriptEvent)Client.scriptEvents.method4949()) {
								if (var26.isMouseInputEvent && var26.widget.onScroll == var26.args) {
									var26.method3657();
								}
							}
						}
					}

					var17 = MouseHandler.MouseHandler_x;
					var18 = MouseHandler.MouseHandler_y;
					if (MouseHandler.MouseHandler_lastButton != 0) {
						var17 = MouseHandler.MouseHandler_lastPressedX;
						var18 = MouseHandler.MouseHandler_lastPressedY;
					}

					boolean var33 = var17 >= var12 && var18 >= var13 && var17 < var14 && var18 < var15;
					if (var9.contentType == 1337) {
						if (!Client.isLoading && !Client.isMenuOpen && var33) {
							WorldMapRectangle.method385(var17, var18, var12, var13);
						}
					} else if (var9.contentType == 1338) {
						class3.method60(var9, var10, var11);
					} else {
						if (var9.contentType == 1400) {
							GrandExchangeOfferAgeComparator.worldMap.method6382(MouseHandler.MouseHandler_x, MouseHandler.MouseHandler_y, var33, var10, var11, var9.width, var9.height);
						}

						if (!Client.isMenuOpen && var33) {
							if (var9.contentType == 1400) {
								GrandExchangeOfferAgeComparator.worldMap.method6426(var10, var11, var9.width, var9.height, var17, var18);
							} else {
								WorldMapLabelSize.method288(var9, var17 - var10, var18 - var11);
							}
						}

						boolean var21;
						int var23;
						if (var32) {
							for (int var20 = 0; var20 < var9.field2555.length; ++var20) {
								var21 = false;
								boolean var22 = false;
								if (!var21 && var9.field2555[var20] != null) {
									for (var23 = 0; var23 < var9.field2555[var20].length; ++var23) {
										boolean var24 = false;
										if (var9.field2706 != null) {
											var24 = KeyHandler.KeyHandler_pressedKeys[var9.field2555[var20][var23]];
										}

										if (Messages.method2308(var9.field2555[var20][var23]) || var24) {
											var21 = true;
											if (var9.field2706 != null && var9.field2706[var20] > Client.cycle) {
												break;
											}

											byte var25 = var9.field2643[var20][var23];
											if (var25 == 0 || ((var25 & 8) == 0 || !KeyHandler.KeyHandler_pressedKeys[86] && !KeyHandler.KeyHandler_pressedKeys[82] && !KeyHandler.KeyHandler_pressedKeys[81]) && ((var25 & 2) == 0 || KeyHandler.KeyHandler_pressedKeys[86]) && ((var25 & 1) == 0 || KeyHandler.KeyHandler_pressedKeys[82]) && ((var25 & 4) == 0 || KeyHandler.KeyHandler_pressedKeys[81])) {
												var22 = true;
												break;
											}
										}
									}
								}

								if (var22) {
									if (var20 < 10) {
										ClientPacket.method3667(var20 + 1, var9.id, var9.childIndex, var9.itemId, "");
									} else if (var20 == 10) {
										GrandExchangeOffer.method210();
										WorldMapData_1.method815(var9.id, var9.childIndex, WorldMapRectangle.method388(ScriptEvent.method1283(var9)), var9.itemId);
										Client.selectedSpellActionName = PrivateChatMode.method5931(var9);
										if (Client.selectedSpellActionName == null) {
											Client.selectedSpellActionName = "null";
										}

										Client.selectedSpellName = var9.dataText + class297.method5314(16777215);
									}

									var23 = var9.field2644[var20];
									if (var9.field2706 == null) {
										var9.field2706 = new int[var9.field2555.length];
									}

									if (var9.field2695 == null) {
										var9.field2695 = new int[var9.field2555.length];
									}

									if (var23 != 0) {
										if (var9.field2706[var20] == 0) {
											var9.field2706[var20] = var23 + Client.cycle + var9.field2695[var20];
										} else {
											var9.field2706[var20] = var23 + Client.cycle;
										}
									} else {
										var9.field2706[var20] = Integer.MAX_VALUE;
									}
								}

								if (!var21 && var9.field2706 != null) {
									var9.field2706[var20] = 0;
								}
							}
						}

						if (var9.isIf3) {
							if (MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
								var33 = true;
							} else {
								var33 = false;
							}

							boolean var34 = false;
							if ((MouseHandler.MouseHandler_currentButton == 1 || !class217.mouseCam && MouseHandler.MouseHandler_currentButton == 4) && var33) {
								var34 = true;
							}

							var21 = false;
							if ((MouseHandler.MouseHandler_lastButton == 1 || !class217.mouseCam && MouseHandler.MouseHandler_lastButton == 4) && MouseHandler.MouseHandler_lastPressedX >= var12 && MouseHandler.MouseHandler_lastPressedY >= var13 && MouseHandler.MouseHandler_lastPressedX < var14 && MouseHandler.MouseHandler_lastPressedY < var15) {
								var21 = true;
							}

							if (var21) {
								Player.method1380(var9, MouseHandler.MouseHandler_lastPressedX - var10, MouseHandler.MouseHandler_lastPressedY - var11);
							}

							if (var9.contentType == 1400) {
								GrandExchangeOfferAgeComparator.worldMap.method6383(var17, var18, var33 & var34, var33 & var21);
							}

							if (Client.clickedWidget != null && var9 != Client.clickedWidget && var33 && GrandExchangeOfferUnitPriceComparator.method218(ScriptEvent.method1283(var9))) {
								Client.draggedOnWidget = var9;
							}

							if (var9 == Client.clickedWidgetParent) {
								Client.field732 = true;
								Client.field859 = var10;
								Client.field881 = var11;
							}

							if (var9.hasListener) {
								ScriptEvent var27;
								if (var33 && Client.mouseWheelRotation != 0 && var9.onScroll != null) {
									var27 = new ScriptEvent();
									var27.isMouseInputEvent = true;
									var27.widget = var9;
									var27.mouseY = Client.mouseWheelRotation;
									var27.args = var9.onScroll;
									Client.scriptEvents.method4952(var27);
								}

								if (Client.clickedWidget != null || class236.dragInventoryWidget != null || Client.isMenuOpen) {
									var21 = false;
									var34 = false;
									var33 = false;
								}

								if (!var9.isClicked && var21) {
									var9.isClicked = true;
									if (var9.onClick != null) {
										var27 = new ScriptEvent();
										var27.isMouseInputEvent = true;
										var27.widget = var9;
										var27.mouseX = MouseHandler.MouseHandler_lastPressedX - var10;
										var27.mouseY = MouseHandler.MouseHandler_lastPressedY - var11;
										var27.args = var9.onClick;
										Client.scriptEvents.method4952(var27);
									}
								}

								if (var9.isClicked && var34 && var9.onClickRepeat != null) {
									var27 = new ScriptEvent();
									var27.isMouseInputEvent = true;
									var27.widget = var9;
									var27.mouseX = MouseHandler.MouseHandler_x - var10;
									var27.mouseY = MouseHandler.MouseHandler_y - var11;
									var27.args = var9.onClickRepeat;
									Client.scriptEvents.method4952(var27);
								}

								if (var9.isClicked && !var34) {
									var9.isClicked = false;
									if (var9.onRelease != null) {
										var27 = new ScriptEvent();
										var27.isMouseInputEvent = true;
										var27.widget = var9;
										var27.mouseX = MouseHandler.MouseHandler_x - var10;
										var27.mouseY = MouseHandler.MouseHandler_y - var11;
										var27.args = var9.onRelease;
										Client.field919.method4952(var27);
									}
								}

								if (var34 && var9.onHold != null) {
									var27 = new ScriptEvent();
									var27.isMouseInputEvent = true;
									var27.widget = var9;
									var27.mouseX = MouseHandler.MouseHandler_x - var10;
									var27.mouseY = MouseHandler.MouseHandler_y - var11;
									var27.args = var9.onHold;
									Client.scriptEvents.method4952(var27);
								}

								if (!var9.containsMouse && var33) {
									var9.containsMouse = true;
									if (var9.onMouseOver != null) {
										var27 = new ScriptEvent();
										var27.isMouseInputEvent = true;
										var27.widget = var9;
										var27.mouseX = MouseHandler.MouseHandler_x - var10;
										var27.mouseY = MouseHandler.MouseHandler_y - var11;
										var27.args = var9.onMouseOver;
										Client.scriptEvents.method4952(var27);
									}
								}

								if (var9.containsMouse && var33 && var9.onMouseRepeat != null) {
									var27 = new ScriptEvent();
									var27.isMouseInputEvent = true;
									var27.widget = var9;
									var27.mouseX = MouseHandler.MouseHandler_x - var10;
									var27.mouseY = MouseHandler.MouseHandler_y - var11;
									var27.args = var9.onMouseRepeat;
									Client.scriptEvents.method4952(var27);
								}

								if (var9.containsMouse && !var33) {
									var9.containsMouse = false;
									if (var9.onMouseLeave != null) {
										var27 = new ScriptEvent();
										var27.isMouseInputEvent = true;
										var27.widget = var9;
										var27.mouseX = MouseHandler.MouseHandler_x - var10;
										var27.mouseY = MouseHandler.MouseHandler_y - var11;
										var27.args = var9.onMouseLeave;
										Client.field919.method4952(var27);
									}
								}

								if (var9.onTimer != null) {
									var27 = new ScriptEvent();
									var27.widget = var9;
									var27.args = var9.onTimer;
									Client.field727.method4952(var27);
								}

								ScriptEvent var30;
								int var35;
								int var36;
								if (var9.onVarTransmit != null && Client.field772 > var9.field2701) {
									if (var9.varTransmitTriggers != null && Client.field772 - var9.field2701 <= 32) {
										label887:
										for (var35 = var9.field2701; var35 < Client.field772; ++var35) {
											var23 = Client.field866[var35 & 31];

											for (var36 = 0; var36 < var9.varTransmitTriggers.length; ++var36) {
												if (var23 == var9.varTransmitTriggers[var36]) {
													var30 = new ScriptEvent();
													var30.widget = var9;
													var30.args = var9.onVarTransmit;
													Client.scriptEvents.method4952(var30);
													break label887;
												}
											}
										}
									} else {
										var27 = new ScriptEvent();
										var27.widget = var9;
										var27.args = var9.onVarTransmit;
										Client.scriptEvents.method4952(var27);
									}

									var9.field2701 = Client.field772;
								}

								if (var9.onInvTransmit != null && Client.field869 > var9.field2620) {
									if (var9.invTransmitTriggers != null && Client.field869 - var9.field2620 <= 32) {
										label863:
										for (var35 = var9.field2620; var35 < Client.field869; ++var35) {
											var23 = Client.changedItemContainers[var35 & 31];

											for (var36 = 0; var36 < var9.invTransmitTriggers.length; ++var36) {
												if (var23 == var9.invTransmitTriggers[var36]) {
													var30 = new ScriptEvent();
													var30.widget = var9;
													var30.args = var9.onInvTransmit;
													Client.scriptEvents.method4952(var30);
													break label863;
												}
											}
										}
									} else {
										var27 = new ScriptEvent();
										var27.widget = var9;
										var27.args = var9.onInvTransmit;
										Client.scriptEvents.method4952(var27);
									}

									var9.field2620 = Client.field869;
								}

								if (var9.onStatTransmit != null && Client.changedSkillsCount > var9.field2588) {
									if (var9.statTransmitTriggers != null && Client.changedSkillsCount - var9.field2588 <= 32) {
										label839:
										for (var35 = var9.field2588; var35 < Client.changedSkillsCount; ++var35) {
											var23 = Client.changedSkills[var35 & 31];

											for (var36 = 0; var36 < var9.statTransmitTriggers.length; ++var36) {
												if (var23 == var9.statTransmitTriggers[var36]) {
													var30 = new ScriptEvent();
													var30.widget = var9;
													var30.args = var9.onStatTransmit;
													Client.scriptEvents.method4952(var30);
													break label839;
												}
											}
										}
									} else {
										var27 = new ScriptEvent();
										var27.widget = var9;
										var27.args = var9.onStatTransmit;
										Client.scriptEvents.method4952(var27);
									}

									var9.field2588 = Client.changedSkillsCount;
								}

								if (Client.chatCycle > var9.field2700 && var9.onChatTransmit != null) {
									var27 = new ScriptEvent();
									var27.widget = var9;
									var27.args = var9.onChatTransmit;
									Client.scriptEvents.method4952(var27);
								}

								if (Client.field873 > var9.field2700 && var9.onFriendTransmit != null) {
									var27 = new ScriptEvent();
									var27.widget = var9;
									var27.args = var9.onFriendTransmit;
									Client.scriptEvents.method4952(var27);
								}

								if (Client.field874 > var9.field2700 && var9.onClanTransmit != null) {
									var27 = new ScriptEvent();
									var27.widget = var9;
									var27.args = var9.onClanTransmit;
									Client.scriptEvents.method4952(var27);
								}

								if (Client.field774 > var9.field2700 && var9.onStockTransmit != null) {
									var27 = new ScriptEvent();
									var27.widget = var9;
									var27.args = var9.onStockTransmit;
									Client.scriptEvents.method4952(var27);
								}

								if (Client.field726 > var9.field2700 && var9.field2691 != null) {
									var27 = new ScriptEvent();
									var27.widget = var9;
									var27.args = var9.field2691;
									Client.scriptEvents.method4952(var27);
								}

								if (Client.field877 > var9.field2700 && var9.onMiscTransmit != null) {
									var27 = new ScriptEvent();
									var27.widget = var9;
									var27.args = var9.onMiscTransmit;
									Client.scriptEvents.method4952(var27);
								}

								var9.field2700 = Client.cycleCntr;
								if (var9.onKey != null) {
									for (var35 = 0; var35 < Client.field901; ++var35) {
										ScriptEvent var31 = new ScriptEvent();
										var31.widget = var9;
										var31.keyTyped = Client.field872[var35];
										var31.keyPressed = Client.field902[var35];
										var31.args = var9.onKey;
										Client.scriptEvents.method4952(var31);
									}
								}
							}
						}

						if (!var9.isIf3) {
							if (Client.clickedWidget != null || class236.dragInventoryWidget != null || Client.isMenuOpen) {
								continue;
							}

							if ((var9.mouseOverRedirect >= 0 || var9.mouseOverColor != 0) && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
								if (var9.mouseOverRedirect >= 0) {
									class9.mousedOverWidgetIf1 = var0[var9.mouseOverRedirect];
								} else {
									class9.mousedOverWidgetIf1 = var9;
								}
							}

							if (var9.type == 8 && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
								Language.field2368 = var9;
							}

							if (var9.scrollHeight > var9.height) {
								ViewportMouse.method3078(var9, var10 + var9.width, var11, var9.height, var9.scrollHeight, MouseHandler.MouseHandler_x, MouseHandler.MouseHandler_y);
							}
						}

						if (var9.type == 0) {
							method4185(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
							if (var9.children != null) {
								method4185(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
							}

							InterfaceParent var28 = (InterfaceParent)Client.interfaceParents.method6010((long)var9.id);
							if (var28 != null) {
								if (var28.type == 0 && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15 && !Client.isMenuOpen) {
									for (ScriptEvent var29 = (ScriptEvent)Client.scriptEvents.method4931(); var29 != null; var29 = (ScriptEvent)Client.scriptEvents.method4949()) {
										if (var29.isMouseInputEvent) {
											var29.method3657();
											var29.widget.containsMouse = false;
										}
									}

									if (MilliClock.widgetDragDuration == 0) {
										Client.clickedWidget = null;
										Client.clickedWidgetParent = null;
									}

									if (!Client.isMenuOpen) {
										Tile.method2946();
									}
								}

								class2.method35(var28.group, var12, var13, var14, var15, var10, var11);
							}
						}
					}
				}
			}
		}

	}
}
