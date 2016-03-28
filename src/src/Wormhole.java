package src;

import java.util.Scanner;

/**
 * 
 */
public class Wormhole {

    /**
     * Default constructor
     */
    public Wormhole() {

    }

    /**
     * 
     */
    private SpecialWall yellowPortal;

    /**
     * 
     */
    private SpecialWall bluePortal;





    /**
     * @return
     */
    public boolean checkPass() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Wormhole.checkPass - Returned possibility of passing trough wormhole");
        GameEngine.print("Átjárható a féregjárat? Y/N");
        Scanner scan=new Scanner(System.in);
        String inp=scan.nextLine();
        GameEngine.tab--;
        if(inp.equals("Y"))
            return true;
        return false;


    }

    /**
     * @return
     */
    public SpecialWall getBlue() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Wormhole.getBlue - Returned blue end of wormhole");
        GameEngine.print("Van már ilyen színű bejárat? Y / N");
        Scanner scan=new Scanner(System.in);
        String inp=scan.nextLine();
        GameEngine.tab--;
        if(inp.equals("Y"))
            return new SpecialWall();
        return null;
    }

    /**
     * @param specWall 
     * @return
     */
    public void setBlue(SpecialWall specWall) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Wormhole.setBlue - Blue end of wormhole set");
        GameEngine.tab--;
    }

    /**
     * @return
     */
    public SpecialWall getYellow() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Wormhole.getYellow - Returned yellow end of wormhole");
        GameEngine.tab--;
        return null;
    }

    /**
     * @param specWall 
     * @return
     */
    public void setYellow(SpecialWall specWall) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Wormhole.setYellow - Yellow end of wormhole set");
        GameEngine.tab--;
    }

}