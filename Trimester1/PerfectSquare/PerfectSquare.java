//Nick Keirstead

import java.util.Scanner;

public class PerfectSquare {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter Number To Check If Perfect Square: ");
		int n = s.nextInt();
		System.out.println(isPerfectSquare(n));
	}
	public static boolean isPerfectSquare(int n) {
		int sum = 0;
		for (int i = 1; sum < n; i += 2) {
			sum += i;
		}
		return sum == n;
	}
}
