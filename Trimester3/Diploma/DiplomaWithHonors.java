//Nick Keirstead
public class DiplomaWithHonors extends Diploma {
	public DiplomaWithHonors (String name, String major) {
		super(name, major);
	}
	public String toString() {
		return super.toString() +  "\n*** with honors ***";
	}
}