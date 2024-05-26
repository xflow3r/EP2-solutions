package AB6;

/**
 * This class represents a Boolean OR-combination.
 */
//
// TODO: define further classes and methods, if needed.
//
public class OR implements Condition //TODO: uncomment clause.
{
    //TODO: define missing parts of this class.
    private Condition c1;
    private Condition c2;


    /**
     * Initializes 'this' as the Boolean combination 'c1 OR c2'.
     * @param c1 the first operand, c1 != null.
     * @param c2 the second operand, c2 != null.
     */
    public OR(Condition c1, Condition c2) {
        this.c1 = c1;
        this.c2 = c2;
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
        return c1.getValue(assignments) || c2.getValue(assignments);
    }
}