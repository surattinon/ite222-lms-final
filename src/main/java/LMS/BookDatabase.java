package LMS;

public class BookDatabase {
  // Declare 2D array to store in books field
  private BookDetail[] books;

  // Constructor to initialize BookDatabase with 2D array of books
  public BookDatabase(BookDetail[] books) {
    this.books = books;
  }

  // Setter method for books field
  public void setBooks(BookDetail[] books) {
    this.books = books;
  }

  // Getter method for books field
  public BookDetail[] getBooks() {
    return books;
  }
}
