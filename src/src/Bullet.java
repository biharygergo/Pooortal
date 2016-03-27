package src;

/**
 * 
 */
public class Bullet{

    /**
     * Default constructor
     */
    public Bullet() {
        GameEngine.tab++;
        GameEngine.print("Bullet.() - new Bullet is created");
        GameEngine.tab--;

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
        GameEngine.tab++;
        GameEngine.print("Bullet.getColor - returned Bullet's color");
        GameEngine.tab--;
        return null;
    }

    /**
     * @param color 
     * @return
     */
    public void setColor(Color color) {
        GameEngine.tab++;
        GameEngine.print("Bullet.setColor - set Bullet's color");
        GameEngine.tab--;
        // TODO implement here

    }

    /**
     * @return
     */
    public Dir getDir() {
        GameEngine.tab++;
        GameEngine.print("Bullet.getDir - returned Bullet's dir");
        GameEngine.tab--;
        // TODO implement here
        return null;
    }

    /**
     * @param dir 
     * @return
     */
    public void setDir(Dir dir) {
        GameEngine.tab++;
        GameEngine.print("Bullet.setDir - set Bullet's dir");
        GameEngine.tab--;
        // TODO implement here

    }

    /**
     * @param f 
     * @return
     */
    public void setField(Field f) {
        GameEngine.tab++;
        GameEngine.print("Bullet.setField - set Bullet's current Field");
        GameEngine.tab--;
        // TODO implement here

    }

    /**
     * @return
     */
    public void getField() {
        GameEngine.tab++;
        GameEngine.print("Bullet.getField - returned Bullet's current Field");
        GameEngine.tab--;
        // TODO implement here

    }

    /**
     * @return
     */
    public boolean isActive() {
        GameEngine.tab++;
        GameEngine.print("Bullet.isActive - returned boolean active");
        GameEngine.tab--;
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