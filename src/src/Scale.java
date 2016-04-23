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
        description = "Scale";
    }

    /**
     * The weight of the scale (True or False)
     */
    private boolean weight;

    /**
     * Boxes currently stacked
     */
    public List<Box> boxes;

    /**
     * The minimum weight the door will open to
     */
    public int minWeight;

    /**
     * The weight currently on the scale
     */
    public int currentWeight;

    /**
     * The player that is currently standing on the Scale
     */
    public Player playerOnScale;

    /**
     * The door which is connected to the scale
     */
    private Door door;

    /**
     * @return The door which is connected to the scale
     */
    public Door getDoor() {
       return door;
    }

    /**
     * @param door The door to be set for the scale
     */
    public void setDoor(Door door) {
        this.door = door;
    }

    /**
     * @return Whether there is weight on the scale or not
     */
    public boolean getWeight() {

        return weight;
    }

    /**
     * @param weight The weight to be set on the scale
     */
    public void setWeight(boolean weight) {
       this.weight = weight;

    }

    /**
     * @return Whether it's steppable or not
     */
    public boolean steppable() {
        //Ha vannak rajta dobozok, ne lehessen rálépni - > ledől a doboztorony :)
      if(boxes.size()==0)
          return true;

        return false;
    }

    public void reCheckWeights(){
        if(currentWeight<minWeight){
            door.setOpen(false);
        }
        else{
            door.setOpen(true);
        }
    }
    /**
     * @param player the player who wants to step on the field where the scale is
     */
    public void onStep(Player player) {
        if(player.getField().equals(this)) {

            player.onThisScale = this;
            //Kell ez?!

            currentWeight += player.weight;

            if (currentWeight >= minWeight) {
                door.setOpen(true);
            }

        }
    }

    /**
     * What happens when the player shoots on the scale
     * @param bullet The bullet which the player shoots on the scale
     * @param colonelHole The wormhole
     */
    public void onShoot(Bullet bullet, Wormhole colonelHole, Wormhole jaffaHole) {
       bullet.setField(this);
    }

    /**
     *
     * @return
     */
    public Map<Dir, Field> getSides (){
        return sides;
    }

    /**
     *
     * @param replicator this is the replicator
     */
    public void onReplicatorStep(Replicator replicator){
        replicator.setField(this);

    }

    public void listScale(int num){
        System.out.println(num +". (" + xPos + ","+ yPos + ") " + "(" + door.xPos + ","+ door.yPos + ") " + minWeight + " " + currentWeight + " " + door.isOpen());
    }
}