package src;

/**
 * Represents the replicator on the map
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

    Replicator(Field field, Dir dir) {
        this.field = field;
        this.dir = dir;
        this.alive = true;
    }

    /**
     * @return The field which the player currently stands on
     */
    public Field getField() {
        return field;
    }

    /**
     * @param field The field to be set for the replicator
     */
    public void setField(Field field) {
        this.field = field;
    }

    /**
     * @return The direction of the replicator
     */
    public Dir getDir() {
        return dir;
    }

    /**
     * @param dir The direction to be set for the replicator
     */
    public void setDir(Dir dir) {
        this.dir = dir;
    }

    /**
     * @return Whether the player is alive or not
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * @param alive Set if the replicator is alive or dead
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    /**
     * @return The next field
     */
    public Field getNextField() {
        Field nextField = field.getSide(dir);

        return nextField;
    }

    /**
     * What happens when replicator is shot
     * @param bullet this is the killing bullet
     */
    public void onShoot(Bullet bullet){
        alive = false;
        bullet.setActive(false);
    }

    public void listReplicator(int num){
        System.out.println(num + "."  + " (" + field.getxPos() + "," + field.getyPos() + ") " + dir.name() + " " + ((Boolean) alive).toString());
    }
}
