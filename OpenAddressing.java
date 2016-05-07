package algorithmPractice;

import java.util.HashMap;

// All elements fill up the hash table, until all slots hold elements
// Sequence of keys (probe sequence) is fixed
public class OpenAddressing {

	// Hash function, using numerical type as hash, here is modular by ASCII
	// Size of probe sequence is 26
	public static int hash(String key) {
		return ((int) key.toLowerCase().charAt(0)) % 97;
	}

	// Linear probing
	public static int linearProbing(String key, int i, HashMap<Integer, String> hm) {
		return (hash(key) + i) % 26;
	}

	// Quadratic probing
	public static int quadraticProbing(String key, int i, HashMap<Integer, String> hm) {
		return (hash(key) + i + i ^ 2) % 26;
	}

	// Insertion, return the position or -1 if fails, use linear probing as
	// example
	public static int hashInsert(String key, HashMap<Integer, String> hm) {
		for (int i = 0; i < 26; i++) {
			int j = linearProbing(key, i, hm);
			if (hm.get(j) == null) {
				hm.put(j, key);
				return j;
			}
		}
		return -1;
	}

	// Search, also use linear probing as example
	public static int hashSearch(String key, HashMap<Integer, String> hm) {
		for (int i = 0; i < 26; i++) {
			int j = linearProbing(key, i, hm);
			if (hm.get(j).equals(key)) {
				return j;
			}
		}
		return -1;
	}

	// Test
	public static void main(String[] args) {
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		System.out.println(hashInsert("Panda", hm)); // 15
		System.out.println(hashInsert("Penguin", hm)); // 16 (15 is occupied)
	}

}
