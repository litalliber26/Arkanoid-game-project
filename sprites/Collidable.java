package sprites;
// 208000414 Lital Liber
/**
 * @author Lital Liber <lital.liber@live.biu.ac.il>
 * @version 1.0
 * @since 2023-04-28
 */
import geometry.Rectangle;
import geometry.Velocity;
import geometry.Point;
/**
 * The Collidable interface will be used by things that can be collided with.
 * In this assignment, this means the Blocks and the Paddle.
 */
public interface Collidable {
    // Return the "collision shape" of the object.
    /**
     * The function return the "collision shape" of the object.
     * @return The "collision shape" of the object, in this assignment, this
     * means the Blocks or the Paddle.
     */
    Rectangle getCollisionRectangle();
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
     Velocity hit(Ball hitter, Point collisionPoint,
                        Velocity currentVelocity);
}