//Nick Keirstead
public class Haiku extends Poem {
	private static int[] syllsPerLine = {5,7,5};
	public Haiku() {}
	public int numLines() {
		return syllsPerLine.length;
	}
	public int getSyllables(int k) {
		return syllsPerLine[k-1];
	}
}