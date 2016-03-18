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
        GameEngine.print("Road.onStep - onStep called on player");
        // TODO implement here
    }

    /**
     * 
     */
    public boolean steppable() {
        // TODO implement here
        GameEngine.print("Road.steppable - Field's state returned");
        return false;
    }

    /**
     * @param bullet 
     * @param wormHole 
     * @return
     */
    public void onShoot(Bullet bullet, Wormhole wormHole) {
        // TODO implement here
        GameEngine.print("Road.onShoot - called on Road");
    }

    /**
     * @return
     */
    public Map<Dir, Field> getSides() {
        // TODO implement here
        GameEngine.print("Road.getSides - Returned neighboring fields");
        return null;
    }

    /**
     * @param Map 
     * @return
     */
    public void setSides(Map<Dir, Field> map) {
        // TODO implement here
        GameEngine.print("Road.setSides - Neighboring fields set");

    }

    /**
     * @return
     */


}