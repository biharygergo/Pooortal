package src;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Represents the scale on the map
 */
public class Scale extends Field {

    /**
     * The weight of the scale (True or False)
     */
    private boolean weight;

    /**
     * Boxes currently stacked
     */
    private ArrayList<Box> boxes = new ArrayList<>();

    /**
     * The minimum weight the door will open to
     */
    private int minWeight;

    /**
     * The weight currently on the scale
     */
    private int currentWeight;

    /**
     * The player that is currently standing on the Scale
     */
    private Player playerOnScale;

    /**
     * The door which is connected to the scale
     */
    private Door door;

    /**
     * Default constructor
     */
    public Scale() {
        description = "Scale";
    }

    /**
     * @return The door which is connected to the scale
     */
    public Door getDoor() {
       return door;
    }

    /**
     * @param door The door to be set for the scale
     */
    public void setDoor(Door door) {
        this.door = door;
    }

    /**
     * @return Whether there is weight on the scale or not
     */
    public boolean getWeight() {
        return weight;
    }

    /**
     * @param weight The weight to be set on the scale
     */
    public void setWeight(boolean weight) {
       this.weight = weight;
    }

    /**
     * @return Whether it's steppable or not
     */
    public boolean steppable() {
        //Ha vannak rajta dobozok, ne lehessen rálépni - > ledől a doboztorony :)
      if(boxes.size()==0)
          return true;

        return false;
    }

    public void reCheckWeights(){
        if(currentWeight<minWeight){
            door.setOpen(false);
        }
        else{
            door.setOpen(true);
        }
    }
    /**
     * @param player the player who wants to step on the field where the scale is
     */
    public void onStep(Player player) {
        if(player.getField().equals(this)) {

            player.onThisScale = this;
            //Kell ez?!

            currentWeight += player.weight;

            if (currentWeight >= minWeight) {
                door.setOpen(true);
            }

        }
        else{
            Box box = player.getBox();
            boxes.add(box);
            currentWeight+=box.getWeight();
            if(currentWeight >=minWeight)
                door.setOpen(true);
        }
    }

    public Box getBoxOnTop(){
        return boxes.get(boxes.size()-1);
    }
    public void removeBox(Box box){
        int boxweight = box.getWeight();
        currentWeight-=boxweight;
        boxes.remove(box);
        reCheckWeights();
    }
    /**
     * What happens when the player shoots on the scale
     * @param bullet The bullet which the player shoots on the scale
     * @param colonelHole The wormhole
     */
    public void onShoot(Bullet bullet, Wormhole colonelHole, Wormhole jaffaHole) {
       bullet.setField(this);
    }

    /**
     *
     * @param replicator this is the replicator
     */
    public void onReplicatorStep(Replicator replicator){
        replicator.setField(this);

    }

    public void listScale(int num){
        System.out.println(num + ". (" + xPos + "," + yPos + ") " + "(" + door.xPos + "," + door.yPos + ") " + minWeight + " " + currentWeight + " " + door.isOpen());
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setMinWeight(int minWeight) {
        this.minWeight = minWeight;
    }

    public int getMinWeight() {
        return minWeight;
    }

    public Icon getImage() {
        String name = "scale.png";
        String path ="src/"+name;
        File file = new File(path);
        BufferedImage image = null;
        try {
            image = ImageIO.read(file);
            Image dimg =image.getScaledInstance(50,50, Image.SCALE_SMOOTH);
            return new ImageIcon(dimg);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}