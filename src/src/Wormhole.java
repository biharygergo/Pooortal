package src;

/**
 * 
 */
public class Wormhole {

    /**
     * Default constructor
     */
    public Wormhole() {
        GameEngine.print("Wormhole() - New Wormhole created");
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
        GameEngine.print("Wormhole.checkPass - Returned possibility of passing trough wormhole");
        return false;
    }

    /**
     * @return
     */
    public SpecialWall getBlue() {
        // TODO implement here
        GameEngine.print("Wormhole.getBlue - Returned blue end of wormhole");
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
        GameEngine.print("Wormhole.getYellow - Returned yellow end of wormhole");
        return null;
    }

    /**
     * @param specWall 
     * @return
     */
    public void setYellow(SpecialWall specWall) {
        // TODO implement here
        GameEngine.print("Wormhole.setYellow - Yellow end of wormhole set");
    }

}