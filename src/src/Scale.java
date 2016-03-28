package src;

import java.util.*;

/**
 * 
 */
public class Scale extends Field {

    /**
     * Default constructor
     */
    public Scale() {

    }


    /**
     * 
     */
    private boolean weight;


    /**
     * 
     */
    private Door door;

    /**
     * @return
     */
    public Door getDoor() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Scale.getDoor - Returned current Door for Scale");
        GameEngine.tab--;
        return null;
    }

    /**
     * @param door 
     * @return
     */
    public void setDoor(Door door) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Scale.setDoor - Current Door for Scale set");
        GameEngine.tab--;
    }

    /**
     * @return
     */
    public boolean getWeight() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Scale.getWeight - Returned current weight on Scale");
        GameEngine.tab--;
        return false;
    }

    /**
     * @param weight 
     * @return
     */
    public void setWeight(boolean weight) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Scale.setWeight - Current weight on Scale set");
        GameEngine.tab--;

    }

    /**
     * @return
     */
    public boolean steppable() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Scale.steppable - Field's state returned");
        GameEngine.tab--;
        return false;
    }

    /**
     * @param player 
     * @return
     */
    public void onStep(Player player) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Scale.onStep - Onstep called on Player");
        Field playerField=player.getField();
        if (playerField==this){
            door.setOpen(true);
        }
        else{
            //Akkor fogjuk használni, ha a player lemászott a mérlegről
            GameEngine.print("Van súly a mérlegen? I/N");
            Scanner scanner=new Scanner(System.in);
            String ans=scanner.nextLine();
            if(ans.equals("I")){
                setWeight(true);
                //Inicializalunk itt egy ajtot
                door=new Door();
                door.setOpen(true);
            }
            else{
                //Ha nincs súly és nincs rajta, akkor csukjuk be
                door.setOpen(false);
            }

        }
        GameEngine.tab--;
    }

    /**
     * @param bullet 
     * @param wormHole 
     * @return
     */
    public void onShoot(Bullet bullet, Wormhole wormHole) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("SpecialWall.onShoot - Called on SpecialWall");
        GameEngine.tab--;
    }

    /**
     * @return
     *

    public Map<Dir, Field> getSides() {
        // TODO implement here
        return null;
    }


    public void setSides(Map<Dir, Field> map) {
        // TODO implement here

    }
    */


}