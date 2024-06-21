/**
 * This class can be modified and is for testing your solution.
 * Modifications will NOT be reviewed or assessed.
 */
public class PraxisTest2 {

    /**
     * The main method.
     * @param args not used.
     */
    public static void main(String[] args) {

        //                  |
        //              +---2---+
        //            m3|       |m4
        //           +--2--+    *
        //         m1|   m2|    16
        //           *  +--1--+
        //           7  |     |
        //              *     *
        //              3     3

        try {
            Star m1 = new Star(7);
            BalancedStick m2 = new BalancedStick(1, new Star(3), new Star(3));

            BalancedStick m3 = new BalancedStick(2, m1, m2);

            Star m4 = new Star(16);

            Mobile mobile1, mobile2, mobile3;
            mobile1 = new BalancedStick(2, m3, m4);

            mobile2 = new BalancedStick(2, m4, new BalancedStick(2, m2, m1));
            mobile3 = new BalancedStick(2, m4, new BalancedStick(2, new BalancedStick(3, new Star(2), new Star(2)), m1));

            System.out.println("Test 1: 'getWeight'");
            testValue(m1.getWeight(), 7);
            testValue(m2.getWeight(), 7);

            System.out.println("\nTest 2: 'toString'");
            testEquals(mobile1.toString(), "((*7)-2-((*3)-1-(*3)))-2-(*16)");
            testEquals(mobile2.toString(), "(*16)-2-(((*3)-1-(*3))-2-(*7))");
            testEquals(mobile3.toString(), "(*16)-2-(((*2)-3-(*2))-2-(*7))");

            System.out.println("\nTest 3: 'equals'");
            testEquals(mobile1, mobile2);
            testEquals(mobile2.equals(mobile3), false);
            testEquals(m3, new BalancedStick(2, m2, m1));
            testEquals(m3.equals(m2), false);

            System.out.println("\nTest 4: 'iterator'");
            StarIterator iter = mobile1.iterator();
            StringBuilder sb = new StringBuilder();
            while (iter.hasNext()) {
                sb.append(iter.next());
            }
            // sb should be like "*7*3*3*16"; order is irrelevant.
            testEquals(sb.toString().length(), 9);
            testEquals(sb.toString().contains("*7"), true);
            testEquals(sb.toString().contains("*16"), true);
            testEquals(sb.toString().contains("*3"), true);
            testEquals(sb.toString().lastIndexOf("*3")
                    != sb.toString().indexOf("*3"), true);

            System.out.println("\nTest 5: iterator throwing exception");
            try {
                iter.next();
                System.out.println("This message should not be printed!");

            } catch (java.util.NoSuchElementException e) {
                testEquals(e.getMessage(), "no star element!");
            }

            System.out.println("\nTest 6: 'getStarCollection'");
            StarCollection sc = mobile1.getStarCollection();
            testEquals(sc.contains(m1), true);
            testEquals(sc.contains(m4), true);
            sc.contains(new Star(m1.getWeight()));
            testEquals(sc.contains(new Star(m1.getWeight())), false);
            m3.replace(m1, new Star(7));
            testEquals(sc.contains(m1), false);

            System.out.println("\nTest 7:");
            try {
                mobile2 = new BalancedStick(1, m2, m4); // unbalanced! -> Exception
                System.out.println("Test NOT successful! This message should not be printed!");

            } catch (UnbalancedException e) {
                testEquals(e.getMessage(), "Stick unbalanced (left 7 - right 16)");

            }
        } catch (UnbalancedException e) {
            System.out.println("Test NOT successful! This message should not be printed:");
            System.out.println(e.getMessage());

        }
    }


    public static void testEquals(Object given, Object expected) {
        if (given.equals(expected)) {
            System.out.println("Successful test");
        } else {
            System.out.println("Test NOT successful! Expected value: " + expected.toString() + " / Given " +
                    "value: " + given.toString());
        }
    }

    public static void testValue(double given, double expected) {
        if (given < expected + (expected + 1) / 1e12 && given > expected - (expected + 1) / 1e12) {
            System.out.println("Successful test");
        } else {
            System.out.println("Test NOT successful! Expected value: " + expected + " / Given value: " + given);
        }
    }
}
