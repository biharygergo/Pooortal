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
        GameEngine.print("Wall() - New Wall created");
    }

    /**
     * @param player
     */
    public void onStep(Player player) {
        // TODO implement here
        GameEngine.print("Wall.onStep - Onstep called on Player");
    }

    /**
     * 
     */
    public boolean steppable() {
        // TODO implement here
        GameEngine.print("Wall.steppable - Field's state returned");
        return false;
    }

    /**
     * @param bullet 
     * @param wormHole 
     * @return
     */
    public void onShoot(Bullet bullet, Wormhole wormHole) {
        // TODO implement here
        GameEngine.print("Wall.onShoot - Called on Wall");
        GameEngine.tab++;
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
