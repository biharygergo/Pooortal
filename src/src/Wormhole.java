package src;

import java.util.Scanner;

/**
 * Represents a wormhole between two special wall
 */
public class Wormhole {

    /**
     * Default constructor
     */
    public Wormhole() {

    }

    /**
     * This is the yellow portal
     */
    private SpecialWall yellowPortal;

    /**
     * This is the blue portal
     */
    private SpecialWall bluePortal;

    /**
     * Returns whether the wormhole is passable or not
     * @return The boolean which represents that the wormhole is passable or not
     */
    public boolean checkPass() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Wormhole.checkPass - Returned possibility of passing trough wormhole");
        GameEngine.print("Átjárható a féregjárat? Y/N");
        Scanner scan=new Scanner(System.in);
        String inp=scan.nextLine().toUpperCase();
        GameEngine.tab--;
        if(inp.equals("Y"))
            return true;
        return false;
    }

    /**
     * Returns the blue portal
     * @return The blue portal of the wormhole
     */
    public SpecialWall getBlue() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Wormhole.getBlue - Returned blue end of wormhole");
        GameEngine.print("Van már ilyen színű bejárat? Y / N");
        Scanner scan=new Scanner(System.in);
        String inp=scan.nextLine().toUpperCase();
        GameEngine.tab--;
        if(inp.equals("Y"))
            return new SpecialWall();
        return null;
    }

    /**
     * Setting the blue portal to the wormhole
     * @param specWall The special wall that represents the blue portal of the wormhole
     */
    public void setBlue(SpecialWall specWall) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Wormhole.setBlue - Blue end of wormhole set");
        GameEngine.tab--;
    }

    /**
     * Returns the yellow portal
     * @return The yellow portal of the wormhole
     */
    public SpecialWall getYellow() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Wormhole.getYellow - Returned yellow end of wormhole");
        GameEngine.tab--;
        return null;
    }

    /**
     * Setting the yellow portal to the wormhole
     * @param specWall The special wall that represents the yellow portal of the wormhole
     */
    public void setYellow(SpecialWall specWall) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Wormhole.setYellow - Yellow end of wormhole set");
        GameEngine.tab--;
    }

    public void listWormhole(){}
}