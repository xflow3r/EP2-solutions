package AB7;

import java.util.*;

/**
 * Represents a hierarchical system consisting of more than one subsystem (i.e., implying more
 * than one body).
 */
//
// TODO: Complete this class definition. You can use the Java-Collection-Framework.
//       You can define further classes and methods for the implementation.
//
public class MultiBody implements HierarchicalSystem //TODO: activate clause.
{

    //TODO: private variables and methods if needed.
    //TODO: missing parts of this class.
    private HierarchicalSystem[] subsystems;
    /**
     * Initializes this system with more than one subsystem.
     *
     * @param subsystems an array of components of this system (bodies or subsystems),
     *           subsystems != null && subsystems.length > 1.
     *           Refer to Java Varargs documentation for more details:
     *           https://docs.oracle.com/javase/8/docs/technotes/guides/language/varargs.html
     */
    public MultiBody(HierarchicalSystem... subsystems) {
        this.subsystems = subsystems;
    }

    @Override
    public String getName() {
        String s = "";

        for(HierarchicalSystem h : subsystems) {
            s += h.getName() + ", ";
        }

        return s.substring(0, s.length()-2);
    }

    @Override
    public String toString() {
        Arrays.sort(subsystems, Comparator.comparingDouble(s -> s.getCenter().distanceTo(this.getCenter())));
        StringBuilder s = new StringBuilder();
        int currentLevel = 1;
        for (HierarchicalSystem system : subsystems) {
            s.append(recursiveToString(system, currentLevel));
        }
        return s.toString();
    }

    private String recursiveToString(HierarchicalSystem system, int level) {
        StringBuilder result = new StringBuilder();
        String indentation = "   ".repeat(level);
        if (system instanceof Body) {
            result.append(indentation).append(system.toString()).append("\n");
        }

        if (system instanceof MultiBody) {
            MultiBody multiBody = (MultiBody) system;
            for (int i = 0; i < multiBody.subsystems.length; i++) {
                if (i == 0) {
                    result.append(indentation).append(multiBody.subsystems[i].toString()).append("\n");
                } else {
                    result.append(recursiveToString(multiBody.subsystems[i], level + 1));
                }
            }
        }
        return result.toString();
    }


    @Override
    public double getMass() {
        double totalMass = 0;
        for (int i = 0; i < subsystems.length; i++) {
            totalMass += subsystems[i].getMass();
        }
        return totalMass;
    }


    @Override
    public Vector3 getCenter() {
        double totalMass = 0;
        Vector3 weightedPositionSum = new Vector3(0, 0, 0);

        for (HierarchicalSystem subsystem : subsystems) {
            double subsystemMass = subsystem.getMass();
            Vector3 subsystemCenter = subsystem.getCenter();

            weightedPositionSum = weightedPositionSum.plus(subsystemCenter.times(subsystemMass));
            totalMass += subsystemMass;
        }

        if (totalMass == 0) {
            return new Vector3(0, 0, 0);
        }

        return weightedPositionSum.times(1/totalMass);
    }

    @Override
    public double getRadius() {
        Vector3 barycenter = this.getCenter();
        double maxcenter = 0;

        for (int i = 0; i < subsystems.length; i++) {
            double center = subsystems[i].getCenter().distanceTo(barycenter) + subsystems[i].getRadius();
            if (center > maxcenter) maxcenter = center;
        }

        return maxcenter;
    }

    @Override
    public int getNumberOfBodies() {
        int numberOfBodies = 0;
        for (int i = 0; i < subsystems.length; i++) {
            numberOfBodies += subsystems[i].getNumberOfBodies();
        }
        return numberOfBodies;
    }

    @Override
    public Deque<Body> asOrderedList(SystemComparator comp) {
        List<Body> bodies = new ArrayList<>();
        collectBodies(this, bodies);
        bodies.sort(comp);
        return new ArrayDeque<>(bodies);
    }

    private void collectBodies(HierarchicalSystem system, List<Body> bodies) {
        if (system instanceof Body) {
            bodies.add((Body) system);
        } else if (system instanceof MultiBody) {
            MultiBody multiBody = (MultiBody) system;
            for (HierarchicalSystem subSystem : multiBody.subsystems) {
                collectBodies(subSystem, bodies);
            }
        }
    }

    private void addAll(MultiBody system, Queue<Body> queue) {
        for (int i = 0; i < system.subsystems.length; i++) {
            if (system.subsystems[i] instanceof Body) {
                queue.add((Body) system.subsystems[i]);
            } else {
                addAll((MultiBody) system.subsystems[i], queue);
            }
        }
    }

    @Override
    public BodyIterator iterator() {
        Queue<Body> q = new ArrayDeque();

        for (int i = 0; i < subsystems.length; i++) {
            if (subsystems[i] instanceof Body) {
                q.add((Body) subsystems[i]);
            } else {
                addAll((MultiBody) subsystems[i], q);
            }
        }

        return new BodyIterator() {
            @Override
            public boolean hasNext() {
                return !q.isEmpty();
            }

            @Override
            public Body next() {
                if (hasNext()) {
                    return q.poll();
                }
                throw new NoSuchElementException("no more bodies");
            }
        };
    }
}

// TODO: define further classes, if needed (either here or in a separate file).

