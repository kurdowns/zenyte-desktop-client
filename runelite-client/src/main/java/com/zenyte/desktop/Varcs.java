package com.zenyte.desktop;

import java.io.EOFException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.runelite.api.events.VarClientIntChanged;
import net.runelite.api.events.VarClientStrChanged;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSVarcs;

@ObfuscatedName("cp")
public class Varcs implements RSVarcs {
	@ObfuscatedName("sm")
	@ObfuscatedSignature(
		signature = "Lmq;"
	)
	static PlatformInfo platformInfo;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	public static AbstractArchive SequenceDefinition_archive;
	@ObfuscatedName("k")
	boolean[] intsPersistence;
	@ObfuscatedName("d")
	Map map;
	@ObfuscatedName("w")
	String[] strings;
	@ObfuscatedName("v")
	boolean unwrittenChanges;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		longValue = 4946671747010980607L
	)
	long field1281;

	Varcs() {
		this.unwrittenChanges = false;
		int var1 = GrandExchangeOffer.archive2.method4246(19);
		this.map = new HashMap();
		this.intsPersistence = new boolean[var1];

		int var2;
		for (var2 = 0; var2 < var1; ++var2) {
			VarcInt var4 = (VarcInt)VarcInt.VarcInt_cached.method3418((long)var2);
			VarcInt var3;
			if (var4 != null) {
				var3 = var4;
			} else {
				byte[] var5 = VarcInt.VarcInt_archive.method4224(19, var2, (byte)-105);
				var4 = new VarcInt();
				if (var5 != null) {
					var4.method4463(new Buffer(var5));
				}

				VarcInt.VarcInt_cached.method3424(var4, (long)var2);
				var3 = var4;
			}

			this.intsPersistence[var2] = var3.persist;
		}

		var2 = 0;
		if (GrandExchangeOffer.archive2.method4329(15)) {
			var2 = GrandExchangeOffer.archive2.method4246(15);
		}

		this.strings = new String[var2];
		this.method2248();
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1118908426"
	)
	void method2239(int var1, int var2) {
		this.map.put(var1, var2);
		if (this.intsPersistence[var1]) {
			this.unwrittenChanges = true;
		}

		this.onVarCIntChanged(var1, var2);
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "-101"
	)
	int method2240(int var1) {
		Object var2 = this.map.get(var1);
		return var2 instanceof Integer ? (Integer)var2 : -1;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)V",
		garbageValue = "1504120549"
	)
	void method2272(int var1, String var2) {
		this.map.put(var1, var2);
		this.onVarCStrChanged(var1, var2);
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(II)Ljava/lang/String;",
		garbageValue = "-1244262565"
	)
	String method2264(int var1) {
		Object var2 = this.map.get(var1);
		return var2 instanceof String ? (String)var2 : "";
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;S)V",
		garbageValue = "10505"
	)
	void method2266(int var1, String var2) {
		this.strings[var1] = var2;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(IB)Ljava/lang/String;",
		garbageValue = "61"
	)
	String method2244(int var1) {
		return this.strings[var1];
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1883661666"
	)
	void method2245() {
		int var1;
		for (var1 = 0; var1 < this.intsPersistence.length; ++var1) {
			if (!this.intsPersistence[var1]) {
				this.map.remove(var1);
			}
		}

		for (var1 = 0; var1 < this.strings.length; ++var1) {
			this.strings[var1] = null;
		}

	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(ZS)Lmb;",
		garbageValue = "6254"
	)
	AccessFile method2246(boolean var1) {
		return KeyHandler.method919("2", WorldMapArchiveLoader.field3965.name, var1);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "316912893"
	)
	void method2247() {
		AccessFile var1 = this.method2246(true);

		try {
			int var2 = 3;
			int var3 = 0;
			Iterator var4 = this.map.entrySet().iterator();

			while (var4.hasNext()) {
				Entry var5 = (Entry)var4.next();
				int var6 = (Integer)var5.getKey();
				if (this.intsPersistence[var6]) {
					Object var7 = var5.getValue();
					var2 += 3;
					if (var7 instanceof Integer) {
						var2 += 4;
					} else if (var7 instanceof String) {
						var2 += class234.method4198((String)var7);
					}

					++var3;
				}
			}

			Buffer var24 = new Buffer(var2);
			var24.method5531(2);
			var24.method5532(var3);
			Iterator var25 = this.map.entrySet().iterator();

			while (var25.hasNext()) {
				Entry var13 = (Entry)var25.next();
				int var14 = (Integer)var13.getKey();
				if (this.intsPersistence[var14]) {
					var24.method5532(var14);
					Object var8 = var13.getValue();
					class3 var9 = class3.method38(var8.getClass());
					var24.method5531(var9.field9);
					class0 var10 = class3.method40(var8.getClass());
					var10.vmethod64(var8, var24);
				}
			}

			var1.method6653(var24.array, 0, var24.offset);
		} catch (Exception var22) {
		} finally {
			try {
				var1.method6648();
			} catch (Exception var21) {
			}

		}

		this.unwrittenChanges = false;
		this.field1281 = class217.method4014();
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "349952581"
	)
	void method2248() {
		AccessFile var1 = this.method2246(false);

		label212: {
			try {
				byte[] var2 = new byte[(int)var1.method6650()];

				int var4;
				for (int var3 = 0; var3 < var2.length; var3 += var4) {
					var4 = var1.method6658(var2, var3, var2.length - var3);
					if (var4 == -1) {
						throw new EOFException();
					}
				}

				Buffer var14 = new Buffer(var2);
				if (var14.array.length - var14.offset < 1) {
					return;
				}

				int var15 = var14.method5547();
				if (var15 >= 0 && var15 <= 2) {
					int var7;
					int var8;
					int var9;
					int var16;
					if (var15 >= 2) {
						var16 = var14.method5549();
						var7 = 0;

						while (true) {
							if (var7 >= var16) {
								break label212;
							}

							var8 = var14.method5549();
							var9 = var14.method5547();
							class3 var10 = (class3)GrandExchangeEvent.method159(class3.method46(), var9);
							Object var11 = var10.method42(var14);
							if (this.intsPersistence[var8]) {
								this.map.put(var8, var11);
							}

							++var7;
						}
					} else {
						var16 = var14.method5549();

						for (var7 = 0; var7 < var16; ++var7) {
							var8 = var14.method5549();
							var9 = var14.method5552();
							if (this.intsPersistence[var8]) {
								this.map.put(var8, var9);
							}
						}

						var7 = var14.method5549();
						var8 = 0;

						while (true) {
							if (var8 >= var7) {
								break label212;
							}

							var14.method5549();
							var14.method5667();
							++var8;
						}
					}
				}
			} catch (Exception var25) {
				break label212;
			} finally {
				try {
					var1.method6648();
				} catch (Exception var24) {
				}

			}

			return;
		}

		this.unwrittenChanges = false;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "973740896"
	)
	void method2274() {
		if (this.unwrittenChanges && this.field1281 < class217.method4014() - 60000L) {
			this.method2247();
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "2008113856"
	)
	boolean method2250() {
		return this.unwrittenChanges;
	}

	public void onVarCStrChanged(int var1, String var2) {
		WorldMapSection1.client.getCallbacks().post(VarClientStrChanged.class, new VarClientStrChanged(var1));
	}

	public void onVarCIntChanged(int var1, int var2) {
		WorldMapSection1.client.getCallbacks().post(VarClientIntChanged.class, new VarClientIntChanged(var1));
	}

	public Map getVarcMap() {
		return this.map;
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "906944643"
	)
	static final void method2280() {
		if (!ViewportMouse.ViewportMouse_false0) {
			int var0 = Scene.Scene_cameraPitchSine;
			int var1 = Scene.Scene_cameraPitchCosine;
			int var2 = Scene.Scene_cameraYawSine;
			int var3 = Scene.Scene_cameraYawCosine;
			byte var4 = 50;
			short var5 = 3500;
			int var6 = (ViewportMouse.ViewportMouse_x - Rasterizer3D.Rasterizer3D_clipMidX) * var4 / Rasterizer3D.Rasterizer3D_zoom;
			int var7 = (ViewportMouse.ViewportMouse_y - Rasterizer3D.Rasterizer3D_clipMidY) * var4 / Rasterizer3D.Rasterizer3D_zoom;
			int var8 = (ViewportMouse.ViewportMouse_x - Rasterizer3D.Rasterizer3D_clipMidX) * var5 / Rasterizer3D.Rasterizer3D_zoom;
			int var9 = (ViewportMouse.ViewportMouse_y - Rasterizer3D.Rasterizer3D_clipMidY) * var5 / Rasterizer3D.Rasterizer3D_zoom;
			int var10 = Rasterizer3D.method3137(var7, var4, var1, var0);
			int var11 = Rasterizer3D.method3104(var7, var4, var1, var0);
			var7 = var10;
			var10 = Rasterizer3D.method3137(var9, var5, var1, var0);
			int var12 = Rasterizer3D.method3104(var9, var5, var1, var0);
			var9 = var10;
			var10 = Rasterizer3D.method3101(var6, var11, var3, var2);
			var11 = Rasterizer3D.method3102(var6, var11, var3, var2);
			var6 = var10;
			var10 = Rasterizer3D.method3101(var8, var12, var3, var2);
			var12 = Rasterizer3D.method3102(var8, var12, var3, var2);
			ViewportMouse.field1756 = (var6 + var10) / 2;
			class300.field3653 = (var9 + var7) / 2;
			HorizontalAlignment.field3456 = (var12 + var11) / 2;
			ViewportMouse.field1753 = (var10 - var6) / 2;
			Clock.field2061 = (var9 - var7) / 2;
			GrandExchangeEvent.field75 = (var12 - var11) / 2;
			class23.field134 = Math.abs(ViewportMouse.field1753);
			ViewportMouse.field1758 = Math.abs(Clock.field2061);
			AttackOption.field1182 = Math.abs(GrandExchangeEvent.field75);
		}
	}

	@ObfuscatedName("hc")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-938707872"
	)
	static int method2281(int var0, int var1) {
		int var2 = var1 - 334;
		if (var2 < 0) {
			var2 = 0;
		} else if (var2 > 100) {
			var2 = 100;
		}

		int var3 = (Client.zoomWidth - Client.zoomHeight) * var2 / 100 + Client.zoomHeight;
		return var0 * var3 / 256;
	}
}
