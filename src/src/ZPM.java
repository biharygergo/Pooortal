package src;

/**
 * 
 */
public class ZPM extends Modules {

    /**
     * Default constructor
     */
    public ZPM() {
    }


    /**
     * @param player 
     * @return
     */
    public void onUse(Player player) {
        // TODO implement here
        GameEngine.print("ZPM.onUse - onUse called on Player");

    }

    /**
     * @param player 
     * @return
     */
    public void onStep(Player player) {
        GameEngine.print("ZPM.onStep - onStep called on Player");
        // TODO implement here

    }

    /**
     * @return
     */
    public Field getField() {
        // TODO implement here
        GameEngine.print("ZPM.getField - Returned ZPM's current Field");
        return null;
    }

    /**
     * @param field 
     * @return
     */
    public void setField(Field field) {
        // TODO implement here
        GameEngine.print("ZPM.setField - Current Field set");
    }

}