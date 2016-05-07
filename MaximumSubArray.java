package algorithmPractice;

import java.util.ArrayList;

import otherPractice.TripleDouble;

public class MaximumSubArray {
	
	// Test
	public static void main(String[] args) {
		
//		ArrayList<Integer> A1 = {13, 289, 67, -3, 99, 158, 561, -78, 2, 199, 88, 2500, -669, 12, 1500, -500};
//		System.out.println(findMaxSubArray(A1, 0, A1.length - 1));

	}
	
	// Divide and Conquer
	// Any array can be divided into 2 parts: low ~ mid, mid + 1 ~ high
	// Any subarray can have 3 possible positions: 
	// Entirely in the first half, entirely in the second half, or crossing
	// To find the maximum subarray, find the maximum subarray from i to mid and mid + 1 to j 
	// Here, low <= i <= mid < j < = high
	
	// Return the maximum crossing subarray by triple
	public static TripleDouble findMaxCrossingSubArray(ArrayList<Double> A, int low, int mid, int high) {
		
		double leftSum = -10000000.0; // approximate negative infinity
		double sum = 0;
		int maxLeft = mid;
	
		for (int i = mid; i >= low; i --) {
			sum = sum + A.get(i);
			if (sum > leftSum) {
				leftSum = sum;
				maxLeft = i;
			}
		}
		
		double rightSum = -10000000.0; // approximate negative infinity
		sum = 0;
		int maxRight = mid + 1;
		
		for (int j = mid + 1; j <= high; j ++) {
			sum = sum + A.get(j);
			if (sum > rightSum) {
				rightSum = sum;
				maxRight = j;
			}
		}
		
		TripleDouble t = new TripleDouble(maxLeft, maxRight, (leftSum + rightSum));
		
		return t;
		
	}
	
	// Find the maxima in the two halves by recursion, compare both with the maximum in crossing
	public static TripleDouble findMaxSubArray(ArrayList<Double> A, int low, int high) {
		
		if(high == low) {
			// Base case: only 1 element
			TripleDouble t = new TripleDouble(low, high, A.get(low));
			return t;
			
		} else {
			
			int mid = (low + high) / 2;
			TripleDouble t1 = findMaxSubArray(A, low, mid); // left half recursion
			TripleDouble t2 = findMaxSubArray(A, mid + 1, high); // right half recursion
			TripleDouble t3 = findMaxCrossingSubArray(A, low, mid, high); // crossing
			double leftSum = t1.getPar3();
			double rightSum = t2.getPar3();
			double crossSum = t3.getPar3();
			
			if (leftSum >= rightSum && leftSum >= crossSum) {
				return t1;
			} else if (rightSum >= leftSum && rightSum >= crossSum) {
				return t2;
			} else {
				return t3;
			}
			
		}
	}
}
