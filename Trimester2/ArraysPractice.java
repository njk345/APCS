import java.util.*;
public class ArraysPractice {
	public static void main(String[] args) {
		int[] test = {1,2,3,4,5,6,7};
		System.out.println(Arrays.toString(test));
		int[] testInserted = insert(test, 4, 8);
		//System.out.println(Arrays.toString(testInserted));
		//System.out.println(Arrays.toString(remove(test, 4)));
		removeAll(test, 3);
		System.out.println(Arrays.toString(test));
	}
	public static int[] insert(int[] a, int index, int x) {
		int[] a2 = new int[a.length + 1];
		for (int i = 0; i < index; i++) {
			a2[i] = a[i];
		}
		a2[index] = x;
		for (int i = index + 1; i < a2.length; i++) {
			a2[i] = a[i-1];
		}
		return a2;
	}
	public static int[] remove(int[] a, int index) {
		int[] a2 = new int[a.length - 1];
		for (int i = 0; i < index; i++) {
			a2[i] = a[i];
		}
		for (int i = index + 1; i < a.length; i++) {
			a2[i - 1] = a[i];
		}
		return a2;
	}
	public static void removeAll(int[] a, int x) {
		int offset = 0;
		for (int i = 0; i < a.length - offset; i++) {
			if (a[i] == x) {
				offset++;
			}
			a[i] = a[i + offset];
		}
		for (int i = a.length - 1; i > (a.length - 1) - offset; i--) {
			a[i] = 0;
		}
	}
}