package com.zenyte.desktop;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSEntity;
import net.runelite.rs.api.RSFloorDecoration;
import net.runelite.rs.api.RSModel;

@ObfuscatedName("eo")
public final class FloorDecoration implements RSFloorDecoration {
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1588480469
	)
	int y;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		longValue = -6831837537966124847L
	)
	public long tag;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -198900691
	)
	int tileHeight;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1743466221
	)
	int x;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lee;"
	)
	public Entity entity;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1370776167
	)
	int flags;
	public int groundObjectPlane;

	FloorDecoration() {
	}

	public Point getCanvasLocation(int var1) {
		return Perspective.localToCanvas(WorldMapSection1.client, this.getLocalLocation(), this.getPlane(), var1);
	}

	public long getHash() {
		return this.tag;
	}

	public RSModel getModel() {
		RSEntity var1 = this.getEntity();
		if (var1 == null) {
			return null;
		} else {
			return var1 instanceof net.runelite.api.Model ? (RSModel)var1 : var1.getModel();
		}
	}

	public RSEntity getEntity() {
		return this.entity;
	}

	public int getX() {
		return this.x;
	}

	public LocalPoint getLocalLocation() {
		return new LocalPoint(this.getX(), this.getY());
	}

	public int getY() {
		return this.y;
	}

	public int getPlane() {
		return this.groundObjectPlane;
	}

	public void setPlane(int var1) {
		this.groundObjectPlane = var1;
	}

	public Shape getConvexHull() {
		RSModel var1 = this.getModel();
		if (var1 == null) {
			return null;
		} else {
			int var2 = Perspective.getTileHeight(WorldMapSection1.client, new LocalPoint(this.getX(), this.getY()), WorldMapSection1.client.getPlane());
			return var1.getConvexHull(this.getX(), this.getY(), 0, var2);
		}
	}

	public Shape getClickbox() {
		return Perspective.getClickbox(WorldMapSection1.client, this.getModel(), 0, this.getLocalLocation());
	}

	public int getId() {
		long var1 = this.getHash();
		return (int)(var1 >>> 17 & 4294967295L);
	}

	public WorldPoint getWorldLocation() {
		return WorldPoint.fromLocal(WorldMapSection1.client, this.getX(), this.getY(), this.getPlane());
	}

	public Point getCanvasLocation() {
		return this.getCanvasLocation(0);
	}

	public Polygon getCanvasTilePoly() {
		return Perspective.getCanvasTilePoly(WorldMapSection1.client, this.getLocalLocation());
	}

	public Point getCanvasTextLocation(Graphics2D var1, String var2, int var3) {
		return Perspective.getCanvasTextLocation(WorldMapSection1.client, var1, this.getLocalLocation(), var2, var3);
	}

	public Point getMinimapLocation() {
		return Perspective.localToMinimap(WorldMapSection1.client, this.getLocalLocation());
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "-95"
	)
	public static void method2938(int var0, int var1) {
		VarbitDefinition var2 = SpriteMask.method4040(var0);
		int var3 = var2.baseVar;
		int var4 = var2.startBit;
		int var5 = var2.endBit;
		int var6 = Varps.Varps_masks[var5 - var4];
		if (var1 < 0 || var1 > var6) {
			var1 = 0;
		}

		var6 <<= var4;
		Varps.Varps_main[var3] = Varps.Varps_main[var3] & ~var6 | var1 << var4 & var6;
		Client.settingsChanged(var3);
	}
}
