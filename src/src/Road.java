package src;

import java.util.*;

/**
 * Represents the road field, which is always steppable if nothing stands on it
 */
public class Road extends Field {

    /**
     * Default constructor
     */
    public Road() {;
    }

    /**
     * @param player the player who wants to step on it
     */
    public void onStep(Player player) {
        GameEngine.tab++;
        GameEngine.print("Road.onStep - onStep called on Player");
        GameEngine.tab--;
        // TODO implement here
    }

    /**
     * @return The boolean whether the road is steppable or not
     */
    public boolean steppable() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Road.steppable - Field's state returned");
        GameEngine.tab--;
        return true;
    }

    /**
     * What happens when the player shoots on the road
     * @param bullet The bullet which the player shoots on the road
     * @param wormHole The wormhole
     */
    public void onShoot(Bullet bullet, Wormhole wormHole) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Road.onShoot - Called on Road");
        GameEngine.tab--;
    }

    /**
     * @return
     *
    public Map<Dir, Field> getSides() {
        // TODO implement here
        GameEngine.print("Road.getSides - Returned neighboring fields");
        return null;
    }


    public void setSides(Map<Dir, Field> map) {
        // TODO implement here
        GameEngine.print("Road.setSides - Neighboring fields set");

    }


     * @return
     */


}