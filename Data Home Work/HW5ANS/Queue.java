package hw5;

public class Queue {
    Node[] arr; // circular Queue
    int capacity;
    int front;
    int back;
    int size;
    
    public Queue(int cap){
        this.capacity = cap;
        this.front = 0;
        this.back = 0;
        this.size = 0;
        arr = new Node[cap];
    }
    
    public void enqueue(Node node){
        if (!isFull()){
            // do something
            arr[back] = node;
            back = (back+1) % capacity;
            size++;
        }else{
            System.out.println("Queue Overflow!!!");
        }
    }
    
    public Node dequeue(){
        
        if (!isEmpty()){
            // do something
            Node temp = arr[front];
            arr[front] = null;
            front = (front+1) % capacity;
            size--;
            return temp;
        }else{
            System.out.println("Queue Underflow!!!");
        }
        return null;
    }
    
    public boolean isEmpty(){
        return size == 0; // fix this
    }
    
    public boolean isFull(){
        return size == capacity; // fix this
    }
    
    public void printCircularIndices(){
        System.out.println("Front index = " + front + " Back index = " + back);
    }
    
    public void printQueue(){
        if (!isEmpty()){
            System.out.print("[Front] ");
            int tempFront = front;
            int tempSize = size;
            while(tempFront != back || tempSize > 0){
                System.out.print(arr[tempFront].data + " ");
                tempFront = (tempFront+1) % capacity;
                tempSize--;
            }
            System.out.println("[Back]");
        }else{
            System.out.println("Empty Queue!!!");
        }
    }
}
