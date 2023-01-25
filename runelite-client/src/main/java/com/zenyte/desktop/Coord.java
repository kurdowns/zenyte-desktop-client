package com.zenyte.desktop;

import net.runelite.client.callback.Hooks;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSCoord;

@ObfuscatedName("hj")
public class Coord implements RSCoord {
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 301187265
	)
	public static int field2530;
	@ObfuscatedName("cd")
	public static char field2531;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 762647407
	)
	public int y;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 660497933
	)
	public int plane;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1808182037
	)
	public int x;

	@ObfuscatedSignature(
		signature = "(Lhj;)V"
	)
	public Coord(Coord var1) {
		this.plane = var1.plane;
		this.x = var1.x;
		this.y = var1.y;
	}

	public Coord(int var1, int var2, int var3) {
		this.plane = var1;
		this.x = var2;
		this.y = var3;
	}

	public Coord(int var1) {
		if (var1 == -1) {
			this.plane = -1;
		} else {
			this.plane = var1 >> 28 & 3;
			this.x = var1 >> 14 & 16383;
			this.y = var1 & 16383;
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1927907066"
	)
	public int method4043() {
		return this.plane << 28 | this.x << 14 | this.y;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lhj;I)Z",
		garbageValue = "-2112462573"
	)
	boolean method4042(Coord var1) {
		if (this.plane != var1.plane) {
			return false;
		} else if (this.x != var1.x) {
			return false;
		} else {
			return this.y == var1.y;
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)Ljava/lang/String;",
		garbageValue = "404618696"
	)
	String method4047(String var1) {
		return this.plane + var1 + (this.x >> 6) + var1 + (this.y >> 6) + var1 + (this.x & 63) + var1 + (this.y & 63);
	}

	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else {
			return !(var1 instanceof Coord) ? false : this.method4042((Coord)var1);
		}
	}

	public String toString() {
		return this.method4047(",");
	}

	public String aab() {
		return this.method4047(",");
	}

	public String aau() {
		return this.method4047(",");
	}

	public String aak() {
		return this.method4047(",");
	}

	public int hashCode() {
		return this.method4043();
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(B)[Lie;",
		garbageValue = "112"
	)
	static VerticalAlignment[] method4060() {
		return new VerticalAlignment[]{VerticalAlignment.field3193, VerticalAlignment.VerticalAlignment_centered, VerticalAlignment.field3196};
	}

	@ObfuscatedName("gn")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "1911582516"
	)
	static final void method4061(int var0, int var1, int var2, int var3) {
		++Client.viewportDrawCount;
		if (ByteArrayPool.localPlayer.x >> 7 == Client.destinationX && ByteArrayPool.localPlayer.y >> 7 == Client.destinationY) {
			Client.destinationX = 0;
		}

		if (Client.renderSelf) {
			class22.method254(ByteArrayPool.localPlayer, false);
		}

		WorldMapCacheName.method716();
		Messages.method2315(true);
		int var4 = Players.Players_count;
		int[] var5 = Players.Players_indices;

		int var6;
		for (var6 = 0; var6 < var4; ++var6) {
			if (var5[var6] != Client.combatTargetPlayerIndex && var5[var6] != Client.localPlayerIndex) {
				class22.method254(Client.players[var5[var6]], true);
			}
		}

		Messages.method2315(false);

		for (Projectile var19 = (Projectile)Client.projectiles.method4931(); var19 != null; var19 = (Projectile)Client.projectiles.method4949()) {
			if (var19.plane == ScriptEvent.Client_plane && Client.cycle <= var19.cycleEnd) {
				if (Client.cycle >= var19.cycleStart) {
					if (var19.targetIndex > 0) {
						NPC var21 = Client.npcs[var19.targetIndex - 1];
						if (var21 != null && var21.x >= 0 && var21.x < 13312 && var21.y >= 0 && var21.y < 13312) {
							var19.method2196(var21.x, var21.y, class277.method5013(var21.x, var21.y, var19.plane) - var19.endHeight, Client.cycle);
						}
					}

					if (var19.targetIndex < 0) {
						var6 = -var19.targetIndex - 1;
						Player var22;
						if (var6 == Client.localPlayerIndex) {
							var22 = ByteArrayPool.localPlayer;
						} else {
							var22 = Client.players[var6];
						}

						if (var22 != null && var22.x >= 0 && var22.x < 13312 && var22.y >= 0 && var22.y < 13312) {
							var19.method2196(var22.x, var22.y, class277.method5013(var22.x, var22.y, var19.plane) - var19.endHeight, Client.cycle);
						}
					}

					var19.method2194(Client.field741);
					GrandExchangeOfferWorldComparator.scene.method3174(ScriptEvent.Client_plane, (int)var19.x, (int)var19.y, (int)var19.z, 60, var19, var19.yaw, -1L, false);
				}
			} else {
				var19.method3657();
			}
		}

		GrandExchangeOfferAgeComparator.method249();
		class204.method3751(var0, var1, var2, var3, true);
		var0 = Client.viewportOffsetX;
		var1 = Client.viewportOffsetY;
		var2 = Client.viewportWidth;
		var3 = Client.viewportHeight;
		Rasterizer2D.method6045(var0, var1, var0 + var2, var3 + var1);
		Rasterizer3D.method3133();
		int var7;
		int var8;
		int var9;
		int var10;
		int var11;
		int var12;
		int var20;
		if (!Client.isCameraLocked) {
			var4 = Client.camAngleX;
			if (Client.field941 / 256 > var4) {
				var4 = Client.field941 / 256;
			}

			if (Client.field926[4] && Client.field730[4] + 128 > var4) {
				var4 = Client.field730[4] + 128;
			}

			var20 = Client.camAngleY & 2047;
			var6 = SoundSystem.oculusOrbFocalPointX;
			var7 = Client.field756;
			var8 = ServerPacket.oculusOrbFocalPointY;
			var9 = var4 * 3 + 600;
			var10 = Varcs.method2281(var9, var3);
			var11 = 2048 - var4 & 2047;
			var12 = 2048 - var20 & 2047;
			int var13 = 0;
			int var14 = 0;
			int var15 = var10;
			int var16;
			int var17;
			int var18;
			if (var11 != 0) {
				var16 = Rasterizer3D.Rasterizer3D_sine[var11];
				var17 = Rasterizer3D.Rasterizer3D_cosine[var11];
				var18 = var14 * var17 - var16 * var10 >> 16;
				var15 = var16 * var14 + var10 * var17 >> 16;
				var14 = var18;
			}

			if (var12 != 0) {
				var16 = Rasterizer3D.Rasterizer3D_sine[var12];
				var17 = Rasterizer3D.Rasterizer3D_cosine[var12];
				var18 = var17 * var13 + var16 * var15 >> 16;
				var15 = var17 * var15 - var16 * var13 >> 16;
				var13 = var18;
			}

			WorldMapRectangle.cameraX = var6 - var13;
			GrandExchangeOfferWorldComparator.cameraY = var7 - var14;
			class200.cameraZ = var8 - var15;
			ApproximateRouteStrategy.cameraPitch = var4;
			Client.onCameraPitchChanged(-1);
			WorldMapIcon_1.cameraYaw = var20;
			if (Client.oculusOrbState == 1 && Client.staffModLevel >= 2 && Client.cycle % 50 == 0 && (SoundSystem.oculusOrbFocalPointX >> 7 != ByteArrayPool.localPlayer.x >> 7 || ServerPacket.oculusOrbFocalPointY >> 7 != ByteArrayPool.localPlayer.y >> 7)) {
				var16 = ByteArrayPool.localPlayer.plane;
				var17 = (SoundSystem.oculusOrbFocalPointX >> 7) + class69.baseX * 731242929;
				var18 = (ServerPacket.oculusOrbFocalPointY >> 7) + class89.baseY * 1825982697;
				GrandExchangeOfferWorldComparator.method148(var17, var18, var16, true);
			}
		}

		if (!Client.isCameraLocked) {
			var4 = UserComparator8.method3489();
		} else {
			var4 = Tiles.method1238();
		}

		var20 = WorldMapRectangle.cameraX;
		var6 = GrandExchangeOfferWorldComparator.cameraY;
		var7 = class200.cameraZ;
		var8 = ApproximateRouteStrategy.cameraPitch;
		var9 = WorldMapIcon_1.cameraYaw;

		for (var10 = 0; var10 < 5; ++var10) {
			if (Client.field926[var10]) {
				var11 = (int)(Math.random() * (double)(Client.field788[var10] * 2 + 1) - (double)Client.field788[var10] + Math.sin((double)Client.field929[var10] / 100.0D * (double)Client.field930[var10]) * (double)Client.field730[var10]);
				if (var10 == 0) {
					WorldMapRectangle.cameraX += var11;
				}

				if (var10 == 1) {
					GrandExchangeOfferWorldComparator.cameraY += var11;
				}

				if (var10 == 2) {
					class200.cameraZ += var11;
				}

				if (var10 == 3) {
					WorldMapIcon_1.cameraYaw = var11 + WorldMapIcon_1.cameraYaw & 2047;
				}

				if (var10 == 4) {
					ApproximateRouteStrategy.cameraPitch += var11;
					Client.onCameraPitchChanged(-1);
					if (ApproximateRouteStrategy.cameraPitch < 128) {
						ApproximateRouteStrategy.cameraPitch = 128;
						Client.onCameraPitchChanged(-1);
					}

					if (ApproximateRouteStrategy.cameraPitch > 383) {
						ApproximateRouteStrategy.cameraPitch = 383;
						Client.onCameraPitchChanged(-1);
					}
				}
			}
		}

		var10 = MouseHandler.MouseHandler_x;
		var11 = MouseHandler.MouseHandler_y;
		if (MouseHandler.MouseHandler_lastButton != 0) {
			var10 = MouseHandler.MouseHandler_lastPressedX;
			var11 = MouseHandler.MouseHandler_lastPressedY;
		}

		if (var10 >= var0 && var10 < var0 + var2 && var11 >= var1 && var11 < var3 + var1) {
			AbstractSocket.method5859(var10 - var0, var11 - var1);
		} else {
			GameShell.method1155();
		}

		ChatChannel.method2342();
		Hooks.clearColorBuffer(var0, var1, var2, var3, 0);
		ChatChannel.method2342();
		var12 = Rasterizer3D.Rasterizer3D_zoom;
		Rasterizer3D.Rasterizer3D_zoom = Client.viewportZoom;
		GrandExchangeOfferWorldComparator.scene.method3203(WorldMapRectangle.cameraX, GrandExchangeOfferWorldComparator.cameraY, class200.cameraZ, ApproximateRouteStrategy.cameraPitch, WorldMapIcon_1.cameraYaw, var4);
		Rasterizer3D.Rasterizer3D_zoom = var12;
		ChatChannel.method2342();
		GrandExchangeOfferWorldComparator.scene.method3177();
		MouseHandler.method1202(var0, var1, var2, var3);
		UserComparator4.method3476(var0, var1);
		((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).method2845(Client.field741);
		UserComparator5.method3509(var0, var1, var2, var3);
		WorldMapRectangle.cameraX = var20;
		GrandExchangeOfferWorldComparator.cameraY = var6;
		class200.cameraZ = var7;
		ApproximateRouteStrategy.cameraPitch = var8;
		Client.onCameraPitchChanged(-1);
		WorldMapIcon_1.cameraYaw = var9;
		if (Client.isLoading && WorldMapLabelSize.method292(true, false) == 0) {
			Client.isLoading = false;
		}

		if (Client.isLoading) {
			Hooks.clearColorBuffer(var0, var1, var2, var3, 0);
			AbstractByteArrayCopier.method4004("Loading - please wait.", false);
		}

	}
}
