//Nick Keirstead
import java.util.*;
class Scrabble {
	static final int[] scores = 
		{1,2,3,4,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter Word: ");
		String str = s.nextLine();
		System.out.println(computeScore(str));
	}
	public static int computeScore(String word) {
		word = word.toUpperCase();
		int tot = 0;
		int refLett = (int)'A';
		for (int i = 0; i < word.length(); i++) {
			int diff = (int)word.charAt(i) - refLett;
			tot += scores[diff];
		}
		return tot;
	}
	
}