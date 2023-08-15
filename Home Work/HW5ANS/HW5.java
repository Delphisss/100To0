/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw5;

/**
 *
 * @author 0736
 */
public class HW5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
                //Node tree = constructTree1();
                //tree.printTree();
                Node tree = constructTree1();
tree.printTree();
tree.printBFT();
tree.printDFT();
     

    }


public static Node constructTree1(){
    Node root = new Node(3); // Fix this
    root.left = new Node(7);
    root.right = new Node(5);
    root.left.left = new Node(2);
    root.left.right = new Node(6);
    root.right.right = new Node(9);
    root.left.right.left = new Node(1);
    root.left.right.right = new Node(8);
    root.right.right.left = new Node(4);
    // do something
    
    return root;
}


public static Node constructTree2(){
     Node root = new Node(1); // Fix this
     root.left = new Node(2);
     root.right = new Node(3);
     root.left.left = new Node(4);
     root.left.right = new Node(5);
     root.left.right.left = new Node(7);
     root.left.right.right = new Node(8);
     root.left.right.right.right = new Node(10);
     root.right.right = new Node(6);
     root.right.right.left = new Node(9);
    // do something
    
    return root;
}


                
                
}
    
