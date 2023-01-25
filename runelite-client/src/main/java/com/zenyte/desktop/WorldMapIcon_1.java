package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSWorldMapIcon_1;

@ObfuscatedName("af")
public class WorldMapIcon_1 extends AbstractWorldMapIcon implements RSWorldMapIcon_1 {
	@ObfuscatedName("he")
	@ObfuscatedGetter(
		intValue = -395695129
	)
	static int cameraYaw;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1547579339
	)
	final int objectDefId;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lao;"
	)
	final WorldMapRegion region;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1354598699
	)
	int element;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lau;"
	)
	WorldMapLabel label;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 152564965
	)
	int subWidth;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1072450563
	)
	int subHeight;

	@ObfuscatedSignature(
		signature = "(Lhj;Lhj;ILao;)V"
	)
	WorldMapIcon_1(Coord var1, Coord var2, int var3, WorldMapRegion var4) {
		super(var1, var2);
		this.objectDefId = var3;
		this.region = var4;
		this.method390();
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "69"
	)
	public int vmethod685() {
		return this.element;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)Lau;",
		garbageValue = "2077771117"
	)
	WorldMapLabel vmethod710() {
		return this.label;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "650401890"
	)
	int vmethod688() {
		return this.subWidth;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1828864081"
	)
	int vmethod693() {
		return this.subHeight;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "10774"
	)
	void method390() {
		this.element = WorldMapSection2.method435(this.objectDefId).method4645().mapIconId;
		this.label = this.region.method549(class25.method279(this.element));
		WorldMapElement var1 = class25.method279(this.vmethod685());
		Sprite var2 = var1.method4443(false);
		if (var2 != null) {
			this.subWidth = var2.subWidth;
			this.subHeight = var2.subHeight;
		} else {
			this.subWidth = 0;
			this.subHeight = 0;
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "39"
	)
	public static int method407(int var0) {
		return WorldMapRectangle.method387(ViewportMouse.ViewportMouse_entityTags[var0]);
	}

	@ObfuscatedName("gz")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "265635085"
	)
	static void method406(int var0) {
		Client.field893 = 0L;
		if (var0 >= 2) {
			Client.isResizable = true;
			Client.resizeChanged(-1);
		} else {
			Client.isResizable = false;
			Client.resizeChanged(-1);
		}

		if (ApproximateRouteStrategy.method1327() == 1) {
			WorldMapSection1.client.method1017(765, 503, 133431336);
		} else {
			WorldMapSection1.client.method1017(7680, 2160, -943083531);
		}

		if (Client.gameState >= 25) {
			PacketBufferNode var1 = FaceNormal.method3363(ClientPacket.field2257, Client.packetWriter.isaacCipher);
			var1.packetBuffer.method5531(ApproximateRouteStrategy.method1327());
			var1.packetBuffer.method5532(WorldMapLabel.canvasWidth);
			var1.packetBuffer.method5532(Varps.canvasHeight);
			Client.packetWriter.method2361(var1);
		}

	}
}
