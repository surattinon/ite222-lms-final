package LMS;

public class BookDetail {
  private String bookID;
  private String bookTitle;
  private String bookAuthor;
  private String bookPublication;
  private boolean isAvailable;

  public BookDetail(String bookID, String title, String author, String publication) {
    this.bookTitle = title;
    this.bookAuthor = author;
    this.bookPublication = publication;
    this.bookID = bookID;
    this.isAvailable = true; // By default, the book is available
  }

  public boolean borrowBook() {
    if (isAvailable) {
      isAvailable = false;
      return true;
    }
    return false;
  }

  public void returnBook() {
    isAvailable = true;
  }

  public String getBookID() {
    return bookID;
  }

  public String getBookTitle() {
    return bookTitle;
  }

  public void getBookTable() {
    System.out.printf(
        "| %-10s| %-20s| %-20s| %-20s| %-10s|\n",
        bookID, bookTitle, bookAuthor, bookPublication, isAvailable);
  }
}
