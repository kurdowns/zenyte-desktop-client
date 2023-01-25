package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSNPCDefinition;
import net.runelite.rs.api.RSWorldMapSection0;

@ObfuscatedName("ai")
public class WorldMapSection0 implements WorldMapSection, RSWorldMapSection0 {
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 713824535
	)
	int oldZ;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1876975141
	)
	int newZ;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1131302305
	)
	int oldX;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -676651519
	)
	int oldY;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1875954061
	)
	int newX;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -391734637
	)
	int newY;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 858906315
	)
	int oldChunkXLow;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 2112793997
	)
	int oldChunkYLow;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -902525679
	)
	int oldChunkXHigh;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 519445535
	)
	int oldChunkYHigh;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -2051517669
	)
	int newChunkXLow;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 878808507
	)
	int newChunkYLow;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 671796187
	)
	int newChunkXHigh;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -362726853
	)
	int newChunkYHigh;

	WorldMapSection0() {
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Las;I)V",
		garbageValue = "1890497148"
	)
	public void vmethod870(WorldMapArea var1) {
		if (var1.regionLowX > this.newX) {
			var1.regionLowX = this.newX;
		}

		if (var1.regionHighX < this.newX) {
			var1.regionHighX = this.newX;
		}

		if (var1.regionLowY > this.newY) {
			var1.regionLowY = this.newY;
		}

		if (var1.regionHighY < this.newY) {
			var1.regionHighY = this.newY;
		}

	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "-65934716"
	)
	public boolean vmethod871(int var1, int var2, int var3) {
		if (var1 >= this.oldZ && var1 < this.newZ + this.oldZ) {
			return var2 >= (this.oldX << 6) + (this.oldChunkXLow << 3) && var2 <= (this.oldX << 6) + (this.oldChunkXHigh << 3) + 7 && var3 >= (this.oldY << 6) + (this.oldChunkYLow << 3) && var3 <= (this.oldY << 6) + (this.oldChunkYHigh << 3) + 7;
		} else {
			return false;
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "-1383343929"
	)
	public boolean vmethod872(int var1, int var2) {
		return var1 >= (this.newX << 6) + (this.newChunkXLow << 3) && var1 <= (this.newX << 6) + (this.newChunkXHigh << 3) + 7 && var2 >= (this.newY << 6) + (this.newChunkYLow << 3) && var2 <= (this.newY << 6) + (this.newChunkYHigh << 3) + 7;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "1656767825"
	)
	public int[] vmethod873(int var1, int var2, int var3) {
		if (!this.vmethod871(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{this.newX * 64 - this.oldX * 64 + var2 + (this.newChunkXLow * 8 - this.oldChunkXLow * 8), var3 + (this.newY * 64 - this.oldY * 64) + (this.newChunkYLow * 8 - this.oldChunkYLow * 8)};
			return var4;
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(III)Lhj;",
		garbageValue = "-226825052"
	)
	public Coord vmethod890(int var1, int var2) {
		if (!this.vmethod872(var1, var2)) {
			return null;
		} else {
			int var3 = this.oldX * 64 - this.newX * 64 + (this.oldChunkXLow * 8 - this.newChunkXLow * 8) + var1;
			int var4 = this.oldY * 64 - this.newY * 64 + var2 + (this.oldChunkYLow * 8 - this.newChunkYLow * 8);
			return new Coord(this.oldZ, var3, var4);
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lkb;I)V",
		garbageValue = "-1393433755"
	)
	public void vmethod885(Buffer var1) {
		this.oldZ = var1.method5547();
		this.newZ = var1.method5547();
		this.oldX = var1.method5549();
		this.oldChunkXLow = var1.method5547();
		this.oldChunkXHigh = var1.method5547();
		this.oldY = var1.method5549();
		this.oldChunkYLow = var1.method5547();
		this.oldChunkYHigh = var1.method5547();
		this.newX = var1.method5549();
		this.newChunkXLow = var1.method5547();
		this.newChunkXHigh = var1.method5547();
		this.newY = var1.method5549();
		this.newChunkYLow = var1.method5547();
		this.newChunkYHigh = var1.method5547();
		this.method327();
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1832298319"
	)
	void method327() {
	}

	@ObfuscatedName("gi")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "-1795572864"
	)
	static final void method308(int var0, int var1, int var2) {
		if (var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
			int var3 = class277.method5013(var0, var1, ScriptEvent.Client_plane) - var2;
			var0 -= WorldMapRectangle.cameraX;
			var3 -= GrandExchangeOfferWorldComparator.cameraY;
			var1 -= class200.cameraZ;
			int var4 = Rasterizer3D.Rasterizer3D_sine[ApproximateRouteStrategy.cameraPitch];
			int var5 = Rasterizer3D.Rasterizer3D_cosine[ApproximateRouteStrategy.cameraPitch];
			int var6 = Rasterizer3D.Rasterizer3D_sine[WorldMapIcon_1.cameraYaw];
			int var7 = Rasterizer3D.Rasterizer3D_cosine[WorldMapIcon_1.cameraYaw];
			int var8 = var0 * var7 + var6 * var1 >> 16;
			var1 = var7 * var1 - var0 * var6 >> 16;
			var0 = var8;
			var8 = var5 * var3 - var4 * var1 >> 16;
			var1 = var5 * var1 + var4 * var3 >> 16;
			if (var1 >= 50) {
				Client.viewportTempX = var0 * Client.viewportZoom / var1 + Client.viewportWidth / 2;
				Client.viewportTempY = var8 * Client.viewportZoom / var1 + Client.viewportHeight / 2;
			} else {
				Client.viewportTempX = -1;
				Client.viewportTempY = -1;
			}

		} else {
			Client.viewportTempX = -1;
			Client.viewportTempY = -1;
		}
	}

	@ObfuscatedName("hm")
	@ObfuscatedSignature(
		signature = "(Lkj;I)V",
		garbageValue = "1398134743"
	)
	static final void method335(PacketBuffer var0) {
		for (int var1 = 0; var1 < Client.field851; ++var1) {
			int var2 = Client.field725[var1];
			NPC var3 = Client.npcs[var2];
			int var4 = var0.method5547();
			int var5;
			int var6;
			int var7;
			if ((var4 & 128) != 0) {
				var5 = var0.method5587();
				if (var5 == 65535) {
					var5 = -1;
				}

				var6 = var0.method5547();
				if (var5 == var3.sequence && var5 != -1) {
					var7 = SpotAnimationDefinition.method4478(var5).field3525;
					if (var7 == 1) {
						var3.sequenceFrame = 0;
						var3.sequenceFrameCycle = 0;
						var3.sequenceDelay = var6;
						var3.field1011 = 0;
					}

					if (var7 == 2) {
						var3.field1011 = 0;
					}
				} else if (var5 == -1 || var3.sequence == -1 || SpotAnimationDefinition.method4478(var5).field3519 >= SpotAnimationDefinition.method4478(var3.sequence).field3519) {
					var3.sequence = var5;
					var3.animationChanged(-1);
					var3.sequenceFrame = 0;
					var3.sequenceFrameCycle = 0;
					var3.sequenceDelay = var6;
					var3.field1011 = 0;
					var3.field1032 = var3.pathLength;
				}
			}

			int var8;
			if ((var4 & 16) != 0) {
				var5 = var0.method5586();
				var6 = var0.method5587();
				var7 = var3.x - (var5 - class69.baseX * 731242929 - class69.baseX * 731242929) * 64;
				var8 = var3.y - (var6 - class89.baseY * 1825982697 - class89.baseY * 1825982697) * 64;
				if (var7 != 0 || var8 != 0) {
					var3.field1015 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
				}
			}

			if ((var4 & 32) != 0) {
				NPCDefinition var10001 = class237.method4201(var0.method5587());
				var3.onDefinitionChanged((RSNPCDefinition)var10001);
				var3.definition = var10001;
				var3.field976 = var3.definition.size;
				var3.field1026 = var3.definition.rotation;
				var3.walkSequence = var3.definition.walkSequence;
				var3.walkBackSequence = var3.definition.walkBackSequence;
				var3.walkLeftSequence = var3.definition.walkLeftSequence;
				var3.walkRightSequence = var3.definition.walkRightSequence;
				var3.idleSequence = var3.definition.idleSequence;
				var3.turnLeftSequence = var3.definition.turnLeftSequence;
				var3.turnRightSequence = var3.definition.turnRightSequence;
			}

			if ((var4 & 8) != 0) {
				var3.targetIndex = var0.method5549();
				var3.interactingChanged(-1);
				if (var3.targetIndex == 65535) {
					var3.targetIndex = -1;
					var3.interactingChanged(-1);
				}
			}

			if ((var4 & 2) != 0) {
				var3.spotAnimation = var0.method5587();
				var3.spotAnimationChanged(-1);
				var5 = var0.method5594();
				var3.field1033 = var5 >> 16;
				var3.field1013 = (var5 & 65535) + Client.cycle;
				var3.spotAnimationFrame = 0;
				var3.spotAnimationFrameCycle = 0;
				if (var3.field1013 > Client.cycle) {
					var3.spotAnimationFrame = -1;
				}

				if (var3.spotAnimation == 65535) {
					var3.spotAnimation = -1;
					var3.spotAnimationChanged(-1);
				}
			}

			if ((var4 & 64) != 0) {
				var3.overheadText = var0.method5667();
				var3.overheadTextChanged(-1);
				var3.overheadTextCyclesRemaining = 100;
			}

			if ((var4 & 1) != 0) {
				var5 = var0.method5578();
				int var9;
				int var10;
				int var11;
				if (var5 > 0) {
					for (var6 = 0; var6 < var5; ++var6) {
						var8 = -1;
						var9 = -1;
						var10 = -1;
						var7 = var0.method5561();
						if (var7 == 32767) {
							var7 = var0.method5561();
							var9 = var0.method5561();
							var8 = var0.method5561();
							var10 = var0.method5561();
						} else if (var7 != 32766) {
							var9 = var0.method5561();
						} else {
							var7 = -1;
						}

						var11 = var0.method5561();
						var3.method1845(var7, var9, var8, var10, Client.cycle, var11);
					}
				}

				var6 = var0.method5577();
				if (var6 > 0) {
					for (var7 = 0; var7 < var6; ++var7) {
						var8 = var0.method5561();
						var9 = var0.method5561();
						if (var9 != 32767) {
							var10 = var0.method5561();
							var11 = var0.method5577();
							int var12 = var9 > 0 ? var0.method5578() : var11;
							var3.method1831(var8, Client.cycle, var9, var10, var11, var12);
						} else {
							var3.method1832(var8);
						}
					}
				}
			}

			if ((var4 & 4) != 0) {
				var3.field990 = var0.method5580();
				var3.field1017 = var0.method5581();
				var3.field972 = var0.method5579();
				var3.field1018 = var0.method5548();
				var3.field1019 = var0.method5537() + Client.cycle;
				var3.field1020 = var0.method5586() + Client.cycle;
				var3.field1021 = var0.method5549();
				var3.pathLength = 1;
				var3.field1032 = 0;
				var3.field990 += var3.pathX[0];
				var3.field1017 += var3.pathY[0];
				var3.field972 += var3.pathX[0];
				var3.field1018 += var3.pathY[0];
			}
		}

	}
}
