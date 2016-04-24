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
        description = "Door";
    }

    /**
     * Status of the door
     */
    private boolean open;

    //TODO Door kapott egy referenciát Scale-re!
    private Scale scale;

    private boolean playerBlockingDoor;
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
//TODO doksiba írni: uj változó doorblocking? private mondjuk de a fv public!
        playerBlockingDoor=true;
      //GameEngine beallitja hogy mi legyen, itt ez sima Road-kent funkcional!
    }

    /**
     * Returns if there is a player blocking the door
     * @return
     */
    public boolean isPlayerBlockingDoor(){
        return playerBlockingDoor;
    }

    public void reCheckWeightAfterSteppingOff(){

        scale.reCheckWeights();
    }
    /**
     * Set if player is still blocking
     * @param block
     */
    public void setPlayerBlockingDoor(boolean block){
        playerBlockingDoor = block;
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

   public void setScale(Scale scale){
       this.scale = scale;
   }

    public Scale getScale(){
        return scale;
    }
    /**
     * What happens on replicator step
     * @param replicator this is the replicator that stepped on the door
     */
    public void onReplicatorStep(Replicator replicator){
    }
}