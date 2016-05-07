package algorithmPractice;

import java.util.Random;

public class RandomPermuteArray {

	// Test
	public static void main(String[] args) {
		
		int[] A1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		int[] A2 = permuteBySorting(A1);
		
		for (int item: A2) {
			System.out.print(item + ", ");
		}

	}
	
	// Randomize any given array A by a random priority list P
	public static int[] permuteBySorting(int[] A) {
		
		int n = A.length;
		int[] P = new int[n];
		Random rand = new Random();
		
		for(int i = 0; i < n; i ++) {
			// Use the range 1 ~ n^3 to ensure all priorities P[i] are likely to be unique
			P[i] = rand.nextInt(n^3) + 1;
		}
		
		return nonDecreasingSortWithPriority(A, P);	
	}

	// Non-decreasing sort, using P as sort key of A
	public static int[] nonDecreasingSortWithPriority(int[] A, int[] P) {

		for (int j = 1; j < P.length; j++) {
			int key = P[j];
			int key2 = A[j];
			int i = j - 1;
			while (i >= 0 && P[i] > key) {
				P[i + 1] = P[i];
				A[i + 1] = A[i];
				i--;
			}
			P[i + 1] = key;
			A[i + 1] = key2;
		}
		
		return A;
	}

}
