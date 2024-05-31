package AB7;

/**
 * This class represents a comparator based on the mass of a hierarchical system.
 */
public class MassComparator implements SystemComparator {

    @Override
    /**
     * Compares its two systems for order based on their mass. See further details in
     * 'SystemComparator'.
     *
     * @param s1 the first object to be compared.
     * @param s2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the first argument
     * is less than, equal to, or greater than the second.
     */
    public int compare(HierarchicalSystem s1, HierarchicalSystem s2) {
        return Double.compare(s1.getMass(), s2.getMass());
    }
}
