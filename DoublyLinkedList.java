public class DoublyLinkedList {
    Node head;
    Node tail;
    String listName;
    
    public DoublyLinkedList(String name){
        //START FIX HERE
        
        this.listName = name; //define list name
        //END FIX HERE
    }
    
    public void popTail() {
        //START FIX HERE
        if (isEmpty()) {    //if it is empty print "ERROR"
            System.out.println("ERROR");
        }
        else {  //if it isn't empty 
            if(this.head == this.tail){ //if have last one in list remove it
                this.head = null;
                this.tail = null;
            }
            else{   //if have more one item in list remove last node
                this.tail = this.tail.previous;
                this.tail.next = null;
            }
        }
        //END FIX HERE
    }
    
    public void popHead(){
        //START FIX HERE
        if (isEmpty()) {    //if it is empty print "ERROR"
            System.out.println("ERROR");
        }
        else {  //if it isn't empty 
            if(this.head == this.tail){ //if have last one in list remove it
                this.head = null;
                this.tail = null;
            }
            else{   //if have more one item in list remove first node
                Node next = this.head.next;
                next.previous = null;
                this.head = next;
            }
        }
        //END FIX HERE
    }
    
    public Node getHead(){
        //START FIX HERE
        if (isEmpty()) {
            System.out.println("ERROR");
            return new Node("Empty List!");
        }
        else {
            return this.head;
        }
        //END FIX HERE
    }
    
    public Node getTail(){
        //START FIX HERE
        if (isEmpty()) {
            System.out.println("ERROR");
            return new Node("Empty List!");
        }
        else {
            return this.tail;
        }
        //END FIX HERE
    }
    
    public void pushHead(Node node){
        //START FIX HERE
        if (isEmpty()) {    //if list is empty push node to list
            this.head = node;
            node.previous = null;
            node.next = null;
            this.tail = node;
        }
        else {  //if list isn't empty push node to first node
            node.next = this.head;
            this.head.previous = node;
            node.previous = null;
            this.head = node;
        }
        //END FIX HERE
    }
    
    public void pushTail(Node node) {
        //START FIX HERE
        if (isEmpty()) {    //if list is empty push to first node
            this.head = node;
            node.previous = null;
            node.next = null;
            this.tail = node;
        }
        else {  //if list isn't empty push to last node
            this.tail.next = node;
            node.previous = this.tail;
            node.next = null;
            this.tail = node;
        }
        //END FIX HERE
    }

    public Node findNode(int id){
        //START FIX HERE
        if (isEmpty()) { // if it is empty return node constructor with error message "Empty List!"
            return new Node("Empty List!");
        }
        else { // if it isn't empty find node that heroId == id
            Node cur = this.head;
            while(cur != null){ // find node that heroId == id
                if(cur.heroId == id){   // if find heroId == id return that node
                    return cur; 
                }
                cur = cur.next; //go to next node
            }
            return new Node("Hero Not Found!"); //if not found that node return node constructor with error message "Hero Not Found!"
        }
        //END FIX HERE
    }
    
    public Node eraseNode(int id){
        //START FIX HERE
        if (isEmpty()) {
            System.out.println("ERROR");
            return new Node("Empty List!");
        }
        else {
            Node cur = this.head;
            while(cur != null){ // find node that heroId == id
                if(cur.heroId == id){
                    if(cur == tail) this.popTail(); //if it is last node use poptail()
                    else if(cur == head) this.popHead();    //if it is first node use pophead()
                    else{   //if it isn't first and last node remove that node
                        Node pre = cur.previous;
                        Node next = cur.next;
                        pre.next = cur.next;
                        next.previous = cur.previous;
                        cur.next = null;
                        cur.previous = null;
                    }
                    return cur; 
                }
                cur = cur.next; //go to next node
            }
            return new Node("Hero Not Found!"); //if not found that node return node constructor with error message "Hero Not Found!"
        }
        //END FIX HERE
    }
    
    public void addNodeAfter(Node node1, Node node2){
        //START FIX HERE
        Node cur = this.head;
        while(cur != null){ // find node that is node1
            if(cur == node1){
                if(cur == this.tail){   //if it is last node use pushTail(node2)
                    this.pushTail(node2);
                }
                else{   //if isn't add node2 to list
                    Node next = cur.next;
                    cur.next = node2;
                    next.previous = node2;
                    node2.previous = cur;
                    node2.next = next;
                }
            }
            cur = cur.next;
        }
        //END FIX HERE
    }
    
    public void addNodeBefore(Node node1, Node node2){
        //START FIX HERE
        Node cur = this.head;
        while(cur != null){ // find node that is node1
            if(cur == node1){
                if(cur == this.head){   //if it is first node use pushHead(node2)
                    this.pushHead(node2);
                }
                else{   //if isn't add node2 to list
                    Node pre = cur.previous;
                    pre.next = node2;
                    cur.previous = node2;
                    node2.previous = pre;
                    node2.next = cur;
                }
            }
            cur = cur.next;
        }
        //END FIX HERE
    }
    
    public boolean isEmpty(){
        //START FIX HERE
        if(this.head == null && this.tail == null) return true; //if list is empty return true
        else return false;  //if list isn't empty return false
        //END FIX HERE
    }

    public void merge(DoublyLinkedList list){
        //START FIX HERE
        if (list.isEmpty()) return; //if new list is empty do nothing
        else{   //if new list isn't empty merge it together
            this.tail.next = list.head;
            list.head.previous = this.tail;
            this.tail = list.tail;
        }
        //END FIX HERE
    }
    
    public void printStructure(){
        //START FIX HERE
        System.out.print(listName + ": head <-> ");
        Node cur = this.head;
        while(cur != null){ //print item in list
            System.out.print("{" + cur.heroId + "}");
            System.out.print(" <-> ");
            cur = cur.next;
        }
        System.out.println("tail");
        //END FIX HERE
    }
    
    // This may be useful for you for implementing printStructure()
    public void printStructureTailward(){ 
        Node current = tail;
        System.out.print(listName + ": tail <-> ");
        while(current != null){
            System.out.print("{" + current.heroId + "} <-> ");
            current = current.previous;
        }
        System.out.println("head");
    }
    
    public Node getHighestPowerHero(){
        //START FIX HERE
        if (isEmpty()) {
            return new Node("Empty List!");
        }
        else { //if isn't empty find maxpower and return it
            Node cur = this.head;
            Node max = cur; //create Node max to keep max node
            double maxpower = max.power;    //create maxpower to keep max power
            while(cur != null){
                if(maxpower <= cur.power){
                    max = cur;
                    maxpower = max.power;
                }
                cur = cur.next;
            }
            return max;
        }
        //END FIX HERE
    }
}
