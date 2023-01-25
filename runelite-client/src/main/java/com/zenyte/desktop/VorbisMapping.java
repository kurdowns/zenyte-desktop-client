package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.rs.api.RSVorbisMapping;

@ObfuscatedName("dt")
public class VorbisMapping implements RSVorbisMapping {
	@ObfuscatedName("x")
	int submaps;
	@ObfuscatedName("m")
	int mappingMux;
	@ObfuscatedName("k")
	int[] submapFloor;
	@ObfuscatedName("d")
	int[] submapResidue;

	VorbisMapping() {
		VorbisSample.method2462(16);
		this.submaps = VorbisSample.method2486() != 0 ? VorbisSample.method2462(4) + 1 : 1;
		if (VorbisSample.method2486() != 0) {
			VorbisSample.method2462(8);
		}

		VorbisSample.method2462(2);
		if (this.submaps > 1) {
			this.mappingMux = VorbisSample.method2462(4);
		}

		this.submapFloor = new int[this.submaps];
		this.submapResidue = new int[this.submaps];

		for (int var1 = 0; var1 < this.submaps; ++var1) {
			VorbisSample.method2462(8);
			this.submapFloor[var1] = VorbisSample.method2462(8);
			this.submapResidue[var1] = VorbisSample.method2462(8);
		}

	}
}
