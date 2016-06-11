//Nick Keirstead
import java.util.*;
public class FindMin {
  public static void main(String[] args) {
    int[] list = new int[10];
    for (int i = 0; i < 10; i++) {
      list[i] = (int)(Math.random() * 100);
    }
    System.out.println(Arrays.toString(list));
    System.out.println("Minimum = " + findMin1(list, Integer.MAX_VALUE));
    System.out.println("Minimum = " + findMin2(list, 0));
  }
  //This is the first method I thought of, although
  //I doubt it's what you were looking for...
  public static int findMin1(int[] list, int n) {
    if (list.length == 0) return n;
    else {
      int[] newList = Arrays.copyOfRange(list, 1, list.length);
      if (list[0] < n) return findMin1(newList, list[0]);
      else return findMin1(newList, n);
    }
  }
  //This is the better method
  public static int findMin2(int[] list, int n) {
    if (n == list.length - 1) return list[n];
    int minOfRest = findMin2(list, n+1);
    return list[n] < minOfRest? list[n] : minOfRest;
  }
}
