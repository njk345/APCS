//Nick Keirstead
//10/23/15

import java.util.Scanner;

public class OneTwo {
  public static void main (String[] blah) {
    Scanner s = new Scanner(System.in);
    boolean again = true;
    int choice;

    do {
      System.out.print("Enter a number 1-10 (or 0 to quit) : ");
      choice = s.nextInt();
      while (choice < 0 || choice > 10) {
        System.out.print("\nEnter number in valid range please : ");
        choice = s.nextInt();
      }

      switch(choice) {
        case 1:
        case 2:
          System.out.println("Buckle your shoe");
          break;
        case 3:
        case 4:
          System.out.println("Shut the door");
          break;
        case 5:
        case 6:
          System.out.println("Pick up sticks");
          break;
        case 7:
        case 8:
          System.out.println("Lay them straight");
          break;
        case 9:
        case 10:
          System.out.println("A big, fat hen");
          break;
        default: //choice guaranteed to be 0 at this point
          System.out.println("Bye");
          again = false;
      }
      System.out.println();
    }
    while (again);
  }
}
