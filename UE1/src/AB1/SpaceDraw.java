package AB1;

import java.awt.*;

/**
 * A class with utility methods.
 */
public class SpaceDraw {

    /**
     * Returns the approximate radius of a celestial body with the specified mass.
     * (It is assumed that the radius r is related to the mass m of the body by
     * r = Math.pow(m, 0.5), where m and r measured in solar units.)
     * @param mass the mass of the body in kg, mass > 0.
     * @return the radius of the body.
     */
    public static double massToRadius(double mass) {

        return Simulation.SUN_RADIUS * (Math.pow(mass / Simulation.SUN_MASS, 0.5));
    }

    /**
     * Returns the approximate color of a celestial body with the specified mass. The color of
     * the body corresponds to the temperature of the body, assuming the relation of mass and
     * temperature of a main sequence star.
     * @param mass the mass of the body in kg, mass > 0.
     * @return the color of the body.
     */
    public static Color massToColor(double mass) {
        Color color;
        if (mass < Simulation.SUN_MASS / 10) {
            // not a star-like body below this mass
            color = Color.LIGHT_GRAY;
        } else {
            // assume a main sequence star
            color = SpaceDraw.kelvinToColor((int) (5500 * mass / Simulation.SUN_MASS));
        }

        return color;
    }

    /**
     * Returns the approximate color of temperature 'kelvin'.
     * @param kelvin the temperature
     * @return the color corresponding to the temperature.
     */
    private static Color kelvinToColor(int kelvin) {

        double k = kelvin / 100D;
        double red = k <= 66 ? 255 : 329.698727446 * Math.pow(k - 60, -0.1332047592);
        double green = k <= 66 ? 99.4708025861 * Math.log(k) - 161.1195681661 : 288.1221695283 * Math.pow(k - 60, -0.0755148492);
        double blue = k >= 66 ? 255 : (k <= 19 ? 0 : 138.5177312231 * Math.log(k - 10) - 305.0447927307);

        return new Color(
                limitAndDarken(red, kelvin),
                limitAndDarken(green, kelvin),
                limitAndDarken(blue, kelvin)
        );
    }

    /**
     * A transformation used in the method 'kelvinToColor'.
     * @param color
     * @param kelvin
     * @return transformation used in the method 'kelvinToColor'.
     */
    private static int limitAndDarken(double color, int kelvin) {

        int kelvinNorm = kelvin - 373;

        if (color < 0 || kelvinNorm < 0) return 0;
        else if (color > 255) return 255;
        else if (kelvinNorm < 500) return (int) ((color / 256D) * (kelvinNorm / 500D) * 256);
        else return (int) color;
    }
}
