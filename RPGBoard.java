/**
 * The RPGBoard class extends the generic Board class and is specifically
 * designed
 * for use in the Legends RPG game. It holds RPGTile objects, which represent
 * the
 * different types of tiles on the board (such as walkable tiles, market tiles,
 * etc.).
 * The board is initialized with RPGTile objects.
 */
public class RPGBoard extends Board {
    // default constructor now using RPGTiles
    // default size is set in board
    public RPGBoard() {
        board = new RPGTile[DEFAULT_SIZE][DEFAULT_SIZE];
    }

    // initialize the board with all empty rpgtiles
    public void initBoard() {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                board[x][y] = new RPGTile();
            }
        }
    }

    // getters and setters
    public RPGTile[][] getBoard() {
        return (RPGTile[][]) board;
    }

    public void setBoard(RPGTile[][] board) {
        this.board = board;
    }

}
