/**
 * The BoardGame class represents a type of game that is played on a board.
 * This class extends the generic Game class and includes a Board object
 * which serves as the playing field for the game.
 * It provides basic functionality to retrieve or set the board.
 */
public class BoardGame extends Game {
    protected Board board;

    // default constructor
    public BoardGame() {
        board = new Board();
    }

    // getters/setters
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
