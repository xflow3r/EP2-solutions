/**
 * This class represents a rational number with an int numerator and denominator.
 * Please, do not change this class definition.
 */
public class Rational {

    private int numerator;
    private int denominator;

    /**
     * Initializes this rational with numerator and denominator.
     * @param numerator the numerator of this rational number.
     * @param denominator the denominator != 0.
     */
    public Rational(int numerator, int denominator) {

        if (numerator == 0) {
            this.numerator = 0;
            this.denominator = 1;
        } else {
            int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
            this.numerator = numerator / gcd;
            this.denominator = denominator / gcd;
            if (this.denominator < 0) {
                this.numerator *= -1;
                this.denominator *= -1;
            }
        }
    }

    /**
     * Returns the greatest common divisor of 'a' and 'b'.
     * @param a the first number.
     * @param b the second number.
     * @return the greatest common divisor of 'a' and 'b'.
     */
    private int gcd(int a, int b) {

        return b == 0 ? a : gcd(b, a % b);
    }

    /**
     * Returns the numerator of the rational number.
     * @return the numerator of the rational number.
     */
    public int getNumerator() {

        return numerator;
    }

    /**
     * Returns the denominator of the rational number.
     * @return the denominator of the rational number.
     */
    public int getDenominator() {

        return denominator;
    }

    /**
     * Compares 'this' to the rational number specified by 'other'.
     * Return -1 if this rational number is less than the other rational number, 0 if they are
     * equal, or 1 if this rational number is greater than the other rational number.
     * @param other the rational number with which 'this' is compared.
     * @return -1 if this rational number is less than the other rational number, 0 if they are
     * equal, or 1 if this rational number is greater than the other rational number.
     */
    public int compareTo(Rational other) {

        if (this.numerator == other.numerator && this.denominator == other.denominator) {
            return 0;
        } else if (this.numerator * other.denominator < other.numerator * this.denominator) {
            return -1;
        } else {
            return 1;
        }
    }

    /**
     * Returns a string representation of 'this' in the form numerator/denominator.
     * @return a string representation of 'this'.
     */
    public String toString() {

        if (denominator == 1) {
            return Integer.toString(numerator);
        } else {
            return numerator + "/" + denominator;
        }
    }
}

