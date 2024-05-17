package AB5;

import java.util.NoSuchElementException;

/**
 * This class represents a product of a constant coefficient and a variable (i.e. a linear term).
 */
//
//
public class ConstVarProduct implements IntVarTerm
{

    private IntConst coeff;
    private IntVar var;

    /**
     * Initialized this product of 'coeff' and 'var' (for example 3x is such a product).
     * @param coeff the coefficient of the term which is not 0 or 1,
     *              coeff != null && coeff.isZero() == false &&
     *              coeff.plus(new IntConst(-1)).isZero == false.
     * @param var the variable in the term, var != null.
     */
    public ConstVarProduct(IntConst coeff, IntVar var) {
        this.coeff = coeff;
        this.var = var;
        // TODO: implement constructor.
    }

    @Override
    public IntVarIterator iterator() {
        return new IntVarIterator() {
            private boolean hasReturned = false;
            @Override
            public boolean hasNext() {
                return !hasReturned;
            }

            @Override
            public IntVar next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements");
                }
                hasReturned = true;
                return var;
            }
        };
    }

    @Override
    public IntVar getVar() {
        return this.var;
    }

    @Override
    public IntConst getCoeff() {
        return this.coeff;
    }



    @Override
    public LinearExpression plus(LinearExpression e) { //TODO dont return new?
        if (e instanceof SumOfTerms) {
            return e.plus(this);
        } else if (e instanceof IntVarTerm) {
            if (e instanceof IntVar) {
                if (this.var.equals(e)) {
                    return new ConstVarProduct(this.coeff.plus(((IntVar) e).getCoeff()), this.var);
                } else {
                    return new SumOfTerms(this, (IntVarTerm) e);
                }
            } else if (e instanceof ConstVarProduct) {
                if (this.var.equals(((ConstVarProduct) e).getVar())) {
                    return new ConstVarProduct(this.coeff.plus(((ConstVarProduct) e).getCoeff()), this.var);
                } else {
                    return new SumOfTerms(this, (IntVarTerm) e);
                }
            }
        } else if (e instanceof IntConst) {
            return new SumOfTerms(this, (IntConst) e);
        }

        return new SumOfTerms(this, (IntVarTerm) e);
    }

    @Override
    public LinearExpression negate() {
        return new ConstVarProduct(this.coeff.negate(), this.var);
    }

    @Override
    public LinearExpression times(IntConst c) {
        return new ConstVarProduct(this.coeff.times(c), this.var);
    }

    @Override
    public LinearExpression assignValue(IntVarConstMap varValues) {
        if (varValues.containsKey(this.getVar())) {
            return varValues.get(this.getVar()).times(this.getVar().getCoeff());
        }
        return this;
    }

    @Override
    public String toString() {
        if (coeff.equals(new IntConst(0))) {
            return "0";
        } else if (coeff.equals(new IntConst(1))) {
            return var.toString();
        } else if (coeff.equals(new IntConst(-1))) {
            return "-" + var.toString();
        } else {
            return coeff.toString() + var.toString();
        }
    }
}
