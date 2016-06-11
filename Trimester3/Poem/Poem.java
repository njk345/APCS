//Nick Keirstead
public abstract class Poem {
	public abstract int numLines();
	public abstract int getSyllables(int k);
	public void printRhythm() {
		int[] syllsPerLine = new int[numLines()];
		for (int i = 0; i < syllsPerLine.length; i++) {
			syllsPerLine[i] = getSyllables(i+1);
		}
		for (int line : syllsPerLine) {
			for (int i = 0; i < line; i++) {
				System.out.print((i == line - 1) ? "ta\n" : "ta-");
			}
		}
	}
	public static void main(String[] args) {
		System.out.println("Haiku Rythm:");
		Haiku h = new Haiku();
		h.printRhythm();
		System.out.println();
		
		System.out.println("Limerick Rhythm:");
		Limerick l = new Limerick();
		l.printRhythm();
		System.out.println();
	}
}