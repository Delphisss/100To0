// This node contains information about an investor (investorID) who submits an order (sell order = minHeap, buy order = maxHeap)
// at a certain time (timestamp) and a certain price (price)
public class Node {
    
    double price;
    int investorID;
    int amount;
    int timestamp; // Heap.push() is the only function that modify this variable
    boolean isMinHeap;
    
    public Node(double price, int investorID, int amount, boolean isMinHeap){
        this.price = price;
        this.investorID = investorID;
        this.amount = amount;
        this.isMinHeap = isMinHeap;
    }
    
    // This function will return true if Priority(thisNode) > Priority(rightNode)
    // minHeap: the lower the price, the higher the priority
    // maxHeap: the lower the price, the lower the priority
    // If same price, the smaller the timestamp is, the higher the priority will be
    public boolean compare(Node rightNode){
        if (this.price == rightNode.price) {
            if(this.timestamp < rightNode.timestamp) {return true;}
            else return false;
        }else{
            if (isMinHeap){
                if(this.price < rightNode.price) return true;
                else return false;
            }else{
                if(this.price > rightNode.price) return true;
                else return false;
            }
        }
    }
    
    public Node(){} // Dummy constructor, no need to edit
}
