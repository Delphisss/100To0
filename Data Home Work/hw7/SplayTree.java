import java.util.LinkedList;
import java.util.Queue;

public class SplayTree extends BTreePrinter {
    Node root;

    public SplayTree(Node root) {
        this.root = root;
        root.parent = null; // Clear parent of the root (Important for SplayTree)
    }

    // zig() function will move up the node x one level
    // Case 1: x == root
    // Case 2-3: x.parent == root (sig from left, zig from right)
    // Case 4-5: x.parent != root (sig from left, zig from right)
    public void zig(Node x) {
        Node y = x.parent;
        if (y == null) {
            System.out.println("Cannot perform Zig operation on the root node");
        } else if (y == root) { // If the node is a child of the root
            if (x.key < y.key) {// Zig from left
                if (x.right != null) {
                    y.left = x.right;
                    x.right.parent = y;
                } else {
                    y.left = null;
                }
                x.right = y;
                y.parent = x;
                root = x;
                root.parent = null;
            } // Complete the rest of the cases yourself
            else { // Zig from right
                if (x.left != null) {
                    y.right = x.left;
                    x.left.parent = y;
                } else {
                    y.right = null;
                }
                x.left = y;
                y.parent = x;
                root = x;
                root.parent = null;
            }
        } else if (y != root) {
            Node w = x.parent.parent;
            if (x.key < y.key) { // X is left of Y
                if (x.right != null) {
                    y.left = x.right;
                    x.right.parent = y;
                } else {
                    y.left = null;
                }
                x.right = y;
                y.parent = x;
                if (w.key > y.key) {
                    w.left = x;
                } else {
                    w.right = x;
                }
                x.parent = w;
            } else {
                if (x.left != null) {
                    y.right = x.left;
                    x.left.parent = y;
                } else {
                    y.right = null;
                }
                x.left = y;
                y.parent = x;
                if (w.key > y.key) {
                    w.left = x;
                } else {
                    w.right = x;
                }
                x.parent = w;
            }
        }
    }

    // zigzig() function will move up node x two levels along the outer path
    // Pls call zig() to perform zigzig()
    public void zigzig(Node x) {
        // Do something
        zig(x.parent);
        zig(x);
    }

    // zigzag() function will move up node x two levels along the inner path
    // Pls call zig() to perform zigzag()
    public void zigzag(Node x) {
        // Do something
        zig(x);
        zig(x);
    }

    // This function will interatively splay (move up) node x all the way to the
    // root
    public void splay(Node x) {
        while (x != null && x != root) {
            Node y = x.parent;
            Node w = x.parent.parent;
            if (y == root) {
                // Do something and break
                zig(x);
                break;
            } // Complete the rest of the cases yourself
            else {
                if (w.left != null && w.left.left == x || w.right != null && w.right.right == x)
                    zigzig(x);
                else if (w.left != null && w.left.right == x || w.right != null && w.right.left == x)
                    zigzag(x);
            }
        }
    }

    // Modify this function to have the splaying feature
    // This can be done by calling the splay() function
    public void insert(int key) {
        // Pls copy code from the previous problem
        if (root == null) root = new Node(key);
        Node current = root;
        if (current.key != key) {
            while (current != null) {
                if (key == current.key)
                    break;
                else if (key < current.key) {
                    if (current.left == null)
                        break;
                    else {
                        current = current.left;
                    }
                } else if (key > current.key) {
                    if (current.right == null)
                        break;
                    else {
                        current = current.right;
                    }
                }
            }
        }

        if (key < current.key) {
            current.left = new Node(key);
            current.left.parent = current;
            splay(current.left);
        } else if (key > current.key) {
            current.right = new Node(key);
            current.right.parent = current;
            splay(current.right);
        }
    }

    // Modify this function to have the splaying feature (if withSplay is true)
    // This can be done by calling the splay() function
    public Node find(int search_key, boolean withSplay) {
        // Pls copy code from the previous problem
        Node current = root;
        if (current == null)
            return null;
        while (current != null) {
            if (search_key == current.key) {
                if (withSplay) {
                    splay(current);
                }
                return current;
            } else if (search_key < current.key) {
                current = current.left;
            } else if (search_key > current.key) {
                current = current.right;
            }
        }
        return current;
        // and add the splaying feature somewhere (do not forget the withSplay check)
    }

    // This delete() is different than what you learned in BSTree and AVLTree before
    // Use the algorithm learned in the class to implement this function
    public void delete(int key) {
        Node want2Del = find(key, true);
        splay(want2Del); // delete Node to root
        Node leftSubtree = root.left;
        Node rightSubtree = root.right;
        // Find RightSubtree min
        rightSubtree = findMin(rightSubtree);
        splay(rightSubtree);
        root = rightSubtree;
        root.left = leftSubtree;
    }

    // This function does not have the splaying feature
    public Node findMin(Node node) {
        // Pls copy code from the previous problem
        Node current = node;
        if (current == null)
            return null;
        while (current != null) {
            if (current.left == null) {
                return current;
            }
            current = current.left;
        }
        return current;
        // Do not add the splaying feature in this function
    }

    // This is another version of height() called iterative method to find BST
    // height
    // This function is complete, no need to edit
    @SuppressWarnings("unchecked")
    public int height() {
        if (root == null)
            return -1;
        Queue<Node> q = new LinkedList();
        q.add(root);
        int height = -1;
        while (true) {
            int nodeCount = q.size();
            if (nodeCount == 0)
                return height;
            height++;
            while (nodeCount > 0) {
                Node newnode = q.remove();
                if (newnode.left != null)
                    q.add(newnode.left);
                if (newnode.right != null)
                    q.add(newnode.right);
                nodeCount--;
            }
        }
    }

    // This function is complete, no need to edit
    public void printTree() {
        if (root == null) {
            System.out.println("Empty tree!!!");
        } else {
            super.printTree(root);
        }
    }

    public SplayTree() {
    } // Dummy Constructor, no need to edit

    // This is the editable testcase (test#4)
    // No need to edit
    public static void test4() {
        BSTree2 tree1 = new BSTree2();
        long start = System.currentTimeMillis();
        int N = 40000;
        for (int i = 0; i < N; i++)
            tree1.insert(i);
        System.out.println("Time for sequentially inserting " + N + " objects into BST = "
                + (System.currentTimeMillis() - start) + " msec");
        start = System.currentTimeMillis();
        for (int i = 0; i < N; i++)
            tree1.find((int) (Math.random() * N));

        System.out.println("Time for finding " + N + " different objects in BST= "
                + (System.currentTimeMillis() - start) + " msec");
        SplayTree tree2 = new SplayTree();
        start = System.currentTimeMillis();
        for (int i = 0; i < N; i++)
            tree2.insert(i);

        System.out.println("Time for sequentially inserting " + N + " objects into SplayTree = "
                + (System.currentTimeMillis() - start) + " msec");
        start = System.currentTimeMillis();
        for (int i = 0; i < N; i++)
            tree2.find((int) (Math.random() * N), true);
        System.out.println("Time for finding " + N + " different objects in SplayTree = "
                + (System.currentTimeMillis() - start) + " msec");

        System.out.println("Which one is faster: BSTree or SplayTree?");
    }

}