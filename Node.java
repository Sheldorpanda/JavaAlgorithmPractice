package algorithmPractice;

// Node for doubly linked list
public class Node {

	// Due to passing in Java, prev and next are already L-values (pointers)
	protected Node prev; // prev Node pointed
	protected Node next; // next Node pointed
	protected Object data; // key

	// Constructor, no specified pointed Node
	public Node(Object data) {
		this.prev = null;
		this.next = null;
		this.data = data;
	}

	// Constructor, specified pointed Nodes (Insertion)
	public Node(Node _prev, Node _next, Object data) {
		this.prev = _prev;
		this.next = _next;
		this.data = data;
		_prev.next = this;
		_next.prev = this;
	}

	// Equals
	@Override
	public boolean equals(Object o) {
		boolean retVal = false;
		if (o instanceof Node) {
			Node n = (Node) o;
			retVal = this.prev.equals(n.getPrev()) && this.data.equals(n.getData()) && this.next.equals(n.getNext());
		}
		return retVal;
	}

	// toString
	@Override
	public String toString() {
		return "Prev: " + this.getPrev() + "; Data: " + this.data + "; Next: " + this.next;
	}

	// Accessors and mutators
	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
