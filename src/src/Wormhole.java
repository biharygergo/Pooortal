package src;

import java.util.Scanner;

/**
 * Represents a wormhole between two special wall
 */
public class Wormhole {

    private String description;

    /**
     * Default constructor
     */
    public Wormhole() {

    }

    /**
     * This is the color1 portal
     */
    private SpecialWall color1Portal;

    /**
     * This is the color2 portal
     */
    private SpecialWall color2Portal;

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
    public SpecialWall getColor1() {
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
    public void setColor1(SpecialWall specWall) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Wormhole.setBlue - Blue end of wormhole set");
        GameEngine.tab--;
    }

    /**
     * Returns the yellow portal
     * @return The yellow portal of the wormhole
     */
    public SpecialWall getColor2() {
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
    public void setColor2(SpecialWall specWall) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Wormhole.setYellow - Yellow end of wormhole set");
        GameEngine.tab--;
    }

    public void listWormhole(int num){
        System.out.println(num +". (" + color1Portal.getxPos() + ","+ color1Portal.yPos + ") " + color1Portal.getColor() + " (" + color2Portal.getxPos() + ","+ color2Portal.yPos + ") " + color2Portal.getColor());
    }

    public String getDescription() {
        return description;
    }
}