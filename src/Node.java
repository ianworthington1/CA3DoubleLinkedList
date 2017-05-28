
public class Node implements iNode{
	
	//How to find the next node
	//Where to store
	
	public Node next; //type of Node under variable name next.
	public Node previous; //type of Node under variable name previous.
	public Object data; //type of Object under variable name data == loosely coupled by generic type
	
	public Node(Node next, Node previous, Object data){
		this.next = next;
		this.previous = previous;
		this.data = data;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public Node getPrevious() {
		return previous;
	}
	
	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = data;
	} 
	
}