package algorithmPractice;

import java.util.ArrayList;

// Longest Common Subsequence
public class LCS {

	public static int[][] lcs(ArrayList<Integer> X, ArrayList<Integer> Y) {
		ArrayList<Integer> retVal = new ArrayList<Integer>();
		int m = X.size();
		int n = Y.size();
		int[][] c = new int[m][n];
		int[][] path = new int[m][n]; // 1: up-left, 2: up, 3: left
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (X.get(i) == Y.get(j)) {
					c[i][j] = c[i - 1][j - 1] + 1;
					path[i][j] = 1;
					retVal.add(c[i][j]);
				} else if (c[i - 1][j] >= c[i][j - 1]) {
					c[i][j] = c[i - 1][j];
					path[i][j] = 2;
				} else {
					c[i][j] = c[i][j - 1];
					path[i][j] = 3;
				}
			}
		}
		return path;
	}
	
	public static String printLcs(int[][] path, ArrayList<Integer> X, int i, int j) {
		String retVal = "";
		if(i == 0 || j == 0) {
			return retVal;
		}
		if(path[i][j] == 1) {
			retVal += printLcs(path, X, i-1, j-1);
			retVal += (X.get(i) + ", ");
		} else if(path[i][j] == 2) {
			retVal += printLcs(path, X, i-1, j);
		} else if (path[i][j] == 3) {
			retVal += printLcs(path, X, i, j - 1);
		}
		return retVal;
	}

	public static void main(String[] args) {
		int[] x1 = {1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1};
		int[] y1 = {0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0};
		ArrayList<Integer> Y1 = new ArrayList<Integer>();
		ArrayList<Integer> X1 = new ArrayList<Integer>();
		for(int item: x1) {
			X1.add(item);
		}
		for(int item: y1) {
			Y1.add(item);
		}
		int[][] p = lcs(X1, Y1);
		System.out.println(printLcs(p, X1, X1.size() - 1, Y1.size() - 1));
	}
}