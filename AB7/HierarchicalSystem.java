package AB7;

import java.util.Deque;

/**
 * A system of celestial bodies bound by gravity (for example like the solar system).
 * A system may consist of multiple subsystems (like the earth-moon system or the system
 * consisting of jupiter and his moons). The simplest system is a single body (like mercury).
 *
 * PLEASE, DO NOT CHANGE THIS FILE!
 */
public interface HierarchicalSystem extends BodyIterable {

    /**
     * Returns the name of this system. The name of a system is the name of the
     * body which is nearest to the system's barycenter.
     *
     * @return the name of this system.
     */
    String getName();

    /**
     * Returns the sum of the masses of all subsystems (i.e. of all bodies contained directly
     * in this system as well as those within any nested subsystems.).
     *
     * @return the sum of the masses of all subsystems in this system.
     */
    double getMass();

    /**
     * Returns the barycenter (center of mass) of this system.
     * The barycenter is computed as the weighted average of the barycenters
     * of all subsystems within this system. Each position is weighted
     * by the mass of the respective subsystem. The returned barycenter is the sum of
     * these weighted positions divided by the total mass of the entire system.
     *
     * @return the barycenter (center of mass) of this hierarchical system.
     */
    Vector3 getCenter();

    /**
     * Returns the radius of the minimal sphere centered at the barycenter
     * of this system that encompasses all celestial bodies within the system.
     * The radius of this sphere is the maximal distance from the
     * barycenter to the furthest surface point of a body within this system.
     * It is the sum of the distance of that body to the barycenter plus its radius.
     *
     * @return the radius of the minimal encompassing sphere centered at the barycenter.
     */
    double getRadius();

    /**
     * Returns the number of bodies within this system. This includes all bodies contained directly
     * in this system as well as those within any nested subsystems.
     *
     * @return the number of bodies within this system.
     */
    int getNumberOfBodies();

    /**
     * Returns an ordered list of all the bodies within this system. The list is ordered ascending
     * according to the comparator specified by 'comp'.
     * @param comp the comparator specifying the order relation of elements in this list,
     *            comp != null.
     * @return an ordered list.
     */
    Deque<Body> asOrderedList(SystemComparator comp);

    @Override
    /**
     * Returns an iterator over elements of type 'Body'. This includes all bodies contained directly
     * in this system as well as those within any nested subsystems.
     * (The order of the iterations is not specified.)
     *
     * @return an iterator over elements of type 'Body'.
     */
    BodyIterator iterator();

    @Override
    /**
     * Returns a readable representation of this system which reflects its hierarchical structure.
     * Every body of this system is represented in a separate line.
     * Subsystems are listed in ascending order based on their distance to the barycenter of
     * this system. The subsystem closest to the barycenter is listed first. Further subsystems
     * are indented by three space characters for each level of hierarchy (indentation and
     * ordering is applied recursively for subsystems within subsystems).
     * For example, the solar system would be represented as:
     *
     * Sun: 1.989E30 kg.
     *    Mercury: 3.301E23 kg.
     *    Venus: 4.86747E24 kg.
     *    Earth: 5.972E24 kg.
     *       Moon: 7.349E22 kg.
     *    Mars: 6.41712E23 kg.
     *       Phobos: 1.08E20 kg.
     *       Deimos: 1.8E20 kg.
     *    Vesta: 2.5908E20 kg.
     *    Ceres: 9.394E20 kg.
     *    Hygiea: 8.32E19 kg.
     *    Pallas: 2.14E20 kg.
     *
     */
    String toString();
}
