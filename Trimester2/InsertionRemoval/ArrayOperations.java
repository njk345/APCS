import java.util.*;
class ArrayOperations {
	public static void main(String[] args) {
		int[] test = {1,2,3,4,5};
		int[] res = insert(test, 8, 5);
		System.out.println(Arrays.toString(res));
		int[] res2 = remove(res, 3);
		System.out.println(Arrays.toString(res2));
	}
	public static int[] insert(int[] a, int el, int index) {
		int[] a2 = new int[a.length + 1];
		a2[index] = el;
		for (int i = 0; i < index; i++) {
			a2[i] = a[i];
		}
		for (int i = index + 1; i <= a.length; i++) {
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
			a2[i-1] = a[i];
		}
		return a2;
	}
}