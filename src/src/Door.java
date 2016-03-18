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
        GameEngine.print("Door.() - new Door was created");

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
        GameEngine.print("Door.isOpen - returned open attribute");

        return false;
    }

    /**
     * @param open 
     * @return
     */
    public void setOpen(boolean open) {
        GameEngine.print("Door.setOpen - set open attribute");

        // TODO implement here

    }

    /**
     * @param player 
     * @return
     */
    public void onStep(Player player) {
        GameEngine.print("Door.onStep - Door was stepped on by player");

        // TODO implement here

    }

    /**
     * @return
     */
    public boolean steppable() {
        GameEngine.print("Door.steppable - returned whether door is steppable");

        // TODO implement here
        return false;
    }

    /**
     * @param bullet 
     * @param wormHole 
     * @return
     */
    public void onShoot(Bullet bullet, Wormhole wormHole) {
        GameEngine.print("Door.onShoot - defines what happens when Door is shot");

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