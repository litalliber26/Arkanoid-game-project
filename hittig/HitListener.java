package hittig;
// 208000414 Lital Liber
/**
 * @author Lital Liber <lital.liber@live.biu.ac.il>
 * @version 1.0
 * @since 2023-05-24
 */
import sprites.Ball;
import sprites.Block;
/**
 *
 */
public interface HitListener {
    /**
     * This function is called whenever the beingHit object is hit. The hitter
     * parameter is the Ball that's doing the hitting.
     * @param beingHit the object being collided with.
     * @param hitter The hitter parameter is the Ball that's doing the hitting.
     */
    void hitEvent(Block beingHit, Ball hitter);
}

