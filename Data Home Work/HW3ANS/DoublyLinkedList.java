public class DoublyLinkedList {
    Node head;
    Node tail;
    String listName;
    
    public DoublyLinkedList(String name){
        //set listName = name
        this.listName = name;
    }
    
    public void popBack() {
      if (isEmpty()){
          System.out.println("ERROR");
        }else{
          tail = tail.previous;
          if(tail == null) {
              head = null;
              return;
          }
          tail.next = null;
          }
    }
    
    public void popFront(){
        if (isEmpty()){
            System.out.println("ERROR");
        }else{
            head = head.next;
            if(head == null){
                tail = null;
                return;
            }
            head.previous = null;
        }
    }
    
    public Node topFront(){
       if (isEmpty()){
            /*if linkedlist is empty print "ERROR" and
            return node that has error_msg*/
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
           // return node
            return head;
        }
    }
    
    public Node topBack(){
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            return tail;
        }
    }
    
    public void pushFront(Node node){
        if (isEmpty()){
            // if linkedlist is empty make head point to node
            head = node;
            tail = node;
        }else{

            node.next = head;
            head.previous = node;
            head = node;
        }
    }
    
    public void pushBack(Node node) {
        if (isEmpty()) {
            /* if linkedlist is empty head point to new node*/
            head = node;
            tail = node;
        } else {
            /* if linklist is not empty make temp node to store tail
            set tail.next to new node and make tail set to last node in linked
            list and set last node previous to temp that store tail node before
            we pushback*/
            node.previous = tail;
            tail.next = node;
            tail = node;
        }
    }

    public Node findNode(int id){
        if (isEmpty()){
            return new Node("Empty List!");
        } else {
          Node current = head;
          while(current!=null){
              if(current.student_id == id){
                  return current;
              }
              current = current.next;
          }
          return new Node("Student Not Found!");
    }
    }
    
    public Node eraseNode(int id){
        if (isEmpty()){
            
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            Node cur=findNode(id);
            Node temp=cur;
            if(temp.name=="Student Not Found!")
            {
                return temp;
            }
            if(cur==head)
            {
            head=cur.next;
            head.previous=null;
            
            }
            else if(cur==tail)
            {
                
                tail=cur.previous;
                tail.next=null;
            }
            else
            {
            cur.next.previous=cur.previous;
            cur.previous.next=cur.next;
            }
            return temp;
        }
    }
    
    public void addNodeAfter(Node node1, Node node2){
        if(node1.next == null){
            node1.next = node2;
            node2.previous = node1;
            tail = node2;
        }
        else {
            node2.next = node1.next;
            node2.previous = node1;
            node1.next.previous = node2;
            node1.next = node2;
        }
    }
    
    public void addNodeBefore(Node node1, Node node2){
        if(node1.previous == null){
            node2.next = node1;
            node1.previous = node2;
            head = node2;
        }
        else {
            node2.next = node1;
            node2.previous = node1.previous;
            node1.previous.next = node2;
            node1.previous = node2;
        }
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    public void merge(DoublyLinkedList list){
        tail.next = list.head;
        list.head.previous = tail;
        tail = list.tail;
    }
    
    public void printStructure(){
        Node current = head;
        System.out.print(listName + ": head <-> ");
        while(current!=null){
            System.out.print("{" + current.student_id + "}" +" <-> ");
            current = current.next;
        }
        System.out.println("tail");
    }
    
    // This may be useful for you for implementing printStructure()
    public void printStructureBackward(){ 
        Node current=tail;
        System.out.print(listName + ": tail <-> ");
        while(current!=null){
            System.out.print("{" + current.student_id + "} <-> ");
            current = current.previous;
        }
        System.out.println("head");
    }
    
    public Node whoGotHighestGPA(){
        if (isEmpty()) {
            return new Node("Empty List!");
        } else {
            Node current = head;
            Node top = current;
            while(current!=null){
                if(top.gpa <= current.gpa){
                    top = current;
                }
                current = current.next;
            }
            return top;
        }
    }
}
