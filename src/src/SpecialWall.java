package src;

import java.util.*;

/**
 * 
 */
public class SpecialWall extends Wall {

    /**
     * Default constructor
     */
    public SpecialWall() {
    }


    /**
     * 
     */
    private Color color;

    /**
     * 
     */
    private Wormhole wormHole;






    /**
     * @param bullet 
     * @param wormHole 
     * @return
     */
    public void onShoot(Bullet bullet, Wormhole wormHole) {
        // TODO implement here

    }

    /**
     * @param color 
     * @return
     */
    public void setColor(Color color) {
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
     * @param player
     */
    public void onStep(Player player) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Color getColor() {
        // TODO implement here
        return null;
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