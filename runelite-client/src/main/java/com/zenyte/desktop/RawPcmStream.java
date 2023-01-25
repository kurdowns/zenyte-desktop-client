package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSRawPcmStream;

@ObfuscatedName("dy")
public class RawPcmStream extends PcmStream implements RSRawPcmStream {
	@ObfuscatedName("x")
	int field1490;
	@ObfuscatedName("m")
	int field1481;
	@ObfuscatedName("k")
	int field1482;
	@ObfuscatedName("d")
	int field1483;
	@ObfuscatedName("v")
	int field1484;
	@ObfuscatedName("q")
	int field1489;
	@ObfuscatedName("z")
	int field1486;
	@ObfuscatedName("t")
	int numLoops;
	@ObfuscatedName("e")
	int start;
	@ObfuscatedName("s")
	int end;
	@ObfuscatedName("p")
	boolean field1493;
	@ObfuscatedName("n")
	int field1491;
	@ObfuscatedName("u")
	int field1485;
	@ObfuscatedName("h")
	int field1492;
	@ObfuscatedName("g")
	int field1494;

	@ObfuscatedSignature(
		signature = "(Ldm;II)V"
	)
	RawPcmStream(RawSound var1, int var2, int var3) {
		super.sound = var1;
		this.start = var1.start;
		this.end = var1.end;
		this.field1493 = var1.field1407;
		this.field1481 = var2;
		this.field1482 = var3;
		this.field1483 = 8192;
		this.field1490 = 0;
		this.method2644();
	}

	@ObfuscatedSignature(
		signature = "(Ldm;III)V"
	)
	RawPcmStream(RawSound var1, int var2, int var3, int var4) {
		super.sound = var1;
		this.start = var1.start;
		this.end = var1.end;
		this.field1493 = var1.field1407;
		this.field1481 = var2;
		this.field1482 = var3;
		this.field1483 = var4;
		this.field1490 = 0;
		this.method2644();
	}

	@ObfuscatedName("w")
	void method2644() {
		this.field1484 = this.field1482;
		this.field1489 = method2707(this.field1482, this.field1483);
		this.field1486 = method2638(this.field1482, this.field1483);
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "()Lds;"
	)
	protected PcmStream vmethod3962() {
		return null;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "()Lds;"
	)
	protected PcmStream vmethod3964() {
		return null;
	}

	@ObfuscatedName("z")
	protected int vmethod3963() {
		return this.field1482 == 0 && this.field1491 == 0 ? 0 : 1;
	}

	@ObfuscatedName("t")
	public synchronized void vmethod3966(int[] var1, int var2, int var3) {
		if (this.field1482 == 0 && this.field1491 == 0) {
			this.vmethod3967(var3);
		} else {
			RawSound var4 = (RawSound)super.sound;
			int var5 = this.start << 8;
			int var6 = this.end << 8;
			int var7 = var4.samples.length << 8;
			int var8 = var6 - var5;
			if (var8 <= 0) {
				this.numLoops = 0;
			}

			int var9 = var2;
			var3 += var2;
			if (this.field1490 < 0) {
				if (this.field1481 <= 0) {
					this.method2780();
					this.method3657();
					return;
				}

				this.field1490 = 0;
			}

			if (this.field1490 >= var7) {
				if (this.field1481 >= 0) {
					this.method2780();
					this.method3657();
					return;
				}

				this.field1490 = var7 - 1;
			}

			if (this.numLoops < 0) {
				if (this.field1493) {
					if (this.field1481 < 0) {
						var9 = this.method2665(var1, var2, var5, var3, var4.samples[this.start]);
						if (this.field1490 >= var5) {
							return;
						}

						this.field1490 = var5 + var5 - 1 - this.field1490;
						this.field1481 = -this.field1481;
					}

					while (true) {
						var9 = this.method2664(var1, var9, var6, var3, var4.samples[this.end - 1]);
						if (this.field1490 < var6) {
							return;
						}

						this.field1490 = var6 + var6 - 1 - this.field1490;
						this.field1481 = -this.field1481;
						var9 = this.method2665(var1, var9, var5, var3, var4.samples[this.start]);
						if (this.field1490 >= var5) {
							return;
						}

						this.field1490 = var5 + var5 - 1 - this.field1490;
						this.field1481 = -this.field1481;
					}
				} else if (this.field1481 < 0) {
					while (true) {
						var9 = this.method2665(var1, var9, var5, var3, var4.samples[this.end - 1]);
						if (this.field1490 >= var5) {
							return;
						}

						this.field1490 = var6 - 1 - (var6 - 1 - this.field1490) % var8;
					}
				} else {
					while (true) {
						var9 = this.method2664(var1, var9, var6, var3, var4.samples[this.start]);
						if (this.field1490 < var6) {
							return;
						}

						this.field1490 = var5 + (this.field1490 - var5) % var8;
					}
				}
			} else {
				if (this.numLoops > 0) {
					if (this.field1493) {
						label139: {
							if (this.field1481 < 0) {
								var9 = this.method2665(var1, var2, var5, var3, var4.samples[this.start]);
								if (this.field1490 >= var5) {
									return;
								}

								this.field1490 = var5 + var5 - 1 - this.field1490;
								this.field1481 = -this.field1481;
								if (--this.numLoops == 0) {
									break label139;
								}
							}

							do {
								var9 = this.method2664(var1, var9, var6, var3, var4.samples[this.end - 1]);
								if (this.field1490 < var6) {
									return;
								}

								this.field1490 = var6 + var6 - 1 - this.field1490;
								this.field1481 = -this.field1481;
								if (--this.numLoops == 0) {
									break;
								}

								var9 = this.method2665(var1, var9, var5, var3, var4.samples[this.start]);
								if (this.field1490 >= var5) {
									return;
								}

								this.field1490 = var5 + var5 - 1 - this.field1490;
								this.field1481 = -this.field1481;
							} while(--this.numLoops != 0);
						}
					} else {
						int var10;
						if (this.field1481 < 0) {
							while (true) {
								var9 = this.method2665(var1, var9, var5, var3, var4.samples[this.end - 1]);
								if (this.field1490 >= var5) {
									return;
								}

								var10 = (var6 - 1 - this.field1490) / var8;
								if (var10 >= this.numLoops) {
									this.field1490 += var8 * this.numLoops;
									this.numLoops = 0;
									break;
								}

								this.field1490 += var8 * var10;
								this.numLoops -= var10;
							}
						} else {
							while (true) {
								var9 = this.method2664(var1, var9, var6, var3, var4.samples[this.start]);
								if (this.field1490 < var6) {
									return;
								}

								var10 = (this.field1490 - var5) / var8;
								if (var10 >= this.numLoops) {
									this.field1490 -= var8 * this.numLoops;
									this.numLoops = 0;
									break;
								}

								this.field1490 -= var8 * var10;
								this.numLoops -= var10;
							}
						}
					}
				}

				if (this.field1481 < 0) {
					this.method2665(var1, var9, 0, var3, 0);
					if (this.field1490 < 0) {
						this.field1490 = -1;
						this.method2780();
						this.method3657();
					}
				} else {
					this.method2664(var1, var9, var7, var3, 0);
					if (this.field1490 >= var7) {
						this.field1490 = var7;
						this.method2780();
						this.method3657();
					}
				}

			}
		}
	}

