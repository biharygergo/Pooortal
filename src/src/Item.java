package src;

/**
 * Represents the items on the map (ZPM, box)
 */
public abstract class Item {

    /**
     * Default constructor
     */
    public Item() {
      //  GameEngine.print("Item.() - new Item was created");

    }

    /**
     * The field which the item stands on
     */
    protected Field field;

    /**
     * @return The field which the item stands on
     */
    public Field getField() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Item.getField - returns item's current Field");
        GameEngine.tab--;

        return null;
    }

    /**
     * @param field The field to be set for the item
     */
    public void setField(Field field) {
        GameEngine.tab++;
        GameEngine.print("Item.getField - sets item's current Field");
        GameEngine.tab--;
        // TODO implement here

    }

    /**
     * @param player the player who wants to step on the item
     */
    public abstract void onStep(Player player);

    /**
     * @param player the player who wants to use the item
     */
    public abstract void onUse(Player player);

}