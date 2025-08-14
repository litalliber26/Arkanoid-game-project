package sprites;
// 208000414 Lital Liber
/**
 * @author Lital Liber <lital.liber@live.biu.ac.il>
 * @version 1.0
 * @since 2023-04-28
 */
import geometry.Point;
/**
 * A class that contains information about the collision.
 */
public class CollisionInfo {
    // Fields
    // The collision point of the collidable object with the other object.
    private Point collisionPoint;
    // The collidable object.
    private Collidable collisionObject;
    /**
     * A function that receives collisionPoint and collisionObject and
     * builds a collisionInfo with them.
     * @param collisionPoint The collision point of the Collidable object with
     * the other object.
     * @param collisionObject The collidable object involved in the collision.
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }
    // the point at which the collision occurs.
    /**
     * @return The collision point of the collidable object with the other
     * object.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }
    // the collidable object involved in the collision.
    /**
     * @return The collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}