	@ObfuscatedName("e")
	public synchronized void method2675(int var1) {
		this.numLoops = var1;
	}

	@ObfuscatedName("s")
	public synchronized void vmethod3967(int var1) {
		if (this.field1491 > 0) {
			if (var1 >= this.field1491) {
				if (this.field1482 == Integer.MIN_VALUE) {
					this.field1482 = 0;
					this.field1486 = 0;
					this.field1489 = 0;
					this.field1484 = 0;
					this.method3657();
					var1 = this.field1491;
				}

				this.field1491 = 0;
				this.method2644();
			} else {
				this.field1484 += this.field1485 * var1;
				this.field1489 += this.field1492 * var1;
				this.field1486 += this.field1494 * var1;
				this.field1491 -= var1;
			}
		}

		RawSound var2 = (RawSound)super.sound;
		int var3 = this.start << 8;
		int var4 = this.end << 8;
		int var5 = var2.samples.length << 8;
		int var6 = var4 - var3;
		if (var6 <= 0) {
			this.numLoops = 0;
		}

		if (this.field1490 < 0) {
			if (this.field1481 <= 0) {
				this.method2780();
				this.method3657();
				return;
			}

			this.field1490 = 0;
		}

		if (this.field1490 >= var5) {
			if (this.field1481 >= 0) {
				this.method2780();
				this.method3657();
				return;
			}

			this.field1490 = var5 - 1;
		}

		this.field1490 += this.field1481 * var1;
		if (this.numLoops < 0) {
			if (!this.field1493) {
				if (this.field1481 < 0) {
					if (this.field1490 >= var3) {
						return;
					}

					this.field1490 = var4 - 1 - (var4 - 1 - this.field1490) % var6;
				} else {
					if (this.field1490 < var4) {
						return;
					}

					this.field1490 = var3 + (this.field1490 - var3) % var6;
				}

			} else {
				if (this.field1481 < 0) {
					if (this.field1490 >= var3) {
						return;
					}

					this.field1490 = var3 + var3 - 1 - this.field1490;
					this.field1481 = -this.field1481;
				}

				while (this.field1490 >= var4) {
					this.field1490 = var4 + var4 - 1 - this.field1490;
					this.field1481 = -this.field1481;
					if (this.field1490 >= var3) {
						return;
					}

					this.field1490 = var3 + var3 - 1 - this.field1490;
					this.field1481 = -this.field1481;
				}

			}
		} else {
			if (this.numLoops > 0) {
				if (this.field1493) {
					label123: {
						if (this.field1481 < 0) {
							if (this.field1490 >= var3) {
								return;
							}

							this.field1490 = var3 + var3 - 1 - this.field1490;
							this.field1481 = -this.field1481;
							if (--this.numLoops == 0) {
								break label123;
							}
						}

						do {
							if (this.field1490 < var4) {
								return;
							}

							this.field1490 = var4 + var4 - 1 - this.field1490;
							this.field1481 = -this.field1481;
							if (--this.numLoops == 0) {
								break;
							}

							if (this.field1490 >= var3) {
								return;
							}

							this.field1490 = var3 + var3 - 1 - this.field1490;
							this.field1481 = -this.field1481;
						} while(--this.numLoops != 0);
					}
				} else {
					int var7;
					if (this.field1481 < 0) {
						if (this.field1490 >= var3) {
							return;
						}

						var7 = (var4 - 1 - this.field1490) / var6;
						if (var7 < this.numLoops) {
							this.field1490 += var6 * var7;
							this.numLoops -= var7;
							return;
						}

						this.field1490 += var6 * this.numLoops;
						this.numLoops = 0;
					} else {
						if (this.field1490 < var4) {
							return;
						}

						var7 = (this.field1490 - var3) / var6;
						if (var7 < this.numLoops) {
							this.field1490 -= var6 * var7;
							this.numLoops -= var7;
							return;
						}

						this.field1490 -= var6 * this.numLoops;
						this.numLoops = 0;
					}
				}
			}

			if (this.field1481 < 0) {
				if (this.field1490 < 0) {
					this.field1490 = -1;
					this.method2780();
					this.method3657();
				}
			} else if (this.field1490 >= var5) {
				this.field1490 = var5;
				this.method2780();
				this.method3657();
			}

		}
	}

