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
        GameEngine.print("Player() - New Player created");
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

        GameEngine.print("Player.dropBox - Box dropped");
        box=null;
        return null;
    }

    /**
     * @return
     */
    public Bullet shootBlue() {
        // TODO implement here
        GameEngine.print("Player.shootBlue - Blue bullet shot");
        return null;
    }

    /**
     * @return
     */
    public Bullet shootYellow() {
        // TODO implement here
        GameEngine.print("Player.shootYellow - Yellow bullet shot");
        return null;
    }

    /**
     * @return
     */
    public Field getField() {
        // TODO implement here
        GameEngine.print("Player.getField - Returned field");

        return null;
    }

    /**
     * @param field 
     * @return
     */
    public void setField(Field field) {
        // TODO implement here
        GameEngine.print("Player.setField - Field set");
    }

    /**
     * @return
     */
    public Dir getDir() {
        // TODO implement here
        GameEngine.print("Player.getDir - Returned direction");
        return null;
    }

    /**
     * @param dir 
     * @return
     */
    public void setDir(Dir dir) {
        // TODO implement here
        GameEngine.print("Player.setDir - Direction set");
    }

    /**
     * @return
     */
    public Box getBox() {
        // TODO implement here
        GameEngine.print("Player.getBox - Returned box");
        return null;
    }

    /**
     * @param box 
     * @return
     */
    public void setBox(Box box) {
        // TODO implement here
        GameEngine.print("Player.setBox - Box set");
    }

    /**
     * @return
     */
    public boolean isAlive() {
        // TODO implement here
        GameEngine.print("Player.isAlive - Returned player state");
        return false;
    }

    /**
     * @param alive 
     * @return
     */
    public void setAlive(boolean alive) {
        // TODO implement here
        GameEngine.print("Player.setAlive - Player state set");
    }

    /**
     * @return
     */
    public Field getNextField() {
        // TODO implement here
        GameEngine.print("Player.getNextField - Returned next field");
        return null;
    }

}