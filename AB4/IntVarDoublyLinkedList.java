package AB4;

/**
 * A list of 'IntVar' objects implemented as a doubly linked list. The number of elements of the 
 * list is not limited. The list may also contain entries of 'null'.
 */
//
// TODO: define further classes and methods for the implementation of the doubly linked list, if
//  needed.
//
public class IntVarDoublyLinkedList {

    private ListNode head;
    private ListNode tail;
    /**
     * Initializes 'this' as an empty list.
     */
    public IntVarDoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Inserts the specified element 'v' at the beginning of this list.
     * @param v the variable that is added ('v' can also be 'null').
     */
    public void addFirst(IntVar v) {
        ListNode toInsert = new ListNode(v, head, null);
        if(head != null) {
            head.setPrev(toInsert);
        } else {
            tail = toInsert; // 1 node in List -> head and tail is same
        }
        head = toInsert;
    }

    /**
     * Appends the specified element 'v' to the end of this list.
     * @param v the variable that is added ('v' can also be 'null').
     */
    public void addLast(IntVar v) {
        if (head == null) {
            addFirst(v);
        } else {
            ListNode toInsert = new ListNode(v, null, tail);
            tail.setNext(toInsert);
            tail = toInsert;
        }
    }

    /**
     * Returns the last element in this list (at the end of the list) without removing it.
     * Returns 'null' if the list is empty.
     */
    public IntVar getLast() {
        return tail == null ?  null : tail.getValue();
    }

    /**
     * Returns the first element in this list (at the beginning of the list) without removing it.
     * Returns 'null' if the list is empty.
     */
    public IntVar getFirst() {
        return head == null ?  null : head.getValue();
    }

    /**
     * Retrieves and removes the first element in this list, that is, the element with index 0.
     * Indices of subsequent elements are decremented accordingly. Returns 'null' if the list is
     * empty.
     *
     * @return the first element in this list, or 'null' if the list is empty.
     */
    public IntVar pollFirst() {
        if (head != null) {
            ListNode pollNode = head;
            head = head.getNext();
            if (head != null) {
                head.setPrev(null);
            } else {
                tail = null; // empty list now
            }
            return pollNode.getValue();
        } else {
            return null;
        }
    }

    /**
     * Retrieves and removes the last element in this list, that is, the element with the highest
     * index. Returns 'null' if the list is empty.
     * @return the last element in this list, or 'null' if the list is empty.
     */
    public IntVar pollLast() {
        if (head == null) {
            return null;
        } else if (head.getNext() == null) { //empty list again
            ListNode node = head;
            head = null;
            tail = null;
            return node.getValue();
        }else {
            IntVar value = tail.getValue();
            tail = tail.getPrev();
            tail.setNext(null);
            return value;
        }
    }


    /**
     * Inserts the specified element at the specified position in this list, such that a
     * following invocation of get(i) would return 'v'. Shifts the element currently at that
     * position (if any) and any subsequent elements to the right (adds one to their indices).
     * @param i the position of the new element in the list, i >= 0 && i <= size().
     * @param v the body that is added ('v' can also be 'null').
     */
    public void add(int i, IntVar v) {
        if (i < 0 || i > size()) {
            return;
        }

        if (i == 0) {
            addFirst(v);
            return;
        } else if(i == size()) {
            addLast(v);
            return;
        }



            ListNode node = head;

            for (int j = 0; j < i; j++) {
                node = node.getNext();
            }

            ListNode toInsert = new ListNode(v, node.getNext(), node.getPrev());
            node.setNext(toInsert);
            toInsert.getNext().setPrev(toInsert);


        //TODO: implement method.
    }

    /**
     * Returns the element with the specified index in this list. Returns 'null' if the list is
     * empty.
     * @param i the list index of the element to be retrieved, i >= 0 && i < size().
     * @return the retrieved element at the specified position.
     */
    public IntVar get(int i) {
        if (head == null || i < 0 || i >= size()) {
            return null;
        }
        ListNode node = head;
        for (int j = 0; j < i; j++) {
            node = node.getNext();
        }
        return node.getValue();
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     * @param i the index of the element to be replaced, i >= 0 && i < size().
     * @param v the new element to be set at the specified index ('v' can also be 'null').
     * @return the element that was replaced.
     */
    public IntVar set(int i, IntVar v) {

        ListNode node = head;

        for (int j = 0; j < i; i++) {
            node = node.getNext();
        }
        IntVar value = node.getNext().getValue();
        ListNode toInsert = new ListNode(v, node, node.getNext().getNext());
        node.setNext(toInsert);

        //TODO: implement method.
        return value;
    }

    /**
     * Removes the element at the specified position in this list. Shifts any subsequent
     * elements to the left (subtracts one from their indices). Returns the element that was
     * removed from the list.
     * @param i the index of the element to be removed, i >= 0 && i < size().
     * @return the removed element.
     */
    public IntVar remove(int i) {
        if (i == 0) {
            ListNode toRemove = head;
            head = null;
            return toRemove.getValue();
        }

        ListNode node = head;

        for (int j = 0; j < i-1; j++) {
            node = node.getNext();
        }

        ListNode toRemove = node.getNext();

        node.getNext().getNext().setPrev(node);
        node.setNext(node.getNext().getNext());

        //TODO: implement method.
        return toRemove.getValue();
    }

    /**
     * Returns the index of the last occurrence of the specified element in this list, or -1 if
     * this list does not contain the element. More formally, returns the highest index i such
     * that v == get(i), or -1 if there is no such index.
     * @param v the element to search for ('v' can also be 'null').
     * @return the index of the last occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     */
    public int lastIndexOf(IntVar v) {
        if (head == null) {
            return -1;
        }

        ListNode node = head;
        int index = 1;
        int lastIndexOf = -1;
        while (node.getNext() != null) {
            if (node.getValue() == v) {
                lastIndexOf = index;
            }
            index++;
            node = node.getNext();
        }

        //TODO: implement method.
        return lastIndexOf;
    }

    /**
     * Returns the number of entries in this list (including 'null' entries).
     * @return the number of entries in this list (including 'null' entries).
     */
    public int size() {
        if (head == null) {
            return 0;
        }

        ListNode node = head;
        int size = 1;
        while (node.getNext() != null){
            node = node.getNext();
            size++;
        }
        //TODO: implement method.
        return size;
    }
}

class ListNode {
    private ListNode next, prev;
    private IntVar value;

    ListNode(IntVar value, ListNode next, ListNode prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public IntVar getValue () { return this.value; }
    public ListNode getNext () { return this.next; }
    public ListNode getPrev () { return this.prev; }
    public void setNext ( ListNode n) { this.next = n; }
    public void setPrev ( ListNode n) { this.prev = n; }
    public void setValue (IntVar v) { this.value = v; }

}
// TODO: define further classes, if needed (either here or in a separate file).
