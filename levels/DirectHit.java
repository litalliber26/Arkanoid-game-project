package levels;
// 208000414 Lital Liber
/**
 * @author Lital Liber <lital.liber@live.biu.ac.il>
 * @version 1.0
 * @since 2023-06-07
 */
import geometry.Velocity;
import java.awt.Color;
import java.util.List;
import sprites.Sprite;
import sprites.Block;
import biuoop.DrawSurface;
/**
 * The class present the first level amd all of his properties.
 */
public class DirectHit implements LevelInformation {
    private static final int NUM_OF_BALLS = 1;
    private static final int DX = 0;
    private static final int DY = 2;
    private static final int PADDLE_SPEED = 3;
    private static final int PADDLE_WIDTH = 120;
    private static final int BLOCK_HEIGHT = 40;
    private static final int BLOCK_WIDTH = 40;
    private static final int BLOCK_X = 385;
    private static final int BLOCK_Y = 200;
    private static final int FOUR_HUNDRED = 400;
    private static final int ZERO = 0;
    private static final int TWO_HUNDRED_FIFTEEN = 215;
    private static final int FIFTY = 50;
    private static final int HUNDRED = 100;
    private static final int HUNDRED_AND_FIFTH = 150;
    private static final int TWO_HUNDRED_TWENTY = 200;
    private static final int THREE_HUNDRED_SEVENTY = 370;
    private static final int FIVE_HUNDRED_EIGHTY = 580;
    private static final int FOUR_HUNDRED_THIRTY = 430;
    private static final int THIRTY_FIVE = 35;
    private static final int ONE_HUNDRED_EIGHTH_FIVE = 185;
    private static final int TWO_HUNDRED_FORTY_FIVE = 245;
    private static final int TREE_HUNDRED_NINETY_FIVE = 395;
    @Override
    public int numberOfBalls() {
        return NUM_OF_BALLS;
    }
    // The initial velocity of each ball
    // Note that initialBallVelocities().size() == numberOfBalls()
    @Override
    public List<Velocity> initialBallVelocities() {
        return List.of(new Velocity(DX, DY));
    }
    @Override
    public int paddleSpeed() {
        return PADDLE_SPEED;
    }
    @Override
    public int paddleWidth() {
        return PADDLE_WIDTH;
    }
    // the level name will be displayed at the top of the screen.
    @Override
    public String levelName() {
        return "Direct Hit";
    }
    // Returns a sprite with the background of the level
    @Override
    public Sprite getBackground() {
        return new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                //The background.
                d.setColor(Color.black);
                d.fillRectangle(ZERO, ZERO, d.getWidth(), d.getHeight());
                // The green circle.
                d.setColor(Color.green);
                d.drawCircle(FOUR_HUNDRED, TWO_HUNDRED_FIFTEEN, FIFTY);
                // The yellow circle.
                d.setColor(Color.yellow);
                d.drawCircle(FOUR_HUNDRED, TWO_HUNDRED_FIFTEEN, HUNDRED);
                // The red circle.
                d.setColor(Color.red);
                d.drawCircle(FOUR_HUNDRED, TWO_HUNDRED_FIFTEEN,
                        HUNDRED_AND_FIFTH);
                // The lines around the target.
                d.setColor(Color.blue);
                d.drawLine(TWO_HUNDRED_TWENTY, TWO_HUNDRED_FIFTEEN,
                        THREE_HUNDRED_SEVENTY, TWO_HUNDRED_FIFTEEN);
                d.drawLine(FOUR_HUNDRED_THIRTY, TWO_HUNDRED_FIFTEEN,
                        FIVE_HUNDRED_EIGHTY, TWO_HUNDRED_FIFTEEN);
                d.drawLine(FOUR_HUNDRED, THIRTY_FIVE, FOUR_HUNDRED,
                        ONE_HUNDRED_EIGHTH_FIVE);
                d.drawLine(FOUR_HUNDRED, TWO_HUNDRED_FORTY_FIVE,
                        FOUR_HUNDRED, TREE_HUNDRED_NINETY_FIVE);
            }
            @Override
            public void timePassed() {

            }
        };
    }
    // The Blocks that make up this level, each block contains
    // its size, color and location.
    @Override
    public List<Block> blocks() {
        return List.of(new Block(BLOCK_X, BLOCK_Y, BLOCK_WIDTH, BLOCK_HEIGHT,
                Color.RED));
    }
    // Number of blocks that should be removed
    // before the level is considered to be "cleared".
    // This number should be <= blocks.size();
    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
