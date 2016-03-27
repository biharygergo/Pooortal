package src;

/**
 * 
 */
public class Bullet{

    /**
     * Default constructor
     */
    public Bullet() {
        GameEngine.print("Bullet.() - new Bullet is created");

    }

    /**
     * 
     */
    private Color color;

    /**
     * 
     */
    private Dir dir;

    /**
     * 
     */
    private Field field;

    /**
     * 
     */
    private boolean active;



    /**
     * 
     */
   // public GameEngine currentBullets;







    /**
     * @return
     */
    public Color getColor() {
        // TODO implement here
        GameEngine.print("Bullet.getColor - returned Bullet's color");

        return null;
    }

    /**
     * @param color 
     * @return
     */
    public void setColor(Color color) {
        GameEngine.print("Bullet.setColor - set Bullet's color");

        // TODO implement here

    }

    /**
     * @return
     */
    public Dir getDir() {
        GameEngine.print("Bullet.getDir - returned Bullet's dir");

        // TODO implement here
        return null;
    }

    /**
     * @param dir 
     * @return
     */
    public void setDir(Dir dir) {
        GameEngine.print("Bullet.setDir - set Bullet's dir");

        // TODO implement here

    }

    /**
     * @param f 
     * @return
     */
    public void setField(Field f) {
        GameEngine.print("Bullet.setField - set Bullet's current Field");

        // TODO implement here

    }

    /**
     * @return
     */
    public void getField() {
        GameEngine.print("Bullet.getField - returned Bullet's current Field");

        // TODO implement here

    }

    /**
     * @return
     */
    public boolean isActive() {
        GameEngine.print("Bullet.isActive - returned boolean active");

        // TODO implement here
        return false;
    }

    /**
     * @param act 
     * @return
     */
    public void setActive(boolean act) {
        GameEngine.tab++;
        GameEngine.print("Bullet.setActive - set Bullet as active or inactive");
        GameEngine.tab--;
        // TODO implement here

    }

    /**
     * @param player
     * @return
     */


}