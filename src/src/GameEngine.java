package src;

/**
 * 
 */
public class GameEngine {

    static int tab;

    /**
     * Default constructor
     */
    public GameEngine() {
        GameEngine.tab=2;
    }

    /**
     * 
     */
    private Player oNeill;

    /**
     * 
     */
    private Modules activeModules;

    /**
     * 
     */
    private FieldMap map;

    /**
     * 
     */
    private Wormhole wormhole;

    /**
     * 
     */








    /**
     * @return
     */
    public void start() {
        // TODO implement here

    }

    /**
     * @return
     */
    public void endGame() {
        // TODO implement here

    }

    public static void main(String[] args){
        System.out.println("It Works!");
        tab++;
        Player p= new Player();
        p.dropBox();
    }

}