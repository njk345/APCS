//Nick Keirstead

import java.util.Scanner;

public class AddOdds {
  public static void main (String[] args) {
    Scanner s = new Scanner(System.in);
    int n = -1;
    do {
      System.out.print("Sum odds up to what integer (> 1)? ");
      n = s.nextInt();
    } while (n < 2);
    System.out.println(addOdds(n));
  }
  public static int addOdds(int n) {
    int sum = 0;
    for (int i = 1; i < n; i += 2) {
      sum += i;
    }
    return sum;
  }
}
