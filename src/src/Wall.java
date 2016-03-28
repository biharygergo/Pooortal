package src;

import java.util.*;

/**
 * Represents the wall field, which is not steppable
 */
public class Wall extends Field {

    /**
     * Default constructor
     */
    public Wall() {

    }

    /**
     * What happens when the player steps on it
     * @param player the player who wants to step on the wall
     */
    public void onStep(Player player) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Wall.onStep - Onstep called on Player");
        GameEngine.tab--;
    }

    /**
     * Returns that the wall is steppable or not
     * @return The boolean whether the wall is steppable or not
     */
    public boolean steppable() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Wall.steppable - Field's state returned");
        GameEngine.tab--;
        return false;
    }

    /**
     * What happens when the player shoots on the wall
     * @param bullet The bullet which the player shoots on the wall
     * @param wormHole The wormhole on the wall
     */
    public void onShoot(Bullet bullet, Wormhole wormHole) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Wall.onShoot - Called on Wall");
        bullet.setActive(false);
        GameEngine.tab--;
    }

    /**
     * @return

    public Map<Dir, Field> getSides() {
        // TODO implement here
        GameEngine.print("Wall.getSides - Returned neighboring fields");
        return null;
    }


    public void setSides(Map<Dir, Field> map) {
        // TODO implement here
        GameEngine.print("Wall.setSides - Neighboring fields set");
    }
    */
}
