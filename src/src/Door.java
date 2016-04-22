package src;

import java.util.*;

/**
 * Represents a door on a given field
 */
public class Door extends Field {

    /**
     * Default constructor
     */
    public Door() {

    }

    /**
     * Status of the door
     */
    private boolean open;


    /**
     * @return Returns true if the door is open, false otherwise
     */
    public boolean isOpen() {

        return open;
    }

    /**
     * @param open Status of the door
     */
    public void setOpen(boolean open) {

        this.open=open;

    }

    /**
     * If open, the player steps on it, and automatically steps on the next field in the given direction
     * @param player the player stepped on the door
     */
    public void onStep(Player player) {

        Field nextPlayerField = player.getField().getSide(player.getDir());

        //TODO talaljuk ki hogy itt mi legyen, mert mi van ha doboz van lerakva az ajto elotti roadon? Nem kene tudnunk ralepni, modulest viszont nem latjuk innen!

        player.setField(nextPlayerField);



    }

    /**
     * @return Returns true if open, false otherwise
     */
    public boolean steppable() {


        return open;
    }

    /**
     * If the door is closed, changes the bullet status to false. If open, the bullet flies through the given field
     * @param bullet the bullet hitting, or flying across the door
     * @param colonelHole The colonel's wormhole in the map
     *  @param jaffaHole  jaffa's wormhole in the map

     */
    public void onShoot(Bullet bullet, Wormhole colonelHole, Wormhole jaffaHole) {
       if(!open){
           bullet.setActive(false);
       }
        else{
           bullet.setField(this);
       }
    }

    /**
     * @return Returns the neighbouring fields in a given direction
     */
    public Map<Dir, Field> getSides() {

        return null;
    }

    /**
     * Sets the new neighbours
     * @param map the neighbours of the door in the specified direction
     */
    public void setSides(Map<Dir, Field> map) {
        // TODO implement here

    }


    /**
     * What happens on replicator step
     * @param replicator this is the replicator that stepped on the door
     */
    public void onReplicatorStep(Replicator replicator){

    }
}