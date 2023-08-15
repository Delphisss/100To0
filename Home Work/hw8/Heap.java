public class Heap {
    
    int capacity;
    Node[] arr;
    int size;
    
    boolean isMinHeap;  // true if minHeap, false if maxHeap
    
    int timer;    // For each push, the timer will increase by 1
    
    public Heap(boolean isMinHeap, int cap){
        // Initialize the heap here
        arr = new Node[cap];
        this.capacity = cap;
        this.isMinHeap = isMinHeap;
        this.size = 0;
        // Don't forget that we will build the binary heap using...
        // ... the concept of "Complete binary tree based on the array implementation"
        // ... The 0 index will not be used, The index starts from 1 (remember?)
        
    }
    public Node top(){
        return arr[1];
    }
    
    public void push(Node node){
        // Increase timer each time you push something into the Queue
        timer++;
        node.timestamp = timer; // Stamp the time number to the node
        // To do:
        // 1. Push the new node at the end of the array (via back pointer)
        int posn = size + 1;
        arr[posn] = node;
        // 2. Sift (percolate) it up the heap
        //      * Check priority of the current node with its parent
        //      * Swap the current node if the priority is higher than the parent
        //      * Repeat the process until reaching the root or there is no swap (Pls use while loop)
        while(posn != 1){
            Node parentOfCurrent = arr[posn/2];
            boolean currentNode = arr[posn].compare(parentOfCurrent);
            if(currentNode){
                swap(posn, (posn/2));
            }
            posn /= 2;
        }
        // 3. Increase the heap size
        size++;
    }
    
    public Node pop(){
        // To do:
        // 1. Mark the root for return (Don't forget to return this node)
        Node forReturn = arr[1];
        // 2. Move the last node to the root (change pointer, set null)
        arr[1] = arr[size];
        arr[size] = null;
        // 3. Decrease the heap size
        size--;
        // 4. Sift (percolate) it down the heap
        //      * Check priority of the current node with both children
        //      * Swap the current node with the lower priority child
        //      * Repeat the process until the node has no child or there is no swap (Pls use while loop)
        int posn = 1;
        while(arr[posn*2] != null || arr[posn*2+1] != null){
            if(arr[posn*2] != null && arr[posn*2+1] == null || arr[posn*2].compare(arr[posn*2+1])){
                boolean checkChild1 = arr[posn].compare(arr[posn*2]);
                if(checkChild1 == false){
                    swap(posn, posn*2);
                }
                // posn = posn*2;
            }
            else if(arr[posn*2+1] != null && arr[posn*2] == null || arr[posn*2+1].compare(arr[posn*2])){
                boolean checkChild2 = arr[posn].compare(arr[posn*2+1]);
                if(checkChild2 == false){
                    swap(posn, posn*2+1);
                }
                // posn = posn*2+1;
            }
            posn = posn*2;
        }

        return forReturn;
    }

    // This is an optional function, you may use it if you know what it is
    // This function is complete, no need to edit
    public void swap(int index1, int index2){
        Node temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
