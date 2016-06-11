//Nick Keirstead

import java.util.Scanner;

public class Checkers {
  public static void main (String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.println("How Many Rows in The Checkerboard? ");
    int n = s.nextInt();
    printCheckers(n);
  }
  public static void printCheckers(int n) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i % 2 == 0) {
          if (j % 2 == 0) {
            System.out.print("#");
          }
          else System.out.print("o");
        }
        else if (j % 2 == 0) {
          System.out.print("o");
        }
        else System.out.print("#");
      }
      System.out.print("\n");
    }
  }
}
