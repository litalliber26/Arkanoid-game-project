package sprites;
// 208000414 Lital Liber
/**
 * @author Lital Liber <lital.liber@live.biu.ac.il>
 * @version 1.0
 * @since 2023-04-10
 */
import biuoop.DrawSurface;
import geometry.Point;
import geometry.Velocity;
import geometry.Line;
import games.GameLevel;

/**
 *Class Name: Ball
 * A class that represents a ball characterized by radius, color and midpoint.
 */
public class Ball implements Sprite {
    // Fields
    //The initial center point of the ball
    private Point center;
    //the radius of a ball.
    private int r;
    //the color of the ball.
    private java.awt.Color color;
    //the speed of the ball.
    private Velocity velocity;
    // the game environment.
    private GameEnvironment environment;
    // constructor
    private static final int SMALL_INTERFACE_WIDTH = 200;
    private static final int SMALL_INTERFACE_HEIGHT = 200;
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int FIVE = 5;
    private static final int GREY_REC_START = 50;
    private static final int GREY_REC_END = 500;
    private static final int YELLOW_REC_START = 450;
    private static final int YELLOW_REC_END = 600;
    private static final int TEN = 10;
    private static final int MINUS_ONE = -1;
    private static final int INTERFACE_WIDTH = 800;
    private static final int INTERFACE_HEIGHT = 600;
    private static final double BETWEEN = 0.9;
    /**
     * A function that receives the midpoint of a ball, radius and color and
     * builds a ball with them.
     * @param center the midpoint of a ball.
     * @param r the radius of the ball.
     * @param color the color of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = Math.abs(r);
        this.color = color;

    }
    /**
     * A function that receives the coordinates of the midpoint of a ball,
     * radius and color and builds a ball with them.
     * @param x the X value of the center point of the ball.
     * @param y the Y value of the center point of the ball.
     * @param r the radius of the ball.
     * @param color the color of the ball.
     */
    public Ball(int x, int y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.r = Math.abs(r);
        this.color = color;

    }
    /**
     * A function that receives the coordinates of the midpoint of a ball,
     * velocity radius and color and builds a ball with them.
     * @param x the X value of the center point of the ball.
     * @param y the Y value of the center point of the ball.
     * @param r the radius of the ball.
     * @param v the velocity of the ball.
     * @param color the color of the ball.
     */
    public Ball(double x, double y, int r, Velocity v, java.awt.Color color) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        this.velocity = v;
    }

    // accessors
    /**
     * @return the X value of the center point of the ball.
     */
    public int getX() {
        return (int) this.center.getX();
    }
    /**
     * @return the Y value of the center point of the ball.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * @return the radius of the ball.
     */
    public int getSize() {
        return this.r;
    }
    /**
     * @return the color of the ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }
    // draw the ball on the given DrawSurface
    /** draw the ball on the given DrawSurface.
     * the function
     * @param surface the given DrawSurface.
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.getColor());
        surface.fillCircle(this.getX(), this.getY(), this.getSize());
    }
    /**
     * The function changes the ball speed value to the received value.
     * @param v The speed of the ball after the change.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }
    /**
     * The function changes the ball speed value to the received value.
     * @param dx The dx of the speed of the ball after the change.
     * @param dy The dy of the speed of the ball after the change.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }
    /**
     * @return the velocity of the ball.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }
    /**
     * The function moves the ball one step. when the ball hits the border to
     * the left or to the right, it should change its horizontal direction,
     * and when it hits the border on the top or the bottom, it should change
     * its vertical direction.
     */
    public void moveOneStep1() {
        //If the speed is null the operation will stop.
        Velocity velocity = this.getVelocity();
        if (velocity == null) {
            return;
        }
        //The next point after adding the speed.
        Point newPoint = velocity.applyToPoint(this.center);
        //The X value of the new point.
        double x = newPoint.getX();
        //The Y value of the new point.
        double y = newPoint.getY();
        // when the ball hits the border to the left or to the right, it
        // should change its horizontal direction,
        if (x - this.r <= ZERO || x + this.r >= SMALL_INTERFACE_WIDTH) {
            this.velocity = new Velocity((velocity.getDx() * -ONE),
                    velocity.getDy());
        }
        //when it hits the border on the top or the bottom, it should change
        // its vertical direction.
        if (y - this.r < ZERO || y + this.r > SMALL_INTERFACE_HEIGHT) {
            this.velocity = new Velocity(velocity.getDx(),
                    (-ONE * velocity.getDy()));
        }
        this.center = newPoint;
    }
    /**
     * The function moves the ball one step. when the ball hits the border to
     * the left or to the right, it should change its horizontal direction,
     * and when it hits the border on the top or the bottom, it should change
     * its vertical direction.
     */
    public void moveOneStep2() {
        //If the speed is null the operation will stop.
        Velocity velocity = this.getVelocity();
        if (velocity == null) {
            return;
        }
        //The next point after adding the speed.
        Point newPoint = velocity.applyToPoint(this.center);
        //The X value of the new point.
        double x = newPoint.getX();
        //The Y value of the new point.
        double y = newPoint.getY();
        //when the ball hits the border to the left or to the right, it
        // should change its horizontal direction, and when it hits the
        // border on the top or the bottom, it should change its vertical
        // direction.
        if ((x - this.r <= this.r || x + this.r
                >= (SMALL_INTERFACE_WIDTH - this.r))
                && (y - this.r <= this.r || y
                + this.r >= (SMALL_INTERFACE_HEIGHT - this.r))) {
            this.velocity = new Velocity((velocity.getDx() * -ONE),
                    -ONE * velocity.getDy());
        }
        if (x - this.r <= ZERO
                || x + this.r >= (SMALL_INTERFACE_WIDTH - FIVE)) {
            this.velocity = new Velocity((velocity.getDx() * -ONE),
                    velocity.getDy());
        }
        if (y - this.r < ZERO || y + this.r > (SMALL_INTERFACE_HEIGHT - FIVE)) {
            this.velocity = new Velocity(velocity.getDx(),
                    (-ONE * velocity.getDy()));
        }
        if (x - this.r <= ZERO
                || x + this.r >= (SMALL_INTERFACE_WIDTH - FIVE)) {
            this.velocity = new Velocity((velocity.getDx() * -ONE),
                    velocity.getDy());
        }
        if (y - this.r < ZERO || y + this.r > (SMALL_INTERFACE_HEIGHT - FIVE)) {
            this.velocity = new Velocity(velocity.getDx(),
                    (-ONE * velocity.getDy()));
        }
        if (x - this.r <= ZERO || x + this.r >= SMALL_INTERFACE_WIDTH) {
            this.velocity = new Velocity((velocity.getDx() * -ONE),
                    velocity.getDy());
        }
        if (y - this.r <= ZERO || y + this.r >= SMALL_INTERFACE_HEIGHT) {
            this.velocity = new Velocity(velocity.getDx(),
                    (-ONE * velocity.getDy()));
        }

        this.center = newPoint;
    }
    /**
     * The function moves the ball one step when it is in a gray rectangle.
     * when the ball hits the border to the left or to the right, it should
     * change its horizontal direction,and when it hits the border on the
     * top or the bottom, it should change its vertical direction.
     */
    public void moveOneStepGreyRec() {
        //If the speed is null the operation will stop.
        Velocity velocity = this.getVelocity();
        if (velocity == null) {
            return;
        }
        //The next point after adding the speed.
        Point newPoint = velocity.applyToPoint(this.center);
        //The X value of the new point.
        double x = newPoint.getX();
        //The Y value of the new point.
        double y = newPoint.getY();
        //when the ball hits the border to the left or to the right, it
        // should change its horizontal direction, and when it hits the
        // border on the top or the bottom, it should change its vertical
        // direction.
        if ((x - this.r <= GREY_REC_START + this.r || x + this.r
                >= (GREY_REC_END - this.r))
                && (y - this.r <= GREY_REC_START + this.r
                || y + this.r >= (GREY_REC_END - this.r))) {
            this.velocity = new Velocity((velocity.getDx() * -ONE),
                    -ONE * velocity.getDy());
        }
        if (x - this.r <= GREY_REC_START
                || x + this.r >= (GREY_REC_END - FIVE)) {
            this.velocity = new Velocity(velocity.getDx() * -ONE,
                    velocity.getDy());
        }
        if (y - this.r < GREY_REC_START || y + this.r > (GREY_REC_END - FIVE)) {
            this.velocity = new Velocity(velocity.getDx(),
                    -ONE * velocity.getDy());
        }
        if (x - this.r <= GREY_REC_START
                || x + this.r >= (GREY_REC_END - FIVE)) {
            this.velocity = new Velocity(velocity.getDx() * -ONE,
                    velocity.getDy());
        }
        if (y - this.r < GREY_REC_START || y + this.r > (GREY_REC_END - FIVE)) {
            this.velocity = new Velocity(velocity.getDx(),
                    -ONE * velocity.getDy());
        }
        if (x - this.r <= GREY_REC_START || x + this.r >= GREY_REC_END) {
            this.velocity = new Velocity(velocity.getDx() * -ONE,
                    velocity.getDy());
        }
        if (y - this.r <= GREY_REC_START || y + this.r >= GREY_REC_END) {
            this.velocity = new Velocity(velocity.getDx(),
                    -ONE * velocity.getDy());
        }
        this.center = newPoint;
    }
    /**
     * The function moves the ball one step when it is in a yellow rectangle.
     * The function moves the ball one step. when the ball hits the border to
     * the left or to the right, it should change its horizontal direction,
     * and when it hits the border on the top or the bottom, it should change
     * its vertical direction.
     */
    public void moveOneStepYellowRec() {
        //If the speed is null the operation will stop.
        Velocity velocity = this.getVelocity();
        if (velocity == null) {
            return;
        }
        //The next point after adding the speed.
        Point newPoint = velocity.applyToPoint(this.center);
        //The X value of the new point.
        double x = newPoint.getX();
        //The Y value of the new point.
        double y = newPoint.getY();
        //when the ball hits the border to the left or to the right, it
        // should change its horizontal direction, and when it hits the
        // border on the top or the bottom, it should change its vertical
        // direction.
        if ((x - this.r <= YELLOW_REC_START + this.r
                || x + this.r >= YELLOW_REC_END - this.r)
                && (y - this.r <= YELLOW_REC_START + this.r
                || y + this.r >= YELLOW_REC_END - this.r)) {
            this.velocity = new Velocity((velocity.getDx() * -ONE),
                    -ONE * velocity.getDy());
        }
        if (x - this.r <= YELLOW_REC_START
                || x + this.r >= (YELLOW_REC_END - FIVE)) {
            this.velocity = new Velocity(velocity.getDx() * -ONE,
                    velocity.getDy());
        }
        if (y - this.r < YELLOW_REC_START
                || y + this.r > (YELLOW_REC_END - FIVE)) {
            this.velocity = new Velocity(velocity.getDx(),
                    -ONE * velocity.getDy());
        }
        if (x - this.r <= YELLOW_REC_START
                || x + this.r >= (YELLOW_REC_END - FIVE)) {
            this.velocity = new Velocity(velocity.getDx() * -ONE,
                    velocity.getDy());
        }
        if (y - this.r < YELLOW_REC_START
                || y + this.r > (YELLOW_REC_END - FIVE)) {
            this.velocity = new Velocity(velocity.getDx(),
                    -ONE * velocity.getDy());
        }
        if (x - this.r <= YELLOW_REC_START || x + this.r >= YELLOW_REC_END) {
            this.velocity = new Velocity(velocity.getDx() * -ONE,
                    velocity.getDy());
        }
        if (y - this.r <= YELLOW_REC_START || y + this.r >= YELLOW_REC_END) {
            this.velocity = new Velocity(velocity.getDx(),
                    -ONE * velocity.getDy());
        }
        this.center = newPoint;
    }
    //ass3********************************************************************//
    /**
     * Set the GameEnvironment to new environment.
     * @param environment The new GameEnvironment.
     */
    public void setGameEnvironment(GameEnvironment environment) {
        this.environment = environment;
    }
    /**
     * The function moves the ball one step. when the ball hits the border to
     * the left or to the right, it should change its horizontal direction,
     * and when it hits the border on the top or the bottom, it should change
     * its vertical direction. if the ball hits a vertical edge of the block,
     * the horizontal direction should change, and if the ball hits a
     * horizontal edge of the block, the vertical direction should change.
     */
    public void moveOneStep() {
        // The X value of thr ball's velocity.
        double dx = this.velocity.getDx();
        // The Y value of thr ball's velocity.
        double dy = this.velocity.getDy();
        // The Y value of thr ball's midpoint.
        double x = this.center.getX();
        // The Y value of thr ball's midpoint.
        double y = this.center.getY();
        // Check if the collision was with a horizontal edge.
        if (x >= (INTERFACE_WIDTH - TEN) || x <= TEN) {
            dx = MINUS_ONE * dx;
        }
        // Check if the collision was with a vertical edge.
        if (y >= (INTERFACE_HEIGHT - TEN) || y <= TEN) {
            dy = MINUS_ONE * dy;
        }
        // The velocity after change the values due to the collision.
        this.velocity = new Velocity(dx, dy);
        // The trajectory of the ball.
        Line trajectory = new Line(this.center,
                this.velocity.applyToPoint(this.center));
        CollisionInfo collisionInfo =
                this.environment.getClosestCollision(trajectory);
        // If there is no collision the center point of the ball will not
        // change.
        if (collisionInfo == null) {
            this.center = this.velocity.applyToPoint(this.center);
        } else { // If there is collision those values will change:
            // The collision point.
            Point collisionPoint = collisionInfo.collisionPoint();
            // The collision object.
            Collidable collisionObject = collisionInfo.collisionObject();
            // The velocity after the collision.
            Velocity newVelocity = collisionObject.hit(this,
                    collisionPoint, this.velocity);
            //// The center point of the ball after the collision.
            this.center =
                    new Line(collisionPoint, this.center).pointOnLine(BETWEEN);
            // The velocity after the collision.
            this.velocity = newVelocity;
        }
    }
    /**
     * The function notify the ball that time has passed and activates the
     * moveOneStep function.
     */
    @Override
    public void timePassed() {
        moveOneStep();
    }
    /**
     * The function adds the ball to the game.
     * @param game The game of part in the assignment .
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }
    /**
     * The function remove a sprite from the game.
     * @param game the current game.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
}

