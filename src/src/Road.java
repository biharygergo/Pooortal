package src;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Represents the road field, which is always steppable if nothing stands on it
 */
public class Road extends Field {

    /**
     * Default constructor
     */
    public Road() {
        description = "Road";
    }

    /**
     * @param player the player who wants to step on it
     */
    public void onStep(Player player) {
        //GameEngine állitja be az új fieldet!
    }

    /**
     * @return The boolean whether the road is steppable or not
     */
    public boolean steppable() {
        return true;
    }

    /**
     * What happens when the player shoots on the road
     * @param bullet The bullet which the player shoots on the road
     * @param colonelHole The wormhole
     * @param jaffaHole jaffahole
     */
    public void onShoot(Bullet bullet, Wormhole colonelHole, Wormhole jaffaHole) {
        bullet.setField(this);
    }

    /**
     * What happens when replicator steps on Road
     * @param replicator this is the replicator
     */
    public void onReplicatorStep(Replicator replicator){
        replicator.setField(this);
    }

    public Icon getImage() {
        String name = "images/road.png";
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