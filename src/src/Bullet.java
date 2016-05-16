package src;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Represents a bullet in a given color
 */
public class Bullet{
    BufferedImage red, blue, green, yellow;
    /**
     * Color of the bullet
     */
    private Color color;


    /**
     * Direction of the bullet
     */
    private Dir dir;

    /**
     * Current field of the bullet
     */
    private Field field;

    /**
     * Status of the bullet
     */
    private boolean active;

    /**
     * Default constructor
     */
    public Bullet() {
    }

    /**
     * @return Returns the color of the bullet
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color Color of the bullet
     */
    public void setColor(Color color) {
      this.color=color;
    }

    /**
     * @return Returns the direction of the bullet
     */
    public Dir getDir() {
        return dir;
    }

    /**
     * @param dir Direction of the bullet
     */
    public void setDir(Dir dir) {
       this.dir=dir;
    }

    /**
     * @param field Bullet's actual field
     */
    public void setField(Field field) {
        this.field=field;
    }

    /**
     * @return Returns the actual field of the bullet
     */
    public Field getField() {
        return field;
    }

    /**
     * @return true, if the bullet is active, otherwise false
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active Sets the bullet status
     */
    public void setActive(boolean active) {
        this.active=active;
    }

    public Field getNextField(){
        Field nextField = field.getSide(dir);
        return nextField;
    }


    public BufferedImage getImage() {
        if (blue == null || green == null || red == null || yellow == null) {
            try {
                blue = ImageIO.read(new File("res/img/blue_bullet.png"));
                red = ImageIO.read(new File("res/img/red_bullet.png"));
                green = ImageIO.read(new File("res/img/green_bullet.png"));
                yellow = ImageIO.read(new File("res/img/yellow_bullet.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        switch (color) {
            case Blue:
                return blue;
            case Yellow:
                return yellow;
            case Green:
                return green;
            case Red:
                return red;
        }

        return null;
    }

}