package AB6;

/**
 * This interface represents a linear expression. A linear expression is a term (constant
 * or a product of a coefficient and a variable) or a sum of linear terms each containing at
 * most a single variable. For example, 3x - y + 5 is such an expression. Objects of
 * 'LinearExpression' are iterable: They provide an iterator over all variables of the expression.
 */
public interface LinearExpression extends IntVarIterable {

    static final IntConst ONE = new IntConst(1);
    static final IntConst ZERO = new IntConst(0);

    /**
     * Returns a linear expression representing the sum of 'this' and 'e'. The result is
     * represented by an object of the most specific subtype of 'LinearExpression'. For example, if
     * the result can be reduced to a single term consisting of a variable and a coefficient of 1
     * the returned object is of type 'IntVar'. If it can be reduced to just a constant the
     * returned object is of type 'IntConst'.
     * @param e the second summand != null.
     * @return the sum of 'this' and 'v'.
     */
    LinearExpression plus(LinearExpression e);

    /**
     * The 'plus' method specifically for constants
     * (see specification of 'plus(LinearExpression)').
     * @param c the second summand != null.
     * @return the sum of 'this' and 'v'.
     */
    LinearExpression plus(IntConst c);

    /**
     * The 'plus' method specifically for terms with variables
     * (see specification of 'plus(LinearExpression)').
     * @param t the second summand != null.
     * @return the sum of 'this' and 'v'.
     */
    LinearExpression plus(IntVarTerm t);

    /**
     * Returns the expression representing the negation of 'this', such that for an expression 'e'
     * the following condition holds: e.plus(e.negate()).equals(ZERO).
     * @return the negation of 'this'.
     */
    LinearExpression negate();

    /**
     * Returns the product of 'this' and 'c'.
     * @param c the second operand for the product.
     * @return the product of 'this' and 'c'.
     */
    LinearExpression times(IntConst c);

    /**
     * Returns the expression resulting from assigning specific values to certain variables.
     * In this new expression the corresponding variables have been substituted by the constant
     * values, that were assigned to these variables through mappings in 'varValues'. For example,
     * if 'varValues' associates variable x with constant 2 and variable y with constant 3,
     * calling the method on the expression representing 2x + y will result in the expression
     * representing the constant 7. If 'varValues' contains the mapping for y, but no mapping for
     * x, then the result is the expression 2x + 3. If there is neither a mapping for x nor for y,
     * then the result is the expression 2x + y.
     * @param varValues the map containing mappings from variables to their assigned values,
     *                  varValues != null.
     * @return the new expression in which specific variables have been replaced by constant
     * values (as specified by 'varValues').
     */
    LinearExpression assignValue(IntVarConstMap varValues);

    /**
     * A readable representation of this expression in which each of its variables appears only
     * once preceded by a coefficient, unless the coefficient is 1 or -1.
     * The order in which the variables appear is not specified. Non-zero constants appear as the
     * last term in the string.
     * Terms that are zero are omitted. For example, -y + x + x - 4 would be represented by
     * "2x - y - 4" and x + y - x + 0 would be represented by "y", if there is only one
     * variable named 'x' in these expressions. If the two occurrences of 'x' in the expression
     * x + x correspond to different variable objects (with the same name), the string
     * representation is "x + x" instead of "2x".
     * (See Test.java for further examples.)
     * @return readable representation of this expression.
     */
    String toString();

    /**
     * Compares the specified object with 'this' for equality. Returns 'true' if the
     * given object is of type 'LinearExpression' and represents the same expression in the
     * mathematical sense. This means each term of this must have an equal counterpart in 'o' and
     * vice versa. Otherwise, 'false' is returned.
     * @param o the object to check for equality.
     * @return if the given object represents the same mathematical expression.
     */
    boolean equals(Object o);

    /**
     * Returns the hash code of 'this'.
     * @return the hash code of 'this'.
     */
    int hashCode();

}
