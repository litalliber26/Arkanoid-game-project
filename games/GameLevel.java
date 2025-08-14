package games;
// 208000414 Lital Liber
/**
 * @author Lital Liber <lital.liber@live.biu.ac.il>
 * @version 1.0
 * @since 2023-07-06
 */
import biuoop.DrawSurface;
import java.awt.Color;
import sprites.Sprite;
import sprites.SpriteCollection;
import sprites.Collidable;
import sprites.GameEnvironment;
import sprites.Block;
import sprites.Ball;
import sprites.Paddle;
import  geometry.Rectangle;
import geometry.Point;
import counters.Counter;
import hittig.BlockRemover;
import hittig.BallRemover;
import counters.ScoreIndicator;
import counters.ScoreTrackingListener;
import animations.Animation;
import animations.AnimationRunner;
import animations.PauseScreen;
import levels.LevelInformation;
import geometry.Velocity;
import java.util.List;
import levels.Green3;
import sprites.LevelName;
/**
 * The class creates the game and run its flow.
 */
public class GameLevel implements Animation {
    // Collection of all the sprites in the game.
    private SpriteCollection sprites;
    // The game environment.
    private GameEnvironment environment;
    // Counter of the remaining blocks.
    private Counter remainingBlocks;
    // The block remover.
    private BlockRemover blockRemover;
    // Counter of the remaining balls..
    private Counter remainingBalls;
    // The counter of the scores.
    private Counter score;
    private boolean gameOver;
    private AnimationRunner runner;
    private boolean running = false;
    private biuoop.KeyboardSensor keyboard;
    private  LevelInformation level = new Green3();
    private String status = null;
    //------------------------------------------------------------------------//
    private static final int WIDTH = 800;
    private static  final  int ZERO = 0;
    private static final int BACKGROUND_GREEN = 102;
    private static final int TEN = 10;
    private static final int DEATH_REGION_X = 31;
    private static final int DEATH_REGION_Y = 590;
    private static final int DEATH_REGION_WIDTH = 738;
    private static final int DEATH_REGION_HEIGHT = 29;
    private static final int BLOCK_HEIGHT = 20;
    private static final int BORDER_WIDTH = 30;
    private static final int BORDER_HEIGHT = 570;
    private static final int BORDER_X = 770;
    private static final int BORDER_Y = 30;
    private static final int FIFTY_FIVE = 45;
    private static final int SIXTEEN = 16;
    private static final int BALL_RADIUS = 5;
    private static final int ONE = 1;
    private static final int TWO_HUNDRED = 200;
    private static final int PADDLE_X = 350;
    private static final int PADDLE_Y = 570;
    private static final int PADDLE_HEIGHT = 19;
    private static final int HUNDRED = 100;
    private static final int BACKGROUND_R = 51;
    private static final int BACKGROUND_G = 153;
    private static final int BACKGROUND_B = 255;
    private static final int TWO = 2;
    //------------------------------------------------------------------------//
    /**
     * The function builds a game from the collection of sprites,game
     * environment,the counters of balls, blocks and points, BlockRemover,
     * status, gameOver, level, keyboard, runner and score.
     * @param level the current level.
     * @param keyboard the KeyboardSensor that yhe user choose.
     * @param runner the current AnimationRunner.
     * @param score The score the user earned.
     */
    public GameLevel(LevelInformation level, biuoop.KeyboardSensor keyboard,
                     AnimationRunner runner, Counter score) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.remainingBlocks = new Counter();
        this.remainingBalls = new Counter();
        this.blockRemover = new BlockRemover(this, remainingBlocks);
        this.status = new String();
        this.gameOver = false;
        this.level = level;
        this.keyboard = keyboard;
        this.runner = runner;
        this.score = score;
    }
    /**
     * The function initialize and run the game with the AnimationRunner.
     */
    public void run() {
        this.initialize();
        this.running = true;
        this.runner.run(this);
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        // draw all the sprites.
        this.sprites.drawAllOn(d);
        // notify all the sprites that time passed.
        this.sprites.notifyAllTimePassed();
        //Checking if the player win or lost.
        if (level.numberOfBlocksToRemove() <= level.blocks().size()
                - remainingBlocks.getValue()) {
            this.running = false;
            this.status = "win";
            this.score.increase(HUNDRED);
        } else if (remainingBalls.getValue() == ZERO) {
            this.running = false;
            this.status = "lost";
        }
        //Creating the pause screen.
        PauseScreen pauseScreen =
                new PauseScreen(this.keyboard);
        if (keyboard.isPressed("p")) {
            runner.run(
                    new KeyPressStoppableAnimation(keyboard,
                            biuoop.KeyboardSensor.SPACE_KEY,
                            pauseScreen));
    }
    }
    @Override
    public boolean shouldStop() {
        return !this.running; }
    /**
     * The function initializes the game. Create the blocks and ball and
     * Paddle and add them to the game. According to the current stage.
     */
    public void initialize() {
        //Creating the level background.
        addSprite(level.getBackground());
        // creating the block remover.
        BlockRemover blockRemover =
                new BlockRemover(this, remainingBlocks);
        // creating the ball remover.
        BallRemover ballRemover = new BallRemover(this, remainingBalls);
        // creating the deathRegion.
        Color color = Color.green;
        if (level.levelName().equals("Direct Hit")) {
            color = Color.black;
        } else if (level.levelName().equals("Wide Easy")) {
            int r = BACKGROUND_R; int g = BACKGROUND_G; int b = BACKGROUND_B;
            color = new Color(r, g, b);
        } else if (level.levelName().equals("Green 3"))  {
            int r = ZERO; int g = BACKGROUND_GREEN; int b = ZERO;
            color = new Color(r, g, b);
        }
        Block deathRegion = new Block(DEATH_REGION_X, DEATH_REGION_Y,
                DEATH_REGION_WIDTH, DEATH_REGION_HEIGHT, color);
        deathRegion.addToGame(this);
        deathRegion.addHitListener(ballRemover);
        // creating of scoreIndicator and scoreTracker.
        ScoreIndicator scoreIndicator = new ScoreIndicator(new Rectangle(ZERO,
                ZERO, WIDTH, BLOCK_HEIGHT), score);
        //Creating the LevelName.
        LevelName levelName = new LevelName(level.levelName());
        ////Creating the ScoreTrackingListener.
        ScoreTrackingListener scoreTracker = new ScoreTrackingListener(score);
        //Creating the blocks and add them to the game.
        for (Block block : level.blocks()) {
            block.addHitListener(blockRemover);
            block.addHitListener(scoreTracker);
            remainingBlocks.increase((double) ONE);
            block.addToGame(this);
        }
        //Creates the borders of the frame, and add them to the game.
        //Creates the right border of the frame, and add it to the game.
        int blockWidth = BORDER_WIDTH; int blockHeight = BORDER_HEIGHT;
        int blockX = BORDER_X; int blockY = BORDER_Y;
        Block block = new Block(blockX, blockY, blockWidth,
                blockHeight, Color.gray);
        block.addToGame(this);
        //Creates the left border of the frame, and add it to the game.
        blockX = ZERO;
        Block block2 = new Block(blockX, blockY, blockWidth,
                blockHeight, Color.gray);
        block2.addToGame(this);
        //Creates the upper border of the frame, and add it to the game.
        blockWidth = WIDTH; blockHeight = FIFTY_FIVE; blockY = ZERO;
        Block block3 = new Block(blockX, blockY, blockWidth,
                blockHeight, Color.gray);
        block3.addToGame(this);
        //Creation of the white rectangle that contains the score.
        blockWidth = WIDTH; blockHeight = SIXTEEN; blockY = ZERO;
        Block block5 = new Block(ZERO, blockY, blockWidth,
                blockHeight, Color.white);
        block5.addToGame(this);
        scoreIndicator.addToGame(this);
        levelName.addToGame(this);
        //Creating the paddle and add it to the game.
        int paddleX;
        if (level.levelName().equals("Wide Easy")) {
            paddleX = TWO_HUNDRED;
        } else {
            paddleX = PADDLE_X;
        }
        int paddleY = PADDLE_Y; int paddleHeight = PADDLE_HEIGHT;
           Rectangle rectangle = new Rectangle(new Point(paddleX, paddleY),
                   level.paddleWidth(), paddleHeight);
        Paddle paddle = new Paddle(keyboard, rectangle, Color.orange,
                level.paddleSpeed());
        paddle.addToGame(this);
        //Creating the balls and add them to the game.
        List<Velocity> velocities = level.initialBallVelocities();
        int x = level.numberOfBalls();
        for (int i = ZERO; i < x; i++) {
            Ball ball = new Ball((int) (paddle.getCollisionRectangle()
                    .getUpperLeft().getX() + paddle.getCollisionRectangle()
                    .getWidth() / TWO), (int) paddle.getCollisionRectangle()
                    .getUpperLeft().getY() - TEN, BALL_RADIUS, Color.white);
            ball.setGameEnvironment(environment);
            ball.setVelocity(velocities.get(i));
            ball.addToGame(this);
            remainingBalls.increase((double) ONE);
        }
    }
    /**
     * The function adds a Collidable to the game.
     * @param c The Collidable object that the function adds to the game.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }
    /**
     * The function adds a Sprite to the collection of all the sprites in the
     * game.
     * @param s The Sprite object that the function adds to the collection.
     */
    public void addSprite(Sprite s) {

        this.sprites.addSprite(s);
    }
    /**
     *  The function removes a Collidable from the game.
     * @param c The Collidable object that the function removes from the game.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }
    /**
     * The function removes a Sprite from the game.
     * @param s The Sprite object that the function removes from the game.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }
    /**
     * @return the remover of the blocks.
     */
    public BlockRemover getBlockRemover() {
        return this.blockRemover;
    }
    /**
     * @return the player status - if he won or lost
     */
    public String status() {
        return status;
    }
    @Override
    public String getPrint() {
        return "a";
    }
}
