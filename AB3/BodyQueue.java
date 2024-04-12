package AB3;

import AB2.Body;

/**
 * A queue of bodies. A collection designed for holding bodies prior to processing.
 * The bodies of the queue can be accessed in a FIFO (first-in-first-out) manner,
 * i.e., the body that was first inserted by 'add' is retrieved first by 'poll'.
 * The number of elements of the queue is not limited.
 */
public class BodyQueue {

    // uses a 'BodySinglyLinkedList' object.
    private BodySinglyLinkedList list = new BodySinglyLinkedList();

    /**
     * Constructor: initializes 'this' as an empty queue.
     */
    public BodyQueue() {}

    /**
     * Constructor: initializes this queue as an independent copy of the specified queue.
     * Calling methods of this queue will not affect the specified queue
     * and vice versa.
     *
     * @param queue the queue from which elements are copied to the new queue, queue != null.
     */
    public BodyQueue(BodyQueue queue) {

        this.list = new BodySinglyLinkedList(queue.list);
    }

    /**
     * Retrieves and removes the head of this queue,
     * or returns 'null' if this queue is empty.
     * @return the head of this queue (or 'null' if this queue is empty).
     */
    public Body poll() {

        return list.pollFirst();
    }

    /**
     * Adds the specified body 'b' to this queue.
     * @param b the element that is added to the queue (b can also be 'null').
     */
    public void add(Body b) {

        list.addLast(b);
    }

    /**
     * Returns the number of bodies in this queue.
     * @return the number of bodies in this queue.
     */
    public int size() {

        return list.size();
    }
}
