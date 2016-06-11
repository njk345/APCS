import java.util.*;
class ArrayQuizPractice {
	public static void main(String[] args) {
		Random r = new Random();
		
		char[][] board = new char[10][10];
		fillCheckerboard(board);
		System.out.println(Arrays.deepToString(board));
		
		//**********************************************
		
		double[][] m1 = new double[20][10];
		double[][] m2 = new double[20][10];
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m1[0].length; j++) {
				double r1 = r.nextDouble();
				double r2 = r.nextDouble();
				m1[i][j] = r1;
				m2[i][j] = r2;
			}
		}
		System.out.println(covers(m1, m2));
	}
	public static void fillCheckerboard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < board[i].length; j++) {
					board[i][j] = j % 2 == 0? 'x' : '.';
				}
			}
			else {
				for (int j = 0; j < board[i].length; j++) {
					board[i][j] = j % 2 == 0? '.' : 'x';
				}
			}
		}
	}
	public static boolean covers(double[][] m1, double[][] m2) {
		int tot = m1.length * m1[0].length;
		int numCoverings = 0;
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m1[0].length; j++) {
				if (Double.compare(m1[i][j], m2[i][j]) > 0) {
					numCoverings++;
				}
			}
		}
		return numCoverings * 2 >= tot;
		//or we could do:
			//return numCoverings >= (int)((double) tot / 2);
	}
}