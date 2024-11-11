/**
 * The LegTile class represents a basic tile in the Legends game board.
 * Each tile has a visual representation through a tile icon and can be extended
 * by
 * other tile types (like MarketTile, WallTile, WildTile).
 */
public class LegTile extends RPGTile {
    protected String tileIcon;

    // default constructor
    public LegTile() {
        super();
        tileIcon = "";
    }

    // make the toString Method for a tile represent its type of tile with one
    // letter
    @Override
    public String toString() {
        return tileIcon;
    }

    public String getTileIcon() {
        return tileIcon;
    }

    public void setTileIcon(String tileIcon) {
        this.tileIcon = tileIcon;
    }
}
