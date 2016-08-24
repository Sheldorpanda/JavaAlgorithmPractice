package algorithmPractice;

// 1 extra bit information (boolean, in this case) than regular tree structure
// The color ensures no path from leaf to root is more than twice as any
// other path
// Hence the tree is called balanced
// A RB Tree with n nodes has max height 2*log(n+1)
public class RedBlackTree<T> {

	private RedBlackTreeNode<T> root;
	private int treeSize;

	// Accessors and mutators
	public RedBlackTreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(RedBlackTreeNode<T> root) {
		this.root = root;
	}

	public int getTreeSize() {
		return treeSize;
	}

	// RB insertion, in order
	@SuppressWarnings("null")
	public void insertion(RedBlackTreeNode<T> n) {
		// Insert the same like a regular binary tree
		// Take numerical key as example
		RedBlackTreeNode<T> temp = this.root;
		RedBlackTreeNode<T> p = null;
		while (temp != null) {
			p = temp;
			if (Integer.parseInt(n.getKey().toString()) < Integer.parseInt(temp.getKey().toString())) {
				temp = temp.getLeft();
			} else {
				temp = temp.getRight();
			}
		}
		if (p == null) {
			this.setRoot(n);
			n.setRed(false);
		} else {
			if (Integer.parseInt(n.getKey().toString()) < Integer.parseInt(temp.getKey().toString())) {
				p.setLeft(n);
			} else {
				p.setRight(n);
			}
			// Fix color
			n.setRed(true);
			this.insertFixColor(n);
		}
	}

	// Insertion fix color method, keeping balanced
	public void insertFixColor(RedBlackTreeNode<T> n) {
		RedBlackTreeNode<T> u = null;
		// Only if n.p.p exists, execute this code
		while (n.isRed() && (n.getParent().getParent() != null)) {
			// Get uncle, color of null is black
			if (n.getParent().equals(n.getParent().getParent().getLeft())) {
				u = n.getParent().getParent().getRight();
			} else {
				u = n.getParent().getParent().getLeft();
			}
			if (u != null) {
				if (u.isRed()) {
					// Case 1: uncle is red
					n.getParent().setRed(false);
					u.setRed(false);
					n.getParent().getParent().setRed(true);
					n = n.getParent().getParent();
				} else if (n.equals(n.getParent().getRight())) {
					// Case 2: uncle is black and n is right
					n = n.getParent();
					n.leftRotate();
					n.getParent().setRed(false);
					n.getParent().getParent().setRed(true);
				} else {
					// Case 3: uncle is black and n is left
					n = n.getParent();
					n.rightRotate();
					n.getParent().setRed(false);
					n.getParent().getParent().setRed(true);
				}
			}
		}
	}
	
	// RB transplant
	public void transplant(RedBlackTreeNode<T> u, RedBlackTreeNode<T> v) {
		if(u.getParent() == null) {
			this.setRoot(v);
		} else {
			if(u.equals(u.getParent().getLeft())) {
				u.getParent().setLeft(v);
			} else {
				u.getParent().setRight(v);
			}
		}
	}

	// Equals
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof RedBlackTree)) {
			return false;
		}
		@SuppressWarnings("unchecked")
		RedBlackTree<T> t = (RedBlackTree<T>) o;
		boolean retVal = true;
		if (this.getRoot() != null && t.getRoot() != null) {
			retVal = this.getRoot().equals(t.getRoot());
		}
		return retVal;
	}

	// Test
	public static void main(String[] args) {

	}

}
