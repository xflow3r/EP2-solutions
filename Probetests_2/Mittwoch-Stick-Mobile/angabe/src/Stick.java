import java.util.*;

/**
 * A 'Stick' has a specified stick weight, that can not be changed after
 * initialisation. Mobiles can be attached to the stick (recursive structure).
 * 'Stick' implements 'Mobile'.
 * You can assume that no part of a mobile has the same identity as another part.
 */
//
// TODO: Complete the methods in 'Stick'.
//       You can define further classes and methods for the implementation.
//       You may use the Java-Collection framework.
//
public class Stick // implements Mobile // TODO: uncomment clause.
{

    //TODO: define missing parts of the class.

    /**
     * Initialises 'this'; throws an 'StickBreaksException' if the sum of the weight of
     * all mobiles in the array 'attached' is greater than 10 times the 'stickWeight'.
     * The detail message of the exception is "Stick breaks!".
     *
     * @param stickWeight the weight of this stick (without attached mobiles), stickWeight > 0.
     * @param attached an array with all the mobiles directly attached to this stick.
     *      Precondition: attached != null && attached.length > 0 and for any two mobiles m1 and m2
     *      being part of 'attached' (including sub-mobiles) it holds that
     *      m1.equals(m2) == false, this is, there are no duplicates anywhere in a mobile.
     * @throws StickBreaksException if the sum of the weight of all mobiles in the array
     *        'attached' is greater than 10 times the 'stickWeight'.
     */
    public Stick(int stickWeight, Mobile[] attached) throws StickBreaksException {

        // TODO: implement constructor.
    }

    /**
     * Replaces the mobile equal to 'toReplace' with a new mobile 'replaceWith' if this mobile
     * is directly attached to this stick (no recursive search). In this case 'true' is returned.
     * Otherwise, the call of this method has no effect and 'false' is returned.
     * Throws a 'StickBreaksException' if the replacement would violate the
     * condition that the sum of the weight of all attached mobiles has to be
     * less than or equal to 10 times its stick weight.
     *
     * @param toReplace the mobile to be replaced, toReplace != null.
     * @param replaceWith the new mobile to replace with, replaceWith != null.
     * @return 'true' if the replacement was successful, 'false' otherwise.
     * @throws StickBreaksException if the replacement would violate the
     *        condition that the sum of the weight of all attached mobiles has to be
     *        less than or equal to 10 times its stick weight.
     */
    public boolean replace(Mobile toReplace, Mobile replaceWith) throws StickBreaksException {

        // TODO: implement method.
        return false;
    }

    /**
     * Returns 'true' if 'o' is also of class 'Stick', has an equal stick weight, and has
     * equal mobiles attached, regardless of their order. This means that 'this' and 'o' have the
     * same number of mobiles attached and every mobile attached to 'this' is equal to a mobile
     * attached to 'o' (and vice versa).
     * Otherwise, 'false' is returned.
     *
     * @param o the other object to compare with.
     * @return 'true' if 'this' and 'o' are equal and 'false' otherwise.
     */
    @Override
    public boolean equals(Object o) {

        // TODO: implement method.
        return false;
    }
}

// TODO: define additional classes if needed (either here or in a separate file).