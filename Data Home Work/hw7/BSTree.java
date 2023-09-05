public class BSTree extends BTreePrinter{
    Node root;
      
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
        Node w = y.parent;
        Node x = y.left;
        Node z = x.right;
        if(x != null || z != null){
            if(w != null){
            if(z.left == null) x.right = null;
            if(z.right == null) y.left = null;
            if(z.left != null){
                x.right = z.left;
                z.left.parent = x;
            }
            if(z.right != null){
                y.left = z.right;
                z.right.parent = y;
            }
            if(x.key < z.key){
                z.left = x;
                x.parent = z;
            }
            else if(x.key > z.key){
                z.right = x;
                x.parent = z;
            }
            if(y.key < z.key){
                z.left = y;
                y.parent = z;
            }
            else if(y.key > z.key){
                z.right = y;
                y.parent = z;
            }
            if(z.key < w.key){
                w.left = z;
                z.parent = w;
            }
            else if(z.key > w.key){
                w.right = z;
                z.parent = w;
            }
           }
           else{
            if(z.left != null){
                x.right = z.left;
                z.left.parent = x;
            }
            if(z.right != null){
                y.left = z.right;
                z.right.parent = y;
            }
            if(x.key < z.key){
                z.left = x;
                x.parent = z;
            }
            else if(x.key > z.key){
                z.right = x;
                x.parent = z;
            }
            if(y.key < z.key){
                z.left = y;
                y.parent = z;
            }
            else if(y.key > z.key){
                z.right = y;
                y.parent = z;
            }
                root = z;
            }
        }
    }

    public void doubleRotateFromRight(Node y) {
        // Do something
        Node w = y.parent;
        Node x = y.right;
        Node z = x.left;
        if(x != null || z != null){
            if(w != null){
            if(z.left == null) y.right = null;
            if(z.right == null) x.left = null;
            if(z.left != null){
                y.right = z.left;
                z.left.parent = y;
            }
            if(z.right != null){
                x.left = z.right;
                z.right.parent = x;
            }
            if(x.key < z.key){
                z.left = x;
                x.parent = z;
            }
            else if(x.key > z.key){
                z.right = x;
                x.parent = z;
            }
            if(y.key < z.key){
                z.left = y;
                y.parent = z;
            }
            else if(y.key > z.key){
                z.right = y;
                y.parent = z;
            }
            if(z.key < w.key){
                w.left = z;
                z.parent = w;
            }
            else if(z.key > w.key){
                w.right = z;
                z.parent = w;
            }
           }
           else{
            if(z.left == null) y.right = null;
            if(z.right == null) x.left = null;
            if(z.left != null){
                y.right = z.left;
                z.left.parent = y;
            }
            if(z.right != null){
                x.left = z.right;
                z.right.parent = x;
            }
            if(x.key < z.key){
                z.left = x;
                x.parent = z;
            }
            else if(x.key > z.key){
                z.right = x;
                x.parent = z;
            }
            if(y.key < z.key){
                z.left = y;
                y.parent = z;
            }
            else if(y.key > z.key){
                z.right = y;
                y.parent = z;
            }
                root = z;
            }
        }
    }
    
    public Node find(int search_key) {
        // Pls copy the code from the previous homework
        return find(root, search_key); // Call the recursive version
    }
    
    public static Node find(Node node, int search_key) {
        // Pls copy the code from the previous homework
        if(node == null) return null;
        if(search_key == node.key) return node;
        else if(search_key < node.key) return find(node.left, search_key);
        else if(search_key > node.key) return find(node.right, search_key);
        return null;
    }

    public static Node findMin(Node node){
        // Pls copy the code from the previous homework
        if(node == null) return null;
        else if(node.left == null) return node;
        return findMin(node.left);
    }

    public static Node findMax(Node node){
        // Pls copy the code from the previous homework
        if(node == null) return null;
        else if(node.right == null) return node;
        return findMax(node.right);
    }

    public void insert(int key) {
        // Pls copy the code from the previous homework
        if (root == null) {
            root = new Node(key);
        } else {
            insert(root, key);
        }
    }

    // public Node findClosestLeaf(int search_key){
    //     return findClosestLeaf(root, search_key); // Call the recursive version
    // }
   
    // public static Node findClosestLeaf(Node node, int search_key){
    //     // this function should be recursive
    //     if(node == null) return null;
    //     if(search_key == node.key) return node;
        
    //     else if(search_key < node.key){
    //         if(node.left == null) return node;
    //         else return findClosestLeaf(node.left, search_key);
    //     }
    //     else if(search_key > node.key){
    //         if(node.right == null) return node;
    //         else return findClosestLeaf(node.right, search_key);
    //     } 
        
    //     return null;
    // }

    public static void insert(Node node, int key) {
        // Pls copy the code from the previous homework
        if(key == node.key) return;
        else if(key < node.key){
            if(node.left == null){
                node.left = new Node(key);
                node.left.parent = node;
            }
            else insert(node.left, key);
        }
        else if(key > node.key){
            if(node.right == null){
                node.right = new Node(key);
                node.right.parent = node;
            }
            else insert(node.right, key);
        } 

    }
    
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
                    delete(minNode);
                }
                
            }
            else{
                if(find(key) == null) System.out.println("Key not found!!!");
                else{
                    delete(find(key));
                }
            }
        }
    }
    
    public static void delete(Node node){
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
            delete(min);
        }
    }

    
    public static boolean isMergeable(Node r1, Node r2){
        int maxNodeR1 = findMax(r1).key;
        int minNodeR2 = findMin(r2).key;
        if(maxNodeR1 < minNodeR2) return true;
        else return false;
    }

    public static Node mergeWithRoot(Node r1, Node r2, Node t){
        if (isMergeable(r1, r2)) {
            // Fix this
            t.left = r1;
            t.right = r2;
            r1.parent = t;
            r2.parent = t;
            return t;
        } else {
            System.out.println("All nodes in T1 must be smaller than all nodes from T2");
            return null;
        }
    }
    
    public void merge(BSTree tree2){
        if (isMergeable(this.root, tree2.root)){
            Node T = findMax(this.root);
            delete(T.key);
            this.root = mergeWithRoot(this.root, tree2.root, T);
        }else{
            System.out.println("All nodes in T1 must be smaller than all nodes from T2");
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
}