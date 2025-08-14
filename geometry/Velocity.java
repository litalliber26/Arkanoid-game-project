package geometry;
// 208000414 Lital Liber
/**
 * @author Lital Liber <lital.liber@live.biu.ac.il>
 * @version 1.0
 * @since 2023-04-10
 */

/**
 *Class Name: Velocity
 * The class represents a speed represented by the X and Y coordinates.
 */
public class Velocity {
    // Fields
    private double dx;
    private double dy;
    //Magic numbers.
    private static final int ONE = 1;
    private static final int TWO = 2;
    // constructor
    /**
     * A function that accepts dx dy and constructs using velocity.
     * @param dx the dx value of the new velocity.
     * @param dy the dy value of the new velocity.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * @return the dx value of the new velocity.
     */
    public int getDx() {

        return (int) this.dx;
    }
    /**
     * @return the dy value of the new velocity.
     */
    public int getDy() {

        return (int) this.dy;
    }

    /**
     *The function that calculates the size of the Velocity using the formula:
     * dx^2+dy^2=VelocitySize^2.
     * @return The size of the velocity.
     */
    public double getVelocitySize() {
        //Calculation of the squared X value.
        double dx = Math.pow(this.dx, TWO);
        //Calculation of the squared Y value.
        double dy = Math.pow(this.dy, TWO);
        //Calculation of the squared value of the size of the velocity.
        double velocitySizeSquared = dx + dy;
        //Calculation of the size of the velocity.
        return Math.sqrt(velocitySizeSquared);
    }

    // Take a point with position (x,y) and return a new point
    // with position (x+dx, y+dy)

    /**
     * The function take a point with position (x,y) and return a new point
     * with position (x+dx, y+dy).
     * @param p the start point.
     * @return a new point with position (x+dx, y+dy).
     */

    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }

    /**
     * A function that receives an angle and velocity and constructs with a
     * new velocity.
     * @param angle the angle of the new velocity.
     * @param speed the size of new velocity.
     * @return the new velocity.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        //Conversion of the angle to the relevant units of measure.
        double newAngle = Math.toRadians(angle);
        //Calculation of the X value of the speed as a function of the given
        // angle.
        double dx = speed * Math.sin(newAngle);
        //Calculation of the Y value of the speed as a function of the given
        // angle.
        double dy = -ONE * speed * Math.cos(newAngle);
        return new Velocity(dx, dy);
    }

}