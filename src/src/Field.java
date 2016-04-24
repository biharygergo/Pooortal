package src;

import java.util.*;

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
    protected Map<Dir, Field> sides = new HashMap<Dir, Field>();

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
       //sides = map;
        sides.put(Dir.Up, map.get(Dir.Up));
        sides.put(Dir.Down, map.get(Dir.Down));
        sides.put(Dir.Left, map.get(Dir.Left));
        sides.put(Dir.Right, map.get(Dir.Right));
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
    public Road getRandomRoad(Field startfield){
        Field current = startfield, first = startfield; //current: actual field, first: first field of current row
        ArrayList<Road> roads = new ArrayList<>();

        for (int i = 0; first != null; i++) {

            for (int j = 0; current != null ; j++) {
                if (current.getDescription().equals("Road"))
                    roads.add((Road) current);
                current = current.getSide(Dir.Right);
            }

            current = first.getSide(Dir.Down);
            first = first.getSide(Dir.Down); //go one field down
        }

        Random r = new Random();
        int Low = 0;
        int High = roads.size();
        int Result = r.nextInt(High-Low) + Low;

        return roads.get(Result);
    }

   /* public Road getRandomRoad(Field startHere, List<Box> boxes, List<ZPM> zpms){
        //TODO rekurziv algoritmust írni, ami megkeres egy utat!

        Road foundGoodRoad = null;
        boolean noMoreFields;

        Field topLeft = null;

        Field currentField;

        int maxwidth = 6;
        int maxheight = 6;

        int currentx = startHere.getxPos();
        int currenty = startHere.getyPos();

        //Elvileg ezekkel a bal felső sarkot kellene megkapnunk
        for(int i=0; i<currentx; i++){
            if(i==0)
                topLeft=startHere;
            else {
                topLeft = topLeft.getSide(Dir.Left);
            }
        }

        for(int j = currenty; j<maxheight; j++){
            topLeft = topLeft.getSide(Dir.Up);
        }

        currentField = topLeft;

        for ( int row = 0; row < maxheight; row++){
            for(int column = 0; column<maxwidth; column++){
                
            }
        }
        return null;
    }*/

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

    public void setPos(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }
    public Field getFieldAtPos(int x, int y){
        Field current = this;
        for (int i = 0; i < x-1; i++) {
            current = current.getSide(Dir.Down);
        }

        for (int i = 0; i < y-1; i++) {
            current = current.getSide(Dir.Right);
        }

        return  current;
    }

    public Field getFixRoad() {
        return getFieldAtPos(5, 4);
    }
}