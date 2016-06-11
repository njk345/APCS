//Nick Keirstead
import java.util.Scanner;
public class Person implements Comparable<Person> {
  private String firstName, lastName;
  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
  public String getFirstName() {
    return firstName;
  } 
  public String getLastName() {
    return lastName;
  }
  @Override
  public int compareTo(Person p) {
    String fullName1 = getLastName() + getFirstName();
    String fullName2 = p.getLastName() + p.getFirstName();
    return fullName1.compareTo(fullName2);
  }
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.print("Enter Full Name 1: ");
    String[] n1 = s.nextLine().split(" ");
    System.out.print("Enter Full Name 2: ");
    String[] n2 = s.nextLine().split(" ");
    
    Person p1 = new Person(n1[0], n1[1]);
    Person p2 = new Person(n2[0], n2[1]);

    int comparison = p1.compareTo(p2);
    String comesFirst = "";
    String second = "";
    if (comparison < 0) {
      comesFirst = p1.getFirstName() + " " + p1.getLastName();
      second = p2.getFirstName() + " " + p2.getLastName();
    } else {
      comesFirst = p2.getFirstName() + " " + p2.getLastName();
      second = p1.getFirstName() + " " + p1.getLastName();
    }

    System.out.println("Lexicographical Ordering: " + comesFirst + ", " + second);
  }
}
