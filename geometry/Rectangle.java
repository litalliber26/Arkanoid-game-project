package geometry;
// 208000414 Lital Liber
/**
 * @author Lital Liber <lital.liber@live.biu.ac.il>
 * @version 1.0
 * @since 2023-04-28
 */
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * The class represents a rectangle represented by upperLeft point,width, height
 * and color.
 */
public class Rectangle {
    // Fields
    // The upper-left point of the rectangle.
    private Point upperLeft;
    // The width of the rectangle.
    private double width;
    // The height of the rectangle.
    private double height;
    // The color of the rectangle.
    private Color color;
    // Create a new rectangle with location and width/height.
    /**
     * Create a new rectangle with location and width/height.
     * @param upperLeft The upper-left point of the rectangle.
     * @param width  The width of the rectangle.
     * @param height The color of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }
    /**
     * Create a new rectangle with location and width/height.
     * @param x The X value of the upper-left point of the rectangle.
     * @param y The Y value of the upper-left point of the rectangle.
     * @param width  The width of the rectangle.
     * @param height The height of the rectangle.
     */
    public Rectangle(int x, int y, double width, double height) {
        this.upperLeft = new Point(x, y);
        this.width = width;
        this.height = height;
    }
    /**
     * Create a new rectangle with location, width/height and color.
     * @param x The X value of the upper-left point of the rectangle.
     * @param y The Y value of the upper-left point of the rectangle.
     * @param width  The width of the rectangle.
     * @param height The height of the rectangle.
     * @param color The color of the rectangle.
     */
    public Rectangle(int x, int y, double width, double height, Color color) {
        this.upperLeft = new Point(x, y);
        this.width = width;
        this.height = height;
        this.color = color;
    }
    /**
     * Create a new rectangle with rectangle and color.
     * @param rectangle The rectangle.
     * @param color The color of the rectangle.
     */
    public Rectangle(Rectangle rectangle, Color color) {
        this.upperLeft = rectangle.getUpperLeft();
        this.width = rectangle.getWidth();
        this.height = rectangle.getHeight();
        this.color = color;
    }
    // Return a (possibly empty) List of intersection points
    // with the specified line.
    /**
     * The function checks if a certain line has intersection points with the
     * rectangle.
     * @param line The line that the function checks to see if it has
     * intersection points with the rectangle.
     * @return a (possibly empty) List of intersection points with the
     * specified line.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> intersectionPoints = new ArrayList<>();
        // The upperLeft X,Y value of the rectangle.
        double x1 = this.upperLeft.getX();
        double y1 = this.upperLeft.getY();
        // The upperRight X,Y value of the rectangle.
        double x2 = this.upperLeft.getX() + this.width;
        double y2 = this.upperLeft.getY();
        // The downRight X,Y value of the rectangle.
        double x3 = this.upperLeft.getX() + this.width;
        double y3 = this.upperLeft.getY() + this.height;
        // The downLeft X,Y value of the rectangle.
        double x4 = this.upperLeft.getX();
        double y4 = this.upperLeft.getY() + this.height;
        // The upperLeft point of the rectangle.
        Line l1 = new Line(x1, y1, x2, y2);
        // The upperRight point of the rectangle.
        Line l2 = new Line(x2, y2, x3, y3);
        // The downRight point of the rectangle.
        Line l3 = new Line(x3, y3, x4, y4);
        // The downLeft point of the rectangle.
        Line l4 = new Line(x4, y4, x1, y1);
        //Checking whether the line intersects each of the sides of the
        // rectangle. If so, adding the intersection point to the array of
        // intersection points.
        if (line.isIntersecting(l3)) {
            intersectionPoints.add(line.intersectionWith(l3));
        }
        if (line.isIntersecting(l2)) {
            intersectionPoints.add(line.intersectionWith(l2));
        }
        if (line.isIntersecting(l1)) {
            intersectionPoints.add(line.intersectionWith(l1));
        }
        if (line.isIntersecting(l4)) {
            intersectionPoints.add(line.intersectionWith(l4));
        }
        //Return list of intersection points with the specified line.
        return intersectionPoints;
    }
    // Return the width and height of the rectangle
    /**
     * @return the width of the rectangle.
     */
    public double getWidth() {
        return this.width;
    }
    /**
     * @return the height of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }
    // Returns the upper-left point of the rectangle.
    /**
     * @return the upper-left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
    /**
     * @return the color point of the rectangle.
     */
    public Color getColor() {
        return this.color;
    }
    /**
     * Set the UpperLeft point to newUpperLeft.
     * @param newUpperLeft The value of the UpperLeft point.
     */
    public void setUpperLeft(Point newUpperLeft) {
        this.upperLeft = new Point(newUpperLeft.getX(), newUpperLeft.getY());
    }
    /**
     * The function transforms the upperLeft point from (x,y) to (x+dx, y+dy).
     * @param dx The delta of X value of the point.
     * @param dy The delta of X value of the point.
     */
    public void applyTO(double dx, double dy) {
        this.upperLeft = new Point(this.upperLeft.getX()
                + dx, this.upperLeft.getY() + dy);
    }
}
