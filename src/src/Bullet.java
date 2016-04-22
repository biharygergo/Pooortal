package src;

/**
 * Represents a bullet in a given color
 */
public class Bullet{

    /**
     * Default constructor
     */
    public Bullet() {
    }

    /**
     * Color of the bullet
     */
    private Color color;

    public Color primaryColor;
    /**
     * Direction of the bullet
     */
    private Dir dir;

    /**
     * Current field of the bullet
     */
    private Field field;

    /**
     * Status of the bullet
     */
    private boolean active;

    /**
     * @return Returns the color of the bullet
     */
    public Color getColor() {

        return color;
    }

    /**
     * @param color Color of the bullet
     */
    public void setColor(Color color) {
      this.color=color;

    }

    /**
     * @return Returns the direction of the bullet
     */
    public Dir getDir() {

        return dir;
    }

    /**
     * @param dir Direction of the bullet
     */
    public void setDir(Dir dir) {
       this.dir=dir;

    }

    /**
     * @param field Bullet's actual field
     */
    public void setField(Field field) {
        this.field=field;

    }

    /**
     * @return Returns the actual field of the bullet
     */
    public Field getField() {

        return field;
    }

    /**
     * @return true, if the bullet is active, otherwise false
     */
    public boolean isActive() {

        return active;
    }

    /**
     * @param active Sets the bullet status
     */
    public void setActive(boolean active) {
        this.active=active;

    }

    public Field getNextField(){
        Field nextField = field.getSide(dir);
        return nextField;
    }
}