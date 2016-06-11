//Nick Keirstead
import java.util.*;

//I used generics - LineList can hold any type, not just String
//Also, I made LineList itself an ArrayList by extending it,
//rather than having it hold an ArrayList and rewriting all the methods
public class LineList<T> extends ArrayList<T> {
	public LineList() {
		super();
	}
	public void move(int index, int newIndex) {
		this.add(newIndex, this.remove(index));
	}
	public void swap(int a, int b) {
		T temp = this.get(a);
		this.set(a, this.get(b));
		this.set(b, temp);
	}
	public void shuffle() {
		for (int n = this.size(); n >= 2; n--) {
			int randIndex = (int)(Math.random() * (n-1));
			swap(randIndex, this.size() - 1);
		}
	}
	//Testing Stuff
	public static void main (String[] args) {
		LineList<String> test = new LineList<>();
		test.add("hello");
		test.add("world");
		test.add("nick");
		test.add("keirstead");
		test.add("apcs");
		test.add("screen");
		
		System.out.println(test.toString());
		test.move(0, 6);
		System.out.println(test.toString());
		test.shuffle();
		System.out.println(test.toString());
	}
}
