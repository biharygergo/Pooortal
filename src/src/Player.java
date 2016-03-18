package src;//import src.Field;
//package src;

/**
 * 
 */
public class Player {

    /**
     * Default constructor
     */
    public Player() {
    }

    /**
     * 
     */
    private Field field;

    /**
     * 
     */
    private Dir dir;

    /**
     * 
     */

    private boolean alive;

    /**
     * 
     */
    int collectedZPMs;


    /**
     * 
     */
    private Box box;


    /**
     * @return
     */
    public Box dropBox() {
        // TODO implement here

        GameEngine.print("dropBox - Box dropped");

        return null;
    }

    /**
     * @return
     */
    public Bullet shootBlue() {
        // TODO implement here
        GameEngine.print("shootBlue - Blue bullet shooted");
        return null;
    }

    /**
     * @return
     */
    public Bullet shootYellow() {
        // TODO implement here
        GameEngine.print("shootYellow - Yellow bullet shooted");
        return null;
    }

    /**
     * @return
     */
    public Field getField() {
        // TODO implement here
        GameEngine.print("getField - Returned field");

        return null;
    }

    /**
     * @param field 
     * @return
     */
    public void setField(Field field) {
        // TODO implement here
        GameEngine.print("setField - Field set");
    }

    /**
     * @return
     */
    public Dir getDir() {
        // TODO implement here
        GameEngine.print("getDir - Returned direction");
        return null;
    }

    /**
     * @param dir 
     * @return
     */
    public void setDir(Dir dir) {
        // TODO implement here
        GameEngine.print("setDir - Direction set");
    }

    /**
     * @return
     */
    public Box getBox() {
        // TODO implement here
        GameEngine.print("getBox - Returned box");
        return null;
    }

    /**
     * @param box 
     * @return
     */
    public void setBox(Box box) {
        // TODO implement here
        GameEngine.print("setBox - Box set");
    }

    /**
     * @return
     */
    public boolean isAlive() {
        // TODO implement here
        GameEngine.print("isAlive - Returned player state");
        return false;
    }

    /**
     * @param alive 
     * @return
     */
    public void setAlive(boolean alive) {
        // TODO implement here
        GameEngine.print("setAlive - Player state set");
    }

    /**
     * @return
     */
    public Field getNextField() {
        // TODO implement here
        GameEngine.print("getNextField - Returned next field");
        return null;
    }

}