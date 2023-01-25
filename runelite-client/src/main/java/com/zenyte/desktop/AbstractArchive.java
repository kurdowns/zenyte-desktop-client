package com.zenyte.desktop;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.BaseEncoding;
import com.google.common.io.ByteStreams;
import com.google.common.io.CharStreams;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import net.runelite.api.overlay.OverlayIndex;
import net.runelite.client.RuneLite;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSAbstractArchive;
import net.runelite.rs.api.RSArchive;
import org.slf4j.Logger;

@ObfuscatedName("iy")
public abstract class AbstractArchive implements RSAbstractArchive {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lmw;"
	)
	static GZipDecompressor gzipDecompressor;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1088785149
	)
	static int field3143;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1667499623
	)
	int groupCount;
	@ObfuscatedName("k")
	int[] groupIds;
	@ObfuscatedName("d")
	int[] groupNameHashes;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lmj;"
	)
	IntHashTable groupNameHashTable;
	@ObfuscatedName("v")
	int[] groupCrcs;
	@ObfuscatedName("q")
	int[] groupVersions;
	@ObfuscatedName("z")
	int[] fileCounts;
	@ObfuscatedName("t")
	int[][] fileIds;
	@ObfuscatedName("e")
	int[][] fileNameHashes;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "[Lmj;"
	)
	IntHashTable[] fileNameHashTables;
	@ObfuscatedName("p")
	Object[] groups;
	@ObfuscatedName("n")
	Object[][] files;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -1296799789
	)
	public int hash;
	@ObfuscatedName("g")
	boolean releaseGroups;
	@ObfuscatedName("i")
	boolean shallowFiles;
	public boolean overlayOutdated;

	static {
		gzipDecompressor = new GZipDecompressor();
		field3143 = 0;
	}

	AbstractArchive(boolean var1, boolean var2) {
		this.releaseGroups = var1;
		this.shallowFiles = var2;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "([BI)V",
		garbageValue = "32768"
	)
	void method4222(byte[] var1) {
		this.hash = GrandExchangeOfferUnitPriceComparator.method225(var1, var1.length);
		Buffer var2 = new Buffer(class217.method4013(var1));
		int var3 = var2.method5547();
		if (var3 >= 5 && var3 <= 7) {
			if (var3 >= 6) {
				var2.method5552();
			}

			int var4 = var2.method5547();
			if (var3 >= 7) {
				this.groupCount = var2.method5751();
			} else {
				this.groupCount = var2.method5549();
			}

			int var5 = 0;
			int var6 = -1;
			this.groupIds = new int[this.groupCount];
			int var7;
			if (var3 >= 7) {
				for (var7 = 0; var7 < this.groupCount; ++var7) {
					this.groupIds[var7] = var5 += var2.method5751();
					if (this.groupIds[var7] > var6) {
						var6 = this.groupIds[var7];
					}
				}
			} else {
				for (var7 = 0; var7 < this.groupCount; ++var7) {
					this.groupIds[var7] = var5 += var2.method5549();
					if (this.groupIds[var7] > var6) {
						var6 = this.groupIds[var7];
					}
				}
			}

			this.groupCrcs = new int[var6 + 1];
			this.groupVersions = new int[var6 + 1];
			this.fileCounts = new int[var6 + 1];
			this.fileIds = new int[var6 + 1][];
			this.groups = new Object[var6 + 1];
			this.files = new Object[var6 + 1][];
			if (var4 != 0) {
				this.groupNameHashes = new int[var6 + 1];

				for (var7 = 0; var7 < this.groupCount; ++var7) {
					this.groupNameHashes[this.groupIds[var7]] = var2.method5552();
				}

				this.groupNameHashTable = new IntHashTable(this.groupNameHashes);
			}

			for (var7 = 0; var7 < this.groupCount; ++var7) {
				this.groupCrcs[this.groupIds[var7]] = var2.method5552();
			}

			for (var7 = 0; var7 < this.groupCount; ++var7) {
				this.groupVersions[this.groupIds[var7]] = var2.method5552();
			}

			for (var7 = 0; var7 < this.groupCount; ++var7) {
				this.fileCounts[this.groupIds[var7]] = var2.method5549();
			}

			int var8;
			int var9;
			int var10;
			int var11;
			int var12;
			if (var3 >= 7) {
				for (var7 = 0; var7 < this.groupCount; ++var7) {
					var8 = this.groupIds[var7];
					var9 = this.fileCounts[var8];
					var5 = 0;
					var10 = -1;
					this.fileIds[var8] = new int[var9];

					for (var11 = 0; var11 < var9; ++var11) {
						var12 = this.fileIds[var8][var11] = var5 += var2.method5751();
						if (var12 > var10) {
							var10 = var12;
						}
					}

					this.files[var8] = new Object[var10 + 1];
				}
			} else {
				for (var7 = 0; var7 < this.groupCount; ++var7) {
					var8 = this.groupIds[var7];
					var9 = this.fileCounts[var8];
					var5 = 0;
					var10 = -1;
					this.fileIds[var8] = new int[var9];

					for (var11 = 0; var11 < var9; ++var11) {
						var12 = this.fileIds[var8][var11] = var5 += var2.method5549();
						if (var12 > var10) {
							var10 = var12;
						}
					}

					this.files[var8] = new Object[var10 + 1];
				}
			}

			if (var4 != 0) {
				this.fileNameHashes = new int[var6 + 1][];
				this.fileNameHashTables = new IntHashTable[var6 + 1];

				for (var7 = 0; var7 < this.groupCount; ++var7) {
					var8 = this.groupIds[var7];
					var9 = this.fileCounts[var8];
					this.fileNameHashes[var8] = new int[this.files[var8].length];

					for (var10 = 0; var10 < var9; ++var10) {
						this.fileNameHashes[var8][this.fileIds[var8][var10]] = var2.method5552();
					}

					this.fileNameHashTables[var8] = new IntHashTable(this.fileNameHashes[var8]);
				}
			}

		} else {
			throw new RuntimeException("");
		}
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-11"
	)
	void vmethod4321(int var1) {
	}

	@ObfuscatedName("k")
	public byte[] method4224(int var1, int var2, byte var3) {
		byte[] var4 = this.copy$takeFile(var1, var2, var3);
		int var5 = ((RSArchive)this).getIndex();
		if(!OverlayIndex.hasOverlay(var5, var1)) {
			return var4;
		} else {
			Logger var6 = WorldMapSection1.client.getLogger();
			InputStream var7 = this.getClass().getResourceAsStream("/runelite/" + var5 + "/" + var1);
			if(var7 == null) {
				var6.warn("Missing overlay data for {}/{}", Integer.valueOf(var5), Integer.valueOf(var1));
				return var4;
			} else {
				InputStream var8 = this.getClass().getResourceAsStream("/runelite/" + var5 + "/" + var1 + ".hash");
				if(var4 == null) {
					if(var8 != null) {
						var6.warn("Hash file for non existing archive {}/{}", Integer.valueOf(var5), Integer.valueOf(var1));
						return null;
					} else {
						var6.debug("Adding archive {}/{}", Integer.valueOf(var5), Integer.valueOf(var1));

						try {
							return ByteStreams.toByteArray(var7);
						} catch (IOException var12) {
							var6.warn("error loading archive replacement", var12);
							return null;
						}
					}
				} else if(var8 == null) {
					var6.warn("Missing hash file for {}/{}", Integer.valueOf(var5), Integer.valueOf(var1));
					return var4;
				} else {
					HashCode var9 = Hashing.sha256().hashBytes(var4);
					String var10 = BaseEncoding.base16().encode(var9.asBytes());

					try {
						String var11 = CharStreams.toString(new InputStreamReader(var8));
						if(var11.equals(var10)) {
							var6.debug("Replacing archive {}/{}", Integer.valueOf(var5), Integer.valueOf(var1));
							return ByteStreams.toByteArray(var7);
						}

						var6.warn("Mismatch in overlaid cache archive hash for {}/{}: {} != {}", new Object[]{Integer.valueOf(var5), Integer.valueOf(var1), var11, var10});
						this.overlayOutdated = true;
					} catch (IOException var13) {
						var6.warn("error checking hash", var13);
					}

					return var4;
				}
			}
		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(II[II)[B",
		garbageValue = "867631074"
	)
	public byte[] method4263(int var1, int var2, int[] var3) {
		if (var1 >= 0 && var1 < this.files.length && this.files[var1] != null && var2 >= 0 && var2 < this.files[var1].length) {
			if (this.files[var1][var2] == null) {
				boolean var4 = this.method4239(var1, var3);
				if (!var4) {
					this.vmethod4322(var1);
					var4 = this.method4239(var1, var3);
					if (!var4) {
						return null;
					}
				}
			}

			byte[] var5 = class39.method644(this.files[var1][var2], false);
			if (this.shallowFiles) {
				this.files[var1][var2] = null;
			}

			return var5;
		} else {
			return null;
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "1838243967"
	)
	public boolean method4238(int var1, int var2) {
		if (var1 >= 0 && var1 < this.files.length && this.files[var1] != null && var2 >= 0 && var2 < this.files[var1].length) {
			if (this.files[var1][var2] != null) {
				return true;
			} else if (this.groups[var1] != null) {
				return true;
			} else {
				this.vmethod4322(var1);
				return this.groups[var1] != null;
			}
		} else {
			return false;
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-700946668"
	)
	public boolean method4227(int var1) {
		if (this.files.length == 1) {
			return this.method4238(0, var1);
		} else if (this.files[var1].length == 1) {
			return this.method4238(var1, 0);
		} else {
			throw new RuntimeException();
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IB)Z",
		garbageValue = "-121"
	)
	public boolean method4250(int var1) {
		if (this.groups[var1] != null) {
			return true;
		} else {
			this.vmethod4322(var1);
			return this.groups[var1] != null;
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "2004742407"
	)
	public boolean method4229() {
		boolean var1 = true;

		for (int var2 = 0; var2 < this.groupIds.length; ++var2) {
			int var3 = this.groupIds[var2];
			if (this.groups[var3] == null) {
				this.vmethod4322(var3);
				if (this.groups[var3] == null) {
					var1 = false;
				}
			}
		}

		return var1;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "9"
	)
	int vmethod4346(int var1) {
		return this.groups[var1] != null ? 100 : 0;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(II)[B",
		garbageValue = "1070095083"
	)
	public byte[] method4231(int var1) {
		if (this.files.length == 1) {
			return this.method4224(0, var1, (byte)-120);
		} else if (this.files[var1].length == 1) {
			return this.method4224(var1, 0, (byte)-88);
		} else {
			throw new RuntimeException();
		}
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(III)[B",
		garbageValue = "1361179955"
	)
	public byte[] method4232(int var1, int var2) {
		if (var1 >= 0 && var1 < this.files.length && this.files[var1] != null && var2 >= 0 && var2 < this.files[var1].length) {
			if (this.files[var1][var2] == null) {
				boolean var3 = this.method4239(var1, (int[])null);
				if (!var3) {
					this.vmethod4322(var1);
					var3 = this.method4239(var1, (int[])null);
					if (!var3) {
						return null;
					}
				}
			}

			byte[] var4 = class39.method644(this.files[var1][var2], false);
			return var4;
		} else {
			return null;
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IB)[B",
		garbageValue = "100"
	)
	public byte[] method4225(int var1) {
		if (this.files.length == 1) {
			return this.method4232(0, var1);
		} else if (this.files[var1].length == 1) {
			return this.method4232(var1, 0);
		} else {
			throw new RuntimeException();
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-48"
	)
	void vmethod4322(int var1) {
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II)[I",
		garbageValue = "-2049646423"
	)
	public int[] method4234(int var1) {
		return var1 >= 0 && var1 < this.fileIds.length ? this.fileIds[var1] : null;
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "26"
	)
	public int method4246(int var1) {
		return this.files[var1].length;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-30"
	)
	public int method4235() {
		return this.files.length;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "504262227"
	)
	public void method4236() {
		for (int var1 = 0; var1 < this.groups.length; ++var1) {
			this.groups[var1] = null;
		}

	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1058828801"
	)
	public void method4237(int var1) {
		for (int var2 = 0; var2 < this.files[var1].length; ++var2) {
			this.files[var1][var2] = null;
		}

	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "3"
	)
	public void method4273() {
		for (int var1 = 0; var1 < this.files.length; ++var1) {
			if (this.files[var1] != null) {
				for (int var2 = 0; var2 < this.files[var1].length; ++var2) {
					this.files[var1][var2] = null;
				}
			}
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I[II)Z",
		garbageValue = "1499207460"
	)
	boolean method4239(int var1, int[] var2) {
		if (this.groups[var1] == null) {
			return false;
		} else {
			int var3 = this.fileCounts[var1];
			int[] var4 = this.fileIds[var1];
			Object[] var5 = this.files[var1];
			boolean var6 = true;

			for (int var7 = 0; var7 < var3; ++var7) {
				if (var5[var4[var7]] == null) {
					var6 = false;
					break;
				}
			}

			if (var6) {
				return true;
			} else {
				byte[] var21;
				if (var2 == null || var2[0] == 0 && var2[1] == 0 && var2[2] == 0 && var2[3] == 0) {
					var21 = class39.method644(this.groups[var1], false);
				} else {
					var21 = class39.method644(this.groups[var1], true);
					Buffer var8 = new Buffer(var21);
					var8.method5727(var2, 5, var8.array.length);
				}

				byte[] var25 = class217.method4013(var21);
				if (this.releaseGroups) {
					this.groups[var1] = null;
				}

				int var10;
				if (var3 > 1) {
					int var9 = var25.length;
					--var9;
					var10 = var25[var9] & 255;
					var9 -= var3 * var10 * 4;
					Buffer var11 = new Buffer(var25);
					int[] var12 = new int[var3];
					var11.offset = var9;

					int var14;
					int var15;
					for (int var13 = 0; var13 < var10; ++var13) {
						var14 = 0;

						for (var15 = 0; var15 < var3; ++var15) {
							var14 += var11.method5552();
							var12[var15] += var14;
						}
					}

					byte[][] var23 = new byte[var3][];

					for (var14 = 0; var14 < var3; ++var14) {
						var23[var14] = new byte[var12[var14]];
						var12[var14] = 0;
					}

					var11.offset = var9;
					var14 = 0;

					int var17;
					for (var15 = 0; var15 < var10; ++var15) {
						int var16 = 0;

						for (var17 = 0; var17 < var3; ++var17) {
							var16 += var11.method5552();
							System.arraycopy(var25, var14, var23[var17], var12[var17], var16);
							var12[var17] += var16;
							var14 += var16;
						}
					}

					for (var15 = 0; var15 < var3; ++var15) {
						if (!this.shallowFiles) {
							var17 = var4[var15];
							byte[] var19 = var23[var15];
							Object var18;
							if (var19 == null) {
								var18 = null;
							} else if (var19.length > 136) {
								DirectByteArrayCopier var20 = new DirectByteArrayCopier();
								var20.vmethod4006(var19);
								var18 = var20;
							} else {
								var18 = var19;
							}

							var5[var17] = var18;
						} else {
							var5[var4[var15]] = var23[var15];
						}
					}
				} else if (!this.shallowFiles) {
					var10 = var4[0];
					Object var26;
					if (var25 == null) {
						var26 = null;
					} else if (var25.length > 136) {
						DirectByteArrayCopier var27 = new DirectByteArrayCopier();
						var27.vmethod4006(var25);
						var26 = var27;
					} else {
						var26 = var25;
					}

					var5[var10] = var26;
				} else {
					var5[var4[0]] = var25;
				}

				return true;
			}
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;S)I",
		garbageValue = "20025"
	)
	public int method4240(String var1) {
		var1 = var1.toLowerCase();
		return this.groupNameHashTable.method6594(HealthBarDefinition.method4533(var1));
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)I",
		garbageValue = "709668582"
	)
	public int method4233(int var1, String var2) {
		var2 = var2.toLowerCase();
		return this.fileNameHashTables[var1].method6594(HealthBarDefinition.method4533(var2));
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
		garbageValue = "1971024882"
	)
	public boolean method4299(String var1, String var2) {
		var1 = var1.toLowerCase();
		var2 = var2.toLowerCase();
		int var3 = this.groupNameHashTable.method6594(HealthBarDefinition.method4533(var1));
		if (var3 < 0) {
			return false;
		} else {
			int var4 = this.fileNameHashTables[var3].method6594(HealthBarDefinition.method4533(var2));
			return var4 >= 0;
		}
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;I)[B",
		garbageValue = "-1226254785"
	)
	public byte[] method4223(String var1, String var2) {
		var1 = var1.toLowerCase();
		var2 = var2.toLowerCase();
		int var3 = this.groupNameHashTable.method6594(HealthBarDefinition.method4533(var1));
		int var4 = this.fileNameHashTables[var3].method6594(HealthBarDefinition.method4533(var2));
		return this.method4224(var3, var4, (byte)-55);
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
		garbageValue = "-612487532"
	)
	public boolean method4241(String var1, String var2) {
		var1 = var1.toLowerCase();
		var2 = var2.toLowerCase();
		int var3 = this.groupNameHashTable.method6594(HealthBarDefinition.method4533(var1));
		int var4 = this.fileNameHashTables[var3].method6594(HealthBarDefinition.method4533(var2));
		return this.method4238(var3, var4);
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;S)Z",
		garbageValue = "5353"
	)
	public boolean method4245(String var1) {
		var1 = var1.toLowerCase();
		int var2 = this.groupNameHashTable.method6594(HealthBarDefinition.method4533(var1));
		return this.method4250(var2);
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "904314096"
	)
	public void method4260(String var1) {
		var1 = var1.toLowerCase();
		int var2 = this.groupNameHashTable.method6594(HealthBarDefinition.method4533(var1));
		if (var2 >= 0) {
			this.vmethod4321(var2);
		}
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)I",
		garbageValue = "-63"
	)
	public int method4261(String var1) {
		var1 = var1.toLowerCase();
		int var2 = this.groupNameHashTable.method6594(HealthBarDefinition.method4533(var1));
		return this.vmethod4346(var2);
	}

	public byte[] copy$takeFile(int var1, int var2, byte var3) {
		return this.method4263(var1, var2, (int[])null);
	}

	public boolean isOverlayOutdated() {
		return this.overlayOutdated;
	}

	public byte[] getConfigData(int var1, int var2) {
		return this.method4224(var1, var2, (byte)-30);
	}
}
