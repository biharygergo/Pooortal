package src;

import java.util.*;

/**
 * 
 */
public class Wall extends Field {

    /**
     * Default constructor
     */
    public Wall() {

    }

    /**
     * @param player
     */
    public void onStep(Player player) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Wall.onStep - Onstep called on Player");
        GameEngine.tab--;
    }

    /**
     * 
     */
    public boolean steppable() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Wall.steppable - Field's state returned");
        GameEngine.tab--;
        return false;
    }

    /**
     * @param bullet 
     * @param wormHole 
     * @return
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
