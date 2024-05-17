package AB5;

import java.util.Iterator;

/**
 * An iterator over elements of type 'IntVar'.
 */
public interface IntVarIterator extends Iterator<IntVar> {

    @Override
    /**
     * Returns 'true' if the iteration has more elements.
     */
    boolean hasNext();

    @Override
    /**
     * Returns the next element of the iteration, or 'null' if the iteration has no more elements.
     * @return the next element of the iteration, or 'null' if the iteration has no more elements.
     */
    IntVar next();
}
