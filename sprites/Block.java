package sprites;
// 208000414 Lital Liber
/**
 * @author Lital Liber <lital.liber@live.biu.ac.il>
 * @version 1.0
 * @since 2023-04-28
 */
import biuoop.DrawSurface;
import java.awt.Color;
import geometry.Rectangle;
import geometry.Line;
import geometry.Velocity;
import geometry.Point;
import games.GameLevel;
import hittig.HitListener;
import java.util.List;
import java.util.ArrayList;
import hittig.HitNotifier;

/**
 * The class implements the block which is a rectangle.
 */
public class Block implements Collidable, Sprite, HitNotifier   {
    // Fields
    // The rectangle that represents the block.
    private Rectangle block;
    // The list of hit listeners of the block.
    private List<HitListener> hitListeners;
    private Color color;
    private static final int MINUS_ONE = -1;
    /**
     * Create a new block with location, width/height and color.
     * @param x The X value of the upper-left point of the block.
     * @param y The Y value of the upper-left point of the block.
     * @param width  The width of the block.
     * @param height The height of the block.
     * @param color The color of the block.
     */
    public Block(int x, int y, double width, double height, Color color) {
        this.block = new Rectangle(x, y, width, height, color);
        this.hitListeners = new ArrayList<>();
    }
    /**
     * Create a new block with rectangle and color.
     * @param rectangle The rectangle of the block.
     * @param color The color of the block.
     */
    public Block(Rectangle rectangle, Color color) {
        this.block = rectangle;
        this.color = color;
    }
    // Return the "collision shape" of the object.
    /**
     * The function return the "collision shape" of the block.
     * @return The "collision shape" of the block.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.block;
    }
    // Notify the object that we collided with it at collisionPoint with
    // a given velocity.
    // The return is the new velocity expected after the hit (based on
    // the force the object inflicted on us).
    /**
     * The function calculates the velocity of the other object after the
     * collision with the block.
     * @param hitter the object that hit the Collidable object.
     * @param collisionPoint The collision point of the block with
     * the other object.
     * @param currentVelocity The Velocity of the other object before the
     * collision with the block.
     * @return The new velocity of the other object expected after the hit.
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint,
                        Velocity currentVelocity) {
        // The upperLeft X,Y value of the block.
        double x1 = this.block.getUpperLeft().getX();
        double y1 = this.block.getUpperLeft().getY();
        // The upperRight X,Y value of the block.
        double x2 = this.block.getUpperLeft().getX() + this.block.getWidth();
        double y2 = this.block.getUpperLeft().getY();
        // The downRight X,Y value of the block.
        double x3 = this.block.getUpperLeft().getX() + this.block.getWidth();
        double y3 = this.block.getUpperLeft().getY() + this.block.getHeight();
        // The downLeft X,Y value of the block.
        double x4 = this.block.getUpperLeft().getX();
        double y4 = this.block.getUpperLeft().getY() + this.block.getHeight();
        // The upperLeft point of the block.
        Line l1 = new Line(x1, y1, x2, y2);
        // The upperRight point of the block.
        Line l2 = new Line(x2, y2, x3, y3);
        // The downRight point of the block.
        Line l3 = new Line(x3, y3, x4, y4);
        // The downLeft point of the block.
        Line l4 = new Line(x4, y4, x1, y1);

        //The X value of the ball's velocity.
        double dx = currentVelocity.getDx();
        //The Y value of the ball's velocity.
        double dy = currentVelocity.getDy();
        //The new velocity after the hit.
        Velocity newVelocity = new Velocity(dx, dy);
        //if the ball hits a vertical edge of the block, the horizontal
        // direction should change.
        if (l4.partOf(collisionPoint)) {
            newVelocity = new Velocity(MINUS_ONE * dx, dy);
        } else if (l2.partOf(collisionPoint)) {
            newVelocity = new Velocity(MINUS_ONE * dx, dy);
        }
        ///if the ball hits a horizontal edge of the block, the vertical
        // direction should change.
        if (l1.partOf(collisionPoint)) {
            newVelocity = new Velocity(dx, MINUS_ONE * dy);
        } else if (l3.partOf(collisionPoint)) {
            newVelocity = new Velocity(dx, MINUS_ONE *  dy);
        }
        this.notifyHit(hitter);
        // return the velocity after the hit.
        return newVelocity;
    }
    /**
     * The function draw the block on the screen.
     * @param surface The screen on which the action will draw the block.
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.block.getColor());
        surface.fillRectangle((int) this.block.getUpperLeft().getX(),
                (int) this.block.getUpperLeft().getY(),
                (int) this.block.getWidth(),
                (int) this.block.getHeight());
    }
    /**
     * The function notify the block that time has passed.
     */
    @Override
    public void timePassed() {
    }
    /**
     * The function adds the block to the game.
     * @param game The game in the assignment .
     */
    public void addToGame(GameLevel game) {
        game.addCollidable(this);
        game.addSprite(this);
    }
    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }
    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
    /**
     * The function will be called whenever a hit() occurs, and will notify
     * all the registered HitListener objects by calling their hitEvent method.
     * @param hitter The ball that hit the block.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners =
                new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
    /**
     * The function remove the block from the game.
     * @param game the current game.
     */
    public void removeFromGame(GameLevel game) {
        //Remove the block from the collidables array.
        game.removeCollidable(this);
        //Remove the block from the sprite collection.
        game.removeSprite(this);
        //Remove the HitListener.
        removeHitListener((HitListener) game.getBlockRemover());
    }
}
