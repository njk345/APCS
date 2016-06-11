//Nick Keirstead

import java.util.Scanner;

public class MakeChange {
  public static void main (String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.print("How Many Total Cents? ");
    int cents = s.nextInt();
    makeChange(cents);
    s.close();
  }
  public static void makeChange(int cents) {
    int maxQ = (int)((float)cents / 25);
    int maxD = (int)((float)cents / 10);
    int maxN = (int)((float)cents / 5);
    int maxP = cents;
    int sum;
    int solutions = 0;
    
    for (int q = 0; q <= maxQ; q++) {
      for (int d = 0; d <= maxD; d++) {
        for (int n = 0; n <= maxN; n++) {
          for (int p = 0; p <= maxP; p++) {
            sum = q*25 + d*10 + n*5 + p;
            if (sum == cents) {
              solutions++;
              System.out.print(cents + " cents = ");
				System.out.print(q + " quarters + ");
				System.out.print(d + " dimes + ");
				System.out.print(n + " nickels + ");
				System.out.print(p + " pennies\n");
            }
          }
        }
      }
    }
    System.out.println("\nTOTAL SOLUTIONS = " + solutions);
  }

}
