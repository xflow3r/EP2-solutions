package AB7;

import AB1.Simulation;
import codedraw.CodeDraw;
import codedraw.TextFormat;

import java.awt.*;

/**
 * This class represents a canvas for drawing a hierarchical system of celestial bodies.
 */
public class SpaceDraw {

    private CodeDraw cd;
    private HierarchicalSystem hs;
    private double size;

    /**
     * Initializes this 'SpaceDraw' canvas with the system it represents.
     *
     * @param hs the hierarchical system to be drawn.
     */
    public SpaceDraw(HierarchicalSystem hs) {

        cd = new CodeDraw();
        cd.clear(Color.BLACK);
        cd.setTitle(hs.getName());
        // Set the font with desired size
        TextFormat format = new TextFormat();
        format.setFontSize(10);
        cd.setTextFormat(format);

        this.size = hs.getRadius()*2.5;
        this.hs = hs;
    }

    /**
     * Draws all the bodies of the specified system with the barycenter at the center of the canvas.
     */
    public void draw() {

        cd.clear(Color.BLACK);
        for (Body b: hs) {
            cd.setColor(massToColor(b.getMass()));
            cd.fillCircle(cd.getWidth() * (b.getCenter().getX() - hs.getCenter().getX() + size / 2) / size,
                    cd.getWidth() * (b.getCenter().getY() - hs.getCenter().getY() + size / 2) / size,
                    Math.max(cd.getWidth() * b.getRadius() / size, 1.5));

            // delete if you don't want the names:
            cd.drawText (cd.getWidth() * (b.getCenter().getX() - hs.getCenter().getX() + size / 2) / size + 5,
                    cd.getWidth() * (b.getCenter().getY() - hs.getCenter().getY() + size / 2) / size + 5,
                    b.getName());

        }
        cd.show();
    }

    /**
     * Returns the approximate radius of a celestial body with the specified mass.
     * (It is assumed that the radius r is related to the mass m of the body by
     * r = Math.pow(m, 0.5), where m and r measured in solar units.)
     *
     * @param mass the mass of the body in kg, mass > 0.
     * @return the radius of the body.
     */
    public static double massToRadius(double mass) {

        return AB1.Simulation.SUN_RADIUS * (Math.pow(mass / AB1.Simulation.SUN_MASS, 0.5));
    }

    /**
     * Returns the approximate color of a celestial body with the specified mass. The color of
     * the body corresponds to the temperature of the body, assuming the relation of mass and
     * temperature of a main sequence star.
     *
     * @param mass the mass of the body in kg, mass > 0.
     * @return the color of the body.
     */
    public static Color massToColor(double mass) {
        Color color;
        if (mass < AB1.Simulation.SUN_MASS / 10) {
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
     *
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
     *
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
