package AB5;

import java.util.Arrays;

/**
 * A class used for testing.
 */
public class Test {

    /**
     * The main method.
     * @param args not used.
     */
    public static void main(String[] args) {

        System.out.println("Test1:");
        IntVar x = new IntVar("x");
        IntVar y = new IntVar("y");
        IntVar z = new IntVar("z");
        IntConst five = new IntConst(5);
        testEquals(y.toString(), "y");
        testEquals(five.toString(),"5");
        testEquals(five.negate().toString(),"-5");
        testIdentity(five.negate().plus(five).isZero(), true);

        System.out.println("\nTest2:");
        IntVarConstMap values = new IntVarConstHashMap();
        values.put(x, new IntConst(3));
        values.put(y, five);
        values.put(z, new IntConst(-2));
        testIdentity(values.containsKey(x), true);
        testIdentity(values.containsKey(y), true);
        testIdentity(values.containsKey(z), true);
        testIdentity(values.size(), 3);
        testIdentity(values.get(y), five);
        testIdentity(values.remove(y), five);
        testIdentity(values.size(), 2);
        testIdentity(values.remove(y), null);
        testIdentity(values.size(), 2);

        System.out.println("\nTest3:");
        IntVar x1 = new IntVar("x");
        values.put(x1, LinearExpression.ZERO); // same name "x", different variable!
        testIdentity(values.size(), 3);
        testEquals(values.get(x), new IntConst(3));
        testIdentity(values.get(x1), LinearExpression.ZERO);
        values.remove(x1);
        testIdentity(values.size(), 2);

        System.out.println("\nTest4:");


        IntVarIterator iter = x.plus(y).plus(five).iterator();
        IntVar e1, e2;
        testIdentity(iter.hasNext(), true);
        e1 = iter.next();
        testIdentity(iter.hasNext(), true);
        e2 = iter.next();
        testIdentity(iter.hasNext(), false);
        testIdentity(iter.next(), null);
        testIdentity(e1.equals(x) && e2.equals(y) || e1.equals(y) && e2.equals(x), true);



        System.out.println("\nTest5:");
        LinearExpression e = x;
        testEquals(e.toString(), "x");
        testEquals(e.negate().toString(), "-x");
        e = e.plus(e).plus(e);
        testEquals(e.toString().replaceAll("\\s",""), "3x");
        e = e.plus(z.negate());
        testEqualsOne(e.toString().replaceAll("\\s",""),
                new String[]{"3x-z", "-z+3x"});
        e = e.plus(z.negate());
        testEqualsOne(e.toString().replaceAll("\\s",""),
                new String[]{"3x-2z", "-2z+3x"});
        e = e.plus(new IntConst(7));
        testEqualsOne(e.toString().replaceAll("\\s",""),
                new String[]{"3x-2z+7", "-2z+3x+7"});
        e = e.plus(y).plus(y).plus(y).plus(y).plus(y);
        testEqualsOne(e.toString().replaceAll("\\s",""),
                new String[]{"3x+5y-2z+7", "5y+3x-2z+7", "3x-2z+5y+7", "5y-2z+3x+7",
                        "-2z+3x+5y+7", "-2z+5y+3x+7"});
        e = e.plus(y.plus(y).plus(y).plus(y).plus(y).negate());
        testEqualsOne(e.toString().replaceAll("\\s",""),
                new String[]{"3x-2z+7", "-2z+3x+7"});
        LinearExpression zero = e.plus(e.negate());
        testEquals(zero.toString().replaceAll("\\s", ""), "0");
        testEqualsOne(x.plus(x).plus(y.plus(y)).toString().replaceAll("\\s", ""),
                new String[]{"2x+2y", "2y+2x"});
        testEqualsOne(x.plus(x).plus(y.plus(y)).plus(z).toString().replaceAll("\\s", ""),
                new String[]{"2x+2y+z", "2y+2x+z", "z+2y+2x", "z+2x+2y", "2x+z+2y", "2y+z+2x"});
        testEqualsOne(x.plus(y).plus(five).toString(),
                new String[]{"x+y+5", "y+x+5"});

        System.out.println("\nTest6:");
        e.assignValue(values);
        testEquals(e.assignValue(values).toString().replaceAll("\\s", ""), "20");
    }

    /**
     * Checks two objects for identity and prints "Successful comparison" only if
     * (first == second) == expected.
     * @param first the first object.
     * @param second the second object.
     * @param expected the expected value of first == second.
     */
    public static void testIdentity(Object first, Object second, boolean expected) {
        boolean real = first == second;

        if (real == expected) {
            System.out.println("Successful test");
        } else {
            if (real) {
                System.out.println("Comparison NOT successful! " + first + " should not be " +
                        "identical with " + second);
            } else {
                System.out.println("Comparison NOT successful! " + first + " should be " +
                        "identical with " + second);
            }
        }
    }

    /**
     * Checks two objects for identity and prints "Successful test" only if given == expected.
     * @param given the given object.
     * @param expected the expected object.
     */
    public static void testIdentity(Object given, Object expected) {
        testIdentity(given, expected, true);
    }

    /**
     * Checks two values for equality.
     * @param given the value to be checked.
     * @param expected the expected value.
     */
    public static void testValue(double given, double expected) {
        if (given < expected + (expected+1)/1e12 && given > expected - (expected+1)/1e12) {
            System.out.println("Successful test");
        } else {
            System.out.println("Test NOT successful! Expected value: " + expected + " / Given value: " + given);
        }
    }

    /**
     * Checks two objects for equality.
     * @param given the object to be checked, given != null.
     * @param expected the expected object, 'given' is checked for equality to 'expected'.
     */
    public static void testEquals(Object given, Object expected) {
        if (given.equals(expected)) {
            System.out.println("Successful test");
        } else {
            System.out.println("Test NOT successful! Expected object: " + expected + " / Given " +
                    "object: " + given);
        }
    }

    /**
     * Checks if the specified string is equal to at least one of the string in the specified array.
     * @param given the string to be checked.
     * @param expected the array containing valid variations of the expected string.
     */
    public static void testEqualsOne(String given, String[] expected) {
        for (String s : expected) {
            if (given.equals(s)) {
                System.out.println("Successful test");
                return;
            }
        }
        System.out.println("Test NOT successful! Given " + given + " does not match one " +
                "of " + Arrays.toString(expected) + ".");
    }
}