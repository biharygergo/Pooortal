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

        //TODO ZPM ujralerakasa a removeZPM-ben!
        for (ZPM zpm : ZPMs) {

            if (zpm.getField().equals(field)) {
                removeZPM(zpm);
                return zpm;
            }
        }

        for (Box box : boxes
                ) {
            if (box.getField().equals(field)) {
                return box;
            }
        }

        return null;

    }

    /**
     * @param string String for initialization
     * @param startField The player starts from this field
     */
    public void initializeModules(String string, Field startField) {
        // TODO letrehozo fv-t kene irni!

    }

    /**
     * @param bullet The bullet to be added
     */
    public void addBullet(Bullet bullet) {

        bullets.add(bullet);
    }

    /**
     * @param bullet The bullet to be removed
     */
    public void removeBullet(Bullet bullet) {

       bullets.remove(bullet);
    }

    /** Remove ZPM and add new ZPM if necessary
     * @param zpm The ZPM to be removed
     */
    public void removeZPM(ZPM zpm) {
       collectedZPMs++;

        if((collectedZPMs%2)==0){
            Road newField =  zpm.getField().getRandomRoad();
            ZPM newZPM = new ZPM();
            newZPM.setField(newField);
            ZPMs.add(newZPM);

            ZPMs.remove(zpm);
        }
        else{
            ZPMs.remove(zpm);
        }
    }

    /**
     * @param box The box to be removed
     */
    public void removeBox(Box box) {
      boxes.remove(box);
    }

    /**
     * @return The list of bullets
     */
    public List<Bullet> getBullets() {
        return bullets;
    }

    public void listBoxes(){}
    public void listZPM(){}
    public void listBullets(){}

}