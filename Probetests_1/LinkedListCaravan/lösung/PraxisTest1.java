/**
 * This class can be modified and is for testing your solution.
 * Modifications will NOT be reviewed or assessed.
 */
public class PraxisTest1 {

    /**
     * The main method.
     * @param args not used.
     */
    public static void main(String[] args) {

        Camel c1 = new Camel(10, 2);
        Camel c2 = new Camel(5, 2);
        Camel c3 = new Camel(7, 3);
        Camel c4 = new Camel(12, 3);
        Camel c5 = new Camel(20, 10);
        Camel c6 = new Camel(2, 0);

        System.out.println("Test add method:");
        Caravan l1 = new Caravan();
        l1.addLast(c1);
        l1.addLast(c2);
        l1.addLast(c4);
        l1.addLast(c5);
        l1.addLast(c6);

        System.out.println("Test size method:");
        testValue(l1.size(), 5);

        System.out.println("Test insertBefore method:");
        l1.insertBefore(12, c3);
        testValue(l1.size(), 6);

        System.out.println("Test toString method:");
        testEquals(new Caravan().toString(), "[]");
        testEquals(l1.toString(), "[(10-2=8), (5-2=3), (7-3=4), (12-3=9), (20-10=10), (2-0=2)] pace = 2");


        System.out.println("Test detachFront method with size:");
        Caravan l2 = l1.detachFront(4);
        testValue(l1.size(), 2);
        testValue(l2.size(), 4);

        System.out.println("Test detachFront method with toString:");
        testEquals(l1.toString(), "[(20-10=10), (2-0=2)] pace = 2");
        testEquals(l2.toString(), "[(10-2=8), (5-2=3), (7-3=4), (12-3=9)] pace = 3");

    }

    /**
     * Checks two objects for identity and prints "Successful test" only if given == expected.
     * @param given the given object.
     * @param expected the expected object.
     */
    public static void testIdentical(Object given, Object expected) {
        if (given == expected) {
            System.out.println("Successful test");
        } else {
            System.out.println("Test NOT successful! Expected value: " + expected + " / Given value: " + given);
        }
    }

    /**
     * Checks two objects for identity and prints "Successful test" only if given != expected.
     * @param given the given object.
     * @param notExpected the object that should be different from 'given'.
     */
    public static void testNotIdentical(Object given, Object notExpected) {
        if (given != notExpected) {
            System.out.println("Successful test");
        } else {
            System.out.println("Test NOT successful! Expected value: " + notExpected + " / Given value: " + given);
        }
    }

    /**
     * Compares two objects for equality using the 'equals' method.
     * Prints "successful test" if and only if
     * (given == null ? expected == null : given.equals(expected) == 0)
     * @param given the given rational number.
     * @param expected the rational number to compare 'given' to.
     */
    public static void testEquals(Object given, Object expected) {
        if (given == null ? expected == null : given.equals(expected)) {
            System.out.println("Successful test");
        } else {
            System.out.println("Test NOT successful! Expected value: " + expected + " / Given " +
                    "value: " + given);
        }
    }

    /**
     * Reports a successful test only if and only if the specified boolean value is 'true'.
     * @param expectedTrue the specified boolean value.
     */
    public static void testTrue(boolean expectedTrue) {
        if (expectedTrue) {
            System.out.println("Successful test");
        } else {
            System.out.println("Test NOT successful! Expression should be 'true' but is 'false'.");
        }
    }

    /**
     * Compares two values and prints "Successful test" only if there are equal.
     * @param given the given value to be checked.
     * @param expected the expected value with which 'given' is compared.
     */
    public static void testValue(int given, int expected) {
        if (given == expected) {
            System.out.println("Successful test");
        } else {
            System.out.println("Test NOT successful! Expected value: " + expected + " / Given value: " + given);
        }
    }

}
