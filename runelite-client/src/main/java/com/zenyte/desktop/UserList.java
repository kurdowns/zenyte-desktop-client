package com.zenyte.desktop;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import net.runelite.api.Nameable;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSUser;
import net.runelite.rs.api.RSUserList;
import net.runelite.rs.api.RSUsername;

@ObfuscatedName("kw")
public abstract class UserList<T extends Nameable> implements RSUserList<T> {
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 359260523
	)
	final int capacity;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1553317273
	)
	int size;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "[Ljd;"
	)
	User[] array;
	@ObfuscatedName("q")
	HashMap usernamesMap;
	@ObfuscatedName("z")
	HashMap previousUsernamesMap;
	@ObfuscatedName("t")
	Comparator comparator;

	UserList(int var1) {
		this.size = 0;
		this.comparator = null;
		this.capacity = var1;
		this.array = this.vmethod5281(var1);
		this.usernamesMap = new HashMap(var1 / 8);
		this.previousUsernamesMap = new HashMap(var1 / 8);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Ljd;",
		garbageValue = "-1332552421"
	)
	abstract User vmethod5269();

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(II)[Ljd;",
		garbageValue = "-667029686"
	)
	abstract User[] vmethod5281(int var1);

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1068929306"
	)
	public void method5161() {
		this.size = 0;
		Arrays.fill(this.array, (Object)null);
		this.usernamesMap.clear();
		this.previousUsernamesMap.clear();
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "4"
	)
	public int method5115() {
		return this.size;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1500565158"
	)
	public boolean method5174() {
		return this.capacity == this.size;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lku;I)Z",
		garbageValue = "590485203"
	)
	public boolean method5117(Username var1) {
		if (!var1.method5239()) {
			return false;
		} else {
			return this.usernamesMap.containsKey(var1) ? true : this.previousUsernamesMap.containsKey(var1);
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lku;I)Ljd;",
		garbageValue = "2044020824"
	)
	public User method5202(Username var1) {
		User var2 = this.method5119(var1);
		return var2 != null ? var2 : this.method5120(var1);
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(Lku;I)Ljd;",
		garbageValue = "-678771148"
	)
	User method5119(Username var1) {
		return !var1.method5239() ? null : (User)this.usernamesMap.get(var1);
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lku;I)Ljd;",
		garbageValue = "1317746514"
	)
	User method5120(Username var1) {
		return !var1.method5239() ? null : (User)this.previousUsernamesMap.get(var1);
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lku;I)Z",
		garbageValue = "-734937712"
	)
	public final boolean method5121(Username var1) {
		User var2 = this.method5119(var1);
		if (var2 == null) {
			return false;
		} else {
			this.method5195(var2);
			return true;
		}
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Ljd;I)V",
		garbageValue = "1801318248"
	)
	final void method5195(User var1) {
		this.remove(var1);
		int var2 = this.method5151(var1);
		if (var2 != -1) {
			this.method5132(var2);
			this.method5164(var1);
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Lku;I)Ljd;",
		garbageValue = "-2093018234"
	)
	User method5123(Username var1) {
		return this.method5184(var1, (Username)null);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lku;Lku;B)Ljd;",
		garbageValue = "50"
	)
	User method5184(Username var1, Username var2) {
		if (this.method5119(var1) != null) {
			throw new IllegalStateException();
		} else {
			User var3 = this.vmethod5269();
			var3.method5079(var1, var2);
			this.method5176(var3);
			this.method5131(var3);
			this.add(var1, var2);
			return var3;
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IS)Ljd;",
		garbageValue = "-19459"
	)
	public final User method5196(int var1) {
		if (var1 >= 0 && var1 < this.size) {
			return this.array[var1];
		} else {
			throw new ArrayIndexOutOfBoundsException(var1);
		}
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "15351"
	)
	public final void method5126() {
		if (this.comparator == null) {
			Arrays.sort(this.array, 0, this.size);
		} else {
			Arrays.sort(this.array, 0, this.size, this.comparator);
		}

	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(Ljd;Lku;Lku;I)V",
		garbageValue = "577990406"
	)
	final void method5127(User var1, Username var2, Username var3) {
		this.method5164(var1);
		var1.method5079(var2, var3);
		this.method5131(var1);
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(Ljd;I)I",
		garbageValue = "-1683425809"
	)
	final int method5151(User var1) {
		for (int var2 = 0; var2 < this.size; ++var2) {
			if (this.array[var2] == var1) {
				return var2;
			}
		}

		return -1;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "(Ljd;B)V",
		garbageValue = "28"
	)
	final void method5164(User var1) {
		if (this.usernamesMap.remove(var1.username) == null) {
			throw new IllegalStateException();
		} else {
			if (var1.previousUsername != null) {
				this.previousUsernamesMap.remove(var1.previousUsername);
			}

		}
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "(Ljd;I)V",
		garbageValue = "1612214268"
	)
	final void method5176(User var1) {
		this.array[++this.size - 1] = var1;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(Ljd;I)V",
		garbageValue = "1080849523"
	)
	final void method5131(User var1) {
		this.usernamesMap.put(var1.username, var1);
		if (var1.previousUsername != null) {
			User var2 = (User)this.previousUsernamesMap.put(var1.previousUsername, var1);
			if (var2 != null && var2 != var1) {
				var2.previousUsername = null;
			}
		}

	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-23"
	)
	final void method5132(int var1) {
		--this.size;
		if (var1 < this.size) {
			System.arraycopy(this.array, var1 + 1, this.array, var1, this.size - var1);
		}

	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-18"
	)
	public final void method5135() {
		this.comparator = null;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "(Ljava/util/Comparator;I)V",
		garbageValue = "-1901322261"
	)
	public final void method5136(Comparator var1) {
		if (this.comparator == null) {
			this.comparator = var1;
		} else if (this.comparator instanceof AbstractUserComparator) {
			((AbstractUserComparator)this.comparator).method5086(var1);
		}

	}

	public Nameable[] getNameables() {
		return this.array;
	}

	public void rl$add(RSUsername var1, RSUsername var2) {
	}

	public void rl$remove(RSUser var1) {
	}

	public void remove(RSUser var1) {
		this.rl$remove(var1);
	}

	public T findByName(RSUsername var1) {
		return (T) this.method5202((Username)var1);
	}

	public int getCount() {
		return this.method5115();
	}

	public void add(RSUsername var1, RSUsername var2) {
		this.rl$add(var1, var2);
	}

	public T[] getMembers() {
		Nameable[] var1 = this.getNameables();
		int var2 = this.getCount();
		return (T[])Arrays.copyOf(var1, var2);
	}

	public T findByName(String var1) {
		return this.findByName(WorldMapSection1.client.createName(var1, WorldMapSection1.client.getLoginType()));
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Liy;S)V",
		garbageValue = "32619"
	)
	public static void method5155(AbstractArchive var0) {
		InvDefinition.InvDefinition_archive = var0;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(ILce;ZB)I",
		garbageValue = "43"
	)
	static int method5201(int var0, class101 var1, boolean var2) {
		int var4 = -1;
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			var3 = MusicPatchNode.method3898(var4);
		} else {
			var3 = var2 ? GrandExchangeOfferNameComparator.field115 : Interpreter.field1130;
		}

		if (var0 == 1100) {
			Interpreter.Interpreter_intStackSize -= 2;
			var3.scrollX = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			if (var3.scrollX > var3.scrollWidth - var3.width) {
				var3.scrollX = var3.scrollWidth - var3.width;
			}

			if (var3.scrollX < 0) {
				var3.scrollX = 0;
			}

			var3.scrollY = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			if (var3.scrollY > var3.scrollHeight - var3.height) {
				var3.scrollY = var3.scrollHeight - var3.height;
			}

			if (var3.scrollY < 0) {
				var3.scrollY = 0;
			}

			ItemContainer.method1273(var3);
			return 1;
		} else if (var0 == 1101) {
			var3.color = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			ItemContainer.method1273(var3);
			return 1;
		} else if (var0 == 1102) {
			var3.fill = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
			ItemContainer.method1273(var3);
			return 1;
		} else if (var0 == 1103) {
			var3.transparencyTop = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			ItemContainer.method1273(var3);
			return 1;
		} else if (var0 == 1104) {
			var3.lineWid = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			ItemContainer.method1273(var3);
			return 1;
		} else if (var0 == 1105) {
			var3.spriteId2 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			ItemContainer.method1273(var3);
			return 1;
		} else if (var0 == 1106) {
			var3.spriteAngle = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			ItemContainer.method1273(var3);
			return 1;
		} else if (var0 == 1107) {
			var3.spriteTiling = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
			ItemContainer.method1273(var3);
			return 1;
		} else if (var0 == 1108) {
			var3.modelType = 1;
			var3.modelId = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			ItemContainer.method1273(var3);
			return 1;
		} else if (var0 == 1109) {
			Interpreter.Interpreter_intStackSize -= 6;
			var3.modelOffsetX = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var3.modelOffsetY = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			var3.modelAngleX = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
			var3.modelAngleY = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
			var3.modelAngleZ = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 4];
			var3.modelZoom = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 5];
			ItemContainer.method1273(var3);
			return 1;
		} else {
			int var8;
			if (var0 == 1110) {
				var8 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				if (var8 != var3.sequenceId) {
					var3.sequenceId = var8;
					var3.modelFrame = 0;
					var3.modelFrameCycle = 0;
					ItemContainer.method1273(var3);
				}

				return 1;
			} else if (var0 == 1111) {
				var3.modelOrthog = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
				ItemContainer.method1273(var3);
				return 1;
			} else if (var0 == 1112) {
				String var7 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
				if (!var7.equals(var3.text)) {
					var3.text = var7;
					ItemContainer.method1273(var3);
				}

				return 1;
			} else if (var0 == 1113) {
				var3.fontId = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				ItemContainer.method1273(var3);
				return 1;
			} else if (var0 == 1114) {
				Interpreter.Interpreter_intStackSize -= 3;
				var3.textXAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
				var3.textYAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
				var3.textLineHeight = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
				ItemContainer.method1273(var3);
				return 1;
			} else if (var0 == 1115) {
				var3.textShadowed = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
				ItemContainer.method1273(var3);
				return 1;
			} else if (var0 == 1116) {
				var3.outline = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				ItemContainer.method1273(var3);
				return 1;
			} else if (var0 == 1117) {
				var3.spriteShadow = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				ItemContainer.method1273(var3);
				return 1;
			} else if (var0 == 1118) {
				var3.spriteFlipV = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
				ItemContainer.method1273(var3);
				return 1;
			} else if (var0 == 1119) {
				var3.spriteFlipH = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
				ItemContainer.method1273(var3);
				return 1;
			} else if (var0 == 1120) {
				Interpreter.Interpreter_intStackSize -= 2;
				var3.scrollWidth = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
				var3.scrollHeight = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
				ItemContainer.method1273(var3);
				if (var4 != -1 && var3.type == 0) {
					MouseHandler.method1161(Widget.Widget_interfaceComponents[var4 >> 16], var3, false);
				}

				return 1;
			} else if (var0 == 1121) {
				class58.method968(var3.id, var3.childIndex);
				Client.meslayerContinueWidget = var3;
				ItemContainer.method1273(var3);
				return 1;
			} else if (var0 == 1122) {
				var3.spriteId = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				ItemContainer.method1273(var3);
				return 1;
			} else if (var0 == 1123) {
				var3.color2 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				ItemContainer.method1273(var3);
				return 1;
			} else if (var0 == 1124) {
				var3.transparencyBot = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				ItemContainer.method1273(var3);
				return 1;
			} else if (var0 == 1125) {
				var8 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				class332 var6 = (class332)GrandExchangeEvent.method159(MusicPatchNode.method3899(), var8);
				if (var6 != null) {
					var3.fillMode = var6;
					ItemContainer.method1273(var3);
				}

				return 1;
			} else {
				boolean var5;
				if (var0 == 1126) {
					var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
					var3.field2601 = var5;
					return 1;
				} else if (var0 == 1127) {
					var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
					var3.modelTransparency = var5;
					return 1;
				} else {
					return 2;
				}
			}
		}
	}
}
