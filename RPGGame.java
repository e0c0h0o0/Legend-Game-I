/**
 * The RPGGame class extends the BoardGame class and is specifically designed
 * for
 * role-playing games (RPGs) in the Legends game framework. This class manages
 * the RPGBoard,
 * as well as the player's move options and interactions during the game.
 */
public class RPGGame extends BoardGame {
    // variables
    private RPGBoard board;

    // move options
    protected final String moveUP = "W";
    protected final String moveLEFT = "A";
    protected final String moveDOWN = "S";
    protected final String moveRIGHT = "D";
    protected final String showInfo = "I";
    protected final String quitGame = "Q";
    protected final String showInv = "E";
    protected final String showMap = "M";

    // default constructor
    public RPGGame() {
        board = new RPGBoard();
    }
}
