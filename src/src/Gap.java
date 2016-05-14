package src;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Represents the gap on the map
 */
public class Gap extends Field {

    /**
     * Default constructor
     */
    public Gap() {
        description = "Gap";
    }

    /**
     * @param player the player who wants to step on the gap
     */
    public void onStep(Player player) {
        if(player.getField() != this) {
            Box currentBox = player.getBox();
            if(currentBox != null)
                currentBox.setAlive(false);
            //player.dropBox();
        }

        else {//Ha nem alltunk rajta, akkor dobozt raktunk le, ha rajta allunk akkor bizony meghaltunk!
            player.setAlive(false);
            if(player.getBox()!=null)
                player.getBox().setAlive(false);
        }
    }

    /**
     * @return Whether the gap is steppable or not
     */
    public boolean steppable() {
        //Ra lehet lepni! Ha replicator kicsereli, akkor ugysem ez hivodik meg.
        return true;
    }

    /**
     * What happens when the player shoots on the gap
     * @param bullet The bullet which the player shoots on the gap
     * @param jaffaHole The wormhole of Jaffa
     * @param colonelHole colonel's hole
     */
    public void onShoot(Bullet bullet, Wormhole colonelHole, Wormhole jaffaHole) {
       //Semmi sem történik, mehet tovább a golyó
        bullet.setField(this);
    }

    /**
     * What happens on replicator step: the gap is closed and becomes a road
     * @param replicator this is the replicator
     */
    public void onReplicatorStep(Replicator replicator) {
        Road replace = new Road();

        replace.setPos(this.xPos, this.yPos);
        this.getSide(Dir.Up).setSide(Dir.Down,replace);
        this.getSide(Dir.Down).setSide(Dir.Up,replace);
        this.getSide(Dir.Left).setSide(Dir.Right,replace);
        this.getSide(Dir.Right).setSide(Dir.Left,replace);

        replace.setSides(sides);
        replicator.setAlive(false);
    }

    public Icon getImage() {
        String name = "gap.png";
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