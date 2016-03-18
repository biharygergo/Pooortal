import java.util.*;

/**
 * 
 */
public class Scale extends Field {

    /**
     * Default constructor
     */
    public Scale() {
    }


    /**
     * 
     */
    private boolean weight;


    /**
     * 
     */
    private Door door;

    /**
     * @return
     */
    public Door getDoor() {
        // TODO implement here
        return null;
    }

    /**
     * @param door 
     * @return
     */
    public void setDoor(Door door) {
        // TODO implement here

    }

    /**
     * @return
     */
    public boolean getWeight() {
        // TODO implement here
        return false;
    }

    /**
     * @param weight 
     * @return
     */
    public void setWeight(boolean weight) {
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
     * @param player 
     * @return
     */
    public void onStep(Player player) {
        // TODO implement here

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