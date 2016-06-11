public class Circle
{
    private double radius;
    
    public Circle(int r)
    {
        this.radius = r;
    }
    public double getRadius() {
        return this.radius;
    }
    public double getArea() {
        return Math.pow(this.getRadius(), 2) * Math.PI;
    }
}
