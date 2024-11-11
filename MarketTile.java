/**
 * The MarketTile class represents a market tile on the Legends game board.
 * Players can interact with the market when they land on this tile.
 * The tile is visually represented by an "M" icon.
 */
public class MarketTile extends LegTile {
    private final String DEFAULT_ICON = "M";

    public MarketTile() {
        super();
        tileIcon = DEFAULT_ICON;
    }

    public String getIcon() {
        return DEFAULT_ICON;
    }

    // reset back to default
    public void resetIcon() {
        tileIcon = DEFAULT_ICON;
    }

}
