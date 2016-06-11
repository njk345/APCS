//Nick Keirstead
public class RightTriangle extends Triangle {
  private static final double PERIMETER_COEFFICIENT = Math.sqrt(2) + 2;
  public double getArea() {
    return getSide() * getSide() / 2;
  }
  public double getPerimeter() {
    return getSide() * PERIMETER_COEFFICIENT;
  }
  public RightTriangle(double side) {
    super(side);
  }
  @Override
  public String toString() {
    return "Right Triangle: " + super.toString();
  }
}
