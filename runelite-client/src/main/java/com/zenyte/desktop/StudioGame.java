package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSStudioGame;

@ObfuscatedName("iv")
public class StudioGame implements Enumerated, RSStudioGame {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Liv;"
	)
	public static final StudioGame runescape;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Liv;"
	)
	public static final StudioGame stellardawn;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Liv;"
	)
	public static final StudioGame game3;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Liv;"
	)
	public static final StudioGame game4;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Liv;"
	)
	public static final StudioGame game5;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Liv;"
	)
	public static final StudioGame oldscape;
	@ObfuscatedName("q")
	public final String name;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 2013565785
	)
	final int id;

	static {
		runescape = new StudioGame("runescape", "RuneScape", 0);
		stellardawn = new StudioGame("stellardawn", "Stellar Dawn", 1);
		game3 = new StudioGame("game3", "Game 3", 2);
		game4 = new StudioGame("game4", "Game 4", 3);
		game5 = new StudioGame("game5", "Game 5", 4);
		oldscape = new StudioGame("oldscape", "RuneScape 2007", 5);
	}

	StudioGame(String var1, String var2, int var3) {
		this.name = var1;
		this.id = var3;
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
		signature = "([BB)Ljava/lang/String;",
		garbageValue = "-100"
	)
	public static String method4218(byte[] var0) {
		int var2 = var0.length;
		StringBuilder var3 = new StringBuilder();

		for (int var4 = 0; var4 < var2 + 0; var4 += 3) {
			int var5 = var0[var4] & 255;
			var3.append(class299.field3646[var5 >>> 2]);
			if (var4 < var2 - 1) {
				int var6 = var0[var4 + 1] & 255;
				var3.append(class299.field3646[(var5 & 3) << 4 | var6 >>> 4]);
				if (var4 < var2 - 2) {
					int var7 = var0[var4 + 2] & 255;
					var3.append(class299.field3646[(var6 & 15) << 2 | var7 >>> 6]).append(class299.field3646[var7 & 63]);
				} else {
					var3.append(class299.field3646[(var6 & 15) << 2]).append("=");
				}
			} else {
				var3.append(class299.field3646[(var5 & 3) << 4]).append("==");
			}
		}

		String var1 = var3.toString();
		return var1;
	}

	@ObfuscatedName("fh")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1083978305"
	)
	static void method4219(int var0) {
		if (var0 == -1 && !Client.field915) {
			Client.method1494();
		} else if (var0 != -1 && var0 != Client.currentTrackGroupId && Client.musicVolume != 0 && !Client.field915) {
			FaceNormal.method3364(2, AbstractWorldMapIcon.archive6, var0, 0, Client.musicVolume, false);
		}

		Client.currentTrackGroupId = var0;
	}

	@ObfuscatedName("io")
	@ObfuscatedSignature(
		signature = "([Lhe;IIIIIIIIB)V",
		garbageValue = "19"
	)
	static final void method4213(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		Client.renderWidgetLayer(var0, var1, var2, var3, var4, var5, var6, var7, var8);
		Rasterizer2D.method6045(var2, var3, var4, var5);
		Rasterizer3D.method3133();

		for (int var9 = 0; var9 < var0.length; ++var9) {
			Widget var10 = var0[var9];
			if (var10 != null && (var10.parentId == var1 || var1 == -1412584499 && var10 == Client.clickedWidget)) {
				int var11;
				if (var8 == -1) {
					Client.rootWidgetXs[Client.rootWidgetCount] = var10.x + var6;
					Client.rootWidgetYs[Client.rootWidgetCount] = var7 + var10.y;
					Client.rootWidgetWidths[Client.rootWidgetCount] = var10.width;
					Client.rootWidgetHeights[Client.rootWidgetCount] = var10.height;
					var11 = ++Client.rootWidgetCount - 1;
				} else {
					var11 = var8;
				}

				var10.rootIndex = var11;
				var10.cycle = Client.cycle;
				if (!var10.isIf3 || !AbstractWorldMapData.method356(var10)) {
					if (var10.contentType > 0) {
						UserComparator5.method3507(var10);
					}

					int var12 = var10.x + var6;
					int var13 = var7 + var10.y;
					int var14 = var10.transparencyTop;
					int var15;
					int var16;
					if (var10 == Client.clickedWidget) {
						if (var1 != -1412584499 && !var10.isScrollBar) {
							GrandExchangeEvents.field70 = var0;
							WorldMapDecoration.field245 = var6;
							SequenceDefinition.field3526 = var7;
							continue;
						}

						if (Client.isDraggingWidget && Client.field732) {
							var15 = MouseHandler.MouseHandler_x;
							var16 = MouseHandler.MouseHandler_y;
							var15 -= Client.widgetClickX;
							var16 -= Client.widgetClickY;
							if (var15 < Client.field859) {
								var15 = Client.field859;
							}

							if (var15 + var10.width > Client.field859 + Client.clickedWidgetParent.width) {
								var15 = Client.field859 + Client.clickedWidgetParent.width - var10.width;
							}

							if (var16 < Client.field881) {
								var16 = Client.field881;
							}

							if (var16 + var10.height > Client.field881 + Client.clickedWidgetParent.height) {
								var16 = Client.field881 + Client.clickedWidgetParent.height - var10.height;
							}

							var12 = var15;
							var13 = var16;
						}

						if (!var10.isScrollBar) {
							var14 = 128;
						}
					}

					int var17;
					int var18;
					int var19;
					int var20;
					int var21;
					int var22;
					if (var10.type == 2) {
						var15 = var2;
						var16 = var3;
						var17 = var4;
						var18 = var5;
					} else if (var10.type == 9) {
						var19 = var12;
						var20 = var13;
						var21 = var12 + var10.width;
						var22 = var13 + var10.height;
						if (var21 < var12) {
							var19 = var21;
							var21 = var12;
						}

						if (var22 < var13) {
							var20 = var22;
							var22 = var13;
						}

						++var21;
						++var22;
						var15 = var19 > var2 ? var19 : var2;
						var16 = var20 > var3 ? var20 : var3;
						var17 = var21 < var4 ? var21 : var4;
						var18 = var22 < var5 ? var22 : var5;
					} else {
						var19 = var12 + var10.width;
						var20 = var13 + var10.height;
						var15 = var12 > var2 ? var12 : var2;
						var16 = var13 > var3 ? var13 : var3;
						var17 = var19 < var4 ? var19 : var4;
						var18 = var20 < var5 ? var20 : var5;
					}

					if (!var10.isIf3 || var15 < var17 && var16 < var18) {
						if (var10.contentType != 0) {
							if (var10.contentType == 1336) {
								if (Client.displayFps) {
									var13 += 15;
									WorldMapData_0.fontPlain12.method5391("Fps:" + GameShell.fps, var12 + var10.width, var13, 16776960, -1);
									var13 += 15;
									Runtime var41 = Runtime.getRuntime();
									var20 = (int)((var41.totalMemory() - var41.freeMemory()) / 1024L);
									var21 = 16776960;
									if (var20 > 327680 && !Client.isLowDetail) {
										var21 = 16711680;
									}

									WorldMapData_0.fontPlain12.method5391("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
									var13 += 15;
								}
								continue;
							}

							if (var10.contentType == 1337) {
								Client.viewportX = var12;
								Client.viewportY = var13;
								Coord.method4061(var12, var13, var10.width, var10.height);
								Client.field679[var10.rootIndex] = true;
								Rasterizer2D.method6045(var2, var3, var4, var5);
								continue;
							}

							if (var10.contentType == 1338) {
								ArchiveLoader.method1256(var10, var12, var13, var11);
								Rasterizer2D.method6045(var2, var3, var4, var5);
								continue;
							}

							if (var10.contentType == 1339) {
								AbstractSocket.method5851(var10, var12, var13, var11);
								Rasterizer2D.method6045(var2, var3, var4, var5);
								continue;
							}

							if (var10.contentType == 1400) {
								GrandExchangeOfferAgeComparator.worldMap.method6432(var12, var13, var10.width, var10.height, Client.cycle);
							}

							if (var10.contentType == 1401) {
								GrandExchangeOfferAgeComparator.worldMap.method6401(var12, var13, var10.width, var10.height);
							}

							if (var10.contentType == 1402) {
								MilliClock.loginScreenRunesAnimation.method1918(var12, Client.cycle, (byte)53);
							}
						}

						if (var10.type == 0) {
							if (!var10.isIf3 && AbstractWorldMapData.method356(var10) && var10 != class9.mousedOverWidgetIf1) {
								continue;
							}

							if (!var10.isIf3) {
								if (var10.scrollY > var10.scrollHeight - var10.height) {
									var10.scrollY = var10.scrollHeight - var10.height;
								}

								if (var10.scrollY < 0) {
									var10.scrollY = 0;
								}
							}

							method4213(var0, var10.id, var15, var16, var17, var18, var12 - var10.scrollX, var13 - var10.scrollY, var11);
							if (var10.children != null) {
								method4213(var10.children, var10.id, var15, var16, var17, var18, var12 - var10.scrollX, var13 - var10.scrollY, var11);
							}

							InterfaceParent var30 = (InterfaceParent)Client.interfaceParents.method6010((long)var10.id);
							if (var30 != null) {
								MusicPatch.method3957(var30.group, var15, var16, var17, var18, var12, var13, var11);
							}

							Rasterizer2D.method6045(var2, var3, var4, var5);
							Rasterizer3D.method3133();
						}

						if (Client.isResizable || Client.field813[var11] || Client.gameDrawingMode > 1) {
							if (var10.type == 0 && !var10.isIf3 && var10.scrollHeight > var10.height) {
								FontName.method5354(var12 + var10.width, var13, var10.scrollY, var10.height, var10.scrollHeight);
							}

							if (var10.type != 1) {
								int var23;
								int var24;
								int var25;
								int var26;
								if (var10.type == 2) {
									var19 = 0;

									for (var20 = 0; var20 < var10.rawHeight; ++var20) {
										for (var21 = 0; var21 < var10.rawWidth; ++var21) {
											var22 = var21 * (var10.paddingX + 32) + var12;
											var23 = var13 + var20 * (var10.paddingY + 32);
											if (var19 < 20) {
												var22 += var10.inventoryXOffsets[var19];
												var23 += var10.inventoryYOffsets[var19];
											}

											if (var10.itemIds[var19] <= 0) {
												if (var10.inventorySprites != null && var19 < 20) {
													Sprite var43 = var10.method4116(var19);
													if (var43 != null) {
														var43.method6187(var22, var23);
													} else if (Widget.field2565) {
														ItemContainer.method1273(var10);
													}
												}
											} else {
												boolean var37 = false;
												boolean var38 = false;
												var26 = var10.itemIds[var19] - 1;
												if (var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == class236.dragInventoryWidget && var19 == Client.dragItemSlotSource) {
													Sprite var27;
													if (Client.isItemSelected == 1 && var19 == Client.selectedItemSlot && var10.id == WorldMapSection2.selectedItemWidget) {
														var27 = SecureRandomFuture.method2213(var26, var10.itemQuantities[var19], 2, 0, 2, false);
													} else {
														var27 = SecureRandomFuture.method2213(var26, var10.itemQuantities[var19], 1, 3153952, 2, false);
													}

													if (var27 != null) {
														if (var10 == class236.dragInventoryWidget && var19 == Client.dragItemSlotSource) {
															var24 = MouseHandler.MouseHandler_x - Client.draggedWidgetX;
															var25 = MouseHandler.MouseHandler_y - Client.draggedWidgetY;
															if (var24 < 5 && var24 > -5) {
																var24 = 0;
															}

															if (var25 < 5 && var25 > -5) {
																var25 = 0;
															}

															if (Client.itemDragDuration < 5) {
																var24 = 0;
																var25 = 0;
															}

															var27.method6193(var24 + var22, var23 + var25, 128);
															if (var1 != -1) {
																Widget var28 = var0[var1 & 65535];
																int var29;
																if (var25 + var23 < Rasterizer2D.Rasterizer2D_yClipStart && var28.scrollY > 0) {
																	var29 = (Rasterizer2D.Rasterizer2D_yClipStart - var23 - var25) * Client.field741 / 3;
																	if (var29 > Client.field741 * 10) {
																		var29 = Client.field741 * 10;
																	}

																	if (var29 > var28.scrollY) {
																		var29 = var28.scrollY;
																	}

																	var28.scrollY -= var29;
																	Client.draggedWidgetY += var29;
																	ItemContainer.method1273(var28);
																}

																if (var23 + var25 + 32 > Rasterizer2D.Rasterizer2D_yClipEnd && var28.scrollY < var28.scrollHeight - var28.height) {
																	var29 = (var23 + var25 + 32 - Rasterizer2D.Rasterizer2D_yClipEnd) * Client.field741 / 3;
																	if (var29 > Client.field741 * 10) {
																		var29 = Client.field741 * 10;
																	}

																	if (var29 > var28.scrollHeight - var28.height - var28.scrollY) {
																		var29 = var28.scrollHeight - var28.height - var28.scrollY;
																	}

																	var28.scrollY += var29;
																	Client.draggedWidgetY -= var29;
																	ItemContainer.method1273(var28);
																}
															}
														} else if (var10 == WorldMapID.field307 && var19 == Client.field880) {
															var27.method6193(var22, var23, 128);
														} else {
															var27.method6187(var22, var23);
														}
													} else {
														ItemContainer.method1273(var10);
													}
												}
											}

											++var19;
										}
									}
								} else if (var10.type == 3) {
									if (GrandExchangeOfferAgeComparator.method250(var10)) {
										var19 = var10.color2;
										if (var10 == class9.mousedOverWidgetIf1 && var10.mouseOverColor2 != 0) {
											var19 = var10.mouseOverColor2;
										}
									} else {
										var19 = var10.color;
										if (var10 == class9.mousedOverWidgetIf1 && var10.mouseOverColor != 0) {
											var19 = var10.mouseOverColor;
										}
									}

									if (var10.fill) {
										switch(var10.fillMode.field3873) {
										case 1:
											Rasterizer2D.method6053(var12, var13, var10.width, var10.height, var10.color, var10.color2);
											break;
										case 2:
											Rasterizer2D.method6077(var12, var13, var10.width, var10.height, var10.color, var10.color2, 255 - (var10.transparencyTop & 255), 255 - (var10.transparencyBot & 255));
											break;
										default:
											if (var14 == 0) {
												Rasterizer2D.method6052(var12, var13, var10.width, var10.height, var19);
											} else {
												Rasterizer2D.method6051(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
											}
										}
									} else if (var14 == 0) {
										Rasterizer2D.method6137(var12, var13, var10.width, var10.height, var19);
									} else {
										Rasterizer2D.method6056(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
									}
								} else {
									Font var39;
									if (var10.type == 4) {
										var39 = var10.method4121();
										if (var39 == null) {
											if (Widget.field2565) {
												ItemContainer.method1273(var10);
											}
										} else {
											String var45 = var10.text;
											if (GrandExchangeOfferAgeComparator.method250(var10)) {
												var20 = var10.color2;
												if (var10 == class9.mousedOverWidgetIf1 && var10.mouseOverColor2 != 0) {
													var20 = var10.mouseOverColor2;
												}

												if (var10.text2.length() > 0) {
													var45 = var10.text2;
												}
											} else {
												var20 = var10.color;
												if (var10 == class9.mousedOverWidgetIf1 && var10.mouseOverColor != 0) {
													var20 = var10.mouseOverColor;
												}
											}

											if (var10.isIf3 && var10.itemId != -1) {
												ItemDefinition var46 = AbstractWorldMapData.method373(var10.itemId);
												var45 = var46.name;
												if (var45 == null) {
													var45 = "null";
												}

												if ((var46.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
													var45 = class297.method5314(16748608) + var45 + "</col>" + " " + 'x' + UserComparator5.method3508(var10.itemQuantity);
												}
											}

											if (var10 == Client.meslayerContinueWidget) {
												var45 = "Please wait...";
												var20 = var10.color;
											}

											if (!var10.isIf3) {
												var45 = WallDecoration.method3389(var45, var10);
											}

											var39.method5397(var45, var12, var13, var10.width, var10.height, var20, var10.textShadowed ? 0 : -1, var10.textXAlignment, var10.textYAlignment, var10.textLineHeight);
										}
									} else if (var10.type == 5) {
										Sprite var40;
										if (!var10.isIf3) {
											var40 = var10.method4114(GrandExchangeOfferAgeComparator.method250(var10), (byte)-39);
											if (var40 != null) {
												var40.method6187(var12, var13);
											} else if (Widget.field2565) {
												ItemContainer.method1273(var10);
											}
										} else {
											if (var10.itemId != -1) {
												var40 = SecureRandomFuture.method2213(var10.itemId, var10.itemQuantity, var10.outline, var10.spriteShadow, var10.itemQuantityMode, false);
											} else {
												var40 = var10.method4114(false, (byte)-70);
											}

											if (var40 == null) {
												if (Widget.field2565) {
													ItemContainer.method1273(var10);
												}
											} else {
												var20 = var40.width;
												var21 = var40.height;
												if (!var10.spriteTiling) {
													var22 = var10.width * 4096 / var20;
													if (var10.spriteAngle != 0) {
														var40.method6247(var10.width / 2 + var12, var10.height / 2 + var13, var10.spriteAngle, var22);
													} else if (var14 != 0) {
														var40.method6195(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
													} else if (var20 == var10.width && var21 == var10.height) {
														var40.method6187(var12, var13);
													} else {
														var40.method6189(var12, var13, var10.width, var10.height);
													}
												} else {
													Rasterizer2D.method6066(var12, var13, var12 + var10.width, var13 + var10.height);
													var22 = (var20 - 1 + var10.width) / var20;
													var23 = (var21 - 1 + var10.height) / var21;

													for (var24 = 0; var24 < var22; ++var24) {
														for (var25 = 0; var25 < var23; ++var25) {
															if (var10.spriteAngle != 0) {
																var40.method6247(var20 / 2 + var12 + var20 * var24, var21 / 2 + var13 + var25 * var21, var10.spriteAngle, 4096);
															} else if (var14 != 0) {
																var40.method6193(var12 + var24 * var20, var13 + var25 * var21, 256 - (var14 & 255));
															} else {
																var40.method6187(var12 + var24 * var20, var13 + var21 * var25);
															}
														}
													}

													Rasterizer2D.method6045(var2, var3, var4, var5);
												}
											}
										}
									} else {
										ItemDefinition var34;
										if (var10.type == 6) {
											boolean var36 = GrandExchangeOfferAgeComparator.method250(var10);
											if (var36) {
												var20 = var10.sequenceId2;
											} else {
												var20 = var10.sequenceId;
											}

											Model var42 = null;
											var22 = 0;
											if (var10.itemId != -1) {
												var34 = AbstractWorldMapData.method373(var10.itemId);
												if (var34 != null) {
													var34 = var34.method4689(var10.itemQuantity);
													var42 = var34.method4696(1, (byte)-60);
													if (var42 != null) {
														var42.method2955();
														var22 = var42.height / 2;
													} else {
														ItemContainer.method1273(var10);
													}
												}
											} else if (var10.modelType == 5) {
												if (var10.modelId == 0) {
													var42 = Client.playerAppearance.method4069((SequenceDefinition)null, -1, (SequenceDefinition)null, -1);
												} else {
													var42 = ByteArrayPool.localPlayer.vmethod3353(480835067);
												}
											} else if (var20 == -1) {
												var42 = var10.method4117((SequenceDefinition)null, -1, var36, ByteArrayPool.localPlayer.appearance, (byte)73);
												if (var42 == null && Widget.field2565) {
													ItemContainer.method1273(var10);
												}
											} else {
												SequenceDefinition var47 = SpotAnimationDefinition.method4478(var20);
												var42 = var10.method4117(var47, var10.modelFrame, var36, ByteArrayPool.localPlayer.appearance, (byte)49);
												if (var42 == null && Widget.field2565) {
													ItemContainer.method1273(var10);
												}
											}

											Rasterizer3D.method3085(var10.width / 2 + var12, var10.height / 2 + var13);
											var23 = Rasterizer3D.Rasterizer3D_sine[var10.modelAngleX] * var10.modelZoom >> 16;
											var24 = Rasterizer3D.Rasterizer3D_cosine[var10.modelAngleX] * var10.modelZoom >> 16;
											if (var42 != null) {
												if (!var10.isIf3) {
													var42.method2968(0, var10.modelAngleY, 0, var10.modelAngleX, 0, var23, var24);
												} else {
													var42.method2955();
													if (var10.modelOrthog) {
														var42.method2999(0, var10.modelAngleY, var10.modelAngleZ, var10.modelAngleX, var10.modelOffsetX, var23 + var22 + var10.modelOffsetY, var24 + var10.modelOffsetY, var10.modelZoom);
													} else {
														var42.method2968(0, var10.modelAngleY, var10.modelAngleZ, var10.modelAngleX, var10.modelOffsetX, var22 + var23 + var10.modelOffsetY, var24 + var10.modelOffsetY);
													}
												}
											}

											Rasterizer3D.method3150();
										} else {
											if (var10.type == 7) {
												var39 = var10.method4121();
												if (var39 == null) {
													if (Widget.field2565) {
														ItemContainer.method1273(var10);
													}
													continue;
												}

												var20 = 0;

												for (var21 = 0; var21 < var10.rawHeight; ++var21) {
													for (var22 = 0; var22 < var10.rawWidth; ++var22) {
														if (var10.itemIds[var20] > 0) {
															var34 = AbstractWorldMapData.method373(var10.itemIds[var20] - 1);
															String var31;
															if (var34.isStackable != 1 && var10.itemQuantities[var20] == 1) {
																var31 = class297.method5314(16748608) + var34.name + "</col>";
															} else {
																var31 = class297.method5314(16748608) + var34.name + "</col>" + " " + 'x' + UserComparator5.method3508(var10.itemQuantities[var20]);
															}

															var25 = var22 * (var10.paddingX + 115) + var12;
															var26 = var21 * (var10.paddingY + 12) + var13;
															if (var10.textXAlignment == 0) {
																var39.method5389(var31, var25, var26, var10.color, var10.textShadowed ? 0 : -1);
															} else if (var10.textXAlignment == 1) {
																var39.method5392(var31, var10.width / 2 + var25, var26, var10.color, var10.textShadowed ? 0 : -1);
															} else {
																var39.method5391(var31, var25 + var10.width - 1, var26, var10.color, var10.textShadowed ? 0 : -1);
															}
														}

														++var20;
													}
												}
											}

											if (var10.type == 8 && var10 == Language.field2368 && Client.field832 == Client.field871) {
												var19 = 0;
												var20 = 0;
												Font var32 = WorldMapData_0.fontPlain12;
												String var33 = var10.text;

												String var44;
												for (var33 = WallDecoration.method3389(var33, var10); var33.length() > 0; var20 = var20 + var32.ascent + 1) {
													var24 = var33.indexOf("<br>");
													if (var24 != -1) {
														var44 = var33.substring(0, var24);
														var33 = var33.substring(var24 + 4);
													} else {
														var44 = var33;
														var33 = "";
													}

													var25 = var32.method5384(var44);
													if (var25 > var19) {
														var19 = var25;
													}
												}

												var19 += 6;
												var20 += 7;
												var24 = var12 + var10.width - 5 - var19;
												var25 = var13 + var10.height + 5;
												if (var24 < var12 + 5) {
													var24 = var12 + 5;
												}

												if (var24 + var19 > var4) {
													var24 = var4 - var19;
												}

												if (var20 + var25 > var5) {
													var25 = var5 - var20;
												}

												Rasterizer2D.method6052(var24, var25, var19, var20, 16777120);
												Rasterizer2D.method6137(var24, var25, var19, var20, 0);
												var33 = var10.text;
												var26 = var25 + var32.ascent + 2;

												for (var33 = WallDecoration.method3389(var33, var10); var33.length() > 0; var26 = var26 + var32.ascent + 1) {
													int var35 = var33.indexOf("<br>");
													if (var35 != -1) {
														var44 = var33.substring(0, var35);
														var33 = var33.substring(var35 + 4);
													} else {
														var44 = var33;
														var33 = "";
													}

													var32.method5389(var44, var24 + 3, var26, 0, -1);
												}
											}

											if (var10.type == 9) {
												if (var10.field2601) {
													var19 = var12;
													var20 = var13 + var10.height;
													var21 = var12 + var10.width;
													var22 = var13;
												} else {
													var19 = var12;
													var20 = var13;
													var21 = var12 + var10.width;
													var22 = var13 + var10.height;
												}

												if (var10.lineWid == 1) {
													Rasterizer2D.method6061(var19, var20, var21, var22, var10.color);
												} else {
													class60.method997(var19, var20, var21, var22, var10.color, var10.lineWid);
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
