package algorithmPractice;

public class BinarySearchTree {

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
	public BinarySearchTree(TreeNode _root) {
		root = _root;
		treeSize = 1;
	}

	// Insertion
	public void treeInsert(BinarySearchTree t, TreeNode z) {
		TreeNode y = null;
		TreeNode x = t.getRoot();
		while (!x.equals(null)) {
			y = x;
			if((int)z.getKey() < (int)x.getKey()) {
				x = x.getLeft();
			} else {
				x = x.getRight();
			}
		}
		if(y.equals(null)) {
			t.setRoot(z);
		} else if((int)z.getKey() < (int)y.getKey()){
			y.setLeft(z);
		} else {
			y.setRight(z);
		}
	}

	// Test
	public static void main(String[] args) {

	}

}
