package AB5;

import java.util.Objects;

/**
 * This class represents a constant integer value. Two 'IntConst' objects are equal
 * if they represent the same value.
 */
public class IntConst implements LinearExpression {

    private final int value;

    /**
     * Initializes this constant with the specified value.
     * @param value, value != 0 && value != 1 && value != -1.
     */
    public IntConst(int value) {
        this.value = value;
    }

    @Override
    /**
     * Returns the sum of 'this' and 'c'.
     * @param c the second operand, c != null.
     * @return the sum of 'this' and 'c'.
    */
    public IntConst plus(IntConst c) {
        return new IntConst(c.value + this.value);
    }


    /**
     * The 'plus' method specifically for terms with variables
     * (see specification of 'plus(LinearExpression)').
     * @param t the second summand != null.
     * @return the sum of 'this' and 'v'.
     */
    @Override
    public LinearExpression plus(IntVarTerm t) {
        return new SumOfTerms(t, this); // return new SumOfTerms(t, this);
    }

    @Override
    /**
     * Returns the product of 'this' and 'c'.
     * @param c the second operand, c != null.
     * @return the sum of 'this' and 'c'.
     */
    public IntConst times(IntConst c) {
        return new IntConst(c.value * this.value);
    }

    @Override
    /**
     * Returns an expression in which values have been assigned to variables.
     * Since this expression is constant and has no variable, it's value is just 'this'.
     * (Since 'this' is immutable, no new object is created by this method.)
     */
    public LinearExpression assignValue(IntVarConstMap map) {
        return this;
    }

    @Override
    /**
     * Returns the sum of 'this' and 'e' represented by an object of the most specific
     * subtype of 'LinearExpression'.
     * @param e the second summand, e != null.
     * @returns the sum of 'this' and 'e'
     */
    public LinearExpression plus(LinearExpression e) {

        if (e.getClass() == this.getClass()) {
            return new IntConst(((IntConst) e).value + this.value);
        }
        return e.plus(this);
    }

    @Override
    /**
     * Returns a new constant representing the negative 'this', such that for a constant c the
     * following holds: c.plus(c.negate()).isZero() == true.
     * @return the negative of 'this'.
     */
    public IntConst negate() {
        return new IntConst(-value);
    }

    /**
     * Returns 'true' only if 'this' represents the value 0.
     * @return 'true' if 'this' represents the value 0, otherwise 'false'.
     */
    public boolean isZero() {
        return value == 0;
    }

    /**
     * Returns 'true' if and only if 'this' is less than 'c'.
     * @param c the other constant to compare with, c != null.
     * @return 'true' if 'this' is less than 'c', otherwise 'false'.
     */
    public boolean lessThan(IntConst c) {
        return this.value < c.value;
    }

    /**
     * Returns a readable representation of 'this', i.e., the value of 'this' as a string.
     * @return a readable representation of 'this'.
     */
    @Override
    public String toString() {
        return Integer.toString(value);
    }

    @Override
    /**
     * Returns the iterator over 'IntVar' elements of 'this'. As a constant 'this' has no
     * such elements.
     */
    public IntVarIterator iterator() {
        return new ConstIntVarIterator();
    }

    @Override
    /**
     * Compares 'this' and 'o' for equality.
     * @param o the object which is checked for equality with 'this'.
     * @returns 'true' if 'this' and 'o' are equal, otherwise 'false'.
     */
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;
        return value == ((IntConst)o).value;
    }

    @Override
    /**
     * The hash code of 'this'.
     */
    public int hashCode() {

        return Objects.hash(value);
    }
}

/**
 * The 'IntVarIterator' implementation for constants. Constants have no elements of
 * type 'IntVar'.
 */
class ConstIntVarIterator implements IntVarIterator {

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public IntVar next() {
        return null;
    }
}
