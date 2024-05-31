package AB7;

/**
 * This class represents vectors in a 3D vector space.
 */
public class Vector3 {

    private double x;
    private double y;
    private double z;

    /**
     * Initializes this vector with its three coordinates.
     * @param x the x-coordinate.
     * @param y the y-coordinate.
     * @param z the z-coordinate.
     */
    public Vector3(double x, double y, double z) {

        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Returns the x-coordinate.
     * @return the x-coordinate.
     */
    public double getX() {

        return x;
    }

    /**
     * Returns the y-coordinate.
     * @return the y-coordinate.
     */
    public double getY() {

        return y;
    }

    /**
     * Returns the z-coordinate.
     * @return the z-coordinate.
     */
    public double getZ() {

        return z;
    }

    /**
     * Returns the sum of this vector and vector 'v'.
     * @param v another vector, v != null.
     * @return the sum of this vector and vector 'v'.
     */
    public Vector3 plus(Vector3 v) {

        return new Vector3(this.x + v.x, this.y + v.y, this.z + v.z);
    }

    /**
     * Returns the product of this vector and 'd'.
     * @param d the coefficient for the product.
     * @return the product of this vector and 'd'.
     */
    public Vector3 times(double d) {

        return new Vector3(this.x * d, this.y * d, this.z * d);
    }

    /**
     * Returns the sum of this vector and -1*v.
     * @param v another vector, v != null.
     * @return the sum of this vector and -1*v.
     */
    public Vector3 minus(Vector3 v) {

        return new Vector3(this.x - v.x, this.y - v.y, this.z - v.z);
    }

    /**
     * Returns the Euclidean distance of this vector to the specified vector 'v'.
     * @param v another vector, v != null.
     * @return the Euclidean distance of this vector to the specified vector 'v'.
     */
    public double distanceTo(Vector3 v) {

        return this.minus(v).length();
    }

    /**
     * Returns the norm of this vector.
     * @return the length (norm) of this vector.
     */
    public double length() {

        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    /**
     * Normalizes this vector: changes the length of this vector such that it becomes 1.
     * The direction of the vector is not affected.
     */
    public void normalize() {

        double length = this.length();
        this.x /= length;
        this.y /= length;
        this.z /= length;
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

