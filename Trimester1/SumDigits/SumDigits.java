import java.util.Scanner;

public class SumDigits {
  public static void main (String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.print("Enter Num: ");
    int n = s.nextInt();
    System.out.println(sumDigits(n));
  }
  public static int sumDigits(int n) {
    if (n == 0) return 0;
    return n % 10 + sumDigits(n/10);
  }
  public static int loopSum(int n) {
    int sum = 0;
    while (n > 0) {
      sum += n % 10;
      n /= 10;
    }
    return sum;
  }
}
