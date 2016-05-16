package src;

/**
 * The Main class
 */
public class Main {

    private static GameEngine gameEngine = new GameEngine();
    private static Controller controller = new Controller(gameEngine, "listener");
    private static Controller controllerOnNewThread = new Controller(gameEngine, "updater");

    public static void main (String[] args){

        Thread t = new Thread(controller);
        Thread t2 = new Thread(controllerOnNewThread);
        t.start();
        t2.start();
    }
}