package src;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Represents a ZPM on a given field (road)
 */
public class ZPM extends Item {

    private BufferedImage myImage;
    /**
     * Default constructor
     */
    public ZPM(Field current) {
        field = current;
    }

    /**
     * What happens when the player wants to use the field which has the ZPM on it
     * @param player the player who wants to use the ZPM
     */
    public void onUse(Player player) {
     //Itt nem történik semmi ha minden igaz
    }

    /**
     * What happens when the player steps on it
     * @param player the player who wants to step on the field with ZPM on it
     */
    public void onStep(Player player) {
       player.collectedZPMs++;
       player.setField(this.field); //max ennyi

        //Itt még mi történik?

    }

    /**
     * Returns the field on which the ZPM stands
     * @return Returns the field on which the ZPM stands
     */
    public Field getField() {
      return this.field;
    }

    /**
     * Sets the new field of the ZPM
     * @param field The new field
     */
    public void setField(Field field) {
       this.field = field;
    }

    public BufferedImage getImage() {
        String name = "zpm.png";
        String path ="src/"+name;
        File file = new File(path);
        BufferedImage image = null;
        try {
            if(myImage == null){
                image = ImageIO.read(file);
                myImage = image;
                return image;}
            else{
                return myImage;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}