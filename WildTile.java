/**
 * The WildTile class represents a walkable tile in the wilderness on the
 * Legends RPG game board.
 * WildTiles are empty spaces where players or entities can move. These tiles
 * are represented by a space (" ").
 * This class extends the LegTile class and modifies its properties to make the
 * tile walkable.
 */
public class WildTile extends LegTile {
    private final String DEFAULT_ICON = " ";

    // default constructor
    // set the wildnerness tile to just a space to show you can go there.
    public WildTile() {
        super();
        tileIcon = " ";
    }

    public String getIcon() {
        return DEFAULT_ICON;
    }

    // reset back to default
    public void resetIcon() {
        tileIcon = DEFAULT_ICON;
    }

}
