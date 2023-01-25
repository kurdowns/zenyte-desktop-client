package com.zenyte.desktop;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSWorldMapArchiveLoader;

@ObfuscatedName("mi")
public class WorldMapArchiveLoader implements RSWorldMapArchiveLoader {
	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		signature = "Liv;"
	)
	static StudioGame field3965;
	@ObfuscatedName("w")
	String cacheName;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	AbstractArchive archive;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 2095920673
	)
	int percentLoaded;
	@ObfuscatedName("z")
	boolean loaded;

	@ObfuscatedSignature(
		signature = "(Liy;)V"
	)
	WorldMapArchiveLoader(AbstractArchive var1) {
		this.percentLoaded = 0;
		this.loaded = false;
		this.archive = var1;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-2004873028"
	)
	void method6366(String var1) {
		if (var1 != null && !var1.isEmpty()) {
			if (var1 != this.cacheName) {
				this.cacheName = var1;
				this.percentLoaded = 0;
				this.loaded = false;
				this.method6370();
			}
		}
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-339187615"
	)
	int method6370() {
		if (this.percentLoaded < 33) {
			if (!this.archive.method4241(WorldMapCacheName.field340.name, this.cacheName)) {
				return this.percentLoaded;
			}

			this.percentLoaded = 33;
		}

		if (this.percentLoaded == 33) {
			if (this.archive.method4299(WorldMapCacheName.field341.name, this.cacheName) && !this.archive.method4241(WorldMapCacheName.field341.name, this.cacheName)) {
				return this.percentLoaded;
			}

			this.percentLoaded = 66;
		}

		if (this.percentLoaded == 66) {
			if (!this.archive.method4241(this.cacheName, WorldMapCacheName.field343.name)) {
				return this.percentLoaded;
			}

			this.percentLoaded = 100;
			this.loaded = true;
		}

		return this.percentLoaded;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "94"
	)
	boolean method6367() {
		return this.loaded;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "16"
	)
	int method6369() {
		return this.percentLoaded;
	}
}
