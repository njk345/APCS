//Nick Keirstead

//Rather than creating the multiplication table and
//formatting the spaces between number, etc. to a fixed size (12),
//I generalized and wrote a method that can print a column-aligned
//multiplication table up to any integer max (as long as it'll fit within
//your display!)
//In doing so, I used a scanner though to get the size from the user, so I hope
//that's okay..

import java.util.Scanner;

public class MultTable {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.print("Up To What Number Do You Want the Multiplication Table? ");
    int n = s.nextInt();
    System.out.print("\n");
    printMultTable(n);
  }
  public static void printMultTable(int max) {
    int maxLen = numDigits(max*max);

	//print header row first
    for (int i = 0; i <= max; i++) {
      if (i == 0) { //print leading spaces
        String lead = " ";
        for (int j = 0; j < maxLen; j++) {
          lead += " ";
        }
        System.out.print(lead);
      }

      System.out.print(formattedNum(i, maxLen));
    }
    System.out.print("\n");

    //print body rows
    for (int row = 0; row <= max; row++) {
      System.out.print(formattedNum(row, maxLen));
      for (int col = 0; col <= max; col++) {
        System.out.print(formattedNum((row*col), maxLen));
      }
      System.out.print("\n");
    }
  }
  
  public static String formattedNum(int n, int maxSize) {
    //maxSize is the maximum number of digits that appears in any number
    //in the given multiplication table
    //the number of spaces we place after a given number varies based on its number
    //of digits, and is a function of whichever number is the longest in the table.
    //For instance, if biggest number appearing in table is 5000, to have single-digit
    //numbers line up with it, we must place three spaces after them, or two spaces for 
    //double-digit numbers, etc.
    //This function determines how many spaces to add and returns the correct number string
    //with spaces included.
    
    String rv = n + " ";
    int ndig = numDigits(n);
    int diffFromMax = maxSize - ndig;
    for (int i = 0; i < diffFromMax; i++) {
      rv += " ";
    }
    return rv;
  }
  
  public static int numDigits(int n) {
    if (n == 0) return 1;
    int numdig = 0;
    while (n > 0) {
      n /= 10;
      numdig++;
    }
    return numdig;
  }
}
