package com.zenyte.desktop;

import net.runelite.api.events.ItemQuantityChanged;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSTile;
import net.runelite.rs.api.RSTileItem;

@ObfuscatedName("cf")
public final class TileItem extends Entity implements RSTileItem {
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lag;"
	)
	static WorldMapEvent worldMapEvent;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 809859925
	)
	int id;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1293976509
	)
	int quantity;
	public int rl$sceneY;
	public int rl$sceneX;

	TileItem() {
		this.rl$$init();
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)Lel;"
	)
	protected final Model vmethod3353(int var1) {
		return AbstractWorldMapData.method373(this.id).method4696(this.quantity, (byte)-102);
	}

	public void onUnlink() {
		if (this.rl$sceneX != -1 && WorldMapSection1.client.getLastItemDespawn() == null) {
			WorldMapSection1.client.setLastItemDespawn(this);
		}

	}

	private void rl$$init() {
		this.rl$sceneX = -1;
		this.rl$sceneY = -1;
	}

	public int getId() {
		return this.id;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public net.runelite.api.Tile getTile() {
		int var1 = this.rl$sceneX;
		int var2 = this.rl$sceneY;
		if (var1 != -1 && var2 != -1) {
			RSTile[][][] var3 = WorldMapSection1.client.getScene().getTiles();
			return var3[WorldMapSection1.client.getPlane()][var1][var2];
		} else {
			return null;
		}
	}

	public void quantityChanged(int var1) {
		if (this.rl$sceneX != -1) {
			WorldMapSection1.client.getLogger().debug("Item quantity changed: {} ({} -> {})", new Object[]{this.getId(), this.getQuantity(), var1});
			ItemQuantityChanged var2 = new ItemQuantityChanged(this, this.getTile(), this.getQuantity(), var1);
			WorldMapSection1.client.getCallbacks().post(ItemQuantityChanged.class, var2);
		}

	}

	public int getX() {
		return this.rl$sceneX;
	}

	public void setX(int var1) {
		this.rl$sceneX = var1;
	}

	public int getY() {
		return this.rl$sceneY;
	}

	public void setY(int var1) {
		this.rl$sceneY = var1;
	}

	public void setId(int var1) {
		this.id = var1;
	}

	public void setQuantity(int var1) {
		this.quantity = var1;
	}
}
