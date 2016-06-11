import java.util.*;
public class Recursion {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.print("Enter n: ");
    int n = s.nextInt();
    System.out.println(sumOfSquares(n));
    System.out.println(multiply(n, 5));
  }
  public static long sumOfSquares(int n) {
    if (n == 1) return 1;
    return (long)(n * n + sumOfSquares(n-1));
  }
  public static int multiply(int a, int b) {
    if (a == 0) return 0;
    return b + multiply(a-1, b);
  }
  public static int mysterySum(int n) {
    if (n == 0) return 0;
    return 3 + mysterySum(n-1);
  }
}
