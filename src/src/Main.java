package src;

/**
 * The Main class
 */
public class Main {

    private static GameEngine gameEngine = new GameEngine();
    private static Controller controller = new Controller(gameEngine);
    public static void main (String[] args){
        controller.run();
    }
}
