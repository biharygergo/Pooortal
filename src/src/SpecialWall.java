package src;

import java.util.*;

/**
 * Represents a special wall, which extends from the wall
 */
public class SpecialWall extends Wall {

    /**
     * Default constructor
     */
    public SpecialWall() {
        description = "SpecialWall";
    }

    /**
     * The color of the special wall when there is a portal on it
     */
    private Color color;

    /**
     * The wormhole on the special wall
     */
    private Wormhole wormHole;

    /**
     * What happens when the player shoots on the special wall
     * @param bullet The bullet which the player shoots on the special wall
     * @param colonelHole The wormhole on the special wall
     */
    public void onShoot(Bullet bullet, Wormhole colonelHole, Wormhole jaffaHole) {

        Color bulletColor = bullet.getColor();

        if(color == bulletColor)
            return;
        //Megnezzuk, hogy melyik lyukhoz tartozik!
        if(bullet.primaryColor == colonelHole.getColor1().getColor()){

        }
    }

    /**
     * Setting the color of the special wall
     * @param color The color to be set for the special wall
     */
    public void setColor(Color color) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("SpecialWall.setColor - New color set");
        GameEngine.tab--;
    }

    /**
     * Returns that the special wall is steppable or not
     * @return The boolean whether the special wall is steppable or not
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
     * What happens when the player wants to step on it
     * @param player the player who wants to step
     */
    public void onStep(Player player) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("SpecialWall.onStep - Onstep called on Player");
        SpecialWall other = wormHole.getColor2();
        player.setField(other);
        GameEngine.tab--;
    }

    /**
     * Returns the color of the special wall
     * @return The color of the special wall
     */
    public Color getColor() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("SpecialWall.getColor - Returned actual color");
        GameEngine.tab--;
        return null;
    }

    /**
     *
     * @param replicator this is the replicator
     */
    public void onReplicatorStep(Replicator replicator){

    }

    public void listSpecialWall(int num){
        System.out.println(num +". (" + xPos + ","+ yPos + ") " + color + " " + wormHole.getDescription());
    }


}

