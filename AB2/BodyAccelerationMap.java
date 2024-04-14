package AB2;
import AB1.Vector3;

/**
 * A map that associates a body with an acceleration vector. The number of
 * key-value pairs is not limited.
 */
public class BodyAccelerationMap {

    // Key/Value pairs
    Body[] keys;
    private Vector3[] values;

    private int capacity; // how much does fit in the map
    private int size; // how many are currently in the map

    /**
     * Initializes this map with an initial capacity.
     * @param initialCapacity specifies the size of the internal array. initialCapacity > 0.
     */
    public BodyAccelerationMap(int initialCapacity) {

        this.capacity = initialCapacity;
        this.values = new Vector3[initialCapacity];
        this.keys = new Body[initialCapacity];
    }

    /**
     * Adds a new key-value association to this map. If the key already exists in this map,
     * the value is replaced and the old value is returned. Otherwise, 'null' is returned.
     * @param key a body != null.
     * @param acceleration the acceleration vector to be associated with the key.
     * @return the old value if the key already existed in this map, or 'null' otherwise.
     */
    public Vector3 put(Body key, Vector3 acceleration) {

        // check if entry already exists
        for (int i = 0; i < size; i++) {
            if(this.keys[i].equals(key)) {
                Vector3 returnVector = this.values[i];
                this.values[i] = acceleration;
                return returnVector;
            }
        }

        if (size == keys.length) {
            resize();
        }

        int insertIndex = size;
        for (int i = 0; i < size; i++) {
            if (key.getMass() > this.keys[i].getMass()) {

                insertIndex = i;
                break;
            }
        }

        for (int j = size; j > insertIndex; j--) {
            this.keys[j] = this.keys[j - 1];
            this.values[j] = this.values[j - 1];
        }

        this.keys[insertIndex] = key;
        this.values[insertIndex] = acceleration;
        size++;

        return null;
    }

    //old resize deleted data -> passed test but if you add more data you get null pointers
    private void resize(){
        int newCapacity = keys.length * 2;
        Body[] newKeys = new Body[newCapacity];
        Vector3[] newValues = new Vector3[newCapacity];

        for(int i = 0; i < keys.length; i++) {
            newKeys[i] = keys[i];
        }

        for(int i = 0; i < values.length; i++) {
            newValues[i] = values[i];
        }

        keys = newKeys;
        values = newValues;
    }


    /**
     * Returns the value associated with the specified key, i.e. the acceleration vector
     * associated with the specified body. Returns 'null' if the key is not contained in this map.
     * @param key a body != null.
     * @return the value associated with the specified key (or 'null' if the key is not contained in
     * this map).
     */
    public Vector3 get(Body key) {

        int left = 0;
        int right = size - 1;

        while (left <= right) {
            int middle = left + ((right - left) / 2);

            if (keys[middle].getMass() < key.getMass()) {
                right = middle - 1;
            } else {
                if (keys[left].getMass() == key.getMass()) {
                    return values[left];
                }
                left = middle + 1;
            }
        }

        return null;
    }
}
