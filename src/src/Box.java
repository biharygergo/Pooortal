package src;

/**
 * Represents a box on a given field
 */
public class Box extends Item {

     /**
      * Handles the pick up and drop of the box
      * @param player
     */
    public void onUse(Player player) {
        GameEngine.tab++;
        GameEngine.print("Box.onUse - Box is being used");
        player.setBox(this);
        setField(player.getField());
        GameEngine.tab--;
        // TODO implement here

    }

    /**
     * What to do if the player want to step on a field which has a box on it
     * @param player
     */
    public void onStep(Player player) {
        GameEngine.tab++;
        GameEngine.print("Box.onStep - onStep executed on player");
        GameEngine.tab--;
        // TODO implement here

    }

    /**
     * @return current field on which the box stands
     */
    public Field getField() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Box.getField - returned current Field");
        GameEngine.tab--;
        return null;
    }

    /**
     * @param field sets the new field
     */
    public void setField(Field field) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Box.setField - current Field reset to new field");
        GameEngine.tab--;

    }

}