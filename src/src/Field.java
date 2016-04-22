package src;

import java.util.Map;

/**
 * Abstract class representing the fields on the map
 */
public abstract class Field {

    protected String description;
    protected int xPos, yPos;

    /**
     * Default constructor
     */
    public Field() {
    }

    /**
     * The neighbouring fields
     */
    protected Map<Dir, Field> sides;

    /**
     * @return true if the player can step on it, false otherwise
     */
    public abstract boolean steppable();

    /**
     * What to do if the player want to step on a field
     * @param player the player who wants to step on the field
     */
    public abstract void onStep(Player player);

    /**
     * What to do if a fired bullet reaches the field
     * @param bullet the bullet hitting, or flying across the field
     * @param colonelHole The wormhole in the map
     * @param jaffaHole The wormhole in the map
     */
    public abstract void onShoot(Bullet bullet, Wormhole colonelHole, Wormhole jaffaHole);

    /**
     * @return Returns the neighbouring fields in a given direction
     */
    public Map<Dir, Field> getSides() {

        return sides;
    }

    //TODO: insert into document
    public Field getSide(Dir dir){
        //TODO így kell ezt címezni? nem sides[dir]? - maró: így
        return sides.get(dir);

    }

    public void setSide(Dir dir, Field newSide){
        sides.put(dir, newSide);
    }
    /**
     * Sets the new neighbours
     * @param map the neighbours of the door in the specified direction* @param map
     */
    public void setSides(Map<Dir, Field> map) {
       sides=map;

    }
    /**
     * what happens on replicator step
     * @param replicator this is the replicator
     */
    public abstract void onReplicatorStep(Replicator replicator);

    /**
     * Used when trying to place a new ZPM. Returns a random road that is steppable
     * @return road
     */
    public Field getRandomRoad(){
        //TODO rekurziv algoritmust írni, ami megkeres egy utat!
        return null;
    }

    public void listField(int num){
        System.out.println(num +". (" + xPos + ","+ yPos + ") " + description);
    }

    public String getDescription() {
        return description;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }
}