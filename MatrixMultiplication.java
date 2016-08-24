package algorithmPractice;

import java.util.ArrayList;

import otherPractice.ArrayTuple;

// Use dynamic programming to do chain multiplication of matrices
// By counting all possible parenthesization
public class MatrixMultiplication {

	// Single multiplication
	public static Matrix multiplication(Matrix A, Matrix B) {
		if (A.getCol() != B.getRow()) {
			System.out.println("Error!");
			System.exit(1);
		}
		Matrix C = new Matrix(A.getRow(), B.getCol());
		for (int i = 0; i < A.getRow(); i++) {
			for (int j = 0; j < B.getCol(); j++) {
				int c = 0;
				for (int k = 0; k < A.getCol(); k++) {
					c += A.getElement(k, i) * B.getElement(j, k);
				}
				C.setElement(j, i, c);
			}
		}
		return C;
	}

	// Chain multiplication, fully parenthesize a product with minimum times of
	// scalar multiplication, optimized by dynamic programming
	// Assume matrix A_i has dimension p[i-1]*p[i] for i = 1, 2,...,n
	// The minimum cost for A_i * ... * A_j is m[i][j], for j = 2, 3, ..., n
	// m[i][j] = min(m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j]) for 0<i<=k<=j<=n
	// Need m to store min values and auxiliary s to store respective indices
	public static int[][] chain(ArrayList<Integer> p) {
		int n = p.size();
		// Construct table m[1...n, 1...n] and s[1...n-1, 2...n]
		// For Java is based 0, leave 0 and 0,1 index = 0 for m and s
		// Java automatically initializes all elements in m and s be 0
		int[][] m = new int[n][n];
		// To store j, push 2 to 0 and n to n-2
		int[][] s = new int[n - 1][n];
		// Let chain length be l
		for (int l = 2; l < n; l++) {
			for (int i = 1; i < n - l + 1; i++) {
				int j = i + l - 1;
				// Sentinel = positive infinity
				m[i][j] = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					// Update scalar production cost
					int q = m[i][k] + m[k + 1][j] + p.get(i - 1) * p.get(k) * p.get(j);
					if (q < m[i][j]) {
						m[i][j] = q;
						s[i][j] = k;
					}
				}
			}
		}
		return s;
	}

	// Print optimal parenthesized result by index
	public static String printOptimalParens(int[][] s, int i, int j) {
		String retVal = "";
		if (i == j) {
			return "" + i;
		}
		// s[i][j] = k, the optimal splitter
		retVal = "(" + printOptimalParens(s, i, s[i][j]) + printOptimalParens(s, s[i][j] + 1, j) + ")";
		return retVal;
	}

	// Test
	public static void main(String[] args) throws StackOverflowError {
//		System.out.println("Matrix multiplication test: ");
//		int[][] a1 = { { 1 }, { 2 }, { 3 }, { 4 }, { 5 }, { 6 } };
//		int[][] b1 = { { 7, 8, 9 } };
//		Matrix A1 = new Matrix(a1);
//		Matrix B1 = new Matrix(b1);
//		Matrix C1 = multiplication(A1, B1);
//		System.out.println(C1);

		ArrayList<Integer> p1 = new ArrayList<Integer>();
		p1.add(3);
		p1.add(4);
		p1.add(5);
		p1.add(4);
		p1.add(3);
		int[][] s1 = chain(p1);
		System.out.println("Opitmal parenthesization test:\n" + printOptimalParens(s1, 1, 4));

	}

}
