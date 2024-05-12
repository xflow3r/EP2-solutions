import java.util.List;

/**
 * A caravan of camels implemented as a singly linked list with entries of 'Camel'.
 * There are no 'null' entries in the list.
 */
//
// TODO: define further classes and methods for the implementation of the singly linked list,
//  if needed. Do NOT use the Java-Collection framework in your implementation.
//
public class Caravan {

    private ListNode head;
    /**
     * Initializes this caravan as an empty list.
     */
    public Caravan() {
        this.head = null;
    }

    /**
     * Adds 'camel' as the last camel to the end of this caravan.
     * @param camel the camel to be added to the end of this caravan, camel != null.
     */
    public void addLast(Camel camel) {
        if (head == null) {
            head = new ListNode(camel, null);
        } else {
            ListNode node = head;

            while (node.getNext() != null) {
                node = node.getNext();
            }
            node.setNext(new ListNode(camel, null));
        }
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

        if (head == null) {
            head = new ListNode(camel, null);
        } else {
            ListNode node = head;

            while (node.getNext() != null) {
                if (node.getNext().getData().getStrength() == searchStrength) {
                    ListNode afterInsertNode = node.getNext();
                    node.setNext(new ListNode(camel, afterInsertNode));
                    return;
                }
                node = node.getNext();
            }
        }
        // here if no camel was found
        ListNode toInsert = new ListNode(camel, head);
        head = toInsert;
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
        Caravan newCaravan = new Caravan();

        if (head == null) {
            return newCaravan;
        } else {
            ListNode node = head;
            int counter = 0;

            while (node != null && counter < number) {
                newCaravan.addLast(node.getData());
                node = node.getNext();
                counter += 1;
            }

            head = node;
            return newCaravan;

        }
    }

    /**
     * Returns the number of camels in the caravan.
     * @return the number of camels in the caravan.
     */
    public int size() {
        if (head == null) {
            return 0;
        } else {
            ListNode node = head;
            int counter = 0;
            while (node != null) {
                counter += 1;
                node = node.getNext();
            }
            return counter;
        }
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

        String s = "[";
        if (head != null) {
            ListNode node = head;
            int slowestPace = node.getData().getMaxPace();
            while (node != null) {
                s += node.getData().toString() + ", ";
                if (slowestPace > node.getData().getMaxPace()) {
                    slowestPace = node.getData().getMaxPace();
                }
                node = node.getNext();
            }
            return s.substring(0, s.length()-2) + "] pace = " + slowestPace;
        }
        return s + "]";
    }
}

class ListNode {
    private Camel data;
    private ListNode next;

    public ListNode(Camel data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public Camel getData() {
        return data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}