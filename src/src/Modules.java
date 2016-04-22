package src;

import java.util.*;

/**
 * Contains the different modules on the map: ZPMs, boxes and bullets
 */
public class Modules {

    public Modules() {

    }

    private List<ZPM> ZPMs;

    private List<Box> boxes;

    private List<Bullet> bullets;

    private int collectedZPMs=0;
    /**
     * @param field The field we want to search for item
     * @return The item on the given field
     */
    public Item searchModule(Field field) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Modules.searchModule - Returned Module on Field");

        GameEngine.print("Következő mezőn van doboz? Y / N");
        Scanner scan=new Scanner(System.in);
        String ans=scan.nextLine().toUpperCase();

        if(ans.equals("Y")){
            Box box=new Box();
            GameEngine.tab--;
            return box;
        }

        GameEngine.print("Következő mezőn van ZPM? (Csak a 9-es esetben igaz!) Y / N");
        ans= scan.nextLine().toUpperCase();
        if(ans.equals("Y")){
            ZPM zpm=new ZPM();
            removeZPM(zpm);
            GameEngine.tab--;
            return zpm;
        }
        GameEngine.tab--;
        return null;
    }

    /**
     * @param string String for initialization
     * @param startField The player starts from this field
     */
    public void initializeModules(String string, Field startField) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Modules.initializeModules - Modules initialized from file input");
        GameEngine.tab--;
    }

    /**
     * @param bullet The bullet to be added
     */
    public void addBullet(Bullet bullet) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Modules.addBullet - New Bullet added to active bullets");
        GameEngine.tab--;
    }

    /**
     * @param bullet The bullet to be removed
     */
    public void removeBullet(Bullet bullet) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Modules.removeBullet - Bullet removed from active bullets");
        GameEngine.tab--;
    }

    /** Remove ZPM and add new ZPM if necessary
     * @param zpm The ZPM to be removed
     */
    public void removeZPM(ZPM zpm) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Modules.removeZPM - ZPM removed from active ZPMs");
        GameEngine.tab--;
    }

    /**
     * @param box The box to be removed
     */
    public void removeBox(Box box) {
        // TODO implement here
        GameEngine.tab++;

        GameEngine.print("Modules.removeBox - Box deleted");
        GameEngine.tab--;
    }

    /**
     * @return The list of bullets
     */
    public List<Bullet> getBullets() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Modules.getBullets - Returned active bullets");
        GameEngine.tab--;
        return bullets;
    }

    public void listBoxes(){}
    public void listZPM(){}
    public void listBullets(){}

}