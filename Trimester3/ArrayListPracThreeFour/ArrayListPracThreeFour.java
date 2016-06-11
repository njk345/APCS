//Nick Keirstead
import java.util.*;
public class ArrayListPracThreeFour {
	public static void main(String[] args) {
		ArrayList<String> test = new ArrayList<String>();
		test.add("hello");
		test.add("hello");
		test.add("world");
		removeConsecutiveDuplicates(test);
		System.out.println(test.toString());
	}
	public static void removeConsecutiveDuplicates(ArrayList<String> lst) {
		for (int i = lst.size() - 1; i >= 1; i--) {
			if (lst.get(i).equals(lst.get(i-1))) {
				lst.remove(i);
			}
		}
	}
	public static ArrayList<ArrayList<String>> buckets(List<String> words) {
		ArrayList<ArrayList<String>> bucks = new ArrayList<ArrayList<String>>(26);
		for (int i = 0; i < bucks.size(); i++) {
			bucks.add(new ArrayList<String>());
		}
		for (String s : words) {
			char f = s.toUpperCase().charAt(0);
			int place = (int)f - 65;
			bucks.get(place).add(s);
		}
		return bucks;
	}
}