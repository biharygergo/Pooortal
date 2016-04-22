package src;

/**
 * Represents the wall field, which is not steppable
 */
public class Wall extends Field {

    /**
     * Default constructor
     */
    public Wall() {
        description = "Wall";
    }

    /**
     * What happens when the player steps on it
     * @param player the player who wants to step on the wall
     */
    public void onStep(Player player) {
       //Ez nem hivodik meg sosem
    }

    /**
     * Returns that the wall is steppable or not
     * @return The boolean whether the wall is steppable or not
     */
    public boolean steppable() {

        return false;
    }

    /**
     * What happens when the player shoots on the wall
     * @param bullet The bullet which the player shoots on the wall
     * @param colonelHole The wormhole on the wall
     */
    public void onShoot(Bullet bullet, Wormhole colonelHole, Wormhole jaffaHole) {
       bullet.setActive(false);
    }

    /**
     *
     * @param replicator this is the replicator
     */
    public void onReplicatorStep(Replicator replicator){
        //Ez sem hivodik meg sosem!
    }
}
