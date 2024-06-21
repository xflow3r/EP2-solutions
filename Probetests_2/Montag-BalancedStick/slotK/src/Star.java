import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Leaf node of a mobile. The actual decoration of a mobile.
 * A 'Star' has a specified weight, that can not be changed after
 * initialisation. 'Star' implements 'Decoration'.
 */
//
// TODO: Complete the methods in 'Star'.
//       You can define further classes and methods for the implementation.
//       You may use the Java-Collection framework.
//
public class Star implements Decoration //TODO: activate clause.
{

    private final int weight;
    /**
     * Initializes 'this' with its weight.
     *
     * @param weight the weight of this star.
     */
    public Star(int weight) {
        this.weight = weight;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    @Override
    /**
     * Returns a readable representation of 'this' with the
     * symbol '*' followed by the weight of this star.
     */
    public String toString() {
        return "*" + this.weight;
    }


    @Override
    public int hashCode() {
        return Objects.hash(weight);
    }

    @Override
    public StarCollection getStarCollection() {
        return new StarCollection() {
            @Override
            public boolean contains(Star s) {
                return Star.this.equals(s);
            }
        };
    }

    @Override
    public StarIterator iterator() {
        return new StarIterator() {
            private boolean isCalled = false;

            @Override
            public boolean hasNext() {
                return !isCalled;
            }

            @Override
            public Star next() {
                if (hasNext()){
                    isCalled = true;
                    return Star.this;
                }

                throw new NoSuchElementException("no star element!");
            }
        };
    }
}
