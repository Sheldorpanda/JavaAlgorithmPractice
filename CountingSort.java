package algorithmPractice;

public class CountingSort {
	
	// All sorting by comparing input elements are comparision sort, e.g.: QuickSort and HeapSort
	// Comparison sort: running time O(n*lg(n)), worst case: Omega(n*lg(n)) times of comparison
	// Linear sort: running time O(n)

	// Test
	public static void main(String[] args) {
		
		int[] A1 = {9, 18, 76, 89, 100, 89, 23, 28, 23, 74};
		int[] B1 = countingSort(A1);
		for(int item: B1) {
			System.out.print(item + ", ");
		}
		
	}
	
	// Counting sort: assume all n inputs are in range 0 to k
	// Count the number of elements less than the element, then put the element directly into that position
	public static int[] countingSort(int[] A) {
		// Initialize all counts = 0, by Java default value
		int k = findMax(A) + 1;
		int[] C = new int[k];

		// Counting
		for(int item: A) {
			C[item] ++;
		}
		
		// Get series from sequence by summation
		for(int i = 1; i < k; i ++) {
			C[i] += C[i-1];
		}

		// Put elements in output array
		int[] B = new int[A.length];
		for(int i = A.length - 1; i >= 0; i --) {
			B[C[A[i]] - 1] = A[i];
			C[A[i]] --;
		}
		return B;
	}
	
	// Find the max to get the range
	public static int findMax(int[] A) {
		int max = A[0];
		for(int item: A) {
			if(item > max) {
				max = item;
			}
		}
		return max;
	}

}
