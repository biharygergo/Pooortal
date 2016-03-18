package src;
import java.util.*;

/**
 *
 */
public class Box extends Modules {

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
        GameEngine.print("Box.onUse - Box is being used");

        // TODO implement here

    }

    /**
     * @param player
     * @return
     */
    public void onStep(Player player) {
        GameEngine.print("Box.onStep - onStep executed on player");

        // TODO implement here

    }

    /**
     * @return
     */
    public Field getField() {
        // TODO implement here
        GameEngine.print("Box.getField - returned current Field");

        return null;
    }

    /**
     * @param field
     * @return
     */
    public void setField(Field field) {
        // TODO implement here
        GameEngine.print("Box.setField - current Field reset to new field");


    }

}