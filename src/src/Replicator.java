package src;

import java.util.Scanner;

/**
 * Created by katalinberes on 2016. 04. 22..
 */
public class Replicator {
    /**
     * The current field of the replicator
     */
    private Field field;

    /**
     * The current direction of the replicator
     */
    private Dir dir;

    /**
     * Is the replicator alive?
     */
    private boolean alive;

    /**
     * @return The field which the player currently stands on
     */
    public Field getField() {
        // TODO implement here

        return field;
    }

    /**
     * @param field The field to be set for the replicator
     */
    public void setField(Field field) {

    }

    /**
     * @return The direction of the replicator
     */
    public Dir getDir() {
        // TODO implement here

        return Dir.Down;
    }

    /**
     * @param dir The direction to be set for the replicator
     */
    public void setDir(Dir dir) {
        // TODO implement here


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
     * @param alive Set if the replicator is alive or dead
     */
    public void setAlive(boolean alive) {
        // TODO implement here

    }

    /**
     * @return The next field
     */
    public Field getNextField() {
        // TODO implement here
        return null;

    }

    /**
     * What happens when replicator is shot
     * @param bullet this is the killing bullet
     */
    public void onShoot(Bullet bullet){

    }

    /**
     *
     * @param value
     */
    public void randomizeReplicator(boolean value){

    }

    public void listReplicator(){}
}
