public class SinglyLinkedList {
    Node head;
    String listName;

    public SinglyLinkedList(String name){
        //START FIX HERE
        this.listName = name; //define list name
        //END FIX HERE
    }

    
    public void popTail() {
        //START FIX HERE
        if (isEmpty()) {
            System.out.println("ERROR");
        }
        else {
            Node cur = this.head;
            if(cur.next == null){   //if have last one in list remove it
                this.head = null;
            }
            else{ //if have many item in list
                while(cur != null){ 
                    Node next = cur.next;
                    if(next.next == null){  //set Node next is last node
                        cur.next = null; //remove last node
                    }
                    cur = cur.next; 
                }
            }

        }
        //END FIX HERE
    }
    
    public void popHead(){
        //START FIX HERE
        if (isEmpty()) {
            System.out.println("ERROR");
        }
        else {
            Node cur = this.head;
            if(cur.next == null){   //if have last one in list remove it
                this.head = null;
            }
            else{ //if have many item in list
                this.head = cur.next;
                cur.next = null;    //remove first node
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
            Node cur = this.head;
            while(cur != null){
                if(cur.next == null){ //set cur is last node
                    break;
                }
                cur = cur.next;
            }
            return cur; //return last node
        }
        //END FIX HERE
    }
    
    public void pushHead(Node node){
        //START FIX HERE
        if (isEmpty()) { //if it is empty push it to list
            this.head = node;
            node.next = null;
        }
        else {  //if it isn't empty push it to first node
            Node cur = this.head;
            node.next = cur;
            this.head = node;
        }
        //END FIX HERE
    }
    
    public void pushTail(Node node) {
        //START FIX HERE
        if (isEmpty()) {    //if it is empty push it to list
            this.head = node;
            node.next = null;
        }
        else {  //if it isn't empty push it to last node
            Node cur = this.head;
            while(cur != null){
                if(cur.next == null){
                    cur.next = node;
                    node.next = null;
                    break;
                }
                cur = cur.next;
            }
        }
        //END FIX HERE
    }

    public Node findNode(int id){
        //START FIX HERE
        if (isEmpty()) { //if it is empty return "Empty List!"
            return new Node("Empty List!");
        }
        else {
            Node cur = this.head;
            while(cur != null){ //find node that heroId == id
                if(cur.heroId == id){   //if found it return that node
                    return cur;
                }
                cur = cur.next;
            }
            return new Node("Hero Not Found!"); //if not found return "Hero Not Found!"
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
            Node pre = cur;
            while(cur != null){
                if(cur.heroId == id){
                    if(cur == this.head){   //if Node cur is first node
                        this.popHead(); //remove first node
                    }
                    else if(cur.next == null){  //if Node cur is last node
                        this.popTail(); //remove last node
                    }
                    else{   //if Node cur isn't first node and last node 
                        pre.next = cur.next;
                        cur.next = null;    //remove node cur
                    }
                    return cur;
                }
                pre = cur;
                cur = cur.next;
            }
            return new Node("Hero Not Found!"); //if not found return "Hero Not Found!"
        //END FIX HERE
        }
    }
    
    public void addNodeAfter(Node node1, Node node2){
        //START FIX HERE
        Node cur = this.head;
        while(cur != null){
            if(cur == node1){   //set Node cur is node1
                break;
            }
            cur = cur.next;
        }
        if(cur.next == null){   //if Node cur is last node 
            this.pushTail(node2);
        }
        else{   //if Node cur isn't last node 
            Node next = cur.next;
            cur.next = node2;   
            node2.next = next; //add new node
        }
        //END FIX HERE
    }
    
    public void addNodeBefore(Node node1, Node node2){
        //START FIX HERE
        Node cur = this.head;
        Node pre = cur;
        while(cur != null){
            if(cur == node1){   //set Node cur is node1
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        if(cur == this.head){   //if Node cur is first node 
            this.pushHead(node2); //add new node to node head
        }
        else{   //if Node cur isn't first node
            pre.next = node2;
            node2.next = cur;   //add new node
        }
        //END FIX HERE
    }
    
    public boolean isEmpty(){
        //START FIX HERE
        if(this.head == null) return true;  //if list is empty return true
        else return false;  //if list isn't empty return false
        //END FIX HERE
    }

    public void merge(SinglyLinkedList list){
        //START FIX HERE
        if (list.isEmpty()) return; //if new list is empty do nothing 
        else{   //if new list isn't empty merge it together
            Node cur = this.head;
            while(cur != null){
                if(cur.next == null){   //set Node cur is last node
                    break;
                }
                cur = cur.next;
            }
            cur.next = list.head;
        }
        //END FIX HERE
    }
    
    // public void printStructure(){
    //     //START FIX HERE
    //     System.out.print(listName + ": head <-> ");

    //     System.out.println("tail");
    //     //END FIX HERE
    // }
    

    public void printStructure(){
        Node nodeIndex = this.head;
        System.out.print(listName + ": head -> ");

        while (nodeIndex != null) {
            System.out.print("{" + nodeIndex.heroId + "} -> ");
            nodeIndex = nodeIndex.next;
        }

        System.out.println("null");
    }

    public Node getHighestPowerHero(){
        //START FIX HERE
        if (isEmpty()) {
            return new Node("Empty List!");
        }
        else {  //if isn't empty find maxpower and return it
            Node cur = this.head;
            Node max = cur; //create Node max to keep max node
            double maxpower = max.power;    //create maxpower to keep max power
            while(cur != null) {
                if(maxpower <= cur.power){
                    maxpower = cur.power;
                    max = cur;
                }
                cur = cur.next;
            }
            return max;
        }
        //END FIX HERE
    }
}
