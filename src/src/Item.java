package src;

/**
 * 
 */
public abstract class Item {

    /**
     * Default constructor
     */
    public Item() {
    }

    /**
     * 
     */
    protected Field field;






    /**
     * @return
     */
    public Field getField() {
        // TODO implement here
        return null;
    }

    /**
     * @param field 
     * @return
     */
    public void setField(Field field) {
        // TODO implement here

    }

    /**
     * @param player 
     * @return
     */
    public abstract void onStep(Player player);

    /**
     * @param player 
     * @return
     */
    public abstract void onUse(Player player);

}