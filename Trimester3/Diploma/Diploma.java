//Nick Keirstead
public class Diploma {
	private String name, major;
	public Diploma(String name, String major) {
		this.name = name;
		this.major = major;
	}
	public String getName() {
		return this.name;
	}
	public String getMajor() {
		return this.major;
	}
	public String toString() {
		return "This certifies that " + name + "\nhas completed a MOOC in " + major;
	}
	public static void main(String[] args) {
		Diploma d = new Diploma("nick", "english");
		System.out.println(d);
		System.out.println();
		DiplomaWithHonors d2 = new DiplomaWithHonors("james", "math");
		System.out.println(d2);
	}	
}