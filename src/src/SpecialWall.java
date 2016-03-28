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
        GameEngine.print("Milyen színű a lövedék?(B/Y)");
        Scanner scan=new Scanner(System.in);
        String line=scan.nextLine();
        if(line.equals("B")) {
            SpecialWall blueWall = wormHole.getBlue();
            if (blueWall != null) {
                blueWall.setColor(Color.Empty);
            }
            setColor(Color.Blue);
            wormHole.setBlue(this);
        }
        else if (line.equals("Y")){
            SpecialWall yellowWall = wormHole.getYellow();
            if (yellowWall != null) {
                yellowWall.setColor(Color.Empty);
            }
            setColor(Color.Yellow);
            wormHole.setYellow(this);
        }
        GameEngine.tab--;
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
        GameEngine.tab++;
        wormHole = new Wormhole();
        GameEngine.print("SpecialWall.steppable - Field's state returned");
        boolean pass = wormHole.checkPass();
        GameEngine.tab--;
        return pass;
    }

    /**
     * @param player
     */
    public void onStep(Player player) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("SpecialWall.onStep - Onstep called on Player");
        SpecialWall other = wormHole.getYellow();
        player.setField(other);
        GameEngine.tab--;
    }

    /**
     * @return
     */
    public Color getColor() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("SpecialWall.getColor - Returned actual color");
        GameEngine.tab--;
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