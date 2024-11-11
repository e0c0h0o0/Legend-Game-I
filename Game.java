/**
 * The Game class serves as a base class for different types of games.
 * It includes functionality to manage the game's state (whether it is over or
 * not)
 * and provides a method to simulate the game's progression.
 */
public class Game {
    protected boolean isOver;

    // default constructor
    public Game() {
        isOver = false;
    }

    // Determine if the game is over
    public void playGame() {
        while (isOver == false) {
        }
        System.out.println("Game is Over!");
    }

    // getters/setters
    public boolean getIsOver() {
        return isOver;
    }

    public void setIsOver(boolean isOver) {
        this.isOver = isOver;
    }

}
