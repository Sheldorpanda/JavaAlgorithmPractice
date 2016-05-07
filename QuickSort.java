package algorithmPractice;

public class QuickSort {

	// Divide: partition (rearrange) subarray A[p...r] to A[p...q-1] and
	// A[q+1...r]
	// such that each element in former is less than or equal to the latter
	// Conquer: sort subarrays A[p..q-1] and A[q+1...r] by recursion calls
	// Combine: all elements are in their position, no need to combine

	// Test
	public static void main(String[] args) {
		
		int[] A1 = {89, -11, 239, 0, 11, 23, 99, 100, 1, 99, 18, 101, 23, 1932, -99};
		quickSort(A1, 0, A1.length - 1);
		for(int item: A1) {
			System.out.print(item + ", ");
		}
	}
	
	// Quick sort: recursive call of partition
	// Good partition: subarray of (n-1)/2 and (n-1)/2, bad partition: subarray of 0 and n-1
	// Average case when a good partition followed by a bad partition: O(n*lg(n))
	public static void quickSort(int[] A, int p, int r) {
		if (p < r) {
			int q = partition(A, p, r);
			quickSort(A, p, q - 1);
			quickSort(A, q + 1, r);
		}
	}
	
	// Partition the array into 3 parts:
	// If element < pivot, put before pivot, if element > pivot, put after pivot
	// Usually choose the last element as pivot
	// End with: Unsorted smaller, pivot, unsorted larger
	// Return the final position of the pivot (for recursion)
	public static int partition(int[] A, int p, int r) {
		// select A[r] as the pivot element
		int x = A[r];
		int i = p - 1;
		for (int j = p; j < r; j++) {
			if (A[j] <= x) { // <=: nondecreasing, >=: nonincreasing
				i++;
				// swap A[i] and A[j]
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}
		// swap A[i+1] and A[r]
		int temp = A[i + 1];
		A[i + 1] = A[r];
		A[r] = temp;
		return (i + 1);
	}

}
