package AB2;

import AB2.Body;
import AB1.SpaceDraw;
import AB1.Vector3;
import codedraw.CodeDraw;

import java.awt.*;
import java.util.Random;


/**
 * Simulates a cluster of bodies.
 */
public class Simulation {

    // gravitational constant
    public static final double G = 6.6743e-11;

    // one astronomical unit (AU) is the average distance between earth and sun.
    public static final double AU = 150e9; // meters

    // some further constants needed in the simulation
    public static final double SUN_MASS = 1.989e30; // kilograms
    public static final double SUN_RADIUS = 696340e3; // meters

    // set some system parameters
    public static final int NUMBER_OF_BODIES = 50;
    public static final double OVERALL_SYSTEM_MASS = 30 * SUN_MASS; // kilograms

    // all quantities are based on units of kilogram respectively second and meter.
    /**
     * The main simulation method using instances of other classes.
     * @param args not used.
     */
    public static void main(String[] args) {
        // simulation
        CodeDraw cd = new CodeDraw();
        BodyQueue bodiesQ = new BodyQueue(NUMBER_OF_BODIES);
        BodyAccelerationMap accelerationOfBodyMap = new BodyAccelerationMap(NUMBER_OF_BODIES);

        Random random = new Random(2024);

        for (int i = 0; i < NUMBER_OF_BODIES; i++) {
            bodiesQ.add(new Body(Math.abs(random.nextGaussian()) * OVERALL_SYSTEM_MASS / NUMBER_OF_BODIES,
                    new Vector3(0.2 * random.nextGaussian() * AU, 0.2 * random.nextGaussian() * AU, 0.2 * random.nextGaussian() * AU),
                    new Vector3(random.nextGaussian() * 5e3, random.nextGaussian() * 5e3, random.nextGaussian() * 5e3)));
        }

        double seconds = 0;

        // simulation loop
        while (true) {
            seconds++;

            BodyQueue bodiesQCopy = new BodyQueue(bodiesQ);

            while (bodiesQCopy.size() > 0) {
                Vector3 accleration = new Vector3(0,0,0);
                Body body1 = bodiesQCopy.poll();
                BodyQueue bodyQCopy2 = new BodyQueue(bodiesQ);

                while (bodyQCopy2.size() > 0) {
                    Body body2 = bodyQCopy2.poll();
                    if (body1 != body2) {
                        Vector3 toAdd = body1.acceleration(body2);
                        accleration = accleration.plus(toAdd);
                    }
                }
                accelerationOfBodyMap.put(body1, accleration);
            }

            bodiesQCopy = new BodyQueue(bodiesQ);

            while (bodiesQCopy.size() > 0) {
                Body body1 = bodiesQCopy.poll();
                Vector3 acceleration = accelerationOfBodyMap.get(body1);
                if (acceleration != null) {
                    body1.accelerate(accelerationOfBodyMap.get(body1));
                }
            }

            // show all movements in the canvas only every hour (to speed up the simulation)
            if (seconds % (3600) == 0) {
                // clear old positions (exclude the following line if you want to draw orbits).
                cd.clear(Color.BLACK);
                // draw new positions
                bodiesQCopy = new BodyQueue(bodiesQ);

                while (bodiesQCopy.size() > 0) {
                    Body body1 = bodiesQCopy.poll();
                    body1.draw(cd);
                }
                // show new positions
                cd.show();
            }
        }
    }
}
