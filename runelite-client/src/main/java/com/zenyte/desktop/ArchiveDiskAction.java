package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSArchiveDiskAction;

@ObfuscatedName("ir")
public class ArchiveDiskAction extends Node implements RSArchiveDiskAction {
	@ObfuscatedName("de")
	@ObfuscatedSignature(
		signature = "Lih;"
	)
	static Archive archive0;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1964239455
	)
	int type;
	@ObfuscatedName("m")
	public byte[] data;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Llq;"
	)
	public ArchiveDisk archiveDisk;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lih;"
	)
	public Archive archive;

	ArchiveDiskAction() {
	}
}
