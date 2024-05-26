package AB6;

import AB4.IntVarDoublyLinkedList;

/**
 * This data structure maps variables ('IntVar' objects) to constants ('IntConst' objects).
 * It is implemented as a binary search tree where variables are sorted lexicographically according
 * their name using the 'compareTo' method of String. There is no limit on the number of
 * key-value mappings stored in the map.
 */
//
// TODO: define further classes and methods for the implementation of the binary search tree, if
//  needed.
//
public class IntVarConstTreeMap implements IntVarConstMap //TODO: uncomment clause.
{

    private TreeNode root;
    private int size;

    public IntVarConstTreeMap() {
        this.root = null;
        this.size = 0;
    }

    /**
     * Constructs this map as a copy of the specified 'map'. This map has the same key-value mappings
     * as 'map'. However, if 'map' is changed later, it will not affect 'this' and vice versa.
     *
     * @param map the map from which key-value mappings are copied to this new map, map != null.
     */
    public IntVarConstTreeMap(IntVarConstTreeMap map) {
        this.root = copyTree(map.root);
        this.size = map.size();
    }

    private TreeNode copyTree(TreeNode node){
        if (node == null) return null;
        TreeNode newNode = new TreeNode(node.getKey(), node.getValue());

        newNode.setLeft(copyTree(node.getLeft()));
        newNode.setRight(copyTree(node.getRight()));
        return newNode;
    }

    @Override
    public IntConst get(IntVar key) {
        if (root == null) return null;
        return root.get(key);
    }

    @Override
    public IntConst put(IntVar key, IntConst value) {
        size++;
        if (root == null) {
            root = new TreeNode(key, value);
        } else {
            return root.put(key, value);
        }

        return null;
    }

    @Override
    public IntConst remove(IntVar key) {
        if (key != null) {
            TreeNode parent = null;
            TreeNode current = root;
            while (current != null && !current.getKey().equals(key)) {
                parent = current;
                int cmp = key.getName().compareTo(current.getKey().getName());
                if (cmp < 0) {
                    current = current.getLeft();
                } else {
                    current = current.getRight();
                }
            }

            if (current == null) {
                return null;
            }

            IntConst oldValue = current.getValue();

            if (current.getLeft() == null && current.getRight() == null) {
                if (current == root) {
                    root = null;
                } else if (current.equals(parent.getLeft())) {
                    parent.setLeft(null);
                } else {
                    parent.setRight(null);
                }
            } else if (current.getLeft() != null && current.getRight() != null) {
                TreeNode successorParent = current;
                TreeNode successor = current.getRight();
                while (successor.getLeft() != null) {
                    successorParent = successor;
                    successor = successor.getLeft();
                }
                current.setKey(successor.getKey());
                current.setValue(successor.getValue());
                if (successorParent.getLeft() == successor) {
                    successorParent.setLeft(successor.getRight());
                } else {
                    successorParent.setRight(successor.getRight());
                }
            } else {
                TreeNode child = (current.getLeft() != null) ? current.getLeft() : current.getRight();
                if (current == root) {
                    root = child;
                } else if (current == parent.getLeft()) {
                    parent.setLeft(child);
                } else {
                    parent.setRight(child);
                }
            }
            size--;
            return oldValue;
        }
        return null;
    }


    @Override
    public String toString() {
        if (root == null) {
            return "empty";
        } else {
            return root.toStringNode();
        }
    }

    @Override
    public boolean containsKey(IntVar key) {
        if (root != null) {
            return root.containsKey(key);
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return size;
    }

    public IntVar[] getAllKeys() {
        int treeSize = this.size();
        IntVar[] keys = new IntVar[treeSize];
        if (root != null) {
            root.collectKeys(keys, 0);
        }
        return keys;
    }

    @Override
    public IntVarSet keySet() {
        IntVarSet set = new IntVarSet() {

            IntVar[] set = new IntVar[root.size()];
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
                set = getAllKeys();
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

    public int collectKeys(IntVar[] keys, int index) {
        if (left != null) {
            index = left.collectKeys(keys, index);
        }

        keys[index++] = this.key;

        if (right != null) {
            index = right.collectKeys(keys, index);
        }

        return index;
    }

    public String toStringNode() {
        String s = "";
        if (left != null) {
            s += left.toStringNode();
        }

        s += this.key.toString() + " " + this.value.toString();

        if (right != null) {
            s += right.toStringNode();
        }
        return s;
    }


    public IntConst put(IntVar key, IntConst value) {
        int comp = 0;
        if (key != null) {
            comp = key.getName().compareTo(this.key.getName()); //0 = equal, < 0 if string is smaller, > 0 if string is geater
        }

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
        int comp = 0;
        if (key != null) {
            comp = key.getName().compareTo(this.key.getName()); //0 = equal, < 0 if string is smaller, > 0 if string is geater
        }


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
        int comp = 0;
        if (key != null) {
            comp =  key.getName().compareTo(this.key.getName()); //0 = equal, < 0 if string is smaller, > 0 if string is geater
        }

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

