//Nick Keirstead
import java.util.Scanner;

public class Gcf {
  public static void main (String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.println("Enter Two Integers For GCF: ");
    int a = s.nextInt();
    int b = s.nextInt();
    System.out.println(gcf(a,b));
  }
  public static int gcf(int a, int b) {
    while (a > 0) {
      int temp = a;
      a = b % a;
      b = temp;
    }
    return b;
  }
  
  //the better way
  public static int recursiveGcf(int a, int b) {
    if (a == b) return a;
    if (a > b) return gcf(a-b,a);
    return gcf(b-a,b);
  }
}
