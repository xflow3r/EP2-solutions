package AB4;

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
        IntVarDoublyLinkedList list = new IntVarDoublyLinkedList();
        testValue(list.size(), 0);
        list.addFirst(y);
        list.addFirst(x);
        list.addLast(z);
        list.addLast(z);
        testValue(list.size(), 4);
        testIdentity(list.get(0), x);
        testIdentity(list.get(1), y);
        testIdentity(list.get(2), z);
        testIdentity(list.get(3), z);
        testIdentity(list.getLast(), z);
        testIdentity(list.getFirst(), x);
        testValue(list.lastIndexOf(z), 3);
        testIdentity(list.pollLast(), z);
        testValue(list.size(), 3);
        testIdentity(list.remove(1), y);
        testIdentity(list.pollFirst(), x);
        testIdentity(list.pollFirst(), z);
        testValue(list.size(), 0);

        System.out.println("\nTest2:");
        IntVarConstTreeMap values = new IntVarConstTreeMap();
        values.put(y, five);
        values.put(x, new IntConst(3));
        values.put(z, new IntConst(-2));
        testIdentity(values.containsKey(x), true);
        testIdentity(values.containsKey(y), true);
        testIdentity(values.containsKey(z), true);
        testIdentity(values.get(y), five);
        System.out.println(values.size());




        System.out.println("\nTest3:");
        LinearExpression e = new LinearExpression(x);
        testEquals(e.toString(), "x");
        testEquals(e.negate().toString(), "-x");
        e = e.plus(e).plus(e);
        testEquals(e.toString().replaceAll("\\s",""), "3x");
        e = e.plus(new LinearExpression(z).negate());
        testEquals(e.toString().replaceAll("\\s",""), "3x-z");
        e = e.plus(new LinearExpression(z).negate());
        testEquals(e.toString().replaceAll("\\s",""), "3x-2z");
        e = e.plus(new LinearExpression(new IntConst(7)));
        testEquals(e.toString().replaceAll("\\s",""), "3x-2z+7");
        e = e.plus(y).plus(y).plus(y).plus(y).plus(y);
        testEquals(e.toString().replaceAll("\\s",""), "3x+5y-2z+7");
        e = e.plus(new LinearExpression(y).plus(y).plus(y).plus(y).plus(y).negate());
        testEquals(e.toString().replaceAll("\\s",""), "3x-2z+7");
        LinearExpression zero = e.plus(e.negate());
        testEquals(zero.toString().replaceAll("\\s",""), "0");

        System.out.println("\nTest4:");
        testEquals(e.assignValue(values).toString().replaceAll("\\s",""), "20");

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
     * Checks two objects for identity and prints "Successful comparison" only if given == expected.
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
     * Checks two strings for equality.
     * @param given the string to be checked.
     * @param expected the expected string.
     */
    public static void testEquals(String given, String expected) {
        if (given.equals(expected)) {
            System.out.println("Successful test");
        } else {
            System.out.println("Test NOT successful! Expected value: " + expected + " / Given value: " + given);
        }
    }
}