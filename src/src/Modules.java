package src;

import java.util.*;

/**
 * 
 */
public class Modules {


    public Modules() {

    }

    private List<ZPM> ZPMs;

    private List<Box> boxes;

    private List<Bullet> bullets;







    /**
     * @param field 
     * @return
     */
    public Item searchModule(Field field) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Modules.searchModule - Returned Module on Field");

        GameEngine.print("Következő mezőn van doboz? Y / N");
        Scanner scan=new Scanner(System.in);
        String ans=scan.nextLine();

        if(ans.equals("Y")){
            Box box=new Box();
            GameEngine.tab--;
            return box;
        }
        GameEngine.tab--;
        return null;
    }

    /**
     * @param string 
     * @param startField 
     * @return
     */
    public void initializeModules(String string, Field startField) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Modules.initializeModules - Modules initialized from file input");
        GameEngine.tab--;
    }

    /**
     * @param bullet 
     * @return
     */
    public void addBullet(Bullet bullet) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Modules.addBullet - New Bullet added to active bullets");
        GameEngine.tab--;
    }

    /**
     * @param bullet 
     * @return
     */
    public void removeBullet(Bullet bullet) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Modules.removeBullet - Bullet removed from active bullets");
        GameEngine.tab--;
    }

    /**
     * @param zpm 
     * @return
     */
    public void removeZPM(ZPM zpm) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Modules.removeZPM - ZPM removed from active ZPMs");
        GameEngine.tab--;
    }

    /**
     * @param box 
     * @return
     */
    public void removeBox(Box box) {
        // TODO implement here
        GameEngine.tab++;

        GameEngine.print("Modules.removeBox - Box deleted");
        GameEngine.tab--;
    }

    /**
     * @return
     */
    public List<Bullet> getBullets() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Modules.getBullets - Returned active bullets");
        GameEngine.tab--;
        return bullets;
    }

}