package src;
import java.util.*;

/**
 *
 */
public class Box extends Item {

    /**
     * Default constructor
     * /
     public Box() {
     }



     /**
     * @param player
     * @return
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
     * @param player
     * @return
     */
    public void onStep(Player player) {
        GameEngine.tab++;
        GameEngine.print("Box.onStep - onStep executed on player");
        GameEngine.tab--;
        // TODO implement here

    }

    /**
     * @return
     */
    public Field getField() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Box.getField - returned current Field");
        GameEngine.tab--;
        return null;
    }

    /**
     * @param field
     * @return
     */
    public void setField(Field field) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Box.setField - current Field reset to new field");
        GameEngine.tab--;

    }

}