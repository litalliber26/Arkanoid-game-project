package sprites;
// 208000414 Lital Liber
/**
 * @author Lital Liber <lital.liber@live.biu.ac.il>
 * @version 1.0
 * @since 2023-04-28
 */
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import games.GameLevel;

/**
 * The class represents the paddle, the player of the game is represented in
 * the shape of a rectangle.
 */
public class Paddle implements Sprite, Collidable {
    //Fields
    // The color of the paddle.
    private static final Color PADDLE_COLOR = Color.ORANGE;
    // The current KeyboardSensor.
    private biuoop.KeyboardSensor keyboard;
    // The rectangle that represents the paddle.
    private Rectangle paddle;
    //Counters
    //The count of the first region.
    private int count1 = ZERO;
    //The count of the second region.
    private int count2 = ZERO;
    //The count of the third region.
    private int count3 = ZERO;
    //The count of the four region.
    private int count4 = ZERO;
    // The count of the five region.
    private int count5 = ZERO;
    //Velocities.
    // The velocity of the first region.
    private Velocity v1 = new Velocity(ZERO, ZERO);
    //The velocity of the second region.
    private Velocity v2 = new Velocity(ZERO, ZERO);
    //The velocity of the four region.
    private Velocity v4 = new Velocity(ZERO, ZERO);
    //The velocity of the five region.
    private Velocity v5 = new Velocity(ZERO, ZERO);
    private  int speed;
    // paddle velocity.
    private static final int PADDLE_VELOCITY = 10;
    //paddle's regions.
    private static final int PADDLE_REGIONS = 5;
    // the screen's wight.
    private static final int WIGHT = 800;
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int MINUS_ONE = -1;
    private static final int TWO = 2;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int THREE_HUNDRED = 300;
    private static final int THREE_HUNDRED_AND_THIRTY = 330;
    private static final int THIRTY = 30;
    private static final int SIXTY = 60;
    private static final int EIGHTY = 80;
    private static final int SEVEN_HUNDRED_AND_SEVENTY = 770;
    /**
     * Create a new paddle with rectangle and keyboard sensor.
     * @param rectangle The rectangle that represents the paddle.
     * @param keyboard The keyboard sensor the user selected.
     */
    public Paddle(Rectangle rectangle, KeyboardSensor keyboard) {
        this.paddle = rectangle;
        this.keyboard = keyboard;
    }
    /**
     * Create a new paddle with rectangle and keyboard sensor.
     * @param keyboard The keyboard sensor the user selected.
     * @param rectangle The rectangle that represents the paddle.
     * @param color The color of the paddle.
     * @param speed The speed of the paddle.
     */
    public Paddle(KeyboardSensor keyboard, Rectangle rectangle,
                  Color color, int speed) {
       this.paddle = new Rectangle(rectangle, color);
        this.keyboard = keyboard;
        this.speed = speed;
    }
    /**
     * If the user pressed on thr right arrow the function move the paddle to
     * the left.
     */
    public void moveLeft() {
        double x =
                this.paddle.getUpperLeft().getX()
                        + (this.paddle.getWidth() / TWO);
        // Check if the collision was with a horizontal edge.
        if (x <= (THIRTY + (paddle.getWidth() / 2))) {
            moveRight();
            return;
        }
        int dx = -PADDLE_VELOCITY;
        if (this.paddle.getUpperLeft().getX() + dx < ZERO) {
            dx = (int) -this.paddle.getUpperLeft().getX();
        }
        this.paddle.applyTO(dx, ZERO);
    }
    /**
     * If the user pressed on thr right arrow the function move the paddle to
     * the right.
     */
    public void moveRight() {
        double x =
                this.paddle.getUpperLeft().getX()
                        + (this.paddle.getWidth() / TWO);
        // Check if the collision was with a horizontal edge.
        if (x >= (SEVEN_HUNDRED_AND_SEVENTY - (paddle.getWidth() / TWO))) {
            moveLeft();
            return;
        }
        int dx = PADDLE_VELOCITY;
        if (this.paddle.getUpperLeft().getX()
                + this.paddle.getWidth() + dx > WIGHT) {
            dx = (int) (WIGHT - this.paddle.getUpperLeft().getX()
                            - this.paddle.getWidth());
        }
        this.paddle.applyTO(dx, ZERO);
    }
    /**
     * The function notify the paddle that time has passed and activates the
     * moveLeft or moveRight function accordingly.
     */
    @Override
    public void timePassed() {
        // move to the left.
        if (this.keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }
        // move to the right.
        if (this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
    }
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(PADDLE_COLOR);
        d.fillRectangle((int) this.paddle.getUpperLeft().getX(),
                (int) this.paddle.getUpperLeft().getY(),
                (int) this.paddle.getWidth(), (int) this.paddle.getHeight());
        d.setColor(Color.BLACK);
        d.drawRectangle((int) this.paddle.getUpperLeft().getX(),
                (int) this.paddle.getUpperLeft().getY(),
                (int) this.paddle.getWidth(), (int) this.paddle.getHeight());
    }
    /**
     * The function return the "collision shape" of the paddle.
     * @return The "collision shape" of the paddle.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return new Rectangle((int) this.paddle.getUpperLeft().getX(),
                (int) this.paddle.getUpperLeft().getY(),
                (int) this.paddle.getWidth(), (int) this.paddle.getHeight());
    }
    /**
     * The function calculates the velocity of the other object after the
     * collision with the block.
     * @param hitter the object that hit the Collidable object.
     * @param collisionPoint The collision point of the block with
     * the other object.
     * @param currentVelocity The Velocity of the other object before the
     * collision with the block.
     * @return
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint,
                        Velocity currentVelocity) {
        //The width of each region.
        double regionWidth = this.paddle.getWidth() / PADDLE_REGIONS;
        //The collision point.
        double collisionPointX = collisionPoint.getX()
                - this.paddle.getUpperLeft().getX();
        //The region where the collision happened.
        int region = (int) (collisionPointX / regionWidth) + ONE;
        //The X value of the Velocity.
        double dx = currentVelocity.getDx();
        //The Y value of the Velocity.
        double dy = currentVelocity.getDy();
        //if we hit region 1, the ball should bounce back with an angle of 300
        // degrees.
        if (region == ONE) {
            count1++;
            if (count1 > ONE) {
                return v1;
            }
            v1 = Velocity.fromAngleAndSpeed(THREE_HUNDRED,
                    currentVelocity.getVelocitySize());
            return v1;
        //for region 2 is should bounce back 330 degrees.
        } else if (region == TWO) {
                count2++;
                 if (count2 > ONE) {
                     return v2;
                 }
                 v2 = Velocity.fromAngleAndSpeed(THREE_HUNDRED_AND_THIRTY,
                         currentVelocity.getVelocitySize());
                return v2;
        //for region 5 in 60 degrees.
        } else if (region == FIVE) {
            count5++;
            if (count5 > ONE) {
                return v5;
            }
            v5 = Velocity.fromAngleAndSpeed(SIXTY,
                    currentVelocity.getVelocitySize());
            return v5;
        //for region 4 it should bounce in 30 degrees.
        } else if (region == FOUR) {
            count4++;
            if (count4 > ONE) {
                return v4;
            }
            v4 = Velocity.fromAngleAndSpeed(THIRTY,
                    currentVelocity.getVelocitySize());
            return v4;
        // If the ball hits the middle region (region 3), it should keep its
        // horizontal direction and only change its vertical one.
        } else {
            count3++;
            if (count3 > ONE) {
                return new Velocity(dx, -dy);
            }
                dy = MINUS_ONE * dy;
                return new Velocity(dx, dy);
        }
    }
    /**
     * The function adds the paddle to the game.
     * @param game The game of the assignment .
     */
    public void addToGame(GameLevel game) {
        game.addCollidable(this);
        game.addSprite(this);
    }
}
