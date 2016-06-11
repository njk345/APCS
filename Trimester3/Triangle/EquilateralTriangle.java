//Nick Keirstead
public class EquilateralTriangle extends Triangle {
	private static final double AREA_COEFFICIENT = Math.sqrt(3) / 4;
  public EquilateralTriangle(double side) {
		super(side);
	}
	public double getArea() {
    return AREA_COEFFICIENT * getSide() * getSide();
  }
  public double getPerimeter() {
    return getSide() * 3;
  }
  @Override
  public String toString() {
    return "Equilateral Triangle: " + super.toString();
  }
}
