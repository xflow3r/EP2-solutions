package AB7;

/**
 * An object providing an iterator over its 'Body' elements.
 *
 * PLEASE, DO NOT CHANGE THIS FILE!
 */
public interface BodyIterable extends Iterable<Body> {

    /**
     * Returns an iterator over elements of type 'Body'.
     *
     * @return an iterator over elements of type 'Body'.
     */
    public BodyIterator iterator();
}
