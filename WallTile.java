/**
 * The WallTile class represents a non-walkable tile (a wall) on the Legends RPG
 * game board.
 * Wall tiles prevent players or entities from moving onto them, and are
 * represented by a specific icon.
 * This class extends the LegTile class and modifies its properties to make the
 * tile non-walkable.
 */
public class WallTile extends LegTile {
    private final String DEFAULT_ICON = "#";

    // default constructor
    // set the wall tiles icon to a # so it represents a wall
    public WallTile() {
        super();
        isWalkable = false;
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