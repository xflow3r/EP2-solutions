package AB6;

/**
 * Objects of 'IntVarTerm' represent single linear terms which are products of exactly one variable
 * and one coefficient. For example, 3x is such a term. Also, the variable 'x' is such a term, as
 * it's coefficient is 1.
 */
public interface IntVarTerm extends LinearExpression {

    IntVar getVar();
    IntConst getCoeff();

    /* TODO: uncomment this block
    default LinearExpression plus(IntVarTerm t) {

            if (t.getVar().equals(this.getVar())) {
                IntConst c = t.getCoeff().plus(this.getCoeff());
                if (c.isZero()) {
                    return ZERO;
                }
                if (c.plus(ONE.negate()).isZero()) {
                    return this.getVar();
                }
                return new ConstVarProduct(c, this.getVar());
            }
            return new SumOfTerms(this, t);
    }

    default LinearExpression plus(IntConst c) {

        if (c.isZero()) {
            return this;
        }
        return new SumOfTerms(this, c);
    }

    //TODO: end of block to uncomment */
}
