package AB6;

/**
 * This class represents an ALL DIFFERENT condition.
 */
//
// TODO: define further classes and methods, if needed.
//
public class AllDifferent implements Condition //TODO: uncomment clause.
{

    //TODO: define missing parts of this class.
    private IntVarSet set;
    /**
     * Initializes this 'AllDifferent' constraint object.
     *
     * @param set a set of variables which are required to have unique values
     *            across them. This set defines the scope of the constraint.
     */
    public AllDifferent(IntVarSet set) {
        this.set = set;
    }

    @Override
    public IntVarSet getVarSet() {
        return new IntVarSet() {

            private IntVar[] vars = new IntVar[10]; // initial capacity
            private int size = 0;
            @Override
            public void add(IntVar v) {
                if (!contains(v)) {
                    vars[size++] = v;
                }
            }

            @Override
            public boolean contains(IntVar v) {
                for (int i = 0; i < size; i++) {
                    if (vars[i].equals(v)) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public int size() {
                return size;
            }

            @Override
            public IntVarIterator iterator() {
                IntVarIterator iter = set.iterator();

                while (iter.hasNext()) {
                    add(iter.next());
                }

                // add everything from set with add
                return new IntVarIterator() {

                    private int index = 0;
                    @Override
                    public boolean hasNext() {
                        return index < size;
                    }

                    @Override
                    public IntVar next() {
                        if (!hasNext()) {
                            return null;
                        }
                        return vars[index++];
                    }
                };
            }
        };
    }

    /**
     * Evaluates the condition based on current assignments.
     *
     * This method checks if the values assigned to the variables in the intersection
     * of this condition's variable set and the keys of the provided map are all unique.
     * Only variables that are both in the internal set and the key set of 'assignments'
     * are considered in the evaluation (all other variables are not considered when checking the
     * condition).
     *
     * @param assignments A map (IntVarConstMap) where keys are variables and values are their
     *                    assigned integer values. This map contains current assignments that
     *                    may or may not fully cover all variables in the problem.
     * @return true, if all considered variables have unique values, false otherwise.
     */
    public boolean getValue(IntVarConstMap assignments) {
        IntConst[] uniqueValues = new IntConst[this.set.size()];
        int count = 0;

        for (IntVar var : assignments.keySet()) {
            if (set.contains(var)) {
                IntConst value = assignments.get(var);

                boolean isDuplicate = false;
                for (int i = 0; i < count; i++) {
                    if (uniqueValues[i].equals(value)) {
                        isDuplicate = true;
                        break;
                    }
                }

                if (isDuplicate) {
                    return false;
                }

                uniqueValues[count++] = value;
            }
        }
        return true;
    }
}
