package AB6;

/**
 * This class represents a solver for constrained combinatorial problems involving
 * primary conditions and additional conditions (constraints) composed of 'LinearExpression'
 * objects.
 */

public class Solver {

    public static final int[] VARIABLE_DOMAIN = new int[]{0, 9};
    private Condition constraints, primary;

    /**
     * Initializes this solver with its primary condition ('goal') and additional constraints,
     * that must be fulfilled by the solution.
     * @param goal the fundamental linear equation that must be fulfilled for the solution
     *             to be valid, for example, the equation SEND + MORE = MONEY in which all letters
     *             correspond to variables.
     * @param constraints the additional constraints that must be followed but do not dictate the
     *                    linear relationship, for example, the constraint that all variables
     *                    must take on different values.
     */
    public Solver(Condition goal, Condition constraints) {

        this.constraints = constraints;
        this.primary = goal;
    }

    /**
     * Finds the solution, if it exists, and returns the map with all mappings from variables
     * to the values of the solution. In the example SEND+MORE=MONEY the mapping with the
     * solution is [D=7, E=5, M=1, N=6, O=0, R=8, S=9, Y=2].
     */
    public IntVarConstMap solve() {

        IntVarSet varSet = primary.getVarSet();
        IntVar[] varArray = new IntVar[varSet.size()];
        int i = 0;
        for(IntVar v: varSet) {
            varArray[i++] = v;
        }
        IntVarConstMap assignments = new IntVarConstTreeMap();
        solve(varArray, 0, assignments);
        return assignments;
    }

    /**
     * A private recursive method performing backtracking to find the solution.
     * @param vars an array with all variables of the 'goal' condition.
     * @param index the position in 'vars'.
     * @param assignments the map with the assignments of values for each variable.
     * @return 'true' if a solution was found.
     */
    private boolean solve(IntVar[] vars, int index, IntVarConstMap assignments) {
        //System.out.println("solver call");
        //System.out.println(vars.length + " " + index);
        if (index == vars.length) {
            if (primary.getValue(assignments)) {
                System.out.println("Solution found: " + assignments);
                return true;
            }
            return false;
        }

        for (int digit = VARIABLE_DOMAIN[0]; digit <= VARIABLE_DOMAIN[1]; digit++) {
            assignments.put(vars[index], new IntConst(digit));
            if (constraints.getValue(assignments)) {
                if (solve(vars, index + 1, assignments)) return true;
            }
            assignments.remove(vars[index]); // backtracking!
        }
        return false;
    }

    /**
     * Test the solver.
     * @param args not used.
     */
    public static void main(String[] args) {

        /*
        Testing the solver for the problem:

            SEND
           +MORE=
           -----
           MONEY

         The values of the following variables have to be found: S, E, N, D, M, O, R, Y,
         subject to constraints:
         1.) All values must be different from each other,
         2.) S != 0, M != 0 (no leading zeros allowed).
         */

        IntVar S = new IntVar("S");
        IntVar E = new IntVar("E");
        IntVar N = new IntVar("N");
        IntVar D = new IntVar("D");
        IntVar M = new IntVar("M");
        IntVar O = new IntVar("O");
        IntVar R = new IntVar("R");
        IntVar Y = new IntVar("Y");

        IntConst thousand = new IntConst(1000);
        IntConst hundred = new IntConst(100);
        IntConst ten = new IntConst(10);

        LinearExpression sendMore =
                S.times(thousand).plus(E.times(hundred)).plus(N.times(ten)).plus(D);

        System.out.println(sendMore); // should be 1000S + 100E + 10N + D

        sendMore = sendMore.plus(M.times(thousand).plus(O.times(hundred)).plus(R.times(ten)).plus(E));

        System.out.println("sendMore"); // 1000S + 101E + 10N + D + 1000M + 100O + 10R
        System.out.println(sendMore); // 1000S + 101E + 10N + D + 1000M + 100O + 10R

        LinearExpression money =
                M.times(ten.times(thousand)).plus(O.times(thousand)).plus(N.times(hundred)).plus(E.times(ten)).plus(Y);

        System.out.println("money"); // M*(10.000 + 1000 O + 100N + 10E + Y)
        System.out.println(money); // M*(10.000 + 1000 O + 100N + 10E + Y)




        Condition sendMoreMoneyEquation = new IsEqual(sendMore, money);


        IntVarSet v = sendMoreMoneyEquation.getVarSet();

        Condition allDifferent = new AllDifferent(sendMoreMoneyEquation.getVarSet());
        Condition leadingZeros = new IsEqual(S, LinearExpression.ZERO).or(new IsEqual(M,
                LinearExpression.ZERO));

        // Create the solver object with the SEND+MORE=MONEY conditions


        Solver solver = new Solver(sendMoreMoneyEquation, allDifferent.and(leadingZeros.not()));


        // Solve the problem
        IntVarConstMap solution = solver.solve();

        // Print the solution once again
        System.out.println(solution);

    }
}
