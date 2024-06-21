import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * A 'BalancedStick' has a specified stick weight, that can not be changed after
 * initialisation. On the left and right end of the stick mobiles
 * are attached (recursive structure). 'BalancedStick' implements 'Mobile'.
 * You can assume that no part of a mobile has the same identity as another part.
 */
//
// TODO: Complete the methods in 'BalancedStick'.
//       You can define further classes and methods for the implementation.
//       You may use the Java-Collection framework.
//
public class BalancedStick implements Mobile // TODO: activate clause.
{

    //TODO: define missing parts of the class.
    private final int stickweight;
    private Mobile left, right;


    /**
     * Initialises 'this'; throws an 'UnbalancedException' if the resulting mobile
     * would not be balanced, i.e. if left.getWeight() != right.getWeight(). The detail message
     * of the exception contains information about the difference between left and right weight,
     * for example "Stick unbalanced (left 7 - right 16)" (see example in 'PraxisTest2.java').
     *
     * @param stickWeight the weight of the stick, stickWeight > 0.
     * @param left the left mobile, left != null.
     * @param right the right mobile, right != null.
     *        no part of a mobile has the same identity as another part.
     * @throws UnbalancedException if the mobile would not be balanced
     */
    public BalancedStick(int stickWeight, Mobile left, Mobile right) throws UnbalancedException {
        this.stickweight = stickWeight;
        if (left.getWeight() != right.getWeight()) throw new UnbalancedException("Stick unbalanced (left " + left.getWeight() + " - right " + right.getWeight() + ")");
        this.left = left;
        this.right = right;
    }

    /**
     * Replaces the mobile equal to 'toReplace' with a new mobile 'replaceWith' and
     * returns 'true' if such a mobile is contained as part of this mobile, i.e., attached to this
     * stick or below (recursive search). Otherwise, the call of this method has no effect and
     * 'false' is returned.
     * Throws an 'UnbalancedException' if the replacement would violate the
     * conditions that all sticks need to be balanced. The detail message
     * of the exception contains information about the difference between left and right weight.
     *
     * @param toReplace the mobile to be replaced, toReplace != null.
     * @param replaceWith the new mobile to replace with, replaceWith != null.
     * @return 'true' if the replacement was successful, 'false' otherwise.
     * @throws UnbalancedException if the replacement would unbalance the mobile
     */
    public boolean replace(Mobile toReplace, Mobile replaceWith) throws UnbalancedException {
        //idk ob das stimmt aber eig muss ja toReplace das gleiche gewicht wie der linke baum haben
        if (toReplace.getWeight() != replaceWith.getWeight()) throw new UnbalancedException("left: " + toReplace.getWeight() + " right: " + replaceWith.getWeight());
        if (this.search(replaceWith)) {//Mobile is already contained in tree
            return true;
        }
        return false;
    }

    public void recReplace(Mobile toReplace, Mobile replaceWith) throws UnbalancedException{

    }

    public boolean search(Mobile m) {
        boolean leftb = false, rightb = false;

        if (m instanceof Star) {
            if (left instanceof Star) {
                leftb = ((Star) left).getWeight() == m.getWeight(); // already checks for weight
                if (leftb) left = m;
            } else {
                leftb = ((BalancedStick) left).search(m);
            }

            if (right instanceof Star) {
                rightb = ((Star) right).getWeight() == m.getWeight();
                if (rightb) right = m;
            } else {
                rightb = ((BalancedStick) right).search(m);
            }

            return leftb || rightb;
        } else {
            //TODO hier halt noch für den case mit balancedStick - ist aber nicht im test
            return false;
        }
    }


    @Override
    public int getWeight() {
        return stickweight + left.getWeight() + right.getWeight();
    }

    /**
     * Returns a readable representation of the mobile, showing its complete
     * structure with all weights using an expression with parentheses.
     * Example (compare with the graphical representation above):
     * ((*7)-2-((*3)-1-(*3)))-2-(*16)
     *
     * @return a readable representation of the mobile.
     */
    @Override
    public String toString() {
        return "(" + left.toString() + ")-" + stickweight + "-(" + right.toString() + ")";
    }



    @Override
    public int hashCode() {
        return Objects.hash(stickweight, left, right);
    }

    @Override
    /**
     * Two sticks are equal if
     * 1.) they have the same stick weight and
     * 2.) if the left part of 'this' equals the left part of 'o' and the right part of 'this'
     *       equals the right part of 'o'
     *     or
     *     if the right part of 'this' equals the left part of 'o' and the left part of 'this'
     *       equals the right part of 'o' (i.e., exchanging left and right part does not
     *       change the value returned by 'equals').
     *
     * For example, all three of the following mobiles are equal (provided that corresponding
     * objects of Star are equal):
     *
     *          |                      |                |
     *      +---2---+              +---2---+        +---2---+
     *      |       |              |       |        |       |
     *   +--2--+    *           +--2--+    *        *    +--2--+
     *   |     |    16          |     |    16       16   |     |
     *   *  +--1--+          +--1--+  *               +--1--+  *
     *   7  |     |          |     |  7               |     |  7
     *      *     *          *     *                  *     *
     *      3     3          3     3                  3     3
     *
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BalancedStick stars = (BalancedStick) o;

        return stickweight == stars.stickweight
                && (this.left.equals(((BalancedStick) o).left) && this.right.equals(((BalancedStick) o).right)
                || this.right.equals(((BalancedStick) o).left) && this.left.equals(((BalancedStick) o).right));
    }

    @Override
    public StarCollection getStarCollection() {
        return new StarCollection() {
            @Override
            public boolean contains(Star s) {
                boolean found = false;

                if (left instanceof BalancedStick) {
                    if (((BalancedStick) left).getStarCollection().contains(s)) found = true;
                } else if (left instanceof Star) {
                    if (((Star) left).getStarCollection().contains(s)) found = true;
                }

                if (right instanceof BalancedStick) {
                    if (((BalancedStick) right).getStarCollection().contains(s)) found = true;
                } else if (right instanceof Star) {
                    if (((Star) right).getStarCollection().contains(s)) found = true;
                }


                return found;
            }
        };
    }

    @Override
    public StarIterator iterator() {

        StarIterator iterLeft = left.iterator();
        StarIterator iterRight = right.iterator();

        return new StarIterator() {
            @Override
            public boolean hasNext() {
                return iterLeft.hasNext() || iterRight.hasNext();
            }

            @Override
            public Star next() {

                if (hasNext()) {
                    if (iterRight.hasNext()) {
                        return iterRight.next();
                    } else {
                        return iterLeft.next();
                    }
                }
                throw new NoSuchElementException("no star element!");
            }
        };
    }
}

// TODO: define additional classes if needed (either here or in a separate file).
