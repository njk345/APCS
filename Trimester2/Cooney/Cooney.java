//Nick Keirstead
import java.util.*;
public class Cooney {
	public static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		int correct = 0;
		while (correct < 5) {
			System.out.print("Does Cooney Like ... ");
			String inp = s.nextLine();
			boolean like = cooneyLikes(inp);
			System.out.println(like? "Yes, Cooney likes " + inp : "No, Cooney doesn't like " + inp);
			correct = like? correct + 1 : 0;h
		}
		System.out.println("\nI think you got the rule... I quit!\nThaanks forr pplaying!");
	}
	public static boolean cooneyLikes(String s) {
		if (s.length() < 2) return false;
		if (s.charAt(0) == s.charAt(1)) 
			return true;
		return cooneyLikes(s.substring(1));
	}
}