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
    private Field startField;

    private int collectedZPMs=0;

    public Modules() {

    }

    public void setStartField(Field startField) {
        this.startField = startField;
    }

    /**
     * @param field The field we want to search for item
     * @return The item on the given field
     */
    public Item searchModule(Field field) {

        for (ZPM zpm : ZPMs) {
            if (zpm.getField().equals(field)) {
                removeZPM(zpm);
                return zpm;
            }
        }

        for (Box box : boxes) {
            if (box.getField().equals(field)) {
                return box;
            }
        }

        return null;
    }

    public boolean noMoreZPM(){
        if(ZPMs.size()==0)
            return true;
        return false;
    }

    /**
     * @param filename String for initialization
     * @param startField The player starts from this field
     */
    public void initializeModules(String filename, Field startField) {
        Field current;
        int x;
        int y;
        int weight;
        try(
                BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line = br.readLine();
                String cells[] = new String[10];

                while (line != null) { //végig a sorokon

                    cells = line.split(";");

                    switch (cells[0]){
                        case "Box":
                            x = Integer.parseInt(cells[1]);
                            y = Integer.parseInt(cells[2]);
                            weight = Integer.parseInt(cells[3]);
                            current = startField.getFieldAtPos(x,y);
                            boxes.add(new Box(current, weight));
                            break;
                        case "ZPM":
                            x = Integer.parseInt(cells[1]);
                            y = Integer.parseInt(cells[2]);

                            current = startField.getFieldAtPos(x,y);
                            ZPMs.add(new ZPM(current));
                            break;
                    }

                    line = br.readLine();
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
     * Checks bullet states and updates list
     */
    public void checkBullets(){
        ArrayList<Bullet> newList = new ArrayList<Bullet>();
        for (Bullet bullet: bullets){
            if(bullet.isActive())
                newList.add(bullet);
        }
        bullets=newList;
    }

    /**
     * Checks boxes and updates list
     */
    public void checkBoxes(){
        ArrayList<Box> newList = new ArrayList<Box>();
        for (Box box: boxes) {
            if(box.isAlive())
                newList.add(box);
        }
        boxes=newList;
    }
    /**
     * @param bullet The bullet to be removed
     */
    public void removeBullet(Bullet bullet) {
       bullets.remove(bullet);
    }

    /**
     * Finds ZPM based on its location
     * @param where location
     * @return
     */
    public boolean ZPMisInList(Field where){
        for (ZPM zpm:ZPMs) {
            if(zpm.getField().equals(where))
                return true;
        }
        return false;
    }

    /**
     * Finds box based on location
     * @param where location
     * @return
     */
    public boolean BoxisInList(Field where){
        for (Box box:boxes) {
            if(box.getField().equals(where))
                return true;
        }
        return false;
    }

    /**
     * Finds given ZPM in list
     * @param what this ZPM
     * @return
     */
    public ZPM findZPM(Field what){
        for (ZPM zpm:ZPMs) {
            if(zpm.getField().equals(what))
                return zpm;
        }
        return null;
    }

    /**
     * Finds box based on location
     * @param where location
     * @return
     */
    public Box findBox(Field where){
        for (Box box:boxes) {
            if(box.getField().equals(where))
                return box;
        }
        return null;
    }

    /** Remove ZPM and add new ZPM if necessary
     * @param zpm The ZPM to be removed
     */
    public void removeZPM(ZPM zpm) {
        collectedZPMs++;

        if((collectedZPMs%2) == 0){
            Road newField =  zpm.getField().getRandomRoad(startField);

            while(ZPMisInList(newField) || BoxisInList(newField)){
                newField = zpm.getField().getRandomRoad(startField);
            }

            ZPM newZPM = new ZPM(newField);
            ZPMs.add(newZPM);
        }

        ZPMs.remove(zpm);
    }

    public void clearAll(){
        boxes.clear();
        ZPMs.clear();
        bullets.clear();
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
        int i = 1;
        for (Box box: boxes) {
            System.out.println(i + ". (" + box.field.getxPos() + "," + box.field.getyPos() + ") " + box.getWeight());
            i++;
        }
    }

    public void listZPM(){
        int i = 1;
        for (ZPM zpm: ZPMs) {
            System.out.println(i + ". (" + zpm.field.getxPos() + "," + zpm.field.getyPos() + ") ");
            i++;
        }
    }

    public void listBullets(){
        int i = 1;
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