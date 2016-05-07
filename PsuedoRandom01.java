package algorithmPractice;

public class PsuedoRandom01 {

	private static int seed = 5;

	// Linear Congruential PRNG: N = 2, return 0 and 1 at probability = 1/2
	public static int psuedoRandom01(int a, int b) {

		int r = (a * seed + b) % 2;
		seed = r;
		return r;

	}

	// Test
	public static void main(String[] args) {

		int count0 = 0;
		int count1 = 0;

		for (int i = 0; i < 1000000; i++) {
			int r = psuedoRandom01(113, 97); // a = 113, b = 97, use large prime
												// numbers
			if (r == 0) {
				count0++;
			} else {
				count1++;
			}

		}
		
		System.out.println(count0);
		System.out.println(count1);

	}
}
