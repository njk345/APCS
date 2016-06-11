//Nick Keirstead
public class Runner {
  public static void main(String[] args) {
    EquilateralTriangle e = new EquilateralTriangle(Math.random() * 100);
    RightTriangle r = new RightTriangle(Math.random() * 100);
    System.out.println(e + "\n" + r);
  }
}
