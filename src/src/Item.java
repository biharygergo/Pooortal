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

        return field;
    }

    /**
     * @param field The field to be set for the item
     */
    public void setField(Field field) {

         this.field=field;
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