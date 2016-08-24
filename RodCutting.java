package algorithmPractice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Optimization algorithm, comparing conventional recursion and dynamic programming
// Optimize NP to P
public class RodCutting {

	// Length-price pairing map
	public static Map<Integer, Integer> p = new HashMap<Integer, Integer>();

	// Length-price import
	public static void pIn(String fileName) throws FileNotFoundException {
		File input = new File(fileName);
		Scanner snr = new Scanner(input);
		while (snr.hasNext()) {
			String temp = snr.next();
			String[] s = new String[2];
			s = temp.trim().split(",");
			p.put(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
		}
		snr.close();
	}

	// Maximum
	public static int max(int n1, int n2) {
		if (n1 > n2) {
			return n1;
		}
		return n2;
	}

	// Optimized revenue, conventional recursion, Theta(2^n)
	public static int re(int n) {
		if (n == 0) {
			return 0;
		}
		int retVal = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			retVal = max(retVal, p.get(i) + re(n - i));
		}
		return retVal;
	}

	// Top-down memoization auxiliary
	public static int mrAux(int n, int[] r) {
		if (n == 0) {
			return 0;
		}
		if (r[n - 1] != Integer.MIN_VALUE) {
			return r[n - 1];
		}

		int retVal = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			retVal = max(retVal, p.get(i) + mrAux(n - i, r));
		}
		r[n - 1] = retVal;
		return retVal;
	}

	// Optimized revenue, top-down dynamic with memoization, Theta(n^2)
	public static int mr(int n) {
		int[] r = new int[n];
		for (int i = 0; i < n; i++) {
			r[i] = Integer.MIN_VALUE;
		}
		return mrAux(n, r);
	}

	// Optimized revenue, bottom-up dynamic with memoization, Theta(n^2)
	public static int br(int n) {
		int[] r = new int[n + 1];
		r[0] = 0;
		int temp = 0;
		for (int j = 1; j <= n; j++) {
			temp = Integer.MIN_VALUE;
			for (int i = 1; i <= j; i++) {
				temp = max(temp, p.get(i) + r[j - i]);
			}
			r[j] = temp;
		}
		return r[n];
	}

	// Test
	public static void main(String[] args) throws FileNotFoundException {
		pIn("RodCuttingData.txt");
		long start = System.currentTimeMillis();
		System.out.println(re(25)); // NP, T=200~450
		long end = System.currentTimeMillis();
		System.out.println("Recursion time: " + (end - start));
		long start2 = System.currentTimeMillis();
		System.out.println(mr(25)); // P, T=0~3
		long end2 = System.currentTimeMillis();
		System.out.println("Top-down dynamic time: " + (end2 - start2));
		long start3 = System.currentTimeMillis();
		System.out.println(br(25)); // P, T=0~3
		long end3 = System.currentTimeMillis();
		System.out.println("Bottom-up dynamic time: " + (end3 - start3));
	}
}
