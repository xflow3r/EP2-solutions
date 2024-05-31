package AB7;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.NoSuchElementException;

/**
 * A class used for testing.
 */
public class Test {

    /**
     * The main method.
     * @param args not used.
     */
    public static void main(String[] args) {



        // create solar system with 12 bodies
        Body sun = new Body("Sun", 1.989E30,
                new Vector3(0.0, 0.0, 0.0), new Vector3(0.0, 0.0, 0.0));
        Body earth = new Body("Earth", 5.972E24,
                new Vector3(-6.13135922534815E10, -1.383789852227691E11, 2.719682263474911E7),
                new Vector3(26832.720535473603, -11948.23168764519, 1.9948243075997851));
        Body moon = new Body("Moon", 7.349E22,
                new Vector3(-6.132484773775896E10, -1.387394951280871E11, 1.701046736294776E7),
                new Vector3(27916.62329282941, -12020.39526008238, -94.89703264508708));
        Body mars = new Body("Mars", 6.41712E23,
                new Vector3(-1.7923193702925848E11, 1.726665823982123E11, 7.991673845249474E9),
                new Vector3(-15925.78496403673, -15381.16179928219, 68.67560910598857));
        Body deimos = new Body("Deimos", 1.8E20,
                new Vector3(-1.792255010450533E11, 1.726891122683271E11, 7.990659337380297E9),
                new Vector3(-17100.476719804457, -15020.348656808, 631.2927851249581));
        Body phobos = new Body("Phobos", 1.08E20,
                new Vector3(-1.792253482539647E11, 1.72661109673625E11, 7.987848354800322E9),
                new Vector3(-14738.203714241401, -13671.17675223948, -411.0012490555253));
        Body mercury = new Body("Mercury", 3.301E23,
                new Vector3(-5.167375560011926E10, -4.217574885682655E10, 1.14808913958168E9),
                new Vector3(21580.25398577148, -34951.03632847389, -4835.225596525241));
        Body venus = new Body("Venus", 4.86747E24,
                new Vector3(-3.123150865740532E10, 1.0395568504115701E11, 3.173401325838074E9),
                new Vector3(-33748.180519629335, -10014.25141045021, 1809.94488874165));
        Body vesta = new Body("Vesta", 2.5908E20,
                new Vector3(-3.337493557929893E11, -4.7147908276077385E10, 4.1923010146878105E10),
                new Vector3(4440.54247538484, -19718.49074006637, 48.06573124543601));
        Body pallas = new Body("Pallas", 2.14E20,
                new Vector3(4.3452066613895575E11, -2.057319365171432E11, 1.0549957423213101E11),
                new Vector3(5058.947582097117, 11184.45711782372, -8183.524138259704));
        Body hygiea = new Body("Hygiea", 8.32E19,
                new Vector3(-3.983943433707043E11, 2.325833000024021E11, -2.233667695713672E10),
                new Vector3(-6931.864585548552, -15686.8108598699, -690.5791992347208));
        Body ceres = new Body("Ceres", 9.394E20,
                new Vector3(3.781372641419032E11, 1.96718960466285E11, -6.366459168068592E10),
                new Vector3(-8555.324226752316, 14718.33755980907, 2040.230135060142));
        HierarchicalSystem marsSystem = new MultiBody(mars,
                deimos, phobos);
        HierarchicalSystem earthSystem = new MultiBody(earth, moon);
        HierarchicalSystem solarSystem = new MultiBody(sun, marsSystem,
                earthSystem, mercury, venus, vesta, pallas, hygiea, ceres);

        String targetMars =
                "Mars: 6.41712E23 kg.\n" +
                "   Phobos: 1.08E20 kg.\n" +
                "   Deimos: 1.8E20 kg.";

        String targetSolar =
                "Sun: 1.989E30 kg.\n" +
                "   Mercury: 3.301E23 kg.\n" +
                "   Venus: 4.86747E24 kg.\n" +
                "   Earth: 5.972E24 kg.\n" +
                "      Moon: 7.349E22 kg.\n" +
                "   Mars: 6.41712E23 kg.\n" +
                "      Phobos: 1.08E20 kg.\n" +
                "      Deimos: 1.8E20 kg.\n" +
                "   Vesta: 2.5908E20 kg.\n" +
                "   Ceres: 9.394E20 kg.\n" +
                "   Hygiea: 8.32E19 kg.\n" +
                "   Pallas: 2.14E20 kg.";

        System.out.println("\nTest 'toString':");
        testEquals(marsSystem.toString().trim(), targetMars.trim());
        testEquals(solarSystem.toString().trim(), targetSolar.trim());

        System.out.println("\nTest 'getRadius':");
        testValue(earthSystem.getRadius(), 3.565769243005397E8);
        testValue(solarSystem.getRadius(), 4.922034555877454E11);

        System.out.println("\nTest 'getMass':");
        testValue(earthSystem.getMass(), earth.getMass() + moon.getMass());
        testValue(solarSystem.getMass(), 1.9890118865556799E30);

        System.out.println("\nTest 'getCenter':");
        testEquals(earthSystem.getCenter().distanceTo(earth.getCenter()), 4386303.00354618);
        testEquals(solarSystem.getCenter().distanceTo(sun.getCenter()),349528.73796885146 );

        System.out.println("\nTest 'getNumberOfBodies':");
        testValue(earthSystem.getNumberOfBodies(), 2);
        testValue(solarSystem.getNumberOfBodies(), 12);
        testValue(earth.getNumberOfBodies(), 1);

        System.out.println("\nTest 'asOrderedList' with 'MassComparator':");
        Deque<Body> list = marsSystem.asOrderedList(new MassComparator());
        testEquals(list.pollFirst(), phobos);
        testEquals(list.pollFirst(), deimos);
        testEquals(list.pollFirst(), mars);

        list = solarSystem.asOrderedList(new MassComparator());
        testEquals(list.pollFirst(), hygiea);
        testEquals(list.pollFirst(), phobos);
        testEquals(list.pollLast(), sun);
        testEquals(list.pollLast(), earth);

        System.out.println("\nTest 'iterator':");
        int count = 0;
        HashSet<Body> set = new HashSet<>();
        BodyIterator iterator = solarSystem.iterator();
        while(iterator.hasNext()) {
            count++;
            set.add(iterator.next());
        }
        testValue(set.size(), 12);
        testValue(count, 12);

        try {
            iterator.next();
            System.out.println("Test NOT sucessful! Statement should not be reached!");
        } catch (NoSuchElementException e) {
            System.out.println("Successful test");
        }

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
}
