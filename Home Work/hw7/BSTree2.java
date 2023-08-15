public class BSTree2 extends BTreePrinter{
    Node root;
    
    // Implement this function using iterative method
    // Do not use recursion
    public Node find(int search_key){
        Node current = root;
        if(current == null) return null;
        while(current != null){
            if(search_key == current.key) return current;
            else if(search_key < current.key){
                current = current.left;

            }
            else if(search_key > current.key){
                current = current.right;

            }
        }
        return current;
    }

    // Implement this function using iterative method
    // Do not use recursion
    public Node findMin(){
        Node current = root;
        if(current == null) return null;
        while(current != null){
            if(current.left == null){ 
                return current;
            }
            current = current.left;
            }
            return current;
     }

    // Implement this function using iterative method
    // Do not use recursion
    public Node findMax(){
        Node current = root;
        if(current == null) return null;
        while(current != null){
            if(current.right == null){
                return current;
            }
            current = current.right;
        }
        return current;
    }
    
    // Implement this function using iterative method
    // Do not use recursion
    public void insert(int key) {
            if(root == null) root = new Node(key);
            Node current = root;
            if(current.key != key){
                while(current != null){
                    if(key == current.key) break;
                    else if(key < current.key){
                        if(current.left == null) break;
                        else{
                            current = current.left;

                        }
                    }
                    else if(key > current.key){
                        if(current.right == null) break;
                        else{
                            current = current.right;

                        }
                    }
                }
            }
            
        
        if(key < current.key){
            current.left = new Node(key);
        }
        else if(key > current.key){
            current.right = new Node(key);
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