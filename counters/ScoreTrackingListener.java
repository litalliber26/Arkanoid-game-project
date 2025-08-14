package counters;
// 208000414 Lital Liber
/**
 * @author Lital Liber <lital.liber@live.biu.ac.il>
 * @version 1.0
 * @since 2023-05-24
 */
import hittig.HitListener;
import sprites.Block;
import sprites.Ball;
/**
 * The ScoreTrackingListener update the score counter when blocks are being hit
 * and removed.
 */
public class ScoreTrackingListener implements HitListener {
    private static final double TWO_AND_HALF = 2.5;
    //Fields.
    // The current score.
    private Counter currentScore;
    /**
     * A function that receives scoreCounter builds a ScoreTrackingListener
     * with it.
     * @param scoreCounter The current score.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(TWO_AND_HALF);
    }
}
