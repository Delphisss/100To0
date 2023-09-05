package hw4;

public class Queue implements List{
    // Implement Queue using Linked List with tail
    Node head;
    Node tail;
    
    public void push(Node node){
        if (head == null){
            // Do something (Empty list)
            head = node;
            tail = node;
        }else{
            // Do something (Non-empty list)
            tail.next = node;
            tail = node;
        }
    }
    
    public void pop(){
        if (head != null){
            if (head != tail){
                // Do something (List of many nodes)
                head = head.next;
            }
            else{
                head = tail.next;
            }
        }
        else{
            head = null;
            System.out.println("Error: Queue Underflow");
        }
    }
    
    public Node top(){
        // Fix this
        return head;
}
}