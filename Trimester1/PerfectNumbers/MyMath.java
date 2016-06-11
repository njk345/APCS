//Nick Keirstead

import java.util.Scanner;

public class MyMath
{
  /**
   * Returns the sum of all integers from 1 to n, if n >= 1,
   * and 0 otherwise.
   */
  public static int sumUpTo(int n)
  {
    int sum = 0;

    for (int k = 1; k <= n; k++)
      sum += k;

    return sum;
  }

  /**
   * Returns 1 * 2 * ... * n, if n >= 1; otherwise returns 1
   */
  public static long factorial(int n)
  {
    long f = 1;

    for (int k = 2; k <= n; k++)
      f *= k;

    return f;
  }

  /**
   * Returns true if n is a prime; otherwise returns false
   */
  public static boolean isPrime(int n)
  {
    if (n <= 1)
      return false;

    int m = 2;

    while (m * m <= n)
    {
      if (n % m == 0)
        return false;
      m++;
    }

    return true;
  }

  /**
   * Tests Goldbach conjecture for even numbers
   * up to bigNum
   */
  public static boolean testGoldbach(int bigNum)
  {
    for (int n = 6; n <= bigNum; n += 2)  // obviously true for n = 4
    {
      boolean found2primes = false;

      for (int p = 3; p <= n/2; p += 2)
      {
        if (isPrime(p) && isPrime(n - p))
          found2primes = true;
      }

      if (!found2primes)
      {
        System.out.println(n + " is not a sum of two primes!");
        return false;
      }
    }

    return true;
  }

	public static long[] getMersenne (int n) {
		//gets the nth mersenne, with n = 1 at 3
		//returns array with nth mersenne and power 'n' used to make it
		int numFound = 1;
		int currPow = 3;
		long currMersenne = 3;
		while (numFound < n) {
			long m = (long) Math.pow(2,currPow) - 1;
			if (isPrime((int) m)) {
				currMersenne = m;
				numFound++;
			}
			currPow++;
		}
		long[] rvs = {currMersenne, (long)currPow-1};
		return rvs;
	}
	
	public static long getPerfectNum(long[] mersenne) {
		return (long) Math.pow(2, mersenne[1] - 1) * mersenne[0];
	}
	
	public static void printPerfectsMersennes(int n) {
		if (n <= 0) return;
		if (n > 7) {
			System.out.println("Can't go that high!");
		}
		else {
			for (int i = 0; i < n; i++)	 {
				long[] mArr = getMersenne(i+1);
				long m = mArr[0];
				long p = getPerfectNum(mArr);
				System.out.print("Mersenne " + (i+1) + ": " + m + "    ||    ");
				System.out.print("Special " + (i+1) + ": " + p + "\n");
			}
		}
	}
	
  /*********************************************************************/

  public static void main(String[] args)
  {
    Scanner kb = new Scanner(System.in);
    int n;

    do
    {
      System.out.print("Enter an integer from 4 to 20: ");
      n = kb.nextInt();
    } while (n < 4 || n > 20);

    kb.close();

    System.out.println();
    System.out.println("1 + ... + " + n + " = " + sumUpTo(n));
    System.out.println(n + "! = " + factorial(n));
    System.out.println("Primes: ");
    for (int k = 1; k <= n; k++)
      if (isPrime(k))
        System.out.print(k + " ");
    System.out.println();
    System.out.println("Goldbach conjecture up to " + n + ": " + testGoldbach(n));
	System.out.println();
	printPerfectsMersennes(6);
}
}
