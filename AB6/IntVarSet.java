package AB6;

/**
 * A set of 'IntVar' elements with no duplicates, i.e., the set does not have
 * elements e1 and e2 for which e1.equals(e2) and no 'null' elements. The set has
 * an iterator over its elements.
 */
public interface IntVarSet extends IntVarIterable {

    /**
     * Adds the specified element 'v' to this set. If 'v' is already contained in this set,
     * the methods has no effect (see method 'contains').
     * @param v the variable that is added, v != null.
     */
    void add(IntVar v);

    /**
     * Returns 'true' if and only if 'v' is contained in this set. More formally, returns
     * 'true' if and only if this set contains an element 'e' such that e.equals(v).
     * (There can be at most one such element.)
     * @param v the element to be checked, v != null.
     * @return 'true' if and only if 'v' is contained in this set.
     */
    boolean contains(IntVar v);

    /**
     * Returns the number of elements in this set.
     * @return the number of elements in this set.
     */
    int size();
}
