package src;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Represents a box on a given field
 */
public class Box extends Item {

    private int weight;
    private boolean alive;
    private BufferedImage myImage;

    public Box(Field f, int w) {
        field = f;
        weight = w;
        alive = true;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
      * Handles the pick up and drop of the box
      * @param player the player who wants to use the box
     */
    public void onUse(Player player) {
        if(player.getBox()!=null)
            return;

        player.setBox(this);
        this.field = player.getField();

        //Hozzaadjuk a player sulyahoz a box sulyat?
        player.weight+=this.weight;

    }

    /**
     * What to do if the player want to step on a field which has a box on it
     * @param player the player who wants to step on the field
     */
    public void onStep(Player player) {
        //Elvileg nem csinálunk semmit
    }

    /**
     * @return Returns the current field on which the box stands
     */
    public Field getField() {
        return field;
    }

    /**
     * Sets the new field for the box
     * @param field The new field
     */
    public void setField(Field field) {
     this.field=field;
    }

    public boolean isAlive(){
        return alive;
    }

    public void setAlive(boolean life){
        alive=life;
    }

    public BufferedImage getImage() {
        if (image == null) {
            try {
                image = ImageIO.read(new File("res/img/box.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return image;
    }
}