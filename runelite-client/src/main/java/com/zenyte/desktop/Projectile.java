package com.zenyte.desktop;

import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.api.events.ProjectileSpawned;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSNPC;
import net.runelite.rs.api.RSPlayer;
import net.runelite.rs.api.RSProjectile;

@ObfuscatedName("ct")
public final class Projectile extends Entity implements RSProjectile {
	@ObfuscatedName("sj")
	@ObfuscatedSignature(
		signature = "Lco;"
	)
	public static FriendSystem friendSystem;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -101649187
	)
	int id;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1827872967
	)
	int plane;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1361221531
	)
	int sourceX;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1265488669
	)
	int sourceY;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1417484877
	)
	int sourceZ;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1177641065
	)
	int endHeight;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1536269421
	)
	int cycleStart;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1563239709
	)
	int cycleEnd;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1004662519
	)
	int slope;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 491202369
	)
	int startHeight;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 219402729
	)
	int targetIndex;
	@ObfuscatedName("p")
	boolean isMoving;
	@ObfuscatedName("n")
	double x;
	@ObfuscatedName("u")
	double y;
	@ObfuscatedName("h")
	double z;
	@ObfuscatedName("g")
	double speedX;
	@ObfuscatedName("i")
	double speedY;
	@ObfuscatedName("a")
	double speed;
	@ObfuscatedName("b")
	double speedZ;
	@ObfuscatedName("l")
	double accelerationZ;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -858077797
	)
	int yaw;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -1652545155
	)
	int pitch;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Ljc;"
	)
	SequenceDefinition sequenceDefinition;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -299919777
	)
	int frame;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -1622544383
	)
	int frameCycle;

	Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
		this.isMoving = false;
		this.frame = 0;
		this.frameCycle = 0;
		this.id = var1;
		this.plane = var2;
		this.sourceX = var3;
		this.sourceY = var4;
		this.sourceZ = var5;
		this.cycleStart = var6;
		this.cycleEnd = var7;
		this.slope = var8;
		this.startHeight = var9;
		this.targetIndex = var10;
		this.endHeight = var11;
		this.isMoving = false;
		int var12 = MouseHandler.method1205(this.id).sequence;
		if (var12 != -1) {
			this.sequenceDefinition = SpotAnimationDefinition.method4478(var12);
		} else {
			this.sequenceDefinition = null;
		}

		this.rl$$init();
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-251648925"
	)
	final void method2196(int var1, int var2, int var3, int var4) {
		this.projectileMoved(var1, var2, var3, var4);
		double var5;
		if (!this.isMoving) {
			var5 = (double)(var1 - this.sourceX);
			double var7 = (double)(var2 - this.sourceY);
			double var9 = Math.sqrt(var5 * var5 + var7 * var7);
			this.x = (double)this.sourceX + var5 * (double)this.startHeight / var9;
			this.y = (double)this.startHeight * var7 / var9 + (double)this.sourceY;
			this.z = (double)this.sourceZ;
		}

		var5 = (double)(this.cycleEnd + 1 - var4);
		this.speedX = ((double)var1 - this.x) / var5;
		this.speedY = ((double)var2 - this.y) / var5;
		this.speed = Math.sqrt(this.speedY * this.speedY + this.speedX * this.speedX);
		if (!this.isMoving) {
			this.speedZ = -this.speed * Math.tan(0.02454369D * (double)this.slope);
		}

		this.accelerationZ = ((double)var3 - this.z - var5 * this.speedZ) * 2.0D / (var5 * var5);
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1296799789"
	)
	final void method2194(int var1) {
		this.isMoving = true;
		this.x += (double)var1 * this.speedX;
		this.y += (double)var1 * this.speedY;
		this.z += (double)var1 * this.speedZ + 0.5D * this.accelerationZ * (double)var1 * (double)var1;
		this.speedZ += (double)var1 * this.accelerationZ;
		this.yaw = (int)(Math.atan2(this.speedX, this.speedY) * 325.949D) + 1024 & 2047;
		this.pitch = (int)(Math.atan2(this.speedZ, this.speed) * 325.949D) & 2047;
		if (this.sequenceDefinition != null) {
			this.frameCycle += var1;

			while (true) {
				do {
					do {
						if (this.frameCycle <= this.sequenceDefinition.frameLengths[this.frame]) {
							return;
						}

						this.frameCycle -= this.sequenceDefinition.frameLengths[this.frame];
						++this.frame;
					} while(this.frame < this.sequenceDefinition.frameIds.length);

					this.frame -= this.sequenceDefinition.frameCount;
				} while(this.frame >= 0 && this.frame < this.sequenceDefinition.frameIds.length);

				this.frame = 0;
			}
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)Lel;"
	)
	protected final Model vmethod3353(int var1) {
		SpotAnimationDefinition var2 = MouseHandler.method1205(this.id);
		Model var3 = var2.method4467(this.frame);
		if (var3 == null) {
			return null;
		} else {
			var3.method2965(this.pitch);
			return var3;
		}
	}

	public int getRsInteracting() {
		return this.targetIndex;
	}

	public void projectileMoved(int var1, int var2, int var3, int var4) {
		LocalPoint var5 = new LocalPoint(var1, var2);
		ProjectileMoved var6 = new ProjectileMoved();
		var6.setProjectile(this);
		var6.setPosition(var5);
		var6.setZ(var3);
		WorldMapSection1.client.getCallbacks().post(ProjectileMoved.class, var6);
	}

	public int getEndCycle() {
		return this.cycleEnd;
	}

	private void rl$$init() {
		ProjectileSpawned var1 = new ProjectileSpawned();
		var1.setProjectile(this);
		WorldMapSection1.client.getCallbacks().post(ProjectileSpawned.class, var1);
	}

	public int getRemainingCycles() {
		int var1 = WorldMapSection1.client.getGameCycle();
		return this.getEndCycle() - var1;
	}

	public net.runelite.api.Actor getInteracting() {
		int var1 = this.getRsInteracting();
		if (var1 == 0) {
			return null;
		} else {
			int var2;
			if (var1 > 0) {
				var2 = var1 - 1;
				RSNPC[] var4 = WorldMapSection1.client.getCachedNPCs();
				return var4[var2];
			} else {
				var2 = -var1 - 1;
				if (var2 == WorldMapSection1.client.getLocalInteractingIndex()) {
					return WorldMapSection1.client.getLocalPlayer();
				} else {
					RSPlayer[] var3 = WorldMapSection1.client.getCachedPlayers();
					return var3[var2];
				}
			}
		}
	}

	public int getId() {
		return this.id;
	}

	public int getFloor() {
		return this.plane;
	}

	public int getX1() {
		return this.sourceX;
	}

	public int getY1() {
		return this.sourceY;
	}

	public int getHeight() {
		return this.sourceZ;
	}

	public int getEndHeight() {
		return this.endHeight;
	}

	public int getStartMovementCycle() {
		return this.cycleStart;
	}

	public int getSlope() {
		return this.slope;
	}

	public int getStartHeight() {
		return this.startHeight;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public double getZ() {
		return this.z;
	}

	public double getVelocityX() {
		return this.speedX;
	}

	public double getVelocityY() {
		return this.speedY;
	}

	public double getScalar() {
		return this.speed;
	}

	public double getVelocityZ() {
		return this.speedZ;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "29577048"
	)
	public static int method2197(int var0) {
		VarbitDefinition var2 = (VarbitDefinition)VarbitDefinition.VarbitDefinition_cached.method3418((long)var0);
		VarbitDefinition var1;
		if (var2 != null) {
			var1 = var2;
		} else {
			byte[] var7 = VarbitDefinition.VarbitDefinition_archive.method4224(14, var0, (byte)-79);
			var2 = new VarbitDefinition();
			if (var7 != null) {
				var2.method4536(new Buffer(var7));
			}

			VarbitDefinition.VarbitDefinition_cached.method3424(var2, (long)var0);
			var1 = var2;
		}

		int var3 = var1.baseVar;
		int var4 = var1.startBit;
		int var5 = var1.endBit;
		int var6 = Varps.Varps_masks[var5 - var4];
		return Varps.Varps_main[var3] >> var4 & var6;
	}
}
