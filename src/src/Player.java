package src;

import java.util.Scanner;

/**
 * Represents the player on the map
 */
public class Player {

    /**
     * Default constructor
     */
    public Player(){
        field=new Road();
    }

    /**
     * The field which the player currently stands on
     */
    private Field field;

    /**
     * The direction of the player
     */
    private Dir dir;

    /**
     * Is the player alive or dead?
     */

    private boolean alive;

    /**
     * The number of ZPMs the player has collected so far
     */
    int collectedZPMs;

    /**
     * The box which the player has picked up
     */
    private Box box;

    /**
     * The weight of the player
     */
    public int weight;

    /**
     * The primary color of this player
     */
    public Color primaryColor;

    /**
     * Not null if the player is currently standing on a Scale
     */
    public Scale onThisScale;


    /**
     * @return The box which the player has dropped
     */
    public Box dropBox() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Player.dropBox - Box dropped");
        //Box box=new Box();
        box = null;
        GameEngine.tab--;
        return new Box();
    }

    /**
     * @return the bullet which the player shot color1
     */
    public Bullet shootColor1() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Player.shootBlue - Blue bullet shot");
        GameEngine.tab--;
        return null;
    }

    /**
     * @return The color2 bullet
     */
    public Bullet shootColor2() {
        // TODO implement here
        GameEngine.tab--;
        GameEngine.print("Player.shootYellow - Yellow bullet shot");
        GameEngine.tab--;
        return null;
    }

    /**
     * @return The field which the player currently stands on
     */
    public Field getField() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Player.getField - Returned field");


        GameEngine.tab--;
        return field;
    }

    /**
     * @param field The field to be set for the player
     */
    public void setField(Field field) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Player.setField - Field set");
        this.field=field;
        GameEngine.tab--;
    }

    /**
     * @return The direction of the player
     */
    public Dir getDir() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Player.getDir - Returned direction");
        GameEngine.tab--;
        return Dir.Down;
    }

    /**
     * @param dir The direction to be set for the player
     */
    public void setDir(Dir dir) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Player.setDir - Direction set");
        GameEngine.tab--;

    }

    /**
     * @return The box which the player has picked up
     */
    public Box getBox() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Player.getBox - Returned box");
        GameEngine.print("Van a játékosnál doboz? Y / N");
        Scanner scan=new Scanner(System.in);
        String input=scan.nextLine().toUpperCase();

        if(input.equals("Y")){
            Box box=new Box();
            GameEngine.tab--;
            return box;
        }
        GameEngine.tab--;
        return null;
    }

    /**
     * @param box The box to be set for the player
     */
    public void setBox(Box box) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Player.setBox - Box set");
        GameEngine.tab--;
    }

    /**
     * @return Whether the player is alive or not
     */
    public boolean isAlive() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Player.isAlive - Returned player state");
        GameEngine.print("Meghaltunk? Y/N");
        Scanner scan=new Scanner(System.in);
        String line=scan.nextLine().toUpperCase();

        GameEngine.tab--;
        if (line.equals("Y"))
            return false;
        else return true;



    }

    /**
     * @param alive Set if the player is alive or dead
     */
    public void setAlive(boolean alive) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Player.setAlive - Player state set");
        GameEngine.tab--;
    }

    /**
     * @return The next field
     */
    public Field getNextField() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Player.getNextField - Returned next field");

        GameEngine.print("Lehet a következő mezőre lépni? Y / N");
        Scanner scan=new Scanner(System.in);

       String input= scan.nextLine().toUpperCase();
        if(input.equals("Y")) {
            Road r=new Road();
            GameEngine.tab--;
            return r;
        }
        else {
            Wall r=new Wall();
            GameEngine.tab--;
            return r;
        }

    }

    public void listPlayer(int num){

    }

}