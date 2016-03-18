package src;

import java.util.*;

/**
 * 
 */
public class Scale extends Field {

    /**
     * Default constructor
     */
    public Scale() {
        GameEngine.print("Scale() - New Scale created");
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
        GameEngine.print("Scale.getDoor - Returned current Door for Scale");
        return null;
    }

    /**
     * @param door 
     * @return
     */
    public void setDoor(Door door) {
        // TODO implement here
        GameEngine.print("Scale.setDoor - Current Door for Scale set");
    }

    /**
     * @return
     */
    public boolean getWeight() {
        // TODO implement here
        GameEngine.print("Scale.getWeight - Returned current weight on Scale");
        return false;
    }

    /**
     * @param weight 
     * @return
     */
    public void setWeight(boolean weight) {
        // TODO implement here
        GameEngine.print("Scale.setWeight - Current weight on Scale set");

    }

    /**
     * @return
     */
    public boolean steppable() {
        // TODO implement here
        GameEngine.print("Scale.steppable - Field's state returned");
        return false;
    }

    /**
     * @param player 
     * @return
     */
    public void onStep(Player player) {
        // TODO implement here
        GameEngine.print("Scale.onStep - Onstep called on Player");

    }

    /**
     * @param bullet 
     * @param wormHole 
     * @return
     */
    public void onShoot(Bullet bullet, Wormhole wormHole) {
        // TODO implement here
        GameEngine.print("SpecialWall.onShoot - Called on SpecialWall");

    }

    /**
     * @return
     *

    public Map<Dir, Field> getSides() {
        // TODO implement here
        return null;
    }


    public void setSides(Map<Dir, Field> map) {
        // TODO implement here

    }
    */


}