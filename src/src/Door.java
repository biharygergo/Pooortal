package src;

import java.util.*;

/**
 * Represents a door on a given field
 */
public class Door extends Field {

    /**
     * Default constructor
     */
    public Door() {

    }

    /**
     * Status of the door
     */
    private boolean open;


    /**
     * @return Returns true if the door is open, false otherwise
     */
    public boolean isOpen() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Door.isOpen - returned open attribute");
        GameEngine.tab--;
        return false;
    }

    /**
     * @param open Status of the door
     */
    public void setOpen(boolean open) {
        GameEngine.tab++;
        GameEngine.print("Door.setOpen - set open attribute " + open);
        GameEngine.tab--;
        // TODO implement here

    }

    /**
     * If open, the player steps on it, and automatically steps on the next field in the given direction
     * @param player the player stepped on the door
     */
    public void onStep(Player player) {
        GameEngine.tab++;
        GameEngine.print("Door.onStep - Door was stepped on by player");
        GameEngine.tab--;
        // TODO implement here

    }

    /**
     * @return Returns true if open, false otherwise
     */
    public boolean steppable() {
        GameEngine.tab++;
        GameEngine.print("Door.steppable - returned whether door is steppable");
        GameEngine.tab--;
        // TODO implement here
        return false;
    }

    /**
     * If the door is closed, changes the bullet status to false. If open, the bullet flies through the given field
     * @param bullet the bullet hitting, or flying across the door
     * @param wormHole The wormhole in the map
     */
    public void onShoot(Bullet bullet, Wormhole wormHole) {
        GameEngine.tab++;
        GameEngine.print("Door.onShoot - defines what happens when Door is shot");
        GameEngine.tab--;
        // TODO implement here

    }

    /**
     * @return Returns the neighbouring fields in a given direction
     */
    public Map<Dir, Field> getSides() {
        // TODO implement here

        return null;
    }

    /**
     * Sets the new neighbours
     * @param map the neighbours of the door in the specified direction
     */
    public void setSides(Map<Dir, Field> map) {
        // TODO implement here

    }
}