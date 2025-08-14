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
 * a BlockRemover is in charge of removing blocks from the game, as well as
 * keeping count of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    private static final int ONE = 1;
    //Fields
    // The current game.
    private GameLevel game;
    // The current number of balls.
    private Counter remainingBlocks;
    /**
     * A function that receives game and removedBlocks and builds a BlockRemover
     * with them.
     * @param game The current game.
     * @param removedBlocks
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }
    // Blocks that are hit should be removed
    // from the game. Remember to remove this listener from the block
    // that is being removed from the game.
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        //Deleting a block after hitting.
        beingHit.removeFromGame(this.game);
        //Decrease by one of the number of blocks.
        this.remainingBlocks.decrease(ONE);
    }
}
