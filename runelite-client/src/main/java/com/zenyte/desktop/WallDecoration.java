package com.zenyte.desktop;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.geometry.Shapes;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSEntity;
import net.runelite.rs.api.RSModel;
import net.runelite.rs.api.RSWallDecoration;

@ObfuscatedName("ez")
public final class WallDecoration implements RSWallDecoration {
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1214014955
	)
	int y;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -166681381
	)
	int tileHeight;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1454515853
	)
	int x;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -985506123
	)
	int orientation;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 817578233
	)
	int orientation2;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1515780955
	)
	int xOffset;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -102361683
	)
	int yOffset;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lee;"
	)
	public Entity entity1;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lee;"
	)
	public Entity entity2;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		longValue = -7258048285485333861L
	)
	public long tag;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1418566089
	)
	int flags;
	public int decorativeObjectPlane;

	WallDecoration() {
		this.tag = 0L;
		this.flags = 0;
	}

	public Point getCanvasLocation(int var1) {
		return Perspective.localToCanvas(WorldMapSection1.client, this.getLocalLocation(), this.getPlane(), var1);
	}

	public long getHash() {
		return this.tag;
	}

	public RSModel getModel1() {
		RSEntity var1 = this.getEntity1();
		if (var1 == null) {
			return null;
		} else {
			RSModel var2;
			if (var1 instanceof net.runelite.api.Model) {
				var2 = (RSModel)var1;
			} else {
				var2 = var1.getModel();
			}

			return var2;
		}
	}

	public RSModel getModel2() {
		RSEntity var1 = this.getEntity2();
		if (var1 == null) {
			return null;
		} else {
			RSModel var2;
			if (var1 instanceof net.runelite.api.Model) {
				var2 = (RSModel)var1;
			} else {
				var2 = var1.getModel();
			}

			return var2;
		}
	}

	public RSEntity getEntity1() {
		return this.entity1;
	}

	public RSEntity getEntity2() {
		return this.entity2;
	}

	public LocalPoint getLocalLocation() {
		return new LocalPoint(this.getX(), this.getY());
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getPlane() {
		return this.decorativeObjectPlane;
	}

	public int getXOffset() {
		return this.xOffset;
	}

	public int getYOffset() {
		return this.yOffset;
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

	public void setPlane(int var1) {
		this.decorativeObjectPlane = var1;
	}

	public Shape getClickbox() {
		LocalPoint var1 = this.getLocalLocation();
		Shape var2 = Perspective.getClickbox(WorldMapSection1.client, this.getModel1(), 0, new LocalPoint(var1.getX() + this.getXOffset(), var1.getY() + this.getYOffset()));
		Shape var3 = Perspective.getClickbox(WorldMapSection1.client, this.getModel2(), 0, var1);
		if (var2 == null && var3 == null) {
			return null;
		} else if (var2 != null && var3 != null) {
			return new Shapes(new Shape[]{var2, var3});
		} else {
			return var2 != null ? var2 : var3;
		}
	}

	public Shape getConvexHull() {
		RSModel var1 = this.getModel1();
		if (var1 == null) {
			return null;
		} else {
			int var2 = Perspective.getTileHeight(WorldMapSection1.client, new LocalPoint(this.getX(), this.getY()), WorldMapSection1.client.getPlane());
			return var1.getConvexHull(this.getX() + this.getXOffset(), this.getY() + this.getYOffset(), 0, var2);
		}
	}

	public Shape getConvexHull2() {
		RSModel var1 = this.getModel2();
		if (var1 == null) {
			return null;
		} else {
			int var2 = Perspective.getTileHeight(WorldMapSection1.client, new LocalPoint(this.getX(), this.getY()), WorldMapSection1.client.getPlane());
			return var1.getConvexHull(this.getX(), this.getY(), 0, var2);
		}
	}

	public int getOrientation() {
		return this.orientation2;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I[BLlq;S)V",
		garbageValue = "4729"
	)
	static void method3388(int var0, byte[] var1, ArchiveDisk var2) {
		ArchiveDiskAction var3 = new ArchiveDiskAction();
		var3.type = 0;
		var3.key = (long)var0;
		var3.data = var1;
		var3.archiveDisk = var2;
		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
			ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.method4952(var3);
		}

		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
			if (ArchiveDiskActionHandler.field3151 == 0) {
				class197.ArchiveDiskActionHandler_thread = new Thread(new ArchiveDiskActionHandler());
				class197.ArchiveDiskActionHandler_thread.setDaemon(true);
				class197.ArchiveDiskActionHandler_thread.start();
				class197.ArchiveDiskActionHandler_thread.setPriority(5);
			}

			ArchiveDiskActionHandler.field3151 = 600;
		}
	}

	@ObfuscatedName("iw")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Lhe;I)Ljava/lang/String;",
		garbageValue = "-748115662"
	)
	static String method3389(String var0, Widget var1) {
		if (var0.indexOf("%") != -1) {
			for (int var2 = 1; var2 <= 5; ++var2) {
				while (true) {
					int var3 = var0.indexOf("%" + var2);
					if (var3 == -1) {
						break;
					}

					String var4 = var0.substring(0, var3);
					int var6 = Tiles.method1227(var1, var2 - 1);
					String var5;
					if (var6 < 999999999) {
						var5 = Integer.toString(var6);
					} else {
						var5 = "*";
					}

					var0 = var4 + var5 + var0.substring(var3 + 2);
				}
			}
		}

		return var0;
	}
}
