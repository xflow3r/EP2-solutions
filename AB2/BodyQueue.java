package AB2;

/**
 * A queue of bodies. A collection designed for holding bodies prior to processing.
 * The bodies of the queue can be accessed in a FIFO (first-in-first-out) manner,
 * i.e., the body that was first inserted by 'add' is retrieved first by 'poll'.
 * The number of elements of the queue is not limited.
 */
public class BodyQueue {

    private Body[] queue;
    private int head = 0, tail = 0, count = 0;
    /**
     * Initializes this queue with an initial capacity.
     * @param initialCapacity the length of the internal array in the beginning,
     *                        initialCapacity > 0.
     */
    public BodyQueue(int initialCapacity) {
        this.queue = new Body[initialCapacity];
    }

    /**
     * Initializes this queue as an independent copy of the specified queue.
     * Calling methods of this queue will not affect the specified queue
     * and vice versa.
     * @param q the queue from which elements are copied to the new queue, q != null.
     */
    public BodyQueue(BodyQueue q) {
        this.queue = new Body[q.size()];
        for (Body b : q.queue) {
            this.add(b);
        }
        this.head = q.head;
        this.tail = q.tail;
        this.count = q.count;
    }

    /**
     * Adds the specified body 'b' to this queue.
     * @param b the element that is added to the queue.
     */
    public void add(Body b) {
        if (count == queue.length) {
            doubleSize();
        }

        queue[tail] = b;
        tail = (tail+1) % queue.length;
        count++;
    }


    /**
     * doubles size of the Queue
     * @return
     */
    private void doubleSize() {
        Body[] returnQ = new Body[queue.length*2];

        for (int i = 0; i < count; i++) {
            returnQ[i] = this.queue[(head + i) % queue.length];
        }
        this.queue = returnQ;
        head = 0;
        tail = count;
    }


    /**
     * Retrieves and removes the head of this queue,
     * or returns 'null' if this queue is empty.
     * @return the head of this queue (or 'null' if this queue is empty).
     */
    public Body poll() {
        if (count == 0) {
            return null;
        }

        Body result = queue[head];
        queue[head] = null;
        head = (head + 1) % queue.length;
        count--;
        return result;
    }

    /**
     * Returns the number of bodies in this queue.
     * @return the number of bodies in this queue.
     */
    public int size() {
        return count;
    }
}
