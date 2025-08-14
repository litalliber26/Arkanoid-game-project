package geometry;
// 208000414 Lital Liber
/**
 * @author Lital Liber <lital.liber@live.biu.ac.il>
 * @version 1.0
 * @since 2023-04-10
 */
import java.util.List;
/**
 *Class Name: Line
 * The department represents a line made up of two points. With the help of
 * the department you can: calculate the length of a line, find the middle/
 * beginning/end point of the line, check if two lines intersect and what is the
 * meeting point between them and if two lines are equal.
 */
public class Line {
    // Fields
    // The starting point of the line.
    private Point start;
    // The end point of the line.
    private Point end;
    // constructors
    private static final double TWO = 2.0;
    private static final int ONE = 1;
    private static final int ZERO = 0;
    /**
     * The function receives a start point and a end point and builds a new
     * point with them.
     * @param start the start point of the line.
     * @param end the end point of the line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }
    /**
     * The function receives an X value and a Y value of the first point and
     * an X value and a Y value of the last point and builds a new line with
     * them.
     * @param x1 the x value of the start point.
     * @param y1 the y value of the start point.
     * @param x2 the x value of the end point.
     * @param y2 the y value of the end point.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }
    // Return the length of the line
    /**
     * The function calculates the length of the line and returns it.
     * @return the length of the line.
     */
    public double length() {
        //Returns the distance between the start point and the end point.
        return this.end.distance(start);
    }
    // Returns the middle point of the line
    /**
     * The function calculates the midpoint of the line and returns it.
     * @return the midpoint of the line.
     */
    public Point middle() {
        //Calculation of the middle X,Y value in the line by the average between
        // the X,Y of the start point and the end point.
        double x = (this.start.getX() + this.end.getX()) / TWO;
        double y = (this.start.getY() + this.end.getY()) / TWO;
        return new Point(x, y);
    }
    // Returns the start point of the line
    /**
     * The function calculates the start point of the line and returns it.
     * @return the start point of the line.
     */
    public Point start() {
        return this.start;
    }
    // Returns the end point of the line
    /**
     * The function calculates the  end point of the line and returns it.
     * @return the end point of the line.
     */
    public Point end() {
        return this.end;
    }
    // Returns true if the lines intersect, false otherwise

