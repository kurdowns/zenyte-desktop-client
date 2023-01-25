package com.zenyte.desktop;

import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSPacketWriter;

@ObfuscatedName("dv")
public class PacketWriter implements RSPacketWriter {
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 2038642023
	)
	static int loginBoxCenter;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Llt;"
	)
	AbstractSocket socket;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Ljm;"
	)
	IterableNodeDeque packetBufferNodes;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1977656589
	)
	int bufferSize;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lkb;"
	)
	Buffer buffer;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Llp;"
	)
	public IsaacCipher isaacCipher;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lkj;"
	)
	PacketBuffer packetBuffer;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lgv;"
	)
	ServerPacket serverPacket;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1499666993
	)
	int serverPacketLength;
	@ObfuscatedName("t")
	boolean field1335;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1899399217
	)
	int field1338;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -1748299909
	)
	int pendingWrites;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lgv;"
	)
	ServerPacket field1334;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lgv;"
	)
	ServerPacket field1329;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lgv;"
	)
	ServerPacket field1339;

	PacketWriter() {
		this.packetBufferNodes = new IterableNodeDeque();
		this.bufferSize = 0;
		this.buffer = new Buffer(5000);
		this.packetBuffer = new PacketBuffer(40000);
		this.serverPacket = null;
		this.serverPacketLength = 0;
		this.field1335 = true;
		this.field1338 = 0;
		this.pendingWrites = 0;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1731012634"
	)
	final void method2345() {
		this.packetBufferNodes.method4866();
		this.bufferSize = 0;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2069512411"
	)
	final void method2346() throws IOException {
		if (this.socket != null && this.bufferSize > 0) {
			this.buffer.offset = 0;

			while (true) {
				PacketBufferNode var1 = (PacketBufferNode)this.packetBufferNodes.method4860();
				if (var1 == null || var1.index > this.buffer.array.length - this.buffer.offset) {
					this.socket.vmethod5878(this.buffer.array, 0, this.buffer.offset);
					this.pendingWrites = 0;
					break;
				}

				this.buffer.method5596(var1.packetBuffer.array, 0, var1.index);
				this.bufferSize -= var1.index;
				var1.method3657();
				var1.packetBuffer.method5530();
				var1.method3686();
			}
		}

	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lgq;I)V",
		garbageValue = "1849813620"
	)
	public final void method2361(PacketBufferNode var1) {
		this.packetBufferNodes.method4858(var1);
		var1.index = var1.packetBuffer.offset;
		var1.packetBuffer.offset = 0;
		this.bufferSize += var1.index;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Llt;B)V",
		garbageValue = "-28"
	)
	void method2354(AbstractSocket var1) {
		this.socket = var1;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "955020520"
	)
	void method2349() {
		if (this.socket != null) {
			this.socket.vmethod5866();
			this.socket = null;
		}

	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-17"
	)
	void method2350() {
		this.socket = null;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)Llt;",
		garbageValue = "1352632931"
	)
	AbstractSocket method2359() {
		return this.socket;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-816734320"
	)
	public static int method2362(int var0) {
		long var2 = ViewportMouse.ViewportMouse_entityTags[var0];
		int var1 = (int)(var2 >>> 0 & 127L);
		return var1;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "1838015298"
	)
	static int method2367(int var0) {
		ChatChannel var1 = (ChatChannel)Messages.Messages_channels.get(var0);
		return var1 == null ? 0 : var1.method2332();
	}

	@ObfuscatedName("fr")
	@ObfuscatedSignature(
		signature = "(Ljc;IIIB)V",
		garbageValue = "29"
	)
	static void method2368(SequenceDefinition var0, int var1, int var2, int var3) {
		if (Client.soundEffectCount < 50 && Client.areaSoundEffectVolume != 0) {
			if (var0.soundEffects != null && var1 < var0.soundEffects.length) {
				int var4 = var0.soundEffects[var1];
				if (var4 != 0) {
					int var5 = var4 >> 8;
					int var6 = var4 >> 4 & 7;
					int var7 = var4 & 15;
					Client.soundEffectIds[Client.soundEffectCount] = var5;
					Client.queuedSoundEffectLoops[Client.soundEffectCount] = var6;
					Client.queuedSoundEffectDelays[Client.soundEffectCount] = 0;
					Client.soundEffects[Client.soundEffectCount] = null;
					int var8 = (var2 - 64) / 128;
					int var9 = (var3 - 64) / 128;
					Client.soundLocations[Client.soundEffectCount] = var7 + (var9 << 8) + (var8 << 16);
					++Client.soundEffectCount;
					Client.queuedSoundEffectCountChanged(-1);
				}
			}
		}
	}
}
