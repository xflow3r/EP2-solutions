package AB3;

import AB1.Vector3;
import AB2.Body;

/**
 * A class used for testing.
 */
public class Test {

    /**
     * The main method.
     * @param args not used.
     */
    public static void main(String[] args) {

        //test classes BodySinglyLinkedList and BodyAccelerationTreeMap


        // create five bodies
        Body sun = new Body(1.989e30, new Vector3(0, 0, 0), new Vector3(0, 0, 0));
        Body earth = new Body(5.972e24, new Vector3(-1.394555e11, 5.103346e10, 0), new Vector3(-10308.53, -28169.38, 0));
        Body mercury = new Body(3.301e23, new Vector3(-5.439054e10, 9.394878e9, 0), new Vector3(-17117.83, -46297.48, -1925.57));
        Body venus = new Body(4.86747e24, new Vector3(-1.707667e10, 1.066132e11, 2.450232e9), new Vector3(-34446.02, -5567.47, 2181.10));
        Body mars = new Body(6.41712e23, new Vector3(-1.010178e11, -2.043939e11, -1.591727E9), new Vector3(20651.98, -10186.67, -2302.79));

        // check basic functions of 'BodySinglyLinkedList'
        System.out.println("Test1:");

        BodySinglyLinkedList bl = new BodySinglyLinkedList();

        bl.addLast(mercury);
        bl.addLast(sun);
        bl.addLast(earth);
        testValue(bl.size(), 3);

        testIdentity(bl.getFirst(), mercury);
        testIdentity(bl.getLast(), earth);

        testIdentity(bl.get(0), mercury);
        testIdentity(bl.get(1), sun);
        testIdentity(bl.get(2), earth);

        System.out.println("Test2:");
        testValue(bl.indexOf(earth), 2);
        testValue(bl.indexOf(sun), 1);
        testValue(bl.indexOf(mercury), 0);

        System.out.println("Test3:");
        testIdentity(bl.pollFirst(), mercury);
        testIdentity(bl.pollLast(), earth);
        testIdentity(bl.pollFirst(), sun);

        testValue(bl.size(), 0);
        testIdentity(bl.getFirst(), null);

        System.out.println("Test4:");
        bl.addFirst(earth);
        bl.addFirst(venus);
        bl.addFirst(sun);
        bl.add(1, mercury);
        bl.add(4, mars);

        testValue(bl.size(), 5);

        testIdentity(bl.get(0), sun);
        testIdentity(bl.get(1), mercury);
        testIdentity(bl.get(2), venus);
        testIdentity(bl.get(3), earth);
        testIdentity(bl.get(4), mars);

        // check constructor of 'BodySinglyLinkedList'
        BodySinglyLinkedList blCopy = new BodySinglyLinkedList(bl);
        testIdentity(bl, blCopy, false);
        testIdentity(bl.pollFirst(), blCopy.pollFirst(), true);
        bl.addFirst(sun);
        testValue(bl.size(), 5);
        testValue(blCopy.size(), 4);

        // check basic functions of 'BodyAccelerationTreeMap'
        System.out.println("Test5:");
        BodyAccelerationTreeMap map = new BodyAccelerationTreeMap();
        map.put(earth, earth.acceleration(sun));
        map.put(sun, sun.acceleration(earth).plus(sun.acceleration(venus)));
        map.put(venus, venus.acceleration(sun));
        map.put(mars, mars.acceleration(sun));
        map.put(mercury, mercury.acceleration(sun));

        testValue(map.get(earth).distanceTo(earth.acceleration(sun)), 0);
        testValue(map.get(sun).distanceTo(sun.acceleration(earth).plus(sun.acceleration(venus))), 0);

        testIdentity(map.containsKey(earth), true);
        Body anotherEarth = new Body(5.972e24, new Vector3(-1.394555e11, 5.103346e10, 0),
                new Vector3(-10308.53, -28169.38, 0));
        testIdentity(map.containsKey(anotherEarth), false);

        testValue(map.put(earth, new Vector3(0, 0, 0)).distanceTo(earth.acceleration(sun)), 0);
        testValue(map.get(earth).distanceTo(new Vector3(0, 0, 0)), 0);
        testValue(map.get(mercury).distanceTo(mercury.acceleration(sun)), 0);


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
}
