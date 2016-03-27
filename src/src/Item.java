package src;

/**
 * 
 */
public abstract class Item {

    /**
     * Default constructor
     */
    public Item() {
      //  GameEngine.print("Item.() - new Item was created");

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
        GameEngine.tab++;
        GameEngine.print("Item.getField - returns item's current Field");
        GameEngine.tab--;

        return null;
    }

    /**
     * @param field 
     * @return
     */
    public void setField(Field field) {
        GameEngine.tab++;
        GameEngine.print("Item.getField - sets item's current Field");
        GameEngine.tab--;
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