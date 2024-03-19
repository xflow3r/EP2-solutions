package AB2;

import AB1.Vector3;

/**
 * A class used for testing.
 */
public class Test {

    /**
     * The main method.
     * @param args not used.
     */
    public static void main(String[] args) {

        //test classes BodyQueue and BodyAccelerationMap


        // create three bodies
        Body sun = new Body(1.989e30,new Vector3(0,0,0),new Vector3(0,0,0));
        Body earth = new Body(5.972e24,new Vector3(-1.394555e11,5.103346e10,0),
                new Vector3(-10308.53,-28169.38,0));
        Body mercury = new Body(3.301e23,new Vector3(-5.439054e10,9.394878e9,0),
                new Vector3(-17117.83,-46297.48,-1925.57));

        // check basic functions of 'BodyQueue'
        System.out.println("Test1:");

        BodyQueue bq = new BodyQueue(2);
        bq.add(mercury);
        bq.add(sun);
        bq.add(earth);
        testValue(bq.size(), 3);

        testIdentity(bq.poll(), mercury);
        testIdentity(bq.poll(), sun);
        testIdentity(bq.poll(), earth);

        testValue(bq.size(), 0);

        bq.add(mercury);
        bq.add(sun);
        testValue(bq.size(), 2);

        // check constructor of 'BodyQueue'
        BodyQueue bqCopy = new BodyQueue(bq);
        testIdentity(bq, bqCopy, false);
        testIdentity(bq.poll(), bqCopy.poll(), true);
        bq.add(earth);
        testValue(bq.size(), 2);
        testValue(bqCopy.size(), 1);

        // check basic functions of 'BodyAccelerationMap'
        System.out.println("Test2:");
        BodyAccelerationMap bam = new BodyAccelerationMap(5);
        bam.put(earth, earth.acceleration(sun));
        bam.put(sun, sun.acceleration(earth));

        testValue(bam.get(earth).distanceTo(earth.acceleration(sun)),0);
        testValue(bam.get(sun).distanceTo(sun.acceleration(earth)),0);

        bam.put(earth, new Vector3(0,0,0));
        testValue(bam.get(earth).distanceTo(new Vector3(0,0,0)), 0);
        testIdentity(bam.get(mercury),null);
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
