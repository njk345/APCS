//Nick Keirstead
//AP Computer Science H
//10/8/15

public class LargestInt {
	public static void main(String[] args) {
		System.out.println(max(6,8));
	}
	public static int max(int a, int b) {
		if (a <= 0 && b >= 0) return b;
		//if a < 0 and b > 0, immediately return b
		//if a == 0 and b == 0, return b (same as a)
		//if a == 0 and b > 0, return b
		//--> this covers all these cases
		
		if (a >= 0 && b <= 0) return a;
		//if a > 0 and b < 0, immediately return a
		//if a == 0 and b == 0, return a (same as b)
		//if a > 0 and b == 0, return a
		//--> this covers all these cases
		
		//by this point, not possible for a and b to
		//have different signs (would have gotten caught
		//in first two if statements)
		if (a < 0) {
			return -1 + max(a + 1, b + 1);
			//call recursively, building up a negative number
			//that is the larger a or b inputted (the larger a
			//or b is closer to zero if both are negative)
		}
		else {
			return 1 + max(a - 1, b - 1);
			//call recursively, building up a positive number
			//that is the smaller of a or b inputted.
			//When a or b is zero, first or second if statement
			//goes into effect and returns the other one (which
			//is bigger)
		}
	}
	
	
	/*
	NON RECURSIVE VERSION
	
	public static int max(int a, int b) {
		return (a > b) ? a : b;
	}
	
	
	*/
}