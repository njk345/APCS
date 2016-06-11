//Nick Keirstead
import java.util.*;
public class ArrayListPractice {
	public static void main(String[] args) {
		ArrayList<Integer> test = new ArrayList<>();
		for (int i = 10; i > 5; i--) {
			test.add(i);
		}
		System.out.println(test.toString());
		removeSmallest(test);
		System.out.println(test.toString());
	}
	public static ArrayList<String> reverse(ArrayList<String> arr) {
		ArrayList<String> rev = new ArrayList<String>();
		for (int i = arr.size() - 1; i >= 0; i--) {
			rev.add(arr.get(i));
		}
		return rev;
	}
	public static void removeSmallest(ArrayList<Integer> arr) {
		if (arr.isEmpty()) return;
		int smallest = Integer.MAX_VALUE;
		for (int i : arr) {
			if (i < smallest) {
				smallest = i;
			}
		}
		arr.remove(arr.indexOf(smallest));
	}
}