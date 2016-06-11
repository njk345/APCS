//Nick Keirstead
import java.util.*;
public class ForEach
{
    public static Random r;
    public static Scanner s;
    public static void main(String[] args) {
        r = new Random();
        s = new Scanner(System.in);
        System.out.print("\fHow Many Arrays Do You Want in the 2d Array? ");
        int outerSize = s.nextInt();
        System.out.print("How Long Do You Want Each Array in the 2d Array to be? ");
        int innerSize = s.nextInt();
        int[][] randArrays = new int[outerSize][innerSize];
        System.out.print("Maximum Random Number To Put in the Array? ");
        int max = s.nextInt();
        
        for (int[] i : randArrays) {
            for (int j = 0; j < i.length; j++) {
                i[j] = r.nextInt(max);
            }
        }
        
        System.out.println("\nThe Randomly Generated 2d Array:");
        System.out.println(Arrays.deepToString(randArrays));
        System.out.println("\nSums of Each Array in the 2d Array:");
        int[] sums = arraySums(randArrays);
        System.out.println(Arrays.toString(sums));
        System.out.println("\nLargest Sum = " + largestEl(sums));
        System.out.println("Most Common Sums = " + mostCommons(sums).toString());
    }
    public static int arraySum(int[] arr) {
        int sum = 0;
        for (int i : arr)
            sum += i;
        return sum;
    }
    public static int[] arraySums(int[][] arrs) {
        int[] sums = new int[arrs.length];
        int index = 0;
        for (int[] i : arrs) {
            sums[index] = arraySum(i);
            index++;
        }
        return sums;
    }
    public static int largestEl(int[] a) {
        int max = -1;
        for (int i : a) {
            if (i > max) max = i;
        }
        return max;
    }
    public static ArrayList<Integer> mostCommons(int[] a) {
        HashMap<Integer, Integer> freqs = new HashMap<Integer, Integer>();
        for (int i : a) {
            if (!freqs.containsKey(i)) {
                freqs.put(i, 1);
            }
            else {
                freqs.put(i, freqs.get(i) + 1);
            }
        }
        int highestFreq = 0;
        int mostCommon = -1;
        for (Integer i : freqs.keySet()) {
            if (freqs.get(i) > highestFreq) {
                highestFreq = freqs.get(i).intValue();
                mostCommon = i.intValue();
            }
        }
        ArrayList<Integer> modes = new ArrayList<Integer>();
        for (Integer i : freqs.keySet()) {
            if (freqs.get(i).intValue() == highestFreq) {
                modes.add(i);
            }
        }
        return modes;
    }
}
