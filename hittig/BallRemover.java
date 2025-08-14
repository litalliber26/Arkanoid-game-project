package hittig;
// 208000414 Lital Liber
/**
 * @author Lital Liber <lital.liber@live.biu.ac.il>
 * @version 1.0
 * @since 2023-05-24
 */
import counters.Counter;
import games.GameLevel;
import sprites.Block;
import sprites.Ball;
/**
 * The BallRemover will be in charge of removing balls, and updating an
 * availabe-balls counter.
 */
public class BallRemover implements HitListener {
    private static final int ONE = 1;
    //Fields
    // The current game.
    private GameLevel game;
    // The current number of balls.
    private Counter remainingBalls;
    /**
     * A function that receives game and ballCounter and builds a BallRemover
     * with them.
     * @param game The current game.
     * @param removedBalls The current number of balls.
     */
    public BallRemover(GameLevel game, Counter removedBalls) {
        this.game = game;
        this.remainingBalls = removedBalls;
    }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        this.remainingBalls.decrease(ONE);
    }
}
