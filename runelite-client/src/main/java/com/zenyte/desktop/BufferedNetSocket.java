package com.zenyte.desktop;

import java.io.IOException;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSBufferedNetSocket;

@ObfuscatedName("lc")
public class BufferedNetSocket extends AbstractSocket implements RSBufferedNetSocket {
	@ObfuscatedName("x")
	Socket socket;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Llm;"
	)
	BufferedSource source;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Llo;"
	)
	BufferedSink sink;

	BufferedNetSocket(Socket var1, int var2, int var3) throws IOException {
		this.socket = var1;
		this.socket.setSoTimeout(30000);
		this.socket.setTcpNoDelay(true);
		this.socket.setReceiveBufferSize(65536);
		this.socket.setSendBufferSize(65536);
		this.source = new BufferedSource(this.socket.getInputStream(), var2);
		this.sink = new BufferedSink(this.socket.getOutputStream(), var3);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-105"
	)
	public void vmethod5866() {
		this.sink.method5888();

		try {
			this.socket.close();
		} catch (IOException var2) {
		}

		this.source.method5918();
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1436175029"
	)
	public int vmethod5863() throws IOException {
		return this.source.method5909();
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "195119972"
	)
	public int vmethod5862() throws IOException {
		return this.source.method5908();
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(IB)Z",
		garbageValue = "0"
	)
	public boolean vmethod5861(int var1) throws IOException {
		return this.source.method5907(var1);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "([BIIB)I",
		garbageValue = "33"
	)
	public int vmethod5864(byte[] var1, int var2, int var3) throws IOException {
		return this.source.method5911(var1, var2, var3);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "([BIII)V",
		garbageValue = "236801869"
	)
	public void vmethod5878(byte[] var1, int var2, int var3) throws IOException {
		this.sink.method5881(var1, var2, var3);
	}

	protected void finalize() {
		this.vmethod5866();
	}

	protected void aav() {
		this.vmethod5866();
	}

	protected void aaf() {
		this.vmethod5866();
	}

	protected void aaw() {
		this.vmethod5866();
	}

	protected void aay() {
		this.vmethod5866();
	}
}
