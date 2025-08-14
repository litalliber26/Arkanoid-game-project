package levels;
// 208000414 Lital Liber
/**
 * @author Lital Liber <lital.liber@live.biu.ac.il>
 * @version 1.0
 * @since 2023-06-07
 */
import geometry.Velocity;
import java.util.List;
import sprites.Sprite;
import sprites.Block;
/**
 * The LevelInformation interface specifies the information required to fully
 * describe a level.
 */
public interface LevelInformation {
    /**
     * @return the number of the balls in the level.
     */
    int numberOfBalls();
    // The initial velocity of each ball
    // Note that initialBallVelocities().size() == numberOfBalls()
    /**
     * The function create a list of the initial velocity of each ball and
     * return it.
     * @return a list that contain the velocities of the balls.
     */
    List<Velocity> initialBallVelocities();
    /**
     * @return the speed of the paddle in the level.
     */
    int paddleSpeed();
    /**
     * @return the width of the paddle in the level.
     */
    int paddleWidth();
    // the level name will be displayed at the top of the screen.
    /**
     * @return the level name.
     */
    String levelName();
    // Returns a sprite with the background of the level.
    /**
     * The function create a special background to each level and return it.
     * @return a sprite with the background of the level.
     */
    Sprite getBackground();
    // The Blocks that make up this level, each block contains
    // its size, color and location.
    /**
     * The function create a list of the blocks in the level and return it.
     * @return a list that contain the blocks in the level.
     */
    List<Block> blocks();
    // Number of blocks that should be removed
    // before the level is considered to be "cleared".
    // This number should be <= blocks.size();
    /**
     * @return Number of blocks that should be removed before the level is
     * considered to be "cleared".
     */
    int numberOfBlocksToRemove();
}
