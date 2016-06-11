//NICK KEIRSTEAD

public class BookTest {
  public static void main (String[] args) {
    Book b = new Book(3);
    for (int i = 0; i < 3; i++) {
      System.out.println(b.getCurrPage());
      b.nextPage();
    }
  }
}
