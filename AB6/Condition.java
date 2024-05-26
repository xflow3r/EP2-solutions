package AB6;

/**
 * An interface for conditions over expressions with 'IntVar' objects as variables. For example,
 * 3x+y == 0 is such a condition. Conditions can also be combined to form more complex expressions
 * such as 3x+y == 0 AND NOT(x == 0).
 */
public interface Condition {

    /**
     * Returns a new condition representing the boolean combination 'this' AND 'c'.
     * @param c the second condition, c != null.
     * @return a new condition representing the boolean combination 'this' AND 'c'.
     */
    default Condition and(Condition c) {

        return new AND(this, c);
    }

    /**
     * Returns a new condition representing the boolean combination 'this' OR 'c'.
     * @param c the second condition, c != null.
     * @return a new condition representing the boolean combination 'this' OR 'c'.
     */
    default Condition or(Condition c) {

        return new OR(this, c);
    }

    /**
     * Returns a new condition representing the boolean operation NOT 'this'.
     * @return a new condition representing the boolean operation NOT 'this'.
     */
    default Condition not() {

        return new NOT(this);
    }

    /**
     * Returns a new set of all variables of this condition. Later changes of 'this' will
     * not affect the set and vice versa.
     * @return a new set of all variables of this condition.
     */
    IntVarSet getVarSet();

    /**
     * Returns 'true' if this condition is satisfied for the specified variable
     * assignments, otherwise 'false'.
     * @param assignments the values for each variable occurring in this condition.
     * @return 'true' if this condition is satisfied, otherwise 'false'.
     */
    boolean getValue(IntVarConstMap assignments);
}
