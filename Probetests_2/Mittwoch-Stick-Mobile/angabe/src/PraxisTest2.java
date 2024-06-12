import java.util.NoSuchElementException;

// This class can be modified and is for testing your solution.
// Modifications will NOT be reviewed or assessed.
//
public class PraxisTest2 {

    public static void main(String[] args) {

        //              mobile1|
        //              +------2---+----+
        //            m2|          |    |
        //        +-----2--+--+    *    *
        //        |      m3|  |    12   5
        //        |        |  *
        //        *        |  2
        //        7        |
        //              +--1--+
        //              |     |
        //              *     *
        //              3     3

        /* TODO: uncomment this block.
        try {
            Star star7 = new Star(7);
            Star star3a = new Star(3);
            Star star3b = new Star(3);
            Star star2 = new Star(2);
            Star star12 = new Star(12);
            Star star5 = new Star(5);

            Stick m3 = new Stick(1, new Mobile[]{star3a, star3b});
            Stick m2 = new Stick(2, new Mobile[]{star7, m3, star2});
            Stick m4 = new Stick(2, new Mobile[]{new Star(2), new Star(2)});

            Mobile mobile1, mobile2, mobile3, mobile4, mobile5;
            mobile1 = new Stick(5, new Mobile[]{m2, star12, star5});
            mobile2 = new Stick(2, new Mobile[]{m3, m4});
            mobile3 = new Stick(2, new Mobile[]{new Stick(1, new Mobile[]{star3a, star3b}), m4});
            mobile4 = new Stick(2, new Mobile[]{new Stick(1, new Mobile[]{new Star(3), star3b}), m4});
            mobile5 = new Stick(2, new Mobile[]{m4, new Stick(1, new Mobile[]{star3b, star3a})});

            System.out.println("Test 1: getWeight");
            testEquals(star7.getWeight(), 7);
            testEquals(m2.getWeight(), 18);

            System.out.println("\nTest 2: toString (order is irrelevant)");
            String s0 = mobile1.toString();
            System.out.println("Expected result: \"5[*5, 2[1[*3, *3], *7, *2], *12]\" (but may be in different order)");
            System.out.println("Your result: " + s0);
            testEquals(s0.length(), 32);
            testEquals(s0.startsWith("5["), true);
            testEquals(s0.endsWith("]"), true);
            testEquals(s0.contains("*7"), true);
            testEquals(s0.contains("*2"), true);
            testEquals(s0.contains("*12"), true);

            String s1 = mobile2.toString();
            System.out.println("Expected result: \"2[1[*3, *3], 2[*2, *2]]\" (but may be in different order)");
            System.out.println("Your result: " + s1);
            testEquals(s1.equals("2[1[*3, *3], 2[*2, *2]]") || s1.equals("2[2[*2, *2], 1[*3, *3]]"), true);

            String s2 = mobile3.toString();
            System.out.println("Expected result: \"2[1[*3, *3], 2[*2, *2]]\" (but may be in different order): ");
            System.out.println("Your result: " + s2);
            testEquals(s2.equals("2[1[*3, *3], 2[*2, *2]]") || s2.equals("2[2[*2, *2], 1[*3, *3]]"), true);

            System.out.println("\nTest 3: equals");
            testEquals(mobile1.equals(mobile2), false); // false
            testEquals(m3.equals(new Stick(1, new Mobile[]{star3b, star3a})), true); // true
            testEquals(mobile2.equals(mobile4), false); // false
            testEquals(mobile3.equals(mobile5), true); // true

            System.out.println("\nTest 4: Iterator");
            StarIterator iter = mobile1.iterator();
            String sIter = "";
            while (iter.hasNext()) {
                sIter += iter.next(); //*5*3*3*7*2*12
            }
            // sIter should be like "*5*3*3*7*2*12", but may be in different order
            testEquals(sIter.length(), 13);
            testEquals(sIter.contains("*5"), true);
            sIter = sIter.replaceFirst("\\*5", "");
            testEquals(sIter.contains("*3"), true);
            sIter = sIter.replaceFirst("\\*3", "");
            testEquals(sIter.contains("*3"), true);
            sIter = sIter.replaceFirst("\\*3", "");
            testEquals(sIter.contains("*7"), true);
            sIter = sIter.replaceFirst("\\*7", "");
            testEquals(sIter.contains("*2"), true);
            sIter = sIter.replaceFirst("\\*2", "");
            testEquals(sIter.contains("*12"), true);
            sIter = sIter.replaceFirst("\\*12", "");
            testEquals(sIter.isEmpty(), true);

            System.out.println("\nTest 5: iterator throwing exception");
            try {
                iter.next();
                System.out.println("This message should not be printed!");

            } catch (java.util.NoSuchElementException e) {
                testEquals(e.getMessage(), "no star element!");
            }

            System.out.println("\nTest 6: replace and Countable");
            Countable sc = mobile1.getStickCountable();
            testEquals(sc.count(), 3);
            m2.replace(m3, new Star(7));
            testEquals(sc.count(), 2);

            System.out.println("\nTest 7: StickBreaksException");
            try {
                mobile2 = new Stick(2, new Mobile[]{m2, m4});
                System.out.println("Test NOT successful! This message should not be printed!");
            } catch (StickBreaksException e) {
                testEquals(e.getMessage(), "Stick breaks!");
            }

        } catch (StickBreaksException e) {
            System.out.println("Test NOT successful! This message should not be printed:");
            System.out.println(e.getMessage());
        }
        // TODO: end of block to uncomment. */

    }

    public static void testEquals(Object given, Object expected) {
        if (given.equals(expected)) {
            System.out.println("Successful test");
        } else {
            System.out.println("Test NOT successful! Expected value: " + expected.toString() + " / Given " +
                    "value: " + given.toString());
        }
    }
}