	@ObfuscatedName("p")
	public synchronized void method2645(int var1) {
		this.method2647(var1 << 6, this.method2649());
	}

	@ObfuscatedName("n")
	synchronized void method2668(int var1) {
		this.method2647(var1, this.method2649());
	}

	@ObfuscatedName("u")
	synchronized void method2647(int var1, int var2) {
		this.field1482 = var1;
		this.field1483 = var2;
		this.field1491 = 0;
		this.method2644();
	}

	@ObfuscatedName("h")
	public synchronized int method2648() {
		return this.field1482 == Integer.MIN_VALUE ? 0 : this.field1482;
	}

	@ObfuscatedName("g")
	public synchronized int method2649() {
		return this.field1483 < 0 ? -1 : this.field1483;
	}

	@ObfuscatedName("i")
	public synchronized void method2650(int var1) {
		int var2 = ((RawSound)super.sound).samples.length << 8;
		if (var1 < -1) {
			var1 = -1;
		}

		if (var1 > var2) {
			var1 = var2;
		}

		this.field1490 = var1;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Z)V",
		garbageValue = "1"
	)
	public synchronized void method2641() {
		this.field1481 = (this.field1481 ^ this.field1481 >> 31) + (this.field1481 >>> 31);
		this.field1481 = -this.field1481;
	}

	@ObfuscatedName("o")
	void method2780() {
		if (this.field1491 != 0) {
			if (this.field1482 == Integer.MIN_VALUE) {
				this.field1482 = 0;
			}

			this.field1491 = 0;
			this.method2644();
		}

	}

	@ObfuscatedName("c")
	public synchronized void method2652(int var1, int var2) {
		this.method2690(var1, var2, this.method2649());
	}

	@ObfuscatedName("f")
	public synchronized void method2690(int var1, int var2, int var3) {
		if (var1 == 0) {
			this.method2647(var2, var3);
		} else {
			int var4 = method2707(var2, var3);
			int var5 = method2638(var2, var3);
			if (var4 == this.field1489 && var5 == this.field1486) {
				this.field1491 = 0;
			} else {
				int var6 = var2 - this.field1484;
				if (this.field1484 - var2 > var6) {
					var6 = this.field1484 - var2;
				}

				if (var4 - this.field1489 > var6) {
					var6 = var4 - this.field1489;
				}

				if (this.field1489 - var4 > var6) {
					var6 = this.field1489 - var4;
				}

				if (var5 - this.field1486 > var6) {
					var6 = var5 - this.field1486;
				}

				if (this.field1486 - var5 > var6) {
					var6 = this.field1486 - var5;
				}

				if (var1 > var6) {
					var1 = var6;
				}

				this.field1491 = var1;
				this.field1482 = var2;
				this.field1483 = var3;
				this.field1485 = (var2 - this.field1484) / var1;
				this.field1492 = (var4 - this.field1489) / var1;
				this.field1494 = (var5 - this.field1486) / var1;
			}
		}
	}

	@ObfuscatedName("ae")
	public synchronized void method2692(int var1) {
		if (var1 == 0) {
			this.method2668(0);
			this.method3657();
		} else if (this.field1489 == 0 && this.field1486 == 0) {
			this.field1491 = 0;
			this.field1482 = 0;
			this.field1484 = 0;
			this.method3657();
		} else {
			int var2 = -this.field1484;
			if (this.field1484 > var2) {
				var2 = this.field1484;
			}

			if (-this.field1489 > var2) {
				var2 = -this.field1489;
			}

			if (this.field1489 > var2) {
				var2 = this.field1489;
			}

			if (-this.field1486 > var2) {
				var2 = -this.field1486;
			}

			if (this.field1486 > var2) {
				var2 = this.field1486;
			}

			if (var1 > var2) {
				var1 = var2;
			}

			this.field1491 = var1;
			this.field1482 = Integer.MIN_VALUE;
			this.field1485 = -this.field1484 / var1;
			this.field1492 = -this.field1489 / var1;
			this.field1494 = -this.field1486 / var1;
		}
	}

	@ObfuscatedName("an")
	public synchronized void method2655(int var1) {
		if (this.field1481 < 0) {
			this.field1481 = -var1;
		} else {
			this.field1481 = var1;
		}

	}

	@ObfuscatedName("ai")
	public synchronized int method2656() {
		return this.field1481 < 0 ? -this.field1481 : this.field1481;
	}

	@ObfuscatedName("ap")
	public boolean method2657() {
		return this.field1490 < 0 || this.field1490 >= ((RawSound)super.sound).samples.length << 8;
	}

	@ObfuscatedName("av")
	public boolean method2658() {
		return this.field1491 != 0;
	}

	@ObfuscatedName("ak")
	int method2664(int[] var1, int var2, int var3, int var4, int var5) {
		while (true) {
			if (this.field1491 > 0) {
				int var6 = var2 + this.field1491;
				if (var6 > var4) {
					var6 = var4;
				}

				this.field1491 += var2;
				if (this.field1481 == 256 && (this.field1490 & 255) == 0) {
					if (PcmPlayer.PcmPlayer_stereo) {
						var2 = method2739(0, ((RawSound)super.sound).samples, var1, this.field1490, var2, this.field1489, this.field1486, this.field1492, this.field1494, 0, var6, var3, this);
					} else {
						var2 = method2696(((RawSound)super.sound).samples, var1, this.field1490, var2, this.field1484, this.field1485, 0, var6, var3, this);
					}
				} else if (PcmPlayer.PcmPlayer_stereo) {
					var2 = method2680(0, 0, ((RawSound)super.sound).samples, var1, this.field1490, var2, this.field1489, this.field1486, this.field1492, this.field1494, 0, var6, var3, this, this.field1481, var5);
				} else {
					var2 = method2679(0, 0, ((RawSound)super.sound).samples, var1, this.field1490, var2, this.field1484, this.field1485, 0, var6, var3, this, this.field1481, var5);
				}

				this.field1491 -= var2;
				if (this.field1491 != 0) {
					return var2;
				}

				if (!this.method2772()) {
					continue;
				}

				return var4;
			}

			if (this.field1481 == 256 && (this.field1490 & 255) == 0) {
				if (PcmPlayer.PcmPlayer_stereo) {
					return method2704(0, ((RawSound)super.sound).samples, var1, this.field1490, var2, this.field1489, this.field1486, 0, var4, var3, this);
				}

				return method2676(((RawSound)super.sound).samples, var1, this.field1490, var2, this.field1484, 0, var4, var3, this);
			}

			if (PcmPlayer.PcmPlayer_stereo) {
				return method2672(0, 0, ((RawSound)super.sound).samples, var1, this.field1490, var2, this.field1489, this.field1486, 0, var4, var3, this, this.field1481, var5);
			}

			return method2677(0, 0, ((RawSound)super.sound).samples, var1, this.field1490, var2, this.field1484, 0, var4, var3, this, this.field1481, var5);
		}
	}

	@ObfuscatedName("aa")
	int method2665(int[] var1, int var2, int var3, int var4, int var5) {
		while (true) {
			if (this.field1491 > 0) {
				int var6 = var2 + this.field1491;
				if (var6 > var4) {
					var6 = var4;
				}

				this.field1491 += var2;
				if (this.field1481 == -256 && (this.field1490 & 255) == 0) {
					if (PcmPlayer.PcmPlayer_stereo) {
						var2 = method2705(0, ((RawSound)super.sound).samples, var1, this.field1490, var2, this.field1489, this.field1486, this.field1492, this.field1494, 0, var6, var3, this);
					} else {
						var2 = method2669(((RawSound)super.sound).samples, var1, this.field1490, var2, this.field1484, this.field1485, 0, var6, var3, this);
					}
				} else if (PcmPlayer.PcmPlayer_stereo) {
					var2 = method2767(0, 0, ((RawSound)super.sound).samples, var1, this.field1490, var2, this.field1489, this.field1486, this.field1492, this.field1494, 0, var6, var3, this, this.field1481, var5);
				} else {
					var2 = method2724(0, 0, ((RawSound)super.sound).samples, var1, this.field1490, var2, this.field1484, this.field1485, 0, var6, var3, this, this.field1481, var5);
				}

				this.field1491 -= var2;
				if (this.field1491 != 0) {
					return var2;
				}

				if (!this.method2772()) {
					continue;
				}

				return var4;
			}

			if (this.field1481 == -256 && (this.field1490 & 255) == 0) {
				if (PcmPlayer.PcmPlayer_stereo) {
					return method2734(0, ((RawSound)super.sound).samples, var1, this.field1490, var2, this.field1489, this.field1486, 0, var4, var3, this);
				}

				return method2667(((RawSound)super.sound).samples, var1, this.field1490, var2, this.field1484, 0, var4, var3, this);
			}

			if (PcmPlayer.PcmPlayer_stereo) {
				return method2674(0, 0, ((RawSound)super.sound).samples, var1, this.field1490, var2, this.field1489, this.field1486, 0, var4, var3, this, this.field1481, var5);
			}

			return method2673(0, 0, ((RawSound)super.sound).samples, var1, this.field1490, var2, this.field1484, 0, var4, var3, this, this.field1481, var5);
		}
	}

	@ObfuscatedName("ax")
	boolean method2772() {
		int var1 = this.field1482;
		int var2;
		int var3;
		if (var1 == Integer.MIN_VALUE) {
			var3 = 0;
			var2 = 0;
			var1 = 0;
		} else {
			var2 = method2707(var1, this.field1483);
			var3 = method2638(var1, this.field1483);
		}

		if (var1 == this.field1484 && var2 == this.field1489 && var3 == this.field1486) {
			if (this.field1482 == Integer.MIN_VALUE) {
				this.field1482 = 0;
				this.field1486 = 0;
				this.field1489 = 0;
				this.field1484 = 0;
				this.method3657();
				return true;
			} else {
				this.method2644();
				return false;
			}
		} else {
			if (this.field1484 < var1) {
				this.field1485 = 1;
				this.field1491 = var1 - this.field1484;
			} else if (this.field1484 > var1) {
				this.field1485 = -1;
				this.field1491 = this.field1484 - var1;
			} else {
				this.field1485 = 0;
			}

			if (this.field1489 < var2) {
				this.field1492 = 1;
				if (this.field1491 == 0 || this.field1491 > var2 - this.field1489) {
					this.field1491 = var2 - this.field1489;
				}
			} else if (this.field1489 > var2) {
				this.field1492 = -1;
				if (this.field1491 == 0 || this.field1491 > this.field1489 - var2) {
					this.field1491 = this.field1489 - var2;
				}
			} else {
				this.field1492 = 0;
			}

			if (this.field1486 < var3) {
				this.field1494 = 1;
				if (this.field1491 == 0 || this.field1491 > var3 - this.field1486) {
					this.field1491 = var3 - this.field1486;
				}
			} else if (this.field1486 > var3) {
				this.field1494 = -1;
				if (this.field1491 == 0 || this.field1491 > this.field1486 - var3) {
					this.field1491 = this.field1486 - var3;
				}
			} else {
				this.field1494 = 0;
			}

			return false;
		}
	}

	@ObfuscatedName("ac")
	int vmethod2806() {
		int var1 = this.field1484 * 3 >> 6;
		var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
		if (this.numLoops == 0) {
			var1 -= var1 * this.field1490 / (((RawSound)super.sound).samples.length << 8);
		} else if (this.numLoops >= 0) {
			var1 -= var1 * this.start / ((RawSound)super.sound).samples.length;
		}

		return var1 > 255 ? 255 : var1;
	}

	public void setNumLoops(int var1) {
		this.method2675(var1);
	}

	@ObfuscatedName("x")
	static int method2707(int var0, int var1) {
		return var1 < 0 ? var0 : (int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
	}

	@ObfuscatedName("m")
	static int method2638(int var0, int var1) {
		return var1 < 0 ? -var0 : (int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Ldm;II)Ldy;"
	)
	public static RawPcmStream method2640(RawSound var0, int var1, int var2) {
		return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, (int)((long)var0.sampleRate * 256L * (long)var1 / (long)(PcmPlayer.field1421 * 100)), var2 << 6) : null;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Ldm;III)Ldy;"
	)
	public static RawPcmStream method2671(RawSound var0, int var1, int var2, int var3) {
		return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, var1, var2, var3) : null;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIILdy;)I"
	)
	static int method2676(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
		var2 >>= 8;
		var7 >>= 8;
		var4 <<= 2;
		if ((var5 = var3 + var7 - var2) > var6) {
			var5 = var6;
		}

		int var10001;
		for (var5 -= 3; var3 < var5; var1[var10001] += var0[var2++] * var4) {
			var10001 = var3++;
			var1[var10001] += var0[var2++] * var4;
			var10001 = var3++;
			var1[var10001] += var0[var2++] * var4;
			var10001 = var3++;
			var1[var10001] += var0[var2++] * var4;
			var10001 = var3++;
		}

		for (var5 += 3; var3 < var5; var1[var10001] += var0[var2++] * var4) {
			var10001 = var3++;
		}

		var8.field1490 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIILdy;)I"
	)
	static int method2704(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
		var3 >>= 8;
		var9 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		if ((var7 = var4 + var9 - var3) > var8) {
			var7 = var8;
		}

		var4 <<= 1;
		var7 <<= 1;

		int var10001;
		byte var11;
		for (var7 -= 6; var4 < var7; var2[var10001] += var11 * var6) {
			var11 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
			var2[var10001] += var11 * var6;
			var11 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
			var2[var10001] += var11 * var6;
			var11 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
			var2[var10001] += var11 * var6;
			var11 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
		}

		for (var7 += 6; var4 < var7; var2[var10001] += var11 * var6) {
			var11 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
		}

		var10.field1490 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIILdy;)I"
	)
	static int method2667(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
		var2 >>= 8;
		var7 >>= 8;
		var4 <<= 2;
		if ((var5 = var3 + var2 - (var7 - 1)) > var6) {
			var5 = var6;
		}

		int var10001;
		for (var5 -= 3; var3 < var5; var1[var10001] += var0[var2--] * var4) {
			var10001 = var3++;
			var1[var10001] += var0[var2--] * var4;
			var10001 = var3++;
			var1[var10001] += var0[var2--] * var4;
			var10001 = var3++;
			var1[var10001] += var0[var2--] * var4;
			var10001 = var3++;
		}

		for (var5 += 3; var3 < var5; var1[var10001] += var0[var2--] * var4) {
			var10001 = var3++;
		}

		var8.field1490 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIILdy;)I"
	)
	static int method2734(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
		var3 >>= 8;
		var9 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		if ((var7 = var3 + var4 - (var9 - 1)) > var8) {
			var7 = var8;
		}

		var4 <<= 1;
		var7 <<= 1;

		int var10001;
		byte var11;
		for (var7 -= 6; var4 < var7; var2[var10001] += var11 * var6) {
			var11 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
			var2[var10001] += var11 * var6;
			var11 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
			var2[var10001] += var11 * var6;
			var11 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
			var2[var10001] += var11 * var6;
			var11 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
		}

		for (var7 += 6; var4 < var7; var2[var10001] += var11 * var6) {
			var11 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
		}

		var10.field1490 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIILdy;II)I"
	)
	static int method2677(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
		if (var11 == 0 || (var7 = var5 + (var11 + (var9 - var4) - 257) / var11) > var8) {
			var7 = var8;
		}

		byte var13;
		int var10001;
		while (var5 < var7) {
			var1 = var4 >> 8;
			var13 = var2[var1];
			var10001 = var5++;
			var3[var10001] += ((var13 << 8) + (var2[var1 + 1] - var13) * (var4 & 255)) * var6 >> 6;
			var4 += var11;
		}

		if (var11 == 0 || (var7 = var5 + (var11 + (var9 - var4) - 1) / var11) > var8) {
			var7 = var8;
		}

		for (var1 = var12; var5 < var7; var4 += var11) {
			var13 = var2[var4 >> 8];
			var10001 = var5++;
			var3[var10001] += ((var13 << 8) + (var1 - var13) * (var4 & 255)) * var6 >> 6;
		}

		var10.field1490 = var4;
		return var5;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILdy;II)I"
	)
	static int method2672(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
			var8 = var9;
		}

		var5 <<= 1;

		byte var14;
		int var10001;
		for (var8 <<= 1; var5 < var8; var4 += var12) {
			var1 = var4 >> 8;
			var14 = var2[var1];
			var0 = (var14 << 8) + (var4 & 255) * (var2[var1 + 1] - var14);
			var10001 = var5++;
			var3[var10001] += var0 * var6 >> 6;
			var10001 = var5++;
			var3[var10001] += var0 * var7 >> 6;
		}

		if (var12 == 0 || (var8 = (var5 >> 1) + (var10 - var4 + var12 - 1) / var12) > var9) {
			var8 = var9;
		}

		var8 <<= 1;

		for (var1 = var13; var5 < var8; var4 += var12) {
			var14 = var2[var4 >> 8];
			var0 = (var14 << 8) + (var1 - var14) * (var4 & 255);
			var10001 = var5++;
			var3[var10001] += var0 * var6 >> 6;
			var10001 = var5++;
			var3[var10001] += var0 * var7 >> 6;
		}

		var11.field1490 = var4;
		return var5 >> 1;
	}

	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIILdy;II)I"
	)
	static int method2673(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
		if (var11 == 0 || (var7 = var5 + (var11 + (var9 + 256 - var4)) / var11) > var8) {
			var7 = var8;
		}

		int var10001;
		while (var5 < var7) {
			var1 = var4 >> 8;
			byte var13 = var2[var1 - 1];
			var10001 = var5++;
			var3[var10001] += ((var13 << 8) + (var2[var1] - var13) * (var4 & 255)) * var6 >> 6;
			var4 += var11;
		}

		if (var11 == 0 || (var7 = var5 + (var11 + (var9 - var4)) / var11) > var8) {
			var7 = var8;
		}

		var0 = var12;

		for (var1 = var11; var5 < var7; var4 += var1) {
			var10001 = var5++;
			var3[var10001] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
		}

		var10.field1490 = var4;
		return var5;
	}

	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILdy;II)I"
	)
	static int method2674(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		if (var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
			var8 = var9;
		}

		var5 <<= 1;

		int var10001;
		for (var8 <<= 1; var5 < var8; var4 += var12) {
			var1 = var4 >> 8;
			byte var14 = var2[var1 - 1];
			var0 = (var2[var1] - var14) * (var4 & 255) + (var14 << 8);
			var10001 = var5++;
			var3[var10001] += var0 * var6 >> 6;
			var10001 = var5++;
			var3[var10001] += var0 * var7 >> 6;
		}

		if (var12 == 0 || (var8 = (var5 >> 1) + (var10 - var4 + var12) / var12) > var9) {
			var8 = var9;
		}

		var8 <<= 1;

		for (var1 = var13; var5 < var8; var4 += var12) {
			var0 = (var1 << 8) + (var4 & 255) * (var2[var4 >> 8] - var1);
			var10001 = var5++;
			var3[var10001] += var0 * var6 >> 6;
			var10001 = var5++;
			var3[var10001] += var0 * var7 >> 6;
		}

		var11.field1490 = var4;
		return var5 >> 1;
	}

	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIIILdy;)I"
	)
	static int method2696(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
		var2 >>= 8;
		var8 >>= 8;
		var4 <<= 2;
		var5 <<= 2;
		if ((var6 = var3 + var8 - var2) > var7) {
			var6 = var7;
		}

		var9.field1489 += var9.field1492 * (var6 - var3);
		var9.field1486 += var9.field1494 * (var6 - var3);

		int var10001;
		for (var6 -= 3; var3 < var6; var4 += var5) {
			var10001 = var3++;
			var1[var10001] += var0[var2++] * var4;
			var4 += var5;
			var10001 = var3++;
			var1[var10001] += var0[var2++] * var4;
			var4 += var5;
			var10001 = var3++;
			var1[var10001] += var0[var2++] * var4;
			var4 += var5;
			var10001 = var3++;
			var1[var10001] += var0[var2++] * var4;
		}

		for (var6 += 3; var3 < var6; var4 += var5) {
			var10001 = var3++;
			var1[var10001] += var0[var2++] * var4;
		}

		var9.field1484 = var4 >> 2;
		var9.field1490 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIIIILdy;)I"
	)
	static int method2739(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
		var3 >>= 8;
		var11 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		var7 <<= 2;
		var8 <<= 2;
		if ((var9 = var11 + var4 - var3) > var10) {
			var9 = var10;
		}

		var12.field1484 += var12.field1485 * (var9 - var4);
		var4 <<= 1;
		var9 <<= 1;

		byte var13;
		int var10001;
		for (var9 -= 6; var4 < var9; var6 += var8) {
			var13 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
			var6 += var8;
			var13 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
			var6 += var8;
			var13 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
			var6 += var8;
			var13 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
		}

		for (var9 += 6; var4 < var9; var6 += var8) {
			var13 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
		}

		var12.field1489 = var5 >> 2;
		var12.field1486 = var6 >> 2;
		var12.field1490 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		signature = "([B[IIIIIIIILdy;)I"
	)
	static int method2669(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
		var2 >>= 8;
		var8 >>= 8;
		var4 <<= 2;
		var5 <<= 2;
		if ((var6 = var3 + var2 - (var8 - 1)) > var7) {
			var6 = var7;
		}

		var9.field1489 += var9.field1492 * (var6 - var3);
		var9.field1486 += var9.field1494 * (var6 - var3);

		int var10001;
		for (var6 -= 3; var3 < var6; var4 += var5) {
			var10001 = var3++;
			var1[var10001] += var0[var2--] * var4;
			var4 += var5;
			var10001 = var3++;
			var1[var10001] += var0[var2--] * var4;
			var4 += var5;
			var10001 = var3++;
			var1[var10001] += var0[var2--] * var4;
			var4 += var5;
			var10001 = var3++;
			var1[var10001] += var0[var2--] * var4;
		}

		for (var6 += 3; var3 < var6; var4 += var5) {
			var10001 = var3++;
			var1[var10001] += var0[var2--] * var4;
		}

		var9.field1484 = var4 >> 2;
		var9.field1490 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("bu")
	@ObfuscatedSignature(
		signature = "(I[B[IIIIIIIIIILdy;)I"
	)
	static int method2705(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
		var3 >>= 8;
		var11 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		var7 <<= 2;
		var8 <<= 2;
		if ((var9 = var3 + var4 - (var11 - 1)) > var10) {
			var9 = var10;
		}

		var12.field1484 += var12.field1485 * (var9 - var4);
		var4 <<= 1;
		var9 <<= 1;

		byte var13;
		int var10001;
		for (var9 -= 6; var4 < var9; var6 += var8) {
			var13 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
			var6 += var8;
			var13 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
			var6 += var8;
			var13 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
			var6 += var8;
			var13 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
		}

		for (var9 += 6; var4 < var9; var6 += var8) {
			var13 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
		}

		var12.field1489 = var5 >> 2;
		var12.field1486 = var6 >> 2;
		var12.field1490 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("be")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILdy;II)I"
	)
	static int method2679(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		var11.field1489 -= var11.field1492 * var5;
		var11.field1486 -= var11.field1494 * var5;
		if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
			var8 = var9;
		}

		byte var14;
		int var10001;
		while (var5 < var8) {
			var1 = var4 >> 8;
			var14 = var2[var1];
			var10001 = var5++;
			var3[var10001] += ((var14 << 8) + (var2[var1 + 1] - var14) * (var4 & 255)) * var6 >> 6;
			var6 += var7;
			var4 += var12;
		}

		if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 1) / var12) > var9) {
			var8 = var9;
		}

		for (var1 = var13; var5 < var8; var4 += var12) {
			var14 = var2[var4 >> 8];
			var10001 = var5++;
			var3[var10001] += ((var14 << 8) + (var1 - var14) * (var4 & 255)) * var6 >> 6;
			var6 += var7;
		}

		var11.field1489 += var11.field1492 * var5;
		var11.field1486 += var11.field1494 * var5;
		var11.field1484 = var6;
		var11.field1490 = var4;
		return var5;
	}

	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIIIILdy;II)I"
	)
	static int method2680(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
		var13.field1484 -= var5 * var13.field1485;
		if (var14 == 0 || (var10 = var5 + (var12 - var4 + var14 - 257) / var14) > var11) {
			var10 = var11;
		}

		var5 <<= 1;

		byte var16;
		int var10001;
		for (var10 <<= 1; var5 < var10; var4 += var14) {
			var1 = var4 >> 8;
			var16 = var2[var1];
			var0 = (var16 << 8) + (var4 & 255) * (var2[var1 + 1] - var16);
			var10001 = var5++;
			var3[var10001] += var0 * var6 >> 6;
			var6 += var8;
			var10001 = var5++;
			var3[var10001] += var0 * var7 >> 6;
			var7 += var9;
		}

		if (var14 == 0 || (var10 = (var5 >> 1) + (var12 - var4 + var14 - 1) / var14) > var11) {
			var10 = var11;
		}

		var10 <<= 1;

		for (var1 = var15; var5 < var10; var4 += var14) {
			var16 = var2[var4 >> 8];
			var0 = (var16 << 8) + (var1 - var16) * (var4 & 255);
			var10001 = var5++;
			var3[var10001] += var0 * var6 >> 6;
			var6 += var8;
			var10001 = var5++;
			var3[var10001] += var0 * var7 >> 6;
			var7 += var9;
		}

		var5 >>= 1;
		var13.field1484 += var13.field1485 * var5;
		var13.field1489 = var6;
		var13.field1486 = var7;
		var13.field1490 = var4;
		return var5;
	}

	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIILdy;II)I"
	)
	static int method2724(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		var11.field1489 -= var11.field1492 * var5;
		var11.field1486 -= var11.field1494 * var5;
		if (var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
			var8 = var9;
		}

		int var10001;
		while (var5 < var8) {
			var1 = var4 >> 8;
			byte var14 = var2[var1 - 1];
			var10001 = var5++;
			var3[var10001] += ((var14 << 8) + (var2[var1] - var14) * (var4 & 255)) * var6 >> 6;
			var6 += var7;
			var4 += var12;
		}

		if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12) / var12) > var9) {
			var8 = var9;
		}

		var0 = var13;

		for (var1 = var12; var5 < var8; var4 += var1) {
			var10001 = var5++;
			var3[var10001] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
			var6 += var7;
		}

		var11.field1489 += var11.field1492 * var5;
		var11.field1486 += var11.field1494 * var5;
		var11.field1484 = var6;
		var11.field1490 = var4;
		return var5;
	}

	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		signature = "(II[B[IIIIIIIIIILdy;II)I"
	)
	static int method2767(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
		var13.field1484 -= var5 * var13.field1485;
		if (var14 == 0 || (var10 = var5 + (var12 + 256 - var4 + var14) / var14) > var11) {
			var10 = var11;
		}

		var5 <<= 1;

		int var10001;
		for (var10 <<= 1; var5 < var10; var4 += var14) {
			var1 = var4 >> 8;
			byte var16 = var2[var1 - 1];
			var0 = (var2[var1] - var16) * (var4 & 255) + (var16 << 8);
			var10001 = var5++;
			var3[var10001] += var0 * var6 >> 6;
			var6 += var8;
			var10001 = var5++;
			var3[var10001] += var0 * var7 >> 6;
			var7 += var9;
		}

		if (var14 == 0 || (var10 = (var5 >> 1) + (var12 - var4 + var14) / var14) > var11) {
			var10 = var11;
		}

		var10 <<= 1;

		for (var1 = var15; var5 < var10; var4 += var14) {
			var0 = (var1 << 8) + (var4 & 255) * (var2[var4 >> 8] - var1);
			var10001 = var5++;
			var3[var10001] += var0 * var6 >> 6;
			var6 += var8;
			var10001 = var5++;
			var3[var10001] += var0 * var7 >> 6;
			var7 += var9;
		}

		var5 >>= 1;
		var13.field1484 += var13.field1485 * var5;
		var13.field1489 = var6;
		var13.field1486 = var7;
		var13.field1490 = var4;
		return var5;
	}
}
