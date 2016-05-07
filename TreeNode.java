package algorithmPractice;

public class TreeNode {

	// A tree node consists of leftmost child and right sibling
	private TreeNode left;
	private TreeNode right;
	private TreeNode parent;
	private Object key;

	// Accessors and mutators
	public TreeNode getLeft() {
		return this.left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
		left.setParent(this);
	}

	public TreeNode getRight() {
		return this.right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
		right.setParent(this);
	}
	
	public TreeNode getParent() {
		return this.parent;
	}
	
	private void setParent(TreeNode parent) {
		parent.setLeft(this);
		this.setParent(parent);
	}

	public Object getKey() {
		return key;
	}

	public void setKey(Object key) {
		this.key = key;
	}

	// Constructor
	public TreeNode(Object _key) {
		this.key = _key;
	}

	// If has a child
	public boolean hasChild() {
		return this.getLeft() != null;
	}

	// If has a sibling
	public boolean hasSibling() {
		return this.getRight() != null;
	}

}
