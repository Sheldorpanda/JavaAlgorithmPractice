package algorithmPractice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ZeroOneKnapsack {

	private static Map<Integer, Integer> priceTable = new HashMap<Integer, Integer>();
	private static Map<Integer, Boolean> used = new HashMap<Integer, Boolean>();

	public static void pIn(String fileName) throws FileNotFoundException {
		File input = new File(fileName);
		Scanner snr = new Scanner(input);
		int p, w = 0;
		while (snr.hasNext()) {
			String temp = snr.next();
			String[] s = temp.trim().split(","); 
			w = Integer.parseInt(s[0]);
			p = Integer.parseInt(s[1]);
			if (priceTable.containsKey(w)) {
				if (priceTable.get(w) > p) {
					continue;
				}
			}
			priceTable.put(w, p);
			used.put(w, false);
		}
		snr.close();
	}

	public static int knapsack(int W) {
		int[] aux = new int[W];
		for (int i = 0; i < W; i++) {
			aux[i] = Integer.MIN_VALUE;
			if(used.containsKey(W - i)) {
				used.put(W - i, false);
			}
		}
		return knapsackAux(W, aux);
	}

	public static int knapsackAux(int W, int[] aux) {
		if (W == 0) {
			return 0;
		}
		if (aux[W - 1] != Integer.MIN_VALUE) {
			return aux[W - 1];
		}
		int retVal = 0;
		for (int i = 0; i < W; i++) {
			if (priceTable.containsKey(W - i)) {
				int temp = priceTable.get(W - i) + knapsackAux(i, aux);
				if(retVal < temp && !used.get(W - i)) {
					retVal = temp;
					used.put(W - i, true);
				}
			}
		}
		aux[W - 1] = retVal;
		return retVal;
	}

	public static void main(String[] args) throws FileNotFoundException {
		pIn("ZeroOneKnapsackData.txt");
		System.out.println(knapsack(1));
		System.out.println(knapsack(3));
		System.out.println(knapsack(4));
		System.out.println(knapsack(8));
		System.out.println(knapsack(9));
		System.out.println(knapsack(13));
		System.out.println(knapsack(21));
		System.out.println(knapsack(25));
	}

}
