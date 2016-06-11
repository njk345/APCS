class LoopTypes {
	public static void main(String[] args) {
		System.out.println(sumOfSquares(1,100));
		System.out.println(whileLoopSum(1,100));
		System.out.println(forLoopSum(1,100));
		System.out.println(doWhileLoopSum(1,100));
	}
	public static long sumOfSquares(int n, int max) {
		if (n == max) return n * n;
		return n * n + sumOfSquares(n+1,max);
	}
	public static long whileLoopSum(int min, int max) {
		long sum = 0;
		int i = min;
		while (i <= max) {
			sum += i*i;
			i++;
		}
		return sum;
	}
	public static long forLoopSum(int min, int max) {
		long sum = 0;
		for (int i = min; i <= max; i++) {
			sum += i*i;
		}
		return sum;
	}
	public static long doWhileLoopSum(int min, int max) {
		long sum = 0;
		int i = min;
		
		do {
			sum += i*i;
			i++;
		}
		while (i <= max);
		return sum;
	}
}