package src;

import java.util.*;

/**
 * 
 */
public class Modules {

    /**
     * Default constructor
     */
    public Modules() {
    }

    /**
     * 
     */
    private List<ZPM> ZPMs;

    /**
     * 
     */
    private List<Box> boxes;

    /**
     * 
     */
    private List<Bullet> bullets;







    /**
     * @param field 
     * @return
     */
    public Item searchModule(Field field) {
        // TODO implement here
        GameEngine.print("Modules.searchModule - Returned Module on Field");
        return null;
    }

    /**
     * @param string 
     * @param startField 
     * @return
     */
    public void initializeModules(String string, Field startField) {
        // TODO implement here
        GameEngine.print("Modules.initializeModules - Modules initialized from file input");
    }

    /**
     * @param bullet 
     * @return
     */
    public void addBullet(Bullet bullet) {
        // TODO implement here
        GameEngine.print("Modules.addBullet - New Bullet added to active bullets");
    }

    /**
     * @param bullet 
     * @return
     */
    public void removeBullet(Bullet bullet) {
        // TODO implement here
        GameEngine.print("Modules.removeBullet - Bullet removed from active bullets");
    }

    /**
     * @param zpm 
     * @return
     */
    public void removeZPM(ZPM zpm) {
        // TODO implement here
        GameEngine.print("Modules.removeZPM - ZPM removed from active ZPMs");
    }

    /**
     * @param box 
     * @return
     */
    public void removeBox(Box box) {
        // TODO implement here
        GameEngine.print("Modules.removeBox - Box deleted");
    }

    /**
     * @return
     */
    public List<Bullet> getBullets() {
        // TODO implement here
        GameEngine.print("Modules.getBullets - Returned active bullets");
        return bullets;
    }

}