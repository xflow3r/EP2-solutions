package AB1;

import codedraw.CodeDraw;

import java.awt.*;

/**
 * This class represents vectors in a 3D vector space.
 */
public class Vector3 {

    private double x;
    private double y;
    private double z;


    public Vector3(){

    }

    public Vector3 (double x, double y , double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Returns the sum of this vector and vector 'v'.
     * @param v another vector, v != null.
     * @return the sum of this vector and vector 'v'.
     */
    public Vector3 plus(Vector3 v) {
        return new Vector3(this.x + v.x , this.y + v.y , this.z + v.z);
    }

    /**
     * Returns the product of this vector and 'd'.
     * @param d the coefficient for the product.
     * @return the product of this vector and 'd'.
     */
    public Vector3 times(double d) {
        return new Vector3(this.x*d, this.y*d, this.z*d);
    }

    /**
     * Returns the sum of this vector and -1*v.
     * @param v another vector, v != null.
     * @return the sum of this vector and -1*v.
     */
    public Vector3 minus(Vector3 v) {
        return new Vector3(this.x-v.x, this.y-v.y, this.z - v.z);
    }

    /**
     * Returns the Euclidean distance of this vector to the specified vector 'v'.
     * @param v another vector, v != null.
     * @return the Euclidean distance of this vector to the specified vector 'v'.
     */
    public double distanceTo(Vector3 v) {
        return Math.sqrt(Math.pow(this.x-v.x,2) + Math.pow(this.y-v.y,2) + Math.pow(this.z-v.z,2));
    }

    /**
     * Returns the norm of this vector.
     * @return the length (norm) of this vector.
     */
    public double length() {
        return Math.sqrt(Math.pow(x,2) + Math.pow(y,2) + Math.pow(z,2));
    }

    /**
     * Normalizes this vector: changes the length of this vector such that it becomes 1.
     * The direction of the vector is not affected.
     */
    public void normalize() {
        this.x = this.x / this.length();
        this.y = this.y / this.length();
        this.z = this.z / this.length();
    }

    /**
     * Draws a filled circle with a specified radius centered at the (x,y) coordinates of this vector
     * in the canvas associated with 'cd'. The z-coordinate is not used.
     * @param cd the CodeDraw object used for drawing.
     * @param radius the radius > 0.
     */
    public void drawAsFilledCircle(CodeDraw cd, double radius) {

        double x = cd.getWidth() * (this.x + Simulation.SECTION_SIZE / 2) / Simulation.SECTION_SIZE;
        double y = cd.getWidth() * (this.y + Simulation.SECTION_SIZE / 2) / Simulation.SECTION_SIZE;
        double radius2 = cd.getWidth() * radius / Simulation.SECTION_SIZE;

        cd.fillCircle(x, y, Math.max(radius2, 1.5));
    }

    /**
     * Returns the result of dividing this vector by a scalar 'd'.
     * @param d the divisor.
     * @return the result of division.
     */
    public Vector3 divide(double d) {
        // To prevent division by zero, you might want to add a check here
        if (d == 0) {
            return new Vector3(0,0,0);
        }
        return new Vector3(this.x / d, this.y / d, this.z / d);
    }


    /**
     * Returns the coordinates of this vector in brackets as a string
     * in the form "[x, y, z]", e.g., "[1.48E11, 0.0, 0.0]".
     * @return 'this' represented as a string.
     */
    public String toString() {
        return "[" + this.x + ", " + this.y + ", " + this.z + "]";
    }
}


