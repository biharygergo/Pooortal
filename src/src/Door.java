package src;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Represents a door on a given field
 */
public class Door extends Field {

    private Scale scale;
    private boolean playerBlockingDoor;

    /**
     * Status of the door
     */
    private boolean open;

    /**
     * Default constructor
     */
    public Door() {
        description = "Door";
    }

    /**
     * @return Returns true if the door is open, false otherwise
     */
    public boolean isOpen() {
        return open;
    }

    /**
     * @param open Status of the door
     */
    public void setOpen(boolean open) {
        if(playerBlockingDoor)
            this.open = true;
        else {
            this.open = open;
        }
    }

    /**
     * If open, the player steps on it, and automatically steps on the next field in the given direction
     * @param player the player stepped on the door
     */
    public void onStep(Player player) {
        playerBlockingDoor=true;
        player.onThisDoor = this;
      //GameEngine beallitja hogy mi legyen, itt ez sima Road-kent funkcional!
    }

    /**
     * Returns if there is a player blocking the door
     * @return
     */
    public boolean isPlayerBlockingDoor(){
        return playerBlockingDoor;
    }

    public void reCheckWeightAfterSteppingOff(){
        scale.reCheckWeights();
    }
    /**
     * Set if player is still blocking
     * @param block
     */
    public void setPlayerBlockingDoor(boolean block){
        playerBlockingDoor = block;
    }
    /**
     * @return Returns true if open, false otherwise
     */
    public boolean steppable() {
        return open;
    }

    /**
     * If the door is closed, changes the bullet status to false. If open, the bullet flies through the given field
     * @param bullet the bullet hitting, or flying across the door
     * @param colonelHole The colonel's wormhole in the map
     *  @param jaffaHole  jaffa's wormhole in the map

     */
    public void onShoot(Bullet bullet, Wormhole colonelHole, Wormhole jaffaHole) {
       if(!open){
           bullet.setActive(false);
       }
        else{
           bullet.setField(this);
       }
    }

    /**
     * @return Returns the neighbouring fields in a given direction
     */

   public void setScale(Scale scale){
       this.scale = scale;
   }

    public Scale getScale(){
        return scale;
    }
    /**
     * What happens on replicator step
     * @param replicator this is the replicator that stepped on the door
     */
    public void onReplicatorStep(Replicator replicator){
    }

    public Icon getImage() {
        String name = "door_closed.png";
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