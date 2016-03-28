package src;

/**
 * 
 */
public class ZPM extends Item {

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
        GameEngine.tab++;
        GameEngine.print("ZPM.onUse - onUse called on Player");
        GameEngine.tab--;

    }

    /**
     * @param player 
     * @return
     */
    public void onStep(Player player) {
        GameEngine.tab++;
        GameEngine.print("ZPM.onStep - onStep called on Player");
        player.collectedZPMs++;
        GameEngine.tab--;
        // TODO implement here

    }

    /**
     * @return
     */
    public Field getField() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("ZPM.getField - Returned ZPM's current Field");
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
        GameEngine.print("ZPM.setField - Current Field set");
        GameEngine.tab--;
    }

}