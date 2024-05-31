package AB7;

import java.util.Comparator;

/**
 * A class representing comparator objects.
 *
 * PLEASE, DO NOT CHANGE THIS FILE!
 */
public interface SystemComparator extends Comparator<HierarchicalSystem> {

    /**
     * Compares its two systems for order. Returns a negative integer, zero, or a positive integer
     * as the first argument is less than, equal to, or greater than the second.
     * In the foregoing description, the notation sgn(expression) designates the mathematical
     * signum function, which is defined to return one of -1, 0, or 1 according to whether the
     * value of expression is negative, zero or positive.
     *
     * The implementor must ensure that sgn(compare(x, y)) == -sgn(compare(y, x)) for
     * all x and y. (This implies that compare(x, y) must throw an exception if and only
     * if compare(y, x) throws an exception.)
     *
     * The implementor must also ensure that the relation is transitive:
     * ((compare(x, y)>0) && (compare(y, z)>0)) implies compare(x, z)>0.
     *
     * Finally, the implementor must ensure that compare(x, y)==0 implies that
     * sgn(compare(x, z))==sgn(compare(y, z)) for all z.
     *
     * @param s1 the first object to be compared.
     * @param s2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the first argument
     * is less than, equal to, or greater than the second.
     */
    int compare(HierarchicalSystem s1, HierarchicalSystem s2);
}
