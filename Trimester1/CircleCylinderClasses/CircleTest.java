import java.util.Scanner;

public class CircleTest
{
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Radius of Circle To Get Area: ");
        int r = in.nextInt();
        Circle c = new Circle(r);
        System.out.println(c.getArea());
    }
}
