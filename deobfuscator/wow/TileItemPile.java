import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Area;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSEntity;
import net.runelite.rs.api.RSTileItemPile;

@ObfuscatedName("dn")
public final class TileItemPile implements RSTileItemPile {

   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1464221376
   )
   int y;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lee;"
   )
   Entity second;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1402854643
   )
   int tileHeight;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1160995392
   )
   int x;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lee;"
   )
   Entity first;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lee;"
   )
   Entity third;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = 1345007712428644829L
   )
   long tag;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -720251669
   )
   int height;
   public int itemLayerPlane;


   public Point getCanvasLocation(int var1) {
      return Perspective.localToCanvas(WorldMapSection1.client, this.getLocalLocation(), this.getPlane(), var1);
   }

   public Area getClickbox() {
      throw new UnsupportedOperationException();
   }

   public RSEntity getMiddle() {
      return this.second;
   }

   public RSEntity getBottom() {
      return this.first;
   }

   public RSEntity getTop() {
      return this.third;
   }

   public long getHash() {
      return this.tag;
   }

   public int getX() {
      return this.x * 64;
   }

   public LocalPoint getLocalLocation() {
      return new LocalPoint(this.getX(), this.getY());
   }

   public int getY() {
      return this.y * 64;
   }

   public int getPlane() {
      return this.itemLayerPlane;
   }

   public int getId() {
      long var1 = this.getHash();
      return (int)(var1 >>> 17 & 4294967295L);
   }

   public WorldPoint getWorldLocation() {
      return WorldPoint.fromLocal(WorldMapSection1.client, this.getX(), this.getY(), this.getPlane());
   }

   public Point getCanvasLocation() {
      return this.getCanvasLocation(0);
   }

   public Polygon getCanvasTilePoly() {
      return Perspective.getCanvasTilePoly(WorldMapSection1.client, this.getLocalLocation());
   }

   public Point getCanvasTextLocation(Graphics2D var1, String var2, int var3) {
      return Perspective.getCanvasTextLocation(WorldMapSection1.client, var1, this.getLocalLocation(), var2, var3);
   }

   public Point getMinimapLocation() {
      return Perspective.localToMinimap(WorldMapSection1.client, this.getLocalLocation());
   }

   public void setPlane(int var1) {
      this.itemLayerPlane = var1;
   }

   public net.runelite.api.Model getModelBottom() {
      RSEntity var1 = this.getBottom();
      return var1 == null?null:(var1 instanceof net.runelite.api.Model?(net.runelite.api.Model)var1:var1.getModel());
   }

   public net.runelite.api.Model getModelMiddle() {
      RSEntity var1 = this.getMiddle();
      return var1 == null?null:(var1 instanceof net.runelite.api.Model?(net.runelite.api.Model)var1:var1.getModel());
   }

   public net.runelite.api.Model getModelTop() {
      RSEntity var1 = this.getTop();
      return var1 == null?null:(var1 instanceof net.runelite.api.Model?(net.runelite.api.Model)var1:var1.getModel());
   }

   public int getHeight() {
      return this.height;
   }
}
