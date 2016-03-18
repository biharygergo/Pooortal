package src;

import java.util.*;

/**
 * 
 */
public abstract class Field {

    /**
     * Default constructor
     */
    public Field() {
    }

    /**
     * 
     */
    protected Map<Dir, Field> sides;






    /**
     * @return
     */
    public abstract boolean steppable();

    /**
     * @param player 
     * @return
     */
    public abstract void onStep(Player player);

    /**
     * @param bullet 
     * @param wormHole 
     * @return
     */
    public abstract void onShoot(Bullet bullet, Wormhole wormHole);

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