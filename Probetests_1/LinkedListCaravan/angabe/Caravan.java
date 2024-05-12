/**
 * A caravan of camels implemented as a singly linked list with entries of 'Camel'.
 * There are no 'null' entries in the list.
 */
//
// TODO: define further classes and methods for the implementation of the singly linked list,
//  if needed. Do NOT use the Java-Collection framework in your implementation.
//
public class Caravan {

    //TODO: declare variables.

    /**
     * Initializes this caravan as an empty list.
     */
    public Caravan() {

        //TODO: define constructor.
    }

    /**
     * Adds 'camel' as the last camel to the end of this caravan.
     * @param camel the camel to be added to the end of this caravan, camel != null.
     */
    public void addLast(Camel camel) {

        // TODO: implement method.
    }

    /**
     * Inserts a new camel into this caravan. Seen from the head of the caravan, the camel is
     * inserted just before the first camel in the caravan that has the same strength as the
     * specified 'searchStrength'. If no such camel is found, the new camel is added as the head
     * of the caravan.
     * @param searchStrength the strength of the camel to be found in the caravan.
     * @param camel the camel to be inserted into the caravan, camel != null.
     */
    public void insertBefore(int searchStrength, Camel camel) {

        // TODO: implement method.
    }

    /**
     * Removes 'number' camels from the front of the caravan (the first 'number'
     * camels seen from the head of the caravan) and returns them as a new caravan in which they
     * have the same order as they had in 'this' (see examples in 'PraxisTest1.java'). If this
     * caravan is empty (this.size() == 0) or number == 0 then the result is a new empty caravan.
     * Precondition:
     * @param number the number of camels to be removed from the front of this caravan,
     *               number >= 0 && number <= this.size().
     * @return the detached caravan.
     */
    public Caravan detachFront(int number) {

        // TODO: implement method.
        return null;

    }

    /**
     * Returns the number of camels in the caravan.
     * @return the number of camels in the caravan.
     */
    public int size() {

        //TODO: implement method.
        return -1;
    }

    /**
     * Returns a string representation of this caravan with all its camels in brackets
     * in corresponding order with head of the caravan on the left,
     * followed by the pace of the caravan, which corresponds to the pace of
     * the slowest camel in the caravan.
     * Example: [(10-2=8), (5-2=3), (7-3=4), (10-3=7)] pace = 3
     * Returns "[]" if the caravan is empty.
     * @return the string representation of this caravan.
     */
    public String toString() {

        // TODO: implement method.
        return "";
    }
}

// TODO: define further classes, if needed (either here or in a separate file).
