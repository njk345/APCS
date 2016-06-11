import java.util.*;
class Untitled {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Get How Many Fibonacci Numbers? ");
		int n = s.nextInt();
		if (n < 0) throw new RuntimeException("Can't Do That");
		System.out.print(Arrays.toString(nFibs(n)));
	}
	public static int[] nFibs(int n) {
		//return array with first n fibonacci numbers inclusive
		int[] fibs = new int[n];
		for (int i = 1; i <= n; i++) {
			fibs[i-1] = fib(i);
		}
		return fibs;
	}
	public static int fib(int n) {
		if (n <= 2) return 1;
		return fib(n-1) + fib(n-2);
	}
	public static int[] iterFib(int n) {
		int[] fibs = new int[n];
		if (n == 0) return fibs;
		fibs[0] = 1;
		if (n == 1) return fibs;
		fibs[1] = 1;
		if (n == 2) return fibs;
		for (int i = 2; i < n; i++) {
			fibs[i] = fibs[i-1] + fibs[i-2];
		}
		return fibs;
	}
}