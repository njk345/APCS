//NICK KEIRSTEAD

public class Book {
  private int numPages;
  private int currPage;
  
  public Book (int numpages) {
    numPages = numpages;
    currPage = 1;
  }
  public int getNumPages () {
    return numPages;
  }
  public int getCurrPage () {
    return currPage;
  }
  public void nextPage () {
    if (currPage < numPages) currPage++;
  }
}
