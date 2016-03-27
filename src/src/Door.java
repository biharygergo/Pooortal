package src;

import java.util.*;

/**
 * 
 */
public class Door extends Field {

    /**
     * Default constructor
     */
    public Door() {
        GameEngine.tab++;
        GameEngine.print("Door.() - new Door was created");
        GameEngine.tab--;
    }

    /**
     * 
     */
    private boolean open;


    /**
     * @return
     */
    public boolean isOpen() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Door.isOpen - returned open attribute");
        GameEngine.tab--;
        return false;
    }

    /**
     * @param open 
     * @return
     */
    public void setOpen(boolean open) {
        GameEngine.tab++;
        GameEngine.print("Door.setOpen - set open attribute");
        GameEngine.tab--;
        // TODO implement here

    }

    /**
     * @param player 
     * @return
     */
    public void onStep(Player player) {
        GameEngine.tab++;
        GameEngine.print("Door.onStep - Door was stepped on by player");
        GameEngine.tab--;
        // TODO implement here

    }

    /**
     * @return
     */
    public boolean steppable() {
        GameEngine.tab++;
        GameEngine.print("Door.steppable - returned whether door is steppable");
        GameEngine.tab--;
        // TODO implement here
        return false;
    }

    /**
     * @param bullet 
     * @param wormHole 
     * @return
     */
    public void onShoot(Bullet bullet, Wormhole wormHole) {
        GameEngine.tab++;
        GameEngine.print("Door.onShoot - defines what happens when Door is shot");
        GameEngine.tab--;
        // TODO implement here

    }

    /**
     * @return
     */
    public Map<Dir, Field> getSides() {
        // TODO implement here

        return null;
    }

    /**
     * @param Map 
     * @return
     */
    public void setSides(Map<Dir, Field> map) {
        // TODO implement here

    }



}