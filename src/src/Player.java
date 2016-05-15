package src;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Represents a player on the map
 */
public class Player {

    public boolean dropBoxAllowed = true;
    public Door onThisDoor;

    /**
     * The field which the player currently stands on
     */
    private Field field;

    /**
     * The direction of the player
     */
    private Dir dir;

    /**
     * Is the player alive or dead?
     */
    private boolean alive;

    /**
     * The number of ZPMs the player has collected so far
     */
    int collectedZPMs;

    /**
     * The box which the player has picked up
     */
    private Box box;

    /**
     * The weight of the player
     */
    public int weight;

    /**
     * The primary color of this player
     */
    public Color primaryColor;

    /**
     * Not null if the player is currently standing on a Scale
     */
    public Scale onThisScale;

    /**
     * Default constructor
     */
    public Player(){
        field=new Road();
    }

    public Player(Field field, Dir dir, int weight, Color primaryColor) {
        this.field = field;
        this.dir = dir;
        this.weight = weight;
        this.primaryColor = primaryColor;
        this.alive = true;
    }

    /**
     * @return The box which the player has dropped
     */
    public Box dropBox() {
        if(dropBoxAllowed) {
            box.setField(this.getNextField());
            Box returnvalue = box;
            weight -= box.getWeight();
            box = null;
            return returnvalue;
        }
        else{
            dropBoxAllowed = true;
            return null;
        }
    }

    /**
     * @return the bullet which the player shot color1
     */
    public Bullet shootColor1() {

        Bullet bullet = new Bullet();
        bullet.setColor(primaryColor);
        bullet.setField(field);
        bullet.setDir(dir);
        bullet.setActive(true);

        return bullet;
    }

    /**
     * @return The color2 bullet
     */
    public Bullet shootColor2() {
        Bullet bullet = new Bullet();
        //Óriás trükk: így a következő színt lehet beállítani a golyónak
        bullet.setColor(primaryColor.next());
        bullet.setField(field);
        bullet.setDir(dir);
        bullet.setActive(true);

        return bullet;
    }

    /**
     * @return The field which the player currently stands on
     */
    public Field getField() {
        return field;
    }

    /**
     * @param field The field to be set for the player
     */
    public void setField(Field field) {
        if(onThisScale!=null){
            int currentWeight = onThisScale.getCurrentWeight() - weight;
            onThisScale.setCurrentWeight(currentWeight);
            if(onThisScale.getCurrentWeight()<onThisScale.getMinWeight()){
                onThisScale.getDoor().setOpen(false);
            }
            onThisScale = null;
        }

        if(onThisDoor!=null){
            onThisDoor.setPlayerBlockingDoor(false);
            onThisDoor.reCheckWeightAfterSteppingOff();
            onThisDoor = null;

        }
        if(box!=null)
            box.setField(field);
        this.field=field;
    }

    /**
     * @return The direction of the player
     */
    public Dir getDir() {
       return dir;
    }

    /**
     * @param dir The direction to be set for the player
     */
    public void setDir(Dir dir) {
      this.dir = dir;
    }

    /**
     * @return The box which the player has picked up
     */
    public Box getBox() {
        return box;
    }

    /**
     * @param box The box to be set for the player
     */
    public void setBox(Box box) {
        this.box = box;
    }

    /**
     * @return Whether the player is alive or not
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * @param alive Set if the player is alive or dead
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    /**
     * @return The next field
     */
    public Field getNextField() {
        Field nextField = field.getSide(dir);

        return nextField;
    }

    public void listPlayer(int num, String playerName){
        System.out.println(num + ". " + playerName + " (" + field.getxPos() + "," + field.getyPos() + ") " + dir.name() +
                (box == null ? " null " : ("(" + box.getField().getxPos() + "," + box.getField().getyPos() + ") ")) +
                ((Boolean) alive).toString() + " " + collectedZPMs + " " + weight + " " + primaryColor);
    }

    public int getX(){
        return field.getxPos();
    }

    public int getY(){
        return field.getyPos();
    }


    public Icon getImage() {
        String name;
        if(primaryColor == Color.Blue)
            name = "images/oneil.png";
        else{
            name = "images/jaffa.png";
        }
        String path ="src/"+name;
        File file = new File(path);
        BufferedImage image = null;
        try {
            image = ImageIO.read(file);

            image = View.rotate(image, View.getAngleFromDir(dir));

            Image dimg =image.getScaledInstance(50,50, Image.SCALE_SMOOTH);
            return new ImageIcon(dimg);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}