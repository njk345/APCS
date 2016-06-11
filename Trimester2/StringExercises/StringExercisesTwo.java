//Nick Keirstead

public class StringExercisesTwo {
	public static void main (String[] args) {
		String test = "hello*";
		String test2 = "hello**";
		System.out.println(endsWithStar(test));
		System.out.println(endsWithTwoStars(test2));
	}
	public static boolean endsWithStar (String s) {
		if (s.length() == 0) return false;
		if (s.equals("*")) return true;
		return endsWithStar(s.substring(1));
	}
	public static boolean endsWithTwoStars (String s) {
		if (s.length() < 2) return false;
		if (s.equals("**")) return true;
		return endsWithTwoStars(s.substring(1));
	}
}