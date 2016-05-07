package algorithmPractice;

public class InsertionSort {
	
	// Worst efficiency of sorting: O(n^2)
	
	public static void main(String[] args) {
		
		int[] A1 = {8, 6, 23, 9, 7, 55, 16};
		int[] A2 = nonDecreasingSort(A1);
		int[] A3 = {8, 6, 23, 9, 7, 55, 16};
		int[] A4 = nonIncreasingSort(A3);
		int[] A5 = {8, 6, 23, 9, 7, 55, 16};
		
		for (int item: A2) {
			System.out.print(item + " ");
		}
		
		System.out.println("");
		
		for (int item: A4) {
			System.out.print(item + " ");
		}
		
		System.out.println("");
		System.out.println(linearSearch(A5, 9));
		System.out.println(linearSearch(A5, 11));
		
		int[] B1 = {0, 1, 0, 0, 0};
		int[] B2 = {1, 1, 1, 0, 1};
		int[] B3 = binarySum(B1, B2);
		for (int item: B3) {
			System.out.print(item + " ");
		}
	}
	
	// Non-decreasing sort
	public static int[] nonDecreasingSort(int[] A) {
		// Loop invariant
		// Initialization: j = 1, i = 0, A[i] = A[0]
		// Maintenance: For every j, A[0] to A[j-1] are already sorted
		// Termination: At j = A.length, A[0] to A[-1] are all sorted
		for (int j = 1; j < A.length; j ++) {
			int key = A[j];
			// Insert A[j] in to the sorted sequence
			int i = j - 1;
			while (i >= 0 && A[i] > key) {
				A[i + 1] = A[i];
				i --;
			}
			A[i + 1] = key;
		}
		return A;
	}
	
	// Non-increasing sort
	public static int[] nonIncreasingSort(int[] A) {
		
		for (int j = 1; j < A.length; j ++) {
			int key = A[j];
			int i = j - 1;
			while (i >= 0 && A[i] < key) {
				A[i + 1] = A[i];
				i --;
			}
			A[i + 1] = key;
		}
		return A;
	}
	
	// Linear search
	public static int linearSearch(int[] A, int v) {
		int j = 0;
		while (j < A.length && A[j] != v) {
			j ++;
		}
		if (j == A.length) {
			return -1;
		}
		return j;
	}
	
	// Binary sum by arrays
	public static int[] binarySum(int[] A, int[] B) {
		int[] C = new int[A.length + 1];
		int add = 0;
		int j = C.length - 1;
		while(j > 0) {
			C[j] = (A[j-1] + B[j-1] + add) % 2;
			add = (A[j-1] + B[j-1] + add) / 2;
			j --;
		}
		C[0] = add;
		return C;
	}
}
