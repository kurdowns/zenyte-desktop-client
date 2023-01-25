package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.rs.api.RSByteArrayNode;

@ObfuscatedName("gu")
public class ByteArrayNode extends Node implements RSByteArrayNode {
	@ObfuscatedName("x")
	public byte[] byteArray;

	public ByteArrayNode(byte[] var1) {
		this.byteArray = var1;
	}
}
