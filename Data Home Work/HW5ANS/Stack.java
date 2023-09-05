package hw5;

public class Stack {
    Node[] arr; // regular array
    int capacity;
    int size;

    public Stack(int cap){
        this.capacity = cap;
        this.size = 0;
        arr = new Node[cap];
    }
    
    public void push(Node node){
        if (!isFull()){
            // do something
            arr[size] = node;
            size++;
        }else{
            System.out.println("Stack Overflow!!!");
        }
    }
    public Node pop(){
        if (!isEmpty()){
            Node temp = arr[size-1];
            size--;
            return temp;
        }else{
            System.out.println("Stack Underflow!!!");
        }
        return null; // fix this (out of place)
    }
    public boolean isFull(){
        return size == capacity; // fix this
    }
    public boolean isEmpty(){
        return size == 0; // fix this
    }
    
    public void printStack(){
        if (!isEmpty()) {
            System.out.print("[Bottom] ");
            for(int i = 0; i < size; i++){
                System.out.print(arr[i].data + " ");
            }
            System.out.println("[Top]");
        } else {
            System.out.println("Empty Stack!!!");
        }
    }
}
