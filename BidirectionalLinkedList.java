package algorithmPractice;

// A dynamic set
public class BidirectionalLinkedList {

	private Node head;
	private int listCount;

	// Accessors and mutators
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	// Constructor, to instantiate an empty set
	public BidirectionalLinkedList() {
		this.head = null;
		this.listCount = 0;
	}

	// Constructor, to instantiate with head
	public BidirectionalLinkedList(Object data) {
		this.head = new Node(data);
		this.listCount = 1;
	}

	// Add object at the end of the BLL
	public void add(Object data) {
		Node n = new Node(data);
		if (this.head != null) {
			// Crawl along the BLL
			Node current = this.head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(n);
			n.setPrev(current);
		} else {
			this.head = n;
		}
		this.listCount++;
	}

	// toString
	@Override
	public String toString() {
		String retVal = "Empty BLL";
		if (this.head != null) {
			retVal = this.head.getData().toString();
			Node current = this.head;
			while (current.getNext() != null) {
				current = current.getNext();
				retVal += ", " + current.getData();
			}
		}
		return retVal;
	}

	// Test
	public static void main(String[] args) {

		// BLL by runtime polymorphism
		Node n1 = new Node(0);
		System.out.println(n1);
		BidirectionalLinkedList bll = new BidirectionalLinkedList();
		System.out.println(bll);
		BidirectionalLinkedList bll2 = new BidirectionalLinkedList(1);
		System.out.println(bll2);
		bll2.add("A");
		System.out.println(bll2);

	}

}
