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
        this.color = Color.Empty;
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

        bullet.setActive(false);

        if(color == bulletColor)
            return;
        //Megnezzuk, hogy melyik lyukhoz tartozik!
       if(bulletColor==colonelHole.primaryColor || bulletColor == colonelHole.secondaryColor){
           if(bulletColor == colonelHole.primaryColor){
               if(colonelHole.getColor2()!= null && colonelHole.getColor2().equals(this)){
                   colonelHole.setColor2(null);
               }
               if(colonelHole.getColor1()!=null){
                   colonelHole.getColor1().color = Color.Empty;
                   colonelHole.setColor1(this);
                   color = bulletColor;
                   wormHole = colonelHole;
               }
               else{
                   colonelHole.setColor1(this);
                   color = bulletColor;
                   wormHole = colonelHole;


               }
           }

           if(bulletColor == colonelHole.secondaryColor){
               if(colonelHole.getColor1()!= null && colonelHole.getColor1().equals(this)){
                   colonelHole.setColor1(null);
               }
               if(colonelHole.getColor2()!=null){
                   colonelHole.getColor2().color = Color.Empty;
                   colonelHole.setColor2(this);
                   color = bulletColor;
                   wormHole = colonelHole;

               }
               else{
                   colonelHole.setColor2(this);
                   color = bulletColor;
                   wormHole = colonelHole;


               }
           }
       }

        else {

           if(bulletColor == jaffaHole.primaryColor){
               if(jaffaHole.getColor1()!=null){
                   jaffaHole.getColor1().color = Color.Empty;
                   jaffaHole.setColor1(this);
                   color = bulletColor;
                   wormHole = jaffaHole;

               }
               else{
                   jaffaHole.setColor1(this);
                   color = bulletColor;
                   wormHole = jaffaHole;


               }
           }

           if(bulletColor == jaffaHole.secondaryColor){
               if(jaffaHole.getColor2()!=null){
                   jaffaHole.getColor2().color = Color.Empty;
                   jaffaHole.setColor2(this);
                   color = bulletColor;
                   wormHole = jaffaHole;

               }
               else{
                   jaffaHole.setColor2(this);
                   color = bulletColor;
                   wormHole = jaffaHole;

               }
           }

       }
    }

    /**
     * Setting the color of the special wall
     * @param color The color to be set for the special wall
     */
    public void setColor(Color color) {
       this.color = color;
    }

    /**
     * Returns that the special wall is steppable or not
     * @return The boolean whether the special wall is steppable or not
     */
    public boolean steppable() {
        if(wormHole==null)
            return false;

        return wormHole.checkPass();
    }

    /**
     * What happens when the player wants to step on it
     * @param player the player who wants to step
     */
    public void onStep(Player player) {
        if(player.getField().equals(this)) {
            if (color == wormHole.primaryColor)
                player.setField(wormHole.getColor2());
            else {
                player.setField(wormHole.getColor1());
            }
        }
        else{
            player.dropBoxAllowed=false;
        }
    }

    /**
     * Returns the color of the special wall
     * @return The color of the special wall
     */
    public Color getColor() {
        return color;
    }

    /**
     *
     * @param replicator this is the replicator
     */
    public void onReplicatorStep(Replicator replicator){
        if(color == wormHole.primaryColor)
            replicator.setField(wormHole.getColor2());
        else {
            replicator.setField(wormHole.getColor1());
        }

    }

    public void listSpecialWall(int num){
        System.out.println(num +". (" + xPos + ","+ yPos + ") " + color);
    }
}

