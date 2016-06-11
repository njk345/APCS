//Nick Keirstead
import java.util.Scanner;

public class Stars {
  public static void main (String[] args) {
    Scanner s = new Scanner(System.in);
    int n;
    do {
      System.out.print("Enter Star Triangle Height: ");
      n = s.nextInt();
    } while (n < 0);

    printStarTriangle(n);
  }
  public static void printStarTriangle(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < n - i; j++) {
        System.out.print(" ");
      }
      for (int k = 0; k < i; k++) {
        System.out.print("* ");
      }
      System.out.print("\n");
    }
    for (int i = 0; i < 13; i++) {
      System.out.print("* ");
    }
    System.out.print("\n");
  }
}
