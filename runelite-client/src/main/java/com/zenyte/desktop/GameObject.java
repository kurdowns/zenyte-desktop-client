package com.zenyte.desktop;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.Angle;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSEntity;
import net.runelite.rs.api.RSGameObject;
import net.runelite.rs.api.RSModel;

@ObfuscatedName("ek")
public final class GameObject implements RSGameObject {
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1812382241
	)
	int centerY;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1894508257
	)
	int orientation;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -67995329
	)
	int plane;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1055464323
	)
	int height;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 733420337
	)
	int centerX;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lee;"
	)
	public Entity entity;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1786771811
	)
	int startX;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 983334103
	)
	int endX;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 364744081
	)
	int startY;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1023700223
	)
	int endY;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1872697875
	)
	int field1950;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -623014369
	)
	int lastDrawn;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		longValue = 1416033697273847883L
	)
	public long tag;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 837500395
	)
	int flags;

	GameObject() {
		this.tag = 0L;
		this.flags = 0;
	}

	public Point getCanvasLocation(int var1) {
		return Perspective.localToCanvas(WorldMapSection1.client, this.getLocalLocation(), this.getPlane(), var1);
	}

	public int getRelativeX() {
		return this.startX;
	}

	public int getOffsetX() {
		return this.endX;
	}

	public long getHash() {
		return this.tag;
	}

	public RSModel getModel() {
		RSEntity var1 = this.getEntity();
		if (var1 == null) {
			return null;
		} else {
			return var1 instanceof RSModel ? (RSModel)var1 : var1.getModel();
		}
	}

	public int getRsOrientation() {
		return this.orientation;
	}

	public RSEntity getEntity() {
		return this.entity;
	}

	public int getX() {
		return this.centerX;
	}

	public LocalPoint getLocalLocation() {
		return new LocalPoint(this.getX(), this.getY());
	}

	public int getRelativeY() {
		return this.startY;
	}

	public int getOffsetY() {
		return this.endY;
	}

	public int getFlags() {
		return this.flags;
	}

	public int getY() {
		return this.centerY;
	}

	public int getPlane() {
		return this.plane;
	}

	public Point getSceneMinLocation() {
		return new Point(this.getRelativeX(), this.getRelativeY());
	}

	public Point getSceneMaxLocation() {
		return new Point(this.getOffsetX(), this.getOffsetY());
	}

	public Shape getClickbox() {
		return Perspective.getClickbox(WorldMapSection1.client, this.getModel(), this.getRsOrientation(), this.getLocalLocation());
	}

	public Shape getConvexHull() {
		RSModel var1 = this.getModel();
		if (var1 == null) {
			return null;
		} else {
			int var2 = Perspective.getTileHeight(WorldMapSection1.client, new LocalPoint(this.getX(), this.getY()), WorldMapSection1.client.getPlane());
			return var1.getConvexHull(this.getX(), this.getY(), this.getRsOrientation(), var2);
		}
	}

	public Angle getOrientation() {
		int var1 = this.getRsOrientation();
		int var2 = this.getFlags() >> 6 & 3;
		return new Angle(var1 + var2 * 512);
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

	public int getHeight() {
		return this.height;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Ljava/io/File;Ljava/io/File;S)V",
		garbageValue = "1603"
	)
	public static void method3394(File var0, File var1) {
		try {
			AccessFile var2 = new AccessFile(JagexCache.JagexCache_locationFile, "rw", 10000L);
			Buffer var3 = new Buffer(500);
			var3.method5531(3);
			var3.method5531(var1 != null ? 1 : 0);
			var3.method5540(var0.getPath());
			if (var1 != null) {
				var3.method5540("");
			}

			var2.method6653(var3.array, 0, var3.offset);
			var2.method6648();
		} catch (IOException var4) {
			var4.printStackTrace();
		}

	}

	@ObfuscatedName("m")
	public static String method3391(long var0) {
		if (var0 > 0L && var0 < 6582952005840035281L) {
			if (var0 % 37L == 0L) {
				return null;
			} else {
				int var2 = 0;

				for (long var3 = var0; var3 != 0L; var3 /= 37L) {
					++var2;
				}

				StringBuilder var5 = new StringBuilder(var2);

				while (var0 != 0L) {
					long var6 = var0;
					var0 /= 37L;
					var5.append(class298.base37Table[(int)(var6 - 37L * var0)]);
				}

				return var5.reverse().toString();
			}
		} else {
			return null;
		}
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lkj;I)V",
		garbageValue = "-137749117"
	)
	public static void method3392(PacketBuffer var0) {
		ReflectionCheck var1 = (ReflectionCheck)class105.reflectionChecks.method4860();
		if (var1 != null) {
			int var2 = var0.offset;
			var0.method5689(var1.id);

			for (int var3 = 0; var3 < var1.size; ++var3) {
				if (var1.creationErrors[var3] != 0) {
					var0.method5531(var1.creationErrors[var3]);
				} else {
					try {
						int var4 = var1.operations[var3];
						Field var5;
						int var6;
						if (var4 == 0) {
							var5 = var1.fields[var3];
							var6 = var5.getInt((Object)null);
							var0.method5531(0);
							var0.method5689(var6);
						} else if (var4 == 1) {
							var5 = var1.fields[var3];
							var5.setInt((Object)null, var1.intReplaceValues[var3]);
							var0.method5531(0);
						} else if (var4 == 2) {
							var5 = var1.fields[var3];
							var6 = var5.getModifiers();
							var0.method5531(0);
							var0.method5689(var6);
						}

						Method var25;
						if (var4 != 3) {
							if (var4 == 4) {
								var25 = var1.methods[var3];
								var6 = var25.getModifiers();
								var0.method5531(0);
								var0.method5689(var6);
							}
						} else {
							var25 = var1.methods[var3];
							byte[][] var10 = var1.arguments[var3];
							Object[] var7 = new Object[var10.length];

							for (int var8 = 0; var8 < var10.length; ++var8) {
								ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var10[var8]));
								var7[var8] = var9.readObject();
							}

							Object var11 = var25.invoke((Object)null, var7);
							if (var11 == null) {
								var0.method5531(0);
							} else if (var11 instanceof Number) {
								var0.method5531(1);
								var0.method5529(((Number)var11).longValue());
							} else if (var11 instanceof String) {
								var0.method5531(2);
								var0.method5627((String)var11);
							} else {
								var0.method5531(4);
							}
						}
					} catch (ClassNotFoundException var13) {
						var0.method5531(-10);
					} catch (InvalidClassException var14) {
						var0.method5531(-11);
					} catch (StreamCorruptedException var15) {
						var0.method5531(-12);
					} catch (OptionalDataException var16) {
						var0.method5531(-13);
					} catch (IllegalAccessException var17) {
						var0.method5531(-14);
					} catch (IllegalArgumentException var18) {
						var0.method5531(-15);
					} catch (InvocationTargetException var19) {
						var0.method5531(-16);
					} catch (SecurityException var20) {
						var0.method5531(-17);
					} catch (IOException var21) {
						var0.method5531(-18);
					} catch (NullPointerException var22) {
						var0.method5531(-19);
					} catch (Exception var23) {
						var0.method5531(-20);
					} catch (Throwable var24) {
						var0.method5531(-21);
					}
				}
			}

			var0.method5551(var2);
			var1.method3657();
		}
	}

	@ObfuscatedName("fw")
	@ObfuscatedSignature(
		signature = "(Lih;Ljava/lang/String;B)V",
		garbageValue = "-1"
	)
	static void method3390(Archive var0, String var1) {
		ArchiveLoader var2 = new ArchiveLoader(var0, var1);
		Client.archiveLoaders.add(var2);
		Client.field898 += var2.groupCount;
	}

	@ObfuscatedName("hy")
	@ObfuscatedSignature(
		signature = "(ZLkj;I)V",
		garbageValue = "1045938723"
	)
	static final void method3393(boolean var0, PacketBuffer var1) {
		Client.isInInstance = var0;
		int var3;
		int var4;
		int var5;
		int var6;
		int var7;
		int var8;
		if (!Client.isInInstance) {
			int var2 = var1.method5549();
			var3 = var1.method5537();
			var4 = var1.method5549();
			UrlRequester.xteaKeys = new int[var4][4];

			for (var5 = 0; var5 < var4; ++var5) {
				for (var6 = 0; var6 < 4; ++var6) {
					UrlRequester.xteaKeys[var5][var6] = var1.method5552();
				}
			}

			StructDefinition.regions = new int[var4];
			KeyHandler.regionMapArchiveIds = new int[var4];
			WorldMapArea.regionLandArchiveIds = new int[var4];
			WorldMapData_0.regionLandArchives = new byte[var4][];
			class23.regionMapArchives = new byte[var4][];
			boolean var16 = false;
			if ((var3 / 8 == 48 || var3 / 8 == 49) && var2 / 8 == 48) {
				var16 = true;
			}

			if (var3 / 8 == 48 && var2 / 8 == 148) {
				var16 = true;
			}

			var4 = 0;

			for (var6 = (var3 - 6) / 8; var6 <= (var3 + 6) / 8; ++var6) {
				for (var7 = (var2 - 6) / 8; var7 <= (var2 + 6) / 8; ++var7) {
					var8 = var7 + (var6 << 8);
					if (!var16 || var7 != 49 && var7 != 149 && var7 != 147 && var6 != 50 && (var6 != 49 || var7 != 47)) {
						StructDefinition.regions[var4] = var8;
						KeyHandler.regionMapArchiveIds[var4] = WorldMapIcon_0.archive5.method4240("m" + var6 + "_" + var7);
						WorldMapArea.regionLandArchiveIds[var4] = WorldMapIcon_0.archive5.method4240("l" + var6 + "_" + var7);
						++var4;
					}
				}
			}

			GrandExchangeOfferNameComparator.method237(var3, var2, true);
		} else {
			boolean var15 = var1.method5547() == 1;
			var3 = var1.method5537();
			var4 = var1.method5587();
			var5 = var1.method5549();
			var1.method5496();

			int var9;
			for (var6 = 0; var6 < 4; ++var6) {
				for (var7 = 0; var7 < 13; ++var7) {
					for (var8 = 0; var8 < 13; ++var8) {
						var9 = var1.method5495(1);
						if (var9 == 1) {
							Client.instanceChunkTemplates[var6][var7][var8] = var1.method5495(26);
						} else {
							Client.instanceChunkTemplates[var6][var7][var8] = -1;
						}
					}
				}
			}

			var1.method5498();
			UrlRequester.xteaKeys = new int[var5][4];

			for (var6 = 0; var6 < var5; ++var6) {
				for (var7 = 0; var7 < 4; ++var7) {
					UrlRequester.xteaKeys[var6][var7] = var1.method5552();
				}
			}

			StructDefinition.regions = new int[var5];
			KeyHandler.regionMapArchiveIds = new int[var5];
			WorldMapArea.regionLandArchiveIds = new int[var5];
			WorldMapData_0.regionLandArchives = new byte[var5][];
			class23.regionMapArchives = new byte[var5][];
			var5 = 0;

			for (var6 = 0; var6 < 4; ++var6) {
				for (var7 = 0; var7 < 13; ++var7) {
					for (var8 = 0; var8 < 13; ++var8) {
						var9 = Client.instanceChunkTemplates[var6][var7][var8];
						if (var9 != -1) {
							int var10 = var9 >> 14 & 1023;
							int var11 = var9 >> 3 & 2047;
							int var12 = (var10 / 8 << 8) + var11 / 8;

							int var13;
							for (var13 = 0; var13 < var5; ++var13) {
								if (StructDefinition.regions[var13] == var12) {
									var12 = -1;
									break;
								}
							}

							if (var12 != -1) {
								StructDefinition.regions[var5] = var12;
								var13 = var12 >> 8 & 255;
								int var14 = var12 & 255;
								KeyHandler.regionMapArchiveIds[var5] = WorldMapIcon_0.archive5.method4240("m" + var13 + "_" + var14);
								WorldMapArea.regionLandArchiveIds[var5] = WorldMapIcon_0.archive5.method4240("l" + var13 + "_" + var14);
								++var5;
							}
						}
					}
				}
			}

			GrandExchangeOfferNameComparator.method237(var3, var4, !var15);
		}

	}
}
