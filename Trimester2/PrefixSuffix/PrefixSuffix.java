//Nick Keirstead
import java.util.*;
public class PrefixSuffix {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter Main String: ");
		String mainStr = s.nextLine();
		System.out.print("(1) Check If startsWith(), (2) Check If endsWith(): ");
		int method = s.nextInt();
		s.nextLine();
		System.out.print("Enter Substring to Check: ");
		String sub = s.nextLine();
		if (method == 1) {
			System.out.println(startsWith(mainStr, sub));
		}
		else if (method == 2) {
			System.out.println(endsWith(mainStr, sub));
		}
		else System.out.println("Invalid Method Choice.");
	}
	public static boolean startsWith(String s, String patt) {
		if (s.length() < patt.length() || patt.length() == 0) return false;
		return s.substring(0, patt.length()).equals(patt);
	}
	public static boolean endsWith(String s, String patt) {
		if (s.length() < patt.length() || patt.length() == 0) return false;
		return s.substring(s.length() - patt.length(), s.length()).equals(patt);
	}
}