package com.zenyte.desktop;

import net.runelite.api.events.DynamicObjectAnimationChanged;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSDynamicObject;
import net.runelite.rs.api.RSEntity;

@ObfuscatedName("cv")
public class DynamicObject extends Entity implements RSDynamicObject {
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -778595855
	)
	int id;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1719688801
	)
	int type;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1645761999
	)
	int orientation;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1021480433
	)
	int plane;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1939594765
	)
	int x;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 456415143
	)
	int y;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Ljc;"
	)
	SequenceDefinition sequenceDefinition;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -2053050533
	)
	int frame;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1933430481
	)
	int cycleStart;
	public int animationID;

	@ObfuscatedSignature(
		signature = "(IIIIIIIZLee;)V"
	)
	DynamicObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Entity var9) {
		this.id = var1;
		this.type = var2;
		this.orientation = var3;
		this.plane = var4;
		this.x = var5;
		this.y = var6;
		if (var7 != -1) {
			this.sequenceDefinition = SpotAnimationDefinition.method4478(var7);
			this.frame = 0;
			this.cycleStart = Client.cycle - 1;
			this.onAnimCycleCountChanged(-1);
			if (this.sequenceDefinition.field3525 == 0 && var9 != null && var9 instanceof DynamicObject) {
				DynamicObject var10 = (DynamicObject)var9;
				if (this.sequenceDefinition == var10.sequenceDefinition) {
					this.frame = var10.frame;
					this.cycleStart = var10.cycleStart;
					this.onAnimCycleCountChanged(-1);
					this.rl$init(var1, var2, var3, var4, var5, var6, var7, var8, var9);
					return;
				}
			}

			if (var8 && this.sequenceDefinition.frameCount != -1) {
				this.frame = (int)(Math.random() * (double)this.sequenceDefinition.frameIds.length);
				this.cycleStart -= (int)(Math.random() * (double)this.sequenceDefinition.frameLengths[this.frame]);
				this.onAnimCycleCountChanged(-1);
			}
		}

		this.rl$init(var1, var2, var3, var4, var5, var6, var7, var8, var9);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)Lel;"
	)
	protected final Model vmethod3353(int var1) {
		boolean var8 = false;

		Model var3;
		try {
			var8 = true;
			int var2 = this.getAnimFrame();
			if (var2 < 0) {
				this.setAnimFrame((var2 ^ Integer.MIN_VALUE) & 65535);
			}

			var3 = this.copy$getModel(var1);
			var8 = false;
		} finally {
			if (var8) {
				int var6 = this.getAnimFrame();
				if (var6 < 0) {
					this.setAnimFrame((var6 ^ Integer.MIN_VALUE) & 65535);
				}

			}
		}

		int var4 = this.getAnimFrame();
		if (var4 < 0) {
			this.setAnimFrame((var4 ^ Integer.MIN_VALUE) & 65535);
		}

		return (Model)var3;
	}

	public int getAnimFrame() {
		return this.frame;
	}

	@ObfuscatedSignature(
		signature = "(I)Lel;"
	)
	public final Model copy$getModel(int var1) {
		if (this.sequenceDefinition != null) {
			int var2 = Client.cycle - this.cycleStart;
			if (var2 > 100 && this.sequenceDefinition.frameCount > 0) {
				var2 = 100;
			}

			label55: {
				do {
					do {
						if (var2 <= this.sequenceDefinition.frameLengths[this.frame]) {
							break label55;
						}

						var2 -= this.sequenceDefinition.frameLengths[this.frame];
						++this.frame;
					} while(this.frame < this.sequenceDefinition.frameIds.length);

					this.frame -= this.sequenceDefinition.frameCount;
				} while(this.frame >= 0 && this.frame < this.sequenceDefinition.frameIds.length);

				this.sequenceDefinition = null;
			}

			this.cycleStart = Client.cycle - var2;
			this.onAnimCycleCountChanged(-1);
		}

		ObjectDefinition var13 = WorldMapSection2.method435(this.id);
		if (var13.transforms != null) {
			var13 = var13.method4645();
		}

		if (var13 == null) {
			return null;
		} else {
			int var3;
			int var4;
			if (this.orientation != 1 && this.orientation != 3) {
				var3 = var13.sizeX;
				var4 = var13.sizeY;
			} else {
				var3 = var13.sizeY;
				var4 = var13.sizeX;
			}

			int var5 = (var3 >> 1) + this.x;
			int var6 = (var3 + 1 >> 1) + this.x;
			int var7 = (var4 >> 1) + this.y;
			int var8 = (var4 + 1 >> 1) + this.y;
			int[][] var9 = Tiles.Tiles_heights[this.plane];
			int var10 = var9[var5][var8] + var9[var6][var7] + var9[var5][var7] + var9[var6][var8] >> 2;
			int var11 = (this.x << 7) + (var3 << 6);
			int var12 = (this.y << 7) + (var4 << 6);
			return var13.method4641(this.type, this.orientation, var9, var11, var10, var12, this.sequenceDefinition, this.frame);
		}
	}

	public void setAnimFrame(int var1) {
		this.frame = var1;
	}

	public int getAnimCycleCount() {
		return this.cycleStart;
	}

	public void rl$init(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, RSEntity var9) {
		this.animationID = var7;
		if (var7 != -1) {
			DynamicObjectAnimationChanged var10 = new DynamicObjectAnimationChanged();
			var10.setObject(var1);
			var10.setAnimation(var7);
			WorldMapSection1.client.getCallbacks().post(DynamicObjectAnimationChanged.class, var10);
		}

	}

	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1"
	)
	public void onAnimCycleCountChanged(int var1) {
		if (WorldMapSection1.client.isInterpolateObjectAnimations()) {
			int var2 = WorldMapSection1.client.getGameCycle() - this.getAnimCycleCount();
			this.setAnimFrame(Integer.MIN_VALUE | var2 << 16 | this.getAnimFrame());
		}

	}

	public int getAnimationID() {
		return this.animationID;
	}

	public int getId() {
		return this.id;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(ILlq;Lih;I)V",
		garbageValue = "-389102765"
	)
	static void method2328(int var0, ArchiveDisk var1, Archive var2) {
		byte[] var3 = null;
		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
			for (ArchiveDiskAction var5 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.method4931(); var5 != null; var5 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.method4949()) {
				if (var5.key == (long)var0 && var1 == var5.archiveDisk && var5.type == 0) {
					var3 = var5.data;
					break;
				}
			}
		}

		if (var3 != null) {
			var2.method4349(var1, var0, var3, true);
		} else {
			byte[] var4 = var1.method5897(var0);
			var2.method4349(var1, var0, var4, true);
		}
	}
}
