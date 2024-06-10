package LMS;

/** BookDatabase */
public class BookDatabase {
  private BookDetail[][] books;

  public BookDatabase(BookDetail[][] books) {
    this.books = books;
  }

  public BookDetail[][] getBooks() {
    return books;
  }

  public void setBooks(BookDetail[][] books) {
    this.books = books;
  }
}
