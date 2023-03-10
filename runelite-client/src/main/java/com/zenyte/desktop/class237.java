package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ic")
public class class237 {
	static {
		Math.sqrt(8192.0D);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(II)Ljj;",
		garbageValue = "386633685"
	)
	public static NPCDefinition method4201(int var0) {
		NPCDefinition var1 = (NPCDefinition)NPCDefinition.NpcDefinition_cached.method3418((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = NPCDefinition.NpcDefinition_archive.method4224(9, var0, (byte)-120);
			var1 = new NPCDefinition();
			var1.id = var0;
			if (var2 != null) {
				var1.method4762(new Buffer(var2));
			}

			var1.method4765();
			NPCDefinition.NpcDefinition_cached.method3424(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("fd")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1434556827"
	)
	static void method4202() {
		int var0;
		if (Client.titleLoadingStage == 0) {
			GrandExchangeOfferWorldComparator.scene = new Scene(4, 104, 104, Tiles.Tiles_heights);

			for (var0 = 0; var0 < 4; ++var0) {
				Client.collisionMaps[var0] = new CollisionMap(104, 104);
			}

			ArchiveDisk.sceneMinimapSprite = new Sprite(512, 512);
			Login.Login_loadingText = "Starting game engine...";
			Login.Login_loadingPercent = 5;
			Client.titleLoadingStage = 20;
		} else if (Client.titleLoadingStage == 20) {
			Login.Login_loadingText = "Prepared visibility map";
			Login.Login_loadingPercent = 10;
			Client.titleLoadingStage = 30;
		} else if (Client.titleLoadingStage == 30) {
			ArchiveDiskAction.archive0 = ChatChannel.method2339(0, false, true, true);
			DirectByteArrayCopier.archive1 = ChatChannel.method2339(1, false, true, true);
			GrandExchangeOffer.archive2 = ChatChannel.method2339(2, true, false, true);
			WorldMapSprite.archive3 = ChatChannel.method2339(3, false, true, true);
			FontName.archive4 = ChatChannel.method2339(4, false, true, true);
			WorldMapIcon_0.archive5 = ChatChannel.method2339(5, true, true, true);
			AbstractWorldMapIcon.archive6 = ChatChannel.method2339(6, true, true, true);
			AbstractWorldMapIcon.archive7 = ChatChannel.method2339(7, false, true, true);
			class228.archive8 = ChatChannel.method2339(8, false, true, true);
			SecureRandomFuture.archive9 = ChatChannel.method2339(9, false, true, true);
			PlayerAppearance.archive10 = ChatChannel.method2339(10, false, true, true);
			WorldMapRegion.archive11 = ChatChannel.method2339(11, false, true, true);
			class41.archive12 = ChatChannel.method2339(12, false, true, true);
			NPC.archive13 = ChatChannel.method2339(13, true, false, true);
			class224.archive14 = ChatChannel.method2339(14, false, true, true);
			GrandExchangeOfferNameComparator.archive15 = ChatChannel.method2339(15, false, true, true);
			MenuAction.archive17 = ChatChannel.method2339(17, true, true, true);
			UserComparator9.archive18 = ChatChannel.method2339(18, false, true, true);
			class278.archive19 = ChatChannel.method2339(19, false, true, true);
			class25.archive20 = ChatChannel.method2339(20, false, true, true);
			Login.Login_loadingText = "Connecting to update server";
			Login.Login_loadingPercent = 20;
			Client.titleLoadingStage = 40;
		} else if (Client.titleLoadingStage == 40) {
			byte var31 = 0;
			var0 = var31 + ArchiveDiskAction.archive0.method4354() * 4 / 100;
			var0 += DirectByteArrayCopier.archive1.method4354() * 4 / 100;
			var0 += GrandExchangeOffer.archive2.method4354() * 2 / 100;
			var0 += WorldMapSprite.archive3.method4354() * 2 / 100;
			var0 += FontName.archive4.method4354() * 6 / 100;
			var0 += WorldMapIcon_0.archive5.method4354() * 4 / 100;
			var0 += AbstractWorldMapIcon.archive6.method4354() * 2 / 100;
			var0 += AbstractWorldMapIcon.archive7.method4354() * 56 / 100;
			var0 += class228.archive8.method4354() * 2 / 100;
			var0 += SecureRandomFuture.archive9.method4354() * 2 / 100;
			var0 += PlayerAppearance.archive10.method4354() * 2 / 100;
			var0 += WorldMapRegion.archive11.method4354() * 2 / 100;
			var0 += class41.archive12.method4354() * 2 / 100;
			var0 += NPC.archive13.method4354() * 2 / 100;
			var0 += class224.archive14.method4354() * 2 / 100;
			var0 += GrandExchangeOfferNameComparator.archive15.method4354() * 2 / 100;
			var0 += class278.archive19.method4354() / 100;
			var0 += UserComparator9.archive18.method4354() / 100;
			var0 += class25.archive20.method4354() / 100;
			var0 += MenuAction.archive17.method4319() && MenuAction.archive17.method4229() ? 1 : 0;
			if (var0 != 100) {
				if (var0 != 0) {
					Login.Login_loadingText = "Checking for updates - " + var0 + "%";
				}

				Login.Login_loadingPercent = 30;
			} else {
				GameObject.method3390(ArchiveDiskAction.archive0, "Animations");
				GameObject.method3390(DirectByteArrayCopier.archive1, "Skeletons");
				GameObject.method3390(FontName.archive4, "Sound FX");
				GameObject.method3390(WorldMapIcon_0.archive5, "Maps");
				GameObject.method3390(AbstractWorldMapIcon.archive6, "Music Tracks");
				GameObject.method3390(AbstractWorldMapIcon.archive7, "Models");
				GameObject.method3390(class228.archive8, "Sprites");
				GameObject.method3390(WorldMapRegion.archive11, "Music Jingles");
				GameObject.method3390(class224.archive14, "Music Samples");
				GameObject.method3390(GrandExchangeOfferNameComparator.archive15, "Music Patches");
				GameObject.method3390(class278.archive19, "World Map");
				GameObject.method3390(UserComparator9.archive18, "World Map Geography");
				GameObject.method3390(class25.archive20, "World Map Ground");
				class7.spriteIds = new GraphicsDefaults();
				class7.spriteIds.method5935(MenuAction.archive17);
				Login.Login_loadingText = "Loaded update list";
				Login.Login_loadingPercent = 30;
				Client.titleLoadingStage = 45;
			}
		} else {
			Archive var2;
			Archive var3;
			Archive var30;
			if (Client.titleLoadingStage == 45) {
				WorldMapEvent.method867(22050, !Client.isLowDetail, 2);
				MidiPcmStream var33 = new MidiPcmStream();
				var33.method3779(9, 128);
				WorldMapManager.pcmPlayer0 = Occluder.method3387(class227.taskHandler, 0, 22050);
				WorldMapManager.pcmPlayer0.method2521(var33);
				var30 = GrandExchangeOfferNameComparator.archive15;
				var2 = class224.archive14;
				var3 = FontName.archive4;
				class58.musicPatchesArchive = var30;
				class206.musicSamplesArchive = var2;
				class206.soundEffectsArchive = var3;
				class206.midiPcmStream = var33;
				AbstractWorldMapData.pcmPlayer1 = Occluder.method3387(class227.taskHandler, 1, 2048);
				Tiles.pcmStreamMixer = new PcmStreamMixer();
				AbstractWorldMapData.pcmPlayer1.method2521(Tiles.pcmStreamMixer);
				class25.decimator = new Decimator(22050, PcmPlayer.field1421);
				Login.Login_loadingText = "Prepared sound engine";
				Login.Login_loadingPercent = 35;
				Client.titleLoadingStage = 50;
				ItemContainer.WorldMapElement_fonts = new Fonts(class228.archive8, NPC.archive13);
			} else if (Client.titleLoadingStage == 50) {
				var0 = FontName.method5360().length;
				Client.fontsMap = ItemContainer.WorldMapElement_fonts.method5364(FontName.method5360());
				if (Client.fontsMap.size() < var0) {
					Login.Login_loadingText = "Loading fonts - " + Client.fontsMap.size() * 100 / var0 + "%";
					Login.Login_loadingPercent = 40;
				} else {
					class101.fontPlain11 = (Font)Client.fontsMap.get(FontName.FontName_plain11);
					WorldMapData_0.fontPlain12 = (Font)Client.fontsMap.get(FontName.FontName_plain12);
					TaskHandler.fontBold12 = (Font)Client.fontsMap.get(FontName.FontName_bold12);
					Varcs.platformInfo = Client.platformInfoProvider.vmethod6355();
					Login.Login_loadingText = "Loaded fonts";
					Login.Login_loadingPercent = 40;
					Client.titleLoadingStage = 60;
				}
			} else {
				int var26;
				if (Client.titleLoadingStage == 60) {
					var0 = class92.method2142(PlayerAppearance.archive10, class228.archive8);
					var26 = class7.method98();
					if (var0 < var26) {
						Login.Login_loadingText = "Loading title screen - " + var0 * 100 / var26 + "%";
						Login.Login_loadingPercent = 50;
					} else {
						Login.Login_loadingText = "Loaded title screen";
						Login.Login_loadingPercent = 50;
						MouseRecorder.method1293(5);
						Client.titleLoadingStage = 70;
					}
				} else if (Client.titleLoadingStage == 70) {
					if (!GrandExchangeOffer.archive2.method4229()) {
						Login.Login_loadingText = "Loading config - " + GrandExchangeOffer.archive2.method4350() + "%";
						Login.Login_loadingPercent = 60;
					} else {
						Archive var32 = GrandExchangeOffer.archive2;
						FloorOverlayDefinition.FloorOverlayDefinition_archive = var32;
						var30 = GrandExchangeOffer.archive2;
						FloorUnderlayDefinition.FloorUnderlayDefinition_archive = var30;
						Message.method1319(GrandExchangeOffer.archive2, AbstractWorldMapIcon.archive7);
						WorldMapLabelSize.method290(GrandExchangeOffer.archive2, AbstractWorldMapIcon.archive7, Client.isLowDetail);
						var2 = GrandExchangeOffer.archive2;
						var3 = AbstractWorldMapIcon.archive7;
						NPCDefinition.NpcDefinition_archive = var2;
						NPCDefinition.NpcDefinition_modelArchive = var3;
						KeyHandler.method940(GrandExchangeOffer.archive2);
						Archive var29 = GrandExchangeOffer.archive2;
						Archive var5 = AbstractWorldMapIcon.archive7;
						boolean var6 = Client.isMembersWorld;
						Font var7 = class101.fontPlain11;
						PrivateChatMode.ItemDefinition_archive = var29;
						GrandExchangeOffer.ItemDefinition_modelArchive = var5;
						class169.ItemDefinition_inMembersWorld = var6;
						class336.ItemDefinition_fileCount = PrivateChatMode.ItemDefinition_archive.method4246(10);
						WorldMapSection3.ItemDefinition_fontPlain11 = var7;
						Archive var8 = GrandExchangeOffer.archive2;
						Archive var9 = ArchiveDiskAction.archive0;
						Archive var10 = DirectByteArrayCopier.archive1;
						Varcs.SequenceDefinition_archive = var8;
						GZipDecompressor.SequenceDefinition_animationsArchive = var9;
						class92.SequenceDefinition_skeletonsArchive = var10;
						Archive var11 = GrandExchangeOffer.archive2;
						Archive var12 = AbstractWorldMapIcon.archive7;
						SpotAnimationDefinition.SpotAnimationDefinition_archive = var11;
						SpotAnimationDefinition.SpotAnimationDefinition_modelArchive = var12;
						Archive var13 = GrandExchangeOffer.archive2;
						VarbitDefinition.VarbitDefinition_archive = var13;
						Archive var14 = GrandExchangeOffer.archive2;
						VarpDefinition.VarpDefinition_archive = var14;
						VarpDefinition.VarpDefinition_fileCount = VarpDefinition.VarpDefinition_archive.method4246(16);
						World.method1894(WorldMapSprite.archive3, AbstractWorldMapIcon.archive7, class228.archive8, NPC.archive13);
						UserList.method5155(GrandExchangeOffer.archive2);
						MouseHandler.method1206(GrandExchangeOffer.archive2);
						Players.method2237(GrandExchangeOffer.archive2);
						Archive var15 = GrandExchangeOffer.archive2;
						ParamDefinition.ParamDefinition_archive = var15;
						UserComparator4.varcs = new Varcs();
						Archive var16 = GrandExchangeOffer.archive2;
						Archive var17 = class228.archive8;
						Archive var18 = NPC.archive13;
						HitSplatDefinition.HitSplatDefinition_archive = var16;
						HitSplatDefinition.field3322 = var17;
						class296.HitSplatDefinition_fontsArchive = var18;
						Archive var19 = GrandExchangeOffer.archive2;
						Archive var20 = class228.archive8;
						HealthBarDefinition.HealthBarDefinition_archive = var19;
						UserComparator1.HitSplatDefinition_spritesArchive = var20;
						Archive var21 = GrandExchangeOffer.archive2;
						Archive var22 = class228.archive8;
						WorldMapElement.WorldMapElement_archive = var22;
						if (var21.method4229()) {
							class277.WorldMapElement_count = var21.method4246(35);
							WorldMapElement.WorldMapElement_cached = new WorldMapElement[class277.WorldMapElement_count];

							for (int var23 = 0; var23 < class277.WorldMapElement_count; ++var23) {
								byte[] var24 = var21.method4224(35, var23, (byte)-30);
								WorldMapElement.WorldMapElement_cached[var23] = new WorldMapElement(var23);
								if (var24 != null) {
									WorldMapElement.WorldMapElement_cached[var23].method4448(new Buffer(var24));
									WorldMapElement.WorldMapElement_cached[var23].method4442();
								}
							}
						}

						Login.Login_loadingText = "Loaded config";
						Login.Login_loadingPercent = 60;
						Client.titleLoadingStage = 80;
					}
				} else if (Client.titleLoadingStage == 80) {
					var0 = 0;
					if (ChatChannel.compass == null) {
						ChatChannel.compass = MusicPatchNode2.method3752(class228.archive8, class7.spriteIds.compass, 0, 273345835);
					} else {
						++var0;
					}

					if (GrandExchangeOfferNameComparator.redHintArrowSprite == null) {
						GrandExchangeOfferNameComparator.redHintArrowSprite = MusicPatchNode2.method3752(class228.archive8, class7.spriteIds.field3824, 0, 273345835);
					} else {
						++var0;
					}

					IndexedSprite[] var1;
					int var27;
					if (class169.mapSceneSprites == null) {
						var2 = class228.archive8;
						var27 = class7.spriteIds.mapScenes;
						if (!UserComparator7.method3502(var2, var27, 0)) {
							var1 = null;
						} else {
							var1 = Skills.method4190();
						}

						class169.mapSceneSprites = var1;
					} else {
						++var0;
					}

					if (class52.headIconPkSprites == null) {
						class52.headIconPkSprites = ClientPacket.method3670(class228.archive8, class7.spriteIds.headIconsPk, 0);
					} else {
						++var0;
					}

					if (ReflectionCheck.headIconPrayerSprites == null) {
						ReflectionCheck.headIconPrayerSprites = ClientPacket.method3670(class228.archive8, class7.spriteIds.field3817, 0);
					} else {
						++var0;
					}

					if (class4.headIconHintSprites == null) {
						class4.headIconHintSprites = ClientPacket.method3670(class228.archive8, class7.spriteIds.field3818, 0);
					} else {
						++var0;
					}

					if (WorldMapAreaData.mapMarkerSprites == null) {
						WorldMapAreaData.mapMarkerSprites = ClientPacket.method3670(class228.archive8, class7.spriteIds.field3819, 0);
					} else {
						++var0;
					}

					if (class299.crossSprites == null) {
						class299.crossSprites = ClientPacket.method3670(class228.archive8, class7.spriteIds.field3820, 0);
					} else {
						++var0;
					}

					if (VarpDefinition.mapDotSprites == null) {
						VarpDefinition.mapDotSprites = ClientPacket.method3670(class228.archive8, class7.spriteIds.field3821, 0);
					} else {
						++var0;
					}

					if (class232.scrollBarSprites == null) {
						var2 = class228.archive8;
						var27 = class7.spriteIds.field3822;
						if (!UserComparator7.method3502(var2, var27, 0)) {
							var1 = null;
						} else {
							var1 = Skills.method4190();
						}

						class232.scrollBarSprites = var1;
					} else {
						++var0;
					}

					if (WorldMapID.modIconSprites == null) {
						var2 = class228.archive8;
						var27 = class7.spriteIds.field3823;
						if (!UserComparator7.method3502(var2, var27, 0)) {
							var1 = null;
						} else {
							var1 = Skills.method4190();
						}

						WorldMapID.modIconSprites = var1;
					} else {
						++var0;
					}

					if (var0 < 11) {
						Login.Login_loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
						Login.Login_loadingPercent = 70;
					} else {
						AbstractFont.AbstractFont_modIconSprites = WorldMapID.modIconSprites;
						GrandExchangeOfferNameComparator.redHintArrowSprite.method6180();
						var26 = (int)(Math.random() * 21.0D) - 10;
						int var28 = (int)(Math.random() * 21.0D) - 10;
						var27 = (int)(Math.random() * 21.0D) - 10;
						int var4 = (int)(Math.random() * 41.0D) - 20;
						class169.mapSceneSprites[0].method6158(var4 + var26, var4 + var28, var27 + var4);
						Login.Login_loadingText = "Loaded sprites";
						Login.Login_loadingPercent = 70;
						Client.titleLoadingStage = 90;
					}
				} else if (Client.titleLoadingStage == 90) {
					if (!SecureRandomFuture.archive9.method4229()) {
						Login.Login_loadingText = "Loading textures - " + "0%";
						Login.Login_loadingPercent = 90;
					} else {
						class41.textureProvider = new TextureProvider(SecureRandomFuture.archive9, class228.archive8, 20, 0.8D, Client.isLowDetail ? 64 : 128);
						Rasterizer3D.method3117(class41.textureProvider);
						Rasterizer3D.method3087(0.8D);
						Client.titleLoadingStage = 100;
					}
				} else if (Client.titleLoadingStage == 100) {
					var0 = class41.textureProvider.method2838();
					if (var0 < 100) {
						Login.Login_loadingText = "Loading textures - " + var0 + "%";
						Login.Login_loadingPercent = 90;
					} else {
						Login.Login_loadingText = "Loaded textures";
						Login.Login_loadingPercent = 90;
						Client.titleLoadingStage = 110;
					}
				} else if (Client.titleLoadingStage == 110) {
					MidiPcmStream.mouseRecorder = new MouseRecorder();
					class227.taskHandler.method3551(MidiPcmStream.mouseRecorder, 10);
					Login.Login_loadingText = "Loaded input handler";
					Login.Login_loadingPercent = 92;
					Client.titleLoadingStage = 120;
				} else if (Client.titleLoadingStage == 120) {
					if (!PlayerAppearance.archive10.method4241("huffman", "")) {
						Login.Login_loadingText = "Loading wordpack - " + 0 + "%";
						Login.Login_loadingPercent = 94;
					} else {
						Huffman var25 = new Huffman(PlayerAppearance.archive10.method4223("huffman", ""));
						class219.huffman = var25;
						Login.Login_loadingText = "Loaded wordpack";
						Login.Login_loadingPercent = 94;
						Client.titleLoadingStage = 130;
					}
				} else if (Client.titleLoadingStage == 130) {
					if (!WorldMapSprite.archive3.method4229()) {
						Login.Login_loadingText = "Loading interfaces - " + WorldMapSprite.archive3.method4350() * 4 / 5 + "%";
						Login.Login_loadingPercent = 96;
					} else if (!class41.archive12.method4229()) {
						Login.Login_loadingText = "Loading interfaces - " + (80 + class41.archive12.method4350() / 6) + "%";
						Login.Login_loadingPercent = 96;
					} else if (!NPC.archive13.method4229()) {
						Login.Login_loadingText = "Loading interfaces - " + (96 + NPC.archive13.method4350() / 50) + "%";
						Login.Login_loadingPercent = 96;
					} else {
						Login.Login_loadingText = "Loaded interfaces";
						Login.Login_loadingPercent = 98;
						Client.titleLoadingStage = 140;
					}
				} else if (Client.titleLoadingStage == 140) {
					Login.Login_loadingPercent = 100;
					if (!class278.archive19.method4245(WorldMapCacheName.field339.name)) {
						Login.Login_loadingText = "Loading world map - " + class278.archive19.method4261(WorldMapCacheName.field339.name) / 10 + "%";
					} else {
						if (GrandExchangeOfferAgeComparator.worldMap == null) {
							GrandExchangeOfferAgeComparator.worldMap = new WorldMap();
							GrandExchangeOfferAgeComparator.worldMap.method6380(class278.archive19, UserComparator9.archive18, class25.archive20, TaskHandler.fontBold12, Client.fontsMap, class169.mapSceneSprites);
						}

						Login.Login_loadingText = "Loaded world map";
						Client.titleLoadingStage = 150;
					}
				} else if (Client.titleLoadingStage == 150) {
					MouseRecorder.method1293(10);
				}
			}
		}
	}
}
