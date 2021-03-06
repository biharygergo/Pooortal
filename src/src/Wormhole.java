package src;

/**
 * Represents a wormhole between two special wall
 */
public class Wormhole {

    public Color primaryColor;
    public Color secondaryColor;

    /**
     * This is the color1 portal
     */
    private SpecialWall color1Portal;

    /**
     * This is the color2 portal
     */
    private SpecialWall color2Portal;

    /**
     * Default constructor
     */
    public Wormhole() {

    }

    /**
     * Returns whether the wormhole is passable or not
     * @return The boolean which represents that the wormhole is passable or not
     */
    public boolean checkPass() {
      if (color1Portal!=null && color2Portal != null)
          return true;

        return false;
    }

    /**
     * Returns the blue portal
     * @return The blue portal of the wormhole
     */
    public SpecialWall getColor1() {
        return color1Portal;
    }

    /**
     * Setting the blue portal to the wormhole
     * @param specWall The special wall that represents the blue portal of the wormhole
     */
    public void setColor1(SpecialWall specWall) {
        color1Portal = specWall;
    }

    /**
     * Returns the yellow portal
     * @return The yellow portal of the wormhole
     */
    public SpecialWall getColor2() {
       return color2Portal;
    }

    /**
     * Setting the yellow portal to the wormhole
     * @param specWall The special wall that represents the yellow portal of the wormhole
     */
    public void setColor2(SpecialWall specWall) {
        color2Portal = specWall;
    }

    public void listWormhole(int num){
        System.out.println(num +"." + (color1Portal == null ? " null Empty" : ("(" + color1Portal.getxPos() + "," + color1Portal.getyPos() + ") " + color1Portal.getColor().name())) +
                (color2Portal == null ? " null Empty" : (" (" + color2Portal.getxPos() + "," + color2Portal.getyPos() + ") "  + color2Portal.getColor().name())));
    }
}