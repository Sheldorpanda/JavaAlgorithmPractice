package algorithmPractice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Activity-selection problem
public class GreedySelector {
	
	public static List<Integer> start = new ArrayList<Integer>();
	public static List<Integer> finish = new ArrayList<Integer>();

	public static void in(String fileName) throws FileNotFoundException {
		File input = new File(fileName);
		Scanner snr = new Scanner(input);
		while (snr.hasNext()) {
			String entry = snr.next();
			String[] s = new String[2];
			s = entry.trim().split(",");
			start.add(Integer.parseInt(s[1]));
			finish.add(Integer.parseInt(s[2]));
		}
		snr.close();
	}
	
	public static List<Integer> greedySelector(List<Integer> s, List<Integer> f, int ini) {
		List<Integer> retVal = new ArrayList<Integer>();
		retVal.add(ini);
		int k = ini;
		for(int m = ini; m < s.size(); m++ ) {
			if(s.get(m) > f.get(k)) {
				retVal.add(m);
				k = m;
			}
		}
		return retVal;
	}

	public static void main(String[] args) throws FileNotFoundException {
		in("ActivitySelectionData.txt");
		List<Integer> A = greedySelector(start, finish, 0);
		List<Integer> B = greedySelector(start, finish, 1);
		List<Integer> C = greedySelector(start, finish, 5);
		List<Integer> D = greedySelector(start, finish, 9);
		System.out.println("Maximum cardinality with different initial elem:");
		for(int item: A) {
			System.out.print(item + " ");
		}
		System.out.println();
		for(int item: B) {
			System.out.print(item + " ");
		}
		System.out.println();
		for(int item: C) {
			System.out.print(item + " ");
		}
		System.out.println();
		for(int item: D) {
			System.out.print(item + " ");
		}
	}

}
