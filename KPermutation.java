package algorithmPractice;

import java.util.Random;

public class KPermutation {
	
	// Test
	public static void main(String[] args) {
		
		int[] A1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] A2 = randomizeInPlace(A1);
		
		for (int item: A2) {
			System.out.print(item + ", ");
		}
	}
	
	// A better method than Randomized Priority List
	// Each permuted array before swap at i is a (i-1)-permutation
	// By MI, each n-permutation has probability 1/(n!)
	public static int[] randomizeInPlace(int[] A) {
		Random rand = new Random();
		
		for(int i = 0; i < A.length; i ++) {
			// Swap A[i] and A[Random(i,n)]
			int r = rand.nextInt(A.length -1 - i + 1) + i;
			int temp = A[i];
			A[i] = A[r];
			A[r] = temp;	
		}
		
		return A;	
	}

}
