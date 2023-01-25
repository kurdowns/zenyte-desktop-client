package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSCollisionMap;

@ObfuscatedName("fm")
public class CollisionMap implements RSCollisionMap {
	@ObfuscatedName("at")
	@ObfuscatedGetter(
		intValue = -1688029989
	)
	public int xInset;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = -1941455175
	)
	public int yInset;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = 1262495837
	)
	int xSize;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = -281985159
	)
	int ySize;
	@ObfuscatedName("au")
	public int[][] flags;

	public CollisionMap(int var1, int var2) {
		this.xInset = 0;
		this.yInset = 0;
		this.xSize = var1;
		this.ySize = var2;
		this.flags = new int[this.xSize][this.ySize];
		this.method3618();
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1906958459"
	)
	public void method3618() {
		for (int var1 = 0; var1 < this.xSize; ++var1) {
			for (int var2 = 0; var2 < this.ySize; ++var2) {
				if (var1 != 0 && var2 != 0 && var1 < this.xSize - 5 && var2 < this.ySize - 5) {
					this.flags[var1][var2] = 16777216;
				} else {
					this.flags[var1][var2] = 16777215;
				}
			}
		}

	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IIIIZI)V",
		garbageValue = "-1240663333"
	)
	public void method3612(int var1, int var2, int var3, int var4, boolean var5) {
		var1 -= this.xInset;
		var2 -= this.yInset;
		if (var3 == 0) {
			if (var4 == 0) {
				this.method3616(var1, var2, 128);
				this.method3616(var1 - 1, var2, 8);
			}

			if (var4 == 1) {
				this.method3616(var1, var2, 2);
				this.method3616(var1, var2 + 1, 32);
			}

			if (var4 == 2) {
				this.method3616(var1, var2, 8);
				this.method3616(var1 + 1, var2, 128);
			}

			if (var4 == 3) {
				this.method3616(var1, var2, 32);
				this.method3616(var1, var2 - 1, 2);
			}
		}

		if (var3 == 1 || var3 == 3) {
			if (var4 == 0) {
				this.method3616(var1, var2, 1);
				this.method3616(var1 - 1, var2 + 1, 16);
			}

			if (var4 == 1) {
				this.method3616(var1, var2, 4);
				this.method3616(var1 + 1, var2 + 1, 64);
			}

			if (var4 == 2) {
				this.method3616(var1, var2, 16);
				this.method3616(var1 + 1, var2 - 1, 1);
			}

			if (var4 == 3) {
				this.method3616(var1, var2, 64);
				this.method3616(var1 - 1, var2 - 1, 4);
			}
		}

		if (var3 == 2) {
			if (var4 == 0) {
				this.method3616(var1, var2, 130);
				this.method3616(var1 - 1, var2, 8);
				this.method3616(var1, var2 + 1, 32);
			}

			if (var4 == 1) {
				this.method3616(var1, var2, 10);
				this.method3616(var1, var2 + 1, 32);
				this.method3616(var1 + 1, var2, 128);
			}

			if (var4 == 2) {
				this.method3616(var1, var2, 40);
				this.method3616(var1 + 1, var2, 128);
				this.method3616(var1, var2 - 1, 2);
			}

			if (var4 == 3) {
				this.method3616(var1, var2, 160);
				this.method3616(var1, var2 - 1, 2);
				this.method3616(var1 - 1, var2, 8);
			}
		}

		if (var5) {
			if (var3 == 0) {
				if (var4 == 0) {
					this.method3616(var1, var2, 65536);
					this.method3616(var1 - 1, var2, 4096);
				}

				if (var4 == 1) {
					this.method3616(var1, var2, 1024);
					this.method3616(var1, var2 + 1, 16384);
				}

				if (var4 == 2) {
					this.method3616(var1, var2, 4096);
					this.method3616(var1 + 1, var2, 65536);
				}

				if (var4 == 3) {
					this.method3616(var1, var2, 16384);
					this.method3616(var1, var2 - 1, 1024);
				}
			}

			if (var3 == 1 || var3 == 3) {
				if (var4 == 0) {
					this.method3616(var1, var2, 512);
					this.method3616(var1 - 1, var2 + 1, 8192);
				}

				if (var4 == 1) {
					this.method3616(var1, var2, 2048);
					this.method3616(var1 + 1, var2 + 1, 32768);
				}

				if (var4 == 2) {
					this.method3616(var1, var2, 8192);
					this.method3616(var1 + 1, var2 - 1, 512);
				}

				if (var4 == 3) {
					this.method3616(var1, var2, 32768);
					this.method3616(var1 - 1, var2 - 1, 2048);
				}
			}

			if (var3 == 2) {
				if (var4 == 0) {
					this.method3616(var1, var2, 66560);
					this.method3616(var1 - 1, var2, 4096);
					this.method3616(var1, var2 + 1, 16384);
				}

				if (var4 == 1) {
					this.method3616(var1, var2, 5120);
					this.method3616(var1, var2 + 1, 16384);
					this.method3616(var1 + 1, var2, 65536);
				}

				if (var4 == 2) {
					this.method3616(var1, var2, 20480);
					this.method3616(var1 + 1, var2, 65536);
					this.method3616(var1, var2 - 1, 1024);
				}

				if (var4 == 3) {
					this.method3616(var1, var2, 81920);
					this.method3616(var1, var2 - 1, 1024);
					this.method3616(var1 - 1, var2, 4096);
				}
			}
		}

	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(IIIIZB)V",
		garbageValue = "2"
	)
	public void method3613(int var1, int var2, int var3, int var4, boolean var5) {
		int var6 = 256;
		if (var5) {
			var6 += 131072;
		}

		var1 -= this.xInset;
		var2 -= this.yInset;

		for (int var7 = var1; var7 < var3 + var1; ++var7) {
			if (var7 >= 0 && var7 < this.xSize) {
				for (int var8 = var2; var8 < var2 + var4; ++var8) {
					if (var8 >= 0 && var8 < this.ySize) {
						this.method3616(var7, var8, var6);
					}
				}
			}
		}

	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1257789406"
	)
	public void method3614(int var1, int var2) {
		var1 -= this.xInset;
		var2 -= this.yInset;
		int[] var10000 = this.flags[var1];
		var10000[var2] |= 2097152;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-88147521"
	)
	public void method3615(int var1, int var2) {
		var1 -= this.xInset;
		var2 -= this.yInset;
		int[] var10000 = this.flags[var1];
		var10000[var2] |= 262144;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "2136101912"
	)
	void method3616(int var1, int var2, int var3) {
		int[] var10000 = this.flags[var1];
		var10000[var2] |= var3;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IIIIZI)V",
		garbageValue = "1473004141"
	)
	public void method3617(int var1, int var2, int var3, int var4, boolean var5) {
		var1 -= this.xInset;
		var2 -= this.yInset;
		if (var3 == 0) {
			if (var4 == 0) {
				this.method3619(var1, var2, 128);
				this.method3619(var1 - 1, var2, 8);
			}

			if (var4 == 1) {
				this.method3619(var1, var2, 2);
				this.method3619(var1, var2 + 1, 32);
			}

			if (var4 == 2) {
				this.method3619(var1, var2, 8);
				this.method3619(var1 + 1, var2, 128);
			}

			if (var4 == 3) {
				this.method3619(var1, var2, 32);
				this.method3619(var1, var2 - 1, 2);
			}
		}

		if (var3 == 1 || var3 == 3) {
			if (var4 == 0) {
				this.method3619(var1, var2, 1);
				this.method3619(var1 - 1, var2 + 1, 16);
			}

			if (var4 == 1) {
				this.method3619(var1, var2, 4);
				this.method3619(var1 + 1, var2 + 1, 64);
			}

			if (var4 == 2) {
				this.method3619(var1, var2, 16);
				this.method3619(var1 + 1, var2 - 1, 1);
			}

			if (var4 == 3) {
				this.method3619(var1, var2, 64);
				this.method3619(var1 - 1, var2 - 1, 4);
			}
		}

		if (var3 == 2) {
			if (var4 == 0) {
				this.method3619(var1, var2, 130);
				this.method3619(var1 - 1, var2, 8);
				this.method3619(var1, var2 + 1, 32);
			}

			if (var4 == 1) {
				this.method3619(var1, var2, 10);
				this.method3619(var1, var2 + 1, 32);
				this.method3619(var1 + 1, var2, 128);
			}

			if (var4 == 2) {
				this.method3619(var1, var2, 40);
				this.method3619(var1 + 1, var2, 128);
				this.method3619(var1, var2 - 1, 2);
			}

			if (var4 == 3) {
				this.method3619(var1, var2, 160);
				this.method3619(var1, var2 - 1, 2);
				this.method3619(var1 - 1, var2, 8);
			}
		}

		if (var5) {
			if (var3 == 0) {
				if (var4 == 0) {
					this.method3619(var1, var2, 65536);
					this.method3619(var1 - 1, var2, 4096);
				}

				if (var4 == 1) {
					this.method3619(var1, var2, 1024);
					this.method3619(var1, var2 + 1, 16384);
				}

				if (var4 == 2) {
					this.method3619(var1, var2, 4096);
					this.method3619(var1 + 1, var2, 65536);
				}

				if (var4 == 3) {
					this.method3619(var1, var2, 16384);
					this.method3619(var1, var2 - 1, 1024);
				}
			}

			if (var3 == 1 || var3 == 3) {
				if (var4 == 0) {
					this.method3619(var1, var2, 512);
					this.method3619(var1 - 1, var2 + 1, 8192);
				}

				if (var4 == 1) {
					this.method3619(var1, var2, 2048);
					this.method3619(var1 + 1, var2 + 1, 32768);
				}

				if (var4 == 2) {
					this.method3619(var1, var2, 8192);
					this.method3619(var1 + 1, var2 - 1, 512);
				}

				if (var4 == 3) {
					this.method3619(var1, var2, 32768);
					this.method3619(var1 - 1, var2 - 1, 2048);
				}
			}

			if (var3 == 2) {
				if (var4 == 0) {
					this.method3619(var1, var2, 66560);
					this.method3619(var1 - 1, var2, 4096);
					this.method3619(var1, var2 + 1, 16384);
				}

				if (var4 == 1) {
					this.method3619(var1, var2, 5120);
					this.method3619(var1, var2 + 1, 16384);
					this.method3619(var1 + 1, var2, 65536);
				}

				if (var4 == 2) {
					this.method3619(var1, var2, 20480);
					this.method3619(var1 + 1, var2, 65536);
					this.method3619(var1, var2 - 1, 1024);
				}

				if (var4 == 3) {
					this.method3619(var1, var2, 81920);
					this.method3619(var1, var2 - 1, 1024);
					this.method3619(var1 - 1, var2, 4096);
				}
			}
		}

	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(IIIIIZI)V",
		garbageValue = "1811467744"
	)
	public void method3635(int var1, int var2, int var3, int var4, int var5, boolean var6) {
		int var7 = 256;
		if (var6) {
			var7 += 131072;
		}

		var1 -= this.xInset;
		var2 -= this.yInset;
		int var8;
		if (var5 == 1 || var5 == 3) {
			var8 = var3;
			var3 = var4;
			var4 = var8;
		}

		for (var8 = var1; var8 < var3 + var1; ++var8) {
			if (var8 >= 0 && var8 < this.xSize) {
				for (int var9 = var2; var9 < var2 + var4; ++var9) {
					if (var9 >= 0 && var9 < this.ySize) {
						this.method3619(var8, var9, var7);
					}
				}
			}
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IIIB)V",
		garbageValue = "61"
	)
	void method3619(int var1, int var2, int var3) {
		int[] var10000 = this.flags[var1];
		var10000[var2] &= ~var3;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "-25"
	)
	public void method3637(int var1, int var2) {
		var1 -= this.xInset;
		var2 -= this.yInset;
		int[] var10000 = this.flags[var1];
		var10000[var2] &= -262145;
	}

	public int[][] getFlags() {
		return this.flags;
	}
}
