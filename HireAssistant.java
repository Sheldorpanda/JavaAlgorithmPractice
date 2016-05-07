package algorithmPractice;

import java.util.ArrayList;

public class HireAssistant {

	public static void main(String[] args) {

	}

	// If the next candidate (positive int) is better (>) than the previous,
	// hire the next one and fire the previous
	public static int hireAssitant(ArrayList<Integer> A) {
		int best = 0;
		for (int item : A) {
			if (item > best) {
				best = item;
			}
		}
		return best;
	}
	
	// Analysis: let interview fee be ci, hiring fee be ch, ch > ci, n people interviewed and m hired
	// Total cost: O(ci * n + ch * m)
	// Worst case: O((ci + ch) * n), as ci * n is constant, it is O(ch * n)
	// Use probabilistic analysis: report the average-case running time instead
	// Assume a uniform random permutation, that is, the n! permutations all occur with equal probability 1/(n!)
	// An algorithm is randomized if its behavior is not only determined by input but also a random value generator
	// E.g.: Take a list from the total candidates, randomly pick some to interview
	
	// If the probability is uniformly random: P(candidate at i is better than 0 ~ i-1) = 1/i
	// E(Xi) = sum[0 to n](1/i) = ln(n) + O(1)
	// Expected average total hiring cost: O(ch * ln(n))
	// Way better than O(ch * n)

}
