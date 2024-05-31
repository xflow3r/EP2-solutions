package AB7;

/**
 * This class represents a comparator based on the distance to an specified
 * reference point.
 */
public class DistanceComparator implements SystemComparator {

    //TODO: object variables and additional methods are private.
    private Vector3 reference;


    /**
     * Initializes this comparator with the reference point.
     *
     * @param reference the reference point.
     */
    public DistanceComparator(Vector3 reference) {
        this.reference = reference;
        //TODO: implement constructor.
    }

    /**
     * Returns the reference point of this comparator.
     *
     * @return the reference point of this comparator.
     */
    public Vector3 getReference() {

        //TODO: implement method.
        return this.reference;
    }

    @Override
    /**
     * Compares its two systems for order based on the distance of their barycenter to the
     * reference point of this comparator. See further details in 'SystemComparator'.
     *
     * @param s1 the first object to be compared.
     * @param s2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the first argument
     * is less than, equal to, or greater than the second.
     */
    public int compare(HierarchicalSystem s1, HierarchicalSystem s2) {
        double distance1 = s1.getCenter().distanceTo(reference);
        double distance2 = s2.getCenter().distanceTo(reference);

        return Double.compare(distance1, distance2);
    }
}
