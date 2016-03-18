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
        return false;
    }

    /**
     * @param open 
     * @return
     */
    public void setOpen(boolean open) {
        // TODO implement here

    }

    /**
     * @param player 
     * @return
     */
    public void onStep(Player player) {
        // TODO implement here

    }

    /**
     * @return
     */
    public boolean steppable() {
        // TODO implement here
        return false;
    }

    /**
     * @param bullet 
     * @param wormHole 
     * @return
     */
    public void onShoot(Bullet bullet, Wormhole wormHole) {
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