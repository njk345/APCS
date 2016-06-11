public class Keivan {
	public static void main(String[] args) {
		double unknown = 1;
		double known = 0;
		int m = 0;
		while (known < 0.95) {
			double chunk = unknown * 0.10;
			known += chunk;
			unknown -= chunk;
			m++;
		}
		int y = m / 12;
		m = m % 12;
		if (y > 0) System.out.print(y + " Years, ");
		System.out.print(m + " Months\n");
	}
}