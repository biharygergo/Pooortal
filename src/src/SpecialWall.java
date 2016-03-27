package src;

import java.util.*;

/**
 * 
 */
public class SpecialWall extends Wall {

    /**
     * Default constructor
     */
    public SpecialWall() {
        GameEngine.print("SpecialWall() - New SpecialWall created");
    }


    /**
     * 
     */
    private Color color;

    /**
     * 
     */
    private Wormhole wormHole;






    /**
     * @param bullet 
     * @param wormHole 
     * @return
     */
    public void onShoot(Bullet bullet, Wormhole wormHole) {
        // TODO implement here
        GameEngine.tab++;

        GameEngine.print("SpecialWall.onShoot - Called on SpecialWall");
        bullet.setActive(false);
        SpecialWall blueWall=wormHole.getBlue();
        if(blueWall!=null){
            blueWall.setColor(Color.Empty);
        }
        setColor(Color.Blue);
        wormHole.setBlue(this);
    }

    /**
     * @param color 
     * @return
     */
    public void setColor(Color color) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("SpecialWall.setColor - New color set");
        GameEngine.tab--;
    }

    /**
     * 
     */
    public boolean steppable() {
        // TODO implement here
        GameEngine.print("SpecialWall.steppable - Field's state returned");
        return false;
    }

    /**
     * @param player
     */
    public void onStep(Player player) {
        // TODO implement here
        GameEngine.print("SpecialWall.onStep - Onstep called on Player");
    }

    /**
     * @return
     */
    public Color getColor() {
        // TODO implement here
        GameEngine.print("SpecialWall.getColor - Returned actual color");
        return null;
    }

    /**
     * @return

    public Map<Dir, Field> getSides() {
        // TODO implement here
        return null;
    }

    /**
     * @param Map
     * @return

    public void setSides(Map<Dir, Field> map) {
        // TODO implement here

    }*/
}