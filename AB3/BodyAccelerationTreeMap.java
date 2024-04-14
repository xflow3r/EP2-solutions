package AB3;

import AB1.Vector3;
import AB2.Body;

/**
 * This data structure maps bodies to vectors ('Vector3' objects). It is implemented
 * as a binary search tree where bodies are sorted based on their masses.
 * The map allows multiple bodies with the same mass as long as they are not identical.
 * There is no limit on the number of key-value pairs stored in the map.
 */
//
// TODO: define further classes and methods for the implementation of the binary search tree, if
//  needed.
//
public class BodyAccelerationTreeMap {

    private TreeNode root;

    /**
     * Adds a new key-value association to this map. If the key already exists in this map,
     * the value is replaced and the old value is returned. Otherwise, 'null' is returned.
     * @param key a body != null.
     * @param value the vector to be associated with the key (can also be 'null').
     * @return the old value if the key already existed in this map, or 'null' otherwise.
     */
    public Vector3 put(Body key, Vector3 value) {
        if (root == null) {
            root = new TreeNode(key, value);
            return null;
        } else {
            return root.add(key, value);
        }
    }

    /**
     * Returns the value associated with the specified key, i.e. the vector
     * associated with the specified body. Returns 'null' if the key is not contained in this map.
     * @param key a body != null.
     * @return the value associated with the specified key (or 'null' if the key is not contained in
     * this map).
     */
    public Vector3 get(Body key) {
        if (root == null) {
            return null;
        } else {
            return root.get(key);
        }
    }

    /**
     * Returns 'true' if this map contains a mapping for the specified key.
     * @param key a body != null.
     * @return 'true' if this map contains a mapping for the specified key, or 'false' otherwise.
     */
    public boolean containsKey(Body key) {
        return root.contains(key);
    }

    /**
     *  Returns a readable representation of this map, in which key-value pairs are listed in
     *  descending order according to the mass of the bodies.
     */
    public String toString() {
        if (root != null) {
            return root.toString().substring(0, root.toString().length()-2); //to remove the last ",\n" from the string
        } else {
            return "BodyAccelerationTreeMap is empty";
        }
    }
}

class TreeNode {
    private Body key;
    private Vector3 value;
    private TreeNode left, right;

    public TreeNode(Body key, Vector3 value) {
        this.key = key;
        this.value = value;
    }

    public Vector3 add(Body body, Vector3 value) {
        if (this.key.getMass() == body.getMass()) {
            Vector3 oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        if (body.getMass() < this.key.getMass()) {
            if (left != null) {
                return left.add(body, value);
            } else {
                left = new TreeNode(body, value);
                return null;
            }
        } else {
            if (right != null) {
                return right.add(body, value);
            } else {
                right = new TreeNode(body, value);
                return null;
            }
        }
    }

    public boolean contains(Body key) {
        if (this.key.equals(key)){ //hier equals weil auf identity gecheckt wird
            return true;
        }
        if (key.getMass() < this.key.getMass()) {
            if (left != null) {
                return left.contains(key);
            }
        } else {
            if ( right != null) {
                return right.contains(key);
            }
        }
        return false;
    }


    public Vector3 get(Body key){
        if (this.key.getMass() == key.getMass()) {
            return this.value;
        }

        if (key.getMass() < this.key.getMass()) {
            if (left != null) {
                return left.get(key);
            }
        } else {
            if ( right != null) {
                return right.get(key);
            }
        }
        return null;
    }

    public String toString(){ // previous ordering was wrong
        String s = "";
        if(right != null) {
            s += right.toString();
        }

        s += key.toString() + value.toString()  + ",\n";

        if(left != null) {
            s += left.toString();
        }
        return s;
    }


 }
// TODO: define further classes, if needed (either here or in a separate file).
