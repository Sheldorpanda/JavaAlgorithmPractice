package algorithmPractice;

// An unbounded branch tree consisting of tree nodes
// Left-child-right-sibling representation
public class Tree<T> {

	private TreeNode<T> root;
	private int treeSize;

	// Accessors and mutators
	public TreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(TreeNode<T> _root) {
		root = _root;
	}

	public int getTreeSize() {
		return treeSize;
	}

	// Constructor with root
	public Tree(TreeNode<T> _root) {
		root = _root;
		treeSize = 1;
	}

	// Constructor without root
	public Tree() {
		root = null;
		treeSize = 0;
	}

	// Add a child to a tree node
	public void addChild(TreeNode<T> n, TreeNode<T> newChild) {
		if (n.getLeft() == null) {
			n.setLeft(newChild);
			treeSize++;
		} else {
			this.addSibling(n.getLeft(), newChild);
		}
	}

	// Add a sibling to a tree node
	public void addSibling(TreeNode<T> n, TreeNode<T> newSibling) {
		TreeNode<T> rightMostSibling = n;
		while (rightMostSibling.getRight() != null) {
			rightMostSibling = rightMostSibling.getRight();
		}
		rightMostSibling.setRight(newSibling);
		treeSize++;
	}

	// Print a size-n tree in time O(n)
	// 1, Go through all siblings (if not null)
	// 2, Recursion on the left-most-child of this level (root and siblings, if
	// not null)
	// Pattern: parent[child1, child2]
	public String walk(TreeNode<T> _root) {
		String retVal = _root.getKey().toString();
		if (_root.hasChild()) {
			retVal += "[" + walk(_root.getLeft()) + "]";
		}
		if (_root.hasSibling()) {
			retVal += ", " + walk(_root.getRight());
		}
		return retVal;
	}

	@Override
	public String toString() {
		return walk(root);
	}

}
