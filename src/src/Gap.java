package src;

import java.util.*;

/**
 * 
 */
public class Gap extends Field {

    /**
     * Default constructor
     */
    public Gap() {
        GameEngine.print("Gap.() - new Gap was created");

    }

    /**
     * @param player
     */
    public void onStep(Player player) {
        GameEngine.tab++;
        GameEngine.print("Gap.onStep - Gap was stepped on by player");

        player.setAlive(false);
        GameEngine.tab--;
        // TODO implement here
    }

    /**
     * 
     */
    public boolean steppable() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Gap.steppable - returns true for Gap");
        GameEngine.tab--;
        return false;
    }

    /**
     * @param bullet 
     * @param wormHole 
     * @return
     */
    public void onShoot(Bullet bullet, Wormhole wormHole) {
        GameEngine.tab++;
        GameEngine.print("Gap.onShoot - defines what happens when bullet is shot on this Gap");
        GameEngine.tab--;
        // TODO implement here

    }

    /**
     * @return
     */
//    public Map<Dir, Field> getSides() {
//        // TODO implement here
//        return null;
//    }
//
//    /**
//     * @param Map
//     * @return
//     */
//    public void setSides(Map<Dir, Field> map) {
//        // TODO implement here
//
//    }


}