package AB6;

/**
 * This class represents IS EQUAL condition. It represents the constraint that
 * two expressions are equal when their variables are assigned to specific values
 * (using the same variable assignments in both expressions).
 */
//
// TODO: define further classes and methods, if needed.
//
public class IsEqual implements Condition //TODO: uncomment clause.
{
    //TODO: define missing parts of this class.
    private LinearExpression e1;
    private LinearExpression e2;
    /**
     * Initializes 'this' with two linear expressions.
     * @param e1 the first expression, e1 != null.
     * @param e2 the second expression, e2 != null.
     */
    public IsEqual(LinearExpression e1, LinearExpression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public IntVarSet getVarSet() {
        IntVarSet set = new IntVarSet() {

            private IntVar[] vars = new IntVar[20];
            private int size = 0;
            @Override
            public void add(IntVar v) {
                if (!contains(v)) {
                    vars[size] = v;
                    size++;
                }
            }

            @Override
            public boolean contains(IntVar v) {
                for (int i = 0; i < size; i++) {
                    if (vars[i] != null) {
                        if (vars[i].equals(v)) {
                            return true;
                        }
                    }
                }
                return false;
            }

            @Override
            public int size() {
                return size;
            }

            private void populateSet() {
                IntVarIterator iter1 = e1.iterator();
                IntVarIterator iter2 = e2.iterator();

                while (iter1.hasNext()) {
                    add(iter1.next());
                }

                while (iter2.hasNext()) {
                    add(iter2.next());
                }
            }

            {
                populateSet();
            }

            @Override
            public IntVarIterator iterator() {
                /*
                IntVarIterator iter1 = e1.iterator();
                IntVarIterator iter2 = e2.iterator();

                while (iter1.hasNext()) {
                    add(iter1.next());
                }

                while (iter2.hasNext()) {
                    add(iter2.next());
                }
                System.out.println(size);

                 */
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
        return set;
    }

    /**
     * Returns e1.assignValue(assignments).equals(e2.assignValue(assignments)).
     * @param assignments the map with variable assignments, assignments != null.
     * @return e1.assignValue(assignments).equals(e2.assignValue(assignments)).
     */
    @Override
    public boolean getValue(IntVarConstMap assignments) {
        return e1.assignValue(assignments).equals(e2.assignValue(assignments));
    }
}
