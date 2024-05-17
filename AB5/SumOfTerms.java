package AB5;

import java.util.NoSuchElementException;

/**
 * This class represents a linear expression consisting of more than one term.
 * For example, 3x - y + 5 consists of multiple terms. 'SumOfTerms' provides an iterator over all
 * variables occurring in 'this'. The order of the iteration is not specified.
 * In this example it iterates over elements 'x' and 'y'. This class implements 'LinearExpression'.
 */
//
// TODO: define further classes, if needed.
//
public class SumOfTerms implements LinearExpression // TODO: uncomment clause.
{

    //TODO: declare variables.
    private IntVarConstHashMap map;
    private IntConst c;


    //TODO: define private constructors as needed.

    /**
     * Initializes 'this' as a sum of two terms, each with a variable.
     * @param t1 the first term in this sum.
     * @param t2 the second term in this sum.
     *          The following conditions holds: t1.getVar().equals(t2.getVar()) == false.
     */
    public SumOfTerms(IntVarTerm t1, IntVarTerm t2) {
        this.map = new IntVarConstHashMap();
        map.put(t1.getVar(), t1.getCoeff());
        map.put(t2.getVar(), t2.getCoeff());
        this.c = new IntConst(0);
    }

    /**
     * Initializes 'this' as a sum of a term with a variable and a constant.
     * @param t the term != null.
     * @param c a constant != null, for which c.isZero() == false.
     */
    public SumOfTerms(IntVarTerm t, IntConst c) {
        this.map = new IntVarConstHashMap();
        this.map.put(t.getVar(), t.getCoeff());
        this.c = c;
    }

    private SumOfTerms(IntVarConstHashMap map, IntConst c) {
        this.map = map;
        this.c = c;
    }


    @Override
    public IntVarIterator iterator() {
        IntVarQueue q = map.keyQueue();
        return new IntVarIterator() {
            @Override
            public boolean hasNext() {
                return q.size() > 0;
            }

            @Override
            public IntVar next() {
                if (hasNext()) {
                    return q.poll();
                }
                return null;
            }
        };
    }

    @Override
    public LinearExpression plus(LinearExpression e) {
        IntVarConstHashMap newMap = new IntVarConstHashMap(this.map);
        IntConst newConst = this.c;

        if (e instanceof SumOfTerms) {
            IntVarIterator iter = ((SumOfTerms) e).iterator();
            while (iter.hasNext()) {
                IntVar current = iter.next();
                IntConst currentCoeff = newMap.get(current);
                IntConst newCoeff = ((SumOfTerms) e).map.get(current);
                newMap.put(current, currentCoeff == null ? newCoeff : currentCoeff.plus(newCoeff));
            }
            newConst = newConst.plus(((SumOfTerms) e).c);
        } else if (e instanceof IntVarTerm) {
            return this.plus((IntVarTerm) e);
        } else if (e instanceof IntConst) {
            return this.plus((IntConst) e);
        }
        return new SumOfTerms(newMap, newConst);
    }

    @Override
    public LinearExpression plus(IntConst c) {
        return new SumOfTerms(this.map, this.c.plus(c));
    }

    @Override
    public LinearExpression plus(IntVarTerm t) {
        IntVarConstHashMap newMap = new IntVarConstHashMap(this.map);
        IntConst currentCoeff = newMap.get(t.getVar());
        newMap.put(t.getVar(), currentCoeff == null ? t.getCoeff() : currentCoeff.plus(t.getCoeff()));
        return new SumOfTerms(newMap, this.c);
    }


    @Override
    public LinearExpression negate() {
        IntVarConstHashMap newMap = new IntVarConstHashMap();
        IntVarIterator iter = this.iterator();
        while (iter.hasNext()) {
            IntVar var = iter.next();
            newMap.put(var, this.map.get(var).negate());
        }
        return new SumOfTerms(newMap, this.c.negate());
    }

    @Override
    public LinearExpression times(IntConst c) {
        IntVarConstHashMap newMap = new IntVarConstHashMap();
        IntVarIterator iter = this.iterator();
        while (iter.hasNext()) {
            IntVar var = iter.next();
            newMap.put(var, this.map.get(var).times(c));
        }
        return new SumOfTerms(newMap, this.c.times(c));
    }

    @Override
    public LinearExpression assignValue(IntVarConstMap varValues) {
        IntVarConstHashMap newMap = new IntVarConstHashMap();
        IntConst newConst = this.c;
        IntVarIterator iter = this.iterator();

        while (iter.hasNext()) {
            IntVar var = iter.next();
            if (varValues.containsKey(var)) {
                newConst = newConst.plus(this.map.get(var).times(varValues.get(var)));
            } else {
                newMap.put(var, this.map.get(var));
            }
        }

        return newMap.size() < 0 ? newConst : new SumOfTerms(newMap, newConst);
    }

    @Override
    public String toString() {
        String s = "";

        IntVarQueue q = map.keyQueue();
        boolean firstEntry = true;
        while (q.size() != 0) {
            IntVar polled = q.poll();

            if (map.get(polled).equals(new IntConst(0))) {

            } else if (map.get(polled).equals(new IntConst(1))){
                if (firstEntry) {
                    s += polled.toString();
                    firstEntry = false;
                } else {
                    s += "+" + polled.toString();
                }
            } else if (map.get(polled).equals(new IntConst(-1))) {
                s += "-" + polled.toString();
            } else {
                if (firstEntry) {
                    s += map.get(polled).toString() + polled.toString();
                    firstEntry = false;
                } else {
                    if (map.get(polled).lessThan(new IntConst(0))) {
                        s += map.get(polled).toString() + polled.toString();
                    } else {
                        s += "+" + map.get(polled).toString() + polled.toString();
                    }

                }
            }
        }

        if (c.equals(new IntConst(0))) {
            if (s.isEmpty()) {
                return "0";
            } else {
                return s;
            }
        } else {
            if (c.lessThan(new IntConst(0))) {
                return s + c.toString();
            } else {
                if (s.isEmpty()) {
                    return c.toString();
                } else {
                    return s + "+" + c.toString();
                }

            }
        }
    }
}