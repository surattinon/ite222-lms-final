package LMS;

public class BookDatabase {
  // Fields
  // Declare books as a private field with datatype BookDetail array
  private BookDetail[] books;

  // Constructor for BookDatabase class
  public BookDatabase(BookDetail[] books) {
    this.books = books; // Set the books field with the books argument
  }

  // Getter method for books field
  public BookDetail[] getBookDB() {
    return books;
  }
}

// Subclass BookDetail
class BookDetail {
  // Fields
  private String bookID;
  private String bookTitle;
  private String bookAuthor;
  private String bookPublication;
  private String status;
  private boolean isAvailable;

  public BookDetail(String bookID, String title, String author, String publication) {
    this.bookTitle = title;
    this.bookAuthor = author;
    this.bookPublication = publication;
    this.bookID = bookID;
    this.isAvailable = true;
    this.status = "Available"; // Set status to "Available" by default
  }

  // Boolean method to check if the book is available
  public boolean isNotBorrow() {
    if (isAvailable) { // if the book is available
      isAvailable = false; // Set isAvailable to false
      status = "Not Available"; // Set status to "Not Available"
      return true; // Return true
    }
    return false; // If the book is not available, return false
  }

  public boolean isNotReturn() {
    if (!isAvailable) { // if the book is not available
      isAvailable = true; // Set isAvailable to true
      status = "Available"; // Set status to "Available"
      return true; // Return true
    }
    return false; // If the book is available, return false
  }

  // Getter method for bookID
  public String getBookBorrowID() {
    return bookID;
  }

  // Getter method for bookTitle
  public String getBookTitle() {
    return bookTitle;
  }

  // Getter method for print books details in table format with printf
  public void showBookTable() {
    System.out.printf(
        "| %-10s| %-20s| %-20s| %-20s| %-20s|\n",
        bookID, bookTitle, bookAuthor, bookPublication, status);
  }
}
