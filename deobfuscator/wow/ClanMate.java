import net.runelite.api.ClanMemberRank;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSClanMate;

@ObfuscatedName("jt")
public class ClanMate extends Buddy implements RSClanMate {

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lkv;"
   )
   TriBool friend;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lkv;"
   )
   TriBool ignored;


   ClanMate() {
      this.friend = TriBool.TriBool_unknown;
      this.ignored = TriBool.TriBool_unknown;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "93359593"
   )
   void method5067() {
      this.friend = TriBool.TriBool_unknown;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "416982136"
   )
   public final boolean method5066() {
      if(this.friend == TriBool.TriBool_unknown) {
         this.method5069();
      }

      return this.friend == TriBool.TriBool_true;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-559295927"
   )
   void method5069() {
      this.friend = Projectile.friendSystem.friendsList.method5142(super.username)?TriBool.TriBool_true:TriBool.TriBool_false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-203044757"
   )
   void method5082() {
      this.ignored = TriBool.TriBool_unknown;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2013472471"
   )
   public final boolean method5072() {
      if(this.ignored == TriBool.TriBool_unknown) {
         this.method5071();
      }

      return this.ignored == TriBool.TriBool_true;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "1528"
   )
   void method5071() {
      this.ignored = Projectile.friendSystem.ignoreList.method5142(super.username)?TriBool.TriBool_true:TriBool.TriBool_false;
   }

   public ClanMemberRank getRank() {
      return ClanMemberRank.valueOf(this.getRSRank());
   }
}
