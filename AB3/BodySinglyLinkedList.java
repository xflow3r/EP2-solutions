package AB3;

import AB2.Body;

import java.util.List;


/**
 * A list of bodies implemented as a singly linked list. The number of elements of the list is
 * not limited.
 */
//
//
public class BodySinglyLinkedList {

    ListNode head;

    /**
     * Initializes 'this' as an empty list.
     */
    public BodySinglyLinkedList() {
        this.head = null;
    }

    /**
     * Constructor: initializes this list as an independent copy of the specified list.
     * Calling methods of this list will not affect the specified list
     * and vice versa.
     *
     * @param list the list from which elements are copied to the new list, list != null.
     */
    public BodySinglyLinkedList(BodySinglyLinkedList list) {
        if (list.head != null) {
            this.head = new ListNode(list.head.getValue(), null);
            ListNode copyCurrent = this.head;
            ListNode originalCurrent = list.head.getNext();

            while (originalCurrent != null) {
                ListNode newNode = new ListNode(originalCurrent.getValue(), null);
                copyCurrent.setNext(newNode);
                copyCurrent = newNode;
                originalCurrent = originalCurrent.getNext();
            }
        }
    }

    /**
     * Inserts the specified element 'b' at the beginning of this list.
     *
     * @param b the body that is added (b can also be 'null').
     */
    public void addFirst(Body b) {
        if (head == null) {
            head = new ListNode(b, null);
        } else {
            ListNode node = new ListNode(b, head);
            head = node;
        }
    }

    /**
     * Appends the specified element 'b' to the end of this list.
     *
     * @param b the body that is added (b can also be 'null').
     */
    public void addLast(Body b) {

        if (head == null) {
            head = new ListNode(b, null);
        } else {
            ListNode node = head;

            while (node.getNext() != null) {
                node = node.getNext();
            }
            node.setNext(new ListNode(b, null));
        }
    }

    /**
     * Returns the last element in this list (at the end of the list) without removing it.
     * Returns 'null' if the list is empty.
     */
    public Body getLast() {
        if (head == null) {
            return null;
        }

        ListNode node = head;
        while (node.getNext() != null) {
            node = node.getNext();
        }

        return node.getValue();
    }

    /**
     * Returns the first element in this list (at the beginning of the list) without removing it.
     * Returns 'null' if the list is empty.
     */
    public Body getFirst() {
        return head == null ? null : head.getValue();
    }

    /**
     * Retrieves and removes the first element in this list, that is, the element with index 0.
     * Indices of subsequent elements are decremented accordingly. Returns 'null' if the list is
     * empty.
     *
     * @return the first element in this list, or 'null' if the list is empty.
     */
    public Body pollFirst() {
        if ( head == null) {
            return null;
        }

        Body b = head.getValue();
        head = head.getNext();

        return b;
    }

    /**
     * Retrieves and removes the last element in this list, that is, the element with the highest
     * index. Returns 'null' if the list is empty.
     *
     * @return the last element in this list, or 'null' if the list is empty.
     */
    public Body pollLast() {

        if (head == null) {
            return null;
        }

        if (head.getNext() == null) {
            Body b = head.getValue();
            head = null;
            return b;
        }


        ListNode node = head;

        while (node.getNext().getNext() != null) {
            node = node.getNext();
        }
        Body b = node.getNext().getValue();
        node.setNext(null);

        return b;
    }

    /**
     * Inserts the specified element at the specified position in this list, such that a
     * following invocation of get(i) would return 'b'. Shifts the element currently at that
     * position (if any) and any subsequent elements to the right (adds one to their indices).
     *
     * @param i the position of the new element in the list, i >= 0 && i <= size().
     * @param b the body that is added (b can also be 'null').
     */
    public void add(int i, Body b) {

        if (head == null || i > size()) return;

        if (i == 0) {
            ListNode insertNode = new ListNode(b, head);
            head = insertNode;
            return;
        }

        ListNode node = head;
        for (int j = 1; j < i; j++) {
            node = node.getNext();
        }

        ListNode insertNode = new ListNode(b, node.getNext());
        node.setNext(insertNode);
    }

    /**
     * Returns the element with the specified index in this list. Returns 'null' if the list is
     * empty.
     *
     * @param i the list index of the element to be retrieved, i >= 0 && i < size().
     * @return the retrieved element at the specified position.
     */
    public Body get(int i) {

        if (head == null || i < 0 || i > size()) return null;
        if (i == size()) return getLast();
        ListNode node = head;

        for (int j = 0; j < i; j++) {
            node = node.getNext();
        }
        return node.getValue();
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list, or -1 if
     * this list does not contain the element. More formally, returns the lowest index i such
     * that b == get(i), or -1 if there is no such index.
     *
     * @param b the body to search for.
     * @return the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     */
    public int indexOf(Body b) {

        ListNode node = head;
        int i = 0;
        while (node != null) {
            if(node.getValue().equals(b)){
                return i;
            }
            node = node.getNext();
            i++;
        }
        return -1;
    }

    /**
     * Returns the number of entries in this list (including 'null' entries).
     */
    public int size() {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.getNext();
        }
        return count;
    }
}

class ListNode {
    private Body value;
    private ListNode next;

    ListNode(Body data, ListNode next) {
        this.value = data;
        this.next = next;
    }

    public Body getValue() {
        return value;
    }

    public void setValue(Body value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}