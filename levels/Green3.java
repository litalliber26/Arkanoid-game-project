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
import java.util.ArrayList;
/**
 * The class present the third level amd all of his properties.
 */
public class Green3 implements LevelInformation {
    private static final int NUM_OF_BALLS = 2;
    private static final int SPEED_ONE = 2;
    private static final int ANGLE_ONE = 45;
    private static final int SPEED_TWO = 3;
    private static final int ANGLE_TWO = 60;
    private static final int PADDLE_SPEED = 8;
    private static final int PADDLE_WIDTH = 80;
    private static final int BLOCK_HEIGHT = 20;
    private static final int BLOCK_WIDTH = 50;
    private static final int FIRST_ROW_X = 260;
    private static final int FIRST_ROW_Y = 150;
    private static final int SPACE_BETWEEN_BLOCKS = 51;
    private static final int SECOND_ROW_X = 311;
    private static final int SECOND_ROW_Y = 171;
    private static final int THIRD_ROW_X = 362;
    private static final int THIRD_ROW_Y = 192;
    private static final int FOUR_ROW_X = 413;
    private static final int FOUR_ROW_Y = 213;
    private static final int FIVE_ROW_X = 464;
    private static final int FIVE_ROW_Y = 234;
    private static final int ZERO = 0;
    private static final int GREEN_BACKGROUND = 102;
    private static final int TWO_HUNDRED = 200;
    private static final int ONE_HUNDRED_FIFTEEN = 115;
    private static final int ONE_HUNDRED_TEN = 110;
    private static final int TEN = 10;
    private static final int TWELVE = 12;
    private static final int EIGHT = 8;
    private static final int THREE = 3;
    private static final int ONE_HUNDRED = 100;
    private static final int FOUR_HUNDRED = 400;
    private static final int THIRTY = 30;
    private static final int SIXTY_FIVE = 65;
    private static final int FOUR_HUNDRED_FIFTY = 450;
    private static final int FIVE = 5;
    private static final int SEVENTY_FIVE = 75;
    private static final int EIGHTY = 18;
    private static final int FOUR_HUNDRED_SIXTY = 460;
    private static final int THIRTY_TWO = 32;
    private static final int TWENTY_FIVE = 25;
    private static final int NINE = 9;
    private static final int SEVEN = 7;
    private static final int SIX = 6;
    @Override
    public int numberOfBalls() {
        return NUM_OF_BALLS;
    }
    // The initial velocity of each ball
    // Note that initialBallVelocities().size() == numberOfBalls()
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        velocities.add(Velocity.fromAngleAndSpeed(ANGLE_ONE, SPEED_ONE));
        velocities.add(Velocity.fromAngleAndSpeed(ANGLE_TWO, SPEED_TWO));
        return velocities;
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
        return "Green 3";
    }
    // Returns a sprite with the background of the level
    @Override
    public Sprite getBackground() {
        return new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                int r = ZERO;
                int g = GREEN_BACKGROUND;
                int b = ZERO;
                Color color = new Color(r, g, b);
                d.setColor(color);
                d.fillRectangle(ZERO, ZERO, d.getWidth(), d.getHeight());
                d.setColor(Color.pink);
                d.fillRectangle(ONE_HUNDRED_TEN, TWO_HUNDRED, TEN, TWO_HUNDRED);

                d.setColor(Color.red);
                d.fillCircle(ONE_HUNDRED_FIFTEEN, TWO_HUNDRED, TWELVE);

                d.setColor(Color.orange);
                d.fillCircle(ONE_HUNDRED_FIFTEEN, TWO_HUNDRED, EIGHT);

                d.setColor(Color.white);
                d.fillCircle(ONE_HUNDRED_FIFTEEN, TWO_HUNDRED, THREE);

                d.setColor(Color.cyan);
                d.fillRectangle(ONE_HUNDRED, FOUR_HUNDRED, THIRTY, TWO_HUNDRED);

                d.setColor(Color.orange);
                d.fillRectangle(SIXTY_FIVE, FOUR_HUNDRED_FIFTY, ONE_HUNDRED,
                        TWO_HUNDRED);

                d.setColor(Color.white);

                for (int x = ZERO; x < FIVE; ++x) {
                    for (int y = ZERO; y < FIVE; ++y) {
                        d.fillRectangle(SEVENTY_FIVE + x * EIGHTY,
                                FOUR_HUNDRED_SIXTY + y * THIRTY_TWO,
                                TEN, TWENTY_FIVE);
                    }
                }
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
        List<Block> blocks = new ArrayList<>();
        // Creating the blocks, and add them to the game.
        // Create the gray blocks, and add it to the game.
        int blocksAmount = TEN; int blockWidth = BLOCK_WIDTH;
        int blockHeight = BLOCK_HEIGHT;
        // The X,Y values of the start Point of the block.
        int blockX = FIRST_ROW_X; int blockY = FIRST_ROW_Y;
        for (int i = ZERO; i < blocksAmount; i++) {
            Block block = new Block(blockX, blockY,
                    blockWidth, blockHeight, Color.gray);
            blocks.add(block);
            blockX += SPACE_BETWEEN_BLOCKS; blockY += ZERO;
        }

        // Create the red blocks, and add it to the game.
        blocksAmount = NINE; blockX = SECOND_ROW_X; blockY = SECOND_ROW_Y;
        for (int i = ZERO; i < blocksAmount; i++) {
            Block block = new Block(blockX, blockY,
                    blockWidth, blockHeight, Color.red);
            blocks.add(block);
            blockX += SPACE_BETWEEN_BLOCKS; blockY += ZERO;
        }

        // Create the yellow blocks, and add it to the game.
        blocksAmount = EIGHT; blockX = THIRD_ROW_X; blockY = THIRD_ROW_Y;
        for (int i = ZERO; i < blocksAmount; i++) {
            Block block = new Block(blockX, blockY,
                    blockWidth, blockHeight, Color.yellow);
            blocks.add(block);
            blockX += SPACE_BETWEEN_BLOCKS; blockY += ZERO;
        }

        // Create the blue blocks, and add it to the game.
        blocksAmount = SEVEN; blockX = FOUR_ROW_X; blockY = FOUR_ROW_Y;
        for (int i = ZERO; i < blocksAmount; i++) {
            Block block = new Block(blockX, blockY,
                    blockWidth, blockHeight, Color.blue);
            blocks.add(block);
            blockX += SPACE_BETWEEN_BLOCKS;
            blockY += ZERO;
        }

        // Create the Pink blocks, and add it to the game.
        blocksAmount = SIX; blockX = FIVE_ROW_X; blockY = FIVE_ROW_Y;
        for (int i = ZERO; i < blocksAmount; i++) {
            Block block = new Block(blockX, blockY, blockWidth,
                    blockHeight, Color.white);
            blocks.add(block);
            blockX += SPACE_BETWEEN_BLOCKS;
            blockY += ZERO;
        }
        return blocks;
        }

    // Number of blocks that should be removed
    // before the level is considered to be "cleared".
    // This number should be <= blocks.size();
    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
