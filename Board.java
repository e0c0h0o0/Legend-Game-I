/**
 * The Board class represents a grid of Tiles used in a game.
 * It supports initialization of different board sizes and provides
 * methods for accessing and modifying individual tiles.
 * The board is a 2D array where each element represents a Tile.
 */
public class Board {
    protected Tile[][] board;// A 2D array of Tiles representing the game board.
    protected final int DEFAULT_SIZE = 8;// The default size for the board (8x8).

    // default constructor
    public Board() {
        board = new Tile[DEFAULT_SIZE][DEFAULT_SIZE];
    }

    // define a board with a fixed size
    public Board(int row, int col) {
        board = new Tile[row][col];
    }

    // initialize the board with all empty tiles
    public void initBoard() {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                board[x][y] = new Tile();
            }
        }
    }

    // method to get a specific Tile
    public Tile getTile(int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            throw new IndexOutOfBoundsException("Coordinates are out of bounds.");
        }
        return board[x][y];
    }

    // method to set a specific tile
    public void setTile(int x, int y, Tile tile) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            throw new IndexOutOfBoundsException("Coordinates are out of bounds.");
        }
        board[x][y] = tile;
    }

    // override toString
    @Override
    public String toString() {
        StringBuilder toPrint = new StringBuilder();
        StringBuilder rowString = new StringBuilder();

        // Create row separators
        for (int x = 0; x < board[0].length; x++) {
            rowString.append("---");
        }
        rowString.append("\n");
        rowString.insert(0, "-");

        // Traverse the board and format each tile
        for (int x = 0; x < board.length; x++) {
            if (x != 0) {
                toPrint.append("\n");
            }
            toPrint.append(rowString);
            for (int y = 0; y < board[0].length; y++) {
                toPrint.append("|").append(board[x][y].toString()).append(" ");
                if (y == board[0].length - 1) {
                    toPrint.append("|");
                }
            }
        }
        toPrint.append("\n").append(rowString);
        return toPrint.toString();
    }

    // getters and setters
    public Tile[][] getBoard() {
        return board;
    }

    public void setBoard(Tile[][] board) {
        this.board = board;
    }
}
