package src;

/**
 * Represents the road field, which is always steppable if nothing stands on it
 */
public class Road extends Field {

    /**
     * Default constructor
     */
    public Road() {
        description = "Road";
    }

    /**
     * @param player the player who wants to step on it
     */
    public void onStep(Player player) {
       player.setField(this);
    }

    /**
     * @return The boolean whether the road is steppable or not
     */
    public boolean steppable() {

        return true;
    }

    /**
     * What happens when the player shoots on the road
     * @param bullet The bullet which the player shoots on the road
     * @param colonelHole The wormhole
     * @param jaffaHole jaffahole
     */
    public void onShoot(Bullet bullet, Wormhole colonelHole, Wormhole jaffaHole) {

        bullet.setField(this);
    }

    /**
     * What happens when replicator steps on Road
     * @param replicator this is the replicator
     */
    public void onReplicatorStep(Replicator replicator){

        replicator.setField(this);
    }

}