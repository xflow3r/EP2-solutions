package AB6;

/**
 * This class represents a Boolean negation (NOT).
 */
//
// TODO: define further classes and methods, if needed.
//
public class NOT implements Condition //TODO: uncomment clause.
{
    private Condition c;

    /**
     * Initializes 'this' as the negation 'NOT c'.
     * @param c the operand for the NOT operator, c != null.
     */
    public NOT(Condition c) {
        this.c = c;
    }

    @Override
    public IntVarSet getVarSet() {
        return new IntVarSet() {

            private IntVar[] vars = new IntVar[10]; // initial capacity
            private int size = 0;
            @Override
            public void add(IntVar v) {
                if (!contains(v)) {
                    if (size >= vars.length) {
                        // Resize the array if needed
                        IntVar[] newVars = new IntVar[vars.length * 2];
                        System.arraycopy(vars, 0, newVars, 0, vars.length);
                        vars = newVars;
                    }
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

    @Override
    public boolean getValue(IntVarConstMap assignments) {
        return !c.getValue(assignments);
    }
}