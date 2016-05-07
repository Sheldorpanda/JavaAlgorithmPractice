package algorithmPractice;

// A good hash function satisfies simple uniform hashing
// Which means, P(key_i into slot_j) are equal for any i and j
public class HashFunctionPractice {

	// Use a subset of N (natural number) as key set
	// Non-numeric types are expressed in suitable radix notations, e.g.: ASCII

	// Division method, mapping a key into one of m slots by modular
	public int divisionHash(Object key, int m) {
		return (int) key % m;
	}

	// Multiplication method, multiply a key by A in [0, 1], then multiply
	// fractional part by m, then take floor, mapping into one of m slots
	public int multiplicationHash(Object key, double A, int m) {
		double K = (int) key * A;
		return (int) (m * (K - (int) K));
	}

	// Universal hashing, which is a random selection from hash function set H
	// For large input, to select cases, use linear congruential PRNG: h(ab) = ((a*k+b) mod p) mod m, where p is a prime number
	// Here, take the two hash functions above as an example
	public Object universalHash(Object key) {
		Object retVal = null;
		int functionNum = (int) Math.random() % 2;
		switch(functionNum) {
		case 0: retVal = divisionHash(key, 2);
				break;
		case 1: retVal = multiplicationHash(key, 0.5, 2);
				break;
		}
		return retVal;
	}
}
