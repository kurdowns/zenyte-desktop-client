package com.zenyte.desktop;

import net.runelite.api.MessageNode;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSChatChannel;
import net.runelite.rs.api.RSDualNode;
import net.runelite.rs.api.RSMessage;

@ObfuscatedName("cl")
public class ChatChannel implements RSChatChannel {
	@ObfuscatedName("fc")
	@ObfuscatedGetter(
		longValue = -181918079142719425L
	)
	static long field1319;
	@ObfuscatedName("go")
	@ObfuscatedSignature(
		signature = "Lla;"
	)
	static Sprite compass;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "[Lby;"
	)
	Message[] messages;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1013484149
	)
	int count;

	ChatChannel() {
		this.messages = new Message[100];
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lby;",
		garbageValue = "922420852"
	)
	Message method2334(int var1, String var2, String var3, String var4) {
		Message var5 = this.messages[99];

		for (int var6 = this.count; var6 > 0; --var6) {
			if (var6 != 100) {
				this.messages[var6] = this.messages[var6 - 1];
			}
		}

		if (var5 == null) {
			var5 = new Message(var1, var2, var4, var3);
		} else {
			var5.method3657();
			var5.method3653();
			var5.method1295(var1, var2, var4, var3);
		}

		this.messages[0] = var5;
		if (this.count < 100) {
			++this.count;
		}

		return var5;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IB)Lby;",
		garbageValue = "49"
	)
	Message method2333(int var1) {
		return var1 >= 0 && var1 < this.count ? this.messages[var1] : null;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-2095560133"
	)
	int method2332() {
		return this.count;
	}

	public RSMessage[] getLines() {
		return this.messages;
	}

	public int getLength() {
		return this.count;
	}

	public void setLength(int var1) {
		this.count = var1;
	}

	public void removeMessageNode(MessageNode var1) {
		RSMessage[] var2 = this.getLines();
		int var3 = this.getLength();
		int var4 = -1;

		int var5;
		for (var5 = 0; var5 < var3; ++var5) {
			if (var2[var5] == var1) {
				var4 = var5;
				break;
			}
		}

		if (var4 != -1) {
			for (var5 = var4; var5 < var3 - 1; ++var5) {
				var2[var5] = var2[var5 + 1];
			}

			var2[var3 - 1] = null;
			this.setLength(var3 - 1);
			RSDualNode var6 = (RSDualNode)var1;
			var6.unlink();
			var6.unlinkDual();
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
		garbageValue = "-570972962"
	)
	static void method2341(int var0, String var1, String var2, String var3) {
		ChatChannel var4 = (ChatChannel)Messages.Messages_channels.get(var0);
		if (var4 == null) {
			var4 = new ChatChannel();
			Messages.Messages_channels.put(var0, var4);
		}

		Message var5 = var4.method2334(var0, var1, var2, var3);
		Messages.Messages_hashTable.method5963(var5, (long)var5.count);
		Messages.Messages_queue.method4999(var5);
		Client.chatCycle = Client.cycleCntr;
		Client.onAddChatMessage(var0, var1, var2, var3);
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "266221696"
	)
	static final void method2337() {
		GrandExchangeEvent.method165("You can't add yourself to your own ignore list");
	}

	@ObfuscatedName("fo")
	@ObfuscatedSignature(
		signature = "(IZZZB)Lih;",
		garbageValue = "109"
	)
	static Archive method2339(int var0, boolean var1, boolean var2, boolean var3) {
		ArchiveDisk var4 = null;
		if (JagexCache.JagexCache_dat2File != null) {
			var4 = new ArchiveDisk(var0, JagexCache.JagexCache_dat2File, PacketBufferNode.JagexCache_idxFiles[var0], 1000000);
		}

		return new Archive(var4, WorldMapRegion.masterDisk, var0, var1, var2, var3);
	}

	@ObfuscatedName("fn")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "48"
	)
	static final void method2342() {
		if (AbstractWorldMapData.pcmPlayer1 != null) {
			AbstractWorldMapData.pcmPlayer1.method2522();
		}

		if (WorldMapManager.pcmPlayer0 != null) {
			WorldMapManager.pcmPlayer0.method2522();
		}

	}

	@ObfuscatedName("ih")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2027834560"
	)
	static void method2340() {
		for (int var0 = 0; var0 < Client.menuOptionsCount; ++var0) {
			if (WorldMapLabelSize.method282(Client.menuOpcodes[var0])) {
				if (var0 < Client.menuOptionsCount - 1) {
					for (int var1 = var0; var1 < Client.menuOptionsCount - 1; ++var1) {
						Client.menuActions[var1] = Client.menuActions[var1 + 1];
						Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
						Client.menuOpcodes[var1] = Client.menuOpcodes[var1 + 1];
						Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
						Client.menuArguments1[var1] = Client.menuArguments1[var1 + 1];
						Client.menuArguments2[var1] = Client.menuArguments2[var1 + 1];
						Client.menuShiftClick[var1] = Client.menuShiftClick[var1 + 1];
					}
				}

				--var0;
				--Client.menuOptionsCount;
				Client.onMenuOptionsChanged(-1);
			}
		}

		MusicPatchNode.method3901(WorldMapScaleHandler.menuWidth / 2 + WorldMapDecoration.menuX, PacketBufferNode.menuY);
	}
}
