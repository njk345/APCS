import java.util.Scanner;

public class CylinderTest
{
   public static void main (String[] args) {
       Scanner in = new Scanner(System.in);
       System.out.println("Enter Radius and Height of Cyclinder (space-separated) To Get Volume: ");
       int r = in.nextInt();
       double h = in.nextDouble();
       Cylinder c = new Cylinder(r, h);
       System.out.println(c.getVolume());
   }
}
