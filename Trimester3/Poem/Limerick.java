//Nick Keirstead
public class Limerick extends Poem {
	private static int[] syllsPerLine = {9,9,6,6,9};
	public Limerick() {}
	public int numLines() {
		return syllsPerLine.length;
	}
	public int getSyllables(int k) {
		return syllsPerLine[k-1];
	}
}