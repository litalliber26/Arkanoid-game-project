package sprites;
// 208000414 Lital Liber
/**
 * @author Lital Liber <lital.liber@live.biu.ac.il>
 * @version 1.0
 * @since 2023-04-28
 */
import java.util.ArrayList;
import java.util.List;
import geometry.Point;
import geometry.Line;
/**
 * The class will hold a collection of collidables.
 */
public class GameEnvironment {
    // The collection of collidables.
    private List<Collidable> collidables;
    /**
     * The function builds the sprites object from the ArrayList of Collidable .
     */
    public GameEnvironment() {
        collidables = new ArrayList<Collidable>();
    }
    /**
     * The function adds a collidable object to the sprites arrayList.
     * @param c The collidable object that the function adds.
     */
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }
    // Assume an object moving from line.start() to line.end().
    // If this object will not collide with any of the collidables
    // in this collection, return null. Else, return the information
    // about the closest collision that is going to occur.
    /**
     * The function finds the nearest collision point.
     * @param trajectory The trajectory of the object.
     * @return If this object will not collide with any of the collidables in
     * this collection, return null. Else, return the information about the
     * closest collision that is going to occur.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        // The nearest intersection point.
        Point minPoint = null;
        // The nearest Collidable object.
        Collidable minCollidable = null;
        // The shortest distance between the start of the trajectory and the
        // point of collision. This is the starting distance and since every
        // distance should be smaller than,I chose infinity. According to
        // what we learned in the Infi course, since this is about finite
        // distances between points. Infinity is always greater.
        double minLength = Double.POSITIVE_INFINITY;
        //The loop finds the nearest collision point.
        for (int i = 0; i < this.collidables.size(); i++) {
            // The nearest collision point.
            Point intersection = trajectory.
            closestIntersectionToStartOfLine(this.collidables.get(i)
            .getCollisionRectangle());
            // If there is a relevant collision point.
            if (intersection != null) {
                //The length will be the distance between the starting point
                // and the point we have now found.
                double length = trajectory.start().distance(intersection);
                // If the length that the loop found is smaller than
                // minLength.The following values will vary depending on
                // the collision point found.
                if (length < minLength) {
                    minLength = length;
                    minPoint = intersection;
                    minCollidable = this.collidables.get(i);
                }
            }
        }
        // If the loop didn't find a relevant collision point, the function
        // return null.
        if (minCollidable == null) {
            return null;
        }
        // return the CollisionInfo about the closet collision that the loop
        // found.
        return new CollisionInfo(minPoint, minCollidable);
    }
    /**
     * The function remove collidable from the collidables array.
     * @param c The deleted collidable.
     */
    public void removeCollidable(Collidable c) {
        this.collidables.remove(c);
    }
}
