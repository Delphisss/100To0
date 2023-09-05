public class SinglyLinkedList {
    Node head;
    String listName;
    
    public SinglyLinkedList(String name){
        //set Name of list from input
        this.listName = name;
    }
    
    public void popBack() {
        if (isEmpty()){
            System.out.println("ERROR");
        }else{
            // if only one Node in list set head point to null (pop head)
            Node current = head;
            if(current.next == null){
                head = null;
            }
            /*while-loop to find the Node X, next to Node X is last node in list
            and set Node X.next as null (pop last node out of list)*/
            else{
            while(current.next.next != null){
                current = current.next;
            }
            current.next = null;
            }
        }
    }
    
    public void popFront(){
        if (isEmpty()){
            //if List is empty print "ERROR"
            System.out.println("ERROR");
        }else{
            /*set Head(first Node in list) as Head.next (next to Node from first Node) 
            because we want to popFront (skip first Node)*/
            head = head.next;
        }
    }
    
    public Node topFront(){
        if (isEmpty()){
            //if List is empty print "ERROR" and return Node that have error_msg is Empty List!
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            // if List is not empty return first node of list (head)
            return head;
        }
    }
    
    public Node topBack(){ 
        if (isEmpty()){
            //if List is empty print "ERROR" and return Node that have error_msg is Empty List!
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            /*need to find last Node of list but this is singly no-tail
            so we need while-loop from head and next ultil we find last Node
            then return that last Node*/
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            return current;
        }
    }
    
    public void pushFront(Node node){
        // Add Node at front of list
        if (isEmpty()){
            //if Node is empty set head as node that we pushed;
            head = node;
        }else{
            /* if Node isn't empty need to link that push node have next pointer to
            head node and set head to node that push to front*/
            node.next = head;
            head = node;
        }
    }
    
    public void pushBack(Node node) {
        if (isEmpty()){
            //if Node is empty set head as node
            head = node;
        } else {
            /*if Node isn't empty we need while-loop to find last Node in list
            from head.next ultil we find and let the last node in list have
            next pointer to node that we pushed*/
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = node;
        }
    }

    public Node findNode(int id){
        //if List is empty return this list is empty
        if (isEmpty()){
            return new Node("Empty List!");
        } else {
        /*if List isn't empty we need while-loop to find Node that has id 
            same as input id from head to last Node in list and return that node*/
            Node current = head;
            while(current != null){
                if(current.student_id == id){
                    return current;
                }
                current = current.next;
            }
        //if Not have Node that id same as input id return node with error_msg "Student Not Found!"
            return new Node("Student Not Found!");
        }
    }
    
    public Node eraseNode(int id){
        // if List is empty can't erase any node return Node with error_msg "Empty List!"
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
        // Need to find node use findNode function that created
            Node findID = findNode(id);
        /*if findNode function return Student Not Found so we can't delete that
            so return to caller "Student Not Found" node*/
            if(findID.name == "Student Not Found!"){
                return findID;
            }
        /*if head is node that we find so we skip head to next node (erase)*/
            else if(head == findID){
                head = head.next;
            }
        /*if head is not a node we find we need while-loop to check all node in list
        to find where Node that have id same as input is and set Node before that node
        have next pointer to node after node that we find (erase)*/
            else{
                Node current = head;
                while(current.next != findID){
                    current = current.next;
                }
                current.next = findID.next;
            }
            return findID;
    }
    }
    
    public void addNodeAfter(Node node1, Node node2){
        //if Node1 not have any node after Node1 so set Node1 next point to node2
        if(node1.next == null){
            node1.next = node2;
        }
        /*set pointer next after Node2 to Node1.next(the original node after Node1)
        and re-link Node1.next to Node2*/
        else{
            node2.next = node1.next;
            node1.next = node2;
        }
    }
    
    public void addNodeBefore(Node node1, Node node2){
        /*if head is Node1 and we need Node2 before Node1
        so we set pointer next from Node2 to Node1 and re-link head to Node2*/
        if(head == node1){
            node2.next = node1;
            head = node2;
        }
        else{
        /*Need to find where is Node before Node1 while-loop from head ultil we find
         and set pointer next from Node2 to Node1 and re-link Node that before node1 to node2*/
            Node current = head;
            while(current.next != node1){
                current = current.next;
            }
            node2.next = node1;
            current.next = node2;
        }
    }
    
    public boolean isEmpty(){
        // head will say if list is empty
        return head==null;
    }
    public void merge(SinglyLinkedList list){
        /* Merge 2 list by find the last Node of list A and
        set pointer of last Node A next to head of list we need to merge*/
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = list.head;
    }
    
    public void printStructure(){
        /*Print Structure of node we need while-loop to access all node from
        head to last node in list*/
        System.out.print(listName + ": head -> ");
        Node current = head;
        while(current != null){
            System.out.print("{" + current.student_id + "} -> ");
            current = current.next;
        }
        System.out.print("null");
        System.out.println();
        
    }
    
    public Node whoGotHighestGPA(){
        /*find HighestGPA in list we need while-loop to check All node in list
        let create temp node to compare every node in list and return that*/
        if (isEmpty()) {
            return new Node("Empty List!");
        } else {
            Node current = head;
            Node highGPA = current;
            while(current != null){
                if(highGPA.gpa <= current.gpa){
                    highGPA = current;
                }
                current = current.next;
            }
            return highGPA;
        }
    }
}
