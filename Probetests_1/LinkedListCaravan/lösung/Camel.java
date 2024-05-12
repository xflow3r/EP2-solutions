/**
 * This class represents a camel (animal). A camel has a strength and can walk at a
 * maximum pace (speed) determined by its strength and the load it carries. Load slows down the
 * camel (maximal pace = strength - load).
 * Please, do not change this class definition.
 */
public class Camel {
    private final int strength;
    private int load;


    /**
     * Initializes this camel with its strength and the load its carries.
     * @param strength the strength of this camel, strength > 0.
     * @param load the load this camel carries, load >= 0.
     * Precondition: strength > 0 && load >= 0.
     */
    public Camel(int strength, int load) {

        this.strength = strength;
        this.load = load;
    }

    /**
     * Returns the strength of this camel.
     * @return the strength of this camel.
     */
    public int getStrength() {

        return strength;
    }

    /**
     * Returns the maximum pace of this camel.
     * @return the maximum pace of this camel.
     */
    public int getMaxPace() {

        return strength > load ? strength - load : 0;
    }

    /**
     * Returns the load that this camel is carrying.
     * @return the load that this camel is carrying.
     */
    public int getLoad() {

        return load;
    }

    /**
     * Returns a string representation of this camel in the form (strength-load=maximal pace),
     * for example "(10-3=7)".
     * @return a string representation of this camel.
     */
    @Override
    public String toString() {
        return "(" + strength + "-" + load + "=" + getMaxPace() + ")";
    }
}
