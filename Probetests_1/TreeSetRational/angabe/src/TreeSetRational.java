/**
 * A set of rational numbers implemented as a binary search tree. There are no
 * duplicate entries in this set (no two elements e1 and e2 for which e1.compareTo(e2) == 0). The
 * elements are sorted according to their value (the ordering is given by the method 'compareTo'
 * of class 'Rational').
 */
//
// TODO: define further classes and methods for the implementation of the binary search tree,
//   if needed. Do NOT use the Java-Collection framework in your implementation.
//
public class TreeSetRational
{

    // TODO: define missing parts of the class.

    /**
     * Initialises 'this' as an empty set.
     */
    public TreeSetRational() {

        // TODO: implement constructor.
    }

    /**
     * Adds the specified rational number to the set.
     * Returns 'true' if the set did not already contain the specified element
     * and 'false' otherwise.
     * @param r the rational number to add to this set, r != null.
     */
    public boolean add(Rational r) {

        // TODO: implement method.
        return false;
    }

    /**
     * Returns a new 'TreeSetRational' object that is the union of this set and the 'other' set.
     * 'this' and 'other' are not changed by this method.
     * @param other the second operand != null.
     */
    public TreeSetRational union(TreeSetRational other) {

        // TODO: implement method.
        return null;
    }

    /**
     * Returns the number of rational numbers in the set that are within the range defined by
     * the lowest and highest rational number (inclusive). The method exploits the structure of
     * the binary search tree and traverses only relevant parts of the tree.
     * @param highest the upper bound of the range.
     * @param lowest the lower bound of the range.
     * The following preconditions hold for 'highest' and 'lowest':
     *        lowest != null && highest != null && lowest.compareTo(highest) <= 0.
     * @return number of rational numbers in the set that are within the specified range.
     */
    public int countWithinRange(Rational lowest, Rational highest) {

        // TODO: implement method.
        return -1;
    }

    /**
     * Removes the lowest rational number from this set. Returns the rational number that was
     * removed from this set or 'null' if this set is empty.
     * (The corresponding node is removed by replacing it with the subtree of the node that
     * contains entries greater than the minimum.)
     * @return the lowest rational number from this set or 'null' if this set is empty.
     */
    public Rational removeMinimum() {

        // TODO: implement method.
        return null;
    }

    /**
     * Returns a string representation of 'this' with all rational objects
     * ordered ascending. The format of the string uses
     * brackets and is as in the following example with a set of four elements:
     * "[-3/4, -2/3, -1/3, 1/2]"
     * Returns "[]" if this set is empty.
     * @return the string representation of 'this'.
     */
    public String toString() {

        // TODO: implement method.
        return "";
    }
}

// TODO: define further classes, if needed (either here or in a separate file).
