public class Cylinder
{
    private Circle base;
    private double height;
    
    public Cylinder(int r, double h)
    {
        this.base = new Circle(r);
        this.height = h;
    }
    public double getVolume() {
       return this.base.getArea() * this.height; 
    }
}
