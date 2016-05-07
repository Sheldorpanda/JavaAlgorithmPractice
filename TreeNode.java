package algorithmPractice;

public class TreeNode<T> {

	// A tree node consists of leftmost child and right sibling
	// This is similar to a red-black tree node, which has an additional
	// attribute
	private TreeNode<T> left;
	private TreeNode<T> right;
	private T key;

	// Accessors and mutators
	public TreeNode<T> getLeft() {
		return this.left;
	}

	public void setLeft(TreeNode<T> left) {
		this.left = (TreeNode<T>) left;
	}

	public TreeNode<T> getRight() {
		return this.right;
	}

	public void setRight(TreeNode<T> right) {
		this.right = right;
	}

	public T getKey() {
		return key;
	}

	public void setKey(T key) {
		this.key = key;
	}

	// Constructor, a tree node has a key and an attribute
	// If attribute.equals(null), it is the root
	public TreeNode(T _key) {
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
