package algorithmPractice;

import java.util.ArrayList;
import java.util.HashMap;

// Chaining is an efficient solution to hash collision
// Average case: simple uniform hashing, each key has equal probability to hash in any slot
// Average case time: Theta(1+m/n) = O(1), where m is #slots which holds non-null values
public class ChainedHash {
	
	// Hash function, here, hash String by the lower case of the first char
	// Hash table consists of 26 ArrayLists
	public static char hash(String s) {
		return s.toLowerCase().charAt(0);
	}

	// Chained hash insert, add key in the head of the list correspond to the
	// value, a second hash (inverse hash) is applied
	public static void chainedHashInsert(HashMap<Character, ArrayList<String>> hm, String s) {
		char key = hash(s);
		ArrayList<String> newValue = new ArrayList<String>();
		newValue.add(s);
		if (hm.containsKey(key)) {
			ArrayList<String> value = hm.get(key);
			newValue.addAll(value);
		}
		hm.put(hash(s), newValue);
	}

	// Chained hash search, O(1)
	public static boolean chainedHashSearch(HashMap<Character, ArrayList<String>> hm, String s) {
		char key = hash(s);
		boolean retVal = false;
		if (hm.containsKey(key)) {
			retVal = hm.get(key).contains((String) s);
		}
		return retVal;
	}

	// Chained hash delete, O(1), successful if value collection contains s
	// Delete one copy from the value collection
	public static boolean chainedHashDelete(HashMap<Character, ArrayList<String>> hm, String s) {
		char key = hash(s);
		boolean retVal = false;
		if (hm.containsKey(key)) {
			retVal = hm.get(key).contains((String) s);
			hm.get(key).remove((String) s);
		}
		return retVal;
	}

	// Test
	public static void main(String[] args) {
		HashMap<Character, ArrayList<String>> hm = new HashMap<Character, ArrayList<String>>();
		chainedHashInsert(hm, "Apple");
		System.out.println(chainedHashSearch(hm, "Apple")); // true
		System.out.println(chainedHashSearch(hm, "Pear")); // false
		System.out.println(chainedHashDelete(hm, "Apple")); // true
		System.out.println(chainedHashDelete(hm, "Apple")); // false
	}
}
