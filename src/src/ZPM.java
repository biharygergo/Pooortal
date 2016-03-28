package src;

/**
 * Represents a ZPM on a given field (road)
 */
public class ZPM extends Item {

    /**
     * Default constructor
     */
    public ZPM() {

    }


    /**
     * What happens when the player wants to use the field which has the ZPM on it
     * @param player the player who wants to use the ZPM
     */
    public void onUse(Player player) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("ZPM.onUse - onUse called on Player");
        GameEngine.tab--;

    }

    /**
     * What happens when the player steps on it
     * @param player the player who wants to step on the field with ZPM on it
     */
    public void onStep(Player player) {
        GameEngine.tab++;
        GameEngine.print("ZPM.onStep - onStep called on Player");
        player.collectedZPMs++;
        GameEngine.tab--;
        // TODO implement here

    }

    /**
     * Returns the field on which the ZPM stands
     * @return Returns the field on which the ZPM stands
     */
    public Field getField() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("ZPM.getField - Returned ZPM's current Field");
        GameEngine.tab--;
        return null;
    }

    /**
     * Sets the new field of the ZPM
     * @param field The new field
     */
    public void setField(Field field) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("ZPM.setField - Current Field set");
        GameEngine.tab--;
    }

}