package src;

import java.util.*;

/**
 * Represents the scale on the map
 */
public class Scale extends Field {

    /**
     * Default constructor
     */
    public Scale() {

    }

    /**
     * The weight of the scale (True or False)
     */
    private boolean weight;

    /**
     * The door which is connected to the scale
     */
    private Door door;

    /**
     * @return The door which is connected to the scale
     */
    public Door getDoor() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Scale.getDoor - Returned current Door for Scale");
        GameEngine.tab--;
        return null;
    }

    /**
     * @param door The door to be set for the scale
     */
    public void setDoor(Door door) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Scale.setDoor - Current Door for Scale set");
        GameEngine.tab--;
    }

    /**
     * @return Whether there is weight on the scale or not
     */
    public boolean getWeight() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Scale.getWeight - Returned current weight on Scale");
        GameEngine.tab--;
        return false;
    }

    /**
     * @param weight The weight to be set on the scale
     */
    public void setWeight(boolean weight) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Scale.setWeight - Current weight on Scale set");
        GameEngine.tab--;

    }

    /**
     * @return Whether it's steppable or not
     */
    public boolean steppable() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Scale.steppable - Field's state returned");
        GameEngine.tab--;
        return false;
    }

    /**
     * @param player the player who wants to step on the field where the scale is
     */
    public void onStep(Player player) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Scale.onStep - Onstep called on Player");
        Field playerField=player.getField();
        if (playerField == this){
            door.setOpen(true);
        }
        else{
            //Akkor fogjuk használni, ha a player lemászott a mérlegről
            GameEngine.print("Van súly a mérlegen? Y / N");
            Scanner scanner=new Scanner(System.in);
            String ans=scanner.nextLine().toUpperCase();
            door = new Door();
            if(ans.equals("Y")){
                setWeight(true);
                //Inicializalunk itt egy ajtot

                door.setOpen(true);
            }
            else{
                //Ha nincs súly és nincs rajta, akkor rá akarunk rakni
                Box b=player.dropBox();
                b.setField(this);
                setWeight(true);
                door.setOpen(true);
            }

        }
        GameEngine.tab--;
    }

    /**
     * What happens when the player shoots on the scale
     * @param bullet The bullet which the player shoots on the scale
     * @param wormHole The wormhole
     */
    public void onShoot(Bullet bullet, Wormhole wormHole) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("SpecialWall.onShoot - Called on SpecialWall");
        GameEngine.tab--;
    }

}