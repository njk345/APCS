//Nick Keirstead

import java.util.Scanner;

public class Pop {
  public static final double pStart = 123.8;
  public static final double gRate = 0.005;
  public static final int yStart = 2014;

  public static void main (String[] a) {
    Scanner s = new Scanner(System.in);
    System.out.print("Enter Target Population (In Millions): ");
    double endPop = s.nextDouble();
    int endYear = yearWhenPopIs(endPop);
	System.out.println("Mexico's Population Will Be " + endPop + " Million In " + endYear);
  }
  public static int yearWhenPopIs(double endPop) {
    if (endPop == pStart) return yStart;
	int y = 0;
    double i = pStart;
    while (i <= endPop) {
      i *= (1+gRate);
      y++;
    }
    return yStart + y;
  }
}
