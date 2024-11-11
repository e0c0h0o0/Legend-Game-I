/**
 * The MainApp class is the entry point for the Legends: Monsters and Heroes
 * game.
 * It creates an instance of the Legends game and starts the game by calling the
 * `playGame` method.
 */
public class MainApp {
    public static void main(String[] args) {
        Legends legend = new Legends();
        legend.playGame();
    }
}
