class Division {
	public static void main(String[] args) {
		divStuff(10,2);
	}
	public static int mult(int a, int b) {
		int prod = 0;
		for (int i = 0; i < b; i++) {
			prod += a;
		}
		return prod;
	}
	public static int recMult(int a, int b) {
		if (b == 0) return 0;
		return a + recMult(a, b-1);
	}
	public static void divStuff (int m, int n) {
		int quot = 0;
		for (int i = m; i > 0; i -= n) {
			quot ++;
		}
		int i = m;
		while (i - n >= 0) {
			i -= n;
		}
		int rem = i;
		System.out.println(rem);
		System.out.println(quot);
	}
}