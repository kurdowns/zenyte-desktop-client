package com.zenyte.desktop;

import java.lang.ref.SoftReference;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.rs.api.RSSoftWrapper;

@ObfuscatedName("fy")
public class SoftWrapper extends Wrapper implements RSSoftWrapper {
	@ObfuscatedName("x")
	SoftReference ref;

	SoftWrapper(Object var1, int var2) {
		super(var2);
		this.ref = new SoftReference(var1);
	}

	@ObfuscatedName("x")
	Object vmethod3461() {
		return this.ref.get();
	}

	@ObfuscatedName("m")
	boolean vmethod3462() {
		return true;
	}
}
