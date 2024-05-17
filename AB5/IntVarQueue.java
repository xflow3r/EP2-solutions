package AB5;

/**
 * A queue for 'IntVar' objects. The number of elements of the
 * queue is not limited. The queue may also contain entries of 'null'.
 */
public class IntVarQueue {

    private ListNode head;
    private ListNode tail;
    private int size;

    /**
     * Initializes 'this' as an empty list.
     */
    public IntVarQueue() {}

    /**
     * Adds the specified element 'v' to this queue.
     * @param v the variable that is added ('v' can also be 'null').
     */
    public void add(IntVar v) {

        if (head == null) {
            head = tail = new ListNode(v, null);
        } else {
            tail.setNext(new ListNode(v, null));
            tail = tail.getNext();
        }
        size++;
    }

    /**
     * Retrieves and removes an element from this queue. Returns 'null' if the list is empty.
     * @return the next element in this queue, or 'null' if the queue is empty.
     */
    public IntVar poll() {

        if (head == null) {
            return null;
        }
        IntVar toReturn = head.getElem();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        size--;
        return toReturn;
    }

    /**
     * Returns the number of entries in this queue (including 'null' entries).
     * @return the number of entries in this queue (including 'null' entries).
     */
    public int size() {

        return size;
    }
}

class ListNode {
    private IntVar elem;
    private ListNode next;

    ListNode(IntVar b, ListNode next) {
        this.elem = b;
        this.next = next;
    }

    IntVar getElem() {
        return elem;
    }

    public ListNode getNext() {
        return next;
    }

    void setNext(ListNode node) {
        next = node;
    }
}