    /**
     * The function checks if the current line and another line intersect. If
     * so, it returns true, otherwise it returns false.
     * @param other the other line.
     * @return If the lines intersect it returns true, otherwise it returns
     * false.
     */
    public boolean isIntersecting(Line other) {
        //If the lines are identical they intersect.
        if (this.equals(other)) {
            return true;
        }
        if (this.start.equals(other.end)) {
            return true;
        }
        if (this.end.equals(other.start)) {
            return true;
        }
        //The X,Y values of the start and end points of the two lines.
        double x1 = this.start.getX();
        double y1 = this.start.getY();
        double x2 = this.end.getX();
        double y2 = this.end.getY();
        double x3 = other.start.getX();
        double y3 = other.start.getY();
        double x4 = other.end.getX();
        double y4 = other.end.getY();

        //The common factor of the intersection point.
        double commonFactor = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
        //If the common factor is zero the lines are parallel.
        if (commonFactor == ZERO) {
            return false;
        }
        //Calculation of the X value of the intersection point.
        double x =
                ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3
                        * x4)) / commonFactor;
        //Calculation of the Y value of the intersection point.
        double y =
                ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3
                        * x4)) / commonFactor;
        //Checking if the X value of the intersection point is between the two
        // lines.
        if ((x < Math.min(x1, x2) || x > Math.max(x1, x2))
                || (y < Math.min(y1, y2) || y > Math.max(y1, y2))) {
            return false;
        }
        //Checking if the Y value of the intersection point is between the two
        // lines.
        if ((x < Math.min(x3, x4) || x > Math.max(x3, x4))
                || (y < Math.min(y3, y4) || y > Math.max(y3, y4))) {
            return false;
        }
        return true;
    }
    // Returns the intersection point if the lines intersect,
    // and null otherwise.
    /**
     * If the lines intersect,the function will return the point of their
     * intersection, otherwise it will return null.
     * @param other The other line.
     * @return If the lines intersect,the function will return the point of
     * their intersection, otherwise it will return null.
     */
    public Point intersectionWith(Line other) {
        // If the lines do not equal, null will be returned.
        if (!this.isIntersecting(other)) {
            return null;
        }
        // If the lines do not intersect, null will be returned.
        if (this.equals(other)) {
            return null;
        }
        // The ending point of the first is equal to the starting points of the
        // second.
        if (this.end.equals(other.start)) {
            return this.end;
        }
        //The X,Y values of the start and end points of the two lines.
        double x1 = this.start.getX();
        double y1 = this.start.getY();
        double x2 = this.end.getX();
        double y2 = this.end.getY();
        double x3 = other.start.getX();
        double y3 = other.start.getY();
        double x4 = other.end.getX();
        double y4 = other.end.getY();

        //The common factor of the intersection point.
        double commonFactor = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
        //Calculation of the X value of the intersection point.
        double x =
                ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3
                        * x4)) / commonFactor;
        //Calculation of the Y value of the intersection point.
        double y =
                ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3
                        * x4)) / commonFactor;
        return new Point(x, y);
    }
    // equals -- return true is the lines are equal, false otherwise

    /**
     * The function checks whether the right line and the additional line are
     * equal. It will return true if they are equal, otherwise it will return
     * false.
     * @param other the other line.
     * @return It will return true if they are equal, otherwise it will return
     * false.
     */
    public boolean equals(Line other) {
        //Checking whether the start and end points of the lines are equal.
        if ((this.start.equals(other.start) && this.end.equals(other.end))
                || (this.start.equals(other.end)
                && this.end.equals(other.start))) {
            return true;
        }
        return false;
    }
    //ass3*******************************************************************//
    // If this line does not intersect with the rectangle, return null.
    // Otherwise, return the closest intersection point to the
    // start of the line.
    /**
     * The function searches for the Intersection point of the line rectangle
     * closest to the beginning of the line.
     * @param rect The rectangle that is checked for the closest collision
     * point.
     * @return If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the start of the
     * line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        // This line.
        Line l1 = new Line(this.start, this.end);
        // If this line does not intersect with the rectangle, return null.
        if (rect.intersectionPoints(l1) == null) {
            return null;
        }
        // List of all the intersection points of the line with the rectangle.
        List<Point> intersectionPoints = rect.intersectionPoints(l1);
        // If the list is one size return the only element in it.
        if (intersectionPoints.size() == ONE) {
            return intersectionPoints.get(ZERO);
        }
        // The nearest intersection point to the start of the line.
        Point minPoint = null;
        // The shortest distance between the start of the trajectory and the
        // point of collision.
        double minLength = ZERO;
        // The number of intersection points of the rectangle with the line.
        int k = intersectionPoints.size();
        // counter.
        int x = ZERO;
        //
        for (int i = ONE; i < k; i++) {
            // The meeting point is at position i in the list.
            Point collisionPoint = intersectionPoints.get(i);
            //
            if (collisionPoint != null) {
                double length = this.start.distance(intersectionPoints.get(i));
                x++;
                // if it is the first point in the list.
                if (x == ONE) {
                    minLength = length + ONE;
                }
                // If the length that the loop found is smaller than
                // minLength.The following values will vary depending on
                // the collision point found.
                if (this.start.distance(intersectionPoints.get(i))
                        < minLength) {
                    minPoint = intersectionPoints.get(i);
                    minLength = this.start.distance(intersectionPoints.get(i));
                }
            }
        }
        // return the closest intersection point to the start of the line.
        return minPoint;
    }
    /**
     * The function checks whether a certain point is part of the line.
     * @param point The point being tested is part of the line.
     * @return If the point is on the line the function will return true.
     * Otherwise,return false.
     */
    public boolean partOf(Point point) {
        //The X value of the point.
        double x = point.getX();
        //The Y value of the point.
        double y = point.getY();
        //The point is part of the line if two conditions are met:
        //1. Is the X value of the point between the minimum X value of the line
        // and the maximum X value of the line.
        //2. Is the Y value of the point between the minimum Y value of the line
        // and the maximum Y value of the line.
        double minX = Math.min(this.start.getX(), this.end.getX());
        double maxX = Math.max(this.start.getX(), this.end.getX());
        double minY =  Math.min(this.start.getY(), this.end.getY());
        double maxY = Math.max(this.start.getY(), this.end.getY());

        return (x >= minX && x <= maxX) && (y >= minY) && y <= maxY;
    }
    /**
     * The function returns a point that is between the start point and the end
     * point of the current line.
     * @param t A value between 0-1 that determines the distance of the new
     * point from the start and end points of the line.
     * @return a point that is on the current line.
     */
    public Point pointOnLine(double t) {
        // The X value of the new Point.
        double x = this.start.getX()
                + t * (this.end.getX() - this.start.getX());
        // The Y value of the new Point.
        double y = this.start.getY()
                + t * (this.end.getY() - this.start.getY());
        return new Point(x, y);
    }
}


