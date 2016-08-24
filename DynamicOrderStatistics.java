package algorithmPractice;

// To augment a data structure, generally:
// 1. Choose an underlying data structure.
// 2. Determine additional information to maintain in the underlying data structure.
// 3. Verify that we can maintain the additional information for the basic modifying
// operations on the underlying data structure.
// 4. Develop new operations.
// These two operations are new operations based on augmented tree (balanced binary)
public class DynamicOrderStatistics<T> {
	
	// Select an object for a given rank from an in-order binary tree
	public T OSSelect(TreeNode<T> tn, int r) {
		T retVal = null;
		if(r == tn.getLeft().size() + 1) {
			retVal = tn.getKey();
		} else if(r < tn.getLeft().size() + 1) {
			retVal = OSSelect(tn.getLeft(), r);
		} else {
			retVal = OSSelect(tn.getRight(), r);
		}
		return retVal;
	}
	
	// Get rank of an object
	public int OSRank(Tree<T> t, TreeNode<T> tn){
		int r = 0;
		if(tn.getLeft() != null){
			r = tn.getLeft().size() + 1;
		} else {
			r = 1;
		}
		TreeNode<T> temp = tn;
		while(!temp.equals(t.getRoot())){
			// Warning: null
			if(temp.equals(temp.getParent().getRight())){
				r = r + temp.getParent().getLeft().size() + 1;
			}
			temp = temp.getParent();
		}
		return r;
	}

}
