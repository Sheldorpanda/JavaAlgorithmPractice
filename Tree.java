package algorithmPractice;

// An unbounded branch tree consisting of tree nodes
// Left-child-right-sibling representation
public class Tree {

	private static TreeNode root;
	private static int treeSize;

	// Accessors and mutators
	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode _root) {
		root = _root;
	}

	public int getTreeSize() {
		return treeSize;
	}

	// Constructor
	public Tree(TreeNode _root) {
		root = _root;
		treeSize = 1;
	}

	// Add a child to a tree node
	public static void addChild(TreeNode n, TreeNode newChild) {
		if (n.getLeft() == null) {
			n.setLeft(newChild);
			treeSize++;
		} else {
			addSibling(n.getLeft(), newChild);
		}
	}

	// Add a sibling to a tree node
	public static void addSibling(TreeNode n, TreeNode newSibling) {
		TreeNode rightMostSibling = n;
		while (rightMostSibling.getRight() != null) {
			rightMostSibling = rightMostSibling.getRight();
		}
		rightMostSibling.setRight(newSibling);
		treeSize++;
	}

	// Print a size-n tree in time O(n)
	// 1, Crawl all siblings (if not null)
	// 2, Recursion on the left-most-child of this level (root and siblings, if
	// not null)
	// Pattern: parent[child1, child2]
	public static String fastCrawl(TreeNode _root) {
		String retVal = _root.getKey().toString();
		if (_root.hasChild()) {
			retVal += "[" + fastCrawl(_root.getLeft()) + "]";
		}
		if (_root.hasSibling()) {
			retVal += ", " + fastCrawl(_root.getRight());
		}
		return retVal;
	}

	@Override
	public String toString() {
		return fastCrawl(root);
	}

	// Test
	public static void main(String[] args) {

		TreeNode r = new TreeNode(0);
		Tree t = new Tree(r);
		TreeNode b1 = new TreeNode(1);
		TreeNode b2 = new TreeNode(2);
		TreeNode b3 = new TreeNode(3);
		TreeNode b4 = new TreeNode(4);
		TreeNode b5 = new TreeNode(5);
		addChild(r, b1);
		addChild(r, b2);
		addChild(b1, b3);
		addChild(b1, b4);
		addChild(b2, b5);
		System.out.println("Tree size: " + t.getTreeSize());
		System.out.println(t);

	}

}
