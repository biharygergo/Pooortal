package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Contains the different modules on the map: ZPMs, boxes and bullets
 */
public class Modules {

    private ArrayList<Bullet> bullets = new ArrayList<>();
    private ArrayList<ZPM> ZPMs = new ArrayList<>();
    private ArrayList<Box> boxes = new ArrayList<>();

    public Modules() {

    }

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
    public void initializeModules(String filename, Field startField) {

        try(
                BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line = br.readLine();
                String cells[] = new String[10];

                while (line != null) { //végig a sorokon
                    line = br.readLine();
                    cells = line.split(";");

                    switch (cells[0]){
                        case "Box":

                            break;
                        case "ZPM":
                            break;

                    }

                    br.readLine();
                }

        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public void listBoxes(){
        int i = 0;
        for (Box box: boxes) {
            System.out.println(i + ". (" + box.field.getxPos() + "," + box.field.getyPos() + ") " + box.getWeight());
            i++;
        }
    }
    public void listZPM(){
        int i = 0;
        for (ZPM zpm: ZPMs) {
            System.out.println(i + ". (" + zpm.field.getxPos() + "," + zpm.field.getyPos() + ") ");
            i++;
        }
    }
    public void listBullets(){
        int i = 0;
        for (Bullet bullet: bullets) {
            System.out.println(i + ". (" + bullet.getField().getxPos() + "," + bullet.getField().getyPos() + ") " + bullet.getColor() + " " + bullet.getDir() + " ");
            i++;
        }
    }

    public void addBox(Box box){
        boxes.add(box);
    }

    public Box getBox(int index){
        return boxes.get(index);
    }

}