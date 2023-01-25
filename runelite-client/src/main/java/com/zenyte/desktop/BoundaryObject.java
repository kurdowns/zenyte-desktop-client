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
import net.runelite.rs.api.RSBoundaryObject;
import net.runelite.rs.api.RSEntity;
import net.runelite.rs.api.RSModel;

@ObfuscatedName("ep")
public final class BoundaryObject implements RSBoundaryObject {
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 2013637089
	)
	int y;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1191949217
	)
	int tileHeight;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -935099037
	)
	int x;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 2050214703
	)
	int orientationA;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1637656997
	)
	int orientationB;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lee;"
	)
	public Entity entity1;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lee;"
	)
	public Entity entity2;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		longValue = 8712969699368096229L
	)
	public long tag;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1289122601
	)
	int flags;
	public int wallPlane;

	BoundaryObject() {
		this.tag = 0L;
		this.flags = 0;
	}

	public Point getCanvasLocation(int var1) {
		return Perspective.localToCanvas(WorldMapSection1.client, this.getLocalLocation(), this.getPlane(), var1);
	}

	public long getHash() {
		return this.tag;
	}

	public RSModel getModelA() {
		RSEntity var1 = this.getEntity1();
		if (var1 == null) {
			return null;
		} else {
			return var1 instanceof net.runelite.api.Model ? (RSModel)var1 : var1.getModel();
		}
	}

	public RSModel getModelB() {
		RSEntity var1 = this.getEntity2();
		if (var1 == null) {
			return null;
		} else {
			return var1 instanceof net.runelite.api.Model ? (RSModel)var1 : var1.getModel();
		}
	}

	public RSEntity getEntity1() {
		return this.entity1;
	}

	public RSEntity getEntity2() {
		return this.entity2;
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
		return this.wallPlane;
	}

	public void setPlane(int var1) {
		this.wallPlane = var1;
	}

	public Shape getClickbox() {
		Shape var1 = Perspective.getClickbox(WorldMapSection1.client, this.getModelA(), 0, this.getLocalLocation());
		Shape var2 = Perspective.getClickbox(WorldMapSection1.client, this.getModelB(), 0, this.getLocalLocation());
		if (var1 == null && var2 == null) {
			return null;
		} else if (var1 != null && var2 != null) {
			return new Shapes(new Shape[]{var1, var2});
		} else {
			return var1 != null ? var1 : var2;
		}
	}

	public Shape getConvexHull() {
		RSModel var1 = this.getModelA();
		if (var1 == null) {
			return null;
		} else {
			int var2 = Perspective.getTileHeight(WorldMapSection1.client, new LocalPoint(this.getX(), this.getY()), WorldMapSection1.client.getPlane());
			return var1.getConvexHull(this.getX(), this.getY(), 0, var2);
		}
	}

	public Shape getConvexHull2() {
		RSModel var1 = this.getModelB();
		if (var1 == null) {
			return null;
		} else {
			int var2 = Perspective.getTileHeight(WorldMapSection1.client, new LocalPoint(this.getX(), this.getY()), WorldMapSection1.client.getPlane());
			return var1.getConvexHull(this.getX(), this.getY(), 0, var2);
		}
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

	public int getOrientationA() {
		return this.orientationA;
	}

	public int getOrientationB() {
		return this.orientationB;
	}

	public int getConfig() {
		return this.flags;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IIII)Lce;",
		garbageValue = "-719728055"
	)
	static class101 method3361(int var0, int var1, int var2) {
		int var3 = (var1 << 8) + var0;
		class101 var6 = (class101)class101.Script_cached.method3418((long)(var3 << 16));
		class101 var5;
		if (var6 != null) {
			var5 = var6;
		} else {
			String var7 = String.valueOf(var3);
			int var8 = class41.archive12.method4240(var7);
			if (var8 == -1) {
				var5 = null;
			} else {
				label56: {
					byte[] var9 = class41.archive12.method4231(var8);
					if (var9 != null) {
						if (var9.length <= 1) {
							var5 = null;
							break label56;
						}

						var6 = SecureRandomCallable.method1246(var9);
						if (var6 != null) {
							class101.Script_cached.method3424(var6, (long)(var3 << 16));
							var5 = var6;
							break label56;
						}
					}

					var5 = null;
				}
			}
		}

		if (var5 != null) {
			return var5;
		} else {
			int var4 = class58.method963(var2, var0);
			class101 var12 = (class101)class101.Script_cached.method3418((long)(var4 << 16));
			class101 var13;
			if (var12 != null) {
				var13 = var12;
			} else {
				String var14 = String.valueOf(var4);
				int var10 = class41.archive12.method4240(var14);
				if (var10 == -1) {
					var13 = null;
				} else {
					byte[] var11 = class41.archive12.method4231(var10);
					if (var11 != null) {
						if (var11.length <= 1) {
							var13 = null;
							return var13 != null ? var13 : null;
						}

						var12 = SecureRandomCallable.method1246(var11);
						if (var12 != null) {
							class101.Script_cached.method3424(var12, (long)(var4 << 16));
							var13 = var12;
							return var13 != null ? var13 : null;
						}
					}

					var13 = null;
				}
			}

			return var13 != null ? var13 : null;
		}
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "-522510299"
	)
	static int method3362(int var0, class101 var1, boolean var2) {
		if (var0 == 5000) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.publicChatMode;
			return 1;
		} else if (var0 == 5001) {
			Interpreter.Interpreter_intStackSize -= 3;
			Client.publicChatMode = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			UserComparator3.privateChatMode = class219.method4031(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
			if (UserComparator3.privateChatMode == null) {
				UserComparator3.privateChatMode = PrivateChatMode.field3806;
			}

			Client.tradeChatMode = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
			PacketBufferNode var18 = FaceNormal.method3363(ClientPacket.field2212, Client.packetWriter.isaacCipher);
			var18.packetBuffer.method5531(Client.publicChatMode);
			var18.packetBuffer.method5531(UserComparator3.privateChatMode.field3804);
			var18.packetBuffer.method5531(Client.tradeChatMode);
			Client.packetWriter.method2361(var18);
			return 1;
		} else {
			String var3;
			int var4;
			if (var0 == 5002) {
				var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
				Interpreter.Interpreter_intStackSize -= 2;
				var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
				int var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
				PacketBufferNode var6 = FaceNormal.method3363(ClientPacket.field2289, Client.packetWriter.isaacCipher);
				var6.packetBuffer.method5531(class234.method4198(var3) + 2);
				var6.packetBuffer.method5627(var3);
				var6.packetBuffer.method5531(var4 - 1);
				var6.packetBuffer.method5531(var5);
				Client.packetWriter.method2361(var6);
				return 1;
			} else {
				int var10;
				if (var0 == 5003) {
					Interpreter.Interpreter_intStackSize -= 2;
					var10 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
					var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
					Message var15 = class1.method16(var10, var4);
					if (var15 != null) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var15.count;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var15.cycle;
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var15.sender != null ? var15.sender : "";
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var15.prefix != null ? var15.prefix : "";
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var15.text != null ? var15.text : "";
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var15.method1316() ? 1 : (var15.method1308() ? 2 : 0);
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == 5004) {
					var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					Message var16 = PendingSpawn.method1825(var10);
					if (var16 != null) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var16.type;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var16.cycle;
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var16.sender != null ? var16.sender : "";
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var16.prefix != null ? var16.prefix : "";
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var16.text != null ? var16.text : "";
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var16.method1316() ? 1 : (var16.method1308() ? 2 : 0);
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == 5005) {
					if (UserComparator3.privateChatMode == null) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = UserComparator3.privateChatMode.field3804;
					}

					return 1;
				} else if (var0 == 5008) {
					var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
					var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					String var14 = var3.toLowerCase();
					byte var17 = 0;
					if (var14.startsWith("yellow:")) {
						var17 = 0;
						var3 = var3.substring("yellow:".length());
					} else if (var14.startsWith("red:")) {
						var17 = 1;
						var3 = var3.substring("red:".length());
					} else if (var14.startsWith("green:")) {
						var17 = 2;
						var3 = var3.substring("green:".length());
					} else if (var14.startsWith("cyan:")) {
						var17 = 3;
						var3 = var3.substring("cyan:".length());
					} else if (var14.startsWith("purple:")) {
						var17 = 4;
						var3 = var3.substring("purple:".length());
					} else if (var14.startsWith("white:")) {
						var17 = 5;
						var3 = var3.substring("white:".length());
					} else if (var14.startsWith("flash1:")) {
						var17 = 6;
						var3 = var3.substring("flash1:".length());
					} else if (var14.startsWith("flash2:")) {
						var17 = 7;
						var3 = var3.substring("flash2:".length());
					} else if (var14.startsWith("flash3:")) {
						var17 = 8;
						var3 = var3.substring("flash3:".length());
					} else if (var14.startsWith("glow1:")) {
						var17 = 9;
						var3 = var3.substring("glow1:".length());
					} else if (var14.startsWith("glow2:")) {
						var17 = 10;
						var3 = var3.substring("glow2:".length());
					} else if (var14.startsWith("glow3:")) {
						var17 = 11;
						var3 = var3.substring("glow3:".length());
					} else if (Language.Language_EN != IgnoreList.clientLanguage) {
						if (var14.startsWith("yellow:")) {
							var17 = 0;
							var3 = var3.substring("yellow:".length());
						} else if (var14.startsWith("red:")) {
							var17 = 1;
							var3 = var3.substring("red:".length());
						} else if (var14.startsWith("green:")) {
							var17 = 2;
							var3 = var3.substring("green:".length());
						} else if (var14.startsWith("cyan:")) {
							var17 = 3;
							var3 = var3.substring("cyan:".length());
						} else if (var14.startsWith("purple:")) {
							var17 = 4;
							var3 = var3.substring("purple:".length());
						} else if (var14.startsWith("white:")) {
							var17 = 5;
							var3 = var3.substring("white:".length());
						} else if (var14.startsWith("flash1:")) {
							var17 = 6;
							var3 = var3.substring("flash1:".length());
						} else if (var14.startsWith("flash2:")) {
							var17 = 7;
							var3 = var3.substring("flash2:".length());
						} else if (var14.startsWith("flash3:")) {
							var17 = 8;
							var3 = var3.substring("flash3:".length());
						} else if (var14.startsWith("glow1:")) {
							var17 = 9;
							var3 = var3.substring("glow1:".length());
						} else if (var14.startsWith("glow2:")) {
							var17 = 10;
							var3 = var3.substring("glow2:".length());
						} else if (var14.startsWith("glow3:")) {
							var17 = 11;
							var3 = var3.substring("glow3:".length());
						}
					}

					var14 = var3.toLowerCase();
					byte var7 = 0;
					if (var14.startsWith("wave:")) {
						var7 = 1;
						var3 = var3.substring("wave:".length());
					} else if (var14.startsWith("wave2:")) {
						var7 = 2;
						var3 = var3.substring("wave2:".length());
					} else if (var14.startsWith("shake:")) {
						var7 = 3;
						var3 = var3.substring("shake:".length());
					} else if (var14.startsWith("scroll:")) {
						var7 = 4;
						var3 = var3.substring("scroll:".length());
					} else if (var14.startsWith("slide:")) {
						var7 = 5;
						var3 = var3.substring("slide:".length());
					} else if (IgnoreList.clientLanguage != Language.Language_EN) {
						if (var14.startsWith("wave:")) {
							var7 = 1;
							var3 = var3.substring("wave:".length());
						} else if (var14.startsWith("wave2:")) {
							var7 = 2;
							var3 = var3.substring("wave2:".length());
						} else if (var14.startsWith("shake:")) {
							var7 = 3;
							var3 = var3.substring("shake:".length());
						} else if (var14.startsWith("scroll:")) {
							var7 = 4;
							var3 = var3.substring("scroll:".length());
						} else if (var14.startsWith("slide:")) {
							var7 = 5;
							var3 = var3.substring("slide:".length());
						}
					}

					PacketBufferNode var8 = FaceNormal.method3363(ClientPacket.field2229, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5531(0);
					int var9 = var8.packetBuffer.offset;
					var8.packetBuffer.method5531(var4);
					var8.packetBuffer.method5531(var17);
					var8.packetBuffer.method5531(var7);
					GraphicsDefaults.method5932(var8.packetBuffer, var3);
					var8.packetBuffer.method5656(var8.packetBuffer.offset - var9);
					Client.packetWriter.method2361(var8);
					return 1;
				} else if (var0 == 5009) {
					Interpreter.Interpreter_stringStackSize -= 2;
					var3 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
					String var12 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1];
					PacketBufferNode var11 = FaceNormal.method3363(ClientPacket.field2283, Client.packetWriter.isaacCipher);
					var11.packetBuffer.method5532(0);
					int var13 = var11.packetBuffer.offset;
					var11.packetBuffer.method5627(var3);
					GraphicsDefaults.method5932(var11.packetBuffer, var12);
					var11.packetBuffer.method5726(var11.packetBuffer.offset - var13);
					Client.packetWriter.method2361(var11);
					return 1;
				} else if (var0 != 5015) {
					if (var0 == 5016) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.tradeChatMode;
						return 1;
					} else if (var0 == 5017) {
						var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = PacketWriter.method2367(var10);
						return 1;
					} else if (var0 == 5018) {
						var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ObjectSound.method2002(var10);
						return 1;
					} else if (var0 == 5019) {
						var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class58.method965(var10);
						return 1;
					} else if (var0 == 5020) {
						var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
						class60.method999(var3);
						return 1;
					} else if (var0 == 5021) {
						Client.field814 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize].toLowerCase().trim();
						return 1;
					} else if (var0 == 5022) {
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = Client.field814;
						return 1;
					} else if (var0 == 5023) {
						var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
						System.out.println(var3);
						return 1;
					} else {
						return 2;
					}
				} else {
					if (ByteArrayPool.localPlayer != null && ByteArrayPool.localPlayer.username != null) {
						var3 = ByteArrayPool.localPlayer.username.method5238();
					} else {
						var3 = "";
					}

					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3;
					return 1;
				}
			}
		}
	}
}
