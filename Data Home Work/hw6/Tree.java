package hw6;
// This Tree needs to inherit BTreePrinter
public class Tree extends BTreePrinter{ // Fix this
    Node root;
      
    public Tree(Node root){
        //fix this
        this.root = root;
    }
    
    public Tree(){} // Dummy constructor (No need to edit)
    
    public void printTree(){
        super.printTree(root);
        if(root == null) System.out.println("Empty tree!!!");
    }

    public static void printNode(Node node){
        if(node == null) System.out.println("Node not found!!!");
        else System.out.println(node.key);
    }
        
    public Node find(int search_key){
        return find(root, search_key); // Call the recursive version
    }
    
    public static Node find(Node node, int search_key){
        // this function should be recursive
        // You should check null in this function
        if(node == null) return null;
        if(search_key == node.key) return node;
        else if(search_key < node.key) return find(node.left, search_key);
        else if(search_key > node.key) return find(node.right, search_key);
        
        return null;
    }
    
    
    public Node findMin(){
        return findMin(root); // Call the recursive version
    }
    
    public static Node findMin(Node node){
        // this function should be recursive
        if(node == null) return null;
        else if(node.left == null) return node;
        return findMin(node.left);
    }
    
    public Node findMax(){
        return findMax(root); // Call the recursive version
    }
    
    public static Node findMax(Node node){
        // this function should be recursive
        if(node == null) return null;
        else if(node.right == null) return node;
        return findMax(node.right);
    }
    
    public Node findClosestLeaf(int search_key){
        return findClosestLeaf(root, search_key); // Call the recursive version
    }
   
    public static Node findClosestLeaf(Node node, int search_key){
        // this function should be recursive
        if(node == null) return null;
        if(search_key == node.key) return node;
        
        else if(search_key < node.key){
            if(node.left == null) return node;
            else return findClosestLeaf(node.left, search_key);
        }
        else if(search_key > node.key){
            if(node.right == null) return node;
            else return findClosestLeaf(node.right, search_key);
        } 
        
        return null;
    }
    
    public Node findClosest(int search_key){
        // Please use while loop to implement this function
        // Try not to use recursion
        
        Node current, closest;
        closest = current = root;
        int min_diff = Integer.MAX_VALUE;
        
        // Use while loop to traverse from root to the closest leaf
        while(current != null){
            if(search_key == current.key){
                closest = current;
                break;
            }
            if(search_key < current.key){
                if((Math.abs(search_key - current.key)) < min_diff){
                    min_diff = Math.abs(search_key - current.key);
                    closest = current;
                }
                current = current.left;
            }
            else if (search_key > current.key){
                if((Math.abs(search_key - current.key)) < min_diff){
                    min_diff = Math.abs(search_key - current.key);
                    closest = current;
                }
                current = current.right;
            }
        }
        return closest;
    }
    
    // Implement this function using the findClosestLeaf technique
    // Do not implement the recursive function
    public void insert(int key) {
        // Implement insert() using the non-recursive version
        // This function should call findClosestLeaf()
        Node current = findClosestLeaf(root, key);
    
        if (current == null) {
            root = new Node(key);
        } else if (key < current.key) {
            if (current.left == null || current.left.key != key) {
                current.left = new Node(key);
            } else {
                System.out.println("Duplicated key!!!"); // Handle duplicate key
            }
        } else if (key > current.key) {
            if (current.right == null || current.right.key != key) {
                current.right = new Node(key);
            } else {
                System.out.println("Duplicated key!!!"); // Handle duplicate key
            }
        } else {
            System.out.println("Duplicated key!!!"); // Handle duplicate key
        }
    }
    
    public void printPreOrderDFT(){
        System.out.print("PreOrder DFT node sequence [ ");
        // Call the recursive version
        printPreOrderDFT(root);
        System.out.println("]");
    }
    
