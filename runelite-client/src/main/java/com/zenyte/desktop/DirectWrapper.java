package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.rs.api.RSDirectWrapper;

@ObfuscatedName("fk")
public class DirectWrapper extends Wrapper implements RSDirectWrapper {
	@ObfuscatedName("x")
	Object obj;

	DirectWrapper(Object var1, int var2) {
		super(var2);
		this.obj = var1;
	}

	@ObfuscatedName("x")
	Object vmethod3461() {
		return this.obj;
	}

	@ObfuscatedName("m")
	boolean vmethod3462() {
		return false;
	}
}
