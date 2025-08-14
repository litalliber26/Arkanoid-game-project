package geometry;
// 208000414 Lital Liber
/**
 * @author Lital Liber <lital.liber@live.biu.ac.il>
 * @version 1.0
 * @since 2023-04-10
 */

/**
 *Class Name: Point
 * The class represents a point made up of an X value and a Y value. You can
 * calculate with the help of the class: distance between two points and compare
 * two points.
 */

public class Point {
    // Fields
    // The X value of the point.
    private double x;
    // The Y value of the point.
    private double y;
    // constructors
    /**
     * The function receives an X value and a Y value and builds a new point
     * with them.
     * @param x The X value of the new point.
     * @param y The Y value of the new point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    // distance -- return the distance of this point to the other point
    /**
     * The function calculates the distance between the current point and
     * another point.
     * @param other The other point.
     * @return the distance between the two points.
     */
    public double distance(Point other) {
        // Calculation of distance between two points based on the formula
        //d2=(x2−x1)2+(y2−y1)2
        return Math.sqrt(((this.getX() - other.getX()) * (this.getX()
                - other.getX())) + ((this.getY() - other.getY()) * (this.getY()
                - other.getY())));
    }

    // equals -- return true is the points are equal, false otherwise.
    /**
     * The function checks whether the current point is equal to another point.
     * @param other The other point.
     * @return Returns true if the points are equal and false if they are not.
     */
    public boolean equals(Point other) {
        //If the Y, X values are equal then the points are equal and true will
        // be returned. If they are different and false will be returned.
        if (this.getX() == other.getX() && this.getY() == other.getY()) {
            return true;
        }
        return false;
    }
    /**
     * The function prints the point values as follows: (x,y).
     */
    public void printPoint() {
        System.out.println("(" + this.x + "," + this.y + ")");
    }
    // Return the x and y values of this point
    /**
     * @return the x values of this point.
     */
    public double getX() {
        return this.x;
    }
    /**
     * @return the y values of this point.
     */
    public double getY() {
        return this.y;
    }
}