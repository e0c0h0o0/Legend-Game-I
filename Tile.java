/**
 * The Tile class represents a single tile on a game board in the Legends RPG
 * game.
 * Each tile contains a string that can represent various entities, such as a
 * hero, monster, or empty space.
 */
public class Tile {
    protected String contents;

    // default constructor
    public Tile() {
        contents = "";
    }

    // set contents on create
    public Tile(String str) {
        contents = str;
    }

    // overriding toString
    @Override
    public String toString() {
        return contents;
    }

    // getters/setters
    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
