package algorithmPractice;

public class RedBlackTreeNode<T> extends TreeNode<T>{

	private RedBlackTreeNode<T> left;
	private RedBlackTreeNode<T> right;
	private RedBlackTreeNode<T> parent;
	private T key;
	// 1, A node must have a color red or black
	// 2, Root and leaves (null) are black
	// 3, If a node is red, both children are black
	// 4, All paths from a node to all descendant leaves contain same number of
	// black nodes
	private boolean red;

	// Accessors and mutators
	public RedBlackTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(RedBlackTreeNode<T> left) {
		this.left = left;
		if (this.red) {
			this.left.setRed(false);
		}
		this.left.setParent(this);
	}

	public RedBlackTreeNode<T> getRight() {
		return right;
	}

	public void setRight(RedBlackTreeNode<T> right) {
		this.right = right;
		if (this.red) {
			this.left.setRed(false);
		}
		this.right.setParent(this);
	}

	public RedBlackTreeNode<T> getParent() {
		return parent;
	}

	public void setParent(RedBlackTreeNode<T> parent) {
		this.parent = parent;
	}

	public boolean isRed() {
		return red;
	}

	public void setRed(boolean red) {
		this.red = red;
	}

	// Equals, for null == null
	@Override
	public boolean equals(Object o) {
		boolean e0 = true;
		boolean e1 = true;
		boolean e2 = true;
		if (!(o instanceof RedBlackTreeNode)) {
			return false;
		}
		@SuppressWarnings("unchecked")
		RedBlackTreeNode<T> n = (RedBlackTreeNode<T>) o;
		if (this.getLeft() != null && n.getLeft() != null) {
			e0 = this.getLeft().equals(n.getLeft());
		}
		if (this.key != null && n.getKey() != null) {
			e1 = this.key.equals(n.getKey());
		}
		if (this.getRight() != null && n.getRight() != null) {
			e2 = this.getRight().equals(n.getRight());
		}
		return e0 && e1 && e2 && (this.isRed() == n.isRed());
	}

	// Left-rotation
	public void leftRotate() {
		RedBlackTreeNode<T> p = this.getParent();
		RedBlackTreeNode<T> r = this.getRight();
		if(r != null) {
			RedBlackTreeNode<T> rl = r.getLeft();
			r.setLeft(this);
			this.setRight(rl);
		}
		boolean isLeft = false;
		if(p != null) {
			isLeft = this.equals(p.getLeft());
			if(isLeft) {
				p.setLeft(r);
			} else {
				p.setRight(r);
			}
		}
	}

	// Right-rotation
	public void rightRotate() {
		RedBlackTreeNode<T> p = this.getParent();
		RedBlackTreeNode<T> l = this.getLeft();
		if(l != null) {
			RedBlackTreeNode<T> lr = l.getRight();
			l.setLeft(this);
			this.setRight(lr);
		}
		boolean isLeft = false;
		if(p != null) {
			isLeft = this.equals(p.getLeft());
			if(isLeft) {
				p.setLeft(l);
			} else {
				p.setRight(l);
			}
		}
	}

	// Constructor
	public RedBlackTreeNode(T _key, boolean _red) {
		super(_key);
		this.red = _red;
	}

	// Constructor, default color is black (null is black)
	public RedBlackTreeNode() {
		super();
		this.red = false;
	}

}
