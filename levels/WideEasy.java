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
import java.util.Random;
/**
 * The class present the second level amd all of his properties.
 */
public class WideEasy implements LevelInformation {
    private static final int NUM_OF_BALLS = 10;
    private static final int BALL_SPEED = 8;
    private static final int ANGLE_ONE = 45;
    private static final int ANGLE_TWO = 90;
    private static final int PADDLE_SPEED = 4;
    private static final int PADDLE_WIDTH = 450;
    private static final int ZERO = 0;
    private static final int BACKGROUND_R = 51;
    private static final int BACKGROUND_G = 153;
    private static final int BACKGROUND_B = 255;
    private static final int RAYS_R = 230;
    private static final int RAYS_B = 220;
    private static final int RAYS_G = 170;
    private static final int TWENTY = 20;
    private static final int SEVEN_HUNDRED_EIGHTY = 780;
    private static final int TEN = 10;
    private static final int ONE_HUNDRED_FIFTY = 150;
    private static final int TWO_HUNDRED_FIFTY = 250;
    private static final int SUN_R = 255;
    private static final int SUN_G = 140;
    private static final int THIRTY = 30;
    private static final int FIFTY_ONE = 51;
    private static final int SECOND_BLOCK_X = 62;
    private static final int THIRD_BLOCK_X = 114;
    private static final int FOUR_BLOCK_X = 166;
    private static final int FIVE_BLOCK_X = 218;
    private static final int SIX_BLOCK_X = 270;
    private static final int SEVEN_BLOCK_X = 322;
    private static final int EIGHT_BLOCK_X = 374;
    private static final int NINE_BLOCK_X = 426;
    private static final int TEN_BLOCK_X = 478;
    private static final int ELEVEN_BLOCK_X = 530;
    private static final int TWELVE_BLOCK_X = 582;
    private static final int THIRTEEN_BLOCK_X = 634;
    private static final int FOURTEEN_BLOCK_X = 686;
    private static final int FIFTEEN_BLOCK_X = 738;
    @Override
    public int numberOfBalls() {
        return NUM_OF_BALLS;
    }
    // The initial velocity of each ball
    // Note that initialBallVelocities().size() == numberOfBalls()
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        for (int i = ZERO; i <= numberOfBalls(); i++) {
            velocities.add(Velocity.fromAngleAndSpeed(new Random().
                    nextInt(ANGLE_TWO) - ANGLE_ONE, BALL_SPEED));
        }
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
        return "Wide Easy";
    }
    // Returns a sprite with the background of the level
    @Override
    public Sprite getBackground() {
        return new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                //Creating the background.
                int r = BACKGROUND_R; int g = BACKGROUND_G;
                int b = BACKGROUND_B;
                Color color = new Color(r, g, b);
                d.setColor(color);
                d.fillRectangle(ZERO, ZERO, d.getWidth(), d.getHeight());
                //Creating the sun rays.
                d.setColor(new Color(RAYS_R, RAYS_B, RAYS_G));
                for (int x = TWENTY; x <= SEVEN_HUNDRED_EIGHTY; x += TEN) {
                    d.drawLine(ONE_HUNDRED_FIFTY, ONE_HUNDRED_FIFTY, x,
                            TWO_HUNDRED_FIFTY);
                }
                //Creating the sun.
                d.setColor(new Color(SUN_R, SUN_G, ZERO));
                d.fillCircle(ONE_HUNDRED_FIFTY, ONE_HUNDRED_FIFTY, THIRTY);
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
        Block block1 = new Block(TEN, TWO_HUNDRED_FIFTY,
                FIFTY_ONE, THIRTY, Color.red);
        blocks.add(block1);
        Block block2 = new Block(SECOND_BLOCK_X, TWO_HUNDRED_FIFTY,
                FIFTY_ONE, THIRTY, Color.red);
        blocks.add(block2);
        Block block3 = new Block(THIRD_BLOCK_X, TWO_HUNDRED_FIFTY,
                FIFTY_ONE, THIRTY, Color.orange);
        blocks.add(block3);
        Block block4 = new Block(FOUR_BLOCK_X, TWO_HUNDRED_FIFTY,
                FIFTY_ONE, THIRTY, Color.orange);
        blocks.add(block4);
        Block block5 = new Block(FIVE_BLOCK_X, TWO_HUNDRED_FIFTY,
                FIFTY_ONE, THIRTY, Color.yellow);
        blocks.add(block5);
        Block block6 = new Block(SIX_BLOCK_X, TWO_HUNDRED_FIFTY,
                FIFTY_ONE, THIRTY, Color.yellow);
        blocks.add(block6);
        Block block7 = new Block(SEVEN_BLOCK_X, TWO_HUNDRED_FIFTY,
                FIFTY_ONE, THIRTY, Color.green);
        blocks.add(block7);
        Block block8 = new Block(EIGHT_BLOCK_X, TWO_HUNDRED_FIFTY,
                FIFTY_ONE, THIRTY, Color.green);
        blocks.add(block8);
        Block block9 = new Block(NINE_BLOCK_X, TWO_HUNDRED_FIFTY,
                FIFTY_ONE, THIRTY, Color.green);
        blocks.add(block9);
        Block block10 = new Block(TEN_BLOCK_X, TWO_HUNDRED_FIFTY,
                FIFTY_ONE, THIRTY, Color.blue);
        blocks.add(block10);
        Block block11 = new Block(ELEVEN_BLOCK_X, TWO_HUNDRED_FIFTY,
                FIFTY_ONE, THIRTY, Color.blue);
        blocks.add(block11);
        Block block12 = new Block(TWELVE_BLOCK_X, TWO_HUNDRED_FIFTY,
                FIFTY_ONE, THIRTY, Color.pink);
        blocks.add(block12);
        Block block13 = new Block(THIRTEEN_BLOCK_X, TWO_HUNDRED_FIFTY,
                FIFTY_ONE, THIRTY, Color.pink);
        blocks.add(block13);
        Block block14 = new Block(FOURTEEN_BLOCK_X, TWO_HUNDRED_FIFTY,
                FIFTY_ONE, THIRTY, Color.cyan);
        blocks.add(block14);
        Block block15 = new Block(FIFTEEN_BLOCK_X, TWO_HUNDRED_FIFTY,
                FIFTY_ONE, THIRTY, Color.cyan);
        blocks.add(block15);
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
