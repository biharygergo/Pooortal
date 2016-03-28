package src;

/**
 * Represents the gap on the map
 */
public class Gap extends Field {

    /**
     * Default constructor
     */
    public Gap() {

    }

    /**
     * @param player the player who wants to step on the gap
     */
    public void onStep(Player player) {
        GameEngine.tab++;
        GameEngine.print("Gap.onStep - Gap was stepped on by player");

        if(player.getField()!=this){
            player.dropBox();
            GameEngine.tab--;

            return;
        }

            player.setAlive(false);


        GameEngine.tab--;
        // TODO implement here
    }

    /**
     * @return Whether the gap is steppable or not
     */
    public boolean steppable() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Gap.steppable - returns true for Gap");
        GameEngine.tab--;
        return false;
    }

    /**
     * What happens when the player shoots on the gap
     * @param bullet The bullet which the player shoots on the gap
     * @param wormHole The wormhole
     */
    public void onShoot(Bullet bullet, Wormhole wormHole) {
        GameEngine.tab++;
        GameEngine.print("Gap.onShoot - defines what happens when bullet is shot on this Gap");
        GameEngine.tab--;
        // TODO implement here

    }
}