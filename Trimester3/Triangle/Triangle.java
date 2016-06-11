//Nick Keirstead
public abstract class Triangle {
	private double side;
	public abstract double getArea();
	public abstract double getPerimeter();
  public double getSide() {
    return side;
  }
  public double getRatio() {
    return getArea() / getPerimeter();
  }
	public Triangle(double side) {
		this.side = side;
	}
  @Override
  public String toString() {
    return "SideLen = " + this.side 
          + " || Area = " + getArea()
          + " || Perimeter = " + getPerimeter()
          + " || Ratio = " + getRatio();
  }
}
