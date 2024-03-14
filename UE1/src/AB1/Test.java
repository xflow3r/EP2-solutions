package AB1;

/**
 * A class used for testing.
 */
public class Test {

    /**
     * The main method.
     * @param args not used.
     */
    public static void main(String[] args) {

        //test classes Body and Vector3

        // create and test a Vector3 object
        Vector3 v = new Vector3(3.0, -1.1, 2.5);
        testValue(v.length(), 4.057092555020159);
        testValue(v.times(2.0).length(), 2*4.057092555020159);
        testValue(v.plus(v).length(), 2*4.057092555020159);
        testValue(v.minus(v).length(), 0.0);
        testEquals(v.toString(), "[3.0, -1.1, 2.5]");

        // create and test two bodies
        Body sun = new Body(1.989e30, new Vector3(0,0,0), new Vector3(0,0,0));
        Body earth = new Body(5.972e24, new Vector3(-1.394555e11,5.103346e10,0),
                new Vector3(-10308.53,-28169.38,0));

        testValue(earth.distanceTo(sun), 1.4850000175024106E11);
        testValue(sun.distanceTo(earth), 1.4850000175024106E11);

        for(int i = 0; i < 3600*24; i++) {
            Vector3 acc1 = earth.acceleration(sun);
            Vector3 acc2 = sun.acceleration(earth);

            earth.accelerate(acc1);
            sun.accelerate(acc2);
        }

        // a dummy body to check the correct position after 24h of movement
        Body targetPositionEarth = new Body(1,
                new Vector3(-1.4032501179629636E11,4.859202671453364E10,0),
                new Vector3(0,0,0));

        // check distance to target position (should be zero)
        testValue(earth.distanceTo(targetPositionEarth), 0);
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
     * @param given the object to be checked.
     * @param expected the expected object.
     */
    public static void testEquals(Object given, Object expected) {
        if (given == expected) {
            System.out.println("Successful test");
            return;
        } else {
            if (given == null) {
                System.out.println("Test NOT successful! Expected value: " +
                        expected +
                        " / Given value: null");
                return;
            }
            if (expected == null) {
                System.out.println("Test NOT successful! Expected value: null / " +
                        "Given value: " + given);
                return;
            }
        }
        if (given.equals(expected)) {
            System.out.println("Successful test");
        } else {
            System.out.println("Test NOT successful! Expected value: " + expected.toString() + " / Given " +
                    "value: " + given.toString());
        }
    }
}
