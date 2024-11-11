/**
 * The RPGTile class represents a tile on the RPGBoard in the Legends RPG game.
 * Each tile can either be walkable or non-walkable, determining whether a
 * player or entity
 * can move onto the tile. This class extends the Tile class.
 */
public class RPGTile extends Tile {
    // variables
    protected boolean isWalkable;

    // default constructor
    public RPGTile() {
        super();
        isWalkable = true;
    }

    // allows to set if the tile is walkable or not
    public RPGTile(boolean isWalkable) {
        super();
        this.isWalkable = isWalkable;
    }

    // getters/setters
    public boolean getWalkable() {
        return isWalkable;
    }

    public void setWalkable(boolean walk) {
        isWalkable = walk;
    }

}
