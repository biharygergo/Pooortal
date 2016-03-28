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
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Bullet.getColor - returned Bullet's color");
        GameEngine.tab--;
        return null;
    }

    /**
     * @param color Color of the bullet
     */
    public void setColor(Color color) {
        GameEngine.tab++;
        GameEngine.print("Bullet.setColor - set Bullet's color");
        GameEngine.tab--;
        // TODO implement here

    }

    /**
     * @return Returns the direction of the bullet
     */
    public Dir getDir() {
        GameEngine.tab++;
        GameEngine.print("Bullet.getDir - returned Bullet's dir");
        GameEngine.tab--;
        // TODO implement here
        return null;
    }

    /**
     * @param dir Direction of the bullet
     */
    public void setDir(Dir dir) {
        GameEngine.tab++;
        GameEngine.print("Bullet.setDir - set Bullet's dir");
        GameEngine.tab--;
        // TODO implement here

    }

    /**
     * @param field Bullet's actual field
     */
    public void setField(Field field) {
        GameEngine.tab++;
        GameEngine.print("Bullet.setField - set Bullet's current Field");
        GameEngine.tab--;
        // TODO implement here

    }

    /**
     * @return Returns the actual field of the bullet
     */
    public void getField() {
        GameEngine.tab++;
        GameEngine.print("Bullet.getField - returned Bullet's current Field");
        GameEngine.tab--;
        // TODO implement here

    }

    /**
     * @return true, if the bullet is active, otherwise false
     */
    public boolean isActive() {
        GameEngine.tab++;
        GameEngine.print("Bullet.isActive - returned boolean active");
        GameEngine.tab--;
        // TODO implement here
        return false;
    }

    /**
     * @param active Sets the bullet status
     */
    public void setActive(boolean active) {
        GameEngine.tab++;
        GameEngine.print("Bullet.setActive - set Bullet as active or inactive");
        GameEngine.tab--;
        // TODO implement here

    }
}