package AB6;


import AB5.IntVarQueue;

import java.util.*;

/**
 * This data structure maps variables ('IntVar' objects) to constants ('IntConst' objects).
 * It is implemented as hash map. There is no limit on the number of key-value
 * mappings stored in the map. This class implements 'IntVarConstMap'.
 */
//
//
public class IntVarConstHashMap implements IntVarConstMap
{

    private Node[] table;
    private final int initialSize = 2;
    /**
     * Initializes this map as an empty map.
     */
    public IntVarConstHashMap() {
        this.table = new Node[initialSize];
    }

    /**
     * Initializes this map as an independent copy of the specified map. Later changes of 'this'
     * will not affect 'map' and vice versa.
     */
    public IntVarConstHashMap(IntVarConstHashMap map) {
        this.table = new Node[map.table.length];
        for (int i = 0; i < map.table.length; i++) {
            if (map.table[i] != null) {
                this.table[i] = new Node(map.table[i].getKey(), map.table[i].getValue());
            }
        }
    }

    @Override
    public IntConst get(IntVar key) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && table[i].getKey().equals(key)) {
                return table[i].getValue();
            }
        }
        return null;
    }

    @Override
    public IntConst put(IntVar key, IntConst value) {
        if (table[table.length-1] != null) { //if not atleast the last element is null
            doubleSize();
        }

        int firstNullIndex = table.length-1;
        boolean indexSet = false;
        for (int i = 0; i < table.length; i++) { // check if key is already present
            if (table[i] == null && !indexSet) { // first free space in the array
                indexSet = true;
                firstNullIndex = i;
            }
            if (table[i] != null && table[i].getKey() != null) {
                if (table[i].getKey().equals(key)) {
                    IntConst oldValue = table[i].getValue();
                    this.table[i].setValue(value);
                    return oldValue;
                }
            }
        }
        if (table[firstNullIndex] == null) {
            table[firstNullIndex] = new Node(key, value);
        }

        return null;
    }

    private void doubleSize() {
        Node[] oldTable = this.table;
        this.table = new Node[oldTable.length * 2];

        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] != null) {
                this.table[i] = new Node(oldTable[i].getKey(), oldTable[i].getValue());
            }
        }
    }

    @Override
    public IntConst remove(IntVar key) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && table[i].getKey().equals(key)) {
                IntConst removedValue = table[i].getValue();
                table[i] = null;
                return removedValue;
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(IntVar key) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && table[i].getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        int size = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                size++;
            }
        }
        return size;
    }


    @Override
    public IntVarSet keySet() {
        IntVarSet set = new IntVarSet() {

            IntVar[] set = new IntVar[table.length];


            @Override
            public void add(IntVar v) {
                if (!contains(v)) {
                    for (int i = 0; i < set.length; i++) {
                        if (set[i] == null) {
                            set[i] = v;
                            return;
                        }
                    }
                }
            }

            @Override
            public boolean contains(IntVar v) {
                for (int i = 0; i < set.length; i++) {
                    if (set[i] != null && set[i].equals(v)) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public int size() {
                int size = 0;
                
                for (int i = 0; i < set.length; i++) {
                    if(set[i] != null) {
                        size++;
                    }
                }
                
                return size;
            }

            @Override
            public IntVarIterator iterator() {
                for (int i = 0; i < table.length; i++) {
                    if(table[i] != null) {
                        add(table[i].getKey());
                    }
                }
                return new IntVarIterator() {

                    int currentIndex = 0;

                    @Override
                    public boolean hasNext() {
                        return currentIndex < set.length;
                    }

                    @Override
                    public IntVar next() {
                        if (!hasNext()) {
                            return null;
                        }
                        return set[currentIndex++];
                    }
                };
            }
        };

        return set;
    }

    @Override
    public String toString() {
        return "IntVarConstHashMap{" +
                "table=" + Arrays.toString(table) +
                ", initialSize=" + initialSize +
                '}';
    }

//TODO: define missing parts of this class.
}

class Node {
    private IntVar key;
    private IntConst value;

    public Node(IntVar key, IntConst value) {
        this.key = key;
        this.value = value;
    }

    public IntVar getKey() {
        return key;
    }

    public IntConst getValue() {
        return value;
    }

    public void setKey(IntVar key) {
        this.key = key;
    }

    public void setValue(IntConst value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
// TODO: define further classes, if needed, either here or in a separate file.
