public class QuadFunction implements Comparable<QuadFunction> {
  private int a, b, c;
  public QuadFunction(int a, int b, int c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }
  public double valueAt(double x) {
    return a * x * x + b * x + c;
  }
  public int getA() {
    return a;
  }
  public int getB() {
    return b;
  }
  public int getC() {
    return c;
  }
  public String toString() {
    String s = "";
    if (a == -1) {
      s += "-";
    } if (a != -1 && a != 1) {
      s += a;
    } if (a != 0) {
      s += "x^2";
    } if (b != 0) {
      s += b < 0? b : "+" + b;
      s += "x";
    } if (c != 0) {
      s += c < 0? c : "+" + c;
    }
    return s;
  }
  public boolean equals(Object o) {
    if (!(o instanceof QuadFunction)) return false;
    return this.toString().equals(o.toString());
  }
  public int compareTo(QuadFunction q) {
    return getA() != q.getA()? getA() - q.getA() : getB() != q.getB()? getB() - q.getB() : getC() - q.getC();
  }
  public static void main(String[] args) {
    QuadFunction f = new QuadFunction(1,-5,6);
    System.out.println(f);
  }
}
