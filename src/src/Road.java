package src;

import java.util.*;

/**
 * 
 */
public class Road extends Field {

    /**
     * Default constructor
     */
    public Road() {
    }

    /**
     * @param player
     */
    public void onStep(Player player) {
        GameEngine.print("onStep - Road's ");
        // TODO implement here
    }

    /**
     * 
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

    /**
     * @return
     */


}