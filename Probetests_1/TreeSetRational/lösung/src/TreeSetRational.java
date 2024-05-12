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
    private TreeNode root;
    /**
     * Initialises 'this' as an empty set.
     */
    public TreeSetRational() {
        this.root = null;
    }

    /**
     * Adds the specified rational number to the set.
     * Returns 'true' if the set did not already contain the specified element
     * and 'false' otherwise.
     * @param r the rational number to add to this set, r != null.
     */
    public boolean add(Rational r) {
        if (root == null) {
            this.root = new TreeNode(r);
            return true;
        } else {
            return root.add(r);
        }
    }

    /**
     * Returns a new 'TreeSetRational' object that is the union of this set and the 'other' set.
     * 'this' and 'other' are not changed by this method.
     * @param other the second operand != null.
     */
    public TreeSetRational union(TreeSetRational other) {
        TreeSetRational newSet = new TreeSetRational();
        this.root.union(newSet);
        other.root.union(newSet);
        return newSet;
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
        if (this.root == null) {
            return 0;
        } else {
            return root.countWithinRange(lowest, highest);
        }
    }

    /**
     * Removes the lowest rational number from this set. Returns the rational number that was
     * removed from this set or 'null' if this set is empty.
     * (The corresponding node is removed by replacing it with the subtree of the node that
     * contains entries greater than the minimum.)
     * @return the lowest rational number from this set or 'null' if this set is empty.
     */
    public Rational removeMinimum() {
        if (root == null) {
            return null;
        } else if (root.getLeft() == null) {
            Rational min = root.getValue();
            root = root.getRight();
            return min;
        } else {
            Rational min = root.removeMinimum();
            root.removeMinimumTree();
            return min;
        }
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
        if (root == null) {
            return "[]";
        } else {
            String s = "[";
            s += root.toStringNode().substring(0, root.toStringNode().length()-2) + "]";
            return s;
        }
    }
}

class TreeNode {
    private Rational value;
    private TreeNode left, right;

    public TreeNode(Rational value) {
        this.value = value;
        this.left = this.right = null;
    }

    public String toStringNode() {
        String s = "";

        if (left != null) {
            s += left.toStringNode();
        }
        s += this.value.toString() + ", ";
        if (right != null) {
            s += right.toStringNode();
        }
        return s;
    }

    public Rational removeMinimum() {
        if (this.left == null) {
            return this.value;
        } else {
            return left.removeMinimum();
        }
    }

    public void removeMinimumTree() {
        if (this.left != null && this.left.left == null) {
            this.left = this.left.right; // replace the left child with its right subtree
        } else if (this.left != null) {
            this.left.removeMinimumTree();
        }
    }


    public void union(TreeSetRational r){ // copy the whole tree into r?
        r.add(this.value);
        if (left != null) {
            left.union(r);
        }
        if (right != null) {
            right.union(r);
        }
    }


    public int countWithinRange(Rational lowest, Rational highest) {
        int counter = 0;

        if (this.value.compareTo(lowest) >= 0 && this.value.compareTo(highest) <= 0) { //value is within bounds
            counter += 1;
        }
        if (this.left != null) {
            counter += left.countWithinRange(lowest, highest);
        }
        if (this.right != null) {
            counter += right.countWithinRange(lowest, highest);
        }

        return counter;
    }



    public boolean add(Rational r) {
        if (this.value.compareTo(r) > 0) { //this is smaller
            if (this.left != null) {
                return left.add(r);
            } else {
                this.left = new TreeNode(r);
                return true;
            }
        } else if (this.value.compareTo(r) < 0) {  //this is bigger
            if(this.right != null) {
                return right.add(r);
            } else {
                this.right = new TreeNode(r);
                return true;
            }
        } else { //last case when this == 0 -> equals
            return false;
        }
    }

    public Rational getValue() {
        return value;
    }


    public TreeNode getLeft() {
        return left;
    }


    public TreeNode getRight() {
        return right;
    }

}
// TODO: define further classes, if needed (either here or in a separate file).
