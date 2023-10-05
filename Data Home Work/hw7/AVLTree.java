public class AVLTree extends BTreePrinter{
    Node root;

    public AVLTree(Node root){
        this.root = root;
        root.parent = null; // Clear parent of the root (Important for spliting)
    }
    
    public void singleRotateFromLeft(Node y) {
        // Do something
            Node w = y.parent;
            Node x = y.left;
            if(w != null){
                if(x.right == null){
                    y.left = null;
                }
                else if(x.right != null){
                    y.left = x.right;
                    x.right.parent = y;
                }
                x.right = y;
                y.parent = x;
                x.parent = w;
                if(w.left == y) w.left = x;
                else if(w.right == y) w.right = x;
            }
            else{
                if(x.right == null) y.left = null;
                else if(x.right != null){
                x.right.parent = y;
                y.left = x.right;
                }
                x.right = y;
                y.parent = x;
                root = x;
                x.parent = null;
            }
    }

    public void singleRotateFromRight(Node y) {
        // Do something
        Node w = y.parent;
        Node x = y.right;
        if(w != null){
            if(x.left == null){
                y.right = null;
            }
            else if(x.left != null){
                y.right = x.left;
                y.right.parent = y;
            }
            x.left = y;
            y.parent = x;
            x.parent = w;
            if(w.left == y) w.left = x;
            else if(w.right == y) w.right = x;
        }
        else{
            if(x.left == null) y.right = null;
            else if(x.left != null){
                y.right = x.left;
                y.right.parent = y;
            }
            x.left = y;
            y.parent = x;
            x.parent = null;
            root = x;
        }
    }

    public void doubleRotateFromLeft(Node y) {
        // Do something
        if(y == null) return;
        Node x = y.left;
        Node w,z;
        if(y.parent != null) w = y.parent;
        else w = null;
        if(x.right != null) z = x.right;
        else z = null;
        if(z == null) return;

        if(w!= null){
            if(z.left != null){
                x.right = z.left;
                z.left.parent = x;
            }
            else x.right = null;
            if(z.right != null){
                y.left = z.right;
                z.right.parent = y;
            }
            else y.left = null;
            if(w.key > z.key){
                w.left = z;
                z.parent = w;
            }
            else {
                w.right = z;
                z.parent = w;
            }
            z.right = y;
            y.parent = z;
            z.left = x;
            x.parent = z;
        }
        else{
            if(z.left != null){
                x.right = z.left;
                z.left.parent = x;
            }
            else x.right = null;
            if(z.right != null){
                y.left = z.right;
                z.right.parent = y;
            }
            else y.left = null;
            if(y == root){
                z.parent = null;
                root = z;
            }
            z.right = y;
            y.parent = z;
            z.left = x;
            x.parent = z;
        }
    }

    public void doubleRotateFromRight(Node y) {
        // Do something
        if(y == null) return;
        Node x = y.right;
        Node w,z;
        if(y.parent != null) w = y.parent;
        else w = null;
        if(x.left != null) z = x.left;
        else z = null;
        if(z == null) return;

        if(w!= null){
            if(z.right != null){
                x.left = z.right;
                z.right.parent = x;
            }
            else x.left = null;
            if(z.left != null){
                y.right = z.left;
                z.left.parent = y;
            }
            else y.right = null;
            if(w.key > z.key){
                w.left = z;
                z.parent = w;
            }
            else {
                w.right = z;
                z.parent = w;
            }
            z.left = y;
            y.parent = z;
            z.right = x;
            x.parent = z;
        }
        else{
            if(z.right != null){
                x.left = z.right;
                z.right.parent = x;
            }
            else x.left = null;
            if(z.left != null){
                y.right = z.left;
                z.left.parent = y;
            }
            else y.right = null;
            if(y == root){
                z.parent = null;
                root = z;
            }
            z.left = y;
            y.parent = z;
            z.right = x;
            x.parent = z;
        }
    }

    public static void rebalance(AVLTree tree, Node node){
        int balanceFactor = height(node.left) - height(node.right);              // Calculate balanceFactor
        if (Math.abs(balanceFactor) > 1){                          // Use balanceFactor to check if unbalanced?
            if (balanceFactor > 0){ balanceFactor = height(node.left.left) - height(node.left.right);    // Use balanceFactor to check if left heavy?
                if (balanceFactor > 0){                  // Use the grandchild to check if Outer or Inner?
                    System.out.println("Perform SingleRotationFromLeft(Node " + node.key +")");   // Fix ??? and call a function
                    tree.singleRotateFromLeft(node);
                }else{
                    System.out.println("Perform DoubleRotationFromLeft(Node " + node.key +")");   // Fix ??? and call a function
                    tree.doubleRotateFromLeft(node);
                }
            }else{
                balanceFactor = height(node.right.left) - height(node.right.right);
                if (balanceFactor > 0){                  // Use the grandchild to check if Outer or Inner?
                    System.out.println("Perform DoubleRotationFromRight(Node " + node.key +")");   // Fix this and call a function
                    tree.doubleRotateFromRight(node);
                }else{
                    System.out.println("Perform SingleRotationFromRight(Node " + node.key +")");   // Fix this and call a function
                    tree.singleRotateFromRight(node);
                }
            }
        }
    }
    
    // Fix this function to have the rebalancing feature
    // There should be rebalance() function calling somewhere in the code
    public static void insert(AVLTree tree, Node node, int key) {
        if (key == node.key) {
            System.out.println("Duplicated key:" + key);
        }else if (key < node.key) {//Go left
            if (node.left == null) {
                node.left = new Node(key);
                node.left.parent = node;
                // rebalance(tree, node);
            }else {
                insert(tree, node.left, key);
                // tree.rebalance(tree, node);
                // rebalance(tree, node);
            }
        }else{  // Go right
            if (node.right == null) {
                node.right = new Node(key);
                node.right.parent = node;
                // rebalance(tree, node);
            }else {
                insert(tree, node.right, key);
                // tree.rebalance(tree, node);
                // rebalance(tree, node);
            }
        }
         rebalance(tree, node);
    }
    
    // This function is complete, no need to edit
    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
        } else {
            insert(this, root, key);
        }
    }
    

    // This function is for deleting the root node
    // If the node is not the root, please call the recursive version
    public void delete(int key) {
        // Pls copy the code from the previous homework
        if(root == null) System.out.println("Empty Tree!!!");
        else{
            if(find(key) == root){
                if(root.left == null && root.right == null) root = null;
                else if(root.left != null && root.right == null){
                    root.left.parent = null;
                    root = root.left;
                }
                else if(root.right != null && root.left == null){
                    root.right.parent = null;
                    root = root.right;
                }
                else if(root.right != null && root.left != null){
                    Node minNode = findMin(root.right);
                    root.key = minNode.key;
                    delete(this, minNode);
                }
            }
            else{
                if(find(key) == null) System.out.println("Key not found!!!");
                else{
                    delete(this, find(key));
                }
            }
        }
    }
    
    // Use this function to delete non-root nodes
    // Also, fix the code to have the rebalancing feature
    public static void delete(AVLTree tree, Node node){
        // Pls copy the code from the previous homework
        if(node.left == null && node.right == null){
            
            if(node.parent.left == node) node.parent.left = null;
            else if(node.parent.right == node) node.parent.right = null;
            
        }
        else if(node.left != null && node.right == null){
            
            node.left.parent = node.parent;
            if(node.parent.left == node) node.parent.left = node.left;
            else if(node.parent.right == node) node.parent.right = node.left;
        
        }
        else if(node.right != null && node.left == null){
            
            node.right.parent = node.parent;
            if(node.parent.left == node) node.parent.left = node.right;
            else if(node.parent.right == node) node.parent.right = node.right;
            
        }
        else if(node.left != null && node.right != null){
            Node min = findMin(node.right);
            node.key = min.key;
            delete(tree, min);
        }

        // Add code segments to enable the rebalancing feature
        Node parent = node.parent;
        while(parent != null){
           int balanceCheck = Math.abs(height(parent.left) - height(parent.right));
            if(balanceCheck > 1){
                rebalance(tree, parent);
            }
            parent = parent.parent;
        }
    }
    
    public Node find(int search_key) {
        // Pls copy the code from the previous problem
        return find(root, search_key);
    }

    public static Node find(Node node, int search_key) {
        // Pls copy the code from the previous problem
        if(node == null) return null;
        if(search_key == node.key) return node;
        else if(search_key < node.key) return find(node.left, search_key);
        else if(search_key > node.key) return find(node.right, search_key);
        return null;
    }
    
    // This function is complete, no need to edit
    public static Node findMin(Node node){
        // Pls copy the code from the previous problem
        if(node == null) return null;
        else if(node.left == null) return node;
        return findMin(node.left);
    }
    
    public static Node findMax(Node node){
        // Pls copy the code from the previous problem
        if(node == null) return null;
        else if(node.right == null) return node;
        return findMax(node.right);
    }
    
    public static boolean isMergeable(Node r1, Node r2){
        if(r1 == null && r2 != null) return true;
        if(r1 != null && r2 == null) return true;
        int maxNodeR1 = findMax(r1).key;
        int minNodeR2 = findMin(r2).key;
        if(maxNodeR1 < minNodeR2) return true;
        else return false;
    }

    public static Node mergeWithRoot(Node r1, Node r2, Node t){
        if(r1 == null && r2 == null) return t;
        if (isMergeable(r1, r2)) {
            // Fix this
            if(Math.abs(height(r1) - height(r2)) <= 1){
                t.left = r1;
                // if(r1 != null) r1.parent = t;
                t.right = r2;
                // if(r2 != null) r2.parent = t;
                return t;
            }
            else if(height(r1) > height(r2)){
                Node Rp = mergeWithRoot(r1.right,r2, t);
                r1.right = Rp;
                Rp.parent = r1;
                AVLTree temp = new AVLTree(r1);
                rebalance(temp, r1);
                return temp.root;
            }
            else if(height(r1) < height(r2)){
                Node Rp = mergeWithRoot(r1, r2.left, t);
                r2.left = Rp;
                Rp.parent = r2;
                AVLTree temp = new AVLTree(r2);
                rebalance(temp,r2);
                return temp.root;
            }
        } else {
            System.out.println("All nodes in T1 must be smaller than all nodes from T2");
            return null;
        }
        return null;
    }
    
    public void merge(AVLTree tree2){
        if (isMergeable(this.root, tree2.root)){
            Node T = findMax(this.root);
            delete(T.key);
            this.root = mergeWithRoot(this.root, tree2.root, T);
        }else{
            System.out.println("All nodes in T1 must be smaller than all nodes from T2");
        }
    }
    
    // Fix this function
    public Node[] split(int key){
        return split(root,key); // This is incorrect, fix this by calling the static split
    }
    
    // Fix this function
    public static Node[] split(Node r, int key){ 
        Node[] arr = new Node[2];
        // Do something
        if(r == null){
            arr[0] = null;
            arr[1] = null;
            return arr;
        }
        else if(key < r.key){
            arr = split(r.left, key);
            if(arr[1] != null) arr[1].parent = null;
            if(r.right != null) r.right.parent = null;
            Node R3 = mergeWithRoot(arr[1], r.right,r);
            arr[1] = R3;
            return arr;
        }
        else if(key >= r.key){
            arr = split(r.right, key);
            if(arr[0] != null) arr[0].parent = null;
            if(r.left != null) r.left.parent = null;
            Node R4 = mergeWithRoot(r.left, arr[0],r);
            arr[0] = R4;
            return arr;
        }
        return arr;
    }
    
    // Use this function to check the node height
    // This function is complete, no need to edit
    public static int height(Node node){
        if (node == null)
            return -1;
        else
            return 1 + Math.max(height(node.left), height(node.right));
    }
    
    // This function is complete, no need to edit
    public void printTree() {
        if (root == null) {
            System.out.println("Empty tree!!!");
        } else {
            super.printTree(root);
        }
    }
    
    public AVLTree() {} // Dummy Constructor, no need to edit
}