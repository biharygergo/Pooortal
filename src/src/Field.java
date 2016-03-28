package src;

import java.util.Map;

/**
 * Abstract class representing the fields on the map
 */
public abstract class Field {

    /**
     * Default constructor
     */
    public Field() {
    }

    /**
     * The neighbouring fields
     */
    protected Map<Dir, Field> sides;

    /**
     * @return true if the player can step on it, false otherwise
     */
    public abstract boolean steppable();

    /**
     * What to do if the player want to step on a field
     * @param player the player who wants to step on the field
     */
    public abstract void onStep(Player player);

    /**
     * What to do if a fired bullet reaches the field
     * @param bullet the bullet hitting, or flying across the field
     * @param wormHole The wormhole in the map
     */
    public abstract void onShoot(Bullet bullet, Wormhole wormHole);

    /**
     * @return Returns the neighbouring fields in a given direction
     */
    public Map<Dir, Field> getSides() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Field.getSides - returned Field's neighbours");
        GameEngine.tab--;
        return null;
    }

    /**
     * Sets the new neighbours
     * @param map the neighbours of the door in the specified direction* @param map
     */
    public void setSides(Map<Dir, Field> map) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Field.setSides - set Field's neighbours");
        GameEngine.tab--;

    }

}