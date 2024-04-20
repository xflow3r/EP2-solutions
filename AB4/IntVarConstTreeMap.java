package AB4;

import javax.swing.plaf.InsetsUIResource;
import java.util.Objects;

/**
 * This data structure maps variables ('IntVar' objects) to constants ('IntConst' objects).
 * It is implemented as a binary search tree where variables are sorted lexicographically according
 * their name using the 'compareTo' method of String. The map allows multiple variables with the
 * same name as long as they are not identical. There is no limit on the number of key-value
 * mappings stored in the map.
 */
//
// TODO: define further classes and methods for the implementation of the binary search tree, if
//  needed.
//
public class IntVarConstTreeMap {

    private TreeNode root;

    public IntVarConstTreeMap() {
        this.root = null;
    }

    /**
     * Constructs this map as a copy of the specified 'map'. This map has the same key-value mappings
     * as 'map'. However, if 'map' is changed later, it will not affect 'this' and vice versa.
     * @param map the map from which key-value mappings are copied to this new map, map != null.
     */
    public IntVarConstTreeMap(IntVarConstTreeMap map) {
        this.root = copyTree(map.root);
        //TODO: implement constructor.
    }

    private TreeNode copyTree(TreeNode node){
        if (node == null) return null;
        TreeNode newNode = new TreeNode(node.getKey(), node.getValue());

        newNode.setLeft(copyTree(node.getLeft()));
        newNode.setRight(copyTree(node.getRight()));
        return newNode;
    }


    /**
     * Constructs this map by copying only those key-value mappings from 'map' for which the key is
     * contained in the specified list. Elements of 'toCopy' which are not keys in 'map' are
     * ignored.
     * @param map the map from which key-value mappings are copied to this new map, map != null.
     * @param toCopy the list of keys specifying which key-value mappings to copy, toCopy != null.
     */
    public IntVarConstTreeMap(IntVarConstTreeMap map, IntVarDoublyLinkedList toCopy) {
        this.root = null;

        for (int i = 0; i < toCopy.size(); i++) {
            IntVar var = toCopy.pollFirst();
            if (var != null) {
                put(var, map.get(var));
            }
        }
    }


    /**
     * Adds a new key-value association to this map. If the key already exists in this map,
     * the value is replaced and the old value is returned. Otherwise, 'null' is returned.
     * @param key a variable != null.
     * @param value the constant to be associated with the key (can also be 'null').
     * @return the old value if the key already existed in this map, or 'null' otherwise.
     */
    public IntConst put(IntVar key, IntConst value) {
        if (root == null) {
            root = new TreeNode(key, value);
            return null;
        } else {
            return root.put(key, value);
        }
    }

    /**
     * Returns the value associated with the specified key, i.e. the vector
     * associated with the specified body. Returns 'null' if the key is not contained in this map.
     * @param key a variable != null.
     * @return the value associated with the specified key (or 'null' if the key is not contained in
     * this map).
     */
    public IntConst get(IntVar key) {
        return root.get(key);
    }

    /**
     * Returns 'true' if this map contains a mapping for the specified key.
     * @param key a variable != null.
     * @return 'true' if this map contains a mapping for the specified key, or 'false' otherwise.
     */
    public boolean containsKey(IntVar key) {
        return root.containsKey(key);
    }

    /**
     * Returns the number of key-value mappings in this map.
     * @return the number of key-value mappings in this map.
     */
    public int size() {
        if (root == null) {
            return 0;
        } else {
            return root.size();
        }
    }

    /**
     * Returns a new list with all the keys of this map. The list is ordered ascending according to
     * the key order relation. (This means that for any two variables x and y, x has a lower
     * index than y in the returned list, if x.getName().compareTo(y.getName()) < 0.
     * If x.getName().compareTo(y.getName()) > 0, y has a lower index than x in the returned list.
     * If there are variables with equal names, they are consecutive entries in the returned list.)
     * @return an ordered list of keys.
     */
    public IntVarDoublyLinkedList keyList() {
        IntVarDoublyLinkedList list = new IntVarDoublyLinkedList();
        if (root != null) {
            root.keyList(list);
        }
        return list;
    }
}


class TreeNode {

    private IntVar key;
    private IntConst value;

    private TreeNode left, right;

    public TreeNode (IntVar key, IntConst value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }


    public IntConst put(IntVar key, IntConst value) {
        int comp = key.getName().compareTo(this.key.getName()); //0 = equal, < 0 if string is smaller, > 0 if string is geater

        if (comp == 0) {
            IntConst returnKey = this.value;
            this.value = value;
            return returnKey;
        } else if (comp > 0) {
            if(this.left == null) {
                this.left = new TreeNode(key, value);
                return null;
            } else {
                return left.put(key, value);
            }
        } else {
            if (this.right == null) {
                this.right = new TreeNode(key, value);
                return null;
            } else {
                return right.put(key, value);
            }
        }
    }


    public boolean containsKey(IntVar key) {
        int comp = key.getName().compareTo(this.key.getName()); //0 = equal, < 0 if string is smaller, > 0 if string is geater

        if (comp == 0) {
            return true;
        } else if (comp > 0) {
            if(this.left == null) {
                return false;
            } else {
                return left.containsKey(key);
            }
        } else {
            if (this.right == null) {
                return false;
            } else {
                return right.containsKey(key);
            }
        }
    }

    public IntConst get(IntVar key) {
        int comp = key.getName().compareTo(this.key.getName()); //0 = equal, < 0 if string is smaller, > 0 if string is geater

        if (comp == 0) {
            return this.value;
        } else if (comp > 0) {
            if(this.left == null) {
                return null;
            } else {
                return left.get(key);
            }
        } else {
            if (this.right == null) {
                return null;
            } else {
                return right.get(key);
            }
        }
    }

    public int size() {
        int index = 1;
        if (right != null) {
            index += right.size();
        }

        if (left != null) {
            index += left.size();
        }
        return index;
    }


    /**
     * Returns a new list with all the keys of this map. The list is ordered ascending according to
     * the key order relation. (This means that for any two variables x and y, x has a lower
     * index than y in the returned list, if x.getName().compareTo(y.getName()) < 0.
     * If x.getName().compareTo(y.getName()) > 0, y has a lower index than x in the returned list.
     * If there are variables with equal names, they are consecutive entries in the returned list.)
     * @return an ordered list of keys.
     */
    public void keyList(IntVarDoublyLinkedList keys) {
        if (left != null) {
            left.keyList(keys);
        }

        keys.addLast(this.key);

        if (right != null) {
            right.keyList(keys);
        }
        //TODO: implement method.
    }

    public IntVar getKey() {
        return key;
    }

    public void setKey(IntVar key) {
        this.key = key;
    }

    public IntConst getValue() {
        return value;
    }

    public void setValue(IntConst value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
// TODO: define further classes, if needed (either here or in a separate file).
