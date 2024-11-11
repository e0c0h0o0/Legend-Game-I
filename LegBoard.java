import java.util.Random;

/**
 * The LegBoard class represents the game board for the Legends RPG.
 * It extends the RPGBoard and provides functionality for initializing and
 * managing
 * a grid-based board with different types of tiles (Market, Wall, Wild).
 * The player's party moves around the board, and the board dynamically updates
 * based on the player's position.
 */
public class LegBoard extends RPGBoard {
    // default party location
    private final int defaultPartyLocX = 0;
    private final int defaultPartyLocY = 0;
    private final String playerIcon = "P";

    // last player location
    private int lastX;
    private int lastY;

    // number of tile types currently in Legends = 3
    private final int NUM_TYPES = 3;

    // default constructor
    public LegBoard() {
        board = new LegTile[DEFAULT_SIZE][DEFAULT_SIZE];
        initBoard();
    }

    public LegBoard(int row, int col) {
        board = new LegTile[row][col];
        lastX = defaultPartyLocX;
        lastY = defaultPartyLocY;
    }

    // Initialize the board to avoid teams getting stuck in corners. About 20% are
    // inaccessible, 30% are markets, and 50% are normal units.
    // Regenerate the board if the team gets trapped in a corner.
    public void initBoard() {
        // total tiles on the board
        int totalTiles = DEFAULT_SIZE * DEFAULT_SIZE;
        // number of market tiles is about 30 percent
        int numMarket = (int) (totalTiles * .3);
        // number of walls is around 20 percent
        int numWalls = (int) (totalTiles * .2);
        // wilderness tiles are calculated from the remainder
        int remaining = totalTiles - numMarket - numWalls;
        // When traversing the board, place units based on a random number from 1-3.
        // A 3 or 4 indicates a wildcard unit, preventing the top from being primarily a
        // market or wall.
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                // the party will always start on a blank tile
                if (x == defaultPartyLocX && y == defaultPartyLocY) {
                    board[x][y] = new WildTile();
                    remaining--;
                }
                // otherwise generate it randomly
                else {
                    Random rand = new Random();
                    int tileNum = rand.nextInt(NUM_TYPES + 1) + 1;
                    if (tileNum == 1 && numMarket > 0) {
                        board[x][y] = new MarketTile();
                        numMarket--;
                    } else if (tileNum == 2 && numWalls > 0) {
                        board[x][y] = new WallTile();
                        numWalls--;
                    } else if ((tileNum == 4 || tileNum == 3) && remaining > 0) {
                        board[x][y] = new WildTile();
                        remaining--;
                    } else if (numWalls > 0) {
                        board[x][y] = new WallTile();
                        numWalls--;
                    } else if (numMarket > 0) {
                        board[x][y] = new MarketTile();
                        numMarket--;
                    } else {
                        board[x][y] = new WildTile();
                        remaining--;
                    }
                }
            }
        }
        // if the player has no where to go,generate a new board
        if (!(checkRoute(defaultPartyLocX, defaultPartyLocY))) {
            initBoard();
        }
        updatePlayer(defaultPartyLocX, defaultPartyLocY);
    }

    // method to check which route they can take Returns true if they can, otherwise
    // returns false
    public boolean checkRoute(int x, int y) {
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX >= 0 && newX < DEFAULT_SIZE && newY >= 0 && newY < DEFAULT_SIZE &&
                    board[newX][newY] != null && ((LegTile) board[newX][newY]).isWalkable) {
                return true;
            }
        }
        return false;
    }

    // check if the party is able to go to that tile
    public boolean canMoveToTile(int x, int y) {
        if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && ((LegTile) board[x][y]).isWalkable) {
            return true;
        }
        System.out.println("Can't go there!");
        return false;
    }

    // updates the Party's position on the map
    public void updatePlayer(int x, int y) {
        // change back to the original icon
        if (board[lastX][lastY] instanceof WallTile) {
            ((WallTile) board[lastX][lastY]).resetIcon();
        } else if (board[lastX][lastY] instanceof WildTile) {
            ((WildTile) board[lastX][lastY]).resetIcon();
        } else {
            ((MarketTile) board[lastX][lastY]).resetIcon();
        }

        ((LegTile) board[x][y]).setTileIcon(playerIcon);
        // update latest location
        lastX = x;
        lastY = y;
    }

}
