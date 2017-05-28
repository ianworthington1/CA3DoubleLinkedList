public class DoubleLinkedList implements iDLL {

	// for a DoubleLinkedList there is usually a variable that is a pointer to the previous node
	
	//Class that's responsible for maintaining the chain of nodes.
	//Needs to able to Add/Remove/Update/GetByPos etc
	
	public Node head; // going to hold a reference to the first object in the chain: A value to operated the LinkList
	public int size; // each time an object is added, increment size by 1, when delete, reduce by 1
	
	public DoubleLinkedList(){
		this.head = null;
		this.size = 0;
	}
	
	// Method to add Node to chain
	
	public void add(Object data){ // adding a new node.
		if(this.head == null){ // check if the list is currently empty.
			// The list is currently empty. Store node in head position.
			Node n = new Node(null, null, data);
			this.head = n;
		} else {
			// The List is not empty
			// Find the last node in the chain
			Node tail = getNode(size);		
			Node n = new Node(null, null, data);
			
			tail.setNext(n); // tail.next = n;
			n.setPrevious(tail);
		}
		
		this. size = size + 1;
	} // end add method
	
	//check that the list size is greater than zero, or the bounds of the list is greater than int x
	//before you call the getNode method
	// or you can make it private, so that only the SingleLinkedList class can call it
	
	//get Node at a particular position
	public Node getNode(int pos){
		Node tmp = null;
		
		for(int i = 1; i <= pos; i++) 
		{
			if (i == 1) 
			{
				tmp = this.head;
			} else 
			{
				tmp = tmp.next;
			}
		}
		
		return tmp;
	} // end getNode
	
	
	public Node updatePriority(){ // pass in a position and object data
		Node tmp = this.head;
		Node next = null;
		
		for (int i = 0; i < size; i++) {
			if (((Patient)tmp.getData()).priority == 0) { // if the Patient object's priority is 1
				next = tmp; // Node next is the same as tmp
				break;
			}
			else {
				next = null; // no next value
			}
			tmp = tmp.getNext();
		}
		return next;
	}
	
	
	public Node findHighestPriority(){ // iterate through the list to find the highest value
		Node tmp = null;
		Node head = this.head;
		
		int priority = 0;
		if (size > 0) {
			for (int i = 0; i < size; i++) {
				
				int currentPriority = ((Patient)head.getData()).priority; // currentPriority variable has value of Patient's priority attribute value
				if (currentPriority > priority) {
					priority = currentPriority;
					tmp = head;
				}
				head = head.getNext();
				
			}
		}
	
		return tmp;
		
	}
	
	public int findByPosition(Node node){ // find a Node at a particular position
		Node tmp = node;
		Node head = this.head;
		
		int position = 1;
		for (int i = 0; i < size; i++) { // iterate through the list
			if (head.getData() != tmp.getData()) { // compare Node passes as parameter, with the current node
				head = head.getNext();
				position ++; // increment position
			}
		}
		return position;
	}
	
	
	public void remove(int pos){ // remove Node at position passed as parameter
		
		Node current = getNode(pos);// find node at position pos
		
		// here it checks the position of the desired Node with the size of the list
		// and sets next and previous statements accordingly
		
		
		
		if (pos > size){
			this.head.setNext(null);
			this.head.setPrevious(null);
			
		} else if (pos < size){
			Node previous = getNode(pos - 1);
			Node next = getNode(pos + 1);
			
			current.setNext(null); //remove next reference from current node
			current.setPrevious(null); // remove previous reference from current node
			next.setPrevious(previous); // set the previous reference for the next node to that of the node before the one to be removed
			//previous.setNext(next); // set the next reference for the previous node to that of the node after the one to be removed.
			
			//this.head = current.getNext();
			//this.head.setPrevious(previous);
		
		} else if (pos == size) {
			
			current.setPrevious(null); // remove previous reference of current node
			
		} else {
			Node previous = getNode(pos - 1);
			Node next = getNode(pos + 1);
			
			previous.setNext(current.getNext());
			next.setPrevious(current.getPrevious());
		}
		this.size = size -1;
	}
	
	public String toString(){ // output to view Node data
		String tmp = "";
		
		Node n = this.head;
		
		while (n != null){
			// store student info to string
			tmp = tmp + ((Patient)n.getData()).firstname + " " + ((Patient)n.getData()).lastname + ": " + ((Patient)n.getData()).symptoms + ".";
			
			n = n.getNext();
		}
		
		return tmp;
	}
	
}
