//Nick Keirstead
import java.util.*;
class TwoDArray {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		System.out.print("Enter Array Dimensions (Space-Sep.): ");
		int rows = s.nextInt();
		int cols = s.nextInt();
		int[][] stuff = new int[rows][cols];
		for (int i = 0; i < stuff.length; i++) {
			for (int x = 0; x < stuff[i].length; x++) {
				stuff[i][x] = r.nextInt(100);
			}
		}
		int res = positiveMax(stuff);
		System.out.println("Largest Pos. El = " + res);
	}
	public static int positiveMax(int[][] mat) {
		int max = 0;
		for (int[] i : mat) {
			for (int x : i) {
				if (x > max) max = x;
			}
		}
		return max;
	}
}