    public static void printPreOrderDFT(Node node){
        // this function should be recursive
        if(node == null) return;
        System.out.print(node.key+ " ");
        if(node.left != null)  printPreOrderDFT(node.left);
        if(node.right != null)  printPreOrderDFT(node.right);
        return;
    }
    
    public void printInOrderDFT(){
        System.out.print("InOrder DFT node sequence [ ");
        // Call the recursive version
        printInOrderDFT(root);
        System.out.println("]");
    }
    
    public static void printInOrderDFT(Node node){
        // this function should be recursive  
        if(node == null) return;
        if(node.left != null)  printInOrderDFT(node.left);
        System.out.print(node.key + " ");
        if(node.right != null)  printInOrderDFT(node.right);
    }
    
    public void printPostOrderDFT(){
        System.out.print("PostOrder DFT node sequence [ ");
        // Call the recursive version
        printPostOrderDFT(root);
        System.out.println("]");
    }
    
    public static void printPostOrderDFT(Node node){
        // this function should be recursive 
        if(node == null) return;
        if(node.left != null)  printPostOrderDFT(node.left);
        if(node.right != null)  printPostOrderDFT(node.right);
        System.out.print(node.key + " ");
    }
    
    public static int height(Node node){
        // Use recursion to implement this function
        // height = length(path{node->deepest child})
        if(node == null) return -1;
        else{
            return 1 + Math.max(height(node.left), height(node.right));
        }
    }
    
    public static int size(Node node){
        // Use recursion to implement this function
        // size = #children + 1(itself)
        if(node == null) return 0;
        else{
            return 1 + size(node.left) + size(node.right);
        }
    }
    
    public static int depth(Node root, Node node){
        // Use recursion to implement this function
        // Similar to height() but start from node, go up to root
        // depth = length(path{node->root})
        if(node == root) return 0;
        else{
            return 1 + depth(root, node.parent);
        }

    }
    
    public int height(){ // Tree height
        // Hint: call the static function
        return height(root);
    }
    
    public int size(){ // Tree size
        // Hint: call the static function
        return size(root);
    }
    
    public int depth(){ // Tree depth
        // Hint: call the static function
        return height(root); // depth of tree == height of tree
    }
    
    public Node findKthSmallest(int k){
        return findKthSmallest(root, k); // Call the recursive version
    }
    
    public static Node findKthSmallest(Node node, int k){
        // this function should be recursive
        int l = size(node.left);
        if(k == (l+1)) return node;
        if(k < (l+1)) return findKthSmallest(node.left, k);
        if(k > (l+1)) return findKthSmallest(node.right, (k-l-1));
        return null;
    }
    
    public static Node findNext(Node node){
        //this function should call other functions
        if(node.right != null) return leftDescendant(node.right);
        else return rightAncestor(node);
    }
    
    public static Node leftDescendant(Node node){// Case 1 (findMin)
        // this function should be recursive
        if(node.left == null) return node;
        else return leftDescendant(node.left);
    }
    
    public static Node rightAncestor(Node node) {// Case 1 (first right parent)
        // this function should be recursive
        if(node.key < node.parent.key) return node.parent;
        else return rightAncestor(node.parent);
    }
    
    public List rangeSearch(int x, int y){
        // This function utilizes findCloest() and findNext()
        // Use List list append(node) to add node to the list
        // List is the static Array
        List L = new List(100);
        Node N = findClosest(x);
        Node closestY = findClosest(y);
        while(N.key <= y){
            if(N.key >= x){ 
                L.append(N);
            }
           if(N.key == closestY.key) break; // end-loop if N has key == Node that closest y (if y is morethan max key of tree)
                N = findNext(N);
        }
        return L;
    }
    
         
    // This function is for deleting the root node
    // If the node is not the root, please call the recursive version
    public void delete(int key) {
        // There should be 6 cases here
        // Non-root nodes should be forwarded to the static function
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

    // Use this function to delete non-root nodes
    public static void delete(Node node){
        // There should be 7 cases here
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
}
