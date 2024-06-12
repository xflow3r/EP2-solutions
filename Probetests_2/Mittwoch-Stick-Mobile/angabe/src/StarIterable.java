/**
 * An object with a method that returns a 'StarIterator'.
 * Please, do not change this interface definition!
 */
public interface StarIterable extends Iterable<Star> {

    /**
     * Returns an iterator over 'Star' objects.
     *
     * @return an iterator over 'Star' objects.
     */
    StarIterator iterator();
}
