package algorithmPractice;

import java.util.Hashtable;

public class HashTablePractice {

	public static void main(String[] args) {
		
		// Direct-address hash
		// O(1) to search, insert, and delete elements
		Hashtable<String, Integer> numbers = new Hashtable<String, Integer>();
		numbers.put("one", 1);
		numbers.put("two", 2);
		System.out.println(numbers);
		System.out.println(numbers.get("two"));
		numbers.remove("two");
		System.out.println(numbers);

	}

}
