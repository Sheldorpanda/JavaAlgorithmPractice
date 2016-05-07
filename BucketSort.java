package algorithmPractice;

import java.util.ArrayList;

public class BucketSort {
	// Speed is the same as CountingSort: O(n)
	// However, no limit in range, better than CountingSort
	// Assumes elements are randomly generated and uniformly distributed in n
	// equal-sized buckets in a range

	// Test
	public static void main(String[] args) {
		
		int[] A1 = { 89, -11, 239, 0, 11, 23, 99, 100, 1, 99, 18, 101, 23, 1932, -99 };
		int[] B1 = bucketSort(A1, 2);
		for(int item: B1) {
			System.out.print(item + ", ");
		}

	}
	
	// Sort in n buckets
	@SuppressWarnings("unchecked")
	public static int[] bucketSort(int[] A, int n){
		
		int[] retVal = {};
		
		// Determine bucket size
		int min = findMin(A);
		int range = findMax(A) - findMin(A);
		double bucketSize = (double)range/n;
		
		ArrayList<Integer>[] bucket = new ArrayList[n + 1];
		
		// Instantiate elements in bucket
		for(int i = 0; i < bucket.length; i ++){
			bucket[i] = new ArrayList<Integer>();
		}
		
		// Fill bucket
		for(int item: A) {
			int bucketNum = (int)((item - min)/bucketSize);
			bucket[bucketNum].add(item);
		}
		
		
		// Convert each ArrayList to Array
		for(ArrayList<Integer> item: bucket) {
			int[] B = new int[item.size()];
			for(int i = 0; i < B.length; i ++) {
				B[i] = item.get(i);
			}
			// Call insertion sort for each bucket, does not affect time = O(n)
			int[] C = InsertionSort.nonDecreasingSort(B);
			retVal = conctArrays(retVal, C);
		}
		
		return retVal;
		
	}
	
	// Concatenate arrays
	public static int[] conctArrays(int[] A, int[] B){
		
		int[] C = new int[A.length + B.length];
		for(int i = 0; i < A.length; i ++) {
			C[i] = A[i];
		}
		for(int i = 0; i < B.length; i ++) {
			C[i + A.length] = B[i];
		}
		return C;
		
	}
	
	// Find max
	public static int findMax(int[] A) {
		int max = A[0];
		for(int item: A) {
			if(item > max) {
				max = item;
			}
		}
		return max;
	}
	
	// Find min
	public static int findMin(int[] A) {
		int min = A[0];
		for(int item: A) {
			if(item < min) {
				min = item;
			}
		}
		return min;
	}

}
