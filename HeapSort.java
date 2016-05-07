package algorithmPractice;

public class HeapSort {

	// Test
	public static void main(String[] args) {

		int[] A1 = { 89, -11, 239, 0, 11, 23, 99, 100, 1, 99, 18, 101, 23, 1932, -99 };
		heapSort(A1);

		for (int item : A1) {
			System.out.print(item + ", ");
		}

	}

	// Heap: a binary tree, or can be represented as an array
	// Parent: [i/2], Left: i*2, Right: i*2+1
	// Max heap: A[Parent(i)] >= A[i], decreasing, Min heap: A[Parent(i)] <=
	// A[i], increasing

	// Heap sort: O(n*lg(n))
	// The root of the max heap must be max of the array
	// Put the root at the end of the array, then rebuild a max heap from the remained
	// Form an increasing array
	public static void heapSort(int[] A) {
		buildMaxHeap(A);
		// initial heap size: A.length - 1
		for (int i = A.length - 1; i > 0; i--) {
			// swap A[0] and A[i]
			int temp = A[i];
			A[i] = A[0];
			A[0] = temp;
			// heap size --
			maxHeapify(A, 0, i - 1);
		}
	}

	// Build max-heap: O(n), no need to cover the leaves l/2 + 1 ~ l
	public static void buildMaxHeap(int[] A) {
		// heap size: A.length - 1
		for (int i = A.length / 2; i >= 0; i--) {
			maxHeapify(A, i, A.length - 1);
		}
	}

	// Max-heapify: O(lg(n)), is the key to maintaning the max-heap property,
	// where lg means log based 2
	public static void maxHeapify(int[] A, int i, int heapSize) {
		// Find the largest A[i] in parent, left and right
		int l = left(i);
		int r = right(i);
		int largest;
		if (l <= heapSize && A[l] > A[i]) {
			largest = l;
		} else {
			largest = i;
		}
		if (r <= heapSize && A[r] > A[largest]) {
			largest = r;
		}
		// If the largest A[i] is not parent, swap largest with parent
		if (largest != i) {
			int temp = A[i];
			A[i] = A[largest];
			A[largest] = temp;
			maxHeapify(A, largest, heapSize); // recursion
		}
	}

	public static int parent(int i) {
		return i / 2;
	}

	public static int left(int i) {
		return i * 2;
	}

	public static int right(int i) {
		return i * 2 + 1;
	}

}
